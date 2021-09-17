//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import oracle.net.jdbc.TNSAddress.Address;
import oracle.net.jdbc.TNSAddress.SchemaObjectFactoryInterface;
import oracle.net.nt.ConnOption;
import oracle.net.nt.ConnStrategy;

public class NavAddress extends Address implements NavSchemaObject {
    public NavAddress(SchemaObjectFactoryInterface var1) {
        super(var1);
    }

    public void navigate(ConnStrategy var1, StringBuffer var2) {
        ConnOption var3 = new ConnOption();
        var3.addr = this.addr;
        var3.conn_data.append(var2.toString());
        var3.conn_data.append(this.toString());
        var1.addOption(var3);
    }

    public void addToString(ConnStrategy var1) {
        String var2 = this.toString();

        for(int var3 = var1.cOpts.size() - 1; var3 >= 0 && !((ConnOption)var1.cOpts.elementAt(var3)).done; --var3) {
            ((ConnOption)var1.cOpts.elementAt(var3)).conn_data.append(var2);
        }

    }
}
