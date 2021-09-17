//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;
import oracle.sql.ANYDATA;
import oracle.sql.RAW;
import oracle.sql.STRUCT;
import oracle.xdb.XMLType;

public interface AQMessage {
    byte[] getMessageId() throws SQLException;

    AQMessageProperties getMessageProperties() throws SQLException;

    void setPayload(byte[] var1) throws SQLException;

    void setPayload(byte[] var1, byte[] var2) throws SQLException;

    void setPayload(STRUCT var1) throws SQLException;

    void setPayload(ANYDATA var1) throws SQLException;

    void setPayload(RAW var1) throws SQLException;

    void setPayload(XMLType var1) throws SQLException;

    byte[] getPayload() throws SQLException;

    byte[] getPayloadTOID();

    STRUCT getSTRUCTPayload() throws SQLException;

    boolean isSTRUCTPayload() throws SQLException;

    ANYDATA getANYDATAPayload() throws SQLException;

    boolean isANYDATAPayload() throws SQLException;

    RAW getRAWPayload() throws SQLException;

    boolean isRAWPayload() throws SQLException;

    XMLType getXMLTypePayload() throws SQLException;

    boolean isXMLTypePayload() throws SQLException;

    String toString();
}
