//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

class NTFListener extends Thread {
    private NTFConnection[] connections = null;
    private int nbOfConnections = 0;
    private boolean needsToBeClosed = false;
    NTFManager dcnManager;
    ServerSocketChannel ssChannel;
    int tcpport;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFListener(NTFManager var1, ServerSocketChannel var2, int var3) {
        this.dcnManager = var1;
        this.connections = new NTFConnection[10];
        this.ssChannel = var2;
        this.tcpport = var3;
    }

    public void run() {
        try {
            Selector var1 = Selector.open();
            this.ssChannel.register(var1, 16);

            while(true) {
                var1.select();
                if (this.needsToBeClosed) {
                    var1.close();
                    this.ssChannel.close();
                    break;
                }

                Iterator var2 = var1.selectedKeys().iterator();

                while(var2.hasNext()) {
                    SelectionKey var3 = (SelectionKey)var2.next();
                    if ((var3.readyOps() & 16) == 16) {
                        ServerSocketChannel var4 = (ServerSocketChannel)var3.channel();
                        SocketChannel var5 = var4.accept();
                        NTFConnection var6 = new NTFConnection(this.dcnManager, var5);
                        if (this.connections.length == this.nbOfConnections) {
                            NTFConnection[] var7 = new NTFConnection[this.connections.length * 2];
                            System.arraycopy(this.connections, 0, var7, 0, this.connections.length);
                            this.connections = var7;
                        }

                        this.connections[this.nbOfConnections++] = var6;
                        var6.start();
                        var2.remove();
                    }
                }
            }
        } catch (IOException var8) {
        }

    }

    synchronized void closeThisListener() {
        for(int var1 = 0; var1 < this.nbOfConnections; ++var1) {
            this.connections[var1].closeThisConnection();
            this.connections[var1].interrupt();
        }

        this.needsToBeClosed = true;
    }
}
