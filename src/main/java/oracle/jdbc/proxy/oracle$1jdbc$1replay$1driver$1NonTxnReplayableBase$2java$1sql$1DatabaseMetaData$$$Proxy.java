package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1DatabaseMetaData$$$Proxy extends NonTxnReplayableBase implements DatabaseMetaData, _Proxy_ {
   private DatabaseMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29603;
   private static Method methodObject29706;
   private static Method methodObject29677;
   private static Method methodObject29662;
   private static Method methodObject29593;
   private static Method methodObject29582;
   private static Method methodObject29697;
   private static Method methodObject29636;
   private static Method methodObject29600;
   private static Method methodObject29686;
   private static Method methodObject29638;
   private static Method methodObject29648;
   private static Method methodObject29720;
   private static Method methodObject29619;
   private static Method methodObject29690;
   private static Method methodObject29580;
   private static Method methodObject29652;
   private static Method methodObject29642;
   private static Method methodObject29737;
   private static Method methodObject29714;
   private static Method methodObject29633;
   private static Method methodObject29570;
   private static Method methodObject29624;
   private static Method methodObject29629;
   private static Method methodObject29595;
   private static Method methodObject29610;
   private static Method methodObject29635;
   private static Method methodObject29729;
   private static Method methodObject29721;
   private static Method methodObject29709;
   private static Method methodObject29594;
   private static Method methodObject29574;
   private static Method methodObject29584;
   private static Method methodObject29590;
   private static Method methodObject29731;
   private static Method methodObject29732;
   private static Method methodObject29588;
   private static Method methodObject29612;
   private static Method methodObject29641;
   private static Method methodObject29726;
   private static Method methodObject29585;
   private static Method methodObject29719;
   private static Method methodObject29591;
   private static Method methodObject29639;
   private static Method methodObject29578;
   private static Method methodObject29722;
   private static Method methodObject29630;
   private static Method methodObject29695;
   private static Method methodObject29575;
   private static Method methodObject29654;
   private static Method methodObject29583;
   private static Method methodObject29592;
   private static Method methodObject29678;
   private static Method methodObject29651;
   private static Method methodObject29605;
   private static Method methodObject29631;
   private static Method methodObject29668;
   private static Method methodObject29566;
   private static Method methodObject29715;
   private static Method methodObject29687;
   private static Method methodObject29691;
   private static Method methodObject29622;
   private static Method methodObject29637;
   private static Method methodObject29647;
   private static Method methodObject29623;
   private static Method methodObject29734;
   private static Method methodObject29728;
   private static Method methodObject29716;
   private static Method methodObject29710;
   private static Method methodObject29738;
   private static Method methodObject29672;
   private static Method methodObject29625;
   private static Method methodObject29683;
   private static Method methodObject29634;
   private static Method methodObject29620;
   private static Method methodObject29577;
   private static Method methodObject29646;
   private static Method methodObject29718;
   private static Method methodObject29713;
   private static Method methodObject29667;
   private static Method methodObject29699;
   private static Method methodObject29669;
   private static Method methodObject29626;
   private static Method methodObject29684;
   private static Method methodObject29589;
   private static Method methodObject29618;
   private static Method methodObject29657;
   private static Method methodObject29704;
   private static Method methodObject29660;
   private static Method methodObject29602;
   private static Method methodObject29565;
   private static Method methodObject29645;
   private static Method methodObject29733;
   private static Method methodObject29569;
   private static Method methodObject29597;
   private static Method methodObject29700;
   private static Method methodObject29665;
   private static Method methodObject29689;
   private static Method methodObject29682;
   private static Method methodObject29671;
   private static Method methodObject29725;
   private static Method methodObject29615;
   private static Method methodObject29604;
   private static Method methodObject29643;
   private static Method methodObject29705;
   private static Method methodObject29696;
   private static Method methodObject29685;
   private static Method methodObject29628;
   private static Method methodObject29656;
   private static Method methodObject29717;
   private static Method methodObject29606;
   private static Method methodObject29675;
   private static Method methodObject29688;
   private static Method methodObject29598;
   private static Method methodObject29576;
   private static Method methodObject29711;
   private static Method methodObject29655;
   private static Method methodObject29735;
   private static Method methodObject29572;
   private static Method methodObject29661;
   private static Method methodObject29676;
   private static Method methodObject29632;
   private static Method methodObject29649;
   private static Method methodObject29596;
   private static Method methodObject29568;
   private static Method methodObject29586;
   private static Method methodObject29617;
   private static Method methodObject29650;
   private static Method methodObject29666;
   private static Method methodObject29681;
   private static Method methodObject29674;
   private static Method methodObject29579;
   private static Method methodObject29703;
   private static Method methodObject29692;
   private static Method methodObject29627;
   private static Method methodObject29613;
   private static Method methodObject29611;
   private static Method methodObject29587;
   private static Method methodObject29614;
   private static Method methodObject29573;
   private static Method methodObject29644;
   private static Method methodObject29653;
   private static Method methodObject29727;
   private static Method methodObject29616;
   private static Method methodObject29730;
   private static Method methodObject29708;
   private static Method methodObject29680;
   private static Method methodObject29663;
   private static Method methodObject29693;
   private static Method methodObject29740;
   private static Method methodObject29739;
   private static Method methodObject29724;
   private static Method methodObject29571;
   private static Method methodObject29701;
   private static Method methodObject29609;
   private static Method methodObject29608;
   private static Method methodObject29567;
   private static Method methodObject29621;
   private static Method methodObject29673;
   private static Method methodObject29694;
   private static Method methodObject29670;
   private static Method methodObject29599;
   private static Method methodObject29698;
   private static Method methodObject29607;
   private static Method methodObject29658;
   private static Method methodObject29640;
   private static Method methodObject29664;
   private static Method methodObject29736;
   private static Method methodObject29702;
   private static Method methodObject29707;
   private static Method methodObject29659;
   private static Method methodObject29601;
   private static Method methodObject29723;
   private static Method methodObject29712;
   private static Method methodObject29679;
   private static Method methodObject29581;

   public int getJDBCMajorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29603, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29603, this.delegate.getJDBCMajorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29603, this.onErrorForAll(methodObject29603, var2));
      }
   }

   public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
      try {
         super.preForAll(methodObject29706, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29706, this.delegate.supportsOpenCursorsAcrossCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29706, this.onErrorForAll(methodObject29706, var2));
      }
   }

   public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29677, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29677, this.delegate.supportsCatalogsInIndexDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29677, this.onErrorForAll(methodObject29677, var2));
      }
   }

   public boolean ownInsertsAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29662, this, arg0);
         return (Boolean)this.postForAll(methodObject29662, this.delegate.ownInsertsAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29662, this.onErrorForAll(methodObject29662, var3));
      }
   }

   public int getDriverMinorVersion() {
      super.preForAll(methodObject29593, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject29593, this.delegate.getDriverMinorVersion());
   }

   public String getCatalogTerm() throws SQLException {
      try {
         super.preForAll(methodObject29582, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29582, (Object)this.delegate.getCatalogTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29582, this.onErrorForAll(methodObject29582, var2));
      }
   }

   public boolean supportsLimitedOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject29697, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29697, this.delegate.supportsLimitedOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29697, this.onErrorForAll(methodObject29697, var2));
      }
   }

   public ResultSet getSchemas() throws SQLException {
      try {
         super.preForAll(methodObject29636, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29636, this.proxyFactory.proxyForCache((Object)this.delegate.getSchemas(), this, this.proxyCache, methodObject29636));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29636, this.onErrorForAll(methodObject29636, var2));
      }
   }

   public String getIdentifierQuoteString() throws SQLException {
      try {
         super.preForAll(methodObject29600, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29600, (Object)this.delegate.getIdentifierQuoteString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29600, this.onErrorForAll(methodObject29600, var2));
      }
   }

   public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
      try {
         super.preForAll(methodObject29686, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29686, this.delegate.supportsDataManipulationTransactionsOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29686, this.onErrorForAll(methodObject29686, var2));
      }
   }

   public String getSearchStringEscape() throws SQLException {
      try {
         super.preForAll(methodObject29638, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29638, (Object)this.delegate.getSearchStringEscape());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29638, this.onErrorForAll(methodObject29638, var2));
      }
   }

   public ResultSet getUDTs(String arg0, String arg1, String arg2, int[] arg3) throws SQLException {
      try {
         super.preForAll(methodObject29648, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29648, this.proxyFactory.proxyForCache((Object)this.delegate.getUDTs(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29648));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29648, this.onErrorForAll(methodObject29648, var6));
      }
   }

   public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29720, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29720, this.delegate.supportsSchemasInPrivilegeDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29720, this.onErrorForAll(methodObject29720, var2));
      }
   }

   public int getMaxSchemaNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29619, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29619, this.delegate.getMaxSchemaNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29619, this.onErrorForAll(methodObject29619, var2));
      }
   }

   public boolean supportsFullOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject29690, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29690, this.delegate.supportsFullOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29690, this.onErrorForAll(methodObject29690, var2));
      }
   }

   public ResultSet getBestRowIdentifier(String arg0, String arg1, String arg2, int arg3, boolean arg4) throws SQLException {
      try {
         super.preForAll(methodObject29580, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject29580, this.proxyFactory.proxyForCache((Object)this.delegate.getBestRowIdentifier(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject29580));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject29580, this.onErrorForAll(methodObject29580, var7));
      }
   }

   public boolean locatorsUpdateCopy() throws SQLException {
      try {
         super.preForAll(methodObject29652, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29652, this.delegate.locatorsUpdateCopy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29652, this.onErrorForAll(methodObject29652, var2));
      }
   }

   public String getSystemFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29642, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29642, (Object)this.delegate.getSystemFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29642, this.onErrorForAll(methodObject29642, var2));
      }
   }

   public boolean usesLocalFilePerTable() throws SQLException {
      try {
         super.preForAll(methodObject29737, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29737, this.delegate.usesLocalFilePerTable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29737, this.onErrorForAll(methodObject29737, var2));
      }
   }

   public boolean supportsResultSetConcurrency(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject29714, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject29714, this.delegate.supportsResultSetConcurrency(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject29714, this.onErrorForAll(methodObject29714, var4));
      }
   }

   public String getSQLKeywords() throws SQLException {
      try {
         super.preForAll(methodObject29633, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29633, (Object)this.delegate.getSQLKeywords());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29633, this.onErrorForAll(methodObject29633, var2));
      }
   }

   public String getUserName() throws SQLException {
      try {
         super.preForAll(methodObject29570, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29570, (Object)this.delegate.getUserName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29570, this.onErrorForAll(methodObject29570, var2));
      }
   }

   public int getMaxUserNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29624, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29624, this.delegate.getMaxUserNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29624, this.onErrorForAll(methodObject29624, var2));
      }
   }

   public ResultSet getProcedures(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29629, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29629, this.proxyFactory.proxyForCache((Object)this.delegate.getProcedures(arg0, arg1, arg2), this, this.proxyCache, methodObject29629));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29629, this.onErrorForAll(methodObject29629, var5));
      }
   }

   public String getDriverVersion() throws SQLException {
      try {
         super.preForAll(methodObject29595, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29595, (Object)this.delegate.getDriverVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29595, this.onErrorForAll(methodObject29595, var2));
      }
   }

   public int getMaxColumnsInIndex() throws SQLException {
      try {
         super.preForAll(methodObject29610, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29610, this.delegate.getMaxColumnsInIndex());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29610, this.onErrorForAll(methodObject29610, var2));
      }
   }

   public String getSchemaTerm() throws SQLException {
      try {
         super.preForAll(methodObject29635, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29635, (Object)this.delegate.getSchemaTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29635, this.onErrorForAll(methodObject29635, var2));
      }
   }

   public boolean supportsSubqueriesInIns() throws SQLException {
      try {
         super.preForAll(methodObject29729, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29729, this.delegate.supportsSubqueriesInIns());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29729, this.onErrorForAll(methodObject29729, var2));
      }
   }

   public boolean supportsSchemasInProcedureCalls() throws SQLException {
      try {
         super.preForAll(methodObject29721, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29721, this.delegate.supportsSchemasInProcedureCalls());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29721, this.onErrorForAll(methodObject29721, var2));
      }
   }

   public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
      try {
         super.preForAll(methodObject29709, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29709, this.delegate.supportsOpenStatementsAcrossRollback());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29709, this.onErrorForAll(methodObject29709, var2));
      }
   }

   public String getDriverName() throws SQLException {
      try {
         super.preForAll(methodObject29594, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29594, (Object)this.delegate.getDriverName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29594, this.onErrorForAll(methodObject29594, var2));
      }
   }

   public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
      try {
         super.preForAll(methodObject29574, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29574, this.delegate.autoCommitFailureClosesAllResultSets());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29574, this.onErrorForAll(methodObject29574, var2));
      }
   }

   public ResultSet getClientInfoProperties() throws SQLException {
      try {
         super.preForAll(methodObject29584, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29584, this.proxyFactory.proxyForCache((Object)this.delegate.getClientInfoProperties(), this, this.proxyCache, methodObject29584));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29584, this.onErrorForAll(methodObject29584, var2));
      }
   }

   public String getDatabaseProductName() throws SQLException {
      try {
         super.preForAll(methodObject29590, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29590, (Object)this.delegate.getDatabaseProductName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29590, this.onErrorForAll(methodObject29590, var2));
      }
   }

   public boolean supportsTableCorrelationNames() throws SQLException {
      try {
         super.preForAll(methodObject29731, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29731, this.delegate.supportsTableCorrelationNames());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29731, this.onErrorForAll(methodObject29731, var2));
      }
   }

   public boolean supportsTransactionIsolationLevel(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29732, this, arg0);
         return (Boolean)this.postForAll(methodObject29732, this.delegate.supportsTransactionIsolationLevel(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29732, this.onErrorForAll(methodObject29732, var3));
      }
   }

   public int getDatabaseMajorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29588, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29588, this.delegate.getDatabaseMajorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29588, this.onErrorForAll(methodObject29588, var2));
      }
   }

   public int getMaxColumnsInSelect() throws SQLException {
      try {
         super.preForAll(methodObject29612, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29612, this.delegate.getMaxColumnsInSelect());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29612, this.onErrorForAll(methodObject29612, var2));
      }
   }

   public ResultSet getSuperTypes(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29641, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29641, this.proxyFactory.proxyForCache((Object)this.delegate.getSuperTypes(arg0, arg1, arg2), this, this.proxyCache, methodObject29641));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29641, this.onErrorForAll(methodObject29641, var5));
      }
   }

   public boolean supportsStoredProcedures() throws SQLException {
      try {
         super.preForAll(methodObject29726, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29726, this.delegate.supportsStoredProcedures());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29726, this.onErrorForAll(methodObject29726, var2));
      }
   }

   public ResultSet getColumnPrivileges(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29585, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29585, this.proxyFactory.proxyForCache((Object)this.delegate.getColumnPrivileges(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29585));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29585, this.onErrorForAll(methodObject29585, var6));
      }
   }

   public boolean supportsSchemasInIndexDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29719, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29719, this.delegate.supportsSchemasInIndexDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29719, this.onErrorForAll(methodObject29719, var2));
      }
   }

   public int getDefaultTransactionIsolation() throws SQLException {
      try {
         super.preForAll(methodObject29591, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29591, this.delegate.getDefaultTransactionIsolation());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29591, this.onErrorForAll(methodObject29591, var2));
      }
   }

   public String getStringFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29639, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29639, (Object)this.delegate.getStringFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29639, this.onErrorForAll(methodObject29639, var2));
      }
   }

   public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
      try {
         super.preForAll(methodObject29578, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29578, this.delegate.doesMaxRowSizeIncludeBlobs());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29578, this.onErrorForAll(methodObject29578, var2));
      }
   }

   public boolean supportsSchemasInTableDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29722, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29722, this.delegate.supportsSchemasInTableDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29722, this.onErrorForAll(methodObject29722, var2));
      }
   }

   public ResultSet getPseudoColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29630, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29630, this.proxyFactory.proxyForCache((Object)this.delegate.getPseudoColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29630));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29630, this.onErrorForAll(methodObject29630, var6));
      }
   }

   public boolean supportsIntegrityEnhancementFacility() throws SQLException {
      try {
         super.preForAll(methodObject29695, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29695, this.delegate.supportsIntegrityEnhancementFacility());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29695, this.onErrorForAll(methodObject29695, var2));
      }
   }

   public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
      try {
         super.preForAll(methodObject29575, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29575, this.delegate.dataDefinitionCausesTransactionCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29575, this.onErrorForAll(methodObject29575, var2));
      }
   }

   public boolean nullsAreSortedAtEnd() throws SQLException {
      try {
         super.preForAll(methodObject29654, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29654, this.delegate.nullsAreSortedAtEnd());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29654, this.onErrorForAll(methodObject29654, var2));
      }
   }

   public ResultSet getCatalogs() throws SQLException {
      try {
         super.preForAll(methodObject29583, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29583, this.proxyFactory.proxyForCache((Object)this.delegate.getCatalogs(), this, this.proxyCache, methodObject29583));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29583, this.onErrorForAll(methodObject29583, var2));
      }
   }

   public int getDriverMajorVersion() {
      super.preForAll(methodObject29592, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject29592, this.delegate.getDriverMajorVersion());
   }

   public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29678, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29678, this.delegate.supportsCatalogsInPrivilegeDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29678, this.onErrorForAll(methodObject29678, var2));
      }
   }

   public boolean isCatalogAtStart() throws SQLException {
      try {
         super.preForAll(methodObject29651, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29651, this.delegate.isCatalogAtStart());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29651, this.onErrorForAll(methodObject29651, var2));
      }
   }

   public int getMaxBinaryLiteralLength() throws SQLException {
      try {
         super.preForAll(methodObject29605, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29605, this.delegate.getMaxBinaryLiteralLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29605, this.onErrorForAll(methodObject29605, var2));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject29631, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29631, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29631, this.onErrorForAll(methodObject29631, var2));
      }
   }

   public boolean storesUpperCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29668, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29668, this.delegate.storesUpperCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29668, this.onErrorForAll(methodObject29668, var2));
      }
   }

   public boolean isReadOnly() throws SQLException {
      try {
         super.preForAll(methodObject29566, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29566, this.delegate.isReadOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29566, this.onErrorForAll(methodObject29566, var2));
      }
   }

   public boolean supportsResultSetHoldability(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29715, this, arg0);
         return (Boolean)this.postForAll(methodObject29715, this.delegate.supportsResultSetHoldability(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29715, this.onErrorForAll(methodObject29715, var3));
      }
   }

   public boolean supportsDifferentTableCorrelationNames() throws SQLException {
      try {
         super.preForAll(methodObject29687, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29687, this.delegate.supportsDifferentTableCorrelationNames());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29687, this.onErrorForAll(methodObject29687, var2));
      }
   }

   public boolean supportsGetGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject29691, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29691, this.delegate.supportsGetGeneratedKeys());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29691, this.onErrorForAll(methodObject29691, var2));
      }
   }

   public int getMaxTableNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29622, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29622, this.delegate.getMaxTableNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29622, this.onErrorForAll(methodObject29622, var2));
      }
   }

   public ResultSet getSchemas(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject29637, this, arg0, arg1);
         return (ResultSet)this.postForAll(methodObject29637, this.proxyFactory.proxyForCache((Object)this.delegate.getSchemas(arg0, arg1), this, this.proxyCache, methodObject29637));
      } catch (SQLException var4) {
         return (ResultSet)this.postForAll(methodObject29637, this.onErrorForAll(methodObject29637, var4));
      }
   }

   public ResultSet getTypeInfo() throws SQLException {
      try {
         super.preForAll(methodObject29647, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29647, this.proxyFactory.proxyForCache((Object)this.delegate.getTypeInfo(), this, this.proxyCache, methodObject29647));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29647, this.onErrorForAll(methodObject29647, var2));
      }
   }

   public int getMaxTablesInSelect() throws SQLException {
      try {
         super.preForAll(methodObject29623, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29623, this.delegate.getMaxTablesInSelect());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29623, this.onErrorForAll(methodObject29623, var2));
      }
   }

   public boolean supportsUnion() throws SQLException {
      try {
         super.preForAll(methodObject29734, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29734, this.delegate.supportsUnion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29734, this.onErrorForAll(methodObject29734, var2));
      }
   }

   public boolean supportsSubqueriesInExists() throws SQLException {
      try {
         super.preForAll(methodObject29728, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29728, this.delegate.supportsSubqueriesInExists());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29728, this.onErrorForAll(methodObject29728, var2));
      }
   }

   public boolean supportsResultSetType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29716, this, arg0);
         return (Boolean)this.postForAll(methodObject29716, this.delegate.supportsResultSetType(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29716, this.onErrorForAll(methodObject29716, var3));
      }
   }

   public boolean supportsOrderByUnrelated() throws SQLException {
      try {
         super.preForAll(methodObject29710, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29710, this.delegate.supportsOrderByUnrelated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29710, this.onErrorForAll(methodObject29710, var2));
      }
   }

   public boolean usesLocalFiles() throws SQLException {
      try {
         super.preForAll(methodObject29738, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29738, this.delegate.usesLocalFiles());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29738, this.onErrorForAll(methodObject29738, var2));
      }
   }

   public boolean supportsANSI92IntermediateSQL() throws SQLException {
      try {
         super.preForAll(methodObject29672, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29672, this.delegate.supportsANSI92IntermediateSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29672, this.onErrorForAll(methodObject29672, var2));
      }
   }

   public String getNumericFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29625, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29625, (Object)this.delegate.getNumericFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29625, this.onErrorForAll(methodObject29625, var2));
      }
   }

   public boolean supportsConvert(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject29683, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject29683, this.delegate.supportsConvert(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject29683, this.onErrorForAll(methodObject29683, var4));
      }
   }

   public int getSQLStateType() throws SQLException {
      try {
         super.preForAll(methodObject29634, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29634, this.delegate.getSQLStateType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29634, this.onErrorForAll(methodObject29634, var2));
      }
   }

   public int getMaxStatementLength() throws SQLException {
      try {
         super.preForAll(methodObject29620, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29620, this.delegate.getMaxStatementLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29620, this.onErrorForAll(methodObject29620, var2));
      }
   }

   public boolean deletesAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29577, this, arg0);
         return (Boolean)this.postForAll(methodObject29577, this.delegate.deletesAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29577, this.onErrorForAll(methodObject29577, var3));
      }
   }

   public String getTimeDateFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29646, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29646, (Object)this.delegate.getTimeDateFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29646, this.onErrorForAll(methodObject29646, var2));
      }
   }

   public boolean supportsSchemasInDataManipulation() throws SQLException {
      try {
         super.preForAll(methodObject29718, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29718, this.delegate.supportsSchemasInDataManipulation());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29718, this.onErrorForAll(methodObject29718, var2));
      }
   }

   public boolean supportsPositionedUpdate() throws SQLException {
      try {
         super.preForAll(methodObject29713, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29713, this.delegate.supportsPositionedUpdate());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29713, this.onErrorForAll(methodObject29713, var2));
      }
   }

   public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29667, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29667, this.delegate.storesMixedCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29667, this.onErrorForAll(methodObject29667, var2));
      }
   }

   public boolean supportsMixedCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29699, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29699, this.delegate.supportsMixedCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29699, this.onErrorForAll(methodObject29699, var2));
      }
   }

   public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29669, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29669, this.delegate.storesUpperCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29669, this.onErrorForAll(methodObject29669, var2));
      }
   }

   public ResultSet getPrimaryKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29626, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29626, this.proxyFactory.proxyForCache((Object)this.delegate.getPrimaryKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject29626));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29626, this.onErrorForAll(methodObject29626, var5));
      }
   }

   public boolean supportsCoreSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject29684, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29684, this.delegate.supportsCoreSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29684, this.onErrorForAll(methodObject29684, var2));
      }
   }

   public int getDatabaseMinorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29589, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29589, this.delegate.getDatabaseMinorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29589, this.onErrorForAll(methodObject29589, var2));
      }
   }

   public int getMaxRowSize() throws SQLException {
      try {
         super.preForAll(methodObject29618, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29618, this.delegate.getMaxRowSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29618, this.onErrorForAll(methodObject29618, var2));
      }
   }

   public boolean nullsAreSortedLow() throws SQLException {
      try {
         super.preForAll(methodObject29657, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29657, this.delegate.nullsAreSortedLow());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29657, this.onErrorForAll(methodObject29657, var2));
      }
   }

   public boolean supportsNamedParameters() throws SQLException {
      try {
         super.preForAll(methodObject29704, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29704, this.delegate.supportsNamedParameters());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29704, this.onErrorForAll(methodObject29704, var2));
      }
   }

   public boolean othersUpdatesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29660, this, arg0);
         return (Boolean)this.postForAll(methodObject29660, this.delegate.othersUpdatesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29660, this.onErrorForAll(methodObject29660, var3));
      }
   }

   public ResultSet getIndexInfo(String arg0, String arg1, String arg2, boolean arg3, boolean arg4) throws SQLException {
      try {
         super.preForAll(methodObject29602, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject29602, this.proxyFactory.proxyForCache((Object)this.delegate.getIndexInfo(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject29602));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject29602, this.onErrorForAll(methodObject29602, var7));
      }
   }

   public String getURL() throws SQLException {
      try {
         super.preForAll(methodObject29565, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29565, (Object)this.delegate.getURL());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29565, this.onErrorForAll(methodObject29565, var2));
      }
   }

   public ResultSet getTables(String arg0, String arg1, String arg2, String[] arg3) throws SQLException {
      try {
         super.preForAll(methodObject29645, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29645, this.proxyFactory.proxyForCache((Object)this.delegate.getTables(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29645));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29645, this.onErrorForAll(methodObject29645, var6));
      }
   }

   public boolean supportsTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29733, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29733, this.delegate.supportsTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29733, this.onErrorForAll(methodObject29733, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject29569, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject29569, this.proxyFactory.proxyForCache((Object)this.delegate.getConnection(), this, this.proxyCache, methodObject29569));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject29569, this.onErrorForAll(methodObject29569, var2));
      }
   }

   public String getExtraNameCharacters() throws SQLException {
      try {
         super.preForAll(methodObject29597, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29597, (Object)this.delegate.getExtraNameCharacters());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29597, this.onErrorForAll(methodObject29597, var2));
      }
   }

   public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29700, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29700, this.delegate.supportsMixedCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29700, this.onErrorForAll(methodObject29700, var2));
      }
   }

   public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29665, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29665, this.delegate.storesLowerCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29665, this.onErrorForAll(methodObject29665, var2));
      }
   }

   public boolean supportsExtendedSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject29689, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29689, this.delegate.supportsExtendedSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29689, this.onErrorForAll(methodObject29689, var2));
      }
   }

   public boolean supportsConvert() throws SQLException {
      try {
         super.preForAll(methodObject29682, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29682, this.delegate.supportsConvert());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29682, this.onErrorForAll(methodObject29682, var2));
      }
   }

   public boolean supportsANSI92FullSQL() throws SQLException {
      try {
         super.preForAll(methodObject29671, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29671, this.delegate.supportsANSI92FullSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29671, this.onErrorForAll(methodObject29671, var2));
      }
   }

   public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
      try {
         super.preForAll(methodObject29725, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29725, this.delegate.supportsStoredFunctionsUsingCallSyntax());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29725, this.onErrorForAll(methodObject29725, var2));
      }
   }

   public int getMaxCursorNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29615, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29615, this.delegate.getMaxCursorNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29615, this.onErrorForAll(methodObject29615, var2));
      }
   }

   public int getJDBCMinorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29604, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29604, this.delegate.getJDBCMinorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29604, this.onErrorForAll(methodObject29604, var2));
      }
   }

   public ResultSet getTablePrivileges(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29643, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29643, this.proxyFactory.proxyForCache((Object)this.delegate.getTablePrivileges(arg0, arg1, arg2), this, this.proxyCache, methodObject29643));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29643, this.onErrorForAll(methodObject29643, var5));
      }
   }

   public boolean supportsNonNullableColumns() throws SQLException {
      try {
         super.preForAll(methodObject29705, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29705, this.delegate.supportsNonNullableColumns());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29705, this.onErrorForAll(methodObject29705, var2));
      }
   }

   public boolean supportsLikeEscapeClause() throws SQLException {
      try {
         super.preForAll(methodObject29696, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29696, this.delegate.supportsLikeEscapeClause());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29696, this.onErrorForAll(methodObject29696, var2));
      }
   }

   public boolean supportsCorrelatedSubqueries() throws SQLException {
      try {
         super.preForAll(methodObject29685, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29685, this.delegate.supportsCorrelatedSubqueries());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29685, this.onErrorForAll(methodObject29685, var2));
      }
   }

   public String getProcedureTerm() throws SQLException {
      try {
         super.preForAll(methodObject29628, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29628, (Object)this.delegate.getProcedureTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29628, this.onErrorForAll(methodObject29628, var2));
      }
   }

   public boolean nullsAreSortedHigh() throws SQLException {
      try {
         super.preForAll(methodObject29656, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29656, this.delegate.nullsAreSortedHigh());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29656, this.onErrorForAll(methodObject29656, var2));
      }
   }

   public boolean supportsSavepoints() throws SQLException {
      try {
         super.preForAll(methodObject29717, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29717, this.delegate.supportsSavepoints());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29717, this.onErrorForAll(methodObject29717, var2));
      }
   }

   public int getMaxCatalogNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29606, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29606, this.delegate.getMaxCatalogNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29606, this.onErrorForAll(methodObject29606, var2));
      }
   }

   public boolean supportsBatchUpdates() throws SQLException {
      try {
         super.preForAll(methodObject29675, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29675, this.delegate.supportsBatchUpdates());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29675, this.onErrorForAll(methodObject29675, var2));
      }
   }

   public boolean supportsExpressionsInOrderBy() throws SQLException {
      try {
         super.preForAll(methodObject29688, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29688, this.delegate.supportsExpressionsInOrderBy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29688, this.onErrorForAll(methodObject29688, var2));
      }
   }

   public ResultSet getFunctionColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29598, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29598, this.proxyFactory.proxyForCache((Object)this.delegate.getFunctionColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29598));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29598, this.onErrorForAll(methodObject29598, var6));
      }
   }

   public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29576, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29576, this.delegate.dataDefinitionIgnoredInTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29576, this.onErrorForAll(methodObject29576, var2));
      }
   }

   public boolean supportsOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject29711, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29711, this.delegate.supportsOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29711, this.onErrorForAll(methodObject29711, var2));
      }
   }

   public boolean nullsAreSortedAtStart() throws SQLException {
      try {
         super.preForAll(methodObject29655, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29655, this.delegate.nullsAreSortedAtStart());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29655, this.onErrorForAll(methodObject29655, var2));
      }
   }

   public boolean supportsUnionAll() throws SQLException {
      try {
         super.preForAll(methodObject29735, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29735, this.delegate.supportsUnionAll());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29735, this.onErrorForAll(methodObject29735, var2));
      }
   }

   public boolean allProceduresAreCallable() throws SQLException {
      try {
         super.preForAll(methodObject29572, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29572, this.delegate.allProceduresAreCallable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29572, this.onErrorForAll(methodObject29572, var2));
      }
   }

   public boolean ownDeletesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29661, this, arg0);
         return (Boolean)this.postForAll(methodObject29661, this.delegate.ownDeletesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29661, this.onErrorForAll(methodObject29661, var3));
      }
   }

   public boolean supportsCatalogsInDataManipulation() throws SQLException {
      try {
         super.preForAll(methodObject29676, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29676, this.delegate.supportsCatalogsInDataManipulation());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29676, this.onErrorForAll(methodObject29676, var2));
      }
   }

   public RowIdLifetime getRowIdLifetime() throws SQLException {
      try {
         super.preForAll(methodObject29632, this, zeroLengthObjectArray);
         return (RowIdLifetime)this.postForAll(methodObject29632, (Object)this.delegate.getRowIdLifetime());
      } catch (SQLException var2) {
         return (RowIdLifetime)this.postForAll(methodObject29632, this.onErrorForAll(methodObject29632, var2));
      }
   }

   public ResultSet getVersionColumns(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29649, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29649, this.proxyFactory.proxyForCache((Object)this.delegate.getVersionColumns(arg0, arg1, arg2), this, this.proxyCache, methodObject29649));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29649, this.onErrorForAll(methodObject29649, var5));
      }
   }

   public ResultSet getExportedKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29596, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29596, this.proxyFactory.proxyForCache((Object)this.delegate.getExportedKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject29596));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29596, this.onErrorForAll(methodObject29596, var5));
      }
   }

   public String getDatabaseProductVersion() throws SQLException {
      try {
         super.preForAll(methodObject29568, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29568, (Object)this.delegate.getDatabaseProductVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29568, this.onErrorForAll(methodObject29568, var2));
      }
   }

   public ResultSet getColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29586, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29586, this.proxyFactory.proxyForCache((Object)this.delegate.getColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29586));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29586, this.onErrorForAll(methodObject29586, var6));
      }
   }

   public int getMaxProcedureNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29617, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29617, this.delegate.getMaxProcedureNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29617, this.onErrorForAll(methodObject29617, var2));
      }
   }

   public boolean insertsAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29650, this, arg0);
         return (Boolean)this.postForAll(methodObject29650, this.delegate.insertsAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29650, this.onErrorForAll(methodObject29650, var3));
      }
   }

   public boolean storesMixedCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29666, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29666, this.delegate.storesMixedCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29666, this.onErrorForAll(methodObject29666, var2));
      }
   }

   public boolean supportsColumnAliasing() throws SQLException {
      try {
         super.preForAll(methodObject29681, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29681, this.delegate.supportsColumnAliasing());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29681, this.onErrorForAll(methodObject29681, var2));
      }
   }

   public boolean supportsAlterTableWithDropColumn() throws SQLException {
      try {
         super.preForAll(methodObject29674, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29674, this.delegate.supportsAlterTableWithDropColumn());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29674, this.onErrorForAll(methodObject29674, var2));
      }
   }

   public boolean generatedKeyAlwaysReturned() throws SQLException {
      try {
         super.preForAll(methodObject29579, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29579, this.delegate.generatedKeyAlwaysReturned());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29579, this.onErrorForAll(methodObject29579, var2));
      }
   }

   public boolean supportsMultipleTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29703, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29703, this.delegate.supportsMultipleTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29703, this.onErrorForAll(methodObject29703, var2));
      }
   }

   public boolean supportsGroupBy() throws SQLException {
      try {
         super.preForAll(methodObject29692, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29692, this.delegate.supportsGroupBy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29692, this.onErrorForAll(methodObject29692, var2));
      }
   }

   public ResultSet getProcedureColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29627, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29627, this.proxyFactory.proxyForCache((Object)this.delegate.getProcedureColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29627));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29627, this.onErrorForAll(methodObject29627, var6));
      }
   }

   public int getMaxColumnsInTable() throws SQLException {
      try {
         super.preForAll(methodObject29613, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29613, this.delegate.getMaxColumnsInTable());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29613, this.onErrorForAll(methodObject29613, var2));
      }
   }

   public int getMaxColumnsInOrderBy() throws SQLException {
      try {
         super.preForAll(methodObject29611, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29611, this.delegate.getMaxColumnsInOrderBy());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29611, this.onErrorForAll(methodObject29611, var2));
      }
   }

   public ResultSet getCrossReference(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws SQLException {
      try {
         super.preForAll(methodObject29587, this, arg0, arg1, arg2, arg3, arg4, arg5);
         return (ResultSet)this.postForAll(methodObject29587, this.proxyFactory.proxyForCache((Object)this.delegate.getCrossReference(arg0, arg1, arg2, arg3, arg4, arg5), this, this.proxyCache, methodObject29587));
      } catch (SQLException var8) {
         return (ResultSet)this.postForAll(methodObject29587, this.onErrorForAll(methodObject29587, var8));
      }
   }

   public int getMaxConnections() throws SQLException {
      try {
         super.preForAll(methodObject29614, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29614, this.delegate.getMaxConnections());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29614, this.onErrorForAll(methodObject29614, var2));
      }
   }

   public boolean allTablesAreSelectable() throws SQLException {
      try {
         super.preForAll(methodObject29573, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29573, this.delegate.allTablesAreSelectable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29573, this.onErrorForAll(methodObject29573, var2));
      }
   }

   public ResultSet getTableTypes() throws SQLException {
      try {
         super.preForAll(methodObject29644, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29644, this.proxyFactory.proxyForCache((Object)this.delegate.getTableTypes(), this, this.proxyCache, methodObject29644));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29644, this.onErrorForAll(methodObject29644, var2));
      }
   }

   public boolean nullPlusNonNullIsNull() throws SQLException {
      try {
         super.preForAll(methodObject29653, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29653, this.delegate.nullPlusNonNullIsNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29653, this.onErrorForAll(methodObject29653, var2));
      }
   }

   public boolean supportsSubqueriesInComparisons() throws SQLException {
      try {
         super.preForAll(methodObject29727, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29727, this.delegate.supportsSubqueriesInComparisons());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29727, this.onErrorForAll(methodObject29727, var2));
      }
   }

   public int getMaxIndexLength() throws SQLException {
      try {
         super.preForAll(methodObject29616, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29616, this.delegate.getMaxIndexLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29616, this.onErrorForAll(methodObject29616, var2));
      }
   }

   public boolean supportsSubqueriesInQuantifieds() throws SQLException {
      try {
         super.preForAll(methodObject29730, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29730, this.delegate.supportsSubqueriesInQuantifieds());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29730, this.onErrorForAll(methodObject29730, var2));
      }
   }

   public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
      try {
         super.preForAll(methodObject29708, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29708, this.delegate.supportsOpenStatementsAcrossCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29708, this.onErrorForAll(methodObject29708, var2));
      }
   }

   public boolean supportsCatalogsInTableDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29680, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29680, this.delegate.supportsCatalogsInTableDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29680, this.onErrorForAll(methodObject29680, var2));
      }
   }

   public boolean ownUpdatesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29663, this, arg0);
         return (Boolean)this.postForAll(methodObject29663, this.delegate.ownUpdatesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29663, this.onErrorForAll(methodObject29663, var3));
      }
   }

   public boolean supportsGroupByBeyondSelect() throws SQLException {
      try {
         super.preForAll(methodObject29693, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29693, this.delegate.supportsGroupByBeyondSelect());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29693, this.onErrorForAll(methodObject29693, var2));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29740, this, arg0);
         return (Boolean)this.postForAll(methodObject29740, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29740, this.onErrorForAll(methodObject29740, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29739, this, arg0);
         return this.postForAll(methodObject29739, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject29739));
      } catch (SQLException var3) {
         return this.postForAll(methodObject29739, this.onErrorForAll(methodObject29739, var3));
      }
   }

   public boolean supportsStatementPooling() throws SQLException {
      try {
         super.preForAll(methodObject29724, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29724, this.delegate.supportsStatementPooling());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29724, this.onErrorForAll(methodObject29724, var2));
      }
   }

   public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29571, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29571, this.delegate.supportsDataDefinitionAndDataManipulationTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29571, this.onErrorForAll(methodObject29571, var2));
      }
   }

   public boolean supportsMultipleOpenResults() throws SQLException {
      try {
         super.preForAll(methodObject29701, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29701, this.delegate.supportsMultipleOpenResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29701, this.onErrorForAll(methodObject29701, var2));
      }
   }

   public int getMaxColumnsInGroupBy() throws SQLException {
      try {
         super.preForAll(methodObject29609, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29609, this.delegate.getMaxColumnsInGroupBy());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29609, this.onErrorForAll(methodObject29609, var2));
      }
   }

   public int getMaxColumnNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29608, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29608, this.delegate.getMaxColumnNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29608, this.onErrorForAll(methodObject29608, var2));
      }
   }

   public ResultSet getAttributes(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29567, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29567, this.proxyFactory.proxyForCache((Object)this.delegate.getAttributes(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29567));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29567, this.onErrorForAll(methodObject29567, var6));
      }
   }

   public int getMaxStatements() throws SQLException {
      try {
         super.preForAll(methodObject29621, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29621, this.delegate.getMaxStatements());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29621, this.onErrorForAll(methodObject29621, var2));
      }
   }

   public boolean supportsAlterTableWithAddColumn() throws SQLException {
      try {
         super.preForAll(methodObject29673, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29673, this.delegate.supportsAlterTableWithAddColumn());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29673, this.onErrorForAll(methodObject29673, var2));
      }
   }

   public boolean supportsGroupByUnrelated() throws SQLException {
      try {
         super.preForAll(methodObject29694, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29694, this.delegate.supportsGroupByUnrelated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29694, this.onErrorForAll(methodObject29694, var2));
      }
   }

   public boolean supportsANSI92EntryLevelSQL() throws SQLException {
      try {
         super.preForAll(methodObject29670, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29670, this.delegate.supportsANSI92EntryLevelSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29670, this.onErrorForAll(methodObject29670, var2));
      }
   }

   public ResultSet getFunctions(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29599, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29599, this.proxyFactory.proxyForCache((Object)this.delegate.getFunctions(arg0, arg1, arg2), this, this.proxyCache, methodObject29599));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29599, this.onErrorForAll(methodObject29599, var5));
      }
   }

   public boolean supportsMinimumSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject29698, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29698, this.delegate.supportsMinimumSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29698, this.onErrorForAll(methodObject29698, var2));
      }
   }

   public int getMaxCharLiteralLength() throws SQLException {
      try {
         super.preForAll(methodObject29607, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29607, this.delegate.getMaxCharLiteralLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29607, this.onErrorForAll(methodObject29607, var2));
      }
   }

   public boolean othersDeletesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29658, this, arg0);
         return (Boolean)this.postForAll(methodObject29658, this.delegate.othersDeletesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29658, this.onErrorForAll(methodObject29658, var3));
      }
   }

   public ResultSet getSuperTables(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29640, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29640, this.proxyFactory.proxyForCache((Object)this.delegate.getSuperTables(arg0, arg1, arg2), this, this.proxyCache, methodObject29640));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29640, this.onErrorForAll(methodObject29640, var5));
      }
   }

   public boolean storesLowerCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29664, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29664, this.delegate.storesLowerCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29664, this.onErrorForAll(methodObject29664, var2));
      }
   }

   public boolean updatesAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29736, this, arg0);
         return (Boolean)this.postForAll(methodObject29736, this.delegate.updatesAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29736, this.onErrorForAll(methodObject29736, var3));
      }
   }

   public boolean supportsMultipleResultSets() throws SQLException {
      try {
         super.preForAll(methodObject29702, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29702, this.delegate.supportsMultipleResultSets());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29702, this.onErrorForAll(methodObject29702, var2));
      }
   }

   public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
      try {
         super.preForAll(methodObject29707, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29707, this.delegate.supportsOpenCursorsAcrossRollback());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29707, this.onErrorForAll(methodObject29707, var2));
      }
   }

   public boolean othersInsertsAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29659, this, arg0);
         return (Boolean)this.postForAll(methodObject29659, this.delegate.othersInsertsAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29659, this.onErrorForAll(methodObject29659, var3));
      }
   }

   public ResultSet getImportedKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29601, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29601, this.proxyFactory.proxyForCache((Object)this.delegate.getImportedKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject29601));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29601, this.onErrorForAll(methodObject29601, var5));
      }
   }

   public boolean supportsSelectForUpdate() throws SQLException {
      try {
         super.preForAll(methodObject29723, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29723, this.delegate.supportsSelectForUpdate());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29723, this.onErrorForAll(methodObject29723, var2));
      }
   }

   public boolean supportsPositionedDelete() throws SQLException {
      try {
         super.preForAll(methodObject29712, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29712, this.delegate.supportsPositionedDelete());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29712, this.onErrorForAll(methodObject29712, var2));
      }
   }

   public boolean supportsCatalogsInProcedureCalls() throws SQLException {
      try {
         super.preForAll(methodObject29679, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29679, this.delegate.supportsCatalogsInProcedureCalls());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29679, this.onErrorForAll(methodObject29679, var2));
      }
   }

   public String getCatalogSeparator() throws SQLException {
      try {
         super.preForAll(methodObject29581, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29581, (Object)this.delegate.getCatalogSeparator());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29581, this.onErrorForAll(methodObject29581, var2));
      }
   }

   public DatabaseMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (DatabaseMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29603 = DatabaseMetaData.class.getDeclaredMethod("getJDBCMajorVersion");
         methodObject29706 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenCursorsAcrossCommit");
         methodObject29677 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInIndexDefinitions");
         methodObject29662 = DatabaseMetaData.class.getDeclaredMethod("ownInsertsAreVisible", Integer.TYPE);
         methodObject29593 = DatabaseMetaData.class.getDeclaredMethod("getDriverMinorVersion");
         methodObject29582 = DatabaseMetaData.class.getDeclaredMethod("getCatalogTerm");
         methodObject29697 = DatabaseMetaData.class.getDeclaredMethod("supportsLimitedOuterJoins");
         methodObject29636 = DatabaseMetaData.class.getDeclaredMethod("getSchemas");
         methodObject29600 = DatabaseMetaData.class.getDeclaredMethod("getIdentifierQuoteString");
         methodObject29686 = DatabaseMetaData.class.getDeclaredMethod("supportsDataManipulationTransactionsOnly");
         methodObject29638 = DatabaseMetaData.class.getDeclaredMethod("getSearchStringEscape");
         methodObject29648 = DatabaseMetaData.class.getDeclaredMethod("getUDTs", String.class, String.class, String.class, int[].class);
         methodObject29720 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInPrivilegeDefinitions");
         methodObject29619 = DatabaseMetaData.class.getDeclaredMethod("getMaxSchemaNameLength");
         methodObject29690 = DatabaseMetaData.class.getDeclaredMethod("supportsFullOuterJoins");
         methodObject29580 = DatabaseMetaData.class.getDeclaredMethod("getBestRowIdentifier", String.class, String.class, String.class, Integer.TYPE, Boolean.TYPE);
         methodObject29652 = DatabaseMetaData.class.getDeclaredMethod("locatorsUpdateCopy");
         methodObject29642 = DatabaseMetaData.class.getDeclaredMethod("getSystemFunctions");
         methodObject29737 = DatabaseMetaData.class.getDeclaredMethod("usesLocalFilePerTable");
         methodObject29714 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetConcurrency", Integer.TYPE, Integer.TYPE);
         methodObject29633 = DatabaseMetaData.class.getDeclaredMethod("getSQLKeywords");
         methodObject29570 = DatabaseMetaData.class.getDeclaredMethod("getUserName");
         methodObject29624 = DatabaseMetaData.class.getDeclaredMethod("getMaxUserNameLength");
         methodObject29629 = DatabaseMetaData.class.getDeclaredMethod("getProcedures", String.class, String.class, String.class);
         methodObject29595 = DatabaseMetaData.class.getDeclaredMethod("getDriverVersion");
         methodObject29610 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInIndex");
         methodObject29635 = DatabaseMetaData.class.getDeclaredMethod("getSchemaTerm");
         methodObject29729 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInIns");
         methodObject29721 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInProcedureCalls");
         methodObject29709 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenStatementsAcrossRollback");
         methodObject29594 = DatabaseMetaData.class.getDeclaredMethod("getDriverName");
         methodObject29574 = DatabaseMetaData.class.getDeclaredMethod("autoCommitFailureClosesAllResultSets");
         methodObject29584 = DatabaseMetaData.class.getDeclaredMethod("getClientInfoProperties");
         methodObject29590 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseProductName");
         methodObject29731 = DatabaseMetaData.class.getDeclaredMethod("supportsTableCorrelationNames");
         methodObject29732 = DatabaseMetaData.class.getDeclaredMethod("supportsTransactionIsolationLevel", Integer.TYPE);
         methodObject29588 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseMajorVersion");
         methodObject29612 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInSelect");
         methodObject29641 = DatabaseMetaData.class.getDeclaredMethod("getSuperTypes", String.class, String.class, String.class);
         methodObject29726 = DatabaseMetaData.class.getDeclaredMethod("supportsStoredProcedures");
         methodObject29585 = DatabaseMetaData.class.getDeclaredMethod("getColumnPrivileges", String.class, String.class, String.class, String.class);
         methodObject29719 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInIndexDefinitions");
         methodObject29591 = DatabaseMetaData.class.getDeclaredMethod("getDefaultTransactionIsolation");
         methodObject29639 = DatabaseMetaData.class.getDeclaredMethod("getStringFunctions");
         methodObject29578 = DatabaseMetaData.class.getDeclaredMethod("doesMaxRowSizeIncludeBlobs");
         methodObject29722 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInTableDefinitions");
         methodObject29630 = DatabaseMetaData.class.getDeclaredMethod("getPseudoColumns", String.class, String.class, String.class, String.class);
         methodObject29695 = DatabaseMetaData.class.getDeclaredMethod("supportsIntegrityEnhancementFacility");
         methodObject29575 = DatabaseMetaData.class.getDeclaredMethod("dataDefinitionCausesTransactionCommit");
         methodObject29654 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedAtEnd");
         methodObject29583 = DatabaseMetaData.class.getDeclaredMethod("getCatalogs");
         methodObject29592 = DatabaseMetaData.class.getDeclaredMethod("getDriverMajorVersion");
         methodObject29678 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInPrivilegeDefinitions");
         methodObject29651 = DatabaseMetaData.class.getDeclaredMethod("isCatalogAtStart");
         methodObject29605 = DatabaseMetaData.class.getDeclaredMethod("getMaxBinaryLiteralLength");
         methodObject29631 = DatabaseMetaData.class.getDeclaredMethod("getResultSetHoldability");
         methodObject29668 = DatabaseMetaData.class.getDeclaredMethod("storesUpperCaseIdentifiers");
         methodObject29566 = DatabaseMetaData.class.getDeclaredMethod("isReadOnly");
         methodObject29715 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetHoldability", Integer.TYPE);
         methodObject29687 = DatabaseMetaData.class.getDeclaredMethod("supportsDifferentTableCorrelationNames");
         methodObject29691 = DatabaseMetaData.class.getDeclaredMethod("supportsGetGeneratedKeys");
         methodObject29622 = DatabaseMetaData.class.getDeclaredMethod("getMaxTableNameLength");
         methodObject29637 = DatabaseMetaData.class.getDeclaredMethod("getSchemas", String.class, String.class);
         methodObject29647 = DatabaseMetaData.class.getDeclaredMethod("getTypeInfo");
         methodObject29623 = DatabaseMetaData.class.getDeclaredMethod("getMaxTablesInSelect");
         methodObject29734 = DatabaseMetaData.class.getDeclaredMethod("supportsUnion");
         methodObject29728 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInExists");
         methodObject29716 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetType", Integer.TYPE);
         methodObject29710 = DatabaseMetaData.class.getDeclaredMethod("supportsOrderByUnrelated");
         methodObject29738 = DatabaseMetaData.class.getDeclaredMethod("usesLocalFiles");
         methodObject29672 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92IntermediateSQL");
         methodObject29625 = DatabaseMetaData.class.getDeclaredMethod("getNumericFunctions");
         methodObject29683 = DatabaseMetaData.class.getDeclaredMethod("supportsConvert", Integer.TYPE, Integer.TYPE);
         methodObject29634 = DatabaseMetaData.class.getDeclaredMethod("getSQLStateType");
         methodObject29620 = DatabaseMetaData.class.getDeclaredMethod("getMaxStatementLength");
         methodObject29577 = DatabaseMetaData.class.getDeclaredMethod("deletesAreDetected", Integer.TYPE);
         methodObject29646 = DatabaseMetaData.class.getDeclaredMethod("getTimeDateFunctions");
         methodObject29718 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInDataManipulation");
         methodObject29713 = DatabaseMetaData.class.getDeclaredMethod("supportsPositionedUpdate");
         methodObject29667 = DatabaseMetaData.class.getDeclaredMethod("storesMixedCaseQuotedIdentifiers");
         methodObject29699 = DatabaseMetaData.class.getDeclaredMethod("supportsMixedCaseIdentifiers");
         methodObject29669 = DatabaseMetaData.class.getDeclaredMethod("storesUpperCaseQuotedIdentifiers");
         methodObject29626 = DatabaseMetaData.class.getDeclaredMethod("getPrimaryKeys", String.class, String.class, String.class);
         methodObject29684 = DatabaseMetaData.class.getDeclaredMethod("supportsCoreSQLGrammar");
         methodObject29589 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseMinorVersion");
         methodObject29618 = DatabaseMetaData.class.getDeclaredMethod("getMaxRowSize");
         methodObject29657 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedLow");
         methodObject29704 = DatabaseMetaData.class.getDeclaredMethod("supportsNamedParameters");
         methodObject29660 = DatabaseMetaData.class.getDeclaredMethod("othersUpdatesAreVisible", Integer.TYPE);
         methodObject29602 = DatabaseMetaData.class.getDeclaredMethod("getIndexInfo", String.class, String.class, String.class, Boolean.TYPE, Boolean.TYPE);
         methodObject29565 = DatabaseMetaData.class.getDeclaredMethod("getURL");
         methodObject29645 = DatabaseMetaData.class.getDeclaredMethod("getTables", String.class, String.class, String.class, String[].class);
         methodObject29733 = DatabaseMetaData.class.getDeclaredMethod("supportsTransactions");
         methodObject29569 = DatabaseMetaData.class.getDeclaredMethod("getConnection");
         methodObject29597 = DatabaseMetaData.class.getDeclaredMethod("getExtraNameCharacters");
         methodObject29700 = DatabaseMetaData.class.getDeclaredMethod("supportsMixedCaseQuotedIdentifiers");
         methodObject29665 = DatabaseMetaData.class.getDeclaredMethod("storesLowerCaseQuotedIdentifiers");
         methodObject29689 = DatabaseMetaData.class.getDeclaredMethod("supportsExtendedSQLGrammar");
         methodObject29682 = DatabaseMetaData.class.getDeclaredMethod("supportsConvert");
         methodObject29671 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92FullSQL");
         methodObject29725 = DatabaseMetaData.class.getDeclaredMethod("supportsStoredFunctionsUsingCallSyntax");
         methodObject29615 = DatabaseMetaData.class.getDeclaredMethod("getMaxCursorNameLength");
         methodObject29604 = DatabaseMetaData.class.getDeclaredMethod("getJDBCMinorVersion");
         methodObject29643 = DatabaseMetaData.class.getDeclaredMethod("getTablePrivileges", String.class, String.class, String.class);
         methodObject29705 = DatabaseMetaData.class.getDeclaredMethod("supportsNonNullableColumns");
         methodObject29696 = DatabaseMetaData.class.getDeclaredMethod("supportsLikeEscapeClause");
         methodObject29685 = DatabaseMetaData.class.getDeclaredMethod("supportsCorrelatedSubqueries");
         methodObject29628 = DatabaseMetaData.class.getDeclaredMethod("getProcedureTerm");
         methodObject29656 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedHigh");
         methodObject29717 = DatabaseMetaData.class.getDeclaredMethod("supportsSavepoints");
         methodObject29606 = DatabaseMetaData.class.getDeclaredMethod("getMaxCatalogNameLength");
         methodObject29675 = DatabaseMetaData.class.getDeclaredMethod("supportsBatchUpdates");
         methodObject29688 = DatabaseMetaData.class.getDeclaredMethod("supportsExpressionsInOrderBy");
         methodObject29598 = DatabaseMetaData.class.getDeclaredMethod("getFunctionColumns", String.class, String.class, String.class, String.class);
         methodObject29576 = DatabaseMetaData.class.getDeclaredMethod("dataDefinitionIgnoredInTransactions");
         methodObject29711 = DatabaseMetaData.class.getDeclaredMethod("supportsOuterJoins");
         methodObject29655 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedAtStart");
         methodObject29735 = DatabaseMetaData.class.getDeclaredMethod("supportsUnionAll");
         methodObject29572 = DatabaseMetaData.class.getDeclaredMethod("allProceduresAreCallable");
         methodObject29661 = DatabaseMetaData.class.getDeclaredMethod("ownDeletesAreVisible", Integer.TYPE);
         methodObject29676 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInDataManipulation");
         methodObject29632 = DatabaseMetaData.class.getDeclaredMethod("getRowIdLifetime");
         methodObject29649 = DatabaseMetaData.class.getDeclaredMethod("getVersionColumns", String.class, String.class, String.class);
         methodObject29596 = DatabaseMetaData.class.getDeclaredMethod("getExportedKeys", String.class, String.class, String.class);
         methodObject29568 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseProductVersion");
         methodObject29586 = DatabaseMetaData.class.getDeclaredMethod("getColumns", String.class, String.class, String.class, String.class);
         methodObject29617 = DatabaseMetaData.class.getDeclaredMethod("getMaxProcedureNameLength");
         methodObject29650 = DatabaseMetaData.class.getDeclaredMethod("insertsAreDetected", Integer.TYPE);
         methodObject29666 = DatabaseMetaData.class.getDeclaredMethod("storesMixedCaseIdentifiers");
         methodObject29681 = DatabaseMetaData.class.getDeclaredMethod("supportsColumnAliasing");
         methodObject29674 = DatabaseMetaData.class.getDeclaredMethod("supportsAlterTableWithDropColumn");
         methodObject29579 = DatabaseMetaData.class.getDeclaredMethod("generatedKeyAlwaysReturned");
         methodObject29703 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleTransactions");
         methodObject29692 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupBy");
         methodObject29627 = DatabaseMetaData.class.getDeclaredMethod("getProcedureColumns", String.class, String.class, String.class, String.class);
         methodObject29613 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInTable");
         methodObject29611 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInOrderBy");
         methodObject29587 = DatabaseMetaData.class.getDeclaredMethod("getCrossReference", String.class, String.class, String.class, String.class, String.class, String.class);
         methodObject29614 = DatabaseMetaData.class.getDeclaredMethod("getMaxConnections");
         methodObject29573 = DatabaseMetaData.class.getDeclaredMethod("allTablesAreSelectable");
         methodObject29644 = DatabaseMetaData.class.getDeclaredMethod("getTableTypes");
         methodObject29653 = DatabaseMetaData.class.getDeclaredMethod("nullPlusNonNullIsNull");
         methodObject29727 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInComparisons");
         methodObject29616 = DatabaseMetaData.class.getDeclaredMethod("getMaxIndexLength");
         methodObject29730 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInQuantifieds");
         methodObject29708 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenStatementsAcrossCommit");
         methodObject29680 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInTableDefinitions");
         methodObject29663 = DatabaseMetaData.class.getDeclaredMethod("ownUpdatesAreVisible", Integer.TYPE);
         methodObject29693 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupByBeyondSelect");
         methodObject29740 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject29739 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject29724 = DatabaseMetaData.class.getDeclaredMethod("supportsStatementPooling");
         methodObject29571 = DatabaseMetaData.class.getDeclaredMethod("supportsDataDefinitionAndDataManipulationTransactions");
         methodObject29701 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleOpenResults");
         methodObject29609 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInGroupBy");
         methodObject29608 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnNameLength");
         methodObject29567 = DatabaseMetaData.class.getDeclaredMethod("getAttributes", String.class, String.class, String.class, String.class);
         methodObject29621 = DatabaseMetaData.class.getDeclaredMethod("getMaxStatements");
         methodObject29673 = DatabaseMetaData.class.getDeclaredMethod("supportsAlterTableWithAddColumn");
         methodObject29694 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupByUnrelated");
         methodObject29670 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92EntryLevelSQL");
         methodObject29599 = DatabaseMetaData.class.getDeclaredMethod("getFunctions", String.class, String.class, String.class);
         methodObject29698 = DatabaseMetaData.class.getDeclaredMethod("supportsMinimumSQLGrammar");
         methodObject29607 = DatabaseMetaData.class.getDeclaredMethod("getMaxCharLiteralLength");
         methodObject29658 = DatabaseMetaData.class.getDeclaredMethod("othersDeletesAreVisible", Integer.TYPE);
         methodObject29640 = DatabaseMetaData.class.getDeclaredMethod("getSuperTables", String.class, String.class, String.class);
         methodObject29664 = DatabaseMetaData.class.getDeclaredMethod("storesLowerCaseIdentifiers");
         methodObject29736 = DatabaseMetaData.class.getDeclaredMethod("updatesAreDetected", Integer.TYPE);
         methodObject29702 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleResultSets");
         methodObject29707 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenCursorsAcrossRollback");
         methodObject29659 = DatabaseMetaData.class.getDeclaredMethod("othersInsertsAreVisible", Integer.TYPE);
         methodObject29601 = DatabaseMetaData.class.getDeclaredMethod("getImportedKeys", String.class, String.class, String.class);
         methodObject29723 = DatabaseMetaData.class.getDeclaredMethod("supportsSelectForUpdate");
         methodObject29712 = DatabaseMetaData.class.getDeclaredMethod("supportsPositionedDelete");
         methodObject29679 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInProcedureCalls");
         methodObject29581 = DatabaseMetaData.class.getDeclaredMethod("getCatalogSeparator");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1DatabaseMetaData$$$Proxy(DatabaseMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
