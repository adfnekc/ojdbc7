//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

public class OracleMultiPhaseArgs {
    int action = 0;
    int nsites = 0;
    Vector dbLinks = null;
    Vector xids = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleMultiPhaseArgs() {
    }

    public OracleMultiPhaseArgs(int var1, int var2, Vector var3, Vector var4) {
        if (var2 <= 1) {
            this.action = 0;
            this.nsites = 0;
            this.dbLinks = null;
            this.xids = null;
        } else if (!var3.isEmpty() && !var4.isEmpty() && var4.size() == var2 && var3.size() == 3 * var2) {
            this.action = var1;
            this.nsites = var2;
            this.xids = var3;
            this.dbLinks = var4;
        }

    }

    public OracleMultiPhaseArgs(byte[] var1) {
        ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
        DataInputStream var3 = new DataInputStream(var2);
        this.xids = new Vector();
        this.dbLinks = new Vector();

        try {
            this.action = var3.readInt();
            this.nsites = var3.readInt();
            int var4 = var3.readInt();
            int var5 = var3.readInt();
            byte[] var6 = new byte[var5];
            var3.read(var6, 0, var5);

            for(int var8 = 0; var8 < this.nsites; ++var8) {
                int var9 = var3.readInt();
                byte[] var10 = new byte[var9];
                var3.read(var10, 0, var9);
                this.xids.addElement(var4);
                this.xids.addElement(var6);
                this.xids.addElement(var10);
                String var12 = var3.readUTF();
                this.dbLinks.addElement(var12);
            }
        } catch (IOException var13) {
            var13.printStackTrace();
        }

    }

    public byte[] toByteArray() {
        return this.toByteArrayOS().toByteArray();
    }

    public ByteArrayOutputStream toByteArrayOS() {
        Object var1 = null;
        boolean var2 = false;
        ByteArrayOutputStream var3 = new ByteArrayOutputStream();
        DataOutputStream var4 = new DataOutputStream(var3);

        try {
            var4.writeInt(this.action);
            var4.writeInt(this.nsites);

            for(int var5 = 0; var5 < this.nsites; ++var5) {
                String var6 = (String)this.dbLinks.elementAt(var5);
                int var7 = (Integer)this.xids.elementAt(var5 * 3);
                byte[] var8 = (byte[])((byte[])this.xids.elementAt(var5 * 3 + 1));
                byte[] var9 = (byte[])((byte[])this.xids.elementAt(var5 * 3 + 2));
                if (var5 == 0) {
                    var4.writeInt(var7);
                    var4.writeInt(var8.length);
                    var4.write(var8, 0, var8.length);
                }

                var4.writeInt(var9.length);
                var4.write(var9, 0, var9.length);
                var4.writeUTF(var6);
            }
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        return var3;
    }

    public int getAction() {
        return this.action;
    }

    public int getnsite() {
        return this.nsites;
    }

    public Vector getdbLinks() {
        return this.dbLinks;
    }

    public Vector getXids() {
        return this.xids;
    }

    public void printMPArgs() {
        for(int var1 = 0; var1 < this.nsites; ++var1) {
            String var2 = (String)this.dbLinks.elementAt(var1);
            int var3 = (Integer)this.xids.elementAt(var1 * 3);
            byte[] var4 = (byte[])((byte[])this.xids.elementAt(var1 * 3 + 1));
            byte[] var5 = (byte[])((byte[])this.xids.elementAt(var1 * 3 + 2));
            this.printByteArray(var4);
            this.printByteArray(var5);
        }

    }

    private void printByteArray(byte[] var1) {
        StringBuffer var2 = new StringBuffer();

        for(int var3 = 0; var3 < var1.length; ++var3) {
            var2.append(var1[var3] + " ");
        }

    }
}
