//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Map;
import oracle.sql.Datum;
import oracle.sql.NUMBER;

abstract class NumberCommonAccessor extends Accessor {
    protected final byte[] tmpBytes;
    static final boolean GET_XXX_ROUNDS = false;
    int[] digs = new int[27];
    static final int LNXSGNBT = 128;
    static final byte LNXDIGS = 20;
    static final byte LNXEXPBS = 64;
    static final int LNXEXPMX = 127;
    static final BigDecimal BIGDEC_ZERO = BigDecimal.valueOf(0L);
    static final byte MAX_LONG_EXPONENT = 9;
    static final byte MIN_LONG_EXPONENT = 9;
    static final byte MAX_INT_EXPONENT = 4;
    static final byte MIN_INT_EXPONENT = 4;
    static final byte MAX_SHORT_EXPONENT = 2;
    static final byte MIN_SHORT_EXPONENT = 2;
    static final byte MAX_BYTE_EXPONENT = 1;
    static final byte MIN_BYTE_EXPONENT = 1;
    static final int[] MAX_LONG = new int[]{202, 10, 23, 34, 73, 4, 69, 55, 78, 59, 8};
    static final int[] MIN_LONG = new int[]{53, 92, 79, 68, 29, 98, 33, 47, 24, 43, 93, 102};
    static final int MAX_LONG_length = 11;
    static final int MIN_LONG_length = 12;
    static final double[] factorTable = new double[]{1.0E254D, 1.0E252D, 1.0E250D, 1.0E248D, 1.0E246D, 1.0E244D, 1.0E242D, 1.0E240D, 1.0E238D, 1.0E236D, 1.0E234D, 1.0E232D, 1.0E230D, 1.0E228D, 1.0E226D, 1.0E224D, 1.0E222D, 1.0E220D, 1.0E218D, 1.0E216D, 1.0E214D, 1.0E212D, 1.0E210D, 1.0E208D, 1.0E206D, 1.0E204D, 1.0E202D, 1.0E200D, 1.0E198D, 1.0E196D, 1.0E194D, 1.0E192D, 1.0E190D, 1.0E188D, 1.0E186D, 1.0E184D, 1.0E182D, 1.0E180D, 1.0E178D, 1.0E176D, 1.0E174D, 1.0E172D, 1.0E170D, 1.0E168D, 1.0E166D, 1.0E164D, 1.0E162D, 1.0E160D, 1.0E158D, 1.0E156D, 1.0E154D, 1.0E152D, 1.0E150D, 1.0E148D, 1.0E146D, 1.0E144D, 1.0E142D, 1.0E140D, 1.0E138D, 1.0E136D, 1.0E134D, 1.0E132D, 1.0E130D, 1.0E128D, 1.0E126D, 1.0E124D, 1.0E122D, 1.0E120D, 1.0E118D, 1.0E116D, 1.0E114D, 1.0E112D, 1.0E110D, 1.0E108D, 1.0E106D, 1.0E104D, 1.0E102D, 1.0E100D, 1.0E98D, 1.0E96D, 1.0E94D, 1.0E92D, 1.0E90D, 1.0E88D, 1.0E86D, 1.0E84D, 1.0E82D, 1.0E80D, 1.0E78D, 1.0E76D, 1.0E74D, 1.0E72D, 1.0E70D, 1.0E68D, 1.0E66D, 1.0E64D, 1.0E62D, 1.0E60D, 1.0E58D, 1.0E56D, 1.0E54D, 1.0E52D, 1.0E50D, 1.0E48D, 1.0E46D, 1.0E44D, 1.0E42D, 1.0E40D, 1.0E38D, 1.0E36D, 1.0E34D, 1.0E32D, 1.0E30D, 1.0E28D, 1.0E26D, 1.0E24D, 1.0E22D, 1.0E20D, 1.0E18D, 1.0E16D, 1.0E14D, 1.0E12D, 1.0E10D, 1.0E8D, 1000000.0D, 10000.0D, 100.0D, 1.0D, 0.01D, 1.0E-4D, 1.0E-6D, 1.0E-8D, 1.0E-10D, 1.0E-12D, 1.0E-14D, 1.0E-16D, 1.0E-18D, 1.0E-20D, 1.0E-22D, 1.0E-24D, 1.0E-26D, 1.0E-28D, 1.0E-30D, 1.0E-32D, 1.0E-34D, 1.0E-36D, 1.0E-38D, 1.0E-40D, 1.0E-42D, 1.0E-44D, 1.0E-46D, 1.0E-48D, 1.0E-50D, 1.0E-52D, 1.0E-54D, 1.0E-56D, 1.0E-58D, 1.0E-60D, 1.0E-62D, 1.0E-64D, 1.0E-66D, 1.0E-68D, 1.0E-70D, 1.0E-72D, 1.0E-74D, 1.0E-76D, 1.0E-78D, 1.0E-80D, 1.0E-82D, 1.0E-84D, 1.0E-86D, 1.0E-88D, 1.0E-90D, 1.0E-92D, 1.0E-94D, 1.0E-96D, 1.0E-98D, 1.0E-100D, 1.0E-102D, 1.0E-104D, 1.0E-106D, 1.0E-108D, 1.0E-110D, 1.0E-112D, 1.0E-114D, 1.0E-116D, 1.0E-118D, 1.0E-120D, 1.0E-122D, 1.0E-124D, 1.0E-126D, 1.0E-128D, 1.0E-130D, 1.0E-132D, 1.0E-134D, 1.0E-136D, 1.0E-138D, 1.0E-140D, 1.0E-142D, 1.0E-144D, 1.0E-146D, 1.0E-148D, 1.0E-150D, 1.0E-152D, 1.0E-154D, 1.0E-156D, 1.0E-158D, 1.0E-160D, 1.0E-162D, 1.0E-164D, 1.0E-166D, 1.0E-168D, 1.0E-170D, 1.0E-172D, 1.0E-174D, 1.0E-176D, 1.0E-178D, 1.0E-180D, 1.0E-182D, 1.0E-184D, 1.0E-186D, 1.0E-188D, 1.0E-190D, 1.0E-192D, 1.0E-194D, 1.0E-196D, 1.0E-198D, 1.0E-200D, 1.0E-202D, 1.0E-204D, 1.0E-206D, 1.0E-208D, 1.0E-210D, 1.0E-212D, 1.0E-214D, 1.0E-216D, 1.0E-218D, 1.0E-220D, 1.0E-222D, 1.0E-224D, 1.0E-226D, 1.0E-228D, 1.0E-230D, 1.0E-232D, 1.0E-234D, 1.0E-236D, 1.0E-238D, 1.0E-240D, 1.0E-242D, 1.0E-244D, 1.0E-246D, 1.0E-248D, 1.0E-250D, 1.0E-252D, 1.0E-254D};
    static final double[] small10pow = new double[]{1.0D, 10.0D, 100.0D, 1000.0D, 10000.0D, 100000.0D, 1000000.0D, 1.0E7D, 1.0E8D, 1.0E9D, 1.0E10D, 1.0E11D, 1.0E12D, 1.0E13D, 1.0E14D, 1.0E15D, 1.0E16D, 1.0E17D, 1.0E18D, 1.0E19D, 1.0E20D, 1.0E21D, 1.0E22D};
    static final int tablemax;
    static final double tablemaxexponent = 127.0D;
    static final double tableminexponent;
    static final int MANTISSA_SIZE = 53;
    static final int[] expdigs0;
    static final int[] expdigs1;
    static final int[] expdigs2;
    static final int[] expdigs3;
    static final int[] expdigs4;
    static final int[] expdigs5;
    static final int[] expdigs6;
    static final int[] expdigs7;
    static final int[] expdigs8;
    static final int[] expdigs9;
    static final int[] expdigs10;
    static final int[] expdigs11;
    static final int[] expdigs12;
    static final int[] expdigs13;
    static final int[] expdigs14;
    static final int[] expdigs15;
    static final int[] expdigs16;
    static final int[] expdigs17;
    static final int[] expdigs18;
    static final int[] expdigs19;
    static final int[] expdigs20;
    static final int[] expdigs21;
    static final int[] expdigs22;
    static final int[] expdigs23;
    static final int[] expdigs24;
    static final int[] expdigs25;
    static final int[] expdigs26;
    static final int[] expdigs27;
    static final int[] expdigs28;
    static final int[] expdigs29;
    static final int[] expdigs30;
    static final int[] expdigs31;
    static final int[] expdigs32;
    static final int[] expdigs33;
    static final int[] expdigs34;
    static final int[] expdigs35;
    static final int[] expdigs36;
    static final int[] expdigs37;
    static final int[] expdigs38;
    static final int[] expdigs39;
    static final int[] expdigs40;
    static final int[] expdigs41;
    static final int[] expdigs42;
    static final int[] expdigs43;
    static final int[] expdigs44;
    static final int[] expdigs45;
    static final int[] expdigs46;
    static final int[] expdigs47;
    static final int[] expdigs48;
    static final int[] expdigs49;
    static final int[] expdigs50;
    static final int[] expdigs51;
    static final int[] expdigs52;
    static final int[] expdigs53;
    static final int[] expdigs54;
    static final int[] expdigs55;
    static final int[] expdigs56;
    static final int[] expdigs57;
    static final int[] expdigs58;
    static final int[] expdigs59;
    static final int[] expdigs60;
    static final int[] expdigs61;
    static final int[] expdigs62;
    static final int[] expdigs63;
    static final int[] expdigs64;
    static final int[] expdigs65;
    static final int[] expdigs66;
    static final int[] expdigs67;
    static final int[] expdigs68;
    static final int[] expdigs69;
    static final int[] expdigs70;
    static final int[] expdigs71;
    static final int[] expdigs72;
    static final int[] expdigs73;
    static final int[] expdigs74;
    static final int[] expdigs75;
    static final int[] expdigs76;
    static final int[] expdigs77;
    static final int[] expdigs78;
    static final int[] expdigs79;
    static final int[] expdigs80;
    static final int[] expdigs81;
    static final int[] expdigs82;
    static final int[] expdigs83;
    static final int[] expdigs84;
    static final int[] expdigs85;
    static final int[] expdigs86;
    static final int[] expdigs87;
    static final int[] expdigs88;
    static final int[] expdigs89;
    static final int[] expdigs90;
    static final int[] expdigs91;
    static final int[] expdigs92;
    static final int[] expdigs93;
    static final int[] expdigs94;
    static final int[] expdigs95;
    static final int[] expdigs96;
    static final int[] expdigs97;
    static final int[] expdigs98;
    static final int[] expdigs99;
    static final int[] expdigs100;
    static final int[] expdigs101;
    static final int[] expdigs102;
    static final int[] expdigs103;
    static final int[] expdigs104;
    static final int[] expdigs105;
    static final int[] expdigs106;
    static final int[] expdigs107;
    static final int[] expdigs108;
    static final int[] expdigs109;
    static final int[] expdigs110;
    static final int[] expdigs111;
    static final int[] expdigs112;
    static final int[] expdigs113;
    static final int[] expdigs114;
    static final int[] expdigs115;
    static final int[] expdigs116;
    static final int[] expdigs117;
    static final int[] expdigs118;
    static final int[] expdigs119;
    static final int[] expdigs120;
    static final int[] expdigs121;
    static final int[] expdigs122;
    static final int[] expdigs123;
    static final int[] expdigs124;
    static final int[] expdigs125;
    static final int[] expdigs126;
    static final int[] expdigs127;
    static final int[] expdigs128;
    static final int[] expdigs129;
    static final int[] expdigs130;
    static final int[] expdigs131;
    static final int[] expdigs132;
    static final int[] expdigs133;
    static final int[] expdigs134;
    static final int[] expdigs135;
    static final int[] expdigs136;
    static final int[] expdigs137;
    static final int[] expdigs138;
    static final int[] expdigs139;
    static final int[] expdigs140;
    static final int[] expdigs141;
    static final int[] expdigs142;
    static final int[] expdigs143;
    static final int[] expdigs144;
    static final int[] expdigs145;
    static final int[] expdigs146;
    static final int[] expdigs147;
    static final int[][] expdigstable;
    static final int[] nexpdigstable;
    static final int[] binexpstable;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NumberCommonAccessor(OracleStatement var1, int var2, boolean var3) {
        super(Representation.NUMBER, var1, var2, var3);
        this.tmpBytes = new byte[this.representationMaxLength];
    }

    void init(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        this.init(var1, 6, 6, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    void init(OracleStatement var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, short var10) throws SQLException {
        this.init(var1, 6, 6, var10, false);
        this.initForDescribe(var2, var3, var4, var5, var6, var7, var8, var9, var10, (String)null);
        this.initForDataAccess(0, var3, (String)null);
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        super.initForDataAccess(var1, var2, var3);
        ++this.byteLength;
    }

    int getInt(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            byte var3 = this.tmpBytes[0];
            int var4 = 0;
            byte var5;
            byte var6;
            int var7;
            int var8;
            long var9;
            int var11;
            int var12;
            if ((var3 & -128) != 0) {
                var5 = (byte)((var3 & -129) - 65);
                var6 = (byte)(var2 - 1);
                var7 = var6 > var5 + 1 ? var5 + 2 : var6 + 1;
                var8 = var7;
                if (var5 >= 4) {
                    if (var5 > 4) {
                        this.throwOverflow();
                    }

                    var9 = 0L;
                    if (var7 > 1) {
                        var9 = (long)(this.tmpBytes[1] - 1);

                        for(var11 = 2; var11 < var8; ++var11) {
                            var9 = var9 * 100L + (long)(this.tmpBytes[var11] - 1);
                        }
                    }

                    for(var11 = var5 - var6; var11 >= 0; --var11) {
                        var9 *= 100L;
                    }

                    if (var9 > 2147483647L) {
                        this.throwOverflow();
                    }

                    var4 = (int)var9;
                } else {
                    if (var7 > 1) {
                        var4 = this.tmpBytes[1] - 1;

                        for(var12 = 2; var12 < var8; ++var12) {
                            var4 = var4 * 100 + (this.tmpBytes[var12] - 1);
                        }
                    }

                    for(var12 = var5 - var6; var12 >= 0; --var12) {
                        var4 *= 100;
                    }
                }
            } else {
                var5 = (byte)((~var3 & -129) - 65);
                var6 = (byte)(var2 - 1);
                if (var6 != 20 || this.tmpBytes[var6] == 102) {
                    --var6;
                }

                var7 = var6 > var5 + 1 ? var5 + 2 : var6 + 1;
                var8 = var7;
                if (var5 >= 4) {
                    if (var5 > 4) {
                        this.throwOverflow();
                    }

                    var9 = 0L;
                    if (var7 > 1) {
                        var9 = (long)(101 - this.tmpBytes[1]);

                        for(var11 = 2; var11 < var8; ++var11) {
                            var9 = var9 * 100L + (long)(101 - this.tmpBytes[var11]);
                        }
                    }

                    for(var11 = var5 - var6; var11 >= 0; --var11) {
                        var9 *= 100L;
                    }

                    var9 = -var9;
                    if (var9 < -2147483648L) {
                        this.throwOverflow();
                    }

                    var4 = (int)var9;
                } else {
                    if (var7 > 1) {
                        var4 = 101 - this.tmpBytes[1];

                        for(var12 = 2; var12 < var8; ++var12) {
                            var4 = var4 * 100 + (101 - this.tmpBytes[var12]);
                        }
                    }

                    for(var12 = var5 - var6; var12 >= 0; --var12) {
                        var4 *= 100;
                    }

                    var4 = -var4;
                }
            }

            return var4;
        }
    }

    boolean getBoolean(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return false;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            return var2 != 1 || this.tmpBytes[0] != -128;
        }
    }

    short getShort(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            byte var3 = this.tmpBytes[0];
            int var4 = 0;
            byte var5;
            byte var6;
            int var7;
            int var8;
            int var9;
            if ((var3 & -128) != 0) {
                var5 = (byte)((var3 & -129) - 65);
                if (var5 > 2) {
                    this.throwOverflow();
                }

                var6 = (byte)(var2 - 1);
                var7 = var6 > var5 + 1 ? var5 + 2 : var6 + 1;
                var8 = var7;
                if (var7 > 1) {
                    var4 = this.tmpBytes[1] - 1;

                    for(var9 = 2; var9 < var8; ++var9) {
                        var4 = var4 * 100 + (this.tmpBytes[var9] - 1);
                    }
                }

                for(var9 = var5 - var6; var9 >= 0; --var9) {
                    var4 *= 100;
                }

                if (var5 == 2 && var4 > 32767) {
                    this.throwOverflow();
                }
            } else {
                var5 = (byte)((~var3 & -129) - 65);
                if (var5 > 2) {
                    this.throwOverflow();
                }

                var6 = (byte)(var2 - 1);
                if (var6 != 20 || this.tmpBytes[var6] == 102) {
                    --var6;
                }

                var7 = var6 > var5 + 1 ? var5 + 2 : var6 + 1;
                var8 = var7;
                if (var7 > 1) {
                    var4 = 101 - this.tmpBytes[1];

                    for(var9 = 2; var9 < var8; ++var9) {
                        var4 = var4 * 100 + (101 - this.tmpBytes[var9]);
                    }
                }

                for(var9 = var5 - var6; var9 >= 0; --var9) {
                    var4 *= 100;
                }

                var4 = -var4;
                if (var5 == 2 && var4 < -32768) {
                    this.throwOverflow();
                }
            }

            return (short)var4;
        }
    }

    byte getByte(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            byte var3 = this.tmpBytes[0];
            int var4 = 0;
            byte var5;
            byte var6;
            if ((var3 & -128) != 0) {
                var5 = (byte)((var3 & -129) - 65);
                if (var5 > 1) {
                    this.throwOverflow();
                }

                var6 = (byte)(var2 - 1);
                if (var6 > var5 + 1) {
                    switch(var5) {
                        case -1:
                        default:
                            break;
                        case 0:
                            var4 = this.tmpBytes[1] - 1;
                            break;
                        case 1:
                            var4 = (this.tmpBytes[1] - 1) * 100 + (this.tmpBytes[2] - 1);
                            if (var4 > 127) {
                                this.throwOverflow();
                            }
                    }
                } else if (var6 == 1) {
                    if (var5 == 1) {
                        var4 = (this.tmpBytes[1] - 1) * 100;
                        if (var4 > 127) {
                            this.throwOverflow();
                        }
                    } else {
                        var4 = this.tmpBytes[1] - 1;
                    }
                } else if (var6 == 2) {
                    var4 = (this.tmpBytes[1] - 1) * 100 + (this.tmpBytes[2] - 1);
                    if (var4 > 127) {
                        this.throwOverflow();
                    }
                }
            } else {
                var5 = (byte)((~var3 & -129) - 65);
                if (var5 > 1) {
                    this.throwOverflow();
                }

                var6 = (byte)(var2 - 1);
                if (var6 != 20 || this.tmpBytes[var6] == 102) {
                    --var6;
                }

                if (var6 > var5 + 1) {
                    switch(var5) {
                        case -1:
                        default:
                            break;
                        case 0:
                            var4 = -(101 - this.tmpBytes[1]);
                            break;
                        case 1:
                            var4 = -((101 - this.tmpBytes[1]) * 100 + (101 - this.tmpBytes[2]));
                            if (var4 < -128) {
                                this.throwOverflow();
                            }
                    }
                } else if (var6 == 1) {
                    if (var5 == 1) {
                        var4 = -(101 - this.tmpBytes[1]) * 100;
                        if (var4 < -128) {
                            this.throwOverflow();
                        }
                    } else {
                        var4 = -(101 - this.tmpBytes[1]);
                    }
                } else if (var6 == 2) {
                    var4 = -((101 - this.tmpBytes[1]) * 100 + (101 - this.tmpBytes[2]));
                    if (var4 < -128) {
                        this.throwOverflow();
                    }
                }
            }

            return (byte)var4;
        }
    }

    long getLong(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0L;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            byte var3 = this.tmpBytes[0];
            long var4 = 0L;
            byte var6;
            byte var7;
            int var8;
            int var9;
            int var10;
            int var11;
            if ((var3 & -128) != 0) {
                if (var3 == -128 && var2 == 1) {
                    return 0L;
                }

                var6 = (byte)((var3 & -129) - 65);
                if (var6 > 9) {
                    this.throwOverflow();
                }

                if (var6 == 9) {
                    var8 = 1;
                    var9 = var2;
                    if (var2 > 11) {
                        var9 = 11;
                    }

                    for(; var8 < var9; ++var8) {
                        var10 = this.tmpBytes[var8] & 255;
                        var11 = MAX_LONG[var8];
                        if (var10 != var11) {
                            if (var10 < var11) {
                                break;
                            }

                            this.throwOverflow();
                        }
                    }

                    if (var8 == var9 && var2 > 11) {
                        this.throwOverflow();
                    }
                }

                var7 = (byte)(var2 - 1);
                var8 = var7 > var6 + 1 ? var6 + 2 : var7 + 1;
                var9 = var8;
                if (var8 > 1) {
                    var4 = (long)(this.tmpBytes[1] - 1);

                    for(var10 = 2; var10 < var9; ++var10) {
                        var4 = var4 * 100L + (long)(this.tmpBytes[var10] - 1);
                    }
                }

                for(var10 = var6 - var7; var10 >= 0; --var10) {
                    var4 *= 100L;
                }
            } else {
                var6 = (byte)((~var3 & -129) - 65);
                if (var6 > 9) {
                    this.throwOverflow();
                }

                if (var6 == 9) {
                    var8 = 1;
                    var9 = var2;
                    if (var2 > 12) {
                        var9 = 12;
                    }

                    for(; var8 < var9; ++var8) {
                        var10 = this.tmpBytes[var8] & 255;
                        var11 = MIN_LONG[var8];
                        if (var10 != var11) {
                            if (var10 > var11) {
                                break;
                            }

                            this.throwOverflow();
                        }
                    }

                    if (var8 == var9 && var2 < 12) {
                        this.throwOverflow();
                    }
                }

                var7 = (byte)(var2 - 1);
                if (var7 != 20 || this.tmpBytes[var7] == 102) {
                    --var7;
                }

                var8 = var7 > var6 + 1 ? var6 + 2 : var7 + 1;
                var9 = var8;
                if (var8 > 1) {
                    var4 = (long)(101 - this.tmpBytes[1]);

                    for(var10 = 2; var10 < var9; ++var10) {
                        var4 = var4 * 100L + (long)(101 - this.tmpBytes[var10]);
                    }
                }

                for(var10 = var6 - var7; var10 >= 0; --var10) {
                    var4 *= 100L;
                }

                var4 = -var4;
            }

            return var4;
        }
    }

    float getFloat(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0F;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            byte var3 = this.tmpBytes[0];
            double var5 = 0.0D;
            int var8 = 1;
            byte var4;
            int var7;
            int var11;
            if ((var3 & -128) != 0) {
                if (var3 == -128 && var2 == 1) {
                    return 0.0F;
                }

                if (var2 == 2 && var3 == -1 && this.tmpBytes[1] == 101) {
                    return (float) (1.0F / 0.0);
                }

                var4 = (byte)((var3 & -129) - 65);

                for(var11 = var2 - 1; this.tmpBytes[var8] == 1 && var11 > 0; --var4) {
                    ++var8;
                    --var11;
                }

                var7 = (int)(127.0D - (double)var4);
                switch(var11) {
                    case 1:
                        var5 = (double)(this.tmpBytes[var8] - 1) * factorTable[var7];
                        break;
                    case 2:
                        var5 = (double)((this.tmpBytes[var8] - 1) * 100 + (this.tmpBytes[var8 + 1] - 1)) * factorTable[var7 + 1];
                        break;
                    case 3:
                        var5 = (double)((this.tmpBytes[var8] - 1) * 10000 + (this.tmpBytes[var8 + 1] - 1) * 100 + (this.tmpBytes[var8 + 2] - 1)) * factorTable[var7 + 2];
                        break;
                    case 4:
                        var5 = (double)((this.tmpBytes[var8] - 1) * 1000000 + (this.tmpBytes[var8 + 1] - 1) * 10000 + (this.tmpBytes[var8 + 2] - 1) * 100 + (this.tmpBytes[var8 + 3] - 1)) * factorTable[var7 + 3];
                        break;
                    case 5:
                        var5 = (double)((this.tmpBytes[var8 + 1] - 1) * 1000000 + (this.tmpBytes[var8 + 2] - 1) * 10000 + (this.tmpBytes[var8 + 3] - 1) * 100 + (this.tmpBytes[var8 + 4] - 1)) * factorTable[var7 + 4] + (double)(this.tmpBytes[var8] - 1) * factorTable[var7];
                        break;
                    case 6:
                        var5 = (double)((this.tmpBytes[var8 + 2] - 1) * 1000000 + (this.tmpBytes[var8 + 3] - 1) * 10000 + (this.tmpBytes[var8 + 4] - 1) * 100 + (this.tmpBytes[var8 + 5] - 1)) * factorTable[var7 + 5] + (double)((this.tmpBytes[var8] - 1) * 100 + (this.tmpBytes[var8 + 1] - 1)) * factorTable[var7 + 1];
                        break;
                    default:
                        var5 = (double)((this.tmpBytes[var8 + 3] - 1) * 1000000 + (this.tmpBytes[var8 + 4] - 1) * 10000 + (this.tmpBytes[var8 + 5] - 1) * 100 + (this.tmpBytes[var8 + 6] - 1)) * factorTable[var7 + 6] + (double)((this.tmpBytes[var8] - 1) * 10000 + (this.tmpBytes[var8 + 1] - 1) * 100 + (this.tmpBytes[var8 + 2] - 1)) * factorTable[var7 + 2];
                }
            } else {
                if (var3 == 0 && var2 == 1) {
                    return (float) (-1.0F / 0.0);
                }

                var4 = (byte)((~var3 & -129) - 65);
                var11 = var2 - 1;
                if (var11 != 20 || this.tmpBytes[var11] == 102) {
                    --var11;
                }

                while(this.tmpBytes[var8] == 1 && var11 > 0) {
                    ++var8;
                    --var11;
                    --var4;
                }

                var7 = (int)(127.0D - (double)var4);
                switch(var11) {
                    case 1:
                        var5 = (double)(-(101 - this.tmpBytes[var8])) * factorTable[var7];
                        break;
                    case 2:
                        var5 = (double)(-((101 - this.tmpBytes[var8]) * 100 + (101 - this.tmpBytes[var8 + 1]))) * factorTable[var7 + 1];
                        break;
                    case 3:
                        var5 = (double)(-((101 - this.tmpBytes[var8]) * 10000 + (101 - this.tmpBytes[var8 + 1]) * 100 + (101 - this.tmpBytes[var8 + 2]))) * factorTable[var7 + 2];
                        break;
                    case 4:
                        var5 = (double)(-((101 - this.tmpBytes[var8]) * 1000000 + (101 - this.tmpBytes[var8 + 1]) * 10000 + (101 - this.tmpBytes[var8 + 2]) * 100 + (101 - this.tmpBytes[var8 + 3]))) * factorTable[var7 + 3];
                        break;
                    case 5:
                        var5 = -((double)((101 - this.tmpBytes[var8 + 1]) * 1000000 + (101 - this.tmpBytes[var8 + 2]) * 10000 + (101 - this.tmpBytes[var8 + 3]) * 100 + (101 - this.tmpBytes[var8 + 4])) * factorTable[var7 + 4] + (double)(101 - this.tmpBytes[var8]) * factorTable[var7]);
                        break;
                    case 6:
                        var5 = -((double)((101 - this.tmpBytes[var8 + 2]) * 1000000 + (101 - this.tmpBytes[var8 + 3]) * 10000 + (101 - this.tmpBytes[var8 + 4]) * 100 + (101 - this.tmpBytes[var8 + 5])) * factorTable[var7 + 5] + (double)((101 - this.tmpBytes[var8]) * 100 + (101 - this.tmpBytes[var8 + 1])) * factorTable[var7 + 1]);
                        break;
                    default:
                        var5 = -((double)((101 - this.tmpBytes[var8 + 3]) * 1000000 + (101 - this.tmpBytes[var8 + 4]) * 10000 + (101 - this.tmpBytes[var8 + 5]) * 100 + (101 - this.tmpBytes[var8 + 6])) * factorTable[var7 + 6] + (double)((101 - this.tmpBytes[var8]) * 10000 + (101 - this.tmpBytes[var8 + 1]) * 100 + (101 - this.tmpBytes[var8 + 2])) * factorTable[var7 + 2]);
                }
            }

            return (float)var5;
        }
    }

    double getDouble(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0D;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            byte var5 = this.tmpBytes[0];
            byte var7 = 1;
            int var8 = var2 - 1;
            boolean var14 = true;
            byte var6;
            int var11;
            boolean var13;
            if ((var5 & -128) != 0) {
                if (var5 == -128 && var2 == 1) {
                    return 0.0D;
                }

                if (var2 == 2 && var5 == -1 && this.tmpBytes[1] == 101) {
                    return 1.0D / 0.0;
                }

                var6 = (byte)((var5 & -129) - 65);
                var13 = (this.tmpBytes[var7 + var8 - 1] - 1) % 10 == 0;
                var11 = this.tmpBytes[var7] - 1;
            } else {
                var14 = false;
                if (var5 == 0 && var2 == 1) {
                    return -1.0D / 0.0;
                }

                var6 = (byte)((~var5 & -129) - 65);
                if (var8 != 20 || this.tmpBytes[var8] == 102) {
                    --var8;
                }

                var13 = (101 - this.tmpBytes[var7 + var8 - 1]) % 10 == 0;
                var11 = 101 - this.tmpBytes[var7];
            }

            int var12 = var8 << 1;
            if (var13) {
                --var12;
            }

            int var15 = (var6 + 1 << 1) - var12;
            if (var11 < 10) {
                --var12;
            }

            double var3;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var25;
            int var26;
            int var27;
            int var49;
            if (var12 <= 15 && (var15 >= 0 && var15 <= 37 - var12 || var15 < 0 && var15 >= -22)) {
                var49 = 0;
                var17 = 0;
                var18 = 0;
                var19 = 0;
                var20 = 0;
                var21 = 0;
                var22 = 0;
                if (var14) {
                    switch(var8) {
                        case 1:
                            break;
                        default:
                            var22 = this.tmpBytes[var7 + 7] - 1;
                        case 7:
                            var21 = this.tmpBytes[var7 + 6] - 1;
                        case 6:
                            var20 = this.tmpBytes[var7 + 5] - 1;
                        case 5:
                            var19 = this.tmpBytes[var7 + 4] - 1;
                        case 4:
                            var18 = this.tmpBytes[var7 + 3] - 1;
                        case 3:
                            var17 = this.tmpBytes[var7 + 2] - 1;
                        case 2:
                            var49 = this.tmpBytes[var7 + 1] - 1;
                    }
                } else {
                    switch(var8) {
                        case 1:
                            break;
                        default:
                            var22 = 101 - this.tmpBytes[var7 + 7];
                        case 7:
                            var21 = 101 - this.tmpBytes[var7 + 6];
                        case 6:
                            var20 = 101 - this.tmpBytes[var7 + 5];
                        case 5:
                            var19 = 101 - this.tmpBytes[var7 + 4];
                        case 4:
                            var18 = 101 - this.tmpBytes[var7 + 3];
                        case 3:
                            var17 = 101 - this.tmpBytes[var7 + 2];
                        case 2:
                            var49 = 101 - this.tmpBytes[var7 + 1];
                    }
                }

                double var50;
                if (var13) {
                    switch(var8) {
                        case 2:
                            var50 = (double)(var11 * 10 + var49 / 10);
                            break;
                        case 3:
                            var50 = (double)(var11 * 1000 + var49 * 10 + var17 / 10);
                            break;
                        case 4:
                            var50 = (double)(var11 * 100000 + var49 * 1000 + var17 * 10 + var18 / 10);
                            break;
                        case 5:
                            var50 = (double)(var11 * 10000000 + var49 * 100000 + var17 * 1000 + var18 * 10 + var19 / 10);
                            break;
                        case 6:
                            var25 = var49 * 10000000 + var17 * 100000 + var18 * 1000 + var19 * 10 + var20 / 10;
                            var50 = (double)((long)var11 * 1000000000L + (long)var25);
                            break;
                        case 7:
                            var25 = var17 * 10000000 + var18 * 100000 + var19 * 1000 + var20 * 10 + var21 / 10;
                            var26 = var11 * 100 + var49;
                            var50 = (double)((long)var26 * 1000000000L + (long)var25);
                            break;
                        case 8:
                            var25 = var18 * 10000000 + var19 * 100000 + var20 * 1000 + var21 * 10 + var22 / 10;
                            var26 = var11 * 10000 + var49 * 100 + var17;
                            var50 = (double)((long)var26 * 1000000000L + (long)var25);
                            break;
                        default:
                            var50 = (double)(var11 / 10);
                    }
                } else {
                    switch(var8) {
                        case 2:
                            var50 = (double)(var11 * 100 + var49);
                            break;
                        case 3:
                            var50 = (double)(var11 * 10000 + var49 * 100 + var17);
                            break;
                        case 4:
                            var50 = (double)(var11 * 1000000 + var49 * 10000 + var17 * 100 + var18);
                            break;
                        case 5:
                            var25 = var49 * 1000000 + var17 * 10000 + var18 * 100 + var19;
                            var50 = (double)((long)var11 * 100000000L + (long)var25);
                            break;
                        case 6:
                            var25 = var17 * 1000000 + var18 * 10000 + var19 * 100 + var20;
                            var26 = var11 * 100 + var49;
                            var50 = (double)((long)var26 * 100000000L + (long)var25);
                            break;
                        case 7:
                            var25 = var18 * 1000000 + var19 * 10000 + var20 * 100 + var21;
                            var26 = var11 * 10000 + var49 * 100 + var17;
                            var50 = (double)((long)var26 * 100000000L + (long)var25);
                            break;
                        case 8:
                            var25 = var19 * 1000000 + var20 * 10000 + var21 * 100 + var22;
                            var26 = var11 * 1000000 + var49 * 10000 + var17 * 100 + var18;
                            var50 = (double)((long)var26 * 100000000L + (long)var25);
                            break;
                        default:
                            var50 = (double)var11;
                    }
                }

                if (var15 != 0 && var50 != 0.0D) {
                    if (var15 >= 0) {
                        if (var15 <= 22) {
                            var3 = var50 * small10pow[var15];
                        } else {
                            var27 = 15 - var12;
                            var50 *= small10pow[var27];
                            var3 = var50 * small10pow[var15 - var27];
                        }
                    } else {
                        var3 = var50 / small10pow[-var15];
                    }
                } else {
                    var3 = var50;
                }
            } else {
                boolean var16 = false;
                var17 = 0;
                var18 = 0;
                var19 = 0;
                var20 = 0;
                var21 = 0;
                var22 = 0;
                int var23 = 0;
                int var24 = 0;
                var25 = 0;
                int var32 = 0;
                int var33 = 0;
                int var34 = 0;
                int var35 = 0;
                int var36 = 0;
                boolean var40 = false;
                boolean var41 = false;
                int var9;
                int var42;
                if (var14) {
                    if ((var8 & 1) != 0) {
                        var9 = 2;
                        var49 = var11;
                    } else {
                        var9 = 3;
                        var49 = var11 * 100 + (this.tmpBytes[var7 + 1] - 1);
                    }

                    for(; var9 < var8; var9 += 2) {
                        var42 = (this.tmpBytes[var7 + var9 - 1] - 1) * 100 + (this.tmpBytes[var7 + var9] - 1) + var49 * 10000;
                        switch(var25) {
                            case 0:
                                var49 = var42 & '\uffff';
                                break;
                            case 1:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                break;
                            case 2:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                break;
                            case 3:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                break;
                            case 4:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                break;
                            case 5:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                break;
                            case 6:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var22 * 10000;
                                var22 = var42 & '\uffff';
                                break;
                            case 7:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var22 * 10000;
                                var22 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var23 * 10000;
                                var23 = var42 & '\uffff';
                                break;
                            default:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var22 * 10000;
                                var22 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var23 * 10000;
                                var23 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var24 * 10000;
                                var24 = var42 & '\uffff';
                        }

                        var42 = var42 >> 16 & '\uffff';
                        if (var42 != 0) {
                            ++var25;
                            switch(var25) {
                                case 1:
                                    var17 = var42;
                                    break;
                                case 2:
                                    var18 = var42;
                                    break;
                                case 3:
                                    var19 = var42;
                                    break;
                                case 4:
                                    var20 = var42;
                                    break;
                                case 5:
                                    var21 = var42;
                                    break;
                                case 6:
                                    var22 = var42;
                                    break;
                                case 7:
                                    var23 = var42;
                                    break;
                                case 8:
                                    var24 = var42;
                            }
                        }
                    }
                } else {
                    if ((var8 & 1) != 0) {
                        var9 = 2;
                        var49 = var11;
                    } else {
                        var9 = 3;
                        var49 = var11 * 100 + (101 - this.tmpBytes[var7 + 1]);
                    }

                    for(; var9 < var8; var9 += 2) {
                        var42 = (101 - this.tmpBytes[var7 + var9 - 1]) * 100 + (101 - this.tmpBytes[var7 + var9]) + var49 * 10000;
                        switch(var25) {
                            case 0:
                                var49 = var42 & '\uffff';
                                break;
                            case 1:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                break;
                            case 2:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                break;
                            case 3:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                break;
                            case 4:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                break;
                            case 5:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                break;
                            case 6:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var22 * 10000;
                                var22 = var42 & '\uffff';
                                break;
                            case 7:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var22 * 10000;
                                var22 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var23 * 10000;
                                var23 = var42 & '\uffff';
                                break;
                            default:
                                var49 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var17 * 10000;
                                var17 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var18 * 10000;
                                var18 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var19 * 10000;
                                var19 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var20 * 10000;
                                var20 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var21 * 10000;
                                var21 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var22 * 10000;
                                var22 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var23 * 10000;
                                var23 = var42 & '\uffff';
                                var42 = (var42 >> 16 & '\uffff') + var24 * 10000;
                                var24 = var42 & '\uffff';
                        }

                        var42 = var42 >> 16 & '\uffff';
                        if (var42 != 0) {
                            ++var25;
                            switch(var25) {
                                case 1:
                                    var17 = var42;
                                    break;
                                case 2:
                                    var18 = var42;
                                    break;
                                case 3:
                                    var19 = var42;
                                    break;
                                case 4:
                                    var20 = var42;
                                    break;
                                case 5:
                                    var21 = var42;
                                    break;
                                case 6:
                                    var22 = var42;
                                    break;
                                case 7:
                                    var23 = var42;
                                    break;
                                case 8:
                                    var24 = var42;
                            }
                        }
                    }
                }

                int var39 = var25++;
                int var28 = 62 - var6 + var8;
                int var30 = nexpdigstable[var28];
                int[] var29 = expdigstable[var28];
                int var51 = var25 + 5;
                var42 = 0;
                if (var30 > var51) {
                    var42 = var30 - var51;
                    var30 = var51;
                }

                var27 = 0;
                int var31 = 0;
                int var37 = var30 - 1 + (var25 - 1) - 4;

                int var10;
                int var43;
                int var44;
                int var45;
                int var46;
                for(var26 = 0; var26 < var37; ++var26) {
                    var43 = var31 & '\uffff';
                    var31 = var31 >> 16 & '\uffff';
                    var44 = var25 < var26 + 1 ? var25 : var26 + 1;

                    for(var10 = var26 - var30 + 1 > 0 ? var26 - var30 + 1 : 0; var10 < var44; ++var10) {
                        var45 = var42 + var26 - var10;
                        switch(var10) {
                            case 1:
                                var46 = var17 * var29[var45];
                                break;
                            case 2:
                                var46 = var18 * var29[var45];
                                break;
                            case 3:
                                var46 = var19 * var29[var45];
                                break;
                            case 4:
                                var46 = var20 * var29[var45];
                                break;
                            case 5:
                                var46 = var21 * var29[var45];
                                break;
                            case 6:
                                var46 = var22 * var29[var45];
                                break;
                            case 7:
                                var46 = var23 * var29[var45];
                                break;
                            case 8:
                                var46 = var24 * var29[var45];
                                break;
                            default:
                                var46 = var49 * var29[var45];
                        }

                        var43 += var46 & '\uffff';
                        var31 += var46 >> 16 & '\uffff';
                    }

                    var40 = var40 || (var43 & '\uffff') != 0;
                    var31 += var43 >> 16 & '\uffff';
                }

                for(var37 += 5; var26 < var37; ++var26) {
                    var43 = var31 & '\uffff';
                    var31 = var31 >> 16 & '\uffff';
                    var44 = var25 < var26 + 1 ? var25 : var26 + 1;

                    for(var10 = var26 - var30 + 1 > 0 ? var26 - var30 + 1 : 0; var10 < var44; ++var10) {
                        var45 = var42 + var26 - var10;
                        switch(var10) {
                            case 1:
                                var46 = var17 * var29[var45];
                                break;
                            case 2:
                                var46 = var18 * var29[var45];
                                break;
                            case 3:
                                var46 = var19 * var29[var45];
                                break;
                            case 4:
                                var46 = var20 * var29[var45];
                                break;
                            case 5:
                                var46 = var21 * var29[var45];
                                break;
                            case 6:
                                var46 = var22 * var29[var45];
                                break;
                            case 7:
                                var46 = var23 * var29[var45];
                                break;
                            case 8:
                                var46 = var24 * var29[var45];
                                break;
                            default:
                                var46 = var49 * var29[var45];
                        }

                        var43 += var46 & '\uffff';
                        var31 += var46 >> 16 & '\uffff';
                    }

                    switch(var27++) {
                        case 1:
                            var33 = var43 & '\uffff';
                            break;
                        case 2:
                            var34 = var43 & '\uffff';
                            break;
                        case 3:
                            var35 = var43 & '\uffff';
                            break;
                        case 4:
                            var36 = var43 & '\uffff';
                            break;
                        default:
                            var32 = var43 & '\uffff';
                    }

                    var31 += var43 >> 16 & '\uffff';
                }

                while(var31 != 0) {
                    if (var27 < 5) {
                        switch(var27++) {
                            case 1:
                                var33 = var31 & '\uffff';
                                break;
                            case 2:
                                var34 = var31 & '\uffff';
                                break;
                            case 3:
                                var35 = var31 & '\uffff';
                                break;
                            case 4:
                                var36 = var31 & '\uffff';
                                break;
                            default:
                                var32 = var31 & '\uffff';
                        }
                    } else {
                        var40 = var40 || var32 != 0;
                        var32 = var33;
                        var33 = var34;
                        var34 = var35;
                        var35 = var36;
                        var36 = var31 & '\uffff';
                    }

                    var31 = var31 >> 16 & '\uffff';
                    ++var39;
                }

                int var38 = (binexpstable[var28] + var39) * 16 - 1;
                switch(var27) {
                    case 2:
                        var43 = var33;
                        break;
                    case 3:
                        var43 = var34;
                        break;
                    case 4:
                        var43 = var35;
                        break;
                    case 5:
                        var43 = var36;
                        break;
                    default:
                        var43 = var32;
                }

                for(var44 = var43 >> 1; var44 != 0; var44 >>= 1) {
                    ++var38;
                }

                var44 = 5;
                var45 = var43 << 5;
                var46 = 0;

                for(var31 = 0; (var45 & 1048576) == 0; ++var44) {
                    var45 <<= 1;
                }

                switch(var27) {
                    case 2:
                        if (var44 > 16) {
                            var45 |= var32 << var44 - 16;
                        } else if (var44 == 16) {
                            var45 |= var32;
                        } else {
                            var45 |= var32 >> 16 - var44;
                            var46 = var32 << 16 + var44;
                        }
                        break;
                    case 3:
                        if (var44 > 16) {
                            var45 |= var33 << var44 - 16 | var32 >> 32 - var44;
                            var46 = var32 << var44;
                        } else if (var44 == 16) {
                            var45 |= var33;
                            var46 = var32 << 16;
                        } else {
                            var45 |= var33 >> 16 - var44;
                            var46 = var33 << 16 + var44;
                            var46 |= var32 << var44;
                        }
                        break;
                    case 4:
                        if (var44 > 16) {
                            var45 |= var34 << var44 - 16 | var33 >> 32 - var44;
                            var46 = var33 << var44 | var32 << var44 - 16;
                        } else if (var44 == 16) {
                            var45 |= var34;
                            var46 = var33 << 16 | var32;
                        } else {
                            var45 |= var34 >> 16 - var44;
                            var46 = var34 << 16 + var44 | var33 << var44 | var32 >> 16 - var44;
                            var31 = var32 & 1 << 15 - var44;
                            if (var44 < 15) {
                                var40 = var40 || var32 << var44 + 17 != 0;
                            }
                        }
                        break;
                    case 5:
                        if (var44 > 16) {
                            var45 |= var35 << var44 - 16 | var34 >> 32 - var44;
                            var46 = var34 << var44 | var33 << var44 - 16 | var32 >> 32 - var44;
                            var31 = var32 & 1 << 31 - var44;
                            var40 = var40 || var32 << var44 + 1 != 0;
                        } else if (var44 == 16) {
                            var45 |= var35;
                            var46 = var34 << 16 | var33;
                            var31 = var32 & '耀';
                            var40 = var40 || (var32 & 32767) != 0;
                        } else {
                            var45 |= var35 >> 16 - var44;
                            var46 = var35 << 16 + var44 | var34 << var44 | var33 >> 16 - var44;
                            var31 = var33 & 1 << 15 - var44;
                            if (var44 < 15) {
                                var40 = var40 || var33 << var44 + 17 != 0;
                            }

                            var40 = var40 || var32 != 0;
                        }
                }

                if (var31 != 0 && (var40 || (var46 & 1) != 0)) {
                    if (var46 == -1) {
                        var46 = 0;
                        ++var45;
                        if ((var45 & 2097152) != 0) {
                            var46 = var46 >> 1 | var45 << 31;
                            var45 >>= 1;
                            ++var38;
                        }
                    } else {
                        ++var46;
                    }
                }

                long var47 = (long)var38 << 52 | (long)(var45 & 1048575) << 32 | (long)var46 & 4294967295L;
                var3 = Double.longBitsToDouble(var47);
            }

            return var14 ? var3 : -var3;
        }
    }

    double getDoubleImprecise(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0D;
        } else {
            int var2 = this.getLength(var1);
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);
            byte var3 = this.tmpBytes[0];
            double var5 = 0.0D;
            byte var8 = 1;
            byte var4;
            int var7;
            int var9;
            int var11;
            if ((var3 & -128) != 0) {
                if (var3 == -128 && var2 == 1) {
                    return 0.0D;
                }

                if (var2 == 2 && var3 == -1 && this.tmpBytes[1] == 101) {
                    return 1.0D / 0.0;
                }

                var4 = (byte)((var3 & -129) - 65);
                var11 = var2 - 1;
                var7 = (int)(127.0D - (double)var4);
                var9 = var11 % 4;
                switch(var9) {
                    case 1:
                        var5 = (double)(this.tmpBytes[var8] - 1) * factorTable[var7];
                        break;
                    case 2:
                        var5 = (double)((this.tmpBytes[var8] - 1) * 100 + (this.tmpBytes[var8 + 1] - 1)) * factorTable[var7 + 1];
                        break;
                    case 3:
                        var5 = (double)((this.tmpBytes[var8] - 1) * 10000 + (this.tmpBytes[var8 + 1] - 1) * 100 + (this.tmpBytes[var8 + 2] - 1)) * factorTable[var7 + 2];
                }

                while(var9 < var11) {
                    var5 += (double)((this.tmpBytes[var8 + var9] - 1) * 1000000 + (this.tmpBytes[var8 + var9 + 1] - 1) * 10000 + (this.tmpBytes[var8 + var9 + 2] - 1) * 100 + (this.tmpBytes[var8 + var9 + 3] - 1)) * factorTable[var7 + var9 + 3];
                    var9 += 4;
                }
            } else {
                if (var3 == 0 && var2 == 1) {
                    return -1.0D / 0.0;
                }

                var4 = (byte)((~var3 & -129) - 65);
                var11 = var2 - 1;
                if (var11 != 20 || this.tmpBytes[var11] == 102) {
                    --var11;
                }

                var7 = (int)(127.0D - (double)var4);
                var9 = var11 % 4;
                switch(var9) {
                    case 1:
                        var5 = (double)(101 - this.tmpBytes[var8]) * factorTable[var7];
                        break;
                    case 2:
                        var5 = (double)((101 - this.tmpBytes[var8]) * 100 + (101 - this.tmpBytes[var8 + 1])) * factorTable[var7 + 1];
                        break;
                    case 3:
                        var5 = (double)((101 - this.tmpBytes[var8]) * 10000 + (101 - this.tmpBytes[var8 + 1]) * 100 + (101 - this.tmpBytes[var8 + 2])) * factorTable[var7 + 2];
                }

                while(var9 < var11) {
                    var5 += (double)((101 - this.tmpBytes[var8 + var9]) * 1000000 + (101 - this.tmpBytes[var8 + var9 + 1]) * 10000 + (101 - this.tmpBytes[var8 + var9 + 2]) * 100 + (101 - this.tmpBytes[var8 + var9 + 3])) * factorTable[var7 + var9 + 3];
                    var9 += 4;
                }

                var5 = -var5;
            }

            return var5;
        }
    }

    BigDecimal getBigDecimal(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            int var2 = this.getLength(var1);

            assert var2 > 0 : "Length not positive";

            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, var2);

            int var3;
            for(var3 = 0; var3 < 27; ++var3) {
                this.digs[var3] = 0;
            }

            boolean var21 = false;
            byte var4 = 1;
            byte var6 = 26;
            boolean var7 = false;
            byte var10 = this.tmpBytes[0];
            boolean var15 = false;
            int var5;
            int var9;
            byte var11;
            byte var12;
            int var13;
            byte var22;
            if ((var10 & -128) != 0) {
                if (var10 == -128 && var2 == 1) {
                    return BIGDEC_ZERO;
                }

                if (var2 == 2 && var10 == -1 && this.tmpBytes[1] == 101) {
                    this.throwOverflow();
                }

                var11 = 1;
                var12 = (byte)((var10 & -129) - 65);
                var9 = var2 - 1;
                var5 = var9 - 1;
                var13 = var12 - var9 + 1 << 1;
                if (var13 > 0) {
                    var13 = 0;
                    var5 = var12;
                } else if (var13 < 0) {
                    var15 = (this.tmpBytes[var9] - 1) % 10 == 0;
                }

                var22 = (byte)(var4 + 1);

                for(var3 = this.tmpBytes[var4] - 1; (var5 & 1) != 0; --var5) {
                    if (var22 > var9) {
                        var3 *= 100;
                    } else {
                        var3 = var3 * 100 + (this.tmpBytes[var22++] - 1);
                    }
                }
            } else {
                if (var10 == 0 && var2 == 1) {
                    this.throwOverflow();
                }

                var11 = -1;
                var12 = (byte)((~var10 & -129) - 65);
                var9 = var2 - 1;
                if (var9 != 20 || this.tmpBytes[var9] == 102) {
                    --var9;
                }

                var5 = var9 - 1;
                var13 = var12 - var9 + 1 << 1;
                if (var13 > 0) {
                    var13 = 0;
                    var5 = var12;
                } else if (var13 < 0) {
                    var15 = (101 - this.tmpBytes[var9]) % 10 == 0;
                }

                var22 = (byte)(var4 + 1);

                for(var3 = 101 - this.tmpBytes[var4]; (var5 & 1) != 0; --var5) {
                    if (var22 > var9) {
                        var3 *= 100;
                    } else {
                        var3 = var3 * 100 + (101 - this.tmpBytes[var22++]);
                    }
                }
            }

            if (var15) {
                ++var13;
                var3 /= 10;
            }

            for(int var14 = var9 - 1; var5 != 0; var5 -= 2) {
                int var16;
                int var23;
                if (var11 == 1) {
                    if (var15) {
                        var23 = (this.tmpBytes[var22 - 1] - 1) % 10 * 1000 + (this.tmpBytes[var22] - 1) * 10 + (this.tmpBytes[var22 + 1] - 1) / 10 + var3 * 10000;
                        var22 = (byte)(var22 + 2);
                    } else if (var22 < var14) {
                        var23 = (this.tmpBytes[var22] - 1) * 100 + (this.tmpBytes[var22 + 1] - 1) + var3 * 10000;
                        var22 = (byte)(var22 + 2);
                    } else {
                        var23 = 0;
                        if (var22 <= var9) {
                            for(var16 = 0; var22 <= var9; ++var16) {
                                var23 = var23 * 100 + (this.tmpBytes[var22++] - 1);
                            }

                            while(var16 < 2) {
                                var23 *= 100;
                                ++var16;
                            }
                        }

                        var23 += var3 * 10000;
                    }
                } else if (var15) {
                    var23 = (101 - this.tmpBytes[var22 - 1]) % 10 * 1000 + (101 - this.tmpBytes[var22]) * 10 + (101 - this.tmpBytes[var22 + 1]) / 10 + var3 * 10000;
                    var22 = (byte)(var22 + 2);
                } else if (var22 < var14) {
                    var23 = (101 - this.tmpBytes[var22]) * 100 + (101 - this.tmpBytes[var22 + 1]) + var3 * 10000;
                    var22 = (byte)(var22 + 2);
                } else {
                    var23 = 0;
                    if (var22 <= var9) {
                        for(var16 = 0; var22 <= var9; ++var16) {
                            var23 = var23 * 100 + (101 - this.tmpBytes[var22++]);
                        }

                        while(var16 < 2) {
                            var23 *= 100;
                            ++var16;
                        }
                    }

                    var23 += var3 * 10000;
                }

                var3 = var23 & '\uffff';

                for(var16 = 25; var16 >= var6; --var16) {
                    var23 = (var23 >> 16) + this.digs[var16] * 10000;
                    this.digs[var16] = var23 & '\uffff';
                }

                if (var6 > 0) {
                    var23 >>= 16;
                    if (var23 != 0) {
                        --var6;
                        this.digs[var6] = var23;
                    }
                }
            }

            this.digs[26] = var3;
            byte var17 = (byte)(this.digs[var6] >> 8 & 255);
            int var8;
            int var18;
            int var19;
            byte[] var24;
            if (var17 == 0) {
                var8 = 53 - (var6 << 1);
                var24 = new byte[var8];

                for(var18 = 26; var18 > var6; --var18) {
                    var19 = var18 - var6 << 1;
                    var24[var19 - 1] = (byte)(this.digs[var18] >> 8 & 255);
                    var24[var19] = (byte)(this.digs[var18] & 255);
                }

                var24[0] = (byte)(this.digs[var6] & 255);
            } else {
                var8 = 54 - (var6 << 1);
                var24 = new byte[var8];

                for(var18 = 26; var18 > var6; --var18) {
                    var19 = var18 - var6 << 1;
                    var24[var19] = (byte)(this.digs[var18] >> 8 & 255);
                    var24[var19 + 1] = (byte)(this.digs[var18] & 255);
                }

                var24[0] = var17;
                var24[1] = (byte)(this.digs[var6] & 255);
            }

            if (var13 == 0 && var8 < 8 && var8 > 0) {
                long var26 = (long)var24[0] & 255L;

                for(int var20 = 1; var20 < var8; ++var20) {
                    var26 = var26 << 8 | (long)(var24[var20] & 255);
                }

                var26 *= (long)var11;
                return new BigDecimal(var26);
            } else {
                BigInteger var25 = new BigInteger(var11, var24);
                return new BigDecimal(var25, -var13);
            }
        }
    }

    BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        return this.isNull(var1) ? null : this.getBigDecimal(var1).setScale(var2, 6);
    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = this.getBytesInternal(var1);
            int var3 = var2.length;
            NUMBER var4 = new NUMBER(var2);
            String var5 = oracle.sql.NUMBER.toString(var2);
            int var6 = var5.length();
            if (var5.startsWith("0.") || var5.startsWith("-0.")) {
                --var6;
            }

            String var7;
            if (var6 > 38) {
                var5 = var4.toText(-44, (String)null);
                int var8 = var5.indexOf(69);
                int var9 = var5.indexOf(43);
                if (var8 == -1) {
                    var8 = var5.indexOf(101);
                }

                int var10;
                for(var10 = var8 - 1; var5.charAt(var10) == '0'; --var10) {
                }

                String var11 = var5.substring(0, var10 + 1);
                String var12 = null;
                if (var9 > 0) {
                    var12 = var5.substring(var9 + 1);
                } else {
                    var12 = var5.substring(var8 + 1);
                }

                var7 = (var11 + "E" + var12).trim();
            } else {
                var7 = var4.toText(38, (String)null).trim();
            }

            if (var7.startsWith("-.")) {
                return "-0" + var7.substring(1);
            } else {
                return var7.startsWith(".") ? "0" + var7 : var7;
            }
        }
    }

    NUMBER getNUMBER(int var1) throws SQLException {
        return this.isNull(var1) ? null : new NUMBER(this.getBytesInternal(var1));
    }

    Object getObject(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Object var2 = null;
            if (this.externalType != 0) {
                switch(this.externalType) {
                    case -7:
                        return this.getBoolean(var1);
                    case -6:
                        return this.getByte(var1);
                    case -5:
                        return this.getLong(var1);
                    case -4:
                    case -3:
                    case -2:
                    case -1:
                    case 0:
                    case 1:
                    default:
                        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                        var3.fillInStackTrace();
                        throw var3;
                    case 2:
                    case 3:
                        return this.getBigDecimal(var1);
                    case 4:
                        return this.getInt(var1);
                    case 5:
                        return this.getShort(var1);
                    case 6:
                    case 8:
                        return this.getDouble(var1);
                    case 7:
                        return this.getFloat(var1);
                }
            } else {
                if (this.statement.connection.j2ee13Compliant && this.precision != 0 && this.scale == -127) {
                    var2 = new Double(this.getDouble(var1));
                } else {
                    var2 = this.getBigDecimal(var1);
                }

                return var2;
            }
        }
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getObject(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getNUMBER(var1);
    }

    byte[] getBytes(int var1) throws SQLException {
        return this.isNull(var1) ? null : this.getBytesInternal(var1);
    }

    void throwOverflow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 26);
        var1.fillInStackTrace();
        throw var1;
    }

    static {
        tablemax = factorTable.length;
        tableminexponent = 127.0D - (double)(tablemax - 20);
        expdigs0 = new int[]{25597, 55634, 18440, 18324, 42485, 50370, 56862, 11593, 45703, 57341, 10255, 12549, 59579, 5};
        expdigs1 = new int[]{50890, 19916, 24149, 23777, 11324, 41057, 14921, 56274, 30917, 19462, 54968, 47943, 38791, 3872};
        expdigs2 = new int[]{24101, 29690, 40218, 29073, 29604, 22037, 27674, 9082, 56670, 55244, 20865, 54874, 47573, 38};
        expdigs3 = new int[]{22191, 40873, 1607, 45622, 23883, 24544, 32988, 43530, 61694, 55616, 43150, 32976, 27418, 25379};
        expdigs4 = new int[]{55927, 44317, 6569, 54851, 238, 63160, 51447, 12231, 55667, 25459, 5674, 40962, 52047, 253};
        expdigs5 = new int[]{56264, 8962, 51839, 64773, 39323, 49783, 15587, 30924, 36601, 56615, 27581, 36454, 35254, 2};
        expdigs6 = new int[]{21545, 25466, 59727, 37873, 13099, 7602, 15571, 49963, 37664, 46896, 14328, 59258, 17403, 1663};
        expdigs7 = new int[]{12011, 4842, 3874, 57395, 38141, 46606, 49307, 60792, 31833, 21440, 9318, 47123, 41461, 16};
        expdigs8 = new int[]{52383, 25023, 56409, 43947, 51036, 17420, 62725, 5735, 53692, 44882, 64439, 36137, 24719, 10900};
        expdigs9 = new int[]{65404, 27119, 57580, 26653, 42453, 19179, 26186, 42000, 1847, 62708, 14406, 12813, 247, 109};
        expdigs10 = new int[]{36698, 50078, 40552, 35000, 49576, 56552, 261, 49572, 31475, 59609, 45363, 46658, 5900, 1};
        expdigs11 = new int[]{33321, 54106, 42443, 60698, 47535, 24088, 45785, 18352, 47026, 40291, 5183, 35843, 24059, 714};
        expdigs12 = new int[]{12129, 44450, 22706, 34030, 37175, 8760, 31915, 56544, 23407, 52176, 7260, 41646, 9415, 7};
        expdigs13 = new int[]{43054, 17160, 43698, 6780, 36385, 52800, 62346, 52747, 33988, 2855, 31979, 38083, 44325, 4681};
        expdigs14 = new int[]{60723, 40803, 16165, 19073, 2985, 9703, 41911, 37227, 41627, 1994, 38986, 27250, 53527, 46};
        expdigs15 = new int[]{36481, 57623, 45627, 58488, 53274, 7238, 2063, 31221, 62631, 25319, 35409, 25293, 54667, 30681};
        expdigs16 = new int[]{52138, 47106, 3077, 4517, 41165, 38738, 39997, 10142, 13078, 16637, 53438, 54647, 53630, 306};
        expdigs17 = new int[]{25425, 24719, 55736, 8564, 12208, 3664, 51518, 17140, 61079, 30312, 2500, 30693, 4468, 3};
        expdigs18 = new int[]{58368, 65134, 52675, 3178, 26300, 7986, 11833, 515, 23109, 63525, 29138, 19030, 50114, 2010};
        expdigs19 = new int[]{41216, 15724, 12323, 26246, 59245, 58406, 46648, 13767, 11372, 15053, 61895, 48686, 7054, 20};
        expdigs20 = new int[]{0, 29248, 62416, 1433, 14025, 43846, 39905, 44375, 137, 47955, 62409, 33386, 48983, 13177};
        expdigs21 = new int[]{0, 21264, 53708, 60962, 25043, 64008, 31200, 50906, 9831, 56185, 43877, 36378, 50952, 131};
        expdigs22 = new int[]{0, 50020, 25440, 60247, 44814, 39961, 6865, 26068, 34832, 9081, 17478, 44928, 20825, 1};
        expdigs23 = new int[]{0, 0, 52929, 10084, 25506, 6346, 61348, 31525, 52689, 61296, 27615, 15903, 40426, 863};
        expdigs24 = new int[]{0, 16384, 24122, 53840, 43508, 13170, 51076, 37670, 58198, 31414, 57292, 61762, 41691, 8};
        expdigs25 = new int[]{0, 0, 4096, 29077, 42481, 30581, 10617, 59493, 46251, 1892, 5557, 4505, 52391, 5659};
        expdigs26 = new int[]{0, 0, 58368, 11431, 1080, 29797, 47947, 36639, 42405, 50481, 29546, 9875, 39190, 56};
        expdigs27 = new int[]{0, 0, 0, 57600, 63028, 53094, 12749, 18174, 21993, 48265, 14922, 59933, 4030, 37092};
        expdigs28 = new int[]{0, 0, 0, 576, 1941, 35265, 9302, 42780, 50682, 28007, 29640, 28124, 60333, 370};
        expdigs29 = new int[]{0, 0, 0, 5904, 8539, 12149, 36793, 43681, 12958, 60573, 21267, 35015, 46478, 3};
        expdigs30 = new int[]{0, 0, 0, 0, 7268, 50548, 47962, 3644, 22719, 26999, 41893, 7421, 56711, 2430};
        expdigs31 = new int[]{0, 0, 0, 0, 7937, 49002, 60772, 28216, 38893, 55975, 63988, 59711, 20227, 24};
        expdigs32 = new int[]{0, 0, 0, 16384, 38090, 63404, 55657, 8801, 62648, 13666, 57656, 60234, 15930};
        expdigs33 = new int[]{0, 0, 0, 4096, 37081, 37989, 16940, 55138, 17665, 39458, 9751, 20263, 159};
        expdigs34 = new int[]{0, 0, 0, 58368, 35104, 16108, 61773, 14313, 30323, 54789, 57113, 38868, 1};
        expdigs35 = new int[]{0, 0, 0, 8448, 18701, 29652, 51080, 65023, 27172, 37903, 3192, 1044};
        expdigs36 = new int[]{0, 0, 0, 37440, 63101, 2917, 39177, 50457, 25830, 50186, 28867, 10};
        expdigs37 = new int[]{0, 0, 0, 56080, 45850, 37384, 3668, 12301, 38269, 18196, 6842};
        expdigs38 = new int[]{0, 0, 0, 46436, 13565, 50181, 34770, 37478, 5625, 27707, 68};
        expdigs39 = new int[]{0, 0, 0, 32577, 45355, 38512, 38358, 3651, 36101, 44841};
        expdigs40 = new int[]{0, 0, 16384, 28506, 5696, 56746, 15456, 50499, 27230, 448};
        expdigs41 = new int[]{0, 0, 4096, 285, 9232, 58239, 57170, 38515, 31729, 4};
        expdigs42 = new int[]{0, 0, 58368, 41945, 57108, 12378, 28752, 48226, 2938};
        expdigs43 = new int[]{0, 0, 24832, 47605, 49067, 23716, 61891, 25385, 29};
        expdigs44 = new int[]{0, 0, 8768, 2442, 50298, 23174, 19624, 19259};
        expdigs45 = new int[]{0, 0, 40720, 45899, 1813, 31689, 38862, 192};
        expdigs46 = new int[]{0, 0, 36452, 14221, 34752, 48813, 60681, 1};
        expdigs47 = new int[]{0, 0, 61313, 34220, 16731, 11629, 1262};
        expdigs48 = new int[]{0, 16384, 60906, 18036, 40144, 40748, 12};
        expdigs49 = new int[]{0, 4096, 609, 15909, 52830, 8271};
        expdigs50 = new int[]{0, 58368, 3282, 56520, 47058, 82};
        expdigs51 = new int[]{0, 41216, 52461, 7118, 54210};
        expdigs52 = new int[]{0, 45632, 51642, 6624, 542};
        expdigs53 = new int[]{0, 25360, 24109, 27591, 5};
        expdigs54 = new int[]{0, 42852, 46771, 3552};
        expdigs55 = new int[]{0, 28609, 34546, 35};
        expdigs56 = new int[]{16384, 4218, 23283};
        expdigs57 = new int[]{4096, 54437, 232};
        expdigs58 = new int[]{58368, 21515, 2};
        expdigs59 = new int[]{57600, 1525};
        expdigs60 = new int[]{16960, 15};
        expdigs61 = new int[]{10000};
        expdigs62 = new int[]{100};
        expdigs63 = new int[]{1};
        expdigs64 = new int[]{36700, 62914, 23592, 49807, 10485, 36700, 62914, 23592, 49807, 10485, 36700, 62914, 23592, 655};
        expdigs65 = new int[]{14784, 18979, 33659, 19503, 2726, 9542, 629, 2202, 40475, 10590, 4299, 47815, 36280, 6};
        expdigs66 = new int[]{16332, 9978, 33613, 31138, 35584, 64252, 13857, 14424, 62281, 46279, 36150, 46573, 63392, 4294};
        expdigs67 = new int[]{6716, 24348, 22618, 23904, 21327, 3919, 44703, 19149, 28803, 48959, 6259, 50273, 62237, 42};
        expdigs68 = new int[]{8471, 23660, 38254, 26440, 33662, 38879, 9869, 11588, 41479, 23225, 60127, 24310, 32615, 28147};
        expdigs69 = new int[]{13191, 6790, 63297, 30410, 12788, 42987, 23691, 28296, 32527, 38898, 41233, 4830, 31128, 281};
        expdigs70 = new int[]{4064, 53152, 62236, 29139, 46658, 12881, 31694, 4870, 19986, 24637, 9587, 28884, 53395, 2};
        expdigs71 = new int[]{26266, 10526, 16260, 55017, 35680, 40443, 19789, 17356, 30195, 55905, 28426, 63010, 44197, 1844};
        expdigs72 = new int[]{38273, 7969, 37518, 26764, 23294, 63974, 18547, 17868, 24550, 41191, 17323, 53714, 29277, 18};
        expdigs73 = new int[]{16739, 37738, 38090, 26589, 43521, 1543, 15713, 10671, 11975, 41533, 18106, 9348, 16921, 12089};
        expdigs74 = new int[]{14585, 61981, 58707, 16649, 25994, 39992, 28337, 17801, 37475, 22697, 31638, 16477, 58496, 120};
        expdigs75 = new int[]{58472, 2585, 40564, 27691, 44824, 27269, 58610, 54572, 35108, 30373, 35050, 10650, 13692, 1};
        expdigs76 = new int[]{50392, 58911, 41968, 49557, 29112, 29939, 43526, 63500, 55595, 27220, 25207, 38361, 18456, 792};
        expdigs77 = new int[]{26062, 32046, 3696, 45060, 46821, 40931, 50242, 60272, 24148, 20588, 6150, 44948, 60477, 7};
        expdigs78 = new int[]{12430, 30407, 320, 41980, 58777, 41755, 41041, 13609, 45167, 13348, 40838, 60354, 19454, 5192};
        expdigs79 = new int[]{30926, 26518, 13110, 43018, 54982, 48258, 24658, 15209, 63366, 11929, 20069, 43857, 60487, 51};
        expdigs80 = new int[]{51263, 54048, 48761, 48627, 30576, 49046, 4414, 61195, 61755, 48474, 19124, 55906, 15511, 34028};
        expdigs81 = new int[]{39834, 11681, 47018, 3107, 64531, 54229, 41331, 41899, 51735, 42427, 59173, 13010, 18505, 340};
        expdigs82 = new int[]{27268, 6670, 31272, 9861, 45865, 10372, 12865, 62678, 23454, 35158, 20252, 29621, 26399, 3};
        expdigs83 = new int[]{57738, 46147, 66, 48154, 11239, 21430, 55809, 46003, 15044, 25138, 52780, 48043, 4883, 2230};
        expdigs84 = new int[]{20893, 62065, 64225, 52254, 59094, 55919, 60195, 5702, 48647, 50058, 7736, 41768, 19709, 22};
        expdigs85 = new int[]{37714, 32321, 45840, 36031, 33290, 47121, 5146, 28127, 9887, 25390, 52929, 2698, 1073, 14615};
        expdigs86 = new int[]{35111, 8187, 18153, 56721, 40309, 59453, 51824, 4868, 45974, 3530, 43783, 8546, 9841, 146};
        expdigs87 = new int[]{23288, 61030, 42779, 19572, 29894, 47780, 45082, 32816, 43713, 33458, 25341, 63655, 30244, 1};
        expdigs88 = new int[]{58138, 33000, 62869, 37127, 61799, 298, 46353, 5693, 63898, 62040, 989, 23191, 53065, 957};
        expdigs89 = new int[]{42524, 32442, 36673, 15444, 22900, 658, 61412, 32824, 21610, 64190, 1975, 11373, 37886, 9};
        expdigs90 = new int[]{26492, 4357, 32437, 10852, 34233, 53968, 55056, 34692, 64553, 38226, 41929, 21646, 6667, 6277};
        expdigs91 = new int[]{61213, 698, 16053, 50571, 2963, 50347, 13657, 48188, 46520, 19387, 33187, 25775, 50529, 62};
        expdigs92 = new int[]{42864, 54351, 45226, 20476, 23443, 17724, 3780, 44701, 52910, 23402, 28374, 46862, 40234, 41137};
        expdigs93 = new int[]{23366, 62147, 58123, 44113, 55284, 39498, 3314, 9622, 9704, 27759, 25187, 43722, 24650, 411};
        expdigs94 = new int[]{38899, 44530, 19586, 37141, 1863, 9570, 32801, 31553, 51870, 62536, 51369, 30583, 7455, 4};
        expdigs95 = new int[]{10421, 4321, 43699, 3472, 65252, 17057, 13858, 29819, 14733, 21490, 40602, 31315, 65186, 2695};
        expdigs96 = new int[]{6002, 54438, 29272, 34113, 17036, 25074, 36183, 953, 25051, 12011, 20722, 4245, 62911, 26};
        expdigs97 = new int[]{14718, 45935, 8408, 42891, 21312, 56531, 44159, 45581, 20325, 36295, 35509, 24455, 30844, 17668};
        expdigs98 = new int[]{54542, 45023, 23021, 3050, 31015, 20881, 50904, 40432, 33626, 14125, 44264, 60537, 44872, 176};
        expdigs99 = new int[]{60183, 8969, 14648, 17725, 11451, 50016, 34587, 46279, 19341, 42084, 16826, 5848, 50256, 1};
        expdigs100 = new int[]{64999, 53685, 60382, 19151, 25736, 5357, 31302, 23283, 14225, 52622, 56781, 39489, 60351, 1157};
        expdigs101 = new int[]{1305, 4469, 39270, 18541, 63827, 59035, 54707, 16616, 32910, 48367, 64137, 2360, 37959, 11};
        expdigs102 = new int[]{45449, 32125, 19705, 56098, 51958, 5225, 18285, 13654, 9341, 25888, 50946, 26855, 36068, 7588};
        expdigs103 = new int[]{27324, 53405, 43450, 25464, 3796, 3329, 46058, 53220, 26307, 53998, 33932, 23861, 58032, 75};
        expdigs104 = new int[]{63080, 50735, 1844, 21406, 57926, 63607, 24936, 52889, 23469, 64488, 539, 8859, 21210, 49732};
        expdigs105 = new int[]{62890, 39828, 3950, 32982, 39245, 21607, 40226, 50991, 18584, 10475, 59643, 40720, 21183, 497};
        expdigs106 = new int[]{37329, 64623, 11835, 985, 46923, 48712, 28582, 21481, 28366, 41392, 13703, 49559, 63781, 4};
        expdigs107 = new int[]{3316, 60011, 41933, 47959, 54404, 39790, 12283, 941, 46090, 42226, 18108, 38803, 16879, 3259};
        expdigs108 = new int[]{46563, 56305, 5006, 45044, 49040, 12849, 778, 6563, 46336, 3043, 7390, 2354, 38835, 32};
        expdigs109 = new int[]{28653, 3742, 33331, 2671, 39772, 29981, 56489, 1973, 26280, 26022, 56391, 56434, 57039, 21359};
        expdigs110 = new int[]{9461, 17732, 7542, 26241, 8917, 24548, 61513, 13126, 59245, 41547, 1874, 41852, 39236, 213};
        expdigs111 = new int[]{36794, 22459, 63645, 14024, 42032, 53329, 25518, 11272, 18287, 20076, 62933, 3039, 8912, 2};
        expdigs112 = new int[]{14926, 15441, 32337, 42579, 26354, 35154, 22815, 36955, 12564, 8047, 856, 41917, 55080, 1399};
        expdigs113 = new int[]{8668, 50617, 10153, 17465, 1574, 28532, 15301, 58041, 38791, 60373, 663, 29255, 65431, 13};
        expdigs114 = new int[]{21589, 32199, 24754, 45321, 9349, 26230, 35019, 37508, 20896, 42986, 31405, 12458, 65173, 9173};
        expdigs115 = new int[]{46746, 1632, 61196, 50915, 64318, 41549, 2971, 23968, 59191, 58756, 61917, 779, 48493, 91};
        expdigs116 = new int[]{1609, 63382, 15744, 15685, 51627, 56348, 33838, 52458, 44148, 11077, 56293, 41906, 45227, 60122};
        expdigs117 = new int[]{19676, 45198, 6055, 38823, 8380, 49060, 17377, 58196, 43039, 21737, 59545, 12870, 14870, 601};
        expdigs118 = new int[]{4128, 2418, 28241, 13495, 26298, 3767, 31631, 5169, 8950, 27087, 56956, 4060, 804, 6};
        expdigs119 = new int[]{39930, 40673, 19029, 54677, 38145, 23200, 41325, 24564, 24955, 54484, 23863, 52998, 13147, 3940};
        expdigs120 = new int[]{3676, 24655, 34924, 27416, 23974, 887, 10899, 4833, 21221, 28725, 19899, 57546, 26345, 39};
        expdigs121 = new int[]{28904, 41324, 18596, 42292, 12070, 52013, 30810, 61057, 55753, 32324, 38953, 6752, 32688, 25822};
        expdigs122 = new int[]{42232, 26627, 2807, 27948, 50583, 49016, 32420, 64180, 3178, 3600, 21361, 52496, 14744, 258};
        expdigs123 = new int[]{2388, 59904, 28863, 7488, 31963, 8354, 47510, 15059, 2653, 58363, 31670, 21496, 38158, 2};
        expdigs124 = new int[]{50070, 5266, 26158, 10774, 15148, 6873, 30230, 33898, 63720, 51799, 4515, 50124, 19875, 1692};
        expdigs125 = new int[]{54240, 3984, 12058, 2729, 13914, 11865, 38313, 39660, 10467, 20834, 36745, 57517, 60491, 16};
        expdigs126 = new int[]{5387, 58214, 9214, 13883, 14445, 34873, 21745, 13490, 23334, 25008, 58535, 19372, 44484, 11090};
        expdigs127 = new int[]{27578, 64807, 12543, 794, 13907, 61297, 12013, 64360, 15961, 20566, 24178, 15922, 59427, 110};
        expdigs128 = new int[]{49427, 41935, 46000, 59645, 45358, 51075, 15848, 32756, 38170, 14623, 35631, 57175, 7147, 1};
        expdigs129 = new int[]{33941, 39160, 55469, 45679, 22878, 60091, 37210, 18508, 1638, 57398, 65026, 41643, 54966, 726};
        expdigs130 = new int[]{60632, 24639, 41842, 62060, 20544, 59583, 52800, 1495, 48513, 43827, 10480, 1727, 17589, 7};
        expdigs131 = new int[]{5590, 60244, 53985, 26632, 53049, 33628, 58267, 54922, 21641, 62744, 58109, 2070, 26887, 4763};
        expdigs132 = new int[]{62970, 37957, 34618, 29757, 24123, 2302, 17622, 58876, 44780, 6525, 33349, 36065, 41556, 47};
        expdigs133 = new int[]{1615, 24878, 20040, 11487, 23235, 27766, 59005, 57847, 60881, 11588, 63635, 61281, 31817, 31217};
        expdigs134 = new int[]{14434, 2870, 65081, 44023, 40864, 40254, 47120, 6476, 32066, 23053, 17020, 19618, 11459, 312};
        expdigs135 = new int[]{43398, 40005, 36695, 8304, 12205, 16131, 42414, 38075, 63890, 2851, 61774, 59833, 7978, 3};
        expdigs136 = new int[]{56426, 22060, 15473, 31824, 19088, 38788, 64386, 12875, 35770, 65519, 11824, 19623, 56959, 2045};
        expdigs137 = new int[]{16292, 32333, 10640, 47504, 29026, 30534, 23581, 6682, 10188, 24248, 44027, 51969, 30060, 20};
        expdigs138 = new int[]{29432, 37518, 55373, 2727, 33243, 22572, 16689, 35625, 34145, 15830, 59880, 32552, 52948, 13407};
        expdigs139 = new int[]{61898, 27244, 41841, 33450, 18682, 13988, 24415, 11497, 1652, 34237, 34677, 325, 5117, 134};
        expdigs140 = new int[]{16347, 3549, 48915, 22616, 21158, 51913, 32356, 21086, 3293, 8862, 1002, 26873, 22333, 1};
        expdigs141 = new int[]{25966, 63733, 28215, 31946, 40858, 58538, 11004, 6877, 6109, 3965, 35478, 37365, 45488, 878};
        expdigs142 = new int[]{45479, 34060, 17321, 19980, 1719, 16314, 29601, 8588, 58388, 22321, 14117, 63288, 51572, 8};
        expdigs143 = new int[]{46861, 47640, 11481, 23766, 46730, 53756, 8682, 60589, 42028, 27453, 29714, 31598, 39954, 5758};
        expdigs144 = new int[]{29304, 58803, 51232, 27762, 60760, 17576, 19092, 26820, 11561, 48771, 6850, 27841, 38410, 57};
        expdigs145 = new int[]{2916, 49445, 34666, 46387, 18627, 58279, 60468, 190, 3545, 51889, 51605, 47909, 40910, 37739};
        expdigs146 = new int[]{19034, 62098, 15419, 33887, 38852, 53011, 28129, 37357, 11176, 48360, 9035, 9654, 25968, 377};
        expdigs147 = new int[]{25094, 10451, 7363, 55389, 57404, 27399, 11422, 39695, 28947, 12935, 61694, 26310, 50722, 3};
        expdigstable = new int[][]{expdigs0, expdigs1, expdigs2, expdigs3, expdigs4, expdigs5, expdigs6, expdigs7, expdigs8, expdigs9, expdigs10, expdigs11, expdigs12, expdigs13, expdigs14, expdigs15, expdigs16, expdigs17, expdigs18, expdigs19, expdigs20, expdigs21, expdigs22, expdigs23, expdigs24, expdigs25, expdigs26, expdigs27, expdigs28, expdigs29, expdigs30, expdigs31, expdigs32, expdigs33, expdigs34, expdigs35, expdigs36, expdigs37, expdigs38, expdigs39, expdigs40, expdigs41, expdigs42, expdigs43, expdigs44, expdigs45, expdigs46, expdigs47, expdigs48, expdigs49, expdigs50, expdigs51, expdigs52, expdigs53, expdigs54, expdigs55, expdigs56, expdigs57, expdigs58, expdigs59, expdigs60, expdigs61, expdigs62, expdigs63, expdigs64, expdigs65, expdigs66, expdigs67, expdigs68, expdigs69, expdigs70, expdigs71, expdigs72, expdigs73, expdigs74, expdigs75, expdigs76, expdigs77, expdigs78, expdigs79, expdigs80, expdigs81, expdigs82, expdigs83, expdigs84, expdigs85, expdigs86, expdigs87, expdigs88, expdigs89, expdigs90, expdigs91, expdigs92, expdigs93, expdigs94, expdigs95, expdigs96, expdigs97, expdigs98, expdigs99, expdigs100, expdigs101, expdigs102, expdigs103, expdigs104, expdigs105, expdigs106, expdigs107, expdigs108, expdigs109, expdigs110, expdigs111, expdigs112, expdigs113, expdigs114, expdigs115, expdigs116, expdigs117, expdigs118, expdigs119, expdigs120, expdigs121, expdigs122, expdigs123, expdigs124, expdigs125, expdigs126, expdigs127, expdigs128, expdigs129, expdigs130, expdigs131, expdigs132, expdigs133, expdigs134, expdigs135, expdigs136, expdigs137, expdigs138, expdigs139, expdigs140, expdigs141, expdigs142, expdigs143, expdigs144, expdigs145, expdigs146, expdigs147};
        nexpdigstable = new int[]{14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 13, 13, 13, 12, 12, 11, 11, 10, 10, 10, 9, 9, 8, 8, 8, 7, 7, 6, 6, 5, 5, 5, 4, 4, 3, 3, 3, 2, 2, 1, 1, 1, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14};
        binexpstable = new int[]{90, 89, 89, 88, 88, 88, 87, 87, 86, 86, 86, 85, 85, 84, 84, 83, 83, 83, 82, 82, 81, 81, 81, 80, 80, 79, 79, 78, 78, 78, 77, 77, 76, 76, 76, 75, 75, 74, 74, 73, 73, 73, 72, 72, 71, 71, 71, 70, 70, 69, 69, 68, 68, 68, 67, 67, 66, 66, 66, 65, 65, 64, 64, 64, 63, 63, 62, 62, 61, 61, 61, 60, 60, 59, 59, 59, 58, 58, 57, 57, 56, 56, 56, 55, 55, 54, 54, 54, 53, 53, 52, 52, 51, 51, 51, 50, 50, 49, 49, 49, 48, 48, 47, 47, 46, 46, 46, 45, 45, 44, 44, 44, 43, 43, 42, 42, 41, 41, 41, 40, 40, 39, 39, 39, 38, 38, 37, 37, 37, 36, 36, 35, 35, 34, 34, 34, 33, 33, 32, 32, 32, 31, 31, 30, 30, 29, 29, 29};
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
