// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Vision.proto

package messages;

public final class _File_Vision {
  private _File_Vision() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_HoughLine_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_HoughLine_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_FieldLine_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_FieldLine_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_Corner_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_Corner_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_CenterCircle_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_CenterCircle_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_Vision_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_Vision_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_VBall_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_VBall_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_FilteredBall_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_FilteredBall_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_SharedBall_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_SharedBall_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_NaiveBall_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_NaiveBall_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messages_NaiveBall_Position_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messages_NaiveBall_Position_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Vision.proto\022\010messages\";\n\tHoughLine\022\t\n" +
      "\001r\030\001 \001(\002\022\t\n\001t\030\002 \001(\002\022\013\n\003ep0\030\003 \001(\002\022\013\n\003ep1\030" +
      "\004 \001(\002\"\241\001\n\tFieldLine\022\"\n\005inner\030\001 \001(\0132\023.mes" +
      "sages.HoughLine\022\"\n\005outer\030\002 \001(\0132\023.message" +
      "s.HoughLine\022\n\n\002id\030\003 \001(\005\022\026\n\016correspondenc" +
      "e\030\004 \001(\005\022\014\n\004prob\030\005 \001(\002\022\r\n\005index\030\006 \001(\005\022\013\n\003" +
      "wz0\030\007 \001(\002\"{\n\006Corner\022\t\n\001x\030\001 \001(\002\022\t\n\001y\030\002 \001(" +
      "\002\022\n\n\002id\030\003 \001(\005\022\026\n\016correspondence\030\004 \001(\005\022\014\n" +
      "\004prob\030\005 \001(\002\022\r\n\005line1\030\006 \001(\005\022\r\n\005line2\030\007 \001(" +
      "\005\022\013\n\003wz0\030\010 \001(\002\"K\n\014CenterCircle\022\n\n\002on\030\001 \001",
      "(\010\022\t\n\001x\030\002 \001(\002\022\t\n\001y\030\003 \001(\002\022\014\n\004prob\030\004 \001(\002\022\013" +
      "\n\003wz0\030\005 \001(\002\"\252\001\n\006Vision\022!\n\004line\030\001 \003(\0132\023.m" +
      "essages.FieldLine\022 \n\006corner\030\002 \003(\0132\020.mess" +
      "ages.Corner\022&\n\006circle\030\003 \001(\0132\026.messages.C" +
      "enterCircle\022\035\n\004ball\030\004 \001(\0132\017.messages.VBa" +
      "ll\022\024\n\014horizon_dist\030\005 \001(\005\"\273\002\n\005VBall\022\020\n\010di" +
      "stance\030\001 \001(\001\022\017\n\007bearing\030\002 \001(\001\022\023\n\013angle_x" +
      "_deg\030\003 \001(\001\022\023\n\013angle_y_deg\030\004 \001(\001\022\022\n\nbeari" +
      "ng_sd\030\005 \001(\001\022\022\n\nin_top_cam\030\006 \001(\010\022\016\n\006radiu" +
      "s\030\007 \001(\001\022\022\n\nconfidence\030\010 \001(\001\022\n\n\002on\030\t \001(\010\022",
      "\021\n\tframes_on\030\n \001(\021\022\022\n\nframes_off\030\013 \001(\021\022\026" +
      "\n\016rel_x_variance\030\014 \001(\001\022\026\n\016rel_y_variance" +
      "\030\r \001(\001\022\023\n\013bearing_deg\030\016 \001(\001\022\t\n\001x\030\017 \001(\021\022\t" +
      "\n\001y\030\020 \001(\021\022\013\n\003wz0\030\021 \001(\002\"\315\004\n\014FilteredBall\022" +
      "\034\n\003vis\030\001 \001(\0132\017.messages.VBall\022\020\n\010distanc" +
      "e\030\002 \001(\002\022\017\n\007bearing\030\003 \001(\002\022\r\n\005rel_x\030\004 \001(\002\022" +
      "\r\n\005rel_y\030\005 \001(\002\022\r\n\005vel_x\030\006 \001(\002\022\r\n\005vel_y\030\007" +
      " \001(\002\022\021\n\tvar_rel_x\030\010 \001(\002\022\021\n\tvar_rel_y\030\t \001" +
      "(\002\022\021\n\tvar_vel_x\030\n \001(\002\022\021\n\tvar_vel_y\030\013 \001(\002" +
      "\022\025\n\ris_stationary\030\014 \001(\010\022\023\n\013bearing_deg\030\r",
      " \001(\002\022\t\n\001x\030\016 \001(\002\022\t\n\001y\030\017 \001(\002\022\022\n\nrel_x_dest" +
      "\030\020 \001(\002\022\022\n\nrel_y_dest\030\021 \001(\002\022\r\n\005speed\030\022 \001(" +
      "\002\022\034\n\024rel_y_intersect_dest\030\023 \001(\002\022\022\n\nstat_" +
      "rel_x\030\024 \001(\002\022\022\n\nstat_rel_y\030\025 \001(\002\022\025\n\rstat_" +
      "distance\030\026 \001(\002\022\024\n\014stat_bearing\030\027 \001(\002\022\021\n\t" +
      "mov_rel_x\030\030 \001(\002\022\021\n\tmov_rel_y\030\031 \001(\002\022\024\n\014mo" +
      "v_distance\030\032 \001(\002\022\023\n\013mov_bearing\030\033 \001(\002\022\021\n" +
      "\tmov_vel_x\030\034 \001(\002\022\021\n\tmov_vel_y\030\035 \001(\002\022\021\n\tm" +
      "ov_speed\030\036 \001(\002\"H\n\nSharedBall\022\t\n\001x\030\001 \001(\002\022" +
      "\t\n\001y\030\002 \001(\002\022\017\n\007ball_on\030\003 \001(\010\022\023\n\013reliabili",
      "ty\030\004 \001(\005\"\250\003\n\tNaiveBall\022\020\n\010velocity\030\001 \001(\002" +
      "\022\022\n\nstationary\030\002 \001(\010\022\022\n\nyintercept\030\003 \001(\002" +
      "\022.\n\010position\030\004 \003(\0132\034.messages.NaiveBall." +
      "Position\0221\n\013dest_buffer\030\005 \003(\0132\034.messages" +
      ".NaiveBall.Position\022\r\n\005x_vel\030\006 \001(\002\022\r\n\005y_" +
      "vel\030\007 \001(\002\022\023\n\013start_avg_x\030\010 \001(\002\022\023\n\013start_" +
      "avg_y\030\t \001(\002\022\021\n\tend_avg_x\030\n \001(\002\022\021\n\tend_av" +
      "g_y\030\013 \001(\002\022\027\n\017avg_start_index\030\014 \001(\002\022\025\n\rav" +
      "g_end_index\030\r \001(\002\022\021\n\talt_x_vel\030\016 \001(\002\022\r\n\005" +
      "x_v_1\030\017 \001(\002\022\r\n\005x_v_2\030\020 \001(\002\022\r\n\005x_v_3\030\021 \001(",
      "\002\032 \n\010Position\022\t\n\001x\030\001 \001(\002\022\t\n\001y\030\002 \001(\002B\020B\014_" +
      "File_VisionP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_messages_HoughLine_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messages_HoughLine_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_HoughLine_descriptor,
        new java.lang.String[] { "R", "T", "Ep0", "Ep1", });
    internal_static_messages_FieldLine_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_messages_FieldLine_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_FieldLine_descriptor,
        new java.lang.String[] { "Inner", "Outer", "Id", "Correspondence", "Prob", "Index", "Wz0", });
    internal_static_messages_Corner_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_messages_Corner_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_Corner_descriptor,
        new java.lang.String[] { "X", "Y", "Id", "Correspondence", "Prob", "Line1", "Line2", "Wz0", });
    internal_static_messages_CenterCircle_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_messages_CenterCircle_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_CenterCircle_descriptor,
        new java.lang.String[] { "On", "X", "Y", "Prob", "Wz0", });
    internal_static_messages_Vision_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_messages_Vision_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_Vision_descriptor,
        new java.lang.String[] { "Line", "Corner", "Circle", "Ball", "HorizonDist", });
    internal_static_messages_VBall_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_messages_VBall_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_VBall_descriptor,
        new java.lang.String[] { "Distance", "Bearing", "AngleXDeg", "AngleYDeg", "BearingSd", "InTopCam", "Radius", "Confidence", "On", "FramesOn", "FramesOff", "RelXVariance", "RelYVariance", "BearingDeg", "X", "Y", "Wz0", });
    internal_static_messages_FilteredBall_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_messages_FilteredBall_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_FilteredBall_descriptor,
        new java.lang.String[] { "Vis", "Distance", "Bearing", "RelX", "RelY", "VelX", "VelY", "VarRelX", "VarRelY", "VarVelX", "VarVelY", "IsStationary", "BearingDeg", "X", "Y", "RelXDest", "RelYDest", "Speed", "RelYIntersectDest", "StatRelX", "StatRelY", "StatDistance", "StatBearing", "MovRelX", "MovRelY", "MovDistance", "MovBearing", "MovVelX", "MovVelY", "MovSpeed", });
    internal_static_messages_SharedBall_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_messages_SharedBall_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_SharedBall_descriptor,
        new java.lang.String[] { "X", "Y", "BallOn", "Reliability", });
    internal_static_messages_NaiveBall_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_messages_NaiveBall_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_NaiveBall_descriptor,
        new java.lang.String[] { "Velocity", "Stationary", "Yintercept", "Position", "DestBuffer", "XVel", "YVel", "StartAvgX", "StartAvgY", "EndAvgX", "EndAvgY", "AvgStartIndex", "AvgEndIndex", "AltXVel", "XV1", "XV2", "XV3", });
    internal_static_messages_NaiveBall_Position_descriptor =
      internal_static_messages_NaiveBall_descriptor.getNestedTypes().get(0);
    internal_static_messages_NaiveBall_Position_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messages_NaiveBall_Position_descriptor,
        new java.lang.String[] { "X", "Y", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
