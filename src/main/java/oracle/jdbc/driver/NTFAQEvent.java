//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.aq.AQNotificationEvent;
import oracle.jdbc.aq.AQMessageProperties.DeliveryMode;
import oracle.jdbc.aq.AQMessageProperties.MessageState;
import oracle.jdbc.aq.AQNotificationEvent.AdditionalEventType;
import oracle.jdbc.aq.AQNotificationEvent.EventType;
import oracle.sql.TIMESTAMP;

class NTFAQEvent extends AQNotificationEvent {
    private String registrationString;
    private int namespace;
    private byte[] payload;
    private String queueName = null;
    private byte[] messageId = null;
    private String consumerName = null;
    private NTFConnection conn;
    private AQMessagePropertiesI msgProp;
    private EventType eventType;
    private AdditionalEventType additionalEventType;
    private ByteBuffer dataBuffer;
    private boolean isReady;
    private short databaseVersion;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFAQEvent(NTFConnection var1, short var2) throws IOException, InterruptedException {
        super(var1);
        this.eventType = EventType.REGULAR;
        this.additionalEventType = AdditionalEventType.NONE;
        this.isReady = false;
        this.conn = var1;
        int var3 = this.conn.readInt();
        byte[] var4 = new byte[var3];
        this.conn.readBuffer(var4, 0, var3);
        this.dataBuffer = ByteBuffer.wrap(var4);
        this.databaseVersion = var2;
    }

    private void initEvent() throws SQLException {
        byte var1 = this.dataBuffer.get();
        int var2 = this.dataBuffer.getInt();
        byte[] var3 = new byte[var2];
        this.dataBuffer.get(var3, 0, var2);
        this.registrationString = this.conn.charset.toString(var3, 0, var2);
        byte var4 = this.dataBuffer.get();
        int var5 = this.dataBuffer.getInt();
        byte[] var6 = new byte[var5];
        this.dataBuffer.get(var6, 0, var5);
        this.namespace = var6[0];
        byte var7 = this.dataBuffer.get();
        int var8 = this.dataBuffer.getInt();
        if (var8 > 0) {
            this.payload = new byte[var8];
            this.dataBuffer.get(this.payload, 0, var8);
        } else {
            this.payload = null;
        }

        if (this.dataBuffer.hasRemaining()) {
            int var9 = 0;
            byte var10;
            int var11;
            if (this.databaseVersion >= 10200) {
                var10 = this.dataBuffer.get();
                var11 = this.dataBuffer.getInt();
                var9 = this.dataBuffer.getInt();
            }

            var10 = this.dataBuffer.get();
            var11 = this.dataBuffer.getInt();
            byte[] var12 = new byte[var11];
            this.dataBuffer.get(var12, 0, var11);
            this.queueName = this.conn.charset.toString(var12, 0, var11);
            byte var13 = this.dataBuffer.get();
            int var14 = this.dataBuffer.getInt();
            this.messageId = new byte[var14];
            this.dataBuffer.get(this.messageId, 0, var14);
            byte var15 = this.dataBuffer.get();
            int var16 = this.dataBuffer.getInt();
            byte[] var17 = new byte[var16];
            this.dataBuffer.get(var17, 0, var16);
            this.consumerName = this.conn.charset.toString(var17, 0, var16);
            byte var18 = this.dataBuffer.get();
            int var19 = this.dataBuffer.getInt();
            byte[] var20 = new byte[var19];
            this.dataBuffer.get(var20, 0, var19);
            byte var21 = this.dataBuffer.get();
            int var22 = this.dataBuffer.getInt();
            int var23 = this.dataBuffer.getInt();
            if (var20[0] == 1) {
                var23 = -var23;
            }

            byte var25 = this.dataBuffer.get();
            int var26 = this.dataBuffer.getInt();
            int var27 = this.dataBuffer.getInt();
            byte var28 = this.dataBuffer.get();
            int var29 = this.dataBuffer.getInt();
            byte[] var30 = new byte[var29];
            this.dataBuffer.get(var30, 0, var29);
            byte var31 = this.dataBuffer.get();
            int var32 = this.dataBuffer.getInt();
            int var33 = this.dataBuffer.getInt();
            if (var30[0] == 1) {
                var33 = -var33;
            }

            byte var35 = this.dataBuffer.get();
            int var36 = this.dataBuffer.getInt();
            int var37 = this.dataBuffer.getInt();
            byte var38 = this.dataBuffer.get();
            int var39 = this.dataBuffer.getInt();
            byte[] var40 = new byte[var39];
            this.dataBuffer.get(var40, 0, var39);
            TIMESTAMP var41 = new TIMESTAMP(var40);
            byte var42 = this.dataBuffer.get();
            int var43 = this.dataBuffer.getInt();
            byte[] var44 = new byte[var43];
            this.dataBuffer.get(var44, 0, var43);
            byte var45 = var44[0];
            byte var46 = this.dataBuffer.get();
            int var47 = this.dataBuffer.getInt();
            byte[] var48 = new byte[var47];
            this.dataBuffer.get(var48, 0, var47);
            String var49 = this.conn.charset.toString(var48, 0, var47);
            byte var50 = this.dataBuffer.get();
            int var51 = this.dataBuffer.getInt();
            byte[] var52 = new byte[var51];
            this.dataBuffer.get(var52, 0, var51);
            String var53 = this.conn.charset.toString(var52, 0, var51);
            byte var54 = this.dataBuffer.get();
            int var55 = this.dataBuffer.getInt();
            byte[] var56 = null;
            if (var55 > 0) {
                var56 = new byte[var55];
                this.dataBuffer.get(var56, 0, var55);
            }

            byte var57 = this.dataBuffer.get();
            int var58 = this.dataBuffer.getInt();
            byte[] var59 = new byte[var58];
            this.dataBuffer.get(var59, 0, var58);
            String var60 = this.conn.charset.toString(var59, 0, var58);
            byte var61 = this.dataBuffer.get();
            int var62 = this.dataBuffer.getInt();
            byte[] var63 = new byte[var62];
            this.dataBuffer.get(var63, 0, var62);
            String var64 = this.conn.charset.toString(var63, 0, var62);
            byte var65 = this.dataBuffer.get();
            int var66 = this.dataBuffer.getInt();
            byte var67 = this.dataBuffer.get();
            this.msgProp = new AQMessagePropertiesI();
            this.msgProp.setAttempts(var37);
            this.msgProp.setCorrelation(var53);
            this.msgProp.setDelay(var27);
            this.msgProp.setEnqueueTime(var41.timestampValue());
            this.msgProp.setMessageState(MessageState.getMessageState(var45));
            if (this.databaseVersion >= 10200) {
                this.msgProp.setDeliveryMode(DeliveryMode.getDeliveryMode(var9));
            }

            this.msgProp.setPreviousQueueMessageId(var56);
            AQAgentI var68 = new AQAgentI();
            var68.setAddress(var64);
            var68.setName(var60);
            var68.setProtocol(var67);
            this.msgProp.setSender(var68);
            this.msgProp.setPriority(var23);
            this.msgProp.setExpiration(var33);
            this.msgProp.setExceptionQueue(var49);
        }

        this.isReady = true;
    }

    public AQMessageProperties getMessageProperties() throws SQLException {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.msgProp;
    }

    public String getRegistration() throws SQLException {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.registrationString;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public AdditionalEventType getAdditionalEventType() {
        return this.additionalEventType;
    }

    void setEventType(EventType var1) throws IOException {
        this.eventType = var1;
    }

    void setAdditionalEventType(AdditionalEventType var1) {
        this.additionalEventType = var1;
    }

    public byte[] getPayload() throws SQLException {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.payload;
    }

    public String getQueueName() throws SQLException {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.queueName;
    }

    public byte[] getMessageId() throws SQLException {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.messageId;
    }

    public String getConsumerName() throws SQLException {
        if (!this.isReady) {
            this.initEvent();
        }

        return this.consumerName;
    }

    public String getConnectionInformation() {
        return this.conn.connectionDescription;
    }

    public String toString() {
        if (!this.isReady) {
            try {
                this.initEvent();
            } catch (SQLException var2) {
                return var2.getMessage();
            }
        }

        StringBuffer var1 = new StringBuffer();
        var1.append("Connection information  : " + this.conn.connectionDescription + "\n");
        var1.append("Event type              : " + this.eventType + "\n");
        if (this.additionalEventType != AdditionalEventType.NONE) {
            var1.append("Additional event type   : " + this.additionalEventType + "\n");
        }

        var1.append("Namespace               : " + this.namespace + "\n");
        var1.append("Registration            : " + this.registrationString + "\n");
        var1.append("Queue name              : " + this.queueName + "\n");
        var1.append("Consumer name           : " + this.consumerName + "\n");
        if (this.payload != null) {
            var1.append("Payload length          : " + this.payload.length + "\n");
            var1.append("Payload (first 50 bytes): " + byteBufferToHexString(this.payload, 50) + "\n");
        } else {
            var1.append("Payload                 : null\n");
        }

        var1.append("Message ID              : " + byteBufferToHexString(this.messageId, 50) + "\n");
        if (this.msgProp != null) {
            var1.append(this.msgProp.toString());
        }

        return var1.toString();
    }

    static final String byteBufferToHexString(byte[] var0, int var1) {
        if (var0 == null) {
            return null;
        } else {
            int var2 = 0;
            boolean var3 = true;

            StringBuffer var4;
            String var5;
            for(var4 = new StringBuffer(); var2 < var0.length && var2 < var1; ++var2) {
                if (!var3) {
                    var4.append(' ');
                } else {
                    var3 = false;
                }

                var5 = Integer.toHexString(var0[var2] & 255);
                if (var5.length() == 1) {
                    var5 = "0" + var5;
                }

                var4.append(var5);
            }

            var5 = var4.toString();
            return var5;
        }
    }
}
