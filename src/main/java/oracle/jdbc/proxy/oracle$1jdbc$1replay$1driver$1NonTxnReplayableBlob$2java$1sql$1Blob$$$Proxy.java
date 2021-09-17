package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableBlob;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBlob$2java$1sql$1Blob$$$Proxy extends NonTxnReplayableBlob implements Blob, _Proxy_ {
   private Blob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30110;
   private static Method methodObject30102;
   private static Method methodObject30104;
   private static Method methodObject30106;
   private static Method methodObject30103;
   private static Method methodObject30111;
   private static Method methodObject30112;
   private static Method methodObject30108;
   private static Method methodObject30109;
   private static Method methodObject30107;
   private static Method methodObject30105;

   public int setBytes(long arg0, byte[] arg1) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30110, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30110, this.delegate.setBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30110, this.onErrorForAll(methodObject30110, var5));
      }
   }

   public byte[] getBytes(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30102, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject30102, (Object)this.delegate.getBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (byte[])this.postForAll(methodObject30102, this.onErrorForAll(methodObject30102, var5));
      }
   }

   public long position(byte[] arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30104, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30104, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30104, this.onErrorForAll(methodObject30104, var5));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject30106, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30106, var2);
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30103, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30103, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30103, this.onErrorForAll(methodObject30103, var2));
      }
   }

   public int setBytes(long arg0, byte[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30111, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject30111, this.delegate.setBytes(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject30111, this.onErrorForAll(methodObject30111, var7));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30112, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30112, var4);
      }
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject30108, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30108, (Object)super.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30108, this.onErrorForAll(methodObject30108, var2));
      }
   }

   public InputStream getBinaryStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30109, this, arg0, arg1);
         return (InputStream)this.postForAll(methodObject30109, (Object)super.getBinaryStream(arg0, arg1));
      } catch (SQLException var6) {
         return (InputStream)this.postForAll(methodObject30109, this.onErrorForAll(methodObject30109, var6));
      }
   }

   public OutputStream setBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30107, this, arg0);
         return (OutputStream)this.postForAll(methodObject30107, (Object)super.setBinaryStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30107, this.onErrorForAll(methodObject30107, var4));
      }
   }

   public long position(Blob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30105, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30105, this.delegate.position(arg0 instanceof _Proxy_ ? (Blob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30105, this.onErrorForAll(methodObject30105, var5));
      }
   }

   public Blob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (Blob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30110 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class);
         methodObject30102 = Blob.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE);
         methodObject30104 = Blob.class.getDeclaredMethod("position", byte[].class, Long.TYPE);
         methodObject30106 = Blob.class.getDeclaredMethod("free");
         methodObject30103 = Blob.class.getDeclaredMethod("length");
         methodObject30111 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class, Integer.TYPE, Integer.TYPE);
         methodObject30112 = Blob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject30108 = Blob.class.getDeclaredMethod("getBinaryStream");
         methodObject30109 = Blob.class.getDeclaredMethod("getBinaryStream", Long.TYPE, Long.TYPE);
         methodObject30107 = Blob.class.getDeclaredMethod("setBinaryStream", Long.TYPE);
         methodObject30105 = Blob.class.getDeclaredMethod("position", Blob.class, Long.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBlob$2java$1sql$1Blob$$$Proxy(Blob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
