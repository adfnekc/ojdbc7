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
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.SQLXML;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableOthers;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableOthers$2java$1sql$1SQLOutput$$$Proxy extends NonTxnReplayableOthers implements SQLOutput, _Proxy_ {
   private SQLOutput delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject22723;
   private static Method methodObject22731;
   private static Method methodObject22708;
   private static Method methodObject22707;
   private static Method methodObject22714;
   private static Method methodObject22709;
   private static Method methodObject22721;
   private static Method methodObject22713;
   private static Method methodObject22720;
   private static Method methodObject22724;
   private static Method methodObject22711;
   private static Method methodObject22716;
   private static Method methodObject22733;
   private static Method methodObject22722;
   private static Method methodObject22717;
   private static Method methodObject22730;
   private static Method methodObject22732;
   private static Method methodObject22727;
   private static Method methodObject22712;
   private static Method methodObject22726;
   private static Method methodObject22725;
   private static Method methodObject22715;
   private static Method methodObject22729;
   private static Method methodObject22719;
   private static Method methodObject22710;
   private static Method methodObject22728;
   private static Method methodObject22718;

   public void writeNClob(NClob arg0) throws SQLException {
      try {
         super.preForAll(methodObject22723, this, arg0);
         this.delegate.writeNClob(arg0 instanceof _Proxy_ ? (NClob)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22723, var3);
      }
   }

   public void writeTimestamp(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject22731, this, arg0);
         this.delegate.writeTimestamp(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22731, var3);
      }
   }

   public void writeInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject22708, this, arg0);
         this.delegate.writeInt(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22708, var3);
      }
   }

   public void writeObject(SQLData arg0) throws SQLException {
      try {
         super.preForAll(methodObject22707, this, arg0);
         this.delegate.writeObject(arg0 instanceof _Proxy_ ? (SQLData)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22707, var3);
      }
   }

   public void writeDouble(double arg0) throws SQLException {
      try {
         super.preForAll(methodObject22714, this, arg0);
         this.delegate.writeDouble(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject22714, var4);
      }
   }

   public void writeBytes(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject22709, this, arg0);
         this.delegate.writeBytes(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22709, var3);
      }
   }

   public void writeClob(Clob arg0) throws SQLException {
      try {
         super.preForAll(methodObject22721, this, arg0);
         this.delegate.writeClob(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22721, var3);
      }
   }

   public void writeShort(short arg0) throws SQLException {
      try {
         super.preForAll(methodObject22713, this, arg0);
         this.delegate.writeShort(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22713, var3);
      }
   }

   public void writeCharacterStream(Reader arg0) throws SQLException {
      try {
         super.preForAll(methodObject22720, this, arg0);
         this.delegate.writeCharacterStream(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22720, var3);
      }
   }

   public void writeNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject22724, this, arg0);
         this.delegate.writeNString(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22724, var3);
      }
   }

   public void writeLong(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject22711, this, arg0);
         this.delegate.writeLong(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject22711, var4);
      }
   }

   public void writeAsciiStream(InputStream arg0) throws SQLException {
      try {
         super.preForAll(methodObject22716, this, arg0);
         this.delegate.writeAsciiStream(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22716, var3);
      }
   }

   public void writeArray(Array arg0) throws SQLException {
      try {
         super.preForAll(methodObject22733, this, arg0);
         this.delegate.writeArray(arg0 instanceof _Proxy_ ? (Array)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22733, var3);
      }
   }

   public void writeDate(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject22722, this, arg0);
         this.delegate.writeDate(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22722, var3);
      }
   }

   public void writeBigDecimal(BigDecimal arg0) throws SQLException {
      try {
         super.preForAll(methodObject22717, this, arg0);
         this.delegate.writeBigDecimal(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22717, var3);
      }
   }

   public void writeTime(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject22730, this, arg0);
         this.delegate.writeTime(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22730, var3);
      }
   }

   public void writeURL(URL arg0) throws SQLException {
      try {
         super.preForAll(methodObject22732, this, arg0);
         this.delegate.writeURL(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22732, var3);
      }
   }

   public void writeSQLXML(SQLXML arg0) throws SQLException {
      try {
         super.preForAll(methodObject22727, this, arg0);
         this.delegate.writeSQLXML(arg0 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22727, var3);
      }
   }

   public void writeByte(byte arg0) throws SQLException {
      try {
         super.preForAll(methodObject22712, this, arg0);
         this.delegate.writeByte(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22712, var3);
      }
   }

   public void writeRowId(RowId arg0) throws SQLException {
      try {
         super.preForAll(methodObject22726, this, arg0);
         this.delegate.writeRowId(arg0 instanceof _Proxy_ ? (RowId)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22726, var3);
      }
   }

   public void writeRef(Ref arg0) throws SQLException {
      try {
         super.preForAll(methodObject22725, this, arg0);
         this.delegate.writeRef(arg0 instanceof _Proxy_ ? (Ref)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22725, var3);
      }
   }

   public void writeBoolean(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject22715, this, arg0);
         this.delegate.writeBoolean(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22715, var3);
      }
   }

   public void writeStruct(Struct arg0) throws SQLException {
      try {
         super.preForAll(methodObject22729, this, arg0);
         this.delegate.writeStruct(arg0 instanceof _Proxy_ ? (Struct)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22729, var3);
      }
   }

   public void writeBlob(Blob arg0) throws SQLException {
      try {
         super.preForAll(methodObject22719, this, arg0);
         this.delegate.writeBlob(arg0 instanceof _Proxy_ ? (Blob)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22719, var3);
      }
   }

   public void writeFloat(float arg0) throws SQLException {
      try {
         super.preForAll(methodObject22710, this, arg0);
         this.delegate.writeFloat(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22710, var3);
      }
   }

   public void writeString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject22728, this, arg0);
         this.delegate.writeString(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22728, var3);
      }
   }

   public void writeBinaryStream(InputStream arg0) throws SQLException {
      try {
         super.preForAll(methodObject22718, this, arg0);
         this.delegate.writeBinaryStream(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject22718, var3);
      }
   }

   public SQLOutput _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (SQLOutput)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject22723 = SQLOutput.class.getDeclaredMethod("writeNClob", NClob.class);
         methodObject22731 = SQLOutput.class.getDeclaredMethod("writeTimestamp", Timestamp.class);
         methodObject22708 = SQLOutput.class.getDeclaredMethod("writeInt", Integer.TYPE);
         methodObject22707 = SQLOutput.class.getDeclaredMethod("writeObject", SQLData.class);
         methodObject22714 = SQLOutput.class.getDeclaredMethod("writeDouble", Double.TYPE);
         methodObject22709 = SQLOutput.class.getDeclaredMethod("writeBytes", byte[].class);
         methodObject22721 = SQLOutput.class.getDeclaredMethod("writeClob", Clob.class);
         methodObject22713 = SQLOutput.class.getDeclaredMethod("writeShort", Short.TYPE);
         methodObject22720 = SQLOutput.class.getDeclaredMethod("writeCharacterStream", Reader.class);
         methodObject22724 = SQLOutput.class.getDeclaredMethod("writeNString", String.class);
         methodObject22711 = SQLOutput.class.getDeclaredMethod("writeLong", Long.TYPE);
         methodObject22716 = SQLOutput.class.getDeclaredMethod("writeAsciiStream", InputStream.class);
         methodObject22733 = SQLOutput.class.getDeclaredMethod("writeArray", Array.class);
         methodObject22722 = SQLOutput.class.getDeclaredMethod("writeDate", Date.class);
         methodObject22717 = SQLOutput.class.getDeclaredMethod("writeBigDecimal", BigDecimal.class);
         methodObject22730 = SQLOutput.class.getDeclaredMethod("writeTime", Time.class);
         methodObject22732 = SQLOutput.class.getDeclaredMethod("writeURL", URL.class);
         methodObject22727 = SQLOutput.class.getDeclaredMethod("writeSQLXML", SQLXML.class);
         methodObject22712 = SQLOutput.class.getDeclaredMethod("writeByte", Byte.TYPE);
         methodObject22726 = SQLOutput.class.getDeclaredMethod("writeRowId", RowId.class);
         methodObject22725 = SQLOutput.class.getDeclaredMethod("writeRef", Ref.class);
         methodObject22715 = SQLOutput.class.getDeclaredMethod("writeBoolean", Boolean.TYPE);
         methodObject22729 = SQLOutput.class.getDeclaredMethod("writeStruct", Struct.class);
         methodObject22719 = SQLOutput.class.getDeclaredMethod("writeBlob", Blob.class);
         methodObject22710 = SQLOutput.class.getDeclaredMethod("writeFloat", Float.TYPE);
         methodObject22728 = SQLOutput.class.getDeclaredMethod("writeString", String.class);
         methodObject22718 = SQLOutput.class.getDeclaredMethod("writeBinaryStream", InputStream.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableOthers$2java$1sql$1SQLOutput$$$Proxy(SQLOutput var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
