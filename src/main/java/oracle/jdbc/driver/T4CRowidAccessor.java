//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.OracleResultSetMetaData.SecurityAttribute;
import oracle.jdbc.internal.OracleConnection;

class T4CRowidAccessor extends RowidAccessor {
    T4CMAREngine mare;
    final int[] meta = new int[1];
    static final int KGRD_EXTENDED_OBJECT = 6;
    static final int KGRD_EXTENDED_BLOCK = 6;
    static final int KGRD_EXTENDED_FILE = 3;
    static final int KGRD_EXTENDED_SLOT = 3;
    static final int kd4_ubridtype_physical = 1;
    static final int kd4_ubridtype_logical = 2;
    static final int kd4_ubridtype_remote = 3;
    static final int kd4_ubridtype_exttab = 4;
    static final int kd4_ubridtype_future2 = 5;
    static final int kd4_ubridtype_max = 5;
    static final int kd4_ubridlen_typeind = 1;
    static final byte[] kgrd_indbyte_char = new byte[]{65, 42, 45, 40, 41};
    static final byte[] kgrd_basis_64 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    static final byte[] kgrd_index_64 = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CRowidAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
        super(var1, var2, var3, var4, var5);
        this.mare = var6;
        this.defineType = 104;
    }

    T4CRowidAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, T4CMAREngine var12) throws SQLException {
        super(var1, var2, var3, var4, var5, var6, var7, var8, var9);
        this.mare = var12;
        this.definedColumnType = var10;
        this.definedColumnSize = var11;
        this.defineType = 104;
    }

    public T4CMAREngine getMAREngine() {
        return this.mare;
    }

    public void unmarshalColumnMetadata() throws SQLException, IOException {
        if (this.statement.statementType != 2 && !this.statement.sqlKind.isPlsqlOrCall() && this.securityAttribute == SecurityAttribute.ENABLED) {
            this.setRowMetadata(this.lastRowProcessed, (byte)this.mare.unmarshalUB1());
        }

    }

    public void processIndicator(int var1) throws IOException, SQLException {
        if ((this.internalType != 1 || this.describeType != 112) && (this.internalType != 23 || this.describeType != 113)) {
            if (this.statement.connection.versionNumber < 9200) {
                this.mare.unmarshalSB2();
                if (!this.statement.sqlKind.isPlsqlOrCall()) {
                    this.mare.unmarshalSB2();
                }
            } else if (this.statement.sqlKind.isPlsqlOrCall() || this.isDMLReturnedParam) {
                this.mare.processIndicator(var1 <= 0, var1);
            }
        } else {
            this.mare.unmarshalUB2();
            this.mare.unmarshalUB2();
        }

    }

    int getPreviousRowProcessed() {
        if (this.previousRowProcessed == -1) {
            this.previousRowProcessed = this.statement.rowPrefetchInLastFetch - 1;
        }

        return this.previousRowProcessed;
    }

    boolean unmarshalOneRow() throws SQLException, IOException {
        boolean var1 = false;
        if (!this.isUseless()) {
            if (this.isUnexpected()) {
                long var2 = this.rowData.getPosition();
                this.unmarshalColumnMetadata();
                this.unmarshalBytes();
                this.rowData.setPosition(var2);
                this.setNull(this.lastRowProcessed, true);
            } else if (this.isNullByDescribe()) {
                this.setNull(this.lastRowProcessed, true);
                this.unmarshalColumnMetadata();
                if (this.statement.connection.versionNumber < 9200) {
                    this.processIndicator(0);
                }
            } else {
                this.unmarshalColumnMetadata();
                var1 = this.unmarshalBytes();
            }
        }

        this.previousRowProcessed = this.lastRowProcessed++;
        return var1;
    }

    void copyRow() throws SQLException, IOException {
        if (this.isNullByDescribe) {
            this.setNull(this.lastRowProcessed, true);
        } else if (this.lastRowProcessed == 0) {
            if (this.previousRowProcessed == -1) {
                this.previousRowProcessed = this.statement.rowPrefetchInLastFetch - 1;
            }

            long var1 = this.getOffset(this.previousRowProcessed);
            this.setNull(this.lastRowProcessed, this.isNull(this.previousRowProcessed));
            this.rowMetadata[this.lastRowProcessed] = this.rowMetadata[this.previousRowProcessed];
            if (!this.isNull(this.previousRowProcessed)) {
                this.setOffset(this.lastRowProcessed);
                ((DynamicByteArray)this.rowData).copyLeft(var1, this.getLength(this.previousRowProcessed));
                this.setLength(this.lastRowProcessed, this.getLength(this.previousRowProcessed));
            }
        } else {
            this.setNull(this.lastRowProcessed, this.isNull(this.previousRowProcessed));
            this.rowMetadata[this.lastRowProcessed] = this.rowMetadata[this.previousRowProcessed];
            this.setOffset(this.lastRowProcessed, this.getOffset(this.previousRowProcessed));
            this.setLength(this.lastRowProcessed, this.getLength(this.previousRowProcessed));
        }

        this.previousRowProcessed = this.lastRowProcessed++;
    }

    boolean unmarshalBytes() throws SQLException, IOException {
        this.setOffset(this.lastRowProcessed);
        this.rowData.putShort((short)0);
        int var1;
        if (this.describeType == 208) {
            var1 = (int)this.mare.unmarshalUB4();
            if (var1 > 0) {
                ((DynamicByteArray)this.rowData).unmarshalCLR(this.mare, var1);
            }
        } else {
            var1 = this.mare.unmarshalUB1();
            if (var1 > 0) {
                this.rowData.putInt((int)this.mare.unmarshalUB4());
                this.rowData.putShort((short)this.mare.unmarshalUB2());
                this.rowData.put((byte)this.mare.unmarshalUB1());
                this.rowData.putInt((int)this.mare.unmarshalUB4());
                this.rowData.putShort((short)this.mare.unmarshalUB2());
            }
        }

        this.processIndicator(var1);
        this.rowData.putShort(this.getOffset(this.lastRowProcessed), (short)var1);
        this.setLength(this.lastRowProcessed, (int)(this.rowData.getPosition() - this.getOffset(this.lastRowProcessed)));
        this.setNull(this.lastRowProcessed, var1 == 0);
        return false;
    }

    byte[] getDecodedBytes(int var1) throws SQLException {
        this.rowData.setPosition(this.getOffset(var1));
        int var2 = this.rowData.getShort();
        if (this.describeType == 208) {
            byte[] var15 = this.getBytesInternal(var1);
            byte[] var16 = new byte[4096];
            var2 = kgrdub2c(var15, var2, 2, var16, 2);
            var16[0] = (byte)(var2 >> 8 & 255);
            var16[1] = (byte)(var2 & 255);
            byte[] var5 = new byte[var2 + 2];
            System.arraycopy(var16, 0, var5, 0, var5.length);
            return var5;
        } else {
            short var3 = (short)var2;
            long var4 = 0L;
            int var6 = 0;
            short var7 = 0;
            long var8 = 0L;
            int var10 = 0;
            if (var3 > 0) {
                var4 = (long)this.rowData.getInt() & 4294967295L;
                var6 = this.rowData.getShort() & '\uffff';
                var7 = (short)(this.rowData.get() & 255);
                var8 = (long)this.rowData.getInt() & 4294967295L;
                var10 = this.rowData.getShort() & '\uffff';
            }

            if (var4 == 0L && var6 == 0 && var7 == 0 && var8 == 0L && var10 == 0) {
                return null;
            } else {
                long[] var11 = new long[]{var4, (long)var6, var8, (long)var10};
                byte[] var12 = rowidToString(var11);
                int var13 = 18;
                if (this.byteLength - 2 < 18) {
                    var13 = this.byteLength - 2;
                }

                byte[] var14 = new byte[var13 + 2];
                System.arraycopy(var12, 0, var14, 2, var13);
                var14[0] = (byte)((var13 & '\uff00') >> 8);
                var14[1] = (byte)(var13 & 255);
                return var14;
            }
        }
    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            long var2 = this.getOffset(var1);
            if (this.describeType == 208 && this.rowData.get(var2) != 1) {
                byte[] var4 = this.getDecodedBytes(var1);
                if (var4 == null) {
                    return null;
                } else {
                    int var8 = (var4[0] & 255) << 8 | var4[1] & 255;
                    return new String(var4, 2, var8);
                }
            } else {
                this.getLength(var1);
                byte[] var5 = this.getDecodedBytes(var1);
                if (var5 == null) {
                    return null;
                } else {
                    String var6 = new String(var5, 2, var5.length - 2);
                    long[] var7 = stringToRowid(var6.getBytes(), 0, var6.length());
                    return new String(rowidToString(var7));
                }
            }
        }
    }

    Object getObject(int var1) throws SQLException {
        if (this.definedColumnType == 0) {
            return super.getObject(var1);
        } else if (this.isNull(var1)) {
            return null;
        } else {
            switch(this.definedColumnType) {
                case -15:
                case -9:
                case -1:
                case 1:
                case 12:
                    return this.getString(var1);
                case -8:
                    return this.getROWID(var1);
                default:
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                    var2.fillInStackTrace();
                    throw var2;
            }
        }
    }

    byte[] getBytes(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = this.getDecodedBytes(var1);
            if (var2 == null) {
                return null;
            } else {
                byte[] var3 = new byte[var2.length - 2];
                System.arraycopy(var2, 2, var3, 0, var3.length);
                return var3;
            }
        }
    }

    static final byte[] rowidToString(long[] var0) {
        long var1 = var0[0];
        long var3 = var0[1];
        long var5 = var0[2];
        long var7 = var0[3];
        byte var9 = 18;
        byte[] var10 = new byte[var9];
        byte var11 = 0;
        int var12 = kgrd42b(var10, var1, 6, var11);
        var12 = kgrd42b(var10, var3, 3, var12);
        var12 = kgrd42b(var10, var5, 6, var12);
        kgrd42b(var10, var7, 3, var12);
        return var10;
    }

    static final long[] rcToRowid(byte[] var0, int var1, int var2) throws SQLException {
        byte var3 = 18;
        if (var2 != var3) {
            throw new SQLException("Rowid size incorrect.");
        } else {
            long[] var4 = new long[3];
            String var5 = new String(var0, var1, var2);
            long var6 = Long.parseLong(var5.substring(0, 8), 16);
            long var8 = Long.parseLong(var5.substring(9, 13), 16);
            long var10 = Long.parseLong(var5.substring(14, 8), 16);
            var4[0] = var10;
            var4[1] = var6;
            var4[2] = var8;
            return var4;
        }
    }

    static final void kgrdr2rc(int var0, int var1, int var2, int var3, int var4, byte[] var5, int var6) throws SQLException {
        var6 = lmx42h(var5, (long)var3, 8, var6);
        var5[var6++] = 46;
        var6 = lmx42h(var5, (long)var4, 4, var6);
        var5[var6++] = 46;
        lmx42h(var5, (long)var1, 4, var6);
    }

    static final int lmx42h(byte[] var0, long var1, int var3, int var4) {
        String var5 = Long.toHexString(var1).toUpperCase();
        int var6 = var3;
        int var7 = 0;

        do {
            if (var7 < var5.length()) {
                var0[var4 + var3 - 1] = (byte)var5.charAt(var5.length() - var7 - 1);
                ++var7;
            } else {
                var0[var4 + var3 - 1] = 48;
            }

            --var3;
        } while(var3 > 0);

        return var6 + var4;
    }

    static final int kgrdc2ub(byte[] var0, int var1, byte[] var2, int var3, int var4) throws SQLException {
        byte var5 = getRowidType(var0, var1);
        byte[] var6 = var2;
        int var7 = var4 - 1;
        boolean var8 = false;
        byte[] var12 = kgrd_index_64;
        int var13 = 1 + 3 * ((var4 - 1) / 4) + ((var4 - 1) % 4 != 0 ? (var4 - 1) % 4 - 1 : 0);
        SQLException var14;
        if (var7 == 0) {
            var14 = DatabaseError.createSqlException((OracleConnection)null, 132);
            var14.fillInStackTrace();
            throw var14;
        } else {
            var2[var3 + 0] = var5;
            int var15 = var1 + 1;
            int var11 = 1;

            while(true) {
                if (var7 > 0) {
                    if (var7 == 1) {
                        var14 = DatabaseError.createSqlException((OracleConnection)null, 132);
                        var14.fillInStackTrace();
                        throw var14;
                    }

                    byte var9 = var12[var0[var15]];
                    if (var9 == -1) {
                        var14 = DatabaseError.createSqlException((OracleConnection)null, 132);
                        var14.fillInStackTrace();
                        throw var14;
                    }

                    ++var15;
                    byte var10 = var12[var0[var15]];
                    if (var10 == -1) {
                        var14 = DatabaseError.createSqlException((OracleConnection)null, 132);
                        var14.fillInStackTrace();
                        throw var14;
                    }

                    var6[var3 + var11] = (byte)((var9 & 255) << 2 | (var10 & 48) >> 4);
                    if (var7 != 2) {
                        ++var11;
                        var9 = var10;
                        ++var15;
                        var10 = var12[var0[var15]];
                        if (var10 == -1) {
                            var14 = DatabaseError.createSqlException((OracleConnection)null, 132);
                            var14.fillInStackTrace();
                            throw var14;
                        }

                        var6[var3 + var11] = (byte)((var9 & 255) << 4 | (var10 & 60) >> 2);
                        if (var7 != 3) {
                            ++var11;
                            var9 = var10;
                            ++var15;
                            var10 = var12[var0[var15]];
                            if (var10 == -1) {
                                var14 = DatabaseError.createSqlException((OracleConnection)null, 132);
                                var14.fillInStackTrace();
                                throw var14;
                            }

                            var6[var3 + var11] = (byte)((var9 & 3) << 6 | var10);
                            var7 -= 4;
                            ++var15;
                            ++var11;
                            continue;
                        }
                    }
                }

                return var13;
            }
        }
    }

    static final long[] stringToRowid(byte[] var0, int var1, int var2) throws SQLException {
        byte var3 = 18;
        if (var2 != var3) {
            throw new SQLException("Rowid size incorrect.");
        } else {
            long[] var4 = new long[4];

            try {
                var4[0] = kgrdb42(var0, 6, var1);
                var1 += 6;
                var4[1] = kgrdb42(var0, 3, var1);
                var1 += 3;
                var4[2] = kgrdb42(var0, 6, var1);
                var1 += 6;
                var4[3] = kgrdb42(var0, 3, var1);
                var1 += 3;
            } catch (Exception var6) {
                var4[0] = 0L;
                var4[1] = 0L;
                var4[2] = 0L;
                var4[3] = 0L;
            }

            return var4;
        }
    }

    static final int kgrd42b(byte[] var0, long var1, int var3, int var4) {
        int var5 = var3;

        for(long var6 = var1; var3 > 0; --var3) {
            var0[var4 + var3 - 1] = kgrd_basis_64[(int)var6 & 63];
            var6 = var6 >>> 6 & 67108863L;
        }

        return var5 + var4;
    }

    static final long kgrdb42(byte[] var0, int var1, int var2) throws SQLException {
        long var3 = 0L;

        for(int var5 = 0; var5 < var1; ++var5) {
            byte var6 = var0[var2 + var5];
            var6 = kgrd_index_64[var6];
            if (var6 == -1) {
                throw new SQLException("Char data to rowid conversion failed.");
            }

            var3 <<= 6;
            var3 |= (long)var6;
        }

        return var3;
    }

    static final void kgrdr2ec(int var0, int var1, int var2, int var3, int var4, byte[] var5, int var6) throws SQLException {
        var6 = kgrd42b(var0, var5, var6, 6);
        var6 = kgrd42b(var1, var5, var6, 3);
        var6 = kgrd42b(var3, var5, var6, 6);
        kgrd42b(var4, var5, var6, 3);
    }

    static final int kgrd42b(int var0, byte[] var1, int var2, int var3) throws SQLException {
        int var4;
        for(var4 = var3; var3 > 0; var0 >>= 6) {
            --var3;
            var1[var2 + var3] = kgrd_basis_64[var0 & 63];
        }

        return var2 + var4;
    }

    static final int kgrdub2c(byte[] var0, int var1, int var2, byte[] var3, int var4) throws SQLException {
        boolean var5 = true;
        byte var6 = var0[var2];
        int var8;
        int var9;
        int var10;
        int var14;
        if (var6 == 1) {
            int[] var7 = new int[var0.length];

            for(var8 = 0; var8 < var0.length; ++var8) {
                var7[var8] = var0[var8] & 255;
            }

            var8 = var2 + 1;
            var9 = (((var7[var8 + 0] << 8) + var7[var8 + 1] << 8) + var7[var8 + 2] << 8) + var7[var8 + 3];
            var8 = var2 + 5;
            var10 = (var7[var8 + 0] << 8) + var7[var8 + 1];
            byte var11 = 0;
            var8 = var2 + 7;
            int var12 = (((var7[var8 + 0] << 8) + var7[var8 + 1] << 8) + var7[var8 + 2] << 8) + var7[var8 + 3];
            var8 = var2 + 11;
            int var13 = (var7[var8 + 0] << 8) + var7[var8 + 1];
            if (var9 == 0) {
                kgrdr2rc(var9, var10, var11, var12, var13, var3, var4);
            } else {
                kgrdr2ec(var9, var10, var11, var12, var13, var3, var4);
            }

            var14 = 18;
        } else {
            int var15 = 0;
            var8 = var1 - 1;
            var9 = 4 * (var1 / 3) + (var1 % 3 == 0 ? var1 % 3 + 1 : 0);
            var10 = 1 + var9 - 1;
            if (var10 != 0) {
                var3[var4 + 0] = kgrd_indbyte_char[var6 - 1];
                int var16 = var2 + 1;
                var15 = 1;

                for(boolean var17 = false; var8 > 0; ++var15) {
                    var3[var4 + var15++] = kgrd_basis_64[(var0[var16] & 255) >> 2];
                    if (var8 == 1) {
                        var3[var4 + var15++] = kgrd_basis_64[(var0[var16] & 3) << 4];
                        break;
                    }

                    byte var18 = (byte)(var0[var16 + 1] & 255);
                    var3[var4 + var15++] = kgrd_basis_64[(var0[var16] & 3) << 4 | (var18 & 240) >> 4];
                    if (var8 == 2) {
                        var3[var4 + var15++] = kgrd_basis_64[(var18 & 15) << 2];
                        break;
                    }

                    var16 += 2;
                    var3[var4 + var15++] = kgrd_basis_64[(var18 & 15) << 2 | (var0[var16] & 192) >> 6];
                    var3[var4 + var15] = kgrd_basis_64[var0[var16] & 63];
                    var8 -= 3;
                    ++var16;
                }
            }

            var14 = var15;
        }

        return var14;
    }

    static final boolean isUROWID(byte[] var0, int var1) {
        return getRowidType(var0, var1) == 2;
    }

    static final byte getRowidType(byte[] var0, int var1) {
        byte var2 = 5;
        switch(var0[var1]) {
            case 40:
                var2 = 4;
                break;
            case 41:
                var2 = 5;
                break;
            case 42:
                var2 = 2;
                break;
            case 45:
                var2 = 3;
                break;
            case 65:
                var2 = 1;
        }

        return var2;
    }
}
