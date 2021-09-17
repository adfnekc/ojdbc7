//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.util.ArrayList;
import java.util.HashMap;

public class NTFJMSPerDatabaseManager {
    NTFJMSConnection[] jmsListenerConnections = null;
    private HashMap<Long, Integer> jmsRegIdToJDBCRegId = new HashMap();
    private String jmsClientId;
    private int noOfRegistrationsInDB = 0;
    String databaseUniqueIdentifier;
    private static final int MAX_NTF_CONNECTIONS = 2;
    String[] databaseInstances = null;
    boolean isInitialized = false;
    ArrayList<String> listenerAddresses = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFJMSPerDatabaseManager(String var1) {
        this.databaseUniqueIdentifier = var1;
    }

    void init(String var1, String[] var2, ArrayList<String> var3) {
        this.jmsClientId = var1;
        this.databaseInstances = var2;
        this.listenerAddresses = var3;
        this.isInitialized = true;
    }

    synchronized void closeJMSListenerConnection() {
        if (this.noOfRegistrationsInDB == 0 && this.jmsListenerConnections != null) {
            for(int var1 = 0; var1 < this.jmsListenerConnections.length; ++var1) {
                if (this.jmsListenerConnections[var1] != null) {
                    this.jmsListenerConnections[var1].closeThisListener();
                    this.jmsListenerConnections[var1].interrupt();
                    PhysicalConnection.ntfManager.removeJMSUtility(this.databaseUniqueIdentifier);
                }
            }

            this.jmsListenerConnections = null;
        }

    }

    synchronized void startJMSListenerConnection(String var1, String var2, String var3) {
        assert this.jmsClientId != null : "jmsClientId is null";

        if (this.jmsListenerConnections == null || this.jmsListenerConnections.length == 0) {
            int var4;
            if (this.databaseInstances.length > 2) {
                var4 = 2;
            } else {
                var4 = this.databaseInstances.length;
            }

            this.jmsListenerConnections = new NTFJMSConnection[var4];

            for(int var5 = 0; var5 < var4; ++var5) {
                String var6 = "notify" + var5;
                this.jmsListenerConnections[var5] = new NTFJMSConnection(this, this.jmsClientId, this.listenerAddresses, this.databaseInstances[var5], var1, var2, var3, var6);
                this.jmsListenerConnections[var5].setDaemon(true);
                this.jmsListenerConnections[var5].start();
            }
        }

    }

    String getJMSClientId() {
        return this.jmsClientId;
    }

    public void setJmsClientId(String var1) {
        this.jmsClientId = var1;
    }

    void removeRegistrationId(Long var1) {
        this.jmsRegIdToJDBCRegId.remove(var1);
    }

    int getJDBCRegId(Long var1) {
        return (Integer)this.jmsRegIdToJDBCRegId.get(var1);
    }

    void mapJMSRegIdToJDBCRegId(Long var1, int var2) {
        this.jmsRegIdToJDBCRegId.put(var1, var2);
    }

    void incrementNumberOfRegistrations() {
        ++this.noOfRegistrationsInDB;
    }

    void decrementNumberOfRegistrations() {
        --this.noOfRegistrationsInDB;
    }
}
