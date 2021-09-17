package oracle.jdbc.driver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;

class T2CInputStream extends OracleInputStream {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   native int t2cGetBytes(long var1, int var3, byte[] var4, int var5, Accessor[] var6, Object[] var7, Object[] var8, long var9);

   T2CInputStream(OracleStatement var1, int var2, Accessor var3) {
      super(var1, var2, var3);
   }

   private int getRowNumber() {
      int var1 = 0;
      if (this.statement.isFetchStreams) {
         if (this.statement instanceof T2CStatement) {
            if (((T2CStatement)this.statement).needToRetainRows) {
               var1 = this.statement.storedRowCount;
            }
         } else if (this.statement instanceof T2CPreparedStatement) {
            if (((T2CPreparedStatement)this.statement).needToRetainRows) {
               var1 = this.statement.storedRowCount;
            }
         } else if (((T2CCallableStatement)this.statement).needToRetainRows) {
            var1 = this.statement.storedRowCount;
         }
      }

      return var1;
   }

   public int getBytes(int var1) throws IOException {
      synchronized(this.statement.connection) {
         if (var1 > this.currentBufferSize) {
            this.currentBufferSize = Math.max(var1, this.initialBufferSize);
            this.resizableBuffer = new byte[this.currentBufferSize];
         }

         long var3 = (long)(this.statement.connection.useNio ? 1 : 0);
         if (this.statement.connection.useNio) {
            if (this.statement.nioBuffers[3] != null && this.statement.nioBuffers[3].capacity() >= this.resizableBuffer.length) {
               this.statement.nioBuffers[3].rewind();
            } else {
               this.statement.nioBuffers[3] = ByteBuffer.allocateDirect(this.resizableBuffer.length);
            }
         }

         boolean var5 = false;
         int var13 = this.t2cGetBytes(this.statement.c_state, this.columnIndex, this.resizableBuffer, this.currentBufferSize, this.statement.accessors, this.statement.nioBuffers, this.statement.lobPrefetchMetaData, var3);
         boolean var6 = false;

         try {
            int var7 = this.getRowNumber();
            if (var13 == -1) {
               ((T2CConnection)this.statement.connection).checkError(var13, this.statement.sqlWarning);
            } else if (var13 == -2) {
               var6 = true;
               this.accessor.setNull(var7, true);
               var13 = 0;
            } else if (var13 >= 0) {
               this.accessor.setNull(var7, false);
            }
         } catch (SQLException var11) {
            throw new IOException(var11.getMessage());
         }

         if (var13 <= 0) {
            var13 = -1;
            var6 = true;
         }

         if (this.statement.connection.useNio) {
            ByteBuffer var14 = this.statement.nioBuffers[3];
            if (var14 != null && var13 > 0) {
               var14.get(this.resizableBuffer, 0, var13);
            }

            if (var6) {
               try {
                  this.statement.extractNioDefineBuffers(this.columnIndex);
               } catch (SQLException var10) {
                  throw new IOException(var10.getMessage());
               }
            }
         }

         if (var6 && this.statement.lobPrefetchMetaData != null) {
            this.statement.processLobPrefetchMetaData(this.statement.lobPrefetchMetaData);
         }

         return var13;
      }
   }

   public boolean isNull() throws IOException {
      if (!this.statement.isFetchStreams) {
         this.needBytes();
         return super.isNull();
      } else {
         return false;
      }
   }
}
