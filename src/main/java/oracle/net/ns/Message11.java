//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Message11 implements Message, Serializable {
    private static final boolean DEBUG = false;
    private String msg;
    private transient ResourceBundle rBundle;
    private static final String messageFile = "oracle.net.mesg.Message";

    public Message11() {
    }

    public String getMessage(int var1, String var2) {
        try {
            this.rBundle = ResourceBundle.getBundle("oracle.net.mesg.Message");
        } catch (Exception var5) {
            return "Message file 'oracle.net.mesg.Message' is missing.";
        }

        try {
            this.msg = this.number2string(var1, var2);
        } catch (MissingResourceException var4) {
            this.msg = "Undefined Error";
        }

        return this.msg;
    }

    private String number2string(int var1, String var2) throws MissingResourceException {
        String var3 = null;
        String var4 = var2 == null ? "" : " " + var2;
        if (var1 <= 12000) {
            switch(var1) {
                case 0:
                    var3 = this.rBundle.getString("GOT_MINUS_ONE") + var4;
                    break;
                case 1:
                    var3 = this.rBundle.getString("ASSERTION_FAILED") + var4;
                    break;
                case 20:
                    var3 = this.rBundle.getString("NT_CONNECTION_FAILED") + var4;
                    break;
                case 21:
                    var3 = this.rBundle.getString("INVALID_NT_ADAPTER") + var4;
                    break;
                case 100:
                    var3 = this.rBundle.getString("PROTOCOL_NOT_SPECIFIED") + var4;
                    break;
                case 101:
                    var3 = this.rBundle.getString("CSTRING_PARSING") + var4;
                    break;
                case 102:
                    var3 = this.rBundle.getString("INVALID_CONNECT_DATA") + var4;
                    break;
                case 103:
                    var3 = this.rBundle.getString("HOSTNAME_NOT_SPECIFIED") + var4;
                    break;
                case 104:
                    var3 = this.rBundle.getString("PORT_NOT_SPECIFIED") + var4;
                    break;
                case 105:
                    var3 = this.rBundle.getString("CONNECT_DATA_MISSING") + var4;
                    break;
                case 106:
                    var3 = this.rBundle.getString("SID_INFORMATION_MISSING") + var4;
                    break;
                case 107:
                    var3 = this.rBundle.getString("ADDRESS_NOT_DEFINED") + var4;
                    break;
                case 108:
                    var3 = this.rBundle.getString("JNDI_THREW_EXCEPTION") + var4;
                    break;
                case 109:
                    var3 = this.rBundle.getString("JNDI_NOT_INITIALIZED") + var4;
                    break;
                case 110:
                    var3 = this.rBundle.getString("JNDI_CLASSES_NOT_FOUND") + var4;
                    break;
                case 111:
                    var3 = this.rBundle.getString("USER_PROPERTIES_NOT_DEFINED") + var4;
                    break;
                case 112:
                    var3 = this.rBundle.getString("NAMING_FACTORY_NOT_DEFINED") + var4;
                    break;
                case 113:
                    var3 = this.rBundle.getString("NAMING_PROVIDER_NOT_DEFINED") + var4;
                    break;
                case 114:
                    var3 = this.rBundle.getString("PROFILE_NAME_NOT_DEFINED") + var4;
                    break;
                case 115:
                    var3 = this.rBundle.getString("HOST_PORT_SID_EXPECTED") + var4;
                    break;
                case 116:
                    var3 = this.rBundle.getString("PORT_NUMBER_ERROR") + var4;
                    break;
                case 117:
                    var3 = this.rBundle.getString("EZ_CONNECT_FORMAT_EXPECTED") + var4;
                    break;
                case 118:
                    var3 = this.rBundle.getString("EZ_CONNECT_UNKNOWN_HOST") + var4;
                    break;
                case 119:
                    var3 = this.rBundle.getString("TNS_ADMIN_EMPTY") + var4;
                    break;
                case 120:
                    var3 = this.rBundle.getString("CONNECT_STRING_EMPTY") + var4;
                    break;
                case 121:
                    var3 = this.rBundle.getString("INVALID_READ_PATH") + var4;
                    break;
                case 122:
                    var3 = this.rBundle.getString("NAMELOOKUP_FAILED") + var4;
                    break;
                case 123:
                    var3 = this.rBundle.getString("NAMELOOKUP_FILE_ERROR") + var4;
                    break;
                case 124:
                    var3 = this.rBundle.getString("INVALID_LDAP_URL") + var4;
                    break;
                case 200:
                    var3 = this.rBundle.getString("NOT_CONNECTED") + var4;
                    break;
                case 201:
                    var3 = this.rBundle.getString("CONNECTED_ALREADY") + var4;
                    break;
                case 202:
                    var3 = this.rBundle.getString("DATA_EOF") + var4;
                    break;
                case 203:
                    var3 = this.rBundle.getString("SDU_MISMATCH") + var4;
                    break;
                case 204:
                    var3 = this.rBundle.getString("BAD_PKT_TYPE") + var4;
                    break;
                case 205:
                    var3 = this.rBundle.getString("UNEXPECTED_PKT") + var4;
                    break;
                case 206:
                    var3 = this.rBundle.getString("REFUSED_CONNECT") + var4;
                    break;
                case 207:
                    var3 = this.rBundle.getString("INVALID_PKT_LENGTH") + var4;
                    break;
                case 208:
                    var3 = this.rBundle.getString("CONNECTION_STRING_NULL") + var4;
                    break;
                case 300:
                    var3 = this.rBundle.getString("FAILED_TO_TURN_ENCRYPTION_ON") + var4;
                    break;
                case 301:
                    var3 = this.rBundle.getString("WRONG_BYTES_IN_NAPACKET") + var4;
                    break;
                case 302:
                    var3 = this.rBundle.getString("WRONG_MAGIC_NUMBER") + var4;
                    break;
                case 303:
                    var3 = this.rBundle.getString("UNKNOWN_ALGORITHM_12649") + var4;
                    break;
                case 304:
                    var3 = this.rBundle.getString("INVALID_ENCRYPTION_PARAMETER") + var4;
                    break;
                case 305:
                    var3 = this.rBundle.getString("WRONG_SERVICE_SUBPACKETS") + var4;
                    break;
                case 306:
                    var3 = this.rBundle.getString("SUPERVISOR_STATUS_FAILURE") + var4;
                    break;
                case 307:
                    var3 = this.rBundle.getString("AUTHENTICATION_STATUS_FAILURE") + var4;
                    break;
                case 308:
                    var3 = this.rBundle.getString("SERVICE_CLASSES_NOT_INSTALLED") + var4;
                    break;
                case 309:
                    var3 = this.rBundle.getString("INVALID_DRIVER") + var4;
                    break;
                case 310:
                    var3 = this.rBundle.getString("ARRAY_HEADER_ERROR") + var4;
                    break;
                case 311:
                    var3 = this.rBundle.getString("RECEIVED_UNEXPECTED_LENGTH_FOR_TYPE") + var4;
                    break;
                case 312:
                    var3 = this.rBundle.getString("INVALID_NA_PACKET_TYPE_LENGTH") + var4;
                    break;
                case 313:
                    var3 = this.rBundle.getString("INVALID_NA_PACKET_TYPE") + var4;
                    break;
                case 314:
                    var3 = this.rBundle.getString("UNEXPECTED_NA_PACKET_TYPE_RECEIVED") + var4;
                    break;
                case 315:
                    var3 = this.rBundle.getString("UNKNOWN_ENC_OR_DATAINT_ALGORITHM") + var4;
                    break;
                case 316:
                    var3 = this.rBundle.getString("INVALID_ENCRYPTION_ALGORITHM_FROM_SERVER") + var4;
                    break;
                case 317:
                    var3 = this.rBundle.getString("ENCRYPTION_CLASS_NOT_INSTALLED") + var4;
                    break;
                case 318:
                    var3 = this.rBundle.getString("DATAINTEGRITY_CLASS_NOT_INSTALLED") + var4;
                    break;
                case 319:
                    var3 = this.rBundle.getString("INVALID_DATAINTEGRITY_ALGORITHM_FROM_SERVER") + var4;
                    break;
                case 320:
                    var3 = this.rBundle.getString("INVALID_SERVICES_FROM_SERVER") + var4;
                    break;
                case 321:
                    var3 = this.rBundle.getString("INCOMPLETE_SERVICES_FROM_SERVER") + var4;
                    break;
                case 322:
                    var3 = this.rBundle.getString("INVALID_LEVEL") + var4;
                    break;
                case 323:
                    var3 = this.rBundle.getString("INVALID_SERVICE") + var4;
                    break;
                case 324:
                    var3 = this.rBundle.getString("AUTHENTICATION_KERBEROS5_NO_TGT") + var4;
                    break;
                case 325:
                    var3 = this.rBundle.getString("AUTHENTICATION_KERBEROS5_FAILURE") + var4;
                    break;
                case 326:
                    var3 = this.rBundle.getString("AUTHENTICATION_KERBEROS5_NO_CONTEXT") + var4;
                    break;
                case 327:
                    var3 = this.rBundle.getString("AUTHENTICATION_KERBEROS5_MUTUAL_AUTH_FAILED") + var4;
                    break;
                case 400:
                    var3 = this.rBundle.getString("INVALID_SSL_VERSION") + var4;
                    break;
                case 401:
                    var3 = this.rBundle.getString("UNSUPPORTED_SSL_PROTOCOL") + var4;
                    break;
                case 403:
                    var3 = this.rBundle.getString("INVALID_SSL_CIPHER_SUITES") + var4;
                    break;
                case 404:
                    var3 = this.rBundle.getString("UNSUPPORTED_CIPHER_SUITE") + var4;
                    break;
                case 405:
                    var3 = this.rBundle.getString("MISMATCH_SERVER_CERT_DN") + var4;
                    break;
                case 406:
                    var3 = this.rBundle.getString("DOUBLE_ENCRYPTION_NOT_ALLOWED") + var4;
                    break;
                case 407:
                    var3 = this.rBundle.getString("UNABLE_TO_PARSE_WALLET_LOCATION") + var4;
                    break;
                case 408:
                    var3 = this.rBundle.getString("UNABLE_TO_INIT_KEY_STORE") + var4;
                    break;
                case 409:
                    var3 = this.rBundle.getString("UNABLE_TO_INIT_TRUST_STORE") + var4;
                    break;
                case 410:
                    var3 = this.rBundle.getString("UNABLE_TO_INIT_SSL_CONTEXT") + var4;
                    break;
                case 411:
                    var3 = this.rBundle.getString("SSL_UNVERIFIED_PEER") + var4;
                    break;
                case 412:
                    var3 = this.rBundle.getString("UNSUPPORTED_METHOD_IN_WALLET_LOCATION") + var4;
                    break;
                case 500:
                    var3 = this.rBundle.getString("NS_BREAK") + var4;
                    break;
                case 501:
                    var3 = this.rBundle.getString("NL_EXCEPTION") + var4;
                    break;
                case 502:
                    var3 = this.rBundle.getString("SO_EXCEPTION") + var4;
                    break;
                case 503:
                    var3 = this.rBundle.getString("SO_CONNECTTIMEDOUT") + var4;
                    break;
                case 504:
                    var3 = this.rBundle.getString("SO_READTIMEDOUT") + var4;
                    break;
                case 505:
                    var3 = this.rBundle.getString("INVALID_CONNECTTIMEOUT") + var4;
                    break;
                case 506:
                    var3 = this.rBundle.getString("INVALID_READTIMEOUT") + var4;
                    break;
                default:
                    var3 = this.rBundle.getString("UNDEFINED_ERROR") + var4;
            }

            return var3;
        } else {
            if (var1 >= 12500 && var1 <= 12530) {
                var3 = this.rBundle.getString("LISTENER_REFUSES_CONNECTION") + ":\n" + "ORA-" + var1 + ", " + this.rBundle.getString(String.valueOf(var1)) + "\n" + var4;
            } else {
                var3 = this.rBundle.getString("ORACLE_ERROR") + " ORA-" + var1;
            }

            return var3;
        }
    }
}
