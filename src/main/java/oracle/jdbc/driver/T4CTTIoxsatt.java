package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValueLong;
import oracle.jdbc.internal.XSKeyval;
import oracle.jdbc.internal.XSNamespace;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSSecureId;
import oracle.sql.TIMESTAMPTZ;

final class T4CTTIoxsatt extends T4CTTIfun {
   private int opcode;
   private byte[] sessionId;
   private XSSecureId sidp;
   private byte[] cookie;
   private XSPrincipal username;
   private byte[][] disabledRolesBytes;
   private byte[][] enabledRolesBytes;
   private byte[][] externalRolesBytes;
   private XSNamespace[] namespaces;
   private XSNamespace[] cacheNamespace;
   private XSNamespace[] deleteNamespace;
   private TIMESTAMPTZ midTierTimestamp;
   private TIMESTAMPTZ authtime;
   private int roleVersion;
   private long inputFlag;
   private XSKeyval kv;
   private int[] roleVersionOutput;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoxsatt(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)180);
   }

   void doOXSATT(int var1, byte[] var2, XSSecureId var3, byte[] var4, XSPrincipal var5, String[] var6, String[] var7, String[] var8, XSNamespace[] var9, XSNamespace[] var10, XSNamespace[] var11, TIMESTAMPTZ var12, TIMESTAMPTZ var13, int var14, long var15, XSKeyval var17, int[] var18) throws IOException, SQLException {
      this.opcode = var1;
      this.sessionId = var2;
      this.sidp = var3;
      this.cookie = var4;
      this.username = var5;
      if (var5 != null) {
         ((XSPrincipalI)var5).doCharConversion(this.meg.conv);
      }

      int var19;
      if (var6 != null && var6.length > 0) {
         this.disabledRolesBytes = new byte[var6.length][];

         for(var19 = 0; var19 < var6.length; ++var19) {
            if (var6[var19] != null && var6[var19].length() > 0) {
               this.disabledRolesBytes[var19] = this.meg.conv.StringToCharBytes(var6[var19]);
            } else {
               this.disabledRolesBytes[var19] = null;
            }
         }
      } else {
         this.disabledRolesBytes = (byte[][])null;
      }

      if (var7 != null && var7.length > 0) {
         this.enabledRolesBytes = new byte[var7.length][];

         for(var19 = 0; var19 < var7.length; ++var19) {
            if (var7[var19] != null && var7[var19].length() > 0) {
               this.enabledRolesBytes[var19] = this.meg.conv.StringToCharBytes(var7[var19]);
            } else {
               this.enabledRolesBytes[var19] = null;
            }
         }
      } else {
         this.enabledRolesBytes = (byte[][])null;
      }

      if (var8 != null && var8.length > 0) {
         this.externalRolesBytes = new byte[var8.length][];

         for(var19 = 0; var19 < var8.length; ++var19) {
            if (var8[var19] != null && var8[var19].length() > 0) {
               this.externalRolesBytes[var19] = this.meg.conv.StringToCharBytes(var8[var19]);
            } else {
               this.externalRolesBytes[var19] = null;
            }
         }
      } else {
         this.externalRolesBytes = (byte[][])null;
      }

      this.namespaces = var9;
      if (var9 != null) {
         for(var19 = 0; var19 < var9.length; ++var19) {
            ((XSNamespaceI)var9[var19]).doCharConversion(this.meg.conv);
         }
      }

      this.cacheNamespace = var10;
      if (var10 != null) {
         for(var19 = 0; var19 < var10.length; ++var19) {
            ((XSNamespaceI)var10[var19]).doCharConversion(this.meg.conv);
         }
      }

      this.deleteNamespace = var11;
      if (var11 != null) {
         for(var19 = 0; var19 < var11.length; ++var19) {
            ((XSNamespaceI)var11[var19]).doCharConversion(this.meg.conv);
         }
      }

      this.midTierTimestamp = var12;
      this.authtime = var13;
      this.roleVersion = var14;
      this.inputFlag = var15;
      this.kv = var17;
      if (var17 != null) {
         KeywordValueLong[] var21 = var17.getKeyval();
         if (var21 != null) {
            for(int var20 = 0; var20 < var21.length; ++var20) {
               ((KeywordValueLongI)var21[var20]).doCharConversion(this.meg.conv);
            }
         }
      }

      this.roleVersionOutput = var18;
      this.doRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalUB4((long)this.opcode);
      boolean var1 = false;
      if (this.sessionId != null && this.sessionId.length > 0) {
         var1 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.sessionId.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      boolean var2 = false;
      if (this.sidp != null) {
         var2 = true;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      boolean var3 = false;
      if (this.cookie != null && this.cookie.length > 0) {
         var3 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.cookie.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      boolean var4 = false;
      if (this.username == null) {
         this.meg.marshalNULLPTR();
      } else {
         var4 = true;
         this.meg.marshalPTR();
      }

      if (this.disabledRolesBytes != null && this.disabledRolesBytes.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.disabledRolesBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.enabledRolesBytes != null && this.enabledRolesBytes.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.enabledRolesBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.externalRolesBytes != null && this.externalRolesBytes.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.externalRolesBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      boolean var5 = false;
      this.meg.marshalPTR();
      if (this.namespaces != null && this.namespaces.length > 0) {
         var5 = true;
         this.meg.marshalUB4((long)this.namespaces.length);
      } else {
         this.meg.marshalUB4(0L);
      }

      boolean var6 = false;
      this.meg.marshalPTR();
      if (this.cacheNamespace != null && this.cacheNamespace.length > 0) {
         var6 = true;
         this.meg.marshalUB4((long)this.cacheNamespace.length);
      } else {
         this.meg.marshalUB4(0L);
      }

      boolean var7 = false;
      this.meg.marshalPTR();
      if (this.deleteNamespace != null && this.deleteNamespace.length > 0) {
         var7 = true;
         this.meg.marshalUB4((long)this.deleteNamespace.length);
      } else {
         this.meg.marshalUB4(0L);
      }

      if (this.midTierTimestamp != null) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      if (this.authtime != null) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      this.meg.marshalPTR();
      this.meg.marshalUB4(this.inputFlag);
      boolean var8 = false;
      if (this.kv != null) {
         var8 = true;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      if (var1) {
         this.meg.marshalB1Array(this.sessionId);
      }

      if (var2) {
         ((XSSecureIdI)this.sidp).marshal(this.meg);
      }

      if (var3) {
         this.meg.marshalB1Array(this.cookie);
      }

      if (var4) {
         ((XSPrincipalI)this.username).marshal(this.meg);
      }

      int var9;
      if (this.disabledRolesBytes != null && this.disabledRolesBytes.length > 0) {
         for(var9 = 0; var9 < this.disabledRolesBytes.length; ++var9) {
            if (this.disabledRolesBytes[var9] == null) {
               this.meg.marshalUB4(0L);
            } else {
               this.meg.marshalUB4((long)this.disabledRolesBytes[var9].length);
               this.meg.marshalCLR(this.disabledRolesBytes[var9], this.disabledRolesBytes[var9].length);
            }
         }
      }

      if (this.enabledRolesBytes != null && this.enabledRolesBytes.length > 0) {
         for(var9 = 0; var9 < this.enabledRolesBytes.length; ++var9) {
            if (this.enabledRolesBytes[var9] == null) {
               this.meg.marshalUB4(0L);
            } else {
               this.meg.marshalUB4((long)this.enabledRolesBytes[var9].length);
               this.meg.marshalCLR(this.enabledRolesBytes[var9], this.enabledRolesBytes[var9].length);
            }
         }
      }

      if (this.externalRolesBytes != null && this.externalRolesBytes.length > 0) {
         for(var9 = 0; var9 < this.externalRolesBytes.length; ++var9) {
            if (this.externalRolesBytes[var9] == null) {
               this.meg.marshalUB4(0L);
            } else {
               this.meg.marshalUB4((long)this.externalRolesBytes[var9].length);
               this.meg.marshalCLR(this.externalRolesBytes[var9], this.externalRolesBytes[var9].length);
            }
         }
      }

      if (var5) {
         for(var9 = 0; var9 < this.namespaces.length; ++var9) {
            ((XSNamespaceI)this.namespaces[var9]).marshal(this.meg);
         }
      }

      if (var6) {
         for(var9 = 0; var9 < this.cacheNamespace.length; ++var9) {
            ((XSNamespaceI)this.cacheNamespace[var9]).marshal(this.meg);
         }
      }

      if (var7) {
         for(var9 = 0; var9 < this.deleteNamespace.length; ++var9) {
            ((XSNamespaceI)this.deleteNamespace[var9]).marshal(this.meg);
         }
      }

      if (this.midTierTimestamp != null) {
         this.meg.marshalB1Array(this.midTierTimestamp.getBytes());
      }

      if (this.authtime != null) {
         this.meg.marshalB1Array(this.authtime.getBytes());
      }

      this.meg.marshalUB4((long)this.roleVersion);
      if (var8) {
         ((XSKeyvalI)this.kv).marshal(this.meg);
      }

   }

   void readRPA() throws SQLException, IOException {
      int var1 = (int)this.meg.unmarshalUB4();
      if (this.roleVersionOutput != null && this.roleVersionOutput.length == 1) {
         this.roleVersionOutput[0] = var1;
      }

   }
}
