//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;

public class SQLName implements Serializable {
    static boolean DEBUG = false;
    static boolean s_parseAllFormat = false;
    static final long serialVersionUID = 2266340348729491526L;
    String name;
    String schema;
    String simple;
    int version;
    boolean synonym;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected SQLName() {
    }

    public SQLName(String var1, OracleConnection var2) throws SQLException {
        this.init(var1, var2);
        this.version = 2;
        this.synonym = false;
    }

    public SQLName(String var1, String var2, OracleConnection var3) throws SQLException {
        this.schema = var1;
        this.simple = var2;
        this.name = this.schema + "." + this.simple;
        this.version = 2;
        this.synonym = false;
    }

    private void init(String var1, OracleConnection var2) throws SQLException {
        String[] var3 = new String[1];
        String[] var4 = new String[1];
        if (parse(var1, var3, var4, true)) {
            this.schema = var3[0];
            this.simple = var4[0];
        } else {
            this.schema = var2.physicalConnectionWithin().getDefaultSchemaNameForNamedTypes();
            this.simple = var4[0];
        }

        this.name = this.schema + "." + this.simple;
    }

    public String getName() throws SQLException {
        return this.name;
    }

    public String getSchema() throws SQLException {
        return this.schema;
    }

    public String getSimpleName() throws SQLException {
        return this.simple;
    }

    public int getVersion() throws SQLException {
        return this.version;
    }

    public static boolean parse(String var0, String[] var1, String[] var2) throws SQLException {
        return parse(var0, var1, var2, s_parseAllFormat);
    }

    public static boolean parse(String var0, String[] var1, String[] var2, boolean var3) throws SQLException {
        if (var0 == null) {
            return false;
        } else if (var1 != null && var1.length >= 1 && var2 != null && var2.length >= 1) {
            int var8;
            if (!var3) {
                var8 = var0.indexOf(".");
                if (var8 < 0) {
                    var2[0] = var0;
                    return false;
                } else {
                    var1[0] = var0.substring(0, var8);
                    var2[0] = var0.substring(var8 + 1);
                    return true;
                }
            } else {
                var8 = var0.length();
                int var5 = var0.indexOf("\"");
                int var6 = var0.indexOf("\"", var5 + 1);
                boolean var7 = true;
                int var9;
                if (var5 < 0) {
                    var9 = var0.indexOf(".");
                    if (var9 < 0) {
                        var2[0] = var0;
                        return false;
                    } else {
                        var1[0] = var0.substring(0, var9);
                        var2[0] = var0.substring(var9 + 1);
                        return true;
                    }
                } else if (var5 == 0) {
                    if (var6 == var8 - 1) {
                        var2[0] = var0.substring(var5 + 1, var6);
                        return false;
                    } else {
                        var9 = var0.indexOf(".", var6);
                        var1[0] = var0.substring(var5 + 1, var6);
                        var5 = var0.indexOf("\"", var9);
                        var6 = var0.indexOf("\"", var5 + 1);
                        if (var5 < 0) {
                            var2[0] = var0.substring(var9 + 1);
                            return true;
                        } else {
                            var2[0] = var0.substring(var5 + 1, var6);
                            return true;
                        }
                    }
                } else {
                    var9 = var0.indexOf(".");
                    var1[0] = var0.substring(0, var9);
                    var2[0] = var0.substring(var5 + 1, var6);
                    return true;
                }
            }
        } else {
            SQLException var4 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public static void setHandleDoubleQuote(boolean var0) throws SQLException {
        s_parseAllFormat = var0;
    }

    public static boolean getHandleDoubleQuote() throws SQLException {
        return s_parseAllFormat;
    }

    public boolean equals(Object var1) {
        if (var1 == this) {
            return true;
        } else {
            return !(var1 instanceof SQLName) ? false : ((SQLName)var1).name.equals(this.name);
        }
    }

    public int hashCode() {
        return this.name == null ? -1 : this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeUTF(this.name);
        var1.writeUTF(this.schema);
        var1.writeUTF(this.simple);
        var1.writeInt(this.version);
        var1.writeBoolean(this.synonym);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.name = var1.readUTF();
        this.schema = var1.readUTF();
        this.simple = var1.readUTF();
        this.version = var1.readInt();
        this.synonym = var1.readBoolean();
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
