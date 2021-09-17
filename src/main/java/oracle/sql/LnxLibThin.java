//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Locale.Category;
import oracle.core.lmx.CoreException;

class LnxLibThin implements LnxLib {
    private static final byte[] lnxqone = new byte[]{-63, 2};
    private static final byte[] lnxqtwo = new byte[]{-63, 3};
    private static final int LNXQACOS = 0;
    private static final int LNXQASIN = 1;
    private static final int LNXQATAN = 2;
    private static final int LNXQCOS = 3;
    private static final int LNXQSIN = 4;
    private static final int LNXQTAN = 5;
    private static final int LNXQCSH = 6;
    private static final int LNXQSNH = 7;
    private static final int LNXQTNH = 8;
    private static final int LNXQEXP = 9;
    private static final int LNXM_NUM = 22;
    private static final int LNXDIGS = 20;
    private static final int LNXSGNBT = 128;
    private static final int LNXEXPMX = 127;
    private static final int LNXEXPMN = 0;
    private static final int LNXEXPBS = 64;
    private static final int LNXBASE = 100;
    private static final int LNXMXFMT = 64;
    private static final int LNXMXOUT = 40;
    private static final int LNXDIV_LNXBASE_SQUARED = 10000;
    private static final int MINUB1MAXVAL = 255;
    private static final double ORANUM_FBASE = 100.0D;
    private static final int LNXQNOSGN = 127;
    private static final char LNXNFT_COMMA = ',';
    private static final int LNXBYTEMASK = 255;
    private static final int LNXSHORTMASK = 65535;
    private static byte[] LnxqFirstDigit = new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static byte[] LnxqNegate = new byte[]{0, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static byte[] LnxqTruncate_P = new byte[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 61, 61, 61, 61, 61, 61, 61, 61, 61, 61, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 81, 81, 81, 81, 81, 81, 81, 81, 81, 81, 91, 91, 91, 91, 91, 91, 91, 91, 91, 91};
    private static byte[] LnxqTruncate_N = new byte[]{0, 0, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 61, 61, 61, 61, 61, 61, 61, 61, 61, 61, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 81, 81, 81, 81, 81, 81, 81, 81, 81, 81, 91, 91, 91, 91, 91, 91, 91, 91, 91, 91, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101};
    private static byte[] LnxqRound_P = new byte[]{0, 1, 1, 1, 1, 1, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 61, 61, 61, 61, 61, 61, 61, 61, 61, 61, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 81, 81, 81, 81, 81, 81, 81, 81, 81, 81, 91, 91, 91, 91, 91, 91, 91, 91, 91, 91, 101, 101, 101, 101, 101};
    private static byte[] LnxqRound_N = new byte[]{0, 0, 1, 1, 1, 1, 1, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 61, 61, 61, 61, 61, 61, 61, 61, 61, 61, 71, 71, 71, 71, 71, 71, 71, 71, 71, 71, 81, 81, 81, 81, 81, 81, 81, 81, 81, 81, 91, 91, 91, 91, 91, 91, 91, 91, 91, 91, 101, 101, 101, 101, 101};
    private static byte[][] LnxqComponents_P = new byte[][]{{0, 0}, {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, {0, 8}, {0, 9}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {1, 9}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}, {2, 8}, {2, 9}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5}, {4, 6}, {4, 7}, {4, 8}, {4, 9}, {5, 0}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 5}, {5, 6}, {5, 7}, {5, 8}, {5, 9}, {6, 0}, {6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}, {6, 8}, {6, 9}, {7, 0}, {7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}, {7, 7}, {7, 8}, {7, 9}, {8, 0}, {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5}, {8, 6}, {8, 7}, {8, 8}, {8, 9}, {9, 0}, {9, 1}, {9, 2}, {9, 3}, {9, 4}, {9, 5}, {9, 6}, {9, 7}, {9, 8}, {9, 9}};
    private static byte[][] LnxqComponents_N = new byte[][]{{0, 0}, {0, 0}, {9, 9}, {9, 8}, {9, 7}, {9, 6}, {9, 5}, {9, 4}, {9, 3}, {9, 2}, {9, 1}, {9, 0}, {8, 9}, {8, 8}, {8, 7}, {8, 6}, {8, 5}, {8, 4}, {8, 3}, {8, 2}, {8, 1}, {8, 0}, {7, 9}, {7, 8}, {7, 7}, {7, 6}, {7, 5}, {7, 4}, {7, 3}, {7, 2}, {7, 1}, {7, 0}, {6, 9}, {6, 8}, {6, 7}, {6, 6}, {6, 5}, {6, 4}, {6, 3}, {6, 2}, {6, 1}, {6, 0}, {5, 9}, {5, 8}, {5, 7}, {5, 6}, {5, 5}, {5, 4}, {5, 3}, {5, 2}, {5, 1}, {5, 0}, {4, 9}, {4, 8}, {4, 7}, {4, 6}, {4, 5}, {4, 4}, {4, 3}, {4, 2}, {4, 1}, {4, 0}, {3, 9}, {3, 8}, {3, 7}, {3, 6}, {3, 5}, {3, 4}, {3, 3}, {3, 2}, {3, 1}, {3, 0}, {2, 9}, {2, 8}, {2, 7}, {2, 6}, {2, 5}, {2, 4}, {2, 3}, {2, 2}, {2, 1}, {2, 0}, {1, 9}, {1, 8}, {1, 7}, {1, 6}, {1, 5}, {1, 4}, {1, 3}, {1, 2}, {1, 1}, {1, 0}, {0, 9}, {0, 8}, {0, 7}, {0, 6}, {0, 5}, {0, 4}, {0, 3}, {0, 2}, {0, 1}, {0, 0}};
    private static byte[][] LnxqAdd_PPP = new byte[][]{{0, 0}, {0, 1}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}, {10, 0}, {11, 0}, {12, 0}, {13, 0}, {14, 0}, {15, 0}, {16, 0}, {17, 0}, {18, 0}, {19, 0}, {20, 0}, {21, 0}, {22, 0}, {23, 0}, {24, 0}, {25, 0}, {26, 0}, {27, 0}, {28, 0}, {29, 0}, {30, 0}, {31, 0}, {32, 0}, {33, 0}, {34, 0}, {35, 0}, {36, 0}, {37, 0}, {38, 0}, {39, 0}, {40, 0}, {41, 0}, {42, 0}, {43, 0}, {44, 0}, {45, 0}, {46, 0}, {47, 0}, {48, 0}, {49, 0}, {50, 0}, {51, 0}, {52, 0}, {53, 0}, {54, 0}, {55, 0}, {56, 0}, {57, 0}, {58, 0}, {59, 0}, {60, 0}, {61, 0}, {62, 0}, {63, 0}, {64, 0}, {65, 0}, {66, 0}, {67, 0}, {68, 0}, {69, 0}, {70, 0}, {71, 0}, {72, 0}, {73, 0}, {74, 0}, {75, 0}, {76, 0}, {77, 0}, {78, 0}, {79, 0}, {80, 0}, {81, 0}, {82, 0}, {83, 0}, {84, 0}, {85, 0}, {86, 0}, {87, 0}, {88, 0}, {89, 0}, {90, 0}, {91, 0}, {92, 0}, {93, 0}, {94, 0}, {95, 0}, {96, 0}, {97, 0}, {98, 0}, {99, 0}, {100, 0}, {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1}, {10, 1}, {11, 1}, {12, 1}, {13, 1}, {14, 1}, {15, 1}, {16, 1}, {17, 1}, {18, 1}, {19, 1}, {20, 1}, {21, 1}, {22, 1}, {23, 1}, {24, 1}, {25, 1}, {26, 1}, {27, 1}, {28, 1}, {29, 1}, {30, 1}, {31, 1}, {32, 1}, {33, 1}, {34, 1}, {35, 1}, {36, 1}, {37, 1}, {38, 1}, {39, 1}, {40, 1}, {41, 1}, {42, 1}, {43, 1}, {44, 1}, {45, 1}, {46, 1}, {47, 1}, {48, 1}, {49, 1}, {50, 1}, {51, 1}, {52, 1}, {53, 1}, {54, 1}, {55, 1}, {56, 1}, {57, 1}, {58, 1}, {59, 1}, {60, 1}, {61, 1}, {62, 1}, {63, 1}, {64, 1}, {65, 1}, {66, 1}, {67, 1}, {68, 1}, {69, 1}, {70, 1}, {71, 1}, {72, 1}, {73, 1}, {74, 1}, {75, 1}, {76, 1}, {77, 1}, {78, 1}, {79, 1}, {80, 1}, {81, 1}, {82, 1}, {83, 1}, {84, 1}, {85, 1}, {86, 1}, {87, 1}, {88, 1}, {89, 1}, {90, 1}, {91, 1}, {92, 1}, {93, 1}, {94, 1}, {95, 1}, {96, 1}, {97, 1}, {98, 1}, {99, 1}, {100, 1}};
    private static byte[][] LnxqAdd_NNN = new byte[][]{{0, 2}, {0, 1}, {0, 0}, {0, 0}, {0, 0}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1}, {10, 1}, {11, 1}, {12, 1}, {13, 1}, {14, 1}, {15, 1}, {16, 1}, {17, 1}, {18, 1}, {19, 1}, {20, 1}, {21, 1}, {22, 1}, {23, 1}, {24, 1}, {25, 1}, {26, 1}, {27, 1}, {28, 1}, {29, 1}, {30, 1}, {31, 1}, {32, 1}, {33, 1}, {34, 1}, {35, 1}, {36, 1}, {37, 1}, {38, 1}, {39, 1}, {40, 1}, {41, 1}, {42, 1}, {43, 1}, {44, 1}, {45, 1}, {46, 1}, {47, 1}, {48, 1}, {49, 1}, {50, 1}, {51, 1}, {52, 1}, {53, 1}, {54, 1}, {55, 1}, {56, 1}, {57, 1}, {58, 1}, {59, 1}, {60, 1}, {61, 1}, {62, 1}, {63, 1}, {64, 1}, {65, 1}, {66, 1}, {67, 1}, {68, 1}, {69, 1}, {70, 1}, {71, 1}, {72, 1}, {73, 1}, {74, 1}, {75, 1}, {76, 1}, {77, 1}, {78, 1}, {79, 1}, {80, 1}, {81, 1}, {82, 1}, {83, 1}, {84, 1}, {85, 1}, {86, 1}, {87, 1}, {88, 1}, {89, 1}, {90, 1}, {91, 1}, {92, 1}, {93, 1}, {94, 1}, {95, 1}, {96, 1}, {97, 1}, {98, 1}, {99, 1}, {100, 1}, {101, 1}, {2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}, {9, 2}, {10, 2}, {11, 2}, {12, 2}, {13, 2}, {14, 2}, {15, 2}, {16, 2}, {17, 2}, {18, 2}, {19, 2}, {20, 2}, {21, 2}, {22, 2}, {23, 2}, {24, 2}, {25, 2}, {26, 2}, {27, 2}, {28, 2}, {29, 2}, {30, 2}, {31, 2}, {32, 2}, {33, 2}, {34, 2}, {35, 2}, {36, 2}, {37, 2}, {38, 2}, {39, 2}, {40, 2}, {41, 2}, {42, 2}, {43, 2}, {44, 2}, {45, 2}, {46, 2}, {47, 2}, {48, 2}, {49, 2}, {50, 2}, {51, 2}, {52, 2}, {53, 2}, {54, 2}, {55, 2}, {56, 2}, {57, 2}, {58, 2}, {59, 2}, {60, 2}, {61, 2}, {62, 2}, {63, 2}, {64, 2}, {65, 2}, {66, 2}, {67, 2}, {68, 2}, {69, 2}, {70, 2}, {71, 2}, {72, 2}, {73, 2}, {74, 2}, {75, 2}, {76, 2}, {77, 2}, {78, 2}, {79, 2}, {80, 2}, {81, 2}, {82, 2}, {83, 2}, {84, 2}, {85, 2}, {86, 2}, {87, 2}, {88, 2}, {89, 2}, {90, 2}, {91, 2}, {92, 2}, {93, 2}, {94, 2}, {95, 2}, {96, 2}, {97, 2}, {98, 2}, {99, 2}, {100, 2}, {101, 2}};
    private static byte[][] LnxqAdd_PNP = new byte[][]{{0, 2}, {0, 1}, {0, 0}, {0, 0}, {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1}, {10, 1}, {11, 1}, {12, 1}, {13, 1}, {14, 1}, {15, 1}, {16, 1}, {17, 1}, {18, 1}, {19, 1}, {20, 1}, {21, 1}, {22, 1}, {23, 1}, {24, 1}, {25, 1}, {26, 1}, {27, 1}, {28, 1}, {29, 1}, {30, 1}, {31, 1}, {32, 1}, {33, 1}, {34, 1}, {35, 1}, {36, 1}, {37, 1}, {38, 1}, {39, 1}, {40, 1}, {41, 1}, {42, 1}, {43, 1}, {44, 1}, {45, 1}, {46, 1}, {47, 1}, {48, 1}, {49, 1}, {50, 1}, {51, 1}, {52, 1}, {53, 1}, {54, 1}, {55, 1}, {56, 1}, {57, 1}, {58, 1}, {59, 1}, {60, 1}, {61, 1}, {62, 1}, {63, 1}, {64, 1}, {65, 1}, {66, 1}, {67, 1}, {68, 1}, {69, 1}, {70, 1}, {71, 1}, {72, 1}, {73, 1}, {74, 1}, {75, 1}, {76, 1}, {77, 1}, {78, 1}, {79, 1}, {80, 1}, {81, 1}, {82, 1}, {83, 1}, {84, 1}, {85, 1}, {86, 1}, {87, 1}, {88, 1}, {89, 1}, {90, 1}, {91, 1}, {92, 1}, {93, 1}, {94, 1}, {95, 1}, {96, 1}, {97, 1}, {98, 1}, {99, 1}, {100, 1}, {1, 2}, {2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}, {9, 2}, {10, 2}, {11, 2}, {12, 2}, {13, 2}, {14, 2}, {15, 2}, {16, 2}, {17, 2}, {18, 2}, {19, 2}, {20, 2}, {21, 2}, {22, 2}, {23, 2}, {24, 2}, {25, 2}, {26, 2}, {27, 2}, {28, 2}, {29, 2}, {30, 2}, {31, 2}, {32, 2}, {33, 2}, {34, 2}, {35, 2}, {36, 2}, {37, 2}, {38, 2}, {39, 2}, {40, 2}, {41, 2}, {42, 2}, {43, 2}, {44, 2}, {45, 2}, {46, 2}, {47, 2}, {48, 2}, {49, 2}, {50, 2}, {51, 2}, {52, 2}, {53, 2}, {54, 2}, {55, 2}, {56, 2}, {57, 2}, {58, 2}, {59, 2}, {60, 2}, {61, 2}, {62, 2}, {63, 2}, {64, 2}, {65, 2}, {66, 2}, {67, 2}, {68, 2}, {69, 2}, {70, 2}, {71, 2}, {72, 2}, {73, 2}, {74, 2}, {75, 2}, {76, 2}, {77, 2}, {78, 2}, {79, 2}, {80, 2}, {81, 2}, {82, 2}, {83, 2}, {84, 2}, {85, 2}, {86, 2}, {87, 2}, {88, 2}, {89, 2}, {90, 2}, {91, 2}, {92, 2}, {93, 2}, {94, 2}, {95, 2}, {96, 2}, {97, 2}, {98, 2}, {99, 2}, {100, 2}};
    private static byte[][] LnxqAdd_PNN = new byte[][]{{0, 0}, {0, 1}, {0, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}, {10, 0}, {11, 0}, {12, 0}, {13, 0}, {14, 0}, {15, 0}, {16, 0}, {17, 0}, {18, 0}, {19, 0}, {20, 0}, {21, 0}, {22, 0}, {23, 0}, {24, 0}, {25, 0}, {26, 0}, {27, 0}, {28, 0}, {29, 0}, {30, 0}, {31, 0}, {32, 0}, {33, 0}, {34, 0}, {35, 0}, {36, 0}, {37, 0}, {38, 0}, {39, 0}, {40, 0}, {41, 0}, {42, 0}, {43, 0}, {44, 0}, {45, 0}, {46, 0}, {47, 0}, {48, 0}, {49, 0}, {50, 0}, {51, 0}, {52, 0}, {53, 0}, {54, 0}, {55, 0}, {56, 0}, {57, 0}, {58, 0}, {59, 0}, {60, 0}, {61, 0}, {62, 0}, {63, 0}, {64, 0}, {65, 0}, {66, 0}, {67, 0}, {68, 0}, {69, 0}, {70, 0}, {71, 0}, {72, 0}, {73, 0}, {74, 0}, {75, 0}, {76, 0}, {77, 0}, {78, 0}, {79, 0}, {80, 0}, {81, 0}, {82, 0}, {83, 0}, {84, 0}, {85, 0}, {86, 0}, {87, 0}, {88, 0}, {89, 0}, {90, 0}, {91, 0}, {92, 0}, {93, 0}, {94, 0}, {95, 0}, {96, 0}, {97, 0}, {98, 0}, {99, 0}, {100, 0}, {101, 0}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1}, {10, 1}, {11, 1}, {12, 1}, {13, 1}, {14, 1}, {15, 1}, {16, 1}, {17, 1}, {18, 1}, {19, 1}, {20, 1}, {21, 1}, {22, 1}, {23, 1}, {24, 1}, {25, 1}, {26, 1}, {27, 1}, {28, 1}, {29, 1}, {30, 1}, {31, 1}, {32, 1}, {33, 1}, {34, 1}, {35, 1}, {36, 1}, {37, 1}, {38, 1}, {39, 1}, {40, 1}, {41, 1}, {42, 1}, {43, 1}, {44, 1}, {45, 1}, {46, 1}, {47, 1}, {48, 1}, {49, 1}, {50, 1}, {51, 1}, {52, 1}, {53, 1}, {54, 1}, {55, 1}, {56, 1}, {57, 1}, {58, 1}, {59, 1}, {60, 1}, {61, 1}, {62, 1}, {63, 1}, {64, 1}, {65, 1}, {66, 1}, {67, 1}, {68, 1}, {69, 1}, {70, 1}, {71, 1}, {72, 1}, {73, 1}, {74, 1}, {75, 1}, {76, 1}, {77, 1}, {78, 1}, {79, 1}, {80, 1}, {81, 1}, {82, 1}, {83, 1}, {84, 1}, {85, 1}, {86, 1}, {87, 1}, {88, 1}, {89, 1}, {90, 1}, {91, 1}, {92, 1}, {93, 1}, {94, 1}, {95, 1}, {96, 1}, {97, 1}, {98, 1}, {99, 1}, {100, 1}, {101, 1}};
    private static byte[] LnxsubIdentity = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101};
    private static byte[][] LnxqDigit_P = new byte[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, {21, 22, 23, 24, 25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36, 37, 38, 39, 40}, {41, 42, 43, 44, 45, 46, 47, 48, 49, 50}, {51, 52, 53, 54, 55, 56, 57, 58, 59, 60}, {61, 62, 63, 64, 65, 66, 67, 68, 69, 70}, {71, 72, 73, 74, 75, 76, 77, 78, 79, 80}, {81, 82, 83, 84, 85, 86, 87, 88, 89, 90}, {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}};
    private static byte[][] LnxqDigit_N = new byte[][]{{101, 100, 99, 98, 97, 96, 95, 94, 93, 92}, {91, 90, 89, 88, 87, 86, 85, 84, 83, 82}, {81, 80, 79, 78, 77, 76, 75, 74, 73, 72}, {71, 70, 69, 68, 67, 66, 65, 64, 63, 62}, {61, 60, 59, 58, 57, 56, 55, 54, 53, 52}, {51, 50, 49, 48, 47, 46, 45, 44, 43, 42}, {41, 40, 39, 38, 37, 36, 35, 34, 33, 32}, {31, 30, 29, 28, 27, 26, 25, 24, 23, 22}, {21, 20, 19, 18, 17, 16, 15, 14, 13, 12}, {11, 10, 9, 8, 7, 6, 5, 4, 3, 2}};
    private static final double[][] powerTable = new double[][]{{128.0D, 1.0E256D, 1.0E-256D}, {64.0D, 1.0E128D, 1.0E-128D}, {32.0D, 1.0E64D, 1.0E-64D}, {16.0D, 1.0E32D, 1.0E-32D}, {8.0D, 1.0E16D, 1.0E-16D}, {4.0D, 1.0E8D, 1.0E-8D}, {2.0D, 10000.0D, 1.0E-4D}, {1.0D, 100.0D, 0.01D}};
    private static final double[][] factorTable = new double[][]{{15.0D, 1.0E30D, 1.0E-30D}, {14.0D, 1.0E28D, 1.0E-28D}, {13.0D, 1.0E26D, 1.0E-26D}, {12.0D, 1.0E24D, 1.0E-24D}, {11.0D, 1.0E22D, 1.0E-22D}, {10.0D, 1.0E20D, 1.0E-20D}, {9.0D, 1.0E18D, 1.0E-18D}, {8.0D, 1.0E16D, 1.0E-16D}, {7.0D, 1.0E14D, 1.0E-14D}, {6.0D, 1.0E12D, 1.0E-12D}, {5.0D, 1.0E10D, 1.0E-10D}, {4.0D, 1.0E8D, 1.0E-8D}, {3.0D, 1000000.0D, 1.0E-6D}, {2.0D, 10000.0D, 1.0E-4D}, {1.0D, 100.0D, 0.01D}, {0.0D, 1.0D, 1.0D}, {-1.0D, 0.01D, 100.0D}, {-2.0D, 1.0E-4D, 10000.0D}, {-3.0D, 1.0E-6D, 1000000.0D}, {-4.0D, 1.0E-8D, 1.0E8D}, {-5.0D, 1.0E-10D, 1.0E10D}, {-6.0D, 1.0E-12D, 1.0E12D}, {-7.0D, 1.0E-14D, 1.0E14D}, {-8.0D, 1.0E-16D, 1.0E16D}, {-9.0D, 1.0E-18D, 1.0E18D}, {-10.0D, 1.0E-20D, 1.0E20D}, {-11.0D, 1.0E-22D, 1.0E22D}, {-12.0D, 1.0E-24D, 1.0E24D}, {-13.0D, 1.0E-26D, 1.0E26D}, {-14.0D, 1.0E-28D, 1.0E28D}, {-15.0D, 1.0E-30D, 1.0E30D}, {-16.0D, 1.0E-32D, 1.0E32D}, {-17.0D, 1.0E-34D, 1.0E34D}, {-18.0D, 1.0E-36D, 1.0E36D}, {-19.0D, 1.0E-38D, 1.0E38D}, {-20.0D, 1.0E-40D, 1.0E40D}, {-21.0D, 1.0E-42D, 1.0E42D}, {-22.0D, 1.0E-44D, 1.0E44D}, {-23.0D, 1.0E-46D, 1.0E46D}, {-24.0D, 1.0E-48D, 1.0E48D}, {-25.0D, 1.0E-50D, 1.0E50D}, {-26.0D, 1.0E-52D, 1.0E52D}, {-27.0D, 1.0E-54D, 1.0E54D}, {-28.0D, 1.0E-56D, 1.0E56D}, {-29.0D, 1.0E-58D, 1.0E58D}, {-30.0D, 1.0E-60D, 1.0E60D}, {-31.0D, 1.0E-62D, 1.0E62D}, {-32.0D, 1.0E-64D, 1.0E64D}, {-33.0D, 1.0E-66D, 1.0E66D}, {-34.0D, 1.0E-68D, 1.0E68D}};
    private char[] lnx_chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', ' ', '.', ',', '$', '<', '>', '(', ')', '#', '~', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'l', 'm', 'p', 'r', 's', 't', 'v', 'A', 'B', 'C', 'D', 'E', 'F', 'I', 'L', 'M', 'P', 'R', 'S', 'T'};

    LnxLibThin() {
    }

    public byte[] lnxabs(byte[] var1) throws SQLException {
        byte[] var2 = new byte[var1.length];
        if (NUMBER._isPositive(var1)) {
            System.arraycopy(var1, 0, var2, 0, var1.length);
            return var2;
        } else if (NUMBER._isNegInf(var1)) {
            return NUMBER.posInf().shareBytes();
        } else {
            int var3 = var1.length;
            if (var1[var3 - 1] == 102) {
                --var3;
            }

            System.arraycopy(var1, 0, var2, 0, var3);
            _negateNumber(var2);
            return _setLength(var2, var3);
        }
    }

    public byte[] lnxacos(byte[] var1) throws SQLException {
        return this.lnxqtri(var1, 0);
    }

    public byte[] lnxadd(byte[] var1, byte[] var2) throws SQLException {
        int var3 = var1.length;
        byte var4 = 0;
        int var5 = var2.length;
        byte var6 = 0;
        byte[] var7 = new byte[41];
        byte var8 = 0;
        int var14 = 0;
        int var15 = 0;
        boolean var24 = false;
        boolean var25 = false;
        boolean var26 = false;
        int var18 = var8 + 1;
        boolean var27 = NUMBER._isPositive(var1);
        int var29 = var1[0] < 0 ? 256 + var1[0] : 255 - var1[0];
        if (!var27 && var1[var3 - 1] == 102) {
            --var3;
        }

        int var28 = var3 - 1;
        boolean var30 = NUMBER._isPositive(var2);
        int var32 = var2[0] < 0 ? 256 + var2[0] : 255 - var2[0];
        if (!var30 && var2[var5 - 1] == 102) {
            --var5;
        }

        int var31 = var5 - 1;
        if (var29 != 255 || var28 != 0 && var1[1] != 101) {
            if (var32 != 255 || var31 != 0 && var2[1] != 101) {
                if (var29 == 128 && var28 == 0) {
                    var7 = new byte[var5];
                    System.arraycopy(var2, 0, var7, 0, var5);
                    return _setLength(var7, var5);
                } else if (var32 == 128 && var31 == 0) {
                    var7 = new byte[var3];
                    System.arraycopy(var1, 0, var7, 0, var3);
                    return _setLength(var7, var3);
                } else {
                    int var23 = var29 - var32;
                    byte[][] var9;
                    boolean var33;
                    byte var36;
                    byte var37;
                    int var39;
                    int var40;
                    if (var27 == var30) {
                        var33 = var27;
                        if (var27) {
                            var9 = LnxqAdd_PPP;
                            var36 = 1;
                            var37 = 1;
                        } else {
                            var9 = LnxqAdd_NNN;
                            var36 = 101;
                            var37 = -1;
                        }
                    } else {
                        int var42 = var23;
                        if (var23 == 0) {
                            var39 = var4 + 1;
                            var40 = var6 + 1;

                            int var41;
                            for(var41 = var4 + (var28 < var31 ? var28 : var31); var39 <= var41 && var1[var39] + var2[var40] == 102; ++var40) {
                                ++var39;
                            }

                            if (var39 <= var41) {
                                var42 = var27 ? var1[var39] + var2[var40] - 102 : 102 - (var1[var39] + var2[var40]);
                            } else {
                                var42 = var28 - var31;
                            }
                        }

                        if (var42 == 0) {
                            return NUMBER._makeZero();
                        }

                        var33 = var42 > 0 ? var27 : var30;
                        if (var33) {
                            var9 = LnxqAdd_PNP;
                            var36 = 1;
                            var37 = -1;
                        } else {
                            var9 = LnxqAdd_PNN;
                            var36 = 101;
                            var37 = 1;
                        }
                    }

                    int var12;
                    byte var13;
                    int var16;
                    byte var17;
                    boolean var22;
                    int var34;
                    int var35;
                    int var43;
                    int var44;
                    int var45;
                    if (var23 >= 0) {
                        var34 = var29;
                        if (var23 + var31 <= var28) {
                            var43 = var23;
                            var44 = var31;
                            var45 = var28 - (var23 + var31);
                            var12 = var4 + var23;
                            var13 = 1;
                            var14 = var12 + var31;
                            var15 = var6 + var31;
                            var16 = var4 + var28;
                            var17 = 1;
                            var35 = var28;
                            var22 = var45 != 0 && var27 != var33;
                        } else if (var23 < var28) {
                            var43 = var23;
                            var44 = var28 - var23;
                            var45 = var31 - var44;
                            var12 = var4 + var23;
                            var13 = 1;
                            var14 = var4 + var28;
                            var15 = var6 + var44;
                            var16 = var6 + var31;
                            var17 = 2;
                            var35 = var23 + var31;
                            var22 = var30 != var33;
                        } else {
                            var43 = var28;
                            var44 = -(var23 - var28);
                            var45 = var31;
                            var12 = var4 + var28;
                            var13 = 1;
                            var16 = var6 + var31;
                            var17 = 2;
                            var35 = var23 + var31;
                            var22 = var30 != var33;
                        }
                    } else {
                        var34 = var32;
                        var23 = -var23;
                        if (var23 + var28 <= var31) {
                            var43 = var23;
                            var44 = var28;
                            var45 = var31 - (var23 + var28);
                            var12 = var6 + var23;
                            var13 = 2;
                            var14 = var4 + var28;
                            var15 = var12 + var28;
                            var16 = var6 + var31;
                            var17 = 2;
                            var35 = var31;
                            var22 = var45 != 0 && var30 != var33;
                        } else if (var23 < var31) {
                            var43 = var23;
                            var44 = var31 - var23;
                            var45 = var28 - var44;
                            var12 = var6 + var23;
                            var13 = 2;
                            var14 = var4 + var44;
                            var15 = var6 + var31;
                            var16 = var4 + var28;
                            var17 = 1;
                            var35 = var23 + var28;
                            var22 = var27 != var33;
                        } else {
                            var43 = var31;
                            var44 = -(var23 - var31);
                            var45 = var28;
                            var12 = var6 + var31;
                            var13 = 2;
                            var16 = var4 + var28;
                            var17 = 1;
                            var35 = var23 + var28;
                            var22 = var27 != var33;
                        }
                    }

                    if (var35 > 20) {
                        if (var23 > 20) {
                            var44 = 0;
                            var45 = 0;
                            var35 = var43;
                            var22 = false;
                        } else {
                            var18 = 1;
                        }
                    }

                    int var19 = var18 + (var35 - 1);
                    int var20 = var19;
                    int var21;
                    if (var45 != 0) {
                        var21 = var19 - var45;
                        if (var17 == 1) {
                            var7[var19] = var1[var16];
                        } else {
                            var7[var19] = var2[var16];
                        }

                        --var16;
                        var20 = var19 - 1;
                        if (var22) {
                            while(var20 > var21) {
                                if (var17 == 1) {
                                    var7[var20] = (byte)(var1[var16] + var37);
                                } else {
                                    var7[var20] = (byte)(var2[var16] + var37);
                                }

                                --var16;
                                --var20;
                            }
                        } else {
                            while(var20 > var21) {
                                if (var17 == 1) {
                                    var7[var20] = var1[var16];
                                } else {
                                    var7[var20] = var2[var16];
                                }

                                --var16;
                                --var20;
                            }
                        }
                    }

                    if (var44 > 0) {
                        var21 = var20 - var44;
                        byte var10 = 0;
                        int var11 = var22 ? var10 + 1 : var10;

                        do {
                            var11 = var10 + var1[var14] + var2[var15] + var9[var11][1];
                            var7[var20] = var9[var11][0];
                            --var14;
                            --var15;
                            --var20;
                        } while(var20 > var21);

                        var22 = (var9[var11][1] & 1) != 0;
                    } else {
                        var39 = var22 ? (var37 == 1 ? 2 : 100) : var36;

                        for(var21 = var20 + var44; var20 > var21; --var20) {
                            var7[var20] = (byte)var39;
                        }
                    }

                    if (var43 != 0) {
                        var21 = var20 - var43;
                        if (var22) {
                            var39 = (var37 == 1 ? 100 : 1) + (var33 ? 0 : 1);
                            var40 = (var37 == 1 ? 1 : 100) + (var33 ? 0 : 1);

                            do {
                                if (var13 == 1) {
                                    var22 = var1[var12] == var39;
                                    var7[var20] = (byte)(var22 ? var40 : var1[var12] + var37);
                                } else {
                                    var22 = var2[var12] == var39;
                                    var7[var20] = (byte)(var22 ? var40 : var2[var12] + var37);
                                }

                                --var12;
                                --var20;
                            } while(var22 && var20 > var21);
                        }

                        while(var20 > var21) {
                            if (var13 == 1) {
                                var7[var20] = var1[var12];
                            } else {
                                var7[var20] = var2[var12];
                            }

                            --var12;
                            --var20;
                        }
                    }

                    if (var22) {
                        if (var34 == 255) {
                            if (var33) {
                                return NUMBER._makePosInf();
                            }

                            return NUMBER._makeNegInf();
                        }

                        --var18;
                        var7[var18] = (byte)(var33 ? 2 : 100);
                        ++var34;
                        ++var35;
                    }

                    if (var7[var18] == var36) {
                        do {
                            ++var18;
                            --var34;
                            --var35;
                        } while(var7[var18] == var36);

                        if (var34 < 128) {
                            return NUMBER._makeZero();
                        }
                    }

                    if (var35 > 20) {
                        var19 = var18 + 19;
                        var35 = 20;
                        if ((var33 ? var7[var19 + 1] : LnxqNegate[var7[var19 + 1]]) > 50) {
                            var39 = var33 ? 100 : 2;
                            if (!var22) {
                                var7[var18 - 1] = (byte)var36;
                            }

                            while(var7[var19] == var39) {
                                --var19;
                                --var35;
                            }

                            if (var19 < var18) {
                                if (var34 == 255) {
                                    if (var33) {
                                        return NUMBER._makePosInf();
                                    }

                                    return NUMBER._makeNegInf();
                                }

                                --var18;
                                ++var34;
                                var35 = 1;
                            }

                            var7[var19] = (byte)(var7[var19] + (var33 ? 1 : -1));
                        }
                    }

                    while(var7[var19] == var36) {
                        --var19;
                        --var35;
                    }

                    if (var18 != 1) {
                        byte[] var46 = new byte[41];
                        System.arraycopy(var7, var18, var46, 1, var35);
                        System.arraycopy(var46, 1, var7, 1, var35);
                    }

                    int var38 = var35 + 1;
                    if (!var33 && var38 <= 20) {
                        var7[var38] = 102;
                        ++var38;
                    }

                    var7[var8] = (byte)(var33 ? var34 - 256 : 255 - var34);
                    return _setLength(var7, var38);
                }
            } else {
                return var30 ? NUMBER._makePosInf() : NUMBER._makeNegInf();
            }
        } else {
            return var27 ? NUMBER._makePosInf() : NUMBER._makeNegInf();
        }
    }

    public byte[] lnxasin(byte[] var1) throws SQLException {
        return this.lnxqtri(var1, 1);
    }

    public byte[] lnxatan(byte[] var1) throws SQLException {
        return this.lnxqtri(var1, 2);
    }

    public byte[] lnxatan2(byte[] var1, byte[] var2) throws SQLException {
        if (NUMBER._isZero(var1) && NUMBER._isZero(var2)) {
            throw new SQLException(CoreException.getMessage((byte)11));
        } else {
            byte[] var3 = this.lnxdiv(var1, var2);
            var3 = this.lnxatan(var3);
            if (NUMBER._isPositive(var2)) {
                return var3;
            } else {
                byte[] var4 = NUMBER.pi().shareBytes();
                return NUMBER._isPositive(var1) ? this.lnxadd(var3, var4) : this.lnxsub(var3, var4);
            }
        }
    }

    public byte[] lnxbex(byte[] var1, byte[] var2) throws SQLException {
        byte[] var3;
        switch(this.lnxsgn(var1)) {
            case -1:
                if ((new NUMBER(var2)).isInt()) {
                    var3 = this.lnxneg(var1);
                    var3 = this.lnxln(var3);
                    var3 = this.lnxmul(var2, var3);
                    var3 = this.lnxexp(var3);
                    if (!NUMBER._isZero(this.lnxmod(var2, lnxqtwo))) {
                        var3 = this.lnxneg(var3);
                    }

                    return var3;
                }

                return NUMBER._makePosInf();
            case 0:
                if (NUMBER._isZero(var2)) {
                    var3 = new byte[lnxqone.length];
                    System.arraycopy(lnxqone, 0, var3, 0, lnxqone.length);
                    return var3;
                }

                return NUMBER._makeZero();
            case 1:
                var3 = this.lnxln(var1);
                var3 = this.lnxmul(var2, var3);
                return this.lnxexp(var3);
            default:
                return null;
        }
    }

    public byte[] lnxcos(byte[] var1) throws SQLException {
        return this.lnxqtra(var1, 3);
    }

    public byte[] lnxcsh(byte[] var1) throws SQLException {
        return this.lnxqtra(var1, 6);
    }

    public byte[] lnxdec(byte[] var1) throws SQLException {
        int var5 = var1.length;
        byte[] var6 = new byte[22];
        System.arraycopy(var1, 0, var6, 0, var5);
        if (NUMBER._isPositive(var6)) {
            int var2 = (byte)((var6[0] & -129) - 65);
            if (var2 >= 0 && var2 <= 18) {
                int var3 = var2 + 1;
                int var4 = var5 - 1;
                if (var3 <= var4) {
                    --var6[var3];
                    if (var6[var3] == 1 && var3 == var4) {
                        --var5;
                        if (var5 == 1) {
                            return NUMBER._makeZero();
                        }
                    }
                } else {
                    --var6[var4];

                    while(var3 > var4) {
                        var6[var3] = 100;
                        --var3;
                    }

                    if (var6[1] == 1) {
                        for(int var7 = 1; var7 <= var2; ++var7) {
                            var6[var7] = var6[var7 + 1];
                        }

                        --var2;
                    }

                    var5 = var2 + 2;
                }

                var6[0] = (byte)(var2 + 128 + 64 + 1);
                byte[] var8 = new byte[var5];
                System.arraycopy(var6, 0, var8, 0, var5);
                return var8;
            }
        }

        return NUMBER._makeZero();
    }

    public byte[] lnxdiv(byte[] var1, byte[] var2) throws SQLException {
        byte[] var3 = var1;
        int var4 = var1.length;
        byte[] var5 = var2;
        int var6 = var2.length;
        byte[] var7 = new byte[22];
        int[] var12 = new int[22];
        int[] var17 = new int[10];
        int[] var24 = new int[13];
        boolean var10 = var1[0] >> 7 != 0;
        byte var11 = var1[0];
        if (!var10) {
            var11 = (byte)(~var11);
            if (var1[var4 - 1] == 102) {
                --var4;
            }
        }

        boolean var15 = var2[0] >> 7 != 0;
        byte var16 = var2[0];
        if (!var15) {
            var16 = (byte)(~var16);
            if (var2[var6 - 1] == 102) {
                --var6;
            }
        }

        if ((var16 & 255) == 128 && var6 == 1) {
            return var10 == var15 ? NUMBER._makePosInf() : NUMBER._makeNegInf();
        } else if ((var11 & 255) == 128 && var4 == 1) {
            return NUMBER._makeZero();
        } else {
            byte var30;
            if (var4 == 1) {
                var30 = 0;
            } else {
                var30 = 1;
            }

            if ((var11 & 255) == 255 && (var4 == 2 || var1[var30] == 101) || var4 == 1 && var1[0] == 0) {
                return var10 == var15 ? NUMBER._makePosInf() : NUMBER._makeNegInf();
            } else {
                if (var6 == 1) {
                    var30 = 0;
                } else {
                    var30 = 1;
                }

                if ((var16 & 255) == 255 && (var6 == 2 || var2[var30] == 101) || var6 == 1 && var2[0] == 0) {
                    return NUMBER._makeZero();
                } else {
                    int var13 = var4 / 2 - 1;
                    int var14 = 21;

                    int var8;
                    for(var8 = var4 - 2; var14 > var13; --var14) {
                        var12[var14] = 0;
                    }

                    if (var10) {
                        if ((var4 & 1) == 0) {
                            var12[var14] = var1[var8 + 1] * 100 - 100;
                            --var8;
                            --var14;
                        }

                        while(var8 > 0) {
                            var12[var14] = var3[var8] * 100 + var3[var8 + 1] - 101;
                            var8 -= 2;
                            --var14;
                        }
                    } else {
                        if ((var4 & 1) == 0) {
                            var12[var14] = 10100 - var1[var8 + 1] * 100;
                            --var8;
                            --var14;
                        }

                        while(var8 > 0) {
                            var12[var14] = 10201 - (var3[var8] * 100 + var3[var8 + 1]);
                            var8 -= 2;
                            --var14;
                        }
                    }

                    int var18 = var6 / 2 - 1;
                    int var19 = var18;
                    int var9 = var6 - 2;
                    if (var15) {
                        if ((var6 & 1) == 0) {
                            var17[var18] = var2[var9 + 1] * 100 - 100;
                            --var9;
                            var19 = var18 - 1;
                        }

                        while(var9 > 0) {
                            var17[var19] = var5[var9] * 100 + var5[var9 + 1] - 101;
                            var9 -= 2;
                            --var19;
                        }
                    } else {
                        if ((var6 & 1) == 0) {
                            var17[var18] = 10100 - var2[var9 + 1] * 100;
                            --var9;
                            var19 = var18 - 1;
                        }

                        while(var9 > 0) {
                            var17[var19] = 10201 - (var5[var9] * 100 + var5[var9 + 1]);
                            var9 -= 2;
                            --var19;
                        }
                    }

                    int var25 = 0;
                    int var26 = -1;
                    int var10002;
                    int var27;
                    int var31;
                    int var32;
                    if (var6 <= 3) {
                        var14 = 0;
                        var31 = var12[0];
                        var32 = var17[0];

                        do {
                            int var33 = var31 / var32;
                            ++var14;
                            var31 -= var33 * var32;
                            var31 = var31 * 10000 + var12[var14];
                            ++var26;
                            var24[var26] = var33;
                        } while((var31 != 0 || var14 < var13) && var26 < 10 + (var24[0] == 0 ? 2 : 1));
                    } else {
                        int var36 = 0;
                        int var37 = var18;
                        double var38 = (double)(var12[var36] * 10000) + (double)var12[var36 + 1];
                        double var40 = (double)(var17[0] * 10000) + (double)var17[1];

                        do {
                            int var35 = (int)(var38 / var40);
                            if (var35 != 0) {
                                var14 = var36 + 2;

                                for(var19 = 2; var14 <= var37; ++var19) {
                                    var12[var14] -= var35 * var17[var19];
                                    ++var14;
                                }
                            }

                            var38 -= (double)var35 * var40;
                            var38 = var38 * 10000.0D + (double)var12[var36 + 2];
                            if (var35 >= 10000) {
                                for(var27 = var26; var24[var27] == 9999; --var27) {
                                    var24[var27] = 0;
                                }

                                var10002 = var24[var27]++;
                                var35 -= 10000;
                            }

                            if (var35 < 0) {
                                for(var27 = var26; var24[var27] == 0; --var27) {
                                    var24[var27] = 9999;
                                }

                                var10002 = var24[var27]--;
                                var35 += 10000;
                            }

                            ++var26;
                            var24[var26] = var35;
                            if (var36 >= var13 && (var38 < 0.0D ? -var38 : var38) < 0.1D) {
                                for(var14 = var36 + 2; var14 <= var37 && var12[var14] == 0; ++var14) {
                                }

                                if (var14 > var37) {
                                    break;
                                }
                            }

                            ++var36;
                            ++var37;
                        } while(var26 < 10 + (var24[0] == 0 ? 2 : 1));
                    }

                    if (var24[0] == 0) {
                        ++var25;
                    }

                    while(var24[var26] == 0) {
                        --var26;
                    }

                    int var28 = var24[var25] >= 100 ? 1 : 0;
                    int var29 = var24[var26] % 100 != 0 ? 1 : 0;
                    int var22 = 2 * (var26 - var25) + var28 + var29;
                    if (var22 > 20) {
                        if (var28 > 0) {
                            var26 = var25 + 9;
                            var24[var26] += var24[var26 + 1] >= 5000 ? 1 : 0;
                        } else {
                            var26 = var25 + 10;
                            var24[var26] = (var24[var26] + 50) / 100 * 100;
                        }

                        if (var24[var26] == 10000) {
                            do {
                                --var26;
                            } while(var24[var26] == 9999);

                            var10002 = var24[var26]++;
                        }

                        if (var24[0] != 0) {
                            var25 = 0;
                        }

                        while(var24[var26] == 0) {
                            --var26;
                        }

                        var28 = var24[var25] >= 100 ? 1 : 0;
                        var29 = var24[var26] % 100 != 0 ? 1 : 0;
                        var22 = 2 * (var26 - var25) + var28 + var29;
                    }

                    int var20 = (var11 & 255) - (var16 & 255) - (var24[0] == 0 ? 1 : 0) + 193;
                    if (var20 > 255) {
                        return var10 == var15 ? NUMBER._makePosInf() : NUMBER._makeNegInf();
                    } else if (var20 < 128) {
                        return NUMBER._makeZero();
                    } else {
                        int var21 = var22 + 1;
                        var7 = new byte[var21];
                        int var23 = var22;
                        var27 = var26;
                        if (var29 == 0) {
                            var7[var22] = (byte)(var24[var26] / 100 + 1);
                            var23 = var22 - 1;
                            var27 = var26 - 1;
                        }

                        while(var23 > 1) {
                            var31 = var24[var27] / 100;
                            var32 = var24[var27] - var31 * 100;
                            var7[var23] = (byte)(var32 + 1);
                            --var23;
                            var7[var23] = (byte)(var31 + 1);
                            --var23;
                            --var27;
                        }

                        if (var28 == 0) {
                            var7[var23] = (byte)(var24[var27] + 1);
                        }

                        var7[0] = (byte)var20;
                        if (var10 == var15) {
                            return var7;
                        } else {
                            ++var21;
                            byte[] var39;
                            if (var21 > 20) {
                                var39 = new byte[21];
                                var21 = 21;
                            } else {
                                var39 = new byte[var21];
                            }

                            var39[0] = (byte)(~var20);

                            for(var31 = 0; var31 < var21 - 2; ++var31) {
                                var39[var31 + 1] = (byte)(102 - var7[var31 + 1]);
                            }

                            if (var21 <= 20) {
                                var39[var21 - 1] = 102;
                            } else if (var7.length == 20) {
                                var39[var21 - 1] = 102;
                            } else {
                                var39[var31 + 1] = (byte)(102 - var7[var31 + 1]);
                            }

                            return var39;
                        }
                    }
                }
            }
        }
    }

    public byte[] lnxexp(byte[] var1) throws SQLException {
        return this.lnxqtra(var1, 9);
    }

    public byte[] lnxflo(byte[] var1) throws SQLException {
        byte[] var2 = this.lnxtru(var1, 0);
        if (NUMBER.compareBytes(var2, var1) != 0 && !NUMBER._isPositive(var1)) {
            var2 = this.lnxsub(var2, lnxqone);
        }

        return var2;
    }

    public byte[] lnxceil(byte[] var1) throws SQLException {
        byte[] var2 = this.lnxtru(var1, 0);
        if (NUMBER.compareBytes(var2, var1) != 0 && NUMBER._isPositive(var1)) {
            var2 = this.lnxadd(var2, lnxqone);
        }

        return var2;
    }

    public byte[] lnxfpr(byte[] var1, int var2) throws SQLException {
        int var12 = var1.length;
        if (NUMBER._isZero(var1)) {
            return NUMBER._makeZero();
        } else if (NUMBER._isNegInf(var1)) {
            return NUMBER._makeNegInf();
        } else if (NUMBER._isPosInf(var1)) {
            return NUMBER._makePosInf();
        } else if (var2 < 0) {
            return NUMBER._makeZero();
        } else {
            boolean var6;
            int var7;
            boolean var8;
            byte var9;
            byte var10;
            byte var11;
            if (var6 = NUMBER._isPositive(var1)) {
                var2 += (var1[1] & 255) < 11 ? 2 : 1;
                var7 = var2 >> 1;
                var8 = (var2 & 1) == 1;
                var9 = 1;
                var10 = 100;
                var11 = 1;
            } else {
                var2 += (var1[1] & 255) > 91 ? 2 : 1;
                var7 = var2 >> 1;
                var8 = (var2 & 1) == 1;
                var9 = 101;
                var10 = 2;
                var11 = -1;
                var12 -= (var1[var12 - 1] & 255) == 102 ? 1 : 0;
            }

            byte[] var3 = new byte[var12];
            System.arraycopy(var1, 0, var3, 0, var12);
            if (var7 > var12 - 1 || var7 == var12 - 1 && (var8 || LnxqFirstDigit[var1[var7]] == 1)) {
                return _setLength(var1, var12);
            } else {
                if (var7 == 0) {
                    if (!var8) {
                        return NUMBER._makeZero();
                    }

                    if (var6) {
                        if (var1[1] < 51) {
                            return NUMBER._makeZero();
                        }
                    } else if (var1[1] > 51) {
                        return NUMBER._makeZero();
                    }
                }

                label142:
                if (var7 == 1 && !var8) {
                    if (var6) {
                        if (var1[1] >= 6) {
                            break label142;
                        }
                    } else if (var1[1] <= 96) {
                        break label142;
                    }

                    return NUMBER._makeZero();
                }

                if (var7 == 0) {
                    if (NUMBER._isInf(var1)) {
                        return var6 ? NUMBER._makePosInf() : NUMBER._makeNegInf();
                    } else {
                        var3[0] = (byte)(var1[0] + var11);
                        var3[1] = (byte)(var9 + var11);
                        return _setLength(var3, 2);
                    }
                } else {
                    byte var5;
                    byte var4 = var5 = (byte)var7;
                    if (var8) {
                        label133: {
                            label132: {
                                if (var6) {
                                    if (var1[var5 + 1] > 50) {
                                        break label132;
                                    }
                                } else if (var1[var5 + 1] < 52) {
                                    break label132;
                                }

                                var3[var4] = var1[var5];
                                break label133;
                            }

                            var3[var4] = (byte)(var1[var5] + var11);
                        }
                    } else {
                        var3[var4] = var6 ? LnxqRound_P[var1[var5]] : LnxqRound_N[var1[var5]];
                    }

                    --var5;
                    int var13;
                    if (var3[var4] != var10 + var11) {
                        if (var3[var4] != var9) {
                            var13 = var7 + 1;
                        } else {
                            while(var1[var5] == var9) {
                                --var5;
                            }

                            var13 = var5 + 1;
                        }
                    } else {
                        while(var5 > 0 && var1[var5] == var10) {
                            --var5;
                        }

                        if (var5 == 0) {
                            if (NUMBER._isInf(var1)) {
                                if (var6) {
                                    return NUMBER._makePosInf();
                                }

                                return NUMBER._makeNegInf();
                            }

                            var3[0] = (byte)(var1[0] + var11);
                            var3[1] = (byte)(var9 + var11);
                            return _setLength(var3, 2);
                        }

                        var3[var5] = (byte)(var1[var5] + var11);
                        var13 = var5 + 1;
                        --var5;
                    }

                    return _setLength(var3, var13);
                }
            }
        }
    }

    public byte[] lnxinc(byte[] var1) throws SQLException {
        int var6 = var1.length;
        byte[] var7 = new byte[22];
        System.arraycopy(var1, 0, var7, 0, var6);
        byte var2 = 0;
        int var5 = (byte)((var7[0] & -129) - 65);
        if (var5 >= 0 && var5 <= 18) {
            byte var3 = (byte)(var5 + 1);
            byte var4 = (byte)(var6 - 1);
            if (var3 <= var4) {
                if (var7[var3] < 100) {
                    ++var7[var3];
                } else {
                    var7[var2] = 0;

                    do {
                        --var3;
                    } while(var7[var3] == 100);

                    if (var3 > var2) {
                        ++var7[var3];
                    } else {
                        ++var5;
                        ++var3;
                        var7[var3] = 2;
                    }

                    var7[var2] = (byte)(var5 + 128 + 64 + 1);
                    var6 = var3 - var2 + 1;
                }
            } else {
                var7[var3] = 2;
                --var3;

                while(var3 > var4) {
                    var7[var3] = 1;
                    --var3;
                }

                var6 = var5 + 2;
            }
        } else {
            var7[0] = -63;
            var7[1] = 2;
            var6 = 2;
        }

        byte[] var8 = new byte[var6];
        System.arraycopy(var7, 0, var8, 0, var6);
        return var8;
    }

    public byte[] lnxln(byte[] var1) throws SQLException {
        if (this.lnxsgn(var1) <= 0) {
            return NUMBER._makeNegInf();
        } else if (NUMBER._isPosInf(var1)) {
            return NUMBER._makePosInf();
        } else {
            byte[] var2 = new byte[var1.length];
            System.arraycopy(var1, 0, var2, 0, var1.length);
            int var3 = (var2[0] & 255) - 193;
            var2[0] = -63;
            double var4 = this.lnxnur(var2);
            double var6 = Math.log(var4);
            byte[] var8 = NUMBER.toBytes(var6);
            byte[] var9 = this.lnxexp(var8);
            byte[] var10 = this.lnxdiv(var2, var9);
            var10 = this.lnxsub(var10, lnxqone);
            byte[] var11 = new byte[var10.length];
            System.arraycopy(var10, 0, var11, 0, var10.length);
            byte[] var12 = this.lnxmul(var10, var10);

            for(int var13 = 1; (var12[0] & 255) > 172; var12 = this.lnxmul(var10, var12)) {
                ++var13;
                var9 = this.lnxqIDiv(var12, var13);
                var11 = this.lnxsub(var11, var9);
                var12 = this.lnxmul(var10, var12);
                ++var13;
                var9 = this.lnxqIDiv(var12, var13);
                var11 = this.lnxadd(var11, var9);
            }

            var3 *= 2;
            byte[] var14 = NUMBER.ln10().shareBytes();
            var10 = this.lnxmin((long)var3);
            var9 = this.lnxmul(var10, var14);
            var9 = this.lnxadd(var9, var8);
            return this.lnxadd(var9, var11);
        }
    }

    public byte[] lnxlog(byte[] var1, byte[] var2) throws SQLException {
        double var3 = NUMBER.toDouble(var2);
        if (var3 > 0.0D) {
            byte[] var5;
            if (var3 == 10.0D) {
                var5 = this.lnxln(var1);
                byte[] var7 = NUMBER.ln10().shareBytes();
                return this.lnxdiv(var5, var7);
            } else {
                var5 = this.lnxln(var1);
                byte[] var6 = this.lnxln(var2);
                return this.lnxdiv(var5, var6);
            }
        } else {
            return NUMBER._makeNegInf();
        }
    }

    public byte[] lnxmod(byte[] var1, byte[] var2) throws SQLException {
        byte[] var3 = this.lnxdiv(var1, var2);
        byte[] var4 = this.lnxtru(var3, 0);
        var3 = this.lnxmul(var2, var4);
        byte[] var5 = this.lnxsub(var1, var3);
        return var5;
    }

    public byte[] lnxmul(byte[] var1, byte[] var2) throws SQLException {
        byte[] var3 = var1;
        int var4 = var1.length;
        byte[] var5 = var2;
        int var6 = var2.length;
        byte[] var7 = new byte[22];
        int[] var12 = new int[10];
        int[] var17 = new int[10];
        boolean var20 = false;
        byte[] var22 = new byte[41];
        boolean var23 = false;
        byte var25 = 0;
        boolean var10 = var1[0] >> 7 != 0;
        byte var11 = var1[0];
        if (!var10) {
            var11 = (byte)(~var11);
            if (var1[var4 - 1] == 102) {
                --var4;
            }
        }

        boolean var15 = var2[0] >> 7 != 0;
        byte var16 = var2[0];
        if (!var15) {
            var16 = (byte)(~var16);
            if (var2[var6 - 1] == 102) {
                --var6;
            }
        }

        if (-var11 == 128 && var4 == 1) {
            var7 = NUMBER._makeZero();
            return var7;
        } else if (-var16 == 128 && var6 == 1) {
            var7 = NUMBER._makeZero();
            return var7;
        } else if ((var11 & 255) != 255 || var4 != 1 && var1[1] != 101) {
            if ((var16 & 255) != 255 || var6 != 1 && var2[1] != 101) {
                if (var4 > var6) {
                    var3 = var2;
                    var5 = var1;
                    int var28 = var4;
                    var4 = var6;
                    var6 = var28;
                    boolean var29 = var10;
                    var10 = var15;
                    var15 = var29;
                }

                int var13 = var4 / 2 - 1;
                int var14 = var13;
                int var8 = var4 - 2;
                if (var10) {
                    if ((var4 & 1) == 0) {
                        var12[var13] = var3[var8 + 1] * 100 - 100;
                        --var8;
                        var14 = var13 - 1;
                    }

                    while(var8 > 0) {
                        var12[var14] = var3[var8] * 100 + var3[var8 + 1] - 101;
                        var8 -= 2;
                        --var14;
                    }
                } else {
                    if ((var4 & 1) == 0) {
                        var12[var13] = 10100 - var3[var8 + 1] * 100;
                        --var8;
                        var14 = var13 - 1;
                    }

                    while(var8 > 0) {
                        var12[var14] = 10201 - (var3[var8] * 100 + var3[var8 + 1]);
                        var8 -= 2;
                        --var14;
                    }
                }

                int var18 = var6 / 2 - 1;
                int var19 = var18;
                int var9 = var6 - 2;
                if (var15) {
                    if ((var6 & 1) == 0) {
                        var17[var18] = var5[var9 + 1] * 100 - 100;
                        --var9;
                        var19 = var18 - 1;
                    }

                    while(var9 > 0) {
                        var17[var19] = var5[var9] * 100 + var5[var9 + 1] - 101;
                        var9 -= 2;
                        --var19;
                    }
                } else {
                    if ((var6 & 1) == 0) {
                        var17[var18] = 10100 - var5[var9 + 1] * 100;
                        --var9;
                        var19 = var18 - 1;
                    }

                    while(var9 > 0) {
                        var17[var19] = 10201 - (var5[var9] * 100 + var5[var9 + 1]);
                        var9 -= 2;
                        --var19;
                    }
                }

                int var21;
                short var30;
                if (var12[0] * var17[0] < 1000000) {
                    var30 = (short)((var11 & 255) + (var16 & 255) - 193);
                    var21 = (var4 & 254) + (var6 & 254);
                } else {
                    var30 = (short)((var11 & 255) + (var16 & 255) - 192);
                    var21 = (var4 & 254) + (var6 & 254) + 1;
                }

                int var31 = 1;
                int var24;
                int var32;
                if (var4 <= 3) {
                    var32 = var12[0] * var17[var18];
                    var32 = LnxmulSetDigit1(var22, var21, var32);
                    var24 = var21 - 2;

                    for(var19 = var18 - 1; var19 >= 0; --var19) {
                        var32 += var12[0] * var17[var19];
                        var32 = LnxmulSetDigit1(var22, var24, var32);
                        var24 -= 2;
                    }

                    LnxmulSetDigit2(var22, var24, var32);
                    var24 -= 2;
                } else {
                    var32 = var25 + var12[var13] * var17[var18];
                    var32 = LnxmulSetDigit1(var22, var21, var32);
                    var24 = var21 - 2;
                    var19 = var18 - 1;

                    while(var19 > var18 - (var4 / 2 - 1)) {
                        switch(var18 - var19 + 1) {
                            case 9:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 8, var32);
                            case 8:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 7, var32);
                            case 7:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 6, var32);
                            case 6:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 5, var32);
                            case 5:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 4, var32);
                            case 4:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 3, var32);
                            case 3:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 2, var32);
                            case 2:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 1, var32);
                            default:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 0, var32);
                                var32 = LnxmulSetDigit1(var22, var24, var32);
                                var24 -= 2;
                                --var19;
                        }
                    }

                    do {
                        switch(var4 / 2) {
                            case 10:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 9, var32);
                            case 9:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 8, var32);
                            case 8:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 7, var32);
                            case 7:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 6, var32);
                            case 6:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 5, var32);
                            case 5:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 4, var32);
                            case 4:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 3, var32);
                            case 3:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 2, var32);
                            case 2:
                                var32 = LnxmulSetSum(var12, var17, var13, var19, 1, var32);
                        }

                        var32 = LnxmulSetSum(var12, var17, var13, var19, 0, var32);
                        var32 = LnxmulSetDigit1(var22, var24, var32);
                        var24 -= 2;
                        --var19;
                    } while(var19 >= 0);

                    var14 = var13 - 1;

                    while(var14 > 0) {
                        switch(var14 + 1) {
                            case 9:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 8, var32);
                            case 8:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 7, var32);
                            case 7:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 6, var32);
                            case 6:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 5, var32);
                            case 5:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 4, var32);
                            case 4:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 3, var32);
                            case 3:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 2, var32);
                            case 2:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 1, var32);
                            default:
                                var32 = LnxmulSetSum(var12, var17, var14, 0, 0, var32);
                                var32 = LnxmulSetDigit1(var22, var24, var32);
                                var24 -= 2;
                                --var14;
                        }
                    }

                    var32 += var12[0] * var17[0];
                    var32 = LnxmulSetDigit1(var22, var24, var32);
                    var24 -= 2;
                    LnxmulSetDigit2(var22, var24, var32);
                    var24 -= 2;
                }

                if ((var21 & 1) == 0 && var22[var24] != 1) {
                    ++var30;
                    ++var21;
                    --var31;
                }

                while(var22[var31 + var21 - 2] == 1) {
                    --var21;
                }

                if (var21 > 21) {
                    var24 = var31 + 19;
                    var21 = 21;
                    if (var22[var24 + 1] <= 50) {
                        while(var22[var31 + var21 - 2] == 1) {
                            --var21;
                        }
                    } else {
                        while(var22[var24] == 100) {
                            --var24;
                            --var21;
                        }

                        if (var24 < var31) {
                            var22[var31] = 2;
                            ++var30;
                            ++var21;
                        }

                        ++var22[var24];
                    }
                }

                if ((var30 & '\uffff') > 255) {
                    return var10 == var15 ? NUMBER._makePosInf() : NUMBER._makeNegInf();
                } else if ((var30 & '\uffff') < 128) {
                    return NUMBER._makeZero();
                } else {
                    int var26;
                    if (var10 != var15) {
                        ++var21;
                        var7 = new byte[var21];
                        var7[0] = (byte)(~var30);

                        for(var26 = 0; var26 < var21 - 1; ++var26) {
                            var7[var26 + 1] = (byte)(102 - var22[var31 + var26]);
                        }

                        var7[var21 - 1] = 102;
                    } else {
                        var7 = new byte[var21];
                        var7[0] = (byte)var30;

                        for(var26 = 0; var26 < var21 - 1; ++var26) {
                            var7[var26 + 1] = var22[var31 + var26];
                        }
                    }

                    return var7;
                }
            } else {
                if (var10 == var15) {
                    var7 = NUMBER._makePosInf();
                } else {
                    var7 = NUMBER._makeNegInf();
                }

                return var7;
            }
        } else {
            if (var10 == var15) {
                var7 = NUMBER._makePosInf();
            } else {
                var7 = NUMBER._makeNegInf();
            }

            return var7;
        }
    }

    private static int LnxmulSetSum(int[] var0, int[] var1, int var2, int var3, int var4, int var5) throws SQLException {
        boolean var6 = false;

        try {
            int var9 = var5 + var0[var2 - var4] * var1[var3 + var4];
            return var9;
        } catch (ArrayIndexOutOfBoundsException var8) {
            throw new SQLException(CoreException.getMessage((byte)4));
        }
    }

    private static int LnxmulSetDigit1(byte[] var0, int var1, int var2) {
        int var3 = var2 / 100;
        int var4 = var2 / 10000;
        var1 -= 2;
        var0[var1 + 1] = (byte)(var2 - var3 * 100 + 1);
        var0[var1] = (byte)(var3 - var4 * 100 + 1);
        return var4;
    }

    private static void LnxmulSetDigit2(byte[] var0, int var1, int var2) {
        int var3 = var2 / 100;
        var1 -= 2;
        var0[var1] = (byte)(var3 + 1);
        var0[var1 + 1] = (byte)(var2 - var3 * 100 + 1);
    }

    public byte[] lnxneg(byte[] var1) throws SQLException {
        if (NUMBER._isZero(var1)) {
            return NUMBER._makeZero();
        } else if (NUMBER._isPosInf(var1)) {
            return NUMBER._makeNegInf();
        } else if (NUMBER._isNegInf(var1)) {
            return NUMBER._makePosInf();
        } else {
            int var2 = var1.length;
            if (!NUMBER._isPositive(var1) && var1[var2 - 1] == 102) {
                --var2;
            }

            byte[] var3 = new byte[var2];
            System.arraycopy(var1, 0, var3, 0, var2);
            _negateNumber(var3);
            return _setLength(var3, var2);
        }
    }

    public byte[] lnxpow(byte[] var1, int var2) throws SQLException {
        byte[] var3;
        if (var2 >= 0) {
            var3 = new byte[var1.length];
            System.arraycopy(var1, 0, var3, 0, var1.length);
        } else {
            int var4 = -2147483648;
            if (var2 == var4) {
                var3 = this.lnxpow(var1, var4 + 1);
                return this.lnxdiv(var3, var1);
            }

            var2 = -var2;
            var3 = this.lnxdiv(lnxqone, var1);
        }

        byte[] var5 = lnxqone;

        while(var2 > 0) {
            if ((var2 & 1) == 1) {
                var5 = this.lnxmul(var5, var3);
            }

            if ((var2 >>= 1) > 0) {
                var3 = this.lnxmul(var3, var3);
            }
        }

        return var5;
    }

    public byte[] lnxrou(byte[] var1, int var2) throws SQLException {
        int var3 = var1.length;
        byte var4 = 0;
        if (var3 == 1) {
            return var1[var4] == -128 ? NUMBER._makeZero() : NUMBER._makeNegInf();
        } else if (var3 == 2 && var1[0] == -1 && var1[1] == 101) {
            return NUMBER._makePosInf();
        } else {
            int var15 = var1[0] < 0 ? 256 + var1[0] : var1[0];
            boolean var7;
            byte var8;
            byte var9;
            byte var10;
            int var11;
            boolean var12;
            if (var7 = NUMBER._isPositive(var1)) {
                if (var2 >= 0) {
                    var11 = var15 + (var2 + 1 >> 1) - 192;
                    var12 = (var2 & 1) != 0;
                } else {
                    var2 = -var2;
                    var11 = var15 - (var2 >> 1) - 192;
                    var12 = (var2 & 1) != 0;
                }

                var8 = 1;
                var9 = 100;
                var10 = 1;
            } else {
                if (var2 >= 0) {
                    var11 = 63 + (var2 + 1 >> 1) - var15;
                    var12 = (var2 & 1) != 0;
                } else {
                    var2 = -var2;
                    var11 = 63 - (var2 >> 1) - var15;
                    var12 = (var2 & 1) != 0;
                }

                var8 = 101;
                var9 = 2;
                var10 = -1;
                var3 -= var1[var3 - 1] == 102 ? 1 : 0;
            }

            byte[] var6 = new byte[var3];
            System.arraycopy(var1, 0, var6, 0, var3);
            if (var11 <= var3 - 1 && (var11 != var3 - 1 || var12 && LnxqFirstDigit[var1[var11]] != 1)) {
                if (var11 >= 0) {
                    if (var11 == 0) {
                        if (var12) {
                            return NUMBER._makeZero();
                        }

                        if (var7) {
                            if (var1[1] < 51) {
                                return NUMBER._makeZero();
                            }
                        } else if (var1[1] > 51) {
                            return NUMBER._makeZero();
                        }
                    }

                    if (var11 == 1 && var12) {
                        if (var7) {
                            if (var1[1] < 6) {
                                return NUMBER._makeZero();
                            }
                        } else if (var1[1] > 96) {
                            return NUMBER._makeZero();
                        }
                    }

                    if (var11 == 0) {
                        label131: {
                            if (var7) {
                                if (var1[var4] == -1) {
                                    break label131;
                                }
                            } else if (var1[var4] == 0) {
                                break label131;
                            }

                            var6[0] = (byte)(var1[var4] + var10);
                            var6[1] = (byte)(var8 + var10);
                            return _setLength(var6, 2);
                        }

                        if (var7) {
                            return NUMBER._makePosInf();
                        } else {
                            return NUMBER._makeNegInf();
                        }
                    } else {
                        byte var13;
                        byte var5 = var13 = (byte)var11;
                        if (var12) {
                            var6[var13] = var7 ? LnxqRound_P[var1[var5]] : LnxqRound_N[var1[var5]];
                        } else {
                            label168: {
                                label167: {
                                    if (var7) {
                                        if (var1[var5 + 1] > 50) {
                                            break label167;
                                        }
                                    } else if (var1[var5 + 1] < 52) {
                                        break label167;
                                    }

                                    var6[var13] = var1[var5];
                                    break label168;
                                }

                                var6[var13] = (byte)(var1[var5] + var10);
                            }
                        }

                        --var5;
                        int var14;
                        if (var6[var13] != var9 + var10) {
                            if (var6[var13] != var8) {
                                var14 = var11 + 1;
                            } else {
                                while(var1[var5] == var8) {
                                    --var5;
                                }

                                var14 = var5 - var4 + 1;
                            }
                        } else {
                            while(var5 > var4 && var1[var5] == var9) {
                                --var5;
                            }

                            if (var5 == var4) {
                                label212: {
                                    if (var7) {
                                        if (var1[var4] != -1) {
                                            break label212;
                                        }
                                    } else if (var1[var4] != 0) {
                                        break label212;
                                    }

                                    if (var7) {
                                        return NUMBER._makePosInf();
                                    }

                                    return NUMBER._makeNegInf();
                                }

                                var6[0] = (byte)(var1[var4] + var10);
                                var6[1] = (byte)(var8 + var10);
                                return _setLength(var6, 2);
                            }

                            var6[var5 - var4] = (byte)(var1[var5] + var10);
                            var14 = var5 - var4 + 1;
                            --var5;
                        }

                        return _setLength(var6, var14);
                    }
                } else {
                    return NUMBER._makeZero();
                }
            } else {
                return _setLength(var1, var3);
            }
        }
    }

    public byte[] lnxsca(byte[] var1, int var2, int var3, boolean[] var4) throws SQLException {
        int var8 = var1.length;
        if (var8 != 1) {
            byte var5;
            byte var6;
            byte var7;
            if (NUMBER._isPositive(var1)) {
                var5 = (byte)((var1[0] & -129) - 65);
                var6 = var1[1];
                var7 = var1[var8 - 1];
            } else {
                --var8;
                var5 = (byte)((~var1[0] & -129) - 65);
                var6 = LnxqNegate[var1[1]];
                var7 = LnxqNegate[var1[var8 - 1]];
            }

            if (2 * (var8 - var5) - (var7 % 10 == 1 ? 1 : 0) > var3) {
                byte[] var11 = this.lnxrou(var1, var3);
                if (NUMBER._isPositive(var11)) {
                    var5 = (byte)((var11[0] & -129) - 65);
                    var6 = var11.length != 1 ? var11[1] : 1;
                } else {
                    var5 = (byte)((~var11[0] & -129) - 65);
                    var6 = LnxqNegate[var11[1]];
                }

                var4[0] = 2 * (var5 + 1) - (var6 < 11 ? 1 : 0) > var2;
                return var11;
            } else {
                int var9 = var1.length;
                byte[] var10 = new byte[var9];
                System.arraycopy(var1, 0, var10, 0, var9);
                var4[0] = 2 * (var5 + 1) - (var6 < 11 ? 1 : 0) > var2;
                return var10;
            }
        } else {
            var4[0] = false;
            return NUMBER._makeZero();
        }
    }

    public byte[] lnxshift(byte[] var1, int var2) throws SQLException {
        byte[] var3 = var1;
        int var4 = var1.length;
        byte[] var6 = new byte[22];
        boolean var7 = false;
        boolean var15 = false;
        byte var16;
        if (var4 == 1) {
            var16 = 0;
        } else {
            var16 = 1;
        }

        byte[] var5;
        int var21;
        if ((var1[0] & 255) == 128 && var4 == 1 || var4 == 2 && (var1[0] & 255) == 255 && var1[var16] == 101 || var4 == 1 && var1[0] == 0) {
            var5 = new byte[var4];

            for(var21 = 0; var21 < var4; ++var21) {
                var5[var21] = var3[var21];
            }

            return var5;
        } else {
            boolean var10 = var1[0] >> 7 == 0;
            int var12 = var10 ? 255 - var1[0] & 255 : var1[0] & 255;
            int var13 = var4;
            if ((var2 & 1) > 0) {
                byte[][] var8;
                byte[][] var9;
                byte var14;
                if (var10) {
                    if (var1[var4 - 1] == 102) {
                        var13 = var4 - 1;
                    }

                    var8 = LnxqComponents_N;
                    var9 = LnxqDigit_N;
                    var14 = 101;
                } else {
                    var8 = LnxqComponents_P;
                    var9 = LnxqDigit_P;
                    var14 = 1;
                }

                int var19;
                int var20;
                if (var8[var1[1]][0] != 0) {
                    var12 = var2 >= 0 ? var12 + var2 / 2 + 1 : var12 - -var2 / 2;
                    var19 = var13 - 2;
                    var20 = var13 - 1;
                    boolean var11;
                    if (var13 > 20) {
                        var11 = var8[var1[var19 + 1]][1] >= 5;
                    } else {
                        var6[var20 + 1] = var9[var8[var1[var19 + 1]][1]][0];
                        ++var13;
                        var11 = false;
                    }

                    while(var19 > 0) {
                        var6[var20] = var9[var8[var3[var19 + 0]][1]][var8[var3[var19 + 1]][0]];
                        --var19;
                        --var20;
                    }

                    var6[1] = var9[0][var8[var3[var19 + 1]][0]];
                    if (var11) {
                        int var17 = var10 ? 2 : 100;
                        int var18 = var10 ? -1 : 1;

                        for(var20 = 20; var6[var20] == var17; --var13) {
                            --var20;
                        }

                        var6[var20] = (byte)(var6[var20] + var18);
                    }
                } else {
                    var12 = var2 >= 0 ? var12 + var2 / 2 : var12 - (-var2 / 2 + 1);
                    var19 = 1;

                    for(var20 = 1; var20 < var13 - 1; ++var20) {
                        var6[var20] = var9[var8[var3[var19 + 0]][1]][var8[var3[var19 + 1]][0]];
                        ++var19;
                    }

                    var6[var20] = var9[var8[var3[var19 + 0]][1]][0];
                }

                while(var6[var13 - 1] == var14) {
                    --var13;
                }

                if (var10) {
                    ++var13;
                    var6[var13 - 1] = 102;
                }
            } else {
                var12 = var2 >= 0 ? var12 + var2 / 2 : var12 - -var2 / 2;

                for(var21 = 1; var21 < var13; ++var21) {
                    var6[var21] = var3[var21];
                }
            }

            if (var12 > 255) {
                if (var10) {
                    var5 = new byte[]{0};
                } else {
                    var5 = new byte[]{-1, 101};
                }

                return var5;
            } else if (var12 < 128) {
                var5 = new byte[]{-128};
                return var5;
            } else {
                var6[0] = var10 ? (byte)(255 - var12) : (byte)var12;
                var5 = new byte[var13];

                for(var21 = 0; var21 < var13; ++var21) {
                    var5[var21] = var6[var21];
                }

                return var5;
            }
        }
    }

    public byte[] lnxsin(byte[] var1) throws SQLException {
        return this.lnxqtra(var1, 4);
    }

    public byte[] lnxsnh(byte[] var1) throws SQLException {
        return this.lnxqtra(var1, 7);
    }

    public byte[] lnxsqr(byte[] var1) throws SQLException {
        int var2 = var1.length;
        int[] var3 = new int[29];
        int[] var4 = new int[29];
        if (!NUMBER._isPositive(var1)) {
            return NUMBER._makeNegInf();
        } else if (NUMBER._isPosInf(var1)) {
            return NUMBER._makePosInf();
        } else if (NUMBER._isZero(var1)) {
            return NUMBER._makeZero();
        } else {
            int var17 = (var1[0] & 255) - 193;

            int var18;
            for(var18 = 1; var18 < var2; ++var18) {
                var3[var18] = var1[var18] - 1;
            }

            byte var13 = 1;
            int var14 = var13 + 20 + 3;
            int var7;
            int var19;
            if ((var17 + 128 & 1) != 0) {
                var7 = ((var3[var13] * 100 + var3[var13 + 1]) * 100 + var3[var13 + 2]) * 100 + var3[var13 + 3];
                var19 = var13 + 3;
            } else {
                var7 = (var3[var13] * 100 + var3[var13 + 1]) * 100 + var3[var13 + 2];
                var19 = var13 + 2;
            }

            int var6 = (int)(Math.sqrt((double)var7) * 100.0D);
            var4[1] = var6 / 10000;
            var4[2] = var6 / 100 % 100;
            var4[3] = var6 % 100;
            var7 -= var4[1] * var6;
            var7 = var7 * 100 + var3[var19 + 1];
            var7 -= var4[2] * var6;
            var7 = var7 * 100 + var3[var19 + 2];
            var7 -= var4[3] * var6;
            var19 += 3;
            var6 *= 2;
            byte var9 = 3;

            int var10;
            int var11;
            for(var10 = var9 + 1; var19 < var14; ++var10) {
                var7 = var7 * 100 + var3[var19];
                int var8 = var7 / var6;
                var7 -= var8 * var6;
                var4[var10] = var8;
                var11 = var9 + (var14 - var19) < var10 ? var9 + (var14 - var19) : var10;
                int var15;
                if (var8 != 0) {
                    var15 = var19 + 1;

                    for(int var16 = var9 + 1; var16 < var11; ++var16) {
                        var3[var15] -= 2 * var8 * var4[var16];
                        ++var15;
                    }

                    if (var15 < var14) {
                        var3[var15] -= var8 * var8;
                    }
                } else if (var7 == 0) {
                    for(var15 = var19 + 1; var15 < var14 && var3[var15] == 0; ++var15) {
                    }

                    if (var15 == var14) {
                        break;
                    }
                }

                ++var19;
            }

            var11 = var10--;

            for(var4[0] = 0; var10 > 0; --var10) {
                while(var4[var10] > 99) {
                    var4[var10] -= 100;
                    ++var4[var10 - 1];
                }

                while(var4[var10] < 0) {
                    var4[var10] += 100;
                    --var4[var10 - 1];
                }
            }

            var17 = (var17 - (var17 + 128 & 1)) / 2 + 1;

            while(var4[var10] == 0) {
                ++var10;
                --var17;
                if (var17 < -65) {
                    return NUMBER._makeZero();
                }
            }

            do {
                --var11;
            } while(var4[var11] == 0);

            int var12 = var11 - var10 + 2;
            if (var12 > 21) {
                var11 = var10 + 20;
                if (var4[var11] < 50) {
                    do {
                        --var11;
                    } while(var4[var11] == 0);
                } else {
                    do {
                        --var11;
                    } while(var4[var11] == 99);

                    int var10002 = var4[var11]++;
                }

                if (var11 < var10) {
                    var10 = var11;
                    ++var17;
                    if (var17 > 62) {
                        return NUMBER._makePosInf();
                    }
                }

                var12 = var11 - var10 + 2;
            }

            byte[] var5 = new byte[var12];
            var5[0] = (byte)(var17 - 63);

            for(var18 = var10; var18 <= var11; ++var18) {
                var5[var18 - (var10 - 1)] = (byte)(var4[var18] + 1);
            }

            return var5;
        }
    }

    public byte[] lnxsub(byte[] var1, byte[] var2) throws SQLException {
        return this.lnxadd(var1, this.lnxneg(var2));
    }

    public byte[] lnxtan(byte[] var1) throws SQLException {
        return this.lnxqtra(var1, 5);
    }

    public byte[] lnxtnh(byte[] var1) throws SQLException {
        return this.lnxqtra(var1, 8);
    }

    public byte[] lnxtru(byte[] var1, int var2) throws SQLException {
        int var10 = var1.length;
        if (NUMBER._isZero(var1)) {
            return NUMBER._makeZero();
        } else if (NUMBER._isNegInf(var1)) {
            return NUMBER._makeNegInf();
        } else if (NUMBER._isPosInf(var1)) {
            return NUMBER._makePosInf();
        } else {
            int var12 = var1[0] < 0 ? 256 + var1[0] : var1[0];
            boolean var6;
            int var7;
            boolean var8;
            byte var9;
            if (var6 = NUMBER._isPositive(var1)) {
                if (var2 >= 0) {
                    var7 = var12 + (var2 + 1 >> 1) - 192;
                    var8 = (var2 & 1) == 1;
                } else {
                    var2 = -var2;
                    var7 = var12 - (var2 >> 1) - 192;
                    var8 = (var2 & 1) == 1;
                }

                var9 = 1;
            } else {
                if (var2 >= 0) {
                    var7 = 63 + (var2 + 1 >> 1) - var12;
                    var8 = (var2 & 1) == 1;
                } else {
                    var2 = -var2;
                    var7 = 63 - (var2 >> 1) - var12;
                    var8 = (var2 & 1) == 1;
                }

                var9 = 101;
                if (var1[var10 - 1] == 102) {
                    --var10;
                }
            }

            byte[] var3 = new byte[var10];
            System.arraycopy(var1, 0, var3, 0, var10);
            if (var7 > var10 - 1 || var7 == var10 - 1 && (var8 || LnxqFirstDigit[var1[var7]] == 1)) {
                return _setLength(var1, var10);
            } else {
                label98: {
                    if (var7 > 0) {
                        if (var7 != 1 || !var8) {
                            break label98;
                        }

                        if (var6) {
                            if (var1[1] >= 11) {
                                break label98;
                            }
                        } else if (var1[1] <= 91) {
                            break label98;
                        }
                    }

                    return NUMBER._makeZero();
                }

                byte var5;
                byte var4 = var5 = (byte)var7;
                if (var8) {
                    if (var6) {
                        var3[var4] = LnxqTruncate_P[var1[var5]];
                    } else {
                        var3[var4] = LnxqTruncate_N[var1[var5]];
                    }
                } else {
                    var3[var4] = var1[var5];
                }

                --var5;
                int var11;
                if (var3[var4] != var9) {
                    var11 = var7 + 1;
                } else {
                    while(var1[var5] == var9) {
                        --var5;
                    }

                    var11 = var5 + 1;
                }

                return _setLength(var3, var11);
            }
        }
    }

    public byte[] lnxcpn(String var1, boolean var2, int var3, boolean var4, int var5, String var6) throws SQLException {
        int var12 = 0;
        int var16 = 0;
        boolean var17 = false;
        boolean var18 = false;
        boolean var19 = false;
        boolean var20 = false;
        int var21 = 0;
        int var22 = 0;
        boolean var23 = false;
        int var24 = 0;
        boolean var28 = false;
        boolean var29 = false;
        boolean var30 = false;
        boolean var31 = false;
        boolean var41 = false;
        Locale var42;
        if (var6 != null) {
            int var43 = var6.indexOf("_");
            if (var43 == -1) {
                var42 = LxMetaData.getJavaLocale(var6, "");
            } else {
                String var44 = var6.substring(0, var43);
                String var45 = var6.substring(var43 + 1);
                var42 = LxMetaData.getJavaLocale(var44, var45);
            }

            if (var42 == null) {
                var42 = Locale.getDefault(Category.FORMAT);
            }
        } else {
            var42 = Locale.getDefault(Category.FORMAT);
        }

        DecimalFormatSymbols var49 = new DecimalFormatSymbols(var42);
        char var35 = var49.getDecimalSeparator();
        char var40 = var49.getMinusSign();
        char[] var7 = var1.toCharArray();
        int var9 = 0;

        int var10;
        for(var10 = var7.length - 1; var9 <= var10 && Character.isSpaceChar(var7[var9]); ++var9) {
        }

        if (var9 <= var10 && (var7[var9] == var40 || var7[var9] == '+')) {
            var17 = var7[var9] == var40;
            ++var9;
        }

        int var8;
        for(var8 = var9; var9 <= var10 && var7[var9] == '0'; ++var9) {
        }

        int var11;
        for(var11 = var9; var9 <= var10 && Character.isDigit(var7[var9]); ++var9) {
        }

        int var46 = var9 - var8;
        int var47 = var9 - var11;
        if (var9 <= var10 && var7[var9] == var35) {
            ++var9;

            for(var12 = var9; var9 <= var10 && Character.isDigit(var7[var9]); ++var9) {
            }

            var21 = var9 - var12;
            var8 = var9;

            do {
                --var9;
            } while(var9 >= var12 && var7[var9] == '0');

            var22 = var9 - var12 + 1;
            var9 = var8;
        }

        if (var46 + var21 != 0) {
            if (var9 <= var10 && (var7[var9] == 'E' || var7[var9] == 'e')) {
                ++var9;
                if (var9 <= var10 && (var7[var9] == var40 || var7[var9] == '+')) {
                    var18 = var7[var9] == var40;
                    ++var9;
                }

                for(var8 = var9; var9 <= var10 && var7[var9] == '0'; ++var9) {
                }

                int var13;
                for(var13 = var9; var9 <= var10 && Character.isDigit(var7[var9]); ++var9) {
                    var16 = var16 * 10 + (var7[var9] - 48);
                }

                int var48 = var9 - var8;
                var24 = var9 - var13;
                if (var48 != 0 && var18) {
                    var16 = -var16;
                }
            }

            while(var9 <= var10 && Character.isSpaceChar(var7[var9])) {
                ++var9;
            }
        }

        int var15;
        int var32;
        int var33;
        if (var47 != 0) {
            if (var22 != 0) {
                var16 += var47 - 1;
                var32 = var47;
                var33 = var22;
                var15 = var11;
            } else {
                var16 += var47 - 1;

                for(var9 = var11 + (var47 - 1); var7[var9] == '0'; --var9) {
                }

                var32 = var9 - var11 + 1;
                var33 = 0;
                var15 = var11;
            }
        } else {
            if (var22 == 0) {
                return NUMBER._makeZero();
            }

            for(var9 = var12; var7[var9] == '0'; ++var9) {
            }

            var16 -= var9 - var12 + 1;
            var32 = var22 - (var9 - var12);
            var33 = 0;
            var15 = var9;
        }

        int var27 = (var16 & 1) == 1 ? 40 : 39;
        int var25 = var32 + var33;
        int var26;
        if (!var2 && !var4) {
            var26 = var25;
        } else {
            if (!var2) {
                var3 = 2147483647;
            }

            if (!var4) {
                var5 = 0;
            }

            var26 = var16 + 1 + var5;
        }

        var26 = Math.min(var26, var27);
        if (var26 < 0 || var26 == 0 && var7[var15] < '5') {
            return NUMBER._makeZero();
        } else {
            boolean var34 = false;
            if (var26 < var25) {
                var9 = var15 + var26 + (var26 < var32 ? 0 : 1);
                if (var7[var9] < '5') {
                    do {
                        --var9;
                    } while(var9 >= var15 && (var7[var9] == '0' || var7[var9] == var35));
                } else {
                    do {
                        --var9;
                    } while(var9 >= var15 && (var7[var9] == '9' || var7[var9] == var35));

                    var34 = true;
                }

                if (var9 < var15) {
                    var7[1] = '1';
                    var7[2] = '0';
                    var15 = 1;
                    ++var16;
                    var28 = false;
                    var30 = (var16 & 1) != 1;
                    var31 = false;
                    var32 = (var16 & 1) == 1 ? 2 : 0;
                    var33 = 0;
                    var34 = false;
                    var41 = true;
                } else if (var33 != 0) {
                    if (var9 - var15 < var32) {
                        var32 = var9 - var15 + 1;
                        var33 = 0;
                    } else {
                        var33 = var9 - var15 - var32;
                    }
                } else {
                    var32 = var9 - var15 + 1;
                }
            }

            if (!var41) {
                if (var33 != 0) {
                    var28 = true;
                    var29 = (var16 & 1) == (var32 & 1);
                    var30 = (var16 & 1) != 1;
                    var31 = var29 != ((var33 & 1) == 1);
                    var32 -= (var30 ? 1 : 0) + (var29 ? 1 : 0);
                    var33 -= (var29 ? 1 : 0) + (var31 ? 1 : 0);
                } else {
                    var28 = false;
                    var30 = (var16 & 1) != 1;
                    var31 = (var16 & 1) == (var32 & 1);
                    var32 -= (var30 ? 1 : 0) + (var31 ? 1 : 0);
                }
            }

            if (!var18 && (var24 > 3 || var16 > 125)) {
                return var17 ? NUMBER._makeNegInf() : NUMBER._makePosInf();
            } else if (!var18 || var24 <= 3 && var16 >= -130) {
                byte[] var39 = new byte[22];
                int var38 = 1;
                var9 = var15;
                if (var30) {
                    var39[var38] = digitPtr(0, lnxqctn(var7[var15]), var17);
                    ++var38;
                    var9 = var15 + 1;
                }

                int var14;
                if (var32 != 0) {
                    for(var14 = var9 + var32; var9 < var14; var9 += 2) {
                        var39[var38] = digitPtr(lnxqctn(var7[var9]), lnxqctn(var7[var9 + 1]), var17);
                        ++var38;
                    }
                }

                if (var28) {
                    if (var29) {
                        var39[var38] = digitPtr(lnxqctn(var7[var9]), lnxqctn(var7[var9 + 2]), var17);
                        ++var38;
                        var9 += 3;
                    } else {
                        ++var9;
                    }
                }

                if (var33 != 0) {
                    for(var14 = var9 + var33; var9 < var14; var9 += 2) {
                        var39[var38] = digitPtr(lnxqctn(var7[var9]), lnxqctn(var7[var9 + 1]), var17);
                        ++var38;
                    }
                }

                if (var31) {
                    var39[var38] = digitPtr(lnxqctn(var7[var9]), 0, var17);
                    ++var38;
                    ++var9;
                }

                if (var34) {
                    var39[var38 - 1] = (byte)(var39[var38 - 1] + (var17 ? -1 : 1) * (var31 ? 10 : 1));
                }

                byte var37;
                if (var16 < 0) {
                    var37 = (byte)(193 - (1 - var16) / 2);
                } else {
                    var37 = (byte)(193 + var16 / 2);
                }

                var39[0] = (byte)(var17 ? ~var37 : var37);
                return _setLength(var39, var38);
            } else {
                return NUMBER._makeZero();
            }
        }
    }

    private static byte digitPtr(int var0, int var1, boolean var2) {
        return var2 ? LnxqDigit_N[var0][var1] : LnxqDigit_P[var0][var1];
    }

    private static int lnxqctn(char var0) {
        return Character.digit(var0, 10);
    }

    public byte[] lnxfcn(String var1, String var2, String var3) throws SQLException {
        if (var3 != null && !var3.equals("AMERICAN_AMERICAN")) {
            throw new SQLException(CoreException.getMessage((byte)12));
        } else {
            LnxLibThinFormat var22 = new LnxLibThinFormat();
            var22.parseFormat(var2);
            var22.LNXNFRDX = true;
            int var23 = var22.lnxnflhd;
            int var24 = var22.lnxnfrhd;
            int var25 = var22.lnxnfsiz;
            int var26 = var22.lnxnfzld;
            if (var22.LNXNFFDA | var22.LNXNFFED | var22.LNXNFFRN | var22.LNXNFFTM) {
                throw new SQLException(CoreException.getMessage((byte)5));
            } else if (var22.LNXNFFRC | var22.LNXNFFCH | var22.LNXNFFCT) {
                throw new SQLException(CoreException.getMessage((byte)12));
            } else {
                char[] var27 = var1.toCharArray();
                int var28 = 0;
                int var29 = var27.length - 1;

                int var30;
                for(var30 = 0; var28 <= var29 && Character.isSpaceChar(var27[var28]); ++var30) {
                    ++var28;
                }

                if (var22.LNXNFFBL && var30 == var25 && var30 == var27.length) {
                    return NUMBER._makeZero();
                } else if (var28 > var29) {
                    throw new SQLException(CoreException.getMessage((byte)14));
                } else {
                    char[] var31 = new char[255];
                    int var32 = 0;
                    if (var22.LNXNFFSH) {
                        if (var27[var28] != '-' && var27[var28] != '+') {
                            throw new SQLException(CoreException.getMessage((byte)14));
                        }

                        var31[var32++] = var27[var28++];
                    } else if (var22.LNXNFFPR) {
                        if (var27[var28] == '<') {
                            var31[var32++] = '-';
                            ++var28;
                        } else {
                            var31[var32++] = '+';
                        }
                    } else if (var22.LNXNFFPT) {
                        if (var27[var28] == '(') {
                            var31[var32++] = '-';
                            ++var28;
                        } else {
                            var31[var32++] = '+';
                        }
                    } else if (!var22.LNXNFFMI && !var22.LNXNFFST) {
                        if (var27[var28] == '-') {
                            var31[var32++] = var27[var28++];
                        }
                    } else {
                        ++var32;
                    }

                    if (var28 > var29) {
                        throw new SQLException(CoreException.getMessage((byte)14));
                    } else {
                        if (var22.LNXNFFDS) {
                            if (var27[var28] != '$') {
                                throw new SQLException(CoreException.getMessage((byte)14));
                            }

                            ++var28;
                            if (var28 > var29) {
                                throw new SQLException(CoreException.getMessage((byte)14));
                            }
                        } else if (var22.LNXNFFCH) {
                            throw new SQLException(CoreException.getMessage((byte)12));
                        }

                        byte[] var33 = new byte[40];
                        int var34 = 0;
                        int var35 = 0;
                        int var36 = 0;
                        boolean var37 = false;

                        int var38;
                        while(var28 <= var29) {
                            if (!Character.isDigit(var27[var28]) && (!var22.LNXNFFHX || (var27[var28] < 'a' || var27[var28] > 'f') && (var27[var28] < 'A' || var27[var28] > 'F'))) {
                                if (!var37) {
                                    if (!var22.LNXNFRDX) {
                                        throw new SQLException(CoreException.getMessage((byte)12));
                                    }

                                    if (var27[var28] == ',') {
                                        ++var28;
                                        var33[var34++] = (byte)var36;
                                        continue;
                                    }

                                    if (var27[var28] == '.') {
                                        if (var36 <= var23 && var36 >= var26) {
                                            var36 = var23 - var36;

                                            for(var34 = 0; var22.lnxnfgps[var35] != 0; ++var35) {
                                                byte var40 = (byte)(var22.lnxnfgps[var35] & 127);
                                                if (var40 > var36) {
                                                    if (var33[var34] != var40 - var36) {
                                                        throw new SQLException(CoreException.getMessage((byte)14));
                                                    }

                                                    ++var34;
                                                }
                                            }

                                            var36 = 0;
                                            var37 = true;
                                            var31[var32] = '.';
                                            ++var32;
                                            ++var28;
                                            continue;
                                        }

                                        throw new SQLException(CoreException.getMessage((byte)14));
                                    }
                                }

                                if (var27[var28] != 'E' && var27[var28] != 'e' || !var22.LNXNFFSN) {
                                    if (var22.LNXNFFRC) {
                                        throw new SQLException(CoreException.getMessage((byte)12));
                                    }
                                    break;
                                }

                                if (var36 <= 0 && !var37) {
                                    throw new SQLException(CoreException.getMessage((byte)14));
                                }

                                var31[var32++] = var27[var28++];
                                if (var28 > var29) {
                                    throw new SQLException(CoreException.getMessage((byte)14));
                                }

                                if (var27[var28] == '+' || var27[var28] == '-') {
                                    var31[var32++] = var27[var28++];
                                }

                                for(var38 = var28; var28 <= var29 && Character.isDigit(var27[var28]); var31[var32++] = var27[var28++]) {
                                }

                                if (var38 == var28) {
                                    throw new SQLException(CoreException.getMessage((byte)14));
                                }
                            } else {
                                var31[var32++] = var27[var28++];
                                ++var36;
                            }
                        }

                        if (!var37) {
                            var38 = var23 - var36;

                            for(var34 = 0; var22.lnxnfgps[var35] != 0; ++var35) {
                                byte var39 = (byte)(var22.lnxnfgps[var35] & 127);
                                if (var39 > var38) {
                                    if (var33[var34] != var39 - var38) {
                                        throw new SQLException(CoreException.getMessage((byte)14));
                                    }

                                    ++var34;
                                }
                            }
                        }

                        if (var22.LNXNFFCT) {
                            throw new SQLException(CoreException.getMessage((byte)12));
                        } else {
                            if (var22.LNXNFFST) {
                                if (var28 > var29) {
                                    throw new SQLException(CoreException.getMessage((byte)14));
                                }

                                if (var27[var28] != '-' && var27[var28] != '+') {
                                    throw new SQLException(CoreException.getMessage((byte)14));
                                }

                                var31[0] = var27[var28];
                                ++var28;
                            } else if (var22.LNXNFFMI) {
                                if (var28 > var29) {
                                    if (var22.LNXNFFIL || var28 != var27.length) {
                                        throw new SQLException(CoreException.getMessage((byte)14));
                                    }

                                    var31[0] = '+';
                                } else {
                                    var31[0] = (char)(var27[var28] == '-' ? 45 : 43);
                                    ++var28;
                                }
                            } else if (var22.LNXNFFPR) {
                                if (var27[var28] == '>' && var31[0] == '-') {
                                    ++var28;
                                }
                            } else if (var22.LNXNFFPT && var28 < var27.length && var27[var28] == ')' && var31[0] == '-') {
                                ++var28;
                            }

                            if (var28 <= var29) {
                                throw new SQLException(CoreException.getMessage((byte)14));
                            } else {
                                if (var37) {
                                    if (var36 > var24) {
                                        throw new SQLException(CoreException.getMessage((byte)14));
                                    }
                                } else {
                                    if (var36 > var23) {
                                        throw new SQLException(CoreException.getMessage((byte)14));
                                    }

                                    if (var36 < var26) {
                                        throw new SQLException(CoreException.getMessage((byte)14));
                                    }
                                }

                                if (var22.LNXNFF05 && (var37 && var36 == var24 || var24 == 0)) {
                                    --var32;
                                    if (var31[var32] != '0' && var31[var32] != '5') {
                                        throw new SQLException(CoreException.getMessage((byte)14));
                                    }

                                    ++var32;
                                }

                                if (var22.LNXNFFHX) {
                                    return this.lnxqh2n(var31);
                                } else {
                                    return this.lnxcpn(new String(var31), false, 0, false, 0, var3);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String lnxnfn(byte[] var1, String var2, String var3) throws SQLException {
        Object var4 = null;
        boolean var5 = false;
        boolean var6 = false;
        boolean var7 = false;
        boolean var8 = false;
        boolean var9 = false;
        boolean var10 = false;
        boolean var11 = false;
        boolean var12 = false;
        boolean var13 = false;
        boolean var14 = false;
        int var15 = 0;
        boolean var16 = false;
        boolean var17 = false;
        boolean var18 = false;
        int var19 = 0;
        boolean var20 = false;
        boolean var21 = false;
        boolean var22 = false;
        byte[] var24 = null;
        boolean[] var25 = new boolean[1];
        boolean var26 = false;
        boolean var27 = true;
        boolean var29 = true;
        String var31 = null;
        LnxLibThinFormat var32 = new LnxLibThinFormat();
        var32.parseFormat(var2);
        int var39 = var32.lnxnflhd;
        int var40 = var32.lnxnfrhd;
        int var41 = var32.lnxnfsiz;
        int var42 = var32.lnxnfzld;
        int var43 = var32.lnxnfztr;
        if (!var32.LNXNFFRN && !var32.LNXNFFHX) {
            int var33;
            int var34;
            if (var32.LNXNFFTM) {
                var33 = var1.length;
                int var35;
                int var36;
                byte var37;
                if (!NUMBER._isZero(var1)) {
                    if (NUMBER._isPositive(var1)) {
                        var34 = var33 - 1;
                        var35 = 2 * ((var1[0] & 255) - 193) + ((var1[1] & 255) > 10 ? 1 : 0);
                        var36 = 2 * var34 - ((var1[1] & 255) < 11 ? 1 : 0) - LnxqFirstDigit[var1[var34]];
                        var37 = 0;
                    } else {
                        if ((var1[var33 - 1] & 255) == 102) {
                            --var33;
                        }

                        var34 = var33 - 1;
                        var35 = 2 * (62 - var1[0]) + ((var1[1] & 255) < 92 ? 1 : 0);
                        var36 = 2 * var34 - ((var1[1] & 255) > 91 ? 1 : 0) - LnxqFirstDigit[var1[var34]];
                        var37 = 1;
                    }
                } else {
                    var35 = 0;
                    var36 = 1;
                    var37 = 0;
                }

                int var56;
                if (var35 >= 0) {
                    var56 = var37 + (var36 > var35 + 1 ? var36 + 1 : var35 + 1);
                } else {
                    var56 = var37 + -(var35 + 1) + var36 + 1;
                }

                if (!var32.LNXNFFSN && var56 > 64) {
                    var32.LNXNFFSN = true;
                }

                if (var32.LNXNFFSN) {
                    var39 = 1;
                    var40 = var36 - 1;
                    var41 = var36 > 1 ? var36 + 7 : 7;
                } else {
                    var39 = var35 + 1 > 0 ? var35 + 1 : 0;
                    var40 = var36 - (var35 + 1) > 0 ? var36 - (var35 + 1) : 0;
                    var41 = var40 != 0 ? var39 + var40 + 2 : var39 + 1;
                }

                if (var40 == 0) {
                    var32.LNXNFNRD = true;
                }
            }

            boolean var30 = (var1[0] & 255) >= 128;
            byte[] var23;
            if (var32.LNXNFFSN) {
                var23 = this.lnxfpr(var1, var40 + var39);
            } else {
                var23 = this.lnxsca(var1, var39, var40, var25);
                if (var25[0]) {
                    throw new SQLException(CoreException.getMessage((byte)4));
                }
            }

            char[] var38 = new char[64];
            int var48 = 0;
            int var44;
            int var45;
            int var46;
            int var47;
            if (NUMBER._isZero(var23)) {
                if (var32.LNXNFFBL) {
                    if (!var32.LNXNFFIL) {
                        return null;
                    }

                    var38 = new char[var41];

                    for(var33 = 0; var33 < var41; ++var33) {
                        var38[var33] = ' ';
                    }

                    return new String(var38);
                }

                var27 = var30;
                var26 = false;
                var45 = 0;
                var47 = 0;
                var44 = var45;
                var46 = var39 > 0 && var43 == 0 ? 1 : 0;
            } else {
                if (NUMBER._isNegInf(var23) || NUMBER._isPosInf(var23)) {
                    throw new SQLException(CoreException.getMessage((byte)4));
                }

                var47 = var23.length - 1;
                var27 = (var23[0] & 128) != 0;
                if (var27) {
                    var24 = var23;
                } else {
                    var24 = new byte[var47];
                    if (var23[var47] == 102) {
                        --var47;
                    }

                    for(var33 = 1; var33 <= var47; ++var33) {
                        var24[var33] = (byte)(102 - var23[var33]);
                    }

                    var24[0] = (byte)(~var23[0]);
                }

                boolean var28 = (var24[var47] & 255) % 10 == 1;
                var44 = 2 * ((var24[0] & 255) - 192);
                var15 = 1;
                if (var29 = (var24[var15] & 255) < 11) {
                    var19 = ((var24[var15] & 255) - 1) / 10;
                }

                if (var32.LNXNFFSN) {
                    int var10000 = 2 * var47 - (var29 ? 1 : 0) - (var28 ? 1 : 0);
                    var46 = 1;
                    var45 = var10000 - 1;
                    var44 -= (var29 ? 1 : 0) + 1;
                    if (var26 = var44 < 0) {
                        var44 = -var44;
                    }

                    if (var44 < 100 && var32.LNXNFFIL) {
                        var38[var48] = ' ';
                        ++var48;
                    }
                } else {
                    var45 = 2 * var47 - var44 - (var28 ? 1 : 0);
                    var46 = var44 - (var29 ? 1 : 0);
                    if (var32.LNXNFF05 && (var40 == 0 || var45 == var40)) {
                        var33 = var15 + var47 - 1;
                        if (!var28) {
                            var34 = (var24[var33] & 255) % 10;
                            var34 = var34 != 0 ? var34 - 1 : 9;
                            if (var34 <= 2) {
                                var24[var33] = (byte)((var24[var33] & 255) - var34);
                            } else if (var34 <= 7) {
                                var24[var33] = (byte)((var24[var33] & 255) + (5 - var34));
                            }
                        } else {
                            var34 = (var24[var33] & 255) / 10;
                            if (var34 <= 2) {
                                var24[var33] = 1;
                            } else if (var34 <= 7) {
                                var24[var33] = 51;
                            }
                        }

                        if (var34 > 7) {
                            --var15;
                            var24 = this.lnxrou(var24, var45 - 1);
                            var47 = var24.length - 1;
                            var28 = (var24[var15] & 255) % 10 == 1;
                            var44 = 2 * ((var24[var15] & 255) - 192);
                            ++var15;
                            if (var29 = (var24[var15] & 255) < 11) {
                                var19 = ((var24[var15] & 255) - 1) / 10;
                            }

                            var45 = 2 * var47 - var44 - (var28 ? 1 : 0);
                            var46 = var44 - (var29 ? 1 : 0);
                            if (var46 > var39) {
                                throw new SQLException(CoreException.getMessage((byte)4));
                            }
                        }
                    }
                }
            }

            int var52 = var39 - (var42 > var46 ? var42 : var46);
            if (var52 != 0 && var32.LNXNFFIL) {
                var33 = var52 + var48;

                for(var34 = 0; var34 < var33; ++var48) {
                    var38[var34] = ' ';
                    ++var34;
                }
            }

            if (!var32.LNXNFFMI && !var32.LNXNFFST) {
                if (var27) {
                    var33 = var32.LNXNFFSH ? 43 : 32;
                } else {
                    var33 = var32.LNXNFFPR ? 60 : (var32.LNXNFFPT ? 40 : 45);
                }

                if (var32.LNXNFFIL || var33 != 32) {
                    var38[var48] = (char)var33;
                    ++var48;
                }
            }

            if (var32.LNXNFFIC) {
                var31 = "USD";
            } else if (var32.LNXNFFUN) {
                var31 = "$";
            } else {
                var31 = "$";
            }

            if (var32.LNXNFFDS) {
                var38[var48] = '$';
                ++var48;
            } else if (var32.LNXNFFCH) {
                for(var33 = 0; var33 < var31.length(); ++var48) {
                    var38[var48] = var31.charAt(var33);
                    ++var33;
                }
            }

            int var49;
            int var50;
            for(var49 = 0; (var50 = var32.lnxnfgps[var49] & 127) != 0 && var50 <= var52; ++var49) {
            }

            int var51;
            if ((var51 = var42 - (var46 > 0 ? var46 : 0)) > 0) {
                while(var51 > 0) {
                    var38[var48] = '0';
                    ++var48;
                    ++var52;

                    while(var52 == var50) {
                        var38[var48] = ',';
                        ++var48;
                        ++var49;
                        var50 = var32.lnxnfgps[var49] & 127;
                    }

                    --var51;
                }
            }

            int var54;
            if (var46 > 0) {
                while(var46 > 0 && var47 != 0) {
                    if (var29) {
                        var54 = (var24[var15] & 255) - 1 - var19 * 10;
                        ++var15;
                        --var47;
                    } else {
                        var54 = ((var24[var15] & 255) - 1) / 10;
                        var19 = var54;
                    }

                    var38[var48] = this.lnx_chars[var54];
                    ++var48;
                    ++var52;

                    while(var52 == var50) {
                        var38[var48] = ',';
                        ++var48;
                        ++var49;
                        var50 = var32.lnxnfgps[var49] & 127;
                    }

                    --var46;
                    var29 = !var29;
                }

                while(var46 > 0) {
                    var38[var48] = '0';
                    ++var48;
                    ++var52;

                    while(var52 == var50) {
                        var38[var48] = ',';
                        ++var48;
                        ++var49;
                        var50 = var32.lnxnfgps[var49] & 127;
                    }

                    --var46;
                }
            }

            if (!var32.LNXNFNRD) {
                if (var32.LNXNFRDX) {
                    var38[var48] = '.';
                    ++var48;
                } else if (var32.LNXNFFRC) {
                    for(var33 = 0; var33 < var31.length(); ++var48) {
                        var38[var48] = var31.charAt(var33);
                        ++var33;
                    }
                } else {
                    var38[var48] = '.';
                    ++var48;
                }
            }

            var20 = false;
            int var53;
            if ((var53 = var43 - (var45 > 0 ? var45 : 0)) < 0) {
                var53 = 0;
            }

            if (var46 != 0) {
                var46 = -var46;

                for(var45 -= var46; var46 != 0; --var46) {
                    var38[var48] = '0';
                    ++var48;
                }
            }

            while(var47 != 0 && var45 != 0) {
                if (var29) {
                    var54 = (var24[var15] & 255) - 1 - var19 * 10;
                    ++var15;
                    --var47;
                } else {
                    var54 = ((var24[var15] & 255) - 1) / 10;
                    var19 = var54;
                }

                var38[var48] = this.lnx_chars[var54];
                ++var48;
                --var45;
                var29 = !var29;
            }

            while(var53 != 0) {
                var38[var48] = '0';
                ++var48;
                --var53;
            }

            if (var32.LNXNFFSN) {
                var38[var48] = 'E';
                ++var48;
                var38[var48] = (char)(var26 ? 45 : 43);
                ++var48;
                if (var44 > 99) {
                    var38[var48] = '1';
                    ++var48;
                    var44 -= 100;
                }

                var38[var48] = this.lnx_chars[var44 / 10];
                ++var48;
                var38[var48] = this.lnx_chars[var44 % 10];
                ++var48;
            }

            if (var32.LNXNFFCT) {
                for(var33 = 0; var33 < var31.length(); ++var48) {
                    var38[var48] = var31.charAt(var33);
                    ++var33;
                }
            }

            if (var27) {
                if (var32.LNXNFFST) {
                    var38[var48] = '+';
                    ++var48;
                } else if ((var32.LNXNFFPR || var32.LNXNFFMI || var32.LNXNFFPT) && var32.LNXNFFIL) {
                    var38[var48] = ' ';
                    ++var48;
                }
            } else if (var32.LNXNFFPR) {
                var38[var48] = '>';
                ++var48;
            } else if (var32.LNXNFFPT) {
                var38[var48] = ')';
                ++var48;
            } else if (var32.LNXNFFMI || var32.LNXNFFST) {
                var38[var48] = '-';
                ++var48;
            }

            if (var32.LNXNFFIL && var48 != var41) {
                var51 = var41 - var48;
                char[] var57 = new char[var51];

                for(var34 = 0; var34 < var51; ++var34) {
                    var57[var34] = ' ';
                }

                StringBuffer var55 = new StringBuffer();
                var55.append(var57);
                var55.append(var38, 0, var48);
                return var55.toString();
            } else {
                return new String(var38, 0, var48);
            }
        } else if (var32.LNXNFFRN) {
            throw new SQLException(CoreException.getMessage((byte)1));
        } else {
            throw new SQLException(CoreException.getMessage((byte)1));
        }
    }

    public String lnxnuc(byte[] var1, int var2, String var3) throws SQLException {
        byte[] var8 = new byte[22];
        boolean var24 = false;
        if (var3 != null) {
            throw new SQLException(CoreException.getMessage((byte)12));
        } else {
            char[] var4 = this.lnx_chars;
            byte var16 = 46;
            if (var2 == 0) {
                throw new SQLException(CoreException.getMessage((byte)13));
            } else {
                boolean var9;
                if (!(var9 = var2 >= 0)) {
                    var2 = -var2;
                }

                char[] var30 = new char[var2];
                byte[][] var5;
                int var17;
                boolean var18;
                if (var18 = !NUMBER._isPositive(var1)) {
                    var5 = LnxqComponents_N;
                    var17 = var2 - 1;
                } else {
                    var5 = LnxqComponents_P;
                    var17 = var2;
                }

                boolean var31 = true;

                while(true) {
                    while(var31) {
                        boolean var10 = var9;
                        int var32 = var1.length;
                        int var15;
                        int var29;
                        if (var32 == 1) {
                            if ((var1[0] & 255) == 128) {
                                if (var9) {
                                    var15 = var2 - 1;
                                    var30[var15] = var4[0];
                                } else {
                                    if (var2 < 5) {
                                        throw new SQLException(CoreException.getMessage((byte)13));
                                    }

                                    var15 = var2 - 5;
                                    var30[var15] = var4[0];
                                    var30[var15 + 1] = var4[41];
                                    var30[var15 + 2] = var4[10];
                                    var30[var15 + 3] = var4[0];
                                    var30[var15 + 4] = var4[0];
                                }

                                if (var15 != 0) {
                                    for(var29 = 0; var29 < var15; ++var29) {
                                        var30[var29] = var4[12];
                                    }
                                }

                                return new String(var30);
                            }

                            if (var2 < 2) {
                                throw new SQLException(CoreException.getMessage((byte)13));
                            }

                            var15 = var2 - 2;
                            var30[var15] = var4[11];
                            var30[var15 + 1] = var4[21];
                            if (var15 != 0) {
                                for(var29 = 0; var29 < var15; ++var29) {
                                    var30[var29] = var4[12];
                                }
                            }

                            return new String(var30);
                        }

                        if (var32 == 2 && (var1[0] & 255) == 255 && (var1[1] & 255) == 101) {
                            var15 = var2 - 1;
                            var30[var15] = var4[21];
                            if (var15 != 0) {
                                for(var29 = 0; var29 < var15; ++var29) {
                                    var30[var29] = var4[12];
                                }
                            }

                            return new String(var30);
                        }

                        int var13;
                        int var14;
                        int var19;
                        if (var18) {
                            if (var1[var32 - 1] == 102) {
                                --var32;
                            }

                            var13 = var32 - 1;
                            var19 = 2 * (62 - (var1[0] & 255)) + ((var1[1] & 255) < 92 ? 1 : 0);
                            var14 = 2 * var13 - ((var1[1] & 255) > 91 ? 1 : 0) - LnxqFirstDigit[var1[var13]];
                        } else {
                            var13 = var32 - 1;
                            var19 = 2 * ((var1[0] & 255) - 193) + ((var1[1] & 255) > 10 ? 1 : 0);
                            var14 = 2 * var13 - ((var1[1] & 255) < 11 ? 1 : 0) - LnxqFirstDigit[var1[var13]];
                        }

                        if (var9) {
                            if (var19 >= 0) {
                                var10 = var19 < var17;
                            } else {
                                var10 = var19 >= -5 || var14 - var19 <= var17 || var17 <= 6;
                            }
                        }

                        int var11;
                        int var12;
                        int var20;
                        int var22;
                        boolean var23;
                        boolean var25;
                        boolean var26;
                        int var27;
                        int var28;
                        if (var10) {
                            if (var19 >= 0) {
                                var20 = var17 <= var19 + 1 ? var17 : var17 - 1;
                            } else {
                                var20 = var17 + var19;
                            }

                            if (var20 < var14) {
                                var1 = this.lnxfpr(var1, var20);
                                continue;
                            }

                            var31 = false;
                            if (var19 >= 0) {
                                if (var14 > var19 + 1) {
                                    var15 = var17 - (var14 + 1);
                                    var23 = true;
                                    var24 = false;
                                    var25 = (var19 & 1) <= 0;
                                    var26 = (var14 - var19 & 1) <= 0;
                                    int var33 = 2147483647;
                                    var27 = var19 + 1 & var33 - 1;
                                    var28 = var14 - (var19 + 1) & var33 - 1;
                                    var12 = var15;
                                } else {
                                    var15 = var17 - (var19 + 1);
                                    var22 = var19 + 1 - var14;
                                    var23 = false;
                                    var25 = (var19 & 1) <= 0;
                                    var26 = (var22 & 1) > 0;
                                    var27 = var14 - (var25 ? 1 : 0) - (var26 ? 1 : 0);
                                    var28 = 0;
                                    if (var22 != 0) {
                                        var11 = var15 + (var18 ? 1 : 0) + var14;

                                        for(var29 = 0; var29 < var22; ++var29) {
                                            var30[var11 + var29] = var4[0];
                                        }
                                    }

                                    var12 = var15;
                                }
                            } else {
                                var15 = var17 - (var14 - var19);
                                int var21 = -(var19 + 1);
                                var23 = false;
                                var25 = (var21 & 1) > 0;
                                var26 = (var21 + var14 & 1) > 0;
                                var27 = 0;
                                var28 = var14 - (var25 ? 1 : 0) - (var26 ? 1 : 0);
                                var11 = var15;
                                if (var18) {
                                    var30[var15] = var4[11];
                                    var11 = var15 + 1;
                                    var18 = false;
                                }

                                var30[var11] = (char)var16;
                                ++var11;
                                if (var21 != 0) {
                                    for(var29 = 0; var29 < var21; ++var29) {
                                        var30[var11 + var29] = var4[0];
                                    }

                                    var11 += var21;
                                }

                                var12 = var11;
                            }

                            if (var15 != 0) {
                                for(var29 = 0; var29 < var15; ++var29) {
                                    var30[var29] = var4[12];
                                }
                            }
                        } else {
                            var20 = var17 - (var19 <= 99 && var19 >= -99 ? 5 : 6);
                            if (var20 < 2) {
                                throw new SQLException(CoreException.getMessage((byte)13));
                            }

                            if (var20 < var14) {
                                var1 = this.lnxfpr(var1, var20);
                                continue;
                            }

                            var31 = false;
                            if (var14 == 1) {
                                var22 = var20 - 1;
                                var23 = true;
                                var24 = (var19 & 1) > 0;
                                var25 = !var24;
                                var26 = false;
                                var27 = 0;
                                var28 = 0;
                            } else {
                                var22 = var20 - var14;
                                var23 = true;
                                var24 = (var19 & 1) > 0;
                                var25 = !var24;
                                var26 = var24 == (var14 & 1) > 0;
                                var27 = 0;
                                var28 = var14 - (var25 ? 1 : 2) - (var26 ? 1 : 0);
                            }

                            var11 = (var18 ? 1 : 0) + 1 + var14;
                            if (var22 != 0) {
                                for(var29 = 0; var29 < var22; ++var29) {
                                    var30[var11 + var29] = var4[0];
                                }

                                var11 += var22;
                            }

                            if (var19 < 0) {
                                var19 = -var19;
                                var30[var11] = var4[41];
                                var30[var11 + 1] = var4[11];
                            } else {
                                var30[var11] = var4[41];
                                var30[var11 + 1] = var4[10];
                            }

                            if (var19 > 99) {
                                var30[var11 + 2] = var4[1];
                                var8[0] = (byte)(var19 - 99);
                                var30[var11 + 3] = var4[LnxqComponents_P[var8[0] & 255][0]];
                                var30[var11 + 4] = var4[LnxqComponents_P[var8[0] & 255][1]];
                            } else {
                                var8[0] = (byte)(var19 + 1);
                                var30[var11 + 2] = var4[LnxqComponents_P[var8[0] & 255][0]];
                                var30[var11 + 3] = var4[LnxqComponents_P[var8[0] & 255][1]];
                            }

                            var12 = 0;
                        }

                        int var6 = 1;
                        var11 = var12;
                        if (var18) {
                            var30[var12] = var4[11];
                            var11 = var12 + 1;
                        }

                        if (var25) {
                            var30[var11] = var4[var5[var1[var6]][1]];
                            ++var11;
                            ++var6;
                        }

                        int var7;
                        if (var27 != 0) {
                            for(var7 = var11 + var27; var11 < var7; ++var6) {
                                var30[var11] = var4[var5[var1[var6]][0]];
                                ++var11;
                                var30[var11] = var4[var5[var1[var6]][1]];
                                ++var11;
                            }
                        }

                        if (var23) {
                            if (var24) {
                                var30[var11] = var4[var5[var1[var6]][0]];
                                ++var11;
                                var30[var11] = (char)var16;
                                ++var11;
                                var30[var11] = var4[var5[var1[var6]][1]];
                                ++var11;
                                ++var6;
                            } else {
                                var30[var11] = (char)var16;
                                ++var11;
                            }
                        }

                        if (var28 != 0) {
                            for(var7 = var11 + var28; var11 < var7; ++var6) {
                                var30[var11] = var4[var5[var1[var6]][0]];
                                ++var11;
                                var30[var11] = var4[var5[var1[var6]][1]];
                                ++var11;
                            }
                        }

                        if (var26) {
                            var30[var11] = var4[var5[var1[var6]][0]];
                            ++var11;
                            ++var6;
                        }
                    }

                    return new String(var30);
                }
            }
        }
    }

    public byte[] lnxren(double var1) throws SQLException {
        byte[] var3 = new byte[20];
        int var4 = 0;
        boolean var6 = var1 >= 0.0D;
        var1 = Math.abs(var1);
        int var10;
        if (var1 < 1.0D) {
            for(var10 = 0; var10 < 8; ++var10) {
                if (powerTable[var10][2] >= var1) {
                    var4 -= (int)powerTable[var10][0];
                    var1 *= powerTable[var10][1];
                }
            }

            if (var1 < 1.0D) {
                --var4;
                var1 *= 100.0D;
            }
        } else {
            for(var10 = 0; var10 < 8; ++var10) {
                if (powerTable[var10][1] <= var1) {
                    var4 += (int)powerTable[var10][0];
                    var1 *= powerTable[var10][2];
                }
            }
        }

        if (var4 > 62) {
            throw new SQLException(CoreException.getMessage((byte)3));
        } else if (var4 < -65) {
            throw new SQLException(CoreException.getMessage((byte)2));
        } else {
            boolean var5 = var1 < 10.0D;
            byte var7 = 8;
            int var9 = 0;

            byte var8;
            for(var8 = (byte)((int)var1); var9 < var7; ++var9) {
                var3[var9] = var8;
                var1 = (var1 - (double)var8) * 100.0D;
                var8 = (byte)((int)var1);
            }

            var9 = 7;
            if (var5) {
                if (var8 >= 50) {
                    ++var3[var9];
                }
            } else if (var4 == 62 && (var3[var9] + 5) / 10 * 10 == 100) {
                var3[var9] = (byte)((var3[var9] - 5) / 10 * 10);
            } else {
                var3[var9] = (byte)((var3[var9] + 5) / 10 * 10);
            }

            while(var3[var9] == 100) {
                if (var9 == 0) {
                    ++var4;
                    var3[var9] = 1;
                    break;
                }

                var3[var9] = 0;
                --var9;
                ++var3[var9];
            }

            for(var9 = 7; var9 != 0 && var3[var9] == 0; --var9) {
                --var7;
            }

            byte[] var11 = new byte[var7 + 1];
            var11[0] = (byte)var4;
            System.arraycopy(var3, 0, var11, 1, var7);
            return NUMBER._toLnxFmt(var11, var6);
        }
    }

    public byte[] lnxmin(long var1) {
        byte[] var4 = new byte[20];
        byte[] var7 = new byte[20];
        byte var8 = 0;
        if (var1 == 0L) {
            return NUMBER._makeZero();
        } else {
            boolean var3 = var1 >= 0L;

            int var5;
            for(var5 = 0; var1 != 0L; ++var5) {
                var4[var5] = (byte)((int)Math.abs(var1 % 100L));
                var1 /= 100L;
            }

            --var5;
            byte var6 = (byte)var5;

            for(int var9 = var6; var8 <= var6; --var9) {
                var7[var8] = var4[var9];
                ++var8;
            }

            while(var5 > 0 && var7[var5--] == 0) {
                --var8;
            }

            byte[] var10 = new byte[var8 + 1];
            var10[0] = var6;
            System.arraycopy(var7, 0, var10, 1, var8);
            return NUMBER._toLnxFmt(var10, var3);
        }
    }

    public double lnxnur(byte[] var1) {
        double var2 = 0.0D;
        int var5 = 1;
        boolean var9 = false;
        int var14 = factorTable.length;
        byte[] var15 = NUMBER._fromLnxFmt(var1);
        boolean var10 = var15[1] < 10;
        double var16 = factorTable[0][0];
        double var18 = factorTable[0][0] - (double)(var14 - 20);
        int var4;
        int var13;
        if ((double)var15[0] <= var16 && (double)var15[0] >= var18) {
            var4 = -1 + (int)(var16 - (double)var15[0]);
            var13 = 0;
        } else if ((double)var15[0] > var16) {
            var4 = -1;
            var13 = (int)((double)var15[0] - var16);
        } else {
            var4 = -1 + (var14 - 20);
            var13 = (int)((double)var15[0] - var18);
        }

        int var8;
        label104: {
            var8 = var15.length - 1;
            if (var10) {
                if (var8 <= 8) {
                    break label104;
                }
            } else if (var8 < 8) {
                break label104;
            }

            var8 = 8;
            var9 = true;
        }

        int var7;
        double var11;
        switch(var8 % 4) {
            case 1:
                byte var20 = var15[1];
                ++var4;
                var11 = factorTable[var4][1];
                if (var11 < 1.0D) {
                    var2 = (double)var20 / factorTable[var4][2];
                } else {
                    var2 = (double)var20 * factorTable[var4][1];
                }

                ++var5;
                --var8;
                break;
            case 2:
                var7 = var15[1] * 100 + var15[2];
                var4 += 2;
                var11 = factorTable[var4][1];
                if (var11 < 1.0D) {
                    var2 = (double)var7 / factorTable[var4][2];
                } else {
                    var2 = (double)var7 * factorTable[var4][1];
                }

                var5 += 2;
                var8 -= 2;
                break;
            case 3:
                var7 = (var15[1] * 100 + var15[2]) * 100 + var15[3];
                var4 += 3;
                var11 = factorTable[var4][1];
                if (var11 < 1.0D) {
                    var2 = (double)var7 / factorTable[var4][2];
                } else {
                    var2 = (double)var7 * factorTable[var4][1];
                }

                var5 += 3;
                var8 -= 3;
                break;
            default:
                var2 = 0.0D;
        }

        while(var8 > 0) {
            var7 = ((var15[var5] * 100 + var15[var5 + 1]) * 100 + var15[var5 + 2]) * 100 + var15[var5 + 3];
            var4 += 4;
            var11 = factorTable[var4][1];
            if (var11 < 1.0D) {
                var2 += (double)var7 / factorTable[var4][2];
            } else {
                var2 += (double)var7 * factorTable[var4][1];
            }

            var5 += 4;
            var8 -= 4;
        }

        if (var9) {
            if (var10) {
                if (var15[var5] > 50) {
                    byte var21 = 1;
                    var2 += (double)var21 * factorTable[var4][1];
                }
            } else {
                --var5;
                if (var15[var5] % 10 >= 5) {
                    var7 = (var15[var5] / 10 + 1) * 10;
                } else {
                    var7 = var15[var5] / 10 * 10;
                }

                var7 -= var15[var5];
                var2 += (double)var7 * factorTable[var4][1];
            }
        }

        if (var13 != 0) {
            int var6;
            for(var6 = 0; var13 > 0; ++var6) {
                if ((int)powerTable[var6][0] <= var13) {
                    var13 -= (int)powerTable[var6][0];
                    var2 *= powerTable[var6][1];
                }
            }

            for(; var13 < 0; ++var6) {
                if ((int)powerTable[var6][0] <= -var13) {
                    var13 += (int)powerTable[var6][0];
                    var2 *= powerTable[var6][2];
                }
            }
        }

        return NUMBER._isPositive(var1) ? var2 : -var2;
    }

    public long lnxsni(byte[] var1) throws SQLException {
        long var2 = 0L;
        byte[] var4 = NUMBER._fromLnxFmt(var1);
        byte var5 = var4[0];
        byte var6 = (byte)(var4.length - 1);
        int var7 = var6 > var5 + 1 ? var5 + 1 : var6;

        int var8;
        for(var8 = 0; var8 < var7; ++var8) {
            var2 = var2 * 100L + (long)var4[var8 + 1];
        }

        for(var8 = var5 - var6; var8 >= 0; --var8) {
            var2 *= 100L;
        }

        return NUMBER._isPositive(var1) ? var2 : -var2;
    }

    private byte[] lnxqh2n(char[] var1) {
        int var3 = 0;
        int var4 = var1.length;
        long[] var5 = new long[14];
        int var6 = 13;
        byte var7 = 13;
        byte[] var9 = new byte[42];

        int var10;
        for(var10 = 1; var4 != 0 && var1[var4 - 1] == 0; --var4) {
        }

        while(var4 != 0 && var1[var3] == '0') {
            ++var3;
            --var4;
        }

        if (var4 == 0) {
            return NUMBER._makeZero();
        } else {
            var5[var7] = 0L;
            switch(var4 % 3) {
                case 0:
                    var5[var7] = this.LNXQH2N_DIGIT(var1[var3], 8, var5[var7]);
                    ++var3;
                    --var4;
                case 2:
                    var5[var7] = this.LNXQH2N_DIGIT(var1[var3], 4, var5[var7]);
                    ++var3;
                    --var4;
                case 1:
                    var5[var7] = this.LNXQH2N_DIGIT(var1[var3], 0, var5[var7]);
                    ++var3;
                    --var4;
            }

            int var8;
            while(var4 != 0) {
                long var15 = 0L;
                var15 = this.LNXQH2N_DIGIT(var1[var3], 8, var15);
                var15 = this.LNXQH2N_DIGIT(var1[var3 + 1], 4, var15);
                var15 = this.LNXQH2N_DIGIT(var1[var3 + 2], 0, var15);

                for(var8 = var7; var8 >= var6; --var8) {
                    var15 += var5[var8] << 12;
                    var5[var8] = var15 % 1000000L;
                    var15 /= 1000000L;
                }

                if (var15 != 0L) {
                    --var6;
                    var5[var6] = var15;
                }

                var3 += 3;
                var4 -= 3;
            }

            int var14 = 3 * (var7 - var6) + 1;
            var14 += var5[var6] >= 100L ? 1 : 0;
            var14 += var5[var6] >= 10000L ? 1 : 0;
            byte[] var17 = new byte[22];
            byte var18 = 0;
            var17[var18] = (byte)(var14 + 192);
            int var11;
            byte[] var12;
            int var13;
            if (var14 > 20) {
                var12 = var9;
                var11 = var10;
                var13 = 21;
            } else {
                var12 = var17;
                var11 = var18 + 1;
                var13 = var14 + 1;
            }

            switch(var14 % 3) {
                case 0:
                    var12[var11] = (byte)((int)(var5[var6] / 10000L + 1L));
                    ++var11;
                case 2:
                    var12[var11] = (byte)((int)(var5[var6] % 10000L / 100L + 1L));
                    ++var11;
                case 1:
                    var12[var11] = (byte)((int)(var5[var6] % 100L + 1L));
                    ++var11;
                default:
                    for(var8 = var6 + 1; var8 <= var7; ++var8) {
                        var12[var11] = (byte)((int)(var5[var8] / 10000L + 1L));
                        var12[var11 + 1] = (byte)((int)(var5[var8] % 10000L / 100L + 1L));
                        var12[var11 + 2] = (byte)((int)(var5[var8] % 100L + 1L));
                        var11 += 3;
                    }

                    if (var14 > 20) {
                        var11 = var10 + 20;
                        if (var9[var11] > 50) {
                            var9[var10 - 1] = 1;
                            --var11;

                            while(var9[var11] == 100) {
                                --var11;
                                --var13;
                            }

                            ++var9[var11];
                            if (var11 < var10) {
                                --var10;
                                ++var17[var18];
                                var13 = 2;
                            }
                        }

                        for(int var19 = 0; var19 < var13; ++var19) {
                            var17[var18 + 1 + var19] = var9[var10 + var19];
                        }
                    }

                    for(var11 = var18 + (var13 - 1); var12[var11] == 1; --var13) {
                        --var11;
                    }

                    byte[] var20 = new byte[var13];
                    System.arraycopy(var17, 0, var20, 0, var13);
                    return var20;
            }
        }
    }

    private long LNXQH2N_DIGIT(char var1, int var2, long var3) {
        long var10;
        if (var1 >= 'a' && var1 <= 'f') {
            var10 = var3 + (long)(var1 - 97 + 10 << var2);
            return var10;
        } else if (var1 >= 'A' && var1 <= 'F') {
            var10 = var3 + (long)(var1 - 65 + 10 << var2);
            return var10;
        } else {
            var10 = var3 + (long)(var1 - 48 << var2);
            return var10;
        }
    }

    private byte[] lnxqtra(byte[] var1, int var2) throws SQLException {
        Object var3 = null;
        Object var4 = null;
        Object var5 = null;
        byte[] var6 = NUMBER.pi().shareBytes();
        byte[] var7 = this.lnxmin(-1L);
        long var8 = 0L;
        byte[] var19;
        byte[] var20;
        byte[] var21;
        if (var2 != 3 && var2 != 4 && var2 != 5) {
            if (var2 == 9) {
                var19 = this.lnxmod(var1, lnxqone);
                var21 = this.lnxsub(var1, var19);
                if ((var21[0] & 255) < 60) {
                    return NUMBER._makeZero();
                }

                if ((var21[0] & 255) > 195) {
                    return NUMBER._makePosInf();
                }

                var8 = this.lnxsni(var21);
                var20 = this.lnxmul(var19, var19);
            } else {
                var19 = new byte[var1.length];
                System.arraycopy(var1, 0, var19, 0, var1.length);
                var20 = this.lnxmul(var19, var19);
            }
        } else {
            var21 = this.lnxmul(lnxqtwo, var6);
            var19 = this.lnxabs(var1);
            var19 = this.lnxmod(var19, var21);
            if (this.lnxcmp(var19, var6) > 0) {
                var19 = this.lnxsub(var19, var21);
            }

            if (this.lnxsgn(var1) == -1) {
                var19 = this.lnxneg(var19);
            }

            var20 = this.lnxmul(var19, var19);
        }

        byte[] var10 = null;
        byte[] var11 = null;
        int var12;
        if (var2 != 4 && var2 != 7) {
            var21 = lnxqone;
            var10 = lnxqone;
            var11 = NUMBER._makeZero();
            int var13 = 0;

            do {
                var21 = this.lnxmul(var20, var21);
                var12 = (var13 + 1) * (var13 + 2);
                var13 += 2;
                var21 = this.lnxqIDiv(var21, var12);
                var11 = this.lnxadd(var11, var21);
                var21 = this.lnxmul(var20, var21);
                var12 = (var13 + 1) * (var13 + 2);
                var13 += 2;
                var21 = this.lnxqIDiv(var21, var12);
                var10 = this.lnxadd(var10, var21);
            } while((var21[0] & 255) + 20 >= (var10[0] & 255) && (var11[0] & 255) != 255);
        }

        byte[] var22 = null;
        byte[] var14 = null;
        if (var2 != 3 && var2 != 6) {
            var21 = new byte[var19.length];
            System.arraycopy(var19, 0, var21, 0, var19.length);
            var22 = new byte[var19.length];
            System.arraycopy(var19, 0, var22, 0, var19.length);
            var14 = NUMBER._makeZero();
            int var15 = 1;

            do {
                var21 = this.lnxmul(var20, var21);
                var12 = (var15 + 1) * (var15 + 2);
                var15 += 2;
                var21 = this.lnxqIDiv(var21, var12);
                var14 = this.lnxadd(var14, var21);
                var21 = this.lnxmul(var20, var21);
                var12 = (var15 + 1) * (var15 + 2);
                var15 += 2;
                var21 = this.lnxqIDiv(var21, var12);
                var22 = this.lnxadd(var22, var21);
            } while(((var21[0] & 255) != 128 || var21.length != 1) && ((var21[0] & 255) < 128 || (var21[0] & 255) + 20 >= (var22[0] & 255)) && ((var21[0] & 255) >= 128 || (var21[0] & 255) <= (var22[0] & 255) + 20) && (var14[0] & 255) != 255 && (var14[0] & 255) != 0);
        }

        byte[] var23 = null;
        Object var16 = null;
        byte[] var24;
        if (var2 != 3 && var2 != 4 && var2 != 5) {
            if (var2 == 6) {
                return this.lnxadd(var10, var11);
            } else if (var2 == 7) {
                return this.lnxadd(var22, var14);
            } else {
                var24 = this.lnxadd(var22, var14);
                var23 = this.lnxadd(var10, var11);
                if (var2 == 8) {
                    return this.lnxdiv(var24, var23);
                } else {
                    byte[] var17 = NUMBER.e().shareBytes();
                    byte[] var18 = this.lnxadd(var23, var24);
                    var19 = this.lnxpow(var17, (int)var8);
                    var18 = this.lnxmul(var18, var19);
                    return var18;
                }
            }
        } else {
            if (var2 == 3 || var2 == 5) {
                var23 = this.lnxsub(var10, var11);
                if (this.lnxcmp(var23, lnxqone) > 0) {
                    var23 = lnxqone;
                } else if (this.lnxcmp(var23, var7) < 0) {
                    var23 = var7;
                }
            }

            if (var2 == 3) {
                return var23;
            } else {
                var24 = this.lnxsub(var22, var14);
                if (this.lnxcmp(var24, lnxqone) > 0) {
                    var24 = lnxqone;
                } else if (this.lnxcmp(var24, var7) < 0) {
                    var24 = var7;
                }

                return var2 == 4 ? var24 : this.lnxdiv(var24, var23);
            }
        }
    }

    private byte[] lnxqtri(byte[] var1, int var2) throws SQLException {
        Object var3 = null;
        Object var4 = null;
        Object var5 = null;
        byte[] var6 = NUMBER.pi().shareBytes();
        byte[] var7 = this.lnxdiv(var6, lnxqtwo);
        if (var2 == 2) {
            if (NUMBER._isPosInf(var1)) {
                return var7;
            }

            if (NUMBER._isNegInf(var1)) {
                return this.lnxneg(var7);
            }
        }

        byte[] var8 = this.lnxabs(var1);
        byte[] var15;
        byte[] var16;
        if (var2 == 1 || var2 == 0) {
            if (this.lnxcmp(var8, lnxqone) > 0) {
                throw new SQLException(CoreException.getMessage((byte)11));
            }

            if ((var8[0] & 255) <= 183) {
                if (var2 == 1) {
                    byte[] var18 = new byte[var1.length];
                    System.arraycopy(var1, 0, var18, 0, var1.length);
                    return var18;
                }

                return this.lnxsub(var7, var1);
            }

            var15 = this.lnxsub(lnxqone, var8);
            var16 = this.lnxadd(lnxqone, var8);
            var8 = this.lnxdiv(var15, var16);
            var8 = this.lnxsqr(var8);
        }

        int var9;
        if ((var9 = this.lnxcmp(var8, lnxqone)) > 0) {
            var8 = this.lnxdiv(lnxqone, var8);
        }

        var15 = new byte[var8.length];
        System.arraycopy(var8, 0, var15, 0, var8.length);
        int var10 = 1;

        while(true) {
            var16 = this.lnxtan(var15);
            byte[] var17 = this.lnxsub(var8, var16);
            var16 = this.lnxmul(var16, var16);
            var16 = this.lnxadd(var16, lnxqone);
            var16 = this.lnxdiv(var17, var16);
            int var11 = (var16[0] & 255) >= 128 ? (var16[0] & 255) - 193 : 62 - (var16[0] & 255);
            int var12 = (var15[0] & 255) >= 128 ? (var15[0] & 255) - 193 : 62 - (var15[0] & 255);
            if ((var16[0] & 255) == 128 && var16.length == 1 || (var11 & 255) + 15 < (var12 & 255) || var10 > 15) {
                if (var9 > 0) {
                    var15 = this.lnxsub(var7, var15);
                }

                if ((var15[0] & 255) < 128) {
                    var15 = NUMBER._makeZero();
                }

                if (this.lnxcmp(var15, var7) > 0) {
                    var15 = var7;
                }

                if (var2 == 1 || var2 == 0) {
                    var15 = this.lnxmul(var15, lnxqtwo);
                }

                switch(var2) {
                    case 0:
                        if (NUMBER._isPositive(var1)) {
                            return var15;
                        }

                        return this.lnxsub(var6, var15);
                    case 1:
                        if (NUMBER._isPositive(var1)) {
                            return this.lnxsub(var7, var15);
                        }

                        return this.lnxsub(var15, var7);
                    case 2:
                        if (NUMBER._isPositive(var1)) {
                            return var15;
                        }

                        return this.lnxneg(var15);
                    default:
                        throw new SQLException(CoreException.getMessage((byte)11));
                }
            }

            var15 = this.lnxadd(var15, var16);
            ++var10;
        }
    }

    private int lnxcmp(byte[] var1, byte[] var2) {
        return NUMBER.compareBytes(var1, var2);
    }

    private int lnxsgn(byte[] var1) {
        if (NUMBER._isZero(var1)) {
            return 0;
        } else {
            return NUMBER._isPositive(var1) ? 1 : -1;
        }
    }

    private byte[] lnxqIDiv(byte[] var1, int var2) throws SQLException {
        byte[] var3 = this.lnxmin((long)var2);
        return this.lnxdiv(var1, var3);
    }

    private static void _negateNumber(byte[] var0) {
        for(int var1 = var0.length - 1; var1 > 0; --var1) {
            var0[var1] = LnxqNegate[var0[var1]];
        }

        var0[0] = (byte)(~var0[0]);
    }

    private static byte[] _setLength(byte[] var0, int var1) {
        boolean var2 = NUMBER._isPositive(var0);
        byte[] var3;
        if (var2) {
            var3 = new byte[var1];
        } else if (var1 <= 20 && var0[var1 - 1] != 102) {
            var3 = new byte[var1 + 1];
            var3[var1] = 102;
        } else {
            var3 = new byte[var1];
        }

        System.arraycopy(var0, 0, var3, 0, var1);
        return var3;
    }

    private static class lnxqc {
        static final int LNXQC0 = 0;
        static final int LNXQC1 = 1;
        static final int LNXQC2 = 2;
        static final int LNXQC3 = 3;
        static final int LNXQC4 = 4;
        static final int LNXQC5 = 5;
        static final int LNXQC6 = 6;
        static final int LNXQC7 = 7;
        static final int LNXQC8 = 8;
        static final int LNXQC9 = 9;
        static final int LNXQCPLUS = 10;
        static final int LNXQCMINUS = 11;
        static final int LNXQCSPACE = 12;
        static final int LNXQCDOT = 13;
        static final int LNXQCCOMMA = 14;
        static final int LNXQCDOLLR = 15;
        static final int LNXQCLT = 16;
        static final int LNXQCGRT = 17;
        static final int LNXQCLPT = 18;
        static final int LNXQCRPT = 19;
        static final int LNXQCHASH = 20;
        static final int LNXQCTILDE = 21;
        static final int LNXQCASML = 22;
        static final int LNXQCBSML = 23;
        static final int LNXQCCSML = 24;
        static final int LNXQCDSML = 25;
        static final int LNXQCESML = 26;
        static final int LNXQCFSML = 27;
        static final int LNXQCGSML = 28;
        static final int LNXQCISML = 29;
        static final int LNXQCLSML = 30;
        static final int LNXQCMSML = 31;
        static final int LNXQCPSML = 32;
        static final int LNXQCRSML = 33;
        static final int LNXQCSSML = 34;
        static final int LNXQCTSML = 35;
        static final int LNXQCVSML = 36;
        static final int LNXQCALRG = 37;
        static final int LNXQCBLRG = 38;
        static final int LNXQCCLRG = 39;
        static final int LNXQCDLRG = 40;
        static final int LNXQCELRG = 41;
        static final int LNXQCFLRG = 42;
        static final int LNXQCILRG = 43;
        static final int LNXQCLLRG = 44;
        static final int LNXQCMLRG = 45;
        static final int LNXQCPLRG = 46;
        static final int LNXQCRLRG = 47;
        static final int LNXQCSLRG = 48;
        static final int LNXQCTLRG = 49;

        private lnxqc() {
        }
    }
}
