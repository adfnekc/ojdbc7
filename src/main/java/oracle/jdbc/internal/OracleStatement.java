//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import java.util.EventListener;

public interface OracleStatement extends oracle.jdbc.OracleStatement, ACProxyable {
    int DEFAULT_RSET_TYPE = 1;
    int CLOSED = 0;
    int ACTIVE = 1;
    int CACHED = 2;
    int NON_CACHED = 3;
    byte IS_UNINITIALIZED = 0;
    byte IS_SELECT = 1;
    byte IS_DELETE = 2;
    byte IS_INSERT = 4;
    byte IS_MERGE = 8;
    byte IS_UPDATE = 16;
    byte IS_PLSQL_BLOCK = 32;
    byte IS_CALL_BLOCK = 64;
    byte IS_OTHER = -128;
    byte IS_DML = 30;
    byte IS_PLSQL = 96;

    void setFixedString(boolean var1);

    boolean getFixedString();

    int sendBatch() throws SQLException;

    boolean getserverCursor();

    int getcacheState();

    int getstatementType();

    OracleStatement.SqlKind getSqlKind() throws SQLException;

    long getChecksum() throws SQLException;

    void registerBindChecksumListener(OracleStatement.BindChecksumListener var1) throws SQLException;

    void setSnapshotSCN(long var1) throws SQLException;

    public interface BindChecksumListener extends EventListener {
        boolean shouldContinue(long var1);
    }

    public static enum SqlKind {
        SELECT(false, false, true, false, (byte)1),
        DELETE(false, true, false, false, (byte)2),
        INSERT(false, true, false, false, (byte)4),
        MERGE(false, true, false, false, (byte)8),
        UPDATE(false, true, false, false, (byte)16),
        PLSQL_BLOCK(true, false, false, false, (byte)32),
        CALL_BLOCK(true, false, false, false, (byte)64),
        SELECT_FOR_UPDATE(false, false, true, false, (byte)1),
        ALTER_SESSION(false, false, false, true, (byte)-128),
        OTHER(false, false, false, true, (byte)-128),
        UNINITIALIZED(false, false, false, false, (byte)0);

        private final boolean dml;
        private final boolean plsqlOrCall;
        private final boolean select;
        private final boolean other;
        private final byte kind;

        private SqlKind(boolean var3, boolean var4, boolean var5, boolean var6, byte var7) {
            this.dml = var4;
            this.plsqlOrCall = var3;
            this.select = var5;
            this.other = var6;
            this.kind = var7;
        }

        public static final OracleStatement.SqlKind valueOf(byte var0) {
            switch(var0) {
                case -128:
                    return OTHER;
                case 1:
                    return SELECT;
                case 2:
                    return DELETE;
                case 4:
                    return INSERT;
                case 8:
                    return MERGE;
                case 16:
                    return UPDATE;
                case 32:
                    return PLSQL_BLOCK;
                case 64:
                    return CALL_BLOCK;
                default:
                    return UNINITIALIZED;
            }
        }

        public boolean isPlsqlOrCall() {
            return this.plsqlOrCall;
        }

        public boolean isDML() {
            return this.dml;
        }

        public boolean isSELECT() {
            return this.select;
        }

        public boolean isOTHER() {
            return this.other;
        }

        public byte getKind() {
            return this.kind;
        }
    }
}
