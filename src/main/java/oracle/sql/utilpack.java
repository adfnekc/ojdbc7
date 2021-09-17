//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

class utilpack {
    private static int INTYM3BYTE = 24;
    private static int INTYM2BYTE = 16;
    private static int INTYM1BYTE = 8;

    utilpack() {
    }

    protected static int LEFTSHIFTFIRSTNIBBLE(byte var0) {
        boolean var1 = false;
        int var2 = (var0 & 255) << INTYM3BYTE;
        return var2;
    }

    protected static int LEFTSHIFTSECONDNIBBLE(byte var0) {
        boolean var1 = false;
        int var2 = (var0 & 255) << INTYM2BYTE;
        return var2;
    }

    protected static int LEFTSHIFTTHIRDNIBBLE(byte var0) {
        boolean var1 = false;
        int var2 = (var0 & 255) << INTYM1BYTE;
        return var2;
    }

    protected static byte RIGHTSHIFTFIRSTNIBBLE(int var0) {
        boolean var1 = false;
        byte var2 = (byte)(var0 >> INTYM3BYTE & 255);
        return var2;
    }

    protected static byte RIGHTSHIFTSECONDNIBBLE(int var0) {
        boolean var1 = false;
        byte var2 = (byte)(var0 >> INTYM2BYTE & 255);
        return var2;
    }

    protected static byte RIGHTSHIFTTHIRDNIBBLE(int var0) {
        boolean var1 = false;
        byte var2 = (byte)(var0 >> INTYM1BYTE & 255);
        return var2;
    }

    protected static byte RIGHTSHIFTFOURTHNIBBLE(int var0) {
        boolean var1 = false;
        byte var2 = (byte)(var0 & 255);
        return var2;
    }
}
