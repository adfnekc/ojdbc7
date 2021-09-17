//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

public class ClientProfile extends Properties {
    private static final String profile_name = "ora-net-profile";
    private static final String shared_profile_name = "ora-shared-profile";

    public ClientProfile() {
    }

    public ClientProfile(Properties var1) {
        if (var1.containsKey("oracle.net.profile")) {
            this.put("oracle.net.profile", var1.getProperty("oracle.net.profile"));
        }

        this.put("oracle.net.authentication_services", var1.getProperty("oracle.net.authentication_services", "()"));
        this.put("oracle.net.encryption_client", var1.getProperty("oracle.net.encryption_client", "ACCEPTED"));
        this.put("oracle.net.encryption_types_client", var1.getProperty("oracle.net.encryption_types_client", "()"));
        this.put("oracle.net.crypto_checksum_client", var1.getProperty("oracle.net.crypto_checksum_client", "ACCEPTED"));
        this.put("oracle.net.crypto_checksum_types_client", var1.getProperty("oracle.net.crypto_checksum_types_client", "()"));
        this.put("oracle.net.crypto_seed", var1.getProperty("oracle.net.crypto_seed", ""));
        this.put("oracle.net.kerberos5_mutual_authentication", var1.getProperty("oracle.net.kerberos5_mutual_authentication", "false"));
        if (var1.getProperty("oracle.net.kerberos5_cc_name") != null) {
            this.put("oracle.net.kerberos5_cc_name", var1.getProperty("oracle.net.kerberos5_cc_name"));
        }

    }

    public String[] getAuthenticationServices() {
        return this.getServices((String)this.get("oracle.net.authentication_services"));
    }

    public String[] getEncryptionServices() {
        return this.getServices((String)this.get("oracle.net.encryption_types_client"));
    }

    public String[] getDataIntegrityServices() {
        return this.getServices((String)this.get("oracle.net.crypto_checksum_types_client"));
    }

    public String getEncryptionLevel() {
        return (String)this.get("oracle.net.encryption_client");
    }

    public int getEncryptionLevelNum() {
        return this.translateAnoValue(this.getEncryptionLevel());
    }

    public String getDataIntegrityLevel() {
        return (String)this.get("oracle.net.crypto_checksum_client");
    }

    public int getDataIntegrityLevelNum() {
        return this.translateAnoValue(this.getDataIntegrityLevel());
    }

    public void print() {
        System.out.println(" ----------------------------------------");
        System.out.println(" Displaying the content of ClientProfile ");
        System.out.println(" List:");
        this.list(System.out);
        Enumeration var1 = this.propertyNames();
        System.out.println("Enumeration has elements ? " + var1.hasMoreElements());

        for(int var2 = 0; var1.hasMoreElements(); ++var2) {
            String var3 = (String)var1.nextElement();
            System.out.println("Key " + var2 + " = " + var3);
            System.out.println("Value = " + this.getProperty(var3));
        }

        System.out.println(" ----------------------------------------");
    }

    private String[] getServices(String var1) {
        String var2 = this.removeParenths(var1);
        StringTokenizer var3 = new StringTokenizer(var2, ",");
        int var4 = var3.countTokens();
        String[] var5 = new String[var4];

        for(int var6 = 0; var6 < var4; ++var6) {
            var5[var6] = var3.nextToken().trim();
        }

        return var5;
    }

    private String removeParenths(String var1) {
        int var2 = var1.indexOf(40);
        int var3 = var2 == -1 ? 0 : var2 + 1;
        int var4 = var1.lastIndexOf(41);
        int var5 = var4 == -1 ? var1.length() : var4;
        String var6 = var1.substring(var3, var5);
        return var6.trim();
    }

    private int translateAnoValue(String var1) {
        byte var2 = 0;
        if (var1.equalsIgnoreCase("ACCEPTED")) {
            var2 = 0;
        } else if (var1.equalsIgnoreCase("REQUESTED")) {
            var2 = 2;
        } else if (var1.equalsIgnoreCase("REQUIRED")) {
            var2 = 3;
        } else if (var1.equalsIgnoreCase("REJECTED")) {
            var2 = 1;
        }

        return var2;
    }
}
