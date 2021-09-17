//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.sql.SQLException;
import oracle.ons.Notification;
import oracle.ons.ONSException;
import oracle.ons.Subscriber;
import oracle.ons.SubscriptionException;

/** @deprecated */
class OracleFailoverEventHandlerThread extends Thread {
    private Notification event = null;
    private OracleConnectionCacheManager cacheManager = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleFailoverEventHandlerThread() throws SQLException {
        this.cacheManager = OracleConnectionCacheManager.getConnectionCacheManagerInstance();
    }

    public void run() {
        Subscriber var1 = null;

        while(this.cacheManager.failoverEnabledCacheExists()) {
            try {
                var1 = (Subscriber)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                    public Object run() {
                        try {
                            return new Subscriber("(%\"eventType=database/event/service\")|(%\"eventType=database/event/host\")", "", 30000L);
                        } catch (SubscriptionException var2) {
                            return null;
                        }
                    }
                });
            } catch (PrivilegedActionException var5) {
            }

            if (var1 != null) {
                try {
                    while(this.cacheManager.failoverEnabledCacheExists()) {
                        if ((this.event = var1.receive(true)) != null) {
                            this.handleEvent(this.event);
                        }
                    }
                } catch (ONSException var6) {
                    var1.close();
                }
            }

            try {
                Thread.currentThread();
                Thread.sleep(10000L);
            } catch (InterruptedException var4) {
            }
        }

    }

    void handleEvent(Notification var1) {
        try {
            short var2 = 0;
            OracleConnectionCacheManager var10000;
            if (var1.type().equalsIgnoreCase("database/event/service")) {
                var10000 = this.cacheManager;
                var2 = 256;
            } else if (var1.type().equalsIgnoreCase("database/event/host")) {
                var10000 = this.cacheManager;
                var2 = 512;
            }

            if (var2 != 0) {
                this.cacheManager.verifyAndHandleEvent(var2, var1.body());
            }
        } catch (SQLException var3) {
        }

    }
}
