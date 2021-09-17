//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.sql.TIMESTAMP;

class T4CTTIaqm {
    static final int ATTR_ORIGINAL_MSGID = 69;
    static final byte ATTR_AGENT_NAME = 64;
    static final byte ATTR_AGENT_ADDRESS = 65;
    static final byte ATTR_AGENT_PROTOCOL = 66;
    static final int AQM_MSG_NO_DELAY = 0;
    static final int AQM_MSG_NO_EXPIRATION = -1;
    static final int AQM_MSGPROP_CORRID_SIZE = 128;
    int aqmpri;
    int aqmdel;
    int aqmexp;
    byte[] aqmcorBytes;
    int aqmcorBytesLength;
    int aqmatt;
    byte[] aqmeqnBytes;
    int aqmeqnBytesLength;
    int aqmsta;
    private byte[] aqmeqtBuffer = new byte[7];
    private int[] retInt = new int[1];
    TIMESTAMP aqmeqt;
    byte[] aqmetiBytes;
    byte[] senderAgentName = null;
    int senderAgentNameLength = 0;
    byte[] senderAgentAddress = null;
    int senderAgentAddressLength = 0;
    byte senderAgentProtocol = 0;
    byte[] originalMsgId;
    T4Ctoh toh;
    int aqmcsn;
    int aqmdsn;
    int aqmflg;
    T4CMAREngine mar;
    T4CConnection connection;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIaqm(T4CConnection var1, T4Ctoh var2) {
        this.toh = var2;
        this.connection = var1;
        this.mar = this.connection.mare;
    }

    void initToDefaultValues() {
        this.aqmpri = 0;
        this.aqmdel = 0;
        this.aqmexp = -1;
        this.aqmcorBytes = null;
        this.aqmcorBytesLength = 0;
        this.aqmatt = 0;
        this.aqmeqnBytes = null;
        this.aqmeqnBytesLength = 0;
        this.aqmsta = 0;
        this.aqmeqt = null;
        this.aqmetiBytes = null;
        this.senderAgentName = null;
        this.senderAgentNameLength = 0;
        this.senderAgentAddress = null;
        this.senderAgentAddressLength = 0;
        this.senderAgentProtocol = 0;
        this.originalMsgId = null;
        this.aqmcsn = 0;
        this.aqmdsn = 0;
        this.aqmflg = 0;
    }

    void marshal() throws IOException {
        this.mar.marshalSB4(this.aqmpri);
        this.mar.marshalSB4(this.aqmdel);
        this.mar.marshalSB4(this.aqmexp);
        if (this.aqmcorBytes != null && this.aqmcorBytes.length != 0) {
            this.mar.marshalSWORD(this.aqmcorBytes.length);
            this.mar.marshalCLR(this.aqmcorBytes, 0, this.aqmcorBytes.length);
        } else {
            this.mar.marshalSWORD(0);
        }

        this.mar.marshalSB4(0);
        if (this.aqmeqnBytes != null && this.aqmeqnBytes.length != 0) {
            this.mar.marshalSWORD(this.aqmeqnBytes.length);
            this.mar.marshalCLR(this.aqmeqnBytes, 0, this.aqmeqnBytes.length);
        } else {
            this.mar.marshalSWORD(0);
        }

        this.mar.marshalSB4(this.aqmsta);
        this.mar.marshalSWORD(0);
        if (this.connection.getTTCVersion() >= 3) {
            if (this.aqmetiBytes != null && this.aqmetiBytes.length > 0) {
                this.mar.marshalSWORD(this.aqmetiBytes.length);
                this.mar.marshalCLR(this.aqmetiBytes, 0, this.aqmetiBytes.length);
            } else {
                this.mar.marshalSWORD(0);
            }
        }

        byte var1 = 4;
        byte[][] var2 = new byte[var1][];
        byte[][] var3 = new byte[var1][];
        int[] var4 = new int[var1];
        var2[0] = this.senderAgentName;
        var3[0] = null;
        var4[0] = 64;
        var2[1] = this.senderAgentAddress;
        var3[1] = null;
        var4[1] = 65;
        var2[2] = null;
        var3[2] = new byte[1];
        var3[2][0] = this.senderAgentProtocol;
        var4[2] = 66;
        var2[3] = null;
        var3[3] = this.originalMsgId;
        var4[3] = 69;
        this.mar.marshalSWORD(var1);
        this.mar.marshalUB1((short)14);
        this.mar.marshalKPDKV(var2, var3, var4);
        if (this.connection.getTTCVersion() >= 3) {
            this.mar.marshalUB4(1L);
            this.toh.init(T4Ctoh.ANYDATA_TOID, 0);
            this.toh.marshal(this.mar);
            this.mar.marshalUB4(0L);
            this.mar.marshalUB4(0L);
            if (this.connection.getTTCVersion() >= 4) {
                this.mar.marshalUB4(0L);
            }
        }

    }

    void receive() throws SQLException, IOException {
        this.aqmpri = this.mar.unmarshalSB4();
        this.aqmdel = this.mar.unmarshalSB4();
        this.aqmexp = this.mar.unmarshalSB4();
        int var1 = this.mar.unmarshalSWORD();
        if (var1 > 0) {
            this.aqmcorBytes = new byte[var1];
            int[] var2 = new int[1];
            this.mar.unmarshalCLR(this.aqmcorBytes, 0, var2, this.aqmcorBytes.length);
            this.aqmcorBytesLength = var2[0];
        } else {
            this.aqmcorBytes = null;
        }

        this.aqmatt = this.mar.unmarshalSB4();
        int var10 = this.mar.unmarshalSWORD();
        if (var10 > 0) {
            this.aqmeqnBytes = new byte[var10];
            int[] var3 = new int[1];
            this.mar.unmarshalCLR(this.aqmeqnBytes, 0, var3, this.aqmeqnBytes.length);
            this.aqmeqnBytesLength = var3[0];
        } else {
            this.aqmeqnBytes = null;
        }

        this.aqmsta = this.mar.unmarshalSB4();
        int var11 = this.mar.unmarshalSB4();
        if (var11 > 0) {
            this.mar.unmarshalCLR(this.aqmeqtBuffer, 0, this.retInt, 7);
            this.aqmeqt = new TIMESTAMP(this.aqmeqtBuffer);
        }

        int var4;
        if (this.connection.getTTCVersion() >= 3) {
            var4 = this.mar.unmarshalSWORD();
            if (var4 > 0) {
                this.aqmetiBytes = new byte[var4];
                int[] var5 = new int[1];
                this.mar.unmarshalCLR(this.aqmetiBytes, 0, var5, this.aqmetiBytes.length);
            } else {
                this.aqmetiBytes = null;
            }
        }

        var4 = this.mar.unmarshalSWORD();
        if (var4 > 0) {
            this.mar.unmarshalUB1();
            byte[][] var12 = new byte[var4][];
            int[] var6 = new int[var4];
            byte[][] var7 = new byte[var4][];
            int[] var8 = new int[var4];
            this.mar.unmarshalKPDKV(var12, var6, var7, var8);

            for(int var9 = 0; var9 < var4; ++var9) {
                if (var8[var9] == 64 && var12[var9] != null && var6[var9] > 0) {
                    this.senderAgentName = var12[var9];
                    this.senderAgentNameLength = var6[var9];
                }

                if (var8[var9] == 65 && var12[var9] != null && var6[var9] > 0) {
                    this.senderAgentAddress = var12[var9];
                    this.senderAgentAddressLength = var6[var9];
                }

                if (var8[var9] == 66 && var7[var9] != null && var7[var9].length > 0) {
                    this.senderAgentProtocol = var7[var9][0];
                }

                if (var8[var9] == 69 && var7[var9] != null && var7[var9].length > 0) {
                    this.originalMsgId = var7[var9];
                }
            }
        }

        if (this.connection.getTTCVersion() >= 3) {
            int var13 = this.mar.unmarshalSWORD();
            this.aqmcsn = (int)this.mar.unmarshalUB4();
            this.aqmdsn = (int)this.mar.unmarshalUB4();
            if (this.connection.getTTCVersion() >= 4) {
                this.aqmflg = (int)this.mar.unmarshalUB4();
            }
        }

    }
}
