//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.io.InterruptedIOException;
import oracle.net.jdbc.nl.RepConversion;

public class Packet implements SQLnetDef {
    private int buffer2send;
    protected int sdu;
    protected int tdu;
    protected int length;
    public int type;
    protected int flags;
    protected int dataLen;
    protected int dataOff;
    protected String data;
    protected byte[] buffer;
    protected int leftOverFromPreviousRead;
    protected int nextPacketOffset;
    public SessionAtts sAtts;
    StringBuilder sb;
    StringBuilder tmpBuf;
    public static final String[] toHex = new String[]{" 00", " 01", " 02", " 03", " 04", " 05", " 06", " 07", " 08", " 09", " 0A", " 0B", " 0C", " 0D", " 0E", " 0F", " 10", " 11", " 12", " 13", " 14", " 15", " 16", " 17", " 18", " 19", " 1A", " 1B", " 1C", " 1D", " 1E", " 1F", " 20", " 21", " 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29", " 2A", " 2B", " 2C", " 2D", " 2E", " 2F", " 30", " 31", " 32", " 33", " 34", " 35", " 36", " 37", " 38", " 39", " 3A", " 3B", " 3C", " 3D", " 3E", " 3F", " 40", " 41", " 42", " 43", " 44", " 45", " 46", " 47", " 48", " 49", " 4A", " 4B", " 4C", " 4D", " 4E", " 4F", " 50", " 51", " 52", " 53", " 54", " 55", " 56", " 57", " 58", " 59", " 5A", " 5B", " 5C", " 5D", " 5E", " 5F", " 60", " 61", " 62", " 63", " 64", " 65", " 66", " 67", " 68", " 69", " 6A", " 6B", " 6C", " 6D", " 6E", " 6F", " 70", " 71", " 72", " 73", " 74", " 75", " 76", " 77", " 78", " 79", " 7A", " 7B", " 7C", " 7D", " 7E", " 7F", " 80", " 81", " 82", " 83", " 84", " 85", " 86", " 87", " 88", " 89", " 8A", " 8B", " 8C", " 8D", " 8E", " 8F", " 90", " 91", " 92", " 93", " 94", " 95", " 96", " 97", " 98", " 99", " 9A", " 9B", " 9C", " 9D", " 9E", " 9F", " A0", " A1", " A2", " A3", " A4", " A5", " A6", " A7", " A8", " A9", " AA", " AB", " AC", " AD", " AE", " AF", " B0", " B1", " B2", " B3", " B4", " B5", " B6", " B7", " B8", " B9", " BA", " BB", " BC", " BD", " BE", " BF", " C0", " C1", " C2", " C3", " C4", " C5", " C6", " C7", " C8", " C9", " CA", " CB", " CC", " CD", " CE", " CF", " D0", " D1", " D2", " D3", " D4", " D5", " D6", " D7", " D8", " D9", " DA", " DB", " DC", " DD", " DE", " DF", " E0", " E1", " E2", " E3", " E4", " E5", " E6", " E7", " E8", " E9", " EA", " EB", " EC", " ED", " EE", " EF", " F0", " F1", " F2", " F3", " F4", " F5", " F6", " F7", " F8", " F9", " FA", " FB", " FC", " FD", " FE", " FF"};
    public static final char[] toChar = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'};
    public static final String DIVIDER = "     |";
    public static final String BLANK_SPACE = "   ";
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public Packet(SessionAtts var1) {
        this.leftOverFromPreviousRead = 0;
        this.nextPacketOffset = 0;
        this.sb = null;
        this.tmpBuf = null;
        this.sAtts = var1;
        this.sdu = var1.getSDU();
        this.tdu = var1.getTDU();
    }

    public Packet(SessionAtts var1, int var2) {
        this(var1);
        this.createBuffer(var2);
    }

    public Packet(SessionAtts var1, int var2, int var3, int var4) {
        this(var1);
        this.createBuffer(var2, var3, var4);
    }

    public Packet(Packet var1) {
        this(var1.sAtts);
        this.length = var1.length;
        this.type = var1.type;
        this.flags = var1.flags;
        this.dataLen = var1.dataLen;
        this.dataOff = var1.dataOff;
        this.buffer = var1.buffer;
        this.leftOverFromPreviousRead = var1.leftOverFromPreviousRead;
        this.nextPacketOffset = var1.nextPacketOffset;
    }

    protected void createBuffer(int var1) {
        this.buffer = new byte[var1];
        if (!this.sAtts.isLargeSDU || this.type != 6 && this.type != 12 && this.type != 15) {
            this.buffer[0] = (byte)(var1 / 256);
            this.buffer[1] = (byte)(var1 % 256);
        } else {
            this.buffer[3] = (byte)(var1 & 255);
            this.buffer[2] = (byte)(var1 >> 8 & 255);
            this.buffer[1] = (byte)(var1 >> 16 & 255);
            this.buffer[0] = (byte)(var1 >> 24 & 255);
        }

    }

    protected void createBuffer(int var1, int var2, int var3) {
        this.type = var2;
        this.createBuffer(var1);
        this.buffer[5] = (byte)var3;
        this.buffer[4] = (byte)var2;
    }

    protected void receive() throws IOException, NetException {
        int var1 = 0;
        int var2 = 0;
        int var3 = this.sdu;
        boolean var4 = true;

        while(var3 > 0) {
            if (this.leftOverFromPreviousRead > 0) {
                System.arraycopy(this.buffer, this.nextPacketOffset, this.buffer, 0, this.leftOverFromPreviousRead);
                var1 = this.leftOverFromPreviousRead;
                if (var1 >= 8) {
                    this.processHeader();
                    var4 = false;
                    if (this.length >= this.leftOverFromPreviousRead) {
                        var3 = this.length - this.leftOverFromPreviousRead;
                        this.leftOverFromPreviousRead = 0;
                        this.nextPacketOffset = 0;
                    } else {
                        this.leftOverFromPreviousRead -= this.length;
                        var3 = 0;
                        this.nextPacketOffset = this.length;
                    }
                } else {
                    var3 -= var1;
                    this.leftOverFromPreviousRead -= var1;
                    this.nextPacketOffset = 0;
                }
            }

            try {
                if (var3 > 0) {
                    if ((var2 = this.sAtts.ntInputStream.read(this.buffer, var1, var3)) <= 0) {
                        throw new NetException(0);
                    }

                    var1 += var2;
                }

                if (var4 && var1 >= 8) {
                    var4 = false;
                    this.processHeader();
                    var3 = this.length;
                    if (var1 > this.length) {
                        this.leftOverFromPreviousRead = var1 - this.length;
                        var3 = 0;
                        this.nextPacketOffset = this.length;
                    } else {
                        this.leftOverFromPreviousRead = 0;
                        this.nextPacketOffset = 0;
                        var3 -= var1;
                    }
                } else {
                    var3 -= var2;
                }
            } catch (InterruptedIOException var6) {
                throw new NetException(504);
            }
        }

    }

    void processHeader() throws IOException, NetException {
        this.length = this.buffer[0] & 255;
        this.length <<= 8;
        this.length |= this.buffer[1] & 255;
        this.type = this.buffer[4];
        this.flags = this.buffer[5];
        if (this.sAtts.isLargeSDU && (this.type == 6 || this.type == 12 || this.type == 15)) {
            this.length = toUb4(this.buffer, 0);
        }

        if (this.type > 19) {
            throw new NetException(204);
        } else if (this.length <= 2097152 && this.length <= this.sdu) {
            if (this.length < 8) {
                throw new NetException(207);
            }
        } else {
            throw new NetException(203);
        }
    }

    protected void send() throws IOException {
        synchronized(this.sAtts.ntOutputStream) {
            this.sAtts.ntOutputStream.write(this.buffer, 0, this.buffer.length);
        }
    }

    protected void extractData() throws IOException, NetException {
        if (this.dataLen <= 0) {
            this.data = new String();
        } else if (this.length > this.dataOff) {
            this.data = new String(this.buffer, 0, this.dataOff, this.dataLen);
        } else {
            byte[] var1 = new byte[this.dataLen + 10];
            byte[] var2 = new byte[this.dataLen];
            int var3 = this.readLocal(var1, 0, this.dataLen + 10);
            if (var3 != 0) {
                if (var3 < 10) {
                    throw new NetException(207);
                }

                var3 -= 10;
                System.arraycopy(var1, 10, var2, 0, var3);
            }

            if (var3 < this.dataLen && this.sAtts.nsInputStream.read(var2, var3, this.dataLen - var3) < 0) {
                throw new NetException(0);
            }

            this.data = new String(var2, 0);
        }

    }

    protected String getData() {
        return this.data;
    }

    void setFlags(int var1) throws NetException {
        this.flags = var1;
        this.buffer[5] = (byte)this.flags;
    }

    void reinitialize(SessionAtts var1) throws NetException {
        this.sAtts = var1;
    }

    public static final int toUb2(byte[] var0, int var1) {
        boolean var2 = false;
        int var3 = var0[var1] & 255;
        var3 <<= 8;
        var3 |= var0[var1 + 1] & 255;
        return var3;
    }

    public static int toUb4(byte[] var0, int var1) {
        int var2 = 0;

        for(int var3 = 0; var3 < 4; ++var3) {
            int var4 = (3 - var3) * 8;
            var2 += (var0[var3 + var1] & 255) << var4;
        }

        return var2;
    }

    public static final void setUb2ToBytes(byte[] var0, int var1, int var2) {
        var0[var1] = (byte)(var2 << 8 & 255);
        var0[var1 + 1] = (byte)(var2 & 255);
    }

    int available() {
        return this.leftOverFromPreviousRead;
    }

    int readLocal(byte[] var1, int var2, int var3) throws NetException {
        int var4 = 0;
        if (this.leftOverFromPreviousRead > 0) {
            if (this.leftOverFromPreviousRead > var3) {
                var4 = var3;
                System.arraycopy(this.buffer, this.nextPacketOffset, var1, var2, var3);
                this.leftOverFromPreviousRead -= var3;
                this.nextPacketOffset += var3;
            } else {
                var4 = this.leftOverFromPreviousRead;
                System.arraycopy(this.buffer, this.nextPacketOffset, var1, var2, var4);
                this.leftOverFromPreviousRead -= var4;
                this.nextPacketOffset = 0;
            }
        }

        return var4;
    }

    protected String dumpBytes(byte[] var1, int var2, int var3) {
        if (this.sb == null) {
            this.sb = new StringBuilder(16384);
            this.tmpBuf = new StringBuilder(80);
        }

        return this.dumpBytes(var1, var2, var3, 8, this.sb, this.tmpBuf);
    }

    public String dumpBytes(byte[] var1, int var2, int var3, int var4, StringBuilder var5, StringBuilder var6) {
        if (var1 == null) {
            return "NULL";
        } else {
            var5.delete(0, var5.length());
            var6.delete(0, var6.length());
            int var8 = var2 + var3;
            int var9 = var2;
            boolean var10 = false;

            int var11;
            for(var11 = 0; var9 < var8; ++var9) {
                int var7 = var1[var9] & 255;
                var5.append(toHex[var7]);
                var6.append(toChar[var7]);
                ++var11;
                if (var11 == var4) {
                    var5.append("     |");
                    var5.append(var6.substring(0, var6.length()));
                    var5.append("|\n");
                    var6.delete(0, var6.length());
                    var11 = 0;
                }
            }

            if (var11 > 0) {
                int var12 = var4 - var11 - 1;

                int var13;
                for(var13 = 0; var13 <= var12; ++var13) {
                    var5.append("   ");
                }

                var5.append("     |");
                var5.append(var6.substring(0, var6.length()));

                for(var13 = 0; var13 <= var12; ++var13) {
                    var5.append(" ");
                }

                var5.append("|\n");
                var6.delete(0, var6.length());
            }

            return var5.substring(0, var5.length());
        }
    }

    protected void dump(byte[] var1, int var2, int var3) {
        int var4 = 0;
        System.out.println("Packet dump");
        System.out.println("buffer.length=" + var1.length);
        System.out.println("offset       =" + var2);
        System.out.println("len          =" + var3);

        for(int var5 = var2; var5 < var3; var5 += 8) {
            System.out.print("|");

            for(int var6 = 0; var6 < 8 && var4 < var3 - 1; ++var6) {
                var4 = var5 + var6;
                RepConversion.printInHex(var1[var4]);
                System.out.print(" ");
            }

            System.out.println("|");
        }

        System.out.println("finish dump");
    }
}
