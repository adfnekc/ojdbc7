//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import oracle.jdbc.OracleConnection;

public interface OracleDatumWithConnection {
    byte[] shareBytes();

    long getLength();

    void setBytes(byte[] var1);

    void setShareBytes(byte[] var1);

    byte[] getBytes();

    InputStream getStream() throws SQLException;

    String stringValue() throws SQLException;

    String stringValue(Connection var1) throws SQLException;

    boolean booleanValue() throws SQLException;

    int intValue() throws SQLException;

    long longValue() throws SQLException;

    float floatValue() throws SQLException;

    double doubleValue() throws SQLException;

    byte byteValue() throws SQLException;

    BigDecimal bigDecimalValue() throws SQLException;

    Date dateValue() throws SQLException;

    Time timeValue() throws SQLException;

    Time timeValue(Calendar var1) throws SQLException;

    Timestamp timestampValue() throws SQLException;

    Timestamp timestampValue(Calendar var1) throws SQLException;

    Reader characterStreamValue() throws SQLException;

    InputStream asciiStreamValue() throws SQLException;

    InputStream binaryStreamValue() throws SQLException;

    boolean isConvertibleTo(Class var1);

    Object toJdbc() throws SQLException;

    Object makeJdbcArray(int var1);

    Connection getJavaSqlConnection() throws SQLException;

    OracleConnection getOracleConnection() throws SQLException;

    oracle.jdbc.internal.OracleConnection getInternalConnection() throws SQLException;

    oracle.jdbc.driver.OracleConnection getConnection() throws SQLException;

    void setPhysicalConnectionOf(Connection var1);
}
