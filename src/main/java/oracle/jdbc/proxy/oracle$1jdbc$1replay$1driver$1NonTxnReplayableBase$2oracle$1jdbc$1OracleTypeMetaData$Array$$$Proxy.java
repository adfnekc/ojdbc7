package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;
import oracle.sql.SQLName;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$Array$$$Proxy extends NonTxnReplayableBase implements OracleTypeMetaData.Array, _Proxy_ {
   private OracleTypeMetaData.Array delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30044;
   private static Method methodObject30042;
   private static Method methodObject30039;
   private static Method methodObject30040;
   private static Method methodObject30045;
   private static Method methodObject30043;
   private static Method methodObject30046;
   private static Method methodObject30038;
   private static Method methodObject30041;
   private static Method methodObject30037;

   public OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject30044, this, zeroLengthObjectArray);
      return (OracleTypeMetaData.Kind)this.postForAll(methodObject30044, (Object)this.delegate.getKind());
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject30042, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30042, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30042, this.onErrorForAll(methodObject30042, var2));
      }
   }

   public OracleTypeMetaData.ArrayStorage getArrayStorage() throws SQLException {
      try {
         super.preForAll(methodObject30039, this, zeroLengthObjectArray);
         return (OracleTypeMetaData.ArrayStorage)this.postForAll(methodObject30039, (Object)this.delegate.getArrayStorage());
      } catch (SQLException var2) {
         return (OracleTypeMetaData.ArrayStorage)this.postForAll(methodObject30039, this.onErrorForAll(methodObject30039, var2));
      }
   }

   public long getMaxLength() throws SQLException {
      try {
         super.preForAll(methodObject30040, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30040, this.delegate.getMaxLength());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30040, this.onErrorForAll(methodObject30040, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject30045, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject30045, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject30045, this.onErrorForAll(methodObject30045, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject30043, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30043, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30043, this.onErrorForAll(methodObject30043, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject30046, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30046, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30046, this.onErrorForAll(methodObject30046, var2));
      }
   }

   public String getBaseName() throws SQLException {
      try {
         super.preForAll(methodObject30038, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30038, (Object)this.delegate.getBaseName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30038, this.onErrorForAll(methodObject30038, var2));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject30041, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30041, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30041, this.onErrorForAll(methodObject30041, var2));
      }
   }

   public int getBaseType() throws SQLException {
      try {
         super.preForAll(methodObject30037, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30037, this.delegate.getBaseType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30037, this.onErrorForAll(methodObject30037, var2));
      }
   }

   public OracleTypeMetaData.Array _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData.Array)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30044 = OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject30042 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject30039 = OracleTypeMetaData.Array.class.getDeclaredMethod("getArrayStorage");
         methodObject30040 = OracleTypeMetaData.Array.class.getDeclaredMethod("getMaxLength");
         methodObject30045 = OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject30043 = OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject30046 = OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject30038 = OracleTypeMetaData.Array.class.getDeclaredMethod("getBaseName");
         methodObject30041 = OracleTypeMetaData.class.getDeclaredMethod("getName");
         methodObject30037 = OracleTypeMetaData.Array.class.getDeclaredMethod("getBaseType");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleTypeMetaData$Array$$$Proxy(OracleTypeMetaData.Array var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
