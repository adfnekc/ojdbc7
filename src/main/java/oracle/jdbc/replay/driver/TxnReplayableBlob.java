package oracle.jdbc.replay.driver;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleBlob;
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

@ProxyFor({OracleBlob.class})
@ProxyAccess(ACProxyable.class)
public abstract class TxnReplayableBlob extends TxnReplayableBase implements JDBCReplayable {
   private static final Method GETBINSTREAM_METHOD = getGetBinaryStreamMethod();
   private static final Method GETBINSTREAM_LONG_METHOD = getGetBinaryStreamLongMethod();
   private static final Method GETBINSTREAM_LONG_LONG_METHOD = getGetBinaryStreamLongLongMethod();
   private static final Method SETBINSTREAM_LONG_METHOD = getSetBinaryStreamLongMethod();
   protected boolean isFreed = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   protected TxnReplayableBlob() {
      this.thisProxyNameInLog = "BLOB" + this.thisProxyNameInLog;
   }

   private static final Method getGetBinaryStreamMethod() {
      try {
         return OracleBlob.class.getMethod("getBinaryStream");
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getGetBinaryStreamLongMethod() {
      try {
         return OracleBlob.class.getMethod("getBinaryStream", Long.TYPE);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getGetBinaryStreamLongLongMethod() {
      try {
         return OracleBlob.class.getMethod("getBinaryStream", Long.TYPE, Long.TYPE);
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getSetBinaryStreamLongMethod() {
      try {
         return OracleBlob.class.getMethod("setBinaryStream", Long.TYPE);
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
   name = "setBytes",
   args = {long.class, byte.class}
), @Signature(
   name = "setBytes",
   args = {long.class, byte.class, int.class, int.class}
), @Signature(
   name = "truncate",
   args = {long.class}
)}
   )
   protected void preForBlobWrites(Method var1, Object var2, Object... var3) {
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

   public InputStream getBinaryStream() throws SQLException {
      if (GETBINSTREAM_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get binary stream");
      } else {
         Method var1 = GETBINSTREAM_METHOD;
         this.preForAll(var1, this);

         try {
            OracleBlob var2 = (OracleBlob)this.getDelegate();
            if (this.isFreed) {
               SQLException var5 = DatabaseError.createSqlException(var2.getInternalConnection(), 192);
               var5.fillInStackTrace();
               throw var5;
            } else {
               InputStream var3;
               if (var2.canReadBasicLobDataInLocator()) {
                  var3 = var2.getBinaryStream();
               } else {
                  var3 = var2.getDBAccess().newInputStream((OracleBlob)this, var2.getBufferSize(), 0L);
               }

               return (InputStream)this.postForAll(var1, var3);
            }
         } catch (SQLException var4) {
            return (InputStream)this.postForAll(var1, this.onErrorForAll(var1, var4));
         }
      }
   }

   public InputStream getBinaryStream(long var1) throws SQLException {
      if (GETBINSTREAM_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get binary stream");
      } else {
         Method var3 = GETBINSTREAM_LONG_METHOD;
         this.preForAll(var3, this);

         try {
            OracleBlob var4 = (OracleBlob)this.getDelegate();
            if (this.isFreed) {
               SQLException var7 = DatabaseError.createSqlException(var4.getInternalConnection(), 192);
               var7.fillInStackTrace();
               throw var7;
            } else {
               InputStream var5;
               if (var4.canReadBasicLobDataInLocator()) {
                  var5 = var4.getBinaryStream(var1);
               } else {
                  var5 = var4.getDBAccess().newInputStream((OracleBlob)this, var4.getBufferSize(), var1);
               }

               return (InputStream)this.postForAll(var3, var5);
            }
         } catch (SQLException var6) {
            return (InputStream)this.postForAll(var3, this.onErrorForAll(var3, var6));
         }
      }
   }

   public InputStream getBinaryStream(long var1, long var3) throws SQLException {
      if (GETBINSTREAM_LONG_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot get binary stream");
      } else {
         Method var5 = GETBINSTREAM_LONG_LONG_METHOD;
         this.preForAll(var5, this);

         try {
            OracleBlob var6 = (OracleBlob)this.getDelegate();
            if (this.isFreed) {
               SQLException var12 = DatabaseError.createSqlException(var6.getInternalConnection(), 192);
               var12.fillInStackTrace();
               throw var12;
            } else {
               InputStream var7;
               if (var6.canReadBasicLobDataInLocator()) {
                  var7 = var6.getBinaryStream(var1, var3);
               } else {
                  long var8 = var6.length();
                  if (var1 < 1L || var3 < 0L || var1 > var8 || var1 - 1L + var3 > var8) {
                     SQLException var10 = DatabaseError.createSqlException(var6.getInternalConnection(), 68);
                     var10.fillInStackTrace();
                     throw var10;
                  }

                  var7 = var6.getDBAccess().newInputStream((OracleBlob)this, var6.getBufferSize(), var1, var3);
               }

               return (InputStream)this.postForAll(var5, var7);
            }
         } catch (SQLException var11) {
            return (InputStream)this.postForAll(var5, this.onErrorForAll(var5, var11));
         }
      }
   }

   public OutputStream setBinaryStream(long var1) throws SQLException {
      if (SETBINSTREAM_LONG_METHOD == null) {
         throw DatabaseError.createSqlException(1, "Cannot set binary stream");
      } else {
         Method var3 = SETBINSTREAM_LONG_METHOD;
         this.preForAll(var3, this);

         try {
            OracleBlob var4 = (OracleBlob)this.getDelegate();
            if (this.isFreed) {
               SQLException var7 = DatabaseError.createSqlException(var4.getInternalConnection(), 192);
               var7.fillInStackTrace();
               throw var7;
            } else {
               OutputStream var5 = var4.getDBAccess().newOutputStream((OracleBlob)this, var4.getBufferSize(), var1, true);
               return (OutputStream)this.postForAll(var3, var5);
            }
         } catch (SQLException var6) {
            return (OutputStream)this.postForAll(var3, this.onErrorForAll(var3, var6));
         }
      }
   }

   public OutputStream getBinaryOutputStream() throws SQLException {
      return this.setBinaryStream(1L);
   }

   public OutputStream getBinaryOutputStream(long var1) throws SQLException {
      return this.setBinaryStream(var1);
   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public OracleConnection getInternalConnection() throws SQLException {
      OracleBlob var1 = (OracleBlob)this.getDelegate();
      return var1.getInternalConnection();
   }
}
