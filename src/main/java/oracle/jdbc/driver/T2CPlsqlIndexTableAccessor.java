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

class T2CPlsqlIndexTableAccessor extends PlsqlIndexTableAccessor {
    int ibtMetaIndex;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T2CPlsqlIndexTableAccessor(OracleStatement var1, PlsqlIbtBindInfo var2, short var3) throws SQLException {
        super(var1, var2, var3);
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        this.unimpl("initForDataAccess");
    }

    Object[] getPlsqlIndexTable(int var1) throws SQLException {
        short[] var3 = this.statement.ibtBindIndicators;
        int var4 = ((var3[this.ibtMetaIndex + 4] & '\uffff') << 16) + (var3[this.ibtMetaIndex + 5] & '\uffff');
        long var5 = this.getOffset(var1);
        int var7 = this.ibtBindInfo.elemMaxLen;
        Object var2;
        int var9;
        switch(this.ibtBindInfo.element_internal_type) {
            case 6:
                var2 = new BigDecimal[var4];

                for(int var12 = 0; var12 < var4; ++var12) {
                    this.rowData.setPosition(var5);
                    var9 = this.rowData.get() & 255;
                    if (var9 == 0) {
                        ((Object[])var2)[var12] = null;
                    } else {
                        ((Object[])var2)[var12] = oracle.sql.NUMBER.toBigDecimal(this.rowData.getBytes(var9));
                    }

                    var5 += (long)var7;
                }

                return (Object[])var2;
            case 9:
                int[] var8 = new int[1];
                var2 = new String[var4];

                for(var9 = 0; var9 < var4; ++var9) {
                    this.rowData.setPosition(var5);
                    char[] var10 = this.rowData.getChars(var5, 1, this.statement.connection.conversion.getCharacterSet((short)1), var8);
                    int var11 = var10[0] / 2;
                    this.rowData.setPosition(var5 + 1L);
                    if (var11 == 0) {
                        ((Object[])var2)[var9] = null;
                    } else {
                        ((Object[])var2)[var9] = this.rowData.getString(var11, this.statement.connection.conversion.getCharacterSet((short)1));
                    }

                    var5 += (long)var7;
                }

                return (Object[])var2;
            default:
                SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 97);
                var13.fillInStackTrace();
                throw var13;
        }
    }

    Datum[] getOraclePlsqlIndexTable(int var1) throws SQLException {
        short[] var2 = this.statement.ibtBindIndicators;
        int var3 = ((var2[this.ibtMetaIndex + 4] & '\uffff') << 16) + (var2[this.ibtMetaIndex + 5] & '\uffff');
        long var4 = this.getOffset(var1);
        int var6 = this.ibtBindInfo.elemMaxLen;
        Object var7 = null;
        switch(this.ibtBindInfo.element_internal_type) {
            case 6:
                var7 = new NUMBER[var3];

                for(int var14 = 0; var14 < var3; ++var14) {
                    this.rowData.setPosition(var4);
                    int var16 = this.rowData.get() & 255;
                    if (var16 == 0) {
                        ((Object[])var7)[var14] = null;
                    } else {
                        ((Object[])var7)[var14] = new NUMBER(this.rowData.getBytes(var16));
                    }

                    var4 += (long)var6;
                }

                return (Datum[])var7;
            case 9:
                int[] var8 = new int[1];
                var7 = new CHAR[var3];
                CharacterSet var9 = this.statement.connection.conversion.getDriverCharSetObj();

                for(int var10 = 0; var10 < var3; ++var10) {
                    this.rowData.setPosition(var4);
                    char[] var11 = this.rowData.getChars(var4, 1, this.statement.connection.conversion.getCharacterSet((short)1), var8);
                    int var12 = var11[0] / 2;
                    this.rowData.setPosition(var4 + 1L);
                    if (var12 == 0) {
                        ((Object[])var7)[var10] = null;
                    } else {
                        String var13 = this.rowData.getString(var12, this.statement.connection.conversion.getCharacterSet((short)1));
                        ((Object[])var7)[var10] = new CHAR(var13, var9);
                    }

                    var4 += (long)var6;
                }

                return (Datum[])var7;
            default:
                SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 97);
                var15.fillInStackTrace();
                throw var15;
        }
    }
}
