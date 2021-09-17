//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

public class JMSDequeueOptions {
    public static final int DEQUEUE_WAIT_FOREVER = 4;
    private JMSDequeueOptions.DequeueMode attrDeqMode;
    private JMSDequeueOptions.VisibilityOption attrVisibility;
    private int attrWait;
    private JMSDequeueOptions.DeliveryFilter attrDeliveryMode;
    private String consumerName = null;
    private String correlation = null;
    private boolean retrieveMessageId;
    private String condition;
    private byte[] deqMessageId = null;

    public JMSDequeueOptions() {
        this.attrDeqMode = JMSDequeueOptions.DequeueMode.REMOVE;
        this.deqMessageId = null;
        this.attrVisibility = JMSDequeueOptions.VisibilityOption.IMMEDIATE;
        this.attrWait = 4;
        this.attrDeliveryMode = JMSDequeueOptions.DeliveryFilter.PERSISTENT;
        this.retrieveMessageId = false;
    }

    public String getConsumerName() {
        return this.consumerName;
    }

    public void setConsumerName(String var1) {
        this.consumerName = var1;
    }

    public String getCorrelation() {
        return this.correlation;
    }

    public void setCorrelation(String var1) {
        this.correlation = var1;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String var1) {
        this.condition = var1;
    }

    public boolean isRetrieveMessageId() {
        return this.retrieveMessageId;
    }

    public void setRetrieveMessageId(boolean var1) {
        this.retrieveMessageId = var1;
    }

    public byte[] getDequeueMessageId() {
        return this.deqMessageId;
    }

    public void setDequeueMessageId(byte[] var1) {
        this.deqMessageId = var1;
    }

    public JMSDequeueOptions.DeliveryFilter getDeliveryMode() {
        return this.attrDeliveryMode;
    }

    public void setDeliveryMode(JMSDequeueOptions.DeliveryFilter var1) {
        this.attrDeliveryMode = var1;
    }

    public JMSDequeueOptions.DequeueMode getDequeueMode() {
        return this.attrDeqMode;
    }

    public void setDequeueMode(JMSDequeueOptions.DequeueMode var1) {
        this.attrDeqMode = var1;
    }

    public JMSDequeueOptions.VisibilityOption getVisibility() {
        return this.attrVisibility;
    }

    public void setVisibility(JMSDequeueOptions.VisibilityOption var1) {
        this.attrVisibility = var1;
    }

    public int getWait() {
        return this.attrWait;
    }

    public void setWait(int var1) {
        this.attrWait = var1;
    }

    public static enum DeliveryFilter {
        PERSISTENT(0),
        BUFFERED(128),
        PERSISTENT_OR_BUFFERED(256);

        private final int mode;

        private DeliveryFilter(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }

    public static enum DequeueMode {
        BROWSE(8),
        LOCKED(16),
        REMOVE(32),
        REMOVE_NODATA(64);

        private final int mode;

        private DequeueMode(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }

    public static enum VisibilityOption {
        ON_COMMIT(1),
        IMMEDIATE(2);

        private final int mode;

        private VisibilityOption(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }
}
