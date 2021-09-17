//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.TNSAddress;

import java.util.Vector;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVPair;

public class AddressList implements SchemaObject {
    public Vector children = new Vector();
    private SchemaObject child;
    private NVPair childnv;
    public boolean sourceRoute = false;
    public boolean loadBalance = false;
    public boolean failover = true;
    protected SchemaObjectFactoryInterface f = null;

    public AddressList(SchemaObjectFactoryInterface var1) {
        this.f = var1;
    }

    public int isA() {
        return 1;
    }

    public String isA_String() {
        return "ADDRESS_LIST";
    }

    public void initFromString(String var1) throws NLException, SOException {
        NVPair var2 = (new NVFactory()).createNVPair(var1);
        this.initFromNVPair(var2);
    }

    public void initFromNVPair(NVPair var1) throws SOException {
        this.init();
        int var2 = var1.getListSize();
        if (var2 == 0) {
            throw new SOException();
        } else {
            for(int var3 = 0; var3 < var2; ++var3) {
                this.childnv = var1.getListElement(var3);
                if (this.childnv.getName().equalsIgnoreCase("SOURCE_ROUTE")) {
                    this.sourceRoute = this.childnv.getAtom().equalsIgnoreCase("yes") || this.childnv.getAtom().equalsIgnoreCase("on") || this.childnv.getAtom().equalsIgnoreCase("true");
                } else if (this.childnv.getName().equalsIgnoreCase("LOAD_BALANCE")) {
                    this.loadBalance = this.childnv.getAtom().equalsIgnoreCase("yes") || this.childnv.getAtom().equalsIgnoreCase("on") || this.childnv.getAtom().equalsIgnoreCase("true");
                } else if (!this.childnv.getName().equalsIgnoreCase("FAILOVER")) {
                    SchemaObjectFactoryInterface var10002;
                    if (this.childnv.getName().equalsIgnoreCase("ADDRESS")) {
                        var10002 = this.f;
                        this.child = this.f.create(0);
                        this.child.initFromNVPair(this.childnv);
                        this.children.addElement(this.child);
                    } else {
                        if (!this.childnv.getName().equalsIgnoreCase("ADDRESS_LIST")) {
                            throw new SOException();
                        }

                        var10002 = this.f;
                        this.child = this.f.create(1);
                        this.child.initFromNVPair(this.childnv);
                        this.children.addElement(this.child);
                    }
                } else {
                    this.failover = this.childnv.getAtom().equalsIgnoreCase("yes") || this.childnv.getAtom().equalsIgnoreCase("on") || this.childnv.getAtom().equalsIgnoreCase("true");
                }
            }

            if (this.children.size() == 0) {
                throw new SOException();
            }
        }
    }

    public String toString() {
        String var1 = new String("");
        if (this.children.size() < 1) {
            return var1;
        } else {
            var1 = var1 + "(ADDRESS_LIST=";

            for(int var2 = 0; var2 < this.children.size(); ++var2) {
                var1 = var1 + ((SchemaObject)this.children.elementAt(var2)).toString();
            }

            if (this.sourceRoute) {
                var1 = var1 + "(SOURCE_ROUTE=yes)";
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
    }

    protected void init() {
        this.children.removeAllElements();
        this.child = null;
        this.childnv = null;
        this.sourceRoute = false;
        this.loadBalance = false;
        this.failover = true;
    }
}
