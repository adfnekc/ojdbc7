//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class TDSPatch {
    static final int S_NORMAL_PATCH = 0;
    static final int S_SIMPLE_PATCH = 1;
    int typeId;
    OracleType owner;
    long position;
    int uptCode;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public TDSPatch(int var1, OracleType var2, long var3, int var5) throws SQLException {
        this.typeId = var1;
        this.owner = var2;
        this.position = var3;
        this.uptCode = var5;
    }

    int getType() throws SQLException {
        return this.typeId;
    }

    OracleNamedType getOwner() throws SQLException {
        return (OracleNamedType)this.owner;
    }

    long getPosition() throws SQLException {
        return this.position;
    }

    byte getUptTypeCode() throws SQLException {
        return (byte)this.uptCode;
    }

    void apply(OracleType var1) throws SQLException {
        this.apply(var1, -1);
    }

    void apply(OracleType var1, int var2) throws SQLException {
        OracleNamedType var4;
        if (this.typeId == 0) {
            OracleTypeUPT var3 = (OracleTypeUPT)this.owner;
            var3.realType = (OracleTypeADT)var1;
            if (var1 instanceof OracleNamedType) {
                var4 = (OracleNamedType)var1;
                var4.setParent(var3.getParent());
                var4.setOrder(var3.getOrder());
            }
        } else {
            if (this.typeId != 1) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                var6.fillInStackTrace();
                throw var6;
            }

            OracleTypeCOLLECTION var5 = (OracleTypeCOLLECTION)this.owner;
            var5.opcode = var2;
            var5.elementType = var1;
            if (var1 instanceof OracleNamedType) {
                var4 = (OracleNamedType)var1;
                var4.setParent(var5);
                var4.setOrder(1);
            }
        }

    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
