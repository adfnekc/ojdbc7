//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

class PlsqlIbtBindInfo {
    Object[] arrayData;
    int maxLen;
    int curLen;
    int element_internal_type;
    int elemMaxLen;
    int ibtByteLength;
    int ibtCharLength;
    int ibtValueIndex;
    int ibtIndicatorIndex;
    int ibtLengthIndex;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    PlsqlIbtBindInfo(OraclePreparedStatement var1, Object[] var2, int var3, int var4, int var5, int var6) throws SQLException {
        this.arrayData = var2;
        this.maxLen = var3;
        this.curLen = var4;
        this.element_internal_type = var5;
        boolean var7 = this.arrayData == null;
        switch(this.element_internal_type) {
            case 1:
            case 96:
                if (var7) {
                    this.elemMaxLen = var6 + 1;
                    this.ibtCharLength = this.elemMaxLen * this.maxLen;
                } else {
                    this.elemMaxLen = var6 == 0 ? 2 : var6 + 1;
                    this.ibtCharLength = this.elemMaxLen * this.maxLen;
                }

                this.element_internal_type = 9;
                break;
            case 6:
                this.elemMaxLen = 22;
                this.ibtByteLength = this.elemMaxLen * this.maxLen;
                break;
            default:
                SQLException var8 = DatabaseError.createSqlException((OracleConnection)null, 97);
                var8.fillInStackTrace();
                throw var8;
        }

    }
}
