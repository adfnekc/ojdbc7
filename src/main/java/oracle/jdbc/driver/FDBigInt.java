//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class FDBigInt {
    int nWords;
    int[] data;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    FDBigInt(int var1) {
        this.nWords = 1;
        this.data = new int[1];
        this.data[0] = var1;
    }

    FDBigInt(long var1) {
        this.data = new int[2];
        this.data[0] = (int)var1;
        this.data[1] = (int)(var1 >>> 32);
        this.nWords = this.data[1] == 0 ? 1 : 2;
    }

    FDBigInt(FDBigInt var1) {
        this.data = new int[this.nWords = var1.nWords];
        System.arraycopy(var1.data, 0, this.data, 0, this.nWords);
    }

    FDBigInt(int[] var1, int var2) {
        this.data = var1;
        this.nWords = var2;
    }

    void lshiftMe(int var1) throws IllegalArgumentException {
        if (var1 <= 0) {
            if (var1 != 0) {
                throw new IllegalArgumentException("negative shift count");
            }
        } else {
            int var2 = var1 >> 5;
            int var3 = var1 & 31;
            int var4 = 32 - var3;
            int[] var5 = this.data;
            int[] var6 = this.data;
            if (this.nWords + var2 + 1 > var5.length) {
                var5 = new int[this.nWords + var2 + 1];
            }

            int var7 = this.nWords + var2;
            int var8 = this.nWords - 1;
            if (var3 == 0) {
                System.arraycopy(var6, 0, var5, var2, this.nWords);
                var7 = var2 - 1;
            } else {
                int var10001;
                int var10002;
                for(var5[var7--] = var6[var8] >>> var4; var8 >= 1; var5[var10001] = var10002 | var6[var8] >>> var4) {
                    var10001 = var7--;
                    var10002 = var6[var8] << var3;
                    --var8;
                }

                var5[var7--] = var6[var8] << var3;
            }

            while(var7 >= 0) {
                var5[var7--] = 0;
            }

            this.data = var5;

            for(this.nWords += var2 + 1; this.nWords > 1 && this.data[this.nWords - 1] == 0; --this.nWords) {
            }

        }
    }

    int normalizeMe() throws IllegalArgumentException {
        int var2 = 0;
        int var3 = 0;
        int var4 = 0;

        int var1;
        for(var1 = this.nWords - 1; var1 >= 0 && (var4 = this.data[var1]) == 0; --var1) {
            ++var2;
        }

        if (var1 < 0) {
            throw new IllegalArgumentException("zero value");
        } else {
            this.nWords -= var2;
            if ((var4 & -268435456) != 0) {
                for(var3 = 32; (var4 & -268435456) != 0; --var3) {
                    var4 >>>= 1;
                }
            } else {
                while(var4 <= 1048575) {
                    var4 <<= 8;
                    var3 += 8;
                }

                while(var4 <= 134217727) {
                    var4 <<= 1;
                    ++var3;
                }
            }

            if (var3 != 0) {
                this.lshiftMe(var3);
            }

            return var3;
        }
    }

    FDBigInt mult(int var1) {
        long var2 = (long)var1;
        int[] var4 = new int[var2 * ((long)this.data[this.nWords - 1] & 4294967295L) > 268435455L ? this.nWords + 1 : this.nWords];
        long var5 = 0L;

        for(int var7 = 0; var7 < this.nWords; ++var7) {
            var5 += var2 * ((long)this.data[var7] & 4294967295L);
            var4[var7] = (int)var5;
            var5 >>>= 32;
        }

        if (var5 == 0L) {
            return new FDBigInt(var4, this.nWords);
        } else {
            var4[this.nWords] = (int)var5;
            return new FDBigInt(var4, this.nWords + 1);
        }
    }

    FDBigInt mult(FDBigInt var1) {
        int[] var2 = new int[this.nWords + var1.nWords];

        int var3;
        for(var3 = 0; var3 < this.nWords; ++var3) {
            long var4 = (long)this.data[var3] & 4294967295L;
            long var6 = 0L;

            int var8;
            for(var8 = 0; var8 < var1.nWords; ++var8) {
                var6 += ((long)var2[var3 + var8] & 4294967295L) + var4 * ((long)var1.data[var8] & 4294967295L);
                var2[var3 + var8] = (int)var6;
                var6 >>>= 32;
            }

            var2[var3 + var8] = (int)var6;
        }

        for(var3 = var2.length - 1; var3 > 0 && var2[var3] == 0; --var3) {
        }

        return new FDBigInt(var2, var3 + 1);
    }

    FDBigInt add(FDBigInt var1) {
        long var7 = 0L;
        int[] var3;
        int[] var4;
        int var5;
        int var6;
        if (this.nWords >= var1.nWords) {
            var3 = this.data;
            var5 = this.nWords;
            var4 = var1.data;
            var6 = var1.nWords;
        } else {
            var3 = var1.data;
            var5 = var1.nWords;
            var4 = this.data;
            var6 = this.nWords;
        }

        int[] var9 = new int[var5];

        int var2;
        for(var2 = 0; var2 < var5; ++var2) {
            var7 += (long)var3[var2] & 4294967295L;
            if (var2 < var6) {
                var7 += (long)var4[var2] & 4294967295L;
            }

            var9[var2] = (int)var7;
            var7 >>= 32;
        }

        if (var7 != 0L) {
            int[] var10 = new int[var9.length + 1];
            System.arraycopy(var9, 0, var10, 0, var9.length);
            var10[var2++] = (int)var7;
            return new FDBigInt(var10, var2);
        } else {
            return new FDBigInt(var9, var2);
        }
    }

    int cmp(FDBigInt var1) {
        int var2;
        int var3;
        if (this.nWords > var1.nWords) {
            var3 = var1.nWords - 1;

            for(var2 = this.nWords - 1; var2 > var3; --var2) {
                if (this.data[var2] != 0) {
                    return 1;
                }
            }
        } else if (this.nWords < var1.nWords) {
            var3 = this.nWords - 1;

            for(var2 = var1.nWords - 1; var2 > var3; --var2) {
                if (var1.data[var2] != 0) {
                    return -1;
                }
            }
        } else {
            var2 = this.nWords - 1;
        }

        while(var2 > 0 && this.data[var2] == var1.data[var2]) {
            --var2;
        }

        var3 = this.data[var2];
        int var4 = var1.data[var2];
        if (var3 < 0) {
            return var4 < 0 ? var3 - var4 : 1;
        } else {
            return var4 < 0 ? -1 : var3 - var4;
        }
    }

    int quoRemIteration(FDBigInt var1) throws IllegalArgumentException {
        if (this.nWords != var1.nWords) {
            throw new IllegalArgumentException("disparate values");
        } else {
            int var2 = this.nWords - 1;
            long var3 = ((long)this.data[var2] & 4294967295L) / (long)var1.data[var2];
            long var5 = 0L;

            for(int var7 = 0; var7 <= var2; ++var7) {
                var5 += ((long)this.data[var7] & 4294967295L) - var3 * ((long)var1.data[var7] & 4294967295L);
                this.data[var7] = (int)var5;
                var5 >>= 32;
            }

            int var9;
            long var10;
            if (var5 != 0L) {
                for(var10 = 0L; var10 == 0L; --var3) {
                    var10 = 0L;

                    for(var9 = 0; var9 <= var2; ++var9) {
                        var10 += ((long)this.data[var9] & 4294967295L) + ((long)var1.data[var9] & 4294967295L);
                        this.data[var9] = (int)var10;
                        var10 >>= 32;
                    }

                    if (var10 != 0L && var10 != 1L) {
                        throw new RuntimeException("Assertion botch: " + var10 + " carry out of division correction");
                    }
                }
            }

            var10 = 0L;

            for(var9 = 0; var9 <= var2; ++var9) {
                var10 += 10L * ((long)this.data[var9] & 4294967295L);
                this.data[var9] = (int)var10;
                var10 >>= 32;
            }

            if (var10 != 0L) {
                throw new RuntimeException("Assertion botch: carry out of *10");
            } else {
                return (int)var3;
            }
        }
    }
}
