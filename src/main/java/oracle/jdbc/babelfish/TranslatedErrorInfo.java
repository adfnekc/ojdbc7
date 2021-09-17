//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

class TranslatedErrorInfo {
    private int errorCode;
    private String sqlState;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    TranslatedErrorInfo() {
    }

    TranslatedErrorInfo(int var1, String var2) {
        this();
        this.errorCode = var1;
        this.sqlState = var2;
    }

    int getErrorCode() {
        return this.errorCode;
    }

    String getSqlState() {
        return this.sqlState;
    }

    void setErrorCode(int var1) {
        this.errorCode = var1;
    }

    void setSqlState(String var1) {
        this.sqlState = var1;
    }
}
