package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;
import oracle.sql.SQLName;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$$$Proxy extends NonTxnReplayableBase implements OracleTypeMetaData, _Proxy_ {
   private OracleTypeMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30034;
   private static Method methodObject30032;
   private static Method methodObject30035;
   private static Method methodObject30033;
   private static Method methodObject30036;
   private static Method methodObject30031;

   public OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject30034, this, zeroLengthObjectArray);
      return (OracleTypeMetaData.Kind)this.postForAll(methodObject30034, (Object)this.delegate.getKind());
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject30032, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30032, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30032, this.onErrorForAll(methodObject30032, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject30035, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject30035, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject30035, this.onErrorForAll(methodObject30035, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject30033, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30033, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30033, this.onErrorForAll(methodObject30033, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject30036, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30036, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30036, this.onErrorForAll(methodObject30036, var2));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject30031, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30031, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30031, this.onErrorForAll(methodObject30031, var2));
      }
   }

   public OracleTypeMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30034 = OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject30032 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject30035 = OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject30033 = OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject30036 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject30031 = OracleTypeMetaData.class.getDeclaredMethod("getName");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$$$Proxy(OracleTypeMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
