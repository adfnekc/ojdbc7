package main;

import oracle.security.o5logon.O5Logon;
import java.lang.System;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class app {
    static void verify() {
        O5Logon logon = new O5Logon();

        final int verifierType = 6949;
        final byte[] salt = { 48, 65, 56, 56, 70, 50, 70, 52, 51, 69, 54, 56, 67, 66, 67, 54, 54, 51, 53, 55 };
        final String user = "SYSTEM";
        final String password = "oracle";
        final int[] len_64 = { 64 };
        final byte serverCompileTimeCapabilities = 15;
        final byte[] encryptedKB = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1,
                1, 1, 1 };

        byte[] encryptedSK = { 70, 55, 67, 70, 52, 70, 65, 53, 53, 51, 54, 65, 57, 53, 57, 56, 56, 70, 67, 68, 70, 50,
                69, 66, 67, 50, 51, 65, 50, 69, 67, 68, 69, 56, 52, 49, 70, 56, 49, 54, 49, 52, 68, 55, 70, 67, 52, 52,
                55, 66, 56, 48, 69, 49, 51, 52, 56, 66, 67, 69, 49, 66, 48, 69, 70, 70, 57, 55, 57, 68, 68, 52, 55, 65,
                66, 55, 50, 57, 66, 51, 48, 51, 52, 67, 50, 50, 57, 51, 54, 50, 50, 49, 69, 67, 57, 50 };

        byte[] f = { 119, 42, 55, 127, 83, -37, -116, -72, 100, 99, 92, -42, -19, -29, 112, 34, -77, -56, 82, 49, 116,
                -109, -110, 1 };

        byte[] empty_256_bytes = new byte[256];

        String AUTH_SVR_RESPONSE = "46C22B78D338E6F2489D2BA68AFAEFCC22432E3D276FD8D5867BC7E15AE96F614CB5159B71064A9A76891E6392E7F117";
        try {
            logon.generateOAuthResponse(verifierType, salt, user, password, password.getBytes(), encryptedSK,
                    encryptedKB, empty_256_bytes, len_64, true, serverCompileTimeCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("generateOAuthResponse %s\n", e);
        }

        logon.setF(f);

        // (this.verifierType, this.salt, var13, var14, var6, this.encryptedSK,
        // this.encryptedKB, var16, var25, this.meg.conv.isServerCSMultiByte,
        // this.serverCompileTimeCapabilities[4]);
        System.out.println("AUTH_SVR_RESPONSE:" + AUTH_SVR_RESPONSE);

        logon.validateServerIdentity(AUTH_SVR_RESPONSE);
    }

    public static void main(String[] args) {
        // verify();

        connect();

        // String b = "000208121822";
        // System.out.println(Arrays.toString(b.getBytes()));
        // System.out.println(Arrays.toString(a(b)));
    };

    static byte[] a(String s) {
        byte[] ret = new byte[s.length() / 2];

        for (int i = 0; i < s.length() / 2; ++i) {
            byte var3 = Byte.parseByte(s.substring(2 * i, 2 * i + 1), 16);
            int var4 = Byte.parseByte(s.substring(2 * i + 1, 2 * i + 2), 16) | var3 << 4;
            // System.out.printf("%s,%s,%s,%s\n", i, var3, var3 << 4, var4);
            ret[i] = (byte) var4;
        }
        return ret;
    }

    static void connect() {
        try {
            Driver OracleDriver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(OracleDriver);
            // Connection connection =
            // DriverManager.getConnection("jdbc:oracle:thin:@172.26.62.201:1521:XE",
            // "system",
            // "oracle");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:49161:XE", "system",
                    "oracle");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM HR.JOBS");
            if (rs.next()) {
                String info = rs.getString("JOB_ID");
                System.out.printf("JOB_ID %s\n", info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
