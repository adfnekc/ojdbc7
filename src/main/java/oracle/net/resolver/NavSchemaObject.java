//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import oracle.net.jdbc.TNSAddress.SchemaObject;
import oracle.net.nt.ConnStrategy;

public interface NavSchemaObject extends SchemaObject {
    boolean DEBUG = false;
    String SR = "(SOURCE_ROUTE=yes)";
    String HC = "(HOP_COUNT=0)";
    String LB = "(LOAD_BALANCE=yes)";
    String NFO = "(FAILOVER=false)";
    String CD = "(CONNECT_DATA=";
    String CID1v2 = "(CID=(PROGRAM=";
    String CID2v2 = ")(HOST=__jdbc__)(USER=";
    String CID3v2 = "))";

    void navigate(ConnStrategy var1, StringBuffer var2);

    void addToString(ConnStrategy var1);
}
