//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oracore.PickleContext;

class Kotad {
    static final int KOTADSIG = -1365573631;
    static final int KOTPDSIG = -1365442559;
    static final int KOTRDSIG = -1365377023;
    static final int KOTCDSIG = -1365311487;
    static final int KOTODSIG = -1365307391;
    static final int KOTADXSIG = -1365303295;
    static final int KOTADPRV = 1;
    static final int KOTADPUB = 2;
    static final int KOTADCNT = 4;
    static final int KOTADCFM = 248;
    static final int KOTADSUB = 256;
    static final int KOTADPTR = 16384;
    static final int KOTADREF = 32768;
    static final int KOTADCNN = 65536;
    static final int KOTADCFN = 131072;
    static final int KOTADCVN = 262144;
    static final int KOTADTRN = 512;
    static final int KOTADCPT = 4096;
    static final int KOTADIN = 256;
    static final int KOTADOUT = 512;
    static final int KOTADCBR = 1024;
    static final int KOTADREQ = 2048;
    static final int KOTADNCP = 1048576;
    private int kotadkvn;
    private byte[] kotadnam;
    private byte[] kotadtrf;
    private short kotadtvn;
    private short kotadid;
    private byte[] kotadprf;
    private short kotadpvn;
    private int kotadflg;
    private long kotadpre;
    private int kotadcid;
    private byte kotadscl;
    private int kotadcne;
    private byte[] kotaddft;
    private long kotadtyp;
    private byte[] kotadadd;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    private Kotad() throws SQLException {
    }

    private static Kotad unpickleKotad(PickleContext var0) throws SQLException {
        Kotad var1 = new Kotad();
        var0.skipBytes(2);
        long var2 = (long)(var0.readLength(true) - 2);
        var0.skipBytes(1);
        var1.kotadkvn = (int)var0.readUB4();
        var1.kotadnam = var0.readDataValue();
        var1.kotadtrf = var0.readDataValue();
        var0.skipBytes(1);
        var1.kotadtvn = (short)var0.readUB2();
        var0.skipBytes(1);
        var1.kotadid = (short)var0.readUB2();
        var1.kotadprf = var0.readDataValue();
        var0.skipBytes(1);
        var1.kotadpvn = (short)var0.readUB2();
        var0.skipBytes(1);
        var1.kotadflg = (int)var0.readUB4();
        var0.skipBytes(1);
        var1.kotadpre = var0.readUB4();
        var0.skipBytes(1);
        var1.kotadcid = var0.readUB2();
        var0.skipBytes(1);
        var1.kotadscl = var0.readByte();
        var0.skipBytes(1);
        var1.kotadcne = (int)var0.readUB4();
        var1.kotaddft = var0.readDataValue();
        var0.skipBytes(1);
        var1.kotadtyp = var0.readUB4();
        var1.kotadadd = var0.readDataValue();
        return var1;
    }

    static final TypeDescriptor unpickleTypeDescriptorImage(PickleContext var0) throws SQLException {
        Kotad var1 = unpickleKotad(var0);
        if (var1.kotadkvn != -1365311487) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 179);
            var3.fillInStackTrace();
            throw var3;
        } else {
            TypeDescriptor var2 = constructPredefinedTypeDescriptor(var1);
            return var2;
        }
    }

    static final AttributeDescriptor unpickleAttributeImage(boolean var0, PickleContext var1) throws SQLException {
        Kotad var2 = unpickleKotad(var1);
        if (var2.kotadkvn != -1365573631) {
            SQLException var5 = DatabaseError.createSqlException((OracleConnection)null, 179);
            var5.fillInStackTrace();
            throw var5;
        } else {
            TypeDescriptor var3 = null;
            if (var0) {
                var3 = constructPredefinedTypeDescriptor(var2);
            }

            AttributeDescriptor var4 = new AttributeDescriptor(new String(var2.kotadnam), var2.kotadid, var2.kotadflg, var3);
            return var4;
        }
    }

    private static final TypeDescriptor constructPredefinedTypeDescriptor(Kotad var0) throws SQLException {
        if (var0.kotadtrf.length != 36) {
            SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 180);
            var4.fillInStackTrace();
            throw var4;
        } else {
            for(int var1 = 4; var1 < 18; ++var1) {
                if (var0.kotadtrf[var1] != 0) {
                    SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 180);
                    var2.fillInStackTrace();
                    throw var2;
                }
            }

            short var3 = TypeDescriptor.OID_TO_TYPECODE[var0.kotadtrf[19]];
            TypeDescriptor var5 = new TypeDescriptor(var3);
            var5.setPrecision(var0.kotadpre);
            var5.setScale(var0.kotadscl);
            return var5;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
