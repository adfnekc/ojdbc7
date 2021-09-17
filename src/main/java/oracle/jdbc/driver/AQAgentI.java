//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.aq.AQAgent;

class AQAgentI implements AQAgent {
    private String attrAgentAddress = null;
    private String attrAgentName = null;
    private int attrAgentProtocol = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    AQAgentI() throws SQLException {
    }

    public void setAddress(String var1) throws SQLException {
        this.attrAgentAddress = var1;
    }

    public String getAddress() {
        return this.attrAgentAddress;
    }

    public void setName(String var1) throws SQLException {
        this.attrAgentName = var1;
    }

    public String getName() {
        return this.attrAgentName;
    }

    public void setProtocol(int var1) throws SQLException {
        this.attrAgentProtocol = var1;
    }

    public int getProtocol() {
        return this.attrAgentProtocol;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("Name=\"");
        var1.append(this.getName());
        var1.append("\" ");
        var1.append("Address=\"");
        var1.append(this.getAddress());
        var1.append("\" ");
        var1.append("Protocol=\"");
        var1.append(this.getProtocol());
        var1.append("\"");
        return var1.toString();
    }
}
