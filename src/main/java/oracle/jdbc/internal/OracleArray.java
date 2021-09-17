//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.ArrayDescriptor;
import oracle.sql.Datum;

public interface OracleArray extends OracleDatumWithConnection, oracle.jdbc.OracleArray, ACProxyable {
    int ACCESS_FORWARD = 1;
    int ACCESS_REVERSE = 2;
    int ACCESS_UNKNOWN = 3;

    Datum[] getOracleArray() throws SQLException;

    Datum[] getOracleArray(long var1, int var3) throws SQLException;

    void setAutoBuffering(boolean var1) throws SQLException;

    boolean getAutoBuffering() throws SQLException;

    void setAutoIndexing(boolean var1, int var2) throws SQLException;

    void setAutoIndexing(boolean var1) throws SQLException;

    boolean getAutoIndexing() throws SQLException;

    int getAccessDirection() throws SQLException;

    ArrayDescriptor getDescriptor() throws SQLException;

    Map getMap() throws SQLException;

    byte[] toBytes() throws SQLException;

    void setDatumArray(Datum[] var1);

    void setObjArray(Object var1) throws SQLException;

    void setLocator(byte[] var1);

    void setPrefixSegment(byte[] var1);

    void setPrefixFlag(byte var1);

    byte[] getLocator();

    void setLength(int var1);

    boolean hasDataSeg();

    boolean isInline();

    boolean isConvertibleTo(Class var1);

    Object makeJdbcArray(int var1);

    void setLastIndexOffset(long var1, long var3) throws SQLException;

    void setIndexOffset(long var1, long var3) throws SQLException;

    long getLastIndex() throws SQLException;

    long getLastOffset() throws SQLException;

    long getOffset(long var1) throws SQLException;

    void setImage(byte[] var1, long var2, long var4) throws SQLException;

    void setImageLength(long var1) throws SQLException;

    long getImageOffset();

    long getImageLength();
}
