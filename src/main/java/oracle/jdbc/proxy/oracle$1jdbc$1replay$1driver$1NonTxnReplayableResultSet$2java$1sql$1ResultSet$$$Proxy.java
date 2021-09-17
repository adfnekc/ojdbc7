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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableResultSet;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableResultSet$2java$1sql$1ResultSet$$$Proxy extends NonTxnReplayableResultSet implements ResultSet, _Proxy_ {
   private ResultSet delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject17231;
   private static Method methodObject17097;
   private static Method methodObject17150;
   private static Method methodObject17253;
   private static Method methodObject17167;
   private static Method methodObject17200;
   private static Method methodObject17204;
   private static Method methodObject17224;
   private static Method methodObject17146;
   private static Method methodObject17181;
   private static Method methodObject17229;
   private static Method methodObject17183;
   private static Method methodObject17217;
   private static Method methodObject17140;
   private static Method methodObject17103;
   private static Method methodObject17225;
   private static Method methodObject17254;
   private static Method methodObject17258;
   private static Method methodObject17235;
   private static Method methodObject17142;
   private static Method methodObject17248;
   private static Method methodObject17118;
   private static Method methodObject17133;
   private static Method methodObject17164;
   private static Method methodObject17206;
   private static Method methodObject17250;
   private static Method methodObject17242;
   private static Method methodObject17239;
   private static Method methodObject17099;
   private static Method methodObject17144;
   private static Method methodObject17179;
   private static Method methodObject17086;
   private static Method methodObject17170;
   private static Method methodObject17246;
   private static Method methodObject17120;
   private static Method methodObject17136;
   private static Method methodObject17207;
   private static Method methodObject17106;
   private static Method methodObject17137;
   private static Method methodObject17128;
   private static Method methodObject17091;
   private static Method methodObject17182;
   private static Method methodObject17184;
   private static Method methodObject17129;
   private static Method methodObject17117;
   private static Method methodObject17268;
   private static Method methodObject17230;
   private static Method methodObject17115;
   private static Method methodObject17095;
   private static Method methodObject17177;
   private static Method methodObject17171;
   private static Method methodObject17116;
   private static Method methodObject17119;
   private static Method methodObject17125;
   private static Method methodObject17271;
   private static Method methodObject17201;
   private static Method methodObject17261;
   private static Method methodObject17155;
   private static Method methodObject17166;
   private static Method methodObject17269;
   private static Method methodObject17265;
   private static Method methodObject17228;
   private static Method methodObject17169;
   private static Method methodObject17249;
   private static Method methodObject17134;
   private static Method methodObject17138;
   private static Method methodObject17087;
   private static Method methodObject17240;
   private static Method methodObject17221;
   private static Method methodObject17121;
   private static Method methodObject17101;
   private static Method methodObject17209;
   private static Method methodObject17172;
   private static Method methodObject17085;
   private static Method methodObject17145;
   private static Method methodObject17270;
   private static Method methodObject17215;
   private static Method methodObject17153;
   private static Method methodObject17236;
   private static Method methodObject17216;
   private static Method methodObject17152;
   private static Method methodObject17110;
   private static Method methodObject17108;
   private static Method methodObject17162;
   private static Method methodObject17252;
   private static Method methodObject17127;
   private static Method methodObject17149;
   private static Method methodObject17168;
   private static Method methodObject17234;
   private static Method methodObject17176;
   private static Method methodObject17190;
   private static Method methodObject17096;
   private static Method methodObject17093;
   private static Method methodObject17262;
   private static Method methodObject17237;
   private static Method methodObject17148;
   private static Method methodObject17154;
   private static Method methodObject17251;
   private static Method methodObject17211;
   private static Method methodObject17198;
   private static Method methodObject17100;
   private static Method methodObject17156;
   private static Method methodObject17174;
   private static Method methodObject17218;
   private static Method methodObject17090;
   private static Method methodObject17147;
   private static Method methodObject17223;
   private static Method methodObject17187;
   private static Method methodObject17192;
   private static Method methodObject17112;
   private static Method methodObject17135;
   private static Method methodObject17104;
   private static Method methodObject17188;
   private static Method methodObject17089;
   private static Method methodObject17160;
   private static Method methodObject17111;
   private static Method methodObject17263;
   private static Method methodObject17257;
   private static Method methodObject17214;
   private static Method methodObject17203;
   private static Method methodObject17197;
   private static Method methodObject17191;
   private static Method methodObject17173;
   private static Method methodObject17226;
   private static Method methodObject17114;
   private static Method methodObject17158;
   private static Method methodObject17132;
   private static Method methodObject17094;
   private static Method methodObject17131;
   private static Method methodObject17267;
   private static Method methodObject17107;
   private static Method methodObject17180;
   private static Method methodObject17139;
   private static Method methodObject17196;
   private static Method methodObject17185;
   private static Method methodObject17130;
   private static Method methodObject17092;
   private static Method methodObject17109;
   private static Method methodObject17157;
   private static Method methodObject17233;
   private static Method methodObject17244;
   private static Method methodObject17113;
   private static Method methodObject17165;
   private static Method methodObject17126;
   private static Method methodObject17259;
   private static Method methodObject17227;
   private static Method methodObject17194;
   private static Method methodObject17195;
   private static Method methodObject17102;
   private static Method methodObject17159;
   private static Method methodObject17124;
   private static Method methodObject17122;
   private static Method methodObject17105;
   private static Method methodObject17213;
   private static Method methodObject17212;
   private static Method methodObject17260;
   private static Method methodObject17189;
   private static Method methodObject17247;
   private static Method methodObject17220;
   private static Method methodObject17205;
   private static Method methodObject17266;
   private static Method methodObject17151;
   private static Method methodObject17245;
   private static Method methodObject17208;
   private static Method methodObject17256;
   private static Method methodObject17275;
   private static Method methodObject17274;
   private static Method methodObject17232;
   private static Method methodObject17088;
   private static Method methodObject17264;
   private static Method methodObject17199;
   private static Method methodObject17193;
   private static Method methodObject17243;
   private static Method methodObject17241;
   private static Method methodObject17163;
   private static Method methodObject17141;
   private static Method methodObject17175;
   private static Method methodObject17238;
   private static Method methodObject17202;
   private static Method methodObject17161;
   private static Method methodObject17178;
   private static Method methodObject17273;
   private static Method methodObject17186;
   private static Method methodObject17222;
   private static Method methodObject17272;
   private static Method methodObject17098;
   private static Method methodObject17219;
   private static Method methodObject17143;
   private static Method methodObject17210;
   private static Method methodObject17123;
   private static Method methodObject17255;

   public void updateBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject17231, this, arg0, arg1);
         Method var10001 = methodObject17231;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17231, var4);
      }
   }

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17097, this, arg0);
         return (Integer)this.postForAll(methodObject17097, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17097, this.onErrorForAll(methodObject17097, var3));
      }
   }

   public InputStream getBinaryStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17150, this, arg0);
         return (InputStream)this.postForAll(methodObject17150, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17150, this.onErrorForAll(methodObject17150, var3));
      }
   }

   public void updateNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17253, this, arg0, arg1);
         Method var10001 = methodObject17253;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17253, var4);
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17167, this, arg0, arg1);
         return (Time)this.postForAll(methodObject17167, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject17167, this.onErrorForAll(methodObject17167, var4));
      }
   }

   public InputStream getUnicodeStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17200, this, arg0);
         return (InputStream)this.postForAll(methodObject17200, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17200, this.onErrorForAll(methodObject17200, var3));
      }
   }

   public boolean isLast() throws SQLException {
      try {
         super.preForAll(methodObject17204, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17204, this.delegate.isLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17204, this.onErrorForAll(methodObject17204, var2));
      }
   }

   public void updateBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject17224, this, arg0, arg1);
         Method var10001 = methodObject17224;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17224, var4);
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17146, this, arg0, arg1);
         Method var10001 = methodObject17146;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17146, var4);
      }
   }

   public boolean first() throws SQLException {
      try {
         super.preForAll(methodObject17181, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17181, this.delegate.first());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17181, this.onErrorForAll(methodObject17181, var2));
      }
   }

   public void updateByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject17229, this, arg0, arg1);
         Method var10001 = methodObject17229;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17229, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17183, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject17183, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject17183, this.onErrorForAll(methodObject17183, var4));
      }
   }

   public void updateArray(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject17217, this, arg0, arg1);
         Method var10001 = methodObject17217;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17217, var4);
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17140, this, arg0, arg1, arg2);
         Method var10001 = methodObject17140;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17140, var6);
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17103, this, arg0);
         return (Double)this.postForAll(methodObject17103, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject17103, this.onErrorForAll(methodObject17103, var3));
      }
   }

   public void updateBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject17225, this, arg0, arg1);
         Method var10001 = methodObject17225;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17225, var4);
      }
   }

   public void updateNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17254, this, arg0, arg1);
         Method var10001 = methodObject17254;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17254, var4);
      }
   }

   public void updateObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject17258, this, arg0, arg1, arg2);
         Method var10001 = methodObject17258;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17258, var5);
      }
   }

   public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17235, this, arg0, arg1, arg2);
         Method var10001 = methodObject17235;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17235, var6);
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17142, this, arg0, arg1);
         Method var10001 = methodObject17142;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17142, var4);
      }
   }

   public void updateNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17248, this, arg0, arg1);
         Method var10001 = methodObject17248;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17248, var4);
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17118, this, arg0);
         return (String)this.postForAll(methodObject17118, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17118, this.onErrorForAll(methodObject17118, var3));
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17133, this, arg0, arg1, arg2);
         Method var10001 = methodObject17133;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17133, var5);
      }
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17164, this, arg0);
         return (Time)this.postForAll(methodObject17164, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject17164, this.onErrorForAll(methodObject17164, var3));
      }
   }

   public void moveToInsertRow() throws SQLException {
      try {
         super.preForAll(methodObject17206, this, zeroLengthObjectArray);
         Method var10001 = methodObject17206;
         this.delegate.moveToInsertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17206, var2);
      }
   }

   public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17250, this, arg0, arg1, arg2);
         Method var10001 = methodObject17250;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17250, var6);
      }
   }

   public void updateFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject17242, this, arg0, arg1);
         Method var10001 = methodObject17242;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17242, var4);
      }
   }

   public void updateDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject17239, this, arg0, arg1);
         Method var10001 = methodObject17239;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17239, var4);
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17099, this, arg0);
         return (Long)this.postForAll(methodObject17099, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject17099, this.onErrorForAll(methodObject17099, var3));
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17144, this, arg0, arg1, arg2);
         Method var10001 = methodObject17144;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17144, var6);
      }
   }

   public void cancelRowUpdates() throws SQLException {
      try {
         super.preForAll(methodObject17179, this, zeroLengthObjectArray);
         Method var10001 = methodObject17179;
         this.delegate.cancelRowUpdates();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17179, var2);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17086, this, arg0);
         return this.postForAll(methodObject17086, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0), this, this.proxyCache, methodObject17086));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17086, this.onErrorForAll(methodObject17086, var3));
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject17170, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17170, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17170, this.onErrorForAll(methodObject17170, var2));
      }
   }

   public void updateLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject17246, this, arg0, arg1);
         Method var10001 = methodObject17246;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17246, var5);
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17120, this, arg0);
         return (Date)this.postForAll(methodObject17120, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject17120, this.onErrorForAll(methodObject17120, var3));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17136, this, arg0, arg1);
         Method var10001 = methodObject17136;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17136, var4);
      }
   }

   public void refreshRow() throws SQLException {
      try {
         super.preForAll(methodObject17207, this, zeroLengthObjectArray);
         Method var10001 = methodObject17207;
         this.delegate.refreshRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17207, var2);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17106, this, arg0);
         return (byte[])this.postForAll(methodObject17106, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject17106, this.onErrorForAll(methodObject17106, var3));
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17137, this, arg0, arg1);
         Method var10001 = methodObject17137;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17137, var4);
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17128, this, arg0, arg1, arg2);
         Method var10001 = methodObject17128;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17128, var6);
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17091, this, arg0);
         return (Boolean)this.postForAll(methodObject17091, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17091, this.onErrorForAll(methodObject17091, var3));
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17182, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject17182, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject17182, this.onErrorForAll(methodObject17182, var4));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17184, this, arg0);
         return (BigDecimal)this.postForAll(methodObject17184, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject17184, this.onErrorForAll(methodObject17184, var3));
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17129, this, arg0, arg1, arg2);
         Method var10001 = methodObject17129;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17129, var6);
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17117, this, arg0);
         return (String)this.postForAll(methodObject17117, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17117, this.onErrorForAll(methodObject17117, var3));
      }
   }

   public void updateShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject17268, this, arg0, arg1);
         Method var10001 = methodObject17268;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17268, var4);
      }
   }

   public void updateBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject17230, this, arg0, arg1);
         Method var10001 = methodObject17230;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17230, var4);
      }
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17115, this, arg0);
         return (Ref)this.postForAll(methodObject17115, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject17115));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject17115, this.onErrorForAll(methodObject17115, var3));
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17095, this, arg0);
         return (Short)this.postForAll(methodObject17095, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject17095, this.onErrorForAll(methodObject17095, var3));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject17177, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17177, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17177, this.onErrorForAll(methodObject17177, var2));
      }
   }

   public void updateTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject17171, this, arg0, arg1);
         Method var10001 = methodObject17171;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17171, var4);
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17116, this, arg0);
         return (Ref)this.postForAll(methodObject17116, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject17116));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject17116, this.onErrorForAll(methodObject17116, var3));
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17119, this, arg0);
         return (Date)this.postForAll(methodObject17119, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject17119, this.onErrorForAll(methodObject17119, var3));
      }
   }

   public void updateRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17125, this, zeroLengthObjectArray);
         Method var10001 = methodObject17125;
         this.delegate.updateRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17125, var2);
      }
   }

   public void updateString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17271, this, arg0, arg1);
         Method var10001 = methodObject17271;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17271, var4);
      }
   }

   public boolean isAfterLast() throws SQLException {
      try {
         super.preForAll(methodObject17201, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17201, this.delegate.isAfterLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17201, this.onErrorForAll(methodObject17201, var2));
      }
   }

   public void updateObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject17261, this, arg0, arg1);
         Method var10001 = methodObject17261;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17261, var4);
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17155, this, arg0);
         return (Blob)this.postForAll(methodObject17155, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject17155));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject17155, this.onErrorForAll(methodObject17155, var3));
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17166, this, arg0, arg1);
         return (Time)this.postForAll(methodObject17166, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject17166, this.onErrorForAll(methodObject17166, var4));
      }
   }

   public void updateShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject17269, this, arg0, arg1);
         Method var10001 = methodObject17269;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17269, var4);
      }
   }

   public void updateRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject17265, this, arg0, arg1);
         Method var10001 = methodObject17265;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17265, var4);
      }
   }

   public void updateByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject17228, this, arg0, arg1);
         Method var10001 = methodObject17228;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17228, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject17169, this, zeroLengthObjectArray);
         Method var10001 = methodObject17169;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17169, var2);
      }
   }

   public void updateNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17249, this, arg0, arg1);
         Method var10001 = methodObject17249;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17249, var4);
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17134, this, arg0, arg1, arg2);
         Method var10001 = methodObject17134;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17134, var6);
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17138, this, arg0, arg1, arg2);
         Method var10001 = methodObject17138;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17138, var5);
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject17087, this, arg0, arg1);
         return this.postForAll(methodObject17087, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17087));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17087, this.onErrorForAll(methodObject17087, var4));
      }
   }

   public void updateDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject17240, this, arg0, arg1);
         Method var10001 = methodObject17240;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17240, var5);
      }
   }

   public void updateBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17221, this, arg0, arg1);
         Method var10001 = methodObject17221;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17221, var4);
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17121, this, arg0, arg1);
         return (Date)this.postForAll(methodObject17121, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject17121, this.onErrorForAll(methodObject17121, var4));
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17101, this, arg0);
         return (Float)this.postForAll(methodObject17101, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject17101, this.onErrorForAll(methodObject17101, var3));
      }
   }

   public boolean rowDeleted() throws SQLException {
      try {
         super.preForAll(methodObject17209, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17209, this.delegate.rowDeleted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17209, this.onErrorForAll(methodObject17209, var2));
      }
   }

   public void updateTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject17172, this, arg0, arg1);
         Method var10001 = methodObject17172;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17172, var4);
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17085, this, arg0);
         return this.postForAll(methodObject17085, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0), this, this.proxyCache, methodObject17085));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17085, this.onErrorForAll(methodObject17085, var3));
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17145, this, arg0, arg1, arg2);
         Method var10001 = methodObject17145;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17145, var6);
      }
   }

   public void updateString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17270, this, arg0, arg1);
         Method var10001 = methodObject17270;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17270, var4);
      }
   }

   public void afterLast() throws SQLException {
      try {
         super.preForAll(methodObject17215, this, zeroLengthObjectArray);
         Method var10001 = methodObject17215;
         this.delegate.afterLast();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17215, var2);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject17153, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject17153, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject17153));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject17153, this.onErrorForAll(methodObject17153, var2));
      }
   }

   public void updateClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17236, this, arg0, arg1);
         Method var10001 = methodObject17236;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17236, var4);
      }
   }

   public void updateArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject17216, this, arg0, arg1);
         Method var10001 = methodObject17216;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17216, var4);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject17152, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17152, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17152, this.onErrorForAll(methodObject17152, var2));
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17110, this, arg0);
         return (URL)this.postForAll(methodObject17110, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject17110, this.onErrorForAll(methodObject17110, var3));
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17108, this, arg0);
         return (Array)this.postForAll(methodObject17108, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject17108));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject17108, this.onErrorForAll(methodObject17108, var3));
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17162, this, arg0);
         return (SQLXML)this.postForAll(methodObject17162, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject17162));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject17162, this.onErrorForAll(methodObject17162, var3));
      }
   }

   public void updateNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17252, this, arg0, arg1);
         Method var10001 = methodObject17252;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17252, var4);
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17127, this, arg0, arg1, arg2);
         Method var10001 = methodObject17127;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17127, var5);
      }
   }

   public Statement getStatement() throws SQLException {
      try {
         super.preForAll(methodObject17149, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject17149, (Object)super.getStatement());
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject17149, this.onErrorForAll(methodObject17149, var2));
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject17168, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject17168, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject17168, this.onErrorForAll(methodObject17168, var2));
      }
   }

   public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17234, this, arg0, arg1, arg2);
         Method var10001 = methodObject17234;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17234, var6);
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17176, this, arg0);
         return (Reader)this.postForAll(methodObject17176, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17176, this.onErrorForAll(methodObject17176, var3));
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17190, this, arg0);
         return (Reader)this.postForAll(methodObject17190, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17190, this.onErrorForAll(methodObject17190, var3));
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17096, this, arg0);
         return (Short)this.postForAll(methodObject17096, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject17096, this.onErrorForAll(methodObject17096, var3));
      }
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17093, this, arg0);
         return (Byte)this.postForAll(methodObject17093, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject17093, this.onErrorForAll(methodObject17093, var3));
      }
   }

   public void updateRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject17262, this, arg0, arg1);
         Method var10001 = methodObject17262;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17262, var4);
      }
   }

   public void updateClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17237, this, arg0, arg1);
         Method var10001 = methodObject17237;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17237, var4);
      }
   }

   public boolean last() throws SQLException {
      try {
         super.preForAll(methodObject17148, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17148, this.delegate.last());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17148, this.onErrorForLast(methodObject17148, var2));
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17154, this, arg0);
         return (Blob)this.postForAll(methodObject17154, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject17154));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject17154, this.onErrorForAll(methodObject17154, var3));
      }
   }

   public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17251, this, arg0, arg1, arg2);
         Method var10001 = methodObject17251;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17251, var6);
      }
   }

   public boolean rowUpdated() throws SQLException {
      try {
         super.preForAll(methodObject17211, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17211, this.delegate.rowUpdated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17211, this.onErrorForAll(methodObject17211, var2));
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17198, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject17198, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject17198, this.onErrorForAll(methodObject17198, var4));
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17100, this, arg0);
         return (Long)this.postForAll(methodObject17100, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject17100, this.onErrorForAll(methodObject17100, var3));
      }
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17156, this, arg0);
         return (Clob)this.postForAll(methodObject17156, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject17156));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject17156, this.onErrorForAll(methodObject17156, var3));
      }
   }

   public InputStream getAsciiStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17174, this, arg0);
         return (InputStream)this.postForAll(methodObject17174, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17174, this.onErrorForAll(methodObject17174, var3));
      }
   }

   public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject17218, this, arg0, arg1);
         Method var10001 = methodObject17218;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17218, var4);
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject17090, this, arg0, arg1);
         return this.postForAll(methodObject17090, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17090));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17090, this.onErrorForAll(methodObject17090, var4));
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17147, this, arg0, arg1);
         Method var10001 = methodObject17147;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17147, var4);
      }
   }

   public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17223, this, arg0, arg1, arg2);
         Method var10001 = methodObject17223;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17223, var6);
      }
   }

   public String getCursorName() throws SQLException {
      try {
         super.preForAll(methodObject17187, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject17187, (Object)this.delegate.getCursorName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject17187, this.onErrorForAll(methodObject17187, var2));
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17192, this, arg0);
         return (String)this.postForAll(methodObject17192, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17192, this.onErrorForAll(methodObject17192, var3));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject17112, this, zeroLengthObjectArray);
         Method var10001 = methodObject17112;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17112, var2);
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17135, this, arg0, arg1, arg2);
         Method var10001 = methodObject17135;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17135, var6);
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17104, this, arg0);
         return (Double)this.postForAll(methodObject17104, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject17104, this.onErrorForAll(methodObject17104, var3));
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject17188, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17188, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17188, this.onErrorForAll(methodObject17188, var2));
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject17089, this, arg0, arg1);
         return this.postForAll(methodObject17089, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17089));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17089, this.onErrorForAll(methodObject17089, var4));
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17160, this, arg0);
         return (RowId)this.postForAll(methodObject17160, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject17160));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject17160, this.onErrorForAll(methodObject17160, var3));
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17111, this, arg0);
         return (URL)this.postForAll(methodObject17111, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject17111, this.onErrorForAll(methodObject17111, var3));
      }
   }

   public void updateRef(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject17263, this, arg0, arg1);
         Method var10001 = methodObject17263;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17263, var4);
      }
   }

   public void updateNull(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17257, this, arg0);
         Method var10001 = methodObject17257;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17257, var3);
      }
   }

   public boolean absolute(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17214, this, arg0);
         return (Boolean)this.postForAll(methodObject17214, this.delegate.absolute(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17214, this.onErrorForAll(methodObject17214, var3));
      }
   }

   public boolean isFirst() throws SQLException {
      try {
         super.preForAll(methodObject17203, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17203, this.delegate.isFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17203, this.onErrorForAll(methodObject17203, var2));
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17197, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject17197, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject17197, this.onErrorForAll(methodObject17197, var4));
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17191, this, arg0);
         return (Reader)this.postForAll(methodObject17191, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17191, this.onErrorForAll(methodObject17191, var3));
      }
   }

   public InputStream getAsciiStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17173, this, arg0);
         return (InputStream)this.postForAll(methodObject17173, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17173, this.onErrorForAll(methodObject17173, var3));
      }
   }

   public void updateBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject17226, this, arg0, arg1);
         Method var10001 = methodObject17226;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17226, var4);
      }
   }

   public boolean previous() throws SQLException {
      try {
         super.preForAll(methodObject17114, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17114, this.delegate.previous());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17114, this.onErrorForAll(methodObject17114, var2));
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17158, this, arg0);
         return (NClob)this.postForAll(methodObject17158, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject17158));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject17158, this.onErrorForAll(methodObject17158, var3));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17132, this, arg0, arg1, arg2);
         Method var10001 = methodObject17132;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17132, var5);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17094, this, arg0);
         return (Byte)this.postForAll(methodObject17094, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject17094, this.onErrorForAll(methodObject17094, var3));
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17131, this, arg0, arg1);
         Method var10001 = methodObject17131;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17131, var4);
      }
   }

   public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject17267, this, arg0, arg1);
         Method var10001 = methodObject17267;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17267, var4);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17107, this, arg0);
         return (Array)this.postForAll(methodObject17107, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject17107));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject17107, this.onErrorForAll(methodObject17107, var3));
      }
   }

   public int findColumn(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17180, this, arg0);
         return (Integer)this.postForAll(methodObject17180, this.delegate.findColumn(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17180, this.onErrorForAll(methodObject17180, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17139, this, arg0, arg1, arg2);
         Method var10001 = methodObject17139;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17139, var5);
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17196, this, arg0);
         return (Timestamp)this.postForAll(methodObject17196, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject17196, this.onErrorForAll(methodObject17196, var3));
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17185, this, arg0);
         return (BigDecimal)this.postForAll(methodObject17185, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject17185, this.onErrorForAll(methodObject17185, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17130, this, arg0, arg1);
         Method var10001 = methodObject17130;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17130, var4);
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17092, this, arg0);
         return (Boolean)this.postForAll(methodObject17092, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17092, this.onErrorForAll(methodObject17092, var3));
      }
   }

   public boolean next() throws SQLException {
      try {
         super.preForAll(methodObject17109, this, zeroLengthObjectArray);
         return this.postForNext(methodObject17109, this.delegate.next());
      } catch (SQLException var2) {
         return this.postForNext(methodObject17109, (Boolean)this.onErrorForAll(methodObject17109, var2));
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17157, this, arg0);
         return (Clob)this.postForAll(methodObject17157, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject17157));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject17157, this.onErrorForAll(methodObject17157, var3));
      }
   }

   public void updateClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17233, this, arg0, arg1);
         Method var10001 = methodObject17233;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17233, var4);
      }
   }

   public void updateInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17244, this, arg0, arg1);
         Method var10001 = methodObject17244;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17244, var4);
      }
   }

   public int getType() throws SQLException {
      try {
         super.preForAll(methodObject17113, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17113, this.delegate.getType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17113, this.onErrorForAll(methodObject17113, var2));
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17165, this, arg0);
         return (Time)this.postForAll(methodObject17165, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject17165, this.onErrorForAll(methodObject17165, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17126, this, arg0, arg1, arg2);
         Method var10001 = methodObject17126;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17126, var5);
      }
   }

   public void updateObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject17259, this, arg0, arg1);
         Method var10001 = methodObject17259;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17259, var4);
      }
   }

   public void updateBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject17227, this, arg0, arg1);
         Method var10001 = methodObject17227;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17227, var4);
      }
   }

   public int getRow() throws SQLException {
      try {
         super.preForAll(methodObject17194, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17194, this.delegate.getRow());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17194, this.onErrorForAll(methodObject17194, var2));
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17195, this, arg0);
         return (Timestamp)this.postForAll(methodObject17195, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject17195, this.onErrorForAll(methodObject17195, var3));
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17102, this, arg0);
         return (Float)this.postForAll(methodObject17102, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject17102, this.onErrorForAll(methodObject17102, var3));
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17159, this, arg0);
         return (NClob)this.postForAll(methodObject17159, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject17159));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject17159, this.onErrorForAll(methodObject17159, var3));
      }
   }

   public void insertRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17124, this, zeroLengthObjectArray);
         Method var10001 = methodObject17124;
         this.delegate.insertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17124, var2);
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17122, this, arg0, arg1);
         return (Date)this.postForAll(methodObject17122, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject17122, this.onErrorForAll(methodObject17122, var4));
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17105, this, arg0);
         return (byte[])this.postForAll(methodObject17105, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject17105, this.onErrorForAll(methodObject17105, var3));
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17213, this, arg0);
         Method var10001 = methodObject17213;
         this.delegate.setFetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17213, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17212, this, arg0);
         Method var10001 = methodObject17212;
         this.delegate.setFetchDirection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17212, var3);
      }
   }

   public void updateObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject17260, this, arg0, arg1, arg2);
         Method var10001 = methodObject17260;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17260, var5);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject17189, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17189, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17189, this.onErrorForAll(methodObject17189, var2));
      }
   }

   public void updateLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject17247, this, arg0, arg1);
         Method var10001 = methodObject17247;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17247, var5);
      }
   }

   public void updateBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17220, this, arg0, arg1);
         Method var10001 = methodObject17220;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17220, var4);
      }
   }

   public void moveToCurrentRow() throws SQLException {
      try {
         super.preForAll(methodObject17205, this, zeroLengthObjectArray);
         Method var10001 = methodObject17205;
         this.delegate.moveToCurrentRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17205, var2);
      }
   }

   public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject17266, this, arg0, arg1);
         Method var10001 = methodObject17266;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17266, var4);
      }
   }

   public InputStream getBinaryStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17151, this, arg0);
         return (InputStream)this.postForAll(methodObject17151, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17151, this.onErrorForAll(methodObject17151, var3));
      }
   }

   public void updateInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17245, this, arg0, arg1);
         Method var10001 = methodObject17245;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17245, var4);
      }
   }

   public boolean relative(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17208, this, arg0);
         return (Boolean)this.postForAll(methodObject17208, this.delegate.relative(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17208, this.onErrorForAll(methodObject17208, var3));
      }
   }

   public void updateNull(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17256, this, arg0);
         Method var10001 = methodObject17256;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17256, var3);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject17275, this, arg0);
         return (Boolean)this.postForAll(methodObject17275, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17275, this.onErrorForAll(methodObject17275, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject17274, this, arg0);
         return this.postForAll(methodObject17274, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17274, this.onErrorForAll(methodObject17274, var3));
      }
   }

   public void updateClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17232, this, arg0, arg1);
         Method var10001 = methodObject17232;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17232, var4);
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject17088, this, arg0, arg1);
         return this.postForAll(methodObject17088, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17088));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17088, this.onErrorForAll(methodObject17088, var4));
      }
   }

   public void updateRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject17264, this, arg0, arg1);
         Method var10001 = methodObject17264;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17264, var4);
      }
   }

   public InputStream getUnicodeStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17199, this, arg0);
         return (InputStream)this.postForAll(methodObject17199, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17199, this.onErrorForAll(methodObject17199, var3));
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17193, this, arg0);
         return (String)this.postForAll(methodObject17193, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17193, this.onErrorForAll(methodObject17193, var3));
      }
   }

   public void updateFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject17243, this, arg0, arg1);
         Method var10001 = methodObject17243;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17243, var4);
      }
   }

   public void updateDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject17241, this, arg0, arg1);
         Method var10001 = methodObject17241;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17241, var5);
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17163, this, arg0);
         return (SQLXML)this.postForAll(methodObject17163, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject17163));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject17163, this.onErrorForAll(methodObject17163, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17141, this, arg0, arg1, arg2);
         Method var10001 = methodObject17141;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17141, var6);
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17175, this, arg0);
         return (Reader)this.postForAll(methodObject17175, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17175, this.onErrorForAll(methodObject17175, var3));
      }
   }

   public void updateDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject17238, this, arg0, arg1);
         Method var10001 = methodObject17238;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17238, var4);
      }
   }

   public boolean isBeforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject17202, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17202, this.delegate.isBeforeFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17202, this.onErrorForAll(methodObject17202, var2));
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17161, this, arg0);
         return (RowId)this.postForAll(methodObject17161, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject17161));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject17161, this.onErrorForAll(methodObject17161, var3));
      }
   }

   public void beforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject17178, this, zeroLengthObjectArray);
         Method var10001 = methodObject17178;
         this.delegate.beforeFirst();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17178, var2);
      }
   }

   public void updateTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject17273, this, arg0, arg1);
         Method var10001 = methodObject17273;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17273, var4);
      }
   }

   public int getConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject17186, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17186, this.delegate.getConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17186, this.onErrorForAll(methodObject17186, var2));
      }
   }

   public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17222, this, arg0, arg1, arg2);
         Method var10001 = methodObject17222;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17222, var6);
      }
   }

   public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject17272, this, arg0, arg1);
         Method var10001 = methodObject17272;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17272, var4);
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17098, this, arg0);
         return (Integer)this.postForAll(methodObject17098, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17098, this.onErrorForAll(methodObject17098, var3));
      }
   }

   public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject17219, this, arg0, arg1);
         Method var10001 = methodObject17219;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17219, var4);
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17143, this, arg0, arg1);
         Method var10001 = methodObject17143;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17143, var4);
      }
   }

   public boolean rowInserted() throws SQLException {
      try {
         super.preForAll(methodObject17210, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17210, this.delegate.rowInserted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17210, this.onErrorForAll(methodObject17210, var2));
      }
   }

   public void deleteRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17123, this, zeroLengthObjectArray);
         Method var10001 = methodObject17123;
         this.delegate.deleteRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17123, var2);
      }
   }

   public void updateNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17255, this, arg0, arg1);
         Method var10001 = methodObject17255;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17255, var4);
      }
   }

   public ResultSet _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (ResultSet)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject17231 = ResultSet.class.getDeclaredMethod("updateBytes", String.class, byte[].class);
         methodObject17097 = ResultSet.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject17150 = ResultSet.class.getDeclaredMethod("getBinaryStream", Integer.TYPE);
         methodObject17253 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class);
         methodObject17167 = ResultSet.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject17200 = ResultSet.class.getDeclaredMethod("getUnicodeStream", String.class);
         methodObject17204 = ResultSet.class.getDeclaredMethod("isLast");
         methodObject17224 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class);
         methodObject17146 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class);
         methodObject17181 = ResultSet.class.getDeclaredMethod("first");
         methodObject17229 = ResultSet.class.getDeclaredMethod("updateByte", String.class, Byte.TYPE);
         methodObject17183 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class, Integer.TYPE);
         methodObject17217 = ResultSet.class.getDeclaredMethod("updateArray", String.class, Array.class);
         methodObject17140 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17103 = ResultSet.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject17225 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class);
         methodObject17254 = ResultSet.class.getDeclaredMethod("updateNString", Integer.TYPE, String.class);
         methodObject17258 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject17235 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class, Long.TYPE);
         methodObject17142 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class);
         methodObject17248 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, NClob.class);
         methodObject17118 = ResultSet.class.getDeclaredMethod("getString", String.class);
         methodObject17133 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject17164 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject17206 = ResultSet.class.getDeclaredMethod("moveToInsertRow");
         methodObject17250 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17242 = ResultSet.class.getDeclaredMethod("updateFloat", Integer.TYPE, Float.TYPE);
         methodObject17239 = ResultSet.class.getDeclaredMethod("updateDate", String.class, Date.class);
         methodObject17099 = ResultSet.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject17144 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17179 = ResultSet.class.getDeclaredMethod("cancelRowUpdates");
         methodObject17086 = ResultSet.class.getDeclaredMethod("getObject", String.class);
         methodObject17170 = ResultSet.class.getDeclaredMethod("getHoldability");
         methodObject17246 = ResultSet.class.getDeclaredMethod("updateLong", Integer.TYPE, Long.TYPE);
         methodObject17120 = ResultSet.class.getDeclaredMethod("getDate", String.class);
         methodObject17136 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class);
         methodObject17207 = ResultSet.class.getDeclaredMethod("refreshRow");
         methodObject17106 = ResultSet.class.getDeclaredMethod("getBytes", String.class);
         methodObject17137 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class);
         methodObject17128 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17091 = ResultSet.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject17182 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject17184 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject17129 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject17117 = ResultSet.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject17268 = ResultSet.class.getDeclaredMethod("updateShort", Integer.TYPE, Short.TYPE);
         methodObject17230 = ResultSet.class.getDeclaredMethod("updateBytes", Integer.TYPE, byte[].class);
         methodObject17115 = ResultSet.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject17095 = ResultSet.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject17177 = ResultSet.class.getDeclaredMethod("wasNull");
         methodObject17171 = ResultSet.class.getDeclaredMethod("updateTime", Integer.TYPE, Time.class);
         methodObject17116 = ResultSet.class.getDeclaredMethod("getRef", String.class);
         methodObject17119 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject17125 = ResultSet.class.getDeclaredMethod("updateRow");
         methodObject17271 = ResultSet.class.getDeclaredMethod("updateString", String.class, String.class);
         methodObject17201 = ResultSet.class.getDeclaredMethod("isAfterLast");
         methodObject17261 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class);
         methodObject17155 = ResultSet.class.getDeclaredMethod("getBlob", String.class);
         methodObject17166 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject17269 = ResultSet.class.getDeclaredMethod("updateShort", String.class, Short.TYPE);
         methodObject17265 = ResultSet.class.getDeclaredMethod("updateRowId", String.class, RowId.class);
         methodObject17228 = ResultSet.class.getDeclaredMethod("updateByte", Integer.TYPE, Byte.TYPE);
         methodObject17169 = ResultSet.class.getDeclaredMethod("clearWarnings");
         methodObject17249 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, NClob.class);
         methodObject17134 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17138 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject17087 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject17240 = ResultSet.class.getDeclaredMethod("updateDouble", Integer.TYPE, Double.TYPE);
         methodObject17221 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, Blob.class);
         methodObject17121 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject17101 = ResultSet.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject17209 = ResultSet.class.getDeclaredMethod("rowDeleted");
         methodObject17172 = ResultSet.class.getDeclaredMethod("updateTime", String.class, Time.class);
         methodObject17085 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject17145 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject17270 = ResultSet.class.getDeclaredMethod("updateString", Integer.TYPE, String.class);
         methodObject17215 = ResultSet.class.getDeclaredMethod("afterLast");
         methodObject17153 = ResultSet.class.getDeclaredMethod("getMetaData");
         methodObject17236 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class);
         methodObject17216 = ResultSet.class.getDeclaredMethod("updateArray", Integer.TYPE, Array.class);
         methodObject17152 = ResultSet.class.getDeclaredMethod("isClosed");
         methodObject17110 = ResultSet.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject17108 = ResultSet.class.getDeclaredMethod("getArray", String.class);
         methodObject17162 = ResultSet.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject17252 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class);
         methodObject17127 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject17149 = ResultSet.class.getDeclaredMethod("getStatement");
         methodObject17168 = ResultSet.class.getDeclaredMethod("getWarnings");
         methodObject17234 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17176 = ResultSet.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject17190 = ResultSet.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject17096 = ResultSet.class.getDeclaredMethod("getShort", String.class);
         methodObject17093 = ResultSet.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject17262 = ResultSet.class.getDeclaredMethod("updateRef", Integer.TYPE, Ref.class);
         methodObject17237 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class);
         methodObject17148 = ResultSet.class.getDeclaredMethod("last");
         methodObject17154 = ResultSet.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject17251 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class, Long.TYPE);
         methodObject17211 = ResultSet.class.getDeclaredMethod("rowUpdated");
         methodObject17198 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject17100 = ResultSet.class.getDeclaredMethod("getLong", String.class);
         methodObject17156 = ResultSet.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject17174 = ResultSet.class.getDeclaredMethod("getAsciiStream", String.class);
         methodObject17218 = ResultSet.class.getDeclaredMethod("updateBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject17090 = ResultSet.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject17147 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class);
         methodObject17223 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class, Long.TYPE);
         methodObject17187 = ResultSet.class.getDeclaredMethod("getCursorName");
         methodObject17192 = ResultSet.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject17112 = ResultSet.class.getDeclaredMethod("close");
         methodObject17135 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject17104 = ResultSet.class.getDeclaredMethod("getDouble", String.class);
         methodObject17188 = ResultSet.class.getDeclaredMethod("getFetchDirection");
         methodObject17089 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject17160 = ResultSet.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject17111 = ResultSet.class.getDeclaredMethod("getURL", String.class);
         methodObject17263 = ResultSet.class.getDeclaredMethod("updateRef", String.class, Ref.class);
         methodObject17257 = ResultSet.class.getDeclaredMethod("updateNull", String.class);
         methodObject17214 = ResultSet.class.getDeclaredMethod("absolute", Integer.TYPE);
         methodObject17203 = ResultSet.class.getDeclaredMethod("isFirst");
         methodObject17197 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject17191 = ResultSet.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject17173 = ResultSet.class.getDeclaredMethod("getAsciiStream", Integer.TYPE);
         methodObject17226 = ResultSet.class.getDeclaredMethod("updateBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject17114 = ResultSet.class.getDeclaredMethod("previous");
         methodObject17158 = ResultSet.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject17132 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject17094 = ResultSet.class.getDeclaredMethod("getByte", String.class);
         methodObject17131 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class);
         methodObject17267 = ResultSet.class.getDeclaredMethod("updateSQLXML", String.class, SQLXML.class);
         methodObject17107 = ResultSet.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject17180 = ResultSet.class.getDeclaredMethod("findColumn", String.class);
         methodObject17139 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject17196 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject17185 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject17130 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class);
         methodObject17092 = ResultSet.class.getDeclaredMethod("getBoolean", String.class);
         methodObject17109 = ResultSet.class.getDeclaredMethod("next");
         methodObject17157 = ResultSet.class.getDeclaredMethod("getClob", String.class);
         methodObject17233 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Clob.class);
         methodObject17244 = ResultSet.class.getDeclaredMethod("updateInt", Integer.TYPE, Integer.TYPE);
         methodObject17113 = ResultSet.class.getDeclaredMethod("getType");
         methodObject17165 = ResultSet.class.getDeclaredMethod("getTime", String.class);
         methodObject17126 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject17259 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class);
         methodObject17227 = ResultSet.class.getDeclaredMethod("updateBoolean", String.class, Boolean.TYPE);
         methodObject17194 = ResultSet.class.getDeclaredMethod("getRow");
         methodObject17195 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject17102 = ResultSet.class.getDeclaredMethod("getFloat", String.class);
         methodObject17159 = ResultSet.class.getDeclaredMethod("getNClob", String.class);
         methodObject17124 = ResultSet.class.getDeclaredMethod("insertRow");
         methodObject17122 = ResultSet.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject17105 = ResultSet.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject17213 = ResultSet.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject17212 = ResultSet.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject17260 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class, Integer.TYPE);
         methodObject17189 = ResultSet.class.getDeclaredMethod("getFetchSize");
         methodObject17247 = ResultSet.class.getDeclaredMethod("updateLong", String.class, Long.TYPE);
         methodObject17220 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, Blob.class);
         methodObject17205 = ResultSet.class.getDeclaredMethod("moveToCurrentRow");
         methodObject17266 = ResultSet.class.getDeclaredMethod("updateSQLXML", Integer.TYPE, SQLXML.class);
         methodObject17151 = ResultSet.class.getDeclaredMethod("getBinaryStream", String.class);
         methodObject17245 = ResultSet.class.getDeclaredMethod("updateInt", String.class, Integer.TYPE);
         methodObject17208 = ResultSet.class.getDeclaredMethod("relative", Integer.TYPE);
         methodObject17256 = ResultSet.class.getDeclaredMethod("updateNull", Integer.TYPE);
         methodObject17275 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject17274 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject17232 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Clob.class);
         methodObject17088 = ResultSet.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject17264 = ResultSet.class.getDeclaredMethod("updateRowId", Integer.TYPE, RowId.class);
         methodObject17199 = ResultSet.class.getDeclaredMethod("getUnicodeStream", Integer.TYPE);
         methodObject17193 = ResultSet.class.getDeclaredMethod("getNString", String.class);
         methodObject17243 = ResultSet.class.getDeclaredMethod("updateFloat", String.class, Float.TYPE);
         methodObject17241 = ResultSet.class.getDeclaredMethod("updateDouble", String.class, Double.TYPE);
         methodObject17163 = ResultSet.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject17141 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject17175 = ResultSet.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject17238 = ResultSet.class.getDeclaredMethod("updateDate", Integer.TYPE, Date.class);
         methodObject17202 = ResultSet.class.getDeclaredMethod("isBeforeFirst");
         methodObject17161 = ResultSet.class.getDeclaredMethod("getRowId", String.class);
         methodObject17178 = ResultSet.class.getDeclaredMethod("beforeFirst");
         methodObject17273 = ResultSet.class.getDeclaredMethod("updateTimestamp", String.class, Timestamp.class);
         methodObject17186 = ResultSet.class.getDeclaredMethod("getConcurrency");
         methodObject17222 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17272 = ResultSet.class.getDeclaredMethod("updateTimestamp", Integer.TYPE, Timestamp.class);
         methodObject17098 = ResultSet.class.getDeclaredMethod("getInt", String.class);
         methodObject17219 = ResultSet.class.getDeclaredMethod("updateBigDecimal", String.class, BigDecimal.class);
         methodObject17143 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class);
         methodObject17210 = ResultSet.class.getDeclaredMethod("rowInserted");
         methodObject17123 = ResultSet.class.getDeclaredMethod("deleteRow");
         methodObject17255 = ResultSet.class.getDeclaredMethod("updateNString", String.class, String.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableResultSet$2java$1sql$1ResultSet$$$Proxy(ResultSet var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
