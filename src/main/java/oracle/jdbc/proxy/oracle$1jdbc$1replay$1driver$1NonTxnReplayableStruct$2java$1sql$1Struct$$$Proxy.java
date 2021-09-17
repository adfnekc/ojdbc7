package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableStruct;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStruct$2java$1sql$1Struct$$$Proxy extends NonTxnReplayableStruct implements Struct, _Proxy_ {
   private Struct delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject25318;
   private static Method methodObject25317;
   private static Method methodObject25316;

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject25318, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject25318, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject25318, this.onErrorForAll(methodObject25318, var2));
      }
   }

   public Object[] getAttributes(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject25317, this, arg0);
         return (Object[])this.postForAll(methodObject25317, (Object)this.delegate.getAttributes(arg0));
      } catch (SQLException var3) {
         return (Object[])this.postForAll(methodObject25317, this.onErrorForAll(methodObject25317, var3));
      }
   }

   public Object[] getAttributes() throws SQLException {
      try {
         super.preForAll(methodObject25316, this, zeroLengthObjectArray);
         return (Object[])this.postForAll(methodObject25316, (Object)this.delegate.getAttributes());
      } catch (SQLException var2) {
         return (Object[])this.postForAll(methodObject25316, this.onErrorForAll(methodObject25316, var2));
      }
   }

   public Struct _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (Struct)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject25318 = Struct.class.getDeclaredMethod("getSQLTypeName");
         methodObject25317 = Struct.class.getDeclaredMethod("getAttributes", Map.class);
         methodObject25316 = Struct.class.getDeclaredMethod("getAttributes");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStruct$2java$1sql$1Struct$$$Proxy(Struct var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
