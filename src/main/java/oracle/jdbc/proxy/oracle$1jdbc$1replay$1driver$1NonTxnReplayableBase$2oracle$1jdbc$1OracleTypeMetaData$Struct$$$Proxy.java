package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;
import oracle.sql.SQLName;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$Struct$$$Proxy extends NonTxnReplayableBase implements OracleTypeMetaData.Struct, _Proxy_ {
   private OracleTypeMetaData.Struct delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30066;
   private static Method methodObject30071;
   private static Method methodObject30072;
   private static Method methodObject30059;
   private static Method methodObject30070;
   private static Method methodObject30061;
   private static Method methodObject30068;
   private static Method methodObject30062;
   private static Method methodObject30064;
   private static Method methodObject30069;
   private static Method methodObject30063;
   private static Method methodObject30060;
   private static Method methodObject30058;
   private static Method methodObject30067;
   private static Method methodObject30065;

   public String[] getSubtypeNames() throws SQLException {
      try {
         super.preForAll(methodObject30066, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject30066, (Object)this.delegate.getSubtypeNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject30066, this.onErrorForAll(methodObject30066, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject30071, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject30071, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject30071, this.onErrorForAll(methodObject30071, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject30072, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30072, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30072, this.onErrorForAll(methodObject30072, var2));
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject30059, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject30059, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject30059));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject30059, this.onErrorForAll(methodObject30059, var2));
      }
   }

   public OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject30070, this, zeroLengthObjectArray);
      return (OracleTypeMetaData.Kind)this.postForAll(methodObject30070, (Object)this.delegate.getKind());
   }

   public boolean isFinalType() throws SQLException {
      try {
         super.preForAll(methodObject30061, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30061, this.delegate.isFinalType());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30061, this.onErrorForAll(methodObject30061, var2));
      }
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject30068, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30068, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30068, this.onErrorForAll(methodObject30068, var2));
      }
   }

   public boolean isSubtype() throws SQLException {
      try {
         super.preForAll(methodObject30062, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30062, this.delegate.isSubtype());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30062, this.onErrorForAll(methodObject30062, var2));
      }
   }

   public String getSupertypeName() throws SQLException {
      try {
         super.preForAll(methodObject30064, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30064, (Object)this.delegate.getSupertypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30064, this.onErrorForAll(methodObject30064, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject30069, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30069, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30069, this.onErrorForAll(methodObject30069, var2));
      }
   }

   public boolean isInstantiable() throws SQLException {
      try {
         super.preForAll(methodObject30063, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30063, this.delegate.isInstantiable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30063, this.onErrorForAll(methodObject30063, var2));
      }
   }

   public int getTypeVersion() throws SQLException {
      try {
         super.preForAll(methodObject30060, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30060, this.delegate.getTypeVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30060, this.onErrorForAll(methodObject30060, var2));
      }
   }

   public int getLength() throws SQLException {
      try {
         super.preForAll(methodObject30058, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30058, this.delegate.getLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30058, this.onErrorForAll(methodObject30058, var2));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject30067, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30067, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30067, this.onErrorForAll(methodObject30067, var2));
      }
   }

   public int getLocalAttributeCount() throws SQLException {
      try {
         super.preForAll(methodObject30065, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30065, this.delegate.getLocalAttributeCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30065, this.onErrorForAll(methodObject30065, var2));
      }
   }

   public OracleTypeMetaData.Struct _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData.Struct)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30066 = OracleTypeMetaData.Struct.class.getDeclaredMethod("getSubtypeNames");
         methodObject30071 = OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject30072 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject30059 = OracleTypeMetaData.Struct.class.getDeclaredMethod("getMetaData");
         methodObject30070 = OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject30061 = OracleTypeMetaData.Struct.class.getDeclaredMethod("isFinalType");
         methodObject30068 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject30062 = OracleTypeMetaData.Struct.class.getDeclaredMethod("isSubtype");
         methodObject30064 = OracleTypeMetaData.Struct.class.getDeclaredMethod("getSupertypeName");
         methodObject30069 = OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject30063 = OracleTypeMetaData.Struct.class.getDeclaredMethod("isInstantiable");
         methodObject30060 = OracleTypeMetaData.Struct.class.getDeclaredMethod("getTypeVersion");
         methodObject30058 = OracleTypeMetaData.Struct.class.getDeclaredMethod("getLength");
         methodObject30067 = OracleTypeMetaData.class.getDeclaredMethod("getName");
         methodObject30065 = OracleTypeMetaData.Struct.class.getDeclaredMethod("getLocalAttributeCount");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$Struct$$$Proxy(OracleTypeMetaData.Struct var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
