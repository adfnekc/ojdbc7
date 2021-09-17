package oracle.jdbc.rowset;

import java.io.Reader;
import java.sql.SQLException;
import javax.sql.RowSetInternal;
import javax.sql.rowset.WebRowSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

class OracleWebRowSetXmlReaderImpl implements OracleWebRowSetXmlReader {
   private static final String JAVA_SAXPARSER_PROPERTY = "javax.xml.parsers.SAXParserFactory";
   private static final String JAVA_DOMPARSER_PROPERTY = "javax.xml.parsers.DocumentBuilderFactory";
   private static final String ORACLE_JAXP_SAXPARSER_FACTORY = "oracle.xml.jaxp.JXSAXParserFactory";
   private static final String ORACLE_JAXP_DOMPARSER_FACTORY = "oracle.xml.jaxp.JXDocumentBuilderFactory";
   private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
   private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
   private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
   private static final String WEBROWSET_SCHEMA = "http://java.sun.com/xml/ns/jdbc/webrowset.xsd";
   private Document document = null;
   private String parserStr = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public void readXML(WebRowSet var1, Reader var2) throws SQLException {
      this.parserStr = this.getSystemProperty("javax.xml.parsers.SAXParserFactory");
      if (this.parserStr != null) {
         this.readXMLSax((OracleWebRowSet)var1, var2);
      } else {
         this.parserStr = this.getSystemProperty("javax.xml.parsers.DocumentBuilderFactory");
         if (this.parserStr == null) {
            throw new SQLException("No valid JAXP parser property specified");
         }

         this.readXMLDom((OracleWebRowSet)var1, var2);
      }

   }

   public void readData(RowSetInternal var1) throws SQLException {
   }

   private void readXMLSax(OracleWebRowSet var1, Reader var2) throws SQLException {
      try {
         InputSource var3 = new InputSource(var2);
         OracleWebRowSetXmlReaderContHandler var4 = new OracleWebRowSetXmlReaderContHandler(var1);
         SAXParserFactory var5 = SAXParserFactory.newInstance();
         var5.setNamespaceAware(true);
         var5.setValidating(true);
         SAXParser var6 = var5.newSAXParser();
         var6.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
         var6.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource", "http://java.sun.com/xml/ns/jdbc/webrowset.xsd");
         XMLReader var7 = var6.getXMLReader();
         var7.setContentHandler(var4);
         var7.parse(var3);
      } catch (SAXParseException var8) {
         System.out.println("** Parsing error, line " + var8.getLineNumber() + ", uri " + var8.getSystemId());
         System.out.println("   " + var8.getMessage());
         var8.printStackTrace();
         throw new SQLException(var8.getMessage());
      } catch (SAXNotRecognizedException var9) {
         var9.printStackTrace();
         throw new SQLException("readXMLSax: SAXNotRecognizedException: " + var9.getMessage());
      } catch (SAXException var10) {
         var10.printStackTrace();
         throw new SQLException("readXMLSax: SAXException: " + var10.getMessage());
      } catch (FactoryConfigurationError var11) {
         var11.printStackTrace();
         throw new SQLException("readXMLSax: Parser factory config: " + var11.getMessage());
      } catch (ParserConfigurationException var12) {
         var12.printStackTrace();
         throw new SQLException("readXMLSax: Parser config: " + var12.getMessage());
      } catch (Exception var13) {
         var13.printStackTrace();
         throw new SQLException("readXMLSax: " + var13.getMessage());
      }
   }

   private void readXMLDom(OracleWebRowSet var1, Reader var2) throws SQLException {
      try {
         InputSource var3 = new InputSource(var2);
         OracleWebRowSetXmlReaderDomHandler var4 = new OracleWebRowSetXmlReaderDomHandler(var1);
         DocumentBuilderFactory var5 = DocumentBuilderFactory.newInstance();
         var5.setNamespaceAware(true);
         var5.setValidating(true);
         var5.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
         var5.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", "http://java.sun.com/xml/ns/jdbc/webrowset.xsd");
         DocumentBuilder var6 = var5.newDocumentBuilder();
         this.document = var6.parse(var3);
         var4.readXMLDocument(this.document);
      } catch (SAXException var7) {
         var7.printStackTrace();
         throw new SQLException("readXMLDom: SAXException: " + var7.getMessage());
      } catch (FactoryConfigurationError var8) {
         var8.printStackTrace();
         throw new SQLException("readXMLDom: Parser factory config: " + var8.getMessage());
      } catch (ParserConfigurationException var9) {
         var9.printStackTrace();
         throw new SQLException("readXMLDom: Parser config: " + var9.getMessage());
      } catch (Exception var10) {
         var10.printStackTrace();
         throw new SQLException("readXMLDom: " + var10.getMessage());
      }
   }

   private String getSystemProperty(String var1) {
      String var2 = null;

      try {
         var2 = System.getProperty(var1);
      } catch (SecurityException var4) {
         var2 = null;
      }

      return var2;
   }
}
