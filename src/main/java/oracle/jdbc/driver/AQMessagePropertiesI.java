//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.jdbc.aq.AQAgent;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.aq.AQMessageProperties.DeliveryMode;
import oracle.jdbc.aq.AQMessageProperties.MessageState;

class AQMessagePropertiesI implements AQMessageProperties {
    private int attrAttempts = -1;
    private String attrCorrelation = null;
    private int attrDelay = 0;
    private Timestamp attrEnqTime = null;
    private String attrExceptionQueue = null;
    private int attrExpiration = -1;
    private MessageState attrMsgState = null;
    private int attrPriority = 0;
    private AQAgentI[] attrRecipientList = null;
    private AQAgentI attrSenderId = null;
    private String attrTransactionGroup = null;
    private byte[] attrPreviousQueueMsgId = null;
    private DeliveryMode deliveryMode = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    AQMessagePropertiesI() {
    }

    public int getDequeueAttemptsCount() {
        return this.attrAttempts;
    }

    public void setCorrelation(String var1) throws SQLException {
        this.attrCorrelation = var1;
    }

    public String getCorrelation() {
        return this.attrCorrelation;
    }

    public void setDelay(int var1) throws SQLException {
        this.attrDelay = var1;
    }

    public int getDelay() {
        return this.attrDelay;
    }

    public Timestamp getEnqueueTime() {
        return this.attrEnqTime;
    }

    public void setExceptionQueue(String var1) throws SQLException {
        this.attrExceptionQueue = var1;
    }

    public String getExceptionQueue() {
        return this.attrExceptionQueue;
    }

    public void setExpiration(int var1) throws SQLException {
        this.attrExpiration = var1;
    }

    public int getExpiration() {
        return this.attrExpiration;
    }

    public MessageState getState() {
        return this.attrMsgState;
    }

    public void setPriority(int var1) throws SQLException {
        this.attrPriority = var1;
    }

    public int getPriority() {
        return this.attrPriority;
    }

    public void setRecipientList(AQAgent[] var1) throws SQLException {
        if (var1 == null) {
            this.attrRecipientList = null;
        } else {
            this.attrRecipientList = new AQAgentI[var1.length];

            for(int var2 = 0; var2 < var1.length; ++var2) {
                this.attrRecipientList[var2] = (AQAgentI)var1[var2];
            }
        }

    }

    public AQAgent[] getRecipientList() {
        return this.attrRecipientList;
    }

    public void setSender(AQAgent var1) throws SQLException {
        this.attrSenderId = (AQAgentI)var1;
    }

    public AQAgent getSender() {
        return this.attrSenderId;
    }

    public String getTransactionGroup() {
        return this.attrTransactionGroup;
    }

    void setTransactionGroup(String var1) {
        this.attrTransactionGroup = var1;
    }

    void setPreviousQueueMessageId(byte[] var1) {
        this.attrPreviousQueueMsgId = var1;
    }

    public byte[] getPreviousQueueMessageId() {
        return this.attrPreviousQueueMsgId;
    }

    public DeliveryMode getDeliveryMode() {
        return this.deliveryMode;
    }

    void setDeliveryMode(DeliveryMode var1) {
        this.deliveryMode = var1;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("Correlation             : " + this.getCorrelation() + "\n");
        Timestamp var2 = this.getEnqueueTime();
        if (var2 != null) {
            var1.append("Enqueue time            : " + var2 + "\n");
        }

        var1.append("Exception Queue         : " + this.getExceptionQueue() + "\n");
        var1.append("Sender                  : (" + this.getSender() + ")\n");
        int var3 = this.getDequeueAttemptsCount();
        if (var3 != -1) {
            var1.append("Attempts                : " + var3 + "\n");
        }

        var1.append("Delay                   : " + this.getDelay() + "\n");
        var1.append("Expiration              : " + this.getExpiration() + "\n");
        MessageState var4 = this.getState();
        if (var4 != null) {
            var1.append("State                   : " + var4 + "\n");
        }

        var1.append("Priority                : " + this.getPriority() + "\n");
        DeliveryMode var5 = this.getDeliveryMode();
        if (var5 != null) {
            var1.append("Delivery Mode           : " + var5 + "\n");
        }

        var1.append("Recipient List          : {");
        AQAgent[] var6 = this.getRecipientList();
        if (var6 != null) {
            for(int var7 = 0; var7 < var6.length; ++var7) {
                var1.append(var6[var7]);
                if (var7 != var6.length - 1) {
                    var1.append("; ");
                }
            }
        }

        var1.append("}");
        return var1.toString();
    }

    void setAttempts(int var1) throws SQLException {
        this.attrAttempts = var1;
    }

    void setEnqueueTime(Timestamp var1) throws SQLException {
        this.attrEnqTime = var1;
    }

    void setMessageState(MessageState var1) throws SQLException {
        this.attrMsgState = var1;
    }
}
