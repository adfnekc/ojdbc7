//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import oracle.jdbc.internal.OracleConnection;

class NTFManager {
    private Hashtable<Integer, NTFListener> nsListeners = new Hashtable();
    private Hashtable<Integer, NTFRegistration> ntfRegistrations = new Hashtable();
    private byte[] listOfJdbcRegId = new byte[20];
    private HashMap<String, NTFJMSPerDatabaseManager> jmsPerDatabaseManagers = new HashMap();
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFManager() {
    }

    synchronized boolean listenOnPortT4C(int[] var1, boolean var2) throws SQLException {
        int var3 = var1[0];
        boolean var4 = false;

        while(this.nsListeners.get(var3) == null) {
            try {
                ServerSocketChannel var5 = ServerSocketChannel.open();
                var5.configureBlocking(false);
                ServerSocket var6 = var5.socket();
                InetSocketAddress var13 = new InetSocketAddress(var3);

                SQLException var9;
                try {
                    var6.bind(var13);
                    var4 = true;
                    NTFListener var8 = new NTFListener(this, var5, var3);
                    this.nsListeners.put(var3, var8);
                    var8.start();
                    break;
                } catch (BindException var10) {
                    if (!var2) {
                        var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 250);
                        var9.fillInStackTrace();
                        throw var9;
                    }

                    ++var3;
                } catch (IOException var11) {
                    if (!var2) {
                        var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 250);
                        var9.fillInStackTrace();
                        throw var9;
                    }

                    ++var3;
                }
            } catch (IOException var12) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
                var7.fillInStackTrace();
                throw var7;
            }
        }

        var1[0] = var3;
        return var4;
    }

    synchronized int getNextJdbcRegId() {
        int var1;
        for(var1 = 1; var1 < this.listOfJdbcRegId.length && this.listOfJdbcRegId[var1] != 0; ++var1) {
        }

        if (var1 == this.listOfJdbcRegId.length - 1) {
            byte[] var2 = new byte[this.listOfJdbcRegId.length * 2];
            System.arraycopy(this.listOfJdbcRegId, 0, var2, 0, this.listOfJdbcRegId.length);
            this.listOfJdbcRegId = var2;
        }

        this.listOfJdbcRegId[var1] = 2;
        return var1;
    }

    synchronized void addRegistration(NTFRegistration var1) {
        Integer var2 = var1.getJdbcRegId();
        Hashtable var3 = (Hashtable)this.ntfRegistrations.clone();
        var3.put(var2, var1);
        this.ntfRegistrations = var3;
    }

    synchronized boolean removeRegistration(NTFRegistration var1) {
        Integer var2 = var1.getJdbcRegId();
        Hashtable var3 = (Hashtable)this.ntfRegistrations.clone();
        Object var4 = var3.remove(var2);
        this.ntfRegistrations = var3;
        boolean var5 = false;
        if (var4 != null) {
            var5 = true;
        }

        return var5;
    }

    synchronized void freeJdbcRegId(int var1) {
        if (this.listOfJdbcRegId != null && this.listOfJdbcRegId.length > var1) {
            this.listOfJdbcRegId[var1] = 0;
        }

    }

    synchronized void cleanListenersT4C(int var1) {
        Enumeration var2 = this.ntfRegistrations.keys();
        boolean var3 = false;

        while(!var3 && var2.hasMoreElements()) {
            Object var4 = var2.nextElement();
            NTFRegistration var5 = (NTFRegistration)this.ntfRegistrations.get(var4);
            if (var5.getClientTCPPort() == var1) {
                var3 = true;
            }
        }

        if (!var3) {
            NTFListener var6 = (NTFListener)this.nsListeners.get(var1);
            if (var6 != null) {
                var6.closeThisListener();
                var6.interrupt();
                this.nsListeners.remove(var1);
            }
        }

    }

    NTFRegistration getRegistration(int var1) {
        Integer var2 = var1;
        Hashtable var3 = this.ntfRegistrations;
        NTFRegistration var4 = (NTFRegistration)var3.get(var2);
        return var4;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    synchronized NTFJMSPerDatabaseManager getJMSPerDatabaseManager(String var1) {
        NTFJMSPerDatabaseManager var2 = (NTFJMSPerDatabaseManager)this.jmsPerDatabaseManagers.get(var1);
        if (var2 == null) {
            var2 = new NTFJMSPerDatabaseManager(var1);
        }

        this.jmsPerDatabaseManagers.put(var1, var2);
        return var2;
    }

    synchronized void removeJMSUtility(String var1) {
        this.jmsPerDatabaseManagers.remove(var1);
    }
}
