//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleConnection;

public class LobPlsqlUtil {
    static boolean PLSQL_DEBUG = false;
    static final int MAX_PLSQL_SIZE = 32512;
    static final int MAX_PLSQL_INSTR_SIZE = 32512;
    static final int MAX_CHUNK_SIZE = 32512;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public LobPlsqlUtil() {
    }

    public static long hasPattern(BLOB var0, byte[] var1, long var2) throws SQLException {
        return hasPattern(var0.getInternalConnection(), var0, 2004, var1, var2);
    }

    public static long isSubLob(BLOB var0, BLOB var1, long var2) throws SQLException {
        return isSubLob(var0.getInternalConnection(), var0, 2004, var1, var2);
    }

    public static long hasPattern(CLOB var0, char[] var1, long var2) throws SQLException {
        if (var1 != null && var2 > 0L) {
            OracleConnection var4 = var0.getInternalConnection();
            long var5 = (long)var1.length;
            long var7 = length(var4, var0, 2005);
            if (var5 != 0L && var5 <= var7 - var2 + 1L && var2 <= var7) {
                long var10;
                if (var5 <= (long)getPlsqlMaxInstrSize(var4)) {
                    OracleCallableStatement var24 = null;

                    try {
                        var24 = (OracleCallableStatement)var4.prepareCall("begin :1 := dbms_lob.instr(:2, :3, :4); end;");
                        var24.registerOutParameter(1, 2);
                        if (var0.isNCLOB()) {
                            var24.setFormOfUse(2, (short)2);
                            var24.setFormOfUse(3, (short)2);
                        }

                        var24.setCLOB(2, var0);
                        var24.setString(3, new String(var1));
                        var24.setLong(4, var2);
                        var24.execute();
                        var10 = var24.getLong(1);
                    } finally {
                        var24.close();
                        var24 = null;
                    }

                    return var10;
                } else {
                    boolean var9 = false;
                    var10 = var2;
                    boolean var12 = false;
                    long var16 = 0L;

                    while(!var12) {
                        if (var5 > var7 - var10 + 1L) {
                            return 0L;
                        }

                        byte var22 = 0;
                        int var18 = (int)Math.min((long)getPlsqlMaxInstrSize(var4), var5 - (long)var22);
                        char[] var15 = new char[var18];
                        System.arraycopy(var1, var22, var15, 0, var18);
                        long var13 = hasPattern(var0, var15, var10);
                        if (var13 == 0L) {
                            return 0L;
                        }

                        var16 = var13;
                        int var23 = var22 + var18;
                        var10 = var13 + (long)var18;
                        boolean var19 = true;

                        while(var19) {
                            var18 = (int)Math.min((long)getPlsqlMaxInstrSize(var4), var5 - (long)var23);
                            var15 = new char[var18];
                            System.arraycopy(var1, var23, var15, 0, var18);
                            var13 = hasPattern(var0, var15, var10);
                            if (var13 == var10) {
                                var23 += var18;
                                var10 += (long)var18;
                                if ((long)var23 == var5) {
                                    var19 = false;
                                    var12 = true;
                                }
                            } else {
                                if (var13 == 0L) {
                                    return 0L;
                                }

                                var10 = var13 - (long)var23;
                                var19 = false;
                            }
                        }
                    }

                    return var16;
                }
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    public static long isSubLob(CLOB var0, CLOB var1, long var2) throws SQLException {
        if (var1 != null && var2 > 0L) {
            OracleConnection var4 = var0.getInternalConnection();
            long var5 = length(var4, var1, 2005);
            long var7 = length(var4, var0, 2005);
            if (var5 != 0L && var5 <= var7 - var2 + 1L && var2 <= var7) {
                if (var5 <= (long)getPlsqlMaxInstrSize(var4)) {
                    char[] var22 = new char[(int)var5];
                    var1.getChars(1L, (int)var5, var22);
                    return hasPattern(var0, var22, var2);
                } else {
                    boolean var9 = false;
                    long var10 = var2;
                    boolean var12 = false;
                    long var16 = 0L;

                    while(!var12) {
                        if (var5 > var7 - var10 + 1L) {
                            return 0L;
                        }

                        byte var20 = 0;
                        int var18 = (int)Math.min((long)getPlsqlMaxInstrSize(var4), var5 - (long)var20);
                        char[] var15 = new char[var18];
                        var1.getChars((long)(var20 + 1), var18, var15);
                        long var13 = hasPattern(var0, var15, var10);
                        if (var13 == 0L) {
                            return 0L;
                        }

                        var16 = var13;
                        int var21 = var20 + var18;
                        var10 = var13 + (long)var18;
                        boolean var19 = true;

                        while(var19) {
                            var18 = (int)Math.min((long)getPlsqlMaxInstrSize(var4), var5 - (long)var21);
                            var15 = new char[var18];
                            var1.getChars((long)(var21 + 1), var18, var15);
                            var13 = hasPattern(var0, var15, var10);
                            if (var13 == var10) {
                                var21 += var18;
                                var10 += (long)var18;
                                if ((long)var21 == var5) {
                                    var19 = false;
                                    var12 = true;
                                }
                            } else {
                                if (var13 == 0L) {
                                    return 0L;
                                }

                                var10 = var13 - (long)var21;
                                var19 = false;
                            }
                        }
                    }

                    return var16;
                }
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    public static long hasPattern(BFILE var0, byte[] var1, long var2) throws SQLException {
        return hasPattern(var0.getInternalConnection(), var0, -13, var1, var2);
    }

    public static long isSubLob(BFILE var0, BFILE var1, long var2) throws SQLException {
        return isSubLob(var0.getInternalConnection(), var0, -13, var1, var2);
    }

    public static String fileGetName(BFILE var0) throws SQLException {
        OracleCallableStatement var1 = null;
        String var2 = null;

        try {
            var1 = (OracleCallableStatement)var0.getInternalConnection().prepareCall("begin dbms_lob.fileGetName(:1, :2, :3); end; ");
            var1.setBFILE(1, var0);
            var1.registerOutParameter(2, 12);
            var1.registerOutParameter(3, 12);
            var1.execute();
            var2 = var1.getString(3);
        } finally {
            if (var1 != null) {
                var1.close();
                var1 = null;
            }

        }

        return var2;
    }

    public static String fileGetDirAlias(BFILE var0) throws SQLException {
        OracleCallableStatement var1 = null;
        String var2 = null;

        try {
            var1 = (OracleCallableStatement)var0.getInternalConnection().prepareCall("begin dbms_lob.fileGetName(:1, :2, :3); end; ");
            var1.setBFILE(1, var0);
            var1.registerOutParameter(2, 12);
            var1.registerOutParameter(3, 12);
            var1.execute();
            var2 = var1.getString(2);
        } finally {
            if (var1 != null) {
                var1.close();
                var1 = null;
            }

        }

        return var2;
    }

    private static int getPlsqlMaxInstrSize(OracleConnection var0) throws SQLException {
        boolean var1 = var0.isCharSetMultibyte(var0.getDriverCharSet());
        int var2 = var0.getMaxCharbyteSize();
        int var3 = 32512;
        if (var1) {
            var3 = 32512 / (var0.getC2SNlsRatio() * var2);
        }

        return var3;
    }

    public static long read(OracleConnection var0, Datum var1, int var2, long var3, long var5, byte[] var7) throws SQLException {
        OracleCallableStatement var8 = null;
        int var9 = 0;

        try {
            var8 = (OracleCallableStatement)var0.prepareCall("begin dbms_lob.read (:1, :2, :3, :4); end;");
            boolean var10 = false;
            boolean var11 = false;
            if (isNCLOB(var1)) {
                var8.setFormOfUse(1, (short)2);
                var8.setFormOfUse(4, (short)2);
            }

            var8.setObject(1, var1, var2);
            var8.registerOutParameter(2, 2);
            var8.registerOutParameter(4, -3);

            while((long)var9 < var5) {
                int var19 = Math.min((int)var5, 32512);
                var8.setInt(2, var19);
                var8.setInt(3, (int)var3 + var9);
                var8.execute();
                int var18 = var8.getInt(2);
                byte[] var12 = var8.getBytes(4);
                var18 = Math.min(var18, var12.length);
                System.arraycopy(var12, 0, var7, var9, var18);
                var9 += var18;
                var5 -= (long)var18;
            }
        } catch (SQLException var16) {
            if (var16.getErrorCode() != 1403) {
                throw var16;
            }
        } finally {
            if (var8 != null) {
                var8.close();
                var8 = null;
            }

        }

        return (long)var9;
    }

    public static long length(OracleConnection var0, Datum var1, int var2) throws SQLException {
        long var3 = 0L;
        OracleCallableStatement var5 = null;

        try {
            var5 = (OracleCallableStatement)var0.prepareCall("begin :1 := dbms_lob.getLength (:2); end;");
            if (isNCLOB(var1)) {
                var5.setFormOfUse(2, (short)2);
            }

            var5.setObject(2, var1, var2);
            var5.registerOutParameter(1, 2);
            var5.execute();
            var3 = var5.getLong(1);
        } finally {
            if (var5 != null) {
                var5.close();
                var5 = null;
            }

        }

        return var3;
    }

    public static long hasPattern(OracleConnection var0, Datum var1, int var2, byte[] var3, long var4) throws SQLException {
        if (var3 != null && var4 > 0L) {
            long var6 = (long)var3.length;
            long var8 = length(var0, var1, var2);
            if (var6 != 0L && var6 <= var8 - var4 + 1L && var4 <= var8) {
                long var11;
                if (var6 <= 32512L) {
                    OracleCallableStatement var25 = null;

                    try {
                        var25 = (OracleCallableStatement)var0.prepareCall("begin :1 := dbms_lob.instr(:2, :3, :4); end;");
                        var25.registerOutParameter(1, 2);
                        var25.setObject(2, var1, var2);
                        var25.setBytes(3, var3);
                        var25.setLong(4, var4);
                        var25.execute();
                        var11 = var25.getLong(1);
                    } finally {
                        var25.close();
                        var25 = null;
                    }

                    return var11;
                } else {
                    boolean var10 = false;
                    var11 = var4;
                    boolean var13 = false;
                    long var17 = 0L;

                    while(!var13) {
                        if (var6 > var8 - var11 + 1L) {
                            return 0L;
                        }

                        byte var23 = 0;
                        int var19 = (int)Math.min(32512L, var6 - (long)var23);
                        byte[] var16 = new byte[var19];
                        System.arraycopy(var3, var23, var16, 0, var19);
                        long var14 = hasPattern(var0, var1, var2, var16, var11);
                        if (var14 == 0L) {
                            return 0L;
                        }

                        var17 = var14;
                        int var24 = var23 + var19;
                        var11 = var14 + (long)var19;
                        boolean var20 = true;

                        while(var20) {
                            var19 = (int)Math.min(32512L, var6 - (long)var24);
                            var16 = new byte[var19];
                            System.arraycopy(var3, var24, var16, 0, var19);
                            var14 = hasPattern(var0, var1, var2, var16, var11);
                            if (var14 == var11) {
                                var24 += var19;
                                var11 += (long)var19;
                                if ((long)var24 == var6) {
                                    var20 = false;
                                    var13 = true;
                                }
                            } else {
                                if (var14 == 0L) {
                                    return 0L;
                                }

                                var11 = var14 - (long)var24;
                                var20 = false;
                            }
                        }
                    }

                    return var17;
                }
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    public static long isSubLob(OracleConnection var0, Datum var1, int var2, Datum var3, long var4) throws SQLException {
        if (var3 != null && var4 > 0L) {
            long var6 = length(var0, var3, var2);
            long var8 = length(var0, var1, var2);
            if (var6 != 0L && var6 <= var8 - var4 + 1L && var4 <= var8) {
                if (var6 <= 32512L) {
                    byte[] var23 = new byte[(int)var6];
                    read(var0, var3, var2, 1L, var6, var23);
                    return hasPattern(var0, var1, var2, var23, var4);
                } else {
                    boolean var10 = false;
                    long var11 = var4;
                    boolean var13 = false;
                    long var17 = 0L;

                    while(!var13) {
                        if (var6 > var8 - var11 + 1L) {
                            return 0L;
                        }

                        byte var21 = 0;
                        int var19 = (int)Math.min(32512L, var6 - (long)var21);
                        byte[] var16 = new byte[var19];
                        read(var0, var3, var2, (long)(var21 + 1), (long)var19, var16);
                        long var14 = hasPattern(var0, var1, var2, var16, var11);
                        if (var14 == 0L) {
                            return 0L;
                        }

                        var17 = var14;
                        int var22 = var21 + var19;
                        var11 = var14 + (long)var19;
                        boolean var20 = true;

                        while(var20) {
                            var19 = (int)Math.min(32512L, var6 - (long)var22);
                            var16 = new byte[var19];
                            read(var0, var3, var2, (long)(var22 + 1), (long)var19, var16);
                            var14 = hasPattern(var0, var1, var2, var16, var11);
                            if (var14 == var11) {
                                var22 += var19;
                                var11 += (long)var19;
                                if ((long)var22 == var6) {
                                    var20 = false;
                                    var13 = true;
                                }
                            } else {
                                if (var14 == 0L) {
                                    return 0L;
                                }

                                var11 = var14 - (long)var22;
                                var20 = false;
                            }
                        }
                    }

                    return var17;
                }
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    private static boolean isNCLOB(Datum var0) {
        Class var1 = null;

        try {
            var1 = Class.forName("oracle.sql.CLOB");
        } catch (ClassNotFoundException var3) {
            return false;
        }

        if (!var1.isInstance(var0)) {
            return false;
        } else {
            CLOB var2 = (CLOB)var0;
            return var2.isNCLOB();
        }
    }

    public static Datum createTemporaryLob(Connection var0, boolean var1, int var2, int var3, short var4) throws SQLException {
        OracleCallableStatement var5 = null;
        Datum var6 = null;

        try {
            var5 = (OracleCallableStatement)var0.prepareCall("begin dbms_lob.createTemporary (:1," + (var1 ? "TRUE" : "FALSE") + ", :2); end;");
            var5.registerOutParameter(1, var3);
            var5.setFormOfUse(1, var4);
            var5.setInt(2, var2);
            var5.execute();
            var6 = var5.getOracleObject(1);
        } finally {
            if (var5 != null) {
                var5.close();
                var5 = null;
            }

        }

        return var6;
    }

    public static void freeTemporaryLob(Connection var0, Datum var1, int var2) throws SQLException {
        OracleCallableStatement var3 = null;

        try {
            var3 = (OracleCallableStatement)var0.prepareCall("begin dbms_lob.freeTemporary (:1); end;");
            var3.registerOutParameter(1, var2);
            if (isNCLOB(var1)) {
                var3.setFormOfUse(1, (short)2);
            }

            var3.setOracleObject(1, var1);
            var3.execute();
            Datum var4 = var3.getOracleObject(1);
            byte[] var5 = var4.shareBytes();
            var1.setShareBytes(var5);
        } finally {
            if (var3 != null) {
                var3.close();
                var3 = null;
            }

        }

    }
}
