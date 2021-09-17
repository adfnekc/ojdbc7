//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.nl;

import java.util.Vector;

public final class NVTokens {
    public static final int TKN_NONE = 0;
    public static final int TKN_LPAREN = 1;
    public static final int TKN_RPAREN = 2;
    public static final int TKN_COMMA = 3;
    public static final int TKN_EQUAL = 4;
    public static final int TKN_LITERAL = 8;
    public static final int TKN_EOS = 9;
    private static final char TKN_LPAREN_VALUE = '(';
    private static final char TKN_RPAREN_VALUE = ')';
    private static final char TKN_COMMA_VALUE = ',';
    private static final char TKN_EQUAL_VALUE = '=';
    private static final char TKN_BKSLASH_VALUE = '\\';
    private static final char TKN_DQUOTE_VALUE = '"';
    private static final char TKN_SQUOTE_VALUE = '\'';
    private static final char TKN_EOS_VALUE = '%';
    private static final char TKN_SPC_VALUE = ' ';
    private static final char TKN_TAB_VALUE = '\t';
    private static final char TKN_LF_VALUE = '\n';
    private static final char TKN_CR_VALUE = '\r';
    private Vector _tkType = null;
    private Vector _tkValue = null;
    private int _numTokens = 0;
    private int _tkPos = 0;

    public NVTokens() {
    }

    private static boolean _isWhiteSpace(char var0) {
        return var0 == ' ' || var0 == '\t' || var0 == '\n' || var0 == '\r';
    }

    private static String _trimWhiteSpace(String var0) {
        int var1 = var0.length();
        int var2 = 0;

        int var3;
        for(var3 = var1; var2 < var1 && _isWhiteSpace(var0.charAt(var2)); ++var2) {
        }

        while(var2 < var3 && _isWhiteSpace(var0.charAt(var3 - 1))) {
            --var3;
        }

        return var0.substring(var2, var3);
    }

    public boolean parseTokens(String var1) {
        this._numTokens = 0;
        this._tkPos = 0;
        this._tkType = new Vector(25, 25);
        this._tkValue = new Vector(25, 25);
        int var2 = var1.length();
        boolean var3 = false;
        char[] var4 = var1.toCharArray();
        int var5 = 0;

        while(true) {
            while(true) {
                do {
                    if (var5 >= var2) {
                        this._addToken(9, '%');
                        return true;
                    }

                    while(var5 < var2 && _isWhiteSpace(var4[var5])) {
                        ++var5;
                    }
                } while(var5 >= var2);

                switch(var4[var5]) {
                    case '(':
                        var3 = false;
                        this._addToken(1, '(');
                        ++var5;
                        continue;
                    case ')':
                        var3 = false;
                        this._addToken(2, ')');
                        ++var5;
                        continue;
                    case ',':
                        var3 = false;
                        this._addToken(3, ',');
                        ++var5;
                        continue;
                    case '=':
                        var3 = true;
                        this._addToken(4, '=');
                        ++var5;
                        continue;
                }

                int var6 = var5;
                int var7 = -1;
                boolean var8 = false;
                char var9 = '"';
                if (var4[var5] == '\'' || var4[var5] == '"') {
                    var8 = true;
                    var9 = var4[var5];
                    ++var5;
                }

                while(var5 < var2) {
                    if (var4[var5] == '\\') {
                        var5 += 2;
                    } else {
                        if (var8) {
                            if (var4[var5] == var9) {
                                ++var5;
                                var7 = var5;
                                break;
                            }
                        } else if (var4[var5] == '(' || var4[var5] == ')' || var4[var5] == ',' && !var3 || var4[var5] == '=' && !var3) {
                            var7 = var5;
                            break;
                        }

                        ++var5;
                    }
                }

                if (var7 == -1) {
                    var7 = var5;
                }

                this._addToken(8, _trimWhiteSpace(var1.substring(var6, var7)));
            }
        }
    }

    public int getToken() throws NLException {
        if (this._tkType == null) {
            throw new UninitializedObjectException("ParseError-04604", "");
        } else if (this._tkPos < this._numTokens) {
            return (Integer)this._tkType.elementAt(this._tkPos);
        } else {
            throw new NLException("NoLiterals-04610", "");
        }
    }

    public int popToken() throws UninitializedObjectException, NLException {
        boolean var1 = false;
        if (this._tkType == null) {
            throw new UninitializedObjectException("ParseError-04604", "");
        } else if (this._tkPos < this._numTokens) {
            int var2 = (Integer)this._tkType.elementAt(this._tkPos++);
            return var2;
        } else {
            throw new NLException("NoLiterals-04610", "");
        }
    }

    public String getLiteral() throws NLException {
        String var1 = null;
        if (this._tkValue == null) {
            throw new UninitializedObjectException("ParseError-04604", "");
        } else if (this._tkPos < this._numTokens) {
            var1 = (String)this._tkValue.elementAt(this._tkPos);
            return var1;
        } else {
            throw new NLException("NoLiterals-04610", "");
        }
    }

    public String popLiteral() throws NLException {
        String var1 = null;
        if (this._tkValue == null) {
            throw new UninitializedObjectException("ParseError-04604", "");
        } else if (this._tkPos < this._numTokens) {
            var1 = (String)this._tkValue.elementAt(this._tkPos++);
            return var1;
        } else {
            throw new NLException("NoLiterals-04610", "");
        }
    }

    public void eatToken() {
        if (this._tkPos < this._numTokens) {
            ++this._tkPos;
        }

    }

    public String toString() {
        if (this._tkType == null) {
            return "*NO TOKENS*";
        } else {
            String var1 = "Tokens";

            for(int var2 = 0; var2 < this._numTokens; ++var2) {
                var1 = var1 + " : " + this._tkValue.elementAt(var2);
            }

            return var1;
        }
    }

    public void println() {
        System.out.println(this.toString());
    }

    private void _addToken(int var1, char var2) {
        this._addToken(var1, String.valueOf(var2));
    }

    private void _addToken(int var1, String var2) {
        this._tkType.addElement(new Integer(var1));
        this._tkValue.addElement(var2);
        ++this._numTokens;
    }
}
