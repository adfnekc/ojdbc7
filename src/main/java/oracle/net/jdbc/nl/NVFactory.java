//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.nl;

public class NVFactory {
    public NVFactory() {
    }

    public NVPair createNVPair(String var1) throws InvalidSyntaxException, NLException {
        NVTokens var2 = new NVTokens();
        var2.parseTokens(var1);
        return this._readTopLevelNVPair(var2);
    }

    private NVPair _readTopLevelNVPair(NVTokens var1) throws InvalidSyntaxException, NLException {
        int var2 = var1.getToken();
        var1.eatToken();
        if (var2 != 1) {
            Object[] var5 = new Object[]{"(", this.getContext(var1)};
            throw new InvalidSyntaxException("SyntaxError-04602", var5);
        } else {
            String var3 = this._readNVLiteral(var1);
            NVPair var4 = new NVPair(var3);
            if ((var2 = var1.getToken()) != 3) {
                return this._readRightHandSide(var4, var1);
            } else {
                while(var2 == 8 || var2 == 3) {
                    var3 = var3 + var1.popLiteral();
                    var2 = var1.getToken();
                }

                var4.setName(var3);
                return this._readRightHandSide(var4, var1);
            }
        }
    }

    private NVPair _readNVPair(NVTokens var1) throws InvalidSyntaxException, NLException {
        int var2 = var1.getToken();
        var1.eatToken();
        if (var2 != 1 && var2 != 3) {
            Object[] var5 = new Object[]{"( or ,", this.getContext(var1)};
            throw new InvalidSyntaxException("SyntaxError-04602", var5);
        } else {
            String var3 = this._readNVLiteral(var1);
            NVPair var4 = new NVPair(var3);
            return this._readRightHandSide(var4, var1);
        }
    }

    private NVPair _readRightHandSide(NVPair var1, NVTokens var2) throws InvalidSyntaxException, NLException {
        int var3;
        Object[] var5;
        switch(var2.getToken()) {
            case 2:
            case 3:
                var1.setAtom(var1.getName());
                break;
            case 4:
                var2.eatToken();
                var3 = var2.getToken();
                if (var3 == 8) {
                    String var4 = this._readNVLiteral(var2);
                    var1.setAtom(var4);
                } else {
                    this._readNVList(var2, var1);
                }
                break;
            default:
                var5 = new Object[]{"=", this.getContext(var2)};
                throw new InvalidSyntaxException("SyntaxError-04602", var5);
        }

        var3 = var2.getToken();
        if (var3 == 2) {
            var2.eatToken();
        } else if (var3 != 3) {
            var5 = new Object[]{var2.getLiteral(), this.getContext(var2)};
            throw new InvalidSyntaxException("UnexpectedChar-04605", var5);
        }

        return var1;
    }

    private String _readNVLiteral(NVTokens var1) throws InvalidSyntaxException, NLException {
        int var2 = var1.getToken();
        if (var2 != 8) {
            Object[] var3 = new Object[]{"LITERAL", this.getContext(var1)};
            throw new InvalidSyntaxException("SyntaxError-04602", var3);
        } else {
            return var1.popLiteral();
        }
    }

    private void _readNVList(NVTokens var1, NVPair var2) throws InvalidSyntaxException, NLException {
        int var3 = var1.getToken();
        if (var3 == 1 || var3 == 3) {
            NVPair var4 = this._readNVPair(var1);
            var2.addListElement(var4);
            if ((var3 == 3 || var4.getName() == var4.getAtom()) && var2.getListType() != NVPair.LIST_COMMASEP) {
                var2.setListType(NVPair.LIST_COMMASEP);
            }

            this._readNVList(var1, var2);
        }
    }

    private String getContext(NVTokens var1) throws NLException {
        return " " + var1.popLiteral() + " " + var1.popLiteral() + " " + var1.popLiteral();
    }
}
