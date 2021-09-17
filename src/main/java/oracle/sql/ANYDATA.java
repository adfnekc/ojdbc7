//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleData;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.InternalFactory;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oracore.PickleContext;
import oracle.xdb.XMLType;

public class ANYDATA implements ORAData, OracleData {
    static final byte KAD_VSN = 1;
    static final byte KAD_VSN2 = 2;
    boolean isNull;
    byte[] data;
    TypeDescriptor type;
    boolean isREF = false;
    short serverCharsetId = 0;
    short serverNCharsetId = 0;
    OracleConnection connection;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ANYDATA(TypeDescriptor var1, boolean var2, byte[] var3, boolean var4) {
        this.type = var1;
        this.isNull = var2;
        this.data = var3;
        this.isREF = var4;
    }

    public ANYDATA(OPAQUE var1) throws SQLException {
        byte[] var2 = var1.getBytesValue();
        this.connection = var1.getPhysicalConnection();
        if (this.connection != null) {
            this.serverCharsetId = this.connection.getDbCsId();
            this.serverNCharsetId = this.connection.getNCharSet();
        }

        this.unpickle(var2, 0);
    }

    int unpickle(byte[] var1, int var2) throws SQLException {
        PickleContext var3 = new PickleContext(var1, (long)var2);
        byte var4 = var3.readByte();
        if (var4 == 2) {
            var3.skipBytes(4);
        }

        short[] var5 = new short[1];
        this.type = TypeDescriptor.unpickleOpaqueTypeImage(var3, this.connection, var5);
        if (var3.readByte() != 0) {
            this.isNull = true;
        } else {
            this.isNull = false;
        }

        int var6;
        if (!this.isNull) {
            var6 = (int)var3.readUB4();
            this.data = var3.readDataValue(var6);
        }

        if (var5[0] == 110) {
            this.isREF = true;
        } else {
            this.isREF = false;
        }

        var6 = var3.offset();
        return var6;
    }

    int pickle(byte[] var1, int var2) {
        var1[var2++] = 1;
        var2 = this.type.pickleOpaqueTypeImage(var1, var2, this.isREF);
        if (this.isNull) {
            var1[var2++] = 1;
        } else {
            var1[var2++] = 0;
        }

        if (!this.isNull) {
            int var3 = this.data.length;
            var1[var2++] = (byte)((var3 & -16777216) >> 24 & 255);
            var1[var2++] = (byte)((var3 & 16711680) >> 16 & 255);
            var1[var2++] = (byte)((var3 & '\uff00') >> 8 & 255);
            var1[var2++] = (byte)(var3 & 255);
            System.arraycopy(this.data, 0, var1, var2, var3);
            var2 += var3;
        }

        return var2;
    }

    int getImageSize() {
        int var1 = this.type.getOpaqueImageTypeSize() + 1 + 1;
        if (!this.isNull) {
            var1 += 4 + this.data.length;
        }

        return var1;
    }

    public Datum toDatum(Connection var1) throws SQLException {
        this.connection = (OracleConnection)var1;
        OpaqueDescriptor var2 = OpaqueDescriptor.createDescriptor("SYS.ANYDATA", var1);
        byte[] var3 = new byte[this.getImageSize()];
        this.pickle(var3, 0);
        OPAQUE var4 = new OPAQUE(var2, this.connection, var3);
        var4.setShareBytes(var4.toBytes());
        return var4;
    }

    public Object toJDBCObject(Connection var1) throws SQLException {
        return this.toDatum(var1);
    }

    public static ANYDATA convertDatum(Datum var0) throws SQLException {
        ANYDATA var1 = null;
        if (var0 != null) {
            if (var0 instanceof STRUCT) {
                var1 = new ANYDATA(((STRUCT)var0).getDescriptor(), false, ((STRUCT)var0).toBytes(), false);
            } else if (var0 instanceof ARRAY) {
                var1 = new ANYDATA(((ARRAY)var0).getDescriptor(), false, ((ARRAY)var0).toBytes(), false);
            } else if (var0 instanceof REF) {
                var1 = new ANYDATA(((REF)var0).getDescriptor(), false, ((REF)var0).getBytes(), true);
            } else if (var0 instanceof OPAQUE) {
                var1 = new ANYDATA(((OPAQUE)var0).getDescriptor(), false, ((OPAQUE)var0).toBytes(), false);
            } else {
                TypeDescriptor var2 = null;
                if (var0 instanceof NUMBER) {
                    var2 = new TypeDescriptor((short)2);
                } else if (var0 instanceof DATE) {
                    var2 = new TypeDescriptor((short)12);
                } else if (var0 instanceof INTERVALDS) {
                    var2 = new TypeDescriptor((short)190);
                } else if (var0 instanceof INTERVALYM) {
                    var2 = new TypeDescriptor((short)189);
                } else if (var0 instanceof TIMESTAMPTZ) {
                    var2 = new TypeDescriptor((short)188);
                } else if (var0 instanceof TIMESTAMPLTZ) {
                    var2 = new TypeDescriptor((short)232);
                } else if (var0 instanceof TIMESTAMP) {
                    var2 = new TypeDescriptor((short)187);
                } else if (var0 instanceof NCLOB) {
                    var2 = new TypeDescriptor((short)288);
                } else if (var0 instanceof CLOB) {
                    var2 = new TypeDescriptor((short)112);
                } else if (var0 instanceof BLOB) {
                    var2 = new TypeDescriptor((short)113);
                } else if (var0 instanceof BFILE) {
                    var2 = new TypeDescriptor((short)114);
                } else if (var0 instanceof RAW) {
                    var2 = new TypeDescriptor((short)95);
                } else if (var0 instanceof BINARY_DOUBLE) {
                    var2 = new TypeDescriptor((short)101);
                } else if (var0 instanceof BINARY_FLOAT) {
                    var2 = new TypeDescriptor((short)100);
                } else if (var0 instanceof ROWID) {
                    var2 = new TypeDescriptor((short)104);
                } else if (var0 instanceof CHAR) {
                    var2 = new TypeDescriptor((short)96);
                }

                if (var0 instanceof ROWID) {
                    byte[] var3 = var0.shareBytes();
                    long[] var4 = InternalFactory.rowid2urowid(var3, 0, var3.length);
                    byte[] var5 = new byte[]{1, (byte)((int)((var4[0] & -16777216L) >> 24)), (byte)((int)((var4[0] & 16711680L) >> 16)), (byte)((int)((var4[0] & 65280L) >> 8)), (byte)((int)(var4[0] & 255L)), (byte)((int)((var4[1] & 65280L) >> 8)), (byte)((int)(var4[1] & 255L)), (byte)((int)((var4[2] & -16777216L) >> 24)), (byte)((int)((var4[2] & 16711680L) >> 16)), (byte)((int)((var4[2] & 65280L) >> 8)), (byte)((int)(var4[2] & 255L)), (byte)((int)((var4[3] & 65280L) >> 8)), (byte)((int)(var4[3] & 255L))};
                    var1 = new ANYDATA(var2, false, var5, false);
                } else {
                    var1 = new ANYDATA(var2, false, var0.shareBytes(), false);
                }
            }

            if (var0 instanceof DatumWithConnection) {
                var1.connection = ((DatumWithConnection)var0).getInternalConnection();
            }
        }

        return var1;
    }

    public TypeDescriptor getTypeDescriptor() {
        return this.type;
    }

    public boolean isNull() {
        return this.isNull;
    }

    public byte[] getData() {
        return this.data;
    }

    public boolean isREF() {
        return this.isREF;
    }

    public String stringValue() throws SQLException {
        return this.stringValue(this.connection);
    }

    public String stringValue(Connection var1) throws SQLException {
        String var2 = null;
        var2 = "ANYDATA TypeCode: \"" + this.getTypeDescriptor().getTypeCodeName();
        if (this.isREF) {
            var2 = var2 + "(REF)";
        }

        var2 = var2 + "\" - ANYDATA Value: \"";
        Datum var3 = this.accessDatum();
        boolean var4 = false;

        try {
            var2 = var2 + var3.stringValue();
            var4 = true;
        } catch (SQLException var17) {
        }

        if (!var4) {
            if ((this.type.getInternalTypeCode() == 108 || this.type.getInternalTypeCode() == 110) && !this.type.isTransient()) {
                var2 = var2 + ((StructDescriptor)this.type).getName() + "(...)";
            } else if (this.type.getInternalTypeCode() == 122 && !this.type.isTransient()) {
                var2 = var2 + ((ArrayDescriptor)this.type).getName() + "(...)";
            } else {
                switch(this.type.getInternalTypeCode()) {
                    case 58:
                        OPAQUE var20 = (OPAQUE)var3;
                        String var21 = var20.getSQLTypeName();
                        var2 = var2 + "OPAQUE(" + var21 + ")";
                        if (var21.compareTo("SYS.XMLTYPE") == 0) {
                            var2 = var2 + ":";
                            XMLType var22 = (XMLType) XMLType.createXML(var20);
                            var2 = var2 + var22.getStringVal();
                        }
                        break;
                    case 113:
                        InputStream var5 = ((BLOB)var3).getBinaryStream();

                        try {
                            try {
                                int var6;
                                String var7;
                                for(var7 = ""; (var6 = var5.read()) != -1; var7 = var7 + Integer.toHexString(var6)) {
                                }

                                var2 = var2 + var7;
                            } catch (IOException var18) {
                            }
                            break;
                        } finally {
                            try {
                                var5.close();
                            } catch (IOException var16) {
                            }

                        }
                    case 114:
                        var2 = var2 + "bfile_dir=" + ((BFILE)var3).getDirAlias() + " bfile_name=" + ((BFILE)var3).getName();
                        break;
                    case 188:
                        if (var1 == null) {
                            var2 = var2 + "?";
                        } else {
                            var2 = var2 + ((TIMESTAMPTZ)var3).stringValue(var1);
                        }
                        break;
                    case 232:
                        if (var1 == null) {
                            var2 = var2 + "?";
                        } else {
                            var2 = var2 + ((TIMESTAMPLTZ)var3).stringValue(var1);
                        }
                }
            }
        }

        var2 = var2 + "\"";
        return var2;
    }

    public Datum accessDatum() throws SQLException {
        Object var1 = null;
        if (!this.isNull) {
            short var2 = this.type.getInternalTypeCode();
            switch(var2) {
                case 1:
                case 9:
                case 96:
                    if (this.serverCharsetId != 0) {
                        var1 = new CHAR(this.data, CharacterSet.make(this.serverCharsetId));
                    } else {
                        var1 = new CHAR(this.data, (CharacterSet)null);
                    }
                    break;
                case 2:
                    var1 = new NUMBER(this.data);
                    break;
                case 12:
                    var1 = new DATE(this.data);
                    break;
                case 58:
                    var1 = new OPAQUE((OpaqueDescriptor)this.type, this.data, this.connection);
                    break;
                case 95:
                    var1 = new RAW(this.data);
                    break;
                case 100:
                    var1 = new BINARY_FLOAT(this.data);
                    break;
                case 101:
                    var1 = new BINARY_DOUBLE(this.data);
                    break;
                case 104:
                    long var3 = ((long)this.data[1] & 255L) << 24 | ((long)this.data[2] & 255L) << 16 | ((long)this.data[3] & 255L) << 8 | (long)this.data[4] & 255L;
                    long var5 = ((long)this.data[5] & 255L) << 8 | (long)this.data[6] & 255L;
                    long var7 = ((long)this.data[7] & 255L) << 24 | ((long)this.data[8] & 255L) << 16 | ((long)this.data[9] & 255L) << 8 | (long)this.data[10] & 255L;
                    long var9 = ((long)this.data[11] & 255L) << 8 | (long)this.data[12] & 255L;
                    long[] var11 = new long[]{var3, var5, var7, var9};
                    byte[] var12 = InternalFactory.urowid2rowid(var11);
                    var1 = new ROWID(var12);
                    break;
                case 108:
                    if (this.type instanceof OpaqueDescriptor) {
                        var1 = new OPAQUE((OpaqueDescriptor)this.type, this.data, this.connection);
                    } else if (!this.isREF) {
                        var1 = new STRUCT((StructDescriptor)this.type, this.data, this.connection);
                    } else {
                        var1 = new REF((StructDescriptor)this.type, this.connection, this.data);
                    }
                    break;
                case 110:
                    var1 = new REF((StructDescriptor)this.type, this.connection, this.data);
                    break;
                case 112:
                    var1 = new CLOB(this.connection, this.data);
                    break;
                case 113:
                    var1 = new BLOB(this.connection, this.data);
                    break;
                case 114:
                    var1 = new BFILE(this.connection, this.data);
                    break;
                case 122:
                    var1 = new ARRAY((ArrayDescriptor)this.type, this.data, this.connection);
                    break;
                case 187:
                    var1 = new TIMESTAMP(this.data);
                    break;
                case 188:
                    var1 = new TIMESTAMPTZ(this.data);
                    break;
                case 189:
                    var1 = new INTERVALYM(this.data);
                    break;
                case 190:
                    var1 = new INTERVALDS(this.data);
                    break;
                case 232:
                    var1 = new TIMESTAMPLTZ(this.data);
                    break;
                case 286:
                case 287:
                    if (this.serverNCharsetId != 0) {
                        var1 = new CHAR(this.data, CharacterSet.make(this.serverNCharsetId));
                    } else {
                        var1 = new CHAR(this.data, (CharacterSet)null);
                    }
                    break;
                case 288:
                    var1 = new NCLOB(this.connection, this.data);
                    break;
                default:
                    String var13 = "internal typecode: " + var2;
                    SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, var13);
                    var14.fillInStackTrace();
                    throw var14;
            }
        }

        return (Datum)var1;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
