//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

public interface ReplayContext {
    byte[] getContext();

    short getQueue();

    long getDirectives();

    long getErrorCode();
}
