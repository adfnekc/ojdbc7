//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class TranslationCache {
    private Map<String, String> queryCache = new ConcurrentHashMap();
    private Map<Integer, TranslatedErrorInfo> errorCache = new ConcurrentHashMap();
    private Map<Integer, TranslatedErrorInfo> localErrorCache;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    TranslationCache(File var1) throws SQLException {
        if (var1 != null) {
            this.localErrorCache = new ConcurrentHashMap();
            this.readLocalErrorFile(var1);
        }

    }

    private void readLocalErrorFile(File var1) throws SQLException {
        SQLException var3;
        try {
            DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();
            var2.setValidating(true);
            DocumentBuilder var16 = var2.newDocumentBuilder();
            Document var4 = var16.parse(var1);
            int var5 = 0;
            TranslatedErrorInfo var6 = null;
            NodeList var7 = var4.getElementsByTagName("Exception");

            for(int var8 = 0; var8 < var7.getLength(); ++var8) {
                var6 = new TranslatedErrorInfo();
                Node var9 = var7.item(var8);
                NodeList var10 = var9.getChildNodes();

                for(int var11 = 0; var11 < var10.getLength(); ++var11) {
                    if (var10.item(var11).getNodeType() == 1) {
                        Element var12 = (Element)var10.item(var11);
                        if (var12.getTagName().equals("ORAError")) {
                            var5 = Integer.parseInt(var12.getFirstChild().getNodeValue());
                        } else if (var12.getTagName().equals("ErrorCode")) {
                            var6.setErrorCode(Integer.parseInt(var12.getFirstChild().getNodeValue()));
                        } else if (var12.getTagName().equals("SQLState")) {
                            var6.setSqlState(var12.getFirstChild().getNodeValue());
                        }
                    }
                }

                this.localErrorCache.put(var5, var6);
                var5 = 0;
            }

        } catch (IOException var13) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 277);
            var3.fillInStackTrace();
            throw var3;
        } catch (SAXException var14) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 278);
            var3.fillInStackTrace();
            throw var3;
        } catch (ParserConfigurationException var15) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 278);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    Map<String, String> getQueryCache() {
        return this.queryCache;
    }

    Map<Integer, TranslatedErrorInfo> getErrorCache() {
        return this.errorCache;
    }

    Map<Integer, TranslatedErrorInfo> getLocalErrorCache() {
        return this.localErrorCache;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
