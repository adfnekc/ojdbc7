//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.TNSAddress;

public interface SchemaObjectFactoryInterface {
    int ADDR = 0;
    int ADDR_LIST = 1;
    int DESC = 2;
    int DESC_LIST = 3;
    int ALIAS = 4;
    int SERVICE = 5;
    int DB_SERVICE = 6;

    SchemaObject create(int var1);
}
