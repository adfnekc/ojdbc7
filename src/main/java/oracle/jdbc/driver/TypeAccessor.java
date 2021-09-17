//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.oracore.OracleType;

abstract class TypeAccessor extends Accessor {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    TypeAccessor(Representation var1, OracleStatement var2, int var3, boolean var4) {
        super(var1, var2, var3, var4);
    }

    abstract OracleType otypeFromName(String var1) throws SQLException;

    void initForDescribe(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, String var10) throws SQLException {
        this.describeTypeName = var10;
        this.initForDescribe(var1, var2, var3, var5, var6, var4, var7, var8, var9);
    }

    byte[] pickledBytes(int var1) throws SQLException {
        return this.getBytesInternal(var1);
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        if (var1 != 0) {
            this.externalType = var1;
        }

        this.internalTypeName = var3;
    }

    void initMetadata() throws SQLException {
        if (this.describeOtype == null && this.describeTypeName != null) {
            this.describeOtype = this.otypeFromName(this.describeTypeName);
        }

        if (this.internalOtype == null && this.internalTypeName != null) {
            this.internalOtype = this.otypeFromName(this.internalTypeName);
        }

    }

    long updateChecksum(long var1, int var3) throws SQLException {
        byte[] var4 = this.pickledBytes(var3);
        CRC64 var10000;
        if (var4 != null && var4.length != 0) {
            var10000 = PhysicalConnection.CHECKSUM;
            var1 = CRC64.updateChecksum(var1, var4, 0, var4.length);
        } else {
            var10000 = PhysicalConnection.CHECKSUM;
            var1 = CRC64.updateChecksum(var1, NULL_DATA_BYTES, 0, NULL_DATA_BYTES.length);
        }

        return var1;
    }
}
