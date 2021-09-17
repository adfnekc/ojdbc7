//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.Datum;

class TimestampAccessor extends DateTimeCommonAccessor {
    static final int MAXLENGTH = 11;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    TimestampAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.TIMESTAMP, var1, 11, var5);
        this.init(var1, 180, 180, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    TimestampAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.TIMESTAMP, var1, 11, false);
        this.init(var1, 180, 180, var9, false);
        this.initForDescribe(180, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            this.getBytesInternal(var1, this.tmpBytes);
            int var2 = this.getLength(var1);
            int var3 = this.oracleYear(this.tmpBytes);
            int var4 = -1;
            if (var2 == 11) {
                var4 = this.oracleNanos(this.tmpBytes);
            }

            int var5 = this.oracleHour(this.tmpBytes);
            String var6 = this.toText(var3, this.oracleMonth(this.tmpBytes) + 1, this.oracleDay(this.tmpBytes), var5, this.oracleMin(this.tmpBytes), this.oracleSec(this.tmpBytes), var4, var5 < 12, (String)null);
            return var6;
        }
    }

    Object getObject(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else if (this.externalType == 0) {
            return this.statement.connection.j2ee13Compliant ? this.getTimestamp(var1) : this.getTIMESTAMP(var1);
        } else {
            switch(this.externalType) {
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
        return this.getTIMESTAMP(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getObject(var1);
    }
}
