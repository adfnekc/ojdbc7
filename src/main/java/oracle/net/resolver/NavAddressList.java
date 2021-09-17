//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.util.Vector;
import oracle.net.jdbc.TNSAddress.AddressList;
import oracle.net.jdbc.TNSAddress.SchemaObjectFactoryInterface;
import oracle.net.nt.ConnOption;
import oracle.net.nt.ConnStrategy;

public class NavAddressList extends AddressList implements NavSchemaObject {
    private Vector activeChildren = new Vector(1, 10);
    private int sBuflength;

    public NavAddressList(SchemaObjectFactoryInterface var1) {
        super(var1);
    }

    public void navigate(ConnStrategy var1, StringBuffer var2) {
        this.navigate2(var1, var2, 0);
    }

    private void navigate2(ConnStrategy var1, StringBuffer var2, int var3) {
        boolean var4 = false;
        ++var3;
        this.sBuflength = var2.length();
        var2.append("(ADDRESS_LIST=");
        int var5;
        if (this.sourceRoute) {
            this.activeChildren = this.children;
            ((NavSchemaObject)this.activeChildren.elementAt(0)).navigate(var1, var2);

            for(var5 = 1; var5 < this.activeChildren.size(); ++var5) {
                ((NavSchemaObject)this.activeChildren.elementAt(var5)).addToString(var1);
            }
        } else {
            this.activeChildren = NavDescriptionList.setActiveChildren(this.children, this.failover, this.loadBalance);

            for(var5 = 0; var5 < this.activeChildren.size(); ++var5) {
                if (this.getChildrenType(var5) == 1) {
                    var4 = true;
                    ((NavAddressList)this.activeChildren.elementAt(var5)).navigate2(var1, var2, var3);
                } else {
                    ((NavSchemaObject)this.activeChildren.elementAt(var5)).navigate(var1, var2);
                }
            }
        }

        --var3;
        if ((var3 != 0 || !var4) && !this.sourceRoute) {
            this.closeNVPair(var1, false);
        } else {
            this.closeNVPair(var1, true);
        }

        var2.setLength(this.sBuflength);
    }

    public void addToString(ConnStrategy var1) {
        String var2 = this.toString();

        for(int var3 = var1.cOpts.size() - 1; var3 >= 0 && !((ConnOption)var1.cOpts.elementAt(var3)).done; --var3) {
            ((ConnOption)var1.cOpts.elementAt(var3)).conn_data.append(var2);
        }

    }

    public String toString() {
        String var1 = "";
        var1 = var1 + "(ADDRESS_LIST=";

        for(int var2 = 0; var2 < this.children.size(); ++var2) {
            var1 = var1 + ((NavSchemaObject)this.children.elementAt(var2)).toString();
        }

        if (this.sourceRoute) {
            var1 = var1 + "(SOURCE_ROUTE=yes)(HOP_COUNT=0)";
        }

        if (this.loadBalance) {
            var1 = var1 + "(LOAD_BALANCE=yes)";
        }

        if (!this.failover) {
            var1 = var1 + "(FAILOVER=false)";
        }

        var1 = var1 + ")";
        return var1;
    }

    public int getChildrenSize() {
        return this.children.size();
    }

    public int getChildrenType(int var1) {
        return ((NavSchemaObject)this.children.elementAt(var1)).isA();
    }

    public NavAddress getChild(int var1) {
        return (NavAddress)this.children.elementAt(var1);
    }

    private void closeNVPair(ConnStrategy var1, boolean var2) {
        for(int var3 = var1.cOpts.size() - 1; var3 >= 0 && !((ConnOption)var1.cOpts.elementAt(var3)).done && (var2 || var1.cOpts.size() - 1 - var3 < this.getChildrenSize()); --var3) {
            if (this.sourceRoute) {
                ((ConnOption)var1.cOpts.elementAt(var3)).conn_data.append("(SOURCE_ROUTE=yes)");
                ((ConnOption)var1.cOpts.elementAt(var3)).conn_data.append("(HOP_COUNT=0)");
            }

            ((ConnOption)var1.cOpts.elementAt(var3)).conn_data.append(")");
        }

    }
}
