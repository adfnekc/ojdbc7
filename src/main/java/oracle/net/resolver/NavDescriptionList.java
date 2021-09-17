//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.util.BitSet;
import java.util.Random;
import java.util.Vector;
import oracle.net.jdbc.TNSAddress.DescriptionList;
import oracle.net.jdbc.TNSAddress.SchemaObjectFactoryInterface;
import oracle.net.nt.ConnStrategy;

public class NavDescriptionList extends DescriptionList implements NavSchemaObject {
    private Vector activeChildren = new Vector(1, 10);
    private int descProcessed;
    private boolean done;

    public NavDescriptionList(SchemaObjectFactoryInterface var1) {
        super(var1);
    }

    public void navigate(ConnStrategy var1, StringBuffer var2) {
        var2.append("(DESCRIPTION_LIST=");

        for(this.activeChildren = setActiveChildren(this.children, this.failover, this.loadBalance); this.descProcessed < this.activeChildren.size(); ++this.descProcessed) {
            ((NavSchemaObject)this.activeChildren.elementAt(this.descProcessed)).navigate(var1, var2);
        }

    }

    public void addToString(ConnStrategy var1) {
    }

    public static Vector setActiveChildren(Vector var0, boolean var1, boolean var2) {
        int var4 = var0.size();
        Vector var5 = new Vector(1, 10);
        Random var6 = new Random();
        BitSet var7 = new BitSet(var4);
        int var3;
        if (var1) {
            if (var2) {
                for(int var8 = 0; var8 < var4; ++var8) {
                    do {
                        var3 = Math.abs(var6.nextInt()) % var4;
                    } while(var7.get(var3));

                    var7.set(var3);
                    var5.addElement(var0.elementAt(var3));
                }
            } else {
                var5 = var0;
            }
        } else if (var2) {
            var3 = Math.abs(var6.nextInt()) % var4;
            var5.addElement(var0.elementAt(var3));
        } else {
            var5.addElement(var0.elementAt(0));
        }

        return var5;
    }
}
