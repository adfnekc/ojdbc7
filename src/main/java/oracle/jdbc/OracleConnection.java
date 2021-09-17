//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import oracle.jdbc.aq.AQDequeueOptions;
import oracle.jdbc.aq.AQEnqueueOptions;
import oracle.jdbc.aq.AQMessage;
import oracle.jdbc.aq.AQNotificationRegistration;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.pool.OracleConnectionCacheCallback;
import oracle.sql.ARRAY;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.DATE;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TypeDescriptor;

public interface OracleConnection extends Connection {
    byte ACCESSMODE_JAVAPROP = 1;
    byte ACCESSMODE_SYSTEMPROP = 2;
    byte ACCESSMODE_BOTH = 3;
    String CONNECTION_PROPERTY_RETAIN_V9_BIND_BEHAVIOR = "oracle.jdbc.RetainV9LongBindBehavior";
    String CONNECTION_PROPERTY_RETAIN_V9_BIND_BEHAVIOR_DEFAULT = "false";
    byte CONNECTION_PROPERTY_RETAIN_V9_BIND_BEHAVIOR_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_USER_NAME = "user";
    String CONNECTION_PROPERTY_USER_NAME_DEFAULT = null;
    byte CONNECTION_PROPERTY_USER_NAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DATABASE = "database";
    String CONNECTION_PROPERTY_DATABASE_DEFAULT = null;
    byte CONNECTION_PROPERTY_DATABASE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_AUTOCOMMIT = "autoCommit";
    String CONNECTION_PROPERTY_AUTOCOMMIT_DEFAULT = "true";
    byte CONNECTION_PROPERTY_AUTOCOMMIT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_PROTOCOL = "protocol";
    String CONNECTION_PROPERTY_PROTOCOL_DEFAULT = null;
    byte CONNECTION_PROPERTY_PROTOCOL_ACCESSMODE = 3;
    /** @deprecated */
    String CONNECTION_PROPERTY_STREAM_CHUNK_SIZE = "oracle.jdbc.StreamChunkSize";
    String CONNECTION_PROPERTY_STREAM_CHUNK_SIZE_DEFAULT = "32767";
    byte CONNECTION_PROPERTY_STREAM_CHUNK_SIZE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_SET_FLOAT_AND_DOUBLE_USE_BINARY = "SetFloatAndDoubleUseBinary";
    String CONNECTION_PROPERTY_SET_FLOAT_AND_DOUBLE_USE_BINARY_DEFAULT = "false";
    byte CONNECTION_PROPERTY_SET_FLOAT_AND_DOUBLE_USE_BINARY_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_OCIDLL = "oracle.jdbc.ocinativelibrary";
    String CONNECTION_PROPERTY_OCIDLL_DEFAULT = null;
    byte CONNECTION_PROPERTY_OCIDLL_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_VSESSION_TERMINAL = "v$session.terminal";
    String CONNECTION_PROPERTY_THIN_VSESSION_TERMINAL_DEFAULT = "unknown";
    byte CONNECTION_PROPERTY_THIN_VSESSION_TERMINAL_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_VSESSION_MACHINE = "v$session.machine";
    String CONNECTION_PROPERTY_THIN_VSESSION_MACHINE_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_VSESSION_MACHINE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_VSESSION_OSUSER = "v$session.osuser";
    String CONNECTION_PROPERTY_THIN_VSESSION_OSUSER_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_VSESSION_OSUSER_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_VSESSION_PROGRAM = "v$session.program";
    String CONNECTION_PROPERTY_THIN_VSESSION_PROGRAM_DEFAULT = "JDBC Thin Client";
    byte CONNECTION_PROPERTY_THIN_VSESSION_PROGRAM_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_VSESSION_PROCESS = "v$session.process";
    String CONNECTION_PROPERTY_THIN_VSESSION_PROCESS_DEFAULT = "1234";
    byte CONNECTION_PROPERTY_THIN_VSESSION_PROCESS_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_VSESSION_INAME = "v$session.iname";
    String CONNECTION_PROPERTY_THIN_VSESSION_INAME_DEFAULT = "jdbc_ttc_impl";
    byte CONNECTION_PROPERTY_THIN_VSESSION_INAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_VSESSION_ENAME = "v$session.ename";
    String CONNECTION_PROPERTY_THIN_VSESSION_ENAME_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_VSESSION_ENAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_PROFILE = "oracle.net.profile";
    String CONNECTION_PROPERTY_THIN_NET_PROFILE_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_PROFILE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_SERVICES = "oracle.net.authentication_services";
    String CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_SERVICES_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_SERVICES_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_KRB5_MUTUAL = "oracle.net.kerberos5_mutual_authentication";
    String CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_KRB5_MUTUAL_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_KRB5_MUTUAL_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_KRB5_CC_NAME = "oracle.net.kerberos5_cc_name";
    String CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_KRB5_CC_NAME_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_AUTHENTICATION_KRB5_CC_NAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_LEVEL = "oracle.net.encryption_client";
    String CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_LEVEL_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_LEVEL_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_TYPES = "oracle.net.encryption_types_client";
    String CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_TYPES_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_TYPES_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_CHECKSUM_LEVEL = "oracle.net.crypto_checksum_client";
    String CONNECTION_PROPERTY_THIN_NET_CHECKSUM_LEVEL_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_CHECKSUM_LEVEL_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_CHECKSUM_TYPES = "oracle.net.crypto_checksum_types_client";
    String CONNECTION_PROPERTY_THIN_NET_CHECKSUM_TYPES_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_CHECKSUM_TYPES_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_CRYPTO_SEED = "oracle.net.crypto_seed";
    String CONNECTION_PROPERTY_THIN_NET_CRYPTO_SEED_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_CRYPTO_SEED_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_TCP_NO_DELAY = "oracle.jdbc.TcpNoDelay";
    String CONNECTION_PROPERTY_THIN_TCP_NO_DELAY_DEFAULT = "false";
    byte CONNECTION_PROPERTY_THIN_TCP_NO_DELAY_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_READ_TIMEOUT = "oracle.jdbc.ReadTimeout";
    String CONNECTION_PROPERTY_THIN_READ_TIMEOUT_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_READ_TIMEOUT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT = "oracle.net.CONNECT_TIMEOUT";
    String CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_DISABLE_OUT_OF_BAND_BREAK = "oracle.net.disableOob";
    String CONNECTION_PROPERTY_THIN_NET_DISABLE_OUT_OF_BAND_BREAK_DEFAULT = "false";
    byte CONNECTION_PROPERTY_THIN_NET_DISABLE_OUT_OF_BAND_BREAK_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_USE_ZERO_COPY_IO = "oracle.net.useZeroCopyIO";
    String CONNECTION_PROPERTY_THIN_NET_USE_ZERO_COPY_IO_DEFAULT = "true";
    byte CONNECTION_PROPERTY_THIN_NET_USE_ZERO_COPY_IO_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_USE_1900_AS_YEAR_FOR_TIME = "oracle.jdbc.use1900AsYearForTime";
    String CONNECTION_PROPERTY_USE_1900_AS_YEAR_FOR_TIME_DEFAULT = "false";
    byte CONNECTION_PROPERTY_USE_1900_AS_YEAR_FOR_TIME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_TIMESTAMPTZ_IN_GMT = "oracle.jdbc.timestampTzInGmt";
    String CONNECTION_PROPERTY_TIMESTAMPTZ_IN_GMT_DEFAULT = "true";
    byte CONNECTION_PROPERTY_TIMESTAMPTZ_IN_GMT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_TIMEZONE_AS_REGION = "oracle.jdbc.timezoneAsRegion";
    String CONNECTION_PROPERTY_TIMEZONE_AS_REGION_DEFAULT = "true";
    byte CONNECTION_PROPERTY_TIMEZONE_AS_REGION_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_SSL_SERVER_DN_MATCH = "oracle.net.ssl_server_dn_match";
    String CONNECTION_PROPERTY_THIN_SSL_SERVER_DN_MATCH_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_SSL_SERVER_DN_MATCH_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_SSL_VERSION = "oracle.net.ssl_version";
    String CONNECTION_PROPERTY_THIN_SSL_VERSION_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_SSL_VERSION_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_SSL_CIPHER_SUITES = "oracle.net.ssl_cipher_suites";
    String CONNECTION_PROPERTY_THIN_SSL_CIPHER_SUITES_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_SSL_CIPHER_SUITES_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTORE = "javax.net.ssl.keyStore";
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTORE_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTORE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTORETYPE = "javax.net.ssl.keyStoreType";
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTORETYPE_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTORETYPE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTOREPASSWORD = "javax.net.ssl.keyStorePassword";
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTOREPASSWORD_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_KEYSTOREPASSWORD_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTORE = "javax.net.ssl.trustStore";
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTORE_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTORE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTORETYPE_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTORETYPE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTOREPASSWORD = "javax.net.ssl.trustStorePassword";
    String CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTOREPASSWORD_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JAVAX_NET_SSL_TRUSTSTOREPASSWORD_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_SSL_KEYMANAGERFACTORY_ALGORITHM = "ssl.keyManagerFactory.algorithm";
    String CONNECTION_PROPERTY_THIN_SSL_KEYMANAGERFACTORY_ALGORITHM_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_SSL_KEYMANAGERFACTORY_ALGORITHM_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_SSL_TRUSTMANAGERFACTORY_ALGORITHM = "ssl.trustManagerFactory.algorithm";
    String CONNECTION_PROPERTY_THIN_SSL_TRUSTMANAGERFACTORY_ALGORITHM_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_SSL_TRUSTMANAGERFACTORY_ALGORITHM_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NET_OLDSYNTAX = "oracle.net.oldSyntax";
    String CONNECTION_PROPERTY_THIN_NET_OLDSYNTAX_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NET_OLDSYNTAX_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_NAMING_CONTEXT_INITIAL = "java.naming.factory.initial";
    String CONNECTION_PROPERTY_THIN_NAMING_CONTEXT_INITIAL_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NAMING_CONTEXT_INITIAL_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_THIN_NAMING_PROVIDER_URL = "java.naming.provider.url";
    String CONNECTION_PROPERTY_THIN_NAMING_PROVIDER_URL_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NAMING_PROVIDER_URL_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_THIN_NAMING_SECURITY_AUTHENTICATION = "java.naming.security.authentication";
    String CONNECTION_PROPERTY_THIN_NAMING_SECURITY_AUTHENTICATION_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NAMING_SECURITY_AUTHENTICATION_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_THIN_NAMING_SECURITY_PRINCIPAL = "java.naming.security.principal";
    String CONNECTION_PROPERTY_THIN_NAMING_SECURITY_PRINCIPAL_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NAMING_SECURITY_PRINCIPAL_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_THIN_NAMING_SECURITY_CREDENTIALS = "java.naming.security.credentials";
    String CONNECTION_PROPERTY_THIN_NAMING_SECURITY_CREDENTIALS_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_NAMING_SECURITY_CREDENTIALS_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_THIN_JNDI_LDAP_CONNECT_TIMEOUT = "com.sun.jndi.ldap.connect.timeout";
    String CONNECTION_PROPERTY_THIN_JNDI_LDAP_CONNECT_TIMEOUT_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JNDI_LDAP_CONNECT_TIMEOUT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_THIN_JNDI_LDAP_READ_TIMEOUT = "com.sun.jndi.ldap.read.timeout";
    String CONNECTION_PROPERTY_THIN_JNDI_LDAP_READ_TIMEOUT_DEFAULT = null;
    byte CONNECTION_PROPERTY_THIN_JNDI_LDAP_READ_TIMEOUT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_WALLET_LOCATION = "oracle.net.wallet_location";
    String CONNECTION_PROPERTY_WALLET_LOCATION_DEFAULT = null;
    byte CONNECTION_PROPERTY_WALLET_LOCATION_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_WALLET_PASSWORD = "oracle.net.wallet_password";
    String CONNECTION_PROPERTY_WALLET_PASSWORD_DEFAULT = null;
    byte CONNECTION_PROPERTY_WALLET_PASSWORD_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_PROXY_CLIENT_NAME = "oracle.jdbc.proxyClientName";
    String CONNECTION_PROPERTY_PROXY_CLIENT_NAME_DEFAULT = null;
    byte CONNECTION_PROPERTY_PROXY_CLIENT_NAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DEFAULT_USE_NIO = "oracle.jdbc.useNio";
    String CONNECTION_PROPERTY_DEFAULT_USE_NIO_DEFAULT = "false";
    byte CONNECTION_PROPERTY_DEFAULT_USE_NIO_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_OCI_DRIVER_CHARSET = "JDBCDriverCharSetId";
    String CONNECTION_PROPERTY_OCI_DRIVER_CHARSET_DEFAULT = null;
    byte CONNECTION_PROPERTY_OCI_DRIVER_CHARSET_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_EDITION_NAME = "oracle.jdbc.editionName";
    String CONNECTION_PROPERTY_EDITION_NAME_DEFAULT = null;
    byte CONNECTION_PROPERTY_EDITION_NAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_INTERNAL_LOGON = "internal_logon";
    String CONNECTION_PROPERTY_INTERNAL_LOGON_DEFAULT = null;
    byte CONNECTION_PROPERTY_INTERNAL_LOGON_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_CREATE_DESCRIPTOR_USE_CURRENT_SCHEMA_FOR_SCHEMA_NAME = "oracle.jdbc.createDescriptorUseCurrentSchemaForSchemaName";
    String CONNECTION_PROPERTY_CREATE_DESCRIPTOR_USE_CURRENT_SCHEMA_FOR_SCHEMA_NAME_DEFAULT = "false";
    byte CONNECTION_PROPERTY_CREATE_DESCRIPTOR_USE_CURRENT_SCHEMA_FOR_SCHEMA_NAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_OCI_SVC_CTX_HANDLE = "OCISvcCtxHandle";
    String CONNECTION_PROPERTY_OCI_SVC_CTX_HANDLE_DEFAULT = "0";
    byte CONNECTION_PROPERTY_OCI_SVC_CTX_HANDLE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_OCI_ENV_HANDLE = "OCIEnvHandle";
    String CONNECTION_PROPERTY_OCI_ENV_HANDLE_DEFAULT = "0";
    byte CONNECTION_PROPERTY_OCI_ENV_HANDLE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_OCI_ERR_HANDLE = "OCIErrHandle";
    String CONNECTION_PROPERTY_OCI_ERR_HANDLE_DEFAULT = "0";
    byte CONNECTION_PROPERTY_OCI_ERR_HANDLE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_PRELIM_AUTH = "prelim_auth";
    String CONNECTION_PROPERTY_PRELIM_AUTH_DEFAULT = "false";
    byte CONNECTION_PROPERTY_PRELIM_AUTH_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_SET_NEW_PASSWORD = "OCINewPassword";
    String CONNECTION_PROPERTY_SET_NEW_PASSWORD_DEFAULT = null;
    byte CONNECTION_PROPERTY_SET_NEW_PASSWORD_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DEFAULT_EXECUTE_BATCH = "defaultExecuteBatch";
    String CONNECTION_PROPERTY_DEFAULT_EXECUTE_BATCH_DEFAULT = "1";
    byte CONNECTION_PROPERTY_DEFAULT_EXECUTE_BATCH_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH = "defaultRowPrefetch";
    String CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH_DEFAULT = "10";
    byte CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DEFAULT_LOB_PREFETCH_SIZE = "oracle.jdbc.defaultLobPrefetchSize";
    String CONNECTION_PROPERTY_DEFAULT_LOB_PREFETCH_SIZE_DEFAULT = "4000";
    byte CONNECTION_PROPERTY_DEFAULT_LOB_PREFETCH_SIZE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_ENABLE_DATA_IN_LOCATOR = "oracle.jdbc.enableDataInLocator";
    String CONNECTION_PROPERTY_ENABLE_DATA_IN_LOCATOR_DEFAULT = "true";
    byte CONNECTION_PROPERTY_ENABLE_DATA_IN_LOCATOR_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_ENABLE_READ_DATA_IN_LOCATOR = "oracle.jdbc.enableReadDataInLocator";
    String CONNECTION_PROPERTY_ENABLE_READ_DATA_IN_LOCATOR_DEFAULT = "true";
    byte CONNECTION_PROPERTY_ENABLE_READ_DATA_IN_LOCATOR_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_REPORT_REMARKS = "remarksReporting";
    String CONNECTION_PROPERTY_REPORT_REMARKS_DEFAULT = "false";
    byte CONNECTION_PROPERTY_REPORT_REMARKS_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_INCLUDE_SYNONYMS = "includeSynonyms";
    String CONNECTION_PROPERTY_INCLUDE_SYNONYMS_DEFAULT = "false";
    byte CONNECTION_PROPERTY_INCLUDE_SYNONYMS_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_RESTRICT_GETTABLES = "restrictGetTables";
    String CONNECTION_PROPERTY_RESTRICT_GETTABLES_DEFAULT = "false";
    byte CONNECTION_PROPERTY_RESTRICT_GETTABLES_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_ACCUMULATE_BATCH_RESULT = "AccumulateBatchResult";
    String CONNECTION_PROPERTY_ACCUMULATE_BATCH_RESULT_DEFAULT = "true";
    byte CONNECTION_PROPERTY_ACCUMULATE_BATCH_RESULT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_USE_FETCH_SIZE_WITH_LONG_COLUMN = "useFetchSizeWithLongColumn";
    String CONNECTION_PROPERTY_USE_FETCH_SIZE_WITH_LONG_COLUMN_DEFAULT = "false";
    byte CONNECTION_PROPERTY_USE_FETCH_SIZE_WITH_LONG_COLUMN_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_PROCESS_ESCAPES = "processEscapes";
    String CONNECTION_PROPERTY_PROCESS_ESCAPES_DEFAULT = "true";
    byte CONNECTION_PROPERTY_PROCESS_ESCAPES_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_FIXED_STRING = "fixedString";
    String CONNECTION_PROPERTY_FIXED_STRING_DEFAULT = "false";
    byte CONNECTION_PROPERTY_FIXED_STRING_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DEFAULTNCHAR = "defaultNChar";
    String CONNECTION_PROPERTY_DEFAULTNCHAR_DEFAULT = "false";
    byte CONNECTION_PROPERTY_DEFAULTNCHAR_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_RESOURCE_MANAGER_ID = "RessourceManagerId";
    String CONNECTION_PROPERTY_RESOURCE_MANAGER_ID_DEFAULT = "0000";
    byte CONNECTION_PROPERTY_RESOURCE_MANAGER_ID_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DISABLE_DEFINECOLUMNTYPE = "disableDefineColumnType";
    String CONNECTION_PROPERTY_DISABLE_DEFINECOLUMNTYPE_DEFAULT = "false";
    byte CONNECTION_PROPERTY_DISABLE_DEFINECOLUMNTYPE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_CONVERT_NCHAR_LITERALS = "oracle.jdbc.convertNcharLiterals";
    String CONNECTION_PROPERTY_CONVERT_NCHAR_LITERALS_DEFAULT = "true";
    byte CONNECTION_PROPERTY_CONVERT_NCHAR_LITERALS_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_AUTO_COMMIT_SPEC_COMPLIANT = "oracle.jdbc.autoCommitSpecCompliant";
    String CONNECTION_PROPERTY_AUTO_COMMIT_SPEC_COMPLIANT_DEFAULT = "true";
    byte CONNECTION_PROPERTY_AUTO_COMMIT_SPEC_COMPLIANT_ACCESSMODE = 3;
    /** @deprecated */
    String CONNECTION_PROPERTY_J2EE13_COMPLIANT = "oracle.jdbc.J2EE13Compliant";
    String CONNECTION_PROPERTY_J2EE13_COMPLIANT_DEFAULT = "false";
    byte CONNECTION_PROPERTY_J2EE13_COMPLIANT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_MAP_DATE_TO_TIMESTAMP = "oracle.jdbc.mapDateToTimestamp";
    String CONNECTION_PROPERTY_MAP_DATE_TO_TIMESTAMP_DEFAULT = "true";
    byte CONNECTION_PROPERTY_MAP_DATE_TO_TIMESTAMP_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_USE_THREADLOCAL_BUFFER_CACHE = "oracle.jdbc.useThreadLocalBufferCache";
    String CONNECTION_PROPERTY_USE_THREADLOCAL_BUFFER_CACHE_DEFAULT = "false";
    byte CONNECTION_PROPERTY_USE_THREADLOCAL_BUFFER_CACHE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DRIVER_NAME_ATTRIBUTE = "oracle.jdbc.driverNameAttribute";
    String CONNECTION_PROPERTY_DRIVER_NAME_ATTRIBUTE_DEFAULT = null;
    byte CONNECTION_PROPERTY_DRIVER_NAME_ATTRIBUTE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_MAX_CACHED_BUFFER_SIZE = "oracle.jdbc.maxCachedBufferSize";
    String CONNECTION_PROPERTY_MAX_CACHED_BUFFER_SIZE_DEFAULT = "30";
    byte CONNECTION_PROPERTY_MAX_CACHED_BUFFER_SIZE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_IMPLICIT_STATEMENT_CACHE_SIZE = "oracle.jdbc.implicitStatementCacheSize";
    String CONNECTION_PROPERTY_IMPLICIT_STATEMENT_CACHE_SIZE_DEFAULT = "0";
    byte CONNECTION_PROPERTY_IMPLICIT_STATEMENT_CACHE_SIZE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_LOB_STREAM_POS_STANDARD_COMPLIANT = "oracle.jdbc.LobStreamPosStandardCompliant";
    String CONNECTION_PROPERTY_LOB_STREAM_POS_STANDARD_COMPLIANT_DEFAULT = "false";
    byte CONNECTION_PROPERTY_LOB_STREAM_POS_STANDARD_COMPLIANT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_STRICT_ASCII_CONVERSION = "oracle.jdbc.strictASCIIConversion";
    String CONNECTION_PROPERTY_STRICT_ASCII_CONVERSION_DEFAULT = "false";
    byte CONNECTION_PROPERTY_STRICT_ASCII_CONVERSION_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_CONNECTION_CLASS = "oracle.jdbc.DRCPConnectionClass";
    String CONNECTION_PROPERTY_CONNECTION_CLASS_DEFAULT = null;
    byte CONNECTION_PROPERTY_CONNECTION_CLASS_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_DRCP_TAG_NAME = "oracle.jdbc.DRCPTagName";
    String CONNECTION_PROPERTY_DRCP_TAG_NAME_DEFAULT = null;
    byte CONNECTION_PROPERTY_DRCP_TAG_NAME_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_THIN_FORCE_DNS_LOAD_BALANCING = "oracle.jdbc.thinForceDNSLoadBalancing";
    String CONNECTION_PROPERTY_THIN_FORCE_DNS_LOAD_BALANCING_DEFAULT = "false";
    byte CONNECTION_PROPERTY_THIN_FORCE_DNS_LOAD_BALANCING_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_ENABLE_TEMP_LOB_REF_COUNT = "oracle.jdbc.enableTempLobRefCnt";
    String CONNECTION_PROPERTY_ENABLE_TEMP_LOB_REF_COUNT_DEFAULT = "true";
    byte CONNECTION_PROPERTY_ENABLE_TEMP_LOB_REF_COUNT_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_NET_KEEPALIVE = "oracle.net.keepAlive";
    String CONNECTION_PROPERTY_NET_KEEPALIVE_DEFAULT = "false";
    byte CONNECTION_PROPERTY_NET_KEEPALIVE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_SQL_TRANSLATION_PROFILE = "oracle.jdbc.sqlTranslationProfile";
    String CONNECTION_PROPERTY_SQL_TRANSLATION_PROFILE_DEFAULT = null;
    byte CONNECTION_PROPERTY_SQL_TRANSLATION_PROFILE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_SQL_ERROR_TRANSLATION_FILE = "oracle.jdbc.sqlErrorTranslationFile";
    String CONNECTION_PROPERTY_SQL_ERROR_TRANSLATION_FILE_DEFAULT = null;
    byte CONNECTION_PROPERTY_SQL_ERROR_TRANSLATION_FILE_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_PASSWORD = "password";
    String CONNECTION_PROPERTY_PASSWORD_DEFAULT = null;
    byte CONNECTION_PROPERTY_PASSWORD_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_SERVER = "server";
    String CONNECTION_PROPERTY_SERVER_DEFAULT = null;
    byte CONNECTION_PROPERTY_SERVER_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_COMMIT_OPTION = "oracle.jdbc.commitOption";
    String CONNECTION_PROPERTY_COMMIT_OPTION_DEFAULT = null;
    byte CONNECTION_PROPERTY_COMMIT_OPTION_ACCESSMODE = 3;
    int DATABASE_OK = 0;
    int DATABASE_CLOSED = -1;
    int DATABASE_NOTOK = -2;
    int DATABASE_TIMEOUT = -3;
    int INVALID_CONNECTION = 4096;
    int PROXY_SESSION = 1;
    int ABANDONED_CONNECTION_CALLBACK = 1;
    int RELEASE_CONNECTION_CALLBACK = 2;
    int ALL_CONNECTION_CALLBACKS = 4;
    int CONNECTION_RELEASE_LOCKED = 256;
    int CONNECTION_RELEASE_LOW = 512;
    int CONNECTION_RELEASE_HIGH = 1024;
    int PROXYTYPE_USER_NAME = 1;
    int PROXYTYPE_DISTINGUISHED_NAME = 2;
    int PROXYTYPE_CERTIFICATE = 3;
    String PROXY_USER_NAME = "PROXY_USER_NAME";
    String PROXY_USER_PASSWORD = "PROXY_USER_PASSWORD";
    String PROXY_DISTINGUISHED_NAME = "PROXY_DISTINGUISHED_NAME";
    String PROXY_CERTIFICATE = "PROXY_CERTIFICATE";
    String PROXY_ROLES = "PROXY_ROLES";
    String CLIENT_INFO_KEY_SEPARATOR = ".";
    String OCSID_NAMESPACE = "OCSID";
    String OCSID_ACTION_KEY = "ACTION";
    String OCSID_CLIENTID_KEY = "CLIENTID";
    String OCSID_ECID_KEY = "ECID";
    String OCSID_MODULE_KEY = "MODULE";
    String OCSID_DBOP_KEY = "DBOP";
    String OCSID_SEQUENCE_NUMBER_KEY = "SEQUENCE_NUMBER";
    int END_TO_END_ACTION_INDEX = 0;
    int END_TO_END_CLIENTID_INDEX = 1;
    int END_TO_END_ECID_INDEX = 2;
    int END_TO_END_MODULE_INDEX = 3;
    int END_TO_END_STATE_INDEX_MAX = 4;
    int CACHE_SIZE_NOT_SET = -1;
    String NTF_TIMEOUT = "NTF_TIMEOUT";
    String NTF_QOS_PURGE_ON_NTFN = "NTF_QOS_PURGE_ON_NTFN";
    String NTF_QOS_RELIABLE = "NTF_QOS_RELIABLE";
    String NTF_QOS_SECURE = "NTF_QOS_SECURE";
    String NTF_ASYNC_DEQ = "NTF_ASYNC_DEQ";
    String NTF_AQ_PAYLOAD = "NTF_AQ_PAYLOAD";
    String NTF_QOS_TX_ACK = "NTF_QOS_TX_ACK";
    String NTF_QOS_AUTO_ACK = "NTF_QOS_AUTO_ACK";
    String NTF_LOCAL_TCP_PORT = "NTF_LOCAL_TCP_PORT";
    int NTF_DEFAULT_TCP_PORT = 47632;
    String NTF_LOCAL_HOST = "NTF_LOCAL_HOST";
    String NTF_GROUPING_CLASS = "NTF_GROUPING_CLASS";
    String NTF_GROUPING_CLASS_NONE = "NTF_GROUPING_CLASS_NONE";
    String NTF_GROUPING_CLASS_TIME = "NTF_GROUPING_CLASS_TIME";
    String NTF_GROUPING_VALUE = "NTF_GROUPING_VALUE";
    String NTF_GROUPING_TYPE = "NTF_GROUPING_TYPE";
    String NTF_GROUPING_TYPE_SUMMARY = "NTF_GROUPING_TYPE_SUMMARY";
    String NTF_GROUPING_TYPE_LAST = "NTF_GROUPING_TYPE_LAST";
    String NTF_GROUPING_START_TIME = "NTF_GROUPING_START_TIME";
    String NTF_GROUPING_REPEAT_TIME = "NTF_GROUPING_REPEAT_TIME";
    String NTF_GROUPING_REPEAT_FOREVER = "NTF_GROUPING_REPEAT_FOREVER";
    String DCN_NOTIFY_ROWIDS = "DCN_NOTIFY_ROWIDS";
    String DCN_IGNORE_INSERTOP = "DCN_IGNORE_INSERTOP";
    String DCN_IGNORE_UPDATEOP = "DCN_IGNORE_UPDATEOP";
    String DCN_IGNORE_DELETEOP = "DCN_IGNORE_DELETEOP";
    String DCN_NOTIFY_CHANGELAG = "DCN_NOTIFY_CHANGELAG";
    String DCN_QUERY_CHANGE_NOTIFICATION = "DCN_QUERY_CHANGE_NOTIFICATION";
    String DCN_BEST_EFFORT = "DCN_BEST_EFFORT";

    void commit(EnumSet<OracleConnection.CommitOption> var1) throws SQLException;

    /** @deprecated */
    void archive(int var1, int var2, String var3) throws SQLException;

    void openProxySession(int var1, Properties var2) throws SQLException;

    boolean getAutoClose() throws SQLException;

    /** @deprecated */
    int getDefaultExecuteBatch();

    int getDefaultRowPrefetch();

    Object getDescriptor(String var1);

    /** @deprecated */
    String[] getEndToEndMetrics() throws SQLException;

    /** @deprecated */
    short getEndToEndECIDSequenceNumber() throws SQLException;

    boolean getIncludeSynonyms();

    boolean getRestrictGetTables();

    /** @deprecated */
    Object getJavaObject(String var1) throws SQLException;

    boolean getRemarksReporting();

    /** @deprecated */
    String getSQLType(Object var1) throws SQLException;

    /** @deprecated */
    int getStmtCacheSize();

    short getStructAttrCsId() throws SQLException;

    String getUserName() throws SQLException;

    String getCurrentSchema() throws SQLException;

    /** @deprecated */
    boolean getUsingXAFlag();

    /** @deprecated */
    boolean getXAErrorFlag();

    int pingDatabase() throws SQLException;

    /** @deprecated */
    int pingDatabase(int var1) throws SQLException;

    void putDescriptor(String var1, Object var2) throws SQLException;

    /** @deprecated */
    void registerSQLType(String var1, Class var2) throws SQLException;

    /** @deprecated */
    void registerSQLType(String var1, String var2) throws SQLException;

    void setAutoClose(boolean var1) throws SQLException;

    /** @deprecated */
    void setDefaultExecuteBatch(int var1) throws SQLException;

    void setDefaultRowPrefetch(int var1) throws SQLException;

    /** @deprecated */
    void setEndToEndMetrics(String[] var1, short var2) throws SQLException;

    void setIncludeSynonyms(boolean var1);

    void setRemarksReporting(boolean var1);

    void setRestrictGetTables(boolean var1);

    /** @deprecated */
    void setStmtCacheSize(int var1) throws SQLException;

    /** @deprecated */
    void setStmtCacheSize(int var1, boolean var2) throws SQLException;

    void setStatementCacheSize(int var1) throws SQLException;

    int getStatementCacheSize() throws SQLException;

    void setImplicitCachingEnabled(boolean var1) throws SQLException;

    boolean getImplicitCachingEnabled() throws SQLException;

    void setExplicitCachingEnabled(boolean var1) throws SQLException;

    boolean getExplicitCachingEnabled() throws SQLException;

    void purgeImplicitCache() throws SQLException;

    void purgeExplicitCache() throws SQLException;

    PreparedStatement getStatementWithKey(String var1) throws SQLException;

    CallableStatement getCallWithKey(String var1) throws SQLException;

    /** @deprecated */
    void setUsingXAFlag(boolean var1);

    /** @deprecated */
    void setXAErrorFlag(boolean var1);

    void shutdown(OracleConnection.DatabaseShutdownMode var1) throws SQLException;

    /** @deprecated */
    void startup(String var1, int var2) throws SQLException;

    void startup(OracleConnection.DatabaseStartupMode var1) throws SQLException;

    /** @deprecated */
    PreparedStatement prepareStatementWithKey(String var1) throws SQLException;

    /** @deprecated */
    CallableStatement prepareCallWithKey(String var1) throws SQLException;

    void setCreateStatementAsRefCursor(boolean var1);

    boolean getCreateStatementAsRefCursor();

    void setSessionTimeZone(String var1) throws SQLException;

    String getSessionTimeZone();

    String getSessionTimeZoneOffset() throws SQLException;

    Properties getProperties();

    Connection _getPC();

    boolean isLogicalConnection();

    void registerTAFCallback(OracleOCIFailover var1, Object var2) throws SQLException;

    OracleConnection unwrap();

    void setWrapper(OracleConnection var1);

    /** @deprecated */
    oracle.jdbc.internal.OracleConnection physicalConnectionWithin();

    OracleSavepoint oracleSetSavepoint() throws SQLException;

    OracleSavepoint oracleSetSavepoint(String var1) throws SQLException;

    void oracleRollback(OracleSavepoint var1) throws SQLException;

    void oracleReleaseSavepoint(OracleSavepoint var1) throws SQLException;

    void close(Properties var1) throws SQLException;

    void close(int var1) throws SQLException;

    boolean isProxySession();

    void applyConnectionAttributes(Properties var1) throws SQLException;

    Properties getConnectionAttributes() throws SQLException;

    Properties getUnMatchedConnectionAttributes() throws SQLException;

    void registerConnectionCacheCallback(OracleConnectionCacheCallback var1, Object var2, int var3) throws SQLException;

    void setConnectionReleasePriority(int var1) throws SQLException;

    int getConnectionReleasePriority() throws SQLException;

    void setPlsqlWarnings(String var1) throws SQLException;

    AQNotificationRegistration[] registerAQNotification(String[] var1, Properties[] var2, Properties var3) throws SQLException;

    void unregisterAQNotification(AQNotificationRegistration var1) throws SQLException;

    AQMessage dequeue(String var1, AQDequeueOptions var2, byte[] var3) throws SQLException;

    AQMessage dequeue(String var1, AQDequeueOptions var2, String var3) throws SQLException;

    void enqueue(String var1, AQEnqueueOptions var2, AQMessage var3) throws SQLException;

    DatabaseChangeRegistration registerDatabaseChangeNotification(Properties var1) throws SQLException;

    DatabaseChangeRegistration getDatabaseChangeRegistration(int var1) throws SQLException;

    void unregisterDatabaseChangeNotification(DatabaseChangeRegistration var1) throws SQLException;

    /** @deprecated */
    void unregisterDatabaseChangeNotification(int var1, String var2, int var3) throws SQLException;

    /** @deprecated */
    void unregisterDatabaseChangeNotification(int var1) throws SQLException;

    void unregisterDatabaseChangeNotification(long var1, String var3) throws SQLException;

    ARRAY createARRAY(String var1, Object var2) throws SQLException;

    Array createOracleArray(String var1, Object var2) throws SQLException;

    BINARY_DOUBLE createBINARY_DOUBLE(double var1) throws SQLException;

    BINARY_FLOAT createBINARY_FLOAT(float var1) throws SQLException;

    DATE createDATE(Date var1) throws SQLException;

    DATE createDATE(Time var1) throws SQLException;

    DATE createDATE(Timestamp var1) throws SQLException;

    DATE createDATE(Date var1, Calendar var2) throws SQLException;

    DATE createDATE(Time var1, Calendar var2) throws SQLException;

    DATE createDATE(Timestamp var1, Calendar var2) throws SQLException;

    DATE createDATE(String var1) throws SQLException;

    INTERVALDS createINTERVALDS(String var1) throws SQLException;

    INTERVALYM createINTERVALYM(String var1) throws SQLException;

    NUMBER createNUMBER(boolean var1) throws SQLException;

    NUMBER createNUMBER(byte var1) throws SQLException;

    NUMBER createNUMBER(short var1) throws SQLException;

    NUMBER createNUMBER(int var1) throws SQLException;

    NUMBER createNUMBER(long var1) throws SQLException;

    NUMBER createNUMBER(float var1) throws SQLException;

    NUMBER createNUMBER(double var1) throws SQLException;

    NUMBER createNUMBER(BigDecimal var1) throws SQLException;

    NUMBER createNUMBER(BigInteger var1) throws SQLException;

    NUMBER createNUMBER(String var1, int var2) throws SQLException;

    TIMESTAMP createTIMESTAMP(Date var1) throws SQLException;

    TIMESTAMP createTIMESTAMP(DATE var1) throws SQLException;

    TIMESTAMP createTIMESTAMP(Time var1) throws SQLException;

    TIMESTAMP createTIMESTAMP(Timestamp var1) throws SQLException;

    TIMESTAMP createTIMESTAMP(String var1) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(Date var1) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(Date var1, Calendar var2) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(Time var1) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(Time var1, Calendar var2) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(Timestamp var1) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(Timestamp var1, Calendar var2) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(String var1) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(String var1, Calendar var2) throws SQLException;

    TIMESTAMPTZ createTIMESTAMPTZ(DATE var1) throws SQLException;

    TIMESTAMPLTZ createTIMESTAMPLTZ(Date var1, Calendar var2) throws SQLException;

    TIMESTAMPLTZ createTIMESTAMPLTZ(Time var1, Calendar var2) throws SQLException;

    TIMESTAMPLTZ createTIMESTAMPLTZ(Timestamp var1, Calendar var2) throws SQLException;

    TIMESTAMPLTZ createTIMESTAMPLTZ(String var1, Calendar var2) throws SQLException;

    TIMESTAMPLTZ createTIMESTAMPLTZ(DATE var1, Calendar var2) throws SQLException;

    void cancel() throws SQLException;

    void abort() throws SQLException;

    TypeDescriptor[] getAllTypeDescriptorsInCurrentSchema() throws SQLException;

    TypeDescriptor[] getTypeDescriptorsFromListInCurrentSchema(String[] var1) throws SQLException;

    TypeDescriptor[] getTypeDescriptorsFromList(String[][] var1) throws SQLException;

    String getDataIntegrityAlgorithmName() throws SQLException;

    String getEncryptionAlgorithmName() throws SQLException;

    String getAuthenticationAdaptorName() throws SQLException;

    boolean isUsable();

    void setDefaultTimeZone(TimeZone var1) throws SQLException;

    TimeZone getDefaultTimeZone() throws SQLException;

    /** @deprecated */
    void setApplicationContext(String var1, String var2, String var3) throws SQLException;

    /** @deprecated */
    void clearAllApplicationContext(String var1) throws SQLException;

    void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException;

    void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1, Executor var2) throws SQLException;

    void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException;

    LogicalTransactionId getLogicalTransactionId() throws SQLException;

    boolean isDRCPEnabled() throws SQLException;

    boolean attachServerConnection() throws SQLException;

    void detachServerConnection(String var1) throws SQLException;

    boolean needToPurgeStatementCache() throws SQLException;

    public static enum CommitOption {
        WRITEBATCH(1),
        WRITEIMMED(2),
        WAIT(4),
        NOWAIT(8);

        private final int code;

        private CommitOption(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public static enum DatabaseStartupMode {
        NO_RESTRICTION(0),
        FORCE(1),
        RESTRICT(2);

        private final int mode;

        private DatabaseStartupMode(int var3) {
            this.mode = var3;
        }

        public final int getMode() {
            return this.mode;
        }
    }

    public static enum DatabaseShutdownMode {
        CONNECT(0),
        TRANSACTIONAL(1),
        TRANSACTIONAL_LOCAL(2),
        IMMEDIATE(3),
        ABORT(4),
        FINAL(5);

        private final int mode;

        private DatabaseShutdownMode(int var3) {
            this.mode = var3;
        }

        public final int getMode() {
            return this.mode;
        }
    }
}
