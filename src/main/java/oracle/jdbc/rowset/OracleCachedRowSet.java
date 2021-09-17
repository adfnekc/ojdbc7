package oracle.jdbc.rowset;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringBufferInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.Vector;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetInternal;
import javax.sql.RowSetMetaData;
import javax.sql.RowSetReader;
import javax.sql.RowSetWriter;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetWarning;
import javax.sql.rowset.spi.SyncFactory;
import javax.sql.rowset.spi.SyncFactoryException;
import javax.sql.rowset.spi.SyncProvider;
import javax.sql.rowset.spi.SyncProviderException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleSavepoint;
import oracle.jdbc.driver.DBConversion;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleDriver;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import oracle.sql.ROWID;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public class OracleCachedRowSet extends OracleRowSet implements RowSet, RowSetInternal, Serializable, Cloneable, CachedRowSet {
   static final long serialVersionUID = -2066958142885801470L;
   private SQLWarning sqlWarning = new SQLWarning();
   private RowSetWarning rowsetWarning;
   protected int presentRow = 0;
   private int currentPage;
   private boolean isPopulateDone;
   private boolean previousColumnWasNull = false;
   private OracleRow insertRow;
   private int insertRowPosition;
   private boolean insertRowFlag = false;
   private int updateRowPosition;
   private boolean updateRowFlag = false;
   protected ResultSetMetaData rowsetMetaData;
   private transient ResultSet resultSet;
   private transient Connection connection;
   private transient boolean isConnectionStayingOpenForTxnControl = false;
   private transient OracleSqlForRowSet osql = null;
   protected Vector rows = new Vector();
   private Vector param = new Vector();
   private String[] metaData;
   protected int colCount;
   protected int rowCount;
   private RowSetReader reader;
   private RowSetWriter writer;
   private int[] keyColumns;
   private int pageSize;
   private SyncProvider syncProvider;
   private static final String DEFAULT_SYNCPROVIDER = "com.sun.rowset.providers.RIOptimisticProvider";
   private String tableName;
   private boolean executeCalled = false;
   private boolean driverManagerInitialized = false;
   private static final int MAX_CHAR_BUFFER_SIZE = 1024;
   private static final int MAX_BYTE_BUFFER_SIZE = 1024;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleCachedRowSet() throws SQLException {
      try {
         this.syncProvider = SyncFactory.getInstance("com.sun.rowset.providers.RIOptimisticProvider");
      } catch (SyncFactoryException var3) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 304);
         var2.fillInStackTrace();
         throw var2;
      }

      this.setReader(new OracleCachedRowSetReader());
      this.setWriter(new OracleCachedRowSetWriter());
      this.currentPage = 0;
      this.pageSize = 0;
      this.isPopulateDone = false;
      this.keyColumns = null;
      this.tableName = null;
   }

   public Connection getConnection() throws SQLException {
      return this.getConnectionInternal();
   }

   Connection getConnectionInternal() throws SQLException {
      if (this.connection == null || this.connection.isClosed()) {
         String var1 = this.getUsername();
         String var2 = this.getPassword();
         SQLException var4;
         if (this.getDataSourceName() != null) {
            try {
               InitialContext var3 = null;

               try {
                  Properties var7 = System.getProperties();
                  var3 = new InitialContext(var7);
               } catch (SecurityException var5) {
               }

               if (var3 == null) {
                  var3 = new InitialContext();
               }

               DataSource var9 = (DataSource)var3.lookup(this.getDataSourceName());
               if (this.username != null && var2 != null) {
                  this.connection = var9.getConnection(this.username, var2);
               } else {
                  this.connection = var9.getConnection();
               }
            } catch (NamingException var6) {
               var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 300, var6.getMessage());
               var4.fillInStackTrace();
               throw var4;
            }
         } else {
            if (this.getUrl() == null) {
               SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 301);
               var10.fillInStackTrace();
               throw var10;
            }

            if (!this.driverManagerInitialized) {
               DriverManager.registerDriver(new OracleDriver());
               this.driverManagerInitialized = true;
            }

            String var8 = this.getUrl();
            if (var8.equals("") || var1 == null || var1.equals("") || var2 == null || var2.equals("")) {
               var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 301);
               var4.fillInStackTrace();
               throw var4;
            }

            this.connection = DriverManager.getConnection(var8, var1, var2);
         }
      }

      return this.connection;
   }

   public Statement getStatement() throws SQLException {
      if (this.resultSet == null) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 305);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return this.resultSet.getStatement();
      }
   }

   public RowSetReader getReader() {
      return this.reader;
   }

   public RowSetWriter getWriter() {
      return this.writer;
   }

   public void setFetchDirection(int var1) throws SQLException {
      SQLException var2;
      if (this.rowsetType == 1005) {
         var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 306);
         var2.fillInStackTrace();
         throw var2;
      } else {
         switch(var1) {
         case 1000:
         case 1002:
            this.presentRow = 0;
            break;
         case 1001:
            if (this.rowsetType == 1003) {
               var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 307);
               var2.fillInStackTrace();
               throw var2;
            }

            this.presentRow = this.rowCount + 1;
            break;
         default:
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 308);
            var2.fillInStackTrace();
            throw var2;
         }

         super.setFetchDirection(var1);
      }
   }

   public void setCommand(String var1) throws SQLException {
      super.setCommand(var1);
      if (var1 != null && !var1.equals("")) {
         this.osql = new OracleSqlForRowSet(var1);
      } else {
         this.osql = null;
      }

   }

   public void setReader(RowSetReader var1) {
      this.reader = var1;
   }

   public void setWriter(RowSetWriter var1) {
      this.writer = var1;
   }

   private final int getColumnIndex(String var1) throws SQLException {
      if (var1 != null && !var1.equals("")) {
         var1 = var1.toUpperCase();

         int var4;
         for(var4 = 0; var4 < this.metaData.length && !var1.equals(this.metaData[var4]); ++var4) {
         }

         if (var4 >= this.metaData.length) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6, var1);
            var3.fillInStackTrace();
            throw var3;
         } else {
            return var4 + 1;
         }
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6, var1);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   private final void checkColumnIndex(int var1) throws SQLException {
      SQLException var2;
      if (this.readOnly) {
         var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var2.fillInStackTrace();
         throw var2;
      } else if (var1 < 1 || var1 > this.colCount) {
         var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, "" + var1);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   private final boolean isUpdated(int var1) throws SQLException {
      if (var1 >= 1 && var1 <= this.colCount) {
         return this.getCurrentRow().isColumnChanged(var1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, "" + var1);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   private final void checkParamIndex(int var1) throws SQLException {
      if (var1 < 1) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 310, "" + var1);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   private final void populateInit(ResultSet var1) throws SQLException {
      this.resultSet = var1;
      Statement var2 = var1.getStatement();
      this.maxFieldSize = var2.getMaxFieldSize();
      this.fetchSize = var2.getFetchSize();
      this.queryTimeout = var2.getQueryTimeout();
      this.connection = var2.getConnection();
      this.transactionIsolation = this.connection.getTransactionIsolation();
      this.typeMap = this.connection.getTypeMap();
      DatabaseMetaData var3 = this.connection.getMetaData();
      this.url = var3.getURL();
      this.username = var3.getUserName();
      this.presentRow = 0;
   }

   private synchronized InputStream getStream(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return null;
      } else if (var2 instanceof InputStream) {
         return (InputStream)var2;
      } else if (var2 instanceof String) {
         return new ByteArrayInputStream(((String)var2).getBytes());
      } else if (var2 instanceof byte[]) {
         return new ByteArrayInputStream((byte[])((byte[])var2));
      } else if (var2 instanceof OracleSerialClob) {
         return ((OracleSerialClob)var2).getAsciiStream();
      } else if (var2 instanceof OracleSerialBlob) {
         return ((OracleSerialBlob)var2).getBinaryStream();
      } else if (var2 instanceof Reader) {
         BufferedReader var26 = null;
         PipedOutputStream var4 = null;
         boolean var19 = false;

         PipedInputStream var7;
         try {
            var19 = true;
            var26 = new BufferedReader((Reader)var2);
            boolean var5 = false;
            PipedInputStream var28 = new PipedInputStream();
            var4 = new PipedOutputStream(var28);

            while(true) {
               int var27;
               if ((var27 = var26.read()) == -1) {
                  var7 = var28;
                  var19 = false;
                  break;
               }

               var4.write(var27);
            }
         } catch (IOException var24) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 311, var24.getMessage());
            var6.fillInStackTrace();
            throw var6;
         } finally {
            if (var19) {
               SQLException var12;
               try {
                  if (var26 != null) {
                     var26.close();
                  }
               } catch (IOException var20) {
                  var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 311, var20.getMessage());
                  var12.fillInStackTrace();
                  throw var12;
               }

               try {
                  if (var4 != null) {
                     var4.close();
                  }
               } catch (IOException var22) {
                  var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 311, var22.getMessage());
                  var12.fillInStackTrace();
                  throw var12;
               }

            }
         }

         SQLException var9;
         try {
            if (var26 != null) {
               var26.close();
            }
         } catch (IOException var23) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 311, var23.getMessage());
            var9.fillInStackTrace();
            throw var9;
         }

         try {
            if (var4 != null) {
               var4.close();
            }

            return var7;
         } catch (IOException var21) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 311, var21.getMessage());
            var9.fillInStackTrace();
            throw var9;
         }
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 312);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   private final Calendar getSessionCalendar(Connection var1) {
      String var2 = ((OracleConnection)var1).getSessionTimeZone();
      Calendar var3;
      if (var2 == null) {
         var3 = Calendar.getInstance();
      } else {
         TimeZone var4 = TimeZone.getDefault();
         var4.setID(var2);
         var3 = Calendar.getInstance(var4);
      }

      return var3;
   }

   private boolean isStreamType(int var1) {
      return var1 == 2004 || var1 == 2005 || var1 == 2011 || var1 == -4 || var1 == -16 || var1 == -1;
   }

   protected synchronized void notifyCursorMoved() {
      if (this.insertRowFlag) {
         this.insertRowFlag = false;
         this.insertRow.setRowUpdated(false);
         this.sqlWarning.setNextWarning(new SQLWarning("Cancelling insertion, due to cursor movement."));
      } else if (this.updateRowFlag) {
         try {
            this.updateRowFlag = false;
            int var1 = this.presentRow;
            this.presentRow = this.updateRowPosition;
            this.getCurrentRow().setRowUpdated(false);
            this.presentRow = var1;
            this.sqlWarning.setNextWarning(new SQLWarning("Cancelling all updates, due to cursor movement."));
         } catch (SQLException var2) {
         }
      }

      super.notifyCursorMoved();
   }

   protected void checkAndFilterObject(int var1, Object var2) throws SQLException {
   }

   OracleRow getCurrentRow() throws SQLException {
      int var1 = this.presentRow - 1;
      if (this.presentRow >= 1 && this.presentRow <= this.rowCount) {
         return (OracleRow)this.rows.elementAt(this.presentRow - 1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 313);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   boolean isExecuteCalled() {
      return this.executeCalled;
   }

   int getCurrentPage() {
      return this.currentPage;
   }

   boolean isConnectionStayingOpen() {
      return this.isConnectionStayingOpenForTxnControl;
   }

   void setOriginal() throws SQLException {
      int var1 = 1;

      do {
         boolean var2 = this.setOriginalRowInternal(var1);
         if (!var2) {
            ++var1;
         }
      } while(var1 <= this.rowCount);

      this.notifyRowSetChanged();
      this.presentRow = 0;
   }

   boolean setOriginalRowInternal(int var1) throws SQLException {
      if (var1 >= 1 && var1 <= this.rowCount) {
         boolean var4 = false;
         OracleRow var3 = (OracleRow)this.rows.elementAt(var1 - 1);
         if (var3.isRowDeleted()) {
            this.rows.remove(var1 - 1);
            --this.rowCount;
            var4 = true;
         } else {
            if (var3.isRowInserted()) {
               var3.setInsertedFlag(false);
            }

            if (var3.isRowUpdated()) {
               var3.makeUpdatesOriginal();
            }
         }

         return var4;
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 313);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public boolean next() throws SQLException {
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      } else if (this.rowCount < 0) {
         return false;
      } else if (this.fetchDirection != 1000 && this.fetchDirection != 1002) {
         if (this.fetchDirection == 1001) {
            if (this.presentRow - 1 > 0) {
               --this.presentRow;
               if (!this.showDeleted && this.getCurrentRow().isRowDeleted()) {
                  return this.next();
               } else {
                  this.notifyCursorMoved();
                  return true;
               }
            } else {
               this.presentRow = 0;
               return false;
            }
         } else {
            return false;
         }
      } else if (this.presentRow + 1 <= this.rowCount) {
         ++this.presentRow;
         if (!this.showDeleted && this.getCurrentRow().isRowDeleted()) {
            return this.next();
         } else {
            this.notifyCursorMoved();
            return true;
         }
      } else {
         this.presentRow = this.rowCount + 1;
         return false;
      }
   }

   public boolean previous() throws SQLException {
      if (this.rowCount < 0) {
         return false;
      } else if (this.fetchDirection == 1001) {
         if (this.presentRow + 1 <= this.rowCount) {
            ++this.presentRow;
            if (!this.showDeleted && this.getCurrentRow().isRowDeleted()) {
               return this.previous();
            } else {
               this.notifyCursorMoved();
               return true;
            }
         } else {
            this.presentRow = this.rowCount + 1;
            return false;
         }
      } else if (this.fetchDirection != 1000 && this.fetchDirection != 1002) {
         return false;
      } else if (this.presentRow - 1 > 0) {
         --this.presentRow;
         if (!this.showDeleted && this.getCurrentRow().isRowDeleted()) {
            return this.previous();
         } else {
            this.notifyCursorMoved();
            return true;
         }
      } else {
         this.presentRow = 0;
         return false;
      }
   }

   public boolean isBeforeFirst() throws SQLException {
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return this.rowCount > 0 && this.presentRow == 0;
      }
   }

   public boolean isAfterLast() throws SQLException {
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return this.rowCount > 0 && this.presentRow == this.rowCount + 1;
      }
   }

   public boolean isFirst() throws SQLException {
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return this.presentRow == 1;
      }
   }

   public boolean isLast() throws SQLException {
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return this.presentRow == this.rowCount;
      }
   }

   public void beforeFirst() throws SQLException {
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.presentRow = 0;
      }
   }

   public void afterLast() throws SQLException {
      this.presentRow = this.rowCount + 1;
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public boolean first() throws SQLException {
      return this.absolute(1);
   }

   public boolean last() throws SQLException {
      return this.absolute(-1);
   }

   public boolean absolute(int var1) throws SQLException {
      SQLException var2;
      if (this.isClosed) {
         var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var2.fillInStackTrace();
         throw var2;
      } else if (this.rowsetType == 1003) {
         var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 314);
         var2.fillInStackTrace();
         throw var2;
      } else if (var1 != 0 && Math.abs(var1) <= this.rowCount) {
         this.presentRow = var1 < 0 ? this.rowCount + var1 + 1 : var1;
         this.notifyCursorMoved();
         return true;
      } else {
         return false;
      }
   }

   public boolean relative(int var1) throws SQLException {
      return this.absolute(this.presentRow + var1);
   }

   public synchronized void populate(ResultSet var1) throws SQLException {
      if (this.rows == null) {
         this.rows = new Vector(50, 10);
      } else {
         this.rows.clear();
      }

      this.rowsetMetaData = new OracleRowSetMetaData(var1.getMetaData());
      this.metaData = new String[this.colCount = this.rowsetMetaData.getColumnCount()];

      for(int var2 = 0; var2 < this.colCount; ++var2) {
         this.metaData[var2] = this.rowsetMetaData.getColumnName(var2 + 1);
      }

      if (!(var1 instanceof OracleCachedRowSet)) {
         this.populateInit(var1);
      }

      boolean var11 = this.fetchDirection == 1000 || this.fetchDirection == 1002;
      this.rowCount = 0;
      OracleRow var3 = null;
      int var4;
      if (this.maxRows == 0 && this.pageSize == 0) {
         var4 = Integer.MAX_VALUE;
      } else if (this.maxRows != 0 && this.pageSize != 0) {
         var4 = Math.min(this.maxRows, this.pageSize);
      } else {
         var4 = Math.max(this.maxRows, this.pageSize);
      }

      if (var1.getType() != 1003 && this.rows.size() == 0 && !var11) {
         var1.afterLast();
      }

      boolean var5;
      for(var5 = false; this.rowCount < var4; ++this.rowCount) {
         if (var11) {
            if (!var1.next()) {
               var5 = true;
               break;
            }
         } else if (!var1.previous()) {
            var5 = true;
            break;
         }

         var3 = new OracleRow(this.colCount);

         for(int var6 = 1; var6 <= this.colCount; ++var6) {
            Object var7 = null;

            try {
               var7 = var1.getObject(var6, this.typeMap);
            } catch (Exception var9) {
               var7 = var1.getObject(var6);
            } catch (AbstractMethodError var10) {
               var7 = var1.getObject(var6);
            }

            if (!(var7 instanceof Clob) && !(var7 instanceof CLOB)) {
               if (!(var7 instanceof Blob) && !(var7 instanceof BLOB)) {
                  var3.setColumnValue(var6, var7);
               } else {
                  var3.setColumnValue(var6, new OracleSerialBlob((Blob)var7));
               }
            } else {
               var3.setColumnValue(var6, new OracleSerialClob((Clob)var7));
            }

            var3.markOriginalNull(var6, var1.wasNull());
         }

         if (var11) {
            this.rows.add(var3);
         } else {
            this.rows.add(1, var3);
         }
      }

      if (var5 || var11 && var1.isAfterLast() || !var11 && var1.isBeforeFirst()) {
         this.isPopulateDone = true;
      }

      this.connection = null;
      this.notifyRowSetChanged();
   }

   public String getCursorName() throws SQLException {
      SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23);
      var1.fillInStackTrace();
      throw var1;
   }

   public synchronized void clearParameters() throws SQLException {
      this.param = null;
      this.param = new Vector();
   }

   public boolean wasNull() throws SQLException {
      if (this.isClosed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return this.previousColumnWasNull;
      }
   }

   public void close() throws SQLException {
      if (!this.isClosed) {
         this.release();
         this.isClosed = true;
      }

   }

   public SQLWarning getWarnings() throws SQLException {
      return this.sqlWarning;
   }

   public void clearWarnings() throws SQLException {
      this.sqlWarning = null;
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      return this.rowsetMetaData;
   }

   public int findColumn(String var1) throws SQLException {
      return this.getColumnIndex(var1);
   }

   public Object[] getParams() throws SQLException {
      return this.param.toArray();
   }

   public void setMetaData(RowSetMetaData var1) throws SQLException {
      this.rowsetMetaData = var1;
      if (var1 != null) {
         this.colCount = var1.getColumnCount();
      }

   }

   public synchronized void execute() throws SQLException {
      this.isConnectionStayingOpenForTxnControl = false;
      this.getReader().readData(this);
      this.executeCalled = true;
      this.isClosed = false;
   }

   public void acceptChanges() throws SyncProviderException {
      try {
         this.getWriter().writeData(this);
      } catch (SQLException var3) {
         SyncProviderException var2 = new SyncProviderException(var3.getMessage());
         var2.initCause(var3);
         throw var2;
      }
   }

   public void acceptChanges(Connection var1) throws SyncProviderException {
      this.connection = var1;
      this.isConnectionStayingOpenForTxnControl = true;
      this.acceptChanges();
   }

   public Object clone() throws CloneNotSupportedException {
      try {
         return this.createCopy();
      } catch (SQLException var2) {
         throw new CloneNotSupportedException("SQL Error occured while cloning: " + var2.getMessage());
      }
   }

   public CachedRowSet createCopy() throws SQLException {
      OracleCachedRowSet var1 = (OracleCachedRowSet)this.createShared();
      int var2 = this.rows.size();
      var1.rows = new Vector(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         var1.rows.add(((OracleRow)this.rows.elementAt(var3)).createCopy());
      }

      return var1;
   }

   public RowSet createShared() throws SQLException {
      OracleCachedRowSet var1 = new OracleCachedRowSet();
      var1.rows = this.rows;
      var1.setDataSource(this.getDataSource());
      var1.setDataSourceName(this.getDataSourceName());
      var1.setUsername(this.getUsername());
      var1.setPassword(this.getPassword());
      var1.setUrl(this.getUrl());
      var1.setTypeMap(this.getTypeMap());
      var1.setMaxFieldSize(this.getMaxFieldSize());
      var1.setMaxRows(this.getMaxRows());
      var1.setQueryTimeout(this.getQueryTimeout());
      var1.setFetchSize(this.getFetchSize());
      var1.setEscapeProcessing(this.getEscapeProcessing());
      var1.setConcurrency(this.getConcurrency());
      var1.setReadOnly(this.readOnly);
      this.rowsetType = this.getType();
      this.fetchDirection = this.getFetchDirection();
      var1.setCommand(this.getCommand());
      var1.setTransactionIsolation(this.getTransactionIsolation());
      var1.presentRow = this.presentRow;
      var1.colCount = this.colCount;
      var1.rowCount = this.rowCount;
      var1.showDeleted = this.showDeleted;
      var1.syncProvider = this.syncProvider;
      var1.currentPage = this.currentPage;
      var1.pageSize = this.pageSize;
      var1.tableName = this.tableName == null ? null : this.tableName;
      var1.keyColumns = this.keyColumns == null ? null : (int[])((int[])this.keyColumns.clone());
      int var2 = this.listener.size();

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1.listener.add(this.listener.elementAt(var3));
      }

      var1.rowsetMetaData = new OracleRowSetMetaData(this.rowsetMetaData);
      var2 = this.param.size();

      for(var3 = 0; var3 < var2; ++var3) {
         var1.param.add(this.param.elementAt(var3));
      }

      var1.metaData = new String[this.metaData.length];
      System.arraycopy(this.metaData, 0, var1.metaData, 0, this.metaData.length);
      return var1;
   }

   public void release() throws SQLException {
      this.rows = null;
      this.rows = new Vector();
      if (this.connection != null && !this.connection.isClosed()) {
         this.connection.close();
      }

      this.rowCount = 0;
      this.presentRow = 0;
      this.notifyRowSetChanged();
   }

   public void restoreOriginal() throws SQLException {
      boolean var1 = false;

      for(int var2 = 0; var2 < this.rowCount; ++var2) {
         OracleRow var3 = (OracleRow)this.rows.elementAt(var2);
         if (var3.isRowInserted()) {
            this.rows.remove(var2);
            --this.rowCount;
            --var2;
            var1 = true;
         } else if (var3.isRowUpdated()) {
            var3.setRowUpdated(false);
            var1 = true;
         } else if (var3.isRowDeleted()) {
            var3.setRowDeleted(false);
            var1 = true;
         }
      }

      if (!var1) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 315);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.notifyRowSetChanged();
         this.presentRow = 0;
      }
   }

   public Collection toCollection() throws SQLException {
      Map var1 = Collections.synchronizedMap(new TreeMap());

      try {
         for(int var2 = 0; var2 < this.rowCount; ++var2) {
            var1.put(var2, ((OracleRow)this.rows.elementAt(var2)).toCollection());
         }
      } catch (Exception var4) {
         var1 = null;
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 316);
         var3.fillInStackTrace();
         throw var3;
      }

      return var1.values();
   }

   public Collection toCollection(int var1) throws SQLException {
      if (var1 >= 1 && var1 <= this.colCount) {
         Vector var6 = new Vector(this.rowCount);

         for(int var3 = 0; var3 < this.rowCount; ++var3) {
            OracleRow var4 = (OracleRow)this.rows.elementAt(var3);
            Object var5 = var4.isColumnChanged(var1) ? var4.getModifiedColumn(var1) : var4.getColumn(var1);
            var6.add(var5);
         }

         return var6;
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, "" + var1);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public Collection toCollection(String var1) throws SQLException {
      return this.toCollection(this.getColumnIndex(var1));
   }

   public int getRow() throws SQLException {
      return this.presentRow > this.rowCount ? this.rowCount : this.presentRow;
   }

   public void cancelRowInsert() throws SQLException {
      if (this.getCurrentRow().isRowInserted()) {
         this.rows.remove(--this.presentRow);
         --this.rowCount;
         this.notifyRowChanged();
      } else {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 317);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public void cancelRowDelete() throws SQLException {
      if (this.getCurrentRow().isRowDeleted()) {
         this.getCurrentRow().setRowDeleted(false);
         this.notifyRowChanged();
      } else {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 318);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public void cancelRowUpdates() throws SQLException {
      if (this.getCurrentRow().isRowUpdated()) {
         this.updateRowFlag = false;
         this.getCurrentRow().setRowUpdated(false);
         this.notifyRowChanged();
      } else {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 319);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public void insertRow() throws SQLException {
      SQLException var1;
      if (this.isReadOnly()) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else if (!this.insertRowFlag) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 317);
         var1.fillInStackTrace();
         throw var1;
      } else if (!this.insertRow.isRowFullyPopulated()) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 320);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.insertRow.insertRow();
         this.rows.insertElementAt(this.insertRow, this.insertRowPosition - 1);
         this.insertRowFlag = false;
         ++this.rowCount;
         this.notifyRowChanged();
      }
   }

   public void updateRow() throws SQLException {
      SQLException var1;
      if (this.isReadOnly()) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else if (this.updateRowFlag) {
         this.updateRowFlag = false;
         this.getCurrentRow().setRowUpdated(true);
         this.notifyRowChanged();
      } else {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 319);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public void deleteRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.getCurrentRow().setRowDeleted(true);
         this.notifyRowChanged();
      }
   }

   public void refreshRow() throws SQLException {
      OracleRow var1 = this.getCurrentRow();
      if (var1.isRowUpdated()) {
         var1.cancelRowUpdates();
      }

   }

   public void moveToInsertRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.insertRow = new OracleRow(this.colCount, true);
         this.insertRowFlag = true;
         if (this.isAfterLast()) {
            this.insertRowPosition = this.presentRow;
         } else {
            this.insertRowPosition = this.presentRow + 1;
         }

      }
   }

   public void moveToCurrentRow() throws SQLException {
      if (this.isReadOnly()) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 309);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.insertRowFlag = false;
         this.updateRowFlag = false;
         this.absolute(this.presentRow);
      }
   }

   public boolean rowUpdated() throws SQLException {
      return this.getCurrentRow().isRowUpdated();
   }

   public boolean rowInserted() throws SQLException {
      return this.getCurrentRow().isRowInserted();
   }

   public boolean rowDeleted() throws SQLException {
      return this.getCurrentRow().isRowDeleted();
   }

   public ResultSet getOriginalRow() throws SQLException {
      OracleCachedRowSet var1 = new OracleCachedRowSet();
      var1.rowsetMetaData = this.rowsetMetaData;
      var1.rowCount = 1;
      var1.colCount = this.colCount;
      var1.presentRow = 0;
      var1.setReader((RowSetReader)null);
      var1.setWriter((RowSetWriter)null);
      OracleRow var2 = new OracleRow(this.rowsetMetaData.getColumnCount(), this.getCurrentRow().getOriginalRow());
      var1.rows.add(var2);
      return var1;
   }

   public ResultSet getOriginal() throws SQLException {
      OracleCachedRowSet var1 = new OracleCachedRowSet();
      var1.rowsetMetaData = this.rowsetMetaData;
      var1.rowCount = this.rowCount;
      var1.colCount = this.colCount;
      var1.presentRow = 0;
      var1.setType(1004);
      var1.setConcurrency(1008);
      var1.setReader((RowSetReader)null);
      var1.setWriter((RowSetWriter)null);
      int var2 = this.rowsetMetaData.getColumnCount();
      OracleRow var3 = null;
      Iterator var4 = this.rows.iterator();

      while(var4.hasNext()) {
         var3 = new OracleRow(var2, ((OracleRow)var4.next()).getOriginalRow());
         var1.rows.add(var3);
      }

      return var1;
   }

   public void setNull(int var1, int var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, (Object)null);
   }

   public void setNull(int var1, int var2, String var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3};
      this.param.add(var1 - 1, var4);
   }

   public void setBoolean(int var1, boolean var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setByte(int var1, byte var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, new Byte(var2));
   }

   public void setShort(int var1, short var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setInt(int var1, int var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setLong(int var1, long var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setFloat(int var1, float var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setDouble(int var1, double var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setBigDecimal(int var1, BigDecimal var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setString(int var1, String var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setBytes(int var1, byte[] var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setDate(int var1, Date var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setTime(int var1, Time var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setObject(int var1, Object var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setRef(int var1, Ref var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setBlob(int var1, Blob var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setClob(int var1, Clob var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setArray(int var1, Array var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3, 2};
      this.param.add(var1 - 1, var4);
   }

   public void setTime(int var1, Time var2, Calendar var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3};
      this.param.add(var1 - 1, var4);
   }

   public void setTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3};
      this.param.add(var1 - 1, var4);
   }

   public void setTimestamp(int var1, Timestamp var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3, 3};
      this.param.add(var1 - 1, var4);
   }

   public void setUnicodeStream(int var1, InputStream var2, int var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3, 1};
      this.param.add(var1 - 1, var4);
   }

   public void setCharacterStream(int var1, Reader var2, int var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3, 4};
      this.param.add(var1 - 1, var4);
   }

   public void setObject(int var1, Object var2, int var3, int var4) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{var2, var3, var4};
      this.param.add(var1 - 1, var5);
   }

   public void setObject(int var1, Object var2, int var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3};
      this.param.add(var1 - 1, var4);
   }

   public void setDate(int var1, Date var2, Calendar var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var4 = new Object[]{var2, var3};
      this.param.add(var1 - 1, var4);
   }

   public void setURL(int var1, URL var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2.toString());
   }

   public synchronized Object getObject(int var1) throws SQLException {
      int var2 = this.presentRow * this.colCount + var1 - 1;
      Object var3 = null;
      if (!this.isUpdated(var1)) {
         var3 = this.getCurrentRow().getColumn(var1);
      } else {
         var3 = this.getCurrentRow().getModifiedColumn(var1);
      }

      this.previousColumnWasNull = var3 == null;
      return var3;
   }

   private synchronized Number getNumber(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof BigDecimal) && !(var2 instanceof Number)) {
         if (var2 instanceof Boolean) {
            return (Boolean)var2 ? 1 : 0;
         } else if (var2 instanceof String) {
            try {
               return new BigDecimal((String)var2);
            } catch (NumberFormatException var5) {
               SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
               var4.fillInStackTrace();
               throw var4;
            }
         } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
            var3.fillInStackTrace();
            throw var3;
         }
      } else {
         return (Number)var2;
      }
   }

   public Object getObject(int var1, Map var2) throws SQLException {
      return this.getObject(var1);
   }

   public boolean getBoolean(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return false;
      } else if (var2 instanceof Boolean) {
         return (Boolean)var2;
      } else if (var2 instanceof Number) {
         return ((Number)var2).doubleValue() != 0.0D;
      } else {
         if (var2 instanceof String) {
            String var3 = ((String)var2).trim();
            if (var3.equals("1")) {
               return true;
            }

            if (var3.equals("0")) {
               return false;
            }
         }

         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
         var4.fillInStackTrace();
         throw var4;
      }
   }

   public byte getByte(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return 0;
      } else if (var2 instanceof BigDecimal) {
         BigDecimal var7 = (BigDecimal)var2;
         if (var7.compareTo(new BigDecimal(127)) != 1 && var7.compareTo(new BigDecimal(-128)) != -1) {
            return var7.byteValue();
         } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 26);
            var4.fillInStackTrace();
            throw var4;
         }
      } else if (var2 instanceof Number) {
         return ((Number)var2).byteValue();
      } else if (var2 instanceof String) {
         return ((String)var2).getBytes()[0];
      } else if (var2 instanceof OracleSerialBlob) {
         OracleSerialBlob var6 = (OracleSerialBlob)var2;
         return var6.getBytes(1L, 1)[0];
      } else if (var2 instanceof OracleSerialClob) {
         OracleSerialClob var5 = (OracleSerialClob)var2;
         return var5.getSubString(1L, 1).getBytes()[0];
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public short getShort(int var1) throws SQLException {
      Number var2 = this.getNumber(var1);
      return var2 == null ? 0 : var2.shortValue();
   }

   public int getInt(int var1) throws SQLException {
      Number var2 = this.getNumber(var1);
      return var2 == null ? 0 : var2.intValue();
   }

   public long getLong(int var1) throws SQLException {
      Number var2 = this.getNumber(var1);
      return var2 == null ? 0L : var2.longValue();
   }

   public float getFloat(int var1) throws SQLException {
      Number var2 = this.getNumber(var1);
      return var2 == null ? 0.0F : var2.floatValue();
   }

   public double getDouble(int var1) throws SQLException {
      Number var2 = this.getNumber(var1);
      return var2 == null ? 0.0D : var2.doubleValue();
   }

   public BigDecimal getBigDecimal(int var1) throws SQLException {
      Number var2 = this.getNumber(var1);
      return var2 != null && !(var2 instanceof BigDecimal) ? new BigDecimal(var2.doubleValue()) : (BigDecimal)var2;
   }

   public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
      return this.getBigDecimal(var1);
   }

   public Date getDate(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return (Date)var2;
      } else if (var2 instanceof Time) {
         Time var6 = (Time)var2;
         return new Date(var6.getTime());
      } else if (var2 instanceof java.util.Date) {
         java.util.Date var5 = (java.util.Date)var2;
         return new Date(var5.getYear(), var5.getMonth(), var5.getDate());
      } else if (var2 instanceof TIMESTAMP) {
         return ((TIMESTAMP)var2).dateValue();
      } else if (var2 instanceof TIMESTAMPTZ) {
         return ((TIMESTAMPTZ)var2).dateValue(this.getConnectionInternal());
      } else if (var2 instanceof TIMESTAMPLTZ) {
         Connection var4 = this.getConnectionInternal();
         return ((TIMESTAMPLTZ)var2).dateValue(var4, this.getSessionCalendar(var4));
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public Date getDate(int var1, Calendar var2) throws SQLException {
      return this.getDate(var1);
   }

   public Time getTime(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return (Time)var2;
      } else if (var2 instanceof java.util.Date) {
         java.util.Date var5 = (java.util.Date)var2;
         return new Time(var5.getHours(), var5.getMinutes(), var5.getSeconds());
      } else if (var2 instanceof TIMESTAMP) {
         return ((TIMESTAMP)var2).timeValue();
      } else if (var2 instanceof TIMESTAMPTZ) {
         return ((TIMESTAMPTZ)var2).timeValue(this.getConnectionInternal());
      } else if (var2 instanceof TIMESTAMPLTZ) {
         Connection var4 = this.getConnectionInternal();
         return ((TIMESTAMPLTZ)var2).timeValue(var4, this.getSessionCalendar(var4));
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public Time getTime(int var1, Calendar var2) throws SQLException {
      return this.getTime(var1);
   }

   public Timestamp getTimestamp(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof Timestamp)) {
         if (var2 instanceof java.util.Date) {
            return new Timestamp(((java.util.Date)var2).getTime());
         } else if (var2 instanceof TIMESTAMP) {
            return ((TIMESTAMP)var2).timestampValue();
         } else if (var2 instanceof TIMESTAMPTZ) {
            return ((TIMESTAMPTZ)var2).timestampValue(this.getConnectionInternal());
         } else if (var2 instanceof TIMESTAMPLTZ) {
            Connection var4 = this.getConnectionInternal();
            return ((TIMESTAMPLTZ)var2).timestampValue(var4, this.getSessionCalendar(var4));
         } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
            var3.fillInStackTrace();
            throw var3;
         }
      } else {
         return (Timestamp)var2;
      }
   }

   public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
      return this.getTimestamp(var1);
   }

   public byte[] getBytes(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return (byte[])((byte[])var2);
      } else if (var2 instanceof byte[]) {
         return (byte[])((byte[])var2);
      } else if (var2 instanceof String) {
         return (byte[])((String)var2).getBytes();
      } else if (var2 instanceof Number) {
         return (byte[])((Number)var2).toString().getBytes();
      } else if (var2 instanceof BigDecimal) {
         return (byte[])((BigDecimal)var2).toString().getBytes();
      } else if (var2 instanceof OracleSerialBlob) {
         OracleSerialBlob var5 = (OracleSerialBlob)var2;
         return var5.getBytes(1L, (int)var5.length());
      } else if (var2 instanceof OracleSerialClob) {
         OracleSerialClob var4 = (OracleSerialClob)var2;
         return var4.getSubString(1L, (int)var4.length()).getBytes();
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public Ref getRef(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof Ref)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      } else {
         return (Ref)var2;
      }
   }

   public Blob getBlob(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof OracleSerialBlob)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      } else {
         return (Blob)var2;
      }
   }

   public Clob getClob(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof OracleSerialClob)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      } else {
         return (Clob)var2;
      }
   }

   public Array getArray(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof Array)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      } else {
         return (Array)var2;
      }
   }

   public String getString(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return (String)var2;
      } else if (var2 instanceof String) {
         return (String)var2;
      } else if (!(var2 instanceof Number) && !(var2 instanceof BigDecimal)) {
         if (var2 instanceof Date) {
            return var2.toString();
         } else if (var2 instanceof Timestamp) {
            return var2.toString();
         } else if (var2 instanceof byte[]) {
            return new String((byte[])((byte[])var2));
         } else if (var2 instanceof OracleSerialClob) {
            OracleSerialClob var10 = (OracleSerialClob)var2;
            return var10.getSubString(1L, (int)var10.length());
         } else if (var2 instanceof OracleSerialBlob) {
            OracleSerialBlob var9 = (OracleSerialBlob)var2;
            return new String(var9.getBytes(1L, (int)var9.length()));
         } else if (var2 instanceof URL) {
            return ((URL)var2).toString();
         } else if (var2 instanceof ROWID) {
            return ((ROWID)var2).stringValue();
         } else if (var2 instanceof Reader) {
            try {
               Reader var8 = (Reader)var2;
               char[] var11 = new char[1024];
               boolean var5 = false;
               StringBuffer var6 = new StringBuffer(1024);

               int var12;
               while((var12 = var8.read(var11)) > 0) {
                  var6.append(var11, 0, var12);
               }

               return var6.substring(0, var6.length());
            } catch (IOException var7) {
               SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 321, var7.getMessage());
               var4.fillInStackTrace();
               throw var4;
            }
         } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
            var3.fillInStackTrace();
            throw var3;
         }
      } else {
         return var2.toString();
      }
   }

   public InputStream getAsciiStream(int var1) throws SQLException {
      InputStream var2 = this.getStream(var1);
      return var2 == null ? null : var2;
   }

   public InputStream getUnicodeStream(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return (InputStream)var2;
      } else if (var2 instanceof String) {
         return new StringBufferInputStream((String)var2);
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public InputStream getBinaryStream(int var1) throws SQLException {
      InputStream var2 = this.getStream(var1);
      return var2 == null ? null : var2;
   }

   public synchronized Reader getCharacterStream(int var1) throws SQLException {
      try {
         InputStream var2 = this.getAsciiStream(var1);
         if (var2 == null) {
            return null;
         } else {
            StringBuffer var8 = new StringBuffer();
            boolean var4 = false;

            int var9;
            while((var9 = var2.read()) != -1) {
               var8.append((char)var9);
            }

            char[] var5 = new char[var8.length()];
            var8.getChars(0, var8.length(), var5, 0);
            CharArrayReader var6 = new CharArrayReader(var5);
            Object var10 = null;
            return var6;
         }
      } catch (IOException var7) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 322);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public synchronized Object getObject(String var1) throws SQLException {
      return this.getObject(this.getColumnIndex(var1));
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

   public boolean getBoolean(String var1) throws SQLException {
      return this.getBoolean(this.getColumnIndex(var1));
   }

   public byte getByte(String var1) throws SQLException {
      return this.getByte(this.getColumnIndex(var1));
   }

   public short getShort(String var1) throws SQLException {
      return this.getShort(this.getColumnIndex(var1));
   }

   public int getInt(String var1) throws SQLException {
      return this.getInt(this.getColumnIndex(var1));
   }

   public long getLong(String var1) throws SQLException {
      return this.getLong(this.getColumnIndex(var1));
   }

   public float getFloat(String var1) throws SQLException {
      return this.getFloat(this.getColumnIndex(var1));
   }

   public double getDouble(String var1) throws SQLException {
      return this.getDouble(this.getColumnIndex(var1));
   }

   public BigDecimal getBigDecimal(String var1, int var2) throws SQLException {
      return this.getBigDecimal(this.getColumnIndex(var1), var2);
   }

   public byte[] getBytes(String var1) throws SQLException {
      return this.getBytes(this.getColumnIndex(var1));
   }

   public Date getDate(String var1) throws SQLException {
      return this.getDate(this.getColumnIndex(var1));
   }

   public Time getTime(String var1) throws SQLException {
      return this.getTime(this.getColumnIndex(var1));
   }

   public Timestamp getTimestamp(String var1) throws SQLException {
      return this.getTimestamp(this.getColumnIndex(var1));
   }

   public Time getTime(String var1, Calendar var2) throws SQLException {
      return this.getTime(this.getColumnIndex(var1), var2);
   }

   public Date getDate(String var1, Calendar var2) throws SQLException {
      return this.getDate(this.getColumnIndex(var1), var2);
   }

   public InputStream getAsciiStream(String var1) throws SQLException {
      return this.getAsciiStream(this.getColumnIndex(var1));
   }

   public InputStream getUnicodeStream(String var1) throws SQLException {
      return this.getUnicodeStream(this.getColumnIndex(var1));
   }

   public String getString(String var1) throws SQLException {
      return this.getString(this.getColumnIndex(var1));
   }

   public InputStream getBinaryStream(String var1) throws SQLException {
      return this.getBinaryStream(this.getColumnIndex(var1));
   }

   public Reader getCharacterStream(String var1) throws SQLException {
      return this.getCharacterStream(this.getColumnIndex(var1));
   }

   public BigDecimal getBigDecimal(String var1) throws SQLException {
      return this.getBigDecimal(this.getColumnIndex(var1));
   }

   public Timestamp getTimestamp(String var1, Calendar var2) throws SQLException {
      return this.getTimestamp(this.getColumnIndex(var1), var2);
   }

   public Object getObject(String var1, Map var2) throws SQLException {
      return this.getObject(this.getColumnIndex(var1), var2);
   }

   public Ref getRef(String var1) throws SQLException {
      return this.getRef(this.getColumnIndex(var1));
   }

   public Blob getBlob(String var1) throws SQLException {
      return this.getBlob(this.getColumnIndex(var1));
   }

   public Clob getClob(String var1) throws SQLException {
      return this.getClob(this.getColumnIndex(var1));
   }

   public Array getArray(String var1) throws SQLException {
      return this.getArray(this.getColumnIndex(var1));
   }

   public void updateObject(int var1, Object var2) throws SQLException {
      this.updateObject(var1, var2, (long[])null);
   }

   protected synchronized void updateObject(int var1, Object var2, long[] var3) throws SQLException {
      this.checkColumnIndex(var1);
      if (this.insertRowFlag) {
         this.checkAndFilterObject(var1, var2);
         this.insertRow.updateObject(var1, var2, var3);
      } else {
         if (this.isBeforeFirst() || this.isAfterLast()) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90);
            var4.fillInStackTrace();
            throw var4;
         }

         this.updateRowFlag = true;
         this.updateRowPosition = this.presentRow;
         this.getCurrentRow().updateObject(var1, var2, var3);
      }

   }

   public void updateNull(int var1) throws SQLException {
      this.updateObject(var1, (Object)null);
   }

   public void updateCharacterStream(int var1, Reader var2, int var3) throws SQLException {
      this.updateCharacterStreamInternal(var1, var2, (long)var3, false, true);
   }

   synchronized void updateCharacterStreamInternal(int var1, Reader var2, long var3, boolean var5, boolean var6) throws SQLException {
      this.checkColumnIndex(var1);
      if (var3 < 0L) {
         SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var13.fillInStackTrace();
         throw var13;
      } else {
         int var7 = this.getMetaData().getColumnType(var1);
         int var14;
         if (!this.isStreamType(var7)) {
            if (var6 && var3 > 2147483647L) {
               SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
               var15.fillInStackTrace();
               throw var15;
            }

            try {
               boolean var8 = false;
               int var16 = var6 ? (int)var3 : Integer.MAX_VALUE;
               char[] var10 = new char[1024];

               StringBuilder var11;
               for(var11 = new StringBuilder(1024); var16 > 0; var16 -= var14) {
                  if (var16 >= 1024) {
                     var14 = var2.read(var10);
                  } else {
                     var14 = var2.read(var10, 0, var16);
                  }

                  if (var14 == -1) {
                     break;
                  }

                  var11.append(var10, 0, var14);
               }

               var2.close();
               if ((long)var16 == var3) {
                  this.updateNull(var1);
                  return;
               }

               this.updateString(var1, var11.toString());
            } catch (IOException var12) {
               SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
               var9.fillInStackTrace();
               throw var9;
            }
         } else {
            if (var6) {
               var14 = var5 ? 4 : 3;
            } else {
               var14 = var5 ? 8 : 7;
            }

            long[] var17 = new long[]{var3, (long)var14};
            this.updateObject(var1, var2, var17);
         }

      }
   }

   public void updateCharacterStream(String var1, Reader var2, int var3) throws SQLException {
      this.updateCharacterStream(this.getColumnIndex(var1), var2, var3);
   }

   public void updateTimestamp(String var1, Timestamp var2) throws SQLException {
      this.updateTimestamp(this.getColumnIndex(var1), var2);
   }

   public void updateBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
      this.updateBinaryStream(this.getColumnIndex(var1), var2, (long)var3, true);
   }

   public void updateBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
      this.updateBinaryStream(var1, var2, (long)var3, true);
   }

   synchronized void updateBinaryStream(int var1, InputStream var2, long var3, boolean var5) throws SQLException {
      this.checkColumnIndex(var1);
      if (var3 < 0L) {
         SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var12.fillInStackTrace();
         throw var12;
      } else {
         int var6 = this.getMetaData().getColumnType(var1);
         if (!this.isStreamType(var6)) {
            if (var5 && var3 > 2147483647L) {
               SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
               var14.fillInStackTrace();
               throw var14;
            }

            try {
               boolean var7 = false;
               int var15 = var5 ? (int)var3 : Integer.MAX_VALUE;
               byte[] var9 = new byte[1024];

               ByteArrayOutputStream var10;
               int var13;
               for(var10 = new ByteArrayOutputStream(1024); var15 > 0; var15 -= var13) {
                  if (var15 >= 1024) {
                     var13 = var2.read(var9);
                  } else {
                     var13 = var2.read(var9, 0, var15);
                  }

                  if (var13 == -1) {
                     break;
                  }

                  var10.write(var9, 0, var13);
               }

               var2.close();
               if ((long)var15 == var3) {
                  this.updateNull(var1);
                  return;
               }

               this.updateBytes(var1, var10.toByteArray());
            } catch (IOException var11) {
               SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
               var8.fillInStackTrace();
               throw var8;
            }
         } else {
            long[] var16 = new long[]{var3, (long)(var5 ? 2 : 6)};
            this.updateObject(var1, var2, var16);
         }

      }
   }

   public void updateAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
      this.updateAsciiStream(var1, var2, (long)var3, true);
   }

   synchronized void updateAsciiStream(int var1, InputStream var2, long var3, boolean var5) throws SQLException {
      this.checkColumnIndex(var1);
      if (var3 < 0L) {
         SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var13.fillInStackTrace();
         throw var13;
      } else {
         int var6 = this.getMetaData().getColumnType(var1);
         if (!this.isStreamType(var6)) {
            if (var5 && var3 > 2147483647L) {
               SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
               var15.fillInStackTrace();
               throw var15;
            }

            try {
               boolean var7 = false;
               int var16 = var5 ? (int)var3 : Integer.MAX_VALUE;
               byte[] var9 = new byte[1024];
               char[] var10 = new char[1024];

               StringBuilder var11;
               int var14;
               for(var11 = new StringBuilder(1024); var16 > 0; var16 -= var14) {
                  if (var16 >= 1024) {
                     var14 = var2.read(var9);
                  } else {
                     var14 = var2.read(var9, 0, var16);
                  }

                  if (var14 == -1) {
                     break;
                  }

                  DBConversion.asciiBytesToJavaChars(var9, var14, var10);
                  var11.append(var10, 0, var14);
               }

               var2.close();
               if ((long)var16 == var3) {
                  this.updateNull(var1);
                  return;
               }

               this.updateString(var1, var11.toString());
            } catch (IOException var12) {
               SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
               var8.fillInStackTrace();
               throw var8;
            }
         } else {
            long[] var17 = new long[]{var3, (long)(var5 ? 1 : 5)};
            this.updateObject(var1, var2, var17);
         }

      }
   }

   public void updateTimestamp(int var1, Timestamp var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateBoolean(int var1, boolean var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateByte(int var1, byte var2) throws SQLException {
      this.updateObject(var1, new Byte(var2));
   }

   public void updateShort(int var1, short var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateInt(int var1, int var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateLong(int var1, long var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateFloat(int var1, float var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateDouble(int var1, double var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateBigDecimal(int var1, BigDecimal var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateString(int var1, String var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateBytes(int var1, byte[] var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateDate(int var1, Date var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateTime(int var1, Time var2) throws SQLException {
      this.updateObject(var1, new Timestamp(0, 0, 0, var2.getHours(), var2.getMinutes(), var2.getSeconds(), 0));
   }

   public void updateObject(int var1, Object var2, int var3) throws SQLException {
      if (!(var2 instanceof Number)) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
         var4.fillInStackTrace();
         throw var4;
      } else {
         this.updateObject(var1, new BigDecimal(new BigInteger(((Number)var2).toString()), var3));
      }
   }

   public void updateNull(String var1) throws SQLException {
      this.updateNull(this.getColumnIndex(var1));
   }

   public void updateAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
      this.updateAsciiStream(this.getColumnIndex(var1), var2, (long)var3, true);
   }

   public void updateBoolean(String var1, boolean var2) throws SQLException {
      this.updateBoolean(this.getColumnIndex(var1), var2);
   }

   public void updateByte(String var1, byte var2) throws SQLException {
      this.updateByte(this.getColumnIndex(var1), var2);
   }

   public void updateShort(String var1, short var2) throws SQLException {
      this.updateShort(this.getColumnIndex(var1), var2);
   }

   public void updateInt(String var1, int var2) throws SQLException {
      this.updateInt(this.getColumnIndex(var1), var2);
   }

   public void updateLong(String var1, long var2) throws SQLException {
      this.updateLong(this.getColumnIndex(var1), var2);
   }

   public void updateFloat(String var1, float var2) throws SQLException {
      this.updateFloat(this.getColumnIndex(var1), var2);
   }

   public void updateDouble(String var1, double var2) throws SQLException {
      this.updateDouble(this.getColumnIndex(var1), var2);
   }

   public void updateBigDecimal(String var1, BigDecimal var2) throws SQLException {
      this.updateBigDecimal(this.getColumnIndex(var1), var2);
   }

   public void updateString(String var1, String var2) throws SQLException {
      this.updateString(this.getColumnIndex(var1), var2);
   }

   public void updateBytes(String var1, byte[] var2) throws SQLException {
      this.updateBytes(this.getColumnIndex(var1), var2);
   }

   public void updateDate(String var1, Date var2) throws SQLException {
      this.updateDate(this.getColumnIndex(var1), var2);
   }

   public void updateTime(String var1, Time var2) throws SQLException {
      this.updateTime(this.getColumnIndex(var1), var2);
   }

   public void updateObject(String var1, Object var2) throws SQLException {
      this.updateObject(this.getColumnIndex(var1), var2);
   }

   public void updateObject(String var1, Object var2, int var3) throws SQLException {
      this.updateObject(this.getColumnIndex(var1), var2, var3);
   }

   public URL getURL(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 == null) {
         return (URL)var2;
      } else if (var2 instanceof URL) {
         return (URL)var2;
      } else if (var2 instanceof String) {
         try {
            return new URL((String)var2);
         } catch (MalformedURLException var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 136);
            var4.fillInStackTrace();
            throw var4;
         }
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public URL getURL(String var1) throws SQLException {
      return this.getURL(this.getColumnIndex(var1));
   }

   public void updateRef(int var1, Ref var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateRef(String var1, Ref var2) throws SQLException {
      this.updateRef(this.getColumnIndex(var1), var2);
   }

   public void updateBlob(int var1, Blob var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateBlob(String var1, Blob var2) throws SQLException {
      this.updateBlob(this.getColumnIndex(var1), var2);
   }

   public void updateClob(int var1, Clob var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateClob(String var1, Clob var2) throws SQLException {
      this.updateClob(this.getColumnIndex(var1), var2);
   }

   public void updateArray(int var1, Array var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateArray(String var1, Array var2) throws SQLException {
      this.updateArray(this.getColumnIndex(var1), var2);
   }

   public int[] getKeyColumns() throws SQLException {
      return this.keyColumns;
   }

   public void setKeyColumns(int[] var1) throws SQLException {
      int var2 = 0;
      if (this.rowsetMetaData != null) {
         var2 = this.rowsetMetaData.getColumnCount();
         if (var1 == null || var1.length > var2) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 324);
            var6.fillInStackTrace();
            throw var6;
         }
      }

      int var3 = var1.length;
      this.keyColumns = new int[var3];

      for(int var4 = 0; var4 < var3; ++var4) {
         if (var1[var4] <= 0 || var1[var4] > var2) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, "" + var1[var4]);
            var5.fillInStackTrace();
            throw var5;
         }

         this.keyColumns[var4] = var1[var4];
      }

   }

   public int getPageSize() {
      return this.pageSize;
   }

   public void setPageSize(int var1) throws SQLException {
      if (var1 >= 0 && (this.maxRows <= 0 || var1 <= this.maxRows)) {
         this.pageSize = var1;
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 325);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public SyncProvider getSyncProvider() throws SQLException {
      return this.syncProvider;
   }

   public void setSyncProvider(String var1) throws SQLException {
      this.syncProvider = SyncFactory.getInstance(var1);
      this.reader = this.syncProvider.getRowSetReader();
      this.writer = this.syncProvider.getRowSetWriter();
   }

   public String getTableName() throws SQLException {
      return this.tableName;
   }

   public void setTableName(String var1) throws SQLException {
      this.tableName = var1;
   }

   public CachedRowSet createCopyNoConstraints() throws SQLException {
      OracleCachedRowSet var1 = (OracleCachedRowSet)this.createCopy();
      var1.initializeProperties();
      var1.listener = new Vector();

      try {
         var1.unsetMatchColumn(var1.getMatchColumnIndexes());
         var1.unsetMatchColumn(var1.getMatchColumnNames());
      } catch (SQLException var3) {
      }

      return var1;
   }

   public CachedRowSet createCopySchema() throws SQLException {
      OracleCachedRowSet var1 = (OracleCachedRowSet)this.createCopy();
      var1.rows = null;
      var1.rowCount = 0;
      var1.currentPage = 0;
      return var1;
   }

   public boolean columnUpdated(int var1) throws SQLException {
      if (this.insertRowFlag) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 326);
         var2.fillInStackTrace();
         throw var2;
      } else {
         return this.getCurrentRow().isColumnChanged(var1);
      }
   }

   public boolean columnUpdated(String var1) throws SQLException {
      return this.columnUpdated(this.getColumnIndex(var1));
   }

   public synchronized void execute(Connection var1) throws SQLException {
      this.connection = var1;
      this.execute();
   }

   public void commit() throws SQLException {
      this.getConnectionInternal().commit();
   }

   public void rollback() throws SQLException {
      this.getConnectionInternal().rollback();
   }

   public void rollback(Savepoint var1) throws SQLException {
      this.getConnectionInternal().rollback(var1);
   }

   public void oracleRollback(OracleSavepoint var1) throws SQLException {
      ((OracleConnection)this.getConnectionInternal()).oracleRollback(var1);
   }

   public void setOriginalRow() throws SQLException {
      if (this.insertRowFlag) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 327);
         var1.fillInStackTrace();
         throw var1;
      } else {
         this.setOriginalRowInternal(this.presentRow);
      }
   }

   public int size() {
      return this.rowCount;
   }

   public boolean nextPage() throws SQLException {
      SQLException var1;
      if (this.fetchDirection == 1001 && this.resultSet != null && this.resultSet.getType() == 1003) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 328);
         var1.fillInStackTrace();
         throw var1;
      } else if (this.rows.size() == 0 && !this.isPopulateDone) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 329);
         var1.fillInStackTrace();
         throw var1;
      } else if ((this.isExecuteCalled() || this.isPopulateDone) && this.rowCount < this.pageSize) {
         return false;
      } else {
         if (this.isExecuteCalled()) {
            ++this.currentPage;
            this.execute();
         } else {
            this.populate(this.resultSet);
            ++this.currentPage;
         }

         return !this.isPopulateDone;
      }
   }

   public boolean previousPage() throws SQLException {
      SQLException var1;
      if (this.resultSet != null && this.resultSet.getType() == 1003) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 328);
         var1.fillInStackTrace();
         throw var1;
      } else if (this.rows.size() == 0 && !this.isPopulateDone) {
         var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 329);
         var1.fillInStackTrace();
         throw var1;
      } else if (this.currentPage == 0) {
         return false;
      } else {
         if (this.fetchDirection == 1001) {
            this.resultSet.relative(this.pageSize * 2);
         } else {
            this.resultSet.relative(-2 * this.pageSize);
         }

         this.populate(this.resultSet);
         if (this.currentPage > 0) {
            --this.currentPage;
         }

         return this.currentPage != 0;
      }
   }

   public void rowSetPopulated(RowSetEvent var1, int var2) throws SQLException {
      if (var2 > 0 && var2 >= this.fetchSize) {
         if (this.rowCount % var2 == 0) {
            this.rowsetEvent = new RowSetEvent(this);
            this.notifyRowSetChanged();
         }

      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 330);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public RowSetWarning getRowSetWarnings() throws SQLException {
      return this.rowsetWarning;
   }

   public void populate(ResultSet var1, int var2) throws SQLException {
      SQLException var7;
      if (var2 < 0) {
         var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 331);
         var7.fillInStackTrace();
         throw var7;
      } else if (var1 == null) {
         var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 332);
         var7.fillInStackTrace();
         throw var7;
      } else {
         int var3 = var1.getType();
         if (var3 == 1003) {
            int var4 = 0;

            boolean var5;
            for(var5 = false; var4 < var2; ++var4) {
               if (!var1.next()) {
                  var5 = true;
                  break;
               }
            }

            if (var4 < var2 && var2 > 0 && var5) {
               SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 333);
               var6.fillInStackTrace();
               throw var6;
            }
         } else if (var2 == 0) {
            var1.beforeFirst();
         } else {
            var1.absolute(var2);
         }

         this.populate(var1);
      }
   }

   public void undoDelete() throws SQLException {
      this.cancelRowDelete();
   }

   public void undoInsert() throws SQLException {
      this.cancelRowInsert();
   }

   public void undoUpdate() throws SQLException {
      this.cancelRowUpdates();
   }

   public Reader getNCharacterStream(int var1) throws SQLException {
      return this.getCharacterStream(var1);
   }

   public NClob getNClob(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof OracleSerialClob)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      } else {
         return (NClob)var2;
      }
   }

   public String getNString(int var1) throws SQLException {
      return this.getString(var1);
   }

   public RowId getRowId(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 instanceof RowId) {
         return var2 == null ? null : (RowId)var2;
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public SQLXML getSQLXML(int var1) throws SQLException {
      Object var2 = this.getObject(var1);
      if (var2 != null && !(var2 instanceof SQLXML)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var3.fillInStackTrace();
         throw var3;
      } else {
         return (SQLXML)var2;
      }
   }

   public Reader getNCharacterStream(String var1) throws SQLException {
      return this.getNCharacterStream(this.getColumnIndex(var1));
   }

   public NClob getNClob(String var1) throws SQLException {
      return this.getNClob(this.getColumnIndex(var1));
   }

   public String getNString(String var1) throws SQLException {
      return this.getNString(this.getColumnIndex(var1));
   }

   public RowId getRowId(String var1) throws SQLException {
      return this.getRowId(this.getColumnIndex(var1));
   }

   public SQLXML getSQLXML(String var1) throws SQLException {
      return this.getSQLXML(this.getColumnIndex(var1));
   }

   public void setAsciiStream(int var1, InputStream var2) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var3 = new Object[]{var2, 7};
      this.param.add(var1 - 1, var3);
   }

   public void setAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{var2, var3, 8};
      this.param.add(var1 - 1, var5);
   }

   public void setBinaryStream(int var1, InputStream var2) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var3 = new Object[]{var2, 5};
      this.param.add(var1 - 1, var3);
   }

   public void setBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{var2, var3, 6};
      this.param.add(var1 - 1, var5);
   }

   public void setBlob(int var1, InputStream var2) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var3 = new Object[]{var2, 13};
      this.param.add(var1 - 1, var3);
   }

   public void setBlob(int var1, InputStream var2, long var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{var2, var3, 14};
      this.param.add(var1 - 1, var5);
   }

   public void setCharacterStream(int var1, Reader var2) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var3 = new Object[]{var2, 9};
      this.param.add(var1 - 1, var3);
   }

   public void setCharacterStream(int var1, Reader var2, long var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{var2, var3, 10};
      this.param.add(var1 - 1, var5);
   }

   public void setClob(int var1, Reader var2) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var3 = new Object[]{var2, 15};
      this.param.add(var1 - 1, var3);
   }

   public void setClob(int var1, Reader var2, long var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{this.reader, var3, 16};
      this.param.add(var1 - 1, var5);
   }

   public void setNCharacterStream(int var1, Reader var2) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var3 = new Object[]{var2, 11};
      this.param.add(var1 - 1, var3);
   }

   public void setNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{var2, var3, 12};
      this.param.add(var1 - 1, var5);
   }

   public void setNClob(int var1, NClob var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setNClob(int var1, Reader var2) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var3 = new Object[]{this.reader, 17};
      this.param.add(var1 - 1, var3);
   }

   public void setNClob(int var1, Reader var2, long var3) throws SQLException {
      this.checkParamIndex(var1);
      Object[] var5 = new Object[]{this.reader, var3, 18};
      this.param.add(var1 - 1, var5);
   }

   public void setNString(int var1, String var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setRowId(int var1, RowId var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setSQLXML(int var1, SQLXML var2) throws SQLException {
      this.checkParamIndex(var1);
      this.param.add(var1 - 1, var2);
   }

   public void setArray(String var1, Array var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setArray(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setBigDecimal(String var1, BigDecimal var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setBigDecimal(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setBlob(String var1, Blob var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setBlob(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setBoolean(String var1, boolean var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setBoolean(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setByte(String var1, byte var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setByte(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setBytes(String var1, byte[] var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setBytes(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setClob(String var1, Clob var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setClob(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setDate(String var1, Date var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setDate(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setDate(String var1, Date var2, Calendar var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setDate(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setDouble(String var1, double var2) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setDouble(var8 + 1, var2);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setFloat(String var1, float var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setFloat(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setInt(String var1, int var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setInt(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setLong(String var1, long var2) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setLong(var8 + 1, var2);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setNClob(String var1, NClob var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setNClob(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setNString(String var1, String var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setNString(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setObject(String var1, Object var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setObject(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setObject(String var1, Object var2, int var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setObject(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setRef(String var1, Ref var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setRef(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setRowId(String var1, RowId var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setRowId(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setShort(String var1, short var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setShort(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setSQLXML(String var1, SQLXML var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setSQLXML(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setString(String var1, String var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setString(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setTime(String var1, Time var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setTime(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setTime(String var1, Time var2, Calendar var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setTime(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setTimestamp(String var1, Timestamp var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setTimestamp(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setTimestamp(String var1, Timestamp var2, Calendar var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setTimestamp(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setURL(String var1, URL var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setURL(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setBlob(String var1, InputStream var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setBlob(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setBlob(String var1, InputStream var2, long var3) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setBlob(var9 + 1, var2, var3);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void setClob(String var1, Reader var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setClob(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setClob(String var1, Reader var2, long var3) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setClob(var9 + 1, var2, var3);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void setNClob(String var1, Reader var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setNClob(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setNClob(String var1, Reader var2, long var3) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setNClob(var9 + 1, var2, var3);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void setAsciiStream(String var1, InputStream var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setAsciiStream(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setAsciiStream(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setAsciiStream(var9 + 1, var2, var3);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void setBinaryStream(String var1, InputStream var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setBinaryStream(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setBinaryStream(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setBinaryStream(var9 + 1, var2, var3);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void setCharacterStream(String var1, Reader var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setCharacterStream(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setCharacterStream(String var1, Reader var2, int var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setCharacterStream(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setCharacterStream(var9 + 1, var2, var3);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void setNCharacterStream(String var1, Reader var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setNCharacterStream(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setNCharacterStream(var9 + 1, var2, var3);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void setUnicodeStream(String var1, InputStream var2, int var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setUnicodeStream(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setNull(String var1, int var2) throws SQLException {
      String var3 = var1.intern();
      String[] var4 = this.osql.getParameterList();
      boolean var5 = false;
      int var6 = Math.min(this.osql.getParameterCount(), var4.length);

      for(int var7 = 0; var7 < var6; ++var7) {
         if (var4[var7] == var3) {
            this.setNull(var7 + 1, var2);
            var5 = true;
         }
      }

      if (!var5) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var8.fillInStackTrace();
         throw var8;
      }
   }

   public void setNull(String var1, int var2, String var3) throws SQLException {
      String var4 = var1.intern();
      String[] var5 = this.osql.getParameterList();
      boolean var6 = false;
      int var7 = Math.min(this.osql.getParameterCount(), var5.length);

      for(int var8 = 0; var8 < var7; ++var8) {
         if (var5[var8] == var4) {
            this.setNull(var8 + 1, var2, var3);
            var6 = true;
         }
      }

      if (!var6) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var9.fillInStackTrace();
         throw var9;
      }
   }

   public void setObject(String var1, Object var2, int var3, int var4) throws SQLException {
      String var5 = var1.intern();
      String[] var6 = this.osql.getParameterList();
      boolean var7 = false;
      int var8 = Math.min(this.osql.getParameterCount(), var6.length);

      for(int var9 = 0; var9 < var8; ++var9) {
         if (var6[var9] == var5) {
            this.setObject(var9 + 1, var2, var3, var4);
            var7 = true;
         }
      }

      if (!var7) {
         SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
         var10.fillInStackTrace();
         throw var10;
      }
   }

   public void updateAsciiStream(int var1, InputStream var2) throws SQLException {
      this.updateAsciiStream(var1, var2, 0L, false);
   }

   public void updateAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
      this.updateAsciiStream(var1, var2, var3, true);
   }

   public void updateAsciiStream(String var1, InputStream var2) throws SQLException {
      this.updateAsciiStream(this.getColumnIndex(var1), var2);
   }

   public void updateAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
      this.updateAsciiStream(this.getColumnIndex(var1), var2, var3);
   }

   public void updateBinaryStream(int var1, InputStream var2) throws SQLException {
      this.updateBinaryStream(var1, var2, 0L, false);
   }

   public void updateBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
      this.updateBinaryStream(var1, var2, var3, true);
   }

   public void updateBinaryStream(String var1, InputStream var2) throws SQLException {
      this.updateBinaryStream(this.getColumnIndex(var1), var2, Long.MAX_VALUE, false);
   }

   public void updateBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
      this.updateBinaryStream(this.getColumnIndex(var1), var2, var3, true);
   }

   public void updateBlob(int var1, InputStream var2) throws SQLException {
      this.updateBinaryStream(var1, var2);
   }

   public void updateBlob(int var1, InputStream var2, long var3) throws SQLException {
      this.updateBinaryStream(var1, var2, var3);
   }

   public void updateBlob(String var1, InputStream var2) throws SQLException {
      this.updateBlob(this.getColumnIndex(var1), var2);
   }

   public void updateBlob(String var1, InputStream var2, long var3) throws SQLException {
      this.updateBlob(this.getColumnIndex(var1), var2, var3);
   }

   public void updateCharacterStream(int var1, Reader var2) throws SQLException {
      this.updateCharacterStreamInternal(var1, var2, 0L, false, false);
   }

   public void updateCharacterStream(int var1, Reader var2, long var3) throws SQLException {
      this.updateCharacterStreamInternal(var1, var2, var3, false, true);
   }

   public void updateCharacterStream(String var1, Reader var2) throws SQLException {
      this.updateCharacterStreamInternal(this.getColumnIndex(var1), var2, 0L, false, false);
   }

   public void updateCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      this.updateCharacterStreamInternal(this.getColumnIndex(var1), var2, var3, false, true);
   }

   public void updateClob(int var1, Reader var2) throws SQLException {
      this.updateCharacterStream(var1, var2);
   }

   public void updateClob(int var1, Reader var2, long var3) throws SQLException {
      this.updateCharacterStream(var1, var2, var3);
   }

   public void updateClob(String var1, Reader var2) throws SQLException {
      this.updateClob(this.getColumnIndex(var1), var2);
   }

   public void updateClob(String var1, Reader var2, long var3) throws SQLException {
      this.updateClob(this.getColumnIndex(var1), var2, var3);
   }

   public void updateNCharacterStream(int var1, Reader var2) throws SQLException {
      this.updateCharacterStreamInternal(var1, var2, 0L, true, false);
   }

   public void updateNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
      this.updateCharacterStreamInternal(var1, var2, var3, true, true);
   }

   public void updateNCharacterStream(String var1, Reader var2) throws SQLException {
      this.updateNCharacterStream(this.getColumnIndex(var1), var2);
   }

   public void updateNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
      this.updateNCharacterStream(this.getColumnIndex(var1), var2, var3);
   }

   public void updateNClob(int var1, NClob var2) throws SQLException {
      this.updateObject(var1, new OracleSerialClob(var2));
   }

   public void updateNClob(int var1, Reader var2) throws SQLException {
      this.updateClob(var1, (Clob)(new OracleSerialClob(var2)));
   }

   public void updateNClob(int var1, Reader var2, long var3) throws SQLException {
      this.updateClob(var1, (Clob)(new OracleSerialClob(var2, var3)));
   }

   public void updateNClob(String var1, NClob var2) throws SQLException {
      this.updateNClob(this.getColumnIndex(var1), var2);
   }

   public void updateNClob(String var1, Reader var2) throws SQLException {
      this.updateNClob(this.getColumnIndex(var1), var2);
   }

   public void updateNClob(String var1, Reader var2, long var3) throws SQLException {
      this.updateNClob(this.getColumnIndex(var1), var2, var3);
   }

   public void updateNString(int var1, String var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateNString(String var1, String var2) throws SQLException {
      this.updateNString(this.getColumnIndex(var1), var2);
   }

   public void updateRowId(int var1, RowId var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateRowId(String var1, RowId var2) throws SQLException {
      this.updateRowId(this.getColumnIndex(var1), var2);
   }

   public void updateSQLXML(int var1, SQLXML var2) throws SQLException {
      this.updateObject(var1, var2);
   }

   public void updateSQLXML(String var1, SQLXML var2) throws SQLException {
      this.updateSQLXML(this.getColumnIndex(var1), var2);
   }
}
