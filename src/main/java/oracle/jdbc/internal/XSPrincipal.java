//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class XSPrincipal {
    public XSPrincipal() {
    }

    public static final XSPrincipal constructXSPrincipal() throws SQLException {
        return InternalFactory.createXSPrincipal();
    }

    public abstract void setDatabaseId(long var1) throws SQLException;

    public abstract void setName(String var1) throws SQLException;

    public abstract void setUUID(byte[] var1) throws SQLException;

    public abstract void setFlag(XSPrincipal.Flag var1) throws SQLException;

    public abstract long getDatabaseId();

    public abstract String getName();

    public abstract byte[] getUUID();

    public abstract XSPrincipal.Flag getFlag();

    public static enum Flag {
        KPXS_PRIN_EXT(1L),
        KPXS_PRIN_USEDBID(2L);

        private final long mode;

        private Flag(long var3) {
            this.mode = var3;
        }

        public final long getMode() {
            return this.mode;
        }
    }
}
