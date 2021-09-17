//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class XSAttribute {
    public XSAttribute() {
    }

    public static final XSAttribute constructXSAttribute() throws SQLException {
        return InternalFactory.createXSAttribute();
    }

    public abstract void setAttributeName(String var1) throws SQLException;

    public abstract void setAttributeValue(String var1) throws SQLException;

    public abstract void setAttributeDefaultValue(String var1) throws SQLException;

    public abstract void setFlag(long var1) throws SQLException;

    public abstract String getAttributeName();

    public abstract String getAttributeValue();

    public abstract String getAttributeDefaultValue();

    public abstract long getFlag();
}
