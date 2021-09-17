//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TypeTreeElement {
    String schemaName = null;
    String typeName = null;
    String[] childSchemaNames = null;
    String[] childTypeNames = null;
    int size = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public TypeTreeElement(String var1, String var2) {
        this.schemaName = var1;
        this.typeName = var2;
    }

    public void putChild(String var1, String var2, int var3) {
        int var4;
        if (this.childTypeNames == null) {
            var4 = 10;
            if (var3 > var4) {
                var4 = var3 * 2;
            }

            this.childSchemaNames = new String[var4];
            this.childTypeNames = new String[var4];
        }

        if (var3 >= this.childTypeNames.length) {
            var4 = (var3 + 10) * 2;
            String[] var5 = new String[var4];
            System.arraycopy(this.childSchemaNames, 0, var5, 0, this.childSchemaNames.length);
            this.childSchemaNames = var5;
            var5 = new String[var4];
            System.arraycopy(this.childTypeNames, 0, var5, 0, this.childTypeNames.length);
            this.childTypeNames = var5;
        }

        this.childSchemaNames[var3] = var1;
        this.childTypeNames[var3] = var2;
        if (var3 > this.size) {
            this.size = var3;
        }

    }

    public String getChildSchemaName(int var1) {
        return this.childSchemaNames[var1];
    }

    public String getChildTypeName(int var1) {
        return this.childTypeNames[var1];
    }

    public String toString() {
        StringWriter var1 = new StringWriter();
        PrintWriter var2 = new PrintWriter(var1);
        var2.println("schemaName: " + this.schemaName + " typeName: " + this.typeName);

        for(int var3 = 0; var3 < this.size; ++var3) {
            var2.println("index: " + var3 + " schema name: " + this.childSchemaNames[var3] + " type name: " + this.childTypeNames[var3]);
        }

        return var1.getBuffer().substring(0);
    }
}
