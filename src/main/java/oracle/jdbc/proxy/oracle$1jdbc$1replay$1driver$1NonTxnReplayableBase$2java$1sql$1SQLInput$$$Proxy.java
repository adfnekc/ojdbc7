package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1SQLInput$$$Proxy extends NonTxnReplayableBase implements SQLInput, _Proxy_ {
   private SQLInput delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29804;
   private static Method methodObject29783;
   private static Method methodObject29782;
   private static Method methodObject29800;
   private static Method methodObject29788;
   private static Method methodObject29805;
   private static Method methodObject29791;
   private static Method methodObject29793;
   private static Method methodObject29780;
   private static Method methodObject29797;
   private static Method methodObject29785;
   private static Method methodObject29781;
   private static Method methodObject29787;
   private static Method methodObject29801;
   private static Method methodObject29792;
   private static Method methodObject29784;
   private static Method methodObject29798;
   private static Method methodObject29779;
   private static Method methodObject29789;
   private static Method methodObject29786;
   private static Method methodObject29790;
   private static Method methodObject29795;
   private static Method methodObject29794;
   private static Method methodObject29799;
   private static Method methodObject29796;
   private static Method methodObject29802;
   private static Method methodObject29803;

   public URL readURL() throws SQLException {
      try {
         super.preForAll(methodObject29804, this, zeroLengthObjectArray);
         return (URL)this.postForAll(methodObject29804, (Object)this.delegate.readURL());
      } catch (SQLException var2) {
         return (URL)this.postForAll(methodObject29804, this.onErrorForAll(methodObject29804, var2));
      }
   }

   public long readLong() throws SQLException {
      try {
         super.preForAll(methodObject29783, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject29783, this.delegate.readLong());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject29783, this.onErrorForAll(methodObject29783, var2));
      }
   }

   public float readFloat() throws SQLException {
      try {
         super.preForAll(methodObject29782, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject29782, this.delegate.readFloat());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject29782, this.onErrorForAll(methodObject29782, var2));
      }
   }

   public short readShort() throws SQLException {
      try {
         super.preForAll(methodObject29800, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject29800, this.delegate.readShort());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject29800, this.onErrorForAll(methodObject29800, var2));
      }
   }

   public Blob readBlob() throws SQLException {
      try {
         super.preForAll(methodObject29788, this, zeroLengthObjectArray);
         return (Blob)this.postForAll(methodObject29788, this.proxyFactory.proxyForCache((Object)this.delegate.readBlob(), this, this.proxyCache, methodObject29788));
      } catch (SQLException var2) {
         return (Blob)this.postForAll(methodObject29788, this.onErrorForAll(methodObject29788, var2));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject29805, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29805, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29805, this.onErrorForAll(methodObject29805, var2));
      }
   }

   public Reader readCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject29791, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject29791, (Object)this.delegate.readCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject29791, this.onErrorForAll(methodObject29791, var2));
      }
   }

   public Date readDate() throws SQLException {
      try {
         super.preForAll(methodObject29793, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject29793, (Object)this.delegate.readDate());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject29793, this.onErrorForAll(methodObject29793, var2));
      }
   }

   public int readInt() throws SQLException {
      try {
         super.preForAll(methodObject29780, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29780, this.delegate.readInt());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29780, this.onErrorForAll(methodObject29780, var2));
      }
   }

   public Ref readRef() throws SQLException {
      try {
         super.preForAll(methodObject29797, this, zeroLengthObjectArray);
         return (Ref)this.postForAll(methodObject29797, this.proxyFactory.proxyForCache((Object)this.delegate.readRef(), this, this.proxyCache, methodObject29797));
      } catch (SQLException var2) {
         return (Ref)this.postForAll(methodObject29797, this.onErrorForAll(methodObject29797, var2));
      }
   }

   public InputStream readAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject29785, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject29785, (Object)this.delegate.readAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject29785, this.onErrorForAll(methodObject29785, var2));
      }
   }

   public byte[] readBytes() throws SQLException {
      try {
         super.preForAll(methodObject29781, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject29781, (Object)this.delegate.readBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject29781, this.onErrorForAll(methodObject29781, var2));
      }
   }

   public InputStream readBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject29787, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject29787, (Object)this.delegate.readBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject29787, this.onErrorForAll(methodObject29787, var2));
      }
   }

   public String readString() throws SQLException {
      try {
         super.preForAll(methodObject29801, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29801, (Object)this.delegate.readString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29801, this.onErrorForAll(methodObject29801, var2));
      }
   }

   public Clob readClob() throws SQLException {
      try {
         super.preForAll(methodObject29792, this, zeroLengthObjectArray);
         return (Clob)this.postForAll(methodObject29792, this.proxyFactory.proxyForCache((Object)this.delegate.readClob(), this, this.proxyCache, methodObject29792));
      } catch (SQLException var2) {
         return (Clob)this.postForAll(methodObject29792, this.onErrorForAll(methodObject29792, var2));
      }
   }

   public Array readArray() throws SQLException {
      try {
         super.preForAll(methodObject29784, this, zeroLengthObjectArray);
         return (Array)this.postForAll(methodObject29784, this.proxyFactory.proxyForCache((Object)this.delegate.readArray(), this, this.proxyCache, methodObject29784));
      } catch (SQLException var2) {
         return (Array)this.postForAll(methodObject29784, this.onErrorForAll(methodObject29784, var2));
      }
   }

   public RowId readRowId() throws SQLException {
      try {
         super.preForAll(methodObject29798, this, zeroLengthObjectArray);
         return (RowId)this.postForAll(methodObject29798, this.proxyFactory.proxyForCache((Object)this.delegate.readRowId(), this, this.proxyCache, methodObject29798));
      } catch (SQLException var2) {
         return (RowId)this.postForAll(methodObject29798, this.onErrorForAll(methodObject29798, var2));
      }
   }

   public Object readObject() throws SQLException {
      try {
         super.preForAll(methodObject29779, this, zeroLengthObjectArray);
         return this.postForAll(methodObject29779, this.proxyFactory.proxyForCache(this.delegate.readObject(), this, this.proxyCache, methodObject29779));
      } catch (SQLException var2) {
         return this.postForAll(methodObject29779, this.onErrorForAll(methodObject29779, var2));
      }
   }

   public boolean readBoolean() throws SQLException {
      try {
         super.preForAll(methodObject29789, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29789, this.delegate.readBoolean());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29789, this.onErrorForAll(methodObject29789, var2));
      }
   }

   public BigDecimal readBigDecimal() throws SQLException {
      try {
         super.preForAll(methodObject29786, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject29786, (Object)this.delegate.readBigDecimal());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject29786, this.onErrorForAll(methodObject29786, var2));
      }
   }

   public byte readByte() throws SQLException {
      try {
         super.preForAll(methodObject29790, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject29790, this.delegate.readByte());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject29790, this.onErrorForAll(methodObject29790, var2));
      }
   }

   public NClob readNClob() throws SQLException {
      try {
         super.preForAll(methodObject29795, this, zeroLengthObjectArray);
         return (NClob)this.postForAll(methodObject29795, this.proxyFactory.proxyForCache((Object)this.delegate.readNClob(), this, this.proxyCache, methodObject29795));
      } catch (SQLException var2) {
         return (NClob)this.postForAll(methodObject29795, this.onErrorForAll(methodObject29795, var2));
      }
   }

   public double readDouble() throws SQLException {
      try {
         super.preForAll(methodObject29794, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject29794, this.delegate.readDouble());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject29794, this.onErrorForAll(methodObject29794, var2));
      }
   }

   public SQLXML readSQLXML() throws SQLException {
      try {
         super.preForAll(methodObject29799, this, zeroLengthObjectArray);
         return (SQLXML)this.postForAll(methodObject29799, this.proxyFactory.proxyForCache((Object)this.delegate.readSQLXML(), this, this.proxyCache, methodObject29799));
      } catch (SQLException var2) {
         return (SQLXML)this.postForAll(methodObject29799, this.onErrorForAll(methodObject29799, var2));
      }
   }

   public String readNString() throws SQLException {
      try {
         super.preForAll(methodObject29796, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29796, (Object)this.delegate.readNString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29796, this.onErrorForAll(methodObject29796, var2));
      }
   }

   public Time readTime() throws SQLException {
      try {
         super.preForAll(methodObject29802, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject29802, (Object)this.delegate.readTime());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject29802, this.onErrorForAll(methodObject29802, var2));
      }
   }

   public Timestamp readTimestamp() throws SQLException {
      try {
         super.preForAll(methodObject29803, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject29803, (Object)this.delegate.readTimestamp());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject29803, this.onErrorForAll(methodObject29803, var2));
      }
   }

   public SQLInput _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (SQLInput)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29804 = SQLInput.class.getDeclaredMethod("readURL");
         methodObject29783 = SQLInput.class.getDeclaredMethod("readLong");
         methodObject29782 = SQLInput.class.getDeclaredMethod("readFloat");
         methodObject29800 = SQLInput.class.getDeclaredMethod("readShort");
         methodObject29788 = SQLInput.class.getDeclaredMethod("readBlob");
         methodObject29805 = SQLInput.class.getDeclaredMethod("wasNull");
         methodObject29791 = SQLInput.class.getDeclaredMethod("readCharacterStream");
         methodObject29793 = SQLInput.class.getDeclaredMethod("readDate");
         methodObject29780 = SQLInput.class.getDeclaredMethod("readInt");
         methodObject29797 = SQLInput.class.getDeclaredMethod("readRef");
         methodObject29785 = SQLInput.class.getDeclaredMethod("readAsciiStream");
         methodObject29781 = SQLInput.class.getDeclaredMethod("readBytes");
         methodObject29787 = SQLInput.class.getDeclaredMethod("readBinaryStream");
         methodObject29801 = SQLInput.class.getDeclaredMethod("readString");
         methodObject29792 = SQLInput.class.getDeclaredMethod("readClob");
         methodObject29784 = SQLInput.class.getDeclaredMethod("readArray");
         methodObject29798 = SQLInput.class.getDeclaredMethod("readRowId");
         methodObject29779 = SQLInput.class.getDeclaredMethod("readObject");
         methodObject29789 = SQLInput.class.getDeclaredMethod("readBoolean");
         methodObject29786 = SQLInput.class.getDeclaredMethod("readBigDecimal");
         methodObject29790 = SQLInput.class.getDeclaredMethod("readByte");
         methodObject29795 = SQLInput.class.getDeclaredMethod("readNClob");
         methodObject29794 = SQLInput.class.getDeclaredMethod("readDouble");
         methodObject29799 = SQLInput.class.getDeclaredMethod("readSQLXML");
         methodObject29796 = SQLInput.class.getDeclaredMethod("readNString");
         methodObject29802 = SQLInput.class.getDeclaredMethod("readTime");
         methodObject29803 = SQLInput.class.getDeclaredMethod("readTimestamp");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1SQLInput$$$Proxy(SQLInput var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
