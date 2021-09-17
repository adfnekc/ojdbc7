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
import oracle.sql.RAW;

public class OracleTypeRAW extends OracleType implements Serializable {
    static final long serialVersionUID = -6083664758336974576L;
    int length;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleTypeRAW() {
    }

    public OracleTypeRAW(int var1) {
        super(var1);
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        RAW var3 = null;
        if (var1 != null) {
            try {
                if (var1 instanceof RAW) {
                    var3 = (RAW)var1;
                } else {
                    var3 = new RAW(var1);
                }
            } catch (SQLException var6) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var5.fillInStackTrace();
                throw var5;
            }
        }

        return var3;
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        Datum[] var6 = null;
        if (var1 != null) {
            if (!(var1 instanceof char[][])) {
                if (var1 instanceof Object[]) {
                    return super.toDatumArray(var1, var2, var3, var5);
                }

                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var10.fillInStackTrace();
                throw var10;
            }

            char[][] var7 = (char[][])((char[][])var1);
            int var8 = (int)(var5 == -1 ? (long)var7.length : Math.min((long)var7.length - var3 + 1L, (long)var5));
            var6 = new Datum[var8];

            for(int var9 = 0; var9 < var8; ++var9) {
                var6[var9] = this.toDatum(new String(var7[(int)var3 + var9 - 1]), var2);
            }
        }

        return var6;
    }

    public int getTypeCode() {
        return -2;
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        super.parseTDSrec(var1);
        this.length = var1.readUB2();
    }

    protected int pickle81(PickleContext var1, Datum var2) throws SQLException {
        if (var2.getLength() > (long)this.length) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 72, this);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = var1.writeLength((int)var2.getLength());
            var3 += var1.writeData(var2.shareBytes());
            return var3;
        }
    }

    public int getLength() {
        return this.length;
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            switch(var2) {
                case 1:
                    return new RAW(var1);
                case 2:
                case 3:
                    return var1;
                default:
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                    var4.fillInStackTrace();
                    throw var4;
            }
        } else {
            return null;
        }
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeInt(this.length);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.length = var1.readInt();
    }
}
