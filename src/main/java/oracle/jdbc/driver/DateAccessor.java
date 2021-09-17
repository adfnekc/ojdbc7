//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.Datum;

class DateAccessor extends DateTimeCommonAccessor {
    static final int MAXLENGTH = 7;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    DateAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.DATE, var1, 7, var5);
        this.init(var1, 12, 12, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    DateAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.DATE, var1, 7, false);
        this.init(var1, 12, 12, var9, false);
        this.initForDescribe(12, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    String getString(int var1) throws SQLException {
        String var2 = null;
        if (this.isNull(var1)) {
            return null;
        } else {
            if (this.externalType == 0) {
                if (this.statement.connection.mapDateToTimestamp) {
                    var2 = this.getTimestamp(var1).toString();
                } else {
                    var2 = this.getDate(var1).toString();
                }
            } else {
                this.getBytesInternal(var1, this.tmpBytes);
                int var3 = this.oracleYear(this.tmpBytes);
                boolean var4 = false;
                int var5;
                var2 = this.toText(var3, this.tmpBytes[2], this.tmpBytes[3], var5 = this.tmpBytes[4] - 1, this.tmpBytes[5] - 1, this.tmpBytes[6] - 1, -1, var5 < 12, (String)null);
            }

            return var2;
        }
    }

    Object getObject(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else if (this.externalType == 0) {
            return this.statement.connection.mapDateToTimestamp ? this.getTimestamp(var1) : this.getDate(var1);
        } else {
            switch(this.externalType) {
                case 91:
                    return this.getDate(var1);
                case 92:
                    return this.getTime(var1);
                case 93:
                    return this.getTimestamp(var1);
                default:
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                    var2.fillInStackTrace();
                    throw var2;
            }
        }
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getDATE(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getObject(var1);
    }
}
