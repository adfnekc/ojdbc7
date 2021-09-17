//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jndi;

import java.util.Properties;
import java.util.Vector;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import oracle.net.ns.NetException;

public class JndiAttrs {
    private Properties env;
    private static final String nFactory = "java.naming.factory.initial";
    private static final String nProvider = "java.naming.provider.url";
    private static final String nProfile = "ora-net-profile";
    private static final String default_nFactory = "com.sun.jndi.ldap.LdapCtxFactory";
    private static final String ldap_read_timeout = "com.sun.jndi.ldap.read.timeout";
    private static final String ldap_connect_timeout = "com.sun.jndi.ldap.connect.timeout";
    DirContext ctx;

    public JndiAttrs(Properties var1) throws NetException {
        String var2 = null;
        this.env = new Properties();
        if (var1.containsKey("java.naming.factory.initial")) {
            this.env.put("java.naming.factory.initial", var1.getProperty("java.naming.factory.initial"));
        } else {
            this.env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        }

        if (var1.containsKey("java.naming.provider.url")) {
            var2 = var1.getProperty("java.naming.provider.url");
            if (var2.startsWith("ldaps")) {
                this.env.put("java.naming.ldap.factory.socket", "oracle.net.jndi.CustomSSLSocketFactory");
                this.env.put("java.naming.security.protocol", "ssl");
                var2 = "ldap:" + var2.substring(6);
            }

            this.env.put("java.naming.provider.url", var2);
        }

        if (var1.containsKey("oracle.net.profile")) {
            this.env.put("ora-net-profile", var1.getProperty("oracle.net.profile"));
        }

        try {
            Class var3 = Class.forName("javax.naming.directory.InitialDirContext");
            if (this.env.get("java.naming.factory.initial") == null) {
                this.env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
            }

            if (this.env.get("java.naming.provider.url") == null) {
                this.env.put("java.naming.provider.url", var2);
            }
        } catch (Exception var10) {
            throw new NetException(110, var10.toString());
        }

        if (var1.containsKey("com.sun.jndi.ldap.connect.timeout")) {
            this.env.put("com.sun.jndi.ldap.connect.timeout", var1.getProperty("com.sun.jndi.ldap.connect.timeout"));
        }

        if (var1.containsKey("com.sun.jndi.ldap.read.timeout")) {
            this.env.put("com.sun.jndi.ldap.read.timeout", var1.getProperty("com.sun.jndi.ldap.read.timeout"));
        }

        Object var11;
        if ((var11 = var1.get("java.naming.security.authentication")) != null) {
            this.env.put("java.naming.security.authentication", var11);
        }

        if ((var11 = var1.get("java.naming.security.principal")) != null) {
            this.env.put("java.naming.security.principal", var11);
        }

        if ((var11 = var1.get("java.naming.security.credentials")) != null) {
            this.env.put("java.naming.security.credentials", var11);
        }

        int var4 = 0;

        while(var4 < 3) {
            try {
                this.ctx = new InitialDirContext(this.env);
                break;
            } catch (NamingException var9) {
                Class var6 = null;

                try {
                    var6 = Class.forName("javax.net.ssl.SSLException");
                } catch (Exception var8) {
                    throw new NetException(108, var9.toString());
                }

                if (!var6.isInstance(var9.getRootCause()) || var4 >= 3) {
                    throw new NetException(108, var9.toString());
                }

                ++var4;
            }
        }

    }

    public Vector getProfileAttrs(String var1) throws NetException {
        String var2 = "cn=";
        Attributes var3 = null;

        try {
            var2 = var2.concat(var1);
            var3 = this.ctx.getAttributes(var2);
        } catch (NamingException var5) {
            throw new NetException(108, var5.toString());
        }

        return this.setAttrs(var3);
    }

    public Vector getAttrs(String var1, String[] var2) throws NetException {
        String var3 = "cn=";
        Attributes var4 = null;

        try {
            if (!var1.startsWith(var3)) {
                var3 = var3.concat(var1);
            } else {
                var3 = var1;
            }

            var4 = this.ctx.getAttributes(var3, var2);
        } catch (NamingException var6) {
            throw new NetException(108, var6.toString());
        }

        return this.setAttrs(var4);
    }

    private Vector setAttrs(Attributes var1) throws NetException {
        Vector var2 = new Vector(1, 1);
        if (var1 == null) {
            System.out.println("No attributes");
        } else {
            try {
                NamingEnumeration var3 = var1.getAll();

                while(var3 != null && var3.hasMoreElements()) {
                    Attribute var4 = (Attribute)var3.next();
                    NamingEnumeration var5 = var4.getAll();

                    while(var5.hasMoreElements()) {
                        var2.addElement(var5.nextElement());
                    }
                }
            } catch (NamingException var6) {
                throw new NetException(108, var6.toString());
            }
        }

        return var2;
    }

    public void setEnv(String var1, String var2) {
        this.env.put(var1, var2);
    }

    public void close() throws NetException {
        try {
            if (null != this.ctx) {
                this.ctx.close();
            }

        } catch (NamingException var2) {
            throw new NetException(108, var2.toString());
        }
    }

    public final String getLdapUrlUsed() throws NetException {
        String var1 = null;

        try {
            var1 = (String)((String)this.ctx.getEnvironment().get("java.naming.provider.url"));
            return var1;
        } catch (NamingException var3) {
            throw new NetException(108, var3.toString());
        }
    }
}
