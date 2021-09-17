//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.SQLWarning;
import java.util.Arrays;
import oracle.jdbc.driver.T4CConnection.ReplayMode;
import oracle.jdbc.internal.OracleConnection;
import oracle.net.ns.BreakNetException;

abstract class T4CTTIfun extends T4CTTIMsg {
    static final short OOPEN = 2;
    static final short OFETCH = 5;
    static final short OCLOSE = 8;
    static final short OLOGOFF = 9;
    static final short OCOMON = 12;
    static final short OCOMOFF = 13;
    static final short OCOMMIT = 14;
    static final short OROLLBACK = 15;
    static final short OCANCEL = 20;
    static final short ODSCRARR = 43;
    static final short OVERSION = 59;
    static final short OK2RPC = 67;
    static final short OALL7 = 71;
    static final short OSQL7 = 74;
    static final short O3LOGON = 81;
    static final short O3LOGA = 82;
    static final short OKOD = 92;
    static final short OALL8 = 94;
    static final short OLOBOPS = 96;
    static final short ODNY = 98;
    static final short OTXSE = 103;
    static final short OTXEN = 104;
    static final short OCCA = 105;
    static final short O80SES = 107;
    static final short OAUTH = 115;
    static final short OSESSKEY = 118;
    static final short OCANA = 120;
    static final short OKPN = 125;
    static final short OOTCM = 127;
    static final short OSCID = 135;
    static final short OSPFPPUT = 138;
    static final short OKPFC = 139;
    static final short OPING = 147;
    static final short OKEYVAL = 154;
    static final short OXSSCS = 155;
    static final short OXSSRO = 156;
    static final short OXSSPO = 157;
    static final short OAQEQ = 121;
    static final short OAQDQ = 122;
    static final short OAQGPS = 132;
    static final short OAQLS = 126;
    static final short OAQXQ = 145;
    static final short OSESSGET = 162;
    static final short OSESSRLS = 163;
    static final short OXSNSO = 172;
    static final short OXSNS = 178;
    static final short OXSSYNC = 176;
    static final short OXSATT = 180;
    static final short OXSCRE = 179;
    static final short OXSDET = 181;
    static final short OXSDES = 182;
    static final short OXSSET = 183;
    static final short OSESSSTATE = 176;
    static final short OAPPCONTREPLAY = 177;
    static final short OAQENQ = 184;
    static final short OAQDEQ = 185;
    static final short OAQEMNDEQ = 186;
    static final short OAQNFY = 187;
    private short funCode;
    protected final T4CTTIoer oer;
    int receiveState = 0;
    static final int IDLE_RECEIVE_STATE = 0;
    static final int ACTIVE_RECEIVE_STATE = 1;
    static final int READROW_RECEIVE_STATE = 2;
    static final int STREAM_RECEIVE_STATE = 3;
    boolean rpaProcessed = false;
    boolean rxhProcessed = false;
    boolean iovProcessed = false;
    private final short[] ttiList;
    private int ttiListEnd = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIfun(T4CConnection var1, byte var2) {
        super(var1, var2);
        this.oer = var1.getT4CTTIoer();
        this.ttiList = var1.ttiList;
    }

    final void setFunCode(short var1) {
        this.funCode = var1;
    }

    final short getFunCode() {
        return this.funCode;
    }

    private final void marshalFunHeader() throws IOException {
        this.connection.setExecutingRPCFunctionCode(this.funCode);
        this.marshalTTCcode();
        this.meg.marshalUB1(this.funCode);
        this.meg.marshalUB1((short)this.connection.getNextSeqNumber());
    }

    abstract void marshal() throws IOException;

    final void doRPC() throws IOException, SQLException {
        if (this.getTTCCode() == 17) {
            SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
            var12.fillInStackTrace();
            throw var12;
        } else {
            this.connection.sendPiggyBackedMessages();

            for(int var1 = 0; var1 < 5; ++var1) {
                this.init();
                this.marshalFunHeader();

                try {
                    this.connection.pipeState = 1;
                    this.marshal();
                    this.connection.pipeState = 2;
                    this.receive();
                    break;
                } catch (SQLException var10) {
                    SQLException var2 = var10;
                    synchronized(this.connection.cancelInProgressLockForThin) {
                        if (var2.getErrorCode() == 1013 || this.connection.cancelInProgressFlag && var2.getMessage() != null && var2.getMessage().contains("ORA-01013")) {
                            this.connection.cancelInProgressFlag = false;
                            if ((this.funCode == 15 || this.funCode == 12 || this.funCode == 13 || this.funCode == 14 || this.funCode == 59) && (this.oer.callNumber != this.connection.currentTTCSeqNumber || this.connection.statementCancel)) {
                                continue;
                            }
                        }
                    }

                    throw var10;
                } finally {
                    this.connection.pipeState = -1;
                }
            }

        }
    }

    final void doPigRPC() throws IOException {
        this.init();
        this.marshalFunHeader();
        this.marshal();
    }

    final void doOneWayRPC() throws IOException, SQLException {
        this.connection.sendPiggyBackedMessages();
        this.init();
        this.marshalFunHeader();
        this.marshal();
        this.meg.flush();
    }

    private void init() {
        this.rpaProcessed = false;
        this.rxhProcessed = false;
        this.iovProcessed = false;
        this.ttiListEnd = 0;
    }

    void resumeReceive() throws SQLException, IOException {
        this.receive();
    }

    private final String ttiListString() {
        String var1 = "[ ";

        for(int var2 = 0; var2 < this.ttiListEnd; ++var2) {
            var1 = var1 + this.ttiList[var2] + ", ";
        }

        var1 = var1 + "]";
        return var1;
    }

    private void receive() throws SQLException, IOException {
        ReplayContext var1 = null;
        this.receiveState = 1;

        try {
            SQLException var2 = null;

            label282:
            while(true) {
                label280:
                while(true) {
                    try {
                        short var3 = this.meg.unmarshalUB1();
                        if (this.ttiListEnd < this.ttiList.length) {
                            this.ttiList[this.ttiListEnd++] = var3;
                        }

                        switch(var3) {
                            case 4:
                                this.processEOCS();
                                this.oer.init();
                                this.oer.unmarshal();

                                try {
                                    this.processError();
                                } catch (SQLException var24) {
                                    var2 = var24;
                                }
                                break label282;
                            case 5:
                            case 10:
                            case 17:
                            case 18:
                            case 20:
                            case 22:
                            case 24:
                            case 25:
                            case 26:
                            default:
                                SQLException var36 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401, this.ttiListString());
                                var36.fillInStackTrace();
                                throw var36;
                            case 6:
                                this.readRXH();
                                this.rxhProcessed = true;
                                break;
                            case 7:
                                this.receiveState = 2;
                                if (this.readRXD()) {
                                    this.receiveState = 3;
                                    return;
                                }

                                this.receiveState = 1;
                                break;
                            case 8:
                                if (this.rpaProcessed) {
                                    SQLException var32 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
                                    var32.fillInStackTrace();
                                    throw var32;
                                }

                                this.readRPA();

                                try {
                                    this.processRPA();
                                } catch (SQLException var26) {
                                    var2 = var26;
                                }

                                this.rpaProcessed = true;
                                break;
                            case 9:
                                this.processEOCS();
                                if (this.connection.getTTCVersion() >= 3) {
                                    short var34 = (short)this.meg.unmarshalUB2();
                                    this.connection.endToEndECIDSequenceNumber = var34;
                                }
                                break label282;
                            case 11:
                                this.readIOV();
                                this.iovProcessed = true;
                                break;
                            case 12:
                                this.processSLG();
                                break;
                            case 13:
                                this.readOAC();
                                break;
                            case 14:
                                this.readLOBD();
                                break;
                            case 15:
                                this.oer.init();
                                this.oer.unmarshalWarning();

                                try {
                                    this.oer.processWarning();
                                } catch (SQLWarning var25) {
                                    this.connection.setWarnings(DatabaseError.addSqlWarning(this.connection.getWarnings(), var25));
                                }
                                break;
                            case 16:
                                this.readDCB();
                                break;
                            case 19:
                                this.meg.marshalUB1((short)19);
                                break;
                            case 21:
                                this.readBVC();
                                break;
                            case 23:
                                byte var4 = (byte)this.meg.unmarshalUB1();
                                int var7;
                                byte var8;
                                int var33;
                                byte var35;
                                switch(var4) {
                                    case 1:
                                        var33 = this.meg.unmarshalUB2();
                                        var35 = (byte)this.meg.unmarshalUB1();
                                        var7 = 0;

                                        while(true) {
                                            if (var7 >= var33) {
                                                continue label280;
                                            }

                                            T4CTTIidc var41 = new T4CTTIidc(this.connection);
                                            var41.unmarshal();
                                            ++var7;
                                        }
                                    case 2:
                                        var33 = this.meg.unmarshalUB2();
                                        var35 = (byte)this.meg.unmarshalUB1();
                                        this.meg.unmarshalNBytes(var33);
                                        continue;
                                    case 3:
                                    case 6:
                                    default:
                                        SQLException var40 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401, this.ttiListString());
                                        var40.fillInStackTrace();
                                        throw var40;
                                    case 4:
                                        this.connection.ocsessret.receive();
                                        continue;
                                    case 5:
                                        var33 = this.meg.unmarshalUB2();
                                        var35 = (byte)this.meg.unmarshalUB1();
                                        T4CTTIkvarr var38 = new T4CTTIkvarr(this.connection);
                                        var38.unmarshal();
                                        continue;
                                    case 7:
                                        byte[] var5 = this.meg.unmarshalDALC();
                                        int var6 = Arrays.hashCode(var5);
                                        if (this.connection.thinACLastLtxidHash != var6) {
                                            LogicalTransactionId var37 = new LogicalTransactionId(var5);
                                            this.connection.thinACCurrentLTXID = var37;
                                            NTFLTXIDEvent var39 = new NTFLTXIDEvent(this.connection, var37);
                                            this.connection.notify(var39);
                                            this.connection.thinACLastLtxidHash = var6;
                                        }
                                        continue;
                                    case 8:
                                        var7 = this.meg.unmarshalUB2();
                                        var8 = (byte)this.meg.unmarshalUB1();
                                        long var42 = this.meg.unmarshalUB4();
                                        long var11 = this.meg.unmarshalUB4();
                                        short var13 = this.meg.unmarshalUB1();
                                        byte[] var14 = this.meg.unmarshalDALC();
                                        var1 = new ReplayContext(var42, var13, var14, var11);
                                        continue;
                                    case 9:
                                        var7 = this.meg.unmarshalUB2();
                                        var8 = (byte)this.meg.unmarshalUB1();
                                        int var9 = 0;

                                        while(true) {
                                            if (var9 >= var7) {
                                                continue label280;
                                            }

                                            NTFXSEvent var10 = new NTFXSEvent(this.connection);
                                            this.connection.notify(var10);
                                            ++var9;
                                        }
                                }
                            case 27:
                                this.readIMPLRES();
                        }
                    } catch (BreakNetException var27) {
                    } finally {
                        this.connection.sentCancel = false;
                    }
                }
            }

            this.receiveState = 0;
            if (var2 != null) {
                throw var2;
            }
        } catch (SQLRecoverableException var29) {
            throw var29;
        } catch (IOException var30) {
            if (var1 != null) {
                this.handleReplayContext(var1);
            }

            throw var30;
        } catch (SQLException var31) {
            if (var1 != null) {
                this.handleReplayContext(var1);
            }

            this.connection.setExecutingRPCFunctionCode((short)0);
            this.connection.setExecutingRPCSQL((String)null);
            throw var31;
        }

        if (var1 != null) {
            this.handleReplayContext(var1);
        }

        this.connection.setExecutingRPCFunctionCode((short)0);
        this.connection.setExecutingRPCSQL((String)null);
    }

    private final void handleReplayContext(ReplayContext var1) {
        if (!this.connection.replayModes.contains(ReplayMode.NONREQUEST)) {
            assert (var1.flags_kpdxcAppContCtl & 4L) != 0L || var1.errcode_kpdxcAppContCtl != 41406L || !this.connection.replayModes.contains(ReplayMode.RUNTIME_REPLAY_ENABLED) : "Server disabled replay with error " + var1.errcode_kpdxcAppContCtl + " but our replayModes=" + this.connection.replayModes;

            assert var1.replayctx_kpdxcAppContCtl == null || var1.replayctx_kpdxcAppContCtl.length <= 0 || this.connection.getExecutingRPCFunctionCode() == 115 || this.connection.replayModes.contains(ReplayMode.RUNTIME_REPLAY_ENABLED) : "Server is sending a non-null replay context but our replayModes=" + this.connection.replayModes;

            if (this.connection.thinACReplayContextReceived.length == this.connection.thinACReplayContextReceivedCurrent) {
                ReplayContext[] var2 = new ReplayContext[this.connection.thinACReplayContextReceived.length * 2];
                System.arraycopy(this.connection.thinACReplayContextReceived, 0, var2, 0, this.connection.thinACReplayContextReceived.length);
                this.connection.thinACReplayContextReceived = var2;
            }

            this.connection.thinACReplayContextReceived[this.connection.thinACReplayContextReceivedCurrent++] = var1;
            if ((var1.flags_kpdxcAppContCtl & 4L) == 0L) {
                this.connection.replayModes.remove(ReplayMode.RUNTIME_REPLAY_ENABLED);
                this.connection.replayModes.remove(ReplayMode.RUNTIME_OR_REPLAYING_STATIC);
            }

            if (var1.replayctx_kpdxcAppContCtl != null && var1.replayctx_kpdxcAppContCtl.length > 0 && (this.connection.getExecutingRPCFunctionCode() != 115 || !this.connection.ignoreReplayContextFromAuthentication)) {
                this.connection.thinACLastReplayContextReceived = var1;
            }

        }
    }

    private final void processEOCS() throws SQLException, IOException {
        if (this.connection.hasServerCompileTimeCapability(15, 1)) {
            int var1 = (int)this.meg.unmarshalUB4();
            this.connection.eocs = var1;
            if ((var1 & 8) != 0) {
                long var2 = this.meg.unmarshalSB8();
            }
        }

    }

    void processRPA() throws SQLException {
    }

    void readOAC() {
    }

    void readRPA() throws IOException, SQLException {
    }

    void readBVC() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    void readLOBD() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    void readIOV() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    void readRXH() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    boolean readRXD() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    void readIMPLRES() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    void readDCB() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    void processSLG() throws IOException, SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
        var1.fillInStackTrace();
        throw var1;
    }

    void processError() throws SQLException {
        this.oer.processError();
    }

    final int getErrorCode() throws SQLException {
        return this.oer.retCode;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
