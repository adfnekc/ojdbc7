package oracle.jdbc.replay.driver;

import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Struct;
import java.util.Properties;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.Methods;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyAccess;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyLocale;
import oracle.jdbc.proxy.annotation.SetDelegate;
import oracle.jdbc.proxy.annotation.Signature;
import oracle.jdbc.replay.internal.OracleDataSource;
import oracle.jdbc.replay.internal.ReplayableConnection;
import oracle.sql.ARRAY;

@ProxyFor({OracleConnection.class})
@ProxyLocale
@ProxyAccess(ACProxyable.class)
public abstract class TxnReplayableConnection extends TxnReplayableBase implements JDBCReplayable, ReplayableConnection {
   private static final Method CREATEARRAY_METHOD = getCreateARRAYMethod();
   private static final Method CREATEARRAYOF_METHOD = getCreateArrayOfMethod();
   private static final Method CREATESTRUCT_METHOD = getCreateStructMethod();
   String originalUser = "";
   String originalPasswd = "";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   protected TxnReplayableConnection() {
      this.thisProxyNameInLog = "CONN" + this.thisProxyNameInLog;
   }

   private static final Method getCreateARRAYMethod() {
      try {
         return OracleConnection.class.getMethod("createARRAY", String.class, Object.class);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getCreateArrayOfMethod() {
      try {
         return Connection.class.getDeclaredMethod("createArrayOf", String.class, Object[].class);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getCreateStructMethod() {
      try {
         return Connection.class.getDeclaredMethod("createStruct", String.class, Object[].class);
      } catch (Exception var1) {
         return null;
      }
   }

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "prepareStatement",
   args = {String.class}
), @Signature(
   name = "prepareStatement",
   args = {String.class, int.class}
), @Signature(
   name = "prepareStatement",
   args = {String.class, int.class}
), @Signature(
   name = "prepareStatement",
   args = {String.class, int.class, int.class}
), @Signature(
   name = "prepareStatement",
   args = {String.class, int.class, int.class, int.class}
), @Signature(
   name = "prepareStatement",
   args = {String.class, String.class}
), @Signature(
   name = "prepareCall",
   args = {String.class}
), @Signature(
   name = "prepareCall",
   args = {String.class, int.class, int.class}
), @Signature(
   name = "prepareCall",
   args = {String.class, int.class, int.class, int.class}
)}
   )
   protected void preForStatementCreation(Method var1, Object var2, Object... var3) {
      this.preForAll(var1, var2, var3);
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "abort",
   args = {}
)}
   )
   protected void preForAbort(Method var1, Object var2, Object... var3) {
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "close",
   args = {}
), @Signature(
   name = "close",
   args = {int.class}
), @Signature(
   name = "close",
   args = {Properties.class}
)}
   )
   protected void preForClosure(Method var1, Object var2, Object... var3) {
      StackTraceElement[] var4 = Thread.currentThread().getStackTrace();
      String var5 = var4 != null && var4.length > 4 ? var4[4].getClassName() : "";
      if (var5.startsWith("oracle.ucp")) {
         this.isClosedAndNoReplay = false;
      } else {
         this.isClosedAndNoReplay = true;
      }

   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "cancel",
   args = {}
)}
   )
   protected void preForCancel(Method var1, Object var2, Object... var3) {
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "openProxySession",
   args = {int.class, Properties.class}
)}
   )
   protected void preForOpenProxySession(Method var1, Object var2, Object... var3) {
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
         }

      }
   }

   @Post
   protected void postForAll(Method var1) {
      this.postForAll(var1, (Object)null);
   }

   @Post
   protected Object postForAll(Method var1, Object var2) {
      return super.postForAll(var1, var2);
   }

   @Post
   @Methods(
      signatures = {@Signature(
   name = "abort",
   args = {}
)}
   )
   protected void postForAbort(Method var1) {
   }

   @Post
   @Methods(
      signatures = {@Signature(
   name = "close",
   args = {}
), @Signature(
   name = "close",
   args = {int.class}
), @Signature(
   name = "close",
   args = {Properties.class}
)}
   )
   protected void postForClosure(Method var1) {
   }

   @Post
   @Methods(
      signatures = {@Signature(
   name = "cancel",
   args = {}
)}
   )
   protected void postForCancel(Method var1) {
   }

   @OnError(SQLException.class)
   protected void onErrorVoidForAll(Method var1, SQLException var2) throws SQLException {
      super.onErrorVoidForAll(var1, var2);
   }

   @OnError(SQLException.class)
   protected Object onErrorForAll(Method var1, SQLException var2) throws SQLException {
      return super.onErrorForAll(var1, var2);
   }

   @GetDelegate
   protected abstract Object getDelegate();

   @SetDelegate
   protected abstract void setDelegate(Object var1);

   @GetCreator
   protected abstract Object getCreator();

   public void setReplayInitiationTimeout(int var1) throws SQLException {
      this.failoverMngr.setReplayInitiationTimeout(var1);
   }

   public void initialize(OracleDataSource var1, String var2, String var3) throws SQLException {
      TxnFailoverManagerImpl var4 = (TxnFailoverManagerImpl)TxnFailoverManagerImpl.getFailoverManager(this, var1);
      this.setFailoverManager(var4);
      this.originalUser = var2;
      this.originalPasswd = var3;
   }

   public void setSessionStateConsistency(boolean var1) throws SQLException {
      this.failoverMngr.setSessionStateConsistency(var1);
   }

   public void beginRequest() throws SQLException {
      this.failoverMngr.beginRequest();
   }

   public void endRequest() throws SQLException {
      this.failoverMngr.endRequest();
   }

   public void disableReplay() throws SQLException {
      this.failoverMngr.disableReplay();
   }

   public ARRAY createARRAY(String var1, Object var2) throws SQLException {
      Object var3;
      if (var2 != null && var2 instanceof Object[]) {
         Object[] var4 = (Object[])((Object[])var2);
         if (var4.length > 0) {
            Object[] var5 = new Object[var4.length];
            int var6 = 0;
            Object[] var7 = var4;
            int var8 = var4.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               Object var10 = var7[var9];
               if (var10 instanceof TxnReplayableBase) {
                  var5[var6++] = ((TxnReplayableBase)var10).getDelegate();
               } else {
                  var5[var6++] = var10;
               }
            }

            var3 = var5;
         } else {
            var3 = var2;
         }
      } else {
         var3 = var2;
      }

      if (CREATEARRAY_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot create ARRAY instance");
      } else {
         Method var12 = CREATEARRAY_METHOD;
         this.preForAll(var12, this, var1, var3);

         try {
            OracleConnection var13 = (OracleConnection)this.getDelegate();
            ARRAY var14 = var13.createARRAY(var1, var3);
            return (ARRAY)this.postForAll(var12, var14);
         } catch (SQLException var11) {
            return (ARRAY)this.postForAll(var12, this.onErrorForAll(var12, var11));
         }
      }
   }

   public Array createOracleArray(String var1, Object var2) throws SQLException {
      return this.createARRAY(var1, var2);
   }

   public Array createArrayOf(String var1, Object[] var2) throws SQLException {
      Object[] var3;
      if (var2 != null && var2.length > 0) {
         var3 = new Object[var2.length];
         int var4 = 0;
         Object[] var5 = var2;
         int var6 = var2.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var5[var7];
            if (var8 instanceof TxnReplayableBase) {
               var3[var4++] = ((TxnReplayableBase)var8).getDelegate();
            } else {
               var3[var4++] = var8;
            }
         }
      } else {
         var3 = var2;
      }

      if (CREATEARRAYOF_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot create Array instance");
      } else {
         Method var10 = CREATEARRAYOF_METHOD;
         this.preForAll(var10, this, var1, var3);

         try {
            Connection var11 = (Connection)this.getDelegate();
            Array var12 = var11.createArrayOf(var1, var3);
            return (Array)this.postForAll(var10, var12);
         } catch (SQLException var9) {
            return (Array)this.postForAll(var10, this.onErrorForAll(var10, var9));
         }
      }
   }

   public Struct createStruct(String var1, Object[] var2) throws SQLException {
      Object[] var3;
      if (var2 != null && var2.length > 0) {
         var3 = new Object[var2.length];
         int var4 = 0;
         Object[] var5 = var2;
         int var6 = var2.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var5[var7];
            if (var8 instanceof TxnReplayableBase) {
               var3[var4++] = ((TxnReplayableBase)var8).getDelegate();
            } else {
               var3[var4++] = var8;
            }
         }
      } else {
         var3 = var2;
      }

      if (CREATESTRUCT_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot create Struct instance");
      } else {
         Method var10 = CREATESTRUCT_METHOD;
         this.preForAll(var10, this, var1, var3);

         try {
            Connection var11 = (Connection)this.getDelegate();
            Struct var12 = var11.createStruct(var1, var3);
            return (Struct)this.postForAll(var10, var12);
         } catch (SQLException var9) {
            return (Struct)this.postForAll(var10, this.onErrorForAll(var10, var9));
         }
      }
   }
}
