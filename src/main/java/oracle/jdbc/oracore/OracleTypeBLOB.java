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
import oracle.sql.BLOB;
import oracle.sql.Datum;

public class OracleTypeBLOB extends OracleType implements Serializable {
    static final long serialVersionUID = -2311211431562030662L;
    static int fixedDataSize = 86;
    transient OracleConnection connection;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeBLOB() {
    }

    public OracleTypeBLOB(OracleConnection var1) {
        this.connection = var1;
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        BLOB var3 = null;
        if (var1 != null) {
            if (!(var1 instanceof BLOB)) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var4.fillInStackTrace();
                throw var4;
            }

            var3 = (BLOB)var1;
        }

        return var3;
    }

    public int getTypeCode() {
        return 2004;
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            switch(var2) {
                case 1:
                case 2:
                    return this.connection.createBlobWithUnpickledBytes(var1);
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
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }

    public void setConnection(OracleConnection var1) throws SQLException {
        this.connection = var1;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
