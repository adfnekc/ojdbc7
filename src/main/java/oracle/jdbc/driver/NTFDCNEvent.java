//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.nio.ByteBuffer;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.QueryChangeDescription;
import oracle.jdbc.dcn.TableChangeDescription;
import oracle.jdbc.dcn.DatabaseChangeEvent.AdditionalEventType;
import oracle.jdbc.dcn.DatabaseChangeEvent.EventType;

class NTFDCNEvent extends DatabaseChangeEvent {
    private int notifVersion = 0;
    private int notifRegid = 0;
    private EventType eventType;
    private AdditionalEventType additionalEventType;
    private String databaseName;
    private byte[] notifXid;
    private int notifScn1;
    private int notifScn2;
    private int numberOfTables;
    private NTFDCNTableChanges[] tcdesc;
    private int numberOfQueries;
    private NTFDCNQueryChanges[] qdesc;
    private long registrationId;
    private NTFConnection conn;
    private int csid;
    private boolean isReady;
    private ByteBuffer dataBuffer;
    private boolean isDeregistrationEvent;
    private short databaseVersion;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFDCNEvent(NTFConnection var1, short var2) throws IOException, InterruptedException {
        super(var1);
        this.additionalEventType = AdditionalEventType.NONE;
        this.databaseName = null;
        this.notifXid = new byte[8];
        this.notifScn1 = 0;
        this.notifScn2 = 0;
        this.numberOfTables = 0;
        this.tcdesc = null;
        this.numberOfQueries = 0;
        this.qdesc = null;
        this.isReady = false;
        this.isDeregistrationEvent = false;
        this.conn = var1;
        this.csid = this.conn.charset.getOracleId();
        int var3 = this.conn.readInt();
        byte[] var4 = new byte[var3];
        this.conn.readBuffer(var4, 0, var3);
        this.dataBuffer = ByteBuffer.wrap(var4);
        this.databaseVersion = var2;
    }

    private void initEvent() {
        byte var1 = this.dataBuffer.get();
        int var2 = this.dataBuffer.getInt();
        byte[] var3 = new byte[var2];
        this.dataBuffer.get(var3, 0, var2);
        String var4 = null;

        try {
            var4 = new String(var3, "UTF-8");
        } catch (Exception var14) {
        }

        var4 = var4.replaceFirst("CHNF", "");
        this.registrationId = Long.parseLong(var4);
        byte var5 = this.dataBuffer.get();
        int var6 = this.dataBuffer.getInt();
        byte[] var7 = new byte[var6];
        this.dataBuffer.get(var7, 0, var6);
        byte var8 = this.dataBuffer.get();
        int var9 = this.dataBuffer.getInt();
        if (this.dataBuffer.hasRemaining()) {
            this.notifVersion = this.dataBuffer.getShort();
            this.notifRegid = this.dataBuffer.getInt();
            this.eventType = EventType.getEventType(this.dataBuffer.getInt());
            short var10 = this.dataBuffer.getShort();
            byte[] var11 = new byte[var10];
            this.dataBuffer.get(var11, 0, var10);

            try {
                this.databaseName = new String(var11, "UTF-8");
            } catch (Exception var13) {
            }

            this.dataBuffer.get(this.notifXid);
            this.notifScn1 = this.dataBuffer.getInt();
            this.notifScn2 = this.dataBuffer.getShort();
            int var12;
            if (this.eventType == EventType.OBJCHANGE) {
                this.numberOfTables = this.dataBuffer.getShort();
                this.tcdesc = new NTFDCNTableChanges[this.numberOfTables];

                for(var12 = 0; var12 < this.tcdesc.length; ++var12) {
                    this.tcdesc[var12] = new NTFDCNTableChanges(this.dataBuffer, this.csid);
                }
            } else if (this.eventType == EventType.QUERYCHANGE) {
                this.numberOfQueries = this.dataBuffer.getShort();
                this.qdesc = new NTFDCNQueryChanges[this.numberOfQueries];

                for(var12 = 0; var12 < this.numberOfQueries; ++var12) {
                    this.qdesc[var12] = new NTFDCNQueryChanges(this.dataBuffer, this.csid);
                }
            }
        }

        this.isReady = true;
    }

    public String getDatabaseName() {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.databaseName;
    }

    public TableChangeDescription[] getTableChangeDescription() {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.eventType == EventType.OBJCHANGE ? this.tcdesc : null;
    }

    public QueryChangeDescription[] getQueryChangeDescription() {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.eventType == EventType.QUERYCHANGE ? this.qdesc : null;
    }

    public byte[] getTransactionId() {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.notifXid;
    }

    public String getTransactionId(boolean var1) {
        if (!this.isReady) {
            this.initEvent();
        }

        int var2;
        int var3;
        long var4;
        if (!var1) {
            var2 = (this.notifXid[0] & 255) << 8 | this.notifXid[1] & 255;
            var3 = (this.notifXid[2] & 255) << 8 | this.notifXid[3] & 255;
            var4 = (long)(((this.notifXid[4] & 255) << 24 | (this.notifXid[5] & 255) << 16 | (this.notifXid[6] & 255) << 8 | this.notifXid[7] & 255) & -1);
        } else {
            var2 = (this.notifXid[1] & 255) << 8 | this.notifXid[0] & 255;
            var3 = (this.notifXid[3] & 255) << 8 | this.notifXid[2] & 255;
            var4 = (long)(((this.notifXid[7] & 255) << 24 | (this.notifXid[6] & 255) << 16 | (this.notifXid[5] & 255) << 8 | this.notifXid[4] & 255) & -1);
        }

        String var6 = "" + var2 + "." + var3 + "." + var4;
        return var6;
    }

    void setEventType(EventType var1) throws IOException {
        if (!this.isReady) {
            this.initEvent();
        }

        this.eventType = var1;
        if (this.eventType == EventType.DEREG) {
            this.isDeregistrationEvent = true;
        }

    }

    void setAdditionalEventType(AdditionalEventType var1) {
        this.additionalEventType = var1;
    }

    public EventType getEventType() {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.eventType;
    }

    public AdditionalEventType getAdditionalEventType() {
        return this.additionalEventType;
    }

    boolean isDeregistrationEvent() {
        return this.isDeregistrationEvent;
    }

    public String getConnectionInformation() {
        return this.conn.connectionDescription;
    }

    public int getRegistrationId() {
        if (!this.isReady) {
            this.initEvent();
        }

        return (int)this.registrationId;
    }

    public long getRegId() {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.registrationId;
    }

    public String toString() {
        if (!this.isReady) {
            this.initEvent();
        }

        StringBuffer var1 = new StringBuffer();
        var1.append("Connection information  : " + this.conn.connectionDescription + "\n");
        var1.append("Registration ID         : " + this.registrationId + "\n");
        var1.append("Notification version    : " + this.notifVersion + "\n");
        var1.append("Event type              : " + this.eventType + "\n");
        if (this.additionalEventType != AdditionalEventType.NONE) {
            var1.append("Additional event type   : " + this.additionalEventType + "\n");
        }

        if (this.databaseName != null) {
            var1.append("Database name           : " + this.databaseName + "\n");
        }

        TableChangeDescription[] var2 = this.getTableChangeDescription();
        if (var2 != null) {
            var1.append("Table Change Description (length=" + this.numberOfTables + ")\n");

            for(int var3 = 0; var3 < var2.length; ++var3) {
                var1.append(var2[var3].toString());
            }
        }

        QueryChangeDescription[] var5 = this.getQueryChangeDescription();
        if (var5 != null) {
            var1.append("Query Change Description (length=" + this.numberOfQueries + ")\n");

            for(int var4 = 0; var4 < var5.length; ++var4) {
                var1.append(var5[var4].toString());
            }
        }

        return var1.toString();
    }
}
