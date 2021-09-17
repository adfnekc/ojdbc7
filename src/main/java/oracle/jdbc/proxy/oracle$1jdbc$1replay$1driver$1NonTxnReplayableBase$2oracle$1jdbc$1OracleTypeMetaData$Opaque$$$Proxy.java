package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;
import oracle.sql.SQLName;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$Opaque$$$Proxy extends NonTxnReplayableBase implements OracleTypeMetaData.Opaque, _Proxy_ {
   private OracleTypeMetaData.Opaque delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30050;
   private static Method methodObject30055;
   private static Method methodObject30048;
   private static Method methodObject30053;
   private static Method methodObject30051;
   private static Method methodObject30049;
   private static Method methodObject30047;
   private static Method methodObject30056;
   private static Method methodObject30054;
   private static Method methodObject30057;
   private static Method methodObject30052;

   public boolean isModeledInC() throws SQLException {
      try {
         super.preForAll(methodObject30050, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30050, this.delegate.isModeledInC());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30050, this.onErrorForAll(methodObject30050, var2));
      }
   }

   public OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject30055, this, zeroLengthObjectArray);
      return (OracleTypeMetaData.Kind)this.postForAll(methodObject30055, (Object)this.delegate.getKind());
   }

   public boolean isTrustedLibrary() throws SQLException {
      try {
         super.preForAll(methodObject30048, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30048, this.delegate.isTrustedLibrary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30048, this.onErrorForAll(methodObject30048, var2));
      }
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject30053, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30053, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30053, this.onErrorForAll(methodObject30053, var2));
      }
   }

   public boolean hasFixedSize() throws SQLException {
      try {
         super.preForAll(methodObject30051, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30051, this.delegate.hasFixedSize());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30051, this.onErrorForAll(methodObject30051, var2));
      }
   }

   public boolean hasUnboundedSize() throws SQLException {
      try {
         super.preForAll(methodObject30049, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30049, this.delegate.hasUnboundedSize());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30049, this.onErrorForAll(methodObject30049, var2));
      }
   }

   public long getMaxLength() throws SQLException {
      try {
         super.preForAll(methodObject30047, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30047, this.delegate.getMaxLength());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30047, this.onErrorForAll(methodObject30047, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject30056, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject30056, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject30056, this.onErrorForAll(methodObject30056, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject30054, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30054, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30054, this.onErrorForAll(methodObject30054, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject30057, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30057, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30057, this.onErrorForAll(methodObject30057, var2));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject30052, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30052, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30052, this.onErrorForAll(methodObject30052, var2));
      }
   }

   public OracleTypeMetaData.Opaque _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData.Opaque)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30050 = OracleTypeMetaData.Opaque.class.getDeclaredMethod("isModeledInC");
         methodObject30055 = OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject30048 = OracleTypeMetaData.Opaque.class.getDeclaredMethod("isTrustedLibrary");
         methodObject30053 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject30051 = OracleTypeMetaData.Opaque.class.getDeclaredMethod("hasFixedSize");
         methodObject30049 = OracleTypeMetaData.Opaque.class.getDeclaredMethod("hasUnboundedSize");
         methodObject30047 = OracleTypeMetaData.Opaque.class.getDeclaredMethod("getMaxLength");
         methodObject30056 = OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject30054 = OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject30057 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject30052 = OracleTypeMetaData.class.getDeclaredMethod("getName");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$Opaque$$$Proxy(OracleTypeMetaData.Opaque var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
