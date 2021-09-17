//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

public class AttributeDescriptor {
    String attributeName;
    short attributeIdentifier;
    int attributeFlag;
    TypeDescriptor td;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    AttributeDescriptor(String var1, short var2, int var3, TypeDescriptor var4) {
        this.attributeName = var1;
        this.attributeIdentifier = var2;
        this.attributeFlag = var3;
        this.td = var4;
    }

    void setTypeDescriptor(TypeDescriptor var1) {
        this.td = var1;
    }

    public TypeDescriptor getTypeDescriptor() {
        return this.td;
    }

    public String getAttributeName() {
        return this.attributeName;
    }
}
