package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableNClob;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableNClob$2java$1sql$1NClob$$$Proxy extends NonTxnReplayableNClob implements NClob, _Proxy_ {
   private NClob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject25204;
   private static Method methodObject25197;
   private static Method methodObject25200;
   private static Method methodObject25199;
   private static Method methodObject25203;
   private static Method methodObject25209;
   private static Method methodObject25205;
   private static Method methodObject25202;
   private static Method methodObject25198;
   private static Method methodObject25206;
   private static Method methodObject25208;
   private static Method methodObject25207;
   private static Method methodObject25201;

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject25204, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25204, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25204, this.onErrorForAll(methodObject25204, var2));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject25197, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject25197, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject25197, this.onErrorForAll(methodObject25197, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject25200, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject25200, var2);
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25199, this, arg0, arg1);
         return (Long)this.postForAll(methodObject25199, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject25199, this.onErrorForAll(methodObject25199, var5));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject25203, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject25203, var4);
      }
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject25209, this, arg0, arg1);
         return (String)this.postForAll(methodObject25209, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject25209, this.onErrorForAll(methodObject25209, var5));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject25205, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject25205, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject25205, this.onErrorForAll(methodObject25205, var2));
      }
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25202, this, arg0);
         return (Writer)this.postForAll(methodObject25202, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject25202, this.onErrorForAll(methodObject25202, var4));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25198, this, arg0, arg1);
         return (Long)this.postForAll(methodObject25198, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject25198, this.onErrorForAll(methodObject25198, var5));
      }
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25206, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject25206, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject25206, this.onErrorForAll(methodObject25206, var6));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject25208, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject25208, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject25208, this.onErrorForAll(methodObject25208, var7));
      }
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject25207, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject25207, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject25207, this.onErrorForAll(methodObject25207, var5));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25201, this, arg0);
         return (OutputStream)this.postForAll(methodObject25201, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject25201, this.onErrorForAll(methodObject25201, var4));
      }
   }

   public NClob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (NClob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject25204 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject25197 = Clob.class.getDeclaredMethod("length");
         methodObject25200 = Clob.class.getDeclaredMethod("free");
         methodObject25199 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject25203 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject25209 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject25205 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject25202 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject25198 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject25206 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject25208 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject25207 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject25201 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableNClob$2java$1sql$1NClob$$$Proxy(NClob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
