//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.nl;

import java.util.Locale;

public class NLException extends Exception {
    public Object[] msg_params;
    private String error_index;
    private String error_msg;

    public NLException(String var1) {
        this.error_msg = var1;
    }

    public NLException(String var1, Object var2) {
        this.error_index = var1;
        Object[] var3 = new Object[]{var2};
        this.msg_params = var3;
        this.initErrorMessage();
    }

    public NLException(String var1, Object[] var2) {
        this.error_index = var1;
        this.msg_params = var2;
        this.initErrorMessage();
    }

    private void initErrorMessage() {
        NetStrings var1 = new NetStrings("oracle.net.jdbc.nl.mesg.NLSR", Locale.getDefault());
        this.error_msg = var1.getString(this.error_index, this.msg_params);
    }

    public String toString() {
        return this.getErrorMessage();
    }

    public String getErrorIndex() {
        return this.error_index;
    }

    public String getErrorMessage() {
        return this.error_msg;
    }

    public String getMessage() {
        return this.getErrorMessage();
    }
}
