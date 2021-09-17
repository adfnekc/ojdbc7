//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class KeywordValue {
    public KeywordValue() {
    }

    public abstract int getKeyword() throws SQLException;

    public abstract byte[] getBinaryValue() throws SQLException;

    public abstract String getTextValue() throws SQLException;

    public static final KeywordValue constructKeywordValue(int var0, String var1) throws SQLException {
        return InternalFactory.createKeywordValue(var0, var1, (byte[])null);
    }

    public static final KeywordValue constructKeywordValue(int var0, byte[] var1) throws SQLException {
        return InternalFactory.createKeywordValue(var0, (String)null, var1);
    }
}
