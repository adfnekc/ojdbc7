//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class XSKeyval {
    public XSKeyval() {
    }

    public static final XSKeyval constructXSKeyval() throws SQLException {
        return InternalFactory.createXSKeyval();
    }

    public abstract void setKeyval(KeywordValueLong[] var1) throws SQLException;

    public abstract void setFlag(long var1) throws SQLException;

    public abstract KeywordValueLong[] getKeyval();

    public abstract long getFlag();
}
