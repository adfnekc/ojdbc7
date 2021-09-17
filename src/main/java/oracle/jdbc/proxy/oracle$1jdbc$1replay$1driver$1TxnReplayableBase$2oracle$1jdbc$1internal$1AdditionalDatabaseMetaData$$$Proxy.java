package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.AdditionalDatabaseMetaData;
import oracle.jdbc.replay.driver.TxnReplayableBase;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1AdditionalDatabaseMetaData$$$Proxy extends TxnReplayableBase implements AdditionalDatabaseMetaData, _Proxy_ {
   private AdditionalDatabaseMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4800;
   private static Method methodObject4747;
   private static Method methodObject4848;
   private static Method methodObject4818;
   private static Method methodObject4737;
   private static Method methodObject4792;
   private static Method methodObject4727;
   private static Method methodObject4839;
   private static Method methodObject4858;
   private static Method methodObject4779;
   private static Method methodObject4744;
   private static Method methodObject4828;
   private static Method methodObject4781;
   private static Method methodObject4729;
   private static Method methodObject4862;
   private static Method methodObject4763;
   private static Method methodObject4832;
   private static Method methodObject4794;
   private static Method methodObject4705;
   private static Method methodObject4785;
   private static Method methodObject4879;
   private static Method methodObject4874;
   private static Method methodObject4776;
   private static Method methodObject4711;
   private static Method methodObject4768;
   private static Method methodObject4739;
   private static Method methodObject4754;
   private static Method methodObject4778;
   private static Method methodObject4871;
   private static Method methodObject4863;
   private static Method methodObject4851;
   private static Method methodObject4738;
   private static Method methodObject4719;
   private static Method methodObject4728;
   private static Method methodObject4734;
   private static Method methodObject4873;
   private static Method methodObject4857;
   private static Method methodObject4732;
   private static Method methodObject4756;
   private static Method methodObject4868;
   private static Method methodObject4861;
   private static Method methodObject4881;
   private static Method methodObject4740;
   private static Method methodObject4735;
   private static Method methodObject4782;
   private static Method methodObject4723;
   private static Method methodObject4864;
   private static Method methodObject4837;
   private static Method methodObject4720;
   private static Method methodObject4796;
   private static Method methodObject4716;
   private static Method methodObject4736;
   private static Method methodObject4819;
   private static Method methodObject4780;
   private static Method methodObject4793;
   private static Method methodObject4714;
   private static Method methodObject4882;
   private static Method methodObject4803;
   private static Method methodObject4749;
   private static Method methodObject4713;
   private static Method methodObject4774;
   private static Method methodObject4809;
   private static Method methodObject4708;
   private static Method methodObject4829;
   private static Method methodObject4833;
   private static Method methodObject4766;
   private static Method methodObject4722;
   private static Method methodObject4789;
   private static Method methodObject4767;
   private static Method methodObject4742;
   private static Method methodObject4876;
   private static Method methodObject4870;
   private static Method methodObject4883;
   private static Method methodObject4852;
   private static Method methodObject4880;
   private static Method methodObject4813;
   private static Method methodObject4769;
   private static Method methodObject4777;
   private static Method methodObject4764;
   private static Method methodObject4788;
   private static Method methodObject4860;
   private static Method methodObject4855;
   private static Method methodObject4715;
   private static Method methodObject4841;
   private static Method methodObject4810;
   private static Method methodObject4825;
   private static Method methodObject4733;
   private static Method methodObject4762;
   private static Method methodObject4799;
   private static Method methodObject4846;
   private static Method methodObject4707;
   private static Method methodObject4875;
   private static Method methodObject4802;
   private static Method methodObject4712;
   private static Method methodObject4741;
   private static Method methodObject4842;
   private static Method methodObject4805;
   private static Method methodObject4807;
   private static Method methodObject4831;
   private static Method methodObject4823;
   private static Method methodObject4812;
   private static Method methodObject4867;
   private static Method methodObject4746;
   private static Method methodObject4759;
   private static Method methodObject4748;
   private static Method methodObject4791;
   private static Method methodObject4847;
   private static Method methodObject4838;
   private static Method methodObject4826;
   private static Method methodObject4772;
   private static Method methodObject4798;
   private static Method methodObject4801;
   private static Method methodObject4859;
   private static Method methodObject4750;
   private static Method methodObject4745;
   private static Method methodObject4816;
   private static Method methodObject4731;
   private static Method methodObject4830;
   private static Method methodObject4771;
   private static Method methodObject4770;
   private static Method methodObject4721;
   private static Method methodObject4853;
   private static Method methodObject4797;
   private static Method methodObject4709;
   private static Method methodObject4784;
   private static Method methodObject4877;
   private static Method methodObject4717;
   private static Method methodObject4824;
   private static Method methodObject4706;
   private static Method methodObject4817;
   private static Method methodObject4775;
   private static Method methodObject4790;
   private static Method methodObject4725;
   private static Method methodObject4710;
   private static Method methodObject4786;
   private static Method methodObject4761;
   private static Method methodObject4808;
   private static Method methodObject4822;
   private static Method methodObject4815;
   private static Method methodObject4856;
   private static Method methodObject4724;
   private static Method methodObject4845;
   private static Method methodObject4783;
   private static Method methodObject4834;
   private static Method methodObject4757;
   private static Method methodObject4755;
   private static Method methodObject4743;
   private static Method methodObject4878;
   private static Method methodObject4758;
   private static Method methodObject4718;
   private static Method methodObject4787;
   private static Method methodObject4795;
   private static Method methodObject4869;
   private static Method methodObject4760;
   private static Method methodObject4872;
   private static Method methodObject4850;
   private static Method methodObject4821;
   private static Method methodObject4835;
   private static Method methodObject4866;
   private static Method methodObject4827;
   private static Method methodObject4843;
   private static Method methodObject4753;
   private static Method methodObject4752;
   private static Method methodObject4884;
   private static Method methodObject4765;
   private static Method methodObject4814;
   private static Method methodObject4836;
   private static Method methodObject4811;
   private static Method methodObject4730;
   private static Method methodObject4840;
   private static Method methodObject4751;
   private static Method methodObject4804;
   private static Method methodObject4806;
   private static Method methodObject4844;
   private static Method methodObject4849;
   private static Method methodObject4865;
   private static Method methodObject4854;
   private static Method methodObject4820;
   private static Method methodObject4773;
   private static Method methodObject4726;

   public boolean othersDeletesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4800, this, arg0);
         return (Boolean)this.postForAll(methodObject4800, this.delegate.othersDeletesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4800, this.onErrorForAll(methodObject4800, var3));
      }
   }

   public int getJDBCMajorVersion() throws SQLException {
      try {
         super.preForAll(methodObject4747, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4747, this.delegate.getJDBCMajorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4747, this.onErrorForAll(methodObject4747, var2));
      }
   }

   public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
      try {
         super.preForAll(methodObject4848, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4848, this.delegate.supportsOpenCursorsAcrossCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4848, this.onErrorForAll(methodObject4848, var2));
      }
   }

   public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject4818, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4818, this.delegate.supportsCatalogsInIndexDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4818, this.onErrorForAll(methodObject4818, var2));
      }
   }

   public int getDriverMinorVersion() {
      super.preForAll(methodObject4737, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject4737, this.delegate.getDriverMinorVersion());
   }

   public boolean insertsAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4792, this, arg0);
         return (Boolean)this.postForAll(methodObject4792, this.delegate.insertsAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4792, this.onErrorForAll(methodObject4792, var3));
      }
   }

   public String getCatalogTerm() throws SQLException {
      try {
         super.preForAll(methodObject4727, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4727, (Object)this.delegate.getCatalogTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4727, this.onErrorForAll(methodObject4727, var2));
      }
   }

   public boolean supportsLimitedOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject4839, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4839, this.delegate.supportsLimitedOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4839, this.onErrorForAll(methodObject4839, var2));
      }
   }

   public boolean supportsResultSetType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4858, this, arg0);
         return (Boolean)this.postForAll(methodObject4858, this.delegate.supportsResultSetType(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4858, this.onErrorForAll(methodObject4858, var3));
      }
   }

   public ResultSet getSchemas() throws SQLException {
      try {
         super.preForAll(methodObject4779, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject4779, this.proxyFactory.proxyForCache((Object)this.delegate.getSchemas(), this, this.proxyCache, methodObject4779));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject4779, this.onErrorForAll(methodObject4779, var2));
      }
   }

   public String getIdentifierQuoteString() throws SQLException {
      try {
         super.preForAll(methodObject4744, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4744, (Object)this.delegate.getIdentifierQuoteString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4744, this.onErrorForAll(methodObject4744, var2));
      }
   }

   public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
      try {
         super.preForAll(methodObject4828, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4828, this.delegate.supportsDataManipulationTransactionsOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4828, this.onErrorForAll(methodObject4828, var2));
      }
   }

   public String getSearchStringEscape() throws SQLException {
      try {
         super.preForAll(methodObject4781, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4781, (Object)this.delegate.getSearchStringEscape());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4781, this.onErrorForAll(methodObject4781, var2));
      }
   }

   public ResultSet getColumnPrivileges(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject4729, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4729, this.proxyFactory.proxyForCache((Object)this.delegate.getColumnPrivileges(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4729));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4729, this.onErrorForAll(methodObject4729, var6));
      }
   }

   public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject4862, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4862, this.delegate.supportsSchemasInPrivilegeDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4862, this.onErrorForAll(methodObject4862, var2));
      }
   }

   public int getMaxSchemaNameLength() throws SQLException {
      try {
         super.preForAll(methodObject4763, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4763, this.delegate.getMaxSchemaNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4763, this.onErrorForAll(methodObject4763, var2));
      }
   }

   public boolean supportsFullOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject4832, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4832, this.delegate.supportsFullOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4832, this.onErrorForAll(methodObject4832, var2));
      }
   }

   public boolean locatorsUpdateCopy() throws SQLException {
      try {
         super.preForAll(methodObject4794, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4794, this.delegate.locatorsUpdateCopy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4794, this.onErrorForAll(methodObject4794, var2));
      }
   }

   public OracleTypeMetaData getOracleTypeMetaData(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject4705, this, arg0);
         return (OracleTypeMetaData)this.postForAll(methodObject4705, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleTypeMetaData(arg0), this, this.proxyCache, methodObject4705));
      } catch (SQLException var3) {
         return (OracleTypeMetaData)this.postForAll(methodObject4705, this.onErrorForAll(methodObject4705, var3));
      }
   }

   public String getSystemFunctions() throws SQLException {
      try {
         super.preForAll(methodObject4785, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4785, (Object)this.delegate.getSystemFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4785, this.onErrorForAll(methodObject4785, var2));
      }
   }

   public boolean usesLocalFilePerTable() throws SQLException {
      try {
         super.preForAll(methodObject4879, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4879, this.delegate.usesLocalFilePerTable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4879, this.onErrorForAll(methodObject4879, var2));
      }
   }

   public boolean supportsTransactionIsolationLevel(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4874, this, arg0);
         return (Boolean)this.postForAll(methodObject4874, this.delegate.supportsTransactionIsolationLevel(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4874, this.onErrorForAll(methodObject4874, var3));
      }
   }

   public String getSQLKeywords() throws SQLException {
      try {
         super.preForAll(methodObject4776, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4776, (Object)this.delegate.getSQLKeywords());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4776, this.onErrorForAll(methodObject4776, var2));
      }
   }

   public String getUserName() throws SQLException {
      try {
         super.preForAll(methodObject4711, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4711, (Object)this.delegate.getUserName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4711, this.onErrorForAll(methodObject4711, var2));
      }
   }

   public int getMaxUserNameLength() throws SQLException {
      try {
         super.preForAll(methodObject4768, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4768, this.delegate.getMaxUserNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4768, this.onErrorForAll(methodObject4768, var2));
      }
   }

   public String getDriverVersion() throws SQLException {
      try {
         super.preForAll(methodObject4739, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4739, (Object)this.delegate.getDriverVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4739, this.onErrorForAll(methodObject4739, var2));
      }
   }

   public int getMaxColumnsInIndex() throws SQLException {
      try {
         super.preForAll(methodObject4754, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4754, this.delegate.getMaxColumnsInIndex());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4754, this.onErrorForAll(methodObject4754, var2));
      }
   }

   public String getSchemaTerm() throws SQLException {
      try {
         super.preForAll(methodObject4778, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4778, (Object)this.delegate.getSchemaTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4778, this.onErrorForAll(methodObject4778, var2));
      }
   }

   public boolean supportsSubqueriesInIns() throws SQLException {
      try {
         super.preForAll(methodObject4871, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4871, this.delegate.supportsSubqueriesInIns());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4871, this.onErrorForAll(methodObject4871, var2));
      }
   }

   public boolean supportsSchemasInProcedureCalls() throws SQLException {
      try {
         super.preForAll(methodObject4863, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4863, this.delegate.supportsSchemasInProcedureCalls());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4863, this.onErrorForAll(methodObject4863, var2));
      }
   }

   public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
      try {
         super.preForAll(methodObject4851, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4851, this.delegate.supportsOpenStatementsAcrossRollback());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4851, this.onErrorForAll(methodObject4851, var2));
      }
   }

   public String getDriverName() throws SQLException {
      try {
         super.preForAll(methodObject4738, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4738, (Object)this.delegate.getDriverName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4738, this.onErrorForAll(methodObject4738, var2));
      }
   }

   public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
      try {
         super.preForAll(methodObject4719, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4719, this.delegate.autoCommitFailureClosesAllResultSets());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4719, this.onErrorForAll(methodObject4719, var2));
      }
   }

   public ResultSet getClientInfoProperties() throws SQLException {
      try {
         super.preForAll(methodObject4728, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject4728, this.proxyFactory.proxyForCache((Object)this.delegate.getClientInfoProperties(), this, this.proxyCache, methodObject4728));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject4728, this.onErrorForAll(methodObject4728, var2));
      }
   }

   public String getDatabaseProductName() throws SQLException {
      try {
         super.preForAll(methodObject4734, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4734, (Object)this.delegate.getDatabaseProductName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4734, this.onErrorForAll(methodObject4734, var2));
      }
   }

   public boolean supportsTableCorrelationNames() throws SQLException {
      try {
         super.preForAll(methodObject4873, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4873, this.delegate.supportsTableCorrelationNames());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4873, this.onErrorForAll(methodObject4873, var2));
      }
   }

   public boolean supportsResultSetHoldability(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4857, this, arg0);
         return (Boolean)this.postForAll(methodObject4857, this.delegate.supportsResultSetHoldability(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4857, this.onErrorForAll(methodObject4857, var3));
      }
   }

   public int getDatabaseMajorVersion() throws SQLException {
      try {
         super.preForAll(methodObject4732, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4732, this.delegate.getDatabaseMajorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4732, this.onErrorForAll(methodObject4732, var2));
      }
   }

   public int getMaxColumnsInSelect() throws SQLException {
      try {
         super.preForAll(methodObject4756, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4756, this.delegate.getMaxColumnsInSelect());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4756, this.onErrorForAll(methodObject4756, var2));
      }
   }

   public boolean supportsStoredProcedures() throws SQLException {
      try {
         super.preForAll(methodObject4868, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4868, this.delegate.supportsStoredProcedures());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4868, this.onErrorForAll(methodObject4868, var2));
      }
   }

   public boolean supportsSchemasInIndexDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject4861, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4861, this.delegate.supportsSchemasInIndexDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4861, this.onErrorForAll(methodObject4861, var2));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4881, this, arg0);
         return this.postForAll(methodObject4881, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject4881));
      } catch (SQLException var3) {
         return this.postForAll(methodObject4881, this.onErrorForAll(methodObject4881, var3));
      }
   }

   public ResultSet getExportedKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4740, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4740, this.proxyFactory.proxyForCache((Object)this.delegate.getExportedKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject4740));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4740, this.onErrorForAll(methodObject4740, var5));
      }
   }

   public int getDefaultTransactionIsolation() throws SQLException {
      try {
         super.preForAll(methodObject4735, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4735, this.delegate.getDefaultTransactionIsolation());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4735, this.onErrorForAll(methodObject4735, var2));
      }
   }

   public String getStringFunctions() throws SQLException {
      try {
         super.preForAll(methodObject4782, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4782, (Object)this.delegate.getStringFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4782, this.onErrorForAll(methodObject4782, var2));
      }
   }

   public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
      try {
         super.preForAll(methodObject4723, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4723, this.delegate.doesMaxRowSizeIncludeBlobs());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4723, this.onErrorForAll(methodObject4723, var2));
      }
   }

   public boolean supportsSchemasInTableDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject4864, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4864, this.delegate.supportsSchemasInTableDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4864, this.onErrorForAll(methodObject4864, var2));
      }
   }

   public boolean supportsIntegrityEnhancementFacility() throws SQLException {
      try {
         super.preForAll(methodObject4837, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4837, this.delegate.supportsIntegrityEnhancementFacility());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4837, this.onErrorForAll(methodObject4837, var2));
      }
   }

   public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
      try {
         super.preForAll(methodObject4720, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4720, this.delegate.dataDefinitionCausesTransactionCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4720, this.onErrorForAll(methodObject4720, var2));
      }
   }

   public boolean nullsAreSortedAtEnd() throws SQLException {
      try {
         super.preForAll(methodObject4796, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4796, this.delegate.nullsAreSortedAtEnd());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4796, this.onErrorForAll(methodObject4796, var2));
      }
   }

   public ResultSet getCatalogs() throws SQLException {
      try {
         super.preForAll(methodObject4716, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject4716, this.proxyFactory.proxyForCache((Object)this.delegate.getCatalogs(), this, this.proxyCache, methodObject4716));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject4716, this.onErrorForAll(methodObject4716, var2));
      }
   }

   public int getDriverMajorVersion() {
      super.preForAll(methodObject4736, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject4736, this.delegate.getDriverMajorVersion());
   }

   public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject4819, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4819, this.delegate.supportsCatalogsInPrivilegeDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4819, this.onErrorForAll(methodObject4819, var2));
      }
   }

   public ResultSet getSchemas(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject4780, this, arg0, arg1);
         return (ResultSet)this.postForAll(methodObject4780, this.proxyFactory.proxyForCache((Object)this.delegate.getSchemas(arg0, arg1), this, this.proxyCache, methodObject4780));
      } catch (SQLException var4) {
         return (ResultSet)this.postForAll(methodObject4780, this.onErrorForAll(methodObject4780, var4));
      }
   }

   public boolean isCatalogAtStart() throws SQLException {
      try {
         super.preForAll(methodObject4793, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4793, this.delegate.isCatalogAtStart());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4793, this.onErrorForAll(methodObject4793, var2));
      }
   }

   public ResultSet getTables(String arg0, String arg1, String arg2, String[] arg3) throws SQLException {
      try {
         super.preForAll(methodObject4714, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4714, this.proxyFactory.proxyForCache((Object)this.delegate.getTables(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4714));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4714, this.onErrorForAll(methodObject4714, var6));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4882, this, arg0);
         return (Boolean)this.postForAll(methodObject4882, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4882, this.onErrorForAll(methodObject4882, var3));
      }
   }

   public boolean ownDeletesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4803, this, arg0);
         return (Boolean)this.postForAll(methodObject4803, this.delegate.ownDeletesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4803, this.onErrorForAll(methodObject4803, var3));
      }
   }

   public int getMaxBinaryLiteralLength() throws SQLException {
      try {
         super.preForAll(methodObject4749, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4749, this.delegate.getMaxBinaryLiteralLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4749, this.onErrorForAll(methodObject4749, var2));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject4713, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4713, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4713, this.onErrorForAll(methodObject4713, var2));
      }
   }

   public ResultSet getPseudoColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject4774, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4774, this.proxyFactory.proxyForCache((Object)this.delegate.getPseudoColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4774));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4774, this.onErrorForAll(methodObject4774, var6));
      }
   }

   public boolean storesUpperCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4809, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4809, this.delegate.storesUpperCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4809, this.onErrorForAll(methodObject4809, var2));
      }
   }

   public boolean isReadOnly() throws SQLException {
      try {
         super.preForAll(methodObject4708, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4708, this.delegate.isReadOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4708, this.onErrorForAll(methodObject4708, var2));
      }
   }

   public boolean supportsDifferentTableCorrelationNames() throws SQLException {
      try {
         super.preForAll(methodObject4829, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4829, this.delegate.supportsDifferentTableCorrelationNames());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4829, this.onErrorForAll(methodObject4829, var2));
      }
   }

   public boolean supportsGetGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject4833, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4833, this.delegate.supportsGetGeneratedKeys());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4833, this.onErrorForAll(methodObject4833, var2));
      }
   }

   public int getMaxTableNameLength() throws SQLException {
      try {
         super.preForAll(methodObject4766, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4766, this.delegate.getMaxTableNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4766, this.onErrorForAll(methodObject4766, var2));
      }
   }

   public boolean deletesAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4722, this, arg0);
         return (Boolean)this.postForAll(methodObject4722, this.delegate.deletesAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4722, this.onErrorForAll(methodObject4722, var3));
      }
   }

   public ResultSet getTypeInfo() throws SQLException {
      try {
         super.preForAll(methodObject4789, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject4789, this.proxyFactory.proxyForCache((Object)this.delegate.getTypeInfo(), this, this.proxyCache, methodObject4789));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject4789, this.onErrorForAll(methodObject4789, var2));
      }
   }

   public int getMaxTablesInSelect() throws SQLException {
      try {
         super.preForAll(methodObject4767, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4767, this.delegate.getMaxTablesInSelect());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4767, this.onErrorForAll(methodObject4767, var2));
      }
   }

   public ResultSet getFunctionColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject4742, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4742, this.proxyFactory.proxyForCache((Object)this.delegate.getFunctionColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4742));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4742, this.onErrorForAll(methodObject4742, var6));
      }
   }

   public boolean supportsUnion() throws SQLException {
      try {
         super.preForAll(methodObject4876, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4876, this.delegate.supportsUnion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4876, this.onErrorForAll(methodObject4876, var2));
      }
   }

   public boolean supportsSubqueriesInExists() throws SQLException {
      try {
         super.preForAll(methodObject4870, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4870, this.delegate.supportsSubqueriesInExists());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4870, this.onErrorForAll(methodObject4870, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4883, this, arg0);
      Method var10001 = methodObject4883;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public boolean supportsOrderByUnrelated() throws SQLException {
      try {
         super.preForAll(methodObject4852, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4852, this.delegate.supportsOrderByUnrelated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4852, this.onErrorForAll(methodObject4852, var2));
      }
   }

   public boolean usesLocalFiles() throws SQLException {
      try {
         super.preForAll(methodObject4880, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4880, this.delegate.usesLocalFiles());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4880, this.onErrorForAll(methodObject4880, var2));
      }
   }

   public boolean supportsANSI92IntermediateSQL() throws SQLException {
      try {
         super.preForAll(methodObject4813, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4813, this.delegate.supportsANSI92IntermediateSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4813, this.onErrorForAll(methodObject4813, var2));
      }
   }

   public String getNumericFunctions() throws SQLException {
      try {
         super.preForAll(methodObject4769, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4769, (Object)this.delegate.getNumericFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4769, this.onErrorForAll(methodObject4769, var2));
      }
   }

   public int getSQLStateType() throws SQLException {
      try {
         super.preForAll(methodObject4777, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4777, this.delegate.getSQLStateType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4777, this.onErrorForAll(methodObject4777, var2));
      }
   }

   public int getMaxStatementLength() throws SQLException {
      try {
         super.preForAll(methodObject4764, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4764, this.delegate.getMaxStatementLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4764, this.onErrorForAll(methodObject4764, var2));
      }
   }

   public String getTimeDateFunctions() throws SQLException {
      try {
         super.preForAll(methodObject4788, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4788, (Object)this.delegate.getTimeDateFunctions());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4788, this.onErrorForAll(methodObject4788, var2));
      }
   }

   public boolean supportsSchemasInDataManipulation() throws SQLException {
      try {
         super.preForAll(methodObject4860, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4860, this.delegate.supportsSchemasInDataManipulation());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4860, this.onErrorForAll(methodObject4860, var2));
      }
   }

   public boolean supportsPositionedUpdate() throws SQLException {
      try {
         super.preForAll(methodObject4855, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4855, this.delegate.supportsPositionedUpdate());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4855, this.onErrorForAll(methodObject4855, var2));
      }
   }

   public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4715, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4715, this.delegate.storesMixedCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4715, this.onErrorForAll(methodObject4715, var2));
      }
   }

   public boolean supportsMixedCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4841, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4841, this.delegate.supportsMixedCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4841, this.onErrorForAll(methodObject4841, var2));
      }
   }

   public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4810, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4810, this.delegate.storesUpperCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4810, this.onErrorForAll(methodObject4810, var2));
      }
   }

   public boolean supportsCoreSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject4825, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4825, this.delegate.supportsCoreSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4825, this.onErrorForAll(methodObject4825, var2));
      }
   }

   public int getDatabaseMinorVersion() throws SQLException {
      try {
         super.preForAll(methodObject4733, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4733, this.delegate.getDatabaseMinorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4733, this.onErrorForAll(methodObject4733, var2));
      }
   }

   public int getMaxRowSize() throws SQLException {
      try {
         super.preForAll(methodObject4762, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4762, this.delegate.getMaxRowSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4762, this.onErrorForAll(methodObject4762, var2));
      }
   }

   public boolean nullsAreSortedLow() throws SQLException {
      try {
         super.preForAll(methodObject4799, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4799, this.delegate.nullsAreSortedLow());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4799, this.onErrorForAll(methodObject4799, var2));
      }
   }

   public boolean supportsNamedParameters() throws SQLException {
      try {
         super.preForAll(methodObject4846, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4846, this.delegate.supportsNamedParameters());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4846, this.onErrorForAll(methodObject4846, var2));
      }
   }

   public String getURL() throws SQLException {
      try {
         super.preForAll(methodObject4707, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4707, (Object)this.delegate.getURL());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4707, this.onErrorForAll(methodObject4707, var2));
      }
   }

   public boolean supportsTransactions() throws SQLException {
      try {
         super.preForAll(methodObject4875, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4875, this.delegate.supportsTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4875, this.onErrorForAll(methodObject4875, var2));
      }
   }

   public boolean othersUpdatesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4802, this, arg0);
         return (Boolean)this.postForAll(methodObject4802, this.delegate.othersUpdatesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4802, this.onErrorForAll(methodObject4802, var3));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject4712, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject4712, this.proxyFactory.proxyForCache((Object)this.delegate.getConnection(), this, this.proxyCache, methodObject4712));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject4712, this.onErrorForAll(methodObject4712, var2));
      }
   }

   public String getExtraNameCharacters() throws SQLException {
      try {
         super.preForAll(methodObject4741, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4741, (Object)this.delegate.getExtraNameCharacters());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4741, this.onErrorForAll(methodObject4741, var2));
      }
   }

   public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4842, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4842, this.delegate.supportsMixedCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4842, this.onErrorForAll(methodObject4842, var2));
      }
   }

   public boolean ownUpdatesAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4805, this, arg0);
         return (Boolean)this.postForAll(methodObject4805, this.delegate.ownUpdatesAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4805, this.onErrorForAll(methodObject4805, var3));
      }
   }

   public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4807, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4807, this.delegate.storesLowerCaseQuotedIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4807, this.onErrorForAll(methodObject4807, var2));
      }
   }

   public boolean supportsExtendedSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject4831, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4831, this.delegate.supportsExtendedSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4831, this.onErrorForAll(methodObject4831, var2));
      }
   }

   public boolean supportsConvert() throws SQLException {
      try {
         super.preForAll(methodObject4823, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4823, this.delegate.supportsConvert());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4823, this.onErrorForAll(methodObject4823, var2));
      }
   }

   public boolean supportsANSI92FullSQL() throws SQLException {
      try {
         super.preForAll(methodObject4812, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4812, this.delegate.supportsANSI92FullSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4812, this.onErrorForAll(methodObject4812, var2));
      }
   }

   public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
      try {
         super.preForAll(methodObject4867, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4867, this.delegate.supportsStoredFunctionsUsingCallSyntax());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4867, this.onErrorForAll(methodObject4867, var2));
      }
   }

   public ResultSet getIndexInfo(String arg0, String arg1, String arg2, boolean arg3, boolean arg4) throws SQLException {
      try {
         super.preForAll(methodObject4746, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject4746, this.proxyFactory.proxyForCache((Object)this.delegate.getIndexInfo(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject4746));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject4746, this.onErrorForAll(methodObject4746, var7));
      }
   }

   public int getMaxCursorNameLength() throws SQLException {
      try {
         super.preForAll(methodObject4759, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4759, this.delegate.getMaxCursorNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4759, this.onErrorForAll(methodObject4759, var2));
      }
   }

   public int getJDBCMinorVersion() throws SQLException {
      try {
         super.preForAll(methodObject4748, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4748, this.delegate.getJDBCMinorVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4748, this.onErrorForAll(methodObject4748, var2));
      }
   }

   public ResultSet getVersionColumns(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4791, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4791, this.proxyFactory.proxyForCache((Object)this.delegate.getVersionColumns(arg0, arg1, arg2), this, this.proxyCache, methodObject4791));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4791, this.onErrorForAll(methodObject4791, var5));
      }
   }

   public boolean supportsNonNullableColumns() throws SQLException {
      try {
         super.preForAll(methodObject4847, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4847, this.delegate.supportsNonNullableColumns());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4847, this.onErrorForAll(methodObject4847, var2));
      }
   }

   public boolean supportsLikeEscapeClause() throws SQLException {
      try {
         super.preForAll(methodObject4838, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4838, this.delegate.supportsLikeEscapeClause());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4838, this.onErrorForAll(methodObject4838, var2));
      }
   }

   public boolean supportsCorrelatedSubqueries() throws SQLException {
      try {
         super.preForAll(methodObject4826, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4826, this.delegate.supportsCorrelatedSubqueries());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4826, this.onErrorForAll(methodObject4826, var2));
      }
   }

   public String getProcedureTerm() throws SQLException {
      try {
         super.preForAll(methodObject4772, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4772, (Object)this.delegate.getProcedureTerm());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4772, this.onErrorForAll(methodObject4772, var2));
      }
   }

   public boolean nullsAreSortedHigh() throws SQLException {
      try {
         super.preForAll(methodObject4798, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4798, this.delegate.nullsAreSortedHigh());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4798, this.onErrorForAll(methodObject4798, var2));
      }
   }

   public boolean othersInsertsAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4801, this, arg0);
         return (Boolean)this.postForAll(methodObject4801, this.delegate.othersInsertsAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4801, this.onErrorForAll(methodObject4801, var3));
      }
   }

   public boolean supportsSavepoints() throws SQLException {
      try {
         super.preForAll(methodObject4859, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4859, this.delegate.supportsSavepoints());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4859, this.onErrorForAll(methodObject4859, var2));
      }
   }

   public int getMaxCatalogNameLength() throws SQLException {
      try {
         super.preForAll(methodObject4750, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4750, this.delegate.getMaxCatalogNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4750, this.onErrorForAll(methodObject4750, var2));
      }
   }

   public ResultSet getImportedKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4745, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4745, this.proxyFactory.proxyForCache((Object)this.delegate.getImportedKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject4745));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4745, this.onErrorForAll(methodObject4745, var5));
      }
   }

   public boolean supportsBatchUpdates() throws SQLException {
      try {
         super.preForAll(methodObject4816, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4816, this.delegate.supportsBatchUpdates());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4816, this.onErrorForAll(methodObject4816, var2));
      }
   }

   public ResultSet getCrossReference(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws SQLException {
      try {
         super.preForAll(methodObject4731, this, arg0, arg1, arg2, arg3, arg4, arg5);
         return (ResultSet)this.postForAll(methodObject4731, this.proxyFactory.proxyForCache((Object)this.delegate.getCrossReference(arg0, arg1, arg2, arg3, arg4, arg5), this, this.proxyCache, methodObject4731));
      } catch (SQLException var8) {
         return (ResultSet)this.postForAll(methodObject4731, this.onErrorForAll(methodObject4731, var8));
      }
   }

   public boolean supportsExpressionsInOrderBy() throws SQLException {
      try {
         super.preForAll(methodObject4830, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4830, this.delegate.supportsExpressionsInOrderBy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4830, this.onErrorForAll(methodObject4830, var2));
      }
   }

   public ResultSet getProcedureColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject4771, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4771, this.proxyFactory.proxyForCache((Object)this.delegate.getProcedureColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4771));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4771, this.onErrorForAll(methodObject4771, var6));
      }
   }

   public ResultSet getPrimaryKeys(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4770, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4770, this.proxyFactory.proxyForCache((Object)this.delegate.getPrimaryKeys(arg0, arg1, arg2), this, this.proxyCache, methodObject4770));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4770, this.onErrorForAll(methodObject4770, var5));
      }
   }

   public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
      try {
         super.preForAll(methodObject4721, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4721, this.delegate.dataDefinitionIgnoredInTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4721, this.onErrorForAll(methodObject4721, var2));
      }
   }

   public boolean supportsOuterJoins() throws SQLException {
      try {
         super.preForAll(methodObject4853, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4853, this.delegate.supportsOuterJoins());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4853, this.onErrorForAll(methodObject4853, var2));
      }
   }

   public boolean nullsAreSortedAtStart() throws SQLException {
      try {
         super.preForAll(methodObject4797, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4797, this.delegate.nullsAreSortedAtStart());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4797, this.onErrorForAll(methodObject4797, var2));
      }
   }

   public ResultSet getAttributes(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject4709, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4709, this.proxyFactory.proxyForCache((Object)this.delegate.getAttributes(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4709));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4709, this.onErrorForAll(methodObject4709, var6));
      }
   }

   public ResultSet getSuperTypes(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4784, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4784, this.proxyFactory.proxyForCache((Object)this.delegate.getSuperTypes(arg0, arg1, arg2), this, this.proxyCache, methodObject4784));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4784, this.onErrorForAll(methodObject4784, var5));
      }
   }

   public boolean supportsUnionAll() throws SQLException {
      try {
         super.preForAll(methodObject4877, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4877, this.delegate.supportsUnionAll());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4877, this.onErrorForAll(methodObject4877, var2));
      }
   }

   public boolean allProceduresAreCallable() throws SQLException {
      try {
         super.preForAll(methodObject4717, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4717, this.delegate.allProceduresAreCallable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4717, this.onErrorForAll(methodObject4717, var2));
      }
   }

   public boolean supportsConvert(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject4824, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject4824, this.delegate.supportsConvert(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject4824, this.onErrorForAll(methodObject4824, var4));
      }
   }

   public long getLobMaxLength() throws SQLException {
      try {
         super.preForAll(methodObject4706, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject4706, this.delegate.getLobMaxLength());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject4706, this.onErrorForAll(methodObject4706, var2));
      }
   }

   public boolean supportsCatalogsInDataManipulation() throws SQLException {
      try {
         super.preForAll(methodObject4817, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4817, this.delegate.supportsCatalogsInDataManipulation());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4817, this.onErrorForAll(methodObject4817, var2));
      }
   }

   public RowIdLifetime getRowIdLifetime() throws SQLException {
      try {
         super.preForAll(methodObject4775, this, zeroLengthObjectArray);
         return (RowIdLifetime)this.postForAll(methodObject4775, (Object)this.delegate.getRowIdLifetime());
      } catch (SQLException var2) {
         return (RowIdLifetime)this.postForAll(methodObject4775, this.onErrorForAll(methodObject4775, var2));
      }
   }

   public ResultSet getUDTs(String arg0, String arg1, String arg2, int[] arg3) throws SQLException {
      try {
         super.preForAll(methodObject4790, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4790, this.proxyFactory.proxyForCache((Object)this.delegate.getUDTs(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4790));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4790, this.onErrorForAll(methodObject4790, var6));
      }
   }

   public ResultSet getBestRowIdentifier(String arg0, String arg1, String arg2, int arg3, boolean arg4) throws SQLException {
      try {
         super.preForAll(methodObject4725, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject4725, this.proxyFactory.proxyForCache((Object)this.delegate.getBestRowIdentifier(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject4725));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject4725, this.onErrorForAll(methodObject4725, var7));
      }
   }

   public String getDatabaseProductVersion() throws SQLException {
      try {
         super.preForAll(methodObject4710, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4710, (Object)this.delegate.getDatabaseProductVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4710, this.onErrorForAll(methodObject4710, var2));
      }
   }

   public ResultSet getTablePrivileges(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4786, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4786, this.proxyFactory.proxyForCache((Object)this.delegate.getTablePrivileges(arg0, arg1, arg2), this, this.proxyCache, methodObject4786));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4786, this.onErrorForAll(methodObject4786, var5));
      }
   }

   public int getMaxProcedureNameLength() throws SQLException {
      try {
         super.preForAll(methodObject4761, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4761, this.delegate.getMaxProcedureNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4761, this.onErrorForAll(methodObject4761, var2));
      }
   }

   public boolean storesMixedCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4808, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4808, this.delegate.storesMixedCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4808, this.onErrorForAll(methodObject4808, var2));
      }
   }

   public boolean supportsColumnAliasing() throws SQLException {
      try {
         super.preForAll(methodObject4822, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4822, this.delegate.supportsColumnAliasing());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4822, this.onErrorForAll(methodObject4822, var2));
      }
   }

   public boolean supportsAlterTableWithDropColumn() throws SQLException {
      try {
         super.preForAll(methodObject4815, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4815, this.delegate.supportsAlterTableWithDropColumn());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4815, this.onErrorForAll(methodObject4815, var2));
      }
   }

   public boolean supportsResultSetConcurrency(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject4856, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject4856, this.delegate.supportsResultSetConcurrency(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject4856, this.onErrorForAll(methodObject4856, var4));
      }
   }

   public boolean generatedKeyAlwaysReturned() throws SQLException {
      try {
         super.preForAll(methodObject4724, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4724, this.delegate.generatedKeyAlwaysReturned());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4724, this.onErrorForAll(methodObject4724, var2));
      }
   }

   public boolean supportsMultipleTransactions() throws SQLException {
      try {
         super.preForAll(methodObject4845, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4845, this.delegate.supportsMultipleTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4845, this.onErrorForAll(methodObject4845, var2));
      }
   }

   public ResultSet getSuperTables(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4783, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4783, this.proxyFactory.proxyForCache((Object)this.delegate.getSuperTables(arg0, arg1, arg2), this, this.proxyCache, methodObject4783));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4783, this.onErrorForAll(methodObject4783, var5));
      }
   }

   public boolean supportsGroupBy() throws SQLException {
      try {
         super.preForAll(methodObject4834, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4834, this.delegate.supportsGroupBy());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4834, this.onErrorForAll(methodObject4834, var2));
      }
   }

   public int getMaxColumnsInTable() throws SQLException {
      try {
         super.preForAll(methodObject4757, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4757, this.delegate.getMaxColumnsInTable());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4757, this.onErrorForAll(methodObject4757, var2));
      }
   }

   public int getMaxColumnsInOrderBy() throws SQLException {
      try {
         super.preForAll(methodObject4755, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4755, this.delegate.getMaxColumnsInOrderBy());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4755, this.onErrorForAll(methodObject4755, var2));
      }
   }

   public ResultSet getFunctions(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4743, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4743, this.proxyFactory.proxyForCache((Object)this.delegate.getFunctions(arg0, arg1, arg2), this, this.proxyCache, methodObject4743));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4743, this.onErrorForAll(methodObject4743, var5));
      }
   }

   public boolean updatesAreDetected(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4878, this, arg0);
         return (Boolean)this.postForAll(methodObject4878, this.delegate.updatesAreDetected(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4878, this.onErrorForAll(methodObject4878, var3));
      }
   }

   public int getMaxConnections() throws SQLException {
      try {
         super.preForAll(methodObject4758, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4758, this.delegate.getMaxConnections());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4758, this.onErrorForAll(methodObject4758, var2));
      }
   }

   public boolean allTablesAreSelectable() throws SQLException {
      try {
         super.preForAll(methodObject4718, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4718, this.delegate.allTablesAreSelectable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4718, this.onErrorForAll(methodObject4718, var2));
      }
   }

   public ResultSet getTableTypes() throws SQLException {
      try {
         super.preForAll(methodObject4787, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject4787, this.proxyFactory.proxyForCache((Object)this.delegate.getTableTypes(), this, this.proxyCache, methodObject4787));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject4787, this.onErrorForAll(methodObject4787, var2));
      }
   }

   public boolean nullPlusNonNullIsNull() throws SQLException {
      try {
         super.preForAll(methodObject4795, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4795, this.delegate.nullPlusNonNullIsNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4795, this.onErrorForAll(methodObject4795, var2));
      }
   }

   public boolean supportsSubqueriesInComparisons() throws SQLException {
      try {
         super.preForAll(methodObject4869, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4869, this.delegate.supportsSubqueriesInComparisons());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4869, this.onErrorForAll(methodObject4869, var2));
      }
   }

   public int getMaxIndexLength() throws SQLException {
      try {
         super.preForAll(methodObject4760, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4760, this.delegate.getMaxIndexLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4760, this.onErrorForAll(methodObject4760, var2));
      }
   }

   public boolean supportsSubqueriesInQuantifieds() throws SQLException {
      try {
         super.preForAll(methodObject4872, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4872, this.delegate.supportsSubqueriesInQuantifieds());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4872, this.onErrorForAll(methodObject4872, var2));
      }
   }

   public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
      try {
         super.preForAll(methodObject4850, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4850, this.delegate.supportsOpenStatementsAcrossCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4850, this.onErrorForAll(methodObject4850, var2));
      }
   }

   public boolean supportsCatalogsInTableDefinitions() throws SQLException {
      try {
         super.preForAll(methodObject4821, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4821, this.delegate.supportsCatalogsInTableDefinitions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4821, this.onErrorForAll(methodObject4821, var2));
      }
   }

   public boolean supportsGroupByBeyondSelect() throws SQLException {
      try {
         super.preForAll(methodObject4835, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4835, this.delegate.supportsGroupByBeyondSelect());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4835, this.onErrorForAll(methodObject4835, var2));
      }
   }

   public boolean supportsStatementPooling() throws SQLException {
      try {
         super.preForAll(methodObject4866, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4866, this.delegate.supportsStatementPooling());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4866, this.onErrorForAll(methodObject4866, var2));
      }
   }

   public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
      try {
         super.preForAll(methodObject4827, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4827, this.delegate.supportsDataDefinitionAndDataManipulationTransactions());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4827, this.onErrorForAll(methodObject4827, var2));
      }
   }

   public boolean supportsMultipleOpenResults() throws SQLException {
      try {
         super.preForAll(methodObject4843, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4843, this.delegate.supportsMultipleOpenResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4843, this.onErrorForAll(methodObject4843, var2));
      }
   }

   public int getMaxColumnsInGroupBy() throws SQLException {
      try {
         super.preForAll(methodObject4753, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4753, this.delegate.getMaxColumnsInGroupBy());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4753, this.onErrorForAll(methodObject4753, var2));
      }
   }

   public int getMaxColumnNameLength() throws SQLException {
      try {
         super.preForAll(methodObject4752, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4752, this.delegate.getMaxColumnNameLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4752, this.onErrorForAll(methodObject4752, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject4884, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4884, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4884));
   }

   public int getMaxStatements() throws SQLException {
      try {
         super.preForAll(methodObject4765, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4765, this.delegate.getMaxStatements());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4765, this.onErrorForAll(methodObject4765, var2));
      }
   }

   public boolean supportsAlterTableWithAddColumn() throws SQLException {
      try {
         super.preForAll(methodObject4814, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4814, this.delegate.supportsAlterTableWithAddColumn());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4814, this.onErrorForAll(methodObject4814, var2));
      }
   }

   public boolean supportsGroupByUnrelated() throws SQLException {
      try {
         super.preForAll(methodObject4836, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4836, this.delegate.supportsGroupByUnrelated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4836, this.onErrorForAll(methodObject4836, var2));
      }
   }

   public boolean supportsANSI92EntryLevelSQL() throws SQLException {
      try {
         super.preForAll(methodObject4811, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4811, this.delegate.supportsANSI92EntryLevelSQL());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4811, this.onErrorForAll(methodObject4811, var2));
      }
   }

   public ResultSet getColumns(String arg0, String arg1, String arg2, String arg3) throws SQLException {
      try {
         super.preForAll(methodObject4730, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject4730, this.proxyFactory.proxyForCache((Object)this.delegate.getColumns(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject4730));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject4730, this.onErrorForAll(methodObject4730, var6));
      }
   }

   public boolean supportsMinimumSQLGrammar() throws SQLException {
      try {
         super.preForAll(methodObject4840, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4840, this.delegate.supportsMinimumSQLGrammar());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4840, this.onErrorForAll(methodObject4840, var2));
      }
   }

   public int getMaxCharLiteralLength() throws SQLException {
      try {
         super.preForAll(methodObject4751, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4751, this.delegate.getMaxCharLiteralLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4751, this.onErrorForAll(methodObject4751, var2));
      }
   }

   public boolean ownInsertsAreVisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4804, this, arg0);
         return (Boolean)this.postForAll(methodObject4804, this.delegate.ownInsertsAreVisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4804, this.onErrorForAll(methodObject4804, var3));
      }
   }

   public boolean storesLowerCaseIdentifiers() throws SQLException {
      try {
         super.preForAll(methodObject4806, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4806, this.delegate.storesLowerCaseIdentifiers());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4806, this.onErrorForAll(methodObject4806, var2));
      }
   }

   public boolean supportsMultipleResultSets() throws SQLException {
      try {
         super.preForAll(methodObject4844, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4844, this.delegate.supportsMultipleResultSets());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4844, this.onErrorForAll(methodObject4844, var2));
      }
   }

   public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
      try {
         super.preForAll(methodObject4849, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4849, this.delegate.supportsOpenCursorsAcrossRollback());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4849, this.onErrorForAll(methodObject4849, var2));
      }
   }

   public boolean supportsSelectForUpdate() throws SQLException {
      try {
         super.preForAll(methodObject4865, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4865, this.delegate.supportsSelectForUpdate());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4865, this.onErrorForAll(methodObject4865, var2));
      }
   }

   public boolean supportsPositionedDelete() throws SQLException {
      try {
         super.preForAll(methodObject4854, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4854, this.delegate.supportsPositionedDelete());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4854, this.onErrorForAll(methodObject4854, var2));
      }
   }

   public boolean supportsCatalogsInProcedureCalls() throws SQLException {
      try {
         super.preForAll(methodObject4820, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4820, this.delegate.supportsCatalogsInProcedureCalls());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4820, this.onErrorForAll(methodObject4820, var2));
      }
   }

   public ResultSet getProcedures(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject4773, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject4773, this.proxyFactory.proxyForCache((Object)this.delegate.getProcedures(arg0, arg1, arg2), this, this.proxyCache, methodObject4773));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject4773, this.onErrorForAll(methodObject4773, var5));
      }
   }

   public String getCatalogSeparator() throws SQLException {
      try {
         super.preForAll(methodObject4726, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4726, (Object)this.delegate.getCatalogSeparator());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4726, this.onErrorForAll(methodObject4726, var2));
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
         methodObject4800 = DatabaseMetaData.class.getDeclaredMethod("othersDeletesAreVisible", Integer.TYPE);
         methodObject4747 = DatabaseMetaData.class.getDeclaredMethod("getJDBCMajorVersion");
         methodObject4848 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenCursorsAcrossCommit");
         methodObject4818 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInIndexDefinitions");
         methodObject4737 = DatabaseMetaData.class.getDeclaredMethod("getDriverMinorVersion");
         methodObject4792 = DatabaseMetaData.class.getDeclaredMethod("insertsAreDetected", Integer.TYPE);
         methodObject4727 = DatabaseMetaData.class.getDeclaredMethod("getCatalogTerm");
         methodObject4839 = DatabaseMetaData.class.getDeclaredMethod("supportsLimitedOuterJoins");
         methodObject4858 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetType", Integer.TYPE);
         methodObject4779 = DatabaseMetaData.class.getDeclaredMethod("getSchemas");
         methodObject4744 = DatabaseMetaData.class.getDeclaredMethod("getIdentifierQuoteString");
         methodObject4828 = DatabaseMetaData.class.getDeclaredMethod("supportsDataManipulationTransactionsOnly");
         methodObject4781 = DatabaseMetaData.class.getDeclaredMethod("getSearchStringEscape");
         methodObject4729 = DatabaseMetaData.class.getDeclaredMethod("getColumnPrivileges", String.class, String.class, String.class, String.class);
         methodObject4862 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInPrivilegeDefinitions");
         methodObject4763 = DatabaseMetaData.class.getDeclaredMethod("getMaxSchemaNameLength");
         methodObject4832 = DatabaseMetaData.class.getDeclaredMethod("supportsFullOuterJoins");
         methodObject4794 = DatabaseMetaData.class.getDeclaredMethod("locatorsUpdateCopy");
         methodObject4705 = oracle.jdbc.AdditionalDatabaseMetaData.class.getDeclaredMethod("getOracleTypeMetaData", String.class);
         methodObject4785 = DatabaseMetaData.class.getDeclaredMethod("getSystemFunctions");
         methodObject4879 = DatabaseMetaData.class.getDeclaredMethod("usesLocalFilePerTable");
         methodObject4874 = DatabaseMetaData.class.getDeclaredMethod("supportsTransactionIsolationLevel", Integer.TYPE);
         methodObject4776 = DatabaseMetaData.class.getDeclaredMethod("getSQLKeywords");
         methodObject4711 = DatabaseMetaData.class.getDeclaredMethod("getUserName");
         methodObject4768 = DatabaseMetaData.class.getDeclaredMethod("getMaxUserNameLength");
         methodObject4739 = DatabaseMetaData.class.getDeclaredMethod("getDriverVersion");
         methodObject4754 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInIndex");
         methodObject4778 = DatabaseMetaData.class.getDeclaredMethod("getSchemaTerm");
         methodObject4871 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInIns");
         methodObject4863 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInProcedureCalls");
         methodObject4851 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenStatementsAcrossRollback");
         methodObject4738 = DatabaseMetaData.class.getDeclaredMethod("getDriverName");
         methodObject4719 = DatabaseMetaData.class.getDeclaredMethod("autoCommitFailureClosesAllResultSets");
         methodObject4728 = DatabaseMetaData.class.getDeclaredMethod("getClientInfoProperties");
         methodObject4734 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseProductName");
         methodObject4873 = DatabaseMetaData.class.getDeclaredMethod("supportsTableCorrelationNames");
         methodObject4857 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetHoldability", Integer.TYPE);
         methodObject4732 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseMajorVersion");
         methodObject4756 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInSelect");
         methodObject4868 = DatabaseMetaData.class.getDeclaredMethod("supportsStoredProcedures");
         methodObject4861 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInIndexDefinitions");
         methodObject4881 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject4740 = DatabaseMetaData.class.getDeclaredMethod("getExportedKeys", String.class, String.class, String.class);
         methodObject4735 = DatabaseMetaData.class.getDeclaredMethod("getDefaultTransactionIsolation");
         methodObject4782 = DatabaseMetaData.class.getDeclaredMethod("getStringFunctions");
         methodObject4723 = DatabaseMetaData.class.getDeclaredMethod("doesMaxRowSizeIncludeBlobs");
         methodObject4864 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInTableDefinitions");
         methodObject4837 = DatabaseMetaData.class.getDeclaredMethod("supportsIntegrityEnhancementFacility");
         methodObject4720 = DatabaseMetaData.class.getDeclaredMethod("dataDefinitionCausesTransactionCommit");
         methodObject4796 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedAtEnd");
         methodObject4716 = DatabaseMetaData.class.getDeclaredMethod("getCatalogs");
         methodObject4736 = DatabaseMetaData.class.getDeclaredMethod("getDriverMajorVersion");
         methodObject4819 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInPrivilegeDefinitions");
         methodObject4780 = DatabaseMetaData.class.getDeclaredMethod("getSchemas", String.class, String.class);
         methodObject4793 = DatabaseMetaData.class.getDeclaredMethod("isCatalogAtStart");
         methodObject4714 = DatabaseMetaData.class.getDeclaredMethod("getTables", String.class, String.class, String.class, String[].class);
         methodObject4882 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject4803 = DatabaseMetaData.class.getDeclaredMethod("ownDeletesAreVisible", Integer.TYPE);
         methodObject4749 = DatabaseMetaData.class.getDeclaredMethod("getMaxBinaryLiteralLength");
         methodObject4713 = DatabaseMetaData.class.getDeclaredMethod("getResultSetHoldability");
         methodObject4774 = DatabaseMetaData.class.getDeclaredMethod("getPseudoColumns", String.class, String.class, String.class, String.class);
         methodObject4809 = DatabaseMetaData.class.getDeclaredMethod("storesUpperCaseIdentifiers");
         methodObject4708 = DatabaseMetaData.class.getDeclaredMethod("isReadOnly");
         methodObject4829 = DatabaseMetaData.class.getDeclaredMethod("supportsDifferentTableCorrelationNames");
         methodObject4833 = DatabaseMetaData.class.getDeclaredMethod("supportsGetGeneratedKeys");
         methodObject4766 = DatabaseMetaData.class.getDeclaredMethod("getMaxTableNameLength");
         methodObject4722 = DatabaseMetaData.class.getDeclaredMethod("deletesAreDetected", Integer.TYPE);
         methodObject4789 = DatabaseMetaData.class.getDeclaredMethod("getTypeInfo");
         methodObject4767 = DatabaseMetaData.class.getDeclaredMethod("getMaxTablesInSelect");
         methodObject4742 = DatabaseMetaData.class.getDeclaredMethod("getFunctionColumns", String.class, String.class, String.class, String.class);
         methodObject4876 = DatabaseMetaData.class.getDeclaredMethod("supportsUnion");
         methodObject4870 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInExists");
         methodObject4883 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4852 = DatabaseMetaData.class.getDeclaredMethod("supportsOrderByUnrelated");
         methodObject4880 = DatabaseMetaData.class.getDeclaredMethod("usesLocalFiles");
         methodObject4813 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92IntermediateSQL");
         methodObject4769 = DatabaseMetaData.class.getDeclaredMethod("getNumericFunctions");
         methodObject4777 = DatabaseMetaData.class.getDeclaredMethod("getSQLStateType");
         methodObject4764 = DatabaseMetaData.class.getDeclaredMethod("getMaxStatementLength");
         methodObject4788 = DatabaseMetaData.class.getDeclaredMethod("getTimeDateFunctions");
         methodObject4860 = DatabaseMetaData.class.getDeclaredMethod("supportsSchemasInDataManipulation");
         methodObject4855 = DatabaseMetaData.class.getDeclaredMethod("supportsPositionedUpdate");
         methodObject4715 = DatabaseMetaData.class.getDeclaredMethod("storesMixedCaseQuotedIdentifiers");
         methodObject4841 = DatabaseMetaData.class.getDeclaredMethod("supportsMixedCaseIdentifiers");
         methodObject4810 = DatabaseMetaData.class.getDeclaredMethod("storesUpperCaseQuotedIdentifiers");
         methodObject4825 = DatabaseMetaData.class.getDeclaredMethod("supportsCoreSQLGrammar");
         methodObject4733 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseMinorVersion");
         methodObject4762 = DatabaseMetaData.class.getDeclaredMethod("getMaxRowSize");
         methodObject4799 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedLow");
         methodObject4846 = DatabaseMetaData.class.getDeclaredMethod("supportsNamedParameters");
         methodObject4707 = DatabaseMetaData.class.getDeclaredMethod("getURL");
         methodObject4875 = DatabaseMetaData.class.getDeclaredMethod("supportsTransactions");
         methodObject4802 = DatabaseMetaData.class.getDeclaredMethod("othersUpdatesAreVisible", Integer.TYPE);
         methodObject4712 = DatabaseMetaData.class.getDeclaredMethod("getConnection");
         methodObject4741 = DatabaseMetaData.class.getDeclaredMethod("getExtraNameCharacters");
         methodObject4842 = DatabaseMetaData.class.getDeclaredMethod("supportsMixedCaseQuotedIdentifiers");
         methodObject4805 = DatabaseMetaData.class.getDeclaredMethod("ownUpdatesAreVisible", Integer.TYPE);
         methodObject4807 = DatabaseMetaData.class.getDeclaredMethod("storesLowerCaseQuotedIdentifiers");
         methodObject4831 = DatabaseMetaData.class.getDeclaredMethod("supportsExtendedSQLGrammar");
         methodObject4823 = DatabaseMetaData.class.getDeclaredMethod("supportsConvert");
         methodObject4812 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92FullSQL");
         methodObject4867 = DatabaseMetaData.class.getDeclaredMethod("supportsStoredFunctionsUsingCallSyntax");
         methodObject4746 = DatabaseMetaData.class.getDeclaredMethod("getIndexInfo", String.class, String.class, String.class, Boolean.TYPE, Boolean.TYPE);
         methodObject4759 = DatabaseMetaData.class.getDeclaredMethod("getMaxCursorNameLength");
         methodObject4748 = DatabaseMetaData.class.getDeclaredMethod("getJDBCMinorVersion");
         methodObject4791 = DatabaseMetaData.class.getDeclaredMethod("getVersionColumns", String.class, String.class, String.class);
         methodObject4847 = DatabaseMetaData.class.getDeclaredMethod("supportsNonNullableColumns");
         methodObject4838 = DatabaseMetaData.class.getDeclaredMethod("supportsLikeEscapeClause");
         methodObject4826 = DatabaseMetaData.class.getDeclaredMethod("supportsCorrelatedSubqueries");
         methodObject4772 = DatabaseMetaData.class.getDeclaredMethod("getProcedureTerm");
         methodObject4798 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedHigh");
         methodObject4801 = DatabaseMetaData.class.getDeclaredMethod("othersInsertsAreVisible", Integer.TYPE);
         methodObject4859 = DatabaseMetaData.class.getDeclaredMethod("supportsSavepoints");
         methodObject4750 = DatabaseMetaData.class.getDeclaredMethod("getMaxCatalogNameLength");
         methodObject4745 = DatabaseMetaData.class.getDeclaredMethod("getImportedKeys", String.class, String.class, String.class);
         methodObject4816 = DatabaseMetaData.class.getDeclaredMethod("supportsBatchUpdates");
         methodObject4731 = DatabaseMetaData.class.getDeclaredMethod("getCrossReference", String.class, String.class, String.class, String.class, String.class, String.class);
         methodObject4830 = DatabaseMetaData.class.getDeclaredMethod("supportsExpressionsInOrderBy");
         methodObject4771 = DatabaseMetaData.class.getDeclaredMethod("getProcedureColumns", String.class, String.class, String.class, String.class);
         methodObject4770 = DatabaseMetaData.class.getDeclaredMethod("getPrimaryKeys", String.class, String.class, String.class);
         methodObject4721 = DatabaseMetaData.class.getDeclaredMethod("dataDefinitionIgnoredInTransactions");
         methodObject4853 = DatabaseMetaData.class.getDeclaredMethod("supportsOuterJoins");
         methodObject4797 = DatabaseMetaData.class.getDeclaredMethod("nullsAreSortedAtStart");
         methodObject4709 = DatabaseMetaData.class.getDeclaredMethod("getAttributes", String.class, String.class, String.class, String.class);
         methodObject4784 = DatabaseMetaData.class.getDeclaredMethod("getSuperTypes", String.class, String.class, String.class);
         methodObject4877 = DatabaseMetaData.class.getDeclaredMethod("supportsUnionAll");
         methodObject4717 = DatabaseMetaData.class.getDeclaredMethod("allProceduresAreCallable");
         methodObject4824 = DatabaseMetaData.class.getDeclaredMethod("supportsConvert", Integer.TYPE, Integer.TYPE);
         methodObject4706 = oracle.jdbc.AdditionalDatabaseMetaData.class.getDeclaredMethod("getLobMaxLength");
         methodObject4817 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInDataManipulation");
         methodObject4775 = DatabaseMetaData.class.getDeclaredMethod("getRowIdLifetime");
         methodObject4790 = DatabaseMetaData.class.getDeclaredMethod("getUDTs", String.class, String.class, String.class, int[].class);
         methodObject4725 = DatabaseMetaData.class.getDeclaredMethod("getBestRowIdentifier", String.class, String.class, String.class, Integer.TYPE, Boolean.TYPE);
         methodObject4710 = DatabaseMetaData.class.getDeclaredMethod("getDatabaseProductVersion");
         methodObject4786 = DatabaseMetaData.class.getDeclaredMethod("getTablePrivileges", String.class, String.class, String.class);
         methodObject4761 = DatabaseMetaData.class.getDeclaredMethod("getMaxProcedureNameLength");
         methodObject4808 = DatabaseMetaData.class.getDeclaredMethod("storesMixedCaseIdentifiers");
         methodObject4822 = DatabaseMetaData.class.getDeclaredMethod("supportsColumnAliasing");
         methodObject4815 = DatabaseMetaData.class.getDeclaredMethod("supportsAlterTableWithDropColumn");
         methodObject4856 = DatabaseMetaData.class.getDeclaredMethod("supportsResultSetConcurrency", Integer.TYPE, Integer.TYPE);
         methodObject4724 = DatabaseMetaData.class.getDeclaredMethod("generatedKeyAlwaysReturned");
         methodObject4845 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleTransactions");
         methodObject4783 = DatabaseMetaData.class.getDeclaredMethod("getSuperTables", String.class, String.class, String.class);
         methodObject4834 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupBy");
         methodObject4757 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInTable");
         methodObject4755 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInOrderBy");
         methodObject4743 = DatabaseMetaData.class.getDeclaredMethod("getFunctions", String.class, String.class, String.class);
         methodObject4878 = DatabaseMetaData.class.getDeclaredMethod("updatesAreDetected", Integer.TYPE);
         methodObject4758 = DatabaseMetaData.class.getDeclaredMethod("getMaxConnections");
         methodObject4718 = DatabaseMetaData.class.getDeclaredMethod("allTablesAreSelectable");
         methodObject4787 = DatabaseMetaData.class.getDeclaredMethod("getTableTypes");
         methodObject4795 = DatabaseMetaData.class.getDeclaredMethod("nullPlusNonNullIsNull");
         methodObject4869 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInComparisons");
         methodObject4760 = DatabaseMetaData.class.getDeclaredMethod("getMaxIndexLength");
         methodObject4872 = DatabaseMetaData.class.getDeclaredMethod("supportsSubqueriesInQuantifieds");
         methodObject4850 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenStatementsAcrossCommit");
         methodObject4821 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInTableDefinitions");
         methodObject4835 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupByBeyondSelect");
         methodObject4866 = DatabaseMetaData.class.getDeclaredMethod("supportsStatementPooling");
         methodObject4827 = DatabaseMetaData.class.getDeclaredMethod("supportsDataDefinitionAndDataManipulationTransactions");
         methodObject4843 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleOpenResults");
         methodObject4753 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnsInGroupBy");
         methodObject4752 = DatabaseMetaData.class.getDeclaredMethod("getMaxColumnNameLength");
         methodObject4884 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject4765 = DatabaseMetaData.class.getDeclaredMethod("getMaxStatements");
         methodObject4814 = DatabaseMetaData.class.getDeclaredMethod("supportsAlterTableWithAddColumn");
         methodObject4836 = DatabaseMetaData.class.getDeclaredMethod("supportsGroupByUnrelated");
         methodObject4811 = DatabaseMetaData.class.getDeclaredMethod("supportsANSI92EntryLevelSQL");
         methodObject4730 = DatabaseMetaData.class.getDeclaredMethod("getColumns", String.class, String.class, String.class, String.class);
         methodObject4840 = DatabaseMetaData.class.getDeclaredMethod("supportsMinimumSQLGrammar");
         methodObject4751 = DatabaseMetaData.class.getDeclaredMethod("getMaxCharLiteralLength");
         methodObject4804 = DatabaseMetaData.class.getDeclaredMethod("ownInsertsAreVisible", Integer.TYPE);
         methodObject4806 = DatabaseMetaData.class.getDeclaredMethod("storesLowerCaseIdentifiers");
         methodObject4844 = DatabaseMetaData.class.getDeclaredMethod("supportsMultipleResultSets");
         methodObject4849 = DatabaseMetaData.class.getDeclaredMethod("supportsOpenCursorsAcrossRollback");
         methodObject4865 = DatabaseMetaData.class.getDeclaredMethod("supportsSelectForUpdate");
         methodObject4854 = DatabaseMetaData.class.getDeclaredMethod("supportsPositionedDelete");
         methodObject4820 = DatabaseMetaData.class.getDeclaredMethod("supportsCatalogsInProcedureCalls");
         methodObject4773 = DatabaseMetaData.class.getDeclaredMethod("getProcedures", String.class, String.class, String.class);
         methodObject4726 = DatabaseMetaData.class.getDeclaredMethod("getCatalogSeparator");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1AdditionalDatabaseMetaData$$$Proxy(AdditionalDatabaseMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
