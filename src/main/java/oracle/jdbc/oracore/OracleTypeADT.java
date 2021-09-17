//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.ObjectData;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.AttributeDescriptor;
import oracle.sql.BLOB;
import oracle.sql.Datum;
import oracle.sql.JAVA_STRUCT;
import oracle.sql.NUMBER;
import oracle.sql.SQLName;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TypeDescriptor;

public class OracleTypeADT extends OracleNamedType implements Serializable {
    static final long serialVersionUID = 3031304012507165702L;
    static final int S_TOP = 1;
    static final int S_EMBEDDED = 2;
    static final int S_UPT_ADT = 4;
    static final int S_JAVA_OBJECT = 16;
    static final int S_FINAL_TYPE = 32;
    static final int S_SUB_TYPE = 64;
    static final int S_ATTR_TDS = 128;
    static final int S_HAS_METADATA = 256;
    static final int S_TDS_PARSED = 512;
    private int statusBits;
    int tdsVersion;
    static final int KOPT_V80 = 1;
    static final int KOPT_V81 = 2;
    static final int KOPT_VNFT = 3;
    static final int KOPT_VERSION = 3;
    boolean endOfAdt;
    int typeVersion;
    long fixedDataSize;
    int alignmentRequirement;
    OracleType[] attrTypes;
    String[] attrNames;
    String[] attrTypeNames;
    public long tdoCState;
    byte[] toid;
    int charSetId;
    int charSetForm;
    int flattenedAttrNum;
    transient int opcode;
    transient int idx;
    boolean isTransient;
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
    static final String[] sqlString = new String[]{"SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM USER_TYPE_ATTRS WHERE TYPE_NAME = :1 ORDER BY ATTR_NO", "SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM USER_TYPE_ATTRS WHERE TYPE_NAME in (SELECT TABLE_NAME FROM USER_SYNONYMS START WITH SYNONYM_NAME = :1 CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME UNION SELECT :1 FROM DUAL) ORDER BY ATTR_NO", "SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM USER_TYPE_ATTRS WHERE TYPE_NAME in (SELECT TABLE_NAME FROM USER_SYNONYMS START WITH SYNONYM_NAME = :1 CONNECT BY NOCYCLE PRIOR TABLE_NAME = SYNONYM_NAME UNION SELECT :1 FROM DUAL) ORDER BY ATTR_NO", "SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM USER_TYPE_ATTRS WHERE TYPE_NAME IN (SELECT TABLE_NAME FROM ALL_SYNONYMS START WITH SYNONYM_NAME = :1 AND  OWNER = 'PUBLIC' CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER UNION SELECT :2  FROM DUAL) ORDER BY ATTR_NO", "SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM USER_TYPE_ATTRS WHERE TYPE_NAME IN (SELECT TABLE_NAME FROM ALL_SYNONYMS START WITH SYNONYM_NAME = :1 AND  OWNER = 'PUBLIC' CONNECT BY NOCYCLE PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER UNION SELECT :2  FROM DUAL) ORDER BY ATTR_NO", "DECLARE CURSOR usyn_cur IS SELECT table_name, table_owner from user_synonyms; TYPE table_name_type IS TABLE OF usyn_cur%ROWTYPE; table_names table_name_type; lastrow BINARY_INTEGER := null; l_syntname user_synonyms.table_name%TYPE; l_syntown  user_synonyms.table_owner%TYPE; BEGIN SELECT TABLE_NAME, TABLE_OWNER BULK COLLECT INTO table_names FROM USER_SYNONYMS START WITH SYNONYM_NAME = ? CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME; IF table_names.LAST IS NOT NULL THEN   lastrow := table_names.LAST;   l_syntname := table_names(lastrow).table_name;   l_syntown :=  table_names(lastrow).table_owner; END IF; OPEN ? FOR SELECT  ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER   FROM ALL_TYPE_ATTRS  A   WHERE (TYPE_NAME = l_syntname OR TYPE_NAME = ?)  AND  A.OWNER = l_syntown   ORDER BY ATTR_NO; END;", "DECLARE CURSOR usyn_cur IS SELECT table_name, table_owner from user_synonyms; TYPE table_name_type IS TABLE OF usyn_cur%ROWTYPE; table_names table_name_type; lastrow BINARY_INTEGER := null; l_syntname user_synonyms.table_name%TYPE; l_syntown  user_synonyms.table_owner%TYPE; BEGIN SELECT TABLE_NAME, TABLE_OWNER BULK COLLECT INTO table_names FROM USER_SYNONYMS START WITH SYNONYM_NAME = ? CONNECT BY NOCYCLEPRIOR TABLE_NAME = SYNONYM_NAME; IF table_names.LAST IS NOT NULL THEN   lastrow := table_names.LAST;   l_syntname := table_names(lastrow).table_name;   l_syntown :=  table_names(lastrow).table_owner; END IF; OPEN ? FOR SELECT  ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER   FROM ALL_TYPE_ATTRS  A   WHERE (TYPE_NAME = l_syntname OR TYPE_NAME = ?)  AND  A.OWNER = l_syntown   ORDER BY ATTR_NO; END;", "SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM ALL_TYPE_ATTRS WHERE OWNER = :1 AND TYPE_NAME = :2 ORDER BY ATTR_NO", "SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM ALL_TYPE_ATTRS WHERE OWNER = (SELECT TABLE_OWNER FROM ALL_SYNONYMS WHERE SYNONYM_NAME=:1) AND TYPE_NAME = (SELECT TABLE_NAME FROM ALL_SYNONYMS WHERE SYNONYM_NAME=:2) ORDER BY ATTR_NO", "DECLARE   the_owner VARCHAR2(100);   the_type  VARCHAR2(100); begin  SELECT TABLE_NAME, TABLE_OWNER INTO THE_TYPE, THE_OWNER  FROM ALL_SYNONYMS  WHERE TABLE_NAME IN (SELECT TYPE_NAME FROM ALL_TYPES)  START WITH SYNONYM_NAME = :1 AND OWNER = 'PUBLIC'  CONNECT BY PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER; OPEN :2 FOR SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME,  ATTR_TYPE_OWNER FROM ALL_TYPE_ATTRS  WHERE TYPE_NAME = THE_TYPE and OWNER = THE_OWNER; END;", "DECLARE   the_owner VARCHAR2(100);   the_type  VARCHAR2(100); begin  SELECT TABLE_NAME, TABLE_OWNER INTO THE_TYPE, THE_OWNER  FROM ALL_SYNONYMS  WHERE TABLE_NAME IN (SELECT TYPE_NAME FROM ALL_TYPES)  START WITH SYNONYM_NAME = :1 AND OWNER = 'PUBLIC'  CONNECT BY NOCYCLE PRIOR TABLE_NAME = SYNONYM_NAME AND TABLE_OWNER = OWNER; OPEN :2 FOR SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME,  ATTR_TYPE_OWNER FROM ALL_TYPE_ATTRS  WHERE TYPE_NAME = THE_TYPE and OWNER = THE_OWNER; END;"};
    static final int SEARCH_USER_TYPES = 0;
    static final int SEARCH_ALL_TYPES = 1;
    static final String[] sqlStringTOID = new String[]{"SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM USER_TYPE_ATTRS a, USER_TYPES b WHERE b.TYPE_OID = :1 AND a.TYPE_NAME = b.TYPE_NAME ORDER BY ATTR_NO", "SELECT ATTR_NO, ATTR_NAME, ATTR_TYPE_NAME, ATTR_TYPE_OWNER FROM ALL_TYPE_ATTRS a, ALL_TYPES b WHERE b.TYPE_OID = :1 AND a.TYPE_NAME = b.TYPE_NAME AND a.OWNER = b.OWNER ORDER BY ATTR_NO"};
    Boolean isInstanciable;
    String superTypeName;
    int numberOfLocalAttributes;
    String[] subTypeNames;
    final int LOCAL_TYPE;
    final int LOOK_FOR_USER_SYNONYM;
    final int LOOK_FOR_PUBLIC_SYNONYM;
    final String[] initMetaData1_9_0_SQL;
    static final int TDS_SIZE = 4;
    static final int TDS_NUMBER = 1;
    static final int KOPM_OTS_SQL_CHAR = 1;
    static final int KOPM_OTS_DATE = 2;
    static final int KOPM_OTS_DECIMAL = 3;
    static final int KOPM_OTS_DOUBLE = 4;
    static final int KOPM_OTS_FLOAT = 5;
    static final int KOPM_OTS_NUMBER = 6;
    static final int KOPM_OTS_SQL_VARCHAR2 = 7;
    static final int KOPM_OTS_SINT32 = 8;
    static final int KOPM_OTS_REF = 9;
    static final int KOPM_OTS_VARRAY = 10;
    static final int KOPM_OTS_UINT8 = 11;
    static final int KOPM_OTS_SINT8 = 12;
    static final int KOPM_OTS_UINT16 = 13;
    static final int KOPM_OTS_UINT32 = 14;
    static final int KOPM_OTS_LOB = 15;
    static final int KOPM_OTS_CANONICAL = 17;
    static final int KOPM_OTS_OCTET = 18;
    static final int KOPM_OTS_RAW = 19;
    static final int KOPM_OTS_ROWID = 20;
    static final int KOPM_OTS_STAMP = 21;
    static final int KOPM_OTS_TZSTAMP = 23;
    static final int KOPM_OTS_INTERVAL = 24;
    static final int KOPM_OTS_PTR = 25;
    static final int KOPM_OTS_SINT16 = 26;
    static final int KOPM_OTS_UPT = 27;
    static final int KOPM_OTS_COLLECTION = 28;
    static final int KOPM_OTS_CLOB = 29;
    static final int KOPM_OTS_BLOB = 30;
    static final int KOPM_OTS_BFILE = 31;
    static final int KOPM_OTS_BINARY_INTEGE = 32;
    static final int KOPM_OTS_IMPTZSTAMP = 33;
    static final int KOPM_OTS_BFLOAT = 37;
    static final int KOPM_OTS_BDOUBLE = 45;
    static final int KOTTCOPQ = 58;
    static final int KOPT_OP_STARTEMBADT = 39;
    static final int KOPT_OP_ENDEMBADT = 40;
    static final int KOPT_OP_STARTADT = 41;
    static final int KOPT_OP_ENDADT = 42;
    static final int KOPT_OP_SUBTYPE_MARKER = 43;
    static final int KOPT_OP_EMBADT_INFO = 44;
    static final int KOPT_OPCODE_START = 38;
    static final int KOPT_OP_VERSION = 38;
    static final int REGULAR_PATCH = 0;
    static final int SIMPLE_PATCH = 1;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeADT() {
        this.statusBits = 1;
        this.tdsVersion = -9999;
        this.endOfAdt = false;
        this.typeVersion = 1;
        this.fixedDataSize = -1L;
        this.alignmentRequirement = -1;
        this.attrTypes = null;
        this.tdoCState = 0L;
        this.toid = null;
        this.idx = 1;
        this.isTransient = false;
        this.numberOfLocalAttributes = -1;
        this.LOCAL_TYPE = 0;
        this.LOOK_FOR_USER_SYNONYM = 1;
        this.LOOK_FOR_PUBLIC_SYNONYM = 2;
        this.initMetaData1_9_0_SQL = new String[]{"SELECT INSTANTIABLE, supertype_owner, supertype_name, LOCAL_ATTRIBUTES FROM all_types WHERE type_name = :1 AND owner = :2 ", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM USER_SYNONYMS WHERE \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM ALL_SYNONYMS WHERE \n         OWNER = 'PUBLIC' AND \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;"};
    }

    public OracleTypeADT(byte[] var1, int var2, int var3, short var4, String var5) throws SQLException {
        this((String)var5, (Connection)((OracleConnection)null));
        this.toid = var1;
        this.typeVersion = var2;
        this.charSetId = var3;
        this.charSetForm = var4;
    }

    public OracleTypeADT(String var1, Connection var2) throws SQLException {
        super(var1, (OracleConnection)var2);
        this.statusBits = 1;
        this.tdsVersion = -9999;
        this.endOfAdt = false;
        this.typeVersion = 1;
        this.fixedDataSize = -1L;
        this.alignmentRequirement = -1;
        this.attrTypes = null;
        this.tdoCState = 0L;
        this.toid = null;
        this.idx = 1;
        this.isTransient = false;
        this.numberOfLocalAttributes = -1;
        this.LOCAL_TYPE = 0;
        this.LOOK_FOR_USER_SYNONYM = 1;
        this.LOOK_FOR_PUBLIC_SYNONYM = 2;
        this.initMetaData1_9_0_SQL = new String[]{"SELECT INSTANTIABLE, supertype_owner, supertype_name, LOCAL_ATTRIBUTES FROM all_types WHERE type_name = :1 AND owner = :2 ", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM USER_SYNONYMS WHERE \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM ALL_SYNONYMS WHERE \n         OWNER = 'PUBLIC' AND \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;"};
        this.typeNameByUser = var1;
    }

    public OracleTypeADT(OracleTypeADT var1, int var2, Connection var3) throws SQLException {
        super(var1, var2, (OracleConnection)var3);
        this.statusBits = 1;
        this.tdsVersion = -9999;
        this.endOfAdt = false;
        this.typeVersion = 1;
        this.fixedDataSize = -1L;
        this.alignmentRequirement = -1;
        this.attrTypes = null;
        this.tdoCState = 0L;
        this.toid = null;
        this.idx = 1;
        this.isTransient = false;
        this.numberOfLocalAttributes = -1;
        this.LOCAL_TYPE = 0;
        this.LOOK_FOR_USER_SYNONYM = 1;
        this.LOOK_FOR_PUBLIC_SYNONYM = 2;
        this.initMetaData1_9_0_SQL = new String[]{"SELECT INSTANTIABLE, supertype_owner, supertype_name, LOCAL_ATTRIBUTES FROM all_types WHERE type_name = :1 AND owner = :2 ", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM USER_SYNONYMS WHERE \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM ALL_SYNONYMS WHERE \n         OWNER = 'PUBLIC' AND \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;"};
    }

    public OracleTypeADT(SQLName var1, byte[] var2, int var3, byte[] var4, OracleConnection var5) throws SQLException {
        this.statusBits = 1;
        this.tdsVersion = -9999;
        this.endOfAdt = false;
        this.typeVersion = 1;
        this.fixedDataSize = -1L;
        this.alignmentRequirement = -1;
        this.attrTypes = null;
        this.tdoCState = 0L;
        this.toid = null;
        this.idx = 1;
        this.isTransient = false;
        this.numberOfLocalAttributes = -1;
        this.LOCAL_TYPE = 0;
        this.LOOK_FOR_USER_SYNONYM = 1;
        this.LOOK_FOR_PUBLIC_SYNONYM = 2;
        this.initMetaData1_9_0_SQL = new String[]{"SELECT INSTANTIABLE, supertype_owner, supertype_name, LOCAL_ATTRIBUTES FROM all_types WHERE type_name = :1 AND owner = :2 ", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM USER_SYNONYMS WHERE \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM ALL_SYNONYMS WHERE \n         OWNER = 'PUBLIC' AND \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;"};
        this.sqlName = var1;
        this.init(var4, var5);
        this.toid = var2;
        this.typeVersion = var3;
    }

    public OracleTypeADT(AttributeDescriptor[] var1, OracleConnection var2) throws SQLException {
        this.statusBits = 1;
        this.tdsVersion = -9999;
        this.endOfAdt = false;
        this.typeVersion = 1;
        this.fixedDataSize = -1L;
        this.alignmentRequirement = -1;
        this.attrTypes = null;
        this.tdoCState = 0L;
        this.toid = null;
        this.idx = 1;
        this.isTransient = false;
        this.numberOfLocalAttributes = -1;
        this.LOCAL_TYPE = 0;
        this.LOOK_FOR_USER_SYNONYM = 1;
        this.LOOK_FOR_PUBLIC_SYNONYM = 2;
        this.initMetaData1_9_0_SQL = new String[]{"SELECT INSTANTIABLE, supertype_owner, supertype_name, LOCAL_ATTRIBUTES FROM all_types WHERE type_name = :1 AND owner = :2 ", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM USER_SYNONYMS WHERE \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;", "DECLARE \n bind_synonym_name user_synonyms.synonym_name%type := :1; \n the_table_owner  user_synonyms.table_owner%type; \n the_table_name   user_synonyms.table_name%type; \n the_db_link      user_synonyms.db_link%type; \n sql_string       VARCHAR2(1000); \nBEGIN \n   SELECT TABLE_NAME, TABLE_OWNER, DB_LINK INTO  \n         the_table_name, the_table_owner, the_db_link \n         FROM ALL_SYNONYMS WHERE \n         OWNER = 'PUBLIC' AND \n         SYNONYM_NAME = bind_synonym_name; \n \n   sql_string := 'SELECT INSTANTIABLE, SUPERTYPE_OWNER,      SUPERTYPE_NAME, LOCAL_ATTRIBUTES FROM ALL_TYPES'; \n \n   IF the_db_link IS NOT NULL  \n   THEN \n     sql_string := sql_string || '@' || the_db_link; \n   END IF; \n   sql_string := sql_string       || ' WHERE TYPE_NAME = '''       || the_table_name   || ''' AND OWNER = '''       || the_table_owner  || ''''; \n   OPEN :2 FOR sql_string; \nEND;"};
        this.setConnectionInternal(var2);
        this.isTransient = true;
        this.flattenedAttrNum = var1.length;
        this.attrTypes = new OracleType[this.flattenedAttrNum];
        this.attrNames = new String[this.flattenedAttrNum];

        int var3;
        for(var3 = 0; var3 < this.flattenedAttrNum; ++var3) {
            this.attrNames[var3] = var1[var3].getAttributeName();
        }

        this.statusBits |= 256;

        for(var3 = 0; var3 < this.flattenedAttrNum; ++var3) {
            TypeDescriptor var4 = var1[var3].getTypeDescriptor();
            switch(var4.getInternalTypeCode()) {
                case 2:
                    this.attrTypes[var3] = new OracleTypeNUMBER(2);
                    ((OracleTypeNUMBER)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    ((OracleTypeNUMBER)this.attrTypes[var3]).scale = var4.getScale();
                    break;
                case 4:
                    this.attrTypes[var3] = new OracleTypeFLOAT();
                    ((OracleTypeFLOAT)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    break;
                case 7:
                    this.attrTypes[var3] = new OracleTypeNUMBER(3);
                    ((OracleTypeNUMBER)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    ((OracleTypeNUMBER)this.attrTypes[var3]).scale = var4.getScale();
                    break;
                case 9:
                    this.attrTypes[var3] = new OracleTypeCHAR(this.connection, 12);
                    ((OracleTypeCHAR)this.attrTypes[var3]).length = (int)var4.getPrecision();
                    ((OracleTypeCHAR)this.attrTypes[var3]).form = 1;
                    break;
                case 12:
                    this.attrTypes[var3] = new OracleTypeDATE();
                    break;
                case 22:
                    this.attrTypes[var3] = new OracleTypeNUMBER(8);
                    ((OracleTypeNUMBER)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    ((OracleTypeNUMBER)this.attrTypes[var3]).scale = var4.getScale();
                    break;
                case 29:
                    this.attrTypes[var3] = new OracleTypeSINT32(false);
                    break;
                case 95:
                    this.attrTypes[var3] = new OracleTypeRAW();
                    break;
                case 96:
                    this.attrTypes[var3] = new OracleTypeCHAR(this.connection, 1);
                    ((OracleTypeCHAR)this.attrTypes[var3]).length = (int)var4.getPrecision();
                    ((OracleTypeCHAR)this.attrTypes[var3]).form = 1;
                    break;
                case 100:
                    this.attrTypes[var3] = new OracleTypeBINARY_FLOAT();
                    break;
                case 101:
                    this.attrTypes[var3] = new OracleTypeBINARY_DOUBLE();
                    break;
                case 108:
                    this.attrTypes[var3] = (OracleTypeADT)var4.getPickler();
                    ((OracleTypeADT)this.attrTypes[var3]).setEmbeddedADT();
                    break;
                case 110:
                    this.attrTypes[var3] = new OracleTypeREF(this, var3, this.connection);
                    break;
                case 112:
                    this.attrTypes[var3] = new OracleTypeCLOB(this.connection);
                    break;
                case 113:
                    this.attrTypes[var3] = new OracleTypeBLOB(this.connection);
                    break;
                case 114:
                    this.attrTypes[var3] = new OracleTypeBFILE(this.connection);
                    break;
                case 122:
                    this.attrTypes[var3] = new OracleTypeCOLLECTION(this, var3, this.connection);
                    break;
                case 187:
                    this.attrTypes[var3] = new OracleTypeTIMESTAMP(this.connection);
                    ((OracleTypeTIMESTAMP)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    break;
                case 188:
                    this.attrTypes[var3] = new OracleTypeTIMESTAMPTZ(this.connection);
                    ((OracleTypeTIMESTAMPTZ)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    break;
                case 189:
                    this.attrTypes[var3] = new OracleTypeINTERVAL(this.connection);
                    ((OracleTypeINTERVAL)this.attrTypes[var3]).typeId = 7;
                    ((OracleTypeINTERVAL)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    ((OracleTypeINTERVAL)this.attrTypes[var3]).scale = var4.getScale();
                    break;
                case 190:
                    this.attrTypes[var3] = new OracleTypeINTERVAL(this.connection);
                    ((OracleTypeINTERVAL)this.attrTypes[var3]).typeId = 10;
                    ((OracleTypeINTERVAL)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    ((OracleTypeINTERVAL)this.attrTypes[var3]).scale = var4.getScale();
                    break;
                case 232:
                    this.attrTypes[var3] = new OracleTypeTIMESTAMPLTZ(this.connection);
                    ((OracleTypeTIMESTAMPLTZ)this.attrTypes[var3]).precision = (int)var4.getPrecision();
                    break;
                default:
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 48, "type: " + var4.getInternalTypeCode());
                    var5.fillInStackTrace();
                    throw var5;
            }
        }

    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        if (var1 != null) {
            if (var1 instanceof STRUCT) {
                return (STRUCT)var1;
            } else if (!(var1 instanceof SQLData) && !(var1 instanceof ObjectData)) {
                if (var1 instanceof Object[]) {
                    StructDescriptor var5 = this.createStructDescriptor();
                    STRUCT var4 = this.createObjSTRUCT(var5, (Object[])((Object[])var1));
                    return var4;
                } else {
                    SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                    var3.fillInStackTrace();
                    throw var3;
                }
            } else {
                return STRUCT.toSTRUCT(var1, var2);
            }
        } else {
            return null;
        }
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        Datum[] var6 = null;
        if (var1 != null) {
            if (!(var1 instanceof Object[])) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var10.fillInStackTrace();
                throw var10;
            }

            Object[] var7 = (Object[])((Object[])var1);
            int var8 = (int)(var5 == -1 ? (long)var7.length : Math.min((long)var7.length - var3 + 1L, (long)var5));
            var6 = new Datum[var8];

            for(int var9 = 0; var9 < var8; ++var9) {
                var6[var9] = this.toDatum(var7[(int)var3 + var9 - 1], var2);
            }
        }

        return var6;
    }

    public int getTypeCode() throws SQLException {
        return (this.getStatus() & 16) != 0 ? 2008 : 2002;
    }

    public OracleType[] getAttrTypes() throws SQLException {
        if (this.attrTypes == null) {
            this.init(this.connection);
        }

        return this.attrTypes;
    }

    public boolean isInHierarchyOf(OracleType var1) throws SQLException {
        if (var1 == null) {
            return false;
        } else if (!var1.isObjectType()) {
            return false;
        } else {
            StructDescriptor var2 = (StructDescriptor)var1.getTypeDescriptor();
            return this.descriptor.isInHierarchyOf(var2.getName());
        }
    }

    public boolean isInHierarchyOf(StructDescriptor var1) throws SQLException {
        return var1 == null ? false : this.descriptor.isInHierarchyOf(var1.getName());
    }

    public boolean isObjectType() {
        return true;
    }

    public TypeDescriptor getTypeDescriptor() {
        return this.descriptor;
    }

    public void init(OracleConnection var1) throws SQLException {
        synchronized(var1) {
            byte[] var3 = this.initMetadata(var1);
            this.init(var3, var1);
        }
    }

    public void init(byte[] var1, OracleConnection var2) throws SQLException {
        synchronized(var2) {
            this.statusBits = 1;
            this.connection = var2;
            if (var1 != null) {
                this.parseTDS(var1, 0L);
            }

            this.setStatusBits(256);
        }
    }

    public byte[] initMetadata(OracleConnection var1) throws SQLException {
        short var2 = var1.getVersionNumber();
        Object var3 = null;
        byte[] var4;
        if (var2 >= 12000) {
            var4 = this.initMetadata12(var1);
        } else {
            var4 = this.initMetadata11_2(var1);
        }

        return var4;
    }

    private byte[] initMetadata12(OracleConnection var1) throws SQLException {
        synchronized(this.connection) {
            byte[] var3 = null;
            if ((this.statusBits & 256) != 0) {
                return null;
            } else {
                if ((this.statusBits & 256) == 0) {
                    CallableStatement var4 = null;
                    this.connection.beginNonRequestCalls();

                    try {
                        String var5 = "begin :1 := dbms_pickler.get_type_shape(:2,:3,:4,:5,:6,:7,:8,:9,:10); end;";
                        String var6 = this.typeNameByUser == null ? this.getFullName() : this.typeNameByUser;
                        var4 = this.connection.prepareCall(var5);
                        var4.registerOutParameter(1, 2);
                        var4.setString(2, var6);
                        var4.registerOutParameter(2, 12, 256);
                        var4.registerOutParameter(3, -3, 16);
                        var4.registerOutParameter(4, 4);
                        var4.registerOutParameter(5, -4);
                        var4.registerOutParameter(6, 12, 5);
                        var4.registerOutParameter(7, 12, 256);
                        var4.registerOutParameter(8, 12, 256);
                        var4.registerOutParameter(9, -10);
                        var4.registerOutParameter(10, -10);
                        var4.execute();
                        boolean var7 = false;
                        int var8 = var4.getInt(1);
                        if (var8 != 0) {
                            SQLException var36;
                            if (var8 != 24331) {
                                var36 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74, this.typeNameByUser);
                                var36.fillInStackTrace();
                                throw var36;
                            }

                            if (var8 == 24331) {
                                var7 = true;
                                var4.registerOutParameter(5, 2004);
                                var4.execute();
                                var8 = var4.getInt(1);
                                if (var8 != 0) {
                                    var36 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74, this.typeNameByUser);
                                    var36.fillInStackTrace();
                                    throw var36;
                                }
                            }
                        }

                        this.toid = var4.getBytes(3);
                        this.typeVersion = NUMBER.toInt(var4.getBytes(4));
                        if (!var7) {
                            var3 = var4.getBytes(5);
                        } else {
                            try {
                                Blob var10 = ((OracleCallableStatement)var4).getBlob(5);
                                InputStream var9 = var10.getBinaryStream();
                                var3 = new byte[(int)var10.length()];
                                var9.read(var3);
                                var9.close();
                                ((BLOB)var10).freeTemporary();
                            } catch (IOException var31) {
                                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var31);
                                var11.fillInStackTrace();
                                throw var11;
                            }
                        }

                        this.metaDataInitialized = true;
                        this.isInstanciable = "YES".equalsIgnoreCase(var4.getString(6));
                        String var35 = var4.getString(8);
                        if (var35 != null) {
                            (new StringBuilder()).append(var4.getString(7)).append(var35).toString();
                        }

                        ResultSet var37 = null;
                        ResultSet var38 = null;

                        try {
                            var37 = (ResultSet)var4.getObject(9);
                            ArrayList var12;
                            SQLException var39;
                            if (var37 != null && var37.next()) {
                                if (var37.getInt(1) != 1) {
                                    var39 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unknown image format");
                                    var39.fillInStackTrace();
                                    throw var39;
                                }

                                var12 = new ArrayList(5);
                                ArrayList var13 = new ArrayList(5);

                                label451:
                                while(true) {
                                    var12.add(var37.getString(2));
                                    String var14 = var37.getString(5);
                                    String var15 = var37.getString(6);
                                    String var16 = "";
                                    if (var14 != null) {
                                        var16 = var16 + var14 + '.';
                                    }

                                    if (var15 != null) {
                                        var16 = var16 + var15 + '.';
                                    }

                                    var16 = var16 + var37.getString(4);
                                    var13.add(var16);
                                    if (!var37.next()) {
                                        Object[] var41 = var12.toArray();
                                        this.attrNames = new String[var12.size()];
                                        int var42 = 0;
                                        Object[] var43 = var41;
                                        int var17 = var41.length;

                                        int var18;
                                        Object var19;
                                        for(var18 = 0; var18 < var17; ++var18) {
                                            var19 = var43[var18];
                                            this.attrNames[var42++] = (String)var19;
                                        }

                                        var41 = var13.toArray();
                                        this.attrTypeNames = new String[var13.size()];
                                        var42 = 0;
                                        var43 = var41;
                                        var17 = var41.length;
                                        var18 = 0;

                                        while(true) {
                                            if (var18 >= var17) {
                                                break label451;
                                            }

                                            var19 = var43[var18];
                                            this.attrTypeNames[var42++] = (String)var19;
                                            ++var18;
                                        }
                                    }
                                }
                            }

                            var37.close();
                            var37 = null;
                            var38 = (ResultSet)var4.getObject(10);
                            if (var38 != null && var38.next()) {
                                if (var38.getInt(1) != 1) {
                                    var39 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unknown image format");
                                    var39.fillInStackTrace();
                                    throw var39;
                                }

                                var12 = new ArrayList(5);

                                do {
                                    var12.add(var38.getString(2) + "." + var38.getString(3));
                                } while(var38.next());

                                this.subTypeNames = new String[var12.size()];

                                for(int var40 = 0; var40 < this.subTypeNames.length; ++var40) {
                                    this.subTypeNames[var40] = (String)var12.get(var40);
                                }
                            }
                        } finally {
                            if (var37 != null) {
                                var37.close();
                            }

                            if (var38 != null) {
                                var38.close();
                            }

                        }

                        this.flattenedAttrNum = Util.getUnsignedByte(var3[8]) * 256 + Util.getUnsignedByte(var3[9]);
                    } finally {
                        if (var4 != null) {
                            var4.close();
                        }

                        this.connection.endNonRequestCalls();
                    }
                }

                this.setStatusBits(256);
                return var3;
            }
        }
    }

    private byte[] initMetadata11_2(OracleConnection var1) throws SQLException {
        synchronized(this.connection) {
            byte[] var3 = null;
            if ((this.statusBits & 256) != 0) {
                return null;
            } else {
                if (this.sqlName == null) {
                    this.getFullName();
                }

                if ((this.statusBits & 256) == 0) {
                    CallableStatement var4 = null;
                    this.connection.beginNonRequestCalls();

                    try {
                        if (this.tdoCState == 0L) {
                            this.tdoCState = this.connection.getTdoCState(this.sqlName.getSchema(), this.sqlName.getSimpleName());
                        }

                        String var5 = "begin :1 := dbms_pickler.get_type_shape(:2,:3,:4,:5,:6,:7); end;";
                        boolean var6 = false;
                        var4 = this.connection.prepareCall(var5);
                        var4.registerOutParameter(1, 2);
                        var4.registerOutParameter(4, -3, 16);
                        var4.registerOutParameter(5, 4);
                        var4.registerOutParameter(6, -4);
                        var4.registerOutParameter(7, -4);
                        var4.setString(2, this.sqlName.getSchema());
                        var4.setString(3, this.sqlName.getSimpleName());
                        var4.execute();
                        int var7 = var4.getInt(1);
                        if (var7 != 0) {
                            SQLException var19;
                            if (var7 != 24331) {
                                var19 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74, this.sqlName.toString());
                                var19.fillInStackTrace();
                                throw var19;
                            }

                            if (var7 == 24331) {
                                var6 = true;
                                var4.registerOutParameter(6, 2004);
                                var4.execute();
                                var7 = var4.getInt(1);
                                if (var7 != 0) {
                                    var19 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74, this.sqlName.toString());
                                    var19.fillInStackTrace();
                                    throw var19;
                                }
                            }
                        }

                        this.toid = var4.getBytes(4);
                        this.typeVersion = NUMBER.toInt(var4.getBytes(5));
                        if (!var6) {
                            var3 = var4.getBytes(6);
                        } else {
                            try {
                                Blob var9 = ((OracleCallableStatement)var4).getBlob(6);
                                InputStream var8 = var9.getBinaryStream();
                                var3 = new byte[(int)var9.length()];
                                var8.read(var3);
                                var8.close();
                                ((BLOB)var9).freeTemporary();
                            } catch (IOException var16) {
                                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var16);
                                var10.fillInStackTrace();
                                throw var10;
                            }
                        }

                        this.metaDataInitialized = true;
                        this.flattenedAttrNum = Util.getUnsignedByte(var3[8]) * 256 + Util.getUnsignedByte(var3[9]);
                        var4.getBytes(7);
                    } finally {
                        if (var4 != null) {
                            var4.close();
                        }

                        this.connection.endNonRequestCalls();
                    }
                }

                this.setStatusBits(256);
                return var3;
            }
        }
    }

    TDSReader parseTDS(byte[] var1, long var2) throws SQLException {
        if (this.attrTypes != null) {
            return null;
        } else {
            TDSReader var4 = new TDSReader(var1, var2);
            long var5 = var4.readLong() + var4.offset();
            var4.checkNextByte((byte)38);
            this.tdsVersion = var4.readByte();
            var4.skipBytes(2);
            this.flattenedAttrNum = var4.readUB2();
            if ((var4.readByte() & 255) == 255) {
                this.setStatusBits(128);
            }

            long var7 = var4.offset();
            var4.checkNextByte((byte)41);
            if (var4.readUB2() != 0) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 47, "parseTDS");
                var12.fillInStackTrace();
                throw var12;
            } else {
                long var9 = var4.readLong();
                this.parseTDSrec(var4);
                if (this.tdsVersion >= 3) {
                    var4.skip_to(var7 + var9 + 2L);
                    var4.skipBytes(2 * this.flattenedAttrNum);
                    byte var11 = var4.readByte();
                    if (var4.isJavaObject(this.tdsVersion, var11)) {
                        this.setStatusBits(16);
                    }

                    if (var4.isFinalType(this.tdsVersion, var11)) {
                        this.setStatusBits(32);
                    }

                    if (var4.readByte() != 1) {
                        this.setStatusBits(64);
                    }
                } else {
                    this.setStatusBits(32);
                }

                var4.skip_to(var5);
                return var4;
            }
        }
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        Vector var2 = new Vector(5);
        OracleType var3 = null;
        this.idx = 1;

        while((var3 = this.getNextTypeObject(var1)) != null) {
            var2.addElement(var3);
        }

        if (this.opcode == 42) {
            this.endOfAdt = true;
            this.applyTDSpatches(var1);
        }

        this.attrTypes = new OracleType[var2.size()];
        var2.copyInto(this.attrTypes);
    }

    private void applyTDSpatches(TDSReader var1) throws SQLException {
        for(TDSPatch var2 = var1.getNextPatch(); var2 != null; var2 = var1.getNextPatch()) {
            var1.moveToPatchPos(var2);
            int var3 = var2.getType();
            if (var3 == 0) {
                var1.readByte();
                byte var4 = var2.getUptTypeCode();
                OracleNamedType var5;
                OracleTypeOPAQUE var6;
                switch(var4) {
                    case -6:
                        var1.readLong();
                    case -5:
                        var5 = var2.getOwner();
                        var6 = null;
                        OracleTypeADT var11;
                        if (var5.hasName()) {
                            var11 = new OracleTypeADT(var5.getFullName(), this.connection);
                        } else {
                            var11 = new OracleTypeADT(var5.getParent(), var5.getOrder(), this.connection);
                        }

                        var11.setUptADT();
                        TDSReader var7 = var11.parseTDS(var1.tds(), var1.absoluteOffset());
                        var1.skipBytes((int)var7.offset());
                        var2.apply(var11.cleanup());
                        break;
                    case 58:
                        var5 = var2.getOwner();
                        var6 = null;
                        if (var5.hasName()) {
                            var6 = new OracleTypeOPAQUE(var5.getFullName(), this.connection);
                        } else {
                            var6 = new OracleTypeOPAQUE(var5.getParent(), var5.getOrder(), this.connection);
                        }

                        var6.parseTDSrec(var1);
                        var2.apply(var6);
                        break;
                    default:
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                        var10.fillInStackTrace();
                        throw var10;
                }
            } else {
                if (var3 != 1) {
                    SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 47, "parseTDS");
                    var9.fillInStackTrace();
                    throw var9;
                }

                OracleType var8 = this.getNextTypeObject(var1);
                var2.apply(var8, this.opcode);
            }
        }

    }

    public OracleNamedType cleanup() {
        synchronized(this.connection) {
            if (this.attrTypes.length == 1 && this.attrTypes[0] instanceof OracleTypeCOLLECTION) {
                OracleTypeCOLLECTION var5 = (OracleTypeCOLLECTION)this.attrTypes[0];
                var5.copy_properties(this);
                return var5;
            } else if (this.attrTypes.length == 1 && (this.statusBits & 128) != 0 && this.attrTypes[0] instanceof OracleTypeUPT && ((OracleTypeUPT)this.attrTypes[0]).realType instanceof OracleTypeOPAQUE) {
                OracleTypeOPAQUE var2 = (OracleTypeOPAQUE)((OracleTypeUPT)this.attrTypes[0]).realType;
                var2.copy_properties(this);
                return var2;
            } else {
                return this;
            }
        }
    }

    void copy_properties(OracleTypeADT var1) {
        this.sqlName = var1.sqlName;
        this.typeNameByUser = var1.typeNameByUser;
        this.parent = var1.parent;
        this.idx = var1.idx;
        this.connection = var1.connection;
        this.toid = var1.toid;
        this.tdsVersion = var1.tdsVersion;
        this.typeVersion = var1.typeVersion;
        this.tdoCState = var1.tdoCState;
        this.endOfAdt = var1.endOfAdt;
        this.attrTypeNames = var1.attrTypeNames;
    }

    OracleType getNextTypeObject(TDSReader var1) throws SQLException {
        while(true) {
            this.opcode = var1.readByte();
            if (this.opcode != 43) {
                if (this.opcode != 44) {
                    OracleTypeBINARY_DOUBLE var4;
                    OracleTypeCHAR var19;
                    OracleTypeNUMBER var20;
                    switch(this.opcode) {
                        case 1:
                            var19 = new OracleTypeCHAR(this.connection, 1);
                            var19.parseTDSrec(var1);
                            ++this.idx;
                            return var19;
                        case 2:
                            OracleTypeDATE var22 = new OracleTypeDATE();
                            var22.parseTDSrec(var1);
                            ++this.idx;
                            return var22;
                        case 3:
                            var20 = new OracleTypeNUMBER(3);
                            var20.parseTDSrec(var1);
                            ++this.idx;
                            return var20;
                        case 4:
                            var20 = new OracleTypeNUMBER(8);
                            var20.parseTDSrec(var1);
                            ++this.idx;
                            return var20;
                        case 5:
                            OracleTypeFLOAT var21 = new OracleTypeFLOAT();
                            var21.parseTDSrec(var1);
                            ++this.idx;
                            return var21;
                        case 6:
                            var20 = new OracleTypeNUMBER(2);
                            var20.parseTDSrec(var1);
                            ++this.idx;
                            return var20;
                        case 7:
                            var19 = new OracleTypeCHAR(this.connection, 12);
                            var19.parseTDSrec(var1);
                            ++this.idx;
                            return var19;
                        case 8:
                            OracleTypeSINT32 var18 = new OracleTypeSINT32(false);
                            var18.parseTDSrec(var1);
                            ++this.idx;
                            return var18;
                        case 9:
                            OracleTypeREF var17 = new OracleTypeREF(this, this.idx, this.connection);
                            var17.parseTDSrec(var1);
                            ++this.idx;
                            return var17;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 20:
                        case 22:
                        case 25:
                        case 26:
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case 38:
                        case 41:
                        case 43:
                        case 44:
                        default:
                            var4 = null;
                            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 48, "get_next_type: " + this.opcode);
                            var3.fillInStackTrace();
                            throw var3;
                        case 19:
                            OracleTypeRAW var16 = new OracleTypeRAW();
                            var16.parseTDSrec(var1);
                            ++this.idx;
                            return var16;
                        case 21:
                            OracleTypeTIMESTAMP var15 = new OracleTypeTIMESTAMP(this.connection);
                            var15.parseTDSrec(var1);
                            ++this.idx;
                            return var15;
                        case 23:
                            OracleTypeTIMESTAMPTZ var14 = new OracleTypeTIMESTAMPTZ(this.connection);
                            var14.parseTDSrec(var1);
                            ++this.idx;
                            return var14;
                        case 24:
                            OracleTypeINTERVAL var13 = new OracleTypeINTERVAL(this.connection);
                            var13.parseTDSrec(var1);
                            ++this.idx;
                            return var13;
                        case 27:
                            OracleTypeUPT var12 = new OracleTypeUPT(this, this.idx, this.connection);
                            var12.parseTDSrec(var1);
                            ++this.idx;
                            return var12;
                        case 28:
                            OracleTypeCOLLECTION var11 = new OracleTypeCOLLECTION(this, this.idx, this.connection);
                            var11.parseTDSrec(var1);
                            ++this.idx;
                            return var11;
                        case 29:
                            OracleTypeCLOB var10 = new OracleTypeCLOB(this.connection);
                            var10.parseTDSrec(var1);
                            if (this.attrTypeNames != null && this.attrTypeNames.length > this.idx - 1) {
                                var10.form = "NCLOB".equals(this.attrTypeNames[this.idx - 1]) ? 2 : 1;
                            } else if (this.sqlName != null && !this.endOfAdt) {
                                this.connection.getForm(this, var10, this.idx);
                            }

                            ++this.idx;
                            return var10;
                        case 30:
                            OracleTypeBLOB var9 = new OracleTypeBLOB(this.connection);
                            var9.parseTDSrec(var1);
                            ++this.idx;
                            return var9;
                        case 31:
                            OracleTypeBFILE var8 = new OracleTypeBFILE(this.connection);
                            var8.parseTDSrec(var1);
                            ++this.idx;
                            return var8;
                        case 33:
                            OracleTypeTIMESTAMPLTZ var7 = new OracleTypeTIMESTAMPLTZ(this.connection);
                            var7.parseTDSrec(var1);
                            ++this.idx;
                            return var7;
                        case 37:
                            OracleTypeBINARY_FLOAT var6 = new OracleTypeBINARY_FLOAT();
                            var6.parseTDSrec(var1);
                            ++this.idx;
                            return var6;
                        case 39:
                            OracleTypeADT var5 = new OracleTypeADT(this, this.idx, this.connection);
                            var5.setEmbeddedADT();
                            var5.parseTDSrec(var1);
                            ++this.idx;
                            return var5;
                        case 40:
                        case 42:
                            return null;
                        case 45:
                            var4 = new OracleTypeBINARY_DOUBLE();
                            var4.parseTDSrec(var1);
                            ++this.idx;
                            return var4;
                    }
                }

                byte var2 = var1.readByte();
                if (var1.isJavaObject(3, var2)) {
                    this.setStatusBits(16);
                }
            }
        }
    }

    public byte[] linearize(Datum var1) throws SQLException {
        synchronized(this.connection) {
            return this.pickle81(var1);
        }
    }

    public Datum unlinearize(byte[] var1, long var2, Datum var4, int var5, Map var6) throws SQLException {
        OracleConnection var7 = this.getConnection();
        Datum var8 = null;
        if (var7 == null) {
            var8 = this._unlinearize(var1, var2, var4, var5, var6);
        } else {
            synchronized(var7) {
                var8 = this._unlinearize(var1, var2, var4, var5, var6);
            }
        }

        return var8;
    }

    public Datum _unlinearize(byte[] var1, long var2, Datum var4, int var5, Map var6) throws SQLException {
        synchronized(this.connection) {
            if (var1 == null) {
                return null;
            } else {
                PickleContext var8 = new PickleContext(var1, var2);
                return this.unpickle81(var8, (STRUCT)var4, 1, var5, var6);
            }
        }
    }

    protected STRUCT unpickle81(PickleContext var1, STRUCT var2, int var3, int var4, Map var5) throws SQLException {
        STRUCT var6 = var2;
        long var7 = (long)var1.offset();
        byte var9 = var1.readByte();
        SQLException var15;
        if (!PickleContext.is81format(var9)) {
            var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Image is not in 8.1 format");
            var15.fillInStackTrace();
            throw var15;
        } else if (PickleContext.isCollectionImage_pctx(var9)) {
            var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Image is a collection image,expecting ADT");
            var15.fillInStackTrace();
            throw var15;
        } else if (!var1.readAndCheckVersion()) {
            var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Image version is not recognized");
            var15.fillInStackTrace();
            throw var15;
        } else {
            switch(var3) {
                case 3:
                    long var10 = (long)var1.readLength();
                    var6 = this.unpickle81Prefix(var1, var2, var9);
                    if (var6 == null) {
                        StructDescriptor var12 = this.createStructDescriptor();
                        var6 = this.createByteSTRUCT(var12, (byte[])null);
                    }

                    var6.setImage(var1.image(), var7, 0L);
                    var6.setImageLength(var10);
                    var1.skipTo(var7 + var10);
                    break;
                case 9:
                    var1.skipBytes(var1.readLength(true) - 2);
                    break;
                default:
                    var1.skipLength();
                    var6 = this.unpickle81Prefix(var1, var2, var9);
                    if (var6 == null) {
                        StructDescriptor var13 = this.createStructDescriptor();
                        var6 = this.createByteSTRUCT(var13, (byte[])null);
                    }

                    OracleType[] var14 = var6.getDescriptor().getOracleTypeADT().getAttrTypes();
                    int var18;
                    switch(var4) {
                        case 1:
                            Datum[] var16 = new Datum[var14.length];

                            for(var18 = 0; var18 < var14.length; ++var18) {
                                var16[var18] = (Datum)var14[var18].unpickle81rec(var1, var4, var5);
                            }

                            var6.setDatumArray(var16);
                            break;
                        case 2:
                            Object[] var11 = new Object[var14.length];

                            for(var18 = 0; var18 < var14.length; ++var18) {
                                var11[var18] = var14[var18].unpickle81rec(var1, var4, var5);
                            }

                            var6.setObjArray(var11);
                            break;
                        default:
                            SQLException var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                            var17.fillInStackTrace();
                            throw var17;
                    }
            }

            return var6;
        }
    }

    protected STRUCT unpickle81Prefix(PickleContext var1, STRUCT var2, byte var3) throws SQLException {
        STRUCT var4 = var2;
        if (PickleContext.hasPrefix(var3)) {
            long var5 = (long)(var1.readLength() + var1.absoluteOffset());
            byte var7 = var1.readByte();
            byte var8 = (byte)(var7 & 12);
            boolean var9 = var8 == 0;
            boolean var10 = var8 == 4;
            boolean var11 = var8 == 8;
            boolean var12 = var8 == 12;
            boolean var13 = (var7 & 16) != 0;
            if (var10) {
                byte[] var14 = var1.readBytes(16);
                String var15 = toid2typename(this.connection, var14);
                StructDescriptor var16 = (StructDescriptor)TypeDescriptor.getTypeDescriptor(var15, this.connection);
                if (var2 == null) {
                    var4 = this.createByteSTRUCT(var16, (byte[])null);
                } else {
                    var2.setDescriptor(var16);
                }
            }

            if (var13) {
                var1.readLength();
            }

            if (var11 | var12) {
                SQLException var17 = DatabaseError.createUnsupportedFeatureSqlException();
                var17.fillInStackTrace();
                throw var17;
            }

            var1.skipTo(var5);
        }

        return var4;
    }

    protected Object unpickle81rec(PickleContext var1, int var2, Map var3) throws SQLException {
        byte var4 = var1.readByte();
        byte var5 = 0;
        if (PickleContext.isAtomicNull(var4)) {
            return null;
        } else {
            if (PickleContext.isImmediatelyEmbeddedNull(var4)) {
                var5 = var1.readByte();
            }

            STRUCT var6 = this.unpickle81datum(var1, var4, var5);
            return this.toObject(var6, var2, var3);
        }
    }

    protected Object unpickle81rec(PickleContext var1, byte var2, int var3, Map var4) throws SQLException {
        STRUCT var5 = this.unpickle81datum(var1, var2, (byte)0);
        return this.toObject(var5, var3, var4);
    }

    private STRUCT unpickle81datum(PickleContext var1, byte var2, byte var3) throws SQLException {
        int var4 = this.getNumAttrs();
        StructDescriptor var5 = this.createStructDescriptor();
        STRUCT var6 = this.createByteSTRUCT(var5, (byte[])null);
        OracleType var7 = this.getAttrTypeAt(0);
        Object var8 = null;
        if (PickleContext.isImmediatelyEmbeddedNull(var2) && var3 == 1) {
            var8 = null;
        } else if (PickleContext.isImmediatelyEmbeddedNull(var2)) {
            var8 = ((OracleTypeADT)var7).unpickle81datum(var1, var2, (byte)(var3 - 1));
        } else if (PickleContext.isElementNull(var2)) {
            if (var7.getTypeCode() != 2002 && var7.getTypeCode() != 2008) {
                var8 = null;
            } else {
                var8 = var7.unpickle81datumAsNull(var1, var2, var3);
            }
        } else {
            var8 = var7.unpickle81rec(var1, var2, 1, (Map)null);
        }

        Datum[] var9 = new Datum[var4];
        var9[0] = (Datum)var8;

        for(int var10 = 1; var10 < var4; ++var10) {
            var7 = this.getAttrTypeAt(var10);
            var9[var10] = (Datum)var7.unpickle81rec(var1, 1, (Map)null);
        }

        var6.setDatumArray(var9);
        return var6;
    }

    protected Datum unpickle81datumAsNull(PickleContext var1, byte var2, byte var3) throws SQLException {
        int var4 = this.getNumAttrs();
        StructDescriptor var5 = this.createStructDescriptor();
        STRUCT var6 = this.createByteSTRUCT(var5, (byte[])null);
        Datum[] var7 = new Datum[var4];
        byte var8 = 0;
        OracleType var9 = this.getAttrTypeAt(var8);
        int var10;
        if (var9.getTypeCode() != 2002 && var9.getTypeCode() != 2008) {
            var10 = var8 + 1;
            var7[var8] = (Datum)null;
        } else {
            var10 = var8 + 1;
            var7[var8] = var9.unpickle81datumAsNull(var1, var2, var3);
        }

        for(; var10 < var4; ++var10) {
            var9 = this.getAttrTypeAt(var10);
            if (var9.getTypeCode() != 2002 && var9.getTypeCode() != 2008) {
                var7[var10] = (Datum)var9.unpickle81rec(var1, 1, (Map)null);
            } else {
                var7[var10] = (Datum)var9.unpickle81rec(var1, 1, (Map)null);
            }
        }

        var6.setDatumArray(var7);
        return var6;
    }

    public byte[] pickle81(Datum var1) throws SQLException {
        PickleContext var2 = new PickleContext();
        var2.initStream();
        this.pickle81(var2, var1);
        byte[] var3 = var2.stream2Bytes();
        var1.setShareBytes(var3);
        return var3;
    }

    protected int pickle81(PickleContext var1, Datum var2) throws SQLException {
        int var3 = var1.offset() + 2;
        byte var4 = 0;
        int var5 = var4 + var1.writeImageHeader(this.shouldHavePrefix());
        var5 += this.pickle81Prefix(var1);
        var5 += this.pickle81rec(var1, var2, 0);
        var1.patchImageLen(var3, var5);
        return var5;
    }

    private boolean hasVersion() {
        return this.typeVersion > 1;
    }

    private boolean needsToid() {
        if (this.isTransient) {
            return false;
        } else {
            return (this.statusBits & 64) != 0 || (this.statusBits & 32) == 0 || this.hasVersion();
        }
    }

    private boolean shouldHavePrefix() {
        if (this.isTransient) {
            return false;
        } else {
            return this.hasVersion() || this.needsToid();
        }
    }

    protected int pickle81Prefix(PickleContext var1) throws SQLException {
        if (this.shouldHavePrefix()) {
            boolean var2 = false;
            int var3 = 1;
            int var4 = 1;
            if (this.needsToid()) {
                var4 += this.getTOID().length;
                var3 |= 4;
            }

            if (this.hasVersion()) {
                var3 |= 16;
                if (this.typeVersion > PickleContext.KOPI20_LN_MAXV) {
                    var4 += 5;
                } else {
                    var4 += 2;
                }
            }

            int var5 = var1.writeLength(var4);
            var5 += var1.writeData((byte)var3);
            if (this.needsToid()) {
                var5 += var1.writeData(this.toid);
            }

            if (this.hasVersion()) {
                if (this.typeVersion > PickleContext.KOPI20_LN_MAXV) {
                    var5 += var1.writeLength(this.typeVersion);
                } else {
                    var5 += var1.writeSB2(this.typeVersion);
                }
            }

            return var5;
        } else {
            return 0;
        }
    }

    private int pickle81rec(PickleContext var1, Datum var2, int var3) throws SQLException {
        int var4 = 0;
        if (!this.metaDataInitialized) {
            this.copy_properties((OracleTypeADT)((STRUCT)var2).getDescriptor().getPickler());
        }

        Datum[] var5 = ((STRUCT)var2).getOracleAttributes();
        int var6 = var5.length;
        int var7 = 0;
        OracleType var8 = this.getAttrTypeAt(0);
        if (var8 instanceof OracleTypeADT && !(var8 instanceof OracleTypeCOLLECTION) && !(var8 instanceof OracleTypeUPT)) {
            var7 = 1;
            if (var5[0] == null) {
                if (var3 > 0) {
                    var4 += var1.writeImmediatelyEmbeddedElementNull((byte)var3);
                } else {
                    var4 += var1.writeAtomicNull();
                }
            } else {
                var4 += ((OracleTypeADT)var8).pickle81rec(var1, var5[0], var3 + 1);
            }
        }

        for(; var7 < var6; ++var7) {
            var8 = this.getAttrTypeAt(var7);
            if (var5[var7] == null) {
                if (var8 instanceof OracleTypeADT && !(var8 instanceof OracleTypeCOLLECTION) && !(var8 instanceof OracleTypeUPT)) {
                    var4 += var1.writeAtomicNull();
                } else {
                    var4 += var1.writeElementNull();
                }
            } else if (var8 instanceof OracleTypeADT && !(var8 instanceof OracleTypeCOLLECTION) && !(var8 instanceof OracleTypeUPT)) {
                var4 += ((OracleTypeADT)var8).pickle81rec(var1, var5[var7], 1);
            } else {
                var4 += var8.pickle81(var1, var5[var7]);
            }
        }

        return var4;
    }

    private Object toObject(STRUCT var1, int var2, Map var3) throws SQLException {
        switch(var2) {
            case 1:
                return var1;
            case 2:
                if (var1 != null) {
                    return var1.toJdbc(var3);
                }

                return null;
            default:
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                var4.fillInStackTrace();
                throw var4;
        }
    }

    public String getAttributeType(int var1) throws SQLException {
        return this.getAttributeType(var1, true);
    }

    public String getAttributeType(int var1, boolean var2) throws SQLException {
        if (var2) {
            if (this.sqlName == null) {
                this.getFullName();
            }

            if (this.attrNames == null) {
                this.initADTAttrNames();
            }
        }

        if (var1 < 1 || this.attrTypeNames != null && var1 > this.attrTypeNames.length) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid index");
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.attrTypeNames != null ? this.attrTypeNames[var1 - 1] : null;
        }
    }

    public String getAttributeName(int var1) throws SQLException {
        if (this.attrNames == null) {
            this.initADTAttrNames();
        }

        String var2 = null;
        if (this.attrNames != null) {
            synchronized(this.connection) {
                if (var1 < 1 || var1 > this.attrNames.length) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid index");
                    var4.fillInStackTrace();
                    throw var4;
                }
            }

            var2 = this.attrNames[var1 - 1];
        }

        return var2;
    }

    public String getAttributeName(int var1, boolean var2) throws SQLException {
        if (var2 && this.connection != null) {
            return this.getAttributeName(var1);
        } else if (var1 >= 1 && (this.attrNames == null || var1 <= this.attrNames.length)) {
            return this.attrNames != null ? this.attrNames[var1 - 1] : null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid index");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    private void initADTAttrNames() throws SQLException {
        if (this.connection != null) {
            if (this.sqlName == null) {
                this.getFullName();
            }

            if (this.toid != null) {
                this.initADTAttrNamesUsingTOID();
            } else {
                synchronized(this.connection) {
                    Object var2 = null;
                    PreparedStatement var3 = null;
                    ResultSet var4 = null;
                    String[] var5 = new String[this.attrTypes.length];
                    String[] var6 = new String[this.attrTypes.length];
                    boolean var7 = false;
                    boolean var8 = false;
                    if (this.attrNames == null) {
                        this.connection.beginNonRequestCalls();

                        try {
                            int var22 = this.sqlName.getSchema().equals(this.connection.getDefaultSchemaNameForNamedTypes()) ? 0 : 7;

                            while(var22 != 11) {
                                switch(var22) {
                                    case 0:
                                        var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var22]);
                                        var3.setString(1, this.sqlName.getSimpleName());
                                        var3.setFetchSize(this.idx);
                                        var4 = var3.executeQuery();
                                        var22 = 1;
                                        break;
                                    case 1:
                                        if (this.connection.getVersionNumber() >= 10000) {
                                            var22 = 2;
                                        }
                                    case 2:
                                        var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var22]);
                                        var3.setString(1, this.sqlName.getSimpleName());
                                        var3.setString(2, this.sqlName.getSimpleName());
                                        var3.setFetchSize(this.idx);
                                        var4 = var3.executeQuery();
                                        var22 = 3;
                                        break;
                                    case 3:
                                        if (this.connection.getVersionNumber() >= 10000) {
                                            var22 = 4;
                                        }
                                    case 4:
                                        var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var22]);
                                        var3.setString(1, this.sqlName.getSimpleName());
                                        var3.setString(2, this.sqlName.getSimpleName());
                                        var3.setFetchSize(this.idx);
                                        var4 = var3.executeQuery();
                                        var22 = 5;
                                        break;
                                    case 5:
                                        if (this.connection.getVersionNumber() >= 10000) {
                                            var22 = 6;
                                        }
                                    case 6:
                                        var2 = (OracleCallableStatement)this.connection.prepareCall(this.getSqlHint() + sqlString[var22]);
                                        ((CallableStatement)var2).setString(1, this.sqlName.getSimpleName());
                                        ((CallableStatement)var2).setString(3, this.sqlName.getSimpleName());
                                        ((CallableStatement)var2).registerOutParameter(2, -10);
                                        ((CallableStatement)var2).execute();
                                        var4 = ((OracleCallableStatement)var2).getCursor(2);
                                        var4.setFetchSize(1);
                                        var22 = 8;
                                        break;
                                    case 7:
                                        var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var22]);
                                        var3.setString(1, this.sqlName.getSchema());
                                        var3.setString(2, this.sqlName.getSimpleName());
                                        var3.setFetchSize(this.idx);
                                        var4 = var3.executeQuery();
                                        var22 = 8;
                                        break;
                                    case 8:
                                        var3 = this.connection.prepareStatement(this.getSqlHint() + sqlString[var22]);
                                        var3.setString(1, this.sqlName.getSimpleName());
                                        var3.setString(2, this.sqlName.getSimpleName());
                                        var3.setFetchSize(this.idx);
                                        var4 = var3.executeQuery();
                                        var22 = 9;
                                        break;
                                    case 9:
                                        if (this.connection.getVersionNumber() >= 10000) {
                                            var22 = 10;
                                        }
                                    case 10:
                                        var2 = this.connection.prepareCall(this.getSqlHint() + sqlString[var22]);
                                        ((CallableStatement)var2).setString(1, this.sqlName.getSimpleName());
                                        ((CallableStatement)var2).registerOutParameter(2, -10);
                                        ((CallableStatement)var2).execute();
                                        var4 = ((OracleCallableStatement)var2).getCursor(2);
                                        var22 = 11;
                                }

                                try {
                                    int var23;
                                    for(var23 = 0; var23 < this.attrTypes.length && var4.next(); ++var23) {
                                        if (var4.getInt(1) != var23 + 1) {
                                            SQLException var24 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "inconsistent ADT attribute");
                                            var24.fillInStackTrace();
                                            throw var24;
                                        }

                                        var5[var23] = var4.getString(2);
                                        String var9 = var4.getString(4);
                                        var6[var23] = "";
                                        if (var9 != null) {
                                            var6[var23] = var9 + ".";
                                        }

                                        var6[var23] = var6[var23] + var4.getString(3);
                                    }

                                    if (var23 != 0) {
                                        this.attrTypeNames = var6;
                                        this.attrNames = var5;
                                        var22 = 11;
                                    } else {
                                        if (var4 != null) {
                                            var4.close();
                                        }

                                        if (var3 != null) {
                                            var3.close();
                                        }

                                        if (var2 != null) {
                                            ((CallableStatement)var2).close();
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
                                        ((CallableStatement)var2).close();
                                    }

                                }
                            }
                        } finally {
                            this.connection.endNonRequestCalls();
                        }
                    }

                }
            }
        }
    }

    private void initADTAttrNamesUsingTOID() throws SQLException {
        synchronized(this.connection) {
            Object var2 = null;
            PreparedStatement var3 = null;
            ResultSet var4 = null;
            String[] var5 = new String[this.attrTypes.length];
            String[] var6 = new String[this.attrTypes.length];
            boolean var7 = false;
            boolean var8 = false;
            if (this.attrNames == null) {
                this.connection.beginNonRequestCalls();

                try {
                    int var22 = this.sqlName.getSchema().equals(this.connection.getDefaultSchemaNameForNamedTypes()) ? 0 : 1;

                    while(var22 != 11) {
                        switch(var22) {
                            case 0:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlStringTOID[var22]);
                                var3.setBytes(1, this.toid);
                                var3.setFetchSize(this.idx);
                                var4 = var3.executeQuery();
                                var22 = 1;
                                break;
                            case 1:
                                var3 = this.connection.prepareStatement(this.getSqlHint() + sqlStringTOID[var22]);
                                var3.setBytes(1, this.toid);
                                var3.setFetchSize(this.idx);
                                var4 = var3.executeQuery();
                                var22 = 11;
                        }

                        try {
                            int var23;
                            for(var23 = 0; var23 < this.attrTypes.length && var4.next(); ++var23) {
                                if (var4.getInt(1) != var23 + 1 && var22 == 1) {
                                    SQLException var24 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "inconsistent ADT attribute");
                                    var24.fillInStackTrace();
                                    throw var24;
                                }

                                var5[var23] = var4.getString(2);
                                String var9 = var4.getString(4);
                                var6[var23] = "";
                                if (var9 != null) {
                                    var6[var23] = var9 + ".";
                                }

                                var6[var23] = var6[var23] + var4.getString(3);
                            }

                            if (var23 != 0) {
                                this.attrTypeNames = var6;
                                this.attrNames = var5;
                                var22 = 11;
                            } else {
                                if (var4 != null) {
                                    var4.close();
                                }

                                if (var3 != null) {
                                    var3.close();
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
                                ((CallableStatement)var2).close();
                            }

                        }
                    }
                } finally {
                    this.connection.endNonRequestCalls();
                }
            }

        }
    }

    StructDescriptor createStructDescriptor() throws SQLException {
        StructDescriptor var1 = (StructDescriptor)this.descriptor;
        if (this.typeNameByUser == null && this.parent != null && this.parent.getTypeCode() == 2003) {
            this.typeNameByUser = this.parent.getAttributeType(1);
        }

        if (var1 == null) {
            var1 = new StructDescriptor(this, this.connection);
        }

        return var1;
    }

    STRUCT createObjSTRUCT(StructDescriptor var1, Object[] var2) throws SQLException {
        return (STRUCT)((this.statusBits & 16) != 0 ? new JAVA_STRUCT(var1, this.connection, var2) : new STRUCT(var1, this.connection, var2));
    }

    STRUCT createByteSTRUCT(StructDescriptor var1, byte[] var2) throws SQLException {
        return (STRUCT)((this.statusBits & 16) != 0 ? new JAVA_STRUCT(var1, var2, this.connection) : new STRUCT(var1, var2, this.connection));
    }

    public static String getSubtypeName(Connection var0, byte[] var1, long var2) throws SQLException {
        PickleContext var4 = new PickleContext(var1, var2);
        byte var5 = var4.readByte();
        if (PickleContext.is81format(var5) && !PickleContext.isCollectionImage_pctx(var5) && PickleContext.hasPrefix(var5)) {
            if (!var4.readAndCheckVersion()) {
                SQLException var7 = DatabaseError.createSqlException((OracleConnection)null, 1, "Image version is not recognized");
                var7.fillInStackTrace();
                throw var7;
            } else {
                var4.skipLength();
                var4.skipLength();
                var5 = var4.readByte();
                if ((var5 & 4) != 0) {
                    byte[] var6 = var4.readBytes(16);
                    return toid2typename(var0, var6);
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    public static String toid2typename(Connection var0, byte[] var1) throws SQLException {
        String var2 = (String)((OracleConnection)var0).getDescriptor(var1);
        if (var2 == null) {
            PreparedStatement var3 = null;
            ResultSet var4 = null;
            ((OracleConnection)var0).beginNonRequestCalls();

            try {
                var3 = var0.prepareStatement("select owner, type_name from all_types where type_oid = :1");
                var3.setBytes(1, var1);
                var4 = var3.executeQuery();
                if (!var4.next()) {
                    SQLException var5 = DatabaseError.createSqlException((OracleConnection)null, 1, "Invalid type oid");
                    var5.fillInStackTrace();
                    throw var5;
                }

                var2 = var4.getString(1) + "." + var4.getString(2);
                ((OracleConnection)var0).putDescriptor(var1, var2);
            } finally {
                if (var4 != null) {
                    var4.close();
                }

                if (var3 != null) {
                    var3.close();
                }

                ((OracleConnection)var0).endNonRequestCalls();
            }
        }

        return var2;
    }

    public int getTdsVersion() {
        return this.tdsVersion;
    }

    public void printDebug() {
    }

    private String debugText() {
        StringWriter var1 = new StringWriter();
        PrintWriter var2 = new PrintWriter(var1);
        var2.println("OracleTypeADT = " + this);
        var2.println("sqlName = " + this.sqlName);
        var2.println("OracleType[] : ");
        if (this.attrTypes != null) {
            for(int var3 = 0; var3 < this.attrTypes.length; ++var3) {
                var2.println("[" + var3 + "] = " + this.attrTypes[var3]);
            }
        } else {
            var2.println("null");
        }

        var2.println("toid : ");
        if (this.toid != null) {
            this.printUnsignedByteArray(this.toid, var2);
        } else {
            var2.println("null");
        }

        var2.println("tds version : " + this.tdsVersion);
        var2.println("type version : " + this.typeVersion);
        var2.println("type version : " + this.typeVersion);
        var2.println("opcode : " + this.opcode);
        var2.println("tdoCState : " + this.tdoCState);
        return var1.getBuffer().substring(0);
    }

    public byte[] getTOID() {
        try {
            if (this.toid == null) {
                this.initMetadata(this.connection);
            }
        } catch (SQLException var2) {
        }

        return this.toid;
    }

    public int getImageFormatVersion() {
        return PickleContext.KOPI20_VERSION;
    }

    public int getTypeVersion() {
        try {
            if (this.typeVersion == -1) {
                this.initMetadata(this.connection);
            }
        } catch (SQLException var2) {
        }

        return this.typeVersion;
    }

    public int getCharSet() {
        return this.charSetId;
    }

    public int getCharSetForm() {
        return this.charSetForm;
    }

    public long getTdoCState() {
        synchronized(this.connection) {
            try {
                if (this.tdoCState == 0L) {
                    if (this.connection.getVersionNumber() >= 12000 && this.typeNameByUser != null) {
                        this.tdoCState = this.connection.getTdoCState(this.typeNameByUser);
                    } else {
                        this.getFullName();
                        this.tdoCState = this.connection.getTdoCState(this.sqlName.getSchema(), this.sqlName.getSimpleName());
                    }
                }
            } catch (SQLException var4) {
            }

            return this.tdoCState;
        }
    }

    public long getFIXED_DATA_SIZE() {
        try {
            return this.getFixedDataSize();
        } catch (SQLException var2) {
            return 0L;
        }
    }

    public long getFixedDataSize() throws SQLException {
        return this.fixedDataSize;
    }

    public int getAlignmentReq() throws SQLException {
        return this.alignmentRequirement;
    }

    public int getNumAttrs() throws SQLException {
        if (this.attrTypes == null && this.connection != null) {
            this.init(this.connection);
        }

        return this.attrTypes.length;
    }

    public OracleType getAttrTypeAt(int var1) throws SQLException {
        if (this.attrTypes == null && this.connection != null) {
            this.init(this.connection);
        }

        return this.attrTypes[var1];
    }

    public boolean isEmbeddedADT() throws SQLException {
        return (this.statusBits & 2) != 0;
    }

    public boolean isUptADT() throws SQLException {
        return (this.statusBits & 4) != 0;
    }

    public boolean isTopADT() throws SQLException {
        return (this.statusBits & 1) != 0;
    }

    public void setStatus(int var1) throws SQLException {
        this.statusBits = var1;
    }

    void setEmbeddedADT() throws SQLException {
        this.maskAndSetStatusBits(-16, 2);
    }

    void setUptADT() throws SQLException {
        this.maskAndSetStatusBits(-16, 4);
    }

    public boolean isSubType() throws SQLException {
        return (this.statusBits & 64) != 0;
    }

    public boolean isFinalType() throws SQLException {
        return (this.statusBits & 32) != 0 | (this.statusBits & 2) != 0;
    }

    public boolean isJavaObject() throws SQLException {
        return (this.statusBits & 16) != 0;
    }

    public int getStatus() throws SQLException {
        if ((this.statusBits & 1) != 0 && (this.statusBits & 256) == 0) {
            this.init(this.connection);
        }

        return this.statusBits;
    }

    public static OracleTypeADT shallowClone(OracleTypeADT var0) throws SQLException {
        OracleTypeADT var1 = new OracleTypeADT();
        shallowCopy(var0, var1);
        return var1;
    }

    public static void shallowCopy(OracleTypeADT var0, OracleTypeADT var1) throws SQLException {
        var1.connection = var0.connection;
        var1.sqlName = var0.sqlName;
        var1.parent = var0.parent;
        var1.idx = var0.idx;
        var1.descriptor = var0.descriptor;
        var1.statusBits = var0.statusBits;
        var1.typeCode = var0.typeCode;
        var1.dbTypeCode = var0.dbTypeCode;
        var1.tdsVersion = var0.tdsVersion;
        var1.typeVersion = var0.typeVersion;
        var1.fixedDataSize = var0.fixedDataSize;
        var1.alignmentRequirement = var0.alignmentRequirement;
        var1.attrTypes = var0.attrTypes;
        var1.sqlName = var0.sqlName;
        var1.tdoCState = var0.tdoCState;
        var1.toid = var0.toid;
        var1.charSetId = var0.charSetId;
        var1.charSetForm = var0.charSetForm;
        var1.flattenedAttrNum = var0.flattenedAttrNum;
        var1.statusBits = var0.statusBits;
        var1.attrNames = var0.attrNames;
        var1.attrTypeNames = var0.attrTypeNames;
        var1.opcode = var0.opcode;
        var1.idx = var0.idx;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeInt(this.statusBits);
        var1.writeInt(this.tdsVersion);
        var1.writeInt(this.typeVersion);
        var1.writeObject((Object)null);
        var1.writeObject((Object)null);
        var1.writeLong(this.fixedDataSize);
        var1.writeInt(this.alignmentRequirement);
        var1.writeObject(this.attrTypes);
        var1.writeObject(this.attrNames);
        var1.writeObject(this.attrTypeNames);
        var1.writeLong(this.tdoCState);
        var1.writeObject(this.toid);
        var1.writeObject((Object)null);
        var1.writeInt(this.charSetId);
        var1.writeInt(this.charSetForm);
        var1.writeBoolean(true);
        var1.writeInt(this.flattenedAttrNum);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.statusBits = var1.readInt();
        this.tdsVersion = var1.readInt();
        this.typeVersion = var1.readInt();
        var1.readObject();
        var1.readObject();
        var1.readLong();
        var1.readInt();
        this.attrTypes = (OracleType[])((OracleType[])var1.readObject());
        this.attrNames = (String[])((String[])var1.readObject());
        this.attrTypeNames = (String[])((String[])var1.readObject());
        var1.readLong();
        this.toid = (byte[])((byte[])var1.readObject());
        var1.readObject();
        this.charSetId = var1.readInt();
        this.charSetForm = var1.readInt();
        var1.readBoolean();
        this.flattenedAttrNum = var1.readInt();
    }

    public void setConnection(OracleConnection var1) throws SQLException {
        synchronized(var1) {
            this.connection = var1;

            for(int var3 = 0; var3 < this.attrTypes.length; ++var3) {
                this.attrTypes[var3].setConnection(this.connection);
            }

        }
    }

    private void setStatusBits(int var1) {
        synchronized(this.connection) {
            this.statusBits |= var1;
        }
    }

    private void maskAndSetStatusBits(int var1, int var2) {
        synchronized(this.connection) {
            this.statusBits &= var1;
            this.statusBits |= var2;
        }
    }

    private void printUnsignedByteArray(byte[] var1, PrintWriter var2) {
        int var3 = var1.length;
        int[] var5 = Util.toJavaUnsignedBytes(var1);

        int var4;
        for(var4 = 0; var4 < var3; ++var4) {
            var2.print("0x" + Integer.toHexString(var5[var4]) + " ");
        }

        var2.println();

        for(var4 = 0; var4 < var3; ++var4) {
            var2.print(var5[var4] + " ");
        }

        var2.println();
    }

    public void initChildNamesRecursively(Map var1) throws SQLException {
        TypeTreeElement var2 = (TypeTreeElement)((TypeTreeElement)var1.get(this.sqlName));
        if (this.attrTypes != null && this.attrTypes.length > 0) {
            for(int var3 = 0; var3 < this.attrTypes.length; ++var3) {
                OracleType var4 = this.attrTypes[var3];
                var4.setNames(var2.getChildSchemaName(var3 + 1), var2.getChildTypeName(var3 + 1));
                var4.initChildNamesRecursively(var1);
                var4.cacheDescriptor();
            }
        }

    }

    public void cacheDescriptor() throws SQLException {
        this.descriptor = StructDescriptor.createDescriptor(this);
    }

    private void initMetaData1() throws SQLException {
        short var1 = this.connection.getVersionNumber();
        if (var1 >= 9000) {
            this.initMetaData1_9_0();
        } else {
            this.initMetaData1_pre_9_0();
        }

    }

    public Boolean isInstanciable() throws SQLException {
        if (this.isInstanciable == null) {
            this.initMetaData1();
        }

        return this.isInstanciable;
    }

    public String getSuperTypeName() throws SQLException {
        if (this.superTypeName == null) {
            this.initMetaData1();
        }

        return this.superTypeName;
    }

    public int getNumberOfLocalAttributes() throws SQLException {
        if (this.numberOfLocalAttributes == -1) {
            this.initMetaData1();
        }

        return this.numberOfLocalAttributes;
    }

    public String[] getSubtypeNames() throws SQLException {
        if (this.subTypeNames == null) {
            this.initMetaData1();
        }

        return this.subTypeNames;
    }

    private void initMetaData1_9_0() throws SQLException {
        if (this.getTOID() != null) {
            this.initMetaData1_9_0UseToid();
        } else {
            int var1 = 0;
            if (this.sqlName == null) {
                this.getFullName();
            }

            synchronized(this.connection) {
                synchronized(this) {
                    if (this.numberOfLocalAttributes == -1) {
                        PreparedStatement var4 = null;
                        OracleCallableStatement var5 = null;
                        ResultSet var6 = null;
                        boolean var7 = true;
                        this.connection.beginNonRequestCalls();

                        int var21;
                        try {
                            while(true) {
                                label180:
                                while(true) {
                                    switch(var1) {
                                        case 0:
                                            var4 = this.connection.prepareStatement(this.initMetaData1_9_0_SQL[var1]);
                                            var4.setString(1, this.sqlName.getSimpleName());
                                            var4.setString(2, this.sqlName.getSchema());
                                            var4.setFetchSize(1);
                                            var6 = var4.executeQuery();
                                            break label180;
                                        case 1:
                                        case 2:
                                            try {
                                                var5 = (OracleCallableStatement)this.connection.prepareCall(this.initMetaData1_9_0_SQL[var1]);
                                                var5.setString(1, this.sqlName.getSimpleName());
                                                var5.registerOutParameter(2, -10);
                                                var5.execute();
                                                var6 = var5.getCursor(2);
                                                var6.setFetchSize(1);
                                            } catch (SQLException var17) {
                                                if (var17.getErrorCode() == 1403) {
                                                    if (var1 != 1) {
                                                        SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Inconsistent catalog view");
                                                        var9.fillInStackTrace();
                                                        throw var9;
                                                    }

                                                    var5.close();
                                                    ++var1;
                                                    break;
                                                }

                                                throw var17;
                                            }
                                        default:
                                            break label180;
                                    }
                                }

                                if (var6.next()) {
                                    this.isInstanciable = new Boolean(var6.getString(1).equals("YES"));
                                    this.superTypeName = var6.getString(2) + "." + var6.getString(3);
                                    var21 = var6.getInt(4);
                                    break;
                                }

                                if (var1 == 2) {
                                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Inconsistent catalog view");
                                    var8.fillInStackTrace();
                                    throw var8;
                                }

                                var6.close();
                                if (var5 != null) {
                                    var5.close();
                                }

                                ++var1;
                            }
                        } finally {
                            if (var6 != null) {
                                var6.close();
                            }

                            if (var4 != null) {
                                var4.close();
                            }

                            if (var5 != null) {
                                var5.close();
                            }

                            this.connection.endNonRequestCalls();
                        }

                        this.numberOfLocalAttributes = var21;
                    }
                }

            }
        }
    }

    private void initMetaData1_9_0UseToid() throws SQLException {
        String var1 = "SELECT INSTANTIABLE, supertype_owner, supertype_name, LOCAL_ATTRIBUTES, cursor(select owner, type_name from all_types WHERE supertype_name = t.type_name and supertype_owner = t.owner)  FROM all_types t WHERE TYPE_OID = :3";
        PreparedStatement var2 = null;
        ResultSet var3 = null;
        ResultSet var4 = null;
        if (this.sqlName == null) {
            this.getFullName();
        }

        try {
            this.connection.beginNonRequestCalls();
            var2 = this.connection.prepareStatement(var1);
            var2.setBytes(1, this.getTOID());
            var2.setFetchSize(1);
            var3 = var2.executeQuery();
            if (!var3.next()) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Inconsistent catalog view");
                var10.fillInStackTrace();
                throw var10;
            }

            if (var3.getString(1) == null) {
                this.isInstanciable = true;
            } else {
                this.isInstanciable = new Boolean(var3.getString(1).equals("YES"));
            }

            this.superTypeName = var3.getString(2) + "." + var3.getString(3);
            this.numberOfLocalAttributes = var3.getInt(4);
            var4 = (ResultSet)var3.getObject(5);
            ArrayList var5 = new ArrayList(5);

            while(var4.next()) {
                var5.add(var4.getString(1) + "." + var4.getString(2));
            }

            this.subTypeNames = new String[var5.size()];

            for(int var6 = 0; var6 < this.subTypeNames.length; ++var6) {
                this.subTypeNames[var6] = (String)var5.get(var6);
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

    private synchronized void initMetaData1_pre_9_0() throws SQLException {
        this.isInstanciable = new Boolean(true);
        this.superTypeName = "";
        this.numberOfLocalAttributes = 0;
    }

    private void initMetaData2() throws SQLException {
        short var1 = this.connection.getVersionNumber();
        if (var1 >= 9000) {
            this.initMetaData2_9_0();
        } else {
            this.initMetaData2_pre_9_0();
        }

    }

    private void initMetaData2_9_0() throws SQLException {
        if (this.getTOID() != null) {
            this.initMetaData1_9_0UseToid();
        } else {
            if (this.sqlName == null) {
                this.getFullName();
            }

            synchronized(this.connection) {
                synchronized(this) {
                    if (this.subTypeNames == null) {
                        PreparedStatement var3 = null;
                        ResultSet var4 = null;
                        String[] var5 = null;
                        this.connection.beginNonRequestCalls();

                        try {
                            var3 = this.connection.prepareStatement("select owner, type_name from all_types where supertype_name = :1 and supertype_owner = :2");
                            var3.setString(1, this.sqlName.getSimpleName());
                            var3.setString(2, this.sqlName.getSchema());
                            var4 = var3.executeQuery();
                            Vector var6 = new Vector();

                            while(true) {
                                if (!var4.next()) {
                                    var5 = new String[var6.size()];

                                    for(int var7 = 0; var7 < var5.length; ++var7) {
                                        var5[var7] = (String)var6.elementAt(var7);
                                    }

                                    var6.removeAllElements();
                                    var6 = null;
                                    break;
                                }

                                var6.addElement(var4.getString(1) + "." + var4.getString(2));
                            }
                        } finally {
                            if (var4 != null) {
                                var4.close();
                            }

                            if (var3 != null) {
                                var3.close();
                            }

                            this.connection.endNonRequestCalls();
                        }

                        this.subTypeNames = var5;
                    }
                }

            }
        }
    }

    private void initMetaData2_pre_9_0() throws SQLException {
        this.subTypeNames = new String[0];
    }

    public void printXML(PrintWriter var1, int var2) throws SQLException {
        this.printXML(var1, var2, false);
    }

    public void printXML(PrintWriter var1, int var2, boolean var3) throws SQLException {
        int var4;
        for(var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.print("<OracleTypeADT sqlName=\"" + this.sqlName + "\" ");
        var1.print(" typecode=\"" + this.typeCode + "\"");
        if (this.tdsVersion != -9999) {
            var1.print(" tds_version=\"" + this.tdsVersion + "\"");
        }

        var1.println();

        for(var4 = 0; var4 < var2 + 4; ++var4) {
            var1.print("  ");
        }

        var1.println(" is_embedded=\"" + this.isEmbeddedADT() + "\"" + " is_top_level=\"" + this.isTopADT() + "\"" + " is_upt=\"" + this.isUptADT() + "\"" + " finalType=\"" + this.isFinalType() + "\"" + " subtype=\"" + this.isSubType() + "\">");
        if (this.attrTypes != null && this.attrTypes.length > 0) {
            for(var4 = 0; var4 < var2 + 1; ++var4) {
                var1.print("  ");
            }

            var1.println("<attributes>");

            for(var4 = 0; var4 < this.attrTypes.length; ++var4) {
                int var5;
                for(var5 = 0; var5 < var2 + 2; ++var5) {
                    var1.print("  ");
                }

                var1.println("<attribute name=\"" + this.getAttributeName(var4 + 1, var3) + "\" " + " type=\"" + this.getAttributeType(var4 + 1, false) + "\" >");
                this.attrTypes[var4].printXML(var1, var2 + 3, var3);

                for(var5 = 0; var5 < var2 + 2; ++var5) {
                    var1.print("  ");
                }

                var1.println("</attribute> ");
            }

            for(var4 = 0; var4 < var2 + 1; ++var4) {
                var1.print("  ");
            }

            var1.println("</attributes>");
        }

        for(var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.println("</OracleTypeADT>");
    }
}
