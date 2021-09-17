//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import oracle.jdbc.internal.OracleConnection;

abstract class OracleBufferedStream extends InputStream {
    byte[] resizableBuffer;
    int initialBufferSize;
    int currentBufferSize;
    int pos;
    int count;
    long maxPosition;
    boolean closed;
    OracleStatement statement;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleBufferedStream(int var1) {
        this.maxPosition = 2147483647L;
        this.pos = 0;
        this.count = 0;
        this.closed = false;
        this.initialBufferSize = var1;
        this.currentBufferSize = 0;
        this.resizableBuffer = null;
    }

    public OracleBufferedStream(OracleStatement var1, int var2) {
        this(var2);
        this.statement = var1;
    }

    public void close() throws IOException {
        this.closed = true;
        this.resizableBuffer = null;
    }

    public boolean needBytes() throws IOException {
        return this.needBytes(Math.max(this.initialBufferSize, this.currentBufferSize));
    }

    public abstract boolean needBytes(int var1) throws IOException;

    public int flushBytes(int var1) {
        int var2 = var1 > this.count - this.pos ? this.count - this.pos : var1;
        this.pos += var2;
        return var2;
    }

    public int writeBytes(byte[] var1, int var2, int var3) {
        int var4 = var3 > this.count - this.pos ? this.count - this.pos : var3;
        System.arraycopy(this.resizableBuffer, this.pos, var1, var2, var4);
        this.pos += var4;
        return var4;
    }

    public int read() throws IOException {
        if (this.statement == null) {
            synchronized(this) {
                return this.readInternal();
            }
        } else {
            synchronized(this.statement.connection) {
                return this.readInternal();
            }
        }
    }

    private final int readInternal() throws IOException {
        if (!this.closed && !this.isNull()) {
            return this.needBytes() ? this.resizableBuffer[this.pos++] & 255 : -1;
        } else {
            return -1;
        }
    }

    public int read(byte[] var1) throws IOException {
        return this.read(var1, 0, var1.length);
    }

    public int read(byte[] var1, int var2, int var3) throws IOException {
        if (var3 == 0) {
            return 0;
        } else if (this.statement == null) {
            synchronized(this) {
                return this.readInternal(var1, var2, var3);
            }
        } else {
            synchronized(this.statement.connection) {
                return this.readInternal(var1, var2, var3);
            }
        }
    }

    private final int readInternal(byte[] var1, int var2, int var3) throws IOException {
        if (!this.closed && !this.isNull()) {
            int var4;
            if (var3 > var1.length) {
                var4 = var2 + var1.length;
            } else {
                var4 = var2 + var3;
            }

            if (!this.needBytes(var3)) {
                return -1;
            } else {
                int var5;
                for(var5 = var2 + this.writeBytes(var1, var2, var4 - var2); var5 < var4 && this.needBytes(var4 - var5); var5 += this.writeBytes(var1, var5, var4 - var5)) {
                }

                return var5 - var2;
            }
        } else {
            return -1;
        }
    }

    public int available() throws IOException {
        return !this.closed && !this.isNull() ? this.count - this.pos : 0;
    }

    public boolean isNull() throws IOException {
        return false;
    }

    public void mark(int var1) {
    }

    public void reset() throws IOException {
        synchronized(this.statement.connection){}

        try {
            throw new IOException(DatabaseError.findMessage(194, (Object)null));
        } finally {
            ;
        }
    }

    public boolean markSupported() {
        return false;
    }

    public long skip(int var1) throws IOException {
        if (this.statement == null) {
            synchronized(this) {
                return (long)this.skipInternal(var1);
            }
        } else {
            synchronized(this.statement.connection) {
                return (long)this.skipInternal(var1);
            }
        }
    }

    private final int skipInternal(int var1) throws IOException {
        int var2 = 0;
        int var3 = var1;
        if (!this.closed && !this.isNull()) {
            if (!this.needBytes()) {
                return -1;
            } else {
                while(var2 < var3 && this.needBytes()) {
                    var2 += this.flushBytes(var3 - var2);
                }

                return var2;
            }
        } else {
            return -1;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.statement.getConnectionDuringExceptionHandling();
    }
}
