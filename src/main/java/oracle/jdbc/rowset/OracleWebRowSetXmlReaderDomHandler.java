package oracle.jdbc.rowset;

import javax.sql.RowSet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

class OracleWebRowSetXmlReaderDomHandler extends OracleWebRowSetXmlReaderContHandler {
   OracleWebRowSetXmlReaderDomHandler(RowSet var1) {
      super(var1);
   }

   void readXMLDocument(Document var1) throws SAXException {
      Element var2 = var1.getDocumentElement();
      this.startElement((String)null, (String)null, "webRowSet", (Attributes)null);
      Node var3 = var2.getElementsByTagName("properties").item(0);
      this.startElement((String)null, (String)null, "properties", (Attributes)null);
      NodeList var4 = var3.getChildNodes();
      int var5 = var4.getLength();

      for(int var8 = 0; var8 < var5; ++var8) {
         Node var6 = var4.item(var8);
         if (!(var6 instanceof Text)) {
            String var7 = var6.getNodeName();
            this.startElement((String)null, (String)null, var7, (Attributes)null);
            if (var6.hasChildNodes()) {
               this.processElement(var6.getFirstChild().getNodeValue());
            } else {
               this.processElement("");
            }

            this.endElement((String)null, (String)null, var7);
         }
      }

      this.endElement((String)null, (String)null, "properties");
      Node var25 = var2.getElementsByTagName("metadata").item(0);
      this.startElement((String)null, (String)null, "metadata", (Attributes)null);
      Node var9 = var25.getFirstChild().getNextSibling();
      String var10 = var9.getNodeName();
      this.startElement((String)null, (String)null, var10, (Attributes)null);
      this.processElement(var9.getFirstChild().getNodeValue());
      this.endElement((String)null, (String)null, var10);
      NodeList var11 = var25.getChildNodes();
      int var12 = var11.getLength();

      int var16;
      for(int var13 = 3; var13 < var12; ++var13) {
         Node var14 = var11.item(var13);
         NodeList var15 = var14.getChildNodes();
         var16 = var15.getLength();

         for(int var17 = 0; var17 < var16; ++var17) {
            Node var18 = var15.item(var17);
            if (!(var18 instanceof Text)) {
               String var19 = var18.getNodeName();
               this.startElement((String)null, (String)null, var19, (Attributes)null);
               if (var18.hasChildNodes()) {
                  this.processElement(var18.getFirstChild().getNodeValue());
               } else {
                  this.processElement("");
               }

               this.endElement((String)null, (String)null, var19);
            }
         }
      }

      this.endElement((String)null, (String)null, "metadata");
      Node var26 = var2.getElementsByTagName("data").item(0);
      this.startElement((String)null, (String)null, "data", (Attributes)null);
      NodeList var27 = var26.getChildNodes();
      int var28 = var27.getLength();

      for(var16 = 0; var16 < var28; ++var16) {
         Node var29 = var27.item(var16);
         if (!(var29 instanceof Text)) {
            String var30 = var29.getNodeName();
            this.startElement((String)null, (String)null, var30, (Attributes)null);
            NodeList var31 = var29.getChildNodes();
            int var20 = var31.getLength();

            for(int var21 = 0; var21 < var20; ++var21) {
               Node var22 = var31.item(var21);
               if (!(var22 instanceof Text)) {
                  String var23 = var22.getNodeName();
                  this.startElement((String)null, (String)null, var23, (Attributes)null);
                  String var24;
                  if (var22.hasChildNodes()) {
                     var24 = var22.getFirstChild().getNodeValue();
                     if (var24 == null) {
                        this.startElement((String)null, (String)null, "null", (Attributes)null);
                     }
                  } else {
                     var24 = "";
                  }

                  this.processElement(var24);
                  this.endElement((String)null, (String)null, var23);
               }
            }

            this.endElement((String)null, (String)null, var30);
         }
      }

      this.endElement((String)null, (String)null, "data");
      this.endElement((String)null, (String)null, "webRowSet");
      this.endDocument();
   }
}
