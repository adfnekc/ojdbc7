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
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.Datum;

public class OracleTypeFLOAT extends OracleType implements Serializable {
    static final long serialVersionUID = 4088841548269771109L;
    int precision;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeFLOAT() {
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        return OracleTypeNUMBER.toNUMBER(var1, var2);
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        return OracleTypeNUMBER.toNUMBERArray(var1, var2, var3, var5);
    }

    public int getTypeCode() {
        return 6;
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        this.precision = var1.readUnsignedByte();
    }

    public int getScale() {
        return -127;
    }

    public int getPrecision() {
        return this.precision;
    }

    protected static Object unpickle81NativeArray(PickleContext var0, long var1, int var3, int var4) throws SQLException {
        return OracleTypeNUMBER.unpickle81NativeArray(var0, var1, var3, var4);
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        return OracleTypeNUMBER.toNumericObject(var1, var2, var3);
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeInt(this.precision);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.precision = var1.readInt();
    }
}
