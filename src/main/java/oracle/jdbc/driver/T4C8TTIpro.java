//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;

class T4C8TTIpro extends T4CTTIMsg {
    short svrCharSet;
    short svrCharSetElem;
    byte svrFlags;
    byte[] proSvrStr;
    short proSvrVer;
    short oVersion = -1;
    boolean svrInfoAvailable = false;
    byte[] proCliVerTTC8 = new byte[]{6, 5, 4, 3, 2, 1, 0};
    byte[] proCliStrTTC8 = new byte[]{74, 97, 118, 97, 95, 84, 84, 67, 45, 56, 46, 50, 46, 48, 0};
    short NCHAR_CHARSET = 0;
    byte[] runtimeCapabilities = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4C8TTIpro(T4CConnection var1) throws SQLException, IOException {
        super(var1, (byte)1);
    }

    byte[] receive() throws SQLException, IOException {
        SQLException var8;
        if (this.meg.unmarshalUB1() != 1) {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
            var8.fillInStackTrace();
            throw var8;
        } else {
            this.proSvrVer = this.meg.unmarshalUB1();
            this.meg.proSvrVer = this.proSvrVer;
            switch(this.proSvrVer) {
                case 4:
                    this.oVersion = 7230;
                    break;
                case 5:
                    this.oVersion = 8030;
                    break;
                case 6:
                    this.oVersion = 8100;
                    break;
                default:
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 444);
                    var8.fillInStackTrace();
                    throw var8;
            }

            this.meg.unmarshalUB1();
            this.proSvrStr = this.meg.unmarshalTEXT(50);
            this.oVersion = this.getOracleVersion();
            this.svrCharSet = (short)this.meg.unmarshalUB2();
            this.svrFlags = (byte)this.meg.unmarshalUB1();
            if ((this.svrCharSetElem = (short)this.meg.unmarshalUB2()) > 0) {
                this.meg.unmarshalNBytes(this.svrCharSetElem * 5);
            }

            this.svrInfoAvailable = true;
            if (this.proSvrVer < 5) {
                return null;
            } else {
                byte var1 = this.meg.types.getRep((byte)1);
                this.meg.types.setRep((byte)1, (byte)0);
                int var2 = this.meg.unmarshalUB2();
                this.meg.types.setRep((byte)1, var1);
                byte[] var3 = this.meg.unmarshalNBytes(var2);
                int var4 = 6 + (var3[5] & 255) + (var3[6] & 255);
                this.NCHAR_CHARSET = (short)((var3[var4 + 3] & 255) << 8);
                this.NCHAR_CHARSET |= (short)(var3[var4 + 4] & 255);
                if (this.proSvrVer < 6) {
                    return null;
                } else {
                    short var5 = this.meg.unmarshalUB1();
                    byte[] var6 = new byte[var5];

                    int var7;
                    for(var7 = 0; var7 < var5; ++var7) {
                        var6[var7] = (byte)this.meg.unmarshalUB1();
                    }

                    var5 = this.meg.unmarshalUB1();
                    if (var5 > 0) {
                        this.runtimeCapabilities = new byte[var5];

                        for(var7 = 0; var7 < var5; ++var7) {
                            this.runtimeCapabilities[var7] = (byte)this.meg.unmarshalUB1();
                        }
                    }

                    return var6;
                }
            }
        }
    }

    short getOracleVersion() {
        return this.oVersion;
    }

    byte[] getServerRuntimeCapabilities() {
        return this.runtimeCapabilities;
    }

    short getCharacterSet() {
        return this.svrCharSet;
    }

    short getncharCHARSET() {
        return this.NCHAR_CHARSET;
    }

    byte getFlags() {
        return this.svrFlags;
    }

    void marshal() throws SQLException, IOException {
        this.marshalTTCcode();
        this.meg.marshalB1Array(this.proCliVerTTC8);
        this.meg.marshalB1Array(this.proCliStrTTC8);
    }

    void printServerInfo() {
        if (this.svrInfoAvailable) {
            int var1 = 0;
            StringWriter var2 = new StringWriter();
            var2.write("Protocol string  =");

            while(var1 < this.proSvrStr.length) {
                var2.write((char)this.proSvrStr[var1++]);
            }
        }

    }
}
