//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.nl;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class NetStrings {
    ResourceBundle strBundle;
    Locale loc;

    public NetStrings(String var1, Locale var2) {
        this.strBundle = ResourceBundle.getBundle(var1, var2);
    }

    public NetStrings(Locale var1) {
        this.strBundle = ResourceBundle.getBundle("oracle.net.jdbc.nl.mesg.NLSR", var1);
    }

    public NetStrings() {
        this.strBundle = ResourceBundle.getBundle("oracle.network.nl.mesg.NLSR", Locale.getDefault());
    }

    public String getString(String var1) {
        return this.strBundle.getString(var1);
    }

    public String getString(String var1, Object[] var2) {
        String var3 = this.strBundle.getString(var1);
        StringBuffer var4 = new StringBuffer();
        MessageFormat var5 = new MessageFormat(var3);
        var5.format(var2, var4, (FieldPosition)null);
        return var4.toString();
    }
}
