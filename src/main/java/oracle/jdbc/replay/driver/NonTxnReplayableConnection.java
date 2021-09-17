package oracle.jdbc.replay.driver;

import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.EnumSet;
import java.util.Properties;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleSavepoint;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.Methods;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyLocale;
import oracle.jdbc.proxy.annotation.ProxyResult;
import oracle.jdbc.proxy.annotation.ProxyResultPolicy;
import oracle.jdbc.proxy.annotation.SetDelegate;
import oracle.jdbc.proxy.annotation.Signature;
import oracle.jdbc.replay.internal.OracleDataSource;
import oracle.jdbc.replay.internal.ReplayableConnection;
import oracle.sql.ARRAY;

@ProxyFor({Connection.class, OracleConnection.class, oracle.jdbc.internal.OracleConnection.class})
@ProxyLocale
public abstract class NonTxnReplayableConnection extends NonTxnReplayableBase implements Replayable, ReplayableConnection {
   String originalUser = "";
   String originalPasswd = "";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "commit",
   args = {}
), @Signature(
   name = "commit",
   args = {EnumSet.class}
), @Signature(
   name = "rollback",
   args = {}
), @Signature(
   name = "rollback",
   args = {Savepoint.class}
), @Signature(
   name = "setSavepoint",
   args = {}
), @Signature(
   name = "setSavepoint",
   args = {String.class}
), @Signature(
   name = "releaseSavepoint",
   args = {Savepoint.class}
), @Signature(
   name = "oracleRollback",
   args = {OracleSavepoint.class}
), @Signature(
   name = "oracleSetSavepoint",
   args = {}
), @Signature(
   name = "oracleSetSavepoint",
   args = {String.class}
), @Signature(
   name = "oracleReleaseSavepoint",
   args = {OracleSavepoint.class}
)}
   )
   protected void preForTxnControl(Method var1, Object var2, Object... var3) {
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (var1 == null) {
            String var10000 = "NULL METHOD";
         } else {
            var1.getName();
         }

         if (this.failoverMngr != null) {
            boolean var6 = false;

            try {
               oracle.jdbc.internal.OracleConnection var7 = (oracle.jdbc.internal.OracleConnection)this.getDelegate();
               EnumSet var8 = var7.getTransactionState();
               if (var8.contains(oracle.jdbc.internal.OracleConnection.TransactionState.TRANSACTION_STARTED) && !var8.contains(oracle.jdbc.internal.OracleConnection.TransactionState.TRANSACTION_READONLY)) {
                  var6 = true;
               }
            } catch (SQLException var12) {
               var6 = true;
            } finally {
               if (var6) {
                  this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of active transaction", (SQLRecoverableException)null);
               } else {
                  super.preForAll(var1, var2, var3);
               }

            }
         }

      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "abort",
   args = {}
), @Signature(
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
      this.isClosedAndNoReplay = true;
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
), @Signature(
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
      FailoverManagerImpl var4 = (FailoverManagerImpl)FailoverManagerImpl.getFailoverManager(this, var1);
      this.setFailoverManager(var4);
      this.originalUser = var2;
      this.originalPasswd = var3;
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

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public ARRAY createARRAY(String var1, Object var2) throws SQLException {
      Object var3;
      Object[] var4;
      if (var2 != null && var2 instanceof Object[]) {
         var4 = (Object[])((Object[])var2);
         if (var4.length > 0) {
            Object[] var5 = new Object[var4.length];
            int var6 = 0;
            Object[] var7 = var4;
            int var8 = var4.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               Object var10 = var7[var9];
               if (var10 instanceof NonTxnReplayableBase) {
                  var5[var6++] = ((NonTxnReplayableBase)var10).getDelegate();
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

      var4 = null;

      Method var13;
      try {
         var13 = oracle.jdbc.internal.OracleConnection.class.getMethod("createARRAY", String.class, Object.class);
      } catch (Exception var12) {
         throw DatabaseError.createSqlException(1, "Cannot create ARRAY instance");
      }

      this.preForAll(var13, this, var1, var3);

      try {
         oracle.jdbc.internal.OracleConnection var14 = (oracle.jdbc.internal.OracleConnection)this.getDelegate();
         ARRAY var15 = var14.createARRAY(var1, var3);
         return (ARRAY)this.postForAll(var13, var15);
      } catch (SQLException var11) {
         return (ARRAY)this.postForAll(var13, this.onErrorForAll(var13, var11));
      }
   }

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public Array createOracleArray(String var1, Object var2) throws SQLException {
      return this.createARRAY(var1, var2);
   }

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public Array createArrayOf(String var1, Object[] var2) throws SQLException {
      Object[] var3;
      if (var2 != null && var2.length > 0) {
         var3 = new Object[var2.length];
         int var4 = 0;
         Object[] var5 = var2;
         int var6 = var2.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var5[var7];
            if (var8 instanceof NonTxnReplayableBase) {
               var3[var4++] = ((NonTxnReplayableBase)var8).getDelegate();
            } else {
               var3[var4++] = var8;
            }
         }
      } else {
         var3 = var2;
      }

      Method var11 = null;

      try {
         var11 = Connection.class.getDeclaredMethod("createArrayOf", String.class, Object[].class);
      } catch (Exception var10) {
         throw DatabaseError.createSqlException(1, "Cannot create Array instance");
      }

      this.preForAll(var11, this, var1, var3);

      try {
         Connection var12 = (Connection)this.getDelegate();
         Array var13 = var12.createArrayOf(var1, var3);
         return (Array)this.postForAll(var11, var13);
      } catch (SQLException var9) {
         return (Array)this.postForAll(var11, this.onErrorForAll(var11, var9));
      }
   }

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public Struct createStruct(String var1, Object[] var2) throws SQLException {
      Object[] var3;
      if (var2 != null && var2.length > 0) {
         var3 = new Object[var2.length];
         int var4 = 0;
         Object[] var5 = var2;
         int var6 = var2.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var5[var7];
            if (var8 instanceof NonTxnReplayableBase) {
               var3[var4++] = ((NonTxnReplayableBase)var8).getDelegate();
            } else {
               var3[var4++] = var8;
            }
         }
      } else {
         var3 = var2;
      }

      Method var11 = null;

      try {
         var11 = Connection.class.getDeclaredMethod("createStruct", String.class, Object[].class);
      } catch (Exception var10) {
         throw DatabaseError.createSqlException(1, "Cannot create Struct instance");
      }

      this.preForAll(var11, this, var1, var3);

      try {
         Connection var12 = (Connection)this.getDelegate();
         Struct var13 = var12.createStruct(var1, var3);
         return (Struct)this.postForAll(var11, var13);
      } catch (SQLException var9) {
         return (Struct)this.postForAll(var11, this.onErrorForAll(var11, var9));
      }
   }

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract Blob createBlob() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract Clob createClob() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract NClob createNClob() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract SQLXML createSQLXML() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract Statement createStatement() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract Statement createStatement(int var1, int var2) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract Statement createStatement(int var1, int var2, int var3) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract CallableStatement prepareCall(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract CallableStatement prepareCall(String var1, int var2, int var3) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract CallableStatement prepareCall(String var1, int var2, int var3, int var4) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract PreparedStatement prepareStatement(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract PreparedStatement prepareStatement(String var1, int var2) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract PreparedStatement prepareStatement(String var1, int[] var2) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract PreparedStatement prepareStatement(String var1, int var2, int var3) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract PreparedStatement prepareStatement(String var1, int var2, int var3, int var4) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract PreparedStatement prepareStatement(String var1, String[] var2) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Savepoint setSavepoint() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Savepoint setSavepoint(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public Object unwrap(Class var1) throws SQLException {
      return this.getDelegate();
   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public abstract Connection _getPC();

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract OracleSavepoint oracleSetSavepoint() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract OracleSavepoint oracleSetSavepoint(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public OracleConnection unwrap() {
      return ((oracle.jdbc.internal.OracleConnection)this.getDelegate()).unwrap();
   }
}
