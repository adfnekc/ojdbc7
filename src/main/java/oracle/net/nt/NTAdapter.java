//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.nt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.Properties;
import oracle.net.ns.NetException;

public interface NTAdapter {
    void connect() throws IOException;

    void disconnect() throws IOException;

    SocketChannel getSocketChannel();

    InputStream getInputStream() throws IOException;

    OutputStream getOutputStream() throws IOException;

    void setOption(int var1, Object var2) throws IOException, NetException;

    Object getOption(int var1) throws IOException, NetException;

    void abort() throws IOException, NetException;

    void sendUrgentByte(int var1) throws IOException;

    boolean isCharacteristicUrgentSupported() throws IOException;

    void setReadTimeoutIfRequired(Properties var1) throws IOException, NetException;

    boolean isConnectionSocketKeepAlive() throws SocketException;
}
