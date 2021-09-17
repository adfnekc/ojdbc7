//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleConnection;

public class TRANSDUMP {
    private static byte[] GMT_TRANSITIONS = new byte[]{1, 118, 100, 1, 1, 1, 1, 1, 20, 60, 0};

    public TRANSDUMP() {
    }

    public static byte[] getTransitions(Connection var0, int var1) throws SQLException {
        Object var2 = null;
        byte[] var13;
        if (var1 == ZONEIDMAP.getID("GMT")) {
            var13 = GMT_TRANSITIONS;
        } else {
            OracleConnection var3 = ((oracle.jdbc.OracleConnection)var0).physicalConnectionWithin();
            var3.beginNonRequestCalls();
            OracleCallableStatement var4 = (OracleCallableStatement)var0.prepareCall("begin dbms_utility.get_tz_transitions(:1,:2); end;");
            var4.setInt(1, var1);
            var4.registerOutParameter(2, -2);

            try {
                var4.execute();
                var13 = var4.getBytes(2);
            } finally {
                try {
                    var4.close();
                } catch (Exception var11) {
                }

                var3.endNonRequestCalls();
            }
        }

        return var13;
    }
}
