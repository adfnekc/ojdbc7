//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

class T4CTTIoer extends T4CTTIMsg {
    final int MAXERRBUF = 512;
    long curRowNumber;
    int retCode;
    int arrayElemWError;
    int arrayElemErrno;
    int currCursorID;
    short errorPosition;
    short sqlType;
    byte oerFatal;
    short flags;
    short userCursorOpt;
    short upiParam;
    short warningFlag;
    int osError;
    short stmtNumber;
    short callNumber;
    int pad1;
    long successIters;
    int partitionId;
    int tableId;
    int slotNumber;
    long rba;
    long blockNumber;
    int warnLength = 0;
    int warnFlag = 0;
    int[] errorLength = new int[1];
    byte[] errorMsg;
    static final int OERFNCF = 32;
    static final int ORA1403 = 1403;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIoer(T4CConnection var1) {
        super(var1, (byte)4);
    }

    void init() {
        this.retCode = 0;
        this.errorMsg = null;
    }

    int unmarshal() throws IOException, SQLException {
        if (this.connection.getTTCVersion() >= 3) {
            short var1 = (short)this.meg.unmarshalUB2();
            this.connection.endToEndECIDSequenceNumber = var1;
        }

        this.curRowNumber = this.meg.unmarshalUB4();
        this.retCode = this.meg.unmarshalUB2();
        this.arrayElemWError = this.meg.unmarshalUB2();
        this.arrayElemErrno = this.meg.unmarshalUB2();
        this.currCursorID = this.meg.unmarshalUB2();
        this.errorPosition = this.meg.unmarshalSB2();
        this.sqlType = this.meg.unmarshalUB1();
        this.oerFatal = this.meg.unmarshalSB1();
        this.flags = (short)this.meg.unmarshalSB1();
        this.userCursorOpt = (short)this.meg.unmarshalSB1();
        this.upiParam = this.meg.unmarshalUB1();
        this.warningFlag = this.meg.unmarshalUB1();
        this.rba = this.meg.unmarshalUB4();
        this.partitionId = this.meg.unmarshalUB2();
        this.tableId = this.meg.unmarshalUB1();
        this.blockNumber = this.meg.unmarshalUB4();
        this.slotNumber = this.meg.unmarshalUB2();
        this.osError = this.meg.unmarshalSWORD();
        this.stmtNumber = this.meg.unmarshalUB1();
        this.callNumber = this.meg.unmarshalUB1();
        this.pad1 = this.meg.unmarshalUB2();
        this.successIters = this.meg.unmarshalUB4();
        byte[] var5 = this.meg.unmarshalDALC();
        int var2 = this.meg.unmarshalUB2();

        int var3;
        for(var3 = 0; var3 < var2; ++var3) {
            this.meg.unmarshalUB2();
        }

        var3 = (int)this.meg.unmarshalUB4();

        int var4;
        for(var4 = 0; var4 < var3; ++var4) {
            this.meg.unmarshalUB4();
        }

        var4 = this.meg.unmarshalUB2();
        if (this.retCode != 0) {
            this.errorMsg = this.meg.unmarshalCLRforREFS();
            this.errorLength[0] = this.errorMsg.length;
        }

        return this.currCursorID;
    }

    void unmarshalWarning() throws IOException, SQLException {
        this.retCode = this.meg.unmarshalUB2();
        this.warnLength = this.meg.unmarshalUB2();
        this.warnFlag = this.meg.unmarshalUB2();
        if (this.retCode != 0 && this.warnLength > 0) {
            this.errorMsg = this.meg.unmarshalCHR(this.warnLength);
            this.errorLength[0] = this.warnLength;
        }

    }

    void print() throws SQLException {
        if (this.retCode == 0 && this.warnFlag != 0) {
        }

    }

    void processError() throws SQLException {
        this.processError(true);
    }

    void processError(boolean var1) throws SQLException {
        this.processError(var1, (OracleStatement)null);
    }

    void processError(OracleStatement var1) throws SQLException {
        this.processError(true, var1);
    }

    void processError(boolean var1, OracleStatement var2) throws SQLException {
        if (var2 != null) {
            var2.numberOfExecutedElementsInBatch = (int)this.successIters;
        }

        if (this.retCode != 0) {
            switch(this.retCode) {
                case 28:
                case 600:
                case 1012:
                case 1041:
                case 3113:
                case 3114:
                    this.connection.internalClose();
                    break;
                case 902:
                    this.connection.removeAllDescriptor();
            }

            if (var1) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), this.meg.conv.CharBytesToString(this.errorMsg, this.errorLength[0], true), this.retCode);
                var5.fillInStackTrace();
                throw var5;
            }
        } else if (var1) {
            if ((this.warningFlag & 1) == 1) {
                int var3 = this.warningFlag & -2;
                if ((var3 & 32) == 32 || (var3 & 4) == 4) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 110);
                    var4.fillInStackTrace();
                    throw var4;
                }
            }

            if (this.connection != null && this.connection.plsqlCompilerWarnings && (this.flags & 4) == 4) {
                var2.foundPlsqlCompilerWarning();
            }

        }
    }

    void processWarning() throws SQLException {
        if (this.retCode != 0) {
            throw DatabaseError.newSqlWarning(this.meg.conv.CharBytesToString(this.errorMsg, this.errorLength[0], true), this.retCode);
        }
    }

    int getCurRowNumber() throws SQLException {
        return (int)this.curRowNumber;
    }

    int getRetCode() {
        return this.retCode;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }

    long updateChecksum(long var1) throws SQLException {
        CRC64 var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.retCode);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, this.curRowNumber);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.errorPosition);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.sqlType);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.oerFatal);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.flags);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.userCursorOpt);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.upiParam);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.warningFlag);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, (long)this.osError);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, this.successIters);
        var10000 = PhysicalConnection.CHECKSUM;
        var1 = CRC64.updateChecksum(var1, this.errorMsg, 0, this.errorMsg.length);
        return var1;
    }
}
