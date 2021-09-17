package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Map;
import oracle.jdbc.OracleSavepoint;
import oracle.jdbc.replay.driver.NonTxnReplayableOthers;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableOthers$2oracle$1jdbc$1OracleSavepoint$$$Proxy extends NonTxnReplayableOthers implements OracleSavepoint, _Proxy_ {
   private OracleSavepoint delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject22734;
   private static Method methodObject22735;

   public int getSavepointId() throws SQLException {
      try {
         super.preForAll(methodObject22734, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject22734, this.delegate.getSavepointId());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject22734, this.onErrorForAll(methodObject22734, var2));
      }
   }

   public String getSavepointName() throws SQLException {
      try {
         super.preForAll(methodObject22735, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject22735, (Object)this.delegate.getSavepointName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject22735, this.onErrorForAll(methodObject22735, var2));
      }
   }

   public OracleSavepoint _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleSavepoint)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject22734 = Savepoint.class.getDeclaredMethod("getSavepointId");
         methodObject22735 = Savepoint.class.getDeclaredMethod("getSavepointName");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableOthers$2oracle$1jdbc$1OracleSavepoint$$$Proxy(OracleSavepoint var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
