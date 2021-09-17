//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class XSSessionParameters {
    public XSSessionParameters() {
    }

    public static XSSessionParameters constructXSSessionParameters() throws SQLException {
        return InternalFactory.createXSSessionParameters();
    }

    public abstract void setBinary(byte[] var1) throws SQLException;

    public abstract void setInt(int var1) throws SQLException;

    public abstract void setText(String[] var1) throws SQLException;
}
