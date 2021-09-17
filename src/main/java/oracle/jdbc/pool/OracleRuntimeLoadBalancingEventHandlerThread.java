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
class OracleRuntimeLoadBalancingEventHandlerThread extends Thread {
    private Notification event = null;
    private OracleConnectionCacheManager cacheManager = null;
    String m_service;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleRuntimeLoadBalancingEventHandlerThread(String var1) throws SQLException {
        this.m_service = var1;
        this.cacheManager = OracleConnectionCacheManager.getConnectionCacheManagerInstance();
    }

    public void run() {
        Subscriber var1 = null;
        final String var2 = "%\"eventType=database/event/servicemetrics/" + this.m_service + "\"";

        while(this.cacheManager.failoverEnabledCacheExists()) {
            try {
                var1 = (Subscriber)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                    public Object run() {
                        try {
                            return new Subscriber(var2, "", 30000L);
                        } catch (SubscriptionException var2x) {
                            return null;
                        }
                    }
                });
            } catch (PrivilegedActionException var5) {
            }

            if (var1 != null) {
                try {
                    while(this.cacheManager.failoverEnabledCacheExists()) {
                        if ((this.event = var1.receive(300000L)) != null) {
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
            this.cacheManager.parseRuntimeLoadBalancingEvent(this.m_service, var1 == null ? null : var1.body());
        } catch (SQLException var3) {
        }

    }
}
