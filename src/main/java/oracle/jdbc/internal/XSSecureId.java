//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class XSSecureId {
    public XSSecureId() {
    }

    public static final XSSecureId constructXSecureId() throws SQLException {
        return InternalFactory.createXSecureId();
    }

    public abstract void setMac(byte[] var1) throws SQLException;

    public abstract void setMidtierId(byte[] var1) throws SQLException;

    public abstract void setNonce(long var1) throws SQLException;

    public abstract byte[] getMac();

    public abstract byte[] getMidtierId();

    public abstract long getNonce();
}
