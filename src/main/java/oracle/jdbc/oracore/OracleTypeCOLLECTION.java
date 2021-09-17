//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.Datum;
import oracle.sql.SQLName;
import oracle.sql.StructDescriptor;

public class OracleTypeCOLLECTION extends OracleTypeADT implements Serializable {
    static final long serialVersionUID = -7279638692691669378L;
    public static final int TYPE_PLSQL_INDEX_TABLE = 1;
    public static final int TYPE_NESTED_TABLE = 2;
    public static final int TYPE_VARRAY = 3;
    int userCode = 0;
    long maxSize = 0L;
    OracleType elementType = null;
    static final int CURRENT_USER_OBJECT = 0;
    static final int CURRENT_USER_SYNONYM = 1;
    static final int CURRENT_USER_SYNONYM_10g = 2;
    static final int CURRENT_USER_PUBLIC_SYNONYM = 3;
    static final int CURRENT_USER_PUBLIC_SYNONYM_10g = 4;
    static final int POSSIBLY_OTHER_USER_OBJECT = 5;
    static final int POSSIBLY_OTHER_USER_OBJECT_10g = 6;
    static final int OTHER_USER_OBJECT = 7;
    static final int OTHER_USER_SYNONYM = 8;
    static final int PUBLIC_SYNONYM = 9;
    static final int PUBLIC_SYNONYM_10g = 10;
    static final int BREAK = 11;
    static final String[] sqlString = new String[]{"SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM USER_COLL_TYPES WHERE TYPE_NAME = :1", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM USER_COLL_TYPES WHERE TYPE_NAME in (SELECT TABLE_NAME FROM USER_SYNONYMS START WITH SYNONYM_NAME = :1 CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME UNION SELECT :1 FROM DUAL) ", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM USER_COLL_TYPES WHERE TYPE_NAME in (SELECT TABLE_NAME FROM USER_SYNONYMS START WITH SYNONYM_NAME = :1 CONNECT BY NOCYCLE PRIOR TABLE_NAME = SYNONYM_NAME UNION SELECT :1 FROM DUAL) ", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM USER_COLL_TYPES WHERE TYPE_NAME IN (SELECT TABLE_NAME FROM ALL_SYNONYMS START WITH SYNONYM_NAME = :1 AND  OWNER = 'PUBLIC' CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER UNION SELECT :2  FROM DUAL) ", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM USER_COLL_TYPES WHERE TYPE_NAME IN (SELECT TABLE_NAME FROM ALL_SYNONYMS START WITH SYNONYM_NAME = :1 AND  OWNER = 'PUBLIC' CONNECT BY NOCYCLE PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER UNION SELECT :2  FROM DUAL) ", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM ALL_COLL_TYPES WHERE TYPE_NAME IN (SELECT TABLE_NAME FROM USER_SYNONYMS START WITH SYNONYM_NAME = :tname CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME UNION SELECT :tname FROM DUAL)", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM ALL_COLL_TYPES WHERE TYPE_NAME IN (SELECT TABLE_NAME FROM USER_SYNONYMS START WITH SYNONYM_NAME = :tname CONNECT BY NOCYCLE PRIOR TABLE_NAME = SYNONYM_NAME UNION SELECT :tname FROM DUAL)", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM ALL_COLL_TYPES WHERE OWNER = :1 AND TYPE_NAME = :2", "SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM ALL_COLL_TYPES WHERE OWNER = (SELECT TABLE_OWNER FROM ALL_SYNONYMS WHERE SYNONYM_NAME=:1) AND TYPE_NAME = (SELECT TABLE_NAME FROM ALL_SYNONYMS WHERE SYNONYM_NAME=:2) ", "DECLARE   the_owner VARCHAR2(100);   the_type  VARCHAR2(100); begin  SELECT TABLE_NAME, TABLE_OWNER INTO THE_TYPE, THE_OWNER  FROM ALL_SYNONYMS  WHERE TABLE_NAME IN (SELECT TYPE_NAME FROM ALL_TYPES)  START WITH SYNONYM_NAME = :1 AND OWNER = 'PUBLIC'  CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER; OPEN :2 FOR SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM ALL_COLL_TYPES  WHERE TYPE_NAME = THE_TYPE and OWNER = THE_OWNER; END;", "DECLARE   the_owner VARCHAR2(100);   the_type  VARCHAR2(100); begin  SELECT TABLE_NAME, TABLE_OWNER INTO THE_TYPE, THE_OWNER  FROM ALL_SYNONYMS  WHERE TABLE_NAME IN (SELECT TYPE_NAME FROM ALL_TYPES)  START WITH SYNONYM_NAME = :1 AND OWNER = 'PUBLIC'  CONNECT BY NOCYCLE PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER; OPEN :2 FOR SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM ALL_COLL_TYPES  WHERE TYPE_NAME = THE_TYPE and OWNER = THE_OWNER; END;"};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleTypeCOLLECTION(String var1, OracleConnection var2) throws SQLException {
        super(var1, var2);
    }

    public OracleTypeCOLLECTION(OracleTypeADT var1, int var2, OracleConnection var3) throws SQLException {
        super(var1, var2, var3);
    }

    public OracleTypeCOLLECTION(SQLName var1, byte[] var2, int var3, byte[] var4, OracleConnection var5) throws SQLException {
        super(var1, var2, var3, var4, var5);
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        if (var1 != null) {
            if (var1 instanceof ARRAY) {
                return (ARRAY)var1;
            } else {
                ArrayDescriptor var3 = this.createArrayDescriptor();
                return new ARRAY(var3, this.connection, var1);
            }
        } else {
            return null;
        }
    }

    public int getTypeCode() {
        return 2003;
    }

    public boolean isInHierarchyOf(OracleType var1) throws SQLException {
        if (var1 == null) {
            return false;
        } else if (var1 == this) {
            return true;
        } else {
            return var1.getClass() != this.getClass() ? false : var1.getTypeDescriptor().getName().equals(this.descriptor.getName());
        }
    }

    public boolean isInHierarchyOf(StructDescriptor var1) throws SQLException {
        return false;
    }

    public boolean isObjectType() {
        return false;
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        long var2 = var1.readLong();
        this.maxSize = var1.readLong();
        this.userCode = var1.readByte();
        var1.addSimplePatch(var2, this);
    }

    public Datum unlinearize(byte[] var1, long var2, Datum var4, int var5, Map var6) throws SQLException {
        return this.unlinearize(var1, var2, var4, 1L, -1, var5, var6);
    }

    public Datum unlinearize(byte[] var1, long var2, Datum var4, long var5, int var7, int var8, Map var9) throws SQLException {
        OracleConnection var10 = this.getConnection();
        Datum var11 = null;
        if (var10 == null) {
            var11 = this.unlinearizeInternal(var1, var2, var4, var5, var7, var8, var9);
        } else {
            synchronized(var10) {
                var11 = this.unlinearizeInternal(var1, var2, var4, var5, var7, var8, var9);
            }
        }

        return var11;
    }

    public synchronized Datum unlinearizeInternal(byte[] var1, long var2, Datum var4, long var5, int var7, int var8, Map var9) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            PickleContext var10 = new PickleContext(var1, var2);
            return this.unpickle81(var10, (ARRAY)var4, var5, var7, 1, var8, var9);
        }
    }

    public synchronized boolean isInlineImage(byte[] var1, int var2) throws SQLException {
        if (var1 == null) {
            return false;
        } else if (PickleContext.isCollectionImage_pctx(var1[var2])) {
            return true;
        } else if (PickleContext.isDegenerateImage_pctx(var1[var2])) {
            return false;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Image is not a collection image");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    protected int pickle81(PickleContext var1, Datum var2) throws SQLException {
        ARRAY var3 = (ARRAY)var2;
        boolean var4 = var3.hasDataSeg();
        byte var5 = 0;
        int var6 = var1.offset() + 2;
        int var9;
        if (var4) {
            if (!this.metaDataInitialized) {
                this.copy_properties((OracleTypeCOLLECTION)var3.getDescriptor().getPickler());
            }

            Datum[] var7 = var3.getOracleArray();
            if (this.userCode == 3 && (long)var7.length > this.maxSize) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 71, (Object)null);
                var10.fillInStackTrace();
                throw var10;
            }

            var9 = var5 + var1.writeCollImageHeader(var7.length, this.typeVersion);

            for(int var8 = 0; var8 < var7.length; ++var8) {
                if (var7[var8] == null) {
                    var9 += var1.writeElementNull();
                } else {
                    var9 += this.elementType.pickle81(var1, var7[var8]);
                }
            }
        } else {
            var9 = var5 + var1.writeCollImageHeader(var3.getLocator());
        }

        var1.patchImageLen(var6, var9);
        return var9;
    }

    ARRAY unpickle81(PickleContext var1, ARRAY var2, int var3, int var4, Map var5) throws SQLException {
        return this.unpickle81(var1, var2, 1L, -1, var3, var4, var5);
    }

    ARRAY unpickle81(PickleContext var1, ARRAY var2, long var3, int var5, int var6, int var7, Map var8) throws SQLException {
        ARRAY var9 = var2;
        if (var2 == null) {
            ArrayDescriptor var10 = this.createArrayDescriptor();
            var9 = new ARRAY(var10, (byte[])null, this.connection);
        }

        if (this.unpickle81ImgHeader(var1, var9, var6, var7)) {
            if (var3 == 1L && var5 == -1) {
                this.unpickle81ImgBody(var1, var9, var7, var8);
            } else {
                this.unpickle81ImgBody(var1, var9, var3, var5, var7, var8);
            }
        }

        return var9;
    }

    boolean unpickle81ImgHeader(PickleContext var1, ARRAY var2, int var3, int var4) throws SQLException {
        boolean var5 = true;
        if (var3 == 3) {
            var2.setImage(var1.image(), (long)var1.absoluteOffset(), 0L);
        }

        byte var6 = var1.readByte();
        SQLException var10;
        if (!PickleContext.is81format(var6)) {
            var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Image is not in 8.1 format");
            var10.fillInStackTrace();
            throw var10;
        } else if (!PickleContext.hasPrefix(var6)) {
            var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Image has no prefix segment");
            var10.fillInStackTrace();
            throw var10;
        } else {
            if (PickleContext.isCollectionImage_pctx(var6)) {
                var5 = true;
            } else {
                if (!PickleContext.isDegenerateImage_pctx(var6)) {
                    var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Image is not a collection image");
                    var10.fillInStackTrace();
                    throw var10;
                }

                var5 = false;
            }

            var1.readByte();
            if (var3 == 9) {
                var1.skipBytes(var1.readLength(true) - 2);
                return false;
            } else if (var3 == 3) {
                long var9 = (long)var1.readLength();
                var2.setImageLength(var9);
                var1.skipTo(var2.getImageOffset() + var9);
                return false;
            } else {
                var1.skipLength();
                int var7 = var1.readLength();
                var2.setPrefixFlag(var1.readByte());
                if (var2.isInline()) {
                    var1.readDataValue(var7 - 1);
                } else {
                    var2.setLocator(var1.readDataValue(var7 - 1));
                }

                return var2.isInline();
            }
        }
    }

    void unpickle81ImgBody(PickleContext var1, ARRAY var2, long var3, int var5, int var6, Map var7) throws SQLException {
        var1.readByte();
        int var8 = var1.readLength();
        var2.setLength(var8);
        if (var6 != 0) {
            int var9 = (int)this.getAccessLength((long)var8, var3, var5);
            boolean var10 = ArrayDescriptor.getCacheStyle(var2) == 1;
            if (var3 > 1L && var9 > 0) {
                long var11 = var2.getLastIndex();
                long var13;
                if (var11 < var3) {
                    if (var11 > 0L) {
                        var1.skipTo(var2.getLastOffset());
                    } else {
                        var11 = 1L;
                    }

                    if (var10) {
                        for(var13 = var11; var13 < var3; ++var13) {
                            var2.setIndexOffset(var13, (long)var1.offset());
                            this.elementType.unpickle81rec(var1, 9, (Map)null);
                        }
                    } else {
                        for(var13 = var11; var13 < var3; ++var13) {
                            this.elementType.unpickle81rec(var1, 9, (Map)null);
                        }
                    }
                } else if (var11 > var3) {
                    var13 = var2.getOffset(var3);
                    if (var13 != -1L) {
                        var1.skipTo(var13);
                    } else {
                        int var15;
                        if (var10) {
                            for(var15 = 1; (long)var15 < var3; ++var15) {
                                var2.setIndexOffset((long)var15, (long)var1.offset());
                                this.elementType.unpickle81rec(var1, 9, (Map)null);
                            }
                        } else {
                            for(var15 = 1; (long)var15 < var3; ++var15) {
                                this.elementType.unpickle81rec(var1, 9, (Map)null);
                            }
                        }
                    }
                } else {
                    var1.skipTo(var2.getLastOffset());
                }

                var2.setLastIndexOffset(var3, (long)var1.offset());
            }

            this.unpickle81ImgBodyElements(var1, var2, (int)var3, var9, var6, var7);
        }
    }

    void unpickle81ImgBody(PickleContext var1, ARRAY var2, int var3, Map var4) throws SQLException {
        var1.readByte();
        int var5 = var1.readLength();
        var2.setLength(var5);
        if (var3 != 0) {
            this.unpickle81ImgBodyElements(var1, var2, 1, var5, var3, var4);
        }
    }

    private void unpickle81ImgBodyElements(PickleContext var1, ARRAY var2, int var3, int var4, int var5, Map var6) throws SQLException {
        boolean var7 = ArrayDescriptor.getCacheStyle(var2) == 1;
        SQLException var8;
        int var9;
        switch(var5) {
            case 1:
                Datum[] var11 = new Datum[var4];
                if (var7) {
                    for(var9 = 0; var9 < var4; ++var9) {
                        var2.setIndexOffset((long)(var3 + var9), (long)var1.offset());
                        var11[var9] = (Datum)this.elementType.unpickle81rec(var1, var5, var6);
                    }
                } else {
                    for(var9 = 0; var9 < var4; ++var9) {
                        var11[var9] = (Datum)this.elementType.unpickle81rec(var1, var5, var6);
                    }
                }

                var2.setDatumArray(var11);
                break;
            case 2:
                Object[] var10 = ArrayDescriptor.makeJavaArray(var4, this.elementType.getTypeCode());
                if (var7) {
                    for(var9 = 0; var9 < var4; ++var9) {
                        var2.setIndexOffset((long)(var3 + var9), (long)var1.offset());
                        var10[var9] = this.elementType.unpickle81rec(var1, var5, var6);
                    }
                } else {
                    for(var9 = 0; var9 < var4; ++var9) {
                        var10[var9] = this.elementType.unpickle81rec(var1, var5, var6);
                    }
                }

                var2.setObjArray(var10);
                break;
            case 3:
            default:
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "Invalid conversion type " + this.elementType);
                var8.fillInStackTrace();
                throw var8;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (!(this.elementType instanceof OracleTypeNUMBER) && !(this.elementType instanceof OracleTypeFLOAT)) {
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "This feature is limited to numeric collection");
                    var8.fillInStackTrace();
                    throw var8;
                }

                var2.setObjArray(OracleTypeNUMBER.unpickle81NativeArray(var1, 1L, var4, var5));
        }

        var2.setLastIndexOffset((long)(var3 + var4), (long)var1.offset());
    }

    private void initCollElemTypeName() throws SQLException {
        if (this.connection != null) {
            synchronized(this.connection) {
                if (this.sqlName == null) {
                    this.getFullName();
                }

                CallableStatement var2 = null;
                PreparedStatement var3 = null;
                ResultSet var4 = null;
                this.connection.beginNonRequestCalls();

                try {
                    int var5 = this.sqlName.getSchema().equalsIgnoreCase(this.connection.getDefaultSchemaNameForNamedTypes()) ? 0 : 7;

                    while(var5 != 11) {
                        switch(var5) {
                            case 0:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var5]);
                                var3.setString(1, this.sqlName.getSimpleName());
                                var3.setFetchSize(1);
                                var4 = var3.executeQuery();
                                var5 = 1;
                                break;
                            case 1:
                                if (this.connection.getVersionNumber() >= 10000) {
                                    var5 = 2;
                                }
                            case 2:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var5]);
                                var3.setString(1, this.sqlName.getSimpleName());
                                var3.setString(2, this.sqlName.getSimpleName());
                                var3.setFetchSize(1);
                                var4 = var3.executeQuery();
                                var5 = 3;
                                break;
                            case 3:
                                if (this.connection.getVersionNumber() >= 10000) {
                                    var5 = 4;
                                }
                            case 4:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var5]);
                                var3.setString(1, this.sqlName.getSimpleName());
                                var3.setString(2, this.sqlName.getSimpleName());
                                var3.setFetchSize(1);
                                var4 = var3.executeQuery();
                                var5 = 5;
                                break;
                            case 5:
                                if (this.connection.getVersionNumber() >= 10000) {
                                    var5 = 6;
                                }
                            case 6:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var5]);
                                var3.setString(1, this.sqlName.getSimpleName());
                                var3.setString(2, this.sqlName.getSimpleName());
                                var3.setFetchSize(1);
                                var4 = var3.executeQuery();
                                var5 = 8;
                                break;
                            case 7:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var5]);
                                var3.setString(1, this.sqlName.getSchema());
                                var3.setString(2, this.sqlName.getSimpleName());
                                var3.setFetchSize(1);
                                var4 = var3.executeQuery();
                                var5 = 8;
                                break;
                            case 8:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var5]);
                                var3.setString(1, this.sqlName.getSimpleName());
                                var3.setString(2, this.sqlName.getSimpleName());
                                var3.setFetchSize(1);
                                var4 = var3.executeQuery();
                                var5 = 9;
                                break;
                            case 9:
                                if (this.connection.getVersionNumber() >= 10000) {
                                    var5 = 10;
                                }
                            case 10:
                                var2 = this.connection.prepareCall(this.getSqlHint() + sqlString[var5]);
                                var2.setString(1, this.sqlName.getSimpleName());
                                var2.registerOutParameter(2, -10);
                                var2.execute();
                                var4 = ((OracleCallableStatement)var2).getCursor(2);
                                var5 = 11;
                        }

                        if (var4.next()) {
                            if (this.attrTypeNames == null) {
                                this.attrTypeNames = new String[1];
                            }

                            this.attrTypeNames[0] = var4.getString(2) + "." + var4.getString(1);
                            var5 = 11;
                        } else if (var5 == 11) {
                            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                            var6.fillInStackTrace();
                            throw var6;
                        }
                    }

                    while(true) {
                        if (var5 != 11) {
                            continue;
                        }
                    }
                } finally {
                    if (var4 != null) {
                        var4.close();
                    }

                    if (var3 != null) {
                        var3.close();
                    }

                    if (var2 != null) {
                        var2.close();
                    }

                    this.connection.endNonRequestCalls();
                }

            }
        }
    }

    public String getAttributeName(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
        var2.fillInStackTrace();
        throw var2;
    }

    public String getAttributeName(int var1, boolean var2) throws SQLException {
        return this.getAttributeName(var1);
    }

    public String getAttributeType(int var1) throws SQLException {
        if (var1 != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var2.fillInStackTrace();
            throw var2;
        } else {
            if (this.sqlName == null) {
                this.getFullName();
            }

            if (this.attrTypeNames == null) {
                this.initCollElemTypeName();
            }

            return this.attrTypeNames[0];
        }
    }

    public String getAttributeType(int var1, boolean var2) throws SQLException {
        if (var2) {
            return this.getAttributeType(var1);
        } else if (var1 != 1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.sqlName != null && this.attrTypeNames != null ? this.attrTypeNames[0] : null;
        }
    }

    public int getNumAttrs() throws SQLException {
        return 0;
    }

    public OracleType getAttrTypeAt(int var1) throws SQLException {
        return null;
    }

    ArrayDescriptor createArrayDescriptor() throws SQLException {
        return new ArrayDescriptor(this, this.connection);
    }

    ArrayDescriptor createArrayDescriptorWithItsOwnTree() throws SQLException {
        if (this.descriptor == null) {
            if (this.sqlName == null && this.getFullName(false) == null) {
                this.descriptor = new ArrayDescriptor(this, this.connection);
            } else {
                this.descriptor = ArrayDescriptor.createDescriptor(this.sqlName, this.connection);
            }
        }

        return (ArrayDescriptor)this.descriptor;
    }

    public OracleType getElementType() throws SQLException {
        return this.elementType;
    }

    public int getUserCode() throws SQLException {
        return this.userCode;
    }

    public long getMaxLength() throws SQLException {
        return this.maxSize;
    }

    private long getAccessLength(long var1, long var3, int var5) throws SQLException {
        if (var3 > var1) {
            return 0L;
        } else {
            return var5 < 0 ? var1 - var3 + 1L : Math.min(var1 - var3 + 1L, (long)var5);
        }
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeInt(this.userCode);
        var1.writeLong(this.maxSize);
        var1.writeObject(this.elementType);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.userCode = var1.readInt();
        this.maxSize = var1.readLong();
        this.elementType = (OracleType)var1.readObject();
    }

    public void setConnection(OracleConnection var1) throws SQLException {
        this.connection = var1;
        this.elementType.setConnection(var1);
    }

    public void initMetadataRecursively() throws SQLException {
        this.initMetadata(this.connection);
        if (this.elementType != null) {
            this.elementType.initMetadataRecursively();
        }

    }

    public void initChildNamesRecursively(Map var1) throws SQLException {
        TypeTreeElement var2 = (TypeTreeElement)((TypeTreeElement)var1.get(this.sqlName));
        if (this.elementType != null) {
            this.elementType.setNames(var2.getChildSchemaName(0), var2.getChildTypeName(0));
            this.elementType.initChildNamesRecursively(var1);
            this.elementType.cacheDescriptor();
        }

    }

    public void cacheDescriptor() throws SQLException {
        this.descriptor = ArrayDescriptor.createDescriptor(this);
    }

    public void printXML(PrintWriter var1, int var2) throws SQLException {
        this.printXML(var1, var2, false);
    }

    public void printXML(PrintWriter var1, int var2, boolean var3) throws SQLException {
        int var4;
        for(var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.println("<OracleTypeCOLLECTION sqlName=\"" + this.sqlName + "\" " + ">");
        if (this.elementType != null) {
            this.elementType.printXML(var1, var2 + 1, var3);
        }

        for(var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.println("</OracleTypeCOLLECTION>");
    }
}
