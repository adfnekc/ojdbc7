//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executor;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.dcn.DatabaseChangeRegistration;

class NTFDCNRegistration extends NTFRegistration implements DatabaseChangeRegistration {
    private final long regid;
    private String[] tables = new String[10];
    private int nbOfStringsInTable = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFDCNRegistration(int var1, boolean var2, String var3, long var4, String var6, String var7, int var8, Properties var9, short var10) {
        super(var1, 2, var2, var3, var7, var8, var9, var6, var10);
        this.regid = var4;
    }

    NTFDCNRegistration(String var1, long var2, String var4, short var5) {
        super(0, 2, false, var1, (String)null, 0, (Properties)null, var4, var5);
        this.regid = var2;
    }

    public int getRegistrationId() {
        return (int)this.regid;
    }

    public long getRegId() {
        return this.regid;
    }

    public void addListener(DatabaseChangeListener var1, Executor var2) throws SQLException {
        NTFEventListener var3 = new NTFEventListener(var1);
        var3.setExecutor(var2);
        this.addListener(var3);
    }

    public void addListener(DatabaseChangeListener var1) throws SQLException {
        NTFEventListener var2 = new NTFEventListener(var1);
        this.addListener(var2);
    }

    public void removeListener(DatabaseChangeListener var1) throws SQLException {
        super.removeListener(var1);
    }

    synchronized void addTablesName(String[] var1, int var2) {
        if (this.nbOfStringsInTable + var2 > this.tables.length) {
            String[] var3 = new String[(this.nbOfStringsInTable + var2) * 2];
            System.arraycopy(this.tables, 0, var3, 0, this.tables.length);
            this.tables = var3;
        }

        System.arraycopy(var1, 0, this.tables, this.nbOfStringsInTable, var2);
        this.nbOfStringsInTable += var2;
    }

    public String[] getTables() {
        String[] var1 = new String[this.nbOfStringsInTable];
        System.arraycopy(this.tables, 0, var1, 0, this.nbOfStringsInTable);
        return var1;
    }
}
