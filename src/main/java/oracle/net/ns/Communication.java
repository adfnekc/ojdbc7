//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.Properties;

public interface Communication {
    void connect(String var1, Properties var2) throws IOException, NetException;

    SessionAtts getSessionAttributes();

    void disconnect() throws IOException, NetException;

    void sendBreak() throws IOException, NetException;

    void sendInterrupt() throws IOException, NetException;

    void sendReset() throws IOException, NetException;

    NetInputStream getNetInputStream() throws NetException, IOException;

    InputStream getInputStream() throws NetException, IOException;

    NetOutputStream getNetOutputStream() throws NetException, IOException;

    OutputStream getOutputStream() throws NetException, IOException;

    void setO3logSessionKey(byte[] var1) throws NetException, NetException;

    void setOption(int var1, Object var2) throws NetException, IOException;

    Object getOption(int var1) throws NetException, IOException;

    void abort() throws NetException, IOException;

    String getEncryptionName();

    String getDataIntegrityName();

    String getAuthenticationAdaptorName();

    boolean readZeroCopyIO(byte[] var1, int var2, int[] var3) throws IOException;

    void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException;

    boolean isConnectionSocketKeepAlive() throws SocketException;

    int getSocketReadTimeout() throws NetException, IOException;

    void setSocketReadTimeout(int var1) throws NetException, IOException;

    String getConnectionString();

    int getNegotiatedSDU() throws NetException;
}
