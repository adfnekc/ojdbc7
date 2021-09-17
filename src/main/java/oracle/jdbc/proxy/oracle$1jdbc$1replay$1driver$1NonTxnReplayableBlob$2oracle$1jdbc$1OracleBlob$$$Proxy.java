package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.OracleBlob;
import oracle.jdbc.replay.driver.NonTxnReplayableBlob;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBlob$2oracle$1jdbc$1OracleBlob$$$Proxy extends NonTxnReplayableBlob implements OracleBlob, _Proxy_ {
   private OracleBlob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30129;
   private static Method methodObject30121;
   private static Method methodObject30119;
   private static Method methodObject30123;
   private static Method methodObject30122;
   private static Method methodObject30125;
   private static Method methodObject30130;
   private static Method methodObject30131;
   private static Method methodObject30116;
   private static Method methodObject30127;
   private static Method methodObject30120;
   private static Method methodObject30124;
   private static Method methodObject30115;
   private static Method methodObject30114;
   private static Method methodObject30117;
   private static Method methodObject30118;
   private static Method methodObject30128;
   private static Method methodObject30126;
   private static Method methodObject30113;

   public int setBytes(long arg0, byte[] arg1) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30129, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30129, this.delegate.setBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30129, this.onErrorForAll(methodObject30129, var5));
      }
   }

   public byte[] getBytes(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30121, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject30121, (Object)this.delegate.getBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (byte[])this.postForAll(methodObject30121, this.onErrorForAll(methodObject30121, var5));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject30119, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30119, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30119, this.onErrorForAll(methodObject30119, var2));
      }
   }

   public long position(byte[] arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30123, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30123, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30123, this.onErrorForAll(methodObject30123, var5));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30122, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30122, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30122, this.onErrorForAll(methodObject30122, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject30125, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30125, var2);
      }
   }

   public int setBytes(long arg0, byte[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30130, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject30130, this.delegate.setBytes(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject30130, this.onErrorForAll(methodObject30130, var7));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30131, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30131, var4);
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject30116, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30116, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30116, this.onErrorForAll(methodObject30116, var2));
      }
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject30127, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30127, (Object)super.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30127, this.onErrorForAll(methodObject30127, var2));
      }
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject30120, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30120, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30120, this.onErrorForAll(methodObject30120, var2));
      }
   }

   public long position(Blob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30124, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30124, this.delegate.position(arg0 instanceof _Proxy_ ? (Blob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30124, this.onErrorForAll(methodObject30124, var5));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30115, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30115, var3);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject30114, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30114, var2);
      }
   }

   public InputStream getBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30117, this, arg0);
         return (InputStream)this.postForAll(methodObject30117, (Object)super.getBinaryStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject30117, this.onErrorForAll(methodObject30117, var4));
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject30118, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30118, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30118, this.onErrorForAll(methodObject30118, var2));
      }
   }

   public InputStream getBinaryStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30128, this, arg0, arg1);
         return (InputStream)this.postForAll(methodObject30128, (Object)super.getBinaryStream(arg0, arg1));
      } catch (SQLException var6) {
         return (InputStream)this.postForAll(methodObject30128, this.onErrorForAll(methodObject30128, var6));
      }
   }

   public OutputStream setBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30126, this, arg0);
         return (OutputStream)this.postForAll(methodObject30126, (Object)super.setBinaryStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30126, this.onErrorForAll(methodObject30126, var4));
      }
   }

   public int getBytes(long arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30113, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30113, this.delegate.getBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject30113, this.onErrorForAll(methodObject30113, var6));
      }
   }

   public OracleBlob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleBlob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30129 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class);
         methodObject30121 = Blob.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE);
         methodObject30119 = OracleBlob.class.getDeclaredMethod("isSecureFile");
         methodObject30123 = Blob.class.getDeclaredMethod("position", byte[].class, Long.TYPE);
         methodObject30122 = Blob.class.getDeclaredMethod("length");
         methodObject30125 = Blob.class.getDeclaredMethod("free");
         methodObject30130 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class, Integer.TYPE, Integer.TYPE);
         methodObject30131 = Blob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject30116 = OracleBlob.class.getDeclaredMethod("isOpen");
         methodObject30127 = Blob.class.getDeclaredMethod("getBinaryStream");
         methodObject30120 = OracleBlob.class.getDeclaredMethod("isTemporary");
         methodObject30124 = Blob.class.getDeclaredMethod("position", Blob.class, Long.TYPE);
         methodObject30115 = OracleBlob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject30114 = OracleBlob.class.getDeclaredMethod("close");
         methodObject30117 = OracleBlob.class.getDeclaredMethod("getBinaryStream", Long.TYPE);
         methodObject30118 = OracleBlob.class.getDeclaredMethod("isEmptyLob");
         methodObject30128 = Blob.class.getDeclaredMethod("getBinaryStream", Long.TYPE, Long.TYPE);
         methodObject30126 = Blob.class.getDeclaredMethod("setBinaryStream", Long.TYPE);
         methodObject30113 = OracleBlob.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE, byte[].class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBlob$2oracle$1jdbc$1OracleBlob$$$Proxy(OracleBlob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
