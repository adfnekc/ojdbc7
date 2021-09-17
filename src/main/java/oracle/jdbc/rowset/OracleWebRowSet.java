package oracle.jdbc.rowset;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.WebRowSet;
import oracle.jdbc.driver.DatabaseError;

public class OracleWebRowSet extends OracleCachedRowSet implements WebRowSet {
   static final long serialVersionUID = 617253792409477080L;
   private transient OracleWebRowSetXmlReader xmlReader = new OracleWebRowSetXmlReaderImpl();
   private transient OracleWebRowSetXmlWriter xmlWriter = new OracleWebRowSetXmlWriterImpl();
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleWebRowSet() throws SQLException {
      this.setReadOnly(false);
   }

   public void readXml(Reader var1) throws SQLException {
      if (this.xmlReader != null) {
         this.xmlReader.readXML(this, var1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 355);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public void writeXml(Writer var1) throws SQLException {
      if (this.xmlWriter != null) {
         this.xmlWriter.writeXML(this, var1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 356);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public void writeXml(ResultSet var1, Writer var2) throws SQLException {
      this.populate(var1);
      this.writeXml(var2);
   }

   public void readXml(InputStream var1) throws SQLException {
      this.readXml((Reader)(new InputStreamReader(var1)));
   }

   public void writeXml(OutputStream var1) throws SQLException {
      this.writeXml((Writer)(new OutputStreamWriter(var1)));
   }

   public void writeXml(ResultSet var1, OutputStream var2) throws SQLException {
      this.writeXml(var1, (Writer)(new OutputStreamWriter(var2)));
   }
}
