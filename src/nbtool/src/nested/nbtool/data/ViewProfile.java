package nbtool.data;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import nbtool.data.json.Json;
import nbtool.data.json.JsonArray;
import nbtool.data.json.JsonObject;
import nbtool.data.log.Log;
import nbtool.gui.logviews.misc.ViewParent;
import nbtool.util.ClassFinder;
import nbtool.util.Debug;
import nbtool.util.ToolSettings;

public class ViewProfile {
	public static final String PROFILES_KEY = "__PROFILES__";
	public static final String DEFAULT_PROFILE_NAME = "DEFAULT";
	public static ViewProfile DEFAULT_PROFILE = null;
	public static final Map<String, ViewProfile> PROFILES = new HashMap<>();
	
	
	/*static*/
	public static ViewProfile makeDefault() {
		ViewProfile def = new ViewProfile(DEFAULT_PROFILE_NAME);
		
		for (int j = 0; j < TYPES.length; ++j) {
			Class<? extends ViewParent>[] possible =
					POSSIBLE_VIEWS.get(TYPES[j]);
			
			//Select all.
			def.states[j] = resolve(possible, null);
		}
		
		return def;
	}
	
	public static ViewProfile addWithName(String name) {
		assert(name != null && !name.isEmpty());
		
		if (name.equalsIgnoreCase(DEFAULT_PROFILE_NAME)) {
			Debug.error("cannot overwrite default profile with {%s}", name);
			return null;
		}
		
		ViewProfile nvp = new ViewProfile(name);
		
		for (int j = 0; j < TYPES.length; ++j) {
			Class<? extends ViewParent>[] possible =
					POSSIBLE_VIEWS.get(TYPES[j]);
			
			//Select all.
			nvp.states[j] = resolve(possible, null);
		}
		
		PROFILES.put(name, nvp);
		return nvp;
	}
	
	/*instance*/
	public String name;
	public ViewProfile(String n) {
		assert(n != null && !n.isEmpty());

		this.name = n;
		this.states = new ViewState[TYPES.length][];
	}
	
	public ViewState[][] states = null;
	
	@SuppressWarnings("unchecked")
	public Class<? extends ViewParent>[] selected(String type) {
		int tindex = Arrays.asList(TYPES).indexOf(type);
		
		ArrayList<Class<? extends ViewParent>> sel = new ArrayList<Class<? extends ViewParent>>();
		for (ViewState vs : states[tindex]) {
			if (vs.showing)
				sel.add(vs.viewClass);
		}
		
		return sel.toArray(new Class[sel.size()]);
	}
	
	@SuppressWarnings("unchecked")
	public Class<? extends ViewParent>[] viewsForLog(Log log) {
		ArrayList<Class<? extends ViewParent>> views = new ArrayList<Class<? extends ViewParent>>();
		String ptype = log.logClass;
		assert(ptype != null);

		int tindex = Arrays.asList(TYPES).indexOf(ptype);
		if (tindex >= 0) {
			for (ViewState vs : states[tindex]) {
				if (vs.showing)
					views.add(vs.viewClass);
			}
		}

		if (ptype.startsWith("proto-")) {
			views.addAll(Arrays.asList(this.selected(ToolSettings.PROTOBUF_S)));
		}
		
		views.addAll(Arrays.asList(this.selected(ToolSettings.DEFAULT_S)));
		
		Debug.info("LogToViewUtility found %d views for log of type %s.", views.size(), ptype);
		
		return views.toArray(new Class[views.size()]);		
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/*
	 * Helper classes and static methods.
	 */
	public static class ViewState {
		public boolean showing;
		public Class<? extends ViewParent> viewClass;
		
		ViewState(boolean s, Class<? extends ViewParent> cls) {
			showing = s;
			viewClass = cls;
		}
		
		public String toString() {
			return viewClass.getName();
		}
	}
	
	public static void setupProfiles(SExpr profiles) {
		assert( profiles.isList() &&
				profiles.get(0).isAtom() &&
				profiles.get(0).value().equals(PROFILES_KEY));
		
		for (int pi = 1; pi < profiles.count(); ++pi) {
			SExpr profile = profiles.get(pi);
			String name = profile.get(0).value();
			ViewProfile vp = new ViewProfile(name);
			
			for (int j = 0; j < TYPES.length; ++j) {
				Class<? extends ViewParent>[] possible =
						POSSIBLE_VIEWS.get(TYPES[j]);
				
				SExpr lshownSP = profile.find(TYPES[j]);
				if (lshownSP.exists()) {
					Class<? extends ViewParent>[] lshown = classValuesFrom(lshownSP);
					vp.states[j] = resolve(possible, lshown);
				} else {
					vp.states[j] = resolve(possible, null);
				}
			}
			
			PROFILES.put(name, vp);
		}
		
		if (!PROFILES.containsKey(DEFAULT_PROFILE_NAME)) {
			PROFILES.put(DEFAULT_PROFILE_NAME, ViewProfile.makeDefault());
		}
		
		DEFAULT_PROFILE = PROFILES.get(DEFAULT_PROFILE_NAME);
	}
	
	
	@SuppressWarnings("unchecked")
	public static Class<? extends ViewParent>[] classValuesFrom(SExpr s) {
		ArrayList<Class<? extends ViewParent>> classes = 
				new ArrayList<>();
		
		//Start after atom
		for (int i = 1; i < s.count(); ++i) {
			Class<? extends ViewParent> c = null;
			try {
				c = (Class<? extends ViewParent>) Class.forName(s.get(i).value());
			} catch (Exception e) {
				Debug.error( "_____ PREVIOUSLY LOADED CLASS COULD NOT BE FOUND! _____");
				e.printStackTrace();
			}
			
			if (c != null) {
				classes.add(c);
			}
		}
		
		return classes.toArray(new Class[0]);
	}
	
	private static ViewState[] resolve(Class<? extends ViewParent>[] possible,
			Class<? extends ViewParent>[] lastShown) {
		ViewState[] ret = new ViewState[possible.length];
		HashSet<Class<? extends ViewParent>> pset =
				new HashSet<Class<? extends ViewParent>>(Arrays.asList(possible));
		
		int i = 0;
		if (lastShown != null) {
			/* create true VS for every class in lastShown */
			for (Class<? extends ViewParent> cls : lastShown) {
				if (pset.contains(cls)) {
					ret[i++] = new ViewState(true, cls);
					pset.remove(cls);
				}
			}
			
			/* add false VS for every class left in pset */
			for (Class<? extends ViewParent> cls : pset) {
				ret[i++] = new ViewState(false, cls);
			}
		} else {
			/* no last shown for this type, add true VS for all */
			for (Class<? extends ViewParent> cls : pset) {
				ret[i++] = new ViewState(true, cls);
			}
		}
		
		assert(i == possible.length);
		return ret;
	}
	
	public static SExpr makeProfilesSExpr() {
		SExpr top = SExpr.list(SExpr.atom(PROFILES_KEY));
		
		for (Entry<String, ViewProfile> entry : PROFILES.entrySet()) {
			assert(entry.getKey().equals(entry.getValue().name));
			
			ViewProfile vp = entry.getValue();
			SExpr profile = SExpr.list( SExpr.atom(vp.name) );
			
			for (String type : TYPES) {
				Class<? extends ViewParent>[] sel = vp.selected(type);
				SExpr selse = SExpr.list(SExpr.atom(type));
				for (Class<? extends ViewParent> cls : sel) {
					selse.append(SExpr.atom(cls.getName()));
				}
				
				profile.append(selse);
			}
			
			top.append(profile);
		}
		
		return top;
	}
	
	public static final Map<String, Class<? extends ViewParent>[]> POSSIBLE_VIEWS = 
			new HashMap<String, Class<? extends ViewParent>[]>();
			
			public static String[] TYPES;
	
	@SuppressWarnings("unchecked")
	public static void findAllViews() {
		Debug.warn("ViewProfile finding all subclasses of ViewParent");
		List<Class<?>> found = ClassFinder.findAllSubclasses(ViewParent.class);
		Map<String, List<Class<?>>> pv_map = 
				new HashMap<>();
				
		for (Class<?> cls : found) {
			ViewParent inst;
			String[] types = null;
			try {
				inst = (ViewParent) cls.getDeclaredConstructor().newInstance();
				types = inst.displayableTypes();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				
				Debug.error("*************************\n" +
							"\tfatal error checking no-args constructor of ViewParent subclass:\n" +
							"\t%s error: %s", cls.getName(), e.getMessage()
						);
				System.exit(-1);
				
			}
			
			for (String t : types) {
				if (pv_map.containsKey(t)) {
					pv_map.get(t).add(cls);
				} else {
					LinkedList<Class<?>> newList = new LinkedList<>();
					newList.add(cls);
					pv_map.put(t, newList);
				}
			}
		}
		
		for (String type : pv_map.keySet()) {
			POSSIBLE_VIEWS.put(type, pv_map.get(type).toArray(new Class[0]));
		}
		
		TYPES = POSSIBLE_VIEWS.keySet().toArray(new String[0]);
		Debug.info("%s", POSSIBLE_VIEWS.toString());
	}
}





