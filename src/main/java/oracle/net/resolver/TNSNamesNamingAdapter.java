//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.io.File;
import java.io.IOException;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NLParamParser;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.ns.NetException;

public class TNSNamesNamingAdapter implements NamingAdapterInterface {
    private NLParamParser tnsEntriesHdl;
    private String tnsDir;
    private long lastModifiedTime;
    private long nextPollTime;
    private static final String TNSFILE = "tnsnames.ora";
    private static final long REFRESH_INTERVAL = 0L;

    public TNSNamesNamingAdapter(String var1) {
        this.tnsDir = var1;
        this.resetAttr();
    }

    private void resetAttr() {
        this.tnsEntriesHdl = null;
        this.lastModifiedTime = 0L;
        this.nextPollTime = 0L;
    }

    public String resolve(String var1) throws NetException {
        NVPair var2 = null;
        synchronized(this) {
            this.checkAndReload();
            var2 = this.tnsEntriesHdl.getNLPListElement(var1);
        }

        if (var2 == null) {
            throw new NetException(122, "\"" + var1 + "\"");
        } else {
            return var2.valueToString();
        }
    }

    private void loadFile() throws NetException {
        File var1 = new File(this.tnsDir, "tnsnames.ora");
        String var2 = var1.getAbsolutePath();
        if (var1.isFile() && var1.canRead()) {
            long var3 = var1.lastModified();
            if (this.lastModifiedTime != var3) {
                try {
                    this.tnsEntriesHdl = new NLParamParser(var2, (byte)1);
                    this.lastModifiedTime = var3;
                } catch (IOException var6) {
                    this.resetAttr();
                    throw new NetException(123, ": " + var2);
                } catch (NLException var7) {
                }
            }

        } else {
            this.resetAttr();
            throw new NetException(123, ": " + var2);
        }
    }

    private void checkAndReload() throws NetException {
        long var1 = System.currentTimeMillis();
        if (var1 > this.nextPollTime) {
            this.nextPollTime = var1 + 0L;
            this.loadFile();
        }

    }
}
