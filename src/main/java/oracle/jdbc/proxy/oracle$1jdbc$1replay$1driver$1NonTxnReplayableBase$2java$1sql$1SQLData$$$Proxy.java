package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1SQLData$$$Proxy extends NonTxnReplayableBase implements SQLData, _Proxy_ {
   private SQLData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29777;
   private static Method methodObject29776;
   private static Method methodObject29778;

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject29777, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29777, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29777, this.onErrorForAll(methodObject29777, var2));
      }
   }

   public void readSQL(SQLInput arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject29776, this, arg0, arg1);
         Method var10001 = methodObject29776;
         this.delegate.readSQL(arg0 instanceof _Proxy_ ? (SQLInput)((_Proxy_)arg0)._getDelegate_() : arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject29776, var4);
      }
   }

   public void writeSQL(SQLOutput arg0) throws SQLException {
      try {
         super.preForAll(methodObject29778, this, arg0);
         Method var10001 = methodObject29778;
         this.delegate.writeSQL(arg0 instanceof _Proxy_ ? (SQLOutput)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject29778, var3);
      }
   }

   public SQLData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (SQLData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29777 = SQLData.class.getDeclaredMethod("getSQLTypeName");
         methodObject29776 = SQLData.class.getDeclaredMethod("readSQL", SQLInput.class, String.class);
         methodObject29778 = SQLData.class.getDeclaredMethod("writeSQL", SQLOutput.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1SQLData$$$Proxy(SQLData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
