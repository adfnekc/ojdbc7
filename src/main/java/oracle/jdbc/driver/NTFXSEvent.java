//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSEvent;
import oracle.jdbc.internal.XSKeyval;
import oracle.jdbc.internal.XSNamespace;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSSessionNamespace;

class NTFXSEvent extends XSEvent {
    private final XSNamespaceI[] kpxssyncns;
    private final XSNamespaceI[] kpxssyncinvalidns;
    private final XSPrincipalI[] kpxssyncroles;
    private final XSSessionNamespaceI[] kpxssyncsessns;
    private final int kpxssyncrolever;
    private final int kpxssyncsessflg;
    private final int kpxssynccacheflg;
    private final XSKeyvalI kvl;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public XSNamespace[] getNamespaces() {
        return (XSNamespace[])this.kpxssyncns;
    }

    public XSNamespace[] getInvalidNamespaces() {
        return (XSNamespace[])this.kpxssyncinvalidns;
    }

    public XSPrincipal[] getSessionRoles() {
        return (XSPrincipal[])this.kpxssyncroles;
    }

    public XSSessionNamespace[] getSessionNamespaces() {
        return (XSSessionNamespace[])this.kpxssyncsessns;
    }

    public int getRoleVersion() {
        return this.kpxssyncrolever;
    }

    public long getSessionFlags() {
        return (long)this.kpxssyncsessflg;
    }

    public long getCacheFlags() {
        return (long)this.kpxssynccacheflg;
    }

    public XSKeyval getKeyval() {
        return this.kvl;
    }

    NTFXSEvent(T4CConnection var1) throws SQLException, IOException {
        super(var1);
        T4CMAREngine var2 = var1.getMarshalEngine();
        int var3 = (int)var2.unmarshalUB4();
        if (var3 > 0) {
            var2.unmarshalUB1();
        }

        this.kpxssyncns = new XSNamespaceI[var3];

        int var4;
        for(var4 = 0; var4 < var3; ++var4) {
            this.kpxssyncns[var4] = XSNamespaceI.unmarshal(var2);
        }

        var4 = (int)var2.unmarshalUB4();
        if (var4 > 0) {
            var2.unmarshalUB1();
        }

        this.kpxssyncinvalidns = new XSNamespaceI[var4];

        int var5;
        for(var5 = 0; var5 < var4; ++var5) {
            this.kpxssyncinvalidns[var5] = XSNamespaceI.unmarshal(var2);
        }

        var5 = (int)var2.unmarshalUB4();
        if (var5 > 0) {
            var2.unmarshalUB1();
        }

        this.kpxssyncroles = new XSPrincipalI[var5];

        int var6;
        for(var6 = 0; var6 < var5; ++var6) {
            this.kpxssyncroles[var6] = XSPrincipalI.unmarshal(var2);
        }

        var6 = (int)var2.unmarshalUB4();
        if (var6 > 0) {
            var2.unmarshalUB1();
        }

        this.kpxssyncsessns = new XSSessionNamespaceI[var6];

        for(int var7 = 0; var7 < var6; ++var7) {
            var2.unmarshalUB1();
            var2.unmarshalUB1();
            var2.unmarshalUB1();
            this.kpxssyncsessns[var7] = XSSessionNamespaceI.unmarshal(var2);
        }

        this.kpxssyncrolever = (int)var2.unmarshalUB4();
        this.kpxssyncsessflg = (int)var2.unmarshalUB4();
        this.kpxssynccacheflg = (int)var2.unmarshalUB4();
        short var8 = var2.unmarshalUB1();
        if (var8 != 0) {
            var2.unmarshalUB1();
            var2.unmarshalUB1();
            this.kvl = XSKeyvalI.unmarshal(var2);
        } else {
            this.kvl = null;
        }

    }
}
