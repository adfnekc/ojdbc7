package oracle.jdbc.proxy;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.OracleBfile;
import oracle.jdbc.replay.driver.NonTxnReplayableBfile;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBfile$2oracle$1jdbc$1OracleBfile$$$Proxy extends NonTxnReplayableBfile implements OracleBfile, _Proxy_ {
   private OracleBfile delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30316;
   private static Method methodObject30319;
   private static Method methodObject30318;
   private static Method methodObject30323;
   private static Method methodObject30324;
   private static Method methodObject30326;
   private static Method methodObject30322;
   private static Method methodObject30327;
   private static Method methodObject30328;
   private static Method methodObject30321;
   private static Method methodObject30329;
   private static Method methodObject30325;
   private static Method methodObject30320;
   private static Method methodObject30317;
   private static Method methodObject30315;
   private static Method methodObject30330;

   public byte[] getBytes(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30316, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject30316, (Object)this.delegate.getBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (byte[])this.postForAll(methodObject30316, this.onErrorForAll(methodObject30316, var5));
      }
   }

   public long position(byte[] arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30319, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30319, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30319, this.onErrorForAll(methodObject30319, var5));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30318, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30318, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30318, this.onErrorForAll(methodObject30318, var2));
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject30323, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30323, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30323, this.onErrorForAll(methodObject30323, var2));
      }
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject30324, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30324, (Object)super.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30324, this.onErrorForAll(methodObject30324, var2));
      }
   }

   public void openFile() throws SQLException {
      try {
         super.preForAll(methodObject30326, this, zeroLengthObjectArray);
         this.delegate.openFile();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30326, var2);
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30322, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30322, var3);
      }
   }

   public boolean isFileOpen() throws SQLException {
      try {
         super.preForAll(methodObject30327, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30327, this.delegate.isFileOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30327, this.onErrorForAll(methodObject30327, var2));
      }
   }

   public boolean fileExists() throws SQLException {
      try {
         super.preForAll(methodObject30328, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30328, this.delegate.fileExists());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30328, this.onErrorForAll(methodObject30328, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject30321, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30321, var2);
      }
   }

   public void closeFile() throws SQLException {
      try {
         super.preForAll(methodObject30329, this, zeroLengthObjectArray);
         this.delegate.closeFile();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30329, var2);
      }
   }

   public InputStream getBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30325, this, arg0);
         return (InputStream)this.postForAll(methodObject30325, (Object)super.getBinaryStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject30325, this.onErrorForAll(methodObject30325, var4));
      }
   }

   public long position(OracleBfile arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30320, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30320, this.delegate.position(arg0 instanceof _Proxy_ ? (OracleBfile)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30320, this.onErrorForAll(methodObject30320, var5));
      }
   }

   public int getBytes(long arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30317, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30317, this.delegate.getBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject30317, this.onErrorForAll(methodObject30317, var6));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject30315, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30315, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30315, this.onErrorForAll(methodObject30315, var2));
      }
   }

   public String getDirAlias() throws SQLException {
      try {
         super.preForAll(methodObject30330, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30330, (Object)this.delegate.getDirAlias());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30330, this.onErrorForAll(methodObject30330, var2));
      }
   }

   public OracleBfile _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleBfile)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30316 = OracleBfile.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE);
         methodObject30319 = OracleBfile.class.getDeclaredMethod("position", byte[].class, Long.TYPE);
         methodObject30318 = OracleBfile.class.getDeclaredMethod("length");
         methodObject30323 = OracleBfile.class.getDeclaredMethod("isOpen");
         methodObject30324 = OracleBfile.class.getDeclaredMethod("getBinaryStream");
         methodObject30326 = OracleBfile.class.getDeclaredMethod("openFile");
         methodObject30322 = OracleBfile.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject30327 = OracleBfile.class.getDeclaredMethod("isFileOpen");
         methodObject30328 = OracleBfile.class.getDeclaredMethod("fileExists");
         methodObject30321 = OracleBfile.class.getDeclaredMethod("close");
         methodObject30329 = OracleBfile.class.getDeclaredMethod("closeFile");
         methodObject30325 = OracleBfile.class.getDeclaredMethod("getBinaryStream", Long.TYPE);
         methodObject30320 = OracleBfile.class.getDeclaredMethod("position", OracleBfile.class, Long.TYPE);
         methodObject30317 = OracleBfile.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE, byte[].class);
         methodObject30315 = OracleBfile.class.getDeclaredMethod("getName");
         methodObject30330 = OracleBfile.class.getDeclaredMethod("getDirAlias");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBfile$2oracle$1jdbc$1OracleBfile$$$Proxy(OracleBfile var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
