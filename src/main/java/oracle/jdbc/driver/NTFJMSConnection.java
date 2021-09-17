//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;

class NTFJMSConnection extends Thread {
    int tcpport;
    String clientId;
    String instanceName;
    String serviceName;
    String url;
    String userName;
    String password;
    String connClass;
    ArrayList<String> listenerAddresses;
    Connection conn = null;
    T4CTTIoaqnfy oaqnfy = null;
    NTFJMSPerDatabaseManager jmsPerDatabaseManager;
    private boolean needToBeClosed = false;
    private boolean safeToClose = true;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFJMSConnection(NTFJMSPerDatabaseManager var1, String var2, ArrayList<String> var3, String var4, String var5, String var6, String var7, String var8) {
        this.userName = var6;
        this.password = var7;
        this.serviceName = var5;
        this.jmsPerDatabaseManager = var1;
        this.clientId = var2;
        this.listenerAddresses = var3;
        this.instanceName = var4;

        assert this.listenerAddresses != null : "listenerAddresses is null";

        assert this.instanceName != null : "instancename is null";

        String var9 = (String)this.listenerAddresses.get(0);
        this.url = "jdbc:oracle:thin:@(DESCRIPTION=" + var9 + "(CONNECT_DATA=(SERVICE_NAME=" + this.serviceName + ")(SERVER=EMON)(INSTANCE_NAME=" + this.instanceName + ")))";
        this.connClass = var8;
    }

    public void run() {
        if (!this.needToBeClosed) {
            this.safeToClose = false;

            try {
                this.conn = this.getConnection(this.url, this.connClass);
                this.oaqnfy = new T4CTTIoaqnfy((T4CConnection)this.conn, this.clientId, this.jmsPerDatabaseManager);
                this.safeToClose = true;
                this.oaqnfy.doRPC();
            } catch (Exception var2) {
                this.safeToClose = true;
            }
        }

    }

    synchronized Connection getConnection(String var1, String var2) throws Exception {
        OracleDataSource var3 = new OracleDataSource();
        var3.setURL(var1);
        var3.setUser(this.userName);
        var3.setPassword(this.password);
        if (var2 != null) {
            Properties var4 = new Properties();
            var4.put("oracle.jdbc.DRCPConnectionClass", var2);
            var4.put("oracle.jdbc.jmsNotification", "true");
            var4.put("oracle.jdbc.ReadTimeout", 0);
            var4.put("oracle.net.CONNECT_TIMEOUT", 0);
            var3.setConnectionProperties(var4);
        }

        return var3.getConnection();
    }

    void closeThisListener() {
        while(!this.safeToClose) {
        }

        this.needToBeClosed = true;

        try {
            if (this.oaqnfy != null) {
                this.oaqnfy.stopListening();
            }

            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException var2) {
        }

    }
}
