//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class TranslationManager {
    private static final ConcurrentHashMap<String, TranslationCache> translationCacheRegistry = new ConcurrentHashMap();
    private static Map<String, String> defaultErrorFile = new ConcurrentHashMap();
    private static final String SEPARATOR = "\u0000";
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public TranslationManager() {
    }

    public static Translator getTranslator(String var0, String var1, String var2, String var3) throws SQLException {
        if (var3 == null && defaultErrorFile.containsKey(var2)) {
            var3 = (String)defaultErrorFile.get(var2);
        }

        File var4 = null;
        if (var3 != null) {
            var4 = new File(var3);
            if (!var4.exists()) {
                SQLException var8 = DatabaseError.createSqlException((OracleConnection)null, 277);
                var8.fillInStackTrace();
                throw var8;
            }
        }

        assert !".*\u0000.*".matches(var0) && !".*\u0000.*".matches(var1) && !".*\u0000.*".matches(var2);

        String var5 = var0 + "\u0000" + var1 + "\u0000" + var2;
        TranslationCache var6 = (TranslationCache)translationCacheRegistry.get(var5);
        if (var6 == null) {
            var6 = new TranslationCache(var4);
            translationCacheRegistry.putIfAbsent(var5, var6);
        }

        Translator var7 = new Translator(var2, var4, var6);
        return var7;
    }
}
