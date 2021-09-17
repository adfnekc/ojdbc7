//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;

public class OracleTypeINTERVAL extends OracleType implements Serializable {
    static final long serialVersionUID = 1394800182554224957L;
    static final int LDIINTYEARMONTH = 7;
    static final int LDIINTDAYSECOND = 10;
    static final int SIZE_INTERVAL_YM = 5;
    static final int SIZE_INTERVAL_DS = 11;
    byte typeId = 0;
    int scale = 0;
    int precision = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeINTERVAL() {
    }

    public OracleTypeINTERVAL(OracleConnection var1) {
    }

    public int getTypeCode() {
        if (this.typeId == 7) {
            return -103;
        } else {
            return this.typeId == 10 ? -104 : 1111;
        }
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        this.typeId = var1.readByte();
        this.precision = var1.readByte();
        this.scale = var1.readByte();
    }

    public int getScale() throws SQLException {
        return this.scale;
    }

    public int getPrecision() throws SQLException {
        return this.precision;
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.typeId = var1.readByte();
        this.precision = var1.readByte();
        this.scale = var1.readByte();
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeByte(this.typeId);
        var1.writeByte(this.precision);
        var1.writeByte(this.scale);
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            switch(var2) {
                case 1:
                case 2:
                    if (var1.length == 5) {
                        return new INTERVALYM(var1);
                    } else {
                        if (var1.length == 11) {
                            return new INTERVALDS(var1);
                        }

                        return null;
                    }
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
        Object var3 = null;
        if (var1 != null) {
            if (!(var1 instanceof INTERVALYM) && !(var1 instanceof INTERVALDS)) {
                if (!(var1 instanceof String)) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                    var4.fillInStackTrace();
                    throw var4;
                }

                try {
                    var3 = new INTERVALDS((String)var1);
                } catch (StringIndexOutOfBoundsException var5) {
                    var3 = new INTERVALYM((String)var1);
                }
            } else {
                var3 = (Datum)var1;
            }
        }

        return (Datum)var3;
    }

    protected Object unpickle81rec(UnpickleContext var1, int var2, int var3, Map var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90);
        var5.fillInStackTrace();
        throw var5;
    }
}
