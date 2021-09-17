//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.nl;

public class RepConversion {
    public RepConversion() {
    }

    public static void printInHex(byte var0) {
        System.out.print((char)nibbleToHex((byte)((var0 & 240) >> 4)));
        System.out.print((char)nibbleToHex((byte)(var0 & 15)));
    }

    public static byte nibbleToHex(byte var0) {
        var0 = (byte)(var0 & 15);
        return (byte)(var0 < 10 ? var0 + 48 : var0 - 10 + 65);
    }

    public static byte asciiHexToNibble(byte var0) {
        byte var1;
        if (var0 >= 97 && var0 <= 102) {
            var1 = (byte)(var0 - 97 + 10);
        } else if (var0 >= 65 && var0 <= 70) {
            var1 = (byte)(var0 - 65 + 10);
        } else if (var0 >= 48 && var0 <= 57) {
            var1 = (byte)(var0 - 48);
        } else {
            var1 = var0;
        }

        return var1;
    }

    public static void bArray2nibbles(byte[] var0, byte[] var1) {
        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2 * 2] = nibbleToHex((byte)((var0[var2] & 240) >> 4));
            var1[var2 * 2 + 1] = nibbleToHex((byte)(var0[var2] & 15));
        }

    }

    public static String bArray2String(byte[] var0) {
        StringBuffer var1 = new StringBuffer(var0.length * 2);

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1.append((char)nibbleToHex((byte)((var0[var2] & 240) >> 4)));
            var1.append((char)nibbleToHex((byte)(var0[var2] & 15)));
        }

        return var1.toString();
    }

    public static byte[] nibbles2bArray(byte[] var0) {
        byte[] var1 = new byte[var0.length / 2];

        for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = (byte)(asciiHexToNibble(var0[var2 * 2]) << 4);
            var1[var2] |= asciiHexToNibble(var0[var2 * 2 + 1]);
        }

        return var1;
    }

    public static void printInHex(long var0) {
        byte[] var2 = toHex(var0);
        System.out.print(new String(var2));
    }

    public static void printInHex(int var0) {
        byte[] var1 = toHex(var0);
        System.out.print(new String(var1));
    }

    public static void printInHex(short var0) {
        byte[] var1 = toHex(var0);
        System.out.print(new String(var1));
    }

    public static byte[] toHex(long var0) {
        byte var2 = 16;
        byte[] var3 = new byte[var2];

        for(int var4 = var2 - 1; var4 >= 0; --var4) {
            var3[var4] = nibbleToHex((byte)((int)(var0 & 15L)));
            var0 >>= 4;
        }

        return var3;
    }

    public static byte[] toHex(int var0) {
        byte var1 = 8;
        byte[] var2 = new byte[var1];

        for(int var3 = var1 - 1; var3 >= 0; --var3) {
            var2[var3] = nibbleToHex((byte)(var0 & 15));
            var0 >>= 4;
        }

        return var2;
    }

    public static byte[] toHex(short var0) {
        byte var1 = 4;
        byte[] var2 = new byte[var1];

        for(int var3 = var1 - 1; var3 >= 0; --var3) {
            var2[var3] = nibbleToHex((byte)(var0 & 15));
            var0 = (short)(var0 >> 4);
        }

        return var2;
    }
}
