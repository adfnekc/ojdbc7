//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LxMetaData {
    private static final String DEFAULT_ES_ORA_LANGUAGE = "LATIN AMERICAN SPANISH";
    private static final int WIDTH_SIZE = 8;
    private static final short WIDTH_MASK = 255;
    public static final int ST_BADCODESET = 0;
    private static final Locale EN_LOCALE = new Locale("en", "US");
    private static Map ORACLE_LANG_2_ISO_A2_LANG = null;
    private static Map ORACLE_TERR_2_ISO_A2_TERR = null;
    private static Map ORACLE_LANG_2_TERR = null;
    private static Map ISO_A2_LANG_2_ORACLE_LANG = null;
    private static Map ISO_LANGUAGE_DEFAULT_TERRITORY = null;
    private static Map ISO_LOCALE_2_ORACLE_LOCALE = null;
    private static Map ISO_A2_TERR_2_ORACLE_TERR = null;
    private static Map CHARSET_RATIO = null;

    static Locale getJavaLocale(String var0, String var1) {
        if (var0 == null) {
            return null;
        } else {
            String var2 = var0;
            String var3 = EN_LOCALE.getLanguage();
            if (!"".equals(var0)) {
                if (ORACLE_LANG_2_ISO_A2_LANG == null) {
                    ORACLE_LANG_2_ISO_A2_LANG = getLang2IsoLangMap();
                }

                var3 = (String)ORACLE_LANG_2_ISO_A2_LANG.get(var0.toUpperCase(Locale.US));
                if (var3 == null) {
                    return null;
                }
            } else {
                var2 = "AMERICAN";
            }

            String var4 = null;
            if (var1 == null || (var4 = var1.toUpperCase(Locale.US)) == null || "".equals(var4)) {
                if (ORACLE_LANG_2_TERR == null) {
                    ORACLE_LANG_2_TERR = getLang2Terr();
                }

                var4 = (String)ORACLE_LANG_2_TERR.get(var2);
            }

            if (ORACLE_TERR_2_ISO_A2_TERR == null) {
                ORACLE_TERR_2_ISO_A2_TERR = getTerr2IsoTerrMap();
            }

            String var5 = (String)ORACLE_TERR_2_ISO_A2_TERR.get(var4);
            return var5 == null ? null : new Locale(var3, var5);
        }
    }

    public static String getNLSLanguage(Locale var0) {
        String var1 = getOraLocale(var0);
        if (var1 == null) {
            return null;
        } else {
            int var2 = var1.indexOf(95);
            return var2 < 0 ? var1 : var1.substring(0, var2);
        }
    }

    public static String getNLSTerritory(Locale var0) {
        String var1 = getOraLocale(var0);
        if (var1 == null) {
            return null;
        } else {
            int var2 = var1.indexOf(95);
            return var2 < 0 ? null : var1.substring(var2 + 1);
        }
    }

    private static String getOraLocale(Locale var0) {
        if (var0 == null) {
            return null;
        } else {
            String var1 = var0.getLanguage().equals("") ? EN_LOCALE.getLanguage() : var0.getLanguage();
            if (ISO_A2_LANG_2_ORACLE_LANG == null) {
                ISO_A2_LANG_2_ORACLE_LANG = getIsoLangToOracleMap();
            }

            String var2 = (String)ISO_A2_LANG_2_ORACLE_LANG.get(var1);
            if (var2 == null) {
                return null;
            } else {
                String var3 = var0.getCountry();
                if (var3.equals("")) {
                    if (ISO_LANGUAGE_DEFAULT_TERRITORY == null) {
                        ISO_LANGUAGE_DEFAULT_TERRITORY = getIsoLangDefaultTerrMap();
                    }

                    var3 = (String)ISO_LANGUAGE_DEFAULT_TERRITORY.get(var1);
                    if (var3 == null) {
                        return null;
                    }
                }

                Locale var4 = new Locale(var1, var3);
                if (ISO_LOCALE_2_ORACLE_LOCALE == null) {
                    ISO_LOCALE_2_ORACLE_LOCALE = getIsoLocToOracleMap();
                }

                String var5 = (String)ISO_LOCALE_2_ORACLE_LOCALE.get(var4.toString());
                if (var5 != null) {
                    return var5;
                } else {
                    if ("es".equals(var1)) {
                        var2 = "LATIN AMERICAN SPANISH";
                    }

                    if (ISO_A2_TERR_2_ORACLE_TERR == null) {
                        ISO_A2_TERR_2_ORACLE_TERR = getIsoTerrToOracleMap();
                    }

                    String var6 = (String)ISO_A2_TERR_2_ORACLE_TERR.get(var3);
                    return var6 != null ? var2 + "_" + var6 : null;
                }
            }
        }
    }

    public static int getRatio(int var0, int var1) {
        if (var1 == var0) {
            return 1;
        } else {
            if (CHARSET_RATIO == null) {
                CHARSET_RATIO = getCharsetRatio();
            }

            Object var2 = CHARSET_RATIO.get(Integer.toString(var0));
            if (var2 == null) {
                return 0;
            } else {
                int var3 = Integer.parseInt((String)var2);
                var2 = CHARSET_RATIO.get(Integer.toString(var1));
                if (var2 == null) {
                    return 0;
                } else {
                    int var4 = Integer.parseInt((String)var2);
                    int var5 = var3 & 255;
                    if (var5 == 1) {
                        return 1;
                    } else if (var4 >>> 8 == 0) {
                        return var5;
                    } else {
                        int var6 = var4 & 255;
                        int var7 = var5 / var6;
                        if (var5 % var6 != 0) {
                            ++var7;
                        }

                        return var7;
                    }
                }
            }
        }
    }

    private static synchronized Map getLang2IsoLangMap() {
        HashMap var0 = new HashMap();
        var0.put("ALBANIAN", "sq");
        var0.put("AMERICAN", "en");
        var0.put("AMHARIC", "am");
        var0.put("ARABIC", "ar");
        var0.put("ARMENIAN", "hy");
        var0.put("ASSAMESE", "as");
        var0.put("AZERBAIJANI", "az");
        var0.put("BANGLA", "bn");
        var0.put("BELARUSIAN", "be");
        var0.put("BENGALI", "bn");
        var0.put("BRAZILIAN PORTUGUESE", "pt");
        var0.put("BULGARIAN", "bg");
        var0.put("CANADIAN FRENCH", "fr");
        var0.put("CATALAN", "ca");
        var0.put("CROATIAN", "hr");
        var0.put("CYRILLIC KAZAKH", "kk");
        var0.put("CYRILLIC SERBIAN", "sr");
        var0.put("CYRILLIC UZBEK", "uz");
        var0.put("CZECH", "cs");
        var0.put("DANISH", "da");
        var0.put("DARI", "pr");
        var0.put("DIVEHI", "dv");
        var0.put("DUTCH", "nl");
        var0.put("EGYPTIAN", "ar");
        var0.put("ENGLISH", "en");
        var0.put("ESTONIAN", "et");
        var0.put("FINNISH", "fi");
        var0.put("FRENCH", "fr");
        var0.put("GERMAN", "de");
        var0.put("GERMAN DIN", "de");
        var0.put("GREEK", "el");
        var0.put("GUJARATI", "gu");
        var0.put("HEBREW", "iw");
        var0.put("HINDI", "hi");
        var0.put("HUNGARIAN", "hu");
        var0.put("ICELANDIC", "is");
        var0.put("INDONESIAN", "in");
        var0.put("IRISH", "ga");
        var0.put("ITALIAN", "it");
        var0.put("JAPANESE", "ja");
        var0.put("KANNADA", "kn");
        var0.put("KHMER", "km");
        var0.put("KOREAN", "ko");
        var0.put("LAO", "lo");
        var0.put("LATIN AMERICAN SPANISH", "es");
        var0.put("LATIN BOSNIAN", "bs");
        var0.put("LATIN SERBIAN", "sh");
        var0.put("LATIN UZBEK", "uz");
        var0.put("LATVIAN", "lv");
        var0.put("LITHUANIAN", "lt");
        var0.put("MACEDONIAN", "mk");
        var0.put("MALAY", "ms");
        var0.put("MALAYALAM", "ml");
        var0.put("MALTESE", "mt");
        var0.put("MARATHI", "mr");
        var0.put("MEXICAN SPANISH", "es");
        var0.put("NEPALI", "ne");
        var0.put("NORWEGIAN", "no");
        var0.put("NUMERIC DATE LANGUAGE", "en");
        var0.put("ORIYA", "or");
        var0.put("PERSIAN", "fa");
        var0.put("POLISH", "pl");
        var0.put("PORTUGUESE", "pt");
        var0.put("PUNJABI", "pa");
        var0.put("ROMANIAN", "ro");
        var0.put("RUSSIAN", "ru");
        var0.put("SIMPLIFIED CHINESE", "zh");
        var0.put("SINHALA", "si");
        var0.put("SLOVAK", "sk");
        var0.put("SLOVENIAN", "sl");
        var0.put("SPANISH", "es");
        var0.put("SWAHILI", "sw");
        var0.put("SWEDISH", "sv");
        var0.put("TAMIL", "ta");
        var0.put("TELUGU", "te");
        var0.put("THAI", "th");
        var0.put("TRADITIONAL CHINESE", "zh");
        var0.put("TURKISH", "tr");
        var0.put("UKRAINIAN", "uk");
        var0.put("VIETNAMESE", "vi");
        return var0;
    }

    private static synchronized Map getTerr2IsoTerrMap() {
        HashMap var0 = new HashMap();
        var0.put("AFGHANISTAN", "AF");
        var0.put("ALBANIA", "AL");
        var0.put("ALGERIA", "DZ");
        var0.put("AMERICA", "US");
        var0.put("ARGENTINA", "AR");
        var0.put("ARMENIA", "AM");
        var0.put("AUSTRALIA", "AU");
        var0.put("AUSTRIA", "AT");
        var0.put("AZERBAIJAN", "AZ");
        var0.put("BAHAMAS", "BS");
        var0.put("BAHRAIN", "BH");
        var0.put("BANGLADESH", "BD");
        var0.put("BELARUS", "BY");
        var0.put("BELGIUM", "BE");
        var0.put("BELIZE", "BZ");
        var0.put("BERMUDA", "BM");
        var0.put("BOLIVIA", "BO");
        var0.put("BOSNIA AND HERZEGOVINA", "BA");
        var0.put("BRAZIL", "BR");
        var0.put("BULGARIA", "BG");
        var0.put("CAMBODIA", "KH");
        var0.put("CAMEROON", "CM");
        var0.put("CANADA", "CA");
        var0.put("CATALONIA", "ES");
        var0.put("CHILE", "CL");
        var0.put("CHINA", "CN");
        var0.put("CIS", "RU");
        var0.put("COLOMBIA", "CO");
        var0.put("CONGO BRAZZAVILLE", "CG");
        var0.put("CONGO KINSHASA", "CD");
        var0.put("COSTA RICA", "CR");
        var0.put("CROATIA", "HR");
        var0.put("CYPRUS", "CY");
        var0.put("CZECH REPUBLIC", "CZ");
        var0.put("CZECHOSLOVAKIA", "CZ");
        var0.put("DENMARK", "DK");
        var0.put("DJIBOUTI", "DJ");
        var0.put("ECUADOR", "EC");
        var0.put("EGYPT", "EG");
        var0.put("EL SALVADOR", "SV");
        var0.put("ESTONIA", "EE");
        var0.put("ETHIOPIA", "ET");
        var0.put("FINLAND", "FI");
        var0.put("FRANCE", "FR");
        var0.put("FYR MACEDONIA", "MK");
        var0.put("GABON", "GA");
        var0.put("GERMANY", "DE");
        var0.put("GREECE", "GR");
        var0.put("GUATEMALA", "GT");
        var0.put("HONDURAS", "HN");
        var0.put("HONG KONG", "HK");
        var0.put("HUNGARY", "HU");
        var0.put("ICELAND", "IS");
        var0.put("INDIA", "IN");
        var0.put("INDONESIA", "ID");
        var0.put("IRAN", "IR");
        var0.put("IRAQ", "IQ");
        var0.put("IRELAND", "IE");
        var0.put("ISRAEL", "IL");
        var0.put("ITALY", "IT");
        var0.put("IVORY COAST", "CI");
        var0.put("JAPAN", "JP");
        var0.put("JORDAN", "JO");
        var0.put("KAZAKHSTAN", "KZ");
        var0.put("KENYA", "KE");
        var0.put("KOREA", "KR");
        var0.put("KUWAIT", "KW");
        var0.put("LAOS", "LA");
        var0.put("LATVIA", "LV");
        var0.put("LEBANON", "LB");
        var0.put("LIBYA", "LY");
        var0.put("LITHUANIA", "LT");
        var0.put("LUXEMBOURG", "LU");
        var0.put("MACEDONIA", "MK");
        var0.put("MALAYSIA", "MY");
        var0.put("MALDIVES", "MV");
        var0.put("MALTA", "MT");
        var0.put("MAURITANIA", "MR");
        var0.put("MEXICO", "MX");
        var0.put("MONTENEGRO", "ME");
        var0.put("MOROCCO", "MA");
        var0.put("NEPAL", "NP");
        var0.put("NEW ZEALAND", "NZ");
        var0.put("NICARAGUA", "NI");
        var0.put("NIGERIA", "NG");
        var0.put("NORWAY", "NO");
        var0.put("OMAN", "OM");
        var0.put("PAKISTAN", "PK");
        var0.put("PANAMA", "PA");
        var0.put("PARAGUAY", "PY");
        var0.put("PERU", "PE");
        var0.put("PHILIPPINES", "PH");
        var0.put("POLAND", "PL");
        var0.put("PORTUGAL", "PT");
        var0.put("PUERTO RICO", "PR");
        var0.put("QATAR", "QA");
        var0.put("ROMANIA", "RO");
        var0.put("RUSSIA", "RU");
        var0.put("SAUDI ARABIA", "SA");
        var0.put("SENEGAL", "SN");
        var0.put("SERBIA", "RS");
        var0.put("SERBIA AND MONTENEGRO", "CS");
        var0.put("SINGAPORE", "SG");
        var0.put("SLOVAKIA", "SK");
        var0.put("SLOVENIA", "SI");
        var0.put("SOMALIA", "SO");
        var0.put("SOUTH AFRICA", "ZA");
        var0.put("SPAIN", "ES");
        var0.put("SRI LANKA", "LK");
        var0.put("SUDAN", "SD");
        var0.put("SWEDEN", "SE");
        var0.put("SWITZERLAND", "CH");
        var0.put("SYRIA", "SY");
        var0.put("TAIWAN", "TW");
        var0.put("TANZANIA", "TZ");
        var0.put("THAILAND", "TH");
        var0.put("THE NETHERLANDS", "NL");
        var0.put("TUNISIA", "TN");
        var0.put("TURKEY", "TR");
        var0.put("UGANDA", "UG");
        var0.put("UKRAINE", "UA");
        var0.put("UNITED ARAB EMIRATES", "AE");
        var0.put("UNITED KINGDOM", "GB");
        var0.put("URUGUAY", "UY");
        var0.put("UZBEKISTAN", "UZ");
        var0.put("VENEZUELA", "VE");
        var0.put("VIETNAM", "VN");
        var0.put("YEMEN", "YE");
        var0.put("YUGOSLAVIA", "YU");
        var0.put("ZAMBIA", "ZM");
        return var0;
    }

    private static synchronized Map getLang2Terr() {
        HashMap var0 = new HashMap();
        var0.put("ALBANIAN", "ALBANIA");
        var0.put("AMERICAN", "AMERICA");
        var0.put("AMHARIC", "ETHIOPIA");
        var0.put("ARABIC", "UNITED ARAB EMIRATES");
        var0.put("ARMENIAN", "ARMENIA");
        var0.put("ASSAMESE", "INDIA");
        var0.put("AZERBAIJANI", "AZERBAIJAN");
        var0.put("BANGLA", "INDIA");
        var0.put("BELARUSIAN", "BELARUS");
        var0.put("BRAZILIAN PORTUGUESE", "BRAZIL");
        var0.put("BULGARIAN", "BULGARIA");
        var0.put("CANADIAN FRENCH", "CANADA");
        var0.put("CATALAN", "CATALONIA");
        var0.put("CROATIAN", "CROATIA");
        var0.put("CYRILLIC KAZAKH", "KAZAKHSTAN");
        var0.put("CYRILLIC SERBIAN", "SERBIA");
        var0.put("CYRILLIC UZBEK", "UZBEKISTAN");
        var0.put("CZECH", "CZECH REPUBLIC");
        var0.put("DANISH", "DENMARK");
        var0.put("DARI", "AFGHANISTAN");
        var0.put("DIVEHI", "MALDIVES");
        var0.put("DUTCH", "THE NETHERLANDS");
        var0.put("EGYPTIAN", "EGYPT");
        var0.put("ENGLISH", "UNITED KINGDOM");
        var0.put("ESTONIAN", "ESTONIA");
        var0.put("FINNISH", "FINLAND");
        var0.put("FRENCH", "FRANCE");
        var0.put("GERMAN", "GERMANY");
        var0.put("GERMAN DIN", "GERMANY");
        var0.put("GREEK", "GREECE");
        var0.put("GUJARATI", "INDIA");
        var0.put("HEBREW", "ISRAEL");
        var0.put("HINDI", "INDIA");
        var0.put("HUNGARIAN", "HUNGARY");
        var0.put("ICELANDIC", "ICELAND");
        var0.put("INDONESIAN", "INDONESIA");
        var0.put("IRISH", "IRELAND");
        var0.put("ITALIAN", "ITALY");
        var0.put("JAPANESE", "JAPAN");
        var0.put("KANNADA", "INDIA");
        var0.put("KHMER", "CAMBODIA");
        var0.put("KOREAN", "KOREA");
        var0.put("LAO", "LAOS");
        var0.put("LATIN AMERICAN SPANISH", "AMERICA");
        var0.put("LATIN BOSNIAN", "BOSNIA AND HERZEGOVINA");
        var0.put("LATIN SERBIAN", "SERBIA");
        var0.put("LATIN UZBEK", "UZBEKISTAN");
        var0.put("LATVIAN", "LATVIA");
        var0.put("LITHUANIAN", "LITHUANIA");
        var0.put("MACEDONIAN", "FYR MACEDONIA");
        var0.put("MALAY", "MALAYSIA");
        var0.put("MALAYALAM", "INDIA");
        var0.put("MALTESE", "MALTA");
        var0.put("MARATHI", "INDIA");
        var0.put("MEXICAN SPANISH", "MEXICO");
        var0.put("NEPALI", "NEPAL");
        var0.put("NORWEGIAN", "NORWAY");
        var0.put("ORIYA", "INDIA");
        var0.put("PERSIAN", "IRAN");
        var0.put("POLISH", "POLAND");
        var0.put("PORTUGUESE", "PORTUGAL");
        var0.put("PUNJABI", "INDIA");
        var0.put("ROMANIAN", "ROMANIA");
        var0.put("RUSSIAN", "RUSSIA");
        var0.put("SIMPLIFIED CHINESE", "CHINA");
        var0.put("SINHALA", "SRI LANKA");
        var0.put("SLOVAK", "SLOVAKIA");
        var0.put("SLOVENIAN", "SLOVENIA");
        var0.put("SPANISH", "SPAIN");
        var0.put("SWAHILI", "KENYA");
        var0.put("SWEDISH", "SWEDEN");
        var0.put("TAMIL", "INDIA");
        var0.put("TELUGU", "INDIA");
        var0.put("THAI", "THAILAND");
        var0.put("TRADITIONAL CHINESE", "TAIWAN");
        var0.put("TURKISH", "TURKEY");
        var0.put("UKRAINIAN", "UKRAINE");
        var0.put("VIETNAMESE", "VIETNAM");
        return var0;
    }

    private static synchronized Map getIsoLangToOracleMap() {
        HashMap var0 = new HashMap();
        var0.put("am", "AMHARIC");
        var0.put("ar", "ARABIC");
        var0.put("as", "ASSAMESE");
        var0.put("az", "AZERBAIJANI");
        var0.put("be", "BELARUSIAN");
        var0.put("bg", "BULGARIAN");
        var0.put("bn", "BANGLA");
        var0.put("bs", "LATIN BOSNIAN");
        var0.put("ca", "CATALAN");
        var0.put("cs", "CZECH");
        var0.put("da", "DANISH");
        var0.put("de", "GERMAN");
        var0.put("dv", "DIVEHI");
        var0.put("el", "GREEK");
        var0.put("en", "ENGLISH");
        var0.put("es", "SPANISH");
        var0.put("et", "ESTONIAN");
        var0.put("fa", "PERSIAN");
        var0.put("fi", "FINNISH");
        var0.put("fr", "FRENCH");
        var0.put("ga", "IRISH");
        var0.put("gu", "GUJARATI");
        var0.put("he", "HEBREW");
        var0.put("hi", "HINDI");
        var0.put("hr", "CROATIAN");
        var0.put("hu", "HUNGARIAN");
        var0.put("hy", "ARMENIAN");
        var0.put("id", "INDONESIAN");
        var0.put("in", "INDONESIAN");
        var0.put("is", "ICELANDIC");
        var0.put("it", "ITALIAN");
        var0.put("iw", "HEBREW");
        var0.put("ja", "JAPANESE");
        var0.put("kk", "CYRILLIC KAZAKH");
        var0.put("km", "KHMER");
        var0.put("kn", "KANNADA");
        var0.put("ko", "KOREAN");
        var0.put("lo", "LAO");
        var0.put("lt", "LITHUANIAN");
        var0.put("lv", "LATVIAN");
        var0.put("mk", "MACEDONIAN");
        var0.put("ml", "MALAYALAM");
        var0.put("mr", "MARATHI");
        var0.put("ms", "MALAY");
        var0.put("mt", "MALTESE");
        var0.put("nb", "NORWEGIAN");
        var0.put("ne", "NEPALI");
        var0.put("nl", "DUTCH");
        var0.put("nn", "NORWEGIAN");
        var0.put("no", "NORWEGIAN");
        var0.put("or", "ORIYA");
        var0.put("pa", "PUNJABI");
        var0.put("pl", "POLISH");
        var0.put("pr", "DARI");
        var0.put("pt", "PORTUGUESE");
        var0.put("ro", "ROMANIAN");
        var0.put("ru", "RUSSIAN");
        var0.put("sh", "LATIN SERBIAN");
        var0.put("si", "SINHALA");
        var0.put("sk", "SLOVAK");
        var0.put("sl", "SLOVENIAN");
        var0.put("sq", "ALBANIAN");
        var0.put("sr", "CYRILLIC SERBIAN");
        var0.put("sv", "SWEDISH");
        var0.put("sw", "SWAHILI");
        var0.put("ta", "TAMIL");
        var0.put("te", "TELUGU");
        var0.put("th", "THAI");
        var0.put("tr", "TURKISH");
        var0.put("uk", "UKRAINIAN");
        var0.put("uz", "LATIN UZBEK");
        var0.put("vi", "VIETNAMESE");
        var0.put("zh", "SIMPLIFIED CHINESE");
        return var0;
    }

    private static synchronized Map getIsoLangDefaultTerrMap() {
        HashMap var0 = new HashMap();
        var0.put("am", "ET");
        var0.put("ar", "AE");
        var0.put("as", "IN");
        var0.put("az", "AZ");
        var0.put("be", "BY");
        var0.put("bg", "BG");
        var0.put("bn", "BD");
        var0.put("bs", "BA");
        var0.put("ca", "ES");
        var0.put("cs", "CZ");
        var0.put("da", "DK");
        var0.put("de", "DE");
        var0.put("dv", "MV");
        var0.put("el", "GR");
        var0.put("en", "US");
        var0.put("es", "ES");
        var0.put("et", "EE");
        var0.put("fa", "IR");
        var0.put("fi", "FI");
        var0.put("fr", "FR");
        var0.put("ga", "IE");
        var0.put("gu", "IN");
        var0.put("he", "IL");
        var0.put("hi", "IN");
        var0.put("hr", "HR");
        var0.put("hu", "HU");
        var0.put("hy", "AM");
        var0.put("id", "ID");
        var0.put("in", "ID");
        var0.put("is", "IS");
        var0.put("it", "IT");
        var0.put("iw", "IL");
        var0.put("ja", "JP");
        var0.put("kk", "KZ");
        var0.put("km", "KH");
        var0.put("kn", "IN");
        var0.put("ko", "KR");
        var0.put("lo", "LA");
        var0.put("lt", "LT");
        var0.put("lv", "LV");
        var0.put("mk", "MK");
        var0.put("ml", "IN");
        var0.put("mr", "IN");
        var0.put("ms", "MY");
        var0.put("mt", "MT");
        var0.put("nb", "NO");
        var0.put("ne", "NP");
        var0.put("nl", "NL");
        var0.put("nn", "NO");
        var0.put("no", "NO");
        var0.put("or", "IN");
        var0.put("pa", "IN");
        var0.put("pl", "PL");
        var0.put("pr", "AF");
        var0.put("pt", "PT");
        var0.put("ro", "RO");
        var0.put("ru", "RU");
        var0.put("si", "LK");
        var0.put("sk", "SK");
        var0.put("sl", "SI");
        var0.put("sq", "AL");
        var0.put("sr", "RS");
        var0.put("sv", "SE");
        var0.put("ta", "IN");
        var0.put("te", "IN");
        var0.put("th", "TH");
        var0.put("tr", "TR");
        var0.put("uk", "UA");
        var0.put("uz", "UZ");
        var0.put("vi", "VN");
        var0.put("zh", "CN");
        return var0;
    }

    private static synchronized Map getIsoLocToOracleMap() {
        HashMap var0 = new HashMap();
        var0.put("ar_EG", "EGYPTIAN_EGYPT");
        var0.put("ca_ES", "CATALAN_CATALONIA");
        var0.put("en_US", "AMERICAN_AMERICA");
        var0.put("es_ES", "SPANISH_SPAIN");
        var0.put("es_MX", "MEXICAN SPANISH_MEXICO");
        var0.put("fr_CA", "CANADIAN FRENCH_CANADA");
        var0.put("pt_BR", "BRAZILIAN PORTUGUESE_BRAZIL");
        var0.put("zh_HK", "TRADITIONAL CHINESE_HONG KONG");
        var0.put("zh_TW", "TRADITIONAL CHINESE_TAIWAN");
        return var0;
    }

    private static synchronized Map getIsoTerrToOracleMap() {
        HashMap var0 = new HashMap();
        var0.put("AE", "UNITED ARAB EMIRATES");
        var0.put("AF", "AFGHANISTAN");
        var0.put("AL", "ALBANIA");
        var0.put("AM", "ARMENIA");
        var0.put("AR", "ARGENTINA");
        var0.put("AT", "AUSTRIA");
        var0.put("AU", "AUSTRALIA");
        var0.put("AZ", "AZERBAIJAN");
        var0.put("BA", "BOSNIA AND HERZEGOVINA");
        var0.put("BD", "BANGLADESH");
        var0.put("BE", "BELGIUM");
        var0.put("BG", "BULGARIA");
        var0.put("BH", "BAHRAIN");
        var0.put("BM", "BERMUDA");
        var0.put("BO", "BOLIVIA");
        var0.put("BR", "BRAZIL");
        var0.put("BS", "BAHAMAS");
        var0.put("BY", "BELARUS");
        var0.put("BZ", "BELIZE");
        var0.put("CA", "CANADA");
        var0.put("CD", "CONGO KINSHASA");
        var0.put("CG", "CONGO BRAZZAVILLE");
        var0.put("CH", "SWITZERLAND");
        var0.put("CI", "IVORY COAST");
        var0.put("CL", "CHILE");
        var0.put("CM", "CAMEROON");
        var0.put("CN", "CHINA");
        var0.put("CO", "COLOMBIA");
        var0.put("CR", "COSTA RICA");
        var0.put("CS", "SERBIA AND MONTENEGRO");
        var0.put("CY", "CYPRUS");
        var0.put("CZ", "CZECH REPUBLIC");
        var0.put("DE", "GERMANY");
        var0.put("DJ", "DJIBOUTI");
        var0.put("DK", "DENMARK");
        var0.put("DZ", "ALGERIA");
        var0.put("EC", "ECUADOR");
        var0.put("EE", "ESTONIA");
        var0.put("EG", "EGYPT");
        var0.put("ES", "SPAIN");
        var0.put("ET", "ETHIOPIA");
        var0.put("FI", "FINLAND");
        var0.put("FR", "FRANCE");
        var0.put("GA", "GABON");
        var0.put("GB", "UNITED KINGDOM");
        var0.put("GR", "GREECE");
        var0.put("GT", "GUATEMALA");
        var0.put("HK", "HONG KONG");
        var0.put("HN", "HONDURAS");
        var0.put("HR", "CROATIA");
        var0.put("HU", "HUNGARY");
        var0.put("ID", "INDONESIA");
        var0.put("IE", "IRELAND");
        var0.put("IL", "ISRAEL");
        var0.put("IN", "INDIA");
        var0.put("IQ", "IRAQ");
        var0.put("IR", "IRAN");
        var0.put("IS", "ICELAND");
        var0.put("IT", "ITALY");
        var0.put("JO", "JORDAN");
        var0.put("JP", "JAPAN");
        var0.put("KE", "KENYA");
        var0.put("KH", "CAMBODIA");
        var0.put("KR", "KOREA");
        var0.put("KW", "KUWAIT");
        var0.put("KZ", "KAZAKHSTAN");
        var0.put("LA", "LAOS");
        var0.put("LB", "LEBANON");
        var0.put("LK", "SRI LANKA");
        var0.put("LT", "LITHUANIA");
        var0.put("LU", "LUXEMBOURG");
        var0.put("LV", "LATVIA");
        var0.put("LY", "LIBYA");
        var0.put("MA", "MOROCCO");
        var0.put("ME", "MONTENEGRO");
        var0.put("MK", "FYR MACEDONIA");
        var0.put("MR", "MAURITANIA");
        var0.put("MT", "MALTA");
        var0.put("MV", "MALDIVES");
        var0.put("MX", "MEXICO");
        var0.put("MY", "MALAYSIA");
        var0.put("NG", "NIGERIA");
        var0.put("NI", "NICARAGUA");
        var0.put("NL", "THE NETHERLANDS");
        var0.put("NO", "NORWAY");
        var0.put("NP", "NEPAL");
        var0.put("NZ", "NEW ZEALAND");
        var0.put("OM", "OMAN");
        var0.put("PA", "PANAMA");
        var0.put("PE", "PERU");
        var0.put("PH", "PHILIPPINES");
        var0.put("PK", "PAKISTAN");
        var0.put("PL", "POLAND");
        var0.put("PR", "PUERTO RICO");
        var0.put("PT", "PORTUGAL");
        var0.put("PY", "PARAGUAY");
        var0.put("QA", "QATAR");
        var0.put("RO", "ROMANIA");
        var0.put("RS", "SERBIA");
        var0.put("RU", "RUSSIA");
        var0.put("SA", "SAUDI ARABIA");
        var0.put("SD", "SUDAN");
        var0.put("SE", "SWEDEN");
        var0.put("SG", "SINGAPORE");
        var0.put("SI", "SLOVENIA");
        var0.put("SK", "SLOVAKIA");
        var0.put("SN", "SENEGAL");
        var0.put("SO", "SOMALIA");
        var0.put("SV", "EL SALVADOR");
        var0.put("SY", "SYRIA");
        var0.put("TH", "THAILAND");
        var0.put("TN", "TUNISIA");
        var0.put("TR", "TURKEY");
        var0.put("TW", "TAIWAN");
        var0.put("TZ", "TANZANIA");
        var0.put("UA", "UKRAINE");
        var0.put("UG", "UGANDA");
        var0.put("US", "AMERICA");
        var0.put("UY", "URUGUAY");
        var0.put("UZ", "UZBEKISTAN");
        var0.put("VE", "VENEZUELA");
        var0.put("VN", "VIETNAM");
        var0.put("YE", "YEMEN");
        var0.put("YU", "YUGOSLAVIA");
        var0.put("ZA", "SOUTH AFRICA");
        var0.put("ZM", "ZAMBIA");
        return var0;
    }

    private static synchronized Map getCharsetRatio() {
        HashMap var0 = new HashMap();
        var0.put("2000", "258");
        var0.put("873", "4");
        var0.put("557", "1");
        var0.put("558", "1");
        var0.put("559", "1");
        var0.put("565", "1");
        var0.put("566", "1");
        var0.put("500", "1");
        var0.put("320", "1");
        var0.put("70", "1");
        var0.put("36", "1");
        var0.put("560", "1");
        var0.put("556", "1");
        var0.put("554", "1");
        var0.put("561", "1");
        var0.put("563", "1");
        var0.put("555", "1");
        var0.put("52", "1");
        var0.put("173", "1");
        var0.put("140", "1");
        var0.put("191", "1");
        var0.put("194", "1");
        var0.put("314", "1");
        var0.put("47", "1");
        var0.put("179", "1");
        var0.put("197", "1");
        var0.put("43", "1");
        var0.put("390", "1");
        var0.put("233", "1");
        var0.put("48", "1");
        var0.put("19", "1");
        var0.put("235", "1");
        var0.put("185", "1");
        var0.put("322", "1");
        var0.put("323", "1");
        var0.put("317", "1");
        var0.put("188", "1");
        var0.put("325", "1");
        var0.put("326", "1");
        var0.put("35", "1");
        var0.put("49", "1");
        var0.put("196", "1");
        var0.put("51", "1");
        var0.put("158", "1");
        var0.put("159", "1");
        var0.put("171", "1");
        var0.put("11", "1");
        var0.put("207", "1");
        var0.put("222", "1");
        var0.put("189", "1");
        var0.put("180", "1");
        var0.put("204", "1");
        var0.put("225", "1");
        var0.put("198", "1");
        var0.put("182", "1");
        var0.put("14", "1");
        var0.put("202", "1");
        var0.put("224", "1");
        var0.put("232", "1");
        var0.put("184", "1");
        var0.put("301", "1");
        var0.put("316", "1");
        var0.put("32", "1");
        var0.put("262", "1");
        var0.put("162", "1");
        var0.put("263", "1");
        var0.put("163", "1");
        var0.put("170", "1");
        var0.put("150", "1");
        var0.put("110", "1");
        var0.put("113", "1");
        var0.put("81", "1");
        var0.put("327", "1");
        var0.put("381", "1");
        var0.put("324", "1");
        var0.put("211", "1");
        var0.put("37", "1");
        var0.put("266", "1");
        var0.put("166", "1");
        var0.put("174", "1");
        var0.put("380", "1");
        var0.put("382", "1");
        var0.put("386", "1");
        var0.put("385", "1");
        var0.put("172", "1");
        var0.put("12", "1");
        var0.put("201", "1");
        var0.put("223", "1");
        var0.put("208", "1");
        var0.put("186", "1");
        var0.put("401", "1");
        var0.put("368", "1");
        var0.put("17", "1");
        var0.put("206", "1");
        var0.put("200", "1");
        var0.put("181", "1");
        var0.put("25", "1");
        var0.put("265", "1");
        var0.put("165", "1");
        var0.put("161", "1");
        var0.put("23", "1");
        var0.put("187", "1");
        var0.put("92", "1");
        var0.put("315", "1");
        var0.put("38", "1");
        var0.put("267", "1");
        var0.put("167", "1");
        var0.put("175", "1");
        var0.put("154", "1");
        var0.put("833", "2");
        var0.put("835", "2");
        var0.put("830", "3");
        var0.put("837", "3");
        var0.put("831", "3");
        var0.put("836", "2");
        var0.put("832", "2");
        var0.put("838", "2");
        var0.put("834", "2");
        var0.put("829", "2");
        var0.put("842", "2");
        var0.put("840", "2");
        var0.put("845", "2");
        var0.put("846", "2");
        var0.put("590", "1");
        var0.put("114", "1");
        var0.put("176", "1");
        var0.put("383", "1");
        var0.put("384", "1");
        var0.put("192", "1");
        var0.put("193", "1");
        var0.put("195", "1");
        var0.put("205", "1");
        var0.put("190", "1");
        var0.put("16", "1");
        var0.put("40", "1");
        var0.put("34", "1");
        var0.put("18", "1");
        var0.put("153", "1");
        var0.put("155", "1");
        var0.put("152", "1");
        var0.put("13", "1");
        var0.put("203", "1");
        var0.put("226", "1");
        var0.put("199", "1");
        var0.put("183", "1");
        var0.put("33", "1");
        var0.put("15", "1");
        var0.put("21", "1");
        var0.put("353", "1");
        var0.put("354", "1");
        var0.put("41", "1");
        var0.put("42", "1");
        var0.put("319", "1");
        var0.put("22", "1");
        var0.put("82", "1");
        var0.put("93", "1");
        var0.put("312", "1");
        var0.put("264", "1");
        var0.put("164", "1");
        var0.put("177", "1");
        var0.put("156", "1");
        var0.put("1", "1");
        var0.put("221", "1");
        var0.put("277", "1");
        var0.put("4", "1");
        var0.put("871", "3");
        var0.put("872", "4");
        var0.put("45", "1");
        var0.put("44", "1");
        var0.put("231", "1");
        var0.put("230", "1");
        var0.put("239", "1");
        var0.put("2", "1");
        var0.put("241", "1");
        var0.put("96", "1");
        var0.put("100", "1");
        var0.put("7", "1");
        var0.put("97", "1");
        var0.put("98", "1");
        var0.put("9", "1");
        var0.put("27", "1");
        var0.put("99", "1");
        var0.put("95", "1");
        var0.put("8", "1");
        var0.put("5", "1");
        var0.put("90", "1");
        var0.put("6", "1");
        var0.put("91", "1");
        var0.put("94", "1");
        var0.put("101", "1");
        var0.put("210", "1");
        var0.put("3", "1");
        var0.put("278", "1");
        var0.put("31", "1");
        var0.put("46", "1");
        var0.put("39", "1");
        var0.put("279", "1");
        var0.put("351", "1");
        var0.put("352", "1");
        var0.put("178", "1");
        var0.put("251", "1");
        var0.put("50", "1");
        var0.put("10", "1");
        var0.put("28", "1");
        var0.put("160", "1");
        var0.put("261", "1");
        var0.put("20", "1");
        var0.put("850", "2");
        var0.put("853", "2");
        var0.put("852", "2");
        var0.put("851", "2");
        var0.put("854", "260");
        var0.put("865", "2");
        var0.put("866", "2");
        var0.put("864", "2");
        var0.put("862", "1");
        var0.put("868", "2");
        var0.put("992", "2");
        var0.put("867", "2");
        var0.put("860", "4");
        var0.put("861", "2");
        var0.put("863", "4");
        return var0;
    }

    private LxMetaData() {
    }
}
