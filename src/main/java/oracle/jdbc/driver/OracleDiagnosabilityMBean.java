//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanInfo;
import javax.management.StandardMBean;

public class OracleDiagnosabilityMBean extends StandardMBean implements DiagnosabilityMXBean {
    OracleDiagnosabilityMBean() {
        super(DiagnosabilityMXBean.class, true);
    }

    public boolean getLoggingEnabled() {
        return OracleLog.isEnabled();
    }

    public void setLoggingEnabled(boolean var1) {
        OracleLog.setTrace(var1);
    }

    public boolean stateManageable() {
        return false;
    }

    public boolean statisticsProvider() {
        return false;
    }

    protected String getDescription(MBeanInfo var1) {
        return DatabaseError.findMessage("DiagnosabilityMBeanDescription", this);
    }

    protected String getDescription(MBeanConstructorInfo var1) {
        return DatabaseError.findMessage("DiagnosabilityMBeanConstructor()", this);
    }

    protected String getDescription(MBeanAttributeInfo var1) {
        String var2 = var1.getName();
        if (var2.equals("LoggingEnabled")) {
            return DatabaseError.findMessage("DiagnosabilityMBeanLoggingEnabledDescription", this);
        } else if (var2.equals("stateManageable")) {
            return DatabaseError.findMessage("DiagnosabilityMBeanStateManageableDescription", this);
        } else if (var2.equals("statisticsProvider")) {
            return DatabaseError.findMessage("DiagnosabilityMBeanStatisticsProviderDescription", this);
        } else {
            Logger.getLogger("oracle.jdbc.driver").log(Level.SEVERE, "Got a request to describe an unexpected  Attribute: " + var2);
            return super.getDescription(var1);
        }
    }
}
