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
import oracle.jdbc.replay.driver.NonTxnReplayableClob;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableClob$2oracle$1jdbc$1OracleClob$$$Proxy extends NonTxnReplayableClob implements OracleClob, _Proxy_ {
   private OracleClob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30230;
   private static Method methodObject30221;
   private static Method methodObject30223;
   private static Method methodObject30226;
   private static Method methodObject30219;
   private static Method methodObject30225;
   private static Method methodObject30229;
   private static Method methodObject30235;
   private static Method methodObject30222;
   private static Method methodObject30231;
   private static Method methodObject30218;
   private static Method methodObject30228;
   private static Method methodObject30232;
   private static Method methodObject30224;
   private static Method methodObject30217;
   private static Method methodObject30220;
   private static Method methodObject30234;
   private static Method methodObject30233;
   private static Method methodObject30227;

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject30230, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30230, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30230, this.onErrorForAll(methodObject30230, var2));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject30221, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30221, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30221, this.onErrorForAll(methodObject30221, var2));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30223, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30223, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30223, this.onErrorForAll(methodObject30223, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject30226, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30226, var2);
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject30219, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30219, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30219, this.onErrorForAll(methodObject30219, var2));
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30225, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30225, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30225, this.onErrorForAll(methodObject30225, var5));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject30229, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30229, var4);
      }
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30235, this, arg0, arg1);
         return (String)this.postForAll(methodObject30235, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject30235, this.onErrorForAll(methodObject30235, var5));
      }
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject30222, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30222, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30222, this.onErrorForAll(methodObject30222, var2));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject30231, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject30231, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject30231, this.onErrorForAll(methodObject30231, var2));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30218, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30218, var3);
      }
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30228, this, arg0);
         return (Writer)this.postForAll(methodObject30228, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject30228, this.onErrorForAll(methodObject30228, var4));
      }
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30232, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject30232, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject30232, this.onErrorForAll(methodObject30232, var6));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30224, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30224, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30224, this.onErrorForAll(methodObject30224, var5));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject30217, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30217, var2);
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject30220, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30220, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30220, this.onErrorForAll(methodObject30220, var2));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject30234, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject30234, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject30234, this.onErrorForAll(methodObject30234, var7));
      }
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject30233, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30233, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30233, this.onErrorForAll(methodObject30233, var5));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30227, this, arg0);
         return (OutputStream)this.postForAll(methodObject30227, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30227, this.onErrorForAll(methodObject30227, var4));
      }
   }

   public OracleClob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleClob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30230 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject30221 = OracleClob.class.getDeclaredMethod("isSecureFile");
         methodObject30223 = Clob.class.getDeclaredMethod("length");
         methodObject30226 = Clob.class.getDeclaredMethod("free");
         methodObject30219 = OracleClob.class.getDeclaredMethod("isOpen");
         methodObject30225 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject30229 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject30235 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject30222 = OracleClob.class.getDeclaredMethod("isTemporary");
         methodObject30231 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject30218 = OracleClob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject30228 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject30232 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject30224 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject30217 = OracleClob.class.getDeclaredMethod("close");
         methodObject30220 = OracleClob.class.getDeclaredMethod("isEmptyLob");
         methodObject30234 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject30233 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject30227 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableClob$2oracle$1jdbc$1OracleClob$$$Proxy(OracleClob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
