//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;

class IntervaldsAccessor extends Accessor {
    static final int MAXLENGTH = 11;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    IntervaldsAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.INTERVALDS, var1, 11, var5);
        this.init(var1, 183, 183, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    IntervaldsAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.INTERVALDS, var1, 11, false);
        this.init(var1, 183, 183, var9, false);
        this.initForDescribe(183, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    String getString(int var1) throws SQLException {
        return this.isNull(var1) ? null : this.getINTERVALDS(var1).toString();
    }

    Object getObject(int var1) throws SQLException {
        return this.getINTERVALDS(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getINTERVALDS(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getINTERVALDS(var1);
    }

    INTERVALDS getINTERVALDS(int var1) throws SQLException {
        return this.isNull(var1) ? null : new INTERVALDS(this.getBytesInternal(var1));
    }
}
