//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleRef;

/** @deprecated */
public class REF extends DatumWithConnection implements OracleRef, Serializable, Cloneable {
    static final boolean DEBUG = false;
    static final long serialVersionUID = 1328446996944583167L;
    String typename;
    transient StructDescriptor descriptor;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public String getBaseTypeName() throws SQLException {
        if (this.typename == null) {
            if (this.descriptor == null) {
                SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 52);
                var1.fillInStackTrace();
                throw var1;
            }

            this.typename = this.descriptor.getName();
        }

        return this.typename;
    }

    public REF(String var1, Connection var2, byte[] var3) throws SQLException {
        super(var3);
        if (var2 != null && var1 != null) {
            this.typename = var1;
            this.descriptor = null;
            this.setPhysicalConnectionOf(var2);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public REF(StructDescriptor var1, Connection var2, byte[] var3) throws SQLException {
        super(var3);
        if (var2 != null && var1 != null) {
            this.descriptor = var1;
            this.setPhysicalConnectionOf(var2);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public Object getValue(Map var1) throws SQLException {
        STRUCT var2 = this.getSTRUCT();
        Object var3 = var2 != null ? var2.toJdbc(var1) : null;
        return var3;
    }

    public Object getValue() throws SQLException {
        STRUCT var1 = this.getSTRUCT();
        Object var2 = var1 != null ? var1.toJdbc() : null;
        return var2;
    }

    public STRUCT getSTRUCT() throws SQLException {
        synchronized(this.getInternalConnection()) {
            STRUCT var2 = null;
            OraclePreparedStatement var3 = (OraclePreparedStatement)this.getInternalConnection().prepareStatement("select deref(:1) from dual");
            var3.setRowPrefetch(1);
            var3.setREF(1, this);
            OracleResultSet var4 = (OracleResultSet)var3.executeQuery();

            try {
                if (!var4.next()) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 52);
                    var5.fillInStackTrace();
                    throw var5;
                }

                var2 = var4.getSTRUCT(1);
            } finally {
                var4.close();
                var4 = null;
                var3.close();
                var3 = null;
            }

            return var2;
        }
    }

    public void setValue(Object var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            STRUCT var3 = STRUCT.toSTRUCT(var1, this.getInternalConnection());
            SQLException var15;
            if (var3.getInternalConnection() != this.getInternalConnection()) {
                var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 77, "Incompatible connection object");
                var15.fillInStackTrace();
                throw var15;
            } else if (!this.getBaseTypeName().equals(var3.getSQLTypeName())) {
                var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 77, "Incompatible type");
                var15.fillInStackTrace();
                throw var15;
            } else {
                byte[] var4 = var3.toBytes();
                byte[] var5 = var3.getDescriptor().getOracleTypeADT().getTOID();
                CallableStatement var6 = null;
                this.getInternalConnection().beginNonRequestCalls();

                try {
                    var6 = this.getInternalConnection().prepareCall("begin :1 := dbms_pickler.update_through_ref (:2, :3, :4, :5); end;");
                    var6.registerOutParameter(1, 2);
                    var6.setBytes(2, this.shareBytes());
                    var6.setInt(3, 0);
                    var6.setBytes(4, var5);
                    var6.setBytes(5, var4);
                    var6.execute();
                    boolean var7 = false;
                    int var16;
                    if ((var16 = var6.getInt(1)) != 0) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 77, "ORA-" + var16);
                        var8.fillInStackTrace();
                        throw var8;
                    }
                } finally {
                    if (var6 != null) {
                        var6.close();
                    }

                    var6 = null;
                    this.getInternalConnection().endNonRequestCalls();
                }

            }
        }
    }

    public OracleTypeMetaData getOracleMetaData() throws SQLException {
        return this.getDescriptor();
    }

    public StructDescriptor getDescriptor() throws SQLException {
        if (this.descriptor == null) {
            this.descriptor = StructDescriptor.createDescriptor(this.typename, this.getInternalConnection());
        }

        return this.descriptor;
    }

    public String getSQLTypeName() throws SQLException {
        String var1 = this.getBaseTypeName();
        return var1;
    }

    public Object getObject(Map var1) throws SQLException {
        STRUCT var2 = this.getSTRUCT();
        Object var3 = var2 != null ? var2.toJdbc(var1) : null;
        return var3;
    }

    public Object getObject() throws SQLException {
        STRUCT var1 = this.getSTRUCT();
        Object var2 = var1 != null ? var1.toJdbc() : null;
        return var2;
    }

    public void setObject(Object var1) throws SQLException {
        PreparedStatement var2 = null;

        try {
            var2 = this.getInternalConnection().prepareStatement("call sys.utl_ref.update_object( :1, :2 )");
            var2.setRef(1, this);
            var2.setObject(2, var1);
            var2.execute();
        } finally {
            if (var2 != null) {
                var2.close();
            }

        }

    }

    public Object toJdbc() throws SQLException {
        return this;
    }

    public Object toJdbc(Map var1) throws SQLException {
        Object var2 = this;
        if (var1 != null) {
            Class var3 = this.getDescriptor().getClass(var1);
            if (var3 != null) {
                var2 = this.toClass(var3, var1);
            }
        }

        return var2;
    }

    public Object toClass(Class var1, Map var2) throws SQLException {
        Object var3 = null;

        SQLException var5;
        try {
            if (var1 != null && var1 != REF.class && var1 != Ref.class) {
                Object var4 = var1.newInstance();
                if (var4 instanceof SQLData) {
                    var3 = this;
                } else if (var4 instanceof ORADataFactory) {
                    ORADataFactory var8 = (ORADataFactory)var4;
                    var3 = var8.create(this, 2006);
                } else {
                    if (!(var4 instanceof OracleDataFactory)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, this.descriptor.getName());
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    OracleDataFactory var9 = (OracleDataFactory)var4;
                    var3 = var9.create(this, 2006);
                }
            } else {
                var3 = this;
            }

            return var3;
        } catch (InstantiationException var6) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, "InstantiationException: " + var6.getMessage());
            var5.fillInStackTrace();
            throw var5;
        } catch (IllegalAccessException var7) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, "IllegalAccessException: " + var7.getMessage());
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public boolean isConvertibleTo(Class var1) {
        return false;
    }

    public Object makeJdbcArray(int var1) {
        return new REF[var1];
    }

    public Object clone() throws CloneNotSupportedException {
        REF var1 = null;

        try {
            var1 = new REF(this.getBaseTypeName(), this.getInternalConnection(), this.getBytes());
            return var1;
        } catch (SQLException var3) {
            throw new CloneNotSupportedException(var3.getMessage());
        }
    }

    public boolean equals(Object var1) {
        boolean var2 = false;

        try {
            var2 = var1 instanceof REF && super.equals(var1) && this.getBaseTypeName().equals(((REF)var1).getSQLTypeName());
        } catch (Exception var4) {
        }

        return var2;
    }

    public int hashCode() {
        byte[] var1 = this.shareBytes();
        int var2 = 0;
        int var3;
        if ((var1[2] & 5) == 5) {
            for(var3 = 0; var3 < 4; ++var3) {
                var2 *= 256;
                var2 += var1[8 + var3] & 255;
            }
        } else if ((var1[2] & 3) == 3) {
            for(var3 = 0; var3 < 4 && var3 < var1.length; ++var3) {
                var2 *= 256;
                var2 += var1[6 + var3] & 255;
            }
        } else if ((var1[2] & 2) == 2) {
            for(var3 = 0; var3 < 4; ++var3) {
                var2 *= 256;
                var2 += var1[8 + var3] & 255;
            }
        }

        return var2;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeObject(this.shareBytes());

        try {
            var1.writeUTF(this.getBaseTypeName());
        } catch (SQLException var3) {
            throw new IOException(var3.getMessage());
        }
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.setBytes((byte[])((byte[])var1.readObject()));
        this.typename = var1.readUTF();
    }

    public Connection getJavaSqlConnection() throws SQLException {
        return super.getJavaSqlConnection();
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
