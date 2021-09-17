//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

public class JMSEnqueueOptions {
    private JMSEnqueueOptions.VisibilityOption attrVisibility;
    private JMSEnqueueOptions.DeliveryMode attrDeliveryMode;
    private boolean retrieveMessageId;

    public JMSEnqueueOptions() {
        this.attrVisibility = JMSEnqueueOptions.VisibilityOption.IMMEDIATE;
        this.attrDeliveryMode = JMSEnqueueOptions.DeliveryMode.PERSISTENT;
        this.retrieveMessageId = false;
    }

    public JMSEnqueueOptions.DeliveryMode getDeliveryMode() {
        return this.attrDeliveryMode;
    }

    public void setDeliveryMode(JMSEnqueueOptions.DeliveryMode var1) {
        this.attrDeliveryMode = var1;
    }

    public JMSEnqueueOptions.VisibilityOption getVisibility() {
        return this.attrVisibility;
    }

    public void setVisibility(JMSEnqueueOptions.VisibilityOption var1) {
        this.attrVisibility = var1;
    }

    public boolean isRetrieveMessageId() {
        return this.retrieveMessageId;
    }

    public void setRetrieveMessageId(boolean var1) {
        this.retrieveMessageId = var1;
    }

    public static enum DeliveryMode {
        PERSISTENT(0),
        BUFFERED(4),
        PERSISTENTORBUFFERED(8);

        private final int mode;

        private DeliveryMode(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }

    public static enum VisibilityOption {
        ON_COMMIT(2),
        IMMEDIATE(1);

        private final int mode;

        private VisibilityOption(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }
}
