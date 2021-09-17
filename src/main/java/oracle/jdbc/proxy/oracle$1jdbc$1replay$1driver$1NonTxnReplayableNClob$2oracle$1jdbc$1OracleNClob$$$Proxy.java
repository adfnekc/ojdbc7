package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.OracleClob;
import oracle.jdbc.OracleNClob;
import oracle.jdbc.replay.driver.NonTxnReplayableNClob;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableNClob$2oracle$1jdbc$1OracleNClob$$$Proxy extends NonTxnReplayableNClob implements OracleNClob, _Proxy_ {
   private OracleNClob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject25217;
   private static Method methodObject25227;
   private static Method methodObject25210;
   private static Method methodObject25213;
   private static Method methodObject25225;
   private static Method methodObject25212;
   private static Method methodObject25216;
   private static Method methodObject25222;
   private static Method methodObject25228;
   private static Method methodObject25218;
   private static Method methodObject25224;
   private static Method methodObject25215;
   private static Method methodObject25211;
   private static Method methodObject25219;
   private static Method methodObject25223;
   private static Method methodObject25226;
   private static Method methodObject25221;
   private static Method methodObject25220;
   private static Method methodObject25214;

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject25217, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25217, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25217, this.onErrorForAll(methodObject25217, var2));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject25227, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25227, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25227, this.onErrorForAll(methodObject25227, var2));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject25210, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject25210, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject25210, this.onErrorForAll(methodObject25210, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject25213, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject25213, var2);
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject25225, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25225, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25225, this.onErrorForAll(methodObject25225, var2));
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25212, this, arg0, arg1);
         return (Long)this.postForAll(methodObject25212, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject25212, this.onErrorForAll(methodObject25212, var5));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject25216, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject25216, var4);
      }
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject25222, this, arg0, arg1);
         return (String)this.postForAll(methodObject25222, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject25222, this.onErrorForAll(methodObject25222, var5));
      }
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject25228, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25228, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25228, this.onErrorForAll(methodObject25228, var2));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject25218, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject25218, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject25218, this.onErrorForAll(methodObject25218, var2));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject25224, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject25224, var3);
      }
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25215, this, arg0);
         return (Writer)this.postForAll(methodObject25215, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject25215, this.onErrorForAll(methodObject25215, var4));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25211, this, arg0, arg1);
         return (Long)this.postForAll(methodObject25211, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject25211, this.onErrorForAll(methodObject25211, var5));
      }
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25219, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject25219, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject25219, this.onErrorForAll(methodObject25219, var6));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject25223, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject25223, var2);
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject25226, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25226, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25226, this.onErrorForAll(methodObject25226, var2));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject25221, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject25221, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject25221, this.onErrorForAll(methodObject25221, var7));
      }
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject25220, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject25220, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject25220, this.onErrorForAll(methodObject25220, var5));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25214, this, arg0);
         return (OutputStream)this.postForAll(methodObject25214, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject25214, this.onErrorForAll(methodObject25214, var4));
      }
   }

   public OracleNClob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleNClob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject25217 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject25227 = OracleClob.class.getDeclaredMethod("isSecureFile");
         methodObject25210 = Clob.class.getDeclaredMethod("length");
         methodObject25213 = Clob.class.getDeclaredMethod("free");
         methodObject25225 = OracleClob.class.getDeclaredMethod("isOpen");
         methodObject25212 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject25216 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject25222 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject25228 = OracleClob.class.getDeclaredMethod("isTemporary");
         methodObject25218 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject25224 = OracleClob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject25215 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject25211 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject25219 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject25223 = OracleClob.class.getDeclaredMethod("close");
         methodObject25226 = OracleClob.class.getDeclaredMethod("isEmptyLob");
         methodObject25221 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject25220 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject25214 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableNClob$2oracle$1jdbc$1OracleNClob$$$Proxy(OracleNClob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
