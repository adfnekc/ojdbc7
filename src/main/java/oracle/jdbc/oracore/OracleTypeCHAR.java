//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CHAR;
import oracle.sql.CharacterSet;
import oracle.sql.Datum;

public class OracleTypeCHAR extends OracleType implements Serializable {
    static final long serialVersionUID = -6899444518695804629L;
    int form;
    int charset;
    int length;
    int characterSemantic;
    private transient OracleConnection connection;
    private short pickleCharaterSetId;
    private transient CharacterSet pickleCharacterSet;
    private short pickleNcharCharacterSet;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeCHAR() {
    }

    public OracleTypeCHAR(OracleConnection var1) {
        this.form = 0;
        this.charset = 0;
        this.length = 0;
        this.connection = var1;
        this.pickleCharaterSetId = 0;
        this.pickleNcharCharacterSet = 0;
        this.pickleCharacterSet = null;

        try {
            this.pickleCharaterSetId = this.connection.getStructAttrCsId();
        } catch (SQLException var3) {
            this.pickleCharaterSetId = -1;
        }

        this.pickleCharacterSet = CharacterSet.make(this.pickleCharaterSetId);
    }

    protected OracleTypeCHAR(OracleConnection var1, int var2) {
        super(var2);
        this.form = 0;
        this.charset = 0;
        this.length = 0;
        this.connection = var1;
        this.pickleCharaterSetId = 0;
        this.pickleNcharCharacterSet = 0;
        this.pickleCharacterSet = null;

        try {
            this.pickleCharaterSetId = this.connection.getStructAttrCsId();
        } catch (SQLException var4) {
            this.pickleCharaterSetId = -1;
        }

        this.pickleCharacterSet = CharacterSet.make(this.pickleCharaterSetId);
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            CHAR var3 = var1 instanceof CHAR ? (CHAR)var1 : new CHAR(var1, this.pickleCharacterSet);
            return var3;
        }
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        Datum[] var6 = null;
        if (var1 != null) {
            if (var1 instanceof Object[] && !(var1 instanceof char[][])) {
                return super.toDatumArray(var1, var2, var3, var5);
            }

            var6 = this.cArrayToDatumArray(var1, var2, var3, var5);
        }

        return var6;
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        super.parseTDSrec(var1);

        try {
            this.length = var1.readUB2();
            this.form = var1.readByte();
            this.characterSemantic = this.form & 128;
            this.form &= 127;
            this.charset = var1.readUB2();
            if (this.form == 2) {
                switch(this.typeCode) {
                    case 1:
                        this.typeCode = -15;
                        break;
                    case 12:
                        this.typeCode = -9;
                }
            }
        } catch (SQLException var5) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 47, "parseTDS");
            var3.fillInStackTrace();
            throw var3;
        }

        if (this.form == 2 && this.pickleNcharCharacterSet == 0) {
            try {
                this.pickleNcharCharacterSet = this.connection.getStructAttrNCsId();
            } catch (SQLException var4) {
                this.pickleNcharCharacterSet = 2000;
            }

            this.pickleCharaterSetId = this.pickleNcharCharacterSet;
            this.pickleCharacterSet = CharacterSet.make(this.pickleCharaterSetId);
        }
    }

    protected int pickle81(PickleContext var1, Datum var2) throws SQLException {
        CHAR var3 = this.getDbCHAR(var2);
        SQLException var4;
        if (this.characterSemantic != 0 && this.form != 2) {
            if (var3.getStringWithReplacement().length() > this.length) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 72, "\"" + var3.getStringWithReplacement() + "\"");
                var4.fillInStackTrace();
                throw var4;
            }
        } else if (var3.getLength() > (long)this.length) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 72, "\"" + var3.getStringWithReplacement() + "\"");
            var4.fillInStackTrace();
            throw var4;
        }

        return super.pickle81(var1, var3);
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            CHAR var4 = null;
            switch(this.form) {
                case 1:
                case 2:
                    var4 = new CHAR(var1, this.pickleCharacterSet);
                    break;
                case 3:
                case 4:
                case 5:
                    var4 = new CHAR(var1, (CharacterSet)null);
            }

            if (var2 == 1) {
                return var4;
            } else if (var2 == 2) {
                return var4.stringValue();
            } else if (var2 == 3) {
                return var1;
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var5.fillInStackTrace();
                throw var5;
            }
        } else {
            return null;
        }
    }

    private CHAR getDbCHAR(Datum var1) {
        CHAR var2 = (CHAR)var1;
        CHAR var3 = null;
        if (var2.getCharacterSet().getOracleId() == this.pickleCharaterSetId) {
            var3 = var2;
        } else {
            try {
                var3 = new CHAR(var2.toString(), this.pickleCharacterSet);
            } catch (SQLException var5) {
                var3 = var2;
            }
        }

        return var3;
    }

    private Datum[] cArrayToDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        Datum[] var6 = null;
        if (var1 != null) {
            int var8;
            int var9;
            if (var1 instanceof char[][]) {
                char[][] var7 = (char[][])((char[][])var1);
                var8 = (int)(var5 == -1 ? (long)var7.length : Math.min((long)var7.length - var3 + 1L, (long)var5));
                var6 = new Datum[var8];

                for(var9 = 0; var9 < var8; ++var9) {
                    var6[var9] = new CHAR(new String(var7[(int)var3 + var9 - 1]), this.pickleCharacterSet);
                }
            } else if (var1 instanceof boolean[]) {
                boolean[] var10 = (boolean[])((boolean[])var1);
                var8 = (int)(var5 == -1 ? (long)var10.length : Math.min((long)var10.length - var3 + 1L, (long)var5));
                var6 = new Datum[var8];

                for(var9 = 0; var9 < var8; ++var9) {
                    var6[var9] = new CHAR(var10[(int)var3 + var9 - 1], this.pickleCharacterSet);
                }
            } else if (var1 instanceof short[]) {
                short[] var11 = (short[])((short[])var1);
                var8 = (int)(var5 == -1 ? (long)var11.length : Math.min((long)var11.length - var3 + 1L, (long)var5));
                var6 = new Datum[var8];

                for(var9 = 0; var9 < var8; ++var9) {
                    var6[var9] = new CHAR(Integer.valueOf(var11[(int)var3 + var9 - 1]), this.pickleCharacterSet);
                }
            } else if (var1 instanceof int[]) {
                int[] var12 = (int[])((int[])var1);
                var8 = (int)(var5 == -1 ? (long)var12.length : Math.min((long)var12.length - var3 + 1L, (long)var5));
                var6 = new Datum[var8];

                for(var9 = 0; var9 < var8; ++var9) {
                    var6[var9] = new CHAR(var12[(int)var3 + var9 - 1], this.pickleCharacterSet);
                }
            } else if (var1 instanceof long[]) {
                long[] var13 = (long[])((long[])var1);
                var8 = (int)(var5 == -1 ? (long)var13.length : Math.min((long)var13.length - var3 + 1L, (long)var5));
                var6 = new Datum[var8];

                for(var9 = 0; var9 < var8; ++var9) {
                    var6[var9] = new CHAR(new Long(var13[(int)var3 + var9 - 1]), this.pickleCharacterSet);
                }
            } else if (var1 instanceof float[]) {
                float[] var14 = (float[])((float[])var1);
                var8 = (int)(var5 == -1 ? (long)var14.length : Math.min((long)var14.length - var3 + 1L, (long)var5));
                var6 = new Datum[var8];

                for(var9 = 0; var9 < var8; ++var9) {
                    var6[var9] = new CHAR(new Float(var14[(int)var3 + var9 - 1]), this.pickleCharacterSet);
                }
            } else {
                if (!(var1 instanceof double[])) {
                    SQLException var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                    var16.fillInStackTrace();
                    throw var16;
                }

                double[] var15 = (double[])((double[])var1);
                var8 = (int)(var5 == -1 ? (long)var15.length : Math.min((long)var15.length - var3 + 1L, (long)var5));
                var6 = new Datum[var8];

                for(var9 = 0; var9 < var8; ++var9) {
                    var6[var9] = new CHAR(new Double(var15[(int)var3 + var9 - 1]), this.pickleCharacterSet);
                }
            }
        }

        return var6;
    }

    public int getLength() {
        return this.length;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeInt(this.form);
        var1.writeInt(this.charset);
        var1.writeInt(this.length);
        var1.writeInt(this.characterSemantic);
        var1.writeShort(this.pickleCharaterSetId);
        var1.writeShort(this.pickleNcharCharacterSet);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.form = var1.readInt();
        this.charset = var1.readInt();
        this.length = var1.readInt();
        this.characterSemantic = var1.readInt();
        this.pickleCharaterSetId = var1.readShort();
        this.pickleNcharCharacterSet = var1.readShort();
        if (this.pickleNcharCharacterSet != 0) {
            this.pickleCharacterSet = CharacterSet.make(this.pickleNcharCharacterSet);
        } else {
            this.pickleCharacterSet = CharacterSet.make(this.pickleCharaterSetId);
        }

    }

    public void setConnection(OracleConnection var1) throws SQLException {
        this.connection = var1;
    }

    public boolean isNCHAR() throws SQLException {
        return this.form == 2;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
