//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.TIMESTAMPLTZ;

public class OracleTypeTIMESTAMPLTZ extends OracleType implements Serializable {
    static final long serialVersionUID = 1615519855865602397L;
    int precision = 0;
    transient OracleConnection connection;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeTIMESTAMPLTZ() {
    }

    public OracleTypeTIMESTAMPLTZ(OracleConnection var1) {
        this.connection = var1;
    }

    public int getTypeCode() {
        return -102;
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        this.precision = var1.readByte();
    }

    public int getScale() throws SQLException {
        return 0;
    }

    public int getPrecision() throws SQLException {
        return this.precision;
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.precision = var1.readByte();
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeByte(this.precision);
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            switch(var2) {
                case 1:
                    return new TIMESTAMPLTZ(var1);
                case 2:
                    return TIMESTAMPLTZ.toTimestamp(this.connection, var1);
                case 3:
                    return var1;
                default:
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                    var4.fillInStackTrace();
                    throw var4;
            }
        } else {
            return null;
        }
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        TIMESTAMPLTZ var3 = null;
        if (var1 != null) {
            try {
                if (var1 instanceof TIMESTAMPLTZ) {
                    var3 = (TIMESTAMPLTZ)var1;
                } else if (var1 instanceof byte[]) {
                    var3 = new TIMESTAMPLTZ((byte[])((byte[])var1));
                } else if (var1 instanceof Timestamp) {
                    var3 = new TIMESTAMPLTZ(var2, (Timestamp)var1);
                } else if (var1 instanceof DATE) {
                    var3 = new TIMESTAMPLTZ(var2, (DATE)var1);
                } else if (var1 instanceof String) {
                    var3 = new TIMESTAMPLTZ(var2, (String)var1);
                } else if (var1 instanceof Date) {
                    var3 = new TIMESTAMPLTZ(var2, (Date)var1);
                } else {
                    if (!(var1 instanceof Time)) {
                        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                        var4.fillInStackTrace();
                        throw var4;
                    }

                    var3 = new TIMESTAMPLTZ(var2, (Time)var1);
                }
            } catch (Exception var6) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var5.fillInStackTrace();
                throw var5;
            }
        }

        return var3;
    }

    protected Object unpickle81rec(UnpickleContext var1, int var2, int var3, Map var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90);
        var5.fillInStackTrace();
        throw var5;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
