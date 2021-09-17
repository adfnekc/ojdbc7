//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import oracle.jdbc.dcn.DatabaseChangeEvent.AdditionalEventType;
import oracle.jdbc.dcn.DatabaseChangeEvent.EventType;
import oracle.sql.CharacterSet;

class NTFConnection extends Thread {
    private static final int NS_HEADER_SIZE = 10;
    private SocketChannel channel;
    private ByteBuffer inBuffer = null;
    private ByteBuffer outBuffer = null;
    private int currentNSPacketLength;
    private int currentNSPacketType;
    private ByteBuffer currentNSPacketDataBuffer;
    private boolean needsToBeClosed = false;
    private NTFManager ntfManager;
    private Selector selector = null;
    private Iterator iterator = null;
    private SelectionKey aKey = null;
    int remotePort;
    String remoteAddress;
    String remoteName;
    int localPort;
    String localAddress;
    String localName;
    String connectionDescription;
    CharacterSet charset = null;
    static final int NSPTCN = 1;
    static final int NSPTAC = 2;
    static final int NSPTAK = 3;
    static final int NSPTRF = 4;
    static final int NSPTRD = 5;
    static final int NSPTDA = 6;
    static final int NSPTNL = 7;
    static final int NSPTAB = 9;
    static final int NSPTRS = 11;
    static final int NSPTMK = 12;
    static final int NSPTAT = 13;
    static final int NSPTCNL = 14;
    static final int NSPTHI = 19;
    static final short KPDNFY_TIMEOUT = 1;
    static final short KPDNFY_GROUPING = 2;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFConnection(NTFManager var1, SocketChannel var2) {
        try {
            this.ntfManager = var1;
            this.channel = var2;
            this.channel.configureBlocking(false);
            this.inBuffer = ByteBuffer.allocate(4096);
            this.outBuffer = ByteBuffer.allocate(2048);
            Socket var3 = this.channel.socket();
            InetAddress var4 = var3.getInetAddress();
            InetAddress var5 = var3.getLocalAddress();
            this.remotePort = var3.getPort();
            this.localPort = var3.getLocalPort();
            this.remoteAddress = var4.getHostAddress();
            this.remoteName = var4.getHostName();
            this.localAddress = var5.getHostAddress();
            this.localName = var5.getHostName();
            this.connectionDescription = "local=" + this.localName + "/" + this.localAddress + ":" + this.localPort + ", remote=" + this.remoteName + "/" + this.remoteAddress + ":" + this.remotePort;
        } catch (IOException var6) {
        }

    }

    public void run() {
        try {
            this.selector = Selector.open();
            this.channel.register(this.selector, 1);
            boolean var1 = false;
            this.inBuffer.limit(0);

            for(; !this.needsToBeClosed; this.unmarshalOneNSPacket()) {
                int var15;
                if (!this.inBuffer.hasRemaining()) {
                    do {
                        var15 = this.readFromNetwork();
                    } while(var15 == 0);
                }
            }
        } catch (IOException var12) {
        } catch (InterruptedException var13) {
        } finally {
            try {
                this.selector.close();
                this.channel.close();
            } catch (IOException var11) {
            }

        }

    }

    private int readFromNetwork() throws IOException, InterruptedException {
        this.inBuffer.compact();

        do {
            while(this.iterator == null || !this.iterator.hasNext()) {
                this.selector.select();
                if (this.needsToBeClosed) {
                    throw new InterruptedException();
                }

                this.iterator = this.selector.selectedKeys().iterator();
            }

            this.aKey = (SelectionKey)this.iterator.next();
        } while((this.aKey.readyOps() & 1) != 1);

        int var1 = this.channel.read(this.inBuffer);
        if (var1 < 0) {
            throw new EOFException();
        } else {
            if (var1 > 0) {
                this.inBuffer.flip();
            }

            this.iterator.remove();
            return var1;
        }
    }

    private void getNextNSPacket() throws IOException, InterruptedException {
        int var1;
        while(!this.inBuffer.hasRemaining() || this.inBuffer.remaining() < 10) {
            var1 = this.readFromNetwork();
        }

        this.currentNSPacketLength = this.inBuffer.getShort();
        this.inBuffer.position(this.inBuffer.position() + 2);
        this.currentNSPacketType = this.inBuffer.get();
        this.inBuffer.position(this.inBuffer.position() + 5);

        while(this.inBuffer.remaining() < this.currentNSPacketLength - 10) {
            var1 = this.readFromNetwork();
        }

        int var2 = this.inBuffer.limit();
        int var3 = this.inBuffer.position() + this.currentNSPacketLength - 10;
        this.inBuffer.limit(var3);
        this.currentNSPacketDataBuffer = this.inBuffer.slice();
        this.inBuffer.limit(var2);
        this.inBuffer.position(var3);
    }

    private void unmarshalOneNSPacket() throws IOException, InterruptedException {
        this.getNextNSPacket();
        if (this.currentNSPacketDataBuffer.hasRemaining()) {
            switch(this.currentNSPacketType) {
                case 1:
                    byte[] var1 = new byte[]{0, 24, 0, 0, 2, 0, 0, 0, 1, 52, 0, 0, 8, 0, 127, -1, 1, 0, 0, 0, 0, 24, 65, 1};
                    this.outBuffer.clear();
                    this.outBuffer.put(var1);
                    this.outBuffer.limit(24);
                    this.outBuffer.rewind();
                    this.channel.write(this.outBuffer);
                    break;
                case 6:
                    if (this.currentNSPacketDataBuffer.get(0) == -34 && this.currentNSPacketDataBuffer.get(1) == -83) {
                        byte[] var2 = new byte[]{0, 127, 0, 0, 6, 0, 0, 0, 0, 0, -34, -83, -66, -17, 0, 117, 10, 32, 1, 0, 0, 4, 0, 0, 4, 0, 3, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 1, 0, 0, 2, 0, 6, 0, 31, 0, 14, 0, 1, -34, -83, -66, -17, 0, 3, 0, 0, 0, 2, 0, 4, 0, 1, 0, 1, 0, 2, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 1, 0, 0, 2, 0, 6, -5, -1, 0, 2, 0, 2, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 1, 0, 0, 1, 0, 2, 0, 0, 3, 0, 2, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 1, 0, 0, 1, 0, 2, 0};
                        this.outBuffer.clear();
                        this.outBuffer.put(var2);
                        this.outBuffer.limit(var2.length);
                        this.outBuffer.rewind();
                        this.channel.write(this.outBuffer);
                    } else {
                        this.unmarshalNSDataPacket();
                    }
            }
        }

    }

    private void unmarshalNSDataPacket() throws IOException, InterruptedException {
        short var1 = this.readShort();
        int var2 = this.readInt();
        byte var3 = this.readByte();
        int var4 = this.readInt();
        short var5 = this.readShort();
        if (this.charset == null || this.charset.getOracleId() != var5) {
            this.charset = CharacterSet.make(var5);
        }

        byte var6 = this.readByte();
        int var7 = this.readInt();
        short var8 = this.readShort();
        byte var9 = this.readByte();
        int var10 = this.readInt();
        short var11 = this.readShort();
        int var12 = (var2 - 21) / 9;
        int[] var13 = new int[var12];

        int var16;
        for(int var14 = 0; var14 < var12; ++var14) {
            byte var15 = this.readByte();
            var16 = this.readInt();
            byte[] var17 = new byte[var16];
            this.readBuffer(var17, 0, var16);

            for(int var18 = 0; var18 < var16; ++var18) {
                if (var18 < 4) {
                    var13[var14] |= (var17[var18] & 255) << 8 * (var16 - var18 - 1);
                }
            }
        }

        NTFDCNEvent var24 = null;
        NTFAQEvent var25 = null;
        var16 = 0;
        short var26 = 0;
        NTFRegistration[] var27 = null;
        short var19;
        int var20;
        if (var1 >= 2) {
            var19 = this.readShort();
            var27 = new NTFRegistration[var13.length];

            for(var20 = 0; var20 < var13.length; ++var20) {
                var27[var20] = this.ntfManager.getRegistration(var13[var20]);
                if (var27[var20] != null) {
                    var16 = var27[var20].getNamespace();
                    var26 = var27[var20].getDatabaseVersion();
                }
            }

            if (var16 == 2) {
                var24 = new NTFDCNEvent(this, var26);
            } else if (var16 == 1) {
                var25 = new NTFAQEvent(this, var26);
            } else if (var16 == 0) {
            }
        }

        boolean var28 = false;
        if (var1 >= 3) {
            short var29 = this.readShort();
            int var21 = this.readInt();
            byte var22 = this.readByte();
            int var23 = this.readInt();
            var19 = this.readShort();
            if (var16 == 2 && var24 != null) {
                var24.setAdditionalEventType(AdditionalEventType.getEventType(var19));
                if (var19 == 1) {
                    var24.setEventType(EventType.DEREG);
                }
            } else if (var16 == 1 && var25 != null) {
                var25.setAdditionalEventType(oracle.jdbc.aq.AQNotificationEvent.AdditionalEventType.getEventType(var19));
                if (var19 == 1) {
                    var25.setEventType(oracle.jdbc.aq.AQNotificationEvent.EventType.DEREG);
                }
            }
        }

        if (var1 > 3) {
        }

        if (var27 != null) {
            if (var16 == 2) {
                for(var20 = 0; var20 < var27.length; ++var20) {
                    if (var27[var20] != null && var24 != null) {
                        var27[var20].notify(var24);
                    }
                }
            }

            if (var16 == 1) {
                for(var20 = 0; var20 < var27.length; ++var20) {
                    if (var27[var20] != null && var25 != null) {
                        var27[var20].notify(var25);
                    }
                }
            }
        }

    }

    void closeThisConnection() {
        this.needsToBeClosed = true;
    }

    byte readByte() throws IOException, InterruptedException {
        byte var1 = 0;
        if (this.currentNSPacketDataBuffer.hasRemaining()) {
            var1 = this.currentNSPacketDataBuffer.get();
        } else {
            this.getNextNSPacket();
            this.currentNSPacketDataBuffer.get();
        }

        return var1;
    }

    short readShort() throws IOException, InterruptedException {
        boolean var1 = false;
        short var4;
        if (this.currentNSPacketDataBuffer.remaining() >= 2) {
            var4 = this.currentNSPacketDataBuffer.getShort();
        } else {
            int var2 = this.readByte() & 255;
            int var3 = this.readByte() & 255;
            var4 = (short)(var2 << 8 | var3);
        }

        return var4;
    }

    int readInt() throws IOException, InterruptedException {
        boolean var1 = false;
        int var6;
        if (this.currentNSPacketDataBuffer.remaining() >= 4) {
            var6 = this.currentNSPacketDataBuffer.getInt();
        } else {
            int var2 = this.readByte() & 255;
            int var3 = this.readByte() & 255;
            int var4 = this.readByte() & 255;
            int var5 = this.readByte() & 255;
            var6 = var2 << 24 | var3 << 16 | var4 << 8 | var5;
        }

        return var6;
    }

    long readLong() throws IOException, InterruptedException {
        long var1 = 0L;
        if (this.currentNSPacketDataBuffer.remaining() >= 8) {
            var1 = this.currentNSPacketDataBuffer.getLong();
        } else {
            long var3 = (long)(this.readByte() & 255);
            long var5 = (long)(this.readByte() & 255);
            long var7 = (long)(this.readByte() & 255);
            long var9 = (long)(this.readByte() & 255);
            long var11 = (long)(this.readByte() & 255);
            long var13 = (long)(this.readByte() & 255);
            long var15 = (long)(this.readByte() & 255);
            long var17 = (long)(this.readByte() & 255);
            var1 = var3 << 56 | var5 << 48 | var7 << 40 | var9 << 32 | var11 << 24 | var13 << 16 | var15 << 8 | var17;
        }

        return var1;
    }

    void readBuffer(byte[] var1, int var2, int var3) throws IOException, InterruptedException {
        if (this.currentNSPacketDataBuffer.remaining() >= var3) {
            this.currentNSPacketDataBuffer.get(var1, var2, var3);
        } else {
            boolean var4 = false;
            byte var5 = 0;
            boolean var6 = false;
            int var7 = this.currentNSPacketDataBuffer.remaining();
            this.currentNSPacketDataBuffer.get(var1, var2, var7);
            var2 += var7;
            int var8 = var5 + var7;

            while(!var4) {
                this.getNextNSPacket();
                var7 = this.currentNSPacketDataBuffer.remaining();
                int var9 = Math.min(var7, var3 - var8);
                this.currentNSPacketDataBuffer.get(var1, var2, var9);
                var2 += var9;
                var8 += var9;
                if (var8 == var3) {
                    var4 = true;
                }
            }
        }

    }

    private String packetToString(ByteBuffer var1) throws IOException {
        int var2 = 0;
        char[] var4 = new char[8];
        StringBuffer var5 = new StringBuffer();
        int var6 = var1.position();

        while(var1.hasRemaining()) {
            byte var3 = var1.get();
            String var7 = Integer.toHexString(var3 & 255);
            var7 = var7.toUpperCase();
            if (var7.length() == 1) {
                var7 = "0" + var7;
            }

            var5.append(var7);
            var5.append(' ');
            if (var3 > 32 && var3 < 127) {
                var4[var2] = (char)var3;
            } else {
                var4[var2] = '.';
            }

            ++var2;
            if (var2 == 8) {
                var5.append('|');
                var5.append(var4);
                var5.append('|');
                var5.append('\n');
                var2 = 0;
            }
        }

        if (var2 != 0) {
            int var9 = 8 - var2;

            int var8;
            for(var8 = 0; var8 < var9 * 3; ++var8) {
                var5.append(' ');
            }

            var5.append('|');
            var5.append(var4, 0, var2);

            for(var8 = 0; var8 < var9; ++var8) {
                var5.append(' ');
            }

            var5.append('|');
            var5.append('\n');
        }

        var5.append("\nEnd of Packet\n\n");
        var1.position(var6);
        return var5.toString();
    }
}
