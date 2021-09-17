//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.Datum;
import oracle.sql.INTERVALYM;

class IntervalymAccessor extends Accessor {
    static final int MAXLENGTH = 5;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    IntervalymAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.INTERVALYM, var1, 5, var5);
        this.init(var1, 182, 182, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    IntervalymAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.INTERVALYM, var1, 5, false);
        this.init(var1, 182, 182, var9, false);
        this.initForDescribe(182, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    String getString(int var1) throws SQLException {
        return this.isNull(var1) ? null : this.getINTERVALYM(var1).toString();
    }

    Object getObject(int var1) throws SQLException {
        return this.getINTERVALYM(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getINTERVALYM(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getINTERVALYM(var1);
    }

    INTERVALYM getINTERVALYM(int var1) throws SQLException {
        return this.isNull(var1) ? null : new INTERVALYM(this.getBytesInternal(var1));
    }
}
