//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.EventListener;
import java.util.concurrent.Executor;
import oracle.jdbc.LogicalTransactionIdEventListener;
import oracle.jdbc.aq.AQNotificationListener;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.internal.JMSNotificationListener;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.PDBChangeEventListener;
import oracle.jdbc.internal.XSEventListener;

class NTFEventListener {
    private final AQNotificationListener aqlistener;
    private final DatabaseChangeListener dcnlistener;
    private final XSEventListener xslistener;
    private final LogicalTransactionIdEventListener ltxidlistener;
    private final JMSNotificationListener jmslistener;
    private final PDBChangeEventListener pdbChangeListener;
    private Executor executor = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFEventListener(PDBChangeEventListener var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 246);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.jmslistener = null;
            this.dcnlistener = null;
            this.aqlistener = null;
            this.xslistener = null;
            this.ltxidlistener = null;
            this.pdbChangeListener = var1;
        }
    }

    NTFEventListener(DatabaseChangeListener var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 246);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.jmslistener = null;
            this.dcnlistener = var1;
            this.aqlistener = null;
            this.xslistener = null;
            this.ltxidlistener = null;
            this.pdbChangeListener = null;
        }
    }

    NTFEventListener(JMSNotificationListener var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 246);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.jmslistener = var1;
            this.aqlistener = null;
            this.dcnlistener = null;
            this.xslistener = null;
            this.ltxidlistener = null;
            this.pdbChangeListener = null;
        }
    }

    NTFEventListener(AQNotificationListener var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 246);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.jmslistener = null;
            this.aqlistener = var1;
            this.dcnlistener = null;
            this.xslistener = null;
            this.ltxidlistener = null;
            this.pdbChangeListener = null;
        }
    }

    NTFEventListener(XSEventListener var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 246);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.jmslistener = null;
            this.aqlistener = null;
            this.dcnlistener = null;
            this.xslistener = var1;
            this.ltxidlistener = null;
            this.pdbChangeListener = null;
        }
    }

    NTFEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 246);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.jmslistener = null;
            this.aqlistener = null;
            this.dcnlistener = null;
            this.xslistener = null;
            this.ltxidlistener = var1;
            this.pdbChangeListener = null;
        }
    }

    void setExecutor(Executor var1) {
        this.executor = var1;
    }

    Executor getExecutor() {
        return this.executor;
    }

    EventListener getListener() {
        Object var1 = this.dcnlistener;
        if (var1 == null) {
            var1 = this.aqlistener;
        }

        if (var1 == null) {
            var1 = this.jmslistener;
        }

        if (var1 == null) {
            var1 = this.pdbChangeListener;
        }

        return (EventListener)var1;
    }

    PDBChangeEventListener getPDBChangeEventListener() {
        return this.pdbChangeListener;
    }

    JMSNotificationListener getJMSListener() {
        return this.jmslistener;
    }

    AQNotificationListener getAQListener() {
        return this.aqlistener;
    }

    DatabaseChangeListener getDCNListener() {
        return this.dcnlistener;
    }

    XSEventListener getXSEventListener() {
        return this.xslistener;
    }

    LogicalTransactionIdEventListener getLogicalTransactionIdEventListener() {
        return this.ltxidlistener;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
