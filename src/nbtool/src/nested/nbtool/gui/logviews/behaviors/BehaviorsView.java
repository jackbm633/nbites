package nbtool.gui.logviews.images;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.FontMetrics;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.protobuf.Message;
import messages.*;

import nbtool.data.log.Block;
import nbtool.data.log.Log;
import nbtool.gui.logviews.misc.ViewParent;
import nbtool.io.CommonIO.IOInstance;
import nbtool.util.Debug;
import nbtool.util.SharedConstants;

public class BehaviorsView extends ViewParent {
	
	// private static final Debug.DebugSettings debug = Debug.createSettings(true, true, true, null, null);
	Behaviors be;

	@Override
	public void setupDisplay() {
		// Silence is golden
	}

	@Override
	public String[] displayableTypes() {
		return new String[]{"behaviors"};
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try{
			be = Behaviors.parseFrom(displayedLog.blocks.get(0).data);
		} catch(Exception e) {
			e.printStackTrace();
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        	RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		Font f = g.getFont();
		Font body = g.getFont().deriveFont((float)f.getSize() * 1.5f);
		Font info = body.deriveFont((float)body.getSize() * 0.61f);

		FontMetrics fm;

		int pageWidth = 800;

		// http://clrs.cc
		Color red = new Color(255, 65, 54);
		Color blue = new Color(0, 116, 217);
		Color navy = new Color(0, 31, 63);
		Color green = new Color(46, 204, 64);
		Color black = new Color(17, 17, 17);
		Color yellow = new Color(255, 220, 0);
		Color orange = new Color(255, 133, 27);
		Color purple = new Color(177, 13, 201);
		Color gray = new Color(96, 96, 96);

		// Row 1
		g.setFont(body);
		g.setColor(navy);
		g.drawString("BehaviorsView 0.1", 20, 20);
		g.setFont(info);
		g.setColor(black);
		g.drawString("Last updated by James Little on June 8, 2016", 20, 35);
		g.drawLine(20, 40, pageWidth, 40);
		g.setFont(body);
		
		g.drawLine(350, 5, 350, 35);

		g.drawString(be.getRobotName(), 375, 20);
		g.drawString(be.getTeam() + "", 500, 20);
		g.drawString(be.getPlayer() + "", 600, 20);
		g.drawString(be.getRole() + "", 700, 20);
		g.setFont(info);
		g.drawString("Name", 375, 35);
		g.drawString("Team", 500, 35);
		g.drawString("Player", 600, 35);
		g.drawString("Role", 700, 35);

		// Row 2 -- Game Controller States
		fm = g.getFontMetrics();
		g.setFont(body);
		g.setColor(gray);

		String[] gcStateStrs = {
			"Initial", "Ready", "Set", "Playing", "Penalty", "Finished"};

		Behaviors.GameControllerState[] gcStates = {
			Behaviors.GameControllerState.GAMEINITIAL,
			Behaviors.GameControllerState.GAMEREADY,
			Behaviors.GameControllerState.GAMESET,
			Behaviors.GameControllerState.GAMEPLAYING,
			Behaviors.GameControllerState.GAMEPENALTY,
			Behaviors.GameControllerState.GAMEFINISHED,
		};

		Color[] gcStrColors = {blue, blue, orange, green, red, blue};

		int gcStateWidth = pageWidth / gcStateStrs.length;

		for (int i=0; i<gcStateStrs.length; i++) {
			if(be.getGCState() == gcStates[i]) {
				g.setColor(gcStrColors[i]);
			}

			g.drawString(gcStateStrs[i], gcStateWidth*i+20, 70);
			g.setColor(gray);
		}

		g.setFont(info);
		g.setColor(black);
		g.drawString("Game Controller State", 20, 85);
		g.drawLine(20, 90, pageWidth, 90);

		g.drawString(be.getKickHLStrategy(), 150, 150);

	}

	public BehaviorsView() {
		super();
		setLayout(null);
	}

	// @Override
	// public void ioFinished(IOInstance instance) {}

	// @Override
	// public void ioReceived(IOInstance inst, int ret, Log... out) {
		// assert(out[0] == latestVisionLog);
		
		// this.calibrationSuccess = this.latestVisionLog.
		// 		topLevelDictionary.get("CalibrationSuccess").asBoolean().bool();
    	
  //   	Block edgeBlock, lineBlock;
  //   	edgeBlock = this.getEdgeBlock();
  //   	if (edgeBlock != null) {
  //   		debug.info("found edgeBlock");
  //   		EdgeImage ei = new EdgeImage(width, height,  edgeBlock.data);
  //           edgeImage = ei.toBufferedImage();
  //   	}

  //       // TODO refactor. Protobuf?
  //       lines = new Vector<Double>();
        
  //       lineBlock = this.getLineBlock();
  //       if (lineBlock != null) {
  //   		debug.info("found lineBlock");

  //       	byte[] lineBytes = lineBlock.data;
  //           int numLines = lineBytes.length / (9 * 8);
  //           Debug.info("%d field lines expected.", numLines);
  //           try {
  //               DataInputStream dis = new DataInputStream(new ByteArrayInputStream(lineBytes));
  //               for (int i = 0; i < numLines; ++i) {
  //                   lines.add(dis.readDouble()); // image coord r
  //                   lines.add(dis.readDouble()); // image coord t
  //                   lines.add(dis.readDouble()); // image coord ep0
  //                   lines.add(dis.readDouble()); // image coord ep1
  //                   lines.add((double)dis.readInt()); // hough index
  //                   lines.add((double)dis.readInt()); // fieldline index
  //                   lines.add(dis.readDouble()); // field coord r
  //                   lines.add(dis.readDouble()); // field coord t
  //                   lines.add(dis.readDouble()); // field coord ep0
  //                   lines.add(dis.readDouble()); // field coord ep1
  //               }
  //           } catch (Exception e) {
  //               Debug.error("Conversion from bytes to hough coord lines in LineView failed.");
  //               e.printStackTrace();
  //           }
  //       }
                
 //        repaint();
	// }

}
