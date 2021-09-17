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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.Datum;
import oracle.sql.SQLName;
import oracle.sql.TypeDescriptor;

public abstract class OracleNamedType extends OracleType implements Serializable {
    transient OracleConnection connection;
    SQLName sqlName = null;
    transient OracleTypeADT parent = null;
    transient int idx;
    transient TypeDescriptor descriptor = null;
    String typeNameByUser;
    static String getUserTypeTreeSql = "select level depth, parent_type, child_type, ATTR_NO, child_type_owner from  (select TYPE_NAME parent_type, ELEM_TYPE_NAME child_type, 0 ATTR_NO,       ELEM_TYPE_OWNER child_type_owner     from USER_COLL_TYPES  union   select TYPE_NAME parent_type, ATTR_TYPE_NAME child_type, ATTR_NO,       ATTR_TYPE_OWNER child_type_owner     from USER_TYPE_ATTRS  ) start with parent_type  = ?  connect by prior  child_type = parent_type";
    String sqlHint = null;
    static String getAllTypeTreeSql = "select parent_type, parent_type_owner, child_type, ATTR_NO, child_type_owner from ( select TYPE_NAME parent_type,  OWNER parent_type_owner,     ELEM_TYPE_NAME child_type, 0 ATTR_NO,     ELEM_TYPE_OWNER child_type_owner   from ALL_COLL_TYPES union   select TYPE_NAME parent_type, OWNER parent_type_owner,     ATTR_TYPE_NAME child_type, ATTR_NO,     ATTR_TYPE_OWNER child_type_owner   from ALL_TYPE_ATTRS ) start with parent_type  = ?  and parent_type_owner = ? connect by prior child_type = parent_type   and ( child_type_owner = parent_type_owner or child_type_owner is null )";
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleNamedType() {
    }

    public OracleNamedType(String var1, OracleConnection var2) throws SQLException {
        this.setConnectionInternal(var2);
        this.typeNameByUser = var1;
        this.sqlName = new SQLName(var1, var2);
    }

    protected OracleNamedType(OracleTypeADT var1, int var2, OracleConnection var3) {
        this.setConnectionInternal(var3);
        this.parent = var1;
        this.idx = var2;
    }

    public String getFullName() throws SQLException {
        return this.getFullName(false);
    }

    public String getFullName(boolean var1) throws SQLException {
        String var2 = null;
        if (var1 || this.sqlName == null) {
            if (this.parent == null || (var2 = this.parent.getAttributeType(this.idx)) == null) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unable to resolve name");
                var3.fillInStackTrace();
                throw var3;
            }

            this.sqlName = new SQLName(var2, this.connection);
        }

        return this.sqlName.getName();
    }

    public String getSchemaName() throws SQLException {
        if (this.sqlName == null) {
            this.getFullName();
        }

        return this.sqlName.getSchema();
    }

    public String getSimpleName() throws SQLException {
        if (this.sqlName == null) {
            this.getFullName();
        }

        return this.sqlName.getSimpleName();
    }

    public boolean hasName() throws SQLException {
        return this.sqlName != null;
    }

    public OracleTypeADT getParent() throws SQLException {
        return this.parent;
    }

    public void setParent(OracleTypeADT var1) throws SQLException {
        this.parent = var1;
    }

    public int getOrder() throws SQLException {
        return this.idx;
    }

    public void setOrder(int var1) throws SQLException {
        this.idx = var1;
    }

    public OracleConnection getConnection() throws SQLException {
        return this.connection;
    }

    public void setConnection(OracleConnection var1) throws SQLException {
        this.setConnectionInternal(var1);
    }

    public void setConnectionInternal(OracleConnection var1) {
        this.connection = var1;
    }

    public Datum unlinearize(byte[] var1, long var2, Datum var4, int var5, Map var6) throws SQLException {
        SQLException var7 = DatabaseError.createUnsupportedFeatureSqlException();
        var7.fillInStackTrace();
        throw var7;
    }

    public Datum unlinearize(byte[] var1, long var2, Datum var4, long var5, int var7, int var8, Map var9) throws SQLException {
        SQLException var10 = DatabaseError.createUnsupportedFeatureSqlException();
        var10.fillInStackTrace();
        throw var10;
    }

    public byte[] linearize(Datum var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public TypeDescriptor getDescriptor() throws SQLException {
        return this.descriptor;
    }

    public void setDescriptor(TypeDescriptor var1) throws SQLException {
        this.descriptor = var1;
    }

    public int getTypeVersion() {
        return 1;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        try {
            var1.writeUTF(this.getFullName());
        } catch (SQLException var4) {
            IOException var3 = DatabaseError.createIOException(var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        String var2 = var1.readUTF();

        try {
            this.sqlName = new SQLName(var2, (oracle.jdbc.OracleConnection)null);
        } catch (SQLException var4) {
        }

        this.parent = null;
        this.idx = -1;
    }

    public void fixupConnection(OracleConnection var1) throws SQLException {
        if (this.connection == null) {
            this.setConnection(var1);
        }

    }

    public void printXML(PrintWriter var1, int var2) throws SQLException {
        this.printXML(var1, var2, false);
    }

    public void printXML(PrintWriter var1, int var2, boolean var3) throws SQLException {
        for(int var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.println("<OracleNamedType/>");
    }

    public void initNamesRecursively() throws SQLException {
        Map var1 = this.createTypesTreeMap();
        if (var1.size() > 0) {
            this.initChildNamesRecursively(var1);
        }

    }

    public void setNames(String var1, String var2) throws SQLException {
        this.sqlName = new SQLName(var1, var2, this.connection);
    }

    public void setSqlName(SQLName var1) {
        this.sqlName = var1;
    }

    public Map createTypesTreeMap() throws SQLException {
        Map var1 = null;
        String var2 = this.connection.getDefaultSchemaNameForNamedTypes();
        if (this.sqlName.getSchema().equals(var2)) {
            var1 = this.getNodeMapFromUserTypes();
        }

        if (var1 == null) {
            var1 = this.getNodeMapFromAllTypes();
        }

        return var1;
    }

    String getSqlHint() throws SQLException {
        if (this.sqlHint == null) {
            if (this.connection.getVersionNumber() >= 11000) {
                this.sqlHint = "";
            } else {
                this.sqlHint = "/*+RULE*/";
            }
        }

        return this.sqlHint;
    }

    Map getNodeMapFromUserTypes() throws SQLException {
        HashMap var1 = new HashMap();
        PreparedStatement var2 = null;
        ResultSet var3 = null;
        this.connection.beginNonRequestCalls();

        try {
            var2 = this.connection.prepareStatement(this.getSqlHint() + getUserTypeTreeSql);
            var2.setString(1, this.sqlName.getSimpleName());
            var3 = var2.executeQuery();

            while(var3.next()) {
                int var4 = var3.getInt(1);
                String var5 = var3.getString(2);
                String var6 = var3.getString(3);
                int var7 = var3.getInt(4);
                String var8 = var3.getString(5);
                if (var8 != null && !var8.equals(this.sqlName.getSchema())) {
                    var1 = null;
                    break;
                }

                if (var5.length() > 0) {
                    SQLName var9 = new SQLName(this.sqlName.getSchema(), var5, this.connection);
                    TypeTreeElement var10 = null;
                    if (var1.containsKey(var9)) {
                        var10 = (TypeTreeElement)((TypeTreeElement)var1.get(var9));
                    } else {
                        var10 = new TypeTreeElement(this.sqlName.getSchema(), var5);
                        var1.put(var9, var10);
                    }

                    var10.putChild(this.sqlName.getSchema(), var6, var7);
                }
            }
        } finally {
            if (var3 != null) {
                var3.close();
            }

            if (var2 != null) {
                var2.close();
            }

            this.connection.endNonRequestCalls();
        }

        return var1;
    }

    Map getNodeMapFromAllTypes() throws SQLException {
        HashMap var1 = new HashMap();
        PreparedStatement var2 = null;
        ResultSet var3 = null;
        this.connection.beginNonRequestCalls();

        try {
            var2 = this.connection.prepareStatement(this.getSqlHint() + getAllTypeTreeSql);
            var2.setString(1, this.sqlName.getSimpleName());
            var2.setString(2, this.sqlName.getSchema());
            var3 = var2.executeQuery();

            while(var3.next()) {
                String var4 = var3.getString(1);
                String var5 = var3.getString(2);
                String var6 = var3.getString(3);
                int var7 = var3.getInt(4);
                String var8 = var3.getString(5);
                if (var8 == null) {
                    var8 = "SYS";
                }

                if (var4.length() > 0) {
                    SQLName var9 = new SQLName(var5, var4, this.connection);
                    TypeTreeElement var10 = null;
                    if (var1.containsKey(var9)) {
                        var10 = (TypeTreeElement)((TypeTreeElement)var1.get(var9));
                    } else {
                        var10 = new TypeTreeElement(var5, var4);
                        var1.put(var9, var10);
                    }

                    var10.putChild(var8, var6, var7);
                }
            }
        } finally {
            if (var3 != null) {
                var3.close();
            }

            if (var2 != null) {
                var2.close();
            }

            this.connection.endNonRequestCalls();
        }

        return var1;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
