//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

class OracleTimeoutThreadPerVM extends OracleTimeout {
    private static final OracleTimeoutPollingThread watchdog = new OracleTimeoutPollingThread();
    private OracleStatement statement;
    private long interruptAfter;
    private String name;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleTimeoutThreadPerVM(String var1) {
        this.name = var1;
        this.interruptAfter = 9223372036854775807L;
        watchdog.addTimeout(this);
    }

    void close() {
        watchdog.removeTimeout(this);
    }

    synchronized void setTimeout(long var1, OracleStatement var3) throws SQLException {
        if (this.interruptAfter != 9223372036854775807L) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 131);
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.statement = var3;
            this.interruptAfter = System.currentTimeMillis() + var1;
        }
    }

    synchronized void cancelTimeout() throws SQLException {
        this.statement = null;
        this.interruptAfter = 9223372036854775807L;
    }

    void interruptIfAppropriate(long var1) {
        if (var1 > this.interruptAfter) {
            synchronized(this) {
                if (var1 > this.interruptAfter) {
                    if (this.statement.connection.spawnNewThreadToCancel) {
                        final OracleStatement var4 = this.statement;
                        Thread var5 = new Thread(new Runnable() {
                            public void run() {
                                try {
                                    var4.cancel();
                                } catch (Throwable var2) {
                                }

                            }
                        });
                        var5.setName("interruptIfAppropriate_" + this);
                        var5.setDaemon(true);
                        var5.setPriority(10);
                        var5.start();
                    } else {
                        try {
                            this.statement.cancel();
                        } catch (Throwable var7) {
                        }
                    }

                    this.statement = null;
                    this.interruptAfter = 9223372036854775807L;
                }
            }
        }

    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
