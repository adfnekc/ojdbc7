//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.TNSAddress;

import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.jdbc.nl.NVPair;

public class Address implements SchemaObject {
    public String addr;
    public String prot;
    protected SchemaObjectFactoryInterface f = null;

    public Address(SchemaObjectFactoryInterface var1) {
        this.f = var1;
    }

    public int isA() {
        return 0;
    }

    public String isA_String() {
        return "ADDRESS";
    }

    public void initFromString(String var1) throws NLException, SOException {
        NVPair var2 = (new NVFactory()).createNVPair(var1);
        this.initFromNVPair(var2);
    }

    public void initFromNVPair(NVPair var1) throws SOException {
        this.init();
        if (var1 != null && var1.getName().equalsIgnoreCase("address")) {
            NVNavigator var2 = new NVNavigator();
            NVPair var3 = var2.findNVPair(var1, "PROTOCOL");
            if (var3 == null) {
                throw new SOException();
            } else {
                this.prot = var3.getAtom();
                if (this.addr == null) {
                    this.addr = var1.toString();
                }

            }
        } else {
            throw new SOException();
        }
    }

    public String toString() {
        return this.addr;
    }

    public String getProtocol() {
        return this.prot;
    }

    protected void init() {
        this.addr = null;
        this.prot = null;
    }
}
