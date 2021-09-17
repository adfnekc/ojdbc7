package oracle.jdbc.rowset;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;
import javax.sql.RowSet;
import javax.sql.RowSetInternal;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.spi.SyncProvider;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.xml.util.XMLUtil;

class OracleWebRowSetXmlWriterImpl implements OracleWebRowSetXmlWriter {
   private Writer xmlWriter;
   private Stack xmlTagStack;
   private static final String WEBROWSET_ELEMENT = "webRowSet";
   private static final String PROPERTIES_ELEMENT = "properties";
   private static final String METADATA_ELEMENT = "metadata";
   private static final String DATA_ELEMENT = "data";
   private static final String PROPERTY_COMMAND = "command";
   private static final String PROPERTY_CONCURRENCY = "concurrency";
   private static final String PROPERTY_DATASOURCE = "datasource";
   private static final String PROPERTY_ESCAPEPROCESSING = "escape-processing";
   private static final String PROPERTY_FETCHDIRECTION = "fetch-direction";
   private static final String PROPERTY_FETCHSIZE = "fetch-size";
   private static final String PROPERTY_ISOLATIONLEVEL = "isolation-level";
   private static final String PROPERTY_KEYCOLUMNS = "key-columns";
   private static final String PROPERTY_MAP = "map";
   private static final String PROPERTY_MAXFIELDSIZE = "max-field-size";
   private static final String PROPERTY_MAXROWS = "max-rows";
   private static final String PROPERTY_QUERYTIMEOUT = "query-timeout";
   private static final String PROPERTY_READONLY = "read-only";
   private static final String PROPERTY_ROWSETTYPE = "rowset-type";
   private static final String PROPERTY_SHOWDELETED = "show-deleted";
   private static final String PROPERTY_TABLENAME = "table-name";
   private static final String PROPERTY_URL = "url";
   private static final String PROPERTY_SYNCPROVIDER = "sync-provider";
   private static final String PROPERTY_NULL = "null";
   private static final String PROPERTY_KC_COLUMN = "column";
   private static final String PROPERTY_MAP_TYPE = "type";
   private static final String PROPERTY_MAP_CLASS = "class";
   private static final String PROPERTY_S_PROVIDERNAME = "sync-provider-name";
   private static final String PROPERTY_S_PROVIDERVENDOR = "sync-provider-vendor";
   private static final String PROPERTY_S_PROVIDERVERSION = "sync-provider-version";
   private static final String PROPERTY_S_PROVIDERGRADE = "sync-provider-grade";
   private static final String PROPERTY_S_DATASOURCELOCK = "data-source-lock";
   private static final String METADATA_COLUMNCOUNT = "column-count";
   private static final String METADATA_COLUMNDEFINITION = "column-definition";
   private static final String METADATA_COLUMNINDEX = "column-index";
   private static final String METADATA_AUTOINCREMENT = "auto-increment";
   private static final String METADATA_CASESENSITIVE = "case-sensitive";
   private static final String METADATA_CURRENCY = "currency";
   private static final String METADATA_NULLABLE = "nullable";
   private static final String METADATA_SIGNED = "signed";
   private static final String METADATA_SEARCHABLE = "searchable";
   private static final String METADATA_COLUMNDISPLAYSIZE = "column-display-size";
   private static final String METADATA_COLUMNLABEL = "column-label";
   private static final String METADATA_COLUMNNAME = "column-name";
   private static final String METADATA_SCHEMANAME = "schema-name";
   private static final String METADATA_COLUMNPRECISION = "column-precision";
   private static final String METADATA_COLUMNSCALE = "column-scale";
   private static final String METADATA_TABLENAME = "table-name";
   private static final String METADATA_CATALOGNAME = "catalog-name";
   private static final String METADATA_COLUMNTYPE = "column-type";
   private static final String METADATA_COLUMNTYPENAME = "column-type-name";
   private static final String METADATA_NULL = "null";
   private static final String DATA_CURRENTROW = "currentRow";
   private static final String DATA_INSERTROW = "insertRow";
   private static final String DATA_DELETEROW = "deleteRow";
   private static final String DATA_MODIFYROW = "modifyRow";
   private static final String DATA_COLUMNVALUE = "columnValue";
   private static final String DATA_UPDATEVALUE = "updateValue";
   private static final String DATA_NULL = "null";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public void writeXML(WebRowSet var1, Writer var2) throws SQLException {
      if (!(var1 instanceof OracleWebRowSet)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 359);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.xmlTagStack = new Stack();
         this.xmlWriter = var2;
         this.writeRowSet((OracleWebRowSet)var1);
      }
   }

   public boolean writeData(RowSetInternal var1) throws SQLException {
      return false;
   }

   private void writeRowSet(OracleWebRowSet var1) throws SQLException {
      try {
         this.writeHeaderAndStartWebRowSetElement();
         this.writeProperties(var1);
         this.writeMetaData(var1);
         this.writeData(var1);
         this.endWebRowSetElement();
      } catch (IOException var3) {
         throw new SQLException("IOException: " + var3.getMessage());
      }
   }

   private void writeHeaderAndStartWebRowSetElement() throws IOException {
      this.xmlWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      this.xmlWriter.write("\n");
      this.setCurrentTag("webRowSet");
      this.xmlWriter.write("<webRowSet xmlns=\"http://java.sun.com/xml/ns/jdbc\"\n");
      this.xmlWriter.write("           xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
      this.xmlWriter.write("           xsi:schemaLocation=\"http://java.sun.com/xml/ns/jdbc ");
      this.xmlWriter.write("http://java.sun.com/xml/ns/jdbc/webrowset.xsd");
      this.xmlWriter.write("\">\n");
   }

   private void endWebRowSetElement() throws IOException {
      this.endTag("webRowSet");
   }

   private void startElement(String var1) throws IOException {
      this.startTag(var1);
      this.xmlWriter.write("\n");
   }

   private void endElement(String var1) throws IOException {
      this.writeIndent(this.xmlTagStack.size());
      this.endTag(var1);
   }

   private void endElement() throws IOException {
      this.writeIndent(this.xmlTagStack.size());
      String var1 = this.getCurrentTag();
      this.xmlWriter.write("</" + var1 + ">\n");
      this.xmlWriter.flush();
   }

   private void startTag(String var1) throws IOException {
      this.setCurrentTag(var1);
      this.writeIndent(this.xmlTagStack.size());
      this.xmlWriter.write("<" + var1 + ">");
   }

   private void endTag(String var1) throws IOException {
      String var2 = this.getCurrentTag();
      if (var1.equals(var2)) {
         this.xmlWriter.write("</" + var2 + ">\n");
      }

      this.xmlWriter.flush();
   }

   private void setCurrentTag(String var1) {
      this.xmlTagStack.push(var1);
   }

   private String getCurrentTag() {
      return (String)this.xmlTagStack.pop();
   }

   private void writeEmptyElement(String var1) throws IOException {
      this.xmlWriter.write("<" + var1 + "/>");
   }

   private void writeProperties(OracleWebRowSet var1) throws IOException {
      this.startElement("properties");

      try {
         this.writeElementString("command", var1.getCommand());
         this.writeElementInteger("concurrency", var1.getConcurrency());
         this.writeElementString("datasource", var1.getDataSourceName());
         this.writeElementBoolean("escape-processing", var1.getEscapeProcessing());
         this.writeElementInteger("fetch-direction", var1.getFetchDirection());
         this.writeElementInteger("fetch-size", var1.getFetchSize());
         this.writeElementInteger("isolation-level", var1.getTransactionIsolation());
         this.startElement("key-columns");
         int[] var2 = var1.getKeyColumns();
         int var3 = 0;

         while(true) {
            if (var2 == null || var3 >= var2.length) {
               this.endElement("key-columns");
               this.startElement("map");
               Map var9 = var1.getTypeMap();
               if (var9 != null) {
                  Set var5 = var9.entrySet();
                  Iterator var6 = var5.iterator();

                  while(var6.hasNext()) {
                     Entry var7 = (Entry)var6.next();
                     this.writeElementString("type", (String)var7.getKey());
                     this.writeElementString("class", ((Class)var7.getValue()).getName());
                  }
               }

               this.endElement("map");
               this.writeElementInteger("max-field-size", var1.getMaxFieldSize());
               this.writeElementInteger("max-rows", var1.getMaxRows());
               this.writeElementInteger("query-timeout", var1.getQueryTimeout());
               this.writeElementBoolean("read-only", var1.isReadOnly());
               this.writeElementInteger("rowset-type", var1.getType());
               this.writeElementBoolean("show-deleted", var1.getShowDeleted());
               this.writeElementString("table-name", var1.getTableName());
               this.writeElementString("url", var1.getUrl());
               this.startElement("sync-provider");
               SyncProvider var4 = var1.getSyncProvider();
               this.writeElementString("sync-provider-name", var4.getProviderID());
               this.writeElementString("sync-provider-vendor", var4.getVendor());
               this.writeElementString("sync-provider-version", var4.getVersion());
               this.writeElementInteger("sync-provider-grade", var4.getProviderGrade());
               this.writeElementInteger("data-source-lock", var4.getDataSourceLock());
               this.endElement("sync-provider");
               break;
            }

            this.writeElementInteger("column", var2[var3]);
            ++var3;
         }
      } catch (SQLException var8) {
         throw new IOException("SQLException: " + var8.getMessage());
      }

      this.endElement("properties");
   }

   private void writeMetaData(OracleWebRowSet var1) throws IOException {
      this.startElement("metadata");

      try {
         ResultSetMetaData var2 = var1.getMetaData();
         int var3 = var2.getColumnCount();
         this.writeElementInteger("column-count", var3);

         for(int var4 = 1; var4 <= var3; ++var4) {
            this.startElement("column-definition");
            this.writeElementInteger("column-index", var4);
            this.writeElementBoolean("auto-increment", var2.isAutoIncrement(var4));
            this.writeElementBoolean("case-sensitive", var2.isCaseSensitive(var4));
            this.writeElementBoolean("currency", var2.isCurrency(var4));
            this.writeElementInteger("nullable", var2.isNullable(var4));
            this.writeElementBoolean("signed", var2.isSigned(var4));
            this.writeElementBoolean("searchable", var2.isSearchable(var4));
            this.writeElementInteger("column-display-size", var2.getColumnDisplaySize(var4));
            this.writeElementString("column-label", var2.getColumnLabel(var4));
            this.writeElementString("column-name", var2.getColumnName(var4));
            this.writeElementString("schema-name", var2.getSchemaName(var4));
            this.writeElementInteger("column-precision", var2.getPrecision(var4));
            this.writeElementInteger("column-scale", var2.getScale(var4));
            this.writeElementString("table-name", var2.getTableName(var4));
            this.writeElementString("catalog-name", var2.getCatalogName(var4));
            this.writeElementInteger("column-type", var2.getColumnType(var4));
            this.writeElementString("column-type-name", var2.getColumnTypeName(var4));
            this.endElement("column-definition");
         }
      } catch (SQLException var5) {
         throw new IOException("SQLException: " + var5.getMessage());
      }

      this.endElement("metadata");
   }

   private void writeElementBoolean(String var1, boolean var2) throws IOException {
      this.startTag(var1);
      this.writeBoolean(var2);
      this.endTag(var1);
   }

   private void writeElementInteger(String var1, int var2) throws IOException {
      this.startTag(var1);
      this.writeInteger(var2);
      this.endTag(var1);
   }

   private void writeElementString(String var1, String var2) throws IOException {
      this.startTag(var1);
      this.writeString(var2);
      this.endTag(var1);
   }

   private void writeData(OracleWebRowSet var1) throws IOException {
      try {
         ResultSetMetaData var2 = var1.getMetaData();
         int var3 = var2.getColumnCount();
         this.startElement("data");
         var1.beforeFirst();
         var1.setShowDeleted(true);

         while(var1.next()) {
            if (var1.rowDeleted() && var1.rowInserted()) {
               this.startElement("modifyRow");
            } else if (var1.rowDeleted()) {
               this.startElement("deleteRow");
            } else if (var1.rowInserted()) {
               this.startElement("insertRow");
            } else {
               this.startElement("currentRow");
            }

            for(int var4 = 1; var4 <= var3; ++var4) {
               if (var1.columnUpdated(var4)) {
                  ResultSet var5 = var1.getOriginalRow();
                  var5.next();
                  this.startTag("columnValue");
                  this.writeValue(var4, (RowSet)var5);
                  this.endTag("columnValue");
                  this.startTag("updateValue");
                  this.writeValue(var4, var1);
                  this.endTag("updateValue");
               } else {
                  this.startTag("columnValue");
                  this.writeValue(var4, var1);
                  this.endTag("columnValue");
               }
            }

            this.endElement();
         }

         this.endElement("data");
      } catch (SQLException var6) {
         throw new IOException("SQLException: " + var6.getMessage());
      }
   }

   private void writeBigDecimal(BigDecimal var1) throws IOException {
      if (var1 != null) {
         this.xmlWriter.write(var1.toString());
      } else {
         this.writeEmptyElement("null");
      }

   }

   private void writeBoolean(boolean var1) throws IOException {
      this.xmlWriter.write(Boolean.valueOf(var1).toString());
   }

   private void writeDouble(double var1) throws IOException {
      this.xmlWriter.write(Double.toString(var1));
   }

   private void writeFloat(float var1) throws IOException {
      this.xmlWriter.write(Float.toString(var1));
   }

   private void writeInteger(int var1) throws IOException {
      this.xmlWriter.write(Integer.toString(var1));
   }

   private void writeLong(long var1) throws IOException {
      this.xmlWriter.write(Long.toString(var1));
   }

   private void writeNull() throws IOException {
      this.writeEmptyElement("null");
   }

   private void writeShort(short var1) throws IOException {
      this.xmlWriter.write(Short.toString(var1));
   }

   private void writeBytes(byte[] var1) throws IOException {
      String var2 = XMLUtil.printBase64Binary(var1);
      this.xmlWriter.write(var2);
   }

   private void writeString(String var1) throws IOException {
      if (var1 != null) {
         this.xmlWriter.write(var1);
      } else {
         this.xmlWriter.write("");
      }

   }

   private void writeIndent(int var1) throws IOException {
      for(int var2 = 1; var2 < var1; ++var2) {
         this.xmlWriter.write("  ");
      }

   }

   private void writeValue(int var1, RowSet var2) throws IOException {
      try {
         int var3 = var2.getMetaData().getColumnType(var1);
         switch(var3) {
         case -15:
         case -9:
         case -1:
         case 1:
         case 12:
         case 2005:
         case 2011:
            String var16 = var2.getString(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeString(var16);
            }
            break;
         case -7:
         case 5:
            short var4 = var2.getShort(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeShort(var4);
            }
            break;
         case -5:
            long var6 = var2.getLong(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeLong(var6);
            }
            break;
         case -4:
         case -3:
         case -2:
         case 2004:
            byte[] var15 = var2.getBytes(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeBytes(var15);
            }
            break;
         case 2:
         case 3:
            BigDecimal var11 = var2.getBigDecimal(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeBigDecimal(var11);
            }
            break;
         case 4:
            int var5 = var2.getInt(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeInteger(var5);
            }
            break;
         case 6:
         case 7:
            float var8 = var2.getFloat(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeFloat(var8);
            }
            break;
         case 8:
            double var9 = var2.getDouble(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeDouble(var9);
            }
            break;
         case 91:
            Date var12 = var2.getDate(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeLong(var12.getTime());
            }
            break;
         case 92:
            Time var13 = var2.getTime(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeLong(var13.getTime());
            }
            break;
         case 93:
            Timestamp var14 = var2.getTimestamp(var1);
            if (var2.wasNull()) {
               this.writeNull();
            } else {
               this.writeLong(var14.getTime());
            }
            break;
         default:
            throw new SQLException("The type " + var3 + " is not supported currently.");
         }

      } catch (SQLException var17) {
         throw new IOException("Failed to writeValue: " + var17.getMessage());
      }
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
