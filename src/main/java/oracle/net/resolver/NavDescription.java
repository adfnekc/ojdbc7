//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.util.Vector;
import oracle.net.jdbc.TNSAddress.Description;
import oracle.net.jdbc.TNSAddress.SchemaObjectFactoryInterface;
import oracle.net.nt.ConnOption;
import oracle.net.nt.ConnStrategy;

public class NavDescription extends Description implements NavSchemaObject {
    private Vector activeChildren = new Vector(1, 10);
    private int descProcessed;
    private boolean done = false;

    public NavDescription(SchemaObjectFactoryInterface var1) {
        super(var1);
    }

    public void navigate(ConnStrategy var1, StringBuffer var2) {
        var2.setLength(0);
        var2.append("(DESCRIPTION=");

        try {
            if (this.SDU != null) {
                var1.sdu = Integer.parseInt(this.SDU);
            }

            if (this.TDU != null) {
                var1.tdu = Integer.parseInt(this.TDU);
            }

            if (this.connectTimeout != null) {
                var1.connectTimeout = Integer.parseInt(this.connectTimeout) * 1000;
            }

            if (this.retryCount != null) {
                var1.retryCount = Integer.parseInt(this.retryCount);
            }
        } catch (Exception var4) {
        }

        var1.addSocketOptions(this.keepAlive);
        int var3;
        if (this.sourceRoute) {
            if (!this.backwardCompatibilityCase(this.children, var1)) {
                this.activeChildren = this.children;
                ((NavSchemaObject)this.activeChildren.elementAt(0)).navigate(var1, var2);

                for(var3 = 1; var3 < this.activeChildren.size(); ++var3) {
                    ((NavSchemaObject)this.activeChildren.elementAt(var3)).addToString(var1);
                }
            } else {
                this.setConnectionOption(var1, var2);
            }

            this.closeNVPair(var1);
        } else {
            this.activeChildren = NavDescriptionList.setActiveChildren(this.children, this.failover, this.loadBalance);

            for(var3 = 0; var3 < this.activeChildren.size(); ++var3) {
                ((NavSchemaObject)this.activeChildren.elementAt(var3)).navigate(var1, var2);
            }

            this.closeNVPair(var1);
        }

        this.done = true;
    }

    public void closeNVPair(ConnStrategy var1) {
        for(int var2 = var1.cOpts.size() - 1; var2 >= 0 && !((ConnOption)var1.cOpts.elementAt(var2)).done; --var2) {
            ConnOption var3 = (ConnOption)var1.cOpts.elementAt(var2);
            if (this.sourceRoute) {
                var3.conn_data.append("(SOURCE_ROUTE=yes)");
            }

            if (this.connectData == null) {
                this.connectData = "(SERVICE_NAME=)";
            }

            var3.conn_data.append("(CONNECT_DATA=");
            var3.conn_data.append("(CID=(PROGRAM=");
            var3.conn_data.append(var1.getProgramName());
            var3.conn_data.append(")(HOST=__jdbc__)(USER=");
            var3.conn_data.append(var1.getOSUsername());
            var3.conn_data.append("))");
            var3.conn_data.append(this.connectData);
            var3.conn_data.append(")");
            if (this.SID != null) {
                var3.sid = this.SID;
            }

            if (this.serviceName != null) {
                var3.service_name = this.serviceName;
            }

            if (this.instanceName != null) {
                var3.instance_name = this.instanceName;
            }

            if (this.sslServerCertDN != null) {
                var3.sslServerCertDN = this.sslServerCertDN;
            }

            var3.conn_data.append(")");
            var3.done = true;
        }

    }

    public void addToString(ConnStrategy var1) {
    }

    private boolean backwardCompatibilityCase(Vector var1, ConnStrategy var2) {
        if (var1.size() == 1 && ((NavSchemaObject)var1.elementAt(0)).isA() == 1 && !((NavAddressList)var1.elementAt(0)).sourceRoute) {
            NavAddressList var3 = (NavAddressList)var1.elementAt(0);
            int var4 = var3.getChildrenSize();
            if (var4 == 0) {
                return false;
            } else {
                for(int var5 = 0; var5 < var4; ++var5) {
                    if (var3.getChildrenType(var5) != 0) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    private void setConnectionOption(ConnStrategy var1, StringBuffer var2) {
        var2.append("(ADDRESS_LIST=");
        NavAddressList var3 = (NavAddressList)this.children.elementAt(0);
        NavAddress var4 = var3.getChild(0);
        int var5 = var3.getChildrenSize();
        var4.navigate(var1, var2);

        for(int var6 = 1; var6 < var5; ++var6) {
            var3.getChild(var6).addToString(var1);
        }

        ((ConnOption)var1.cOpts.elementAt(0)).conn_data.append(")");
    }
}
