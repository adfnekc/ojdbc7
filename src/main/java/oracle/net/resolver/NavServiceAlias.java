//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import oracle.net.jdbc.TNSAddress.SchemaObjectFactoryInterface;
import oracle.net.jdbc.TNSAddress.ServiceAlias;
import oracle.net.nt.ConnStrategy;

public class NavServiceAlias extends ServiceAlias implements NavSchemaObject {
    public NavServiceAlias(SchemaObjectFactoryInterface var1) {
        super(var1);
    }

    public void navigate(ConnStrategy var1, StringBuffer var2) {
        StringBuffer var3 = new StringBuffer("");
        ((NavSchemaObject)this.child).navigate(var1, var3);
    }

    public void addToString(ConnStrategy var1) {
    }
}
