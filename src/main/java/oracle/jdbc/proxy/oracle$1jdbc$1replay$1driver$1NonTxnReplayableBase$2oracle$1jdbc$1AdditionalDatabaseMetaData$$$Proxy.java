package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.AdditionalDatabaseMetaData;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1AdditionalDatabaseMetaData$$$Proxy extends NonTxnReplayableBase implements AdditionalDatabaseMetaData, _Proxy_ {
   private AdditionalDatabaseMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29855;
   private static Method methodObject29958;
   private static Method methodObject29929;
   private static Method methodObject29914;
   private static Method methodObject29845;
   private static Method methodObject29834;
   private static Method methodObject29949;
   private static Method methodObject29888;
   private static Method methodObject29852;
   private static Method methodObject29938;
   private static Method methodObject29890;
   private static Method methodObject29900;
   private static Method methodObject29972;
   private static Method methodObject29871;
   private static Method methodObject29942;
   private static Method methodObject29832;
   private static Method methodObject29904;
   private static Method methodObject29894;
   private static Method methodObject29989;
   private static Method methodObject29966;
   private static Method methodObject29885;
   private static Method methodObject29822;
   private static Method methodObject29876;
   private static Method methodObject29881;
   private static Method methodObject29847;
   private static Method methodObject29862;
   private static Method methodObject29887;
   private static Method methodObject29981;
   private static Method methodObject29973;
   private static Method methodObject29961;
   private static Method methodObject29846;
   private static Method methodObject29826;
   private static Method methodObject29836;
   private static Method methodObject29842;
   private static Method methodObject29983;
   private static Method methodObject29984;
   private static Method methodObject29840;
   private static Method methodObject29864;
   private static Method methodObject29893;
   private static Method methodObject29978;
   private static Method methodObject29815;
   private static Method methodObject29837;
   private static Method methodObject29971;
   private static Method methodObject29843;
   private static Method methodObject29891;
   private static Method methodObject29830;
   private static Method methodObject29974;
   private static Method methodObject29882;
   private static Method methodObject29947;
   private static Method methodObject29827;
   private static Method methodObject29906;
   private static Method methodObject29835;
   private static Method methodObject29844;
   private static Method methodObject29930;
   private static Method methodObject29903;
   private static Method methodObject29857;
   private static Method methodObject29883;
   private static Method methodObject29920;
   private static Method methodObject29818;
   private static Method methodObject29967;
   private static Method methodObject29939;
   private static Method methodObject29943;
   private static Method methodObject29874;
   private static Method methodObject29889;
   private static Method methodObject29899;
   private static Method methodObject29875;
   private static Method methodObject29986;
   private static Method methodObject29980;
   private static Method methodObject29968;
   private static Method methodObject29962;
   private static Method methodObject29990;
   private static Method methodObject29924;
   private static Method methodObject29877;
   private static Method methodObject29935;
   private static Method methodObject29886;
   private static Method methodObject29872;
   private static Method methodObject29829;
   private static Method methodObject29898;
   private static Method methodObject29970;
   private static Method methodObject29965;
   private static Method methodObject29919;
   private static Method methodObject29951;
   private static Method methodObject29921;
   private static Method methodObject29878;
   private static Method methodObject29936;
   private static Method methodObject29841;
   private static Method methodObject29870;
   private static Method methodObject29909;
   private static Method methodObject29956;
   private static Method methodObject29912;
   private static Method methodObject29854;
   private static Method methodObject29817;
   private static Method methodObject29897;
   private static Method methodObject29985;
   private static Method methodObject29821;
   private static Method methodObject29849;
   private static Method methodObject29952;
   private static Method methodObject29917;
   private static Method methodObject29941;
   private static Method methodObject29934;
   private static Method methodObject29923;
   private static Method methodObject29977;
   private static Method methodObject29867;
   private static Method methodObject29856;
   private static Method methodObject29895;
   private static Method methodObject29957;
   private static Method methodObject29948;
   private static Method methodObject29937;
   private static Method methodObject29880;
   private static Method methodObject29908;
   private static Method methodObject29969;
   private static Method methodObject29858;
   private static Method methodObject29927;
   private static Method methodObject29940;
   private static Method methodObject29850;
   private static Method methodObject29828;
   private static Method methodObject29963;
   private static Method methodObject29907;
   private static Method methodObject29987;
   private static Method methodObject29824;
   private static Method methodObject29816;
   private static Method methodObject29913;
   private static Method methodObject29928;
   private static Method methodObject29884;
   private static Method methodObject29901;
   private static Method methodObject29848;
   private static Method methodObject29820;
   private static Method methodObject29838;
   private static Method methodObject29869;
   private static Method methodObject29902;
   private static Method methodObject29918;
   private static Method methodObject29933;
   private static Method methodObject29926;
   private static Method methodObject29831;
   private static Method methodObject29955;
   private static Method methodObject29944;
   private static Method methodObject29879;
   private static Method methodObject29865;
   private static Method methodObject29863;
   private static Method methodObject29839;
   private static Method methodObject29866;
   private static Method methodObject29825;
   private static Method methodObject29896;
   private static Method methodObject29905;
   private static Method methodObject29979;
   private static Method methodObject29868;
   private static Method methodObject29982;
   private static Method methodObject29960;
   private static Method methodObject29932;
   private static Method methodObject29915;
   private static Method methodObject29945;
   private static Method methodObject29992;
   private static Method methodObject29991;
   private static Method methodObject29976;
   private static Method methodObject29823;
   private static Method methodObject29953;
   private static Method methodObject29861;
   private static Method methodObject29860;
   private static Method methodObject29819;
   private static Method methodObject29873;
   private static Method methodObject29925;
   private static Method methodObject29946;
   private static Method methodObject29922;
   private static Method methodObject29851;
   private static Method methodObject29950;
   private static Method methodObject29859;
   private static Method methodObject29910;
   private static Method methodObject29892;
   private static Method methodObject29916;
   private static Method methodObject29988;
   private static Method methodObject29954;
   private static Method methodObject29959;
   private static Method methodObject29911;
   private static Method methodObject29853;
   private static Method methodObject29975;
   private static Method methodObject29964;
   private static Method methodObject29931;
   private static Method methodObject29833;

   public int getJDBCMajorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29855, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29855, this.delegate.getJDBCMajorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29855, this.onErrorForAll(methodObject29855, var2));
      }
   }

   public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
      try {
         super.preForAll(methodObject29958, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29958, this.delegate.supportsOpenCursorsAcrossCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29958, this.onErrorForAll(methodObject29958, var2));
      }
   }

   public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29929, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29929, this.delegate.supportsCatalogsInIndexDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29929, this.onErrorForAll(methodObject29929, var2));
      }
   }

   public boolean ownInsertsAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29914, this, arg0);
         return (Boolean)this.postForAll(methodObject29914, this.delegate.ownInsertsAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29914, this.onErrorForAll(methodObject29914, var3));
      }
   }

   public int getDriverMinorVersion() {
      super.preForAll(methodObject29845, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject29845, this.delegate.getDriverMinorVersion());
   }

   public String getCatalogTerm() throws SQLException {
      try {
         super.preForAll(methodObject29834, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29834, (Object)this.delegate.getCatalogTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29834, this.onErrorForAll(methodObject29834, var2));
      }
   }

   public boolean supportsLimitedOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject29949, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29949, this.delegate.supportsLimitedOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29949, this.onErrorForAll(methodObject29949, var2));
      }
   }

   public ResultSet getSchemas() throws SQLException {
      try {
         super.preForAll(methodObject29888, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29888, this.proxyFactory.proxyForCache((Object)this.delegate.getSchemas(), this, this.proxyCache, methodObject29888));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29888, this.onErrorForAll(methodObject29888, var2));
      }
   }

   public String getIdentifierQuoteString() throws SQLException {
      try {
         super.preForAll(methodObject29852, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29852, (Object)this.delegate.getIdentifierQuoteString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29852, this.onErrorForAll(methodObject29852, var2));
      }
   }

   public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
      try {
         super.preForAll(methodObject29938, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29938, this.delegate.supportsDataManipulationTransactionsOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29938, this.onErrorForAll(methodObject29938, var2));
      }
   }

   public String getSearchStringEscape() throws SQLException {
      try {
         super.preForAll(methodObject29890, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29890, (Object)this.delegate.getSearchStringEscape());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29890, this.onErrorForAll(methodObject29890, var2));
      }
   }

   public ResultSet getUDTs(String arg0, String arg1, String arg2, int[] arg3) throws SQLException {
      try {
         super.preForAll(methodObject29900, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29900, this.proxyFactory.proxyForCache((Object)this.delegate.getUDTs(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29900));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29900, this.onErrorForAll(methodObject29900, var6));
      }
   }

   public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29972, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29972, this.delegate.supportsSchemasInPrivilegeDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29972, this.onErrorForAll(methodObject29972, var2));
      }
   }

   public int getMaxSchemaNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29871, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29871, this.delegate.getMaxSchemaNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29871, this.onErrorForAll(methodObject29871, var2));
      }
   }

   public boolean supportsFullOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject29942, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29942, this.delegate.supportsFullOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29942, this.onErrorForAll(methodObject29942, var2));
      }
   }

   public ResultSet getBestRowIdentifier(String arg0, String arg1, String arg2, int arg3, boolean arg4) throws SQLException {
      try {
         super.preForAll(methodObject29832, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject29832, this.proxyFactory.proxyForCache((Object)this.delegate.getBestRowIdentifier(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject29832));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject29832, this.onErrorForAll(methodObject29832, var7));
      }
   }

   public boolean locatorsUpdateCopy() throws SQLException {
      try {
         super.preForAll(methodObject29904, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29904, this.delegate.locatorsUpdateCopy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29904, this.onErrorForAll(methodObject29904, var2));
      }
   }

   public String getSystemFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29894, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29894, (Object)this.delegate.getSystemFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29894, this.onErrorForAll(methodObject29894, var2));
      }
   }

   public boolean usesLocalFilePerTable() throws SQLException {
      try {
         super.preForAll(methodObject29989, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29989, this.delegate.usesLocalFilePerTable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29989, this.onErrorForAll(methodObject29989, var2));
      }
   }

   public boolean supportsResultSetConcurrency(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject29966, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject29966, this.delegate.supportsResultSetConcurrency(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject29966, this.onErrorForAll(methodObject29966, var4));
      }
   }

   public String getSQLKeywords() throws SQLException {
      try {
         super.preForAll(methodObject29885, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29885, (Object)this.delegate.getSQLKeywords());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29885, this.onErrorForAll(methodObject29885, var2));
      }
   }

   public String getUserName() throws SQLException {
      try {
         super.preForAll(methodObject29822, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29822, (Object)this.delegate.getUserName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29822, this.onErrorForAll(methodObject29822, var2));
      }
   }

   public int getMaxUserNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29876, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29876, this.delegate.getMaxUserNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29876, this.onErrorForAll(methodObject29876, var2));
      }
   }

   public ResultSet getProcedures(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29881, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29881, this.proxyFactory.proxyForCache((Object)this.delegate.getProcedures(arg0, arg1, arg2), this, this.proxyCache, methodObject29881));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29881, this.onErrorForAll(methodObject29881, var5));
      }
   }

   public String getDriverVersion() throws SQLException {
      try {
         super.preForAll(methodObject29847, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29847, (Object)this.delegate.getDriverVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29847, this.onErrorForAll(methodObject29847, var2));
      }
   }

   public int getMaxColumnsInIndex() throws SQLException {
      try {
         super.preForAll(methodObject29862, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29862, this.delegate.getMaxColumnsInIndex());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29862, this.onErrorForAll(methodObject29862, var2));
      }
   }

   public String getSchemaTerm() throws SQLException {
      try {
         super.preForAll(methodObject29887, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29887, (Object)this.delegate.getSchemaTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29887, this.onErrorForAll(methodObject29887, var2));
      }
   }

   public boolean supportsSubqueriesInIns() throws SQLException {
      try {
         super.preForAll(methodObject29981, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29981, this.delegate.supportsSubqueriesInIns());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29981, this.onErrorForAll(methodObject29981, var2));
      }
   }

   public boolean supportsSchemasInProcedureCalls() throws SQLException {
      try {
         super.preForAll(methodObject29973, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29973, this.delegate.supportsSchemasInProcedureCalls());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29973, this.onErrorForAll(methodObject29973, var2));
      }
   }

   public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
      try {
         super.preForAll(methodObject29961, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29961, this.delegate.supportsOpenStatementsAcrossRollback());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29961, this.onErrorForAll(methodObject29961, var2));
      }
   }

   public String getDriverName() throws SQLException {
      try {
         super.preForAll(methodObject29846, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29846, (Object)this.delegate.getDriverName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29846, this.onErrorForAll(methodObject29846, var2));
      }
   }

   public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
      try {
         super.preForAll(methodObject29826, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29826, this.delegate.autoCommitFailureClosesAllResultSets());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29826, this.onErrorForAll(methodObject29826, var2));
      }
   }

   public ResultSet getClientInfoProperties() throws SQLException {
      try {
         super.preForAll(methodObject29836, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29836, this.proxyFactory.proxyForCache((Object)this.delegate.getClientInfoProperties(), this, this.proxyCache, methodObject29836));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29836, this.onErrorForAll(methodObject29836, var2));
      }
   }

   public String getDatabaseProductName() throws SQLException {
      try {
         super.preForAll(methodObject29842, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29842, (Object)this.delegate.getDatabaseProductName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29842, this.onErrorForAll(methodObject29842, var2));
      }
   }

   public boolean supportsTableCorrelationNames() throws SQLException {
      try {
         super.preForAll(methodObject29983, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29983, this.delegate.supportsTableCorrelationNames());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29983, this.onErrorForAll(methodObject29983, var2));
      }
   }

   public boolean supportsTransactionIsolationLevel(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29984, this, arg0);
         return (Boolean)this.postForAll(methodObject29984, this.delegate.supportsTransactionIsolationLevel(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29984, this.onErrorForAll(methodObject29984, var3));
      }
   }

   public int getDatabaseMajorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29840, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29840, this.delegate.getDatabaseMajorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29840, this.onErrorForAll(methodObject29840, var2));
      }
   }

   public int getMaxColumnsInSelect() throws SQLException {
      try {
         super.preForAll(methodObject29864, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29864, this.delegate.getMaxColumnsInSelect());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29864, this.onErrorForAll(methodObject29864, var2));
      }
   }

   public ResultSet getSuperTypes(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29893, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29893, this.proxyFactory.proxyForCache((Object)this.delegate.getSuperTypes(arg0, arg1, arg2), this, this.proxyCache, methodObject29893));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29893, this.onErrorForAll(methodObject29893, var5));
      }
   }

   public boolean supportsStoredProcedures() throws SQLException {
      try {
         super.preForAll(methodObject29978, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29978, this.delegate.supportsStoredProcedures());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29978, this.onErrorForAll(methodObject29978, var2));
      }
   }

   public OracleTypeMetaData getOracleTypeMetaData(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject29815, this, arg0);
         return (OracleTypeMetaData)this.postForAll(methodObject29815, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleTypeMetaData(arg0), this, this.proxyCache, methodObject29815));
      } catch (SQLException var3) {
         return (OracleTypeMetaData)this.postForAll(methodObject29815, this.onErrorForAll(methodObject29815, var3));
      }
   }

   public ResultSet getColumnPrivileges(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29837, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29837, this.proxyFactory.proxyForCache((Object)this.delegate.getColumnPrivileges(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29837));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29837, this.onErrorForAll(methodObject29837, var6));
      }
   }

   public boolean supportsSchemasInIndexDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29971, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29971, this.delegate.supportsSchemasInIndexDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29971, this.onErrorForAll(methodObject29971, var2));
      }
   }

   public int getDefaultTransactionIsolation() throws SQLException {
      try {
         super.preForAll(methodObject29843, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29843, this.delegate.getDefaultTransactionIsolation());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29843, this.onErrorForAll(methodObject29843, var2));
      }
   }

   public String getStringFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29891, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29891, (Object)this.delegate.getStringFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29891, this.onErrorForAll(methodObject29891, var2));
      }
   }

   public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
      try {
         super.preForAll(methodObject29830, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29830, this.delegate.doesMaxRowSizeIncludeBlobs());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29830, this.onErrorForAll(methodObject29830, var2));
      }
   }

   public boolean supportsSchemasInTableDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29974, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29974, this.delegate.supportsSchemasInTableDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29974, this.onErrorForAll(methodObject29974, var2));
      }
   }

   public ResultSet getPseudoColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29882, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29882, this.proxyFactory.proxyForCache((Object)this.delegate.getPseudoColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29882));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29882, this.onErrorForAll(methodObject29882, var6));
      }
   }

   public boolean supportsIntegrityEnhancementFacility() throws SQLException {
      try {
         super.preForAll(methodObject29947, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29947, this.delegate.supportsIntegrityEnhancementFacility());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29947, this.onErrorForAll(methodObject29947, var2));
      }
   }

   public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
      try {
         super.preForAll(methodObject29827, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29827, this.delegate.dataDefinitionCausesTransactionCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29827, this.onErrorForAll(methodObject29827, var2));
      }
   }

   public boolean nullsAreSortedAtEnd() throws SQLException {
      try {
         super.preForAll(methodObject29906, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29906, this.delegate.nullsAreSortedAtEnd());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29906, this.onErrorForAll(methodObject29906, var2));
      }
   }

   public ResultSet getCatalogs() throws SQLException {
      try {
         super.preForAll(methodObject29835, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29835, this.proxyFactory.proxyForCache((Object)this.delegate.getCatalogs(), this, this.proxyCache, methodObject29835));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29835, this.onErrorForAll(methodObject29835, var2));
      }
   }

   public int getDriverMajorVersion() {
      super.preForAll(methodObject29844, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject29844, this.delegate.getDriverMajorVersion());
   }

   public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29930, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29930, this.delegate.supportsCatalogsInPrivilegeDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29930, this.onErrorForAll(methodObject29930, var2));
      }
   }

   public boolean isCatalogAtStart() throws SQLException {
      try {
         super.preForAll(methodObject29903, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29903, this.delegate.isCatalogAtStart());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29903, this.onErrorForAll(methodObject29903, var2));
      }
   }

   public int getMaxBinaryLiteralLength() throws SQLException {
      try {
         super.preForAll(methodObject29857, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29857, this.delegate.getMaxBinaryLiteralLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29857, this.onErrorForAll(methodObject29857, var2));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject29883, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29883, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29883, this.onErrorForAll(methodObject29883, var2));
      }
   }

   public boolean storesUpperCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29920, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29920, this.delegate.storesUpperCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29920, this.onErrorForAll(methodObject29920, var2));
      }
   }

   public boolean isReadOnly() throws SQLException {
      try {
         super.preForAll(methodObject29818, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29818, this.delegate.isReadOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29818, this.onErrorForAll(methodObject29818, var2));
      }
   }

   public boolean supportsResultSetHoldability(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29967, this, arg0);
         return (Boolean)this.postForAll(methodObject29967, this.delegate.supportsResultSetHoldability(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29967, this.onErrorForAll(methodObject29967, var3));
      }
   }

   public boolean supportsDifferentTableCorrelationNames() throws SQLException {
      try {
         super.preForAll(methodObject29939, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29939, this.delegate.supportsDifferentTableCorrelationNames());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29939, this.onErrorForAll(methodObject29939, var2));
      }
   }

   public boolean supportsGetGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject29943, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29943, this.delegate.supportsGetGeneratedKeys());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29943, this.onErrorForAll(methodObject29943, var2));
      }
   }

   public int getMaxTableNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29874, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29874, this.delegate.getMaxTableNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29874, this.onErrorForAll(methodObject29874, var2));
      }
   }

   public ResultSet getSchemas(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject29889, this, arg0, arg1);
         return (ResultSet)this.postForAll(methodObject29889, this.proxyFactory.proxyForCache((Object)this.delegate.getSchemas(arg0, arg1), this, this.proxyCache, methodObject29889));
      } catch (SQLException var4) {
         return (ResultSet)this.postForAll(methodObject29889, this.onErrorForAll(methodObject29889, var4));
      }
   }

   public ResultSet getTypeInfo() throws SQLException {
      try {
         super.preForAll(methodObject29899, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29899, this.proxyFactory.proxyForCache((Object)this.delegate.getTypeInfo(), this, this.proxyCache, methodObject29899));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29899, this.onErrorForAll(methodObject29899, var2));
      }
   }

   public int getMaxTablesInSelect() throws SQLException {
      try {
         super.preForAll(methodObject29875, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29875, this.delegate.getMaxTablesInSelect());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29875, this.onErrorForAll(methodObject29875, var2));
      }
   }

   public boolean supportsUnion() throws SQLException {
      try {
         super.preForAll(methodObject29986, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29986, this.delegate.supportsUnion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29986, this.onErrorForAll(methodObject29986, var2));
      }
   }

   public boolean supportsSubqueriesInExists() throws SQLException {
      try {
         super.preForAll(methodObject29980, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29980, this.delegate.supportsSubqueriesInExists());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29980, this.onErrorForAll(methodObject29980, var2));
      }
   }

   public boolean supportsResultSetType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29968, this, arg0);
         return (Boolean)this.postForAll(methodObject29968, this.delegate.supportsResultSetType(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29968, this.onErrorForAll(methodObject29968, var3));
      }
   }

   public boolean supportsOrderByUnrelated() throws SQLException {
      try {
         super.preForAll(methodObject29962, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29962, this.delegate.supportsOrderByUnrelated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29962, this.onErrorForAll(methodObject29962, var2));
      }
   }

   public boolean usesLocalFiles() throws SQLException {
      try {
         super.preForAll(methodObject29990, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29990, this.delegate.usesLocalFiles());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29990, this.onErrorForAll(methodObject29990, var2));
      }
   }

   public boolean supportsANSI92IntermediateSQL() throws SQLException {
      try {
         super.preForAll(methodObject29924, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29924, this.delegate.supportsANSI92IntermediateSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29924, this.onErrorForAll(methodObject29924, var2));
      }
   }

   public String getNumericFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29877, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29877, (Object)this.delegate.getNumericFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29877, this.onErrorForAll(methodObject29877, var2));
      }
   }

   public boolean supportsConvert(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject29935, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject29935, this.delegate.supportsConvert(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject29935, this.onErrorForAll(methodObject29935, var4));
      }
   }

   public int getSQLStateType() throws SQLException {
      try {
         super.preForAll(methodObject29886, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29886, this.delegate.getSQLStateType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29886, this.onErrorForAll(methodObject29886, var2));
      }
   }

   public int getMaxStatementLength() throws SQLException {
      try {
         super.preForAll(methodObject29872, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29872, this.delegate.getMaxStatementLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29872, this.onErrorForAll(methodObject29872, var2));
      }
   }

   public boolean deletesAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29829, this, arg0);
         return (Boolean)this.postForAll(methodObject29829, this.delegate.deletesAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29829, this.onErrorForAll(methodObject29829, var3));
      }
   }

   public String getTimeDateFunctions() throws SQLException {
      try {
         super.preForAll(methodObject29898, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29898, (Object)this.delegate.getTimeDateFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29898, this.onErrorForAll(methodObject29898, var2));
      }
   }

   public boolean supportsSchemasInDataManipulation() throws SQLException {
      try {
         super.preForAll(methodObject29970, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29970, this.delegate.supportsSchemasInDataManipulation());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29970, this.onErrorForAll(methodObject29970, var2));
      }
   }

   public boolean supportsPositionedUpdate() throws SQLException {
      try {
         super.preForAll(methodObject29965, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29965, this.delegate.supportsPositionedUpdate());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29965, this.onErrorForAll(methodObject29965, var2));
      }
   }

   public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29919, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29919, this.delegate.storesMixedCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29919, this.onErrorForAll(methodObject29919, var2));
      }
   }

   public boolean supportsMixedCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29951, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29951, this.delegate.supportsMixedCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29951, this.onErrorForAll(methodObject29951, var2));
      }
   }

   public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29921, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29921, this.delegate.storesUpperCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29921, this.onErrorForAll(methodObject29921, var2));
      }
   }

   public ResultSet getPrimaryKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29878, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29878, this.proxyFactory.proxyForCache((Object)this.delegate.getPrimaryKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject29878));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29878, this.onErrorForAll(methodObject29878, var5));
      }
   }

   public boolean supportsCoreSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject29936, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29936, this.delegate.supportsCoreSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29936, this.onErrorForAll(methodObject29936, var2));
      }
   }

   public int getDatabaseMinorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29841, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29841, this.delegate.getDatabaseMinorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29841, this.onErrorForAll(methodObject29841, var2));
      }
   }

   public int getMaxRowSize() throws SQLException {
      try {
         super.preForAll(methodObject29870, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29870, this.delegate.getMaxRowSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29870, this.onErrorForAll(methodObject29870, var2));
      }
   }

   public boolean nullsAreSortedLow() throws SQLException {
      try {
         super.preForAll(methodObject29909, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29909, this.delegate.nullsAreSortedLow());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29909, this.onErrorForAll(methodObject29909, var2));
      }
   }

   public boolean supportsNamedParameters() throws SQLException {
      try {
         super.preForAll(methodObject29956, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29956, this.delegate.supportsNamedParameters());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29956, this.onErrorForAll(methodObject29956, var2));
      }
   }

   public boolean othersUpdatesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29912, this, arg0);
         return (Boolean)this.postForAll(methodObject29912, this.delegate.othersUpdatesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29912, this.onErrorForAll(methodObject29912, var3));
      }
   }

   public ResultSet getIndexInfo(String arg0, String arg1, String arg2, boolean arg3, boolean arg4) throws SQLException {
      try {
         super.preForAll(methodObject29854, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject29854, this.proxyFactory.proxyForCache((Object)this.delegate.getIndexInfo(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject29854));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject29854, this.onErrorForAll(methodObject29854, var7));
      }
   }

   public String getURL() throws SQLException {
      try {
         super.preForAll(methodObject29817, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29817, (Object)this.delegate.getURL());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29817, this.onErrorForAll(methodObject29817, var2));
      }
   }

   public ResultSet getTables(String arg0, String arg1, String arg2, String[] arg3) throws SQLException {
      try {
         super.preForAll(methodObject29897, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29897, this.proxyFactory.proxyForCache((Object)this.delegate.getTables(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29897));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29897, this.onErrorForAll(methodObject29897, var6));
      }
   }

   public boolean supportsTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29985, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29985, this.delegate.supportsTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29985, this.onErrorForAll(methodObject29985, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject29821, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject29821, this.proxyFactory.proxyForCache((Object)this.delegate.getConnection(), this, this.proxyCache, methodObject29821));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject29821, this.onErrorForAll(methodObject29821, var2));
      }
   }

   public String getExtraNameCharacters() throws SQLException {
      try {
         super.preForAll(methodObject29849, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29849, (Object)this.delegate.getExtraNameCharacters());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29849, this.onErrorForAll(methodObject29849, var2));
      }
   }

   public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29952, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29952, this.delegate.supportsMixedCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29952, this.onErrorForAll(methodObject29952, var2));
      }
   }

   public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29917, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29917, this.delegate.storesLowerCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29917, this.onErrorForAll(methodObject29917, var2));
      }
   }

   public boolean supportsExtendedSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject29941, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29941, this.delegate.supportsExtendedSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29941, this.onErrorForAll(methodObject29941, var2));
      }
   }

   public boolean supportsConvert() throws SQLException {
      try {
         super.preForAll(methodObject29934, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29934, this.delegate.supportsConvert());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29934, this.onErrorForAll(methodObject29934, var2));
      }
   }

   public boolean supportsANSI92FullSQL() throws SQLException {
      try {
         super.preForAll(methodObject29923, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29923, this.delegate.supportsANSI92FullSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29923, this.onErrorForAll(methodObject29923, var2));
      }
   }

   public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
      try {
         super.preForAll(methodObject29977, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29977, this.delegate.supportsStoredFunctionsUsingCallSyntax());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29977, this.onErrorForAll(methodObject29977, var2));
      }
   }

   public int getMaxCursorNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29867, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29867, this.delegate.getMaxCursorNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29867, this.onErrorForAll(methodObject29867, var2));
      }
   }

   public int getJDBCMinorVersion() throws SQLException {
      try {
         super.preForAll(methodObject29856, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29856, this.delegate.getJDBCMinorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29856, this.onErrorForAll(methodObject29856, var2));
      }
   }

   public ResultSet getTablePrivileges(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29895, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29895, this.proxyFactory.proxyForCache((Object)this.delegate.getTablePrivileges(arg0, arg1, arg2), this, this.proxyCache, methodObject29895));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29895, this.onErrorForAll(methodObject29895, var5));
      }
   }

   public boolean supportsNonNullableColumns() throws SQLException {
      try {
         super.preForAll(methodObject29957, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29957, this.delegate.supportsNonNullableColumns());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29957, this.onErrorForAll(methodObject29957, var2));
      }
   }

   public boolean supportsLikeEscapeClause() throws SQLException {
      try {
         super.preForAll(methodObject29948, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29948, this.delegate.supportsLikeEscapeClause());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29948, this.onErrorForAll(methodObject29948, var2));
      }
   }

   public boolean supportsCorrelatedSubqueries() throws SQLException {
      try {
         super.preForAll(methodObject29937, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29937, this.delegate.supportsCorrelatedSubqueries());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29937, this.onErrorForAll(methodObject29937, var2));
      }
   }

   public String getProcedureTerm() throws SQLException {
      try {
         super.preForAll(methodObject29880, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29880, (Object)this.delegate.getProcedureTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29880, this.onErrorForAll(methodObject29880, var2));
      }
   }

   public boolean nullsAreSortedHigh() throws SQLException {
      try {
         super.preForAll(methodObject29908, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29908, this.delegate.nullsAreSortedHigh());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29908, this.onErrorForAll(methodObject29908, var2));
      }
   }

   public boolean supportsSavepoints() throws SQLException {
      try {
         super.preForAll(methodObject29969, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29969, this.delegate.supportsSavepoints());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29969, this.onErrorForAll(methodObject29969, var2));
      }
   }

   public int getMaxCatalogNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29858, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29858, this.delegate.getMaxCatalogNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29858, this.onErrorForAll(methodObject29858, var2));
      }
   }

   public boolean supportsBatchUpdates() throws SQLException {
      try {
         super.preForAll(methodObject29927, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29927, this.delegate.supportsBatchUpdates());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29927, this.onErrorForAll(methodObject29927, var2));
      }
   }

   public boolean supportsExpressionsInOrderBy() throws SQLException {
      try {
         super.preForAll(methodObject29940, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29940, this.delegate.supportsExpressionsInOrderBy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29940, this.onErrorForAll(methodObject29940, var2));
      }
   }

   public ResultSet getFunctionColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29850, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29850, this.proxyFactory.proxyForCache((Object)this.delegate.getFunctionColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29850));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29850, this.onErrorForAll(methodObject29850, var6));
      }
   }

   public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29828, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29828, this.delegate.dataDefinitionIgnoredInTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29828, this.onErrorForAll(methodObject29828, var2));
      }
   }

   public boolean supportsOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject29963, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29963, this.delegate.supportsOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29963, this.onErrorForAll(methodObject29963, var2));
      }
   }

   public boolean nullsAreSortedAtStart() throws SQLException {
      try {
         super.preForAll(methodObject29907, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29907, this.delegate.nullsAreSortedAtStart());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29907, this.onErrorForAll(methodObject29907, var2));
      }
   }

   public boolean supportsUnionAll() throws SQLException {
      try {
         super.preForAll(methodObject29987, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29987, this.delegate.supportsUnionAll());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29987, this.onErrorForAll(methodObject29987, var2));
      }
   }

   public boolean allProceduresAreCallable() throws SQLException {
      try {
         super.preForAll(methodObject29824, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29824, this.delegate.allProceduresAreCallable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29824, this.onErrorForAll(methodObject29824, var2));
      }
   }

   public long getLobMaxLength() throws SQLException {
      try {
         super.preForAll(methodObject29816, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject29816, this.delegate.getLobMaxLength());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject29816, this.onErrorForAll(methodObject29816, var2));
      }
   }

   public boolean ownDeletesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29913, this, arg0);
         return (Boolean)this.postForAll(methodObject29913, this.delegate.ownDeletesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29913, this.onErrorForAll(methodObject29913, var3));
      }
   }

   public boolean supportsCatalogsInDataManipulation() throws SQLException {
      try {
         super.preForAll(methodObject29928, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29928, this.delegate.supportsCatalogsInDataManipulation());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29928, this.onErrorForAll(methodObject29928, var2));
      }
   }

   public RowIdLifetime getRowIdLifetime() throws SQLException {
      try {
         super.preForAll(methodObject29884, this, zeroLengthObjectArray);
         return (RowIdLifetime)this.postForAll(methodObject29884, (Object)this.delegate.getRowIdLifetime());
      } catch (SQLException var2) {
         return (RowIdLifetime)this.postForAll(methodObject29884, this.onErrorForAll(methodObject29884, var2));
      }
   }

   public ResultSet getVersionColumns(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29901, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29901, this.proxyFactory.proxyForCache((Object)this.delegate.getVersionColumns(arg0, arg1, arg2), this, this.proxyCache, methodObject29901));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29901, this.onErrorForAll(methodObject29901, var5));
      }
   }

   public ResultSet getExportedKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29848, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29848, this.proxyFactory.proxyForCache((Object)this.delegate.getExportedKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject29848));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29848, this.onErrorForAll(methodObject29848, var5));
      }
   }

   public String getDatabaseProductVersion() throws SQLException {
      try {
         super.preForAll(methodObject29820, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29820, (Object)this.delegate.getDatabaseProductVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29820, this.onErrorForAll(methodObject29820, var2));
      }
   }

   public ResultSet getColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29838, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29838, this.proxyFactory.proxyForCache((Object)this.delegate.getColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29838));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29838, this.onErrorForAll(methodObject29838, var6));
      }
   }

   public int getMaxProcedureNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29869, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29869, this.delegate.getMaxProcedureNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29869, this.onErrorForAll(methodObject29869, var2));
      }
   }

   public boolean insertsAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29902, this, arg0);
         return (Boolean)this.postForAll(methodObject29902, this.delegate.insertsAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29902, this.onErrorForAll(methodObject29902, var3));
      }
   }

   public boolean storesMixedCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29918, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29918, this.delegate.storesMixedCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29918, this.onErrorForAll(methodObject29918, var2));
      }
   }

   public boolean supportsColumnAliasing() throws SQLException {
      try {
         super.preForAll(methodObject29933, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29933, this.delegate.supportsColumnAliasing());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29933, this.onErrorForAll(methodObject29933, var2));
      }
   }

   public boolean supportsAlterTableWithDropColumn() throws SQLException {
      try {
         super.preForAll(methodObject29926, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29926, this.delegate.supportsAlterTableWithDropColumn());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29926, this.onErrorForAll(methodObject29926, var2));
      }
   }

   public boolean generatedKeyAlwaysReturned() throws SQLException {
      try {
         super.preForAll(methodObject29831, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29831, this.delegate.generatedKeyAlwaysReturned());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29831, this.onErrorForAll(methodObject29831, var2));
      }
   }

   public boolean supportsMultipleTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29955, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29955, this.delegate.supportsMultipleTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29955, this.onErrorForAll(methodObject29955, var2));
      }
   }

   public boolean supportsGroupBy() throws SQLException {
      try {
         super.preForAll(methodObject29944, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29944, this.delegate.supportsGroupBy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29944, this.onErrorForAll(methodObject29944, var2));
      }
   }

   public ResultSet getProcedureColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29879, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29879, this.proxyFactory.proxyForCache((Object)this.delegate.getProcedureColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29879));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29879, this.onErrorForAll(methodObject29879, var6));
      }
   }

   public int getMaxColumnsInTable() throws SQLException {
      try {
         super.preForAll(methodObject29865, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29865, this.delegate.getMaxColumnsInTable());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29865, this.onErrorForAll(methodObject29865, var2));
      }
   }

   public int getMaxColumnsInOrderBy() throws SQLException {
      try {
         super.preForAll(methodObject29863, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29863, this.delegate.getMaxColumnsInOrderBy());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29863, this.onErrorForAll(methodObject29863, var2));
      }
   }

   public ResultSet getCrossReference(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws SQLException {
      try {
         super.preForAll(methodObject29839, this, arg0, arg1, arg2, arg3, arg4, arg5);
         return (ResultSet)this.postForAll(methodObject29839, this.proxyFactory.proxyForCache((Object)this.delegate.getCrossReference(arg0, arg1, arg2, arg3, arg4, arg5), this, this.proxyCache, methodObject29839));
      } catch (SQLException var8) {
         return (ResultSet)this.postForAll(methodObject29839, this.onErrorForAll(methodObject29839, var8));
      }
   }

   public int getMaxConnections() throws SQLException {
      try {
         super.preForAll(methodObject29866, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29866, this.delegate.getMaxConnections());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29866, this.onErrorForAll(methodObject29866, var2));
      }
   }

   public boolean allTablesAreSelectable() throws SQLException {
      try {
         super.preForAll(methodObject29825, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29825, this.delegate.allTablesAreSelectable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29825, this.onErrorForAll(methodObject29825, var2));
      }
   }

   public ResultSet getTableTypes() throws SQLException {
      try {
         super.preForAll(methodObject29896, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject29896, this.proxyFactory.proxyForCache((Object)this.delegate.getTableTypes(), this, this.proxyCache, methodObject29896));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject29896, this.onErrorForAll(methodObject29896, var2));
      }
   }

   public boolean nullPlusNonNullIsNull() throws SQLException {
      try {
         super.preForAll(methodObject29905, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29905, this.delegate.nullPlusNonNullIsNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29905, this.onErrorForAll(methodObject29905, var2));
      }
   }

   public boolean supportsSubqueriesInComparisons() throws SQLException {
      try {
         super.preForAll(methodObject29979, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29979, this.delegate.supportsSubqueriesInComparisons());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29979, this.onErrorForAll(methodObject29979, var2));
      }
   }

   public int getMaxIndexLength() throws SQLException {
      try {
         super.preForAll(methodObject29868, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29868, this.delegate.getMaxIndexLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29868, this.onErrorForAll(methodObject29868, var2));
      }
   }

   public boolean supportsSubqueriesInQuantifieds() throws SQLException {
      try {
         super.preForAll(methodObject29982, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29982, this.delegate.supportsSubqueriesInQuantifieds());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29982, this.onErrorForAll(methodObject29982, var2));
      }
   }

   public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
      try {
         super.preForAll(methodObject29960, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29960, this.delegate.supportsOpenStatementsAcrossCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29960, this.onErrorForAll(methodObject29960, var2));
      }
   }

   public boolean supportsCatalogsInTableDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject29932, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29932, this.delegate.supportsCatalogsInTableDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29932, this.onErrorForAll(methodObject29932, var2));
      }
   }

   public boolean ownUpdatesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29915, this, arg0);
         return (Boolean)this.postForAll(methodObject29915, this.delegate.ownUpdatesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29915, this.onErrorForAll(methodObject29915, var3));
      }
   }

   public boolean supportsGroupByBeyondSelect() throws SQLException {
      try {
         super.preForAll(methodObject29945, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29945, this.delegate.supportsGroupByBeyondSelect());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29945, this.onErrorForAll(methodObject29945, var2));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29992, this, arg0);
         return (Boolean)this.postForAll(methodObject29992, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29992, this.onErrorForAll(methodObject29992, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29991, this, arg0);
         return this.postForAll(methodObject29991, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject29991));
      } catch (SQLException var3) {
         return this.postForAll(methodObject29991, this.onErrorForAll(methodObject29991, var3));
      }
   }

   public boolean supportsStatementPooling() throws SQLException {
      try {
         super.preForAll(methodObject29976, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29976, this.delegate.supportsStatementPooling());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29976, this.onErrorForAll(methodObject29976, var2));
      }
   }

   public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
      try {
         super.preForAll(methodObject29823, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29823, this.delegate.supportsDataDefinitionAndDataManipulationTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29823, this.onErrorForAll(methodObject29823, var2));
      }
   }

   public boolean supportsMultipleOpenResults() throws SQLException {
      try {
         super.preForAll(methodObject29953, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29953, this.delegate.supportsMultipleOpenResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29953, this.onErrorForAll(methodObject29953, var2));
      }
   }

   public int getMaxColumnsInGroupBy() throws SQLException {
      try {
         super.preForAll(methodObject29861, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29861, this.delegate.getMaxColumnsInGroupBy());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29861, this.onErrorForAll(methodObject29861, var2));
      }
   }

   public int getMaxColumnNameLength() throws SQLException {
      try {
         super.preForAll(methodObject29860, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29860, this.delegate.getMaxColumnNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29860, this.onErrorForAll(methodObject29860, var2));
      }
   }

   public ResultSet getAttributes(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject29819, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject29819, this.proxyFactory.proxyForCache((Object)this.delegate.getAttributes(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject29819));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject29819, this.onErrorForAll(methodObject29819, var6));
      }
   }

   public int getMaxStatements() throws SQLException {
      try {
         super.preForAll(methodObject29873, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29873, this.delegate.getMaxStatements());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29873, this.onErrorForAll(methodObject29873, var2));
      }
   }

   public boolean supportsAlterTableWithAddColumn() throws SQLException {
      try {
         super.preForAll(methodObject29925, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29925, this.delegate.supportsAlterTableWithAddColumn());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29925, this.onErrorForAll(methodObject29925, var2));
      }
   }

   public boolean supportsGroupByUnrelated() throws SQLException {
      try {
         super.preForAll(methodObject29946, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29946, this.delegate.supportsGroupByUnrelated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29946, this.onErrorForAll(methodObject29946, var2));
      }
   }

   public boolean supportsANSI92EntryLevelSQL() throws SQLException {
      try {
         super.preForAll(methodObject29922, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29922, this.delegate.supportsANSI92EntryLevelSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29922, this.onErrorForAll(methodObject29922, var2));
      }
   }

   public ResultSet getFunctions(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29851, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29851, this.proxyFactory.proxyForCache((Object)this.delegate.getFunctions(arg0, arg1, arg2), this, this.proxyCache, methodObject29851));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29851, this.onErrorForAll(methodObject29851, var5));
      }
   }

   public boolean supportsMinimumSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject29950, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29950, this.delegate.supportsMinimumSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29950, this.onErrorForAll(methodObject29950, var2));
      }
   }

   public int getMaxCharLiteralLength() throws SQLException {
      try {
         super.preForAll(methodObject29859, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29859, this.delegate.getMaxCharLiteralLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29859, this.onErrorForAll(methodObject29859, var2));
      }
   }

   public boolean othersDeletesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29910, this, arg0);
         return (Boolean)this.postForAll(methodObject29910, this.delegate.othersDeletesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29910, this.onErrorForAll(methodObject29910, var3));
      }
   }

   public ResultSet getSuperTables(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29892, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29892, this.proxyFactory.proxyForCache((Object)this.delegate.getSuperTables(arg0, arg1, arg2), this, this.proxyCache, methodObject29892));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29892, this.onErrorForAll(methodObject29892, var5));
      }
   }

   public boolean storesLowerCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject29916, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29916, this.delegate.storesLowerCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29916, this.onErrorForAll(methodObject29916, var2));
      }
   }

   public boolean updatesAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29988, this, arg0);
         return (Boolean)this.postForAll(methodObject29988, this.delegate.updatesAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29988, this.onErrorForAll(methodObject29988, var3));
      }
   }

   public boolean supportsMultipleResultSets() throws SQLException {
      try {
         super.preForAll(methodObject29954, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29954, this.delegate.supportsMultipleResultSets());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29954, this.onErrorForAll(methodObject29954, var2));
      }
   }

   public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
      try {
         super.preForAll(methodObject29959, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29959, this.delegate.supportsOpenCursorsAcrossRollback());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29959, this.onErrorForAll(methodObject29959, var2));
      }
   }

   public boolean othersInsertsAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29911, this, arg0);
         return (Boolean)this.postForAll(methodObject29911, this.delegate.othersInsertsAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29911, this.onErrorForAll(methodObject29911, var3));
      }
   }

   public ResultSet getImportedKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject29853, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject29853, this.proxyFactory.proxyForCache((Object)this.delegate.getImportedKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject29853));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject29853, this.onErrorForAll(methodObject29853, var5));
      }
   }

   public boolean supportsSelectForUpdate() throws SQLException {
      try {
         super.preForAll(methodObject29975, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29975, this.delegate.supportsSelectForUpdate());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29975, this.onErrorForAll(methodObject29975, var2));
      }
   }

   public boolean supportsPositionedDelete() throws SQLException {
      try {
         super.preForAll(methodObject29964, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29964, this.delegate.supportsPositionedDelete());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29964, this.onErrorForAll(methodObject29964, var2));
      }
   }

   public boolean supportsCatalogsInProcedureCalls() throws SQLException {
      try {
         super.preForAll(methodObject29931, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject29931, this.delegate.supportsCatalogsInProcedureCalls());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject29931, this.onErrorForAll(methodObject29931, var2));
      }
   }

   public String getCatalogSeparator() throws SQLException {
      try {
         super.preForAll(methodObject29833, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject29833, (Object)this.delegate.getCatalogSeparator());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject29833, this.onErrorForAll(methodObject29833, var2));
      }
   }

   public AdditionalDatabaseMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (AdditionalDatabaseMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29855 = DatabaseMetaData.class.getDeclaredMethod("getJDBCMajorVersion");
         methodObject29958 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenCursorsAcrossCommit");
         methodObject29929 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInIndexDefinitions");
         methodObject29914 = DatabaseMetaData.class.getDeclaredMethod("ownInsertsAreVisible", Integer.TYPE);
         methodObject29845 = DatabaseMetaData.class.getDeclaredMethod("getDriverMinorVersion");
         methodObject29834 = DatabaseMetaData.class.getDeclaredMethod("getCatalogTerm");
         methodObject29949 = DatabaseMetaData.class.getDeclaredMethod("supportsLimitedOuterJoins");
         methodObject29888 = DatabaseMetaData.class.getDeclaredMethod("getSchemas");
         methodObject29852 = DatabaseMetaData.class.getDeclaredMethod("getIdentifierQuoteString");
         methodObject29938 = DatabaseMetaData.class.getDeclaredMethod("supportsDataManipulationTransactionsOnly");
         methodObject29890 = DatabaseMetaData.class.getDeclaredMethod("getSearchStringEscape");
         methodObject29900 = DatabaseMetaData.class.getDeclaredMethod("getUDTs", String.class, String.class, String.class, int[].class);
         methodObject29972 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInPrivilegeDefinitions");
         methodObject29871 = DatabaseMetaData.class.getDeclaredMethod("getMaxSchemaNameLength");
         methodObject29942 = DatabaseMetaData.class.getDeclaredMethod("supportsFullOuterJoins");
         methodObject29832 = DatabaseMetaData.class.getDeclaredMethod("getBestRowIdentifier", String.class, String.class, String.class, Integer.TYPE, Boolean.TYPE);
         methodObject29904 = DatabaseMetaData.class.getDeclaredMethod("locatorsUpdateCopy");
         methodObject29894 = DatabaseMetaData.class.getDeclaredMethod("getSystemFunctions");
         methodObject29989 = DatabaseMetaData.class.getDeclaredMethod("usesLocalFilePerTable");
         methodObject29966 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetConcurrency", Integer.TYPE, Integer.TYPE);
         methodObject29885 = DatabaseMetaData.class.getDeclaredMethod("getSQLKeywords");
         methodObject29822 = DatabaseMetaData.class.getDeclaredMethod("getUserName");
         methodObject29876 = DatabaseMetaData.class.getDeclaredMethod("getMaxUserNameLength");
         methodObject29881 = DatabaseMetaData.class.getDeclaredMethod("getProcedures", String.class, String.class, String.class);
         methodObject29847 = DatabaseMetaData.class.getDeclaredMethod("getDriverVersion");
         methodObject29862 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInIndex");
         methodObject29887 = DatabaseMetaData.class.getDeclaredMethod("getSchemaTerm");
         methodObject29981 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInIns");
         methodObject29973 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInProcedureCalls");
         methodObject29961 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenStatementsAcrossRollback");
         methodObject29846 = DatabaseMetaData.class.getDeclaredMethod("getDriverName");
         methodObject29826 = DatabaseMetaData.class.getDeclaredMethod("autoCommitFailureClosesAllResultSets");
         methodObject29836 = DatabaseMetaData.class.getDeclaredMethod("getClientInfoProperties");
         methodObject29842 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseProductName");
         methodObject29983 = DatabaseMetaData.class.getDeclaredMethod("supportsTableCorrelationNames");
         methodObject29984 = DatabaseMetaData.class.getDeclaredMethod("supportsTransactionIsolationLevel", Integer.TYPE);
         methodObject29840 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseMajorVersion");
         methodObject29864 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInSelect");
         methodObject29893 = DatabaseMetaData.class.getDeclaredMethod("getSuperTypes", String.class, String.class, String.class);
         methodObject29978 = DatabaseMetaData.class.getDeclaredMethod("supportsStoredProcedures");
         methodObject29815 = AdditionalDatabaseMetaData.class.getDeclaredMethod("getOracleTypeMetaData", String.class);
         methodObject29837 = DatabaseMetaData.class.getDeclaredMethod("getColumnPrivileges", String.class, String.class, String.class, String.class);
         methodObject29971 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInIndexDefinitions");
         methodObject29843 = DatabaseMetaData.class.getDeclaredMethod("getDefaultTransactionIsolation");
         methodObject29891 = DatabaseMetaData.class.getDeclaredMethod("getStringFunctions");
         methodObject29830 = DatabaseMetaData.class.getDeclaredMethod("doesMaxRowSizeIncludeBlobs");
         methodObject29974 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInTableDefinitions");
         methodObject29882 = DatabaseMetaData.class.getDeclaredMethod("getPseudoColumns", String.class, String.class, String.class, String.class);
         methodObject29947 = DatabaseMetaData.class.getDeclaredMethod("supportsIntegrityEnhancementFacility");
         methodObject29827 = DatabaseMetaData.class.getDeclaredMethod("dataDefinitionCausesTransactionCommit");
         methodObject29906 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedAtEnd");
         methodObject29835 = DatabaseMetaData.class.getDeclaredMethod("getCatalogs");
         methodObject29844 = DatabaseMetaData.class.getDeclaredMethod("getDriverMajorVersion");
         methodObject29930 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInPrivilegeDefinitions");
         methodObject29903 = DatabaseMetaData.class.getDeclaredMethod("isCatalogAtStart");
         methodObject29857 = DatabaseMetaData.class.getDeclaredMethod("getMaxBinaryLiteralLength");
         methodObject29883 = DatabaseMetaData.class.getDeclaredMethod("getResultSetHoldability");
         methodObject29920 = DatabaseMetaData.class.getDeclaredMethod("storesUpperCaseIdentifiers");
         methodObject29818 = DatabaseMetaData.class.getDeclaredMethod("isReadOnly");
         methodObject29967 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetHoldability", Integer.TYPE);
         methodObject29939 = DatabaseMetaData.class.getDeclaredMethod("supportsDifferentTableCorrelationNames");
         methodObject29943 = DatabaseMetaData.class.getDeclaredMethod("supportsGetGeneratedKeys");
         methodObject29874 = DatabaseMetaData.class.getDeclaredMethod("getMaxTableNameLength");
         methodObject29889 = DatabaseMetaData.class.getDeclaredMethod("getSchemas", String.class, String.class);
         methodObject29899 = DatabaseMetaData.class.getDeclaredMethod("getTypeInfo");
         methodObject29875 = DatabaseMetaData.class.getDeclaredMethod("getMaxTablesInSelect");
         methodObject29986 = DatabaseMetaData.class.getDeclaredMethod("supportsUnion");
         methodObject29980 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInExists");
         methodObject29968 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetType", Integer.TYPE);
         methodObject29962 = DatabaseMetaData.class.getDeclaredMethod("supportsOrderByUnrelated");
         methodObject29990 = DatabaseMetaData.class.getDeclaredMethod("usesLocalFiles");
         methodObject29924 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92IntermediateSQL");
         methodObject29877 = DatabaseMetaData.class.getDeclaredMethod("getNumericFunctions");
         methodObject29935 = DatabaseMetaData.class.getDeclaredMethod("supportsConvert", Integer.TYPE, Integer.TYPE);
         methodObject29886 = DatabaseMetaData.class.getDeclaredMethod("getSQLStateType");
         methodObject29872 = DatabaseMetaData.class.getDeclaredMethod("getMaxStatementLength");
         methodObject29829 = DatabaseMetaData.class.getDeclaredMethod("deletesAreDetected", Integer.TYPE);
         methodObject29898 = DatabaseMetaData.class.getDeclaredMethod("getTimeDateFunctions");
         methodObject29970 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInDataManipulation");
         methodObject29965 = DatabaseMetaData.class.getDeclaredMethod("supportsPositionedUpdate");
         methodObject29919 = DatabaseMetaData.class.getDeclaredMethod("storesMixedCaseQuotedIdentifiers");
         methodObject29951 = DatabaseMetaData.class.getDeclaredMethod("supportsMixedCaseIdentifiers");
         methodObject29921 = DatabaseMetaData.class.getDeclaredMethod("storesUpperCaseQuotedIdentifiers");
         methodObject29878 = DatabaseMetaData.class.getDeclaredMethod("getPrimaryKeys", String.class, String.class, String.class);
         methodObject29936 = DatabaseMetaData.class.getDeclaredMethod("supportsCoreSQLGrammar");
         methodObject29841 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseMinorVersion");
         methodObject29870 = DatabaseMetaData.class.getDeclaredMethod("getMaxRowSize");
         methodObject29909 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedLow");
         methodObject29956 = DatabaseMetaData.class.getDeclaredMethod("supportsNamedParameters");
         methodObject29912 = DatabaseMetaData.class.getDeclaredMethod("othersUpdatesAreVisible", Integer.TYPE);
         methodObject29854 = DatabaseMetaData.class.getDeclaredMethod("getIndexInfo", String.class, String.class, String.class, Boolean.TYPE, Boolean.TYPE);
         methodObject29817 = DatabaseMetaData.class.getDeclaredMethod("getURL");
         methodObject29897 = DatabaseMetaData.class.getDeclaredMethod("getTables", String.class, String.class, String.class, String[].class);
         methodObject29985 = DatabaseMetaData.class.getDeclaredMethod("supportsTransactions");
         methodObject29821 = DatabaseMetaData.class.getDeclaredMethod("getConnection");
         methodObject29849 = DatabaseMetaData.class.getDeclaredMethod("getExtraNameCharacters");
         methodObject29952 = DatabaseMetaData.class.getDeclaredMethod("supportsMixedCaseQuotedIdentifiers");
         methodObject29917 = DatabaseMetaData.class.getDeclaredMethod("storesLowerCaseQuotedIdentifiers");
         methodObject29941 = DatabaseMetaData.class.getDeclaredMethod("supportsExtendedSQLGrammar");
         methodObject29934 = DatabaseMetaData.class.getDeclaredMethod("supportsConvert");
         methodObject29923 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92FullSQL");
         methodObject29977 = DatabaseMetaData.class.getDeclaredMethod("supportsStoredFunctionsUsingCallSyntax");
         methodObject29867 = DatabaseMetaData.class.getDeclaredMethod("getMaxCursorNameLength");
         methodObject29856 = DatabaseMetaData.class.getDeclaredMethod("getJDBCMinorVersion");
         methodObject29895 = DatabaseMetaData.class.getDeclaredMethod("getTablePrivileges", String.class, String.class, String.class);
         methodObject29957 = DatabaseMetaData.class.getDeclaredMethod("supportsNonNullableColumns");
         methodObject29948 = DatabaseMetaData.class.getDeclaredMethod("supportsLikeEscapeClause");
         methodObject29937 = DatabaseMetaData.class.getDeclaredMethod("supportsCorrelatedSubqueries");
         methodObject29880 = DatabaseMetaData.class.getDeclaredMethod("getProcedureTerm");
         methodObject29908 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedHigh");
         methodObject29969 = DatabaseMetaData.class.getDeclaredMethod("supportsSavepoints");
         methodObject29858 = DatabaseMetaData.class.getDeclaredMethod("getMaxCatalogNameLength");
         methodObject29927 = DatabaseMetaData.class.getDeclaredMethod("supportsBatchUpdates");
         methodObject29940 = DatabaseMetaData.class.getDeclaredMethod("supportsExpressionsInOrderBy");
         methodObject29850 = DatabaseMetaData.class.getDeclaredMethod("getFunctionColumns", String.class, String.class, String.class, String.class);
         methodObject29828 = DatabaseMetaData.class.getDeclaredMethod("dataDefinitionIgnoredInTransactions");
         methodObject29963 = DatabaseMetaData.class.getDeclaredMethod("supportsOuterJoins");
         methodObject29907 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedAtStart");
         methodObject29987 = DatabaseMetaData.class.getDeclaredMethod("supportsUnionAll");
         methodObject29824 = DatabaseMetaData.class.getDeclaredMethod("allProceduresAreCallable");
         methodObject29816 = AdditionalDatabaseMetaData.class.getDeclaredMethod("getLobMaxLength");
         methodObject29913 = DatabaseMetaData.class.getDeclaredMethod("ownDeletesAreVisible", Integer.TYPE);
         methodObject29928 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInDataManipulation");
         methodObject29884 = DatabaseMetaData.class.getDeclaredMethod("getRowIdLifetime");
         methodObject29901 = DatabaseMetaData.class.getDeclaredMethod("getVersionColumns", String.class, String.class, String.class);
         methodObject29848 = DatabaseMetaData.class.getDeclaredMethod("getExportedKeys", String.class, String.class, String.class);
         methodObject29820 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseProductVersion");
         methodObject29838 = DatabaseMetaData.class.getDeclaredMethod("getColumns", String.class, String.class, String.class, String.class);
         methodObject29869 = DatabaseMetaData.class.getDeclaredMethod("getMaxProcedureNameLength");
         methodObject29902 = DatabaseMetaData.class.getDeclaredMethod("insertsAreDetected", Integer.TYPE);
         methodObject29918 = DatabaseMetaData.class.getDeclaredMethod("storesMixedCaseIdentifiers");
         methodObject29933 = DatabaseMetaData.class.getDeclaredMethod("supportsColumnAliasing");
         methodObject29926 = DatabaseMetaData.class.getDeclaredMethod("supportsAlterTableWithDropColumn");
         methodObject29831 = DatabaseMetaData.class.getDeclaredMethod("generatedKeyAlwaysReturned");
         methodObject29955 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleTransactions");
         methodObject29944 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupBy");
         methodObject29879 = DatabaseMetaData.class.getDeclaredMethod("getProcedureColumns", String.class, String.class, String.class, String.class);
         methodObject29865 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInTable");
         methodObject29863 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInOrderBy");
         methodObject29839 = DatabaseMetaData.class.getDeclaredMethod("getCrossReference", String.class, String.class, String.class, String.class, String.class, String.class);
         methodObject29866 = DatabaseMetaData.class.getDeclaredMethod("getMaxConnections");
         methodObject29825 = DatabaseMetaData.class.getDeclaredMethod("allTablesAreSelectable");
         methodObject29896 = DatabaseMetaData.class.getDeclaredMethod("getTableTypes");
         methodObject29905 = DatabaseMetaData.class.getDeclaredMethod("nullPlusNonNullIsNull");
         methodObject29979 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInComparisons");
         methodObject29868 = DatabaseMetaData.class.getDeclaredMethod("getMaxIndexLength");
         methodObject29982 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInQuantifieds");
         methodObject29960 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenStatementsAcrossCommit");
         methodObject29932 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInTableDefinitions");
         methodObject29915 = DatabaseMetaData.class.getDeclaredMethod("ownUpdatesAreVisible", Integer.TYPE);
         methodObject29945 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupByBeyondSelect");
         methodObject29992 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject29991 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject29976 = DatabaseMetaData.class.getDeclaredMethod("supportsStatementPooling");
         methodObject29823 = DatabaseMetaData.class.getDeclaredMethod("supportsDataDefinitionAndDataManipulationTransactions");
         methodObject29953 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleOpenResults");
         methodObject29861 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInGroupBy");
         methodObject29860 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnNameLength");
         methodObject29819 = DatabaseMetaData.class.getDeclaredMethod("getAttributes", String.class, String.class, String.class, String.class);
         methodObject29873 = DatabaseMetaData.class.getDeclaredMethod("getMaxStatements");
         methodObject29925 = DatabaseMetaData.class.getDeclaredMethod("supportsAlterTableWithAddColumn");
         methodObject29946 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupByUnrelated");
         methodObject29922 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92EntryLevelSQL");
         methodObject29851 = DatabaseMetaData.class.getDeclaredMethod("getFunctions", String.class, String.class, String.class);
         methodObject29950 = DatabaseMetaData.class.getDeclaredMethod("supportsMinimumSQLGrammar");
         methodObject29859 = DatabaseMetaData.class.getDeclaredMethod("getMaxCharLiteralLength");
         methodObject29910 = DatabaseMetaData.class.getDeclaredMethod("othersDeletesAreVisible", Integer.TYPE);
         methodObject29892 = DatabaseMetaData.class.getDeclaredMethod("getSuperTables", String.class, String.class, String.class);
         methodObject29916 = DatabaseMetaData.class.getDeclaredMethod("storesLowerCaseIdentifiers");
         methodObject29988 = DatabaseMetaData.class.getDeclaredMethod("updatesAreDetected", Integer.TYPE);
         methodObject29954 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleResultSets");
         methodObject29959 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenCursorsAcrossRollback");
         methodObject29911 = DatabaseMetaData.class.getDeclaredMethod("othersInsertsAreVisible", Integer.TYPE);
         methodObject29853 = DatabaseMetaData.class.getDeclaredMethod("getImportedKeys", String.class, String.class, String.class);
         methodObject29975 = DatabaseMetaData.class.getDeclaredMethod("supportsSelectForUpdate");
         methodObject29964 = DatabaseMetaData.class.getDeclaredMethod("supportsPositionedDelete");
         methodObject29931 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInProcedureCalls");
         methodObject29833 = DatabaseMetaData.class.getDeclaredMethod("getCatalogSeparator");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1AdditionalDatabaseMetaData$$$Proxy(AdditionalDatabaseMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
