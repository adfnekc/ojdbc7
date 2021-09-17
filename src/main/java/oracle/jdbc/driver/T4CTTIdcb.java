package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.oracore.OracleTypeADT;

class T4CTTIdcb extends T4CTTIMsg {
   static final int DCBRXFR = 1;
   static final int DCBFIOT = 2;
   static final int DCBFHAVECOOKIE = 4;
   static final int DCBFNEWCOOKIE = 8;
   static final int DCBFREM = 16;
   int numuds;
   int colOffset;
   byte[] ignoreBuff = new byte[40];
   OracleStatement statement = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIdcb(T4CConnection var1) {
      super(var1, (byte)16);
   }

   void init(OracleStatement var1, int var2) {
      this.statement = var1;
      this.colOffset = var2;
   }

   Accessor[] receive(Accessor[] var1) throws SQLException, IOException {
      short var2 = this.meg.unmarshalUB1();
      if (this.ignoreBuff.length < var2) {
         this.ignoreBuff = new byte[var2];
      }

      this.meg.unmarshalNBytes(this.ignoreBuff, 0, var2);
      int var3 = (int)this.meg.unmarshalUB4();
      var1 = this.receiveCommon(var1, false);
      return var1;
   }

   Accessor[] receiveFromRefCursor(Accessor[] var1) throws SQLException, IOException {
      short var2 = this.meg.unmarshalUB1();
      int var3 = (int)this.meg.unmarshalUB4();
      var1 = this.receiveCommon(var1, false);
      return var1;
   }

   Accessor[] receiveCommon(Accessor[] var1, boolean var2) throws SQLException, IOException {
      if (var2) {
         this.numuds = this.meg.unmarshalUB2();
      } else {
         this.numuds = (int)this.meg.unmarshalUB4();
         if (this.numuds > 0) {
            short var3 = this.meg.unmarshalUB1();
         }
      }

      if (this.statement.needToPrepareDefineBuffer && (var1 == null || var1.length != this.numuds + this.colOffset)) {
         Accessor[] var13 = new Accessor[this.numuds + this.colOffset];
         if (var1 != null && var1.length == this.colOffset) {
            System.arraycopy(var1, 0, var13, 0, this.colOffset);
         }

         var1 = var13;
      }

      T4C8TTIuds var14 = new T4C8TTIuds((T4CConnection)this.statement.connection);
      long var5 = this.statement.checkSum;

      for(int var7 = 0; var7 < this.numuds; ++var7) {
         var14.unmarshal();
         String var4 = this.meg.conv.CharBytesToString(var14.getColumName(), var14.getColumNameByteLength());
         if (this.statement.needToPrepareDefineBuffer) {
            var5 = this.fillupAccessors(var1, this.colOffset + var7, var14, var4, var5);
         }
      }

      this.statement.checkSum = var5;
      if (!var2) {
         byte[] var15 = this.meg.unmarshalDALC();
         if (this.connection.getTTCVersion() >= 3) {
            int var8 = (int)this.meg.unmarshalUB4();
            int var9 = (int)this.meg.unmarshalUB4();
            if (this.connection.getTTCVersion() >= 4) {
               int var10 = (int)this.meg.unmarshalUB4();
               int var11 = (int)this.meg.unmarshalUB4();
               if (this.connection.getTTCVersion() >= 5) {
                  byte[] var12 = this.meg.unmarshalDALC();
               }
            }
         }
      }

      if (this.statement.needToPrepareDefineBuffer && !var2) {
         this.statement.rowPrefetchInLastFetch = -1;
         this.statement.describedWithNames = true;
         this.statement.described = true;
         this.statement.numberOfDefinePositions = this.numuds;
         this.statement.accessors = var1;
         this.statement.prepareAccessors();
         this.statement.allocateTmpByteArray();
      }

      return var1;
   }

   long fillupAccessors(Accessor[] var1, int var2, T4C8TTIuds var3, String var4, long var5) throws SQLException {
      int[] var7 = this.statement.definedColumnType;
      int[] var8 = this.statement.definedColumnSize;
      int[] var9 = this.statement.definedColumnFormOfUse;
      int var10 = this.statement.isRowidPrepended ? 1 : 0;
      String var12 = null;
      String var13 = null;
      String var14 = null;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      if (var2 >= var10) {
         int var20 = var2 - var10;
         if (var7 != null && var7.length > var20 && var7[var20] != 0) {
            var17 = var7[var20];
         }

         if (var8 != null && var8.length > var20 && var8[var20] > 0) {
            var18 = var8[var20];
         }

         if (var9 != null && var9.length > var20 && var9[var20] > 0) {
            var19 = var9[var20];
         }
      }

      int var15 = var3.udsoac.oacmxl;
      int var16;
      byte var22;
      switch(var3.udsoac.oacdty) {
      case 1:
         if (var3.udsoac.oacmxlc != 0 && var3.udsoac.oacmxlc < var15) {
            var15 = 2 * var3.udsoac.oacmxlc;
         }

         var16 = var15;
         if ((var17 == 1 || var17 == 12) && var18 > 0 && var18 < var15) {
            var16 = var18;
         }

         var1[var2] = new T4CVarcharAccessor(this.statement, var16, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var15, var17, var18, this.meg);
         if ((var3.udsoac.oacfl2 & 4096) == 4096 || var3.udsoac.oacmxlc != 0) {
            var1[var2].setDisplaySize(var3.udsoac.oacmxlc);
         }
         break;
      case 2:
         var1[var2] = new T4CNumberAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 6:
         var1[var2] = new T4CVarnumAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 8:
         if (this.statement.isFetchStreams || (var17 == 1 || var17 == 12) && this.connection.versionNumber >= 9000 && var18 < 4001) {
            if (var18 > 0) {
               var16 = var18;
            } else {
               var16 = 32767;
            }

            var22 = -1;
            var1[var2] = new T4CVarcharAccessor(this.statement, var16, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var22, var17, var18, this.meg);
            var1[var2].describeType = 8;
         } else {
            byte var23 = 0;
            var1[var2] = new T4CLongAccessor(this.statement, var2 + 1, var23, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         }
         break;
      case 11:
      case 104:
      case 208:
         var1[var2] = new T4CRowidAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         if (var3.udsoac.oacdty == 208) {
            var1[var2].describeType = 208;
         }
         break;
      case 12:
         var1[var2] = new T4CDateAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 23:
         var1[var2] = new T4CRawAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 24:
         if (!this.statement.isFetchStreams && (var17 != -2 || var18 >= 2001 || this.connection.versionNumber < 9000)) {
            var1[var2] = new T4CLongRawAccessor(this.statement, var2 + 1, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         } else {
            var22 = -1;
            var1[var2] = new T4CRawAccessor(this.statement, var22, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
            var1[var2].describeType = 24;
         }
         break;
      case 96:
         if (var3.udsoac.oacmxlc != 0 && var3.udsoac.oacmxlc < var15) {
            var15 = 2 * var3.udsoac.oacmxlc;
         }

         var16 = var15;
         if ((var17 == 1 || var17 == 12) && var18 > 0 && var18 < var15) {
            var16 = var18;
         }

         var1[var2] = new T4CCharAccessor(this.statement, var16, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var15, var17, var18, this.meg);
         if ((var3.udsoac.oacfl2 & 4096) == 4096 || var3.udsoac.oacmxlc != 0) {
            var1[var2].setDisplaySize(var3.udsoac.oacmxlc);
         }
         break;
      case 100:
         var1[var2] = new T4CBinaryFloatAccessor(this.statement, 4, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 101:
         var1[var2] = new T4CBinaryDoubleAccessor(this.statement, 8, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 102:
         var1[var2] = new T4CResultSetAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 109:
         var12 = this.meg.conv.CharBytesToString(var3.getTypeName(), var3.getTypeCharLength());
         var13 = this.meg.conv.CharBytesToString(var3.getSchemaName(), var3.getSchemaCharLength());
         var14 = var13 + "." + var12;
         var1[var2] = new T4CNamedTypeAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var14, var17, var18, this.meg);
         break;
      case 111:
         var12 = this.meg.conv.CharBytesToString(var3.getTypeName(), var3.getTypeCharLength());
         var13 = this.meg.conv.CharBytesToString(var3.getSchemaName(), var3.getSchemaCharLength());
         var14 = var13 + "." + var12;
         var1[var2] = new T4CRefTypeAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var14, var17, var18, this.meg);
         break;
      case 112:
         short var24 = 1;
         if (var19 != 0) {
            var24 = (short)var19;
         }

         if ((var17 == -1 || var17 == -16) && this.connection.versionNumber >= 9000) {
            boolean var21 = false;
            var1[var2] = new T4CLongAccessor(this.statement, var2 + 1, Integer.MAX_VALUE, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var24, var17, var18, this.meg);
            var1[var2].describeType = 112;
         } else if ((var17 == 12 || var17 == 1 || var17 == -15 || var17 == -9) && this.connection.versionNumber >= 9000) {
            var16 = 32767;
            if (var18 > 0 && var18 < var16) {
               var16 = var18;
            }

            var1[var2] = new T4CVarcharAccessor(this.statement, var16, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var24, 32767, var17, var18, this.meg);
            var1[var2].describeType = 112;
         } else {
            var1[var2] = new T4CClobAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
            if (!this.connection.useLobPrefetch || var17 != 2005 && var17 != 2011) {
               var1[var2].setNoPrefetch();
            } else {
               var1[var2].setPrefetchLength(var18);
            }
         }
         break;
      case 113:
         if (var17 == -4 && this.connection.versionNumber >= 9000) {
            var1[var2] = new T4CLongRawAccessor(this.statement, var2 + 1, Integer.MAX_VALUE, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
            var1[var2].describeType = 113;
         } else if (var17 == -3 && this.connection.versionNumber >= 9000) {
            var1[var2] = new T4CRawAccessor(this.statement, 4000, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
            var1[var2].describeType = 113;
         } else {
            var1[var2] = new T4CBlobAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
            if (this.connection.useLobPrefetch && var17 == 2004) {
               var1[var2].setPrefetchLength(var18);
            } else {
               var1[var2].setNoPrefetch();
            }
         }
         break;
      case 114:
         var1[var2] = new T4CBfileAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         if (this.connection.useLobPrefetch && var17 == -13) {
            var1[var2].setPrefetchLength(var18);
         } else {
            var1[var2].setNoPrefetch();
         }
         break;
      case 180:
         var1[var2] = new T4CTimestampAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 181:
         var1[var2] = new T4CTimestamptzAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 182:
         var1[var2] = new T4CIntervalymAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 183:
         var1[var2] = new T4CIntervaldsAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      case 231:
         var1[var2] = new T4CTimestampltzAccessor(this.statement, var15, var3.udsnull, var3.udsoac.oacflg, var3.udsoac.oacpre, var3.udsoac.oacscl, var3.udsoac.oacfl2, var3.udsoac.oacmal, var3.udsoac.oaccsfrm, var17, var18, this.meg);
         break;
      default:
         assert false : "ud.udsoac.oacdty: " + var3.udsoac.oacdty;

         var1[var2] = null;
      }

      if (var3.udsoac.oactoid.length > 0) {
         var1[var2].internalOtype = new OracleTypeADT(var3.udsoac.oactoid, var3.udsoac.oacvsn, var3.udsoac.oaccsi, var3.udsoac.oaccsfrm, var13 + "." + var12);
      } else {
         var1[var2].internalOtype = null;
      }

      var1[var2].columnName = var4;
      var1[var2].securityAttribute = oracle.jdbc.OracleResultSetMetaData.SecurityAttribute.NONE;
      if ((var3.udsflg & 1) != 0) {
         var1[var2].securityAttribute = oracle.jdbc.OracleResultSetMetaData.SecurityAttribute.ENABLED;
      } else if ((var3.udsflg & 2) != 0) {
         var1[var2].securityAttribute = oracle.jdbc.OracleResultSetMetaData.SecurityAttribute.UNKNOWN;
      }

      var1[var2].setColumnInvisible((var3.udsflg & 8) != 0);
      if (var3.udsoac.oacmxl == 0) {
         var1[var2].isNullByDescribe = true;
      }

      var1[var2].udskpos = var3.getKernelPosition();
      if (this.connection.checksumMode.needToCalculateFetchChecksum()) {
         CRC64 var10000 = PhysicalConnection.CHECKSUM;
         var5 = CRC64.updateChecksum(var5, (long)var3.udsoac.oacdty);
         var10000 = PhysicalConnection.CHECKSUM;
         var5 = CRC64.updateChecksum(var5, (long)var3.udsoac.oacmxl);
         var10000 = PhysicalConnection.CHECKSUM;
         var5 = CRC64.updateChecksum(var5, (long)var3.udsoac.oacpre);
         var10000 = PhysicalConnection.CHECKSUM;
         var5 = CRC64.updateChecksum(var5, (long)var3.udsoac.oacscl);
         var10000 = PhysicalConnection.CHECKSUM;
         var5 = CRC64.updateChecksum(var5, (long)var3.udsoac.oaccsfrm);
         if (var12 != null) {
            var10000 = PhysicalConnection.CHECKSUM;
            var5 = CRC64.updateChecksum(var5, var13 + "." + var12);
         }

         var10000 = PhysicalConnection.CHECKSUM;
         var5 = CRC64.updateChecksum(var5, var4);
      }

      return var5;
   }
}
