//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class CharacterConverter1Byte extends CharacterConverterJDBC {
    static final long serialVersionUID = 200017349723606452L;
    static final int ORACHARMASK = 255;
    static final int UCSCHARWIDTH = 16;
    public int m_ucsReplacement = 0;
    public int[] m_ucsChar = null;
    public char[] m_oraCharLevel1 = null;
    public char[] m_oraCharSurrogateLevel = null;
    public char[] m_oraCharLevel2 = null;
    public byte m_oraCharReplacement = 0;
    protected transient boolean noSurrogate = true;
    protected transient boolean strictASCII = true;
    protected transient int m_oraCharLevel2Size = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public CharacterConverter1Byte() {
        this.m_groupId = 0;
    }

    int toUnicode(byte var1) throws SQLException {
        int var2 = this.m_ucsChar[var1 & 255];
        if (var2 == -1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 154);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return var2;
        }
    }

    int toUnicodeWithReplacement(byte var1) {
        int var2 = this.m_ucsChar[var1 & 255];
        return var2 == -1 ? this.m_ucsReplacement : var2;
    }

    byte toOracleCharacter(char var1, char var2) throws SQLException {
        int var3 = var1 >>> 8 & 255;
        int var4 = var1 & 255;
        int var5 = var2 >>> 8 & 255;
        int var6 = var2 & 255;
        if (this.m_oraCharLevel1[var3] != (char)this.m_oraCharLevel2Size && this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] != '\uffff' && this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] + var5] != '\uffff' && this.m_oraCharLevel2[this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] + var5] + var6] != '\uffff') {
            return (byte)this.m_oraCharLevel2[this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] + var5] + var6];
        } else {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 155);
            var7.fillInStackTrace();
            throw var7;
        }
    }

    byte toOracleCharacter(char var1) throws SQLException {
        int var2 = var1 >>> 8;
        int var3 = var1 & 255;
        char var4;
        if ((var4 = this.m_oraCharLevel2[this.m_oraCharLevel1[var2] + var3]) != '\uffff') {
            return (byte)var4;
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 155);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    byte toOracleCharacterWithReplacement(char var1, char var2) {
        int var3 = var1 >>> 8 & 255;
        int var4 = var1 & 255;
        int var5 = var2 >>> 8 & 255;
        int var6 = var2 & 255;
        return this.m_oraCharLevel1[var3] != (char)this.m_oraCharLevel2Size && this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] != '\uffff' && this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] + var5] != '\uffff' && this.m_oraCharLevel2[this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] + var5] + var6] != '\uffff' ? (byte)this.m_oraCharLevel2[this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var3] + var4] + var5] + var6] : this.m_oraCharReplacement;
    }

    byte toOracleCharacterWithReplacement(char var1) {
        int var2 = var1 >>> 8;
        int var3 = var1 & 255;
        char var4;
        return (var4 = this.m_oraCharLevel2[this.m_oraCharLevel1[var2] + var3]) != '\uffff' ? (byte)var4 : this.m_oraCharReplacement;
    }

    public int toUnicodeChars(byte[] var1, int var2, char[] var3, int var4, int var5) throws SQLException {
        int var6 = var2 + var5;
        boolean var7 = false;
        int var10 = var4;

        int var8;
        for(var8 = var2; var8 < var6 && var10 < var3.length; ++var8) {
            int var12 = this.m_ucsChar[var1[var8] & 255];
            if (var12 == this.m_ucsReplacement) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 154);
                var11.fillInStackTrace();
                throw var11;
            }

            if (((long)var12 & 4294967295L) > 65535L) {
                if (var10 + 2 < var3.length) {
                    --var8;
                    break;
                }

                var3[var10++] = (char)(var12 >>> 16);
                var3[var10++] = (char)(var12 & '\uffff');
            } else {
                var3[var10++] = (char)var12;
            }
        }

        return var8;
    }

    public String toUnicodeString(byte[] var1, int var2, int var3) throws SQLException {
        int var4 = var2 + var3;
        StringBuilder var5 = new StringBuilder(var3);
        boolean var6 = false;

        for(int var7 = var2; var7 < var4; ++var7) {
            int var10 = this.m_ucsChar[var1[var7] & 255];
            if (var10 == this.m_ucsReplacement) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 154);
                var9.fillInStackTrace();
                throw var9;
            }

            if (((long)var10 & 4294967295L) > 65535L) {
                var5.append((char)(var10 >>> 16));
                var5.append((char)(var10 & '\uffff'));
            } else {
                var5.append((char)var10);
            }
        }

        return var5.substring(0, var5.length());
    }

    public String toUnicodeStringWithReplacement(byte[] var1, int var2, int var3) {
        int var4 = var2 + var3;
        StringBuilder var5 = new StringBuilder(var3);
        boolean var6 = false;

        for(int var7 = var2; var7 < var4; ++var7) {
            int var9 = this.m_ucsChar[var1[var7] & 255];
            if (var9 == -1) {
                var5.append((char)this.m_ucsReplacement);
            } else {
                var5.append((char)var9);
            }
        }

        return var5.substring(0, var5.length());
    }

    public byte[] toOracleString(String var1) throws SQLException {
        int var2 = var1.length();
        if (var2 == 0) {
            return new byte[0];
        } else {
            char[] var3 = new char[var2];
            var1.getChars(0, var2, var3, 0);
            byte[] var4 = new byte[var2 * 4];
            int var6 = 0;

            for(int var7 = 0; var7 < var2; ++var7) {
                if (var3[var7] >= '\ud800' && var3[var7] < '\udc00') {
                    SQLException var8;
                    if (var7 + 1 >= var2 || var3[var7 + 1] < '\udc00' || var3[var7 + 1] > '\udfff') {
                        var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 155);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    if (this.noSurrogate) {
                        var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 155);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    var4[var6++] = this.toOracleCharacter(var3[var7], var3[var7 + 1]);
                    ++var7;
                } else if (var3[var7] < 128 && this.strictASCII) {
                    var4[var6++] = (byte)var3[var7];
                } else {
                    var4[var6++] = this.toOracleCharacter(var3[var7]);
                }
            }

            if (var6 < var4.length) {
                byte[] var9 = new byte[var6];
                System.arraycopy(var4, 0, var9, 0, var6);
                return var9;
            } else {
                return var4;
            }
        }
    }

    public byte[] toOracleStringWithReplacement(String var1) {
        int var2 = var1.length();
        if (var2 == 0) {
            return new byte[0];
        } else {
            char[] var3 = new char[var2];
            var1.getChars(0, var2, var3, 0);
            byte[] var4 = new byte[var2 * 4];
            int var6 = 0;

            for(int var7 = 0; var7 < var2; ++var7) {
                if (var3[var7] >= '\ud800' && var3[var7] < '\udc00') {
                    if (var7 + 1 < var2 && var3[var7 + 1] >= '\udc00' && var3[var7 + 1] <= '\udfff') {
                        if (this.noSurrogate) {
                            var4[var6++] = this.m_oraCharReplacement;
                        } else {
                            var4[var6++] = this.toOracleCharacterWithReplacement(var3[var7], var3[var7 + 1]);
                        }

                        ++var7;
                    } else {
                        var4[var6++] = this.m_oraCharReplacement;
                    }
                } else if (var3[var7] < 128 && this.strictASCII) {
                    var4[var6++] = (byte)var3[var7];
                } else {
                    var4[var6++] = this.toOracleCharacterWithReplacement(var3[var7]);
                }
            }

            if (var6 < var4.length) {
                byte[] var8 = new byte[var6];
                System.arraycopy(var4, 0, var8, 0, var6);
                return var8;
            } else {
                return var4;
            }
        }
    }

    public void buildUnicodeToOracleMapping() {
        this.m_oraCharLevel1 = new char[256];
        this.m_oraCharSurrogateLevel = null;
        this.m_oraCharLevel2 = null;
        Vector var1 = new Vector(45055, 12287);
        Hashtable var2 = new Hashtable();
        Hashtable var3 = new Hashtable();
        int var12 = this.m_ucsChar.length;
        char var13 = 0;
        char var14 = 0;

        int var15;
        for(var15 = 0; var15 < 256; ++var15) {
            this.m_oraCharLevel1[var15] = '\uffff';
        }

        int var11;
        for(var15 = 0; var15 < var12; ++var15) {
            var11 = this.m_ucsChar[var15];
            if (var11 != -1) {
                int[] var16 = new int[]{var11, var15};
                var1.addElement(var16);
                this.storeMappingRange(var11, var2, var3);
            }
        }

        if (this.extraUnicodeToOracleMapping != null) {
            var12 = this.extraUnicodeToOracleMapping.length;

            for(var15 = 0; var15 < var12; ++var15) {
                var11 = this.extraUnicodeToOracleMapping[var15][0];
                this.storeMappingRange(var11, var2, var3);
            }
        }

        Enumeration var22 = var2.keys();
        int var19 = 0;
        int var20 = 0;

        Object var17;
        char[] var18;
        while(var22.hasMoreElements()) {
            var17 = var22.nextElement();
            var18 = (char[])((char[])var2.get(var17));
            if (var18 != null) {
                var19 += 256;
            }
        }

        var22 = var3.keys();

        while(var22.hasMoreElements()) {
            var17 = var22.nextElement();
            var18 = (char[])((char[])var3.get(var17));
            if (var18 != null) {
                var20 += 256;
            }
        }

        if (var19 != 0) {
            this.m_oraCharSurrogateLevel = new char[var19];
        }

        if (var20 != 0) {
            this.m_oraCharLevel2 = new char[var20 + 256];
        }

        for(var15 = 0; var15 < var19; ++var15) {
            this.m_oraCharSurrogateLevel[var15] = '\uffff';
        }

        for(var15 = 0; var15 < var20 + 256; ++var15) {
            this.m_oraCharLevel2[var15] = '\uffff';
        }

        int var4;
        int var5;
        int var6;
        int var7;
        for(var15 = 0; var15 < var1.size(); ++var15) {
            int[] var21 = (int[])((int[])var1.elementAt(var15));
            var4 = var21[0] >> 24 & 255;
            var5 = var21[0] >> 16 & 255;
            var6 = var21[0] >> 8 & 255;
            var7 = var21[0] & 255;
            if (var4 >= 216 && var4 < 220) {
                if (this.m_oraCharLevel1[var4] == '\uffff') {
                    this.m_oraCharLevel1[var4] = var14;
                    var14 = (char)(var14 + 256);
                }

                if (this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] == '\uffff') {
                    this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] = var14;
                    var14 = (char)(var14 + 256);
                }

                if (this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] + var6] == '\uffff') {
                    this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] + var6] = var13;
                    var13 = (char)(var13 + 256);
                }

                if (this.m_oraCharLevel2[this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] + var6] + var7] == '\uffff') {
                    this.m_oraCharLevel2[this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] + var6] + var7] = (char)(var21[1] & '\uffff');
                }
            } else {
                if (this.m_oraCharLevel1[var6] == '\uffff') {
                    this.m_oraCharLevel1[var6] = var13;
                    var13 = (char)(var13 + 256);
                }

                if (this.m_oraCharLevel2[this.m_oraCharLevel1[var6] + var7] == '\uffff') {
                    this.m_oraCharLevel2[this.m_oraCharLevel1[var6] + var7] = (char)(var21[1] & '\uffff');
                }
            }
        }

        if (this.extraUnicodeToOracleMapping != null) {
            var12 = this.extraUnicodeToOracleMapping.length;

            for(var15 = 0; var15 < var12; ++var15) {
                var11 = this.extraUnicodeToOracleMapping[var15][0];
                var4 = var11 >>> 24 & 255;
                var5 = var11 >>> 16 & 255;
                var6 = var11 >>> 8 & 255;
                var7 = var11 & 255;
                if (var4 >= 216 && var4 < 220) {
                    if (this.m_oraCharLevel1[var4] == '\uffff') {
                        this.m_oraCharLevel1[var4] = var14;
                        var14 = (char)(var14 + 256);
                    }

                    if (this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] == '\uffff') {
                        this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] = var14;
                        var14 = (char)(var14 + 256);
                    }

                    if (this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] + var6] == '\uffff') {
                        this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] + var6] = var13;
                        var13 = (char)(var13 + 256);
                    }

                    this.m_oraCharLevel2[this.m_oraCharSurrogateLevel[this.m_oraCharSurrogateLevel[this.m_oraCharLevel1[var4] + var5] + var6] + var7] = (char)(this.extraUnicodeToOracleMapping[var15][1] & 255);
                } else {
                    if (this.m_oraCharLevel1[var6] == '\uffff') {
                        this.m_oraCharLevel1[var6] = var13;
                        var13 = (char)(var13 + 256);
                    }

                    this.m_oraCharLevel2[this.m_oraCharLevel1[var6] + var7] = (char)(this.extraUnicodeToOracleMapping[var15][1] & '\uffff');
                }
            }
        }

        if (this.m_oraCharSurrogateLevel == null) {
            this.noSurrogate = true;
        } else {
            this.noSurrogate = false;
        }

        this.strictASCII = true;

        for(var15 = 0; var15 < 128; ++var15) {
            if (this.m_oraCharLevel2[var15] != var15) {
                this.strictASCII = false;
                break;
            }
        }

        for(var15 = 0; var15 < 256; ++var15) {
            if (this.m_oraCharLevel1[var15] == '\uffff') {
                this.m_oraCharLevel1[var15] = (char)var20;
            }
        }

        this.m_oraCharLevel2Size = var20;
    }

    public void extractCodepoints(Vector var1) {
        byte var2 = 0;
        short var3 = 255;

        for(int var5 = var2; var5 <= var3; ++var5) {
            try {
                int[] var4 = new int[]{var5, this.toUnicode((byte)var5)};
                var1.addElement(var4);
            } catch (SQLException var7) {
            }
        }

    }

    public void extractExtraMappings(Vector var1) {
        if (this.extraUnicodeToOracleMapping != null) {
            for(int var3 = 0; var3 < this.extraUnicodeToOracleMapping.length; ++var3) {
                int[] var2 = new int[]{this.extraUnicodeToOracleMapping[var3][0], this.extraUnicodeToOracleMapping[var3][1]};
                var1.addElement(var2);
            }

        }
    }

    public boolean hasExtraMappings() {
        return this.extraUnicodeToOracleMapping != null;
    }

    public char getOraChar1ByteRep() {
        return (char)this.m_oraCharReplacement;
    }

    public char getOraChar2ByteRep() {
        return '\u0000';
    }

    public int getUCS2CharRep() {
        return this.m_ucsReplacement;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
