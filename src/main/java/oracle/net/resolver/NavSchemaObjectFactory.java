//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import oracle.net.jdbc.TNSAddress.SchemaObject;
import oracle.net.jdbc.TNSAddress.SchemaObjectFactoryInterface;

public class NavSchemaObjectFactory implements SchemaObjectFactoryInterface {
    public NavSchemaObjectFactory() {
    }

    public SchemaObject create(int var1) {
        switch(var1) {
            case 0:
                return new NavAddress(this);
            case 1:
                return new NavAddressList(this);
            case 2:
                return new NavDescription(this);
            case 3:
                return new NavDescriptionList(this);
            case 4:
                return new NavServiceAlias(this);
            default:
                return null;
        }
    }
}
