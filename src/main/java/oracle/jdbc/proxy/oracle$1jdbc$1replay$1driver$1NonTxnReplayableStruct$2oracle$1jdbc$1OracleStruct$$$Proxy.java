package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Map;
import oracle.jdbc.OracleStruct;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableStruct;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStruct$2oracle$1jdbc$1OracleStruct$$$Proxy extends NonTxnReplayableStruct implements OracleStruct, _Proxy_ {
   private OracleStruct delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject25319;
   private static Method methodObject25322;
   private static Method methodObject25321;
   private static Method methodObject25320;

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject25319, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject25319, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject25319));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject25319, this.onErrorForAll(methodObject25319, var2));
      }
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject25322, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject25322, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject25322, this.onErrorForAll(methodObject25322, var2));
      }
   }

   public Object[] getAttributes(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject25321, this, arg0);
         return (Object[])this.postForAll(methodObject25321, (Object)this.delegate.getAttributes(arg0));
      } catch (SQLException var3) {
         return (Object[])this.postForAll(methodObject25321, this.onErrorForAll(methodObject25321, var3));
      }
   }

   public Object[] getAttributes() throws SQLException {
      try {
         super.preForAll(methodObject25320, this, zeroLengthObjectArray);
         return (Object[])this.postForAll(methodObject25320, (Object)this.delegate.getAttributes());
      } catch (SQLException var2) {
         return (Object[])this.postForAll(methodObject25320, this.onErrorForAll(methodObject25320, var2));
      }
   }

   public OracleStruct _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleStruct)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject25319 = OracleStruct.class.getDeclaredMethod("getOracleMetaData");
         methodObject25322 = Struct.class.getDeclaredMethod("getSQLTypeName");
         methodObject25321 = Struct.class.getDeclaredMethod("getAttributes", Map.class);
         methodObject25320 = Struct.class.getDeclaredMethod("getAttributes");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStruct$2oracle$1jdbc$1OracleStruct$$$Proxy(OracleStruct var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
