//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.sql.ANYDATA;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

abstract class OracleCallableStatement extends OraclePreparedStatement implements oracle.jdbc.internal.OracleCallableStatement {
    boolean atLeastOneOrdinalParameter;
    boolean atLeastOneNamedParameter;
    String[] namedParameters;
    int parameterCount;
    final String errMsgMixedBind;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleCallableStatement(PhysicalConnection var1, String var2, int var3, int var4) throws SQLException {
        this(var1, var2, var3, var4, 1003, 1007);
    }

    OracleCallableStatement(PhysicalConnection var1, String var2, int var3, int var4, int var5, int var6) throws SQLException {
        super(var1, var2, 1, var4, var5, var6);
        this.atLeastOneOrdinalParameter = false;
        this.atLeastOneNamedParameter = false;
        this.namedParameters = new String[8];
        this.parameterCount = 0;
        this.errMsgMixedBind = "Ordinal binding and Named binding cannot be combined!";
        this.statementType = 2;
    }

    void registerOutParameterInternal(int var1, int var2, int var3, int var4, String var5) throws SQLException {
        this.ensureOpen();
        int var6 = var1 - 1;
        SQLException var7;
        if (var6 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == 0) {
                var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                var7.fillInStackTrace();
                throw var7;
            } else {
                int var9 = this.getInternalType(var2);
                this.resetBatch();
                this.currentRowNeedToPrepareBinds = true;
                if (this.currentRowBindAccessors == null) {
                    this.currentRowBindAccessors = new Accessor[this.numberOfBindPositions];
                }

                switch(var2) {
                    case -16:
                    case -15:
                    case -9:
                        this.currentRowFormOfUse[var6] = 2;
                    case -4:
                    case -3:
                    case -1:
                    case 1:
                    case 12:
                    case 70:
                        break;
                    case 2002:
                    case 2003:
                        if (var5 == null || var5.length() == 0) {
                            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "empty Object name");
                            var8.fillInStackTrace();
                            throw var8;
                        }
                    default:
                        var4 = 0;
                        break;
                    case 2009:
                        var4 = 0;
                        var5 = "SYS.XMLTYPE";
                        break;
                    case 2011:
                        var4 = 0;
                        this.currentRowFormOfUse[var6] = 2;
                }

                this.currentRowBindAccessors[var6] = this.allocateAccessor(var9, var2, var6 + 1, var4, this.currentRowFormOfUse[var6], var5, true);
            }
        } else {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var7.fillInStackTrace();
            throw var7;
        }
    }

    public void registerOutParameter(int var1, int var2, String var3) throws SQLException {
        if (var3 != null && var3.length() != 0) {
            synchronized(this.connection) {
                this.registerOutParameterInternal(var1, var2, 0, 0, var3);
                this.atLeastOneOrdinalParameter = true;
            }
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "empty Object name");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public void registerOutParameterBytes(int var1, int var2, int var3, int var4) throws SQLException {
        synchronized(this.connection) {
            this.registerOutParameterInternal(var1, var2, var3, var4, (String)null);
            this.atLeastOneOrdinalParameter = true;
        }
    }

    /** @deprecated */
    public void registerOutParameterChars(int var1, int var2, int var3, int var4) throws SQLException {
        synchronized(this.connection) {
            this.registerOutParameterInternal(var1, var2, var3, var4, (String)null);
            this.atLeastOneOrdinalParameter = true;
        }
    }

    public void registerOutParameter(int var1, int var2, int var3, int var4) throws SQLException {
        synchronized(this.connection) {
            this.registerOutParameterInternal(var1, var2, var3, var4, (String)null);
            this.atLeastOneOrdinalParameter = true;
        }
    }

    public void registerOutParameter(String var1, int var2, int var3, int var4) throws SQLException {
        synchronized(this.connection) {
            this.registerOutParameterInternal(var1, var2, var3, var4, (String)null);
            this.atLeastOneNamedParameter = true;
        }
    }

    public void registerOutParameterAtName(String var1, int var2) throws SQLException {
        String var3 = var1.intern();
        String[] var4 = this.sqlObject.getParameterList();
        int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
        boolean var6 = true;

        for(int var7 = 0; var7 < var5; ++var7) {
            if (var4[var7] == var3) {
                if (!var6) {
                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                    var8.fillInStackTrace();
                    throw var8;
                }

                this.registerOutParameter(var7 + 1, var2);
                var6 = false;
            }
        }

        if (var6) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
            var9.fillInStackTrace();
            throw var9;
        }
    }

    public void registerOutParameterAtName(String var1, int var2, int var3) throws SQLException {
        String var4 = var1.intern();
        String[] var5 = this.sqlObject.getParameterList();
        int var6 = Math.min(this.sqlObject.getParameterCount(), var5.length);
        boolean var7 = true;

        for(int var8 = 0; var8 < var6; ++var8) {
            if (var5[var8] == var4) {
                if (!var7) {
                    SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                    var9.fillInStackTrace();
                    throw var9;
                }

                this.registerOutParameter(var8 + 1, var2, var3);
                var7 = false;
            }
        }

        if (var7) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
            var10.fillInStackTrace();
            throw var10;
        }
    }

    public void registerOutParameterAtName(String var1, int var2, String var3) throws SQLException {
        String var4 = var1.intern();
        String[] var5 = this.sqlObject.getParameterList();
        int var6 = Math.min(this.sqlObject.getParameterCount(), var5.length);
        boolean var7 = true;

        for(int var8 = 0; var8 < var6; ++var8) {
            if (var5[var8] == var4) {
                if (!var7) {
                    SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                    var9.fillInStackTrace();
                    throw var9;
                }

                this.registerOutParameter(var8 + 1, var2, var3);
                var7 = false;
            }
        }

        if (var7) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
            var10.fillInStackTrace();
            throw var10;
        }
    }

    boolean isOracleBatchStyle() {
        return false;
    }

    void resetBatch() {
        this.batch = 1;
    }

    public void setExecuteBatch(int var1) throws SQLException {
    }

    public int sendBatch() throws SQLException {
        synchronized(this.connection) {
            return this.validRows;
        }
    }

    public void registerOutParameter(int var1, int var2) throws SQLException {
        this.registerOutParameter(var1, var2, 0, -1);
    }

    public void registerOutParameter(int var1, int var2, int var3) throws SQLException {
        this.registerOutParameter(var1, var2, var3, -1);
    }

    public boolean wasNull() throws SQLException {
        return this.wasNullValue(0);
    }

    public String getString(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getString(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Datum getOracleObject(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getOracleObject(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public ROWID getROWID(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getROWID(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public NUMBER getNUMBER(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getNUMBER(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public DATE getDATE(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getDATE(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public INTERVALYM getINTERVALYM(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getINTERVALYM(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public INTERVALDS getINTERVALDS(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getINTERVALDS(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getTIMESTAMP(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getTIMESTAMPTZ(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getTIMESTAMPLTZ(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public REF getREF(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getREF(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public ARRAY getARRAY(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getARRAY(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public STRUCT getSTRUCT(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getSTRUCT(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public OPAQUE getOPAQUE(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getOPAQUE(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public CHAR getCHAR(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getCHAR(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Reader getCharacterStream(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getCharacterStream(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public RAW getRAW(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getRAW(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BLOB getBLOB(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBLOB(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public CLOB getCLOB(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getCLOB(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BFILE getBFILE(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBFILE(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BFILE getBfile(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBFILE(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public boolean getBoolean(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBoolean(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public byte getByte(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getByte(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public short getShort(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getShort(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public int getInt(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getInt(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public long getLong(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getLong(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public float getFloat(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getFloat(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public double getDouble(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getDouble(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getBigDecimal(this.currentRank);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public byte[] getBytes(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBytes(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public byte[] privateGetBytes(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBytesInternal(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Date getDate(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getDate(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Time getTime(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getTime(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Timestamp getTimestamp(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getTimestamp(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public InputStream getAsciiStream(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getAsciiStream(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public InputStream getUnicodeStream(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getUnicodeStream(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public InputStream getBinaryStream(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBinaryStream(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Object getObject(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getObject(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Object getAnyDataEmbeddedObject(int var1) throws SQLException {
        Object var2 = null;
        Object var3 = this.getObject(var1);
        if (var3 instanceof ANYDATA) {
            Datum var4 = ((ANYDATA)var3).accessDatum();
            if (var4 != null) {
                var2 = var4.toJdbc();
            }
        }

        return var2;
    }

    public Object getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getCustomDatum(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getObject(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Object getORAData(int var1, ORADataFactory var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getORAData(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public ResultSet getCursor(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getCursor(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public void clearParameters() throws SQLException {
        synchronized(this.connection) {
            super.clearParameters();
        }
    }

    public Object getObject(int var1, Map var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getObject(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Ref getRef(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getREF(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Blob getBlob(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBLOB(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Clob getClob(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getCLOB(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Array getArray(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getARRAY(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BigDecimal getBigDecimal(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getBigDecimal(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Date getDate(int var1, Calendar var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getDate(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Time getTime(int var1, Calendar var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getTime(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getTimestamp(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public void addBatch() throws SQLException {
        if (this.currentRowBindAccessors != null) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Stored procedure with out or inout parameters cannot be batched");
            var1.fillInStackTrace();
            throw var1;
        } else {
            super.addBatch();
        }
    }

    protected void alwaysOnClose() throws SQLException {
        this.sqlObject.resetNamedParameters();
        this.namedParameters = new String[8];
        this.parameterCount = 0;
        this.atLeastOneOrdinalParameter = false;
        this.atLeastOneNamedParameter = false;
        super.alwaysOnClose();
    }

    public void registerOutParameter(String var1, int var2) throws SQLException {
        this.registerOutParameterInternal(var1, var2, 0, -1, (String)null);
        this.atLeastOneNamedParameter = true;
    }

    public void registerOutParameter(String var1, int var2, int var3) throws SQLException {
        this.registerOutParameterInternal(var1, var2, var3, -1, (String)null);
        this.atLeastOneNamedParameter = true;
    }

    public void registerOutParameter(String var1, int var2, String var3) throws SQLException {
        this.registerOutParameterInternal(var1, var2, 0, -1, var3);
        this.atLeastOneNamedParameter = true;
    }

    void registerOutParameterInternal(String var1, int var2, int var3, int var4, String var5) throws SQLException {
        int var6 = this.addNamedPara(var1);
        this.registerOutParameterInternal(var6, var2, var3, var4, var5);
    }

    public URL getURL(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getURL(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public void setStringForClob(String var1, String var2) throws SQLException {
        int var3 = this.addNamedPara(var1);
        if (var2 != null && var2.length() != 0) {
            this.setStringForClob(var3, var2);
        } else {
            this.setNull(var3, 2005);
        }
    }

    public void setStringForClob(int var1, String var2) throws SQLException {
        if (var2 != null && var2.length() != 0) {
            synchronized(this.connection) {
                this.setStringForClobCritical(var1, var2);
            }
        } else {
            this.setNull(var1, 2005);
        }
    }

    public void setBytesForBlob(String var1, byte[] var2) throws SQLException {
        int var3 = this.addNamedPara(var1);
        this.setBytesForBlob(var3, var2);
    }

    public void setBytesForBlob(int var1, byte[] var2) throws SQLException {
        if (var2 != null && var2.length != 0) {
            synchronized(this.connection) {
                this.setBytesForBlobCritical(var1, var2);
            }
        } else {
            this.setNull(var1, 2004);
        }
    }

    public String getString(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getString(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public boolean getBoolean(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getBoolean(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public byte getByte(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getByte(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public short getShort(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getShort(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public int getInt(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getInt(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public long getLong(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getLong(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public float getFloat(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getFloat(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public double getDouble(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getDouble(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public byte[] getBytes(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getBytes(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Date getDate(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getDate(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Time getTime(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getTime(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Timestamp getTimestamp(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getTimestamp(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Object getObject(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getObject(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public BigDecimal getBigDecimal(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getBigDecimal(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public BigDecimal getBigDecimal(String var1, int var2) throws SQLException {
        SQLException var7;
        if (!this.atLeastOneNamedParameter) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var7.fillInStackTrace();
            throw var7;
        } else if (var1 == null) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var7.fillInStackTrace();
            throw var7;
        } else {
            String var3 = var1.toUpperCase().intern();

            int var4;
            for(var4 = 0; var4 < this.parameterCount && var3 != this.namedParameters[var4]; ++var4) {
            }

            ++var4;
            Accessor var5 = null;
            if (var4 > 0 && var4 <= this.numberOfBindPositions && this.outBindAccessors != null && (var5 = this.outBindAccessors[var4 - 1]) != null) {
                this.lastIndex = var4;
                if (this.streamList != null) {
                    this.closeUsedStreams(var4);
                }

                return var5.getBigDecimal(this.currentRank, var2);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public Object getObject(String var1, Map var2) throws SQLException {
        SQLException var7;
        if (!this.atLeastOneNamedParameter) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var7.fillInStackTrace();
            throw var7;
        } else if (var1 == null) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var7.fillInStackTrace();
            throw var7;
        } else {
            String var3 = var1.toUpperCase().intern();

            int var4;
            for(var4 = 0; var4 < this.parameterCount && var3 != this.namedParameters[var4]; ++var4) {
            }

            ++var4;
            Accessor var5 = null;
            if (var4 > 0 && var4 <= this.numberOfBindPositions && this.outBindAccessors != null && (var5 = this.outBindAccessors[var4 - 1]) != null) {
                this.lastIndex = var4;
                if (this.streamList != null) {
                    this.closeUsedStreams(var4);
                }

                return var5.getObject(this.currentRank, var2);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public Ref getRef(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getREF(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Blob getBlob(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getBLOB(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Clob getClob(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getCLOB(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Array getArray(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getARRAY(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Date getDate(String var1, Calendar var2) throws SQLException {
        SQLException var7;
        if (!this.atLeastOneNamedParameter) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var7.fillInStackTrace();
            throw var7;
        } else if (var1 == null) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var7.fillInStackTrace();
            throw var7;
        } else {
            String var3 = var1.toUpperCase().intern();

            int var4;
            for(var4 = 0; var4 < this.parameterCount && var3 != this.namedParameters[var4]; ++var4) {
            }

            ++var4;
            Accessor var5 = null;
            if (var4 > 0 && var4 <= this.numberOfBindPositions && this.outBindAccessors != null && (var5 = this.outBindAccessors[var4 - 1]) != null) {
                this.lastIndex = var4;
                if (this.streamList != null) {
                    this.closeUsedStreams(var4);
                }

                return var5.getDate(this.currentRank, var2);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public Time getTime(String var1, Calendar var2) throws SQLException {
        SQLException var7;
        if (!this.atLeastOneNamedParameter) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var7.fillInStackTrace();
            throw var7;
        } else if (var1 == null) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var7.fillInStackTrace();
            throw var7;
        } else {
            String var3 = var1.toUpperCase().intern();

            int var4;
            for(var4 = 0; var4 < this.parameterCount && var3 != this.namedParameters[var4]; ++var4) {
            }

            ++var4;
            Accessor var5 = null;
            if (var4 > 0 && var4 <= this.numberOfBindPositions && this.outBindAccessors != null && (var5 = this.outBindAccessors[var4 - 1]) != null) {
                this.lastIndex = var4;
                if (this.streamList != null) {
                    this.closeUsedStreams(var4);
                }

                return var5.getTime(this.currentRank, var2);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public Timestamp getTimestamp(String var1, Calendar var2) throws SQLException {
        SQLException var7;
        if (!this.atLeastOneNamedParameter) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var7.fillInStackTrace();
            throw var7;
        } else if (var1 == null) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var7.fillInStackTrace();
            throw var7;
        } else {
            String var3 = var1.toUpperCase().intern();

            int var4;
            for(var4 = 0; var4 < this.parameterCount && var3 != this.namedParameters[var4]; ++var4) {
            }

            ++var4;
            Accessor var5 = null;
            if (var4 > 0 && var4 <= this.numberOfBindPositions && this.outBindAccessors != null && (var5 = this.outBindAccessors[var4 - 1]) != null) {
                this.lastIndex = var4;
                if (this.streamList != null) {
                    this.closeUsedStreams(var4);
                }

                return var5.getTimestamp(this.currentRank, var2);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public URL getURL(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getURL(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    /** @deprecated */
    public InputStream getAsciiStream(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void registerIndexTableOutParameter(int var1, int var2, int var3, int var4) throws SQLException {
        synchronized(this.connection) {
            int var6 = var1 - 1;
            if (var6 >= 0 && var1 <= this.numberOfBindPositions) {
                int var11 = this.getInternalType(var3);
                if (var11 == 96 || var11 == 1) {
                    if (var4 < 0 || var4 > this.maxIbtVarcharElementLength) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 53);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    if (var4 == 0) {
                        var4 = this.maxIbtVarcharElementLength;
                    }
                }

                this.resetBatch();
                this.currentRowNeedToPrepareBinds = true;
                if (this.currentRowBindAccessors == null) {
                    this.currentRowBindAccessors = new Accessor[this.numberOfBindPositions];
                }

                this.currentRowBindAccessors[var6] = this.allocateIndexTableAccessor(new PlsqlIbtBindInfo(this, (Object[])null, var2, 0, var11, var4), this.currentRowFormOfUse[var6]);
                this.hasIbtBind = true;
            } else {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var7.fillInStackTrace();
                throw var7;
            }
        }
    }

    Accessor allocateIndexTableAccessor(PlsqlIbtBindInfo var1, short var2) throws SQLException {
        return new PlsqlIndexTableAccessor(this, var1, var2);
    }

    public Object getPlsqlIndexTable(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum[] var3 = this.getOraclePlsqlIndexTable(var1);
            Accessor var4 = this.outBindAccessors[var1 - 1];
            int var5 = var4.plsqlIndexTableBindInfo().element_internal_type;
            Object var6 = null;
            switch(var5) {
                case 6:
                    var6 = new BigDecimal[var3.length];
                    break;
                case 9:
                    var6 = new String[var3.length];
                    break;
                default:
                    SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid column type");
                    var10.fillInStackTrace();
                    throw var10;
            }

            for(int var7 = 0; var7 < ((Object[])var6).length; ++var7) {
                ((Object[])var6)[var7] = var3[var7] != null && var3[var7].getLength() != 0L ? var3[var7].toJdbc() : null;
            }

            return var6;
        }
    }

    public Object getPlsqlIndexTable(int var1, Class var2) throws SQLException {
        synchronized(this.connection) {
            Datum[] var4 = this.getOraclePlsqlIndexTable(var1);
            if (var2 != null && var2.isPrimitive()) {
                String var10 = var2.getName();
                int var7;
                if (var10.equals("byte")) {
                    byte[] var18 = new byte[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var18[var7] = var4[var7] != null ? var4[var7].byteValue() : 0;
                    }

                    return var18;
                } else if (var10.equals("char")) {
                    char[] var17 = new char[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var17[var7] = var4[var7] != null && var4[var7].getLength() != 0L ? (char)var4[var7].intValue() : 0;
                    }

                    return var17;
                } else if (var10.equals("double")) {
                    double[] var16 = new double[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var16[var7] = var4[var7] != null && var4[var7].getLength() != 0L ? var4[var7].doubleValue() : 0.0D;
                    }

                    return var16;
                } else if (var10.equals("float")) {
                    float[] var15 = new float[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var15[var7] = var4[var7] != null && var4[var7].getLength() != 0L ? var4[var7].floatValue() : 0.0F;
                    }

                    return var15;
                } else if (var10.equals("int")) {
                    int[] var14 = new int[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var14[var7] = var4[var7] != null && var4[var7].getLength() != 0L ? var4[var7].intValue() : 0;
                    }

                    return var14;
                } else if (var10.equals("long")) {
                    long[] var13 = new long[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var13[var7] = var4[var7] != null && var4[var7].getLength() != 0L ? var4[var7].longValue() : 0L;
                    }

                    return var13;
                } else if (var10.equals("short")) {
                    short[] var12 = new short[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var12[var7] = var4[var7] != null && var4[var7].getLength() != 0L ? (short)var4[var7].intValue() : 0;
                    }

                    return var12;
                } else if (!var10.equals("boolean")) {
                    SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23);
                    var11.fillInStackTrace();
                    throw var11;
                } else {
                    boolean[] var6 = new boolean[var4.length];

                    for(var7 = 0; var7 < var4.length; ++var7) {
                        var6[var7] = var4[var7] != null && var4[var7].getLength() != 0L ? var4[var7].booleanValue() : false;
                    }

                    return var6;
                }
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Datum[] getOraclePlsqlIndexTable(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var7;
            if (this.closed) {
                var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var7.fillInStackTrace();
                throw var7;
            } else if (this.atLeastOneNamedParameter) {
                var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
                var7.fillInStackTrace();
                throw var7;
            } else {
                Accessor var3 = null;
                if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                    this.lastIndex = var1;
                    if (this.streamList != null) {
                        this.closeUsedStreams(var1);
                    }

                    return var3.getOraclePlsqlIndexTable(this.currentRank);
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                    var4.fillInStackTrace();
                    throw var4;
                }
            }
        }
    }

    public boolean execute() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.atLeastOneNamedParameter && this.atLeastOneOrdinalParameter) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
                var2.fillInStackTrace();
                throw var2;
            } else {
                if (this.sqlObject.setNamedParameters(this.parameterCount, this.namedParameters)) {
                    this.needToParse = true;
                }

                return super.execute();
            }
        }
    }

    public int executeUpdate() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.atLeastOneNamedParameter && this.atLeastOneOrdinalParameter) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
                var2.fillInStackTrace();
                throw var2;
            } else {
                if (this.sqlObject.setNamedParameters(this.parameterCount, this.namedParameters)) {
                    this.needToParse = true;
                }

                return super.executeUpdate();
            }
        }
    }

    void releaseBuffers() {
        super.releaseBuffers();
    }

    public void setArray(int var1, Array var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setArrayInternal(var1, var2);
        }
    }

    public void setBigDecimal(int var1, BigDecimal var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBigDecimalInternal(var1, var2);
            }
        }
    }

    public void setBlob(int var1, Blob var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBlobInternal(var1, var2);
            }
        }
    }

    public void setBoolean(int var1, boolean var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBooleanInternal(var1, var2);
            }
        }
    }

    public void setByte(int var1, byte var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setByteInternal(var1, var2);
            }
        }
    }

    public void setBytes(int var1, byte[] var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBytesInternal(var1, var2);
            }
        }
    }

    public void setClob(int var1, Clob var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setClobInternal(var1, var2);
            }
        }
    }

    public void setDate(int var1, Date var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setDateInternal(var1, var2);
            }
        }
    }

    public void setDate(int var1, Date var2, Calendar var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setDateInternal(var1, var2, var3);
            }
        }
    }

    public void setDouble(int var1, double var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setDoubleInternal(var1, var2);
            }
        }
    }

    public void setFloat(int var1, float var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setFloatInternal(var1, var2);
            }
        }
    }

    public void setInt(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setIntInternal(var1, var2);
            }
        }
    }

    public void setLong(int var1, long var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setLongInternal(var1, var2);
            }
        }
    }

    public void setNClob(int var1, NClob var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setNClobInternal(var1, var2);
            }
        }
    }

    public void setNString(int var1, String var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setNStringInternal(var1, var2);
            }
        }
    }

    public void setObject(int var1, Object var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setObjectInternal(var1, var2);
        }
    }

    public void setObject(int var1, Object var2, int var3) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setObjectInternal(var1, var2, var3);
        }
    }

    public void setRef(int var1, Ref var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setRefInternal(var1, var2);
        }
    }

    public void setRowId(int var1, RowId var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setRowIdInternal(var1, var2);
            }
        }
    }

    public void setShort(int var1, short var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setShortInternal(var1, var2);
            }
        }
    }

    public void setSQLXML(int var1, SQLXML var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setSQLXMLInternal(var1, var2);
            }
        }
    }

    public void setString(int var1, String var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setStringInternal(var1, var2);
            }
        }
    }

    public void setTime(int var1, Time var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setTimeInternal(var1, var2);
            }
        }
    }

    public void setTime(int var1, Time var2, Calendar var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setTimeInternal(var1, var2, var3);
            }
        }
    }

    public void setTimestamp(int var1, Timestamp var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setTimestampInternal(var1, var2);
            }
        }
    }

    public void setTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setTimestampInternal(var1, var2, var3);
            }
        }
    }

    public void setURL(int var1, URL var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setURLInternal(var1, var2);
            }
        }
    }

    public void setARRAY(int var1, ARRAY var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setARRAYInternal(var1, var2);
        }
    }

    public void setBFILE(int var1, BFILE var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBFILEInternal(var1, var2);
            }
        }
    }

    public void setBfile(int var1, BFILE var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBfileInternal(var1, var2);
            }
        }
    }

    public void setBinaryFloat(int var1, float var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBinaryFloatInternal(var1, var2);
            }
        }
    }

    public void setBinaryFloat(int var1, BINARY_FLOAT var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBinaryFloatInternal(var1, var2);
            }
        }
    }

    public void setBinaryDouble(int var1, double var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBinaryDoubleInternal(var1, var2);
            }
        }
    }

    public void setBinaryDouble(int var1, BINARY_DOUBLE var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBinaryDoubleInternal(var1, var2);
            }
        }
    }

    public void setBLOB(int var1, BLOB var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBLOBInternal(var1, var2);
            }
        }
    }

    public void setCHAR(int var1, CHAR var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setCHARInternal(var1, var2);
            }
        }
    }

    public void setCLOB(int var1, CLOB var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setCLOBInternal(var1, var2);
            }
        }
    }

    public void setCursor(int var1, ResultSet var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setCursorInternal(var1, var2);
            }
        }
    }

    public void setDATE(int var1, DATE var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setDATEInternal(var1, var2);
            }
        }
    }

    public void setFixedCHAR(int var1, String var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setFixedCHARInternal(var1, var2);
            }
        }
    }

    public void setINTERVALDS(int var1, INTERVALDS var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setINTERVALDSInternal(var1, var2);
            }
        }
    }

    public void setINTERVALYM(int var1, INTERVALYM var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setINTERVALYMInternal(var1, var2);
            }
        }
    }

    public void setNUMBER(int var1, NUMBER var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setNUMBERInternal(var1, var2);
            }
        }
    }

    public void setOPAQUE(int var1, OPAQUE var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setOPAQUEInternal(var1, var2);
        }
    }

    public void setOracleObject(int var1, Datum var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setOracleObjectInternal(var1, var2);
        }
    }

    public void setORAData(int var1, ORAData var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setORADataInternal(var1, var2);
        }
    }

    public void setRAW(int var1, RAW var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setRAWInternal(var1, var2);
            }
        }
    }

    public void setREF(int var1, REF var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setREFInternal(var1, var2);
        }
    }

    public void setRefType(int var1, REF var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setRefTypeInternal(var1, var2);
        }
    }

    public void setROWID(int var1, ROWID var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setROWIDInternal(var1, var2);
            }
        }
    }

    public void setSTRUCT(int var1, STRUCT var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setSTRUCTInternal(var1, var2);
        }
    }

    public void setTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setTIMESTAMPLTZInternal(var1, var2);
            }
        }
    }

    public void setTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setTIMESTAMPTZInternal(var1, var2);
            }
        }
    }

    public void setTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setTIMESTAMPInternal(var1, var2);
            }
        }
    }

    public void setCustomDatum(int var1, CustomDatum var2) throws SQLException {
        if (this.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.atLeastOneOrdinalParameter = true;
            this.setCustomDatumInternal(var1, var2);
        }
    }

    public void setBlob(int var1, InputStream var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBlobInternal(var1, var2);
            }
        }
    }

    public void setBlob(int var1, InputStream var2, long var3) throws SQLException {
        synchronized(this.connection) {
            SQLException var6;
            if (this.closed) {
                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var6.fillInStackTrace();
                throw var6;
            } else if (var3 < 0L) {
                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "length for setBlob() cannot be negative");
                var6.fillInStackTrace();
                throw var6;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBlobInternal(var1, var2, var3);
            }
        }
    }

    public void setClob(int var1, Reader var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setClobInternal(var1, var2);
            }
        }
    }

    public void setClob(int var1, Reader var2, long var3) throws SQLException {
        synchronized(this.connection) {
            SQLException var6;
            if (this.closed) {
                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var6.fillInStackTrace();
                throw var6;
            } else if (var3 < 0L) {
                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "length for setClob() cannot be negative");
                var6.fillInStackTrace();
                throw var6;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setClobInternal(var1, var2, var3);
            }
        }
    }

    public void setNClob(int var1, Reader var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setNClobInternal(var1, var2);
            }
        }
    }

    public void setNClob(int var1, Reader var2, long var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var6.fillInStackTrace();
                throw var6;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setNClobInternal(var1, var2, var3);
            }
        }
    }

    public void setAsciiStream(int var1, InputStream var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setAsciiStreamInternal(var1, var2);
            }
        }
    }

    public void setAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setAsciiStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var6.fillInStackTrace();
                throw var6;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setAsciiStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setBinaryStream(int var1, InputStream var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBinaryStreamInternal(var1, var2);
            }
        }
    }

    public void setBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBinaryStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var6.fillInStackTrace();
                throw var6;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setBinaryStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setCharacterStream(int var1, Reader var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setCharacterStreamInternal(var1, var2);
            }
        }
    }

    public void setCharacterStream(int var1, Reader var2, int var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setCharacterStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var6.fillInStackTrace();
                throw var6;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setCharacterStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setNCharacterStream(int var1, Reader var2) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setNCharacterStreamInternal(var1, var2);
            }
        }
    }

    public void setNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var6.fillInStackTrace();
                throw var6;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setNCharacterStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setUnicodeStream(int var1, InputStream var2, int var3) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var5.fillInStackTrace();
                throw var5;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setUnicodeStreamInternal(var1, var2, var3);
            }
        }
    }

    public void setArray(String var1, Array var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setArrayInternal(var3, var2);
        }
    }

    public void setBigDecimal(String var1, BigDecimal var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBigDecimalInternal(var3, var2);
        }
    }

    public void setBlob(String var1, Blob var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBlobInternal(var3, var2);
        }
    }

    public void setBoolean(String var1, boolean var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBooleanInternal(var3, var2);
        }
    }

    public void setByte(String var1, byte var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setByteInternal(var3, var2);
        }
    }

    public void setBytes(String var1, byte[] var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBytesInternal(var3, var2);
        }
    }

    public void setClob(String var1, Clob var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setClobInternal(var3, var2);
        }
    }

    public void setDate(String var1, Date var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setDateInternal(var3, var2);
        }
    }

    public void setDate(String var1, Date var2, Calendar var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setDateInternal(var4, var2, var3);
        }
    }

    public void setDouble(String var1, double var2) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setDoubleInternal(var4, var2);
        }
    }

    public void setFloat(String var1, float var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setFloatInternal(var3, var2);
        }
    }

    public void setInt(String var1, int var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setIntInternal(var3, var2);
        }
    }

    public void setLong(String var1, long var2) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setLongInternal(var4, var2);
        }
    }

    public void setNClob(String var1, NClob var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setNClobInternal(var3, var2);
        }
    }

    public void setNString(String var1, String var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setNStringInternal(var3, var2);
        }
    }

    public void setObject(String var1, Object var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setObjectInternal(var3, var2);
        }
    }

    public void setObject(String var1, Object var2, int var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setObjectInternal(var4, var2, var3);
        }
    }

    public void setRef(String var1, Ref var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setRefInternal(var3, var2);
        }
    }

    public void setRowId(String var1, RowId var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setRowIdInternal(var3, var2);
        }
    }

    public void setShort(String var1, short var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setShortInternal(var3, var2);
        }
    }

    public void setSQLXML(String var1, SQLXML var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setSQLXMLInternal(var3, var2);
        }
    }

    public void setString(String var1, String var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setStringInternal(var3, var2);
        }
    }

    public void setTime(String var1, Time var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setTimeInternal(var3, var2);
        }
    }

    public void setTime(String var1, Time var2, Calendar var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setTimeInternal(var4, var2, var3);
        }
    }

    public void setTimestamp(String var1, Timestamp var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setTimestampInternal(var3, var2);
        }
    }

    public void setTimestamp(String var1, Timestamp var2, Calendar var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setTimestampInternal(var4, var2, var3);
        }
    }

    public void setURL(String var1, URL var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setURLInternal(var3, var2);
        }
    }

    public void setARRAY(String var1, ARRAY var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setARRAYInternal(var3, var2);
        }
    }

    public void setBFILE(String var1, BFILE var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBFILEInternal(var3, var2);
        }
    }

    public void setBfile(String var1, BFILE var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBfileInternal(var3, var2);
        }
    }

    public void setBinaryFloat(String var1, float var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBinaryFloatInternal(var3, var2);
        }
    }

    public void setBinaryFloat(String var1, BINARY_FLOAT var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBinaryFloatInternal(var3, var2);
        }
    }

    public void setBinaryDouble(String var1, double var2) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setBinaryDoubleInternal(var4, var2);
        }
    }

    public void setBinaryDouble(String var1, BINARY_DOUBLE var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBinaryDoubleInternal(var3, var2);
        }
    }

    public void setBLOB(String var1, BLOB var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBLOBInternal(var3, var2);
        }
    }

    public void setCHAR(String var1, CHAR var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setCHARInternal(var3, var2);
        }
    }

    public void setCLOB(String var1, CLOB var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setCLOBInternal(var3, var2);
        }
    }

    public void setCursor(String var1, ResultSet var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setCursorInternal(var3, var2);
        }
    }

    public void setDATE(String var1, DATE var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setDATEInternal(var3, var2);
        }
    }

    public void setFixedCHAR(String var1, String var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setFixedCHARInternal(var3, var2);
        }
    }

    public void setINTERVALDS(String var1, INTERVALDS var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setINTERVALDSInternal(var3, var2);
        }
    }

    public void setINTERVALYM(String var1, INTERVALYM var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setINTERVALYMInternal(var3, var2);
        }
    }

    public void setNUMBER(String var1, NUMBER var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setNUMBERInternal(var3, var2);
        }
    }

    public void setOPAQUE(String var1, OPAQUE var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setOPAQUEInternal(var3, var2);
        }
    }

    public void setOracleObject(String var1, Datum var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setOracleObjectInternal(var3, var2);
        }
    }

    public void setORAData(String var1, ORAData var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setORADataInternal(var3, var2);
        }
    }

    public void setRAW(String var1, RAW var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setRAWInternal(var3, var2);
        }
    }

    public void setREF(String var1, REF var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setREFInternal(var3, var2);
        }
    }

    public void setRefType(String var1, REF var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setRefTypeInternal(var3, var2);
        }
    }

    public void setROWID(String var1, ROWID var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setROWIDInternal(var3, var2);
        }
    }

    public void setSTRUCT(String var1, STRUCT var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setSTRUCTInternal(var3, var2);
        }
    }

    public void setTIMESTAMPLTZ(String var1, TIMESTAMPLTZ var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setTIMESTAMPLTZInternal(var3, var2);
        }
    }

    public void setTIMESTAMPTZ(String var1, TIMESTAMPTZ var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setTIMESTAMPTZInternal(var3, var2);
        }
    }

    public void setTIMESTAMP(String var1, TIMESTAMP var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setTIMESTAMPInternal(var3, var2);
        }
    }

    public void setCustomDatum(String var1, CustomDatum var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setCustomDatumInternal(var3, var2);
        }
    }

    public void setBlob(String var1, InputStream var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBlobInternal(var3, var2);
        }
    }

    public void setBlob(String var1, InputStream var2, long var3) throws SQLException {
        SQLException var6;
        if (this.closed) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else if (var3 < 0L) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "length for setBlob() cannot be negative");
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setBlobInternal(var5, var2, var3);
        }
    }

    public void setClob(String var1, Reader var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setClobInternal(var3, var2);
        }
    }

    public void setClob(String var1, Reader var2, long var3) throws SQLException {
        SQLException var6;
        if (this.closed) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else if (var3 < 0L) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "length for setClob() cannot be negative");
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setClobInternal(var5, var2, var3);
        }
    }

    public void setNClob(String var1, Reader var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setNClobInternal(var3, var2);
        }
    }

    public void setNClob(String var1, Reader var2, long var3) throws SQLException {
        if (this.closed) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setNClobInternal(var5, var2, var3);
        }
    }

    public void setAsciiStream(String var1, InputStream var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setAsciiStreamInternal(var3, var2);
        }
    }

    public void setAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setAsciiStreamInternal(var4, var2, var3);
        }
    }

    public void setAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
        if (this.closed) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setAsciiStreamInternal(var5, var2, var3);
        }
    }

    public void setBinaryStream(String var1, InputStream var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setBinaryStreamInternal(var3, var2);
        }
    }

    public void setBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setBinaryStreamInternal(var4, var2, var3);
        }
    }

    public void setBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
        if (this.closed) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setBinaryStreamInternal(var5, var2, var3);
        }
    }

    public void setCharacterStream(String var1, Reader var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setCharacterStreamInternal(var3, var2);
        }
    }

    public void setCharacterStream(String var1, Reader var2, int var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setCharacterStreamInternal(var4, var2, var3);
        }
    }

    public void setCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        if (this.closed) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setCharacterStreamInternal(var5, var2, var3);
        }
    }

    public void setNCharacterStream(String var1, Reader var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setNCharacterStreamInternal(var3, var2);
        }
    }

    public void setNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        if (this.closed) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setNCharacterStreamInternal(var5, var2, var3);
        }
    }

    public void setUnicodeStream(String var1, InputStream var2, int var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setUnicodeStreamInternal(var4, var2, var3);
        }
    }

    public void setNull(String var1, int var2, String var3) throws SQLException {
        if (this.closed) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = this.addNamedPara(var1);
            this.setNullInternal(var4, var2, var3);
        }
    }

    public void setNull(String var1, int var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setNullInternal(var3, var2);
        }
    }

    public void setStructDescriptor(String var1, StructDescriptor var2) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            int var3 = this.addNamedPara(var1);
            this.setStructDescriptorInternal(var3, var2);
        }
    }

    public void setObject(String var1, Object var2, int var3, int var4) throws SQLException {
        if (this.closed) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var5 = this.addNamedPara(var1);
            this.setObjectInternal(var5, var2, var3, var4);
        }
    }

    public void setPlsqlIndexTable(int var1, Object var2, int var3, int var4, int var5, int var6) throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
                var8.fillInStackTrace();
                throw var8;
            } else {
                this.atLeastOneOrdinalParameter = true;
                this.setPlsqlIndexTableInternal(var1, var2, var3, var4, var5, var6);
            }
        }
    }

    int addNamedPara(String var1) throws SQLException {
        if (this.closed) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else {
            String var2 = var1.toUpperCase().intern();

            for(int var3 = 0; var3 < this.parameterCount; ++var3) {
                if (var2 == this.namedParameters[var3]) {
                    return var3 + 1;
                }
            }

            if (this.parameterCount >= this.namedParameters.length) {
                String[] var5 = new String[this.namedParameters.length * 2];
                System.arraycopy(this.namedParameters, 0, var5, 0, this.namedParameters.length);
                this.namedParameters = var5;
            }

            this.namedParameters[this.parameterCount++] = var2;
            this.atLeastOneNamedParameter = true;
            return this.parameterCount;
        }
    }

    public Reader getCharacterStream(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getCharacterStream(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public InputStream getUnicodeStream(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getUnicodeStream(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public InputStream getBinaryStream(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getBinaryStream(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public RowId getRowId(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getROWID(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public RowId getRowId(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getROWID(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public NClob getNClob(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getNClob(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public NClob getNClob(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getNClob(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public SQLXML getSQLXML(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getSQLXML(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public SQLXML getSQLXML(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getSQLXML(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public String getNString(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getNString(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public String getNString(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getNString(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Reader getNCharacterStream(int var1) throws SQLException {
        SQLException var4;
        if (this.closed) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.atLeastOneNamedParameter) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var4.fillInStackTrace();
            throw var4;
        } else {
            Accessor var2 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var2 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var2.getNCharacterStream(this.currentRank);
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Reader getNCharacterStream(String var1) throws SQLException {
        SQLException var6;
        if (!this.atLeastOneNamedParameter) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var6.fillInStackTrace();
            throw var6;
        } else if (var1 == null) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            String var2 = var1.toUpperCase().intern();

            int var3;
            for(var3 = 0; var3 < this.parameterCount && var2 != this.namedParameters[var3]; ++var3) {
            }

            ++var3;
            Accessor var4 = null;
            if (var3 > 0 && var3 <= this.numberOfBindPositions && this.outBindAccessors != null && (var4 = this.outBindAccessors[var3 - 1]) != null) {
                this.lastIndex = var3;
                if (this.streamList != null) {
                    this.closeUsedStreams(var3);
                }

                return var4.getNCharacterStream(this.currentRank);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public <T> T getObject(int var1, Class<T> var2) throws SQLException {
        SQLException var5;
        if (this.closed) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var5.fillInStackTrace();
            throw var5;
        } else if (this.atLeastOneNamedParameter) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var5.fillInStackTrace();
            throw var5;
        } else {
            Accessor var3 = null;
            if (var1 > 0 && var1 <= this.numberOfBindPositions && this.outBindAccessors != null && (var3 = this.outBindAccessors[var1 - 1]) != null) {
                this.lastIndex = var1;
                if (this.streamList != null) {
                    this.closeUsedStreams(var1);
                }

                return var3.getObject(this.currentRank, var2);
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public <T> T getObject(String var1, Class<T> var2) throws SQLException {
        SQLException var7;
        if (!this.atLeastOneNamedParameter) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Ordinal binding and Named binding cannot be combined!");
            var7.fillInStackTrace();
            throw var7;
        } else if (var1 == null) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var7.fillInStackTrace();
            throw var7;
        } else {
            String var3 = var1.toUpperCase().intern();

            int var4;
            for(var4 = 0; var4 < this.parameterCount && var3 != this.namedParameters[var4]; ++var4) {
            }

            ++var4;
            Accessor var5 = null;
            if (var4 > 0 && var4 <= this.numberOfBindPositions && this.outBindAccessors != null && (var5 = this.outBindAccessors[var4 - 1]) != null) {
                this.lastIndex = var4;
                if (this.streamList != null) {
                    this.closeUsedStreams(var4);
                }

                return var5.getObject(this.currentRank, var2);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6);
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }
}
