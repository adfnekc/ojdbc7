//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.util.ArrayList;
import java.util.Hashtable;
import oracle.net.jdbc.nl.InvalidSyntaxException;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.ns.NetException;

public class NameResolver {
    private String tnsAdmin;
    private String[] readPath;
    private Hashtable adapterHash;
    String osuser;
    String programName;
    private static final boolean DEBUG = false;
    private static final String[] DEFAULT_SEARCH_PATH = new String[]{"TNSNAMES", "HOSTNAME"};
    private static final String TNS_ADMIN_PROPERTY = "oracle.net.tns_admin";
    private static final String READ_PATH_PROPERTY = "oracle.net.names.directory_path";

    private NameResolver() {
    }

    protected NameResolver(String var1, String var2, String var3) throws NetException {
        this.tnsAdmin = var1;
        this.bootNameResolver();
        this.osuser = var2;
        this.programName = var3;
    }

    public String resolveName(String var1) throws NetException {
        if (var1 == null) {
            throw new NetException(120);
        } else {
            String var3 = var1.trim();
            if (var3.length() == 0) {
                throw new NetException(120);
            } else {
                String var4 = null;
                if (this.tnsAdmin == null) {
                    HostnameNamingAdapter var9 = new HostnameNamingAdapter(this.osuser, this.programName);
                    var4 = var9.resolve(var3);
                    return var4;
                } else {
                    NamingAdapterInterface var5 = null;

                    for(int var6 = 0; var4 == null && var6 < this.readPath.length; ++var6) {
                        var5 = (NamingAdapterInterface)this.adapterHash.get(this.readPath[var6]);

                        try {
                            var4 = var5.resolve(var3);
                        } catch (NetException var8) {
                        }
                    }

                    if (var4 == null) {
                        throw new NetException(122, "\"" + var1 + "\"");
                    } else {
                        return var4;
                    }
                }
            }
        }
    }

    private void addAdapters() {
        if (this.adapterHash == null) {
            this.adapterHash = new Hashtable();
        }

        this.adapterHash.put("TNSNAMES", new TNSNamesNamingAdapter(this.tnsAdmin));
        this.adapterHash.put("HOSTNAME", new HostnameNamingAdapter(this.osuser, this.programName));
    }

    private void bootNameResolver() throws NetException {
        if (this.tnsAdmin != null) {
            this.setReadPath();
            this.addAdapters();
        }

    }

    private boolean checkForValidAdapter(String var1) {
        int var3 = DEFAULT_SEARCH_PATH.length;

        for(int var2 = 0; var2 < var3; ++var2) {
            if (DEFAULT_SEARCH_PATH[var2].equalsIgnoreCase(var1)) {
                return true;
            }
        }

        return false;
    }

    private void setDefaultPath() {
        this.readPath = DEFAULT_SEARCH_PATH;
    }

    private void setReadPath() throws NetException {
        boolean var2 = false;
        String[] var3 = this.getUserReadPath();
        if (var3 == null) {
            this.setDefaultPath();
        } else {
            ArrayList var4 = new ArrayList();

            for(int var6 = 0; var6 < var3.length; ++var6) {
                if (this.checkForValidAdapter(var3[var6])) {
                    String var5 = var3[var6];
                    var5 = var5.toUpperCase();
                    if (!var4.contains(var5)) {
                        var4.add(var3[var6].toUpperCase());
                    }
                }
            }

            int var7 = var4.size();
            if (var7 == 0) {
                throw new NetException(121, " The Read path did not contain any valid adapters.");
            } else {
                this.readPath = new String[var7];
                var4.toArray(this.readPath);
            }
        }
    }

    private String[] getUserReadPath() throws NetException {
        Object var2 = null;
        String var3 = System.getProperty("oracle.net.names.directory_path");
        if (var3 == null) {
            return null;
        } else {
            var3 = var3.trim();
            if (var3.length() == 0) {
                return null;
            } else {
                StringBuffer var4 = new StringBuffer(var3);
                if (var4.charAt(0) == '(') {
                    var4.insert(0, "(path=").append(')');
                } else {
                    var4.insert(0, "(path=(").append("))");
                }

                String var5 = var4.toString();
                NVFactory var6 = new NVFactory();
                NVPair var7 = null;

                try {
                    var7 = var6.createNVPair(var5);
                    if (var7.getRHSType() == NVPair.RHS_LIST && var7.getListType() == NVPair.LIST_COMMASEP) {
                        int var8 = var7.getListSize();
                        String[] var9 = new String[var8];

                        for(int var10 = 0; var10 < var8; ++var10) {
                            var9[var10] = var7.getListElement(var10).getName();
                        }

                        return var9;
                    } else {
                        throw new NetException(121, " Read path specified is " + var3);
                    }
                } catch (InvalidSyntaxException var11) {
                    throw new NetException(121, " Read path specified is " + var3);
                } catch (NLException var12) {
                    throw new NetException(121, " Read path specified is " + var5);
                }
            }
        }
    }
}
