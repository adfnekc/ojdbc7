//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

abstract class VarnumBinder extends Binder {
    static final boolean DEBUG = false;
    static final boolean SLOW_CONVERSIONS = true;
    Binder theVarnumCopyingBinder;
    static final int LNXSGNBT = 128;
    static final byte LNXDIGS = 20;
    static final byte LNXEXPBS = 64;
    static final int LNXEXPMX = 127;
    static final double[] factorTable = new double[]{1.0E254D, 1.0E252D, 1.0E250D, 1.0E248D, 1.0E246D, 1.0E244D, 1.0E242D, 1.0E240D, 1.0E238D, 1.0E236D, 1.0E234D, 1.0E232D, 1.0E230D, 1.0E228D, 1.0E226D, 1.0E224D, 1.0E222D, 1.0E220D, 1.0E218D, 1.0E216D, 1.0E214D, 1.0E212D, 1.0E210D, 1.0E208D, 1.0E206D, 1.0E204D, 1.0E202D, 1.0E200D, 1.0E198D, 1.0E196D, 1.0E194D, 1.0E192D, 1.0E190D, 1.0E188D, 1.0E186D, 1.0E184D, 1.0E182D, 1.0E180D, 1.0E178D, 1.0E176D, 1.0E174D, 1.0E172D, 1.0E170D, 1.0E168D, 1.0E166D, 1.0E164D, 1.0E162D, 1.0E160D, 1.0E158D, 1.0E156D, 1.0E154D, 1.0E152D, 1.0E150D, 1.0E148D, 1.0E146D, 1.0E144D, 1.0E142D, 1.0E140D, 1.0E138D, 1.0E136D, 1.0E134D, 1.0E132D, 1.0E130D, 1.0E128D, 1.0E126D, 1.0E124D, 1.0E122D, 1.0E120D, 1.0E118D, 1.0E116D, 1.0E114D, 1.0E112D, 1.0E110D, 1.0E108D, 1.0E106D, 1.0E104D, 1.0E102D, 1.0E100D, 1.0E98D, 1.0E96D, 1.0E94D, 1.0E92D, 1.0E90D, 1.0E88D, 1.0E86D, 1.0E84D, 1.0E82D, 1.0E80D, 1.0E78D, 1.0E76D, 1.0E74D, 1.0E72D, 1.0E70D, 1.0E68D, 1.0E66D, 1.0E64D, 1.0E62D, 1.0E60D, 1.0E58D, 1.0E56D, 1.0E54D, 1.0E52D, 1.0E50D, 1.0E48D, 1.0E46D, 1.0E44D, 1.0E42D, 1.0E40D, 1.0E38D, 1.0E36D, 1.0E34D, 1.0E32D, 1.0E30D, 1.0E28D, 1.0E26D, 1.0E24D, 1.0E22D, 1.0E20D, 1.0E18D, 1.0E16D, 1.0E14D, 1.0E12D, 1.0E10D, 1.0E8D, 1000000.0D, 10000.0D, 100.0D, 1.0D, 0.01D, 1.0E-4D, 1.0E-6D, 1.0E-8D, 1.0E-10D, 1.0E-12D, 1.0E-14D, 1.0E-16D, 1.0E-18D, 1.0E-20D, 1.0E-22D, 1.0E-24D, 1.0E-26D, 1.0E-28D, 1.0E-30D, 1.0E-32D, 1.0E-34D, 1.0E-36D, 1.0E-38D, 1.0E-40D, 1.0E-42D, 1.0E-44D, 1.0E-46D, 1.0E-48D, 1.0E-50D, 1.0E-52D, 1.0E-54D, 1.0E-56D, 1.0E-58D, 1.0E-60D, 1.0E-62D, 1.0E-64D, 1.0E-66D, 1.0E-68D, 1.0E-70D, 1.0E-72D, 1.0E-74D, 1.0E-76D, 1.0E-78D, 1.0E-80D, 1.0E-82D, 1.0E-84D, 1.0E-86D, 1.0E-88D, 1.0E-90D, 1.0E-92D, 1.0E-94D, 1.0E-96D, 1.0E-98D, 1.0E-100D, 1.0E-102D, 1.0E-104D, 1.0E-106D, 1.0E-108D, 1.0E-110D, 1.0E-112D, 1.0E-114D, 1.0E-116D, 1.0E-118D, 1.0E-120D, 1.0E-122D, 1.0E-124D, 1.0E-126D, 1.0E-128D, 1.0E-130D, 1.0E-132D, 1.0E-134D, 1.0E-136D, 1.0E-138D, 1.0E-140D, 1.0E-142D, 1.0E-144D, 1.0E-146D, 1.0E-148D, 1.0E-150D, 1.0E-152D, 1.0E-154D, 1.0E-156D, 1.0E-158D, 1.0E-160D, 1.0E-162D, 1.0E-164D, 1.0E-166D, 1.0E-168D, 1.0E-170D, 1.0E-172D, 1.0E-174D, 1.0E-176D, 1.0E-178D, 1.0E-180D, 1.0E-182D, 1.0E-184D, 1.0E-186D, 1.0E-188D, 1.0E-190D, 1.0E-192D, 1.0E-194D, 1.0E-196D, 1.0E-198D, 1.0E-200D, 1.0E-202D, 1.0E-204D, 1.0E-206D, 1.0E-208D, 1.0E-210D, 1.0E-212D, 1.0E-214D, 1.0E-216D, 1.0E-218D, 1.0E-220D, 1.0E-222D, 1.0E-224D, 1.0E-226D, 1.0E-228D, 1.0E-230D, 1.0E-232D, 1.0E-234D, 1.0E-236D, 1.0E-238D, 1.0E-240D, 1.0E-242D, 1.0E-244D, 1.0E-246D, 1.0E-248D, 1.0E-250D, 1.0E-252D, 1.0E-254D};
    static final int MANTISSA_SIZE = 53;
    static final int expShift = 52;
    static final long fractHOB = 4503599627370496L;
    static final long fractMask = 4503599627370495L;
    static final int expBias = 1023;
    static final int maxSmallBinExp = 62;
    static final int minSmallBinExp = -21;
    static final long expOne = 4607182418800017408L;
    static final long highbyte = -72057594037927936L;
    static final long highbit = -9223372036854775808L;
    static final long lowbytes = 72057594037927935L;
    static final int[] small5pow = new int[]{1, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625, 1220703125};
    static final long[] long5pow = new long[]{1L, 5L, 25L, 125L, 625L, 3125L, 15625L, 78125L, 390625L, 1953125L, 9765625L, 48828125L, 244140625L, 1220703125L, 6103515625L, 30517578125L, 152587890625L, 762939453125L, 3814697265625L, 19073486328125L, 95367431640625L, 476837158203125L, 2384185791015625L, 11920928955078125L, 59604644775390625L, 298023223876953125L, 1490116119384765625L};
    static final int[] n5bits = new int[]{0, 3, 5, 7, 10, 12, 14, 17, 19, 21, 24, 26, 28, 31, 33, 35, 38, 40, 42, 45, 47, 49, 52, 54, 56, 59, 61};
    static FDBigInt[] b5p;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 6;
        var0.bytelen = 22;
    }

    VarnumBinder() {
        this.theVarnumCopyingBinder = OraclePreparedStatementReadOnly.theStaticVarnumCopyingBinder;
        init(this);
    }

    Binder copyingBinder() {
        return this.theVarnumCopyingBinder;
    }

    static int setLongInternal(byte[] var0, int var1, long var2) {
        if (var2 == 0L) {
            var0[var1] = -128;
            return 1;
        } else if (var2 == -9223372036854775808L) {
            var0[var1] = 53;
            var0[var1 + 1] = 92;
            var0[var1 + 2] = 79;
            var0[var1 + 3] = 68;
            var0[var1 + 4] = 29;
            var0[var1 + 5] = 98;
            var0[var1 + 6] = 33;
            var0[var1 + 7] = 47;
            var0[var1 + 8] = 24;
            var0[var1 + 9] = 43;
            var0[var1 + 10] = 93;
            var0[var1 + 11] = 102;
            return 12;
        } else {
            int var4 = 10;
            int var5 = 0;
            if (var2 / 1000000000000000000L == 0L) {
                --var4;
                if (var2 / 10000000000000000L == 0L) {
                    --var4;
                    if (var2 / 100000000000000L == 0L) {
                        --var4;
                        if (var2 / 1000000000000L == 0L) {
                            --var4;
                            if (var2 / 10000000000L == 0L) {
                                --var4;
                                if (var2 / 100000000L == 0L) {
                                    --var4;
                                    if (var2 / 1000000L == 0L) {
                                        --var4;
                                        if (var2 / 10000L == 0L) {
                                            --var4;
                                            if (var2 / 100L == 0L) {
                                                --var4;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            int var6 = var1 + var4;
            int var7;
            if (var2 < 0L) {
                var2 = -var2;
                var0[var1] = (byte)(63 - var4);

                while(true) {
                    var7 = (int)(var2 % 100L);
                    if (var5 == 0) {
                        if (var7 != 0) {
                            var0[var6 + 1] = 102;
                            var5 = var6 + 2 - var1;
                            var0[var6] = (byte)(101 - var7);
                        }
                    } else {
                        var0[var6] = (byte)(101 - var7);
                    }

                    --var6;
                    if (var6 == var1) {
                        break;
                    }

                    var2 /= 100L;
                }
            } else {
                var0[var1] = (byte)(192 + var4);

                while(true) {
                    var7 = (int)(var2 % 100L);
                    if (var5 == 0) {
                        if (var7 != 0) {
                            var5 = var6 + 1 - var1;
                            var0[var6] = (byte)(var7 + 1);
                        }
                    } else {
                        var0[var6] = (byte)(var7 + 1);
                    }

                    --var6;
                    if (var6 == var1) {
                        break;
                    }

                    var2 /= 100L;
                }
            }

            return var5;
        }
    }

    static int countBits(long var0) {
        if (var0 == 0L) {
            return 0;
        } else {
            while((var0 & -72057594037927936L) == 0L) {
                var0 <<= 8;
            }

            while(var0 > 0L) {
                var0 <<= 1;
            }

            int var2;
            for(var2 = 0; (var0 & 72057594037927935L) != 0L; var2 += 8) {
                var0 <<= 8;
            }

            while(var0 != 0L) {
                var0 <<= 1;
                ++var2;
            }

            return var2;
        }
    }

    boolean roundup(char[] var1, int var2) {
        int var3 = var2 - 1;
        char var4 = var1[var3];
        if (var4 == '9') {
            while(true) {
                if (var4 != '9' || var3 <= 0) {
                    if (var4 == '9') {
                        var1[0] = '1';
                        return true;
                    }
                    break;
                }

                var1[var3] = '0';
                --var3;
                var4 = var1[var3];
            }
        }

        var1[var3] = (char)(var4 + 1);
        return false;
    }

    static FDBigInt big5pow(int var0) {
        if (var0 < 0) {
            throw new RuntimeException("Assertion botch: negative power of 5");
        } else {
            if (b5p == null) {
                b5p = new FDBigInt[var0 + 1];
            } else if (b5p.length <= var0) {
                FDBigInt[] var1 = new FDBigInt[var0 + 1];
                System.arraycopy(b5p, 0, var1, 0, b5p.length);
                b5p = var1;
            }

            if (b5p[var0] != null) {
                return b5p[var0];
            } else if (var0 < small5pow.length) {
                return b5p[var0] = new FDBigInt(small5pow[var0]);
            } else if (var0 < long5pow.length) {
                return b5p[var0] = new FDBigInt(long5pow[var0]);
            } else {
                int var5 = var0 >> 1;
                int var2 = var0 - var5;
                FDBigInt var3 = b5p[var5];
                if (var3 == null) {
                    var3 = big5pow(var5);
                }

                if (var2 < small5pow.length) {
                    return b5p[var0] = var3.mult(small5pow[var2]);
                } else {
                    FDBigInt var4 = b5p[var2];
                    if (var4 == null) {
                        var4 = big5pow(var2);
                    }

                    return b5p[var0] = var3.mult(var4);
                }
            }
        }
    }

    static FDBigInt multPow52(FDBigInt var0, int var1, int var2) {
        if (var1 != 0) {
            if (var1 < small5pow.length) {
                var0 = var0.mult(small5pow[var1]);
            } else {
                var0 = var0.mult(big5pow(var1));
            }
        }

        if (var2 != 0) {
            var0.lshiftMe(var2);
        }

        return var0;
    }

    static FDBigInt constructPow52(int var0, int var1) {
        FDBigInt var2 = new FDBigInt(big5pow(var0));
        if (var1 != 0) {
            var2.lshiftMe(var1);
        }

        return var2;
    }

    int dtoa(byte[] var1, int var2, double var3, boolean var5, boolean var6, char[] var7, int var8, long var9, int var11) {
        int var12 = 2147483647;
        int var13 = -1;
        int var14 = countBits(var9);
        int var15 = var14 - var8 - 1;
        boolean var17 = false;
        if (var15 < 0) {
            var15 = 0;
        }

        int var26;
        int var27;
        int var50;
        if (var8 <= 62 && var8 >= -21 && var15 < long5pow.length && var14 + n5bits[var15] < 64 && var15 == 0) {
            long var18;
            if (var8 > var11) {
                var18 = 1L << var8 - var11 - 1;
            } else {
                var18 = 0L;
            }

            if (var8 >= 52) {
                var9 <<= var8 - 52;
            } else {
                var9 >>>= 52 - var8;
            }

            var12 = 0;
            long var20 = var9;
            long var22 = var18;

            for(var27 = 0; var22 >= 10L; ++var27) {
                var22 /= 10L;
            }

            if (var27 != 0) {
                long var28 = long5pow[var27] << var27;
                long var30 = var9 % var28;
                var20 = var9 / var28;
                var12 += var27;
                if (var30 >= var28 >> 1) {
                    ++var20;
                }
            }

            byte var24;
            int var25;
            if (var20 <= 2147483647L) {
                int var51 = (int)var20;
                var24 = 10;
                var25 = var24 - 1;
                var26 = var51 % 10;

                for(var51 /= 10; var26 == 0; var51 /= 10) {
                    ++var12;
                    var26 = var51 % 10;
                }

                while(var51 != 0) {
                    var7[var25--] = (char)(var26 + 48);
                    ++var12;
                    var26 = var51 % 10;
                    var51 /= 10;
                }

                var7[var25] = (char)(var26 + 48);
            } else {
                var24 = 20;
                var25 = var24 - 1;
                var26 = (int)(var20 % 10L);

                for(var20 /= 10L; var26 == 0; var20 /= 10L) {
                    ++var12;
                    var26 = (int)(var20 % 10L);
                }

                while(var20 != 0L) {
                    var7[var25--] = (char)(var26 + 48);
                    ++var12;
                    var26 = (int)(var20 % 10L);
                    var20 /= 10L;
                }

                var7[var25] = (char)(var26 + 48);
            }

            var50 = var24 - var25;
            if (var25 != 0) {
                System.arraycopy(var7, var25, var7, 0, var50);
            }

            ++var12;
            var13 = var50;
            var17 = true;
        }

        int var21;
        int var48;
        int var49;
        if (!var17) {
            double var46 = Double.longBitsToDouble(4607182418800017408L | var9 & -4503599627370497L);
            int var16 = (int)Math.floor((var46 - 1.5D) * 0.289529654D + 0.176091259D + (double)var8 * 0.301029995663981D);
            var21 = Math.max(0, -var16);
            var48 = var21 + var15 + var8;
            int var23 = Math.max(0, var16);
            var49 = var23 + var15;
            var50 = var48 - var11;
            var9 >>>= 53 - var14;
            var48 -= var14 - 1;
            int var31 = Math.min(var48, var49);
            var48 -= var31;
            var49 -= var31;
            var50 -= var31;
            if (var14 == 1) {
                --var50;
            }

            if (var50 < 0) {
                var48 -= var50;
                var49 -= var50;
                var50 = 0;
            }

            boolean var32 = false;
            var26 = var14 + var48 + (var21 < n5bits.length ? n5bits[var21] : var21 * 3);
            var27 = var49 + 1 + (var23 + 1 < n5bits.length ? n5bits[var23 + 1] : (var23 + 1) * 3);
            boolean var33;
            boolean var34;
            long var35;
            int var37;
            int var39;
            int var54;
            if (var26 < 64 && var27 < 64) {
                if (var26 < 32 && var27 < 32) {
                    int var56 = (int)var9 * small5pow[var21] << var48;
                    var39 = small5pow[var23] << var49;
                    int var57 = small5pow[var21] << var50;
                    int var41 = var39 * 10;
                    var54 = 0;
                    var37 = var56 / var39;
                    var56 = 10 * (var56 % var39);
                    var57 *= 10;
                    var33 = var56 < var57;
                    var34 = var56 + var57 > var41;
                    if (var37 == 0 && !var34) {
                        --var16;
                    } else {
                        var7[var54++] = (char)(48 + var37);
                    }

                    if (var16 <= -3 || var16 >= 8) {
                        var33 = false;
                        var34 = false;
                    }

                    for(; !var33 && !var34; var7[var54++] = (char)(48 + var37)) {
                        var37 = var56 / var39;
                        var56 = 10 * (var56 % var39);
                        var57 *= 10;
                        if ((long)var57 > 0L) {
                            var33 = var56 < var57;
                            var34 = var56 + var57 > var41;
                        } else {
                            var33 = true;
                            var34 = true;
                        }
                    }

                    var35 = (long)((var56 << 1) - var41);
                } else {
                    long var55 = var9 * long5pow[var21] << var48;
                    long var40 = long5pow[var23] << var49;
                    long var42 = long5pow[var21] << var50;
                    long var44 = var40 * 10L;
                    var54 = 0;
                    var37 = (int)(var55 / var40);
                    var55 = 10L * (var55 % var40);
                    var42 *= 10L;
                    var33 = var55 < var42;
                    var34 = var55 + var42 > var44;
                    if (var37 == 0 && !var34) {
                        --var16;
                    } else {
                        var7[var54++] = (char)(48 + var37);
                    }

                    if (var16 <= -3 || var16 >= 8) {
                        var33 = false;
                        var34 = false;
                    }

                    for(; !var33 && !var34; var7[var54++] = (char)(48 + var37)) {
                        var37 = (int)(var55 / var40);
                        var55 = 10L * (var55 % var40);
                        var42 *= 10L;
                        if (var42 > 0L) {
                            var33 = var55 < var42;
                            var34 = var55 + var42 > var44;
                        } else {
                            var33 = true;
                            var34 = true;
                        }
                    }

                    var35 = (var55 << 1) - var44;
                }
            } else {
                FDBigInt var29 = multPow52(new FDBigInt(var9), var21, var48);
                FDBigInt var52 = constructPow52(var23, var49);
                FDBigInt var53 = constructPow52(var21, var50);
                var29.lshiftMe(var39 = var52.normalizeMe());
                var53.lshiftMe(var39);
                FDBigInt var38 = var52.mult(10);
                var54 = 0;
                var37 = var29.quoRemIteration(var52);
                var53 = var53.mult(10);
                var33 = var29.cmp(var53) < 0;
                var34 = var29.add(var53).cmp(var38) > 0;
                if (var37 == 0 && !var34) {
                    --var16;
                } else {
                    var7[var54++] = (char)(48 + var37);
                }

                if (var16 <= -3 || var16 >= 8) {
                    var33 = false;
                    var34 = false;
                }

                while(!var33 && !var34) {
                    var37 = var29.quoRemIteration(var52);
                    var53 = var53.mult(10);
                    var33 = var29.cmp(var53) < 0;
                    var34 = var29.add(var53).cmp(var38) > 0;
                    var7[var54++] = (char)(48 + var37);
                }

                if (var34 && var33) {
                    var29.lshiftMe(1);
                    var35 = (long)var29.cmp(var38);
                } else {
                    var35 = 0L;
                }
            }

            var12 = var16 + 1;
            var13 = var54;
            if (var34) {
                if (var33) {
                    if (var35 == 0L) {
                        if ((var7[var54 - 1] & 1) != 0 && this.roundup(var7, var54)) {
                            ++var12;
                        }
                    } else if (var35 > 0L && this.roundup(var7, var54)) {
                        ++var12;
                    }
                } else if (this.roundup(var7, var54)) {
                    ++var12;
                }
            }
        }

        while(var13 - var12 > 0 && var7[var13 - 1] == '0') {
            --var13;
        }

        boolean var47 = var12 % 2 != 0;
        int var19;
        if (var47) {
            if (var13 % 2 == 0) {
                var7[var13++] = '0';
            }

            var19 = (var12 - 1) / 2;
        } else {
            if (var13 % 2 == 1) {
                var7[var13++] = '0';
            }

            var19 = (var12 - 2) / 2;
        }

        var48 = 117 - var19;
        var21 = 0;
        var49 = 1;
        if (var5) {
            var1[var2] = (byte)(62 - var19);
            if (var47) {
                var1[var2 + var49] = (byte)(101 - (var7[var21++] - 48));
                ++var49;
            }

            while(var21 < var13) {
                var1[var2 + var49] = (byte)(101 - ((var7[var21] - 48) * 10 + (var7[var21 + 1] - 48)));
                var21 += 2;
                ++var49;
            }

            var1[var2 + var49++] = 102;
        } else {
            var1[var2] = (byte)(192 + var19 + 1);
            if (var47) {
                var1[var2 + var49] = (byte)(var7[var21++] - 48 + 1);
                ++var49;
            }

            while(var21 < var13) {
                var1[var2 + var49] = (byte)((var7[var21] - 48) * 10 + (var7[var21 + 1] - 48) + 1);
                var21 += 2;
                ++var49;
            }
        }

        return var49;
    }
}
