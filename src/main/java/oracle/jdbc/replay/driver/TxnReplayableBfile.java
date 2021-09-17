package oracle.jdbc.replay.driver;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleBfile;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyAccess;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyResult;
import oracle.jdbc.proxy.annotation.ProxyResultPolicy;
import oracle.jdbc.proxy.annotation.SetDelegate;

@ProxyFor({OracleBfile.class})
@ProxyAccess(ACProxyable.class)
public abstract class TxnReplayableBfile extends TxnReplayableBase implements JDBCReplayable {
   private static final Method GETBINSTREAM_METHOD = getGetBinaryStreamMethod();
   private static final Method GETBINSTREAM_LONG_METHOD = getGetBinaryStreamLongMethod();
   private static final int MAX_CHUNK_SIZE = 32512;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   private static final Method getGetBinaryStreamMethod() {
      try {
         return OracleBfile.class.getMethod("getBinaryStream");
      } catch (Exception var1) {
         return null;
      }
   }

   private static final Method getGetBinaryStreamLongMethod() {
      try {
         return OracleBfile.class.getMethod("getBinaryStream", Long.TYPE);
      } catch (Exception var1) {
         return null;
      }
   }

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
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
            OracleBfile var2 = (OracleBfile)this.getDelegate();
            InputStream var3 = var2.getDBAccess().newInputStream((OracleBfile)((OracleBfile)this), 32512, 0L);
            return (InputStream)this.postForAll(var1, var3);
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
            OracleBfile var4 = (OracleBfile)this.getDelegate();
            InputStream var5 = var4.getDBAccess().newInputStream((OracleBfile)((OracleBfile)this), 32512, var1);
            return (InputStream)this.postForAll(var3, var5);
         } catch (SQLException var6) {
            return (InputStream)this.postForAll(var3, this.onErrorForAll(var3, var6));
         }
      }
   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public OracleConnection getInternalConnection() throws SQLException {
      OracleBfile var1 = (OracleBfile)this.getDelegate();
      return var1.getInternalConnection();
   }
}
