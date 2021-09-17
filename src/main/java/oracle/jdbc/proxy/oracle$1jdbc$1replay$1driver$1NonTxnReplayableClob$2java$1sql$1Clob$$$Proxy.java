package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableClob;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableClob$2java$1sql$1Clob$$$Proxy extends NonTxnReplayableClob implements Clob, _Proxy_ {
   private Clob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30211;
   private static Method methodObject30204;
   private static Method methodObject30207;
   private static Method methodObject30206;
   private static Method methodObject30210;
   private static Method methodObject30216;
   private static Method methodObject30212;
   private static Method methodObject30209;
   private static Method methodObject30205;
   private static Method methodObject30213;
   private static Method methodObject30215;
   private static Method methodObject30214;
   private static Method methodObject30208;

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject30211, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30211, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30211, this.onErrorForAll(methodObject30211, var2));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30204, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30204, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30204, this.onErrorForAll(methodObject30204, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject30207, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30207, var2);
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30206, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30206, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30206, this.onErrorForAll(methodObject30206, var5));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject30210, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30210, var4);
      }
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30216, this, arg0, arg1);
         return (String)this.postForAll(methodObject30216, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject30216, this.onErrorForAll(methodObject30216, var5));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject30212, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject30212, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject30212, this.onErrorForAll(methodObject30212, var2));
      }
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30209, this, arg0);
         return (Writer)this.postForAll(methodObject30209, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject30209, this.onErrorForAll(methodObject30209, var4));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30205, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30205, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30205, this.onErrorForAll(methodObject30205, var5));
      }
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30213, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject30213, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject30213, this.onErrorForAll(methodObject30213, var6));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject30215, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject30215, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject30215, this.onErrorForAll(methodObject30215, var7));
      }
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject30214, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30214, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30214, this.onErrorForAll(methodObject30214, var5));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30208, this, arg0);
         return (OutputStream)this.postForAll(methodObject30208, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30208, this.onErrorForAll(methodObject30208, var4));
      }
   }

   public Clob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (Clob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30211 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject30204 = Clob.class.getDeclaredMethod("length");
         methodObject30207 = Clob.class.getDeclaredMethod("free");
         methodObject30206 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject30210 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject30216 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject30212 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject30209 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject30205 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject30213 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject30215 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject30214 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject30208 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableClob$2java$1sql$1Clob$$$Proxy(Clob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
