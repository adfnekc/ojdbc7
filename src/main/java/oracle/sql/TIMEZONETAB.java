//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;

public class TIMEZONETAB {
    private static HashMap<Integer, TIMEZONETAB> instanceCache = null;
    private int instanceCount = 0;
    private int versionNumber = 0;
    private Hashtable zonetab = new Hashtable();
    private static int OFFSET_HOUR = 20;
    private static int OFFSET_MINUTE = 60;
    private static int HOUR_MILLISECOND = 3600000;
    private static int MINUTE_MILLISECOND = 60000;
    private static int BYTE_SIZE = 10;

    private TIMEZONETAB(int var1) throws SQLException {
        this.versionNumber = var1;
    }

    public static TIMEZONETAB getInstance(int var0) throws SQLException {
        if (instanceCache == null) {
            Class var1 = TIMEZONETAB.class;
            synchronized(TIMEZONETAB.class) {
                if (instanceCache == null) {
                    instanceCache = new HashMap(5);
                }
            }
        }

        TIMEZONETAB var6 = (TIMEZONETAB)instanceCache.get(var0);
        if (var6 == null) {
            Class var2 = TIMEZONETAB.class;
            synchronized(TIMEZONETAB.class) {
                var6 = (TIMEZONETAB)instanceCache.get(var0);
                if (var6 == null) {
                    var6 = new TIMEZONETAB(var0);
                }
            }
        }

        return var6.returnInstance();
    }

    private synchronized TIMEZONETAB returnInstance() {
        ++this.instanceCount;
        instanceCache.put(this.versionNumber, this);
        return this;
    }

    public synchronized void freeInstance() throws SQLException {
        --this.instanceCount;
        if (this.instanceCount < 1) {
            instanceCache.remove(this.versionNumber);
        }

    }

    public void addTrans(byte[] var1, int var2) {
        int[] var4 = new int[BYTE_SIZE];
        int var3 = var1[0] & 255;
        OffsetDST[] var5 = new OffsetDST[var3];
        int var6 = 0;

        for(int var7 = 1; var7 < var3 * BYTE_SIZE; var7 += BYTE_SIZE) {
            int var8;
            for(var8 = 0; var8 < BYTE_SIZE; ++var8) {
                var4[var8] = var1[var8 + var7] & 255;
            }

            var8 = (var4[0] - 100) * 100 + (var4[1] - 100);
            Calendar var9 = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
            var9.set(1, var8);
            var9.set(2, var4[2] - 1);
            var9.set(5, var4[3]);
            var9.set(11, var4[4] - 1);
            var9.set(12, var4[5] - 1);
            var9.set(13, var4[6] - 1);
            var9.set(14, 0);
            long var10 = var9.getTime().getTime();
            int var12 = (var4[7] - OFFSET_HOUR) * HOUR_MILLISECOND + (var4[8] - OFFSET_MINUTE) * MINUTE_MILLISECOND;
            byte var13 = (byte)var4[9];
            var5[var6++] = new OffsetDST(new Timestamp(var10), var12, var13);
        }

        this.zonetab.put(var2 & 511, var5);
    }

    public byte getLocalOffset(Calendar var1, int var2, OffsetDST var3) throws SQLException {
        boolean var6 = false;
        boolean var7 = false;
        boolean var10 = false;
        Calendar var11 = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
        Calendar var12 = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
        Calendar var13 = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
        var13.set(1, var1.get(1));
        var13.set(2, var1.get(2));
        var13.set(5, var1.get(5));
        var13.set(11, var1.get(11));
        var13.set(12, var1.get(12));
        var13.set(13, var1.get(13));
        var13.set(14, var1.get(14));
        Calendar var14 = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
        var14.set(1, var13.get(1));
        var14.set(2, var13.get(2));
        var14.set(5, 1);
        var14.set(11, 0);
        var14.set(12, 0);
        var14.set(13, 0);
        var14.set(14, 0);
        OffsetDST[] var15 = (OffsetDST[])((OffsetDST[])this.zonetab.get(var2 & 511));
        int var16 = this.findCloseMatch(var15, var14.getTimeInMillis());

        byte var17;
        while(true) {
            var11.setTime(var15[var16].getTimestamp());
            int var4 = var15[var16].getOFFSET();
            var11.add(10, var4 / HOUR_MILLISECOND);
            var11.add(12, var4 % HOUR_MILLISECOND / MINUTE_MILLISECOND);
            byte var8 = var15[var16].getDSTFLAG();
            byte var9;
            if (var13.equals(var11)) {
                var3.setOFFSET(var15[var16].getOFFSET());
                var3.setDSTFLAG(var15[var16].getDSTFLAG());
                var17 = 0;
                if (var16 > 0) {
                    var9 = var15[var16 - 1].getDSTFLAG();
                    if (var8 == 0 && var9 == 1) {
                        var17 = 1;
                    }
                }
                break;
            }

            if (var13.before(var11)) {
                if (var16 == 0) {
                    var3.setOFFSET(0);
                    var3.setDSTFLAG((byte)0);
                    var17 = 0;
                    if (var8 == 1) {
                        var11.add(10, -1);
                        if (!var13.before(var11)) {
                            throw new SQLException("Illegal local time.");
                        }
                    }
                    break;
                }

                --var16;
                if (var16 >= 0) {
                    var9 = var15[var16].getDSTFLAG();
                    if (var8 == 1 && var9 == 0) {
                        var11.add(10, -1);
                        if (!var13.before(var11)) {
                            throw new SQLException("Illegal local time.");
                        }
                    }
                }
            } else {
                if (var16 != var15.length - 1) {
                    var12.setTime(var15[var16 + 1].getTimestamp());
                    int var5 = var15[var16 + 1].getOFFSET();
                    var12.add(10, var5 / HOUR_MILLISECOND);
                    var12.add(12, var5 % HOUR_MILLISECOND / MINUTE_MILLISECOND);
                    if (!var13.before(var12)) {
                        ++var16;
                        continue;
                    }
                }

                var3.setOFFSET(var15[var16].getOFFSET());
                var3.setDSTFLAG(var15[var16].getDSTFLAG());
                var17 = 0;
                if (var8 == 0) {
                    if (var16 > 0) {
                        var9 = var15[var16 - 1].getDSTFLAG();
                        if (var9 == 1) {
                            var11.add(10, 1);
                            if (var13.before(var11)) {
                                var17 = 1;
                            }
                        }
                    }

                    if (var16 != var15.length - 1) {
                        var9 = var15[var16 + 1].getDSTFLAG();
                        if (var9 == 1) {
                            var12.add(10, -1);
                            if (!var13.before(var12)) {
                                throw new SQLException("Illegal local time.");
                            }
                        }
                    }
                }
                break;
            }
        }

        return var17;
    }

    public int getOffset(Calendar var1, int var2) throws SQLException {
        OffsetDST[] var3 = (OffsetDST[])((OffsetDST[])this.zonetab.get(var2 & 511));
        return this.getOffset(var1, var3);
    }

    public int getOffset(Calendar var1, OffsetDST[] var2) throws SQLException {
        boolean var3 = false;
        Timestamp var4 = new Timestamp(var1.getTime().getTime());
        int var5 = this.findCloseMatch(var2, var4.getTime());
        return var2[var5].getOFFSET();
    }

    public boolean isDST(Calendar var1, OffsetDST[] var2) throws SQLException {
        boolean var3 = false;
        Timestamp var4 = new Timestamp(var1.getTime().getTime());
        int var5 = this.findCloseMatch(var2, var4.getTime());
        return var2[var5].getDSTFLAG() == 1;
    }

    public OffsetDST[] getOffsetDST(int var1) {
        OffsetDST[] var2 = (OffsetDST[])((OffsetDST[])this.zonetab.get(var1 & 511));
        return var2;
    }

    final int findCloseMatch(OffsetDST[] var1, long var2) {
        int var4 = var1.length;
        int var5 = 0;
        int var6 = var4 / 2;
        int var7 = var6;
        if (var2 < var1[var5].getTime()) {
            int var8;
            for(var8 = 0; var1[var8].getDSTFLAG() == 1 && var8 < var1.length; ++var8) {
            }

            return var8 < var1.length ? var8 : 0;
        } else {
            while(var6 > 0) {
                if (var2 > var1[var6].getTime()) {
                    var5 = var6;
                } else if (var2 < var1[var6].getTime()) {
                    var4 = var6;
                } else if (var6 == var5) {
                    break;
                }

                var6 = var5 + (var4 - var5) / 2;
                if (var7 == var6) {
                    break;
                }

                var7 = var6;
            }

            return var6;
        }
    }

    public void displayTable(int var1) {
        OffsetDST[] var2 = (OffsetDST[])((OffsetDST[])this.zonetab.get(var1));

        for(int var3 = 0; var3 < var2.length; ++var3) {
            System.out.print(var2[var3].getTimestamp().toString());
            System.out.print("    " + var2[var3].getOFFSET());
            System.out.println("    " + var2[var3].getDSTFLAG());
        }

    }

    public boolean checkID(int var1) {
        return this.zonetab.get(var1 & 511) == null;
    }

    public void updateTable(Connection var1, int var2) throws SQLException, NullPointerException {
        byte[] var3 = TRANSDUMP.getTransitions(var1, var2);
        if (var3 == null) {
            throw new NullPointerException();
        } else {
            this.addTrans(var3, var2);
        }
    }
}
