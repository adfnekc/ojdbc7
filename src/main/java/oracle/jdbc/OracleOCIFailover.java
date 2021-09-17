//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.Connection;

public interface OracleOCIFailover {
    int FO_SESSION = 1;
    int FO_SELECT = 2;
    int FO_NONE = 3;
    int FO_TYPE_UNKNOWN = 4;
    int FO_BEGIN = 1;
    int FO_END = 2;
    int FO_ABORT = 3;
    int FO_REAUTH = 4;
    int FO_ERROR = 5;
    int FO_RETRY = 6;
    int FO_EVENT_UNKNOWN = 7;

    int callbackFn(Connection var1, Object var2, int var3, int var4);
}
