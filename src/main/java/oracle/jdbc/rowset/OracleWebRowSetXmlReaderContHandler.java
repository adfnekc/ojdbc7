package oracle.jdbc.rowset;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import javax.sql.RowSet;
import javax.sql.RowSetMetaData;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.xml.util.XMLUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

class OracleWebRowSetXmlReaderContHandler extends DefaultHandler {
   private OracleWebRowSet wrset;
   private RowSetMetaData rsetMetaData;
   private Vector updatesToRowSet;
   private Vector keyCols;
   private String columnValue;
   private String propertyValue;
   private String metadataValue;
   private boolean isNullValue;
   private int columnIndex;
   private Hashtable propertyNameTagMap;
   private Hashtable metadataNameTagMap;
   private Hashtable dataNameTagMap;
   protected static final String WEBROWSET_ELEMENT_NAME = "webRowSet";
   protected static final String PROPERTIES_ELEMENT_NAME = "properties";
   protected static final String METADATA_ELEMENT_NAME = "metadata";
   protected static final String DATA_ELEMENT_NAME = "data";
   private int state;
   private static final int INITIAL_STATE = 0;
   private static final int PROPERTIES_STATE = 1;
   private static final int METADATA_STATE = 2;
   private static final int DATA_STATE = 3;
   private int tag;
   private static final int NO_TAG = -1;
   private String[] propertyNames = new String[]{"command", "concurrency", "datasource", "escape-processing", "fetch-direction", "fetch-size", "isolation-level", "key-columns", "map", "max-field-size", "max-rows", "query-timeout", "read-only", "rowset-type", "show-deleted", "table-name", "url", "sync-provider", "null", "column", "type", "class", "sync-provider-name", "sync-provider-vendor", "sync-provider-version", "sync-provider-grade", "data-source-lock"};
   private boolean readReadOnlyValue;
   private static final int PROPERTY_COMMAND_TAG = 0;
   private static final int PROPERTY_CONCURRENCY_TAG = 1;
   private static final int PROPERTY_DATASOURCETAG = 2;
   private static final int PROPERTY_ESCAPEPROCESSING_TAG = 3;
   private static final int PROPERTY_FETCHDIRECTION_TAG = 4;
   private static final int PROPERTY_FETCHSIZE_TAG = 5;
   private static final int PROPERTY_ISOLATIONLEVEL_TAG = 6;
   private static final int PROPERTY_KEYCOLUMNS_TAG = 7;
   private static final int PROPERTY_MAP_TAG = 8;
   private static final int PROPERTY_MAXFIELDSIZE_TAG = 9;
   private static final int PROPERTY_MAXROWS_TAG = 10;
   private static final int PROPERTY_QUERYTIMEOUT_TAG = 11;
   private static final int PROPERTY_READONLY_TAG = 12;
   private static final int PROPERTY_ROWSETTYPE_TAG = 13;
   private static final int PROPERTY_SHOWDELETED_TAG = 14;
   private static final int PROPERTY_TABLENAME_TAG = 15;
   private static final int PROPERTY_URL_TAG = 16;
   private static final int PROPERTY_SYNCPROVIDER_TAG = 17;
   private static final int PROPERTY_NULL_TAG = 18;
   private static final int PROPERTY_COLUMN_TAG = 19;
   private static final int PROPERTY_TYPE_TAG = 20;
   private static final int PROPERTY_CLASS_TAG = 21;
   private static final int PROPERTY_SYNCPROVIDERNAME_TAG = 22;
   private static final int PROPERTY_SYNCPROVIDERVENDOR_TAG = 23;
   private static final int PROPERTY_SYNCPROVIDERVERSION_TAG = 24;
   private static final int PROPERTY_SYNCPROVIDERGRADE_TAG = 25;
   private static final int PROPERTY_DATASOURCELOCK_TAG = 26;
   private String[] metadataNames = new String[]{"column-count", "column-definition", "column-index", "auto-increment", "case-sensitive", "currency", "nullable", "signed", "searchable", "column-display-size", "column-label", "column-name", "schema-name", "column-precision", "column-scale", "table-name", "catalog-name", "column-type", "column-type-name", "null"};
   private static final int METADATA_COLUMNCOUNT_TAG = 0;
   private static final int METADATA_COLUMNDEFINITION_TAG = 1;
   private static final int METADATA_COLUMNINDEX_TAG = 2;
   private static final int METADATA_AUTOINCREMENT_TAG = 3;
   private static final int METADATA_CASESENSITIVE_TAG = 4;
   private static final int METADATA_CURRENCY_TAG = 5;
   private static final int METADATA_NULLABLE_TAG = 6;
   private static final int METADATA_SIGNED_TAG = 7;
   private static final int METADATA_SEARCHABLE_TAG = 8;
   private static final int METADATA_COLUMNDISPLAYSIZE_TAG = 9;
   private static final int METADATA_COLUMNLABEL_TAG = 10;
   private static final int METADATA_COLUMNNAME_TAG = 11;
   private static final int METADATA_SCHEMANAME_TAG = 12;
   private static final int METADATA_COLUMNPRECISION_TAG = 13;
   private static final int METADATA_COLUMNSCALE_TAG = 14;
   private static final int METADATA_TABLENAME_TAG = 15;
   private static final int METADATA_CATALOGNAME_TAG = 16;
   private static final int METADATA_COLUMNTYPE_TAG = 17;
   private static final int METADATA_COLUMNTYPENAME_TAG = 18;
   private static final int METADATA_NULL_TAG = 19;
   private String[] dataNames = new String[]{"currentRow", "insertRow", "deleteRow", "modifyRow", "columnValue", "updateValue", "null"};
   private static final int DATA_CURRENTROW_TAG = 0;
   private static final int DATA_INSERTROW_TAG = 1;
   private static final int DATA_DELETEROW_TAG = 2;
   private static final int DATA_MODIFYROW_TAG = 3;
   private static final int DATA_COLUMNVALUE_TAG = 4;
   private static final int DATA_UPDATEVALUE_TAG = 5;
   private static final int DATA_NULL_TAG = 6;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   OracleWebRowSetXmlReaderContHandler(RowSet var1) {
      this.wrset = (OracleWebRowSet)var1;
      this.initialize();
   }

   public void characters(char[] var1, int var2, int var3) throws SAXException {
      String var4 = new String(var1, var2, var3);
      this.processElement(var4);
   }

   public void endDocument() throws SAXException {
      try {
         if (this.readReadOnlyValue) {
            this.wrset.setReadOnly(this.readReadOnlyValue);
         }

      } catch (SQLException var2) {
         throw new SAXException(var2.getMessage());
      }
   }

   public void endElement(String var1, String var2, String var3) throws SAXException {
      String var4 = var2 != null && !var2.equals("") ? var2 : var3;
      int var5;
      switch(this.getState()) {
      case 1:
         if (var4.equals("properties")) {
            this.state = 0;
         } else {
            try {
               var5 = (Integer)this.propertyNameTagMap.get(var4);
               switch(var5) {
               case 7:
                  if (this.keyCols != null) {
                     int[] var16 = new int[this.keyCols.size()];

                     for(int var7 = 0; var7 < var16.length; ++var7) {
                        var16[var7] = Integer.parseInt((String)this.keyCols.elementAt(var7));
                     }

                     this.wrset.setKeyColumns(var16);
                  }
               }

               this.setPropertyValue(this.propertyValue);
            } catch (SQLException var15) {
               throw new SAXException(var15.getMessage());
            }

            this.propertyValue = "";
            this.setNullValue(false);
            this.setTag(-1);
         }
         break;
      case 2:
         if (var4.equals("metadata")) {
            try {
               this.wrset.setMetaData(this.rsetMetaData);
               this.state = 0;
            } catch (SQLException var14) {
               throw new SAXException("Error setting metadata in WebRowSet: " + var14.getMessage());
            }
         } else {
            try {
               this.setMetaDataValue(this.metadataValue);
            } catch (SQLException var13) {
               throw new SAXException("Error setting metadata value: " + var13.getMessage());
            }

            this.metadataValue = "";
            this.setNullValue(false);
            this.setTag(-1);
         }
         break;
      case 3:
         if (var4.equals("data")) {
            this.state = 0;
            return;
         }

         var5 = (Integer)this.dataNameTagMap.get(var4);
         OracleRow var6;
         switch(var5) {
         case 0:
            try {
               this.wrset.insertRow();
               this.wrset.moveToCurrentRow();
               this.wrset.next();
               var6 = this.wrset.getCurrentRow();
               var6.setInsertedFlag(false);
               this.applyUpdates();
               break;
            } catch (SQLException var11) {
               throw new SAXException("Error constructing current row: " + var11.getMessage());
            }
         case 1:
            try {
               this.wrset.insertRow();
               this.wrset.moveToCurrentRow();
               this.wrset.next();
               this.applyUpdates();
               break;
            } catch (SQLException var9) {
               throw new SAXException("Error constructing inserted row: " + var9.getMessage());
            }
         case 2:
            try {
               this.wrset.insertRow();
               this.wrset.moveToCurrentRow();
               this.wrset.next();
               var6 = this.wrset.getCurrentRow();
               var6.setInsertedFlag(false);
               var6.setRowDeleted(true);
               this.applyUpdates();
               break;
            } catch (SQLException var10) {
               throw new SAXException("Error constructing deleted row: " + var10.getMessage());
            }
         case 3:
            try {
               this.wrset.insertRow();
               this.wrset.moveToCurrentRow();
               this.wrset.next();
               var6 = this.wrset.getCurrentRow();
               var6.setRowDeleted(true);
               this.applyUpdates();
               break;
            } catch (SQLException var8) {
               throw new SAXException("Error constructing modified row: " + var8.getMessage());
            }
         case 4:
            try {
               ++this.columnIndex;
               this.insertValue(this.columnValue);
               this.columnValue = "";
               this.setNullValue(false);
               this.setTag(-1);
            } catch (SQLException var12) {
               throw new SAXException("Error inserting column values: " + var12.getMessage());
            }
         }
      }

   }

   public void startElement(String var1, String var2, String var3, Attributes var4) throws SAXException {
      String var5 = var2 != null && !var2.equals("") ? var2 : var3;
      switch(this.getState()) {
      case 1:
         int var6 = (Integer)this.propertyNameTagMap.get(var5);
         if (var6 == 18) {
            this.setNullValue(true);
            this.propertyValue = null;
         } else {
            this.setTag(var6);
         }
         break;
      case 2:
         int var7 = (Integer)this.metadataNameTagMap.get(var5);
         if (var7 == 19) {
            this.setNullValue(true);
            this.metadataValue = null;
         } else {
            this.setTag(var7);
         }
         break;
      case 3:
         int var8 = (Integer)this.dataNameTagMap.get(var5);
         if (var8 == 6) {
            this.setNullValue(true);
            this.columnValue = null;
         } else {
            this.setTag(var8);
            if (var8 == 0 || var8 == 1 || var8 == 2 || var8 == 3) {
               this.columnIndex = 0;

               try {
                  this.wrset.moveToInsertRow();
               } catch (SQLException var10) {
               }
            }
         }
         break;
      default:
         this.setState(var5);
      }

   }

   public void error(SAXParseException var1) throws SAXParseException {
      throw var1;
   }

   public void warning(SAXParseException var1) throws SAXParseException {
      System.out.println("** Warning, line " + var1.getLineNumber() + ", uri " + var1.getSystemId());
      System.out.println("   " + var1.getMessage());
   }

   private void initialize() {
      this.propertyNameTagMap = new Hashtable(30);
      int var1 = this.propertyNames.length;

      int var2;
      for(var2 = 0; var2 < var1; ++var2) {
         this.propertyNameTagMap.put(this.propertyNames[var2], var2);
      }

      this.metadataNameTagMap = new Hashtable(30);
      var1 = this.metadataNames.length;

      for(var2 = 0; var2 < var1; ++var2) {
         this.metadataNameTagMap.put(this.metadataNames[var2], var2);
      }

      this.dataNameTagMap = new Hashtable(10);
      var1 = this.dataNames.length;

      for(var2 = 0; var2 < var1; ++var2) {
         this.dataNameTagMap.put(this.dataNames[var2], var2);
      }

      this.updatesToRowSet = new Vector();
      this.columnValue = "";
      this.propertyValue = "";
      this.metadataValue = "";
      this.isNullValue = false;
      this.columnIndex = 0;
      this.readReadOnlyValue = false;
   }

   protected void processElement(String var1) throws SAXException {
      try {
         switch(this.getState()) {
         case 1:
            this.propertyValue = var1;
            break;
         case 2:
            this.metadataValue = var1;
            break;
         case 3:
            this.setDataValue(var1);
         }

      } catch (SQLException var3) {
         throw new SAXException("processElement: " + var3.getMessage());
      }
   }

   private BigDecimal getBigDecimalValue(String var1) {
      return new BigDecimal(var1);
   }

   private byte[] getBinaryValue(String var1) throws SQLException {
      byte[] var2 = XMLUtil.parseBase64Binary(var1);
      return var2;
   }

   private boolean getBooleanValue(String var1) {
      return Boolean.valueOf(var1);
   }

   private byte getByteValue(String var1) {
      return Byte.parseByte(var1);
   }

   private Date getDateValue(String var1) {
      return new Date(this.getLongValue(var1));
   }

   private double getDoubleValue(String var1) {
      return Double.parseDouble(var1);
   }

   private float getFloatValue(String var1) {
      return Float.parseFloat(var1);
   }

   private int getIntegerValue(String var1) {
      return Integer.parseInt(var1);
   }

   private long getLongValue(String var1) {
      return Long.parseLong(var1);
   }

   private boolean getNullValue() {
      return this.isNullValue;
   }

   private short getShortValue(String var1) {
      return Short.parseShort(var1);
   }

   private String getStringValue(String var1) {
      return var1;
   }

   private Time getTimeValue(String var1) {
      return new Time(this.getLongValue(var1));
   }

   private Timestamp getTimestampValue(String var1) {
      return new Timestamp(this.getLongValue(var1));
   }

   private Blob getBlobValue(String var1) throws SQLException {
      byte[] var2 = XMLUtil.parseBase64Binary(var1);
      return new OracleSerialBlob(var2);
   }

   private Clob getClobValue(String var1) throws SQLException {
      return new OracleSerialClob(var1.toCharArray());
   }

   private void applyUpdates() throws SAXException {
      if (this.updatesToRowSet.size() > 0) {
         try {
            Iterator var2 = this.updatesToRowSet.iterator();

            while(true) {
               if (!var2.hasNext()) {
                  this.wrset.updateRow();
                  break;
               }

               Object[] var1 = (Object[])((Object[])var2.next());
               this.columnIndex = (Integer)var1[0];
               this.insertValue((String)var1[1]);
            }
         } catch (SQLException var3) {
            throw new SAXException("Error updating row: " + var3.getMessage());
         }

         this.updatesToRowSet.removeAllElements();
      }

   }

   private void insertValue(String var1) throws SQLException {
      if (!this.getNullValue() && var1 != null) {
         int var2 = this.wrset.getMetaData().getColumnType(this.columnIndex);
         switch(var2) {
         case -15:
         case -9:
         case -1:
         case 1:
         case 12:
            this.wrset.updateString(this.columnIndex, this.getStringValue(var1));
            break;
         case -7:
            this.wrset.updateByte(this.columnIndex, this.getByteValue(var1));
            break;
         case -5:
            this.wrset.updateLong(this.columnIndex, this.getLongValue(var1));
            break;
         case -4:
         case -3:
         case -2:
            this.wrset.updateBytes(this.columnIndex, this.getBinaryValue(var1));
            break;
         case 2:
         case 3:
            this.wrset.updateObject(this.columnIndex, this.getBigDecimalValue(var1));
            break;
         case 4:
            this.wrset.updateInt(this.columnIndex, this.getIntegerValue(var1));
            break;
         case 5:
            this.wrset.updateShort(this.columnIndex, this.getShortValue(var1));
            break;
         case 6:
         case 7:
            this.wrset.updateFloat(this.columnIndex, this.getFloatValue(var1));
            break;
         case 8:
            this.wrset.updateDouble(this.columnIndex, this.getDoubleValue(var1));
            break;
         case 91:
            this.wrset.updateDate(this.columnIndex, this.getDateValue(var1));
            break;
         case 92:
            this.wrset.updateTime(this.columnIndex, this.getTimeValue(var1));
            break;
         case 93:
            this.wrset.updateTimestamp(this.columnIndex, this.getTimestampValue(var1));
            break;
         case 2004:
            this.wrset.updateBlob(this.columnIndex, this.getBlobValue(var1));
            break;
         case 2005:
            this.wrset.updateClob(this.columnIndex, this.getClobValue(var1));
            break;
         case 2011:
            this.wrset.updateNClob(this.columnIndex, (NClob)this.getClobValue(var1));
            break;
         default:
            throw new SQLException("The type " + var2 + " is not supported currently.");
         }

      } else {
         this.wrset.updateNull(this.columnIndex);
      }
   }

   private void setPropertyValue(String var1) throws SQLException {
      boolean var2 = this.getNullValue();
      SQLException var4;
      SQLException var5;
      switch(this.getTag()) {
      case 0:
         if (var2) {
            this.wrset.setCommand((String)null);
         } else {
            this.wrset.setCommand(var1);
         }
         break;
      case 1:
         if (var2) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var5.fillInStackTrace();
            throw var5;
         }

         this.wrset.setConcurrency(this.getIntegerValue(var1));
         break;
      case 2:
         if (var2) {
            this.wrset.setDataSourceName((String)null);
         } else {
            this.wrset.setDataSourceName(var1);
         }
         break;
      case 3:
         if (var2) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var5.fillInStackTrace();
            throw var5;
         }

         this.wrset.setEscapeProcessing(this.getBooleanValue(var1));
         break;
      case 4:
         if (var2) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var5.fillInStackTrace();
            throw var5;
         }

         int var3 = this.wrset.getType();
         if (var3 != 1005) {
            this.wrset.setFetchDirection(this.getIntegerValue(var1));
         }
         break;
      case 5:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.wrset.setFetchSize(this.getIntegerValue(var1));
         break;
      case 6:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.wrset.setTransactionIsolation(this.getIntegerValue(var1));
      case 7:
      case 8:
      case 17:
      case 18:
      case 20:
      case 21:
      default:
         break;
      case 9:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.wrset.setMaxFieldSize(this.getIntegerValue(var1));
         break;
      case 10:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.wrset.setMaxRows(this.getIntegerValue(var1));
         break;
      case 11:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.wrset.setQueryTimeout(this.getIntegerValue(var1));
         break;
      case 12:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.readReadOnlyValue = this.getBooleanValue(var1);
         break;
      case 13:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.wrset.setType(this.getIntegerValue(var1));
         break;
      case 14:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 357);
            var4.fillInStackTrace();
            throw var4;
         }

         this.wrset.setShowDeleted(this.getBooleanValue(var1));
         break;
      case 15:
         if (var2) {
            this.wrset.setTableName((String)null);
         } else {
            this.wrset.setTableName(var1);
         }
         break;
      case 16:
         if (var2) {
            this.wrset.setUrl((String)null);
         } else {
            this.wrset.setUrl(var1);
         }
         break;
      case 19:
         if (this.keyCols == null) {
            this.keyCols = new Vector();
         }

         this.keyCols.add(var1);
         break;
      case 22:
         if (var2) {
            this.wrset.setSyncProvider((String)null);
         } else {
            this.wrset.setSyncProvider(var1);
         }
      }

   }

   private void setMetaDataValue(String var1) throws SQLException {
      boolean var2 = this.getNullValue();
      SQLException var4;
      switch(this.getTag()) {
      case 0:
         if (var2) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var5.fillInStackTrace();
            throw var5;
         }

         int var3 = this.getIntegerValue(var1);
         this.rsetMetaData = new OracleRowSetMetaData(var3);
         this.columnIndex = 0;
      case 1:
      default:
         break;
      case 2:
         ++this.columnIndex;
         break;
      case 3:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setAutoIncrement(this.columnIndex, this.getBooleanValue(var1));
         break;
      case 4:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setCaseSensitive(this.columnIndex, this.getBooleanValue(var1));
         break;
      case 5:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setCurrency(this.columnIndex, this.getBooleanValue(var1));
         break;
      case 6:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setNullable(this.columnIndex, this.getIntegerValue(var1));
         break;
      case 7:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setSigned(this.columnIndex, this.getBooleanValue(var1));
         break;
      case 8:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setSearchable(this.columnIndex, this.getBooleanValue(var1));
         break;
      case 9:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setColumnDisplaySize(this.columnIndex, this.getIntegerValue(var1));
         break;
      case 10:
         if (var2) {
            this.rsetMetaData.setColumnLabel(this.columnIndex, (String)null);
         } else {
            this.rsetMetaData.setColumnLabel(this.columnIndex, var1);
         }
         break;
      case 11:
         if (var2) {
            this.rsetMetaData.setColumnName(this.columnIndex, (String)null);
         } else {
            this.rsetMetaData.setColumnName(this.columnIndex, var1);
         }
         break;
      case 12:
         if (var2) {
            this.rsetMetaData.setSchemaName(this.columnIndex, (String)null);
         } else {
            this.rsetMetaData.setSchemaName(this.columnIndex, var1);
         }
         break;
      case 13:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setPrecision(this.columnIndex, this.getIntegerValue(var1));
         break;
      case 14:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setScale(this.columnIndex, this.getIntegerValue(var1));
         break;
      case 15:
         if (var2) {
            this.rsetMetaData.setTableName(this.columnIndex, (String)null);
         } else {
            this.rsetMetaData.setTableName(this.columnIndex, var1);
         }
         break;
      case 16:
         if (var2) {
            this.rsetMetaData.setCatalogName(this.columnIndex, (String)null);
         } else {
            this.rsetMetaData.setCatalogName(this.columnIndex, var1);
         }
         break;
      case 17:
         if (var2) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 358);
            var4.fillInStackTrace();
            throw var4;
         }

         this.rsetMetaData.setColumnType(this.columnIndex, this.getIntegerValue(var1));
         break;
      case 18:
         if (var2) {
            this.rsetMetaData.setColumnTypeName(this.columnIndex, (String)null);
         } else {
            this.rsetMetaData.setColumnTypeName(this.columnIndex, var1);
         }
      }

   }

   private void setDataValue(String var1) throws SQLException {
      switch(this.getTag()) {
      case 1:
      case 2:
      case 3:
      default:
         break;
      case 4:
         this.columnValue = var1;
         break;
      case 5:
         Object[] var2 = new Object[]{this.columnIndex, var1};
         this.updatesToRowSet.add(var2);
      }

   }

   protected void setNullValue(boolean var1) {
      this.isNullValue = var1;
   }

   private int getState() {
      return this.state;
   }

   private int getTag() {
      return this.tag;
   }

   private void setState(String var1) throws SAXException {
      if (var1.equals("webRowSet")) {
         this.state = 0;
      } else if (var1.equals("properties")) {
         if (this.state != 1) {
            this.state = 1;
         } else {
            this.state = 0;
         }
      } else if (var1.equals("metadata")) {
         if (this.state != 2) {
            this.state = 2;
         } else {
            this.state = 0;
         }
      } else if (var1.equals("data")) {
         if (this.state != 3) {
            this.state = 3;
         } else {
            this.state = 0;
         }
      }

   }

   private void setTag(int var1) {
      this.tag = var1;
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
