//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.math.BigDecimal;
import java.sql.SQLException;
import oracle.sql.CHAR;
import oracle.sql.CharacterSet;
import oracle.sql.Datum;
import oracle.sql.NUMBER;

class PlsqlIndexTableAccessor extends Accessor {
    static final int MAXLENGTH = -1;
    PlsqlIbtBindInfo ibtBindInfo;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    PlsqlIndexTableAccessor(OracleStatement var1, PlsqlIbtBindInfo var2, short var3) throws SQLException {
        super(Representation.PLSQL_INDEX_TABLE, var1, -1, true);
        this.init(var1, 998, 998, var3, true);
        this.ibtBindInfo = var2;
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        this.unimpl("initForDataAccess");
    }

    PlsqlIbtBindInfo plsqlIndexTableBindInfo() throws SQLException {
        return this.ibtBindInfo;
    }

    Object[] getPlsqlIndexTable(int var1) throws SQLException {
        Object var2;
        this.rowData.setPosition(this.getOffset(var1));
        int var3 = this.rowData.getInt();
        int var4;
        int var5;
        label41:
        switch(this.ibtBindInfo.element_internal_type) {
            case 6:
                var2 = new BigDecimal[var3];
                var4 = 0;

                while(true) {
                    if (var4 >= var3) {
                        break label41;
                    }

                    var5 = this.rowData.getShort();
                    if (var5 == 0) {
                        ((Object[])var2)[var4] = null;
                    } else {
                        ((Object[])var2)[var4] = oracle.sql.NUMBER.toBigDecimal(this.rowData.getBytes(var5));
                    }

                    ++var4;
                }
            case 9:
                var2 = new String[var3];
                var4 = 0;

                while(true) {
                    if (var4 >= var3) {
                        break label41;
                    }

                    var5 = this.rowData.getShort();
                    if (var5 == 0) {
                        ((Object[])var2)[var4] = null;
                    } else {
                        ((Object[])var2)[var4] = this.rowData.getString(var5, this.statement.connection.conversion.getCharacterSet((short)1));
                    }

                    ++var4;
                }
            default:
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 97);
                var6.fillInStackTrace();
                throw var6;
        }

        assert this.rowData.getPosition() == this.getOffset(var1) + (long)this.getLength(var1) : "rowData.position(): " + this.rowData.getPosition() + " getOffset(" + var1 + "): " + this.getOffset(var1) + " getLength(" + var1 + "): " + this.getLength(var1);

        return (Object[])var2;
    }

    Datum[] getOraclePlsqlIndexTable(int var1) throws SQLException {
        Object var2;
        this.rowData.setPosition(this.getOffset(var1));
        var2 = null;
        int var3 = this.rowData.getInt();
        int var5;
        int var6;
        label41:
        switch(this.ibtBindInfo.element_internal_type) {
            case 6:
                var2 = new NUMBER[var3];
                var5 = 0;

                while(true) {
                    if (var5 >= var3) {
                        break label41;
                    }

                    var6 = this.rowData.getShort();
                    if (var6 == 0) {
                        ((Object[])var2)[var5] = null;
                    } else {
                        ((Object[])var2)[var5] = new NUMBER(this.rowData.getBytes(var6));
                    }

                    ++var5;
                }
            case 9:
                var2 = new CHAR[var3];
                CharacterSet var4 = this.statement.connection.conversion.getDriverCharSetObj();
                var5 = 0;

                while(true) {
                    if (var5 >= var3) {
                        break label41;
                    }

                    var6 = this.rowData.getShort();
                    if (var6 == 0) {
                        ((Object[])var2)[var5] = null;
                    } else {
                        ((Object[])var2)[var5] = new CHAR(this.rowData.getBytes(var6), var4);
                    }

                    ++var5;
                }
            default:
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 97);
                var7.fillInStackTrace();
                throw var7;
        }

        assert this.rowData.getPosition() == this.getOffset(var1) + (long)this.getLength(var1) : "rowData.position(): " + this.rowData.getPosition() + " getOffset(" + var1 + "): " + this.getOffset(var1) + " getLength(" + var1 + "): " + this.getLength(var1);

        return (Datum[])var2;
    }
}
