//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class ReplayContext implements oracle.jdbc.internal.ReplayContext {
    long flags_kpdxcAppContCtl;
    short queue_kpdxcAppContCtl;
    byte[] replayctx_kpdxcAppContCtl;
    long errcode_kpdxcAppContCtl;

    ReplayContext(long var1, short var3, byte[] var4, long var5) {
        this.flags_kpdxcAppContCtl = var1;
        this.queue_kpdxcAppContCtl = var3;
        this.errcode_kpdxcAppContCtl = var5;
        this.replayctx_kpdxcAppContCtl = var4;
    }

    public byte[] getContext() {
        return this.replayctx_kpdxcAppContCtl;
    }

    public short getQueue() {
        return this.queue_kpdxcAppContCtl;
    }

    public long getDirectives() {
        return this.flags_kpdxcAppContCtl;
    }

    public long getErrorCode() {
        return this.errcode_kpdxcAppContCtl;
    }

    private String getDirectivesAsString() {
        String var1 = "[0";
        if ((this.flags_kpdxcAppContCtl & 1L) == 1L) {
            var1 = var1 + "|DIRECTIVE_ENQUEUE_CALL";
        }

        if ((this.flags_kpdxcAppContCtl & 2L) == 2L) {
            var1 = var1 + "|DIRECTIVE_REQ_SCOPE_CRSR";
        }

        if ((this.flags_kpdxcAppContCtl & 4L) == 4L) {
            var1 = var1 + "|DIRECTIVE_REPLAY_ENABLED";
        }

        if ((this.flags_kpdxcAppContCtl & 8L) == 8L) {
            var1 = var1 + "|DIRECTIVE_EMPTY_QUEUE";
        }

        return var1 + "]";
    }

    public String toString() {
        return "ReplayContext[Directives=" + this.getDirectivesAsString() + ",Queue=" + this.queue_kpdxcAppContCtl + ",ErrorCode=" + this.errcode_kpdxcAppContCtl + ",Context=" + this.replayctx_kpdxcAppContCtl + "]";
    }
}
