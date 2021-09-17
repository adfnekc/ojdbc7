//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.nt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.Hashtable;
import java.util.Properties;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.ns.NetException;

public class SdpNTAdapter implements NTAdapter {
    static final boolean DEBUG = false;
    static final String SDP_SOCKET_CLASS_NAME = "com.oracle.net.Sdp";
    static Method OPEN_SOCKET = null;
    static Method OPEN_SOCKET_CHANNEL = null;
    private SocketChannel socketChannel;
    int port;
    String host;
    protected Socket socket;
    protected int sockTimeout;
    protected Properties socketOptions;
    private static Hashtable<String, InetAddress[]> inetaddressesCache = new Hashtable();
    private static Hashtable<String, Integer> circularOffsets = new Hashtable();

    private static Socket getSDPSocket() throws IOException {
        if (OPEN_SOCKET == null) {
            try {
                Class var0 = Class.forName("com.oracle.net.Sdp");
                OPEN_SOCKET = var0.getMethod("openSocket");
            } catch (ClassNotFoundException var3) {
                throw new IOException("SDP enabled, but SDP socket class not in classpath", var3);
            } catch (NoSuchMethodException var4) {
                throw new IOException("SDP enabled but unable to get SDP socket class", var4);
            }
        }

        try {
            return (Socket)((Socket)OPEN_SOCKET.invoke((Object)null));
        } catch (IllegalAccessException var1) {
            throw new IOException("SDP enabled, but SDP.openSocket could not be accessed", var1);
        } catch (InvocationTargetException var2) {
            throw new IOException("SDP enabled, but SDP.openSocket raised an exception", var2);
        }
    }

    private static SocketChannel getSDPSocketChannel() throws IOException {
        if (OPEN_SOCKET_CHANNEL == null) {
            try {
                Class var0 = Class.forName("com.oracle.net.Sdp");
                OPEN_SOCKET_CHANNEL = var0.getMethod("openSocketChannel");
            } catch (ClassNotFoundException var3) {
                throw new IOException("SDP enabled, but SDP socket class not in classpath", var3);
            } catch (NoSuchMethodException var4) {
                throw new IOException("SDP enabled but unable to get SDP socket class", var4);
            }
        }

        try {
            return (SocketChannel)((SocketChannel)OPEN_SOCKET_CHANNEL.invoke((Object)null));
        } catch (IllegalAccessException var1) {
            throw new IOException("SDP enabled, but SDP.openSocket could not be accessed", var1);
        } catch (InvocationTargetException var2) {
            throw new IOException("SDP enabled, but SDP.openSocket raised an exception", var2);
        }
    }

    public SdpNTAdapter(String var1, Properties var2) throws NLException {
        this.socketOptions = var2;
        NVNavigator var3 = new NVNavigator();
        NVPair var4 = (new NVFactory()).createNVPair(var1);
        NVPair var5 = var3.findNVPair(var4, "HOST");
        NVPair var6 = var3.findNVPair(var4, "PORT");
        if (var5 == null) {
            throw new NLException("NoNVPair-04614", "HOST");
        } else {
            this.host = var5.getAtom();
            if (var6 != null) {
                try {
                    this.port = Integer.parseInt(var6.getAtom());
                } catch (Exception var8) {
                    throw (NLException)(new NLException((new NetException(116)).getMessage())).initCause(var8);
                }
            } else {
                this.port = 1521;
            }

            if (this.port < 0 || this.port > 65535) {
                throw new NLException((new NetException(116)).getMessage());
            }
        }
    }

    public void connect() throws IOException {
        String var1 = (String)this.socketOptions.get(2);
        boolean var2 = Boolean.parseBoolean((String)this.socketOptions.get(18));
        Boolean var3 = Boolean.parseBoolean((String)this.socketOptions.get(20));
        InetAddress[] var4 = InetAddress.getAllByName(this.host);
        if (var2 && var4.length > 1) {
            var4 = getAddressesInCircularOrder(this.host, var4);
        }

        int var5 = var4.length;
        int var6 = 0;

        while(true) {
            InetAddress var7 = var4[var6];
            ++var6;
            --var5;
            if (!var3) {
                this.socket = getSDPSocket();
            }

            try {
                if (var3) {
                    this.socketChannel = getSDPSocketChannel();
                    this.socket = this.socketChannel.socket();
                } else {
                    this.socket.connect(new InetSocketAddress(var7, this.port), Integer.parseInt(var1));
                }
                break;
            } catch (IOException var11) {
                try {
                    if (this.socket != null) {
                        this.socket.close();
                    }
                } catch (Exception var10) {
                }

                if (var5 <= 0) {
                    throw var11;
                }

                if (var6 >= var4.length) {
                    break;
                }
            }
        }

        this.setOption(3, var1);
        this.setSocketOptions();
    }

    public void setSocketOptions() throws IOException {
        String var1;
        if ((var1 = (String)this.socketOptions.get(0)) != null) {
            this.setOption(0, var1);
        }

        if ((var1 = (String)this.socketOptions.get(1)) != null) {
            this.setOption(1, var1);
        }

    }

    public void disconnect() throws IOException {
        try {
            this.socket.close();
        } finally {
            this.socket = null;
        }

    }

    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    public void setOption(int var1, Object var2) throws IOException, NetException {
        String var3;
        switch(var1) {
            case 0:
                var3 = (String)var2;
                this.socket.setTcpNoDelay(var3.equals("YES"));
                break;
            case 1:
                var3 = (String)var2;
                if (var3.equals("YES")) {
                    this.socket.setKeepAlive(true);
                }
            case 2:
            default:
                break;
            case 3:
                this.sockTimeout = Integer.parseInt((String)var2);
                this.socket.setSoTimeout(this.sockTimeout);
        }

    }

    public Object getOption(int var1) throws IOException, NetException {
        switch(var1) {
            case 1:
                return "" + this.sockTimeout;
            default:
                return null;
        }
    }

    public void abort() throws NetException, IOException {
        try {
            this.socket.setSoLinger(true, 0);
        } catch (Exception var2) {
        }

        this.socket.close();
    }

    public void sendUrgentByte(int var1) throws IOException {
        this.socket.sendUrgentData(var1);
    }

    public boolean isCharacteristicUrgentSupported() throws IOException {
        try {
            return !this.socket.getOOBInline();
        } catch (IOException var2) {
            return false;
        }
    }

    public void setReadTimeoutIfRequired(Properties var1) throws IOException, NetException {
        String var2 = (String)var1.get("oracle.net.READ_TIMEOUT");
        if (var2 == null) {
            var2 = "0";
        }

        this.setOption(3, var2);
    }

    public String toString() {
        return "host=" + this.host + ", port=" + this.port + "\n    socket_timeout=" + this.sockTimeout + ", socketOptions=" + this.socketOptions.toString() + "\n    socket=" + this.socket;
    }

    private static final synchronized InetAddress[] getAddressesInCircularOrder(String var0, InetAddress[] var1) {
        InetAddress[] var2 = (InetAddress[])inetaddressesCache.get(var0);
        Integer var3 = (Integer)circularOffsets.get(var0);
        if (var2 == null || !areEquals(var2, var1)) {
            var3 = new Integer(0);
            var2 = var1;
            inetaddressesCache.put(var0, var1);
            circularOffsets.put(var0, var3);
        }

        InetAddress[] var4 = getCopyAddresses(var2, var3);
        circularOffsets.put(var0, new Integer((var3 + 1) % var2.length));
        return var4;
    }

    private static final boolean areEquals(InetAddress[] var0, InetAddress[] var1) {
        if (var0.length != var1.length) {
            return false;
        } else {
            for(int var2 = 0; var2 < var0.length; ++var2) {
                if (!var0[var2].equals(var1[var2])) {
                    return false;
                }
            }

            return true;
        }
    }

    private static final InetAddress[] getCopyAddresses(InetAddress[] var0, int var1) {
        InetAddress[] var2 = new InetAddress[var0.length];

        for(int var3 = 0; var3 < var0.length; ++var3) {
            var2[var3] = var0[(var3 + var1) % var0.length];
        }

        return var2;
    }

    public boolean isConnectionSocketKeepAlive() throws SocketException {
        return this.socket.getKeepAlive();
    }

    public SocketChannel getSocketChannel() {
        return this.socketChannel;
    }
}
