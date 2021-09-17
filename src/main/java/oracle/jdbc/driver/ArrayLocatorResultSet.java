//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

class ArrayLocatorResultSet extends ForwardOnlyResultSet {
    static int COUNT_UNLIMITED = -1;
    Map map;
    long beginIndex;
    int count;
    long currentIndex;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static ArrayLocatorResultSet create(PhysicalConnection var0, ArrayDescriptor var1, byte[] var2, Map var3) throws SQLException {
        return create(var0, var1, var2, 0L, COUNT_UNLIMITED, var3);
    }

    static ArrayLocatorResultSet create(PhysicalConnection var0, ArrayDescriptor var1, byte[] var2, long var3, int var5, Map var6) throws SQLException {
        OraclePreparedStatement var7 = null;
        ARRAY var8 = new ARRAY(var1, var0, (byte[])null);
        var8.setLocator(var2);
        if (var1.getBaseType() != 2002 && var1.getBaseType() != 2008) {
            var7 = var0.prepareStatementInternal("SELECT ROWNUM, COLUMN_VALUE FROM TABLE( CAST(:1 AS " + var1.getName() + ") )", 1003, 1007);
        } else {
            var7 = var0.prepareStatementInternal("SELECT ROWNUM, SYS_NC_ROWINFO$ FROM TABLE( CAST(:1 AS " + var1.getName() + ") )", 1003, 1007);
        }

        var7.setArray(1, var8);
        var7.executeQuery();
        return new ArrayLocatorResultSet(var0, var7, var3, var5, var6);
    }

    private ArrayLocatorResultSet(OracleConnection var1, OracleStatement var2, long var3, int var5, Map var6) throws SQLException {
        super((PhysicalConnection)var1, var2);
        if (var1 != null && var2 != null) {
            this.closeStatementOnClose = true;
            this.count = var5;
            this.currentIndex = 0L;
            this.beginIndex = var3;
            this.map = var6;
        } else {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid arguments");
            var7.fillInStackTrace();
            throw var7;
        }
    }

    public boolean next() throws SQLException {
        synchronized(this.connection) {
            if (this.currentIndex < this.beginIndex) {
                do {
                    if (this.currentIndex >= this.beginIndex) {
                        return true;
                    }

                    ++this.currentIndex;
                } while(super.next());

                return false;
            } else if (this.count == COUNT_UNLIMITED) {
                return super.next();
            } else if (this.currentIndex < this.beginIndex + (long)this.count - 1L) {
                ++this.currentIndex;
                return super.next();
            } else {
                return false;
            }
        }
    }

    public Object getObject(int var1) throws SQLException {
        synchronized(this.connection) {
            return this.getObject(var1, this.map);
        }
    }

    public int findColumn(String var1) throws SQLException {
        synchronized(this.connection) {
            if (var1.equalsIgnoreCase("index")) {
                return 1;
            } else if (var1.equalsIgnoreCase("value")) {
                return 2;
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6, "get_column_index");
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }
}
