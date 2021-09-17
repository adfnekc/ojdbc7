package oracle.net.jdbc.TNSAddress;

public class SchemaObjectFactory implements SchemaObjectFactoryInterface {
   public SchemaObject create(int var1) {
      switch(var1) {
      case 0:
         return new Address(this);
      case 1:
         return new AddressList(this);
      case 2:
         return new Description(this);
      case 3:
         return new DescriptionList(this);
      case 4:
         return new ServiceAlias(this);
      default:
         return null;
      }
   }
}
