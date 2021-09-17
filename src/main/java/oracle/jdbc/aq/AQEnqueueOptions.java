//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;
import oracle.jdbc.aq.AQDequeueOptions.DeliveryFilter;

public class AQEnqueueOptions {
    private byte[] attrRelativeMessageId = null;
    private AQEnqueueOptions.SequenceDeviationOption attrSequenceDeviation;
    private AQEnqueueOptions.VisibilityOption attrVisibility;
    private AQEnqueueOptions.DeliveryMode attrDeliveryMode;
    private boolean retrieveMsgId;
    private String transformation;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public AQEnqueueOptions() {
        this.attrSequenceDeviation = AQEnqueueOptions.SequenceDeviationOption.BOTTOM;
        this.attrVisibility = AQEnqueueOptions.VisibilityOption.ON_COMMIT;
        this.attrDeliveryMode = AQEnqueueOptions.DeliveryMode.PERSISTENT;
        this.retrieveMsgId = false;
    }

    /** @deprecated */
    public void setRelativeMessageId(byte[] var1) throws SQLException {
        this.attrRelativeMessageId = var1;
    }

    public byte[] getRelativeMessageId() {
        return this.attrRelativeMessageId;
    }

    /** @deprecated */
    public void setSequenceDeviation(AQEnqueueOptions.SequenceDeviationOption var1) throws SQLException {
        this.attrSequenceDeviation = var1;
    }

    public AQEnqueueOptions.SequenceDeviationOption getSequenceDeviation() {
        return this.attrSequenceDeviation;
    }

    public void setVisibility(AQEnqueueOptions.VisibilityOption var1) throws SQLException {
        this.attrVisibility = var1;
    }

    public AQEnqueueOptions.VisibilityOption getVisibility() {
        return this.attrVisibility;
    }

    public void setDeliveryMode(AQEnqueueOptions.DeliveryMode var1) throws SQLException {
        this.attrDeliveryMode = var1;
    }

    public AQEnqueueOptions.DeliveryMode getDeliveryMode() {
        return this.attrDeliveryMode;
    }

    public void setRetrieveMessageId(boolean var1) {
        this.retrieveMsgId = var1;
    }

    public boolean getRetrieveMessageId() {
        return this.retrieveMsgId;
    }

    public void setTransformation(String var1) {
        this.transformation = var1;
    }

    public String getTransformation() {
        return this.transformation;
    }

    public static enum DeliveryMode {
        PERSISTENT(DeliveryFilter.PERSISTENT.getCode()),
        BUFFERED(DeliveryFilter.BUFFERED.getCode());

        private final int mode;

        private DeliveryMode(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }

    public static enum SequenceDeviationOption {
        BOTTOM(0),
        BEFORE(2),
        TOP(3);

        private final int mode;

        private SequenceDeviationOption(int var3) {
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
