//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.core.lmx;

public class CoreException extends Exception {
    public static final byte UNIMPLEMENTED = 1;
    public static final byte UNDERFLOW = 2;
    public static final byte OVERFLOW = 3;
    public static final byte INVALIDORLN = 4;
    public static final byte BADFORMATORLN = 5;
    public static final byte INVALIDORLD = 6;
    public static final byte BADFORMATORLD = 7;
    public static final byte BADYEAR = 8;
    public static final byte BADDAYYEAR = 9;
    public static final byte BADJULIANDATE = 10;
    public static final byte INVALIDINPUTN = 11;
    public static final byte NLSNOTSUPPORTED = 12;
    public static final byte INVALIDINPUT = 13;
    public static final byte CONVERSIONERROR = 14;
    private static final String[] _errmsgs = new String[]{"Unknown Exception", "Unimplemented method called", "Underflow Exception", "Overflow Exception", "Invalid Oracle Number", "Bad Oracle Number format", "Invalid Oracle Date", "Bad Oracle Date format", "Year Not in Range", "Day of Year Not in Range", "Julian Date Not in Range", "Invalid Input Number", "NLS Not Supported", "Invalid Input", "Conversion Error"};
    private byte ecode;

    public CoreException() {
    }

    public CoreException(String var1) {
        super(var1);
    }

    public CoreException(byte var1) {
        this.ecode = var1;
    }

    public void setErrorCode(byte var1) {
        this.ecode = var1;
    }

    public byte getErrorCode() {
        return this.ecode;
    }

    public String getMessage() {
        return this.ecode == 0 ? super.getMessage() : getMessage(this.ecode);
    }

    public static String getMessage(byte var0) {
        return var0 >= 1 && var0 <= 14 ? _errmsgs[var0] : "Unknown exception";
    }
}
