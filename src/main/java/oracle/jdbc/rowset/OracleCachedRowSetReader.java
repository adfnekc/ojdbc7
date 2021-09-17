package oracle.jdbc.rowset;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.sql.RowSetInternal;
import javax.sql.RowSetReader;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.internal.OracleConnection;

public class OracleCachedRowSetReader implements RowSetReader, Serializable {
   static final long serialVersionUID = -3565405169674271176L;
   static final transient int SETUNICODESTREAM_INTLENGTH = 1;
   static final transient int SETBINARYSTREAM_INTLENGTH = 2;
   static final transient int SETASCIISTREAM_INTLENGTH = 3;
   static final transient int SETCHARACTERSTREAM_INTLENGTH = 4;
   static final transient int SETBINARYSTREAM = 5;
   static final transient int SETBINARYSTREAM_LONGLENGTH = 6;
   static final transient int SETASCIISTREAM = 7;
   static final transient int SETASCIISTREAM_LONGLENGTH = 8;
   static final transient int SETCHARACTERSTREAM = 9;
   static final transient int SETCHARACTERSTREAM_LONGLENGTH = 10;
   static final transient int SETNCHARACTERSTREAM = 11;
   static final transient int SETNCHARACTERSTREAM_LONGLENGTH = 12;
   static final transient int SETBLOB_STREAM = 13;
   static final transient int SETBLOB_STREAM_LONG = 14;
   static final transient int SETCLOB_READER = 15;
   static final transient int SETCLOB_READER_LONG = 16;
   static final transient int SETNCLOB_READER = 17;
   static final transient int SETNCLOB_READER_LONG = 18;
   static final transient int TWO_PARAMETERS = 2;
   static final transient int THREE_PARAMETERS = 3;
   private static transient boolean driverManagerInitialized = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   Connection getConnection(RowSetInternal var1) throws SQLException {
      Connection var2 = null;
      Connection var3 = var1.getConnection();
      if (var3 != null && !var3.isClosed()) {
         var2 = var3;
      } else {
         String var6;
         if (((RowSet)var1).getDataSourceName() != null) {
            try {
               InitialContext var4 = null;

               try {
                  Properties var10 = System.getProperties();
                  var4 = new InitialContext(var10);
               } catch (SecurityException var8) {
               }

               if (var4 == null) {
                  var4 = new InitialContext();
               }

               DataSource var12 = (DataSource)var4.lookup(((RowSet)var1).getDataSourceName());
               var6 = ((RowSet)var1).getUsername();
               String var7 = ((RowSet)var1).getPassword();
               if (var6 == null && var7 == null) {
                  var2 = var12.getConnection();
               } else {
                  var2 = var12.getConnection(var6, var7);
               }
            } catch (NamingException var9) {
               SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 300, var9.getMessage());
               var5.fillInStackTrace();
               throw var5;
            }
         } else if (((RowSet)var1).getUrl() != null) {
            if (!driverManagerInitialized) {
               DriverManager.registerDriver(new OracleDriver());
               driverManagerInitialized = true;
            }

            String var11 = ((RowSet)var1).getUrl();
            String var13 = ((RowSet)var1).getUsername();
            var6 = ((RowSet)var1).getPassword();
            if (var11.equals("") || var13.equals("") || var6.equals("")) {
               SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 301);
               var14.fillInStackTrace();
               throw var14;
            }

            var2 = DriverManager.getConnection(var11, var13, var6);
         }
      }

      return var2;
   }

   private void setParams(Object[] var1, PreparedStatement var2) throws SQLException {
      for(int var3 = 0; var3 < var1.length; ++var3) {
         boolean var4 = false;
         if (var1[var3] instanceof byte[]) {
            var2.setObject(var3 + 1, var1[var3]);
         } else {
            int var8;
            try {
               var8 = Array.getLength(var1[var3]);
            } catch (IllegalArgumentException var7) {
               var2.setObject(var3 + 1, var1[var3]);
               continue;
            }

            Object[] var5 = (Object[])((Object[])var1[var3]);
            SQLException var6;
            if (var8 == 2) {
               if (var5[0] == null) {
                  var2.setNull(var3 + 1, (Integer)var5[1]);
               } else if (var5[0] instanceof Date) {
                  if (!(var5[1] instanceof Calendar)) {
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  }

                  var2.setDate(var3 + 1, (Date)var5[0], (Calendar)var5[1]);
               } else if (var5[0] instanceof Time) {
                  if (!(var5[1] instanceof Calendar)) {
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  }

                  var2.setTime(var3 + 1, (Time)var5[0], (Calendar)var5[1]);
               } else if (var5[0] instanceof Timestamp) {
                  if (!(var5[1] instanceof Calendar)) {
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  }

                  var2.setTimestamp(var3 + 1, (Timestamp)var5[0], (Calendar)var5[1]);
               } else if (var5[0] instanceof Reader) {
                  switch((Integer)var5[1]) {
                  case 9:
                     var2.setCharacterStream(var3 + 1, (Reader)var5[0]);
                     break;
                  case 10:
                  case 12:
                  case 13:
                  case 14:
                  case 16:
                  default:
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  case 11:
                     var2.setNCharacterStream(var3 + 1, (Reader)var5[0]);
                     break;
                  case 15:
                     var2.setClob(var3 + 1, (Reader)var5[0]);
                     break;
                  case 17:
                     var2.setNClob(var3 + 1, (Reader)var5[0]);
                  }
               } else if (var5[0] instanceof InputStream) {
                  switch((Integer)var5[1]) {
                  case 5:
                     var2.setBinaryStream(var3 + 1, (InputStream)var5[0]);
                     break;
                  case 7:
                     var2.setAsciiStream(var3 + 1, (InputStream)var5[0]);
                     break;
                  case 13:
                     var2.setBlob(var3 + 1, (InputStream)var5[0]);
                     break;
                  default:
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  }
               } else if (var5[1] instanceof Integer) {
                  var2.setObject(var3 + 1, var5[0], (Integer)var5[1]);
               }
            } else if (var8 == 3) {
               if (var5[0] == null) {
                  var2.setNull(var3 + 1, (Integer)var5[1], (String)var5[2]);
               } else if (var5[0] instanceof Reader) {
                  switch((Integer)var5[2]) {
                  case 4:
                     var2.setCharacterStream(var3 + 1, (Reader)var5[0], (Integer)var5[1]);
                     break;
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 9:
                  case 11:
                  case 13:
                  case 14:
                  case 15:
                  case 17:
                  default:
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  case 10:
                     var2.setCharacterStream(var3 + 1, (Reader)var5[0], (Long)var5[1]);
                     break;
                  case 12:
                     var2.setNCharacterStream(var3 + 1, (Reader)var5[0], (Long)var5[1]);
                     break;
                  case 16:
                     var2.setClob(var3 + 1, (Reader)var5[0], (Long)var5[1]);
                     break;
                  case 18:
                     var2.setNClob(var3 + 1, (Reader)var5[0], (Long)var5[1]);
                  }
               } else if (var5[0] instanceof InputStream) {
                  switch((Integer)var5[2]) {
                  case 1:
                     var2.setUnicodeStream(var3 + 1, (InputStream)var5[0], (Integer)var5[1]);
                     break;
                  case 2:
                     var2.setBinaryStream(var3 + 1, (InputStream)var5[0], (Integer)var5[1]);
                     break;
                  case 3:
                     var2.setAsciiStream(var3 + 1, (InputStream)var5[0], (Integer)var5[1]);
                     break;
                  case 4:
                  case 5:
                  case 7:
                  case 9:
                  case 10:
                  case 11:
                  case 12:
                  case 13:
                  default:
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  case 6:
                     var2.setBinaryStream(var3 + 1, (InputStream)var5[0], (Long)var5[1]);
                     break;
                  case 8:
                     var2.setAsciiStream(var3 + 1, (InputStream)var5[0], (Long)var5[1]);
                     break;
                  case 14:
                     var2.setBlob(var3 + 1, (InputStream)var5[0], (Long)var5[1]);
                  }
               } else {
                  if (!(var5[1] instanceof Integer) || !(var5[2] instanceof Integer)) {
                     var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 323);
                     var6.fillInStackTrace();
                     throw var6;
                  }

                  var2.setObject(var3 + 1, var5[0], (Integer)var5[1], (Integer)var5[2]);
               }
            }
         }
      }

   }

   public synchronized void readData(RowSetInternal var1) throws SQLException {
      OracleCachedRowSet var2 = (OracleCachedRowSet)var1;
      Connection var3 = this.getConnection(var1);
      if (var3 != null && var2.getCommand() != null) {
         try {
            var3.setTransactionIsolation(var2.getTransactionIsolation());
         } catch (Exception var9) {
         }

         PreparedStatement var10 = var3.prepareStatement(var2.getCommand(), var2.getType(), var2.getConcurrency());
         this.setParams(var1.getParams(), var10);

         try {
            var10.setMaxRows(var2.getMaxRows());
            var10.setMaxFieldSize(var2.getMaxFieldSize());
            var10.setEscapeProcessing(var2.getEscapeProcessing());
            var10.setQueryTimeout(var2.getQueryTimeout());
         } catch (Exception var8) {
         }

         ResultSet var5 = var10.executeQuery();
         var2.populate(var5, var2.getCurrentPage() * var2.getPageSize());
         var5.close();
         var10.close();

         try {
            if (!var3.getAutoCommit()) {
               var3.commit();
            }
         } catch (SQLException var7) {
         }

         if (!var2.isConnectionStayingOpen()) {
            var3.close();
         }

      } else {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 342);
         var4.fillInStackTrace();
         throw var4;
      }
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
