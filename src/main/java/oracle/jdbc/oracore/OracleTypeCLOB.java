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
import oracle.sql.CLOB;
import oracle.sql.Datum;

public class OracleTypeCLOB extends OracleType implements Serializable {
    static final long serialVersionUID = 1122821330765834411L;
    static int fixedDataSize = 86;
    transient OracleConnection connection;
    int form;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeCLOB() {
    }

    public OracleTypeCLOB(OracleConnection var1) {
        this.connection = var1;
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        CLOB var3 = null;
        if (var1 != null) {
            if (!(var1 instanceof CLOB)) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var4.fillInStackTrace();
                throw var4;
            }

            var3 = (CLOB)var1;
        }

        return var3;
    }

    public int getTypeCode() {
        return this.form == 2 ? 2011 : 2005;
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            if (var2 != 1 && var2 != 2) {
                if (var2 == 3) {
                    return var1;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return this.connection.createClobWithUnpickledBytes(var1);
            }
        } else {
            return null;
        }
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }

    public void setConnection(OracleConnection var1) throws SQLException {
        this.connection = var1;
    }

    public boolean isNCHAR() throws SQLException {
        return this.form == 2;
    }

    public void setForm(int var1) {
        this.form = var1;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
