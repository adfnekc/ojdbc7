package oracle.jdbc.driver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Arrays;
import java.util.Properties;
import java.util.TimeZone;
import java.util.Locale.Category;
import oracle.jdbc.util.RepConversion;
import oracle.net.ano.AuthenticationService;
import oracle.net.nt.TcpsNTAdapter;
import oracle.security.o3logon.O3LoginClientHelper;
import oracle.security.o5logon.O5Logon;
import oracle.sql.ZONEIDMAP;
import oracle.sql.converter.CharacterSetMetaData;

final class T4CTTIoauthenticate extends T4CTTIfun {
   byte[] terminal;
   byte[] enableTempLobRefCnt;
   byte[] machine;
   byte[] sysUserName;
   byte[] processID;
   byte[] programName;
   byte[] encryptedSK;
   byte[] internalName;
   byte[] externalName;
   byte[] alterSession;
   byte[] aclValue;
   byte[] clientname;
   byte[] editionName = null;
   byte[] driverName;
   String ressourceManagerId;
   boolean bUseO5Logon;
   int verifierType;
   static final int ZTVT_ORCL_7 = 2361;
   static final int ZTVT_SSH1 = 6949;
   static final int ZTVT_NTV = 7809;
   static final int ZTVT_SMD5 = 59694;
   static final int ZTVT_MD5 = 40674;
   static final int ZTVT_SH1 = 45394;
   static final int ZTVT_SHA512 = 18453;
   byte[] salt;
   byte[] encryptedKB;
   boolean isSessionTZ = true;
   static final int SERVER_VERSION_81 = 8100;
   static final int KPZ_LOGON = 1;
   static final int KPZ_CPW = 2;
   static final int KPZ_SRVAUTH = 4;
   static final int KPZ_ENCRYPTED_PASSWD = 256;
   static final int KPZ_LOGON_MIGRATE = 16;
   static final int KPZ_LOGON_SYSDBA = 32;
   static final int KPZ_LOGON_SYSOPER = 64;
   static final int KPZ_LOGON_PRELIMAUTH = 128;
   static final int KPZ_PASSWD_ENCRYPTED = 256;
   static final int KPZ_LOGON_DBCONC = 512;
   static final int KPZ_PROXY_AUTH = 1024;
   static final int KPZ_SESSION_CACHE = 2048;
   static final int KPZ_PASSWD_IS_VFR = 4096;
   static final int KPZ_LOGON_SYSASM = 4194304;
   static final int KPZ_SESSION_QCACHE = 8388608;
   static final int KPZ_LOGON_SYSBKP = 16777216;
   static final int KPZ_LOGON_SYSDGD = 33554432;
   static final int KPZ_LOGON_SYSKMT = 67108864;
   static final String AUTH_TERMINAL = "AUTH_TERMINAL";
   static final String AUTH_PROGRAM_NM = "AUTH_PROGRAM_NM";
   static final String AUTH_MACHINE = "AUTH_MACHINE";
   static final String AUTH_PID = "AUTH_PID";
   static final String AUTH_SID = "AUTH_SID";
   static final String AUTH_SESSKEY = "AUTH_SESSKEY";
   static final String AUTH_VFR_DATA = "AUTH_VFR_DATA";
   static final String AUTH_PASSWORD = "AUTH_PASSWORD";
   static final String AUTH_INTERNALNAME = "AUTH_INTERNALNAME_";
   static final String AUTH_EXTERNALNAME = "AUTH_EXTERNALNAME_";
   static final String AUTH_ACL = "AUTH_ACL";
   static final String AUTH_ALTER_SESSION = "AUTH_ALTER_SESSION";
   static final String AUTH_INITIAL_CLIENT_ROLE = "INITIAL_CLIENT_ROLE";
   static final String AUTH_VERSION_SQL = "AUTH_VERSION_SQL";
   static final String AUTH_VERSION_NO = "AUTH_VERSION_NO";
   static final String AUTH_XACTION_TRAITS = "AUTH_XACTION_TRAITS";
   static final String AUTH_VERSION_STATUS = "AUTH_VERSION_STATUS";
   static final String AUTH_SERIAL_NUM = "AUTH_SERIAL_NUM";
   static final String AUTH_SESSION_ID = "AUTH_SESSION_ID";
   static final String AUTH_CLIENT_CERTIFICATE = "AUTH_CLIENT_CERTIFICATE";
   static final String AUTH_PROXY_CLIENT_NAME = "PROXY_CLIENT_NAME";
   static final String AUTH_CLIENT_DN = "AUTH_CLIENT_DISTINGUISHED_NAME";
   static final String AUTH_INSTANCENAME = "AUTH_INSTANCENAME";
   static final String AUTH_DBNAME = "AUTH_DBNAME";
   static final String AUTH_INSTANCE_NO = "AUTH_INSTANCE_NO";
   static final String AUTH_DB_ID = "AUTH_DB_ID";
   static final String AUTH_SC_SERVER_HOST = "AUTH_SC_SERVER_HOST";
   static final String AUTH_SC_INSTANCE_NAME = "AUTH_SC_INSTANCE_NAME";
   static final String AUTH_SC_INSTANCE_ID = "AUTH_SC_INSTANCE_ID";
   static final String AUTH_SC_INSTANCE_START_TIME = "AUTH_SC_INSTANCE_START_TIME";
   static final String AUTH_SC_DBUNIQUE_NAME = "AUTH_SC_DBUNIQUE_NAME";
   static final String AUTH_SC_SERVICE_NAME = "AUTH_SC_SERVICE_NAME";
   static final String AUTH_SC_SVC_FLAGS = "AUTH_SC_SVC_FLAGS";
   static final String AUTH_SC_DB_DOMAIN = "AUTH_SC_DB_DOMAIN";
   static final String AUTH_SESSION_CLIENT_CSET = "SESSION_CLIENT_CHARSET";
   static final String AUTH_SESSION_CLIENT_LTYPE = "SESSION_CLIENT_LIB_TYPE";
   static final String AUTH_SESSION_CLIENT_DRVNM = "SESSION_CLIENT_DRIVER_NAME";
   static final String AUTH_SESSION_CLIENT_VSN = "SESSION_CLIENT_VERSION";
   static final String AUTH_NLS_LXLAN = "AUTH_NLS_LXLAN";
   static final String AUTH_NLS_LXCTERRITORY = "AUTH_NLS_LXCTERRITORY";
   static final String AUTH_NLS_LXCCURRENCY = "AUTH_NLS_LXCCURRENCY";
   static final String AUTH_NLS_LXCISOCURR = "AUTH_NLS_LXCISOCURR";
   static final String AUTH_NLS_LXCNUMERICS = "AUTH_NLS_LXCNUMERICS";
   static final String AUTH_NLS_LXCDATEFM = "AUTH_NLS_LXCDATEFM";
   static final String AUTH_NLS_LXCDATELANG = "AUTH_NLS_LXCDATELANG";
   static final String AUTH_NLS_LXCSORT = "AUTH_NLS_LXCSORT";
   static final String AUTH_NLS_LXCCALENDAR = "AUTH_NLS_LXCCALENDAR";
   static final String AUTH_NLS_LXCUNIONCUR = "AUTH_NLS_LXCUNIONCUR";
   static final String AUTH_NLS_LXCTIMEFM = "AUTH_NLS_LXCTIMEFM";
   static final String AUTH_NLS_LXCSTMPFM = "AUTH_NLS_LXCSTMPFM";
   static final String AUTH_NLS_LXCTTZNFM = "AUTH_NLS_LXCTTZNFM";
   static final String AUTH_NLS_LXCSTZNFM = "AUTH_NLS_LXCSTZNFM";
   static final String SESSION_CLIENT_LOBATTR = "SESSION_CLIENT_LOBATTR";
   static final String AUTH_KPPL_CONN_CLASS = "AUTH_KPPL_CONN_CLASS";
   static final String AUTH_KPPL_PURITY = "AUTH_KPPL_PURITY";
   static final String AUTH_KPPL_TAG = "AUTH_KPPL_TAG";
   static final String AUTH_KPPL_WAIT = "AUTH_KPPL_WAIT";
   static final String KPPL_PURITY_DEFAULT = "0";
   static final String KPPL_PURITY_NEW = "1";
   static final String KPPL_PURITY_SELF = "2";
   static final String AUTH_CONNECT_STRING = "AUTH_CONNECT_STRING";
   static final String DRIVER_NAME_DEFAULT = "jdbcthin";
   static final int KPU_LIB_UNKN = 0;
   static final int KPU_LIB_DEF = 1;
   static final int KPU_LIB_EI = 2;
   static final int KPU_LIB_XE = 3;
   static final int KPU_LIB_ICUS = 4;
   static final int KPU_LIB_OCI = 5;
   static final int KPU_LIB_THIN = 10;
   static final String AUTH_ORA_EDITION = "AUTH_ORA_EDITION";
   static final String AUTH_COPYRIGHT = "AUTH_COPYRIGHT";
   static final String COPYRIGHT_STR = "\"Oracle\nEverybody follows\nSpeedy bits exchange\nStars await to glow\"\nThe preceding key is copyrighted by Oracle Corporation.\nDuplication of this key is not allowed without permission\nfrom Oracle Corporation. Copyright 2003 Oracle Corporation.";
   static final String SESSION_TIME_ZONE = "SESSION_TIME_ZONE";
   static final String SESSION_NLS_LXCCHARSET = "SESSION_NLS_LXCCHARSET";
   static final String SESSION_NLS_LXCNLSLENSEM = "SESSION_NLS_LXCNLSLENSEM";
   static final String SESSION_NLS_LXCNCHAREXCP = "SESSION_NLS_LXCNCHAREXCP";
   static final String SESSION_NLS_LXCNCHARIMP = "SESSION_NLS_LXCNCHARIMP";
   public static final int AUTH_FLAG_O5LOGON = 0;
   public static final int AUTH_FLAG_NONO5LOGON = 1;
   String sessionTimeZone = null;
   byte[] serverCompileTimeCapabilities = null;
   private T4CKvaldfList keyValList = null;
   private byte[] user = null;
   private long logonMode;
   private byte[][] outKeys = (byte[][]) null;
   private byte[][] outValues = (byte[][]) null;
   private int[] outFlags = new int[0];
   private int outNbPairs = 0;
   O5Logon o5logonHelper = new O5Logon();
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoauthenticate(T4CConnection var1, String var2, byte[] var3) throws SQLException {
      super(var1, (byte) 3);
      this.ressourceManagerId = var2;
      this.serverCompileTimeCapabilities = var3;
      this.setSessionFields(var1);
      this.isSessionTZ = true;
      this.bUseO5Logon = false;
   }

   void marshal() throws IOException {
      if (this.user != null && this.user.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalSB4(this.user.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSB4(0);
      }

      this.meg.marshalUB4(this.logonMode);
      this.meg.marshalPTR();
      this.meg.marshalUB4((long) this.keyValList.size());
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      if (this.user != null && this.user.length > 0) {
         this.meg.marshalCHR(this.user);
      }

      this.meg.marshalKEYVAL(this.keyValList.getKeys(), this.keyValList.getValues(), this.keyValList.getFlags(),
            this.keyValList.size());
   }

   private void doOAUTHRPC(byte[] username, byte[] AUTH_PASSWORD, long logonMode, String RADIUS, boolean var6,
         byte[] var7, byte[] var8, byte[][] var9, int var10, int var11) throws IOException, SQLException {
      System.out.println("doOAUTHRPC");
      this.setFunCode((short) 115);
      this.user = username;
      this.logonMode = logonMode | 1L;
      if (var6) {
         this.logonMode |= 1024L;
      }

      if (username != null && username.length != 0 && AUTH_PASSWORD != null && RADIUS != "RADIUS") {
         this.logonMode |= 256L;
      }

      this.keyValList = new T4CKvaldfList(this.meg.conv);
      if (AUTH_PASSWORD != null) {
         this.keyValList.add("AUTH_PASSWORD", AUTH_PASSWORD);
      }

      if (var9 != null) {
         for (int var12 = 0; var12 < var9.length; ++var12) {
            this.keyValList.add("INITIAL_CLIENT_ROLE", var9[var12]);
         }
      }

      if (var7 != null) {
         this.keyValList.add("AUTH_CLIENT_DISTINGUISHED_NAME", var7);
      }

      if (var8 != null) {
         this.keyValList.add("AUTH_CLIENT_CERTIFICATE", var8);
      }

      this.keyValList.add("AUTH_TERMINAL", this.terminal);
      if (this.bUseO5Logon && this.encryptedKB != null) {
         this.keyValList.add((String) "AUTH_SESSKEY", this.encryptedKB, (byte) 1);
      }

      if (this.programName != null) {
         this.keyValList.add("AUTH_PROGRAM_NM", this.programName);
      }

      if (this.clientname != null) {
         this.keyValList.add("PROXY_CLIENT_NAME", this.clientname);
      }

      this.keyValList.add("AUTH_MACHINE", this.machine);
      this.keyValList.add("AUTH_PID", this.processID);
      if (!this.ressourceManagerId.equals("0000")) {
         byte[] var13 = this.meg.conv.StringToCharBytes("AUTH_INTERNALNAME_");
         var13[var13.length - 1] = 0;
         this.keyValList.add(var13, this.internalName);
         var13 = this.meg.conv.StringToCharBytes("AUTH_EXTERNALNAME_");
         var13[var13.length - 1] = 0;
         this.keyValList.add(var13, this.externalName);
      }

      this.keyValList.add("AUTH_ACL", this.aclValue);
      this.keyValList.add((String) "AUTH_ALTER_SESSION", this.alterSession, (byte) 1);
      if (this.editionName != null) {
         this.keyValList.add("AUTH_ORA_EDITION", this.editionName);
      }

      this.keyValList.add("SESSION_CLIENT_LOBATTR", this.enableTempLobRefCnt);
      this.keyValList.add("SESSION_CLIENT_DRIVER_NAME", this.driverName);
      this.keyValList.add("SESSION_CLIENT_VERSION", this.meg.conv.StringToCharBytes(
            Integer.toString(this.versionStringToInt(this.connection.getMetaData().getDriverVersion()), 10)));
      if (var10 != -1) {
         this.keyValList.add("AUTH_SESSION_ID", this.meg.conv.StringToCharBytes(Integer.toString(var10)));
      }

      if (var11 != -1) {
         this.keyValList.add("AUTH_SERIAL_NUM", this.meg.conv.StringToCharBytes(Integer.toString(var11)));
      }

      if (this.connection.drcpEnabled) {
         this.keyValList.add("AUTH_KPPL_CONN_CLASS",
               this.meg.conv.StringToCharBytes(this.connection.drcpConnectionClass));
         this.keyValList.add("AUTH_KPPL_PURITY", this.meg.conv.StringToCharBytes("2"));
         if (this.connection.drcpTagName != null) {
            this.keyValList.add("AUTH_KPPL_TAG", this.meg.conv.StringToCharBytes(this.connection.drcpTagName));
         }
      }

      this.keyValList.add("AUTH_CONNECT_STRING",
            this.meg.conv.StringToCharBytes(this.connection.net.getConnectionString()));
      this.keyValList.add("AUTH_COPYRIGHT", this.meg.conv.StringToCharBytes(
            "\"Oracle\nEverybody follows\nSpeedy bits exchange\nStars await to glow\"\nThe preceding key is copyrighted by Oracle Corporation.\nDuplication of this key is not allowed without permission\nfrom Oracle Corporation. Copyright 2003 Oracle Corporation."));
      this.outNbPairs = 0;
      this.outKeys = (byte[][]) null;
      this.outValues = (byte[][]) null;
      this.outFlags = new int[0];
      this.doRPC();
   }

   void doOSESSKEY(String username, long logonMode) throws IOException, SQLException {
      this.setFunCode((short) 118);
      this.user = this.meg.conv.StringToCharBytes(username);
      this.logonMode = logonMode | 1L;
      this.keyValList = new T4CKvaldfList(this.meg.conv);
      this.keyValList.add("AUTH_TERMINAL", this.terminal);
      if (this.programName != null) {
         this.keyValList.add("AUTH_PROGRAM_NM", this.programName);
      }

      this.keyValList.add("AUTH_MACHINE", this.machine);
      this.keyValList.add("AUTH_PID", this.processID);
      this.keyValList.add("AUTH_SID", this.sysUserName);
      this.outNbPairs = 0;
      this.outKeys = (byte[][]) null;
      this.outValues = (byte[][]) null;
      this.outFlags = new int[0];
      this.doRPC();
   }

   void readRPA() throws IOException, SQLException {
      this.outNbPairs = this.meg.unmarshalUB2();
      this.outKeys = new byte[this.outNbPairs][];
      this.outValues = new byte[this.outNbPairs][];
      this.outFlags = this.meg.unmarshalKEYVAL(this.outKeys, this.outValues, this.outNbPairs);
   }

   void processError() throws SQLException {
      if (this.getFunCode() == 118) {
         if (this.oer.getRetCode() != 28035 || this.connection.net.getAuthenticationAdaptorName() != "RADIUS") {
            this.oer.processError();
         }
      } else {
         super.processError();
      }

   }

   protected void processRPA() throws SQLException {
      int var2;
      String var4;
      int var10;
      if (this.getFunCode() == 115) {
         Properties var1 = new Properties();

         for (var2 = 0; var2 < this.outNbPairs; ++var2) {
            String var3 = this.meg.conv.CharBytesToString(this.outKeys[var2], this.outKeys[var2].length).trim();
            var4 = "";
            if (this.outValues[var2] != null) {
               var4 = this.meg.conv.CharBytesToString(this.outValues[var2], this.outValues[var2].length).trim();
            }

            var1.setProperty(var3, var4);
         }

         String var8 = var1.getProperty("AUTH_VERSION_NO");
         if (var8 != null) {
            try {
               var10 = new Integer(var8);
            } catch (NumberFormatException var5) {
            }
         }

         var1.setProperty("SERVER_HOST", var1.getProperty("AUTH_SC_SERVER_HOST", ""));
         var1.setProperty("INSTANCE_NAME", var1.getProperty("AUTH_SC_INSTANCE_NAME", ""));
         var1.setProperty("DATABASE_NAME", var1.getProperty("AUTH_SC_DBUNIQUE_NAME", ""));
         var1.setProperty("SERVICE_NAME", var1.getProperty("AUTH_SC_SERVICE_NAME", ""));
         var1.setProperty("SESSION_TIME_ZONE", this.sessionTimeZone);
         this.connection.sessionProperties = var1;
      } else if (this.getFunCode() == 118 && this.connection.net.getAuthenticationAdaptorName() != "RADIUS") {
         if (this.outKeys == null || this.outKeys.length < 1) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 438);
            var9.fillInStackTrace();
            throw var9;
         }

         int var7 = -1;
         var2 = -1;

         try {
            for (var10 = 0; var10 < this.outKeys.length; ++var10) {
               var4 = new String(this.outKeys[var10], "US-ASCII");
               if (var4.equals("AUTH_SESSKEY")) {
                  var7 = var10;
               } else if (var4.equals("AUTH_VFR_DATA")) {
                  var2 = var10;
               }

               if (var2 != -1 && var7 != -1) {
                  break;
               }
            }
         } catch (UnsupportedEncodingException var6) {
         }

         SQLException var11;
         if (var7 == -1) {
            var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 438);
            var11.fillInStackTrace();
            throw var11;
         }

         this.encryptedSK = this.outValues[var7];
         if (var2 != -1) {
            this.bUseO5Logon = true;
            this.salt = this.outValues[var2];
            this.verifierType = this.outFlags[var2];
         }

         if (!this.bUseO5Logon && (this.encryptedSK == null || this.encryptedSK.length != 16)) {
            var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 438);
            var11.fillInStackTrace();
            throw var11;
         }
      }

   }

   void doOAUTH(String username, String password, long logon_mode) throws IOException, SQLException {
      byte[] username_byte = null;
      if (username != null && username.length() > 0) {
         username_byte = this.meg.conv.StringToCharBytes(username);
      }

      byte[] password_byte = null;
      Object var7 = null;
      byte[] AUTH_PASSWORD = null;
      String RADIUS = this.connection.net.getAuthenticationAdaptorName();
      SQLException err;
      if (username != null && username.length() != 0) {
         if (RADIUS != "RADIUS" && this.encryptedSK.length > 16 && !this.bUseO5Logon) {
            err = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 413);
            err.fillInStackTrace();
            throw err;
         }

         if (this.bUseO5Logon
               && (this.encryptedSK == null || this.encryptedSK.length != 64 && this.encryptedSK.length != 96)) {
            err = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 413);
            err.fillInStackTrace();
            throw err;
         }

         String var11 = username.trim();
         String var12 = null;
         if (password != null) {
            var12 = password.trim();
         }

         password = null;
         String username_fixed = var11;
         String password_fixed = var12;
         if (var11.startsWith("\"") || var11.endsWith("\"")) {
            username_fixed = this.removeQuotes(var11);
         }

         if (var12 != null && var12.startsWith("\"") && var12.endsWith("\"")) {
            password_fixed = this.removeQuotes(var12);
         }

         if (password_fixed != null) {
            password_byte = this.meg.conv.StringToCharBytes(password_fixed);
         }

         byte var10;
         byte[] var21;
         if (RADIUS != "RADIUS") {
            if (password_byte == null) {
               AUTH_PASSWORD = null;
            } else {
               byte[] empty_256_bytes;
               if (this.bUseO5Logon) {
                  if (this.verifierType != 2361 && this.verifierType != 40674 && this.verifierType != 59694
                        && this.verifierType != 45394 && this.verifierType != 6949 && this.verifierType != 18453) {
                     SQLException sqlErr = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(),
                           451);
                     sqlErr.fillInStackTrace();
                     throw sqlErr;
                  }

                  this.encryptedKB = new byte[this.encryptedSK.length];

                  for (int i = 0; i < this.encryptedKB.length; ++i) {
                     this.encryptedKB[i] = 1;
                  }

                  int[] len_64 = new int[1];
                  empty_256_bytes = new byte[256];

                  for (int i = 0; i < 256; ++i) {
                     empty_256_bytes[i] = 0;
                  }
                  len_64[0] = 64;

                  try {
                     System.out.printf("encryptedSK: %s\n", Arrays.toString(this.encryptedSK));
                     this.o5logonHelper.generateOAuthResponse(this.verifierType, this.salt, username_fixed,
                           password_fixed, password_byte, this.encryptedSK, this.encryptedKB, empty_256_bytes, len_64,
                           this.meg.conv.isServerCSMultiByte, this.serverCompileTimeCapabilities[4]);
                  } catch (Exception var20) {
                  }
                  AUTH_PASSWORD = new byte[len_64[0]];
                  System.arraycopy(empty_256_bytes, 0, AUTH_PASSWORD, 0, len_64[0]);
               } else {
                  O3LoginClientHelper var27 = new O3LoginClientHelper(this.meg.conv.isServerCSMultiByte);
                  empty_256_bytes = var27.getSessionKey(username_fixed, password_fixed, this.encryptedSK);
                  if (password_byte.length % 8 > 0) {
                     var10 = (byte) (8 - password_byte.length % 8);
                  } else {
                     var10 = 0;
                  }

                  var21 = new byte[password_byte.length + var10];
                  System.arraycopy(password_byte, 0, var21, 0, password_byte.length);
                  byte[] var30 = var27.getEPasswd(empty_256_bytes, var21);
                  AUTH_PASSWORD = new byte[2 * var21.length + 1];
                  if (AUTH_PASSWORD.length < 2 * var30.length) {
                     SQLException var18 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(),
                           413);
                     var18.fillInStackTrace();
                     throw var18;
                  }

                  RepConversion.bArray2Nibbles(var30, AUTH_PASSWORD);
                  AUTH_PASSWORD[AUTH_PASSWORD.length - 1] = RepConversion.nibbleToHex(var10);
               }
            }
         } else if (password_byte != null) {
            if (this.connection.net.getSessionAttributes().getNTAdapter() instanceof TcpsNTAdapter) {
               AUTH_PASSWORD = password_byte;
            } else {
               if ((password_byte.length + 1) % 8 > 0) {
                  var10 = (byte) (8 - (password_byte.length + 1) % 8);
               } else {
                  var10 = 0;
               }

               var21 = new byte[password_byte.length + 1 + var10];
               System.arraycopy(password_byte, 0, var21, 0, password_byte.length);
               byte[] var28 = AuthenticationService.obfuscatePasswordForRadius(var21);
               AUTH_PASSWORD = new byte[var28.length * 2];

               for (int var32 = 0; var32 < var28.length; ++var32) {
                  byte var29 = (byte) ((var28[var32] & 240) >> 4);
                  byte var31 = (byte) (var28[var32] & 15);
                  AUTH_PASSWORD[var32 * 2] = (byte) (var29 < 10 ? var29 + 48 : var29 - 10 + 97);
                  AUTH_PASSWORD[var32 * 2 + 1] = (byte) (var31 < 10 ? var31 + 48 : var31 - 10 + 97);
               }
            }
         }
      }
      // System.out.printf("username_byte:%s, AUTH_PASSWORD:%s, logon_mode\n",username_byte, AUTH_PASSWORD, logon_mode);
      this.doOAUTHRPC(username_byte, AUTH_PASSWORD, logon_mode, RADIUS, false, (byte[]) null, (byte[]) null,
            (byte[][]) null, -1, -1);
      if (RADIUS != "RADIUS" && this.bUseO5Logon) {
         String AUTH_SVR_RESPONSE = this.connection.sessionProperties.getProperty("AUTH_SVR_RESPONSE");

         System.out.printf("AUTH_SVR_RESPONSE: %s\n",AUTH_SVR_RESPONSE);
         try {
            if (!this.o5logonHelper.validateServerIdentity(AUTH_SVR_RESPONSE)) {
               err = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 452);
               err.fillInStackTrace();
               throw err;
            }
         } catch (Exception var19) {
            SQLException err2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 452);
            err2.fillInStackTrace();
            throw err2;
         }
      }
   }

   void doOAUTH(int var1, Properties var2, int var3, int var4) throws IOException, SQLException {
      byte[] var5 = null;
      byte[] var6 = null;
      String[] var7 = null;
      byte[][] PROXY_ROLES_bytes = (byte[][]) null;
      byte[] var9 = null;
      String PROXY_USER_NAME;
      String PROXY_USER_PASSWORD;
      if (var1 == 1) {
         PROXY_USER_NAME = var2.getProperty("PROXY_USER_NAME");
         PROXY_USER_PASSWORD = var2.getProperty("PROXY_USER_PASSWORD");
         if (PROXY_USER_PASSWORD != null) {
            PROXY_USER_NAME = PROXY_USER_NAME + "/" + PROXY_USER_PASSWORD;
         }

         var9 = this.meg.conv.StringToCharBytes(PROXY_USER_NAME);
      } else if (var1 == 2) {
         PROXY_USER_NAME = var2.getProperty("PROXY_DISTINGUISHED_NAME");
         var5 = this.meg.conv.StringToCharBytes(PROXY_USER_NAME);
      } else {
         try {
            var6 = (byte[]) ((byte[]) var2.get("PROXY_CERTIFICATE"));
            StringBuffer var16 = new StringBuffer();

            for (int var13 = 0; var13 < var6.length; ++var13) {
               PROXY_USER_PASSWORD = Integer.toHexString(255 & var6[var13]);
               int var12 = PROXY_USER_PASSWORD.length();
               if (var12 == 0) {
                  var16.append("00");
               } else if (var12 == 1) {
                  var16.append('0');
                  var16.append(PROXY_USER_PASSWORD);
               } else {
                  var16.append(PROXY_USER_PASSWORD);
               }
            }

            var6 = var16.toString().getBytes();
         } catch (Exception var15) {
         }
      }

      try {
         var7 = (String[]) ((String[]) var2.get("PROXY_ROLES"));
      } catch (Exception var14) {
      }

      if (var7 != null) {
         PROXY_ROLES_bytes = new byte[var7.length][];

         for (int i = 0; i < var7.length; ++i) {
            PROXY_ROLES_bytes[i] = this.meg.conv.StringToCharBytes(var7[i]);
         }
      }

      this.doOAUTHRPC(var9, (byte[]) null, 0L, (String) null, true, var5, var6, PROXY_ROLES_bytes, var3, var4);
   }

   private void setSessionFields(T4CConnection var1) throws SQLException {
      String var2 = this.connection.thinVsessionTerminal;
      String var3 = this.connection.thinVsessionMachine;
      String var4 = this.connection.thinVsessionOsuser;
      String var5 = this.connection.thinVsessionProgram;
      String var6 = this.connection.thinVsessionProcess;
      String var7 = this.connection.thinVsessionIname;
      String var8 = this.connection.thinVsessionEname;
      String var9 = this.connection.proxyClientName;
      String var10 = this.connection.driverNameAttribute;
      String var11 = this.connection.editionName;
      if (this.connection.enableTempLobRefCnt) {
         this.enableTempLobRefCnt = (new String("1")).getBytes();
      } else {
         this.enableTempLobRefCnt = (new String("0")).getBytes();
      }

      if (var3 == null) {
         try {
            var3 = InetAddress.getLocalHost().getHostName();
         } catch (Exception var18) {
            var3 = "jdbcclient";
         }
      }

      if (var8 == null) {
         var8 = "jdbc_" + this.ressourceManagerId;
      }

      if (var10 == null) {
         var10 = "jdbcthin";
      }

      this.terminal = this.meg.conv.StringToCharBytes(var2);
      this.machine = this.meg.conv.StringToCharBytes(var3);
      this.sysUserName = this.meg.conv.StringToCharBytes(var4);
      this.programName = this.meg.conv.StringToCharBytes(var5);
      this.processID = this.meg.conv.StringToCharBytes(var6);
      this.internalName = this.meg.conv.StringToCharBytes(var7);
      this.externalName = this.meg.conv.StringToCharBytes(var8);
      if (var9 != null) {
         this.clientname = this.meg.conv.StringToCharBytes(var9);
      }

      if (var11 != null) {
         this.editionName = this.meg.conv.StringToCharBytes(var11);
      }

      this.driverName = this.meg.conv.StringToCharBytes(var10);
      TimeZone var13 = TimeZone.getDefault();
      String timezone = var13.getID();// Asia/Shanghai
      if (!ZONEIDMAP.isValidRegion(timezone) || !var1.timezoneAsRegion) {
         int var15 = var13.getOffset(System.currentTimeMillis());
         int var16 = var15 / 3600000;
         int maybe_hour = var15 / '\uea60' % 60;
         timezone = (var16 < 0 ? "" + var16 : "+" + var16) + (maybe_hour < 10 ? ":0" + maybe_hour : ":" + maybe_hour);
      }

      this.sessionTimeZone = timezone;
      var1.sessionTimeZone = timezone;
      String var19 = CharacterSetMetaData.getNLSLanguage(Locale.getDefault(Category.FORMAT));
      String var20 = CharacterSetMetaData.getNLSTerritory(Locale.getDefault(Category.FORMAT));
      if (var19 != null && var20 != null) {
         this.alterSession = this.meg.conv.StringToCharBytes(
               "ALTER SESSION SET " + (this.isSessionTZ ? "TIME_ZONE='" + this.sessionTimeZone + "'" : "")
                     + " NLS_LANGUAGE='" + var19 + "' NLS_TERRITORY='" + var20 + "' ");
         this.aclValue = this.meg.conv.StringToCharBytes("4400");
         this.alterSession[this.alterSession.length - 1] = 0;
      } else {
         SQLException var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 176);
         var21.fillInStackTrace();
         throw var21;
      }
   }

   String removeQuotes(String var1) {
      int var2 = 0;
      int var3 = var1.length() - 1;

      int var4;
      for (var4 = 0; var4 < var1.length(); ++var4) {
         if (var1.charAt(var4) != '"') {
            var2 = var4;
            break;
         }
      }

      for (var4 = var1.length() - 1; var4 >= 0; --var4) {
         if (var1.charAt(var4) != '"') {
            var3 = var4;
            break;
         }
      }

      String var5 = var1.substring(var2, var3 + 1);
      return var5;
   }

   private int versionStringToInt(String var1) throws SQLException {
      String[] var2 = var1.split("\\.");
      int var3 = Integer.parseInt(var2[0].replaceAll("\\D", ""));
      int var4 = Integer.parseInt(var2[1].replaceAll("\\D", ""));
      int var5 = Integer.parseInt(var2[2].replaceAll("\\D", ""));
      int var6 = Integer.parseInt(var2[3].replaceAll("\\D", ""));
      int var7 = Integer.parseInt(var2[4].replaceAll("\\D", ""));
      int var8 = var3 << 24 | var4 << 20 | var5 << 12 | var6 << 8 | var7;
      return var8;
   }

   private String versionIntToString(int var1) throws SQLException {
      int var2 = (var1 & -16777216) >> 24 & 255;
      int var3 = (var1 & 15728640) >> 20 & 255;
      int var4 = (var1 & 1044480) >> 12 & 255;
      int var5 = (var1 & 3840) >> 8 & 255;
      int var6 = var1 & 255;
      String var7 = "" + var2 + "." + var3 + "." + var4 + "." + var5 + "." + var6;
      return var7;
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }

   public byte[] getDerivedKeyJdbc(byte[] var1, int var2)
         throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
      if (this.verifierType == 2361) {
         var2 |= 1;
      } else {
         var2 |= 0;
      }

      return this.o5logonHelper.getDerivedKey(var1, var2);
   }
}
