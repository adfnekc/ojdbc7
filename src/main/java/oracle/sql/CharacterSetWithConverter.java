//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.sql.converter.CharacterConverterFactory;
import oracle.sql.converter.CharacterConverterFactoryJDBC;
import oracle.sql.converter.JdbcCharacterConverters;

public abstract class CharacterSetWithConverter extends CharacterSet {
    public static CharacterConverterFactory ccFactory = new CharacterConverterFactoryJDBC();
    JdbcCharacterConverters m_converter;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetWithConverter(int var1, JdbcCharacterConverters var2) {
        super(var1);
        this.m_converter = var2;
    }

    static CharacterSet getInstance(int var0) {
        JdbcCharacterConverters var1 = ccFactory.make(var0);
        if (var1 == null) {
            return null;
        } else {
            CharacterSet1Byte var2 = null;
            if ((var2 = CharacterSet1Byte.getInstance(var0, var1)) != null) {
                return var2;
            } else {
                CharacterSetSJIS var3;
                if ((var3 = CharacterSetSJIS.getInstance(var0, var1)) != null) {
                    return var3;
                } else {
                    CharacterSetShift var4;
                    if ((var4 = CharacterSetShift.getInstance(var0, var1)) != null) {
                        return var4;
                    } else {
                        CharacterSet2ByteFixed var5;
                        if ((var5 = CharacterSet2ByteFixed.getInstance(var0, var1)) != null) {
                            return var5;
                        } else {
                            CharacterSetGB18030 var6;
                            if ((var6 = CharacterSetGB18030.getInstance(var0, var1)) != null) {
                                return var6;
                            } else {
                                CharacterSet12Byte var7;
                                if ((var7 = CharacterSet12Byte.getInstance(var0, var1)) != null) {
                                    return var7;
                                } else {
                                    CharacterSetJAEUC var8;
                                    if ((var8 = CharacterSetJAEUC.getInstance(var0, var1)) != null) {
                                        return var8;
                                    } else {
                                        CharacterSetZHTEUC var9;
                                        return (CharacterSet)((var9 = CharacterSetZHTEUC.getInstance(var0, var1)) != null ? var9 : CharacterSetLCFixed.getInstance(var0, var1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isLossyFrom(CharacterSet var1) {
        return var1.getOracleId() != this.getOracleId();
    }

    public boolean isConvertibleFrom(CharacterSet var1) {
        return var1.getOracleId() == this.getOracleId();
    }

    public String toStringWithReplacement(byte[] var1, int var2, int var3) {
        return this.m_converter.toUnicodeStringWithReplacement(var1, var2, var3);
    }

    public String toString(byte[] var1, int var2, int var3) throws SQLException {
        return this.m_converter.toUnicodeString(var1, var2, var3);
    }

    public byte[] convert(String var1) throws SQLException {
        return this.m_converter.toOracleString(var1);
    }

    public byte[] convertWithReplacement(String var1) {
        return this.m_converter.toOracleStringWithReplacement(var1);
    }

    public byte[] convert(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException {
        return var1.getOracleId() == this.getOracleId() ? useOrCopy(var2, var3, var4) : this.convert(var1.toString(var2, var3, var4));
    }
}
