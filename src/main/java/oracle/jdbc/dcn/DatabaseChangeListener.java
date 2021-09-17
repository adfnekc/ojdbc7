//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.dcn;

import java.util.EventListener;

public interface DatabaseChangeListener extends EventListener {
    void onDatabaseChangeNotification(DatabaseChangeEvent var1);
}
