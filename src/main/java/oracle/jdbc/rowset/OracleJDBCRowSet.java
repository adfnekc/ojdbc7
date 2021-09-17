package oracle.jdbc.rowset;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetWarning;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleSavepoint;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.internal.OraclePreparedStatement;

public abstract class OracleJDBCRowSet extends OracleRowSet implements RowSet, JdbcRowSet {
   private Connection connection;
   private static boolean driverManagerInitialized;
   private PreparedStatement preparedStatement;
   private ResultSet resultSet;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleJDBCRowSet() throws SQLException {
      driverManagerInitialized = false;
   }

   public OracleJDBCRowSet(Connection var1) throws SQLException {
      this();
      this.connection = var1;
   }

   public void execute() throws SQLException {
      this.connection = this.getConnection(this);

      try {
         this.connection.setTransactionIsolation(this.getTransactionIsolation());
      } catch (Exception var2) {
      }

      this.connection.setTypeMap(this.getTypeMap());
      if (this.preparedStatement == null) {
         this.preparedStatement = this.connection.prepareStatement(this.getCommand(), this.getType(), this.getConcurrency());
      }

      this.preparedStatement.setFetchSize(this.getFetchSize());
      this.preparedStatement.setFetchDirection(this.getFetchDirection());
      this.preparedStatement.setMaxFieldSize(this.getMaxFieldSize());
      this.preparedStatement.setMaxRows(this.getMaxRows());
      this.preparedStatement.setQueryTimeout(this.getQueryTimeout());
      this.preparedStatement.setEscapeProcessing(this.getEscapeProcessing());
      this.resultSet = this.preparedStatement.executeQuery();
      this.notifyRowSetChanged();
   }

   public void close() throws SQLException {
      if (this.resultSet != null) {
         this.resultSet.close();
      }

      if (this.preparedStatement != null) {
         this.preparedStatement.close();
      }

      if (this.connection != null && !this.connection.isClosed()) {
         if (!this.connection.getAutoCommit()) {
            this.connection.commit();
         }

         this.connection.close();
      }

      this.notifyRowSetChanged();
      this.isClosed = true;
   }

   private Connection getConnection(RowSet var1) throws SQLException {
      Connection var2 = null;
      if (this.connection != null && !this.connection.isClosed()) {
         var2 = this.connection;
      } else if (var1.getDataSourceName() != null) {
         try {
            InitialContext var3 = new InitialContext();
            DataSource var9 = (DataSource)var3.lookup(var1.getDataSourceName());
            if (var1.getUsername() != null && var1.getPassword() != null) {
               var2 = var9.getConnection(var1.getUsername(), var1.getPassword());
            } else {
               var2 = var9.getConnection();
            }
         } catch (NamingException var7) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 300, var7.getMessage());
            var4.fillInStackTrace();
            throw var4;
         }
      } else if (var1.getUrl() != null) {
         if (!driverManagerInitialized) {
            DriverManager.registerDriver(new OracleDriver());
            driverManagerInitialized = true;
         }

         String var8 = var1.getUrl();
         String var10 = var1.getUsername();
         String var5 = var1.getPassword();
         if (var8.equals("") || var10.equals("") || var5.equals("")) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 301);
            var6.fillInStackTrace();
            throw var6;
         }

         var2 = DriverManager.getConnection(var8, var10, var5);
      }

      return var2;
   }

   public boolean wasNull() throws SQLException {
      return this.resultSet.wasNull();
   }

   public SQLWarning getWarnings() throws SQLException {
      return this.resultSet.getWarnings();
   }

   public void clearWarnings() throws SQLException {
      this.resultSet.clearWarnings();
   }

   public String getCursorName() throws SQLException {
      return this.resultSet.getCursorName();
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      return new OracleRowSetMetaData(this.resultSet.getMetaData());
   }

   public int findColumn(String var1) throws SQLException {
      return this.resultSet.findColumn(var1);
   }

   public void clearParameters() throws SQLException {
      this.preparedStatement.clearParameters();
   }

   public Statement getStatement() throws SQLException {
      return this.resultSet.getStatement();
   }

   public void setCommand(String var1) throws SQLException {
      super.setCommand(var1);
      if (this.connection == null || this.connection.isClosed()) {
         this.connection = this.getConnection(this);
      }

      if (this.preparedStatement != null) {
         try {
            this.preparedStatement.close();
            this.preparedStatement = null;
         } catch (SQLException var3) {
         }
      }

      this.preparedStatement = this.connection.prepareStatement(var1, this.getType(), this.getConcurrency());
   }

   public void setReadOnly(boolean var1) throws SQLException {
      super.setReadOnly(var1);
      if (this.connection != null) {
         this.connection.setReadOnly(var1);
      }

   }

   public void setFetchDirection(int var1) throws SQLException {
      super.setFetchDirection(var1);
      this.resultSet.setFetchDirection(this.fetchDirection);
   }

   public void setShowDeleted(boolean var1) throws SQLException {
      if (var1) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 303);
         var2.fillInStackTrace();
         throw var2;
      } else {
         super.setShowDeleted(var1);
      }
   }

   public boolean next() throws SQLException {
      boolean var1 = this.resultSet.next();
      if (var1) {
         this.notifyCursorMoved();
      }

      return var1;
   }

   public boolean previous() throws SQLException {
      boolean var1 = this.resultSet.previous();
      if (var1) {
         this.notifyCursorMoved();
      }

      return var1;
   }

   public void beforeFirst() throws SQLException {
      if (!this.isBeforeFirst()) {
         this.resultSet.beforeFirst();
         this.notifyCursorMoved();
      }

   }

   public void afterLast() throws SQLException {
      if (!this.isAfterLast()) {
         this.resultSet.afterLast();
         this.notifyCursorMoved();
      }

   }

   public boolean first() throws SQLException {
      boolean var1 = this.resultSet.first();
      if (var1) {
         this.notifyCursorMoved();
      }

      return var1;
   }

   public boolean last() throws SQLException {
      boolean var1 = this.resultSet.last();
      if (var1) {
         this.notifyCursorMoved();
      }

      return var1;
   }

   public boolean absolute(int var1) throws SQLException {
      boolean var2 = this.resultSet.absolute(var1);
      if (var2) {
         this.notifyCursorMoved();
      }

      return var2;
   }

   public boolean relative(int var1) throws SQLException {
      boolean var2 = this.resultSet.relative(var1);
      if (var2) {
         this.notifyCursorMoved();
      }

      return var2;
   }

   public boolean isBeforeFirst() throws SQLException {
      return this.resultSet.isBeforeFirst();
   }

   public boolean isAfterLast() throws SQLException {
      return this.resultSet.isAfterLast();
   }

   public boolean isFirst() throws SQLException {
      return this.resultSet.isFirst();
   }

   public boolean isLast() throws SQLException {
      return this.resultSet.isLast();
   }

   public void insertRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.resultSet.insertRow();
         this.notifyRowChanged();
      }
   }

   public void updateRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.resultSet.updateRow();
         this.notifyRowChanged();
      }
   }

   public void deleteRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.resultSet.deleteRow();
         this.notifyRowChanged();
      }
   }

   public void refreshRow() throws SQLException {
      this.resultSet.refreshRow();
   }

   public void cancelRowUpdates() throws SQLException {
      this.resultSet.cancelRowUpdates();
      this.notifyRowChanged();
   }

   public void moveToInsertRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.resultSet.moveToInsertRow();
      }
   }

   public void moveToCurrentRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.resultSet.moveToCurrentRow();
      }
   }

   public int getRow() throws SQLException {
      return this.resultSet.getRow();
   }

   public boolean rowUpdated() throws SQLException {
      return this.resultSet.rowUpdated();
   }

   public boolean rowInserted() throws SQLException {
      return this.resultSet.rowInserted();
   }

   public boolean rowDeleted() throws SQLException {
      return this.resultSet.rowDeleted();
   }

   public void setNull(int var1, int var2) throws SQLException {
      this.preparedStatement.setNull(var1, var2);
   }

   public void setNull(int var1, int var2, String var3) throws SQLException {
      this.preparedStatement.setNull(var1, var2, var3);
   }

   public void setBoolean(int var1, boolean var2) throws SQLException {
      this.preparedStatement.setBoolean(var1, var2);
   }

   public void setByte(int var1, byte var2) throws SQLException {
      this.preparedStatement.setByte(var1, var2);
   }

   public void setShort(int var1, short var2) throws SQLException {
      this.preparedStatement.setShort(var1, var2);
   }

   public void setInt(int var1, int var2) throws SQLException {
      this.preparedStatement.setInt(var1, var2);
   }

   public void setLong(int var1, long var2) throws SQLException {
      this.preparedStatement.setLong(var1, var2);
   }

   public void setFloat(int var1, float var2) throws SQLException {
      this.preparedStatement.setFloat(var1, var2);
   }

   public void setDouble(int var1, double var2) throws SQLException {
      this.preparedStatement.setDouble(var1, var2);
   }

   public void setBigDecimal(int var1, BigDecimal var2) throws SQLException {
      this.preparedStatement.setBigDecimal(var1, var2);
   }

   public void setString(int var1, String var2) throws SQLException {
      this.preparedStatement.setString(var1, var2);
   }

   public void setBytes(int var1, byte[] var2) throws SQLException {
      this.preparedStatement.setBytes(var1, var2);
   }

   public void setDate(int var1, Date var2) throws SQLException {
      this.preparedStatement.setDate(var1, var2);
   }

   public void setTime(int var1, Time var2) throws SQLException {
      this.preparedStatement.setTime(var1, var2);
   }

   public void setObject(int var1, Object var2) throws SQLException {
      this.preparedStatement.setObject(var1, var2);
   }

   public void setRef(int var1, Ref var2) throws SQLException {
      this.preparedStatement.setRef(var1, var2);
   }

   public void setBlob(int var1, Blob var2) throws SQLException {
      this.preparedStatement.setBlob(var1, var2);
   }

   public void setClob(int var1, Clob var2) throws SQLException {
      this.preparedStatement.setClob(var1, var2);
   }

   public void setArray(int var1, Array var2) throws SQLException {
      this.preparedStatement.setArray(var1, var2);
   }

   public void setBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
      this.preparedStatement.setBinaryStream(var1, var2, var3);
   }

   public void setTime(int var1, Time var2, Calendar var3) throws SQLException {
      this.preparedStatement.setTime(var1, var2, var3);
   }

   public void setTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
      this.preparedStatement.setTimestamp(var1, var2, var3);
   }

   public void setTimestamp(int var1, Timestamp var2) throws SQLException {
      this.preparedStatement.setTimestamp(var1, var2);
   }

   public void setAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
      this.preparedStatement.setAsciiStream(var1, var2, var3);
   }

   public void setCharacterStream(int var1, Reader var2, int var3) throws SQLException {
      this.preparedStatement.setCharacterStream(var1, var2, var3);
   }

   public void setObject(int var1, Object var2, int var3, int var4) throws SQLException {
      this.preparedStatement.setObject(var1, var2, var3, var4);
   }

   public void setObject(int var1, Object var2, int var3) throws SQLException {
      this.preparedStatement.setObject(var1, var2, var3);
   }

   public void setDate(int var1, Date var2, Calendar var3) throws SQLException {
      this.preparedStatement.setDate(var1, var2, var3);
   }

   public Object getObject(int var1, Map var2) throws SQLException {
      return this.resultSet.getObject(var1, var2);
   }

   public BigDecimal getBigDecimal(int var1) throws SQLException {
      return this.resultSet.getBigDecimal(var1);
   }

   public Ref getRef(int var1) throws SQLException {
      return this.resultSet.getRef(var1);
   }

   public Blob getBlob(int var1) throws SQLException {
      return this.resultSet.getBlob(var1);
   }

   public Clob getClob(int var1) throws SQLException {
      return this.resultSet.getClob(var1);
   }

   public Array getArray(int var1) throws SQLException {
      return this.resultSet.getArray(var1);
   }

   public Date getDate(int var1, Calendar var2) throws SQLException {
      return this.resultSet.getDate(var1, var2);
   }

   public Reader getCharacterStream(int var1) throws SQLException {
      return this.resultSet.getCharacterStream(var1);
   }

   public Time getTime(int var1, Calendar var2) throws SQLException {
      return this.resultSet.getTime(var1, var2);
   }

   public InputStream getBinaryStream(int var1) throws SQLException {
      return this.resultSet.getBinaryStream(var1);
   }

   public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
      return this.resultSet.getTimestamp(var1, var2);
   }

   public String getString(int var1) throws SQLException {
      return this.resultSet.getString(var1);
   }

   public boolean getBoolean(int var1) throws SQLException {
      return this.resultSet.getBoolean(var1);
   }

   public byte getByte(int var1) throws SQLException {
      return this.resultSet.getByte(var1);
   }

   public short getShort(int var1) throws SQLException {
      return this.resultSet.getShort(var1);
   }

   public long getLong(int var1) throws SQLException {
      return this.resultSet.getLong(var1);
   }

   public float getFloat(int var1) throws SQLException {
      return this.resultSet.getFloat(var1);
   }

   public double getDouble(int var1) throws SQLException {
      return this.resultSet.getDouble(var1);
   }

   public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
      return this.resultSet.getBigDecimal(var1, var2);
   }

   public byte[] getBytes(int var1) throws SQLException {
      return this.resultSet.getBytes(var1);
   }

   public Date getDate(int var1) throws SQLException {
      return this.resultSet.getDate(var1);
   }

   public Time getTime(int var1) throws SQLException {
      return this.resultSet.getTime(var1);
   }

   public Timestamp getTimestamp(int var1) throws SQLException {
      return this.resultSet.getTimestamp(var1);
   }

   public InputStream getAsciiStream(int var1) throws SQLException {
      return this.resultSet.getAsciiStream(var1);
   }

   public InputStream getUnicodeStream(int var1) throws SQLException {
      return this.resultSet.getUnicodeStream(var1);
   }

   public int getInt(int var1) throws SQLException {
      return this.resultSet.getInt(var1);
   }

   public Object getObject(int var1) throws SQLException {
      return this.resultSet.getObject(var1);
   }

   public int getInt(String var1) throws SQLException {
      return this.resultSet.getInt(var1);
   }

   public long getLong(String var1) throws SQLException {
      return this.resultSet.getLong(var1);
   }

   public float getFloat(String var1) throws SQLException {
      return this.resultSet.getFloat(var1);
   }

   public double getDouble(String var1) throws SQLException {
      return this.resultSet.getDouble(var1);
   }

   public BigDecimal getBigDecimal(String var1, int var2) throws SQLException {
      return this.resultSet.getBigDecimal(var1, var2);
   }

   public byte[] getBytes(String var1) throws SQLException {
      return this.resultSet.getBytes(var1);
   }

   public Date getDate(String var1) throws SQLException {
      return this.resultSet.getDate(var1);
   }

   public Time getTime(String var1) throws SQLException {
      return this.resultSet.getTime(var1);
   }

   public Timestamp getTimestamp(String var1) throws SQLException {
      return this.resultSet.getTimestamp(var1);
   }

   public InputStream getAsciiStream(String var1) throws SQLException {
      return this.resultSet.getAsciiStream(var1);
   }

   public InputStream getUnicodeStream(String var1) throws SQLException {
      return this.resultSet.getUnicodeStream(var1);
   }

   public Object getObject(String var1) throws SQLException {
      return this.resultSet.getObject(var1);
   }

   public Reader getCharacterStream(String var1) throws SQLException {
      return this.resultSet.getCharacterStream(var1);
   }

   public Object getObject(String var1, Map var2) throws SQLException {
      return this.resultSet.getObject(var1, var2);
   }

   public Object getObject(String var1, Class var2) throws SQLException {
      return super.getObject(var1, var2);
   }

   public Object getObject(int var1, Class var2) throws SQLException {
      return super.getObject(var1, var2);
   }

   public Object unwrap(Class var1) throws SQLException {
      return super.unwrap(var1);
   }

   public Ref getRef(String var1) throws SQLException {
      return this.resultSet.getRef(var1);
   }

   public Blob getBlob(String var1) throws SQLException {
      return this.resultSet.getBlob(var1);
   }

   public Clob getClob(String var1) throws SQLException {
      return this.resultSet.getClob(var1);
   }

   public Array getArray(String var1) throws SQLException {
      return this.resultSet.getArray(var1);
   }

   public BigDecimal getBigDecimal(String var1) throws SQLException {
      return this.resultSet.getBigDecimal(var1);
   }

   public Date getDate(String var1, Calendar var2) throws SQLException {
      return this.resultSet.getDate(var1, var2);
   }

   public Time getTime(String var1, Calendar var2) throws SQLException {
      return this.resultSet.getTime(var1, var2);
   }

   public InputStream getBinaryStream(String var1) throws SQLException {
      return this.resultSet.getBinaryStream(var1);
   }

   public Timestamp getTimestamp(String var1, Calendar var2) throws SQLException {
      return this.resultSet.getTimestamp(var1, var2);
   }

   public String getString(String var1) throws SQLException {
      return this.resultSet.getString(var1);
   }

   public boolean getBoolean(String var1) throws SQLException {
      return this.resultSet.getBoolean(var1);
   }

   public byte getByte(String var1) throws SQLException {
      return this.resultSet.getByte(var1);
   }

   public short getShort(String var1) throws SQLException {
      return this.resultSet.getShort(var1);
   }

   public void updateNull(int var1) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var2.fillInStackTrace();
         throw var2;
      } else {
         this.resultSet.updateNull(var1);
      }
   }

   public void updateCharacterStream(int var1, Reader var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateCharacterStream(var1, var2, var3);
      }
   }

   public void updateTimestamp(int var1, Timestamp var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateTimestamp(var1, var2);
      }
   }

   public void updateBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateBinaryStream(var1, var2, var3);
      }
   }

   public void updateAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateAsciiStream(var1, var2, var3);
      }
   }

   public void updateBoolean(int var1, boolean var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBoolean(var1, var2);
      }
   }

   public void updateByte(int var1, byte var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateByte(var1, var2);
      }
   }

   public void updateShort(int var1, short var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateShort(var1, var2);
      }
   }

   public void updateInt(int var1, int var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateInt(var1, var2);
      }
   }

   public void updateLong(int var1, long var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateLong(var1, var2);
      }
   }

   public void updateFloat(int var1, float var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateFloat(var1, var2);
      }
   }

   public void updateDouble(int var1, double var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateDouble(var1, var2);
      }
   }

   public void updateBigDecimal(int var1, BigDecimal var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBigDecimal(var1, var2);
      }
   }

   public void updateString(int var1, String var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateString(var1, var2);
      }
   }

   public void updateBytes(int var1, byte[] var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBytes(var1, var2);
      }
   }

   public void updateDate(int var1, Date var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateDate(var1, var2);
      }
   }

   public void updateTime(int var1, Time var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateTime(var1, var2);
      }
   }

   public void updateObject(int var1, Object var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateObject(var1, var2);
      }
   }

   public void updateObject(int var1, Object var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateObject(var1, var2, var3);
      }
   }

   public void updateNull(String var1) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var2.fillInStackTrace();
         throw var2;
      } else {
         this.resultSet.updateNull(var1);
      }
   }

   public void updateBoolean(String var1, boolean var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBoolean(var1, var2);
      }
   }

   public void updateByte(String var1, byte var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateByte(var1, var2);
      }
   }

   public void updateShort(String var1, short var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateShort(var1, var2);
      }
   }

   public void updateInt(String var1, int var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateInt(var1, var2);
      }
   }

   public void updateLong(String var1, long var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateLong(var1, var2);
      }
   }

   public void updateFloat(String var1, float var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateFloat(var1, var2);
      }
   }

   public void updateDouble(String var1, double var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateDouble(var1, var2);
      }
   }

   public void updateBigDecimal(String var1, BigDecimal var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBigDecimal(var1, var2);
      }
   }

   public void updateString(String var1, String var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateString(var1, var2);
      }
   }

   public void updateBytes(String var1, byte[] var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBytes(var1, var2);
      }
   }

   public void updateDate(String var1, Date var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateDate(var1, var2);
      }
   }

   public void updateTime(String var1, Time var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateTime(var1, var2);
      }
   }

   public void updateObject(String var1, Object var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateObject(var1, var2);
      }
   }

   public void updateObject(String var1, Object var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateObject(var1, var2, var3);
      }
   }

   public void updateBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateBinaryStream(var1, var2, var3);
      }
   }

   public void updateAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateAsciiStream(var1, var2, var3);
      }
   }

   public void updateTimestamp(String var1, Timestamp var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateTimestamp(var1, var2);
      }
   }

   public void updateCharacterStream(String var1, Reader var2, int var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.resultSet.updateCharacterStream(var1, var2, var3);
      }
   }

   public URL getURL(int var1) throws SQLException {
      return ((OracleResultSet)this.resultSet).getURL(var1);
   }

   public URL getURL(String var1) throws SQLException {
      return ((OracleResultSet)this.resultSet).getURL(var1);
   }

   public void updateRef(int var1, Ref var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateRef(var1, var2);
      }
   }

   public void updateRef(String var1, Ref var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateRef(var1, var2);
      }
   }

   public void updateBlob(int var1, Blob var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateBlob(var1, var2);
      }
   }

   public void updateBlob(String var1, Blob var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateBlob(var1, var2);
      }
   }

   public void updateClob(int var1, Clob var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateClob(var1, var2);
      }
   }

   public void updateClob(String var1, Clob var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateClob(var1, var2);
      }
   }

   public void updateArray(int var1, Array var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateArray(var1, var2);
      }
   }

   public void updateArray(String var1, Array var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         ((OracleResultSet)this.resultSet).updateArray(var1, var2);
      }
   }

   public void commit() throws SQLException {
      if (this.connection != null) {
         this.connection.commit();
      } else {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 302);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public void rollback() throws SQLException {
      if (this.connection != null) {
         this.connection.rollback();
      } else {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 302);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public void rollback(Savepoint var1) throws SQLException {
      if (this.connection != null) {
         this.connection.rollback(var1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 302);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public void oracleRollback(OracleSavepoint var1) throws SQLException {
      if (this.connection != null) {
         ((OracleConnection)this.connection).oracleRollback(var1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 302);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public boolean getAutoCommit() throws SQLException {
      if (this.connection != null) {
         return this.connection.getAutoCommit();
      } else {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 302);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public void setAutoCommit(boolean var1) throws SQLException {
      if (this.connection != null) {
         this.connection.setAutoCommit(var1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 302);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public RowSetWarning getRowSetWarnings() throws SQLException {
      return null;
   }

   String getTableName() throws SQLException {
      return this.getMetaData().getTableName(this.getMatchColumnIndexes()[0]);
   }

   public Reader getNCharacterStream(int var1) throws SQLException {
      return this.resultSet.getNCharacterStream(var1);
   }

   public NClob getNClob(int var1) throws SQLException {
      return this.resultSet.getNClob(var1);
   }

   public NClob getNClob(String var1) throws SQLException {
      return this.resultSet.getNClob(var1);
   }

   public String getNString(int var1) throws SQLException {
      return this.resultSet.getNString(var1);
   }

   public RowId getRowId(int var1) throws SQLException {
      return this.resultSet.getRowId(var1);
   }

   public SQLXML getSQLXML(int var1) throws SQLException {
      return this.resultSet.getSQLXML(var1);
   }

   public Reader getNCharacterStream(String var1) throws SQLException {
      return this.resultSet.getNCharacterStream(var1);
   }

   public String getNString(String var1) throws SQLException {
      return this.resultSet.getNString(var1);
   }

   public RowId getRowId(String var1) throws SQLException {
      return this.resultSet.getRowId(var1);
   }

   public SQLXML getSQLXML(String var1) throws SQLException {
      return this.resultSet.getSQLXML(var1);
   }

   public void setAsciiStream(int var1, InputStream var2) throws SQLException {
      this.preparedStatement.setAsciiStream(var1, var2);
   }

   public void setBinaryStream(int var1, InputStream var2) throws SQLException {
      this.preparedStatement.setBinaryStream(var1, var2);
   }

   public void setBlob(int var1, InputStream var2) throws SQLException {
      this.preparedStatement.setBlob(var1, var2);
   }

   public void setBlob(int var1, InputStream var2, long var3) throws SQLException {
      this.preparedStatement.setBlob(var1, var2, var3);
   }

   public void setCharacterStream(int var1, Reader var2) throws SQLException {
      this.preparedStatement.setCharacterStream(var1, var2);
   }

   public void setClob(int var1, Reader var2) throws SQLException {
      this.preparedStatement.setClob(var1, var2);
   }

   public void setClob(int var1, Reader var2, long var3) throws SQLException {
      this.preparedStatement.setClob(var1, var2, var3);
   }

   public void setNCharacterStream(int var1, Reader var2) throws SQLException {
      this.preparedStatement.setNCharacterStream(var1, var2);
   }

   public void setNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
      this.preparedStatement.setNCharacterStream(var1, var2, var3);
   }

   public void setNClob(int var1, NClob var2) throws SQLException {
      this.preparedStatement.setNClob(var1, var2);
   }

   public void setNClob(int var1, Reader var2) throws SQLException {
      this.preparedStatement.setNClob(var1, var2);
   }

   public void setNClob(int var1, Reader var2, long var3) throws SQLException {
      this.preparedStatement.setNClob(var1, var2);
   }

   public void setNString(int var1, String var2) throws SQLException {
      this.preparedStatement.setNString(var1, var2);
   }

   public void setRowId(int var1, RowId var2) throws SQLException {
      this.preparedStatement.setRowId(var1, var2);
   }

   public void setSQLXML(int var1, SQLXML var2) throws SQLException {
      this.preparedStatement.setSQLXML(var1, var2);
   }

   public void setURL(int var1, URL var2) throws SQLException {
      this.preparedStatement.setURL(var1, var2);
   }

   public void setArray(String var1, Array var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setArrayAtName(var1, var2);
   }

   public void setBigDecimal(String var1, BigDecimal var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBigDecimalAtName(var1, var2);
   }

   public void setBlob(String var1, Blob var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBlobAtName(var1, var2);
   }

   public void setBoolean(String var1, boolean var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBooleanAtName(var1, var2);
   }

   public void setByte(String var1, byte var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setByteAtName(var1, var2);
   }

   public void setBytes(String var1, byte[] var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBytesAtName(var1, var2);
   }

   public void setClob(String var1, Clob var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setClobAtName(var1, var2);
   }

   public void setDate(String var1, Date var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setDateAtName(var1, var2);
   }

   public void setDate(String var1, Date var2, Calendar var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setDateAtName(var1, var2, var3);
   }

   public void setDouble(String var1, double var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setDoubleAtName(var1, var2);
   }

   public void setFloat(String var1, float var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setFloatAtName(var1, var2);
   }

   public void setInt(String var1, int var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setIntAtName(var1, var2);
   }

   public void setLong(String var1, long var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setLongAtName(var1, var2);
   }

   public void setNClob(String var1, NClob var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNClobAtName(var1, var2);
   }

   public void setNString(String var1, String var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNStringAtName(var1, var2);
   }

   public void setObject(String var1, Object var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setObjectAtName(var1, var2);
   }

   public void setObject(String var1, Object var2, int var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setObjectAtName(var1, var2, var3);
   }

   public void setRef(String var1, Ref var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setRefAtName(var1, var2);
   }

   public void setRowId(String var1, RowId var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setRowIdAtName(var1, var2);
   }

   public void setShort(String var1, short var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setShortAtName(var1, var2);
   }

   public void setSQLXML(String var1, SQLXML var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setSQLXMLAtName(var1, var2);
   }

   public void setString(String var1, String var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setStringAtName(var1, var2);
   }

   public void setTime(String var1, Time var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setTimeAtName(var1, var2);
   }

   public void setTime(String var1, Time var2, Calendar var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setTimeAtName(var1, var2, var3);
   }

   public void setTimestamp(String var1, Timestamp var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setTimestampAtName(var1, var2);
   }

   public void setTimestamp(String var1, Timestamp var2, Calendar var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setTimestampAtName(var1, var2, var3);
   }

   public void setURL(String var1, URL var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setURLAtName(var1, var2);
   }

   public void setBlob(String var1, InputStream var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBlobAtName(var1, var2);
   }

   public void setBlob(String var1, InputStream var2, long var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBlobAtName(var1, var2, var3);
   }

   public void setClob(String var1, Reader var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setClobAtName(var1, var2);
   }

   public void setClob(String var1, Reader var2, long var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setClobAtName(var1, var2, var3);
   }

   public void setNClob(String var1, Reader var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNClobAtName(var1, var2);
   }

   public void setNClob(String var1, Reader var2, long var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNClobAtName(var1, var2, var3);
   }

   public void setAsciiStream(String var1, InputStream var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setAsciiStreamAtName(var1, var2);
   }

   public void setAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setAsciiStreamAtName(var1, var2, var3);
   }

   public void setAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setAsciiStreamAtName(var1, var2, var3);
   }

   public void setBinaryStream(String var1, InputStream var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBinaryStreamAtName(var1, var2);
   }

   public void setBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBinaryStreamAtName(var1, var2, var3);
   }

   public void setBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setBinaryStreamAtName(var1, var2, var3);
   }

   public void setCharacterStream(String var1, Reader var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setCharacterStreamAtName(var1, var2);
   }

   public void setCharacterStream(String var1, Reader var2, int var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setCharacterStreamAtName(var1, var2, var3);
   }

   public void setCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setCharacterStreamAtName(var1, var2, var3);
   }

   public void setNCharacterStream(String var1, Reader var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNCharacterStreamAtName(var1, var2);
   }

   public void setNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNCharacterStreamAtName(var1, var2, var3);
   }

   public void setUnicodeStream(String var1, InputStream var2, int var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setUnicodeStreamAtName(var1, var2, var3);
   }

   public void setNull(String var1, int var2) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNullAtName(var1, var2);
   }

   public void setNull(String var1, int var2, String var3) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setNullAtName(var1, var2, var3);
   }

   public void setObject(String var1, Object var2, int var3, int var4) throws SQLException {
      ((OraclePreparedStatement)this.preparedStatement).setObjectAtName(var1, var2, var3, var4);
   }

   public void updateAsciiStream(int var1, InputStream var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateAsciiStream(var1, var2);
      }
   }

   public void updateAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateAsciiStream(var1, var2, var3);
      }
   }

   public void updateAsciiStream(String var1, InputStream var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateAsciiStream(var1, var2);
      }
   }

   public void updateAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateAsciiStream(var1, var2, var3);
      }
   }

   public void updateBinaryStream(int var1, InputStream var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBinaryStream(var1, var2);
      }
   }

   public void updateBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateBinaryStream(var1, var2, var3);
      }
   }

   public void updateBinaryStream(String var1, InputStream var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBinaryStream(var1, var2);
      }
   }

   public void updateBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateBinaryStream(var1, var2, var3);
      }
   }

   public void updateBlob(int var1, InputStream var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBlob(var1, var2);
      }
   }

   public void updateBlob(int var1, InputStream var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateBlob(var1, var2, var3);
      }
   }

   public void updateBlob(String var1, InputStream var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateBlob(var1, var2);
      }
   }

   public void updateBlob(String var1, InputStream var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateBlob(var1, var2, var3);
      }
   }

   public void updateCharacterStream(int var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateCharacterStream(var1, var2);
      }
   }

   public void updateCharacterStream(int var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateCharacterStream(var1, var2, var3);
      }
   }

   public void updateCharacterStream(String var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateCharacterStream(var1, var2);
      }
   }

   public void updateCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateCharacterStream(var1, var2, var3);
      }
   }

   public void updateClob(int var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateClob(var1, var2);
      }
   }

   public void updateClob(int var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateClob(var1, var2, var3);
      }
   }

   public void updateClob(String var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateClob(var1, var2);
      }
   }

   public void updateClob(String var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateClob(var1, var2, var3);
      }
   }

   public void updateNCharacterStream(int var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNCharacterStream(var1, var2);
      }
   }

   public void updateNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateNCharacterStream(var1, var2, var3);
      }
   }

   public void updateNCharacterStream(String var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNCharacterStream(var1, var2);
      }
   }

   public void updateNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateNCharacterStream(var1, var2, var3);
      }
   }

   public void updateNClob(int var1, NClob var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNClob(var1, var2);
      }
   }

   public void updateNClob(int var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNClob(var1, var2);
      }
   }

   public void updateNClob(int var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateNClob(var1, var2, var3);
      }
   }

   public void updateNClob(String var1, NClob var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNClob(var1, var2);
      }
   }

   public void updateNClob(String var1, Reader var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNClob(var1, var2);
      }
   }

   public void updateNClob(String var1, Reader var2, long var3) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var5.fillInStackTrace();
         throw var5;
      } else {
         this.resultSet.updateNClob(var1, var2, var3);
      }
   }

   public void updateNString(int var1, String var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNString(var1, var2);
      }
   }

   public void updateNString(String var1, String var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateNString(var1, var2);
      }
   }

   public void updateRowId(int var1, RowId var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateRowId(var1, var2);
      }
   }

   public void updateRowId(String var1, RowId var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateRowId(var1, var2);
      }
   }

   public void updateSQLXML(int var1, SQLXML var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateSQLXML(var1, var2);
      }
   }

   public void updateSQLXML(String var1, SQLXML var2) throws SQLException {
      if (this.isReadOnly()) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.resultSet.updateSQLXML(var1, var2);
      }
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      try {
         return (oracle.jdbc.internal.OracleConnection)this.connection;
      } catch (Exception var2) {
         return null;
      }
   }
}
