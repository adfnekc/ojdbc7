//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.TNSAddress;

import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVPair;

public class ServiceAlias implements SchemaObject {
    protected SchemaObject child;
    public String name;
    private SchemaObjectFactoryInterface f = null;

    public ServiceAlias(SchemaObjectFactoryInterface var1) {
        this.f = var1;
    }

    public int isA() {
        return 4;
    }

    public String isA_String() {
        return null;
    }

    public void initFromString(String var1) throws NLException, SOException {
        if (var1.charAt(0) != '(') {
            var1 = "(" + var1 + ")";
        }

        NVPair var2 = (new NVFactory()).createNVPair(var1);
        this.initFromNVPair(var2);
    }

    public void initFromNVPair(NVPair var1) throws SOException {
        if (var1.getListSize() != 1) {
            throw new SOException();
        } else {
            NVPair var2 = var1.getListElement(0);
            SchemaObjectFactoryInterface var10002;
            if (var2.getName().equalsIgnoreCase("DESCRIPTION_LIST")) {
                var10002 = this.f;
                this.child = this.f.create(3);
            } else if (var2.getName().equalsIgnoreCase("DESCRIPTION")) {
                var10002 = this.f;
                this.child = this.f.create(2);
            } else if (var2.getName().equalsIgnoreCase("ADDRESS_LIST")) {
                var10002 = this.f;
                this.child = this.f.create(1);
            } else {
                if (!var2.getName().equalsIgnoreCase("ADDRESS")) {
                    throw new SOException();
                }

                var10002 = this.f;
                this.child = this.f.create(0);
            }

            this.child.initFromNVPair(var2);
            this.name = var1.getName();
        }
    }

    public String toString() {
        return this.name + "=" + this.child.toString();
    }
}
