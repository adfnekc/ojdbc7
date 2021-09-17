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
import oracle.jdbc.replay.driver.TxnReplayableOthers;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableOthers$2java$1sql$1SQLInput$$$Proxy extends TxnReplayableOthers implements SQLInput, _Proxy_ {
   private SQLInput delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject3785;
   private static Method methodObject3763;
   private static Method methodObject3762;
   private static Method methodObject3781;
   private static Method methodObject3770;
   private static Method methodObject3764;
   private static Method methodObject3771;
   private static Method methodObject3773;
   private static Method methodObject3760;
   private static Method methodObject3778;
   private static Method methodObject3767;
   private static Method methodObject3761;
   private static Method methodObject3769;
   private static Method methodObject3782;
   private static Method methodObject3772;
   private static Method methodObject3774;
   private static Method methodObject3779;
   private static Method methodObject3759;
   private static Method methodObject3765;
   private static Method methodObject3768;
   private static Method methodObject3766;
   private static Method methodObject3776;
   private static Method methodObject3775;
   private static Method methodObject3780;
   private static Method methodObject3777;
   private static Method methodObject3784;
   private static Method methodObject3783;

   public URL readURL() throws SQLException {
      try {
         super.preForAll(methodObject3785, this, zeroLengthObjectArray);
         return (URL)this.postForAll(methodObject3785, (Object)this.delegate.readURL());
      } catch (SQLException var2) {
         return (URL)this.postForAll(methodObject3785, this.onErrorForAll(methodObject3785, var2));
      }
   }

   public long readLong() throws SQLException {
      try {
         super.preForAll(methodObject3763, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject3763, this.delegate.readLong());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject3763, this.onErrorForAll(methodObject3763, var2));
      }
   }

   public float readFloat() throws SQLException {
      try {
         super.preForAll(methodObject3762, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject3762, this.delegate.readFloat());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject3762, this.onErrorForAll(methodObject3762, var2));
      }
   }

   public short readShort() throws SQLException {
      try {
         super.preForAll(methodObject3781, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject3781, this.delegate.readShort());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject3781, this.onErrorForAll(methodObject3781, var2));
      }
   }

   public Blob readBlob() throws SQLException {
      try {
         super.preForAll(methodObject3770, this, zeroLengthObjectArray);
         return (Blob)this.postForAll(methodObject3770, this.proxyFactory.proxyForCache((Object)this.delegate.readBlob(), this, this.proxyCache, methodObject3770));
      } catch (SQLException var2) {
         return (Blob)this.postForAll(methodObject3770, this.onErrorForAll(methodObject3770, var2));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject3764, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject3764, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject3764, this.onErrorForAll(methodObject3764, var2));
      }
   }

   public Reader readCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject3771, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject3771, (Object)this.delegate.readCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject3771, this.onErrorForAll(methodObject3771, var2));
      }
   }

   public Date readDate() throws SQLException {
      try {
         super.preForAll(methodObject3773, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject3773, (Object)this.delegate.readDate());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject3773, this.onErrorForAll(methodObject3773, var2));
      }
   }

   public int readInt() throws SQLException {
      try {
         super.preForAll(methodObject3760, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject3760, this.delegate.readInt());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject3760, this.onErrorForAll(methodObject3760, var2));
      }
   }

   public Ref readRef() throws SQLException {
      try {
         super.preForAll(methodObject3778, this, zeroLengthObjectArray);
         return (Ref)this.postForAll(methodObject3778, this.proxyFactory.proxyForCache((Object)this.delegate.readRef(), this, this.proxyCache, methodObject3778));
      } catch (SQLException var2) {
         return (Ref)this.postForAll(methodObject3778, this.onErrorForAll(methodObject3778, var2));
      }
   }

   public InputStream readAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject3767, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject3767, (Object)this.delegate.readAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject3767, this.onErrorForAll(methodObject3767, var2));
      }
   }

   public byte[] readBytes() throws SQLException {
      try {
         super.preForAll(methodObject3761, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject3761, (Object)this.delegate.readBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject3761, this.onErrorForAll(methodObject3761, var2));
      }
   }

   public InputStream readBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject3769, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject3769, (Object)this.delegate.readBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject3769, this.onErrorForAll(methodObject3769, var2));
      }
   }

   public String readString() throws SQLException {
      try {
         super.preForAll(methodObject3782, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject3782, (Object)this.delegate.readString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject3782, this.onErrorForAll(methodObject3782, var2));
      }
   }

   public Clob readClob() throws SQLException {
      try {
         super.preForAll(methodObject3772, this, zeroLengthObjectArray);
         return (Clob)this.postForAll(methodObject3772, this.proxyFactory.proxyForCache((Object)this.delegate.readClob(), this, this.proxyCache, methodObject3772));
      } catch (SQLException var2) {
         return (Clob)this.postForAll(methodObject3772, this.onErrorForAll(methodObject3772, var2));
      }
   }

   public Array readArray() throws SQLException {
      try {
         super.preForAll(methodObject3774, this, zeroLengthObjectArray);
         return (Array)this.postForAll(methodObject3774, this.proxyFactory.proxyForCache((Object)this.delegate.readArray(), this, this.proxyCache, methodObject3774));
      } catch (SQLException var2) {
         return (Array)this.postForAll(methodObject3774, this.onErrorForAll(methodObject3774, var2));
      }
   }

   public RowId readRowId() throws SQLException {
      try {
         super.preForAll(methodObject3779, this, zeroLengthObjectArray);
         return (RowId)this.postForAll(methodObject3779, this.proxyFactory.proxyForCache((Object)this.delegate.readRowId(), this, this.proxyCache, methodObject3779));
      } catch (SQLException var2) {
         return (RowId)this.postForAll(methodObject3779, this.onErrorForAll(methodObject3779, var2));
      }
   }

   public Object readObject() throws SQLException {
      try {
         super.preForAll(methodObject3759, this, zeroLengthObjectArray);
         return this.postForAll(methodObject3759, this.proxyFactory.proxyForCache(this.delegate.readObject(), this, this.proxyCache, methodObject3759));
      } catch (SQLException var2) {
         return this.postForAll(methodObject3759, this.onErrorForAll(methodObject3759, var2));
      }
   }

   public boolean readBoolean() throws SQLException {
      try {
         super.preForAll(methodObject3765, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject3765, this.delegate.readBoolean());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject3765, this.onErrorForAll(methodObject3765, var2));
      }
   }

   public BigDecimal readBigDecimal() throws SQLException {
      try {
         super.preForAll(methodObject3768, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject3768, (Object)this.delegate.readBigDecimal());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject3768, this.onErrorForAll(methodObject3768, var2));
      }
   }

   public byte readByte() throws SQLException {
      try {
         super.preForAll(methodObject3766, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject3766, this.delegate.readByte());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject3766, this.onErrorForAll(methodObject3766, var2));
      }
   }

   public NClob readNClob() throws SQLException {
      try {
         super.preForAll(methodObject3776, this, zeroLengthObjectArray);
         return (NClob)this.postForAll(methodObject3776, this.proxyFactory.proxyForCache((Object)this.delegate.readNClob(), this, this.proxyCache, methodObject3776));
      } catch (SQLException var2) {
         return (NClob)this.postForAll(methodObject3776, this.onErrorForAll(methodObject3776, var2));
      }
   }

   public double readDouble() throws SQLException {
      try {
         super.preForAll(methodObject3775, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject3775, this.delegate.readDouble());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject3775, this.onErrorForAll(methodObject3775, var2));
      }
   }

   public SQLXML readSQLXML() throws SQLException {
      try {
         super.preForAll(methodObject3780, this, zeroLengthObjectArray);
         return (SQLXML)this.postForAll(methodObject3780, this.proxyFactory.proxyForCache((Object)this.delegate.readSQLXML(), this, this.proxyCache, methodObject3780));
      } catch (SQLException var2) {
         return (SQLXML)this.postForAll(methodObject3780, this.onErrorForAll(methodObject3780, var2));
      }
   }

   public String readNString() throws SQLException {
      try {
         super.preForAll(methodObject3777, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject3777, (Object)this.delegate.readNString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject3777, this.onErrorForAll(methodObject3777, var2));
      }
   }

   public Timestamp readTimestamp() throws SQLException {
      try {
         super.preForAll(methodObject3784, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject3784, (Object)this.delegate.readTimestamp());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject3784, this.onErrorForAll(methodObject3784, var2));
      }
   }

   public Time readTime() throws SQLException {
      try {
         super.preForAll(methodObject3783, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject3783, (Object)this.delegate.readTime());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject3783, this.onErrorForAll(methodObject3783, var2));
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
         methodObject3785 = SQLInput.class.getDeclaredMethod("readURL");
         methodObject3763 = SQLInput.class.getDeclaredMethod("readLong");
         methodObject3762 = SQLInput.class.getDeclaredMethod("readFloat");
         methodObject3781 = SQLInput.class.getDeclaredMethod("readShort");
         methodObject3770 = SQLInput.class.getDeclaredMethod("readBlob");
         methodObject3764 = SQLInput.class.getDeclaredMethod("wasNull");
         methodObject3771 = SQLInput.class.getDeclaredMethod("readCharacterStream");
         methodObject3773 = SQLInput.class.getDeclaredMethod("readDate");
         methodObject3760 = SQLInput.class.getDeclaredMethod("readInt");
         methodObject3778 = SQLInput.class.getDeclaredMethod("readRef");
         methodObject3767 = SQLInput.class.getDeclaredMethod("readAsciiStream");
         methodObject3761 = SQLInput.class.getDeclaredMethod("readBytes");
         methodObject3769 = SQLInput.class.getDeclaredMethod("readBinaryStream");
         methodObject3782 = SQLInput.class.getDeclaredMethod("readString");
         methodObject3772 = SQLInput.class.getDeclaredMethod("readClob");
         methodObject3774 = SQLInput.class.getDeclaredMethod("readArray");
         methodObject3779 = SQLInput.class.getDeclaredMethod("readRowId");
         methodObject3759 = SQLInput.class.getDeclaredMethod("readObject");
         methodObject3765 = SQLInput.class.getDeclaredMethod("readBoolean");
         methodObject3768 = SQLInput.class.getDeclaredMethod("readBigDecimal");
         methodObject3766 = SQLInput.class.getDeclaredMethod("readByte");
         methodObject3776 = SQLInput.class.getDeclaredMethod("readNClob");
         methodObject3775 = SQLInput.class.getDeclaredMethod("readDouble");
         methodObject3780 = SQLInput.class.getDeclaredMethod("readSQLXML");
         methodObject3777 = SQLInput.class.getDeclaredMethod("readNString");
         methodObject3784 = SQLInput.class.getDeclaredMethod("readTimestamp");
         methodObject3783 = SQLInput.class.getDeclaredMethod("readTime");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableOthers$2java$1sql$1SQLInput$$$Proxy(SQLInput var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
