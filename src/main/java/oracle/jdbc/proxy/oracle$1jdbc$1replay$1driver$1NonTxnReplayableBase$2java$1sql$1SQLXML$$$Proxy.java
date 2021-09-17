package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.util.Map;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1SQLXML$$$Proxy extends NonTxnReplayableBase implements SQLXML, _Proxy_ {
   private SQLXML delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29808;
   private static Method methodObject29807;
   private static Method methodObject29810;
   private static Method methodObject29814;
   private static Method methodObject29813;
   private static Method methodObject29811;
   private static Method methodObject29809;
   private static Method methodObject29812;
   private static Method methodObject29806;

   public OutputStream setBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject29808, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject29808, (Object)this.delegate.setBinaryStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject29808, this.onErrorForAll(methodObject29808, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject29807, this, zeroLengthObjectArray);
         Method var10001 = methodObject29807;
         this.delegate.free();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject29807, var2);
      }
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject29810, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject29810, (Object)this.delegate.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject29810, this.onErrorForAll(methodObject29810, var2));
      }
   }

   public Result setResult(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29814, this, arg0);
         return (Result)this.postForAll(methodObject29814, (Object)this.delegate.setResult(arg0));
      } catch (SQLException var3) {
         return (Result)this.postForAll(methodObject29814, this.onErrorForAll(methodObject29814, var3));
      }
   }

   public Source getSource(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29813, this, arg0);
         return (Source)this.postForAll(methodObject29813, (Object)this.delegate.getSource(arg0));
      } catch (SQLException var3) {
         return (Source)this.postForAll(methodObject29813, this.onErrorForAll(methodObject29813, var3));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject29811, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject29811, (Object)this.delegate.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject29811, this.onErrorForAll(methodObject29811, var2));
      }
   }

   public Writer setCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject29809, this, zeroLengthObjectArray);
         return (Writer)this.postForAll(methodObject29809, (Object)this.delegate.setCharacterStream());
      } catch (SQLException var2) {
         return (Writer)this.postForAll(methodObject29809, this.onErrorForAll(methodObject29809, var2));
      }
   }

   public void setString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject29812, this, arg0);
         Method var10001 = methodObject29812;
         this.delegate.setString(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject29812, var3);
      }
   }

   public String getString() throws SQLException {
      try {
         super.preForAll(methodObject29806, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29806, (Object)this.delegate.getString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29806, this.onErrorForAll(methodObject29806, var2));
      }
   }

   public SQLXML _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (SQLXML)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29808 = SQLXML.class.getDeclaredMethod("setBinaryStream");
         methodObject29807 = SQLXML.class.getDeclaredMethod("free");
         methodObject29810 = SQLXML.class.getDeclaredMethod("getBinaryStream");
         methodObject29814 = SQLXML.class.getDeclaredMethod("setResult", Class.class);
         methodObject29813 = SQLXML.class.getDeclaredMethod("getSource", Class.class);
         methodObject29811 = SQLXML.class.getDeclaredMethod("getCharacterStream");
         methodObject29809 = SQLXML.class.getDeclaredMethod("setCharacterStream");
         methodObject29812 = SQLXML.class.getDeclaredMethod("setString", String.class);
         methodObject29806 = SQLXML.class.getDeclaredMethod("getString");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1SQLXML$$$Proxy(SQLXML var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
