//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.internal.JMSMessageProperties;

public abstract class InternalFactory {
    public InternalFactory() {
    }

    public static KeywordValueI createKeywordValue(int var0, String var1, byte[] var2) throws SQLException {
        return new KeywordValueI(var0, var1, var2);
    }

    public static KeywordValueLongI createKeywordValueLong(int var0, String var1, byte[] var2) throws SQLException {
        return new KeywordValueLongI(var0, var1, var2);
    }

    public static XSAttributeI createXSAttribute() throws SQLException {
        return new XSAttributeI();
    }

    public static XSNamespaceI createXSNamespace() throws SQLException {
        return new XSNamespaceI();
    }

    public static AQMessagePropertiesI createAQMessageProperties() throws SQLException {
        return new AQMessagePropertiesI();
    }

    public static AQAgentI createAQAgent() throws SQLException {
        return new AQAgentI();
    }

    public static AQMessageI createAQMessage(AQMessageProperties var0) throws SQLException {
        return new AQMessageI((AQMessagePropertiesI)var0);
    }

    public static JMSMessageI createJMSMessage(JMSMessageProperties var0) {
        return new JMSMessageI((JMSMessagePropertiesI)var0);
    }

    public static JMSMessagePropertiesI createJMSMessageProperties() throws SQLException {
        return new JMSMessagePropertiesI();
    }

    public static byte[] urowid2rowid(long[] var0) {
        return T4CRowidAccessor.rowidToString(var0);
    }

    public static long[] rowid2urowid(byte[] var0, int var1, int var2) throws SQLException {
        return T4CRowidAccessor.stringToRowid(var0, var1, var2);
    }

    public static XSSecureIdI createXSecureId() throws SQLException {
        return new XSSecureIdI();
    }

    public static XSPrincipalI createXSPrincipal() throws SQLException {
        return new XSPrincipalI();
    }

    public static XSKeyvalI createXSKeyval() throws SQLException {
        return new XSKeyvalI();
    }

    public static XSSessionNamespaceI createXSSessionNamespace() throws SQLException {
        return new XSSessionNamespaceI();
    }

    public static XSSessionParametersI createXSSessionParameters() throws SQLException {
        return new XSSessionParametersI();
    }
}
