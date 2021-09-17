//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

abstract class OracleInputStream extends OracleBufferedStream {
    int columnIndex;
    Accessor accessor;
    OracleInputStream nextStream;
    boolean hasBeenOpen = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleInputStream(OracleStatement var1, int var2, Accessor var3) {
        super(var1, var1.connection.getDefaultStreamChunkSize());
        this.closed = true;
        this.statement = var1;
        this.columnIndex = var2;
        this.accessor = var3;
        this.nextStream = null;
        OracleInputStream var4 = this.statement.streamList;
        if (var4 != null && this.columnIndex >= var4.columnIndex) {
            if (this.columnIndex == var4.columnIndex) {
                this.nextStream = var4.nextStream;
                var4.nextStream = null;
                this.statement.streamList = this;
            } else {
                while(var4.nextStream != null && this.columnIndex > var4.nextStream.columnIndex) {
                    var4 = var4.nextStream;
                }

                if (var4.nextStream != null && this.columnIndex == var4.nextStream.columnIndex) {
                    this.nextStream = var4.nextStream.nextStream;
                    var4.nextStream.nextStream = null;
                    var4.nextStream = this;
                } else {
                    this.nextStream = var4.nextStream;
                    var4.nextStream = this;
                }
            }
        } else {
            this.nextStream = this.statement.streamList;
            this.statement.streamList = this;
        }

    }

    public String toString() {
        return "OIS@" + Integer.toHexString(this.hashCode()) + "{" + "statement = " + this.statement + ", accessor = " + this.accessor + ", nextStream = " + this.nextStream + ", columnIndex = " + this.columnIndex + ", hasBeenOpen = " + this.hasBeenOpen + "}";
    }

    public boolean needBytes(int var1) throws IOException {
        if (this.closed) {
            return false;
        } else {
            if (this.pos >= this.count) {
                if (var1 > this.currentBufferSize) {
                    this.currentBufferSize = Math.max(var1, this.initialBufferSize);
                    this.resizableBuffer = new byte[this.currentBufferSize];
                }

                try {
                    int var2 = this.getBytes(this.currentBufferSize);
                    this.pos = 0;
                    this.count = var2;
                    if (this.count == -1) {
                        if (this.nextStream == null) {
                            this.statement.connection.releaseLine();
                        }

                        this.closed = true;
                        this.accessor.fetchNextColumns();
                        return false;
                    }
                } catch (SQLException var4) {
                    IOException var3 = DatabaseError.createIOException(var4);
                    var3.fillInStackTrace();
                    throw var3;
                }
            }

            return true;
        }
    }

    public boolean isNull() throws IOException {
        boolean var1 = false;

        try {
            var1 = this.accessor.isNull(0);
            return var1;
        } catch (SQLException var4) {
            IOException var3 = DatabaseError.createIOException(var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void close() throws IOException {
        synchronized(this.statement.connection) {
            if (!this.closed && this.hasBeenOpen) {
                while(this.statement.nextStream != this) {
                    this.statement.nextStream.close();
                    this.statement.nextStream = this.statement.nextStream.nextStream;
                }

                if (!this.isNull()) {
                    while(this.needBytes(Math.max(this.initialBufferSize, this.currentBufferSize))) {
                        this.pos = this.count;
                    }
                }

                this.closed = true;
                this.resizableBuffer = null;
                this.currentBufferSize = 0;
            }

        }
    }

    public abstract int getBytes(int var1) throws IOException;
}
