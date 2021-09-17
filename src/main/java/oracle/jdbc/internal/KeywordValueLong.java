//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import oracle.jdbc.driver.InternalFactory;

import java.sql.SQLException;

public abstract class KeywordValueLong {
    public KeywordValueLong() {
    }

    public static final KeywordValueLong constructKeywordValue(int var0, String var1) throws SQLException {
        return InternalFactory.createKeywordValueLong(var0, var1, (byte[]) null);
    }

    public static final KeywordValueLong constructKeywordValue(int var0, byte[] var1) throws SQLException {
        return InternalFactory.createKeywordValueLong(var0, (String) null, var1);
    }

    public abstract int getKeyword() throws SQLException;

    public abstract byte[] getBinaryValue() throws SQLException;

    public abstract String getTextValue() throws SQLException;
}
