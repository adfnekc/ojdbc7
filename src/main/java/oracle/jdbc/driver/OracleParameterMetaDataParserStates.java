package oracle.jdbc.driver;

class OracleParameterMetaDataParserStates {
   private static final int BASE = 0;
   private static final int PARAMETER = 1;
   private static final int TOKEN = 2;
   private static final int I_NSERT = 3;
   private static final int IN_SERT = 4;
   private static final int INS_ERT = 5;
   private static final int INSE_RT = 6;
   private static final int INSER_T = 7;
   private static final int INSERT_ = 8;
   private static final int U_PDATE = 9;
   private static final int UP_DATE = 10;
   private static final int UPD_ATE = 11;
   private static final int UPDA_TE = 12;
   private static final int UPDAT_E = 13;
   private static final int UPDATE_ = 14;
   private static final int KNOW_KIND = 15;
   private static final int K_STRING = 16;
   private static final int K_NAME = 17;
   public static final int K_C_COMMENT = 18;
   private static final int K_C_COMMENT_1 = 19;
   public static final int K_COMMENT = 20;
   private static final int K_PARAMETER = 21;
   private static final int TOKEN_KK = 22;
   private static final int FROM_t_W_HERE = 23;
   private static final int FROM_t_WH_ERE = 24;
   private static final int FROM_t_WHE_RE = 25;
   private static final int FROM_t_WHER_E = 26;
   private static final int FROM_t_WHERE_ = 27;
   private static final int INSERT_xINTO = 28;
   private static final int I_NTO_t_c_ = 29;
   private static final int IN_TO_t_c_ = 30;
   private static final int INT_O_t_c_ = 31;
   private static final int INTO__t_c_ = 32;
   private static final int INTO_xt_c_ = 33;
   private static final int INTO_T_c_ = 34;
   private static final int INTO_t_xc_ = 35;
   private static final int INTO_t_C_ = 36;
   private static final int INTO_t_c__ = 37;
   private static final int INTO_t_c_xBIND_ = 38;
   private static final int INTO_t_c_BIND_ = 39;
   private static final int INTO_t_c_BIND_K_PARAMETER_ = 40;
   private static final int INTO_t_c_BIND_K_STRING = 41;
   private static final int INTO_t_c_BIND_K_N_tick = 42;
   private static final int INTO_t_c_BIND_K_NCHAR = 43;
   private static final int INTO_t_c_BIND_K_NCHAR_tick = 44;
   private static final int INTO_t_c_BIND_K_Q_tick = 45;
   private static final int INTO_t_c_BIND_K_QTick_ = 46;
   private static final int INTO_t_c_BIND_K_QTick_char = 47;
   private static final int INTO_t_c_BIND_K_QTick_char_tick = 48;
   private static final int UPDATE_xt_SET_c_ = 49;
   private static final int UPDATE_T_SET_c_ = 50;
   private static final int UPDATE_t_xSET_c_ = 51;
   private static final int UPDATE_t_S_ET_c_ = 52;
   private static final int UPDATE_t_SE_T_c_ = 53;
   private static final int F_ROM_t_WHERE = 54;
   private static final int FR_OM_t_WHERE = 55;
   private static final int FRO_M_t_WHERE = 56;
   private static final int FROM__t_WHERE = 57;
   private static final int FROM_xt_WHERE = 58;
   private static final int FROM_T_WHERE = 59;
   private static final int FROM_t_COMMA_WHERE = 60;
   private static final int FROM_t_xWHERE = 61;
   private static final int XXX_W_HERE_c_op_bind_ = 62;
   private static final int XXX_WH_ERE_c_op_bind_ = 63;
   private static final int XXX_WHE_RE_c_op_bind_ = 64;
   private static final int XXX_WHER_E_c_op_bind_ = 65;
   private static final int XXX_WHERE__c_op_bind_ = 66;
   private static final int XXX__c_op_bind_ = 67;
   public static final int XXX_xc_op_bind_ = 68;
   private static final int XXX_C_op_bind_ = 69;
   private static final int XXX_c__op_bind_ = 70;
   private static final int XXX_c_I_S_NOT_NULL_ = 71;
   private static final int XXX_c_IS__NOT_NULL_ = 72;
   private static final int XXX_c_IS_xNOT_NULL_ = 73;
   private static final int XXX_c_IS_N_OT_NULL_ = 74;
   private static final int XXX_c_IS_NO_T_NULL_ = 75;
   private static final int XXX_c_IS_NOT__NULL_ = 76;
   private static final int XXX_c_IS_NOT_xNULL_ = 77;
   private static final int XXX_c_IS_NOT_N_ULL_ = 78;
   private static final int XXX_c_IS_NOT_NU_LL_ = 79;
   private static final int XXX_c_IS_NOT_NUL_L_ = 80;
   private static final int XXX_c_IS_NOT_NULL__ = 81;
   private static final int XXX_c_xop_bind_ = 82;
   private static final int XXX_c_OP_bind_ = 83;
   private static final int XXX_c_OP2_bind_ = 84;
   private static final int XXX_c_op__bind_ = 85;
   private static final int XXX_c_op_BIND_ = 86;
   private static final int XXX__c_op_xbind_O_R_ = 87;
   private static final int XXX__c_op_xbind_OR__ = 88;
   private static final int XXX__c_op_xbind_A_ND_ = 89;
   private static final int XXX__c_op_xbind_AN_D_ = 90;
   private static final int XXX__c_op_xbind_AND__ = 91;
   private static final int XXX_c_op_K_STRING = 92;
   private static final int XXX_c_op_K_N_tick = 93;
   private static final int XXX_c_op_K_NCHAR = 94;
   private static final int XXX_c_op_K_NCHAR_tick = 95;
   private static final int SKIP_PARAMETER_WHITESPACE = 96;
   private static final int LAST_STATE = 97;
   public static final String[] PARSER_STATE_NAME = new String[]{"BASE", "PARAMETER", "TOKEN", "I_NSERT", "IN_SERT", "INS_ERT", "INSE_RT", "INSER_T", "INSERT_", "U_PDATE", "UP_DATE", "UPD_ATE", "UPDA_TE", "UPDAT_E", "UPDATE_", "KNOW_KIND", "K_STRING", "K_NAME", "K_C_COMMENT", "K_C_COMMENT_1", "K_COMMENT", "K_PARAMETER", "TOKEN_KK", "FROM_t_W_HERE", "FROM_t_WH_ERE", "FROM_t_WHE_RE", "FROM_t_WHER_E", "FROM_t_WHERE_", "INSERT_xINTO", "I_NTO_t_c_", "IN_TO_t_c_", "INT_O_t_c_", "INTO__t_c_", "INTO_xt_c_", "INTO_T_c_", "INTO_t_xc_", "INTO_t_C_", "INTO_t_c__", "INTO_t_c_xBIND_", "INTO_t_c_BIND_", "INTO_t_c_BIND_K_PARAMETER_", "INTO_t_c_BIND_K_STRING", "INTO_t_c_BIND_K_N_tick", "INTO_t_c_BIND_K_NCHAR", "INTO_t_c_BIND_K_NCHAR_tick", "INTO_t_c_BIND_K_Q_tick", "INTO_t_c_BIND_K_QTick_", "INTO_t_c_BIND_K_QTick_char", "INTO_t_c_BIND_K_QTick_char_tick", "UPDATE_xt_SET_c_", "UPDATE_T_SET_c_", "UPDATE_t_xSET_c_", "UPDATE_t_S_ET_c_", "UPDATE_t_SE_T_c_", "F_ROM_t_WHERE", "FR_OM_t_WHERE", "FRO_M_t_WHERE", "FROM__t_WHERE", "FROM_xt_WHERE", "FROM_T_WHERE", "FROM_t_COMMA_WHERE", "FROM_t_xWHERE", "XXX_W_HERE_c_op_bind_", "XXX_WH_ERE_c_op_bind_", "XXX_WHE_RE_c_op_bind_", "XXX_WHER_E_c_op_bind_", "XXX_WHERE__c_op_bind_", "XXX__c_op_bind_", "XXX_xc_op_bind_", "XXX_C_op_bind_", "XXX_c__op_bind_", "XXX_c_I_S_NOT_NULL_", "XXX_c_IS__NOT_NULL_", "XXX_c_IS_xNOT_NULL_", "XXX_c_IS_N_OT_NULL_", "XXX_c_IS_NO_T_NULL_", "XXX_c_IS_NOT__NULL_", "XXX_c_IS_NOT_xNULL_", "XXX_c_IS_NOT_N_ULL_", "XXX_c_IS_NOT_NU_LL_", "XXX_c_IS_NOT_NUL_L_", "XXX_c_IS_NOT_NULL__", "XXX_c_xop_bind_", "XXX_c_OP_bind_", "XXX_c_OP2_bind_", "XXX_c_op__bind_", "XXX_c_op_BIND_", "XXX__c_op_xbind_O_R_", "XXX__c_op_xbind_OR__", "XXX__c_op_xbind_A_ND_", "XXX__c_op_xbind_AN_D_", "XXX__c_op_xbind_AND__", "XXX_c_op_K_STRING", "XXX_c_op_K_N_tick", "XXX_c_op_K_NCHAR", "XXX_c_op_K_NCHAR_tick", "SKIP_PARAMETER_WHITESPACE"};
   static final int[][] TRANSITION = new int[97][];
   static final int NO_ACTION = 0;
   static final int OTHER_ACTION = 1;
   static final int WHERE_ACTION = 2;
   static final int PARAMETER_ACTION = 3;
   static final int END_PARAMETER_ACTION = 4;
   static final int COUNT_BIND_ACTION = 5;
   static final int START_NCHAR_LITERAL_ACTION = 6;
   static final int END_NCHAR_LITERAL_ACTION = 7;
   static final int SAVE_DELIMITER_ACTION = 8;
   static final int LOOK_FOR_DELIMITER_ACTION = 9;
   static final int RECORD_TABLE_NAME_ACTION = 10;
   static final int END_RECORD_TABLE_NAME_ACTION = 11;
   static final int DONE_RECORD_TABLE_NAME_ACTION = 12;
   static final int START_RECORD_COLUMN_NAME_ACTION = 13;
   static final int RECORD_COLUMN_NAME_ACTION = 14;
   static final int END_RECORD_COLUMN_NAME_ACTION = 15;
   static final int DONE_RECORD_COLUMN_NAME_ACTION = 16;
   static final int NO_PARAMETER_METADATA_ACTION = 17;
   static final int BEGIN_COMMENT_ACTION = 18;
   static final int END_COMMENT_ACTION = 19;
   static final int RESET_RECORDING_ACTION = 20;
   public static final String[] CBI_ACTION_NAME = new String[]{"NO_ACTION", "OTHER_ACTION", "WHERE_ACTION", "PARAMETER_ACTION", "END_PARAMETER_ACTION", "COUNT_BIND_ACTION", "START_NCHAR_LITERAL_ACTION", "END_NCHAR_LITERAL_ACTION", "SAVE_DELIMITER_ACTION", "LOOK_FOR_DELIMITER_ACTION", "RECORD_TABLE_NAME_ACTION", "END_RECORD_TABLE_NAME_ACTION", "DONE_RECORD_TABLE_NAME_ACTION", "START_RECORD_COLUMN_NAME_ACTION", "RECORD_COLUMN_NAME_ACTION", "END_RECORD_COLUMN_NAME_ACTION", "DONE_RECORD_COLUMN_NAME_ACTION", "NO_PARAMETER_METADATA_ACTION", "BEGIN_COMMENT_ACTION", "END_COMMENT_ACTION", "RESET_RECORDING_ACTION"};
   static final int[][] ACTION = new int[97][];
   static final int INITIAL_STATE = 0;
   static final int RESTART_STATE = 22;
   static final int cMax = 127;
   private static final int cMaxLength = 128;

   private static final int[] copy(int[] var0) {
      int[] var1 = new int[var0.length];
      System.arraycopy(var0, 0, var1, 0, var0.length);
      return var1;
   }

   private static final int[] newArray(int var0, int var1) {
      int[] var2 = new int[var0];

      for(int var3 = 0; var3 < var0; ++var3) {
         var2[var3] = var1;
      }

      return var2;
   }

   private static final int[] copyReplacing(int[] var0, int var1, int var2) {
      int[] var3 = new int[var0.length];

      for(int var4 = 0; var4 < var3.length; ++var4) {
         int var5 = var0[var4];
         if (var5 == var1) {
            var3[var4] = var2;
         } else {
            var3[var4] = var5;
         }
      }

      return var3;
   }

   private static final int[] copyReplacing(int[] var0, int var1, int var2, int var3, int var4) {
      int[] var5 = new int[var0.length];

      for(int var6 = 0; var6 < var5.length; ++var6) {
         int var7 = var0[var6];
         if (var7 == var1) {
            var5[var6] = var2;
         } else if (var7 == var3) {
            var5[var6] = var4;
         } else {
            var5[var6] = var7;
         }
      }

      return var5;
   }

   static {
      try {
         int[] var0 = new int[]{15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 2, 2, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 15, 15, 15, 15, 15, 15, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 15, 15, 15, 15, 2, 15, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 15, 15, 15, 15, 15};
         int[] var1 = copy(var0);
         var1[45] = 20;
         var1[47] = 18;
         var1[58] = 1;
         int[] var2 = copyReplacing(var1, 15, 0);
         var2[73] = 3;
         var2[105] = 3;
         var2[85] = 9;
         var2[117] = 9;
         int[] var3 = copyReplacing(var1, 2, 22);
         var3[34] = 17;
         var3[39] = 16;
         var3[45] = 20;
         var3[47] = 18;
         var3[58] = 96;
         var3[32] = 15;
         var3[32] = 15;
         var3[9] = 15;
         var3[10] = 15;
         var3[13] = 15;
         var3[61] = 15;
         int[] var4 = copyReplacing(var3, 2, 22);
         var4[70] = 54;
         var4[102] = 54;
         TRANSITION[0] = var2;
         TRANSITION[1] = copyReplacing(var1, 2, 1);
         TRANSITION[2] = var1;
         TRANSITION[3] = copy(var1);
         TRANSITION[3][78] = 4;
         TRANSITION[3][110] = 4;
         TRANSITION[4] = copy(var1);
         TRANSITION[4][83] = 5;
         TRANSITION[4][115] = 5;
         TRANSITION[5] = copy(var1);
         TRANSITION[5][69] = 6;
         TRANSITION[5][101] = 6;
         TRANSITION[6] = copy(var1);
         TRANSITION[6][82] = 7;
         TRANSITION[6][114] = 7;
         TRANSITION[7] = copy(var1);
         TRANSITION[7][84] = 8;
         TRANSITION[7][116] = 8;
         TRANSITION[8] = copyReplacing(var3, 15, 28);
         TRANSITION[9] = copy(var1);
         TRANSITION[9][80] = 10;
         TRANSITION[9][112] = 10;
         TRANSITION[10] = copy(var1);
         TRANSITION[10][68] = 11;
         TRANSITION[10][100] = 11;
         TRANSITION[11] = copy(var1);
         TRANSITION[11][65] = 12;
         TRANSITION[11][97] = 12;
         TRANSITION[12] = copy(var1);
         TRANSITION[12][84] = 13;
         TRANSITION[12][116] = 13;
         TRANSITION[13] = copy(var1);
         TRANSITION[13][69] = 14;
         TRANSITION[13][101] = 14;
         TRANSITION[14] = copyReplacing(var4, 15, 49, 22, 50);
         TRANSITION[14][47] = 18;
         TRANSITION[14][45] = 20;
         TRANSITION[22] = var3;
         TRANSITION[18] = newArray(128, 18);
         TRANSITION[18][42] = 19;
         TRANSITION[19] = newArray(128, 18);
         TRANSITION[19][42] = 19;
         TRANSITION[19][47] = 15;
         TRANSITION[20] = newArray(128, 20);
         TRANSITION[20][10] = 15;
         TRANSITION[17] = newArray(128, 17);
         TRANSITION[17][34] = 15;
         TRANSITION[16] = newArray(128, 16);
         TRANSITION[16][39] = 15;
         TRANSITION[21] = copyReplacing(var3, 22, 21, 15, 68);
         TRANSITION[21][47] = 18;
         TRANSITION[21][45] = 20;
         TRANSITION[96] = copyReplacing(var3, 22, 21);
         TRANSITION[96][32] = 96;
         TRANSITION[96][10] = 96;
         TRANSITION[96][13] = 96;
         TRANSITION[96][9] = 96;
         TRANSITION[28] = copyReplacing(var3, 15, 28);
         TRANSITION[28][73] = 29;
         TRANSITION[28][105] = 29;
         TRANSITION[28][47] = 18;
         TRANSITION[28][45] = 20;
         TRANSITION[29] = copy(var3);
         TRANSITION[29][78] = 30;
         TRANSITION[29][110] = 30;
         TRANSITION[30] = copy(var3);
         TRANSITION[30][84] = 31;
         TRANSITION[30][116] = 31;
         TRANSITION[31] = copy(var3);
         TRANSITION[31][79] = 32;
         TRANSITION[31][111] = 32;
         TRANSITION[32] = copyReplacing(var4, 15, 33);
         TRANSITION[32][47] = 18;
         TRANSITION[32][45] = 20;
         TRANSITION[32][40] = 15;
         TRANSITION[33] = copyReplacing(var3, 22, 34, 15, 33);
         TRANSITION[33][40] = 15;
         TRANSITION[33][47] = 18;
         TRANSITION[33][45] = 20;
         TRANSITION[34] = copyReplacing(var3, 22, 34, 15, 38);
         TRANSITION[34][47] = 18;
         TRANSITION[34][45] = 20;
         TRANSITION[34][40] = 36;
         TRANSITION[34][32] = 35;
         TRANSITION[34][10] = 35;
         TRANSITION[34][9] = 35;
         TRANSITION[34][13] = 35;
         TRANSITION[35] = newArray(128, 38);
         TRANSITION[35][40] = 36;
         TRANSITION[35][47] = 18;
         TRANSITION[35][45] = 20;
         TRANSITION[36] = newArray(128, 36);
         TRANSITION[36][44] = 36;
         TRANSITION[36][41] = 37;
         TRANSITION[37] = copyReplacing(var3, 22, 38, 15, 39);
         TRANSITION[38] = copyReplacing(var3, 22, 38, 15, 39);
         TRANSITION[38][40] = 39;
         TRANSITION[39] = newArray(128, 39);
         TRANSITION[39][58] = 40;
         TRANSITION[39][78] = 42;
         TRANSITION[39][110] = 42;
         TRANSITION[39][81] = 45;
         TRANSITION[39][113] = 45;
         TRANSITION[39][39] = 41;
         TRANSITION[40] = copyReplacing(var3, 22, 40, 15, 39);
         TRANSITION[40][44] = 39;
         TRANSITION[41] = newArray(128, 41);
         TRANSITION[41][39] = 39;
         TRANSITION[42] = copyReplacing(var3, 22, 39);
         TRANSITION[42][39] = 43;
         TRANSITION[43] = newArray(128, 43);
         TRANSITION[43][39] = 44;
         TRANSITION[44] = newArray(128, 39);
         TRANSITION[44][39] = 43;
         TRANSITION[45] = newArray(128, 39);
         TRANSITION[45][39] = 46;
         TRANSITION[46] = newArray(128, 47);
         TRANSITION[47] = newArray(128, 47);
         TRANSITION[48] = newArray(128, 47);
         TRANSITION[48][39] = 15;
         TRANSITION[49] = copyReplacing(var4, 15, 49, 22, 50);
         TRANSITION[49][40] = 15;
         TRANSITION[49][47] = 18;
         TRANSITION[49][45] = 20;
         TRANSITION[50] = copyReplacing(var3, 22, 50, 15, 51);
         TRANSITION[50][47] = 18;
         TRANSITION[50][45] = 20;
         TRANSITION[51] = copyReplacing(var4, 15, 51);
         TRANSITION[51][83] = 52;
         TRANSITION[51][115] = 52;
         TRANSITION[51][47] = 18;
         TRANSITION[51][45] = 20;
         TRANSITION[52] = copy(var4);
         TRANSITION[52][69] = 53;
         TRANSITION[52][101] = 53;
         TRANSITION[53] = copy(var4);
         TRANSITION[53][84] = 67;
         TRANSITION[53][116] = 67;
         TRANSITION[54] = copy(var4);
         TRANSITION[54][114] = 55;
         TRANSITION[54][82] = 55;
         TRANSITION[55] = copy(var4);
         TRANSITION[55][111] = 56;
         TRANSITION[55][79] = 56;
         TRANSITION[56] = copy(var4);
         TRANSITION[56][109] = 57;
         TRANSITION[56][77] = 57;
         TRANSITION[57] = copyReplacing(var1, 2, 59, 15, 58);
         TRANSITION[57][47] = 18;
         TRANSITION[57][45] = 20;
         TRANSITION[58] = copyReplacing(var4, 15, 58, 22, 59);
         TRANSITION[58][40] = 15;
         TRANSITION[58][47] = 18;
         TRANSITION[58][45] = 20;
         TRANSITION[59] = copyReplacing(var4, 15, 59, 22, 59);
         TRANSITION[59][44] = 60;
         TRANSITION[59][119] = 23;
         TRANSITION[59][87] = 23;
         TRANSITION[59][47] = 18;
         TRANSITION[59][45] = 20;
         TRANSITION[59][40] = 15;
         TRANSITION[60] = copyReplacing(var4, 15, 57);
         TRANSITION[61] = copy(var4);
         TRANSITION[61][47] = 18;
         TRANSITION[61][45] = 20;
         TRANSITION[61][87] = 23;
         TRANSITION[61][119] = 23;
         TRANSITION[23] = copyReplacing(var3, 15, 59, 22, 59);
         TRANSITION[23][72] = 24;
         TRANSITION[23][104] = 24;
         TRANSITION[24] = copyReplacing(var3, 15, 59, 22, 59);
         TRANSITION[24][69] = 25;
         TRANSITION[24][101] = 25;
         TRANSITION[25] = copyReplacing(var3, 15, 59, 22, 59);
         TRANSITION[25][82] = 26;
         TRANSITION[25][114] = 26;
         TRANSITION[26] = copyReplacing(var3, 15, 59, 22, 59);
         TRANSITION[26][69] = 27;
         TRANSITION[26][101] = 27;
         TRANSITION[27] = copyReplacing(var4, 15, 67, 22, 59);
         TRANSITION[27][47] = 18;
         TRANSITION[27][45] = 20;
         TRANSITION[67] = copyReplacing(var4, 15, 68, 22, 69);
         TRANSITION[67][47] = 18;
         TRANSITION[67][45] = 20;
         TRANSITION[62] = copyReplacing(var4, 15, 68, 22, 69);
         TRANSITION[62][104] = 63;
         TRANSITION[62][72] = 63;
         TRANSITION[63] = copyReplacing(var4, 15, 68, 22, 69);
         TRANSITION[63][101] = 64;
         TRANSITION[63][69] = 64;
         TRANSITION[64] = copyReplacing(var4, 15, 68, 22, 69);
         TRANSITION[64][114] = 65;
         TRANSITION[64][82] = 65;
         TRANSITION[65] = copyReplacing(var4, 15, 68, 22, 69);
         TRANSITION[65][101] = 66;
         TRANSITION[65][69] = 66;
         TRANSITION[66] = copyReplacing(var4, 15, 68, 22, 69);
         TRANSITION[68] = copyReplacing(var4, 15, 68, 22, 69);
         TRANSITION[68][79] = 87;
         TRANSITION[68][111] = 87;
         TRANSITION[68][65] = 89;
         TRANSITION[68][97] = 89;
         TRANSITION[68][87] = 62;
         TRANSITION[68][119] = 62;
         TRANSITION[68][47] = 18;
         TRANSITION[68][45] = 20;
         TRANSITION[87] = copyReplacing(var3, 22, 69);
         TRANSITION[87][82] = 88;
         TRANSITION[87][114] = 88;
         TRANSITION[88] = copyReplacing(var3, 22, 69, 15, 68);
         TRANSITION[88][47] = 18;
         TRANSITION[88][45] = 20;
         TRANSITION[89] = copyReplacing(var3, 22, 69);
         TRANSITION[89][78] = 90;
         TRANSITION[89][110] = 90;
         TRANSITION[90] = copyReplacing(var3, 22, 69);
         TRANSITION[90][68] = 91;
         TRANSITION[90][100] = 91;
         TRANSITION[91] = copyReplacing(var3, 22, 69, 15, 68);
         TRANSITION[91][47] = 18;
         TRANSITION[91][45] = 20;
         TRANSITION[69] = copyReplacing(var3, 22, 69, 15, 82);
         TRANSITION[69][47] = 18;
         TRANSITION[69][45] = 20;
         TRANSITION[69][62] = 83;
         TRANSITION[69][60] = 83;
         TRANSITION[69][61] = 83;
         TRANSITION[69][46] = 69;
         TRANSITION[70] = copyReplacing(var3, 22, 67, 15, 82);
         TRANSITION[70][105] = 71;
         TRANSITION[70][73] = 71;
         TRANSITION[82] = copyReplacing(var4, 15, 82, 22, 69);
         TRANSITION[82][105] = 71;
         TRANSITION[82][73] = 71;
         TRANSITION[82][47] = 18;
         TRANSITION[82][45] = 20;
         TRANSITION[82][105] = 71;
         TRANSITION[82][73] = 71;
         TRANSITION[82][62] = 83;
         TRANSITION[82][60] = 83;
         TRANSITION[82][61] = 83;
         TRANSITION[82][63] = 86;
         TRANSITION[71] = copy(var3);
         TRANSITION[71][83] = 72;
         TRANSITION[71][115] = 72;
         TRANSITION[72] = copyReplacing(var4, 15, 73);
         TRANSITION[72][47] = 18;
         TRANSITION[72][45] = 20;
         TRANSITION[72][78] = 74;
         TRANSITION[72][110] = 74;
         TRANSITION[73] = copyReplacing(var4, 15, 73);
         TRANSITION[73][110] = 74;
         TRANSITION[73][78] = 74;
         TRANSITION[73][47] = 18;
         TRANSITION[73][45] = 20;
         TRANSITION[74] = copy(var3);
         TRANSITION[74][111] = 75;
         TRANSITION[74][79] = 75;
         TRANSITION[74][117] = 79;
         TRANSITION[74][85] = 79;
         TRANSITION[75] = copy(var3);
         TRANSITION[75][116] = 76;
         TRANSITION[75][84] = 76;
         TRANSITION[76] = copyReplacing(var4, 15, 77);
         TRANSITION[77] = copy(var3);
         TRANSITION[77][110] = 78;
         TRANSITION[77][78] = 78;
         TRANSITION[77][47] = 18;
         TRANSITION[77][45] = 20;
         TRANSITION[78] = copy(var3);
         TRANSITION[78][117] = 79;
         TRANSITION[78][85] = 79;
         TRANSITION[79] = copy(var3);
         TRANSITION[79][108] = 80;
         TRANSITION[79][76] = 80;
         TRANSITION[80] = copy(var3);
         TRANSITION[80][108] = 81;
         TRANSITION[80][76] = 81;
         TRANSITION[81] = copyReplacing(var4, 15, 68);
         TRANSITION[81][47] = 18;
         TRANSITION[81][45] = 20;
         TRANSITION[83] = copyReplacing(var4, 15, 85);
         TRANSITION[83][47] = 18;
         TRANSITION[83][45] = 20;
         TRANSITION[83][62] = 84;
         TRANSITION[83][39] = 92;
         TRANSITION[83][78] = 93;
         TRANSITION[83][110] = 93;
         TRANSITION[83][63] = 67;
         TRANSITION[84] = copyReplacing(var4, 15, 85);
         TRANSITION[84][47] = 18;
         TRANSITION[84][45] = 20;
         TRANSITION[84][39] = 92;
         TRANSITION[84][78] = 93;
         TRANSITION[84][110] = 93;
         TRANSITION[84][63] = 67;
         TRANSITION[85] = copyReplacing(var3, 15, 85, 22, 68);
         TRANSITION[85][47] = 18;
         TRANSITION[85][45] = 20;
         TRANSITION[85][39] = 92;
         TRANSITION[85][78] = 93;
         TRANSITION[85][110] = 93;
         TRANSITION[85][63] = 86;
         TRANSITION[86] = copyReplacing(var4, 15, 68, 22, 86);
         TRANSITION[86][47] = 18;
         TRANSITION[86][45] = 20;
         TRANSITION[86][39] = 92;
         TRANSITION[86][78] = 93;
         TRANSITION[86][110] = 93;
         TRANSITION[92] = newArray(128, 92);
         TRANSITION[92][39] = 68;
         TRANSITION[93] = copyReplacing(var3, 22, 68);
         TRANSITION[93][39] = 94;
         TRANSITION[94] = newArray(128, 94);
         TRANSITION[94][39] = 95;
         TRANSITION[95] = newArray(128, 68);
         TRANSITION[95][39] = 94;
         TRANSITION[85][45] = 20;
         TRANSITION[15] = var4;
         int[] var5 = newArray(128, 0);
         int[] var6 = copy(var5);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            if (var3[var7] != 22) {
               var6[var7] = 2;
            } else {
               var6[var7] = 10;
            }
         }

         int[] var29 = new int[128];

         for(int var8 = 0; var8 < var29.length; ++var8) {
            if (TRANSITION[1][var8] == 1) {
               var29[var8] = 3;
            } else {
               var29[var8] = 4;
            }
         }

         int[] var30 = new int[128];

         for(int var9 = 0; var9 < var30.length; ++var9) {
            if (TRANSITION[21][var9] == 21) {
               var30[var9] = 3;
            } else {
               var30[var9] = 4;
            }
         }

         int[] var31 = copy(var30);
         var31[32] = 0;
         var31[10] = 0;
         var31[9] = 0;
         var31[13] = 0;
         int[] var10 = copy(var5);
         var10[44] = 5;
         var10[41] = 5;
         int[] var11 = copy(var31);
         var11[44] = 5;
         var11[41] = 5;
         int[] var12 = copy(var5);

         for(int var13 = 0; var13 < var12.length; ++var13) {
            if (var3[var13] != 15) {
               var12[var13] = 10;
            }
         }

         var12[44] = 11;
         var12[32] = 11;
         var12[9] = 11;
         var12[10] = 11;
         var12[13] = 11;
         var12[40] = 13;
         var12[47] = 18;
         var12[45] = 18;
         int[] var32 = copy(var12);
         var32[32] = 10;
         var32[40] = 17;
         int[] var14 = copy(var5);

         for(int var15 = 0; var15 < var14.length; ++var15) {
            if (var3[var15] == 1) {
               var14[var15] = 0;
            } else if (var3[var15] != 22) {
               var14[var15] = 12;
            }
         }

         int[] var33 = copyReplacing(var5, 0, 14);
         var33[44] = 15;
         var33[41] = 16;
         int[] var16 = copyReplacing(var29, 3, 13);
         var16[58] = 0;

         for(int var17 = 0; var17 < var16.length; ++var17) {
            if (var16[var17] == 4) {
               var16[var17] = 0;
            }
         }

         var16[47] = 18;
         var16[45] = 18;
         int[] var34 = copyReplacing(var16, 13, 14);
         var34[46] = 14;
         var34[40] = 17;
         int[] var18 = copyReplacing(var16, 0, 17, 13, 14);
         int[] var19 = copy(var5);
         var19[47] = 18;
         var19[45] = 18;
         int[] var20 = copy(var5);
         var20[47] = 19;
         int[] var21 = copy(var5);
         var21[10] = 19;
         int[] var22 = copy(var5);
         var22[32] = 20;
         var22[10] = 20;
         var22[9] = 20;
         var22[45] = 20;
         var22[47] = 20;
         int[] var23 = copy(var5);
         var23[39] = 6;
         int[] var24 = copyReplacing(var5, 0, 7);
         var24[39] = 0;
         int[] var25 = copyReplacing(var5, 0, 8);
         int[] var26 = copyReplacing(var5, 0, 9);
         int[] var27 = copy(var26);
         var27[39] = 0;
         ACTION[0] = var5;
         ACTION[1] = var29;
         ACTION[96] = var31;
         ACTION[2] = var19;
         ACTION[3] = var5;
         ACTION[4] = var5;
         ACTION[5] = var5;
         ACTION[6] = var5;
         ACTION[7] = var5;
         ACTION[8] = var5;
         ACTION[9] = var5;
         ACTION[10] = var5;
         ACTION[11] = var5;
         ACTION[12] = var5;
         ACTION[13] = var5;
         ACTION[14] = var5;
         ACTION[22] = var5;
         ACTION[16] = var5;
         ACTION[17] = var5;
         ACTION[18] = var19;
         ACTION[19] = var20;
         ACTION[20] = var21;
         ACTION[21] = var30;
         ACTION[15] = var5;
         ACTION[28] = var19;
         ACTION[29] = var5;
         ACTION[30] = var5;
         ACTION[31] = var5;
         ACTION[32] = var5;
         ACTION[33] = var12;
         ACTION[34] = var12;
         ACTION[35] = var14;
         ACTION[36] = var33;
         ACTION[37] = var5;
         ACTION[38] = var5;
         ACTION[39] = var10;
         ACTION[40] = var11;
         ACTION[41] = var5;
         ACTION[42] = var23;
         ACTION[43] = var5;
         ACTION[44] = var24;
         ACTION[45] = var18;
         ACTION[46] = var25;
         ACTION[47] = var26;
         ACTION[48] = var27;
         ACTION[49] = var12;
         ACTION[50] = var12;
         ACTION[51] = var19;
         ACTION[52] = var5;
         ACTION[53] = var5;
         ACTION[54] = var5;
         ACTION[55] = var5;
         ACTION[56] = var5;
         ACTION[57] = var32;
         ACTION[58] = var32;
         ACTION[59] = var32;
         ACTION[60] = var14;
         ACTION[61] = var5;
         ACTION[62] = var34;
         ACTION[63] = var34;
         ACTION[64] = var34;
         ACTION[65] = var34;
         ACTION[66] = var6;
         ACTION[67] = var16;
         ACTION[68] = var16;
         ACTION[89] = var5;
         ACTION[90] = var5;
         ACTION[91] = var22;
         ACTION[87] = var5;
         ACTION[88] = var5;
         ACTION[69] = var34;
         ACTION[70] = var5;
         ACTION[71] = var5;
         ACTION[72] = var19;
         ACTION[73] = var5;
         ACTION[74] = var5;
         ACTION[75] = var5;
         ACTION[76] = var19;
         ACTION[77] = var5;
         ACTION[78] = var5;
         ACTION[79] = var5;
         ACTION[80] = var5;
         ACTION[81] = var5;
         ACTION[82] = var19;
         ACTION[83] = var19;
         ACTION[84] = var5;
         ACTION[85] = var19;
         ACTION[86] = var5;
         ACTION[92] = var5;
         ACTION[93] = var23;
         ACTION[94] = var5;
         ACTION[95] = var24;
         ACTION[23] = var12;
         ACTION[24] = var12;
         ACTION[25] = var12;
         ACTION[26] = var12;
         ACTION[27] = var6;
      } catch (Throwable var28) {
         var28.printStackTrace();
      }

   }
}
