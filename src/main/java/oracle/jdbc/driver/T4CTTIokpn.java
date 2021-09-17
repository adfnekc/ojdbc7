package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.sql.TIMESTAMPTZ;

final class T4CTTIokpn extends T4CTTIfun {
   static final int REGISTER_KPNDEF = 1;
   static final int UNREGISTER_KPNDEF = 2;
   static final int POST_KPNDEF = 3;
   static final int EXISTINGCLIENT_KPNDEF = 0;
   static final int NEWCLIENT_KPNDEF = 1;
   static final int CLIENTCON_KPNDEF = 4;
   static final int KPUN_PRS_RAW = 1;
   static final int KPUN_VER_10200 = 2;
   static final int KPUN_VER_11100 = 3;
   static final int KPUN_VER_11200 = 4;
   static final int OCI_SUBSCR_NAMESPACE_ANONYMOUS = 0;
   static final int OCI_SUBSCR_NAMESPACE_AQ = 1;
   static final int OCI_SUBSCR_NAMESPACE_DBCHANGE = 2;
   static final int OCI_SUBSCR_NAMESPACE_MAX = 3;
   static final int KPD_CHNF_OPFILTER = 1;
   static final int KPD_CHNF_INSERT = 2;
   static final int KPD_CHNF_UPDATE = 4;
   static final int KPD_CHNF_DELETE = 8;
   static final int KPD_CHNF_ROWID = 16;
   static final int KPD_CQ_QUERYNF = 32;
   static final int KPD_CQ_BEST_EFFORT = 64;
   static final int KPD_CQ_CLQRYCACHE = 128;
   static final int KPD_CHNF_INVALID_REGID = 0;
   static final int KPD_NTFN_CONNID_LEN = 29;
   static final int KKCN_CTX_RAW = 0;
   static final int SUBSCR_QOS_RELIABLE = 1;
   static final int SUBSCR_QOS_PAYLOAD = 2;
   static final int SUBSCR_QOS_REPLICATE = 4;
   static final int SUBSCR_QOS_SECURE = 8;
   static final int SUBSCR_QOS_PURGE_ON_NTFN = 16;
   static final int SUBSCR_QOS_MULTICBK = 32;
   static final int SUBSCR_QOS_ASYNC_DEQ = 512;
   static final int SUBSCR_QOS_TX_ACK = 2048;
   static final int SUBSCR_QOS_AUTO_ACK = 1024;
   static final byte SUBSCR_NTFN_GROUPING_CLASS_NONE = 0;
   static final byte SUBSCR_NTFN_GROUPING_CLASS_TIME = 1;
   static final byte SUBSCR_NTFN_GROUPING_TYPE_SUMMARY = 1;
   static final byte SUBSCR_NTFN_GROUPING_TYPE_LAST = 2;
   private int opcode;
   private int mode;
   private int nbOfRegistrationInfo;
   private String user;
   private String location;
   private String jmsClientId = null;
   private String[] databaseInstances = null;
   private int[] namespace;
   private int[] kpdnrgrpval;
   private int[] kpdnrgrprepcnt;
   private int[] payloadType;
   private int[] qosFlags;
   private int[] timeout;
   private int[] dbchangeOpFilter;
   private int[] dbchangeTxnLag = null;
   private byte[] kpncid = null;
   private byte[][] registeredAgentName = (byte[][])null;
   private byte[][] kpdnrcx = (byte[][])null;
   private byte[] kpdnrgrpcla;
   private byte[] kpdnrgrptyp = null;
   private TIMESTAMPTZ[] kpdnrgrpstatim = null;
   private long[] dbchangeRegistrationId = null;
   private byte[] userArr = null;
   private byte[] locationArr = null;
   private byte[] subscriberName = null;
   private long regid = 0L;
   private long[] registrationId = null;
   ArrayList listenerAddresses = new ArrayList();
   T4CTTIkpdnrri kpninst = null;
   T4CTTIkpdnrgnc kpngcret = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIokpn(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)125);
   }

   void doOKPN(int var1, int var2, String var3, String var4, int var5, int[] var6, String[] var7, byte[][] var8, int[] var9, int[] var10, int[] var11, int[] var12, int[] var13, long[] var14, byte[] var15, int[] var16, byte[] var17, TIMESTAMPTZ[] var18, int[] var19, long[] var20) throws IOException, SQLException {
      this.opcode = var1;
      this.mode = var2;
      this.user = var3;
      this.location = var4;
      this.nbOfRegistrationInfo = var5;
      this.namespace = var6;
      this.kpdnrcx = var8;
      this.payloadType = var9;
      this.qosFlags = var10;
      this.timeout = var11;
      this.dbchangeOpFilter = var12;
      if (this.dbchangeOpFilter == null) {
         this.dbchangeOpFilter = new int[this.nbOfRegistrationInfo];
      }

      this.dbchangeTxnLag = var13;
      if (this.dbchangeTxnLag == null) {
         this.dbchangeTxnLag = new int[this.nbOfRegistrationInfo];
      }

      this.dbchangeRegistrationId = var14;
      if (this.dbchangeRegistrationId == null) {
         this.dbchangeRegistrationId = new long[this.nbOfRegistrationInfo];
      }

      this.kpdnrgrpcla = var15;
      if (this.kpdnrgrpcla == null) {
         this.kpdnrgrpcla = new byte[this.nbOfRegistrationInfo];
      }

      this.kpdnrgrpval = var16;
      if (this.kpdnrgrpval == null) {
         this.kpdnrgrpval = new int[this.nbOfRegistrationInfo];
      }

      this.kpdnrgrptyp = var17;
      if (this.kpdnrgrptyp == null) {
         this.kpdnrgrptyp = new byte[this.nbOfRegistrationInfo];
      }

      this.kpdnrgrpstatim = var18;
      if (this.kpdnrgrpstatim == null) {
         this.kpdnrgrpstatim = new TIMESTAMPTZ[this.nbOfRegistrationInfo];
      }

      this.kpdnrgrprepcnt = var19;
      if (this.kpdnrgrprepcnt == null) {
         this.kpdnrgrprepcnt = new int[this.nbOfRegistrationInfo];
      }

      this.registrationId = var20;
      if (this.registrationId == null) {
         this.registrationId = new long[this.nbOfRegistrationInfo];
      }

      this.registeredAgentName = new byte[this.nbOfRegistrationInfo][];

      for(int var21 = 0; var21 < this.nbOfRegistrationInfo; ++var21) {
         if (var7[var21] != null) {
            this.registeredAgentName[var21] = this.meg.conv.StringToCharBytes(var7[var21]);
         }
      }

      if (this.user != null) {
         this.userArr = this.meg.conv.StringToCharBytes(this.user);
      } else {
         this.userArr = null;
      }

      if (this.location != null) {
         this.locationArr = this.meg.conv.StringToCharBytes(this.location);
      } else {
         this.locationArr = null;
      }

      this.regid = 0L;
      this.doRPC();
   }

   void marshal() throws IOException {
      byte var1 = 1;
      byte var2 = 2;
      this.meg.marshalUB1((short)((byte)this.opcode));
      this.meg.marshalUB4((long)this.mode);
      if (this.userArr != null) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.userArr.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.locationArr != null) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.locationArr.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      this.meg.marshalPTR();
      this.meg.marshalUB4((long)this.nbOfRegistrationInfo);
      this.meg.marshalUB2(var1);
      this.meg.marshalUB2(var2);
      if (this.connection.getTTCVersion() >= 4) {
         this.meg.marshalNULLPTR();
         this.meg.marshalPTR();
         if (this.connection.getTTCVersion() >= 5) {
            this.meg.marshalNULLPTR();
            this.meg.marshalPTR();
            if (this.connection.getTTCVersion() >= 7) {
               this.meg.marshalPTR();
               this.meg.marshalPTR();
               this.meg.marshalPTR();
               this.meg.marshalPTR();
               this.meg.marshalPTR();
               this.meg.marshalSWORD(29);
               this.meg.marshalPTR();
            }
         }
      }

      if (this.userArr != null) {
         this.meg.marshalCHR(this.userArr);
      }

      if (this.locationArr != null) {
         this.meg.marshalCHR(this.locationArr);
      }

      assert this.namespace != null && this.registeredAgentName != null && this.payloadType != null && this.qosFlags != null && this.timeout != null : " namespace : " + this.namespace + ", registeredAgentName : " + this.registeredAgentName + ", payloadType : " + this.payloadType + ", qosFlags : " + this.qosFlags + ", timeout : " + this.timeout;

      assert this.namespace.length == this.nbOfRegistrationInfo && this.registeredAgentName.length == this.nbOfRegistrationInfo && this.payloadType.length == this.nbOfRegistrationInfo && this.qosFlags.length == this.nbOfRegistrationInfo && this.timeout.length == this.nbOfRegistrationInfo && this.kpdnrcx.length == this.nbOfRegistrationInfo && this.dbchangeOpFilter.length == this.nbOfRegistrationInfo && this.dbchangeTxnLag.length == this.nbOfRegistrationInfo && this.kpdnrgrpcla.length == this.nbOfRegistrationInfo && this.kpdnrgrpval.length == this.nbOfRegistrationInfo && this.kpdnrgrptyp.length == this.nbOfRegistrationInfo && this.kpdnrgrpstatim.length == this.nbOfRegistrationInfo && this.kpdnrgrprepcnt.length == this.nbOfRegistrationInfo && this.registrationId.length == this.nbOfRegistrationInfo : " namespace.length = " + this.namespace.length + ", registeredAgentName.length = " + this.registeredAgentName.length + ", qosFlags.length = " + this.qosFlags.length + ", timeout.length = " + this.timeout.length + ", kpdnrcx.length = " + this.kpdnrcx.length + ", dbchangeOpFilter.length = " + this.dbchangeOpFilter.length + ", dbchangeTxnLag.length = " + this.dbchangeTxnLag.length + ", kpdnrgrpcla.length = " + this.kpdnrgrpcla.length + ", kpdnrgrpval.length = " + this.kpdnrgrpval.length + ", kpdnrgrptyp.length = " + this.kpdnrgrptyp.length + ", kpdnrgrpstatim.length = " + this.kpdnrgrpstatim.length + ", kpdnrgrprepcnt.length = " + this.kpdnrgrprepcnt.length + ", registrationId.length = " + this.registrationId.length;

      for(int var3 = 0; var3 < this.nbOfRegistrationInfo; ++var3) {
         this.meg.marshalUB4((long)this.namespace[var3]);
         byte[] var4 = this.registeredAgentName[var3];
         if (var4 != null && var4.length > 0) {
            this.meg.marshalUB4((long)var4.length);
            this.meg.marshalCLR(var4, 0, var4.length);
         } else {
            this.meg.marshalUB4(0L);
         }

         if (this.kpdnrcx == null) {
            this.meg.marshalUB4(0L);
         } else if (this.kpdnrcx[var3] != null && this.kpdnrcx[var3].length > 0) {
            this.meg.marshalUB4((long)this.kpdnrcx[var3].length);
            this.meg.marshalCLR(this.kpdnrcx[var3], 0, this.kpdnrcx[var3].length);
         } else {
            this.meg.marshalUB4(0L);
         }

         this.meg.marshalUB4((long)this.payloadType[var3]);
         if (this.connection.getTTCVersion() >= 4) {
            this.meg.marshalUB4((long)this.qosFlags[var3]);
            byte[] var5 = new byte[0];
            this.meg.marshalUB4((long)var5.length);
            if (var5.length > 0) {
               this.meg.marshalCLR(var5, var5.length);
            }

            this.meg.marshalUB4((long)this.timeout[var3]);
            byte var6 = 0;
            this.meg.marshalUB4((long)var6);
            this.meg.marshalUB4((long)this.dbchangeOpFilter[var3]);
            this.meg.marshalUB4((long)this.dbchangeTxnLag[var3]);
            this.meg.marshalUB4((long)((int)this.dbchangeRegistrationId[var3]));
            if (this.connection.getTTCVersion() >= 5) {
               this.meg.marshalUB1((short)this.kpdnrgrpcla[var3]);
               this.meg.marshalUB4((long)this.kpdnrgrpval[var3]);
               this.meg.marshalUB1((short)this.kpdnrgrptyp[var3]);
               if (this.kpdnrgrpstatim[var3] == null) {
                  this.meg.marshalDALC((byte[])null);
               } else {
                  this.meg.marshalDALC(this.kpdnrgrpstatim[var3].shareBytes());
               }

               this.meg.marshalSB4(this.kpdnrgrprepcnt[var3]);
               this.meg.marshalSB8(this.registrationId[var3]);
            }
         }
      }

   }

   long getRegistrationId() {
      return this.regid;
   }

   void readRPA() throws IOException, SQLException {
      int var1 = (int)this.meg.unmarshalUB4();

      for(int var2 = 0; var2 < var1; ++var2) {
         this.meg.unmarshalUB4();
      }

      int[] var9 = new int[var1];

      int var3;
      for(var3 = 0; var3 < var1; ++var3) {
         var9[var3] = (int)this.meg.unmarshalUB4();
      }

      this.regid = (long)var9[0];
      if (this.connection.getTTCVersion() >= 5) {
         var3 = (int)this.meg.unmarshalUB4();
         this.registrationId = new long[var3];

         int var4;
         int var5;
         for(var4 = 0; var4 < var3; ++var4) {
            this.registrationId[var4] = this.meg.unmarshalSB8();
            if (this.connection.getTTCVersion() >= 7) {
               var5 = (int)this.meg.unmarshalUB4();
               if (var5 > 0) {
                  this.subscriberName = new byte[var5];
                  this.meg.unmarshalBuffer(this.subscriberName, 0, var5);
               }
            }
         }

         this.regid = this.registrationId[0];
         if (this.connection.getTTCVersion() >= 7) {
            var4 = (int)this.meg.unmarshalUB4();
            this.databaseInstances = new String[var4];

            for(var5 = 0; var5 < var4; ++var5) {
               this.kpninst = new T4CTTIkpdnrri(this.connection);
               this.kpninst.receive();
               byte[] var6 = this.kpninst.getKpdnrrinm();
               if (var6 != null) {
                  this.databaseInstances[var5] = this.meg.conv.CharBytesToString(var6, var6.length);
               }
            }

            var5 = (int)this.meg.unmarshalUB4();
            this.listenerAddresses = new ArrayList();

            int var10;
            for(var10 = 0; var10 < var5; ++var10) {
               this.kpngcret = new T4CTTIkpdnrgnc(this.connection);
               this.kpngcret.receive();
               byte[] var7 = this.kpngcret.getKpdnrgnclsc();
               if (var7 != null) {
                  String var8 = this.meg.conv.CharBytesToString(var7, var7.length);
                  this.listenerAddresses.add(var8);
               }
            }

            var10 = this.meg.unmarshalUB2();
            if (var10 > 0) {
               this.kpncid = new byte[var10];
               this.kpncid = this.meg.unmarshalCHR(var10);
               if (this.kpncid != null) {
                  this.jmsClientId = this.meg.conv.CharBytesToString(this.kpncid, this.kpncid.length);
               }
            }
         }
      }

   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }

   ArrayList getListenerAddresses() {
      return this.listenerAddresses;
   }

   String getListenerAddress() throws SQLException {
      SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
      var1.fillInStackTrace();
      throw var1;
   }

   long[] getRegistrationIdArray() {
      return this.registrationId;
   }

   String getJMSClientId() {
      return this.jmsClientId;
   }

   String[] getDatabaseInstances() {
      return this.databaseInstances;
   }
}
