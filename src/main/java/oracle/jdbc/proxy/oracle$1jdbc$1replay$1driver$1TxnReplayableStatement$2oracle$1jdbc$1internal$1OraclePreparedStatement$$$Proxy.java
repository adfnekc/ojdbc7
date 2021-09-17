package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
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
import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OraclePreparedStatement;
import oracle.jdbc.internal.OracleStatement;
import oracle.jdbc.replay.driver.TxnReplayableStatement;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableStatement$2oracle$1jdbc$1internal$1OraclePreparedStatement$$$Proxy extends TxnReplayableStatement implements OraclePreparedStatement, _Proxy_ {
   private OraclePreparedStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject5626;
   private static Method methodObject5605;
   private static Method methodObject5562;
   private static Method methodObject5684;
   private static Method methodObject5736;
   private static Method methodObject5565;
   private static Method methodObject5561;
   private static Method methodObject5559;
   private static Method methodObject5668;
   private static Method methodObject5734;
   private static Method methodObject5695;
   private static Method methodObject5566;
   private static Method methodObject5593;
   private static Method methodObject5675;
   private static Method methodObject5554;
   private static Method methodObject5552;
   private static Method methodObject5750;
   private static Method methodObject5500;
   private static Method methodObject5567;
   private static Method methodObject5640;
   private static Method methodObject5608;
   private static Method methodObject5678;
   private static Method methodObject5721;
   private static Method methodObject5585;
   private static Method methodObject5602;
   private static Method methodObject5733;
   private static Method methodObject5719;
   private static Method methodObject5556;
   private static Method methodObject5720;
   private static Method methodObject5650;
   private static Method methodObject5520;
   private static Method methodObject5544;
   private static Method methodObject5630;
   private static Method methodObject5644;
   private static Method methodObject5728;
   private static Method methodObject5677;
   private static Method methodObject5570;
   private static Method methodObject5511;
   private static Method methodObject5563;
   private static Method methodObject5705;
   private static Method methodObject5603;
   private static Method methodObject5718;
   private static Method methodObject5580;
   private static Method methodObject5729;
   private static Method methodObject5619;
   private static Method methodObject5717;
   private static Method methodObject5558;
   private static Method methodObject5656;
   private static Method methodObject5660;
   private static Method methodObject5535;
   private static Method methodObject5757;
   private static Method methodObject5532;
   private static Method methodObject5697;
   private static Method methodObject5553;
   private static Method methodObject5652;
   private static Method methodObject5621;
   private static Method methodObject5513;
   private static Method methodObject5612;
   private static Method methodObject5595;
   private static Method methodObject5643;
   private static Method methodObject5661;
   private static Method methodObject5699;
   private static Method methodObject5702;
   private static Method methodObject5672;
   private static Method methodObject5749;
   private static Method methodObject5724;
   private static Method methodObject5620;
   private static Method methodObject5647;
   private static Method methodObject5755;
   private static Method methodObject5710;
   private static Method methodObject5649;
   private static Method methodObject5670;
   private static Method methodObject5738;
   private static Method methodObject5708;
   private static Method methodObject5557;
   private static Method methodObject5498;
   private static Method methodObject5637;
   private static Method methodObject5704;
   private static Method methodObject5516;
   private static Method methodObject5693;
   private static Method methodObject5509;
   private static Method methodObject5748;
   private static Method methodObject5714;
   private static Method methodObject5623;
   private static Method methodObject5754;
   private static Method methodObject5594;
   private static Method methodObject5662;
   private static Method methodObject5646;
   private static Method methodObject5690;
   private static Method methodObject5727;
   private static Method methodObject5564;
   private static Method methodObject5597;
   private static Method methodObject5607;
   private static Method methodObject5737;
   private static Method methodObject5589;
   private static Method methodObject5598;
   private static Method methodObject5576;
   private static Method methodObject5615;
   private static Method methodObject5627;
   private static Method methodObject5665;
   private static Method methodObject5731;
   private static Method methodObject5523;
   private static Method methodObject5536;
   private static Method methodObject5625;
   private static Method methodObject5515;
   private static Method methodObject5689;
   private static Method methodObject5588;
   private static Method methodObject5629;
   private static Method methodObject5744;
   private static Method methodObject5716;
   private static Method methodObject5524;
   private static Method methodObject5610;
   private static Method methodObject5688;
   private static Method methodObject5540;
   private static Method methodObject5575;
   private static Method methodObject5676;
   private static Method methodObject5541;
   private static Method methodObject5501;
   private static Method methodObject5503;
   private static Method methodObject5538;
   private static Method methodObject5577;
   private static Method methodObject5669;
   private static Method methodObject5547;
   private static Method methodObject5735;
   private static Method methodObject5732;
   private static Method methodObject5549;
   private static Method methodObject5542;
   private static Method methodObject5599;
   private static Method methodObject5636;
   private static Method methodObject5691;
   private static Method methodObject5517;
   private static Method methodObject5573;
   private static Method methodObject5709;
   private static Method methodObject5692;
   private static Method methodObject5739;
   private static Method methodObject5526;
   private static Method methodObject5634;
   private static Method methodObject5746;
   private static Method methodObject5741;
   private static Method methodObject5584;
   private static Method methodObject5628;
   private static Method methodObject5531;
   private static Method methodObject5723;
   private static Method methodObject5696;
   private static Method methodObject5574;
   private static Method methodObject5512;
   private static Method methodObject5510;
   private static Method methodObject5604;
   private static Method methodObject5545;
   private static Method methodObject5578;
   private static Method methodObject5722;
   private static Method methodObject5713;
   private static Method methodObject5591;
   private static Method methodObject5571;
   private static Method methodObject5685;
   private static Method methodObject5590;
   private static Method methodObject5664;
   private static Method methodObject5632;
   private static Method methodObject5530;
   private static Method methodObject5550;
   private static Method methodObject5527;
   private static Method methodObject5614;
   private static Method methodObject5546;
   private static Method methodObject5681;
   private static Method methodObject5587;
   private static Method methodObject5655;
   private static Method methodObject5712;
   private static Method methodObject5653;
   private static Method methodObject5617;
   private static Method methodObject5631;
   private static Method methodObject5518;
   private static Method methodObject5514;
   private static Method methodObject5521;
   private static Method methodObject5611;
   private static Method methodObject5616;
   private static Method methodObject5715;
   private static Method methodObject5606;
   private static Method methodObject5752;
   private static Method methodObject5682;
   private static Method methodObject5568;
   private static Method methodObject5502;
   private static Method methodObject5706;
   private static Method methodObject5579;
   private static Method methodObject5622;
   private static Method methodObject5519;
   private static Method methodObject5581;
   private static Method methodObject5673;
   private static Method methodObject5533;
   private static Method methodObject5525;
   private static Method methodObject5726;
   private static Method methodObject5645;
   private static Method methodObject5507;
   private static Method methodObject5505;
   private static Method methodObject5534;
   private static Method methodObject5551;
   private static Method methodObject5613;
   private static Method methodObject5522;
   private static Method methodObject5642;
   private static Method methodObject5687;
   private static Method methodObject5698;
   private static Method methodObject5667;
   private static Method methodObject5701;
   private static Method methodObject5592;
   private static Method methodObject5654;
   private static Method methodObject5743;
   private static Method methodObject5582;
   private static Method methodObject5529;
   private static Method methodObject5666;
   private static Method methodObject5679;
   private static Method methodObject5686;
   private static Method methodObject5548;
   private static Method methodObject5633;
   private static Method methodObject5663;
   private static Method methodObject5569;
   private static Method methodObject5504;
   private static Method methodObject5753;
   private static Method methodObject5499;
   private static Method methodObject5747;
   private static Method methodObject5703;
   private static Method methodObject5560;
   private static Method methodObject5657;
   private static Method methodObject5671;
   private static Method methodObject5543;
   private static Method methodObject5539;
   private static Method methodObject5651;
   private static Method methodObject5751;
   private static Method methodObject5730;
   private static Method methodObject5639;
   private static Method methodObject5694;
   private static Method methodObject5506;
   private static Method methodObject5635;
   private static Method methodObject5756;
   private static Method methodObject5586;
   private static Method methodObject5680;
   private static Method methodObject5745;
   private static Method methodObject5609;
   private static Method methodObject5658;
   private static Method methodObject5674;
   private static Method methodObject5600;
   private static Method methodObject5758;
   private static Method methodObject5707;
   private static Method methodObject5596;
   private static Method methodObject5641;
   private static Method methodObject5740;
   private static Method methodObject5537;
   private static Method methodObject5659;
   private static Method methodObject5572;
   private static Method methodObject5528;
   private static Method methodObject5638;
   private static Method methodObject5648;
   private static Method methodObject5742;
   private static Method methodObject5683;
   private static Method methodObject5601;
   private static Method methodObject5618;
   private static Method methodObject5555;
   private static Method methodObject5583;
   private static Method methodObject5624;
   private static Method methodObject5725;
   private static Method methodObject5711;
   private static Method methodObject5700;

   public void setNClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5626, this, arg0, arg1, arg2);
         Method var10001 = methodObject5626;
         this.delegate.setNClobAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5626, var6);
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5605, this, arg0, arg1, arg2);
         Method var10001 = methodObject5605;
         this.delegate.setTimestampAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5605, var5);
      }
   }

   public void setBooleanAtName(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject5562, this, arg0, arg1);
         Method var10001 = methodObject5562;
         this.delegate.setBooleanAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5562, var4);
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject5684, this, arg0, arg1);
         Method var10001 = methodObject5684;
         this.delegate.setTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5684, var4);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5736, this, arg0, arg1, arg2);
         Method var10001 = methodObject5736;
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5736, var5);
      }
   }

   public void setIntAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5565, this, arg0, arg1);
         Method var10001 = methodObject5565;
         this.delegate.setIntAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5565, var4);
      }
   }

   public void setNullAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5561, this, arg0, arg1);
         Method var10001 = methodObject5561;
         this.delegate.setNullAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5561, var4);
      }
   }

   public int getExecuteBatch() {
      super.preForAll(methodObject5559, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5559, this.delegate.getExecuteBatch());
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5668, this, arg0, arg1, arg2);
         Method var10001 = methodObject5668;
         this.delegate.setDate(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5668, var5);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject5734, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5734;
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5734, var6);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5695, this, arg0);
         Method var10001 = methodObject5695;
         this.delegate.setFetchDirection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5695, var3);
      }
   }

   public void setLongAtName(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject5566, this, arg0, arg1);
         Method var10001 = methodObject5566;
         this.delegate.setLongAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5566, var5);
      }
   }

   public void setClobAtName(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5593, this, arg0, arg1);
         Method var10001 = methodObject5593;
         this.delegate.setClobAtName(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5593, var4);
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5675, this, arg0, arg1);
         Method var10001 = methodObject5675;
         this.delegate.setNull(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5675, var4);
      }
   }

   public void setREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5554, this, arg0, arg1);
         Method var10001 = methodObject5554;
         this.delegate.setREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5554, var4);
      }
   }

   public void setORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject5552, this, arg0, arg1);
         Method var10001 = methodObject5552;
         this.delegate.setORAData(arg0, arg1 instanceof _Proxy_ ? (ORAData)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5552, var4);
      }
   }

   public boolean getserverCursor() {
      super.preForAll(methodObject5750, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject5750, this.delegate.getserverCursor());
   }

   public void enterImplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject5500, this, zeroLengthObjectArray);
         Method var10001 = methodObject5500;
         this.delegate.enterImplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5500, var2);
      }
   }

   public void setFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5567, this, arg0, arg1);
         Method var10001 = methodObject5567;
         this.delegate.setFloatAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5567, var4);
      }
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject5640, this, arg0, arg1);
         Method var10001 = methodObject5640;
         this.delegate.setURL(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5640, var4);
      }
   }

   public void setTIMESTAMPAtName(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject5608, this, arg0, arg1);
         Method var10001 = methodObject5608;
         this.delegate.setTIMESTAMPAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5608, var4);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject5678, this, arg0, arg1);
         Method var10001 = methodObject5678;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5678, var4);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject5721, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5721, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5721, this.onErrorForAll(methodObject5721, var2));
      }
   }

   public void setCHARAtName(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject5585, this, arg0, arg1);
         Method var10001 = methodObject5585;
         this.delegate.setCHARAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5585, var4);
      }
   }

   public void setTimeAtName(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject5602, this, arg0, arg1);
         Method var10001 = methodObject5602;
         this.delegate.setTimeAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5602, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5733, this, arg0, arg1, arg2);
         Method var10001 = methodObject5733;
         this.delegate.defineColumnType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5733, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject5719, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5719, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5719, this.onErrorForAll(methodObject5719, var2));
      }
   }

   public void defineParameterTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5556, this, arg0, arg1, arg2);
         Method var10001 = methodObject5556;
         this.delegate.defineParameterTypeBytes(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5556, var5);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject5720, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5720, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5720, this.onErrorForAll(methodObject5720, var2));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5650, this, arg0, arg1, arg2);
         Method var10001 = methodObject5650;
         this.delegate.setCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5650, var5);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject5520, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5520;
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5520, var6);
      }
   }

   public void setTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject5544, this, arg0, arg1);
         Method var10001 = methodObject5544;
         this.delegate.setTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5544, var4);
      }
   }

   public void setSQLXMLAtName(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject5630, this, arg0, arg1);
         Method var10001 = methodObject5630;
         this.delegate.setSQLXMLAtName(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5630, var4);
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject5644, this, arg0, arg1);
         Method var10001 = methodObject5644;
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5644, var4);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject5728, this, arg0);
         return this.postForAll(methodObject5728, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject5728));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5728, this.onErrorForAll(methodObject5728, var3));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject5677, this, arg0, arg1, arg2);
         Method var10001 = methodObject5677;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5677, var5);
      }
   }

   public void setBinaryFloatAtName(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5570, this, arg0, arg1);
         Method var10001 = methodObject5570;
         this.delegate.setBinaryFloatAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5570, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5511, this, arg0, arg1);
         Method var10001 = methodObject5511;
         this.delegate.setAsciiStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5511, var4);
      }
   }

   public void setByteAtName(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject5563, this, arg0, arg1);
         Method var10001 = methodObject5563;
         this.delegate.setByteAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5563, var4);
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForBatches(methodObject5705, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject5705, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject5705, this.onErrorForAll(methodObject5705, var2));
      }
   }

   public void setTimeAtName(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5603, this, arg0, arg1, arg2);
         Method var10001 = methodObject5603;
         this.delegate.setTimeAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5603, var5);
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject5718, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5718, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5718, this.onErrorForAll(methodObject5718, var2));
      }
   }

   public void setARRAYAtName(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject5580, this, arg0, arg1);
         Method var10001 = methodObject5580;
         this.delegate.setARRAYAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5580, var4);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject5729, this, arg0);
         return (Boolean)this.postForAll(methodObject5729, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5729, this.onErrorForAll(methodObject5729, var3));
      }
   }

   public void setFormOfUse(int arg0, short arg1) {
      super.preForAll(methodObject5619, this, arg0, arg1);
      Method var10001 = methodObject5619;
      this.delegate.setFormOfUse(arg0, arg1);
      this.postForAll(var10001);
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject5717, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5717, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5717, this.onErrorForAll(methodObject5717, var2));
      }
   }

   public void defineParameterType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5558, this, arg0, arg1, arg2);
         Method var10001 = methodObject5558;
         this.delegate.defineParameterType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5558, var5);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5656, this, arg0, arg1);
         Method var10001 = methodObject5656;
         this.delegate.setBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5656, var4);
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject5660, this, arg0, arg1);
         Method var10001 = methodObject5660;
         this.delegate.setBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5660, var4);
      }
   }

   public void setCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject5535, this, arg0, arg1);
         Method var10001 = methodObject5535;
         this.delegate.setCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5535, var4);
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject5757, this, arg0);
      Method var10001 = methodObject5757;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public void setCursor(int arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject5532, this, arg0, arg1);
         Method var10001 = methodObject5532;
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5532, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject5697, this, zeroLengthObjectArray);
         Method var10001 = methodObject5697;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5697, var2);
      }
   }

   public void setRefType(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5553, this, arg0, arg1);
         Method var10001 = methodObject5553;
         this.delegate.setRefType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5553, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5652, this, arg0, arg1);
         Method var10001 = methodObject5652;
         this.delegate.setCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5652, var4);
      }
   }

   public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject5621, this, zeroLengthObjectArray);
         return (OracleParameterMetaData)this.postForAll(methodObject5621, this.proxyFactory.proxyForCache((Object)this.delegate.OracleGetParameterMetaData(), this, this.proxyCache, methodObject5621));
      } catch (SQLException var2) {
         return (OracleParameterMetaData)this.postForAll(methodObject5621, this.onErrorForAll(methodObject5621, var2));
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5513, this, arg0, arg1, arg2);
         Method var10001 = methodObject5513;
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5513, var6);
      }
   }

   public void setORADataAtName(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject5612, this, arg0, arg1);
         Method var10001 = methodObject5612;
         this.delegate.setORADataAtName(arg0, arg1 instanceof _Proxy_ ? (ORAData)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5612, var4);
      }
   }

   public void setClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5595, this, arg0, arg1);
         Method var10001 = methodObject5595;
         this.delegate.setClobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5595, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject5643, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject5643, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject5643));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject5643, this.onErrorForAll(methodObject5643, var2));
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5661, this, arg0, arg1);
         Method var10001 = methodObject5661;
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5661, var4);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject5699, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5699, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5699, this.onErrorForAll(methodObject5699, var2));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5702, this, arg0);
         Method var10001 = methodObject5702;
         this.delegate.addBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5702, var3);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5672, this, arg0, arg1, arg2);
         Method var10001 = methodObject5672;
         this.delegate.setNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5672, var6);
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForBatches(methodObject5749, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5749, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5749, this.onErrorForAll(methodObject5749, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5724, this, arg0);
         Method var10001 = methodObject5724;
         this.delegate.setMaxFieldSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5724, var3);
      }
   }

   public void setDisableStmtCaching(boolean arg0) {
      super.preForAll(methodObject5620, this, arg0);
      Method var10001 = methodObject5620;
      this.delegate.setDisableStmtCaching(arg0);
      this.postForAll(var10001);
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5647, this, arg0, arg1, arg2);
         Method var10001 = methodObject5647;
         this.delegate.setAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5647, var5);
      }
   }

   public void registerBindChecksumListener(OracleStatement.BindChecksumListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject5755, this, arg0);
         Method var10001 = methodObject5755;
         this.delegate.registerBindChecksumListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5755, var3);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject5710, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject5710, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject5710));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject5710, this.onErrorForAll(methodObject5710, var2));
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5649, this, arg0, arg1);
         Method var10001 = methodObject5649;
         this.delegate.setAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5649, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5670, this, arg0, arg1);
         Method var10001 = methodObject5670;
         this.delegate.setNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5670, var4);
      }
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject5738, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5738, this.delegate.getRowPrefetch());
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5708, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5708, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5708, this.onErrorForAll(methodObject5708, var4));
      }
   }

   public void defineParameterTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5557, this, arg0, arg1, arg2);
         Method var10001 = methodObject5557;
         this.delegate.defineParameterTypeChars(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5557, var5);
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5498, this, arg0, arg1, arg2);
         Method var10001 = methodObject5498;
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5498, var5);
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject5637, this, arg0, arg1);
         Method var10001 = methodObject5637;
         this.delegate.setShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5637, var4);
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject5704, this, zeroLengthObjectArray);
         Method var10001 = methodObject5704;
         this.delegate.closeOnCompletion();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5704, var2);
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5516, this, arg0, arg1);
         Method var10001 = methodObject5516;
         this.delegate.setCharacterStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5516, var4);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject5693, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5693, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5693, this.onErrorForAll(methodObject5693, var2));
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5509, this, arg0, arg1, arg2);
         Method var10001 = methodObject5509;
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5509, var5);
      }
   }

   public boolean getFixedString() {
      super.preForAll(methodObject5748, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject5748, this.delegate.getFixedString());
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5714, this, arg0);
         return (Boolean)this.postForAll(methodObject5714, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5714, this.onErrorForAll(methodObject5714, var3));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5623, this, arg0, arg1, arg2);
         Method var10001 = methodObject5623;
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5623, var5);
      }
   }

   public long getChecksum() throws SQLException {
      try {
         super.preForAll(methodObject5754, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject5754, this.delegate.getChecksum());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject5754, this.onErrorForAll(methodObject5754, var2));
      }
   }

   public void setClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5594, this, arg0, arg1, arg2);
         Method var10001 = methodObject5594;
         this.delegate.setClobAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5594, var6);
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5662, this, arg0, arg1, arg2);
         Method var10001 = methodObject5662;
         this.delegate.setBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5662, var6);
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5646, this, arg0, arg1);
         Method var10001 = methodObject5646;
         this.delegate.setString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5646, var4);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5690, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5690, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5690, this.onErrorForAll(methodObject5690, var4));
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5727, this, arg0);
         Method var10001 = methodObject5727;
         this.delegate.setQueryTimeout(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5727, var3);
      }
   }

   public void setShortAtName(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject5564, this, arg0, arg1);
         Method var10001 = methodObject5564;
         this.delegate.setShortAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5564, var4);
      }
   }

   public void setBfileAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5597, this, arg0, arg1);
         Method var10001 = methodObject5597;
         this.delegate.setBfileAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5597, var4);
      }
   }

   public void setINTERVALDSAtName(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject5607, this, arg0, arg1);
         Method var10001 = methodObject5607;
         this.delegate.setINTERVALDSAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5607, var4);
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5737, this, arg0, arg1, arg2);
         Method var10001 = methodObject5737;
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5737, var5);
      }
   }

   public void setBlobAtName(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5589, this, arg0, arg1);
         Method var10001 = methodObject5589;
         this.delegate.setBlobAtName(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5589, var4);
      }
   }

   public void setBytesAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5598, this, arg0, arg1);
         Method var10001 = methodObject5598;
         this.delegate.setBytesAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5598, var4);
      }
   }

   public void setFixedCHARAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5576, this, arg0, arg1);
         Method var10001 = methodObject5576;
         this.delegate.setFixedCHARAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5576, var4);
      }
   }

   public void setREFAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5615, this, arg0, arg1);
         Method var10001 = methodObject5615;
         this.delegate.setREFAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5615, var4);
      }
   }

   public void setNClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5627, this, arg0, arg1);
         Method var10001 = methodObject5627;
         this.delegate.setNClobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5627, var4);
      }
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5665, this, arg0, arg1, arg2);
         Method var10001 = methodObject5665;
         this.delegate.setClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5665, var6);
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject5731, this, zeroLengthObjectArray);
         Method var10001 = methodObject5731;
         this.delegate.clearDefines();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5731, var2);
      }
   }

   public ResultSet getReturnResultSet() throws SQLException {
      try {
         super.preForAll(methodObject5523, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject5523, this.proxyFactory.proxyForCache((Object)this.delegate.getReturnResultSet(), this, this.proxyCache, methodObject5523));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject5523, this.onErrorForAll(methodObject5523, var2));
      }
   }

   public void setDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5536, this, arg0, arg1);
         Method var10001 = methodObject5536;
         this.delegate.setDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5536, var4);
      }
   }

   public void setNClobAtName(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5625, this, arg0, arg1);
         Method var10001 = methodObject5625;
         this.delegate.setNClobAtName(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5625, var4);
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5515, this, arg0, arg1, arg2);
         Method var10001 = methodObject5515;
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5515, var6);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5689, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5689, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5689, this.onErrorForAll(methodObject5689, var4));
      }
   }

   public void setBLOBAtName(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5588, this, arg0, arg1);
         Method var10001 = methodObject5588;
         this.delegate.setBLOBAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5588, var4);
      }
   }

   public void setRowIdAtName(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject5629, this, arg0, arg1);
         Method var10001 = methodObject5629;
         this.delegate.setRowIdAtName(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5629, var4);
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject5744, this, arg0);
         Method var10001 = methodObject5744;
         this.delegate.setDatabaseChangeRegistration(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5744, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject5716, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5716, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5716, this.onErrorForAll(methodObject5716, var2));
      }
   }

   public void setExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5524, this, arg0);
         Method var10001 = methodObject5524;
         this.delegate.setExecuteBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5524, var3);
      }
   }

   public void setTIMESTAMPLTZAtName(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5610, this, arg0, arg1);
         Method var10001 = methodObject5610;
         this.delegate.setTIMESTAMPLTZAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5610, var4);
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5688, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5688, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5688, this.onErrorForAll(methodObject5688, var4));
      }
   }

   public void setBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5540, this, arg0, arg1);
         Method var10001 = methodObject5540;
         this.delegate.setBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5540, var4);
      }
   }

   public void setStringForClobAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5575, this, arg0, arg1);
         Method var10001 = methodObject5575;
         this.delegate.setStringForClobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5575, var4);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5676, this, arg0, arg1, arg2);
         Method var10001 = methodObject5676;
         this.delegate.setNull(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5676, var5);
      }
   }

   public void setBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5541, this, arg0, arg1);
         Method var10001 = methodObject5541;
         this.delegate.setBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5541, var4);
      }
   }

   public void enterExplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject5501, this, zeroLengthObjectArray);
         Method var10001 = methodObject5501;
         this.delegate.enterExplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5501, var2);
      }
   }

   public void exitExplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject5503, this, zeroLengthObjectArray);
         Method var10001 = methodObject5503;
         this.delegate.exitExplicitCacheToActive();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5503, var2);
      }
   }

   public void setBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5538, this, arg0, arg1);
         Method var10001 = methodObject5538;
         this.delegate.setBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5538, var4);
      }
   }

   public void setCursorAtName(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject5577, this, arg0, arg1);
         Method var10001 = methodObject5577;
         this.delegate.setCursorAtName(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5577, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5669, this, arg0, arg1, arg2);
         Method var10001 = methodObject5669;
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5669, var6);
      }
   }

   public void setARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject5547, this, arg0, arg1);
         Method var10001 = methodObject5547;
         this.delegate.setARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5547, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5735, this, arg0, arg1, arg2);
         Method var10001 = methodObject5735;
         this.delegate.defineColumnType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5735, var5);
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5732, this, arg0, arg1);
         Method var10001 = methodObject5732;
         this.delegate.defineColumnType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5732, var4);
      }
   }

   public void setStructDescriptor(int arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject5549, this, arg0, arg1);
         Method var10001 = methodObject5549;
         this.delegate.setStructDescriptor(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5549, var4);
      }
   }

   public void setINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject5542, this, arg0, arg1);
         Method var10001 = methodObject5542;
         this.delegate.setINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5542, var4);
      }
   }

   public void setBytesForBlobAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5599, this, arg0, arg1);
         Method var10001 = methodObject5599;
         this.delegate.setBytesForBlobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5599, var4);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject5636, this, arg0, arg1);
         Method var10001 = methodObject5636;
         this.delegate.setLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5636, var5);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject5691, this, zeroLengthObjectArray);
         Method var10001 = methodObject5691;
         this.delegate.cancel();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5691, var2);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5517, this, arg0, arg1, arg2);
         Method var10001 = methodObject5517;
         this.delegate.setNCharacterStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5517, var6);
      }
   }

   public void setBigDecimalAtName(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject5573, this, arg0, arg1);
         Method var10001 = methodObject5573;
         this.delegate.setBigDecimalAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5573, var4);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5709, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5709, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5709, this.onErrorForAll(methodObject5709, var4));
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject5692, this, zeroLengthObjectArray);
         return this.postForGetResultSet(methodObject5692, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject5692));
      } catch (SQLException var2) {
         return this.postForGetResultSet(methodObject5692, (ResultSet)this.onErrorForAll(methodObject5692, var2));
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5739, this, arg0);
         Method var10001 = methodObject5739;
         this.delegate.setRowPrefetch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5739, var3);
      }
   }

   public void setBinaryFloat(int arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5526, this, arg0, arg1);
         Method var10001 = methodObject5526;
         this.delegate.setBinaryFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5526, var4);
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5634, this, arg0, arg1);
         Method var10001 = methodObject5634;
         this.delegate.setFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5634, var4);
      }
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject5746, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject5746, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject5746, this.onErrorForAll(methodObject5746, var2));
      }
   }

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5741, this, arg0);
         Method var10001 = methodObject5741;
         this.delegate.setLobPrefetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5741, var3);
      }
   }

   public void setRAWAtName(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject5584, this, arg0, arg1);
         Method var10001 = methodObject5584;
         this.delegate.setRAWAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5584, var4);
      }
   }

   public void setNStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5628, this, arg0, arg1);
         Method var10001 = methodObject5628;
         this.delegate.setNStringAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5628, var4);
      }
   }

   public void setFixedCHAR(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5531, this, arg0, arg1);
         Method var10001 = methodObject5531;
         this.delegate.setFixedCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5531, var4);
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject5723, this, arg0);
         Method var10001 = methodObject5723;
         this.delegate.setEscapeProcessing(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5723, var3);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5696, this, arg0);
         Method var10001 = methodObject5696;
         this.delegate.setFetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5696, var3);
      }
   }

   public void setStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5574, this, arg0, arg1);
         Method var10001 = methodObject5574;
         this.delegate.setStringAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5574, var4);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5512, this, arg0, arg1, arg2);
         Method var10001 = methodObject5512;
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5512, var5);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5510, this, arg0, arg1, arg2);
         Method var10001 = methodObject5510;
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5510, var6);
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject5604, this, arg0, arg1);
         Method var10001 = methodObject5604;
         this.delegate.setTimestampAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5604, var4);
      }
   }

   public void setTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5545, this, arg0, arg1);
         Method var10001 = methodObject5545;
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5545, var4);
      }
   }

   public void setROWIDAtName(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject5578, this, arg0, arg1);
         Method var10001 = methodObject5578;
         this.delegate.setROWIDAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5578, var4);
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5722, this, arg0);
         Method var10001 = methodObject5722;
         this.delegate.setCursorName(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5722, var3);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject5713, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5713, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5713, this.onErrorForAll(methodObject5713, var2));
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject5591, this, arg0, arg1);
         Method var10001 = methodObject5591;
         this.delegate.setBlobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5591, var4);
      }
   }

   public void setBinaryDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5571, this, arg0, arg1);
         Method var10001 = methodObject5571;
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5571, var5);
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5685, this, arg0, arg1, arg2);
         Method var10001 = methodObject5685;
         this.delegate.setTime(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5685, var5);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5590, this, arg0, arg1, arg2);
         Method var10001 = methodObject5590;
         this.delegate.setBlobAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5590, var6);
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5664, this, arg0, arg1);
         Method var10001 = methodObject5664;
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5664, var4);
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject5632, this, arg0, arg1);
         Method var10001 = methodObject5632;
         this.delegate.setByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5632, var4);
      }
   }

   public void setBytesForBlob(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5530, this, arg0, arg1);
         Method var10001 = methodObject5530;
         this.delegate.setBytesForBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5530, var4);
      }
   }

   public void setSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5550, this, arg0, arg1);
         Method var10001 = methodObject5550;
         this.delegate.setSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5550, var4);
      }
   }

   public void setBinaryDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5527, this, arg0, arg1);
         Method var10001 = methodObject5527;
         this.delegate.setBinaryDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5527, var5);
      }
   }

   public void setRefAtName(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject5614, this, arg0, arg1);
         Method var10001 = methodObject5614;
         this.delegate.setRefAtName(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5614, var4);
      }
   }

   public void setTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5546, this, arg0, arg1);
         Method var10001 = methodObject5546;
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5546, var4);
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject5681, this, arg0, arg1);
         Method var10001 = methodObject5681;
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5681, var4);
      }
   }

   public void setNUMBERAtName(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject5587, this, arg0, arg1);
         Method var10001 = methodObject5587;
         this.delegate.setNUMBERAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5587, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5655, this, arg0, arg1, arg2);
         Method var10001 = methodObject5655;
         this.delegate.setBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5655, var6);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject5712, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5712, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5712, this.onErrorForAll(methodObject5712, var2));
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject5653, this, zeroLengthObjectArray);
         Method var10001 = methodObject5653;
         this.delegate.addBatch();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5653, var2);
      }
   }

   public void setURLAtName(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject5617, this, arg0, arg1);
         Method var10001 = methodObject5617;
         this.delegate.setURLAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5617, var4);
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject5631, this, arg0, arg1);
         Method var10001 = methodObject5631;
         this.delegate.setBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5631, var4);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5518, this, arg0, arg1);
         Method var10001 = methodObject5518;
         this.delegate.setNCharacterStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5518, var4);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5514, this, arg0, arg1);
         Method var10001 = methodObject5514;
         this.delegate.setBinaryStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5514, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject5521, this, arg0, arg1, arg2);
         Method var10001 = methodObject5521;
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5521, var5);
      }
   }

   public void setCustomDatumAtName(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5611, this, arg0, arg1);
         Method var10001 = methodObject5611;
         this.delegate.setCustomDatumAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5611, var4);
      }
   }

   public void setOracleObjectAtName(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5616, this, arg0, arg1);
         Method var10001 = methodObject5616;
         this.delegate.setOracleObjectAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5616, var4);
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject5715, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5715, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5715, this.onErrorForAll(methodObject5715, var2));
      }
   }

   public void setINTERVALYMAtName(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject5606, this, arg0, arg1);
         Method var10001 = methodObject5606;
         this.delegate.setINTERVALYMAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5606, var4);
      }
   }

   public int getstatementType() {
      super.preForAll(methodObject5752, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5752, this.delegate.getstatementType());
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject5682, this, arg0, arg1);
         Method var10001 = methodObject5682;
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5682, var4);
      }
   }

   public void setDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5568, this, arg0, arg1);
         Method var10001 = methodObject5568;
         this.delegate.setDoubleAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5568, var5);
      }
   }

   public void exitImplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject5502, this, zeroLengthObjectArray);
         Method var10001 = methodObject5502;
         this.delegate.exitImplicitCacheToActive();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5502, var2);
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5706, this, arg0);
         return (Integer)this.postForAll(methodObject5706, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5706, this.onErrorForAll(methodObject5706, var3));
      }
   }

   public void setArrayAtName(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject5579, this, arg0, arg1);
         Method var10001 = methodObject5579;
         this.delegate.setArrayAtName(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5579, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5622, this, arg0, arg1);
         Method var10001 = methodObject5622;
         this.delegate.registerReturnParameter(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5622, var4);
      }
   }

   public void setUnicodeStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5519, this, arg0, arg1, arg2);
         Method var10001 = methodObject5519;
         this.delegate.setUnicodeStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5519, var5);
      }
   }

   public void setOPAQUEAtName(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5581, this, arg0, arg1);
         Method var10001 = methodObject5581;
         this.delegate.setOPAQUEAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5581, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5673, this, arg0, arg1);
         Method var10001 = methodObject5673;
         this.delegate.setNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5673, var4);
      }
   }

   public void setROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject5533, this, arg0, arg1);
         Method var10001 = methodObject5533;
         this.delegate.setROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5533, var4);
      }
   }

   public void setBinaryFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5525, this, arg0, arg1);
         Method var10001 = methodObject5525;
         this.delegate.setBinaryFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5525, var4);
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject5726, this, arg0);
         Method var10001 = methodObject5726;
         this.delegate.setPoolable(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5726, var3);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForExecuteQuery(methodObject5645, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject5645, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject5645));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject5645, (ResultSet)this.onErrorForAll(methodObject5645, var2));
      }
   }

   public void setCheckBindTypes(boolean arg0) {
      super.preForAll(methodObject5507, this, arg0);
      Method var10001 = methodObject5507;
      this.delegate.setCheckBindTypes(arg0);
      this.postForAll(var10001);
   }

   public void exitExplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject5505, this, zeroLengthObjectArray);
         Method var10001 = methodObject5505;
         this.delegate.exitExplicitCacheToClose();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5505, var2);
      }
   }

   public void setRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject5534, this, arg0, arg1);
         Method var10001 = methodObject5534;
         this.delegate.setRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5534, var4);
      }
   }

   public void setCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5551, this, arg0, arg1);
         Method var10001 = methodObject5551;
         this.delegate.setCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5551, var4);
      }
   }

   public void setRefTypeAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5613, this, arg0, arg1);
         Method var10001 = methodObject5613;
         this.delegate.setRefTypeAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5613, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject5522, this, arg0, arg1);
         Method var10001 = methodObject5522;
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5522, var4);
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5642, this, arg0, arg1);
         Method var10001 = methodObject5642;
         this.delegate.setBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5642, var4);
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject5687, this, arg0);
         return (Boolean)this.postForAll(methodObject5687, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5687, this.onErrorForAll(methodObject5687, var3));
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject5698, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject5698, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject5698, this.onErrorForAll(methodObject5698, var2));
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject5667, this, arg0, arg1);
         Method var10001 = methodObject5667;
         this.delegate.setDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5667, var4);
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject5701, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject5701, this.proxyFactory.proxyForCache((Object)this.delegate.getConnection(), this, this.proxyCache, methodObject5701));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject5701, this.onErrorForAll(methodObject5701, var2));
      }
   }

   public void setCLOBAtName(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5592, this, arg0, arg1);
         Method var10001 = methodObject5592;
         this.delegate.setCLOBAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5592, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5654, this, arg0, arg1, arg2);
         Method var10001 = methodObject5654;
         this.delegate.setBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5654, var5);
      }
   }

   public int creationState() {
      super.preForAll(methodObject5743, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5743, this.delegate.creationState());
   }

   public void setStructDescriptorAtName(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject5582, this, arg0, arg1);
         Method var10001 = methodObject5582;
         this.delegate.setStructDescriptorAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5582, var4);
      }
   }

   public void setStringForClob(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5529, this, arg0, arg1);
         Method var10001 = methodObject5529;
         this.delegate.setStringForClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5529, var4);
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5666, this, arg0, arg1);
         Method var10001 = methodObject5666;
         this.delegate.setClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5666, var4);
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject5679, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5679;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5679, var6);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject5686, this, zeroLengthObjectArray);
         Method var10001 = methodObject5686;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject5686, var2);
      }
   }

   public void setOPAQUE(int arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5548, this, arg0, arg1);
         Method var10001 = methodObject5548;
         this.delegate.setOPAQUE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5548, var4);
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5633, this, arg0, arg1);
         Method var10001 = methodObject5633;
         this.delegate.setDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5633, var5);
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject5663, this, arg0, arg1);
         Method var10001 = methodObject5663;
         this.delegate.setBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5663, var4);
      }
   }

   public void setBinaryFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5569, this, arg0, arg1);
         Method var10001 = methodObject5569;
         this.delegate.setBinaryFloatAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5569, var4);
      }
   }

   public void exitImplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject5504, this, zeroLengthObjectArray);
         Method var10001 = methodObject5504;
         this.delegate.exitImplicitCacheToClose();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5504, var2);
      }
   }

   public OracleStatement.SqlKind getSqlKind() throws SQLException {
      try {
         super.preForAll(methodObject5753, this, zeroLengthObjectArray);
         return (OracleStatement.SqlKind)this.postForAll(methodObject5753, (Object)this.delegate.getSqlKind());
      } catch (SQLException var2) {
         return (OracleStatement.SqlKind)this.postForAll(methodObject5753, this.onErrorForAll(methodObject5753, var2));
      }
   }

   public void setInternalBytes(int arg0, byte[] arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5499, this, arg0, arg1, arg2);
         Method var10001 = methodObject5499;
         this.delegate.setInternalBytes(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5499, var5);
      }
   }

   public void setFixedString(boolean arg0) {
      super.preForAll(methodObject5747, this, arg0);
      Method var10001 = methodObject5747;
      this.delegate.setFixedString(arg0);
      this.postForAll(var10001);
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject5703, this, zeroLengthObjectArray);
         Method var10001 = methodObject5703;
         this.delegate.clearBatch();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5703, var2);
      }
   }

   public void setNullAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5560, this, arg0, arg1, arg2);
         Method var10001 = methodObject5560;
         this.delegate.setNullAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5560, var5);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5657, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5657, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5657, this.onErrorForAll(methodObject5657, var2));
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5671, this, arg0, arg1);
         Method var10001 = methodObject5671;
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5671, var4);
      }
   }

   public void setINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject5543, this, arg0, arg1);
         Method var10001 = methodObject5543;
         this.delegate.setINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5543, var4);
      }
   }

   public void setCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5539, this, arg0, arg1);
         Method var10001 = methodObject5539;
         this.delegate.setCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5539, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5651, this, arg0, arg1, arg2);
         Method var10001 = methodObject5651;
         this.delegate.setCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5651, var6);
      }
   }

   public int getcacheState() {
      super.preForAll(methodObject5751, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5751, this.delegate.getcacheState());
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5730, this, arg0);
         return (Boolean)this.postForAll(methodObject5730, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5730, this.onErrorForAll(methodObject5730, var3));
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5639, this, arg0, arg1, arg2);
         Method var10001 = methodObject5639;
         this.delegate.setTimestamp(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5639, var5);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject5694, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5694, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5694, this.onErrorForAll(methodObject5694, var2));
      }
   }

   public String getOriginalSql() throws SQLException {
      try {
         super.preForAll(methodObject5506, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject5506, (Object)this.delegate.getOriginalSql());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject5506, this.onErrorForAll(methodObject5506, var2));
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5635, this, arg0, arg1);
         Method var10001 = methodObject5635;
         this.delegate.setInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5635, var4);
      }
   }

   public void setSnapshotSCN(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject5756, this, arg0);
         Method var10001 = methodObject5756;
         this.delegate.setSnapshotSCN(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5756, var4);
      }
   }

   public void setDATEAtName(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5586, this, arg0, arg1);
         Method var10001 = methodObject5586;
         this.delegate.setDATEAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5586, var4);
      }
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject5680, this, arg0, arg1);
         Method var10001 = methodObject5680;
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5680, var4);
      }
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject5745, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject5745, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject5745, this.onErrorForAll(methodObject5745, var2));
      }
   }

   public void setTIMESTAMPTZAtName(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5609, this, arg0, arg1);
         Method var10001 = methodObject5609;
         this.delegate.setTIMESTAMPTZAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5609, var4);
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject5658, this, zeroLengthObjectArray);
         Method var10001 = methodObject5658;
         this.delegate.clearParameters();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5658, var2);
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5674, this, arg0, arg1);
         Method var10001 = methodObject5674;
         this.delegate.setNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5674, var4);
      }
   }

   public void setDateAtName(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject5600, this, arg0, arg1);
         Method var10001 = methodObject5600;
         this.delegate.setDateAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5600, var4);
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject5758, this, zeroLengthObjectArray);
      return this.postForAll(methodObject5758, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject5758));
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5707, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5707, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5707, this.onErrorForAll(methodObject5707, var4));
      }
   }

   public void setBFILEAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5596, this, arg0, arg1);
         Method var10001 = methodObject5596;
         this.delegate.setBFILEAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5596, var4);
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject5641, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5641, this.delegate.execute());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5641, this.onErrorForAll(methodObject5641, var2));
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject5740, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5740, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5740, this.onErrorForAll(methodObject5740, var2));
      }
   }

   public void setNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject5537, this, arg0, arg1);
         Method var10001 = methodObject5537;
         this.delegate.setNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5537, var4);
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject5659, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject5659, this.proxyFactory.proxyForCache((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject5659));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject5659, this.onErrorForAll(methodObject5659, var2));
      }
   }

   public void setBinaryDoubleAtName(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5572, this, arg0, arg1);
         Method var10001 = methodObject5572;
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5572, var4);
      }
   }

   public void setBinaryDouble(int arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5528, this, arg0, arg1);
         Method var10001 = methodObject5528;
         this.delegate.setBinaryDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5528, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject5638, this, arg0, arg1);
         Method var10001 = methodObject5638;
         this.delegate.setTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5638, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5648, this, arg0, arg1, arg2);
         Method var10001 = methodObject5648;
         this.delegate.setAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5648, var6);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5742, this, arg0);
         Method var10001 = methodObject5742;
         this.delegate.closeWithKey(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5742, var3);
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5683, this, arg0, arg1, arg2);
         Method var10001 = methodObject5683;
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5683, var5);
      }
   }

   public void setDateAtName(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5601, this, arg0, arg1, arg2);
         Method var10001 = methodObject5601;
         this.delegate.setDateAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5601, var5);
      }
   }

   public void setPlsqlIndexTable(int arg0, Object arg1, int arg2, int arg3, int arg4, int arg5) throws SQLException {
      try {
         super.preForAll(methodObject5618, this, arg0, arg1, arg2, arg3, arg4, arg5);
         Method var10001 = methodObject5618;
         this.delegate.setPlsqlIndexTable(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3, arg4, arg5);
         this.postForAll(var10001);
      } catch (SQLException var8) {
         this.onErrorVoidForAll(methodObject5618, var8);
      }
   }

   public void setOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5555, this, arg0, arg1);
         Method var10001 = methodObject5555;
         this.delegate.setOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5555, var4);
      }
   }

   public void setSTRUCTAtName(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5583, this, arg0, arg1);
         Method var10001 = methodObject5583;
         this.delegate.setSTRUCTAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5583, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5624, this, arg0, arg1, arg2);
         Method var10001 = methodObject5624;
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5624, var5);
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5725, this, arg0);
         Method var10001 = methodObject5725;
         this.delegate.setMaxRows(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5725, var3);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject5711, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5711, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5711, this.onErrorForAll(methodObject5711, var2));
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForExecuteQuery(methodObject5700, this, arg0);
         return this.postForExecuteQuery(methodObject5700, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject5700));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject5700, (ResultSet)this.onErrorForAll(methodObject5700, var3));
      }
   }

   public OraclePreparedStatement _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OraclePreparedStatement)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject5626 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject5605 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class, Calendar.class);
         methodObject5562 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBooleanAtName", String.class, Boolean.TYPE);
         methodObject5684 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject5736 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5565 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setIntAtName", String.class, Integer.TYPE);
         methodObject5561 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE);
         methodObject5559 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("getExecuteBatch");
         methodObject5668 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject5734 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject5695 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject5566 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setLongAtName", String.class, Long.TYPE);
         methodObject5593 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Clob.class);
         methodObject5675 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject5554 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setREF", Integer.TYPE, REF.class);
         methodObject5552 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setORAData", Integer.TYPE, ORAData.class);
         methodObject5750 = OracleStatement.class.getDeclaredMethod("getserverCursor");
         methodObject5500 = OraclePreparedStatement.class.getDeclaredMethod("enterImplicitCache");
         methodObject5567 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFloatAtName", String.class, Float.TYPE);
         methodObject5640 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject5608 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPAtName", String.class, TIMESTAMP.class);
         methodObject5678 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject5721 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject5585 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCHARAtName", String.class, CHAR.class);
         methodObject5602 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class);
         methodObject5733 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5719 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject5556 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5720 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject5650 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject5520 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject5544 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject5630 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSQLXMLAtName", String.class, SQLXML.class);
         methodObject5644 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject5728 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject5677 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject5570 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, BINARY_FLOAT.class);
         methodObject5511 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class);
         methodObject5563 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setByteAtName", String.class, Byte.TYPE);
         methodObject5705 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject5603 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class, Calendar.class);
         methodObject5718 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject5580 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setARRAYAtName", String.class, ARRAY.class);
         methodObject5729 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject5619 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFormOfUse", Integer.TYPE, Short.TYPE);
         methodObject5717 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject5558 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5656 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject5660 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject5535 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCHAR", Integer.TYPE, CHAR.class);
         methodObject5757 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject5532 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCursor", Integer.TYPE, ResultSet.class);
         methodObject5697 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject5553 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefType", Integer.TYPE, REF.class);
         methodObject5652 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject5621 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("OracleGetParameterMetaData");
         methodObject5513 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject5612 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setORADataAtName", String.class, ORAData.class);
         methodObject5595 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class);
         methodObject5643 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject5661 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject5699 = Statement.class.getDeclaredMethod("isClosed");
         methodObject5702 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject5672 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5749 = OracleStatement.class.getDeclaredMethod("sendBatch");
         methodObject5724 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject5620 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDisableStmtCaching", Boolean.TYPE);
         methodObject5647 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5755 = OracleStatement.class.getDeclaredMethod("registerBindChecksumListener", OracleStatement.BindChecksumListener.class);
         methodObject5710 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject5649 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject5670 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject5738 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject5708 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject5557 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5498 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Integer.TYPE);
         methodObject5637 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject5704 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject5516 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class);
         methodObject5693 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject5509 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject5748 = OracleStatement.class.getDeclaredMethod("getFixedString");
         methodObject5714 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject5623 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5754 = OracleStatement.class.getDeclaredMethod("getChecksum");
         methodObject5594 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject5662 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5646 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject5690 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject5727 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject5564 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setShortAtName", String.class, Short.TYPE);
         methodObject5597 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBfileAtName", String.class, BFILE.class);
         methodObject5607 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDSAtName", String.class, INTERVALDS.class);
         methodObject5737 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5589 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, Blob.class);
         methodObject5598 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesAtName", String.class, byte[].class);
         methodObject5576 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFixedCHARAtName", String.class, String.class);
         methodObject5615 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setREFAtName", String.class, REF.class);
         methodObject5627 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class);
         methodObject5665 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5731 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject5523 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("getReturnResultSet");
         methodObject5536 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDATE", Integer.TYPE, DATE.class);
         methodObject5625 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, NClob.class);
         methodObject5515 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject5689 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject5588 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBLOBAtName", String.class, BLOB.class);
         methodObject5629 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRowIdAtName", String.class, RowId.class);
         methodObject5744 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject5716 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject5524 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setExecuteBatch", Integer.TYPE);
         methodObject5610 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZAtName", String.class, TIMESTAMPLTZ.class);
         methodObject5688 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject5540 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBFILE", Integer.TYPE, BFILE.class);
         methodObject5575 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringForClobAtName", String.class, String.class);
         methodObject5676 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5541 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBfile", Integer.TYPE, BFILE.class);
         methodObject5501 = OraclePreparedStatement.class.getDeclaredMethod("enterExplicitCache");
         methodObject5503 = OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToActive");
         methodObject5538 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBLOB", Integer.TYPE, BLOB.class);
         methodObject5577 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCursorAtName", String.class, ResultSet.class);
         methodObject5669 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5547 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setARRAY", Integer.TYPE, ARRAY.class);
         methodObject5735 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5732 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject5549 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptor", Integer.TYPE, StructDescriptor.class);
         methodObject5542 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject5599 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlobAtName", String.class, byte[].class);
         methodObject5636 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject5691 = Statement.class.getDeclaredMethod("cancel");
         methodObject5517 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject5573 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBigDecimalAtName", String.class, BigDecimal.class);
         methodObject5709 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject5692 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject5739 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject5526 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, BINARY_FLOAT.class);
         methodObject5634 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject5746 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject5741 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject5584 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRAWAtName", String.class, RAW.class);
         methodObject5628 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNStringAtName", String.class, String.class);
         methodObject5531 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFixedCHAR", Integer.TYPE, String.class);
         methodObject5723 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject5696 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject5574 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringAtName", String.class, String.class);
         methodObject5512 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject5510 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject5604 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class);
         methodObject5545 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject5578 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setROWIDAtName", String.class, ROWID.class);
         methodObject5722 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject5713 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject5591 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class);
         methodObject5571 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, Double.TYPE);
         methodObject5685 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject5590 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class, Long.TYPE);
         methodObject5664 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject5632 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject5530 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlob", Integer.TYPE, byte[].class);
         methodObject5550 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject5527 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, Double.TYPE);
         methodObject5614 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefAtName", String.class, Ref.class);
         methodObject5546 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject5681 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject5587 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNUMBERAtName", String.class, NUMBER.class);
         methodObject5655 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5712 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject5653 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject5617 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setURLAtName", String.class, URL.class);
         methodObject5631 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject5518 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class);
         methodObject5514 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class);
         methodObject5521 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE);
         methodObject5611 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCustomDatumAtName", String.class, CustomDatum.class);
         methodObject5616 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOracleObjectAtName", String.class, Datum.class);
         methodObject5715 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject5606 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYMAtName", String.class, INTERVALYM.class);
         methodObject5752 = OracleStatement.class.getDeclaredMethod("getstatementType");
         methodObject5682 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject5568 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDoubleAtName", String.class, Double.TYPE);
         methodObject5502 = OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToActive");
         methodObject5706 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject5579 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setArrayAtName", String.class, Array.class);
         methodObject5622 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE);
         methodObject5519 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setUnicodeStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject5581 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOPAQUEAtName", String.class, OPAQUE.class);
         methodObject5673 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject5533 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setROWID", Integer.TYPE, ROWID.class);
         methodObject5525 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, Float.TYPE);
         methodObject5726 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject5645 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject5507 = OraclePreparedStatement.class.getDeclaredMethod("setCheckBindTypes", Boolean.TYPE);
         methodObject5505 = OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToClose");
         methodObject5534 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRAW", Integer.TYPE, RAW.class);
         methodObject5551 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject5613 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefTypeAtName", String.class, REF.class);
         methodObject5522 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class);
         methodObject5642 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject5687 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject5698 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject5667 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject5701 = Statement.class.getDeclaredMethod("getConnection");
         methodObject5592 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCLOBAtName", String.class, CLOB.class);
         methodObject5654 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5743 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("creationState");
         methodObject5582 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptorAtName", String.class, StructDescriptor.class);
         methodObject5529 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringForClob", Integer.TYPE, String.class);
         methodObject5666 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject5679 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject5686 = Statement.class.getDeclaredMethod("close");
         methodObject5548 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOPAQUE", Integer.TYPE, OPAQUE.class);
         methodObject5633 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject5663 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject5569 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, Float.TYPE);
         methodObject5504 = OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToClose");
         methodObject5753 = OracleStatement.class.getDeclaredMethod("getSqlKind");
         methodObject5499 = OraclePreparedStatement.class.getDeclaredMethod("setInternalBytes", Integer.TYPE, byte[].class, Integer.TYPE);
         methodObject5747 = OracleStatement.class.getDeclaredMethod("setFixedString", Boolean.TYPE);
         methodObject5703 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject5560 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE, String.class);
         methodObject5657 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject5671 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject5543 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject5539 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCLOB", Integer.TYPE, CLOB.class);
         methodObject5651 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5751 = OracleStatement.class.getDeclaredMethod("getcacheState");
         methodObject5730 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject5639 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject5694 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject5506 = OraclePreparedStatement.class.getDeclaredMethod("getOriginalSql");
         methodObject5635 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
         methodObject5756 = OracleStatement.class.getDeclaredMethod("setSnapshotSCN", Long.TYPE);
         methodObject5586 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDATEAtName", String.class, DATE.class);
         methodObject5680 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject5745 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject5609 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZAtName", String.class, TIMESTAMPTZ.class);
         methodObject5658 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject5674 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject5600 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class);
         methodObject5758 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject5707 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject5596 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBFILEAtName", String.class, BFILE.class);
         methodObject5641 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject5740 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject5537 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNUMBER", Integer.TYPE, NUMBER.class);
         methodObject5659 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject5572 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, BINARY_DOUBLE.class);
         methodObject5528 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, BINARY_DOUBLE.class);
         methodObject5638 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject5648 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5742 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject5683 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5601 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class, Calendar.class);
         methodObject5618 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setPlsqlIndexTable", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5555 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOracleObject", Integer.TYPE, Datum.class);
         methodObject5583 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSTRUCTAtName", String.class, STRUCT.class);
         methodObject5624 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5725 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject5711 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject5700 = Statement.class.getDeclaredMethod("executeQuery", String.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableStatement$2oracle$1jdbc$1internal$1OraclePreparedStatement$$$Proxy(OraclePreparedStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
