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
import oracle.sql.REF;
import oracle.sql.StructDescriptor;

public class OracleTypeREF extends OracleNamedType implements Serializable {
    static final long serialVersionUID = 3186448715463064573L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeREF() {
    }

    public OracleTypeREF(String var1, OracleConnection var2) throws SQLException {
        super(var1, var2);
    }

    public OracleTypeREF(OracleTypeADT var1, int var2, OracleConnection var3) {
        super(var1, var2, var3);
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        REF var3 = null;
        if (var1 != null) {
            if (!(var1 instanceof REF)) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var4.fillInStackTrace();
                throw var4;
            }

            var3 = (REF)var1;
        }

        return var3;
    }

    public int getTypeCode() {
        return 2006;
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            if (var2 != 1 && var2 != 2) {
                if (var2 == 3) {
                    return var1;
                } else {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                    var5.fillInStackTrace();
                    throw var5;
                }
            } else {
                StructDescriptor var4 = this.createStructDescriptor();
                return new REF(var4, this.connection, var1);
            }
        } else {
            return null;
        }
    }

    StructDescriptor createStructDescriptor() throws SQLException {
        if (this.descriptor == null) {
            if (this.sqlName == null && this.getFullName(false) == null) {
                OracleTypeADT var1 = new OracleTypeADT(this.getParent(), this.getOrder(), this.connection);
                this.descriptor = new StructDescriptor(var1, this.connection);
            } else {
                this.descriptor = StructDescriptor.createDescriptor(this.sqlName, this.connection);
            }
        }

        return (StructDescriptor)this.descriptor;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }
}
