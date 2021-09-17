//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;

public class JAVA_STRUCT extends STRUCT {
    static final long serialVersionUID = 2211611973003094149L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public JAVA_STRUCT(StructDescriptor var1, Connection var2, Object[] var3) throws SQLException {
        super(var1, var2, var3);
    }

    public JAVA_STRUCT(StructDescriptor var1, byte[] var2, Connection var3) throws SQLException {
        super(var1, var2, var3);
    }

    public Object toJdbc() throws SQLException {
        Object var1 = this.getInternalConnection().getJavaObjectTypeMap();
        Class var2 = null;
        if (var1 != null) {
            var2 = this.descriptor.getClass((Map)var1);
        } else {
            var1 = new Hashtable(10);
            this.getInternalConnection().setJavaObjectTypeMap((Map)var1);
        }

        if (var2 == null) {
            String var3 = StructDescriptor.getJavaObjectClassName(this.getInternalConnection(), this.getDescriptor());
            String var4 = this.getDescriptor().getSchemaName();
            if (var3 == null || var3.length() == 0) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                var5.fillInStackTrace();
                throw var5;
            }

            try {
                var2 = this.getInternalConnection().classForNameAndSchema(var3, var4);
            } catch (ClassNotFoundException var7) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, "ClassNotFoundException: " + var7.getMessage());
                var6.fillInStackTrace();
                throw var6;
            }

            ((Map)var1).put(this.getSQLTypeName(), var2);
        }

        return this.toClass(var2, this.getMap());
    }

    public Object toJdbc(Map var1) throws SQLException {
        return this.toJdbc();
    }
}
