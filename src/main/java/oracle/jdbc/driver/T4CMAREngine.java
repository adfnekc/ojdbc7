//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import oracle.jdbc.internal.OracleConnection;
import oracle.net.ns.Communication;
import oracle.net.ns.NetException;

abstract class T4CMAREngine {
    static final int TTCC_MXL = 252;
    static final int TTCC_ESC = 253;
    static final int TTCC_LNG = 254;
    static final int TTCC_ERR = 255;
    static final int TTCC_MXIN = 32767;
    static final int TTCC_MXIN_OLD = 64;
    private int effectiveTTCC_MXIN = 64;
    static final byte TTCLXMULTI = 1;
    static final byte TTCLXMCONV = 2;
    T4CTypeRep types;
    Communication net;
    DBConversion conv;
    short proSvrVer;
    static final byte[] NO_BYTES = new byte[0];
    boolean useCLRBigChunks = false;
    static final byte[] IGNORED = new byte[32767];
    final byte[] tmpBuffer1 = new byte[1];
    final byte[] tmpBuffer2 = new byte[2];
    final byte[] tmpBuffer3 = new byte[3];
    final byte[] tmpBuffer4 = new byte[4];
    final byte[] tmpBuffer5 = new byte[5];
    final byte[] tmpBuffer6 = new byte[6];
    final byte[] tmpBuffer7 = new byte[7];
    final byte[] tmpBuffer8 = new byte[8];
    final byte[] tmpBuffer10 = new byte[10];
    final int[] retLen = new int[1];
    AtomicReference<OracleConnection> connForException = new AtomicReference();
    static final byte[] NULL_PTR = new byte[]{0, 0, 0, 0};
    static final byte[] NOTNULL_PTR = new byte[]{127, 127, 127, 127};
    ArrayList refVector = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CMAREngine() {
    }

    static String toHex(long var0, int var2) {
        String var3;
        switch(var2) {
            case 1:
                var3 = "00" + Long.toString(var0 & 255L, 16);
                break;
            case 2:
                var3 = "0000" + Long.toString(var0 & 65535L, 16);
                break;
            case 3:
                var3 = "000000" + Long.toString(var0 & 16777215L, 16);
                break;
            case 4:
                var3 = "00000000" + Long.toString(var0 & 4294967295L, 16);
                break;
            case 5:
                var3 = "0000000000" + Long.toString(var0 & 1099511627775L, 16);
                break;
            case 6:
                var3 = "000000000000" + Long.toString(var0 & 281474976710655L, 16);
                break;
            case 7:
                var3 = "00000000000000" + Long.toString(var0 & 72057594037927935L, 16);
                break;
            case 8:
                return toHex(var0 >> 32, 4) + toHex(var0, 4).substring(2);
            default:
                return "more than 8 bytes";
        }

        return "0x" + var3.substring(var3.length() - 2 * var2);
    }

    static String toHex(byte var0) {
        String var1 = "00" + Integer.toHexString(var0 & 255);
        return "0x" + var1.substring(var1.length() - 2);
    }

    static String toHex(short var0) {
        return toHex((long)var0, 2);
    }

    static String toHex(int var0) {
        return toHex((long)var0, 4);
    }

    static String toHex(byte[] var0, int var1) {
        if (var0 == null) {
            return "null";
        } else if (var1 > var0.length) {
            return "byte array not long enough";
        } else {
            String var2 = "[";
            int var3 = Math.min(64, var1);

            for(int var4 = 0; var4 < var3; ++var4) {
                var2 = var2 + toHex(var0[var4]) + " ";
            }

            if (var3 < var1) {
                var2 = var2 + "...";
            }

            return var2 + "]";
        }
    }

    static String toHex(byte[] var0) {
        return var0 == null ? "null" : toHex(var0, var0.length);
    }

    abstract void marshalSB1(byte var1) throws IOException;

    abstract void marshalUB1(short var1) throws IOException;

    abstract void marshalSB2(short var1) throws IOException;

    abstract void marshalUB2(int var1) throws IOException;

    abstract void marshalSB4(int var1) throws IOException;

    abstract void marshalUB4(long var1) throws IOException;

    abstract void marshalSB8(long var1) throws IOException;

    final void marshalSWORD(int var1) throws IOException {
        this.marshalSB4(var1);
    }

    final void marshalUWORD(long var1) throws IOException {
        this.marshalSB4((int)(var1 & -1L));
    }

    abstract void marshalB1Array(byte[] var1) throws IOException;

    abstract void marshalB1Array(byte[] var1, int var2, int var3) throws IOException;

    final void marshalUB4Array(long[] var1) throws IOException {
        for(int var2 = 0; var2 < var1.length; ++var2) {
            this.marshalSB4((int)(var1[var2] & -1L));
        }

    }

    final void marshalO2U(boolean var1) throws IOException {
        if (var1) {
            this.addPtr((byte)1);
        } else {
            this.addPtr((byte)0);
        }

    }

    final void marshalNULLPTR() throws IOException {
        this.addPtr((byte)0);
    }

    final void marshalPTR() throws IOException {
        this.addPtr((byte)1);
    }

    final void marshalCHR(byte[] var1) throws IOException {
        this.marshalCHR(var1, 0, var1.length);
    }

    final void marshalCHR(byte[] var1, int var2, int var3) throws IOException {
        if (var3 > 0) {
            if (this.types.isConvNeeded()) {
                this.marshalCLR(var1, var2, var3);
            } else {
                this.marshalB1Array(var1, var2, var3);
            }
        }

    }

    final void marshalCLR(byte[] var1, int var2) throws IOException {
        this.marshalCLR(var1, 0, var2);
    }

    final void marshalCLR(byte[] var1, int var2, int var3) throws IOException {
        if (var3 > 252) {
            int var6 = 0;
            this.marshalUB1((short)-2);

            do {
                int var4 = var3 - var6;
                int var5 = var4 > this.effectiveTTCC_MXIN ? this.effectiveTTCC_MXIN : var4;
                if (this.useCLRBigChunks) {
                    this.marshalSB4(var5);
                } else {
                    this.marshalUB1((short)((byte)(var5 & 255)));
                }

                this.marshalB1Array(var1, var2 + var6, var5);
                var6 += var5;
            } while(var6 < var3);

            this.marshalUB1((short)0);
        } else {
            this.marshalUB1((short)((byte)(var3 & 255)));
            if (var1.length != 0) {
                this.marshalB1Array(var1, var2, var3);
            }
        }

    }

    final void marshalCLR(InputStream var1, int var2) throws IOException {
        int var3 = this.effectiveTTCC_MXIN;
        byte[] var4 = new byte[var3];
        boolean var5 = false;
        boolean var6 = false;
        this.marshalUB1((short)254);

        try {
            while(!var6) {
                int var10 = var1.read(var4, 0, var3);
                if (var10 == -1) {
                    var6 = true;
                }

                if (var10 > 0) {
                    if (this.useCLRBigChunks) {
                        this.marshalSB4(var10);
                    } else {
                        this.marshalUB1((short)((byte)(var10 & 255)));
                    }

                    this.marshalB1Array(var4, 0, var10);
                }
            }
        } finally {
            this.marshalUB1((short)0);
        }

    }

    final void marshalKEYVAL(byte[][] var1, int[] var2, byte[][] var3, int[] var4, byte[] var5, int var6) throws IOException {
        for(int var7 = 0; var7 < var6; ++var7) {
            if (var1[var7] != null && var2[var7] > 0) {
                this.marshalUB4((long)var2[var7]);
                this.marshalCLR(var1[var7], 0, var2[var7]);
            } else {
                this.marshalUB4(0L);
            }

            if (var3[var7] != null && var4[var7] > 0) {
                this.marshalUB4((long)var4[var7]);
                this.marshalCLR(var3[var7], 0, var4[var7]);
            } else {
                this.marshalUB4(0L);
            }

            if (var5[var7] != 0) {
                this.marshalUB4(1L);
            } else {
                this.marshalUB4(0L);
            }
        }

    }

    final void marshalKEYVAL(byte[][] var1, byte[][] var2, byte[] var3, int var4) throws IOException {
        int[] var5 = new int[var4];
        int[] var6 = new int[var4];

        for(int var7 = 0; var7 < var4; ++var7) {
            if (var1[var7] != null) {
                var5[var7] = var1[var7].length;
            }

            if (var2[var7] != null) {
                var6[var7] = var2[var7].length;
            }
        }

        this.marshalKEYVAL(var1, var5, var2, var6, var3, var4);
    }

    final void marshalDALC(byte[] var1) throws IOException {
        if (var1 != null && var1.length >= 1) {
            this.marshalUB4((long)var1.length);
            this.marshalCLR(var1, var1.length);
        } else {
            this.marshalUB4(0L);
        }

    }

    final void marshalKPDKV(byte[][] var1, byte[][] var2, int[] var3) throws IOException {
        for(int var4 = 0; var4 < var1.length; ++var4) {
            if (var1[var4] != null) {
                this.marshalUB4((long)var1[var4].length);
                this.marshalCLR(var1[var4], 0, var1[var4].length);
            } else {
                this.marshalUB4(0L);
            }

            if (var2[var4] != null) {
                this.marshalUB4((long)var2[var4].length);
                this.marshalCLR(var2[var4], 0, var2[var4].length);
            } else {
                this.marshalUB4(0L);
            }

            this.marshalUB2(var3[var4]);
        }

    }

    final void unmarshalKPDKV(byte[][] var1, int[] var2, byte[][] var3, int[] var4) throws IOException, SQLException {
        boolean var5 = false;
        int[] var6 = new int[1];

        for(int var7 = 0; var7 < var1.length; ++var7) {
            int var8 = (int)this.unmarshalUB4();
            if (var8 > 0) {
                var1[var7] = new byte[var8];
                this.unmarshalCLR(var1[var7], 0, var6, var8);
                var2[var7] = var6[0];
            }

            var8 = (int)this.unmarshalUB4();
            if (var8 > 0) {
                var3[var7] = new byte[var8];
                this.unmarshalCLR(var3[var7], 0, var6, var8);
            }

            var4[var7] = this.unmarshalUB2();
        }

    }

    final void addPtr(byte var1) throws IOException {
        if (this.types.rep[4] == 1) {
            this.marshalUB1((short)var1);
        } else if (var1 == 0) {
            this.marshalB1Array(NULL_PTR);
        } else {
            this.marshalB1Array(NOTNULL_PTR);
        }

    }

    abstract byte unmarshalSB1() throws SQLException, IOException;

    abstract short unmarshalUB1() throws SQLException, IOException;

    abstract short unmarshalSB2() throws SQLException, IOException;

    abstract int unmarshalUB2() throws SQLException, IOException;

    final int unmarshalUCS2(byte[] var1, long var2) throws SQLException, IOException {
        int var4 = this.unmarshalUB2();
        this.tmpBuffer2[0] = (byte)((var4 & '\uff00') >> 8);
        this.tmpBuffer2[1] = (byte)(var4 & 255);
        if (var2 + 1L < (long)var1.length) {
            var1[(int)var2] = this.tmpBuffer2[0];
            var1[(int)var2 + 1] = this.tmpBuffer2[1];
        }

        return this.tmpBuffer2[0] == 0 ? (this.tmpBuffer2[1] == 0 ? 1 : 2) : 3;
    }

    abstract int unmarshalSB4() throws SQLException, IOException;

    abstract long unmarshalUB4() throws SQLException, IOException;

    final int unmarshalSB4(byte[] var1) throws SQLException, IOException {
        long var2 = this.buffer2Value((byte)2, new ByteArrayInputStream(var1));
        return (int)var2;
    }

    final long unmarshalSB8() throws SQLException, IOException {
        long var1 = this.buffer2Value((byte)3);
        return var1;
    }

    final int unmarshalRefCursor(byte[] var1) throws SQLException, IOException {
        int var2 = this.unmarshalSB4(var1);
        return var2;
    }

    int unmarshalSWORD() throws SQLException, IOException {
        int var1 = (int)this.unmarshalUB4();
        return var1;
    }

    long unmarshalUWORD() throws SQLException, IOException {
        long var1 = this.unmarshalUB4();
        return var1;
    }

    abstract byte[] unmarshalNBytes(int var1) throws SQLException, IOException;

    abstract int unmarshalNBytes(byte[] var1, int var2, int var3) throws SQLException, IOException;

    abstract int getNBytes(byte[] var1, int var2, int var3) throws SQLException, IOException;

    abstract byte[] getNBytes(int var1) throws SQLException, IOException;

    abstract byte[] unmarshalTEXT(int var1) throws SQLException, IOException;

    byte[] unmarshalCHR(int var1) throws SQLException, IOException {
        Object var2 = null;
        byte[] var4;
        if (this.types.isConvNeeded()) {
            var4 = this.unmarshalCLR(var1, this.retLen);
            if (var4.length != this.retLen[0]) {
                byte[] var3 = new byte[this.retLen[0]];
                System.arraycopy(var4, 0, var3, 0, this.retLen[0]);
                var4 = var3;
            }
        } else {
            var4 = this.getNBytes(var1);
        }

        return var4;
    }

    void unmarshalCLR(byte[] var1, int var2, int[] var3) throws SQLException, IOException {
        this.unmarshalCLR(var1, var2, var3, 2147483647);
    }

    void unmarshalCLR(byte[] var1, int var2, int[] var3, int var4) throws SQLException, IOException {
        this.unmarshalCLR(var1, (long)var2, var3, var4, 0);
    }

    void unmarshalCLR(Object var1, long var2, int[] var4, int var5, int var6) throws SQLException, IOException {
        boolean var7 = false;
        boolean var8 = false;
        long var9 = var2;
        boolean var11 = false;
        int var12 = 0;
        boolean var13 = false;
        int var14 = 0;
        boolean var15 = true;
        int var17 = this.unmarshalUB1();
        if (var17 < 0) {
            SQLException var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
            var21.fillInStackTrace();
            throw var21;
        } else if (var17 == 0) {
            var4[0] = 0;
        } else if (this.escapeSequenceNull(var17)) {
            var4[0] = 0;
        } else {
            int var16;
            int var19;
            if (var17 != 254) {
                if (var6 - var14 >= var17) {
                    this.unmarshalBuffer(IGNORED, 0, var17);
                    int var10000 = var14 + var17;
                    var17 = 0;
                } else if (var6 - var14 > 0) {
                    this.unmarshalBuffer(IGNORED, 0, var6 - var14);
                    var17 -= var6 - var14;
                    var14 += var6 - var14;
                }

                if (var17 > 0) {
                    var19 = Math.min(var5 - var12, var17);
                    var9 = this.unmarshalBuffer(var1, var2, var19);
                    var12 += var19;
                    var16 = var17 - var19;
                    if (var16 > 0) {
                        this.unmarshalBuffer(IGNORED, 0, var16);
                    }
                }
            } else {
                byte var20 = -1;

                label83:
                while(true) {
                    while(true) {
                        if (var20 != -1) {
                            if (this.useCLRBigChunks) {
                                var17 = this.unmarshalSB4();
                            } else {
                                var17 = this.unmarshalUB1();
                            }

                            if (var17 <= 0) {
                                break label83;
                            }
                        }

                        if (var17 == 254) {
                            switch(var20) {
                                case -1:
                                    var20 = 1;
                                    continue;
                                case 0:
                                    if (!var11) {
                                        var20 = 0;
                                        continue;
                                    }

                                    var15 = false;
                                    break;
                                case 1:
                                    var15 = false;
                            }
                        }

                        if (var9 == -1L) {
                            this.unmarshalBuffer(IGNORED, 0, var17);
                        } else {
                            int var18 = var17;
                            if (var6 - var14 >= var17) {
                                this.unmarshalBuffer(IGNORED, 0, var17);
                                var14 += var17;
                                var18 = 0;
                            } else if (var6 - var14 > 0) {
                                this.unmarshalBuffer(IGNORED, 0, var6 - var14);
                                var18 = var17 - (var6 - var14);
                                var14 += var6 - var14;
                            }

                            if (var18 > 0) {
                                var19 = Math.min(var5 - var12, var18);
                                var9 = this.unmarshalBuffer(var1, var9, var19);
                                var12 += var19;
                                var16 = var18 - var19;
                                if (var16 > 0) {
                                    this.unmarshalBuffer(IGNORED, 0, var16);
                                }
                            }
                        }

                        var20 = 0;
                        if (var17 > 252) {
                            var11 = true;
                        }
                    }
                }
            }

            if (var4 != null) {
                if (var9 != -1L) {
                    var4[0] = var12;
                } else {
                    var4[0] = ((byte[])((byte[])var1)).length - (int)var2;
                }
            }

        }
    }

    final byte[] unmarshalCLR(int var1, int[] var2) throws SQLException, IOException {
        byte[] var3 = new byte[var1 * this.conv.c2sNlsRatio];
        this.unmarshalCLR(var3, 0, var2, var1);
        return var3;
    }

    final int[] unmarshalKEYVAL(byte[][] var1, byte[][] var2, int var3) throws SQLException, IOException {
        byte[] var4 = new byte[1000];
        int[] var5 = new int[1];
        int[] var6 = new int[var3];

        for(int var8 = 0; var8 < var3; ++var8) {
            int var7 = this.unmarshalSB4();
            if (var7 > 0) {
                this.unmarshalCLR(var4, 0, var5);
                var1[var8] = new byte[var5[0]];
                System.arraycopy(var4, 0, var1[var8], 0, var5[0]);
            }

            var7 = this.unmarshalSB4();
            if (var7 > 0) {
                this.unmarshalCLR(var4, 0, var5);
                var2[var8] = new byte[var5[0]];
                System.arraycopy(var4, 0, var2[var8], 0, var5[0]);
            }

            var6[var8] = this.unmarshalSB4();
        }

        Object var9 = null;
        return var6;
    }

    final long unmarshalBuffer(Object var1, long var2, int var4) throws SQLException, IOException {
        return var1 instanceof DynamicByteArray ? ((DynamicByteArray)var1).unmarshalBuffer(this, var2, var4) : (long)this.unmarshalBuffer((byte[])((byte[])var1), (int)var2, var4);
    }

    final int unmarshalBuffer(byte[] var1, int var2, int var3) throws SQLException, IOException {
        if (var3 <= 0) {
            return var2;
        } else {
            if (var1.length < var2 + var3) {
                this.unmarshalNBytes(var1, var2, var1.length - var2);
                this.unmarshalNBytes(IGNORED, 0, var2 + var3 - var1.length);
                var2 = -1;
            } else {
                this.unmarshalNBytes(var1, var2, var3);
                var2 += var3;
            }

            return var2;
        }
    }

    final byte[] unmarshalCLRforREFS() throws SQLException, IOException {
        boolean var1 = false;
        short var2 = 0;
        Object var3 = null;
        short var4 = this.unmarshalUB1();
        if (var4 < 0) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
            var10.fillInStackTrace();
            throw var10;
        } else if (var4 == 0) {
            return null;
        } else {
            boolean var5 = this.escapeSequenceNull(var4);
            if (!var5) {
                if (this.refVector == null) {
                    this.refVector = new ArrayList(10);
                } else {
                    this.refVector.clear();
                }
            }

            byte[] var9;
            if (!var5) {
                byte[] var6;
                if (var4 != 254) {
                    var2 = var4;
                    var6 = new byte[var4];
                    this.unmarshalBuffer(var6, 0, var4);
                    this.refVector.add(var6);
                } else {
                    label49:
                    while(true) {
                        int var8;
                        do {
                            int var10000 = this.useCLRBigChunks ? this.unmarshalSB4() : this.unmarshalUB1();
                            var8 = var10000;
                            if (var10000 <= 0) {
                                break label49;
                            }
                        } while(var8 == 254 && this.types.isServerConversion());

                        var2 = (short)(var2 + var8);
                        var6 = new byte[var8];
                        this.unmarshalBuffer(var6, 0, var8);
                        this.refVector.add(var6);
                    }
                }

                var9 = new byte[var2];
                int var11 = 0;

                while(this.refVector.size() > 0) {
                    int var7 = ((byte[])((byte[])this.refVector.get(0))).length;
                    System.arraycopy(this.refVector.get(0), 0, var9, var11, var7);
                    var11 += var7;
                    this.refVector.remove(0);
                }
            } else {
                var9 = null;
            }

            return var9;
        }
    }

    final boolean escapeSequenceNull(int var1) throws SQLException {
        boolean var2 = false;
        switch(var1) {
            case 0:
                var2 = true;
                break;
            case 253:
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
                var3.fillInStackTrace();
                throw var3;
            case 254:
            default:
                break;
            case 255:
                var2 = true;
        }

        return var2;
    }

    final int processIndicator(boolean var1, int var2) throws SQLException, IOException {
        short var3 = this.unmarshalSB2();
        int var4 = 0;
        if (!var1) {
            if (var3 == 0) {
                var4 = var2;
            } else if (var3 != -2 && var3 <= 0) {
                var4 = 65536 + var3;
            } else {
                var4 = var3;
            }
        }

        return var4;
    }

    final long unmarshalDALC(byte[] var1, int var2, int[] var3) throws SQLException, IOException {
        long var4 = this.unmarshalUB4();
        if (var4 > 0L) {
            this.unmarshalCLR(var1, var2, var3);
        }

        return var4;
    }

    final byte[] unmarshalDALC() throws SQLException, IOException {
        long var1 = this.unmarshalUB4();
        byte[] var3 = new byte[(int)(-1L & var1)];
        if (var3.length > 0) {
            var3 = this.unmarshalCLR(var3.length, this.retLen);
            if (var3 == null) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
                var4.fillInStackTrace();
                throw var4;
            }
        } else {
            var3 = new byte[0];
        }

        return var3;
    }

    final byte[] unmarshalDALC(int[] var1) throws SQLException, IOException {
        long var2 = this.unmarshalUB4();
        byte[] var4 = new byte[(int)(-1L & var2)];
        if (var4.length > 0) {
            var4 = this.unmarshalCLR(var4.length, var1);
            if (var4 == null) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
                var5.fillInStackTrace();
                throw var5;
            }
        } else {
            var4 = new byte[0];
        }

        return var4;
    }

    abstract long buffer2Value(byte var1) throws SQLException, IOException;

    final long buffer2Value(byte var1, ByteArrayInputStream var2) throws SQLException, IOException {
        int var4 = 0;
        long var6 = 0L;
        boolean var8 = false;
        SQLException var10;
        if ((this.types.rep[var1] & 1) > 0) {
            var4 = var2.read();
            if ((var4 & 128) > 0) {
                var4 &= 127;
                var8 = true;
            }

            if (var4 < 0) {
                var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 410);
                var10.fillInStackTrace();
                throw var10;
            }

            if (var4 == 0) {
                return 0L;
            }

            if (var1 == 1 && var4 > 2 || var1 == 2 && var4 > 4) {
                var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 412);
                var10.fillInStackTrace();
                throw var10;
            }
        } else if (var1 == 1) {
            var4 = 2;
        } else if (var1 == 2) {
            var4 = 4;
        }

        byte[] var5 = new byte[var4];
        if (var2.read(var5) < 0) {
            var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 410);
            var10.fillInStackTrace();
            throw var10;
        } else {
            for(int var9 = 0; var9 < var5.length; ++var9) {
                short var3;
                if ((this.types.rep[var1] & 2) > 0) {
                    var3 = (short)(var5[var5.length - 1 - var9] & 255);
                } else {
                    var3 = (short)(var5[var9] & 255);
                }

                var6 |= (long)(var3 << 8 * (var5.length - 1 - var9));
            }

            var6 &= -1L;
            if (var8) {
                var6 = -var6;
            }

            return var6;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return (OracleConnection)this.connForException.get();
    }

    protected void setConnectionDuringExceptionHandling(OracleConnection var1) {
        this.connForException.set(var1);
    }

    protected abstract void flush() throws IOException;

    abstract void setByteOrder(byte var1) throws IOException;

    abstract void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException, NetException;

    boolean readZeroCopyIO(byte[] var1, int var2, int[] var3) throws IOException, NetException {
        boolean var4 = this.net.readZeroCopyIO(var1, var2, var3);
        return var4;
    }

    void setUseCLRBigChunks(boolean var1) {
        this.useCLRBigChunks = var1;
        if (var1) {
            this.effectiveTTCC_MXIN = 32767;
        } else {
            assert false;

            this.effectiveTTCC_MXIN = 64;
        }

    }
}
