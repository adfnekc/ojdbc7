//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.Array;
import java.sql.SQLException;

public interface OracleArray extends Array {
    OracleTypeMetaData getOracleMetaData() throws SQLException;

    int length() throws SQLException;

    String getSQLTypeName() throws SQLException;

    Object toJdbc() throws SQLException;

    int[] getIntArray() throws SQLException;

    int[] getIntArray(long var1, int var3) throws SQLException;

    double[] getDoubleArray() throws SQLException;

    double[] getDoubleArray(long var1, int var3) throws SQLException;

    short[] getShortArray() throws SQLException;

    short[] getShortArray(long var1, int var3) throws SQLException;

    long[] getLongArray() throws SQLException;

    long[] getLongArray(long var1, int var3) throws SQLException;

    float[] getFloatArray() throws SQLException;

    float[] getFloatArray(long var1, int var3) throws SQLException;
}
