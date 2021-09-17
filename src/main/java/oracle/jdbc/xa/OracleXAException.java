//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa;

import java.sql.SQLException;
import javax.transaction.xa.XAException;
import oracle.jdbc.internal.OracleConnection;

public class OracleXAException extends XAException {
    private int xaError;
    private int primary;
    private int secondary;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAException() {
        this.xaError = 0;
        this.primary = 0;
        this.secondary = 0;
    }

    public OracleXAException(int var1) {
        super(errorConvert(var1));
        this.xaError = 0;
        this.primary = 0;
        this.secondary = 0;
        this.xaError = errorConvert(var1);
        this.primary = var1 & '\uffff';
        this.secondary = var1 >> 16;
    }

    public OracleXAException(int var1, int var2) {
        super(errorConvert(var1, var2));
        this.xaError = 0;
        this.primary = 0;
        this.secondary = 0;
        this.xaError = errorConvert(var1, var2);
        this.primary = var1 & '\uffff';
        this.secondary = var1 >> 16;
    }

    public OracleXAException(SQLException var1, int var2) {
        this(var1.getErrorCode(), var2);
        this.initCause(var1);
    }

    public static XAException newXAException(OracleConnection var0, int var1) {
        OracleXAException var2 = new OracleXAException(var1);
        int var3 = var2.getXAError();
        if (var3 == -7 && var0 != null) {
            var0.setUsable(false);
        }

        return var2;
    }

    public static XAException newXAException(OracleConnection var0, int var1, int var2) {
        OracleXAException var3 = new OracleXAException(var1, var2);
        int var4 = var3.getXAError();
        if (var4 == -7 && var0 != null) {
            var0.setUsable(false);
        }

        return var3;
    }

    public static XAException newXAException(OracleConnection var0, SQLException var1, int var2) {
        OracleXAException var3 = new OracleXAException(var1, var2);
        int var4 = var3.getXAError();
        if (var4 == -7 && var0 != null) {
            var0.setUsable(false);
        }

        return var3;
    }

    public static int errorConvert(int var0) {
        return errorConvert(var0, -3);
    }

    public static int errorConvert(int var0, int var1) {
        switch(var0 & 65535) {
            case 28:
            case 1031:
            case 1033:
            case 1034:
            case 1041:
            case 1089:
            case 1090:
            case 1092:
            case 3113:
            case 3114:
            case 12571:
            case 17002:
            case 17008:
            case 17410:
            case 24796:
            case 25400:
            case 25401:
            case 25402:
            case 25403:
            case 25404:
            case 25405:
            case 25406:
            case 25407:
            case 25408:
            case 25409:
                return -7;
            case 2056:
            case 17448:
            case 24763:
            case 24768:
            case 24769:
            case 24770:
            case 24775:
            case 24776:
                return -6;
            case 2091:
            case 2092:
            case 24761:
                return 100;
            case 24756:
                return -4;
            case 24764:
                return 7;
            case 24765:
                return 6;
            case 24766:
                return 5;
            case 24767:
                return 3;
            case 24780:
                return -3;
            case 25351:
            case 30006:
                return 4;
            default:
                return var1;
        }
    }

    public int getXAError() {
        return this.xaError;
    }

    public int getOracleError() {
        return this.primary;
    }

    public int getOracleSQLError() {
        return this.secondary;
    }

    public static String getXAErrorMessage(int var0) {
        switch(var0) {
            case -9:
                return "The resource manager is doing work outside global transaction.";
            case -8:
                return "The XID already exists.";
            case -7:
                return "Resource manager is unavailable.";
            case -6:
                return "Routine was invoked in an inproper context.";
            case -5:
                return "Invalid arguments were given.";
            case -4:
                return "The XID is not valid.";
            case -3:
                return "A resource manager error has occured in the transaction branch.";
            case -2:
                return "Asynchronous operation already outstanding.";
            case 3:
                return "The transaction branch has been read-only and has been committed.";
            case 4:
                return "Routine returned with no effect and may be reissued.";
            case 5:
                return "The transaction branch has been heuristically committed and rolled back.";
            case 6:
                return "The transaction branch has been heuristically rolled back.";
            case 7:
                return "The transaction branch has been heuristically committed.";
            case 8:
                return "The transaction branch may have been heuristically completed.";
            case 9:
                return "Resumption must occur where suspension occured.";
            case 100:
                return "The inclusive lower bound oof the rollback codes.";
            case 101:
                return "Rollback was caused by communication failure.";
            case 102:
                return "A deadlock was detected.";
            case 103:
                return "A condition that violates the integrity of the resource was detected.";
            case 104:
                return "The resource manager rolled back the transaction branch for a reason not on this list.";
            case 105:
                return "A protocol error occured in the resource manager.";
            case 106:
                return "A transaction branch took too long.";
            case 107:
                return "The inclusive upper bound of the rollback error code.";
            default:
                return "Internal XA Error";
        }
    }
}
