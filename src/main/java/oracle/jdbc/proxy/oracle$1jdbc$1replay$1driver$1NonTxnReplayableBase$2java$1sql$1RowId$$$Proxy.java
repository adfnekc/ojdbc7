package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.RowId;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1RowId$$$Proxy extends NonTxnReplayableBase implements RowId, _Proxy_ {
   private RowId delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29775;

   public byte[] getBytes() {
      super.preForAll(methodObject29775, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject29775, (Object)this.delegate.getBytes());
   }

   public RowId _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (RowId)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29775 = RowId.class.getDeclaredMethod("getBytes");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1RowId$$$Proxy(RowId var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
