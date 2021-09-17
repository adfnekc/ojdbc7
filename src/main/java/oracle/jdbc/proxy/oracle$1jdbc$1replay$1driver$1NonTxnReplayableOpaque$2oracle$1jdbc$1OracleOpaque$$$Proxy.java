package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleOpaque;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableOpaque;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableOpaque$2oracle$1jdbc$1OracleOpaque$$$Proxy extends NonTxnReplayableOpaque implements OracleOpaque, _Proxy_ {
   private OracleOpaque delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject17839;
   private static Method methodObject17838;
   private static Method methodObject17837;

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject17839, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject17839, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject17839));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject17839, this.onErrorForAll(methodObject17839, var2));
      }
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject17838, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject17838, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject17838, this.onErrorForAll(methodObject17838, var2));
      }
   }

   public Object getValue() throws SQLException {
      try {
         super.preForAll(methodObject17837, this, zeroLengthObjectArray);
         return this.postForAll(methodObject17837, this.proxyFactory.proxyForCache(this.delegate.getValue(), this, this.proxyCache, methodObject17837));
      } catch (SQLException var2) {
         return this.postForAll(methodObject17837, this.onErrorForAll(methodObject17837, var2));
      }
   }

   public OracleOpaque _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleOpaque)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject17839 = OracleOpaque.class.getDeclaredMethod("getOracleMetaData");
         methodObject17838 = OracleOpaque.class.getDeclaredMethod("getSQLTypeName");
         methodObject17837 = OracleOpaque.class.getDeclaredMethod("getValue");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableOpaque$2oracle$1jdbc$1OracleOpaque$$$Proxy(OracleOpaque var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
