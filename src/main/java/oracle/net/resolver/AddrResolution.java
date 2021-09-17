//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.io.IOException;
import java.net.SocketException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oracle.net.jdbc.TNSAddress.SOException;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.jndi.JndiAttrs;
import oracle.net.ns.NetException;
import oracle.net.nt.ConnOption;
import oracle.net.nt.ConnStrategy;

public class AddrResolution {
    private ConnStrategy cs;
    private Properties up;
    private static final String default_proxy_rules = "__jdbc__";
    private static final String service_alias_name = "ora-net-service-alias";
    private static final String service_attr_name = "orclnetdescstring";
    private static final int length_of_alias_prefix = 6;
    public static final int DEFAULT_DATABASE_PORT = 1521;
    public static final String DEFAULT_CONNECT_PROTOCOL = "TCP";
    private boolean newSyntax = true;
    public boolean connection_revised = false;
    public boolean connection_redirected = false;
    private String TNSAddress;
    private static final Pattern pattern = Pattern.compile("(?=ldaps?://)");
    static final String ADDRESS_FORMAT = "(ADDRESS=(PROTOCOL=%s)(HOST=%s)(PORT=%s))";
    static final String CID_FORMAT = "(CID=(PROGRAM=%s)(HOST=__jdbc__)(USER=%s))";
    static final String CONNECT_DATA_FORMAT = "(CONNECT_DATA=%s%s%s)";
    static final String DESCRIPTION_FORMAT = "(DESCRIPTION=%s%s)";
    static final String DRCP_ENABLED = "(SERVER=POOLED)";
    static final String EMPTY_STRING = "";
    static final String SID_KEY = "(SID=%s)";
    static final String SERVICE_NAME_KEY = "(SERVICE_NAME=%s)";

    public AddrResolution(String var1, Properties var2) throws NetException {
        this.up = var2;
        this.TNSAddress = var1;
        if (this.up.containsKey("java.naming.provider.url") || var1.startsWith("ldap:") || var1.startsWith("ldaps:")) {
            boolean var3 = false;
            Vector var4 = null;
            if (var1.startsWith("ldap:") || var1.startsWith("ldaps:")) {
                var4 = this.computeLdapList(var1);
                if (var4.size() > 1) {
                    var3 = true;
                } else {
                    int var5;
                    if ((var5 = var1.lastIndexOf(47)) == -1) {
                        throw new NetException(124);
                    }

                    this.up.put("java.naming.provider.url", var1.substring(0, var5));
                    this.TNSAddress = var1.substring(var5 + 1, var1.length());
                }
            }

            if (!var3) {
                String[] var11 = new String[1];
                JndiAttrs var7 = new JndiAttrs(this.up);
                var11[0] = "orclnetdescstring";
                Vector var6 = null;

                try {
                    var6 = var7.getAttrs(this.TNSAddress, var11);
                } finally {
                    var7.close();
                }

                this.TNSAddress = (String)var6.firstElement();
                this.connection_revised = true;
            } else {
                this.processLdapFailoverLoadblance(var4);
            }
        }

        if (this.up.getProperty("oracle.net.oldSyntax") == "YES") {
            this.newSyntax = false;
        }

    }

    private Vector<String> computeLdapList(String var1) {
        String[] var2 = pattern.split(var1);
        int var3 = 0;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            var2[var4] = var2[var4].trim();
            if (var2[var4].length() != 0) {
                ++var3;
            }
        }

        Vector var6 = new Vector(var3);

        for(int var5 = 0; var5 < var2.length; ++var5) {
            if (var2[var5].length() != 0) {
                var6.add(var2[var5]);
            }
        }

        return var6;
    }

    private void processLdapFailoverLoadblance(Vector<String> var1) throws NetException {
        boolean var2 = false;
        if (var1.size() <= 1) {
            throw new NetException(124);
        } else {
            boolean var5 = true;
            boolean var6 = true;
            String var7;
            if ((var7 = this.up.getProperty("oracle.net.ldap_failover")) != null && (var7.equalsIgnoreCase("OFF") || var7.equalsIgnoreCase("FALSE") || var7.equalsIgnoreCase("NO"))) {
                var5 = false;
            }

            if ((var7 = this.up.getProperty("oracle.net.ldap_loadbalance")) != null && (var7.equalsIgnoreCase("OFF") || var7.equalsIgnoreCase("FALSE") || var7.equalsIgnoreCase("NO"))) {
                var6 = false;
            }

            if (var1.size() > 1) {
                var1 = NavDescriptionList.setActiveChildren(var1, var5, var6);
            }

            StringBuilder var9 = new StringBuilder();
            int var10 = var1.size();
            Hashtable var11 = new Hashtable(var10);

            String var13;
            String var14;
            for(int var12 = 0; var12 < var10; ++var12) {
                String var4 = (String)var1.elementAt(var12);
                int var15;
                if ((var15 = var4.lastIndexOf(47)) == -1) {
                    throw new NetException(124);
                }

                var13 = var4.substring(0, var15);
                var14 = var4.substring(var15 + 1, var4.length());
                var9.append(var13);
                if (var12 < var10 - 1) {
                    var9.append(' ');
                }

                var11.put(var13.substring(var13.indexOf(47)), var14);
            }

            String var8 = new String(var9);
            this.up.put("java.naming.provider.url", var8);
            JndiAttrs var19 = new JndiAttrs(this.up);
            var13 = var19.getLdapUrlUsed();
            this.TNSAddress = (String)var11.get(var13.substring(var13.indexOf(47)));
            var14 = null;
            String[] var21 = new String[]{"orclnetdescstring"};

            Vector var20;
            try {
                var20 = var19.getAttrs(this.TNSAddress, var21);
            } finally {
                var19.close();
            }

            this.TNSAddress = (String)var20.firstElement();
            this.connection_revised = true;
        }
    }

    public String getTNSAddress() {
        return this.TNSAddress.toUpperCase();
    }

    public ConnOption resolveAndExecute(String var1) throws NetException, IOException {
        ConnStrategy var2 = this.cs;
        if (var1 != null) {
            this.cs = new ConnStrategy(this.up);
            if (this.connection_redirected) {
                this.cs.sdu = var2.sdu;
                this.cs.tdu = var2.tdu;
                this.cs.retryCount = var2.retryCount;
                this.cs.socketOptions = var2.socketOptions;
                this.cs.reuseOpt = true;
            }

            if (var1.indexOf(41) == -1) {
                var1 = var1.trim();
                if (!var1.startsWith("//") && !var1.matches("[\\w]*") && !var1.matches("[\\[[\\w:]*\\]]") && !var1.matches("[[\\w-]\\.]*:[\\d]*/[[\\w\\$\\#]\\.]*(?i)(:pooled)?(?-i)")) {
                    this.TNSAddress = this.resolveSimple(var1);
                } else {
                    String var3 = System.getProperty("oracle.net.tns_admin");
                    NameResolver var4 = NameResolverFactory.getNameResolver(var3, this.cs.getOSUsername(), this.cs.getProgramName());
                    var1 = var1.replaceAll("#", "\\\\#");
                    if (this.up.containsKey("oracle.jdbc.targetInstanceName")) {
                        this.TNSAddress = this.appendInstanceName(var4.resolveName(var1), this.up.getProperty("oracle.jdbc.targetInstanceName"));
                    } else {
                        this.TNSAddress = var4.resolveName(var1);
                    }

                    this.resolveAddrTree(this.TNSAddress);
                }
            } else if (this.newSyntax) {
                if (this.up.containsKey("oracle.jdbc.targetInstanceName")) {
                    var1 = this.appendInstanceName(var1, this.up.getProperty("oracle.jdbc.targetInstanceName"));
                }

                this.resolveAddrTree(var1);
            } else {
                this.resolveAddr(var1);
            }
        } else if (this.cs == null || !this.cs.hasMoreOptions()) {
            return null;
        }

        return this.cs.execute();
    }

    private String resolveSimple(String var1) throws NetException {
        ConnOption var2 = new ConnOption();
        boolean var3 = false;
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        int var7 = 0;
        boolean var8 = false;
        boolean var9 = false;
        if (var1.startsWith("[")) {
            var7 = var1.indexOf(93);
            if (var7 == -1) {
                throw new NetException(115);
            }

            var8 = true;
        }

        int var12;
        int var13;
        if ((var12 = var1.indexOf(58, var7)) != -1 && (var13 = var1.indexOf(58, var12 + 1)) != -1) {
            int var14 = var1.indexOf(58, var13 + 1);
            if (var14 != -1 && var1.length() > var14 + 6) {
                String var10 = var1.substring(var14 + 1);
                var9 = "POOLED".equalsIgnoreCase(var10);
                if (var9) {
                    var2.sid = var1.substring(var13 + 1, var14);
                    var14 = var1.indexOf(58, var14 + 1);
                } else {
                    var2.sid = var1.substring(var13 + 1);
                }
            } else {
                var2.sid = var1.substring(var13 + 1);
            }

            if (var14 != -1) {
                throw new NetException(115);
            } else {
                try {
                    if (var8) {
                        var2.host = var1.substring(1, var12 - 1);
                    } else {
                        var2.host = var1.substring(0, var12);
                    }

                    var2.port = Integer.parseInt(var1.substring(var12 + 1, var13));
                    var2.addr = String.format("(ADDRESS=(PROTOCOL=%s)(HOST=%s)(PORT=%s))", "TCP", var2.host, var2.port);
                    var2.conn_data.append(String.format("(DESCRIPTION=%s%s)", String.format("(CONNECT_DATA=%s%s%s)", String.format("(SID=%s)", var2.sid), var9 ? "(SERVER=POOLED)" : "", String.format("(CID=(PROGRAM=%s)(HOST=__jdbc__)(USER=%s))", this.cs.getProgramName(), this.cs.getOSUsername())), var2.addr));
                    var2.protocol = "TCP";
                    this.cs.addOption(var2);
                    return String.format("(DESCRIPTION=%s%s)", String.format("(CONNECT_DATA=%s%s%s)", String.format("(SID=%s)", var2.sid), var9 ? "(SERVER=POOLED)" : "", ""), var2.addr);
                } catch (NumberFormatException var11) {
                    throw new NetException(116);
                }
            }
        } else {
            throw new NetException(115);
        }
    }

    private void resolveAddr(String var1) throws NetException {
        if (var1.startsWith("alias=")) {
            var1 = var1.substring(var1.indexOf("alias=") + 6, var1.length());
        }

        ConnOption var2 = new ConnOption();
        NVFactory var3 = new NVFactory();
        NVNavigator var4 = new NVNavigator();
        Object var5 = null;
        NVPair var6 = null;

        try {
            var4.findNVPairRecurse(var3.createNVPair(var1), "CID");
            var6 = var4.findNVPairRecurse(var3.createNVPair(var1), "address");
        } catch (NLException var11) {
            System.err.println(var11.getMessage());
        }

        NVPair var7 = var4.findNVPair(var6, "protocol");
        if (var7 == null) {
            throw new NetException(100);
        } else {
            var2.protocol = var7.getAtom();
            if (!var2.protocol.equals("TCP") && !var2.protocol.equals("tcp") && !var2.protocol.equals("SSL") && !var2.protocol.equals("ssl") && !var2.protocol.equals("ANO") && !var2.protocol.equals("ano")) {
                throw new NetException(102);
            } else {
                var7 = var4.findNVPair(var6, "Host");
                if (var7 == null) {
                    throw new NetException(103);
                } else {
                    var2.host = var7.getAtom();
                    var7 = var4.findNVPair(var6, "Port");
                    if (var7 == null) {
                        throw new NetException(104);
                    } else {
                        var2.port = Integer.parseInt(var7.getAtom());
                        var7 = var4.findNVPair(var6, "sduSize");
                        if (var7 != null) {
                            var2.sdu = Integer.parseInt(var7.getAtom());
                        }

                        var7 = var4.findNVPair(var6, "tduSize");
                        if (var7 != null) {
                            var2.tdu = Integer.parseInt(var7.getAtom());
                        }

                        NVPair var8 = null;

                        try {
                            var8 = var4.findNVPairRecurse(var3.createNVPair(var1), "connect_data");
                        } catch (NLException var10) {
                            System.err.println(var10.getMessage());
                        }

                        var2.conn_data = var8 != null ? this.insertCID(var1) : new StringBuilder(var1);
                        var2.addr = String.format("(ADDRESS=(PROTOCOL=%s)(HOST=%s)(PORT=%s))", "TCP", var2.host, var2.port);
                        this.cs.addOption(var2);
                    }
                }
            }
        }
    }

    private void resolveAddrTree(String var1) throws NetException {
        NavSchemaObjectFactory var2 = new NavSchemaObjectFactory();
        NavServiceAlias var3 = (NavServiceAlias)var2.create(4);

        try {
            String var4 = var1.startsWith("alias=") ? var1 : "alias=" + var1;
            var3.initFromString(var4);
        } catch (NLException var5) {
            throw new NetException(501);
        } catch (SOException var6) {
            throw new NetException(502, var6.getMessage());
        }

        var3.navigate(this.cs, (StringBuffer)null);
    }

    private StringBuilder insertCID(String var1) throws NetException {
        NVFactory var2 = new NVFactory();
        NVNavigator var3 = new NVNavigator();
        StringBuilder var4 = new StringBuilder(2048);
        Object var5 = null;
        NVPair var6 = null;
        NVPair var7 = null;
        NVPair var8 = null;
        NVPair var9 = null;

        try {
            var3.findNVPairRecurse(var2.createNVPair(var1), "description");
            var6 = var3.findNVPairRecurse(var2.createNVPair(var1), "address_list");
            var7 = var3.findNVPairRecurse(var2.createNVPair(var1), "address");
            var8 = var3.findNVPairRecurse(var2.createNVPair(var1), "connect_data");
            var9 = var3.findNVPairRecurse(var2.createNVPair(var1), "source_route");
        } catch (NLException var16) {
            System.err.println(var16.getMessage());
        }

        NVPair var10 = null;
        Object var11 = null;
        NVPair var12 = null;
        NVPair var13 = null;
        if (var8 != null) {
            var10 = var3.findNVPair(var8, "SID");
            var3.findNVPair(var8, "CID");
            var12 = var3.findNVPair(var8, "SERVICE_NAME");
            var13 = var3.findNVPair(var8, "SERVER");
            if (var10 == null && var12 == null) {
                throw new NetException(106);
            } else {
                var4.append("(DESCRIPTION=");
                if (var6 != null && var6.getListSize() > 0) {
                    for(int var15 = 0; var15 < var6.getListSize(); ++var15) {
                        NVPair var14 = var6.getListElement(var15);
                        var4.append(var14.toString());
                    }
                } else {
                    if (var7 == null) {
                        throw new NetException(107);
                    }

                    var4.append(var7.toString());
                }

                var4.append(String.format("(CONNECT_DATA=%s%s%s)", (var12 != null ? var12 : var10).toString(), var13 != null ? var13.toString() : "", this.cs.getProgramName(), this.cs.getOSUsername()));
                if (var9 != null) {
                    var4.append(var9.toString());
                }

                var4.append(")");
                return var4;
            }
        } else {
            throw new NetException(105);
        }
    }

    public Properties getUp() {
        return this.up;
    }

    public boolean isConnectionSocketKeepAlive() throws SocketException {
        return this.cs.isConnectionSocketKeepAlive();
    }

    private String appendInstanceName(String var1, String var2) {
        Pattern var3 = Pattern.compile("CONNECT_DATA=([^)]+)\\)", 2);
        Matcher var4 = var3.matcher(var1);
        StringBuffer var5 = new StringBuffer();

        for(boolean var6 = var4.find(); var6; var6 = var4.find()) {
            var4.appendReplacement(var5, var4.group() + "(INSTANCE_NAME=" + var2 + ")");
        }

        var4.appendTail(var5);
        return var5.toString();
    }
}
