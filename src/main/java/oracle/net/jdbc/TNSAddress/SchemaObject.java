//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.TNSAddress;

import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVPair;

public interface SchemaObject {
    int ADDR = 0;
    int ADDR_LIST = 1;
    int DESC = 2;
    int DESC_LIST = 3;
    int ALIAS = 4;
    int SERVICE = 5;
    int DB_SERVICE = 6;

    int isA();

    String isA_String();

    void initFromString(String var1) throws NLException, SOException;

    void initFromNVPair(NVPair var1) throws SOException;

    String toString();
}
