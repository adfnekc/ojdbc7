//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class OracleTimeoutPollingThread extends Thread {
    protected static final String threadName = "OracleTimeoutPollingThread";
    public static final String pollIntervalProperty = "oracle.jdbc.TimeoutPollInterval";
    public static final String pollIntervalDefault = "1000";
    private OracleTimeoutThreadPerVM[] knownTimeouts;
    private int count;
    private long sleepMillis;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleTimeoutPollingThread() {
        super("OracleTimeoutPollingThread");
        this.setDaemon(true);
        this.setPriority(10);
        this.knownTimeouts = new OracleTimeoutThreadPerVM[2];
        this.count = 0;
        this.sleepMillis = Long.parseLong(PhysicalConnection.getSystemPropertyPollInterval());
        this.start();
    }

    public synchronized void addTimeout(OracleTimeoutThreadPerVM var1) {
        int var2 = 0;
        if (this.count >= this.knownTimeouts.length) {
            OracleTimeoutThreadPerVM[] var3 = new OracleTimeoutThreadPerVM[this.knownTimeouts.length * 4];
            System.arraycopy(this.knownTimeouts, 0, var3, 0, this.knownTimeouts.length);
            var2 = this.knownTimeouts.length;
            this.knownTimeouts = var3;
        }

        while(var2 < this.knownTimeouts.length) {
            if (this.knownTimeouts[var2] == null) {
                this.knownTimeouts[var2] = var1;
                ++this.count;
                break;
            }

            ++var2;
        }

    }

    public synchronized void removeTimeout(OracleTimeoutThreadPerVM var1) {
        for(int var2 = 0; var2 < this.knownTimeouts.length; ++var2) {
            if (this.knownTimeouts[var2] == var1) {
                this.knownTimeouts[var2] = null;
                --this.count;
                break;
            }
        }

    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(this.sleepMillis);
            } catch (InterruptedException var2) {
            }

            this.pollOnce();
        }
    }

    private void pollOnce() {
        if (this.count > 0) {
            long var1 = System.currentTimeMillis();

            for(int var3 = 0; var3 < this.knownTimeouts.length; ++var3) {
                try {
                    if (this.knownTimeouts[var3] != null) {
                        this.knownTimeouts[var3].interruptIfAppropriate(var1);
                    }
                } catch (NullPointerException var5) {
                }
            }
        }

    }
}
