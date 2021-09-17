//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class Util {
    private static int[] ldsRoundTable = new int[]{0, 1, 0, 2, 0, 0, 0, 3, 0};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public Util() {
    }

    static void checkNextByte(InputStream var0, byte var1) throws SQLException {
        try {
            if (var0.read() != var1) {
                SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 47, "parseTDS");
                var2.fillInStackTrace();
                throw var2;
            }
        } catch (IOException var4) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public static int[] toJavaUnsignedBytes(byte[] var0) {
        int[] var1 = new int[var0.length];

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = var0[var2] & 255;
        }

        return var1;
    }

    static byte[] readBytes(InputStream var0, int var1) throws SQLException {
        byte[] var2 = new byte[var1];

        try {
            int var3 = var0.read(var2);
            if (var3 != var1) {
                byte[] var6 = new byte[var3];
                System.arraycopy(var2, 0, var6, 0, var3);
                return var6;
            } else {
                return var2;
            }
        } catch (IOException var5) {
            SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    static void writeBytes(OutputStream var0, byte[] var1) throws SQLException {
        try {
            var0.write(var1);
        } catch (IOException var4) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    static void skipBytes(InputStream var0, int var1) throws SQLException {
        try {
            var0.skip((long)var1);
        } catch (IOException var4) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    static long readLong(InputStream var0) throws SQLException {
        byte[] var1 = new byte[4];

        try {
            var0.read(var1);
            return (long)((((var1[0] & 255) * 256 + (var1[1] & 255)) * 256 + (var1[2] & 255)) * 256 + (var1[3] & 255));
        } catch (IOException var4) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    static short readShort(InputStream var0) throws SQLException {
        byte[] var1 = new byte[2];

        try {
            var0.read(var1);
            return (short)((var1[0] & 255) * 256 + (var1[1] & 255));
        } catch (IOException var4) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    static byte readByte(InputStream var0) throws SQLException {
        try {
            return (byte)var0.read();
        } catch (IOException var3) {
            SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, var3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    static byte fdoGetSize(byte[] var0, int var1) {
        byte var2 = fdoGetEntry(var0, var1);
        return (byte)(var2 >> 3 & 31);
    }

    static byte fdoGetAlign(byte[] var0, int var1) {
        byte var2 = fdoGetEntry(var0, var1);
        return (byte)(var2 & 7);
    }

    static int ldsRound(int var0, int var1) {
        int var2 = ldsRoundTable[var1];
        return (var0 >> var2) + 1 << var2;
    }

    private static byte fdoGetEntry(byte[] var0, int var1) {
        short var2 = getUnsignedByte(var0[5]);
        byte var3 = var0[6 + var2 + var1];
        return var3;
    }

    public static short getUnsignedByte(byte var0) {
        return (short)(var0 & 255);
    }

    public static byte[] serializeObject(Object var0) throws IOException {
        if (var0 == null) {
            return null;
        } else {
            ByteArrayOutputStream var1 = new ByteArrayOutputStream();
            ObjectOutputStream var2 = new ObjectOutputStream(var1);
            var2.writeObject(var0);
            var2.flush();
            return var1.toByteArray();
        }
    }

    public static Object deserializeObject(byte[] var0) throws IOException, ClassNotFoundException {
        if (var0 == null) {
            return null;
        } else {
            ByteArrayInputStream var1 = new ByteArrayInputStream(var0);
            return (new ObjectInputStream(var1)).readObject();
        }
    }

    public static void printByteArray(byte[] var0) {
        System.out.println("DONT CALL THIS -- oracle.jdbc.oracore.Util.printByteArray");
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
