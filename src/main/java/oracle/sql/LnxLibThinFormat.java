package oracle.sql;

import java.sql.SQLException;
import oracle.core.lmx.CoreException;

class LnxLibThinFormat {
   boolean LNXNFFMI = false;
   boolean LNXNFFDS = false;
   boolean LNXNFFPR = false;
   boolean LNXNFFBL = false;
   boolean LNXNFFDA = false;
   boolean LNXNFFED = false;
   boolean LNXNFFSN = false;
   boolean LNXNFFVF = false;
   boolean LNXNFFSH = false;
   boolean LNXNFFST = false;
   boolean LNXNFFCH = false;
   boolean LNXNFFCT = false;
   boolean LNXNFFRC = false;
   boolean LNXNFFRN = false;
   boolean LNXNFFLC = false;
   boolean LNXNFFIC = false;
   boolean LNXNFNRD = false;
   boolean LNXNFRDX = false;
   boolean LNXNFFIL = false;
   boolean LNXNFFPT = false;
   boolean LNXNFF05 = false;
   boolean LNXNFFHX = false;
   boolean LNXNFFTM = false;
   boolean LNXNFFUN = false;
   byte[] lnxnfgps = new byte[40];
   int lnxnflhd = 0;
   int lnxnfrhd = 0;
   int lnxnfsiz = 0;
   int lnxnfzld = 0;
   int lnxnfztr = 0;
   private static final int LNXPFL_US = 1;
   private static final int LNXPFL_NLS = -1;
   private static final int LXM_LILCURR = 11;
   private static final int LXM_LIUCURR = 11;
   private static final int LXM_LIICURR = 8;
   private static final int LXM_ROMOUT = 15;

   public void parseFormat(String var1) throws SQLException {
      int var2 = 0;
      int var3 = 0;
      boolean var4 = false;
      boolean var5 = false;
      int var6 = 0;
      char var8 = 0;
      boolean var9 = false;
      int var11 = 0;
      int var12 = 0;
      char var13 = 0;
      char var14 = 0;
      int var15 = 0;
      byte var16 = 39;
      byte var17 = 0;
      int var18 = var1.length();
      char[] var10 = var1.toCharArray();

      for(this.LNXNFFIL = true; var18 != 0; --var18) {
         char var7;
         label592: {
            var7 = Character.toLowerCase(var10[var11]);
            switch(var7) {
            case '$':
               if (this.LNXNFFSN || this.LNXNFFDS || this.LNXNFFCH || this.LNXNFFCT || this.LNXNFFRC || this.LNXNFFHX) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               this.LNXNFFDS = true;
               ++var6;
               break label592;
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case '-':
            case '/':
            case '1':
            case '2':
            case '3':
            case '4':
            case '6':
            case '7':
            case '8':
            case ':':
            case ';':
            case '<':
            case '=':
            case '>':
            case '?':
            case '@':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '[':
            case '\\':
            case ']':
            case '^':
            case '_':
            case '`':
            case 'a':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'n':
            case 'o':
            case 'q':
            case 'w':
            default:
               throw new SQLException(CoreException.getMessage((byte)5));
            case ',':
               if (this.LNXNFFSN || this.LNXNFFHX || var4 || var15 == var16 || var17 < 0 || var2 == 0) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               var5 = true;
               this.lnxnfgps[var15] = (byte)var2;
               ++var15;
               var17 = 1;
               break label592;
            case '.':
               break;
            case '0':
            case '5':
            case '9':
            case 'x':
               if (this.LNXNFFSN) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               if (var8 == 'x' && var7 != 'x') {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               if (var7 == '5') {
                  if (var18 == 2) {
                     var13 = Character.toLowerCase(var10[var11 + 1]);
                  } else if (var18 == 3) {
                     var13 = Character.toLowerCase(var10[var11 + 1]);
                     var14 = Character.toLowerCase(var10[var11 + 2]);
                  }

                  if (this.LNXNFF05 || var18 != 1 && (var18 != 2 || var13 != 's') && var13 != 'c' && var13 != 'l' && var13 != 'u' && (var18 != 3 || (var13 != 'p' || var14 != 'r') && (var13 != 'p' || var14 != 't') && (var13 != 'm' || var14 != 'i'))) {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }

                  this.LNXNFF05 = true;
               }

               if (var7 == 'x') {
                  if (var8 != 0 && var8 != 'm' && var8 != '0' && var8 != 'x') {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }

                  this.LNXNFFHX = true;
                  if (var10[var11] == 'x') {
                     this.LNXNFFLC = true;
                  }
               }

               ++var2;
               if (var7 == '0' && (var4 || var3 == 0)) {
                  var3 = var2;
               }
               break label592;
            case 'b':
               if (this.LNXNFFSN || this.LNXNFFBL || this.LNXNFFHX) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               this.LNXNFFBL = true;
               break label592;
            case 'c':
            case 'l':
            case 'u':
               if (this.LNXNFFCH || this.LNXNFFCT || this.LNXNFFRC || this.LNXNFFSN || this.LNXNFFDS || this.LNXNFFHX) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               if (var7 == 'c') {
                  var6 += 7;
                  this.LNXNFFIC = true;
               } else if (var7 == 'l') {
                  var6 += 10;
               } else {
                  var6 += 10;
                  this.LNXNFFUN = true;
               }

               if (var11 == var12) {
                  this.LNXNFFCH = true;
                  break label592;
               }

               if (var18 == 2) {
                  var13 = Character.toLowerCase(var10[var11 + 1]);
               } else if (var18 == 3) {
                  var13 = Character.toLowerCase(var10[var11 + 1]);
                  var14 = Character.toLowerCase(var10[var11 + 2]);
               }

               if (var18 == 1 || var18 == 2 && var13 == 's' || var18 == 3 && (var13 == 'p' && var14 == 'r' || var13 == 'p' && var14 == 't' || var13 == 'm' && var14 == 'i')) {
                  this.LNXNFFCT = true;
                  break label592;
               }

               if (this.LNXNFF05) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               this.LNXNFFRC = true;
            case 'd':
               if (var17 > 0 || this.LNXNFFHX) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               var17 = -1;
            case 'v':
               if (var7 == 'v') {
                  this.LNXNFNRD = true;
               }
               break;
            case 'e':
               if (this.LNXNFFSN || this.LNXNFF05 || this.LNXNFFHX || var5) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               this.LNXNFFSN = true;
               if (var18 < 4 || var10[var11] != var10[var11 + 1] || var10[var11] != var10[var11 + 2] || var10[var11] != var10[var11 + 3]) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               var11 += 3;
               var18 -= 3;
               var6 += 5;
               break label592;
            case 'f':
               if (var11 != var12 || !this.LNXNFFIL) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               this.LNXNFFIL = false;
               ++var11;
               if (Character.toLowerCase(var10[var11]) != 'm') {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               --var18;
               var12 = var11 + 1;
               var7 = 'm';
               break label592;
            case 'g':
               if (this.LNXNFFSN || this.LNXNFFHX || var4 || var15 == var16 || var17 > 0 || var2 == 0) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               var17 = -1;
               this.lnxnfgps[var15] = (byte)(128 | var2);
               ++var15;
               break label592;
            case 'm':
               if (!this.LNXNFFSH && !this.LNXNFFST && !this.LNXNFFHX) {
                  this.LNXNFFMI = true;
                  ++var11;
                  if (Character.toLowerCase(var10[var11]) != 'i') {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }

                  --var18;
                  if (var18 > 1) {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }
                  break label592;
               }

               throw new SQLException(CoreException.getMessage((byte)5));
            case 'p':
               if (this.LNXNFFSH || this.LNXNFFST || this.LNXNFFHX) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               ++var6;
               --var18;
               if (var18 > 1) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               ++var11;
               if (Character.toLowerCase(var10[var11]) == 'r') {
                  this.LNXNFFPR = true;
               } else {
                  if (Character.toLowerCase(var10[var11]) != 't') {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }

                  this.LNXNFFPT = true;
               }
               break label592;
            case 'r':
               if (var11 == var12 && var18 == 2) {
                  this.LNXNFFRN = true;
                  if (var10[var11] == 'r') {
                     this.LNXNFFLC = true;
                  }

                  this.lnxnfsiz = 15;
                  this.LNXNFFVF = true;
                  return;
               }

               throw new SQLException(CoreException.getMessage((byte)5));
            case 's':
               if (this.LNXNFFSH || this.LNXNFFHX) {
                  throw new SQLException(CoreException.getMessage((byte)5));
               }

               if (var11 == var12) {
                  this.LNXNFFSH = true;
                  ++var12;
               } else {
                  if (var18 != 1) {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }

                  this.LNXNFFST = true;
               }
               break label592;
            case 't':
               if (var11 == var12 && var18 >= 2 && var18 <= 3) {
                  if (Character.toLowerCase(var10[var11 + 1]) != 'm') {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }

                  this.LNXNFFTM = true;
                  this.LNXNFFIL = false;
                  switch(var18 == 3 ? Character.toLowerCase(var10[var11 + 2]) : '9') {
                  case 'e':
                     this.LNXNFFSN = true;
                  case '9':
                     this.lnxnflhd = 0;
                     this.lnxnfrhd = 0;
                     this.lnxnfsiz = 64;
                     this.lnxnfzld = 0;
                     this.lnxnfztr = 0;
                     this.LNXNFFVF = true;
                     return;
                  default:
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }
               }

               throw new SQLException(CoreException.getMessage((byte)5));
            }

            if (this.LNXNFFSN || this.LNXNFFHX || var4) {
               throw new SQLException(CoreException.getMessage((byte)5));
            }

            var4 = true;
            this.lnxnflhd = var2;
            if (var3 != 0) {
               this.lnxnfzld = var2 - var3 + 1;
               var3 = 0;
            } else {
               this.lnxnfzld = 0;
            }

            var2 = 0;
            if (var7 == '.' || var7 == 'd') {
               ++var6;
               if (var7 == '.') {
                  if (var17 < 0) {
                     throw new SQLException(CoreException.getMessage((byte)5));
                  }

                  var17 = 1;
                  this.LNXNFRDX = true;
               }
            }
         }

         var8 = var7;
         ++var11;
      }

      if (var4) {
         this.lnxnfrhd = var2;
         this.lnxnfztr = !this.LNXNFFIL && !this.LNXNFNRD ? var3 : var2;
      } else {
         this.lnxnflhd = var2;
         this.lnxnfzld = var3 != 0 ? var2 - var3 + 1 : 0;
         this.lnxnfrhd = 0;
         this.lnxnfztr = 0;
         this.LNXNFNRD = true;
      }

      if (this.LNXNFFSN) {
         if (this.lnxnflhd <= 1) {
            if (this.lnxnflhd == 0) {
               throw new SQLException(CoreException.getMessage((byte)5));
            }
         } else {
            this.lnxnflhd = 1;
         }

         if (this.lnxnfzld > 1) {
            this.lnxnfzld = 1;
         }
      }

      var6 += this.lnxnflhd;
      var6 += this.lnxnfrhd;
      var6 += var15 + 1;
      if (var6 > 64) {
         throw new SQLException(CoreException.getMessage((byte)5));
      } else {
         this.lnxnfsiz = var6;
      }
   }
}
