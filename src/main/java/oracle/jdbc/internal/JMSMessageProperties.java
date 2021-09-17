//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

public interface JMSMessageProperties {
    String getHeaderProperties();

    void setHeaderProperties(String var1);

    JMSMessageProperties.JMSMessageType getJMSMessageType();

    void setJMSMessageType(JMSMessageProperties.JMSMessageType var1);

    String getUserProperties();

    void setUserProperties(String var1);

    public static enum JMSMessageType {
        TEXT_MESSAGE(0),
        BYTES_MESSAGE(1),
        STREAM_MESSAGE(2),
        MAP_MESSAGE(3),
        OBJECT_MESSAGE(4),
        MESSAGE(100);

        private final int code;

        private JMSMessageType(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final JMSMessageProperties.JMSMessageType getJMSMessageType(int var0) {
            if (var0 == TEXT_MESSAGE.getCode()) {
                return TEXT_MESSAGE;
            } else if (var0 == BYTES_MESSAGE.getCode()) {
                return BYTES_MESSAGE;
            } else if (var0 == STREAM_MESSAGE.getCode()) {
                return STREAM_MESSAGE;
            } else if (var0 == MAP_MESSAGE.getCode()) {
                return MAP_MESSAGE;
            } else {
                return var0 == OBJECT_MESSAGE.getCode() ? OBJECT_MESSAGE : MESSAGE;
            }
        }
    }
}
