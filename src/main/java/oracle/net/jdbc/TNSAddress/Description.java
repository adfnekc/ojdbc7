//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.TNSAddress;

import java.util.Vector;
import oracle.net.jdbc.nl.InvalidSyntaxException;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVPair;

public class Description implements SchemaObject {
    public Vector children = new Vector();
    private SchemaObject child;
    private NVPair childnv;
    protected SchemaObjectFactoryInterface f = null;
    public boolean sourceRoute = false;
    public boolean loadBalance = false;
    public boolean failover = true;
    public boolean keepAlive = false;
    public String SDU;
    public String TDU;
    public Vector protocolStacks = new Vector();
    public String sendBufSize;
    public String receiveBufSize;
    public String connectData;
    public String SID;
    public String server;
    public String failoverMode;
    public String instanceRole;
    public String serviceName;
    public String instanceName;
    public String handlerName;
    public String oracleHome;
    public String connectTimeout;
    public String retryCount;
    public String authTypes;
    public String sslServerCertDN;
    public Vector authParams = new Vector();
    public Vector extraConnInfo = new Vector();
    public Vector extraInfo = new Vector();

    public Description(SchemaObjectFactoryInterface var1) {
        this.f = var1;
    }

    public int isA() {
        return 2;
    }

    public String isA_String() {
        return "DESCRIPTION";
    }

    public void initFromString(String var1) throws NLException, SOException {
        NVPair var2 = (new NVFactory()).createNVPair(var1);
        this.initFromNVPair(var2);
    }

    public void initFromNVPair(NVPair var1) throws SOException {
        this.init();
        int var2 = var1.getListSize();
        if (var2 == 0) {
            throw new SOException();
        } else {
            for(int var3 = 0; var3 < var2; ++var3) {
                this.childnv = var1.getListElement(var3);
                if (this.childnv.getName().equalsIgnoreCase("SOURCE_ROUTE")) {
                    this.sourceRoute = this.childnv.getAtom().equalsIgnoreCase("yes") || this.childnv.getAtom().equalsIgnoreCase("on") || this.childnv.getAtom().equalsIgnoreCase("true");
                } else if (this.childnv.getName().equalsIgnoreCase("LOAD_BALANCE")) {
                    this.loadBalance = this.childnv.getAtom().equalsIgnoreCase("yes") || this.childnv.getAtom().equalsIgnoreCase("on") || this.childnv.getAtom().equalsIgnoreCase("true");
                } else if (!this.childnv.getName().equalsIgnoreCase("FAILOVER")) {
                    if (this.childnv.getName().equalsIgnoreCase("ENABLE")) {
                        this.keepAlive = this.childnv.getAtom().equalsIgnoreCase("broken");
                    } else if (this.childnv.getName().equalsIgnoreCase("PROTOCOL_STACK")) {
                        this.protocolStacks.addElement(this.childnv.toString());
                    } else {
                        SchemaObjectFactoryInterface var10002;
                        if (this.childnv.getName().equalsIgnoreCase("ADDRESS")) {
                            var10002 = this.f;
                            this.child = this.f.create(0);
                            this.child.initFromNVPair(this.childnv);
                            this.children.addElement(this.child);
                        } else if (this.childnv.getName().equalsIgnoreCase("ADDRESS_LIST")) {
                            var10002 = this.f;
                            this.child = this.f.create(1);
                            this.child.initFromNVPair(this.childnv);
                            this.children.addElement(this.child);
                        } else if (this.childnv.getName().equalsIgnoreCase("SDU")) {
                            this.SDU = this.childnv.getAtom();
                        } else if (this.childnv.getName().equalsIgnoreCase("TDU")) {
                            this.TDU = this.childnv.getAtom();
                        } else if (this.childnv.getName().equalsIgnoreCase("SEND_BUF_SIZE")) {
                            this.sendBufSize = this.childnv.getAtom();
                        } else if (this.childnv.getName().equalsIgnoreCase("RECV_BUF_SIZE")) {
                            this.receiveBufSize = this.childnv.getAtom();
                        } else {
                            int var5;
                            NVPair var6;
                            int var9;
                            if (this.childnv.getName().equalsIgnoreCase("CONNECT_DATA")) {
                                this.connectData = this.childnv.valueToString();
                                var9 = this.childnv.getListSize();
                                if (var9 == 0) {
                                    throw new SOException();
                                }

                                for(var5 = 0; var5 < var9; ++var5) {
                                    var6 = this.childnv.getListElement(var5);
                                    if (var6.getName().equalsIgnoreCase("SID")) {
                                        this.SID = var6.getAtom();
                                    } else if (var6.getName().equalsIgnoreCase("SERVER")) {
                                        this.server = var6.getAtom();
                                    } else if (var6.getName().equalsIgnoreCase("SERVICE_NAME")) {
                                        this.serviceName = var6.getAtom();
                                    } else if (var6.getName().equalsIgnoreCase("INSTANCE_NAME")) {
                                        this.instanceName = var6.getAtom();
                                    } else if (var6.getName().equalsIgnoreCase("HANDLER_NAME")) {
                                        this.handlerName = var6.getAtom();
                                    } else if (var6.getName().equalsIgnoreCase("ORACLE_HOME")) {
                                        this.oracleHome = var6.getAtom();
                                    } else if (var6.getName().equalsIgnoreCase("FAILOVER_MODE")) {
                                        this.failoverMode = this.childnv.getListElement(var5).toString();
                                    } else if (var6.getName().equalsIgnoreCase("INSTANCE_ROLE")) {
                                        this.instanceRole = var6.getAtom();
                                    } else {
                                        String var7 = var6.toString().trim();
                                        var7 = var7.substring(1, var7.length() - 1);
                                        this.extraConnInfo.addElement(var7);
                                    }
                                }
                            } else if (this.childnv.getName().equalsIgnoreCase("SECURITY")) {
                                var9 = this.childnv.getListSize();
                                if (var9 == 0) {
                                    throw new SOException();
                                }

                                for(var5 = 0; var5 < var9; ++var5) {
                                    var6 = this.childnv.getListElement(var5);
                                    if (var6.getName().equalsIgnoreCase("AUTHENTICATION")) {
                                        this.authTypes = var6.toString();
                                    }

                                    if (var6.getName().equalsIgnoreCase("ssl_server_cert_dn")) {
                                        this.sslServerCertDN = var6.getAtom();
                                        if (this.sslServerCertDN != null && this.sslServerCertDN.startsWith("\"") && this.sslServerCertDN.endsWith("\"")) {
                                            this.sslServerCertDN = this.sslServerCertDN.substring(1, this.sslServerCertDN.length() - 1);
                                        }
                                    } else {
                                        this.authParams.addElement(var6.toString());
                                    }
                                }
                            } else if (this.childnv.getName().equalsIgnoreCase("CONNECT_TIMEOUT")) {
                                this.connectTimeout = this.childnv.getAtom();
                            } else if (this.childnv.getName().equalsIgnoreCase("RETRY_COUNT")) {
                                this.retryCount = this.childnv.getAtom();
                            } else {
                                if (this.childnv.getName().equalsIgnoreCase("HS") && this.childnv.getAtom() == null) {
                                    try {
                                        this.childnv.setAtom("OK");
                                    } catch (InvalidSyntaxException var8) {
                                    }
                                }

                                String var4 = this.childnv.toString().trim();
                                var4 = var4.substring(1, var4.length() - 1);
                                this.extraInfo.addElement(var4);
                            }
                        }
                    }
                } else {
                    this.failover = this.childnv.getAtom().equalsIgnoreCase("yes") || this.childnv.getAtom().equalsIgnoreCase("on") || this.childnv.getAtom().equalsIgnoreCase("true");
                }
            }

        }
    }

    public String toString() {
        String var1 = new String("");
        new String("");

        int var3;
        for(var3 = 0; var3 < this.children.size(); ++var3) {
            String var2 = ((SchemaObject)this.children.elementAt(var3)).toString();
            if (!var2.equals("")) {
                var1 = var1 + var2;
            }
        }

        if (!var1.equals("") && this.sourceRoute) {
            var1 = var1 + "(SOURCE_ROUTE=yes)";
        }

        if (!var1.equals("") && this.loadBalance) {
            var1 = var1 + "(LOAD_BALANCE=yes)";
        }

        if (!var1.equals("") && !this.failover) {
            var1 = var1 + "(FAILOVER=false)";
        }

        if (this.keepAlive) {
            var1 = var1 + "(ENABLE=broken)";
        }

        if (this.SDU != null) {
            var1 = var1 + "(SDU=" + this.SDU + ")";
        }

        if (this.TDU != null) {
            var1 = var1 + "(TDU=" + this.TDU + ")";
        }

        if (this.sendBufSize != null) {
            var1 = var1 + "(SEND_BUF_SIZE=" + this.sendBufSize + ")";
        }

        if (this.receiveBufSize != null) {
            var1 = var1 + "(RECV_BUF_SIZE=" + this.receiveBufSize + ")";
        }

        if (this.protocolStacks.size() != 0) {
            for(var3 = 0; var3 < this.protocolStacks.size(); ++var3) {
                var1 = var1 + (String)this.protocolStacks.elementAt(var3);
            }
        }

        if (this.SID != null || this.server != null || this.serviceName != null || this.instanceName != null || this.handlerName != null || this.extraConnInfo.size() != 0 || this.oracleHome != null) {
            var1 = var1 + "(CONNECT_DATA=";
            if (this.SID != null) {
                var1 = var1 + "(SID=" + this.SID + ")";
            }

            if (this.server != null) {
                var1 = var1 + "(SERVER=" + this.server + ")";
            }

            if (this.serviceName != null) {
                var1 = var1 + "(SERVICE_NAME=" + this.serviceName + ")";
            }

            if (this.instanceName != null) {
                var1 = var1 + "(INSTANCE_NAME=" + this.instanceName + ")";
            }

            if (this.handlerName != null) {
                var1 = var1 + "(HANDLER_NAME=" + this.handlerName + ")";
            }

            if (this.oracleHome != null) {
                var1 = var1 + "(ORACLE_HOME=" + this.oracleHome + ")";
            }

            if (this.instanceRole != null) {
                var1 = var1 + "(INSTANCE_ROLE=" + this.instanceRole + ")";
            }

            if (this.failoverMode != null) {
                var1 = var1 + this.failoverMode;
            }

            for(var3 = 0; var3 < this.extraConnInfo.size(); ++var3) {
                var1 = var1 + "(" + (String)this.extraConnInfo.elementAt(var3) + ")";
            }

            var1 = var1 + ")";
        }

        if (this.authTypes != null || this.authParams.size() != 0) {
            var1 = var1 + "(SECURITY=";
            if (this.authTypes != null) {
                var1 = var1 + "(AUTHENTICATION=" + this.authTypes + ")";
            }

            for(var3 = 0; var3 < this.authParams.size(); ++var3) {
                var1 = var1 + (String)this.authParams.elementAt(var3);
            }

            var1 = var1 + ")";
        }

        for(var3 = 0; var3 < this.extraInfo.size(); ++var3) {
            var1 = var1 + "(" + (String)this.extraInfo.elementAt(var3) + ")";
        }

        if (!var1.equals("")) {
            var1 = "(DESCRIPTION=" + var1 + ")";
        }

        return var1;
    }

    protected void init() {
        this.children.removeAllElements();
        this.child = null;
        this.childnv = null;
        this.sourceRoute = false;
        this.loadBalance = false;
        this.failover = true;
        this.keepAlive = false;
        this.protocolStacks.removeAllElements();
        this.SDU = null;
        this.TDU = null;
        this.SID = null;
        this.server = null;
        this.serviceName = null;
        this.instanceName = null;
        this.handlerName = null;
        this.oracleHome = null;
        this.authTypes = null;
        this.sendBufSize = null;
        this.receiveBufSize = null;
        this.failoverMode = null;
        this.instanceRole = null;
        this.authParams.removeAllElements();
        this.extraConnInfo.removeAllElements();
        this.extraInfo.removeAllElements();
    }
}
