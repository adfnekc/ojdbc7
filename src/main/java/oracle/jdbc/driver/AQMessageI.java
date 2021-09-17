//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.aq.AQMessage;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.sql.ANYDATA;
import oracle.sql.OPAQUE;
import oracle.sql.OpaqueDescriptor;
import oracle.sql.RAW;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TypeDescriptor;
import oracle.xdb.XMLType;

class AQMessageI implements AQMessage {
    private byte[] id = null;
    private AQMessagePropertiesI properties = null;
    private byte[] toid = null;
    private byte[] payload;
    private STRUCT payLoadSTRUCT;
    private ANYDATA payLoadANYDATA;
    private RAW payLoadRAW;
    private XMLType payLoadXMLType;
    private Connection conn;
    private String typeName;
    private TypeDescriptor sd;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    AQMessageI(AQMessagePropertiesI var1, Connection var2) {
        this.properties = var1;
        this.conn = var2;
    }

    AQMessageI(AQMessagePropertiesI var1) throws SQLException {
        this.properties = var1;
    }

    void setTypeName(String var1) {
        this.typeName = var1;
    }

    void setTypeDescriptor(TypeDescriptor var1) {
        this.sd = var1;
    }

    public byte[] getMessageId() {
        return this.id;
    }

    void setMessageId(byte[] var1) throws SQLException {
        this.id = var1;
    }

    public AQMessageProperties getMessageProperties() {
        return this.properties;
    }

    AQMessagePropertiesI getMessagePropertiesI() {
        return this.properties;
    }

    public void setPayload(byte[] var1) throws SQLException {
        this.payload = var1;
        this.toid = TypeDescriptor.RAWTOID;
    }

    public void setPayload(byte[] var1, byte[] var2) throws SQLException {
        this.payload = var1;
        this.toid = var2;
    }

    public void setPayload(STRUCT var1) throws SQLException {
        this.payload = var1.toBytes();
        this.payLoadSTRUCT = var1;
        this.toid = var1.getDescriptor().getOracleTypeADT().getTOID();
    }

    public void setPayload(ANYDATA var1) throws SQLException {
        this.payload = var1.toDatum(this.conn).shareBytes();
        this.payLoadANYDATA = var1;
        this.toid = TypeDescriptor.ANYDATATOID;
    }

    public void setPayload(RAW var1) throws SQLException {
        this.payload = var1.shareBytes();
        this.payLoadRAW = var1;
        this.toid = TypeDescriptor.RAWTOID;
    }

    public void setPayload(XMLType var1) throws SQLException {
        this.payload = var1.toBytes();
        this.payLoadXMLType = var1;
        this.toid = TypeDescriptor.XMLTYPETOID;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public RAW getRAWPayload() throws SQLException {
        RAW var1 = null;
        if (this.payLoadRAW != null) {
            var1 = this.payLoadRAW;
        } else {
            if (!this.isRAWPayload()) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 193);
                var2.fillInStackTrace();
                throw var2;
            }

            this.payLoadRAW = new RAW(this.payload);
            var1 = this.payLoadRAW;
        }

        return var1;
    }

    public boolean isRAWPayload() throws SQLException {
        if (this.toid != null && this.toid.length == 16) {
            return compareToid(this.toid, TypeDescriptor.RAWTOID);
        } else {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 252);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public STRUCT getSTRUCTPayload() throws SQLException {
        STRUCT var1 = null;
        SQLException var2;
        if (!this.isSTRUCTPayload()) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 193);
            var2.fillInStackTrace();
            throw var2;
        } else {
            if (this.payLoadSTRUCT != null) {
                var1 = this.payLoadSTRUCT;
            } else {
                if (this.sd == null) {
                    this.typeName = OracleTypeADT.toid2typename(this.conn, this.toid);
                    this.sd = TypeDescriptor.getTypeDescriptor(this.typeName, (OracleConnection)this.conn);
                }

                if (!(this.sd instanceof StructDescriptor)) {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 193);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = new STRUCT((StructDescriptor)this.sd, this.payload, this.conn);
                this.payLoadSTRUCT = var1;
            }

            return var1;
        }
    }

    public boolean isSTRUCTPayload() throws SQLException {
        if (this.toid != null && this.toid.length == 16) {
            boolean var4 = true;
            boolean var2 = true;

            for(int var3 = 0; var3 < 15; ++var3) {
                if (this.toid[var3] != 0) {
                    var2 = false;
                    break;
                }
            }

            if (var2 || this.isRAWPayload() || this.isANYDATAPayload()) {
                var4 = false;
            }

            return var4;
        } else {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 252);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public ANYDATA getANYDATAPayload() throws SQLException {
        ANYDATA var1 = null;
        if (this.payLoadANYDATA != null) {
            var1 = this.payLoadANYDATA;
        } else {
            if (!this.isANYDATAPayload()) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 193);
                var4.fillInStackTrace();
                throw var4;
            }

            OpaqueDescriptor var2 = OpaqueDescriptor.createDescriptor("SYS.ANYDATA", this.conn);
            OPAQUE var3 = new OPAQUE(var2, this.payload, this.conn);
            this.payLoadANYDATA = new ANYDATA(var3);
            var1 = this.payLoadANYDATA;
        }

        return var1;
    }

    public boolean isANYDATAPayload() throws SQLException {
        if (this.toid != null && this.toid.length == 16) {
            return this.typeName != null && this.typeName.equals("SYS.ANYDATA") || compareToid(this.toid, TypeDescriptor.ANYDATATOID);
        } else {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 252);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public XMLType getXMLTypePayload() throws SQLException {
        XMLType var1 = null;
        if (this.payLoadXMLType != null) {
            var1 = this.payLoadXMLType;
        } else {
            if (!this.isXMLTypePayload()) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 193);
                var4.fillInStackTrace();
                throw var4;
            }

            OpaqueDescriptor var2 = OpaqueDescriptor.createDescriptor("SYS.XMLTYPE", this.conn);
            OPAQUE var3 = new OPAQUE(var2, this.payload, this.conn);
            this.payLoadXMLType = (XMLType) XMLType.createXML(var3);
            var1 = this.payLoadXMLType;
        }

        return var1;
    }

    public boolean isXMLTypePayload() throws SQLException {
        if (this.toid != null && this.toid.length == 16) {
            return this.typeName != null && this.typeName.equals("SYS.XMLTYPE") || compareToid(this.toid, TypeDescriptor.XMLTYPETOID);
        } else {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 252);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public byte[] getPayloadTOID() {
        return this.toid;
    }

    static boolean compareToid(byte[] var0, byte[] var1) {
        boolean var2 = false;
        if (var0 != null) {
            if (var0 == var1) {
                var2 = true;
            } else if (var0.length == var1.length) {
                boolean var3 = true;

                for(int var4 = 0; var4 < var0.length; ++var4) {
                    if (var0[var4] != var1[var4]) {
                        var3 = false;
                        break;
                    }
                }

                if (var3) {
                    var2 = true;
                }
            }
        }

        return var2;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("Message Properties={");
        var1.append(this.properties);
        var1.append("} ");
        return var1.toString();
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
