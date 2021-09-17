//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.internal.OracleNClob;

/** @deprecated */
public class NCLOB extends CLOB implements OracleNClob {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected NCLOB() {
    }

    public NCLOB(OracleConnection var1) throws SQLException {
        this(var1, (byte[])null);
    }

    public NCLOB(OracleConnection var1, byte[] var2) throws SQLException {
        super(var1, var2, (short)2);
    }

    public NCLOB(CLOB var1) throws SQLException {
        this(var1.getPhysicalConnection(), var1.getBytes());
    }
}
