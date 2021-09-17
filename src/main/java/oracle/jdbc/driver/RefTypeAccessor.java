//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.StructDescriptor;
import oracle.sql.TypeDescriptor;

class RefTypeAccessor extends TypeAccessor {
    static final int MAXLENGTH = -1;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    RefTypeAccessor(OracleStatement var1, String var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.REF_TYPE, var1, -1, var5);
        this.init(var1, 111, 111, var3, var5);
        this.initForDataAccess(var4, 0, var2);
    }

    RefTypeAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, String var10) throws SQLException {
        super(Representation.REF_TYPE, var1, -1, false);
        this.init(var1, 111, 111, var9, false);
        this.initForDescribe(111, var2, var3, var4, var5, var6, var7, var8, var9, var10);
        this.initForDataAccess(0, var2, var10);
    }

    RefTypeAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, String var10, OracleType var11) throws SQLException {
        super(Representation.REF_TYPE, var1, -1, false);
        this.init(var1, 111, 111, var9, false);
        this.describeOtype = var11;
        this.initForDescribe(111, var2, var3, var4, var5, var6, var7, var8, var9, var10);
        this.internalOtype = var11;
        this.initForDataAccess(0, var2, var10);
    }

    OracleType otypeFromName(String var1) throws SQLException {
        return (OracleType)(!this.outBind ? TypeDescriptor.getTypeDescriptor(var1, this.statement.connection).getPickler() : StructDescriptor.createDescriptor(var1, this.statement.connection).getOracleTypeADT());
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        super.initForDataAccess(var1, var2, var3);
        this.byteLength = this.statement.connection.refTypeAccessorByteLen;
    }

    REF getREF(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = this.pickledBytes(var1);
            OracleTypeADT var3 = (OracleTypeADT)this.internalOtype;
            return new REF(var3.getFullName(), this.statement.connection, var2);
        }
    }

    Object getObject(int var1) throws SQLException {
        return this.getObject(var1, this.statement.connection.getTypeMap());
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getREF(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        REF var3 = this.getREF(var1);
        return var3 == null ? null : var3.toJdbc(var2);
    }
}
