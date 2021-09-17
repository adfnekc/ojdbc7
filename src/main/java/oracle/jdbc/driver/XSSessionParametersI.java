//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.XSSessionParameters;

class XSSessionParametersI extends XSSessionParameters {
    byte[] binaryParam = null;
    String[] textParam = null;
    byte[][] textParamBytes;
    int intParam = 0;

    XSSessionParametersI() {
    }

    void doCharConversion(DBConversion var1) throws SQLException {
        if (this.textParam != null && this.textParam.length > 0) {
            this.textParamBytes = new byte[this.textParam.length][];

            for(int var2 = 0; var2 < this.textParam.length; ++var2) {
                this.textParamBytes[var2] = var1.StringToCharBytes(this.textParam[var2]);
            }
        } else {
            this.textParamBytes = (byte[][])null;
        }

    }

    public void setBinary(byte[] var1) throws SQLException {
        this.binaryParam = var1;
    }

    public void setInt(int var1) throws SQLException {
        this.intParam = var1;
    }

    public void setText(String[] var1) throws SQLException {
        this.textParam = var1;
    }
}
