package oracle.jdbc.replay.driver;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.Methods;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyAccess;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyResult;
import oracle.jdbc.proxy.annotation.ProxyResultPolicy;
import oracle.jdbc.proxy.annotation.SetDelegate;
import oracle.jdbc.proxy.annotation.Signature;

@ProxyFor({OracleClob.class})
@ProxyAccess(ACProxyable.class)
public abstract class TxnReplayableClob extends TxnReplayableBase implements JDBCReplayable {
   private static final Method GETASCIISTREAM_METHOD = getGetAsciiStreamMethod();
   private static final Method GETASCIISTREAM_LONG_METHOD = getGetAsciiStreamLongMethod();
   private static final Method GETCHARSTREAM_METHOD = getGetCharacterStreamMethod();
   private static final Method GETCHARSTREAM_LONG_METHOD = getGetCharacterStreamLongMethod();
   private static final Method GETCHARSTREAM_LONG_LONG_METHOD = getGetCharacterStreamLongLongMethod();
   private static final Method SETASCIISTREAM_LONG_METHOD = getSetAsciiStreamLongMethod();
   private static final Method SETCHARSTREAM_LONG_METHOD = getSetCharacterStreamLongMethod();
   protected boolean isFreed = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   protected TxnReplayableClob() {
      this.thisProxyNameInLog = "CLOB" + this.thisProxyNameInLog;
   }

   private static final Method getGetAsciiStreamMethod() {
      try {
         return OracleClob.class.getMethod("getAsciiStream");
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getGetAsciiStreamLongMethod() {
      try {
         return OracleClob.class.getMethod("getAsciiStream", Long.TYPE);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getGetCharacterStreamMethod() {
      try {
         return OracleClob.class.getMethod("getCharacterStream");
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getGetCharacterStreamLongMethod() {
      try {
         return OracleClob.class.getMethod("getCharacterStream", Long.TYPE);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getGetCharacterStreamLongLongMethod() {
      try {
         return OracleClob.class.getMethod("getCharacterStream", Long.TYPE, Long.TYPE);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getSetAsciiStreamLongMethod() {
      try {
         return OracleClob.class.getMethod("setAsciiStream", Long.TYPE);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getSetCharacterStreamLongMethod() {
      try {
         return OracleClob.class.getMethod("setCharacterStream", Long.TYPE);
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
   name = "free",
   args = {}
)}
   )
   protected void preForFree(Method var1, Object var2, Object... var3) {
      this.isFreed = true;
      super.preForAll(var1, var2, var3);
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "setString",
   args = {long.class, String.class}
), @Signature(
   name = "setString",
   args = {long.class, String.class, int.class, int.class}
), @Signature(
   name = "truncate",
   args = {long.class}
)}
   )
   protected void preForClobWrites(Method var1, Object var2, Object... var3) {
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of active transaction", (SQLRecoverableException)null);
         }

      }
   }

   @Post
   protected void postForAll(Method var1) {
      this.postForAll(var1, (Object)null);
   }

   @Post
   protected Object postForAll(Method var1, Object var2) {
      if (var2 instanceof TxnReplayableBase) {
         TxnReplayableBase var3 = (TxnReplayableBase)var2;
         var3.setFailoverManager(this.getFailoverManager());
      }

      return super.postForAll(var1, var2);
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

   public InputStream getAsciiStream() throws SQLException {
      if (GETASCIISTREAM_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get ascii stream");
      } else {
         Method var1 = GETASCIISTREAM_METHOD;
         this.preForAll(var1, this);

         try {
            OracleClob var2 = (OracleClob)this.getDelegate();
            if (this.isFreed) {
               SQLException var5 = DatabaseError.createSqlException(var2.getInternalConnection(), 192);
               var5.fillInStackTrace();
               throw var5;
            } else {
               InputStream var3;
               if (var2.canReadBasicLobDataInLocator()) {
                  var3 = var2.getAsciiStream();
               } else {
                  var3 = var2.getDBAccess().newInputStream((OracleClob)this, var2.getBufferSize(), 0L);
               }

               return (InputStream)this.postForAll(var1, var3);
            }
         } catch (SQLException var4) {
            return (InputStream)this.postForAll(var1, this.onErrorForAll(var1, var4));
         }
      }
   }

   public InputStream getAsciiStream(long var1) throws SQLException {
      if (GETASCIISTREAM_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get ascii stream");
      } else {
         Method var3 = GETASCIISTREAM_LONG_METHOD;
         this.preForAll(var3, this);

         try {
            OracleClob var4 = (OracleClob)this.getDelegate();
            if (this.isFreed) {
               SQLException var7 = DatabaseError.createSqlException(var4.getInternalConnection(), 192);
               var7.fillInStackTrace();
               throw var7;
            } else {
               InputStream var5;
               if (var4.canReadBasicLobDataInLocator()) {
                  var5 = var4.getAsciiStream(var1);
               } else {
                  var5 = var4.getDBAccess().newInputStream((OracleClob)this, var4.getBufferSize(), var1);
               }

               return (InputStream)this.postForAll(var3, var5);
            }
         } catch (SQLException var6) {
            return (InputStream)this.postForAll(var3, this.onErrorForAll(var3, var6));
         }
      }
   }

   public Reader getCharacterStream() throws SQLException {
      if (GETCHARSTREAM_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get character stream");
      } else {
         Method var1 = GETCHARSTREAM_METHOD;
         this.preForAll(var1, this);

         try {
            OracleClob var2 = (OracleClob)this.getDelegate();
            if (this.isFreed) {
               SQLException var5 = DatabaseError.createSqlException(var2.getInternalConnection(), 192);
               var5.fillInStackTrace();
               throw var5;
            } else {
               Reader var3;
               if (var2.canReadBasicLobDataInLocator()) {
                  var3 = var2.getCharacterStream();
               } else {
                  var3 = var2.getDBAccess().newReader((OracleClob)this, var2.getBufferSize(), 0L);
               }

               return (Reader)this.postForAll(var1, var3);
            }
         } catch (SQLException var4) {
            return (Reader)this.postForAll(var1, this.onErrorForAll(var1, var4));
         }
      }
   }

   public Reader getCharacterStream(long var1) throws SQLException {
      if (GETCHARSTREAM_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get character stream");
      } else {
         Method var3 = GETCHARSTREAM_LONG_METHOD;
         this.preForAll(var3, this);

         try {
            OracleClob var4 = (OracleClob)this.getDelegate();
            if (this.isFreed) {
               SQLException var7 = DatabaseError.createSqlException(var4.getInternalConnection(), 192);
               var7.fillInStackTrace();
               throw var7;
            } else {
               Reader var5;
               if (var4.canReadBasicLobDataInLocator()) {
                  var5 = var4.getCharacterStream(var1);
               } else {
                  var5 = var4.getDBAccess().newReader((OracleClob)this, var4.getBufferSize(), var1);
               }

               return (Reader)this.postForAll(var3, var5);
            }
         } catch (SQLException var6) {
            return (Reader)this.postForAll(var3, this.onErrorForAll(var3, var6));
         }
      }
   }

   public Reader getCharacterStream(long var1, long var3) throws SQLException {
      if (GETCHARSTREAM_LONG_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get character stream");
      } else {
         Method var5 = GETCHARSTREAM_LONG_LONG_METHOD;
         this.preForAll(var5, this);

         try {
            OracleClob var6 = (OracleClob)this.getDelegate();
            if (this.isFreed) {
               SQLException var12 = DatabaseError.createSqlException(var6.getInternalConnection(), 192);
               var12.fillInStackTrace();
               throw var12;
            } else {
               Reader var7;
               if (var6.canReadBasicLobDataInLocator()) {
                  var7 = var6.getCharacterStream(var1, var3);
               } else {
                  long var8 = var6.length();
                  if (var1 < 1L || var3 < 0L || var1 > var8 || var1 - 1L + var3 > var8) {
                     SQLException var10 = DatabaseError.createSqlException(var6.getInternalConnection(), 68);
                     var10.fillInStackTrace();
                     throw var10;
                  }

                  var7 = var6.getDBAccess().newReader((OracleClob)this, var6.getBufferSize(), var1, var3);
               }

               return (Reader)this.postForAll(var5, var7);
            }
         } catch (SQLException var11) {
            return (Reader)this.postForAll(var5, this.onErrorForAll(var5, var11));
         }
      }
   }

   public OutputStream setAsciiStream(long var1) throws SQLException {
      if (SETASCIISTREAM_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot set ascii stream");
      } else {
         Method var3 = SETASCIISTREAM_LONG_METHOD;
         this.preForAll(var3, this);

         try {
            OracleClob var4 = (OracleClob)this.getDelegate();
            if (this.isFreed) {
               SQLException var7 = DatabaseError.createSqlException(var4.getInternalConnection(), 192);
               var7.fillInStackTrace();
               throw var7;
            } else {
               OutputStream var5 = var4.getDBAccess().newOutputStream((OracleClob)this, var4.getBufferSize(), var1, true);
               return (OutputStream)this.postForAll(var3, var5);
            }
         } catch (SQLException var6) {
            return (OutputStream)this.postForAll(var3, this.onErrorForAll(var3, var6));
         }
      }
   }

   public Writer setCharacterStream(long var1) throws SQLException {
      if (SETCHARSTREAM_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot set character stream");
      } else {
         Method var3 = SETCHARSTREAM_LONG_METHOD;
         this.preForAll(var3, this);

         try {
            OracleClob var4 = (OracleClob)this.getDelegate();
            if (this.isFreed) {
               SQLException var7 = DatabaseError.createSqlException(var4.getInternalConnection(), 192);
               var7.fillInStackTrace();
               throw var7;
            } else {
               Writer var5 = var4.getDBAccess().newWriter((OracleClob)this, var4.getBufferSize(), var1, true);
               return (Writer)this.postForAll(var3, var5);
            }
         } catch (SQLException var6) {
            return (Writer)this.postForAll(var3, this.onErrorForAll(var3, var6));
         }
      }
   }

   public OutputStream getAsciiOutputStream() throws SQLException {
      return this.setAsciiStream(1L);
   }

   public OutputStream getAsciiOutputStream(long var1) throws SQLException {
      return this.setAsciiStream(var1);
   }

   public Writer getCharacterOutputStream() throws SQLException {
      return this.setCharacterStream(1L);
   }

   public Writer getCharacterOutputStream(long var1) throws SQLException {
      return this.setCharacterStream(var1);
   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public OracleConnection getInternalConnection() throws SQLException {
      OracleClob var1 = (OracleClob)this.getDelegate();
      return var1.getInternalConnection();
   }
}
