package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.BitSet;
import java.util.Vector;
import oracle.jdbc.oracore.OracleTypeADT;

class T4CTTIrxd extends T4CTTIMsg {
   static final byte[] NO_BYTES = new byte[0];
   byte[] buffer;
   byte[] bufferCHAR;
   BitSet bvcColSent = null;
   int nbOfColumns = 0;
   boolean bvcFound = false;
   static final byte TTICMD_UNAUTHORIZED = 1;
   static int call_count = 0;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIrxd(T4CConnection var1) {
      super(var1, (byte)7);
   }

   void init() {
   }

   void setNumberOfColumns(int var1) {
      this.nbOfColumns = var1;
      this.bvcFound = false;
      if (this.bvcColSent != null && this.bvcColSent.length() >= this.nbOfColumns) {
         this.bvcColSent.clear();
      } else {
         this.bvcColSent = new BitSet(this.nbOfColumns);
      }

   }

   void unmarshalBVC(int var1) throws SQLException, IOException {
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < this.bvcColSent.length(); ++var3) {
         this.bvcColSent.clear(var3);
      }

      var3 = this.nbOfColumns / 8 + (this.nbOfColumns % 8 != 0 ? 1 : 0);

      for(int var4 = 0; var4 < var3; ++var4) {
         byte var5 = (byte)(this.meg.unmarshalUB1() & 255);

         for(int var6 = 0; var6 < 8; ++var6) {
            if ((var5 & 1 << var6) != 0) {
               this.bvcColSent.set(var4 * 8 + var6);
               ++var2;
            } else {
               this.bvcColSent.clear(var4 * 8 + var6);
            }
         }
      }

      if (var2 != var1) {
         SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), -1, "INTERNAL ERROR: oracle.jdbc.driver.T4CTTIrxd.unmarshalBVC: bits missing in vector");
         var7.fillInStackTrace();
         throw var7;
      } else {
         this.bvcFound = true;
      }
   }

   void readBitVector(byte[] var1) throws SQLException, IOException {
      int var2;
      for(var2 = 0; var2 < this.bvcColSent.length(); ++var2) {
         this.bvcColSent.clear(var2);
      }

      if (var1 != null && var1.length != 0) {
         for(var2 = 0; var2 < var1.length; ++var2) {
            byte var3 = var1[var2];

            for(int var4 = 0; var4 < 8; ++var4) {
               if ((var3 & 1 << var4) != 0) {
                  this.bvcColSent.set(var2 * 8 + var4);
               }
            }
         }

         this.bvcFound = true;
      } else {
         this.bvcFound = false;
      }

   }

   Vector marshal(byte[] var1, char[] var2, short[] var3, int var4, byte[] var5, DBConversion var6, InputStream[] var7, byte[][] var8, OracleTypeADT[] var9, byte[] var10, char[] var11, short[] var12, byte[] var13, int var14, int[] var15, boolean var16, int[] var17, int[] var18, int[][] var19, boolean var20) throws IOException {
      Vector var21 = null;

      try {
         this.marshalTTCcode();
         int var22 = var3[var4 + 0] & '\uffff';
         int var36 = 0;
         int var37 = var18[0];
         int[] var38 = var19[0];
         int var39 = 0;
         int var24;
         int var25;
         int var27;
         int var29;
         int var30;
         int var31;
         boolean var32;
         int var33;
         short var34;
         int var35;
         int var40;
         int var41;
         int var44;
         int var54;
         int var56;
         char var59;
         if (var20) {
            var40 = 1;

            assert var37 > 0 : "No postoned columns in RXD";
         } else {
            for(var41 = 0; var41 < var22; ++var41) {
               if (var36 < var37 && var38[var36] == var41) {
                  ++var36;
               } else {
                  boolean var42 = false;
                  var54 = var4 + 5 + 10 * var41;
                  var33 = var3[var54 + 0] & '\uffff';
                  if (var13 != null && (var13[var41] & 32) == 0) {
                     if (var33 == 998) {
                        ++var39;
                     }
                  } else {
                     var24 = ((var3[var54 + 7] & '\uffff') << 16) + (var3[var54 + 8] & '\uffff') + var14;
                     var35 = ((var3[var54 + 5] & '\uffff') << 16) + (var3[var54 + 6] & '\uffff') + var14;
                     var25 = var3[var24] & '\uffff';
                     var34 = var3[var35];
                     if (var33 == 116) {
                        this.meg.marshalUB1((short)1);
                        this.meg.marshalUB1((short)0);
                     } else {
                        int var58;
                        if (var33 == 994) {
                           var34 = -1;
                           var58 = var17[3 + var41 * 4 + 0];
                           if (var58 == 109) {
                              var42 = true;
                           }
                        } else if (var33 == 8 || var33 == 24 || !var16 && var15 != null && var15.length > var41 && var15[var41] > this.connection.maxNonStreamBindByteSize) {
                           if (var37 >= var38.length) {
                              int[] var43 = new int[var38.length << 1];
                              System.arraycopy(var38, 0, var43, 0, var38.length);
                              var38 = var43;
                           }

                           var38[var37++] = var41;
                           continue;
                        }

                        if (var34 == -1) {
                           if (var33 == 109 || var42) {
                              this.meg.marshalDALC(NO_BYTES);
                              this.meg.marshalDALC(NO_BYTES);
                              this.meg.marshalDALC(NO_BYTES);
                              this.meg.marshalUB2(0);
                              this.meg.marshalUB4(0L);
                              this.meg.marshalUB2(1);
                              continue;
                           }

                           if (var33 == 998) {
                              ++var39;
                              this.meg.marshalUB4(0L);
                              continue;
                           }

                           if (var33 == 112 || var33 == 113 || var33 == 114) {
                              this.meg.marshalUB4(0L);
                              continue;
                           }

                           if (var33 != 8 && var33 != 24) {
                              this.meg.marshalUB1((short)0);
                              continue;
                           }
                        }

                        int var47;
                        if (var33 == 998) {
                           var58 = (var12[6 + var39 * 8 + 4] & '\uffff') << 16 & 268431360 | var12[6 + var39 * 8 + 5] & '\uffff';
                           var44 = (var12[6 + var39 * 8 + 6] & '\uffff') << 16 & 268431360 | var12[6 + var39 * 8 + 7] & '\uffff';
                           int var63 = var12[6 + var39 * 8] & '\uffff';
                           int var46 = var12[6 + var39 * 8 + 1] & '\uffff';
                           this.meg.marshalUB4((long)var58);

                           for(var47 = 0; var47 < var58; ++var47) {
                              int var66 = var44 + var47 * var46;
                              if (var63 == 9) {
                                 var30 = var11[var66] / 2;
                                 var32 = false;
                                 var56 = var6.javaCharsToCHARBytes(var11, var66 + 1, var5, 0, var30);
                                 this.meg.marshalCLR(var5, var56);
                              } else {
                                 byte var55 = var10[var66];
                                 if (var55 < 1) {
                                    this.meg.marshalUB1((short)0);
                                 } else {
                                    this.meg.marshalCLR(var10, var66 + 1, var55);
                                 }
                              }
                           }

                           ++var39;
                        } else {
                           int var26 = var3[var54 + 1] & '\uffff';
                           if (var26 != 0) {
                              int var28 = ((var3[var54 + 3] & '\uffff') << 16) + (var3[var54 + 4] & '\uffff') + var26 * var14;
                              if (var33 == 6) {
                                 ++var28;
                                 --var25;
                              } else if (var33 == 9) {
                                 var28 += 2;
                                 var25 -= 2;
                              } else if (var33 == 114 || var33 == 113 || var33 == 112) {
                                 this.meg.marshalUB4((long)var25);
                              }

                              if (var33 != 109 && var33 != 111) {
                                 if (var33 == 104) {
                                    var28 += 2;
                                    long[] var62 = T4CRowidAccessor.stringToRowid(var1, var28, 18);
                                    byte var64 = 14;
                                    long var45 = var62[0];
                                    var47 = (int)var62[1];
                                    byte var48 = 0;
                                    long var49 = var62[2];
                                    int var51 = (int)var62[3];
                                    if (var45 == 0L && var47 == 0 && var49 == 0L && var51 == 0) {
                                       this.meg.marshalUB1((short)0);
                                    } else {
                                       this.meg.marshalUB1(var64);
                                       this.meg.marshalUB4(var45);
                                       this.meg.marshalUB2(var47);
                                       this.meg.marshalUB1(var48);
                                       this.meg.marshalUB4(var49);
                                       this.meg.marshalUB2(var51);
                                    }
                                 } else if (var33 == 208) {
                                    var28 += 2;
                                    var25 -= 2;
                                    this.meg.marshalUB4((long)var25);
                                    this.meg.marshalCLR(var1, var28, var25);
                                 } else if (var25 < 1) {
                                    this.meg.marshalUB1((short)0);
                                 } else {
                                    this.meg.marshalCLR(var1, var28, var25);
                                 }
                              } else {
                                 if (var8 == null) {
                                    SQLException var61 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), -1, "INTERNAL ERROR: oracle.jdbc.driver.T4CTTIrxd.marshal: parameterDatum is null");
                                    var61.fillInStackTrace();
                                    throw var61;
                                 }

                                 byte[] var60 = var8[var41];
                                 var25 = var60 == null ? 0 : var60.length;
                                 if (var33 == 109) {
                                    this.meg.marshalDALC(NO_BYTES);
                                    this.meg.marshalDALC(NO_BYTES);
                                    this.meg.marshalDALC(NO_BYTES);
                                    this.meg.marshalUB2(0);
                                    this.meg.marshalUB4((long)var25);
                                    this.meg.marshalUB2(1);
                                 }

                                 if (var25 > 0) {
                                    this.meg.marshalCLR(var60, 0, var25);
                                 }
                              }
                           } else {
                              var31 = var3[var54 + 9] & '\uffff';
                              var27 = var3[var54 + 2] & '\uffff';
                              var29 = ((var3[var54 + 3] & '\uffff') << 16) + (var3[var54 + 4] & '\uffff') + var27 * var14 + 1;
                              if (var33 != 996) {
                                 if (var33 == 96) {
                                    var30 = var25 / 2;
                                    --var29;
                                 } else {
                                    var30 = (var25 - 2) / 2;
                                 }

                                 var32 = false;
                                 if (var31 == 2) {
                                    var56 = var6.javaCharsToNCHARBytes(var2, var29, var5, 0, var30);
                                 } else {
                                    var56 = var6.javaCharsToCHARBytes(var2, var29, var5, 0, var30);
                                 }

                                 this.meg.marshalCLR(var5, var56);
                              } else {
                                 var59 = var2[var29 - 1];
                                 if (this.bufferCHAR == null || this.bufferCHAR.length < var59) {
                                    this.bufferCHAR = new byte[var59];
                                 }

                                 for(var44 = 0; var44 < var59; ++var44) {
                                    this.bufferCHAR[var44] = (byte)((var2[var29 + var44 / 2] & '\uff00') >> 8 & 255);
                                    if (var44 < var59 - 1) {
                                       this.bufferCHAR[var44 + 1] = (byte)(var2[var29 + var44 / 2] & 255 & 255);
                                       ++var44;
                                    }
                                 }

                                 this.meg.marshalCLR((byte[])this.bufferCHAR, var59);
                                 if (this.bufferCHAR.length > 4000) {
                                    this.bufferCHAR = null;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            var40 = var37;
         }

         if (var37 > 0) {
            for(var41 = 0; var41 < var40; ++var41) {
               int var57 = var38[var41];
               var54 = var4 + 5 + 10 * var57;
               var33 = var3[var54 + 0] & '\uffff';
               var24 = ((var3[var54 + 7] & '\uffff') << 16) + (var3[var54 + 8] & '\uffff') + var14;
               var35 = ((var3[var54 + 5] & '\uffff') << 16) + (var3[var54 + 6] & '\uffff') + var14;
               var34 = var3[var35];
               var25 = var3[var24] & '\uffff';
               var27 = var3[var54 + 2] & '\uffff';
               var29 = ((var3[var54 + 3] & '\uffff') << 16) + (var3[var54 + 4] & '\uffff') + var27 * var14 + 1;
               if (var34 == -1) {
                  this.meg.marshalUB1((short)0);
               } else if (var33 != 996) {
                  if (var33 != 8 && var33 != 24) {
                     if (var33 == 96) {
                        var30 = var25 / 2;
                        --var29;
                     } else {
                        var30 = (var25 - 2) / 2;
                     }

                     var31 = var3[var54 + 9] & '\uffff';
                     var32 = false;
                     if (var31 == 2) {
                        var56 = var6.javaCharsToNCHARBytes(var2, var29, var5, 0, var30);
                     } else {
                        var56 = var6.javaCharsToCHARBytes(var2, var29, var5, 0, var30);
                     }

                     this.meg.marshalCLR(var5, var56);
                  } else if (var7 != null) {
                     InputStream var65 = var7[var57];
                     if (var65 != null) {
                        try {
                           this.meg.marshalCLR((InputStream)var65, 0);
                        } catch (IOException var52) {
                           if (var21 == null) {
                              var21 = new Vector();
                           }

                           var21.add(var52);
                        }
                     }
                  }
               } else {
                  var59 = var2[var29 - 1];
                  if (this.bufferCHAR == null || this.bufferCHAR.length < var59) {
                     this.bufferCHAR = new byte[var59];
                  }

                  for(var44 = 0; var44 < var59; ++var44) {
                     this.bufferCHAR[var44] = (byte)((var2[var29 + var44 / 2] & '\uff00') >> 8 & 255);
                     if (var44 < var59 - 1) {
                        this.bufferCHAR[var44 + 1] = (byte)(var2[var29 + var44 / 2] & 255 & 255);
                        ++var44;
                     }
                  }

                  this.meg.marshalCLR((byte[])this.bufferCHAR, var59);
                  if (this.bufferCHAR.length > 4000) {
                     this.bufferCHAR = null;
                  }
               }
            }
         }

         var18[0] = var37;
         var19[0] = var38;
         return var21;
      } catch (SQLException var53) {
         IOException var23 = new IOException();
         var23.initCause(var53);
         throw var23;
      }
   }

   boolean unmarshal(Accessor[] var1, int var2) throws SQLException, IOException {
      return this.unmarshal(var1, 0, var2);
   }

   void copyRowsAsNeeded(Accessor[] var1, int var2) throws SQLException, IOException {
      int[] var3 = new int[this.nbOfColumns];
      int var4 = 0;
      int var5 = Math.min(var2, var1.length);

      for(int var6 = 0; var6 < var5; ++var6) {
         Accessor var7 = var1[var6];
         if (!var7.isUseLess && !this.bvcColSent.get(var7.physicalColumnIndex)) {
            var3[var4++] = var6;
         }
      }

      int var8;
      for(long var17 = -1L; var4 > 0; var3[var8] = var3[var4]) {
         var8 = 0;
         Accessor var9 = var1[var3[var8]];
         long var10 = var9.getOffset(var9.getPreviousRowProcessed());

         int var12;
         for(var12 = 1; var12 < var4; ++var12) {
            int var10000 = var3[var12];
            var9 = var1[var3[var12]];
            long var14 = var9.getOffset(var9.getPreviousRowProcessed());
            if (var14 < var10) {
               var10 = var14;
               var8 = var12;
               if (var14 == -1L) {
                  break;
               }
            }
         }

         var12 = var3[var8];
         var9 = var1[var12];

         assert var9.isNull(var9.getPreviousRowProcessed()) || var17 < var10 : "lastOffset: " + var17 + "\tleastOffset: " + var10 + "\tindexOfLeastOffet: " + var8;

         var17 = var10;

         try {
            var9.copyRow();
         } catch (AssertionError var16) {
            String var18 = this.dumpIndicesOfColumnsToBeCopied(var4, var3, var1);
            AssertionError var15 = new AssertionError(var18 + "\nlastOffset: " + var10 + "\tleastOffset: " + var10 + "\tindexOfLeastOffet: " + var8);
            var15.initCause(var16);
            throw var15;
         }

         --var4;
      }

   }

   boolean unmarshal(Accessor[] var1, int var2, int var3) throws SQLException, IOException {
      int var4;
      for(var4 = var2; var4 < var3 && var4 < var1.length; ++var4) {
         if (var1[var4] != null && var1[var4].physicalColumnIndex < 0) {
            int var5 = 0;

            for(int var6 = 0; var6 < var3 && var6 < var1.length; ++var6) {
               if (var1[var6] != null) {
                  var1[var6].physicalColumnIndex = var5;
                  if (!var1[var6].isUseLess) {
                     ++var5;
                  }
               }
            }
         }
      }

      if (this.bvcFound && var2 == 0) {
         this.copyRowsAsNeeded(var1, var3);
      }

      for(var4 = var2; var4 < var3 && var4 < var1.length; ++var4) {
         if (var1[var4] != null && (!this.bvcFound || var1[var4].isUseLess || this.bvcColSent.get(var1[var4].physicalColumnIndex))) {
            if (var1[var4].statement.statementType == 2 || var1[var4].statement.sqlKind.isPlsqlOrCall()) {
               var1[var4].setCapacity(1);
            }

            if (var1[var4].unmarshalOneRow()) {
               return true;
            }
         }
      }

      this.bvcFound = false;
      return false;
   }

   String dumpIndicesOfColumnsToBeCopied(int var1, int[] var2, Accessor[] var3) throws SQLException {
      StringWriter var4 = new StringWriter();
      PrintWriter var5 = new PrintWriter(var4);
      var5.println("dump indicesOfColumnsToBeCopied call_count: " + call_count++ + " numColumnsToBeCopied: " + var1);

      for(int var6 = 0; var6 < var1; ++var6) {
         long var7 = var3[var2[var6]].getOffset(0);
         var5.println("copy order: " + var6 + " index: " + var2[var6] + " offset: " + var7);
      }

      var5.println();
      return var4.toString();
   }

   boolean unmarshal(Accessor[] var1, int var2, int var3, int var4) throws SQLException, IOException {
      return false;
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
