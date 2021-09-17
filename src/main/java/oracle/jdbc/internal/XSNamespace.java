//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;
import oracle.sql.TIMESTAMPTZ;

public abstract class XSNamespace {
    public static final int ACL_ID_LENGTH = 16;

    public XSNamespace() {
    }

    public static final XSNamespace constructXSNamespace() throws SQLException {
        return InternalFactory.createXSNamespace();
    }

    public abstract void setNamespaceName(String var1) throws SQLException;

    public abstract void setNamespaceHandler(String var1) throws SQLException;

    public abstract void setTimestamp(TIMESTAMPTZ var1) throws SQLException;

    public abstract void setFlag(long var1) throws SQLException;

    public abstract void setAttributes(XSAttribute[] var1) throws SQLException;

    public abstract void setACLIdList(long[] var1) throws SQLException;

    public abstract String getNamespaceName();

    public abstract String getNamespaceHandler();

    public abstract TIMESTAMPTZ getTimestamp();

    public abstract long getFlag();

    public abstract XSAttribute[] getAttributes();

    public abstract long[] getACLIdList();
}
