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
import oracle.jdbc.replay.driver.NonTxnReplayableStatement;
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

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1internal$1OraclePreparedStatement$$$Proxy extends NonTxnReplayableStatement implements OraclePreparedStatement, _Proxy_ {
   private OraclePreparedStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject27616;
   private static Method methodObject27752;
   private static Method methodObject27590;
   private static Method methodObject27618;
   private static Method methodObject27682;
   private static Method methodObject27658;
   private static Method methodObject27612;
   private static Method methodObject27747;
   private static Method methodObject27818;
   private static Method methodObject27684;
   private static Method methodObject27565;
   private static Method methodObject27761;
   private static Method methodObject27657;
   private static Method methodObject27691;
   private static Method methodObject27697;
   private static Method methodObject27698;
   private static Method methodObject27581;
   private static Method methodObject27745;
   private static Method methodObject27804;
   private static Method methodObject27759;
   private static Method methodObject27782;
   private static Method methodObject27609;
   private static Method methodObject27703;
   private static Method methodObject27744;
   private static Method methodObject27797;
   private static Method methodObject27584;
   private static Method methodObject27719;
   private static Method methodObject27728;
   private static Method methodObject27780;
   private static Method methodObject27599;
   private static Method methodObject27723;
   private static Method methodObject27781;
   private static Method methodObject27785;
   private static Method methodObject27660;
   private static Method methodObject27686;
   private static Method methodObject27639;
   private static Method methodObject27574;
   private static Method methodObject27713;
   private static Method methodObject27575;
   private static Method methodObject27758;
   private static Method methodObject27779;
   private static Method methodObject27623;
   private static Method methodObject27821;
   private static Method methodObject27784;
   private static Method methodObject27768;
   private static Method methodObject27595;
   private static Method methodObject27738;
   private static Method methodObject27587;
   private static Method methodObject27617;
   private static Method methodObject27667;
   private static Method methodObject27767;
   private static Method methodObject27674;
   private static Method methodObject27652;
   private static Method methodObject27680;
   private static Method methodObject27589;
   private static Method methodObject27690;
   private static Method methodObject27725;
   private static Method methodObject27662;
   private static Method methodObject27787;
   private static Method methodObject27763;
   private static Method methodObject27635;
   private static Method methodObject27619;
   private static Method methodObject27817;
   private static Method methodObject27800;
   private static Method methodObject27772;
   private static Method methodObject27716;
   private static Method methodObject27803;
   private static Method methodObject27739;
   private static Method methodObject27755;
   private static Method methodObject27573;
   private static Method methodObject27771;
   private static Method methodObject27600;
   private static Method methodObject27789;
   private static Method methodObject27675;
   private static Method methodObject27735;
   private static Method methodObject27736;
   private static Method methodObject27816;
   private static Method methodObject27603;
   private static Method methodObject27822;
   private static Method methodObject27715;
   private static Method methodObject27597;
   private static Method methodObject27813;
   private static Method methodObject27696;
   private static Method methodObject27649;
   private static Method methodObject27625;
   private static Method methodObject27605;
   private static Method methodObject27666;
   private static Method methodObject27689;
   private static Method methodObject27602;
   private static Method methodObject27586;
   private static Method methodObject27694;
   private static Method methodObject27585;
   private static Method methodObject27692;
   private static Method methodObject27577;
   private static Method methodObject27673;
   private static Method methodObject27645;
   private static Method methodObject27737;
   private static Method methodObject27796;
   private static Method methodObject27656;
   private static Method methodObject27637;
   private static Method methodObject27629;
   private static Method methodObject27669;
   private static Method methodObject27596;
   private static Method methodObject27664;
   private static Method methodObject27615;
   private static Method methodObject27693;
   private static Method methodObject27710;
   private static Method methodObject27613;
   private static Method methodObject27671;
   private static Method methodObject27592;
   private static Method methodObject27793;
   private static Method methodObject27769;
   private static Method methodObject27778;
   private static Method methodObject27654;
   private static Method methodObject27636;
   private static Method methodObject27620;
   private static Method methodObject27721;
   private static Method methodObject27653;
   private static Method methodObject27633;
   private static Method methodObject27566;
   private static Method methodObject27568;
   private static Method methodObject27687;
   private static Method methodObject27722;
   private static Method methodObject27591;
   private static Method methodObject27815;
   private static Method methodObject27750;
   private static Method methodObject27627;
   private static Method methodObject27756;
   private static Method methodObject27663;
   private static Method methodObject27601;
   private static Method methodObject27788;
   private static Method methodObject27757;
   private static Method methodObject27806;
   private static Method methodObject27807;
   private static Method methodObject27563;
   private static Method methodObject27799;
   private static Method methodObject27628;
   private static Method methodObject27640;
   private static Method methodObject27717;
   private static Method methodObject27685;
   private static Method methodObject27798;
   private static Method methodObject27811;
   private static Method methodObject27741;
   private static Method methodObject27631;
   private static Method methodObject27670;
   private static Method methodObject27814;
   private static Method methodObject27754;
   private static Method methodObject27638;
   private static Method methodObject27729;
   private static Method methodObject27775;
   private static Method methodObject27760;
   private static Method methodObject27594;
   private static Method methodObject27632;
   private static Method methodObject27630;
   private static Method methodObject27608;
   private static Method methodObject27764;
   private static Method methodObject27661;
   private static Method methodObject27699;
   private static Method methodObject27679;
   private static Method methodObject27748;
   private static Method methodObject27644;
   private static Method methodObject27583;
   private static Method methodObject27774;
   private static Method methodObject27688;
   private static Method methodObject27731;
   private static Method methodObject27732;
   private static Method methodObject27762;
   private static Method methodObject27651;
   private static Method methodObject27677;
   private static Method methodObject27777;
   private static Method methodObject27820;
   private static Method methodObject27659;
   private static Method methodObject27567;
   private static Method methodObject27753;
   private static Method methodObject27705;
   private static Method methodObject27743;
   private static Method methodObject27606;
   private static Method methodObject27734;
   private static Method methodObject27746;
   private static Method methodObject27740;
   private static Method methodObject27724;
   private static Method methodObject27570;
   private static Method methodObject27593;
   private static Method methodObject27655;
   private static Method methodObject27607;
   private static Method methodObject27766;
   private static Method methodObject27672;
   private static Method methodObject27572;
   private static Method methodObject27683;
   private static Method methodObject27765;
   private static Method methodObject27626;
   private static Method methodObject27808;
   private static Method methodObject27786;
   private static Method methodObject27650;
   private static Method methodObject27795;
   private static Method methodObject27622;
   private static Method methodObject27751;
   private static Method methodObject27634;
   private static Method methodObject27676;
   private static Method methodObject27598;
   private static Method methodObject27647;
   private static Method methodObject27604;
   private static Method methodObject27704;
   private static Method methodObject27712;
   private static Method methodObject27569;
   private static Method methodObject27621;
   private static Method methodObject27578;
   private static Method methodObject27646;
   private static Method methodObject27812;
   private static Method methodObject27702;
   private static Method methodObject27776;
   private static Method methodObject27770;
   private static Method methodObject27809;
   private static Method methodObject27749;
   private static Method methodObject27742;
   private static Method methodObject27707;
   private static Method methodObject27708;
   private static Method methodObject27802;
   private static Method methodObject27718;
   private static Method methodObject27727;
   private static Method methodObject27801;
   private static Method methodObject27701;
   private static Method methodObject27730;
   private static Method methodObject27641;
   private static Method methodObject27819;
   private static Method methodObject27624;
   private static Method methodObject27564;
   private static Method methodObject27678;
   private static Method methodObject27792;
   private static Method methodObject27791;
   private static Method methodObject27790;
   private static Method methodObject27614;
   private static Method methodObject27665;
   private static Method methodObject27714;
   private static Method methodObject27783;
   private static Method methodObject27720;
   private static Method methodObject27571;
   private static Method methodObject27711;
   private static Method methodObject27810;
   private static Method methodObject27733;
   private static Method methodObject27576;
   private static Method methodObject27794;
   private static Method methodObject27611;
   private static Method methodObject27823;
   private static Method methodObject27643;
   private static Method methodObject27706;
   private static Method methodObject27805;
   private static Method methodObject27588;
   private static Method methodObject27610;
   private static Method methodObject27726;
   private static Method methodObject27580;
   private static Method methodObject27642;
   private static Method methodObject27668;
   private static Method methodObject27648;
   private static Method methodObject27681;
   private static Method methodObject27709;
   private static Method methodObject27582;
   private static Method methodObject27773;
   private static Method methodObject27579;
   private static Method methodObject27700;

   public void setCHARAtName(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject27616, this, arg0, arg1);
         this.delegate.setCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27616, var4);
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject27752, this, arg0);
         return this.postForExecute(methodObject27752, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject27752, this.onErrorForExecute(methodObject27752, var3));
      }
   }

   public int getExecuteBatch() {
      super.preForAll(methodObject27590, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27590, this.delegate.getExecuteBatch());
   }

   public void setNUMBERAtName(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject27618, this, arg0, arg1);
         this.delegate.setNUMBERAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27618, var4);
      }
   }

   public void setINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject27682, this, arg0, arg1);
         this.delegate.setINTERVALDS(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27682, var4);
      }
   }

   public void setNClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27658, this, arg0, arg1, arg2);
         this.delegate.setNClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27658, var6);
      }
   }

   public void setOPAQUEAtName(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27612, this, arg0, arg1);
         this.delegate.setOPAQUEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27612, var4);
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject27747, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27747, var4);
      }
   }

   public boolean getserverCursor() {
      super.preForAll(methodObject27818, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject27818, this.delegate.getserverCursor());
   }

   public void setTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27684, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27684, var4);
      }
   }

   public void enterImplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject27565, this, zeroLengthObjectArray);
         this.delegate.enterImplicitCache();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27565, var2);
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27761, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27761, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27761, (Integer)this.onErrorForAll(methodObject27761, var4));
      }
   }

   public void setNClobAtName(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27657, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27657, var4);
      }
   }

   public void setORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject27691, this, arg0, arg1);
         this.delegate.setORAData(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27691, var4);
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject27697, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27697, var4);
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27698, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27698, var5);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27581, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27581, var6);
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27745, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27745, var4);
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27804, this, arg0);
         this.delegate.setRowPrefetch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27804, var3);
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27759, this, arg0);
         return this.postForExecuteUpdate(methodObject27759, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject27759, (Integer)this.onErrorForAll(methodObject27759, var3));
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject27782, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27782, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27782, this.onErrorForAll(methodObject27782, var2));
      }
   }

   public void setROWIDAtName(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject27609, this, arg0, arg1);
         this.delegate.setROWIDAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27609, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject27703, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27703, var4);
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27744, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27744, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27797, this, arg0, arg1);
         this.delegate.defineColumnType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27797, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject27584, this, arg0, arg1, arg2, arg3);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27584, var6);
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27719, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27719, var5);
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27728, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27728, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject27780, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27780, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27780, this.onErrorForAll(methodObject27780, var2));
      }
   }

   public void setDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27599, this, arg0, arg1);
         this.delegate.setDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27599, var5);
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject27723, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27723, var6);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27781, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27781, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27781, this.onErrorForAll(methodObject27781, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27785, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27785, var3);
      }
   }

   public void setNStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27660, this, arg0, arg1);
         this.delegate.setNStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27660, var4);
      }
   }

   public void setARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject27686, this, arg0, arg1);
         this.delegate.setARRAY(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27686, var4);
      }
   }

   public void setTIMESTAMPAtName(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject27639, this, arg0, arg1);
         this.delegate.setTIMESTAMPAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27639, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27574, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27574, var6);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27713, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27713, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27575, this, arg0, arg1);
         this.delegate.setAsciiStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27575, var4);
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject27758, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject27758, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject27758, this.onErrorForAll(methodObject27758, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject27779, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27779, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27779, this.onErrorForAll(methodObject27779, var2));
      }
   }

   public void setCLOBAtName(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27623, this, arg0, arg1);
         this.delegate.setCLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27623, var4);
      }
   }

   public void registerBindChecksumListener(OracleStatement.BindChecksumListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject27821, this, arg0);
         this.delegate.registerBindChecksumListener(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27821, var3);
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27784, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27784, var3);
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject27768, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27768, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27768, this.onErrorForAll(methodObject27768, var2));
      }
   }

   public void setShortAtName(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject27595, this, arg0, arg1);
         this.delegate.setShortAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27595, var4);
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27738, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27738, var4);
      }
   }

   public void defineParameterTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27587, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27587, var5);
      }
   }

   public void setDATEAtName(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27617, this, arg0, arg1);
         this.delegate.setDATEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27617, var4);
      }
   }

   public void setBinaryDouble(int arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27667, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27667, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27767, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27767, var2);
      }
   }

   public void setCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject27674, this, arg0, arg1);
         this.delegate.setCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27674, var4);
      }
   }

   public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject27652, this, zeroLengthObjectArray);
         return (OracleParameterMetaData)this.postForAll(methodObject27652, this.proxyFactory.proxyForCache((Object)this.delegate.OracleGetParameterMetaData(), this, this.proxyCache, methodObject27652));
      } catch (SQLException var2) {
         return (OracleParameterMetaData)this.postForAll(methodObject27652, this.onErrorForAll(methodObject27652, var2));
      }
   }

   public void setBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27680, this, arg0, arg1);
         this.delegate.setBfile(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27680, var4);
      }
   }

   public void defineParameterType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27589, this, arg0, arg1, arg2);
         this.delegate.defineParameterType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27589, var5);
      }
   }

   public void setCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27690, this, arg0, arg1);
         this.delegate.setCustomDatum(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27690, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject27725, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject27725, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject27725));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject27725, this.onErrorForAll(methodObject27725, var2));
      }
   }

   public void setSQLXMLAtName(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject27662, this, arg0, arg1);
         this.delegate.setSQLXMLAtName(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27662, var4);
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27787, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27787, var3);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject27763, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27763, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27763, this.onErrorForAll(methodObject27763, var2));
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject27635, this, arg0, arg1);
         this.delegate.setTimestampAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27635, var4);
      }
   }

   public void setBLOBAtName(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27619, this, arg0, arg1);
         this.delegate.setBLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27619, var4);
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForAll(methodObject27817, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27817, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27817, this.onErrorForAll(methodObject27817, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27800, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27800, var5);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject27772, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27772, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject27772));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27772, this.onErrorForAll(methodObject27772, var2));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27716, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27716, var4);
      }
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject27803, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27803, this.delegate.getRowPrefetch());
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27739, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27739, var6);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27755, this, arg0, arg1);
         return this.postForExecute(methodObject27755, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27755, this.onErrorForExecute(methodObject27755, var4));
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27573, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27573, var5);
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27771, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27771, var2);
      }
   }

   public void setBinaryFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27600, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27600, var4);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject27789, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27789, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27789, this.onErrorForAll(methodObject27789, var2));
      }
   }

   public void setDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27675, this, arg0, arg1);
         this.delegate.setDATE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27675, var4);
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27735, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27735, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27736, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27736, var6);
      }
   }

   public boolean getFixedString() {
      super.preForAll(methodObject27816, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject27816, this.delegate.getFixedString());
   }

   public void setBinaryDoubleAtName(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27603, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27603, var4);
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject27822, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27715, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27715, var6);
      }
   }

   public void setLongAtName(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject27597, this, arg0, arg1);
         this.delegate.setLongAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27597, var5);
      }
   }

   public long getChecksum() throws SQLException {
      try {
         super.preForAll(methodObject27813, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27813, this.delegate.getChecksum());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27813, this.onErrorForAll(methodObject27813, var2));
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject27696, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27696, var4);
      }
   }

   public void setPlsqlIndexTable(int arg0, Object arg1, int arg2, int arg3, int arg4, int arg5) throws SQLException {
      try {
         super.preForAll(methodObject27649, this, arg0, arg1, arg2, arg3, arg4, arg5);
         this.delegate.setPlsqlIndexTable(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3, arg4, arg5);
      } catch (SQLException var8) {
         this.onErrorVoidForAll(methodObject27649, var8);
      }
   }

   public void setClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27625, this, arg0, arg1, arg2);
         this.delegate.setClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27625, var6);
      }
   }

   public void setStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27605, this, arg0, arg1);
         this.delegate.setStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27605, var4);
      }
   }

   public void setBinaryDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27666, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27666, var5);
      }
   }

   public void setSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27689, this, arg0, arg1);
         this.delegate.setSTRUCT(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27689, var4);
      }
   }

   public void setBinaryDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27602, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27602, var5);
      }
   }

   public void setObjectAtName(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject27586, this, arg0, arg1);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27586, var4);
      }
   }

   public void setOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27694, this, arg0, arg1);
         this.delegate.setOracleObject(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27694, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject27585, this, arg0, arg1, arg2);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27585, var5);
      }
   }

   public void setRefType(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27692, this, arg0, arg1);
         this.delegate.setRefType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27692, var4);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27577, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27577, var6);
      }
   }

   public void setRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject27673, this, arg0, arg1);
         this.delegate.setRAW(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27673, var4);
      }
   }

   public void setRefAtName(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject27645, this, arg0, arg1);
         this.delegate.setRefAtName(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27645, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject27737, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27737, var4);
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject27796, this, zeroLengthObjectArray);
         this.delegate.clearDefines();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27796, var2);
      }
   }

   public ResultSet getReturnResultSet() throws SQLException {
      try {
         super.preForAll(methodObject27656, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27656, this.proxyFactory.proxyForCache((Object)this.delegate.getReturnResultSet(), this, this.proxyCache, methodObject27656));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27656, this.onErrorForAll(methodObject27656, var2));
      }
   }

   public void setINTERVALYMAtName(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject27637, this, arg0, arg1);
         this.delegate.setINTERVALYMAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27637, var4);
      }
   }

   public void setBytesAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27629, this, arg0, arg1);
         this.delegate.setBytesAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27629, var4);
      }
   }

   public void setBytesForBlob(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27669, this, arg0, arg1);
         this.delegate.setBytesForBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27669, var4);
      }
   }

   public void setIntAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27596, this, arg0, arg1);
         this.delegate.setIntAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27596, var4);
      }
   }

   public void setBinaryFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27664, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27664, var4);
      }
   }

   public void setRAWAtName(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject27615, this, arg0, arg1);
         this.delegate.setRAWAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27615, var4);
      }
   }

   public void setREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27693, this, arg0, arg1);
         this.delegate.setREF(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27693, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27710, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27710, var4);
      }
   }

   public void setStructDescriptorAtName(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject27613, this, arg0, arg1);
         this.delegate.setStructDescriptorAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27613, var4);
      }
   }

   public void setCursor(int arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject27671, this, arg0, arg1);
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27671, var4);
      }
   }

   public void setNullAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27592, this, arg0, arg1);
         this.delegate.setNullAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27592, var4);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27793, this, arg0);
         return this.postForAll(methodObject27793, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27793, this.onErrorForAll(methodObject27793, var3));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27769, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27769, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject27778, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27778, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27778, this.onErrorForAll(methodObject27778, var2));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27654, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27654, var5);
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27636, this, arg0, arg1, arg2);
         this.delegate.setTimestampAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27636, var5);
      }
   }

   public void setBlobAtName(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27620, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27620, var4);
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject27721, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27721, var5);
      }
   }

   public void registerReturnParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27653, this, arg0, arg1);
         this.delegate.registerReturnParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27653, var4);
      }
   }

   public void setTimeAtName(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject27633, this, arg0, arg1);
         this.delegate.setTimeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27633, var4);
      }
   }

   public void enterExplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject27566, this, zeroLengthObjectArray);
         this.delegate.enterExplicitCache();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27566, var2);
      }
   }

   public void exitExplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject27568, this, zeroLengthObjectArray);
         this.delegate.exitExplicitCacheToActive();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27568, var2);
      }
   }

   public void setOPAQUE(int arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27687, this, arg0, arg1);
         this.delegate.setOPAQUE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27687, var4);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject27722, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27722, var4);
      }
   }

   public void setNullAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27591, this, arg0, arg1, arg2);
         this.delegate.setNullAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27591, var5);
      }
   }

   public void setFixedString(boolean arg0) {
      super.preForAll(methodObject27815, this, arg0);
      this.delegate.setFixedString(arg0);
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject27750, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27750, var4);
      }
   }

   public void setBFILEAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27627, this, arg0, arg1);
         this.delegate.setBFILEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27627, var4);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject27756, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27756, var2);
      }
   }

   public void setExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27663, this, arg0);
         this.delegate.setExecuteBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27663, var3);
      }
   }

   public void setBinaryFloatAtName(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27601, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27601, var4);
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27788, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27788, var3);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject27757, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27757, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject27757));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27757, this.onErrorForAll(methodObject27757, var2));
      }
   }

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27806, this, arg0);
         this.delegate.setLobPrefetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27806, var3);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27807, this, arg0);
         this.delegate.closeWithKey(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27807, var3);
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27563, this, arg0, arg1, arg2);
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27563, var5);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject27799, this, arg0, arg1, arg2, arg3);
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27799, var6);
      }
   }

   public void setBfileAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27628, this, arg0, arg1);
         this.delegate.setBfileAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27628, var4);
      }
   }

   public void setTIMESTAMPTZAtName(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27640, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27640, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27717, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27717, var6);
      }
   }

   public void setTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27685, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27685, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27798, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27798, var5);
      }
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject27811, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27811, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27811, this.onErrorForAll(methodObject27811, var2));
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27741, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27741, var4);
      }
   }

   public void setDateAtName(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject27631, this, arg0, arg1);
         this.delegate.setDateAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27631, var4);
      }
   }

   public void setFixedCHAR(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27670, this, arg0, arg1);
         this.delegate.setFixedCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27670, var4);
      }
   }

   public void setSnapshotSCN(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject27814, this, arg0);
         this.delegate.setSnapshotSCN(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27814, var4);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27754, this, arg0, arg1);
         return this.postForExecute(methodObject27754, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27754, this.onErrorForExecute(methodObject27754, var4));
      }
   }

   public void setINTERVALDSAtName(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject27638, this, arg0, arg1);
         this.delegate.setINTERVALDSAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27638, var4);
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject27729, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27729, var4);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject27775, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27775, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27775, this.onErrorForAll(methodObject27775, var2));
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27760, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27760, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27760, (Integer)this.onErrorForAll(methodObject27760, var4));
      }
   }

   public void setByteAtName(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject27594, this, arg0, arg1);
         this.delegate.setByteAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27594, var4);
      }
   }

   public void setDateAtName(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27632, this, arg0, arg1, arg2);
         this.delegate.setDateAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27632, var5);
      }
   }

   public void setBytesForBlobAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27630, this, arg0, arg1);
         this.delegate.setBytesForBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27630, var4);
      }
   }

   public void setCursorAtName(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject27608, this, arg0, arg1);
         this.delegate.setCursorAtName(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27608, var4);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27764, this, arg0);
         return this.postForExecuteQuery(methodObject27764, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject27764));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject27764, (ResultSet)this.onErrorForAll(methodObject27764, var3));
      }
   }

   public void setRowIdAtName(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject27661, this, arg0, arg1);
         this.delegate.setRowIdAtName(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27661, var4);
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27699, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27699, var4);
      }
   }

   public void setBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27679, this, arg0, arg1);
         this.delegate.setBFILE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27679, var4);
      }
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject27748, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27748, var4);
      }
   }

   public void setRefTypeAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27644, this, arg0, arg1);
         this.delegate.setRefTypeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27644, var4);
      }
   }

   public void setUnicodeStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27583, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27583, var5);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject27774, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27774, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27774, this.onErrorForAll(methodObject27774, var2));
      }
   }

   public void setStructDescriptor(int arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject27688, this, arg0, arg1);
         this.delegate.setStructDescriptor(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27688, var4);
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27731, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27731, var4);
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject27732, this, zeroLengthObjectArray);
         this.delegate.addBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27732, var2);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27762, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27762, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27762, (Integer)this.onErrorForAll(methodObject27762, var4));
      }
   }

   public void setDisableStmtCaching(boolean arg0) {
      super.preForAll(methodObject27651, this, arg0);
      this.delegate.setDisableStmtCaching(arg0);
   }

   public void setBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27677, this, arg0, arg1);
         this.delegate.setBLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27677, var4);
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject27777, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27777, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27777, this.onErrorForAll(methodObject27777, var2));
      }
   }

   public int getstatementType() {
      super.preForAll(methodObject27820, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27820, this.delegate.getstatementType());
   }

   public void setNClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27659, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27659, var4);
      }
   }

   public void exitImplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject27567, this, zeroLengthObjectArray);
         this.delegate.exitImplicitCacheToActive();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27567, var2);
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27753, this, arg0, arg1);
         return this.postForExecute(methodObject27753, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27753, this.onErrorForExecute(methodObject27753, var4));
      }
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject27705, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27705, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27743, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27743, var4);
      }
   }

   public void setStringForClobAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27606, this, arg0, arg1);
         this.delegate.setStringForClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27606, var4);
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject27734, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27734, var4);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27746, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27746, var5);
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27740, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27740, var4);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForAll(methodObject27724, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject27724, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject27724));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject27724, (ResultSet)this.onErrorForAll(methodObject27724, var2));
      }
   }

   public void exitExplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject27570, this, zeroLengthObjectArray);
         this.delegate.exitExplicitCacheToClose();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27570, var2);
      }
   }

   public void setBooleanAtName(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject27593, this, arg0, arg1);
         this.delegate.setBooleanAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27593, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27655, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27655, var5);
      }
   }

   public void setFixedCHARAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27607, this, arg0, arg1);
         this.delegate.setFixedCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27607, var4);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27766, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject27766, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject27766, this.onErrorForAll(methodObject27766, var2));
      }
   }

   public void setROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject27672, this, arg0, arg1);
         this.delegate.setROWID(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27672, var4);
      }
   }

   public void setCheckBindTypes(boolean arg0) {
      super.preForAll(methodObject27572, this, arg0);
      this.delegate.setCheckBindTypes(arg0);
   }

   public void setTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject27683, this, arg0, arg1);
         this.delegate.setTIMESTAMP(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27683, var4);
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject27765, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject27765, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject27765, this.onErrorForAll(methodObject27765, var2));
      }
   }

   public void setClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27626, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27626, var4);
      }
   }

   public int creationState() {
      super.preForAll(methodObject27808, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27808, this.delegate.creationState());
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27786, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27786, var3);
      }
   }

   public void setFormOfUse(int arg0, short arg1) {
      super.preForAll(methodObject27650, this, arg0, arg1);
      this.delegate.setFormOfUse(arg0, arg1);
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27795, this, arg0);
         return (Boolean)this.postForAll(methodObject27795, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27795, this.onErrorForAll(methodObject27795, var3));
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject27622, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27622, var4);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject27751, this, zeroLengthObjectArray);
         Method var10001 = methodObject27751;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject27751, var2);
      }
   }

   public void setTimeAtName(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27634, this, arg0, arg1, arg2);
         this.delegate.setTimeAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27634, var5);
      }
   }

   public void setNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject27676, this, arg0, arg1);
         this.delegate.setNUMBER(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27676, var4);
      }
   }

   public void setFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27598, this, arg0, arg1);
         this.delegate.setFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27598, var4);
      }
   }

   public void setOracleObjectAtName(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27647, this, arg0, arg1);
         this.delegate.setOracleObjectAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27647, var4);
      }
   }

   public void setBigDecimalAtName(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject27604, this, arg0, arg1);
         this.delegate.setBigDecimalAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27604, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27704, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27704, var5);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27712, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27712, var6);
      }
   }

   public void exitImplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject27569, this, zeroLengthObjectArray);
         this.delegate.exitImplicitCacheToClose();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27569, var2);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27621, this, arg0, arg1, arg2);
         this.delegate.setBlobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27621, var6);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27578, this, arg0, arg1);
         this.delegate.setBinaryStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27578, var4);
      }
   }

   public void setREFAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27646, this, arg0, arg1);
         this.delegate.setREFAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27646, var4);
      }
   }

   public OracleStatement.SqlKind getSqlKind() throws SQLException {
      try {
         super.preForAll(methodObject27812, this, zeroLengthObjectArray);
         return (OracleStatement.SqlKind)this.postForAll(methodObject27812, (Object)this.delegate.getSqlKind());
      } catch (SQLException var2) {
         return (OracleStatement.SqlKind)this.postForAll(methodObject27812, this.onErrorForAll(methodObject27812, var2));
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject27702, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27702, var4);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27776, this, arg0);
         return (Boolean)this.postForAll(methodObject27776, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27776, this.onErrorForAll(methodObject27776, var3));
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject27770, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27770, var2);
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject27809, this, arg0);
         this.delegate.setDatabaseChangeRegistration(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27809, var3);
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject27749, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27749, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27742, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27742, var6);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27707, this, zeroLengthObjectArray);
         return this.postForExecuteUpdate(methodObject27707, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return this.postForExecuteUpdate(methodObject27707, (Integer)this.onErrorForAll(methodObject27707, var2));
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27708, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27708, var5);
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27802, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27802, var5);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27718, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27718, var4);
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject27727, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27727, var4);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27801, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27801, var5);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject27701, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27701, var5);
      }
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27730, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27730, var5);
      }
   }

   public void setTIMESTAMPLTZAtName(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27641, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27641, var4);
      }
   }

   public int getcacheState() {
      super.preForAll(methodObject27819, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27819, this.delegate.getcacheState());
   }

   public void setClobAtName(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27624, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27624, var4);
      }
   }

   public void setInternalBytes(int arg0, byte[] arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27564, this, arg0, arg1, arg2);
         this.delegate.setInternalBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27564, var5);
      }
   }

   public void setCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27678, this, arg0, arg1);
         this.delegate.setCLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27678, var4);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27792, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27792, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27791, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27791, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27790, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27790, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27790, this.onErrorForAll(methodObject27790, var2));
      }
   }

   public void setSTRUCTAtName(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27614, this, arg0, arg1);
         this.delegate.setSTRUCTAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27614, var4);
      }
   }

   public void setBinaryFloat(int arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27665, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27665, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27714, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27714, var5);
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27783, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27783, var3);
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27720, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27720, var4);
      }
   }

   public String getOriginalSql() throws SQLException {
      try {
         super.preForAll(methodObject27571, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject27571, (Object)this.delegate.getOriginalSql());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject27571, this.onErrorForAll(methodObject27571, var2));
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27711, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27711, var5);
      }
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject27810, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject27810, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject27810, this.onErrorForAll(methodObject27810, var2));
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject27733, this, zeroLengthObjectArray);
         this.delegate.clearParameters();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27733, var2);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27576, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27576, var5);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27794, this, arg0);
         return (Boolean)this.postForAll(methodObject27794, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27794, this.onErrorForAll(methodObject27794, var3));
      }
   }

   public void setARRAYAtName(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject27611, this, arg0, arg1);
         this.delegate.setARRAYAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27611, var4);
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject27823, this, zeroLengthObjectArray);
      return this.postForAll(methodObject27823, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject27823));
   }

   public void setORADataAtName(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject27643, this, arg0, arg1);
         this.delegate.setORADataAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27643, var4);
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject27706, this, zeroLengthObjectArray);
         return this.postForExecute(methodObject27706, this.delegate.execute());
      } catch (SQLException var2) {
         return this.postForExecute(methodObject27706, this.onErrorForExecute(methodObject27706, var2));
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27805, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27805, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27805, this.onErrorForAll(methodObject27805, var2));
      }
   }

   public void defineParameterTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27588, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27588, var5);
      }
   }

   public void setArrayAtName(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject27610, this, arg0, arg1);
         this.delegate.setArrayAtName(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27610, var4);
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject27726, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject27726, this.proxyFactory.proxyForCreate((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject27726));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject27726, this.onErrorForAll(methodObject27726, var2));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27580, this, arg0, arg1);
         this.delegate.setCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27580, var4);
      }
   }

   public void setCustomDatumAtName(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27642, this, arg0, arg1);
         this.delegate.setCustomDatumAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27642, var4);
      }
   }

   public void setStringForClob(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27668, this, arg0, arg1);
         this.delegate.setStringForClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27668, var4);
      }
   }

   public void setURLAtName(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject27648, this, arg0, arg1);
         this.delegate.setURLAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27648, var4);
      }
   }

   public void setINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject27681, this, arg0, arg1);
         this.delegate.setINTERVALYM(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27681, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27709, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27709, var6);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27582, this, arg0, arg1);
         this.delegate.setNCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27582, var4);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject27773, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27773, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27773, this.onErrorForAll(methodObject27773, var2));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27579, this, arg0, arg1, arg2);
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27579, var6);
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27700, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27700, var4);
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
         methodObject27616 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCHARAtName", String.class, CHAR.class);
         methodObject27752 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject27590 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("getExecuteBatch");
         methodObject27618 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNUMBERAtName", String.class, NUMBER.class);
         methodObject27682 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject27658 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject27612 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOPAQUEAtName", String.class, OPAQUE.class);
         methodObject27747 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject27818 = OracleStatement.class.getDeclaredMethod("getserverCursor");
         methodObject27684 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject27565 = OraclePreparedStatement.class.getDeclaredMethod("enterImplicitCache");
         methodObject27761 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject27657 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, NClob.class);
         methodObject27691 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setORAData", Integer.TYPE, ORAData.class);
         methodObject27697 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject27698 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject27581 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject27745 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject27804 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject27759 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject27782 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject27609 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setROWIDAtName", String.class, ROWID.class);
         methodObject27703 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject27744 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject27797 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject27584 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject27719 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27728 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject27780 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject27599 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDoubleAtName", String.class, Double.TYPE);
         methodObject27723 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject27781 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject27785 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject27660 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNStringAtName", String.class, String.class);
         methodObject27686 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setARRAY", Integer.TYPE, ARRAY.class);
         methodObject27639 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPAtName", String.class, TIMESTAMP.class);
         methodObject27574 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject27713 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject27575 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class);
         methodObject27758 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject27779 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject27623 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCLOBAtName", String.class, CLOB.class);
         methodObject27821 = OracleStatement.class.getDeclaredMethod("registerBindChecksumListener", OracleStatement.BindChecksumListener.class);
         methodObject27784 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject27768 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject27595 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setShortAtName", String.class, Short.TYPE);
         methodObject27738 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject27587 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27617 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDATEAtName", String.class, DATE.class);
         methodObject27667 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, BINARY_DOUBLE.class);
         methodObject27767 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject27674 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCHAR", Integer.TYPE, CHAR.class);
         methodObject27652 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("OracleGetParameterMetaData");
         methodObject27680 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBfile", Integer.TYPE, BFILE.class);
         methodObject27589 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27690 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject27725 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject27662 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSQLXMLAtName", String.class, SQLXML.class);
         methodObject27787 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject27763 = Statement.class.getDeclaredMethod("isClosed");
         methodObject27635 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class);
         methodObject27619 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBLOBAtName", String.class, BLOB.class);
         methodObject27817 = OracleStatement.class.getDeclaredMethod("sendBatch");
         methodObject27800 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27772 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject27716 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject27803 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject27739 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27755 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject27573 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27771 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject27600 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, Float.TYPE);
         methodObject27789 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject27675 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDATE", Integer.TYPE, DATE.class);
         methodObject27735 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject27736 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject27816 = OracleStatement.class.getDeclaredMethod("getFixedString");
         methodObject27603 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, BINARY_DOUBLE.class);
         methodObject27822 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject27715 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27597 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setLongAtName", String.class, Long.TYPE);
         methodObject27813 = OracleStatement.class.getDeclaredMethod("getChecksum");
         methodObject27696 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject27649 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setPlsqlIndexTable", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27625 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject27605 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringAtName", String.class, String.class);
         methodObject27666 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, Double.TYPE);
         methodObject27689 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject27602 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, Double.TYPE);
         methodObject27586 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class);
         methodObject27694 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOracleObject", Integer.TYPE, Datum.class);
         methodObject27585 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE);
         methodObject27692 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefType", Integer.TYPE, REF.class);
         methodObject27577 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject27673 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRAW", Integer.TYPE, RAW.class);
         methodObject27645 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefAtName", String.class, Ref.class);
         methodObject27737 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject27796 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject27656 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("getReturnResultSet");
         methodObject27637 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYMAtName", String.class, INTERVALYM.class);
         methodObject27629 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesAtName", String.class, byte[].class);
         methodObject27669 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlob", Integer.TYPE, byte[].class);
         methodObject27596 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setIntAtName", String.class, Integer.TYPE);
         methodObject27664 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, Float.TYPE);
         methodObject27615 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRAWAtName", String.class, RAW.class);
         methodObject27693 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setREF", Integer.TYPE, REF.class);
         methodObject27710 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject27613 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptorAtName", String.class, StructDescriptor.class);
         methodObject27671 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCursor", Integer.TYPE, ResultSet.class);
         methodObject27592 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE);
         methodObject27793 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject27769 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject27778 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject27654 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27636 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class, Calendar.class);
         methodObject27620 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, Blob.class);
         methodObject27721 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject27653 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE);
         methodObject27633 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class);
         methodObject27566 = OraclePreparedStatement.class.getDeclaredMethod("enterExplicitCache");
         methodObject27568 = OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToActive");
         methodObject27687 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOPAQUE", Integer.TYPE, OPAQUE.class);
         methodObject27722 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject27591 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE, String.class);
         methodObject27815 = OracleStatement.class.getDeclaredMethod("setFixedString", Boolean.TYPE);
         methodObject27750 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject27627 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBFILEAtName", String.class, BFILE.class);
         methodObject27756 = Statement.class.getDeclaredMethod("cancel");
         methodObject27663 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setExecuteBatch", Integer.TYPE);
         methodObject27601 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, BINARY_FLOAT.class);
         methodObject27788 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject27757 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject27806 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject27807 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject27563 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Integer.TYPE);
         methodObject27799 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject27628 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBfileAtName", String.class, BFILE.class);
         methodObject27640 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZAtName", String.class, TIMESTAMPTZ.class);
         methodObject27717 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27685 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject27798 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27811 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject27741 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject27631 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class);
         methodObject27670 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFixedCHAR", Integer.TYPE, String.class);
         methodObject27814 = OracleStatement.class.getDeclaredMethod("setSnapshotSCN", Long.TYPE);
         methodObject27754 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject27638 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDSAtName", String.class, INTERVALDS.class);
         methodObject27729 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject27775 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject27760 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject27594 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setByteAtName", String.class, Byte.TYPE);
         methodObject27632 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class, Calendar.class);
         methodObject27630 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlobAtName", String.class, byte[].class);
         methodObject27608 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCursorAtName", String.class, ResultSet.class);
         methodObject27764 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject27661 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRowIdAtName", String.class, RowId.class);
         methodObject27699 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject27679 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBFILE", Integer.TYPE, BFILE.class);
         methodObject27748 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject27644 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefTypeAtName", String.class, REF.class);
         methodObject27583 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setUnicodeStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27774 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject27688 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptor", Integer.TYPE, StructDescriptor.class);
         methodObject27731 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject27732 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject27762 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject27651 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDisableStmtCaching", Boolean.TYPE);
         methodObject27677 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBLOB", Integer.TYPE, BLOB.class);
         methodObject27777 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject27820 = OracleStatement.class.getDeclaredMethod("getstatementType");
         methodObject27659 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class);
         methodObject27567 = OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToActive");
         methodObject27753 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject27705 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject27743 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject27606 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringForClobAtName", String.class, String.class);
         methodObject27734 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject27746 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27740 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject27724 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject27570 = OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToClose");
         methodObject27593 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBooleanAtName", String.class, Boolean.TYPE);
         methodObject27655 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27607 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFixedCHARAtName", String.class, String.class);
         methodObject27766 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject27672 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setROWID", Integer.TYPE, ROWID.class);
         methodObject27572 = OraclePreparedStatement.class.getDeclaredMethod("setCheckBindTypes", Boolean.TYPE);
         methodObject27683 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject27765 = Statement.class.getDeclaredMethod("getConnection");
         methodObject27626 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class);
         methodObject27808 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("creationState");
         methodObject27786 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject27650 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFormOfUse", Integer.TYPE, Short.TYPE);
         methodObject27795 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject27622 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class);
         methodObject27751 = Statement.class.getDeclaredMethod("close");
         methodObject27634 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class, Calendar.class);
         methodObject27676 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNUMBER", Integer.TYPE, NUMBER.class);
         methodObject27598 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFloatAtName", String.class, Float.TYPE);
         methodObject27647 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOracleObjectAtName", String.class, Datum.class);
         methodObject27604 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBigDecimalAtName", String.class, BigDecimal.class);
         methodObject27704 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject27712 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject27569 = OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToClose");
         methodObject27621 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class, Long.TYPE);
         methodObject27578 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class);
         methodObject27646 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setREFAtName", String.class, REF.class);
         methodObject27812 = OracleStatement.class.getDeclaredMethod("getSqlKind");
         methodObject27702 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject27776 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject27770 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject27809 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject27749 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject27742 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27707 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject27708 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27802 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27718 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject27727 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject27801 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27701 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject27730 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject27641 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZAtName", String.class, TIMESTAMPLTZ.class);
         methodObject27819 = OracleStatement.class.getDeclaredMethod("getcacheState");
         methodObject27624 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Clob.class);
         methodObject27564 = OraclePreparedStatement.class.getDeclaredMethod("setInternalBytes", Integer.TYPE, byte[].class, Integer.TYPE);
         methodObject27678 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCLOB", Integer.TYPE, CLOB.class);
         methodObject27792 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject27791 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject27790 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject27614 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSTRUCTAtName", String.class, STRUCT.class);
         methodObject27665 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, BINARY_FLOAT.class);
         methodObject27714 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject27783 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject27720 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject27571 = OraclePreparedStatement.class.getDeclaredMethod("getOriginalSql");
         methodObject27711 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27810 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject27733 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject27576 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27794 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject27611 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setARRAYAtName", String.class, ARRAY.class);
         methodObject27823 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject27643 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setORADataAtName", String.class, ORAData.class);
         methodObject27706 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject27805 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject27588 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27610 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setArrayAtName", String.class, Array.class);
         methodObject27726 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject27580 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class);
         methodObject27642 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCustomDatumAtName", String.class, CustomDatum.class);
         methodObject27668 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringForClob", Integer.TYPE, String.class);
         methodObject27648 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setURLAtName", String.class, URL.class);
         methodObject27681 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject27709 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject27582 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class);
         methodObject27773 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject27579 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject27700 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1internal$1OraclePreparedStatement$$$Proxy(OraclePreparedStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
