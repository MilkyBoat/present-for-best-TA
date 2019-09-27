package bsh;

import bsh.org.objectweb.asm.Constants;
import com.androlua.BuildConfig;
import java.io.IOException;
import java.io.PrintStream;

public class ParserTokenManager implements ParserConstants {

    /* renamed from: a */
    static final long[] f659a = {0, 0, -1, -1};

    /* renamed from: b */
    static final long[] f660b = {-2, -1, -1, -1};

    /* renamed from: c */
    static final long[] f661c = {2301339413881290750L, -16384, 4294967295L, 432345564227567616L};

    /* renamed from: d */
    static final long[] f662d = {0, 0, 0, -36028797027352577L};

    /* renamed from: e */
    static final long[] f663e = {0, -1, -1, -1};

    /* renamed from: f */
    static final long[] f664f = {-1, -1, 65535, 0};

    /* renamed from: g */
    static final long[] f665g = {-1, -1, 0, 0};

    /* renamed from: h */
    static final long[] f666h = {70368744177663L, 0, 0, 0};

    /* renamed from: i */
    static final int[] f667i = {37, 38, 43, 44, 47, 48, 15, 56, 61, 73, 26, 27, 29, 17, 19, 52, 54, 9, 57, 58, 60, 2, 3, 5, 11, 12, 15, 26, 27, 31, 29, 39, 40, 15, 47, 48, 15, 63, 64, 66, 69, 70, 72, 13, 14, 20, 21, 23, 28, 30, 32, 41, 42, 45, 46, 49, 50};

    /* renamed from: j */
    static final long[] f668j = {2305843009213692929L, -195, 63};
    public static final String[] jjstrLiteralImages;

    /* renamed from: k */
    static final long[] f669k = {1022, 0, 0};

    /* renamed from: l */
    static final long[] f670l = {896, 0, 0};
    public static final String[] lexStateNames = {"DEFAULT"};
    public PrintStream debugStream;

    /* renamed from: m */
    protected JavaCharStream f671m;

    /* renamed from: n */
    protected char f672n;

    /* renamed from: o */
    int f673o;

    /* renamed from: p */
    int f674p;

    /* renamed from: q */
    int f675q;

    /* renamed from: r */
    int f676r;

    /* renamed from: s */
    int f677s;

    /* renamed from: t */
    int f678t;

    /* renamed from: u */
    private final int[] f679u;

    /* renamed from: v */
    private final int[] f680v;

    static {
        String[] strArr = new String[Constants.I2F];
        strArr[0] = BuildConfig.FLAVOR;
        strArr[1] = null;
        strArr[2] = null;
        strArr[3] = null;
        strArr[4] = null;
        strArr[5] = null;
        strArr[6] = null;
        strArr[7] = null;
        strArr[8] = null;
        strArr[9] = null;
        strArr[10] = "abstract";
        strArr[11] = "boolean";
        strArr[12] = "break";
        strArr[13] = "class";
        strArr[14] = "byte";
        strArr[15] = "case";
        strArr[16] = "catch";
        strArr[17] = "char";
        strArr[18] = "const";
        strArr[19] = "continue";
        strArr[20] = "default";
        strArr[21] = "do";
        strArr[22] = "double";
        strArr[23] = "else";
        strArr[24] = "enum";
        strArr[25] = "extends";
        strArr[26] = "false";
        strArr[27] = "final";
        strArr[28] = "finally";
        strArr[29] = "float";
        strArr[30] = "for";
        strArr[31] = "goto";
        strArr[32] = "if";
        strArr[33] = "implements";
        strArr[34] = "import";
        strArr[35] = "instanceof";
        strArr[36] = "int";
        strArr[37] = "interface";
        strArr[38] = "long";
        strArr[39] = "native";
        strArr[40] = "new";
        strArr[41] = "null";
        strArr[42] = "package";
        strArr[43] = "private";
        strArr[44] = "protected";
        strArr[45] = "public";
        strArr[46] = "return";
        strArr[47] = "short";
        strArr[48] = "static";
        strArr[49] = "strictfp";
        strArr[50] = "switch";
        strArr[51] = "synchronized";
        strArr[52] = "transient";
        strArr[53] = "throw";
        strArr[54] = "throws";
        strArr[55] = "true";
        strArr[56] = "try";
        strArr[57] = "void";
        strArr[58] = "volatile";
        strArr[59] = "while";
        strArr[60] = null;
        strArr[61] = null;
        strArr[62] = null;
        strArr[63] = null;
        strArr[64] = null;
        strArr[65] = null;
        strArr[66] = null;
        strArr[67] = null;
        strArr[68] = null;
        strArr[69] = null;
        strArr[70] = null;
        strArr[71] = null;
        strArr[72] = "(";
        strArr[73] = ")";
        strArr[74] = "{";
        strArr[75] = "}";
        strArr[76] = "[";
        strArr[77] = "]";
        strArr[78] = ";";
        strArr[79] = ",";
        strArr[80] = ".";
        strArr[81] = "=";
        strArr[82] = ">";
        strArr[83] = "@gt";
        strArr[84] = "<";
        strArr[85] = "@lt";
        strArr[86] = "!";
        strArr[87] = "~";
        strArr[88] = "?";
        strArr[89] = ":";
        strArr[90] = "==";
        strArr[91] = "<=";
        strArr[92] = "@lteq";
        strArr[93] = ">=";
        strArr[94] = "@gteq";
        strArr[95] = "!=";
        strArr[96] = "||";
        strArr[97] = "@or";
        strArr[98] = "&&";
        strArr[99] = "@and";
        strArr[100] = "++";
        strArr[101] = "--";
        strArr[102] = "+";
        strArr[103] = "-";
        strArr[104] = "*";
        strArr[105] = "/";
        strArr[106] = "&";
        strArr[107] = "@bitwise_and";
        strArr[108] = "|";
        strArr[109] = "@bitwise_or";
        strArr[110] = "^";
        strArr[111] = "%";
        strArr[112] = "<<";
        strArr[113] = "@left_shift";
        strArr[114] = ">>";
        strArr[115] = "@right_shift";
        strArr[116] = ">>>";
        strArr[117] = "@right_unsigned_shift";
        strArr[118] = "+=";
        strArr[119] = "-=";
        strArr[120] = "*=";
        strArr[121] = "/=";
        strArr[122] = "&=";
        strArr[123] = "@and_assign";
        strArr[124] = "|=";
        strArr[125] = "@or_assign";
        strArr[126] = "^=";
        strArr[127] = "%=";
        strArr[128] = "<<=";
        strArr[129] = "@left_shift_assign";
        strArr[130] = ">>=";
        strArr[131] = "@right_shift_assign";
        strArr[132] = ">>>=";
        strArr[133] = "@right_unsigned_shift_assign";
        jjstrLiteralImages = strArr;
    }

    public ParserTokenManager(JavaCharStream javaCharStream) {
        this.debugStream = System.out;
        this.f679u = new int[74];
        this.f680v = new int[Constants.LCMP];
        this.f673o = 0;
        this.f674p = 0;
        this.f671m = javaCharStream;
    }

    public ParserTokenManager(JavaCharStream javaCharStream, int i) {
        this(javaCharStream);
        SwitchTo(i);
    }

    /* renamed from: a */
    private final int m667a(int i, int i2) {
        this.f678t = i2;
        this.f677s = i;
        return i + 1;
    }

    /* renamed from: a */
    private final int m668a(int i, int i2, int i3) {
        this.f678t = i2;
        this.f677s = i;
        try {
            this.f672n = this.f671m.readChar();
            return m693e(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    /* renamed from: a */
    private final int m669a(int i, long j, long j2, long j3) {
        int i2;
        switch (i) {
            case 0:
                if ((j2 & 144117387099111424L) != 0) {
                    return 56;
                }
                if ((j & 62) != 0) {
                    return 0;
                }
                if ((j2 & 65536) != 0) {
                    return 11;
                }
                if ((j & 1152921504606845952L) == 0) {
                    return -1;
                }
                this.f678t = 69;
                return 35;
            case 1:
                if ((j & 4301258752L) != 0) {
                    return 35;
                }
                if ((j & 1152921500305587200L) == 0) {
                    return -1;
                }
                if (this.f677s != 1) {
                    this.f678t = 69;
                    this.f677s = 1;
                }
                return 35;
            case 2:
                if ((j & 1080862599528053760L) == 0) {
                    return (j & 72058900781727744L) != 0 ? 35 : -1;
                }
                if (this.f677s != 2) {
                    this.f678t = 69;
                    this.f677s = 2;
                }
                return 35;
            case 3:
                if ((j & 900716275798195200L) == 0) {
                    return (j & 180146461168812032L) != 0 ? 35 : -1;
                }
                if (this.f677s != 3) {
                    this.f678t = 69;
                    this.f677s = 3;
                }
                return 35;
            case 4:
                if ((j & 603623088562974720L) != 0) {
                    return 35;
                }
                if ((j & 297093187235220480L) == 0) {
                    return -1;
                }
                if (this.f677s != 4) {
                    this.f678t = 69;
                    this.f677s = 4;
                }
                return 35;
            case 5:
                if ((j & 295579692563958784L) != 0) {
                    this.f678t = 69;
                    i2 = 5;
                    break;
                } else {
                    return (j & 19527893449179136L) != 0 ? 35 : -1;
                }
            case 6:
                if ((j & 295566498121384960L) != 0) {
                    this.f678t = 69;
                    i2 = 6;
                    break;
                } else {
                    return (j & 13194442573824L) != 0 ? 35 : -1;
                }
            case 7:
                if ((j & 288793326105658368L) != 0) {
                    return 35;
                }
                if ((j & 6773172015726592L) != 0) {
                    this.f678t = 69;
                    i2 = 7;
                    break;
                } else {
                    return -1;
                }
            case 8:
                if ((j & 2251842763358208L) != 0) {
                    this.f678t = 69;
                    i2 = 8;
                    break;
                } else {
                    return (j & 4521329252368384L) != 0 ? 35 : -1;
                }
            case 9:
                if ((j & 2251799813685248L) != 0) {
                    this.f678t = 69;
                    i2 = 9;
                    break;
                } else {
                    return (j & 42949672960L) != 0 ? 35 : -1;
                }
            case 10:
                if ((j & 2251799813685248L) == 0) {
                    return -1;
                }
                if (this.f677s != 10) {
                    this.f678t = 69;
                    this.f677s = 10;
                }
                return 35;
            case 11:
                return (j & 2251799813685248L) != 0 ? 35 : -1;
            default:
                return -1;
        }
        this.f677s = i2;
        return 35;
    }

    /* renamed from: a */
    private final int m670a(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return m677b(20, 0, 0, j);
        }
        try {
            this.f672n = this.f671m.readChar();
            return this.f672n != 'a' ? m677b(21, 0, 0, j3) : m678b(j3, 32);
        } catch (IOException unused) {
            m669a(21, 0, 0, j3);
            return 22;
        }
    }

    /* renamed from: a */
    private final int m671a(long j, long j2, long j3) {
        try {
            this.f672n = this.f671m.readChar();
            switch (this.f672n) {
                case ParserConstants.LONG /*38*/:
                    if ((j2 & 17179869184L) != 0) {
                        return m667a(1, 98);
                    }
                    break;
                case ParserConstants.PRIVATE /*43*/:
                    if ((j2 & 68719476736L) != 0) {
                        return m667a(1, 100);
                    }
                    break;
                case ParserConstants.PUBLIC /*45*/:
                    if ((j2 & 137438953472L) != 0) {
                        return m667a(1, 101);
                    }
                    break;
                case ParserConstants.INTEGER_LITERAL /*60*/:
                    if ((j2 & 281474976710656L) != 0) {
                        this.f678t = 112;
                        this.f677s = 1;
                    }
                    return m673a(j, 0, j2, 0, j3, 1);
                case ParserConstants.DECIMAL_LITERAL /*61*/:
                    if ((j2 & 67108864) != 0) {
                        return m667a(1, 90);
                    }
                    if ((j2 & 134217728) != 0) {
                        return m667a(1, 91);
                    }
                    if ((j2 & 536870912) != 0) {
                        return m667a(1, 93);
                    }
                    if ((j2 & 2147483648L) != 0) {
                        return m667a(1, 95);
                    }
                    if ((j2 & 18014398509481984L) != 0) {
                        return m667a(1, 118);
                    }
                    if ((j2 & 36028797018963968L) != 0) {
                        return m667a(1, 119);
                    }
                    if ((j2 & 72057594037927936L) != 0) {
                        return m667a(1, 120);
                    }
                    if ((j2 & 144115188075855872L) != 0) {
                        return m667a(1, 121);
                    }
                    if ((j2 & 288230376151711744L) != 0) {
                        return m667a(1, 122);
                    }
                    if ((j2 & 1152921504606846976L) != 0) {
                        return m667a(1, 124);
                    }
                    if ((j2 & 4611686018427387904L) != 0) {
                        return m667a(1, 126);
                    }
                    if ((j2 & Long.MIN_VALUE) != 0) {
                        return m667a(1, 127);
                    }
                    break;
                case ParserConstants.HEX_LITERAL /*62*/:
                    if ((j2 & 1125899906842624L) != 0) {
                        this.f678t = 114;
                        this.f677s = 1;
                    }
                    return m673a(j, 0, j2, 4503599627370496L, j3, 20);
                case 'a':
                    return m673a(j, 4947869532160L, j2, 576460786663161856L, j3, 0);
                case 'b':
                    return m673a(j, 1024, j2, 43980465111040L, j3, 0);
                case 'e':
                    return m673a(j, 71468256854016L, j2, 0, j3, 0);
                case 'f':
                    if ((j & 4294967296L) != 0) {
                        return m668a(1, 32, 35);
                    }
                    break;
                case 'g':
                    return m673a(j, 0, j2, 1074266112, j3, 0);
                case 'h':
                    return m673a(j, 603623087556132864L, j2, 0, j3, 0);
                case 'i':
                    return m673a(j, 402653184, j2, 0, j3, 0);
                case 'l':
                    return m673a(j, 545267712, j2, 562950223953920L, j3, 2);
                case 'm':
                    return m673a(j, 25769803776L, j2, 0, j3, 0);
                case 'n':
                    return m673a(j, 240534945792L, j2, 0, j3, 0);
                case 'o':
                    if ((j & 2097152) != 0) {
                        this.f678t = 21;
                        this.f677s = 1;
                    }
                    return m673a(j, 432345842331682816L, j2, 2305843017803628544L, j3, 0);
                case 'r':
                    return m673a(j, 112616378963333120L, j2, 11258999068426240L, j3, 40);
                case 't':
                    return m673a(j, 844424930131968L, j2, 0, j3, 0);
                case 'u':
                    return m673a(j, 37383395344384L, j2, 0, j3, 0);
                case 'w':
                    return m673a(j, 1125899906842624L, j2, 0, j3, 0);
                case 'x':
                    return m673a(j, 33554432, j2, 0, j3, 0);
                case 'y':
                    return m673a(j, 2251799813701632L, j2, 0, j3, 0);
                case '|':
                    if ((j2 & 4294967296L) != 0) {
                        return m667a(1, 96);
                    }
                    break;
            }
            return m677b(0, j, j2, j3);
        } catch (IOException unused) {
            m669a(0, j, j2, j3);
            return 1;
        }
    }

    /* renamed from: a */
    private final int m672a(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(11, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            return c != 'a' ? c != 'e' ? c != 's' ? m677b(12, 0, j5, j6) : m679b(j5, 0, j6, 2) : m679b(j5, 9007199254740992L, j6, 32) : m679b(j5, 0, j6, 8);
        } catch (IOException unused) {
            m669a(12, 0, j5, j6);
            return 13;
        }
    }

    /* renamed from: a */
    private final int m673a(long j, long j2, long j3, long j4, long j5, long j6) {
        int i;
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(0, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            switch (this.f672n) {
                case ParserConstants.DECIMAL_LITERAL /*61*/:
                    if ((j9 & 1) != 0) {
                        return m667a(2, 128);
                    }
                    if ((j9 & 4) != 0) {
                        return m667a(2, 130);
                    }
                    break;
                case ParserConstants.HEX_LITERAL /*62*/:
                    if ((j8 & 4503599627370496L) != 0) {
                        this.f678t = 116;
                        this.f677s = 2;
                    }
                    return m680b(j7, 0, j8, 0, j9, 16);
                case 'a':
                    return m680b(j7, 4785074604220416L, j8, 0, j9, 0);
                case 'b':
                    return m680b(j7, 35184372088832L, j8, 0, j9, 0);
                case 'c':
                    return m680b(j7, 4398046511104L, j8, 0, j9, 0);
                case 'e':
                    return m680b(j7, 4096, j8, 562949953421312L, j9, 2);
                case 'f':
                    return m680b(j7, 1048576, j8, 0, j9, 0);
                case 'i':
                    return m680b(j7, 721710636379144192L, j8, 11302979533537280L, j9, 40);
                case 'l':
                    return m680b(j7, 288232575242076160L, j8, 0, j9, 0);
                case 'n':
                    return m680b(j7, 2252075095031808L, j8, 576460786663161856L, j9, 0);
                case 'o':
                    return m680b(j7, 158330211272704L, j8, 0, j9, 0);
                case 'p':
                    return m680b(j7, 25769803776L, j8, 0, j9, 0);
                case 'r':
                    if ((j7 & 1073741824) != 0) {
                        return m668a(2, 30, 35);
                    }
                    if ((j8 & 8589934592L) != 0) {
                        this.f678t = 97;
                        this.f677s = 2;
                    }
                    return m680b(j7, 27584547717644288L, j8, 2305843009213693952L, j9, 0);
                case 's':
                    return m680b(j7, 34368160768L, j8, 0, j9, 0);
                case 't':
                    if ((j7 & 68719476736L) != 0) {
                        i = 36;
                    } else if ((j8 & 524288) != 0) {
                        i = 83;
                    } else {
                        if ((j8 & 2097152) != 0) {
                            i = 85;
                        }
                        return m680b(j7, 71058120065024L, j8, 1342177280, j9, 0);
                    }
                    this.f678t = i;
                    this.f677s = 2;
                    return m680b(j7, 71058120065024L, j8, 1342177280, j9, 0);
                case 'u':
                    return m680b(j7, 36028797039935488L, j8, 0, j9, 0);
                case 'w':
                    if ((j7 & 1099511627776L) != 0) {
                        return m668a(2, 40, 35);
                    }
                    break;
                case 'y':
                    if ((j7 & 72057594037927936L) != 0) {
                        return m668a(2, 56, 35);
                    }
                    break;
            }
            return m677b(1, j7, j8, j9);
        } catch (IOException unused) {
            m669a(1, j7, j8, j9);
            return 2;
        }
    }

    /* renamed from: a */
    private final void m674a(int i) {
        if (this.f679u[i] != this.f676r) {
            int[] iArr = this.f680v;
            int i2 = this.f675q;
            this.f675q = i2 + 1;
            iArr[i2] = i;
            this.f679u[i] = this.f676r;
        }
    }

    /* renamed from: a */
    private static final boolean m675a(int i, int i2, int i3, long j, long j2) {
        boolean z = false;
        if (i != 0) {
            return false;
        }
        if ((f659a[i3] & j2) != 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private final int m676b() {
        char c = this.f672n;
        switch (c) {
            case 9:
                return m668a(0, 2, 0);
            case 10:
                return m668a(0, 5, 0);
            default:
                switch (c) {
                    case 12:
                        return m668a(0, 4, 0);
                    case 13:
                        return m668a(0, 3, 0);
                    default:
                        switch (c) {
                            case ' ':
                                return m668a(0, 1, 0);
                            case '!':
                                this.f678t = 86;
                                return m671a(0, 2147483648L, 0);
                            default:
                                switch (c) {
                                    case '%':
                                        this.f678t = 111;
                                        return m671a(0, Long.MIN_VALUE, 0);
                                    case ParserConstants.LONG /*38*/:
                                        this.f678t = 106;
                                        return m671a(0, 288230393331580928L, 0);
                                    default:
                                        switch (c) {
                                            case ParserConstants.NEW /*40*/:
                                                return m667a(0, 72);
                                            case ParserConstants.NULL /*41*/:
                                                return m667a(0, 73);
                                            case ParserConstants.PACKAGE /*42*/:
                                                this.f678t = 104;
                                                return m671a(0, 72057594037927936L, 0);
                                            case ParserConstants.PRIVATE /*43*/:
                                                this.f678t = 102;
                                                return m671a(0, 18014467228958720L, 0);
                                            case ParserConstants.PROTECTED /*44*/:
                                                return m667a(0, 79);
                                            case ParserConstants.PUBLIC /*45*/:
                                                this.f678t = 103;
                                                return m671a(0, 36028934457917440L, 0);
                                            case '.':
                                                return m668a(0, 80, 11);
                                            case '/':
                                                this.f678t = 105;
                                                return m671a(0, 144115188075855872L, 0);
                                            default:
                                                switch (c) {
                                                    case ':':
                                                        return m667a(0, 89);
                                                    case ParserConstants.WHILE /*59*/:
                                                        return m667a(0, 78);
                                                    case ParserConstants.INTEGER_LITERAL /*60*/:
                                                        this.f678t = 84;
                                                        return m671a(0, 281475110928384L, 1);
                                                    case ParserConstants.DECIMAL_LITERAL /*61*/:
                                                        this.f678t = 81;
                                                        return m671a(0, 67108864, 0);
                                                    case ParserConstants.HEX_LITERAL /*62*/:
                                                        this.f678t = 82;
                                                        return m671a(0, 5629500071084032L, 20);
                                                    case ParserConstants.OCTAL_LITERAL /*63*/:
                                                        return m667a(0, 88);
                                                    case '@':
                                                        return m671a(0, 2894169735298547712L, 42);
                                                    default:
                                                        switch (c) {
                                                            case ']':
                                                                return m667a(0, 77);
                                                            case '^':
                                                                this.f678t = 110;
                                                                return m671a(0, 4611686018427387904L, 0);
                                                            default:
                                                                switch (c) {
                                                                    case 'a':
                                                                        return m671a(1024, 0, 0);
                                                                    case 'b':
                                                                        return m671a(22528, 0, 0);
                                                                    case 'c':
                                                                        return m671a(1024000, 0, 0);
                                                                    case 'd':
                                                                        return m671a(7340032, 0, 0);
                                                                    case 'e':
                                                                        return m671a(58720256, 0, 0);
                                                                    case 'f':
                                                                        return m671a(2080374784, 0, 0);
                                                                    case 'g':
                                                                        return m671a(2147483648L, 0, 0);
                                                                    default:
                                                                        switch (c) {
                                                                            case 'r':
                                                                                return m671a(70368744177664L, 0, 0);
                                                                            case 's':
                                                                                return m671a(4362862139015168L, 0, 0);
                                                                            case 't':
                                                                                return m671a(139611588448485376L, 0, 0);
                                                                            default:
                                                                                switch (c) {
                                                                                    case 'v':
                                                                                        return m671a(432345564227567616L, 0, 0);
                                                                                    case 'w':
                                                                                        return m671a(576460752303423488L, 0, 0);
                                                                                    default:
                                                                                        switch (c) {
                                                                                            case '{':
                                                                                                return m667a(0, 74);
                                                                                            case '|':
                                                                                                this.f678t = 108;
                                                                                                return m671a(0, 1152921508901814272L, 0);
                                                                                            case '}':
                                                                                                return m667a(0, 75);
                                                                                            case '~':
                                                                                                return m667a(0, 87);
                                                                                            default:
                                                                                                switch (c) {
                                                                                                    case '[':
                                                                                                        return m667a(0, 76);
                                                                                                    case 'i':
                                                                                                        return m671a(270582939648L, 0, 0);
                                                                                                    case 'l':
                                                                                                        return m671a(274877906944L, 0, 0);
                                                                                                    case 'n':
                                                                                                        return m671a(3848290697216L, 0, 0);
                                                                                                    case 'p':
                                                                                                        return m671a(65970697666560L, 0, 0);
                                                                                                    default:
                                                                                                        return m693e(6, 0);
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    /* renamed from: b */
    private final int m677b(int i, long j, long j2, long j3) {
        return m693e(m669a(i, j, j2, j3), i + 1);
    }

    /* renamed from: b */
    private final int m678b(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return m677b(21, 0, 0, j);
        }
        try {
            this.f672n = this.f671m.readChar();
            return this.f672n != 's' ? m677b(22, 0, 0, j3) : m683c(j3, 32);
        } catch (IOException unused) {
            m669a(22, 0, 0, j3);
            return 23;
        }
    }

    /* renamed from: b */
    private final int m679b(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(12, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            return c != 'd' ? c != 's' ? m677b(13, 0, j5, j6) : m684c(j5, 0, j6, 10) : m684c(j5, 9007199254740992L, j6, 32);
        } catch (IOException unused) {
            m669a(13, 0, j5, j6);
            return 14;
        }
    }

    /* renamed from: b */
    private final int m680b(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(1, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            if (c != '=') {
                if (c == '_') {
                    return m685c(j7, 0, j8, 2305843009213693952L, j9, 0);
                }
                if (c == 'i') {
                    return m685c(j7, 563499709235200L, j8, 0, j9, 0);
                }
                switch (c) {
                    case 'a':
                        return m685c(j7, 288230377092288512L, j8, 0, j9, 0);
                    case 'b':
                        return m685c(j7, 4194304, j8, 0, j9, 0);
                    case 'c':
                        return m685c(j7, 2251799813750784L, j8, 0, j9, 0);
                    case 'd':
                        if ((j7 & 144115188075855872L) != 0) {
                            return m668a(3, 57, 35);
                        }
                        if ((j8 & 34359738368L) != 0) {
                            this.f678t = 99;
                            this.f677s = 3;
                        }
                        return m685c(j7, 0, j8, 576460752303423488L, j9, 0);
                    case 'e':
                        return (j7 & 16384) != 0 ? m668a(3, 14, 35) : (j7 & 32768) != 0 ? m668a(3, 15, 35) : (j7 & 8388608) != 0 ? m668a(3, 23, 35) : (j7 & 36028797018963968L) != 0 ? m668a(3, 55, 35) : m685c(j7, 137472507904L, j8, 1342177280, j9, 0);
                    case 'f':
                        return m685c(j7, 0, j8, 562949953421312L, j9, 2);
                    case 'g':
                        return (j7 & 274877906944L) != 0 ? m668a(3, 38, 35) : m685c(j7, 0, j8, 11258999068426240L, j9, 40);
                    default:
                        switch (c) {
                            case 'k':
                                return m685c(j7, 4398046511104L, j8, 0, j9, 0);
                            case 'l':
                                return (j7 & 2199023255552L) != 0 ? m668a(3, 41, 35) : m685c(j7, 576495945265448960L, j8, 0, j9, 0);
                            case 'm':
                                if ((j7 & 16777216) != 0) {
                                    return m668a(3, 24, 35);
                                }
                                break;
                            case 'n':
                                return m685c(j7, 4503599627370496L, j8, 0, j9, 0);
                            case 'o':
                                return (j7 & 2147483648L) != 0 ? m668a(3, 31, 35) : m685c(j7, 27021614944092160L, j8, 0, j9, 0);
                            default:
                                switch (c) {
                                    case 'r':
                                        return (j7 & 131072) != 0 ? m668a(3, 17, 35) : m685c(j7, 140737488355328L, j8, 0, j9, 0);
                                    case 's':
                                        return m685c(j7, 67379200, j8, 0, j9, 0);
                                    case 't':
                                        return m685c(j7, 1425001429861376L, j8, 43980465111040L, j9, 0);
                                    case 'u':
                                        return m685c(j7, 70368744177664L, j8, 0, j9, 0);
                                    case 'v':
                                        return m685c(j7, 8796093022208L, j8, 0, j9, 0);
                                }
                        }
                }
            } else if ((j9 & 16) != 0) {
                return m667a(3, 132);
            }
            return m677b(2, j7, j8, j9);
        } catch (IOException unused) {
            m669a(2, j7, j8, j9);
            return 3;
        }
    }

    /* renamed from: b */
    private final void m681b(int i, int i2) {
        while (true) {
            int[] iArr = this.f680v;
            int i3 = this.f675q;
            this.f675q = i3 + 1;
            iArr[i3] = f667i[i];
            int i4 = i + 1;
            if (i != i2) {
                i = i4;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private static final boolean m682b(int i, int i2, int i3, long j, long j2) {
        boolean z = false;
        if (i != 0) {
            return (f660b[i2] & j) != 0;
        }
        if ((f659a[i3] & j2) != 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    private final int m683c(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return m677b(22, 0, 0, j);
        }
        try {
            this.f672n = this.f671m.readChar();
            return this.f672n != 's' ? m677b(23, 0, 0, j3) : m689d(j3, 32);
        } catch (IOException unused) {
            m669a(23, 0, 0, j3);
            return 24;
        }
    }

    /* renamed from: c */
    private final int m684c(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(13, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            return c != '_' ? c != 'i' ? c != 's' ? m677b(14, 0, j5, j6) : m690d(j5, 0, j6, 8) : m690d(j5, 0, j6, 2) : m690d(j5, 9007199254740992L, j6, 32);
        } catch (IOException unused) {
            m669a(14, 0, j5, j6);
            return 15;
        }
    }

    /* renamed from: c */
    private final int m685c(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(2, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            switch (this.f672n) {
                case '_':
                    return m691d(j7, 0, j8, 576460752303423488L, j9, 0);
                case 'a':
                    return m691d(j7, 13228499271680L, j8, 2305843009213693952L, j9, 0);
                case 'c':
                    return m691d(j7, 1688849860263936L, j8, 0, j9, 0);
                case 'e':
                    return (j7 & 67108864) != 0 ? m668a(4, 26, 35) : (j7 & 576460752303423488L) != 0 ? m668a(4, 59, 35) : m691d(j7, 17600775981056L, j8, 0, j9, 0);
                case 'h':
                    return (j7 & 65536) != 0 ? m668a(4, 16, 35) : m691d(j7, 2251799813685248L, j8, 11258999068426240L, j9, 40);
                case 'i':
                    return m691d(j7, 316659349323776L, j8, 0, j9, 0);
                case 'k':
                    if ((j7 & 4096) != 0) {
                        return m668a(4, 12, 35);
                    }
                    break;
                case 'l':
                    if ((j7 & 134217728) != 0) {
                        this.f678t = 27;
                        this.f677s = 4;
                    }
                    return m691d(j7, 272629760, j8, 0, j9, 0);
                case 'n':
                    return m691d(j7, 33554432, j8, 0, j9, 0);
                case 'q':
                    if ((j8 & 268435456) != 0) {
                        return m667a(4, 92);
                    }
                    if ((j8 & 1073741824) != 0) {
                        return m667a(4, 94);
                    }
                    break;
                case 'r':
                    return m691d(j7, 70523363001344L, j8, 0, j9, 0);
                case 's':
                    return (j7 & 8192) != 0 ? m668a(4, 13, 35) : m691d(j7, 4503599627370496L, j8, 0, j9, 0);
                case 't':
                    return (j7 & 262144) != 0 ? m668a(4, 18, 35) : (j7 & 536870912) != 0 ? m668a(4, 29, 35) : (j7 & 140737488355328L) != 0 ? m668a(4, 47, 35) : m691d(j7, 288230376151711744L, j8, 562949953421312L, j9, 2);
                case 'u':
                    return m691d(j7, 1048576, j8, 0, j9, 0);
                case 'v':
                    return m691d(j7, 549755813888L, j8, 0, j9, 0);
                case 'w':
                    if ((j7 & 9007199254740992L) != 0) {
                        this.f678t = 53;
                        this.f677s = 4;
                    }
                    return m691d(j7, 18014398509481984L, j8, 43980465111040L, j9, 0);
            }
            return m677b(3, j7, j8, j9);
        } catch (IOException unused) {
            m669a(3, j7, j8, j9);
            return 4;
        }
    }

    /* renamed from: c */
    private final void m686c() {
        this.f676r = -2147483647;
        int i = 74;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                this.f679u[i2] = Integer.MIN_VALUE;
                i = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private final void m687c(int i, int i2) {
        m674a(i);
        m674a(i2);
    }

    /* renamed from: c */
    private static final boolean m688c(int i, int i2, int i3, long j, long j2) {
        boolean z = false;
        if (i == 0) {
            if ((f662d[i3] & j2) != 0) {
                z = true;
            }
            return z;
        } else if (i == 51) {
            if ((f665g[i3] & j2) != 0) {
                z = true;
            }
            return z;
        } else if (i != 61) {
            switch (i) {
                case 48:
                    if ((f663e[i3] & j2) != 0) {
                        z = true;
                    }
                    return z;
                case 49:
                    if ((f664f[i3] & j2) != 0) {
                        z = true;
                    }
                    return z;
                default:
                    return (f661c[i2] & j) != 0;
            }
        } else {
            if ((f666h[i3] & j2) != 0) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: d */
    private final int m689d(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return m677b(23, 0, 0, j);
        }
        try {
            this.f672n = this.f671m.readChar();
            return this.f672n != 'i' ? m677b(24, 0, 0, j3) : m694e(j3, 32);
        } catch (IOException unused) {
            m669a(24, 0, 0, j3);
            return 25;
        }
    }

    /* renamed from: d */
    private final int m690d(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(14, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            return c != 'g' ? c != 'i' ? c != 's' ? m677b(15, 0, j5, j6) : m695e(j5, 9007199254740992L, j6, 32) : m695e(j5, 0, j6, 8) : m695e(j5, 0, j6, 2);
        } catch (IOException unused) {
            m669a(15, 0, j5, j6);
            return 16;
        }
    }

    /* renamed from: d */
    private final int m691d(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(3, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            switch (this.f672n) {
                case '_':
                    return m696e(j7, 0, j8, 562949953421312L, j9, 2);
                case 'a':
                    return m696e(j7, 3072, j8, 576460752303423488L, j9, 0);
                case 'c':
                    return (j7 & 35184372088832L) != 0 ? m668a(5, 45, 35) : (j7 & 281474976710656L) != 0 ? m668a(5, 48, 35) : m696e(j7, 17592186044416L, j8, 0, j9, 0);
                case 'd':
                    return m696e(j7, 33554432, j8, 0, j9, 0);
                case 'e':
                    if ((j7 & 4194304) != 0) {
                        return m668a(5, 22, 35);
                    }
                    if ((j7 & 549755813888L) != 0) {
                        return m668a(5, 39, 35);
                    }
                    break;
                case 'f':
                    return m696e(j7, 137438953472L, j8, 0, j9, 0);
                case 'g':
                    return m696e(j7, 4398046511104L, j8, 0, j9, 0);
                case 'h':
                    if ((j7 & 1125899906842624L) != 0) {
                        return m668a(5, 50, 35);
                    }
                    break;
                case 'i':
                    return m696e(j7, 292733975779082240L, j8, 43980465111040L, j9, 0);
                case 'l':
                    return m696e(j7, 269484032, j8, 0, j9, 0);
                case 'm':
                    return m696e(j7, 8589934592L, j8, 0, j9, 0);
                case 'n':
                    return (j7 & 70368744177664L) != 0 ? m668a(5, 46, 35) : m696e(j7, 34360262656L, j8, 0, j9, 0);
                case 'r':
                    return m696e(j7, 2251799813685248L, j8, 0, j9, 0);
                case 's':
                    return (j7 & 18014398509481984L) != 0 ? m668a(5, 54, 35) : m696e(j7, 0, j8, 2305843009213693952L, j9, 0);
                case 't':
                    return (j7 & 17179869184L) != 0 ? m668a(5, 34, 35) : m696e(j7, 571746046443520L, j8, 11258999068426240L, j9, 40);
            }
            return m677b(4, j7, j8, j9);
        } catch (IOException unused) {
            m669a(4, j7, j8, j9);
            return 5;
        }
    }

    /* renamed from: d */
    private final void m692d(int i, int i2) {
        while (true) {
            m674a(f667i[i]);
            int i3 = i + 1;
            if (i != i2) {
                i = i3;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01fb, code lost:
        if ((r20 & 43980465111040L) != 0) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0206, code lost:
        if (r4 > 64) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0211, code lost:
        if (r4 > 64) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0213, code lost:
        r4 = 64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0215, code lost:
        r2 = 31;
        r7 = 33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x022f, code lost:
        m692d(r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0241, code lost:
        if (r4 > 69) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x024c, code lost:
        if (r4 > 69) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x024e, code lost:
        r4 = 69;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0250, code lost:
        r2 = 35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0252, code lost:
        m674a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x027e, code lost:
        if ((r20 & 71776119061217280L) != 0) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02a8, code lost:
        if ((r20 & 566935683072L) != 0) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02aa, code lost:
        r2 = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02b8, code lost:
        if ((r20 & -17179878401L) != 0) goto L_0x02c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02c1, code lost:
        if (r0.f672n == '\"') goto L_0x02c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02c3, code lost:
        m692d(10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02f0, code lost:
        if ((r20 & 71776119061217280L) != 0) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x030b, code lost:
        if ((r20 & 566935683072L) != 0) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0327, code lost:
        if ((r20 & -549755823105L) != 0) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0329, code lost:
        m674a(18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        if ((r20 & -4398046511105L) != 0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0349, code lost:
        r7 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x034b, code lost:
        m687c(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x036d, code lost:
        m692d(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
        if ((r20 & -145135534866433L) != 0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0382, code lost:
        if (r4 > 60) goto L_0x0390;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x038e, code lost:
        if (r4 > 60) goto L_0x0390;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0390, code lost:
        r4 = 60;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0392, code lost:
        r2 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0394, code lost:
        m687c(r2, 9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
        r2 = 71;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x042a, code lost:
        m692d(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0448, code lost:
        if (r4 > 8) goto L_0x0458;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        if ((r20 & -4398046511105L) != 0) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0456, code lost:
        if (r4 > 8) goto L_0x0458;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0458, code lost:
        r4 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0464, code lost:
        if ((r20 & -9217) != 0) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x046c, code lost:
        if (r0.f672n == '!') goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x046e, code lost:
        r2 = 21;
        r7 = 23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x048a, code lost:
        if (r3 != r6) goto L_0x048f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        if (r0.f672n == '*') goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x04b4, code lost:
        m687c(r2, 69);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a1, code lost:
        r2 = 68;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x04c2, code lost:
        m687c(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a3, code lost:
        m687c(r2, 69);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x054c, code lost:
        m692d(10, 12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0573, code lost:
        m674a(18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x05b9, code lost:
        m674a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x05c1, code lost:
        m681b(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0617, code lost:
        m687c(r4, 69);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if ((r20 & -4398046511105L) != 0) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0648, code lost:
        m687c(r4, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x067f, code lost:
        if (r13 > 69) goto L_0x0681;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0681, code lost:
        r13 = 69;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0683, code lost:
        m674a(35);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c9, code lost:
        if ((r20 & -145135534866433L) != 0) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cb, code lost:
        r2 = 65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x06ed, code lost:
        if (r13 > 69) goto L_0x0681;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x072a, code lost:
        if (r3 != r6) goto L_0x0754;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x072c, code lost:
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:0x05c4, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:431:0x05c4, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x05c4, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:442:0x05c4, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:0x05c4, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:454:0x05c4, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e5, code lost:
        m687c(r2, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010a, code lost:
        if (r4 > 7) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0115, code lost:
        if (r4 > 7) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0117, code lost:
        r4 = 7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x041c  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m693e(int r36, int r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = 74
            r0.f675q = r1
            int[] r1 = r0.f680v
            r2 = 0
            r1[r2] = r36
            r1 = 1
            r3 = 2147483647(0x7fffffff, float:NaN)
            r5 = r37
            r3 = 1
            r4 = 2147483647(0x7fffffff, float:NaN)
            r6 = 0
        L_0x0016:
            int r7 = r0.f676r
            int r7 = r7 + r1
            r0.f676r = r7
            r8 = 2147483647(0x7fffffff, float:NaN)
            if (r7 != r8) goto L_0x0023
            r35.m686c()
        L_0x0023:
            char r7 = r0.f672n
            r9 = 10
            r10 = 63
            r11 = 9
            r12 = 18
            r14 = 7
            r15 = 64
            r1 = 60
            r8 = 69
            r18 = 0
            if (r7 >= r15) goto L_0x0494
            r20 = 1
            char r7 = r0.f672n
            long r20 = r20 << r7
        L_0x003e:
            int[] r7 = r0.f680v
            int r3 = r3 + -1
            r7 = r7[r3]
            r2 = 42
            r22 = 287948901175001088(0x3ff000000000000, double:1.988135013128901E-289)
            switch(r7) {
                case 0: goto L_0x0473;
                case 1: goto L_0x0467;
                case 2: goto L_0x045d;
                case 3: goto L_0x044b;
                case 4: goto L_0x0441;
                case 5: goto L_0x042e;
                case 6: goto L_0x039a;
                case 7: goto L_0x0385;
                case 8: goto L_0x037b;
                case 9: goto L_0x004b;
                case 10: goto L_0x0371;
                case 11: goto L_0x035e;
                case 12: goto L_0x004b;
                case 13: goto L_0x034f;
                case 14: goto L_0x033c;
                case 15: goto L_0x004b;
                case 16: goto L_0x032e;
                case 17: goto L_0x031e;
                case 18: goto L_0x030e;
                case 19: goto L_0x004b;
                case 20: goto L_0x0302;
                case 21: goto L_0x02f3;
                case 22: goto L_0x02ea;
                case 23: goto L_0x02d4;
                case 24: goto L_0x02c8;
                case 25: goto L_0x02bb;
                case 26: goto L_0x02ad;
                case 27: goto L_0x004b;
                case 28: goto L_0x029f;
                case 29: goto L_0x028f;
                case 30: goto L_0x0281;
                case 31: goto L_0x0278;
                case 32: goto L_0x0262;
                case 33: goto L_0x0257;
                case 34: goto L_0x0244;
                case 35: goto L_0x0234;
                case 36: goto L_0x0227;
                case 37: goto L_0x021b;
                case 38: goto L_0x0209;
                case 39: goto L_0x01fe;
                case 40: goto L_0x004b;
                case 41: goto L_0x01f2;
                case 42: goto L_0x01e4;
                case 43: goto L_0x01d8;
                case 44: goto L_0x004b;
                case 45: goto L_0x01c9;
                case 46: goto L_0x01b9;
                case 47: goto L_0x01ad;
                case 48: goto L_0x004b;
                case 49: goto L_0x019e;
                case 50: goto L_0x0194;
                case 51: goto L_0x0182;
                case 52: goto L_0x004b;
                case 53: goto L_0x0172;
                case 54: goto L_0x0160;
                case 55: goto L_0x0155;
                case 56: goto L_0x012e;
                case 57: goto L_0x011a;
                case 58: goto L_0x010d;
                case 59: goto L_0x0106;
                case 60: goto L_0x00f2;
                case 61: goto L_0x00ea;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00ce;
                case 64: goto L_0x00c0;
                case 65: goto L_0x00b4;
                case 66: goto L_0x00a8;
                case 67: goto L_0x009d;
                case 68: goto L_0x0091;
                case 69: goto L_0x0089;
                case 70: goto L_0x007b;
                case 71: goto L_0x006f;
                case 72: goto L_0x005f;
                case 73: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0397
        L_0x004d:
            char r7 = r0.f672n
            if (r7 != r2) goto L_0x0397
            int[] r2 = r0.f680v
            int r7 = r0.f675q
            int r13 = r7 + 1
            r0.f675q = r13
            r13 = 67
            r2[r7] = r13
            goto L_0x0397
        L_0x005f:
            char r2 = r0.f672n
            r7 = 47
            if (r2 != r7) goto L_0x0397
            r2 = 68
            if (r4 <= r2) goto L_0x0397
            r2 = 68
            r4 = 68
            goto L_0x0397
        L_0x006f:
            r22 = -4398046511105(0xfffffbffffffffff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            goto L_0x0086
        L_0x007b:
            r22 = -145135534866433(0xffff7bffffffffff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
        L_0x0086:
            r2 = 71
            goto L_0x00a3
        L_0x0089:
            char r7 = r0.f672n
            if (r7 != r2) goto L_0x0397
            r7 = 40
            goto L_0x022f
        L_0x0091:
            r22 = -4398046511105(0xfffffbffffffffff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            goto L_0x00a1
        L_0x009d:
            char r7 = r0.f672n
            if (r7 != r2) goto L_0x0397
        L_0x00a1:
            r2 = 68
        L_0x00a3:
            r0.m687c(r2, r8)
            goto L_0x0397
        L_0x00a8:
            char r2 = r0.f672n
            r7 = 47
            if (r2 != r7) goto L_0x0397
            if (r4 <= r11) goto L_0x0397
            r4 = 9
            goto L_0x0397
        L_0x00b4:
            r22 = -4398046511105(0xfffffbffffffffff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            goto L_0x00cb
        L_0x00c0:
            r22 = -145135534866433(0xffff7bffffffffff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
        L_0x00cb:
            r2 = 65
            goto L_0x00e5
        L_0x00ce:
            char r7 = r0.f672n
            if (r7 != r2) goto L_0x0397
            r2 = 37
            r7 = 39
            goto L_0x036d
        L_0x00d8:
            r22 = -4398046511105(0xfffffbffffffffff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 62
        L_0x00e5:
            r0.m687c(r2, r10)
            goto L_0x0397
        L_0x00ea:
            char r7 = r0.f672n
            if (r7 != r2) goto L_0x0397
            r2 = 62
            goto L_0x0252
        L_0x00f2:
            char r2 = r0.f672n
            r7 = 13
            if (r2 != r7) goto L_0x0397
            int[] r2 = r0.f680v
            int r7 = r0.f675q
            int r13 = r7 + 1
            r0.f675q = r13
            r13 = 59
            r2[r7] = r13
            goto L_0x0397
        L_0x0106:
            char r2 = r0.f672n
            if (r2 != r9) goto L_0x0397
            if (r4 <= r14) goto L_0x0397
            goto L_0x0117
        L_0x010d:
            r22 = 9216(0x2400, double:4.5533E-320)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            if (r4 <= r14) goto L_0x0397
        L_0x0117:
            r4 = 7
            goto L_0x0397
        L_0x011a:
            r22 = -9217(0xffffffffffffdbff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0124
            goto L_0x0397
        L_0x0124:
            if (r4 <= r14) goto L_0x0127
            r4 = 7
        L_0x0127:
            r2 = 20
            r0.m692d(r12, r2)
            goto L_0x0397
        L_0x012e:
            char r7 = r0.f672n
            if (r7 != r2) goto L_0x013f
            int[] r7 = r0.f680v
            int r13 = r0.f675q
            int r10 = r13 + 1
            r0.f675q = r10
            r10 = 67
            r7[r13] = r10
            goto L_0x014d
        L_0x013f:
            char r7 = r0.f672n
            r10 = 47
            if (r7 != r10) goto L_0x014d
            if (r4 <= r14) goto L_0x0148
            r4 = 7
        L_0x0148:
            r7 = 20
            r0.m692d(r12, r7)
        L_0x014d:
            char r7 = r0.f672n
            if (r7 != r2) goto L_0x0397
            r2 = 62
            goto L_0x0252
        L_0x0155:
            char r2 = r0.f672n
            r7 = 47
            if (r2 != r7) goto L_0x0397
            r0.m681b(r14, r11)
            goto L_0x0397
        L_0x0160:
            r22 = 71776119061217280(0xff000000000000, double:7.06327445644526E-304)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x016a
            goto L_0x0397
        L_0x016a:
            if (r4 <= r1) goto L_0x016e
            r4 = 60
        L_0x016e:
            r2 = 54
            goto L_0x0394
        L_0x0172:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x017a
            goto L_0x0397
        L_0x017a:
            if (r4 <= r1) goto L_0x017e
            r4 = 60
        L_0x017e:
            r2 = 53
            goto L_0x0394
        L_0x0182:
            char r2 = r0.f672n
            r7 = 48
            if (r2 == r7) goto L_0x018a
            goto L_0x0397
        L_0x018a:
            if (r4 <= r1) goto L_0x018e
            r4 = 60
        L_0x018e:
            r2 = 15
            r7 = 17
            goto L_0x036d
        L_0x0194:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 50
            goto L_0x0349
        L_0x019e:
            r22 = 43980465111040(0x280000000000, double:2.17292368994844E-310)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 50
            goto L_0x0252
        L_0x01ad:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 34
            r7 = 36
            goto L_0x036d
        L_0x01b9:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x01c1
            goto L_0x0397
        L_0x01c1:
            if (r4 <= r15) goto L_0x01c5
            r4 = 64
        L_0x01c5:
            r2 = 46
            goto L_0x0349
        L_0x01c9:
            r22 = 43980465111040(0x280000000000, double:2.17292368994844E-310)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 46
            goto L_0x0252
        L_0x01d8:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 43
            r7 = 44
            goto L_0x034b
        L_0x01e4:
            long r25 = r20 & r22
            int r7 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r7 != 0) goto L_0x01ec
            goto L_0x0397
        L_0x01ec:
            if (r4 <= r15) goto L_0x0349
            r4 = 64
            goto L_0x0349
        L_0x01f2:
            r22 = 43980465111040(0x280000000000, double:2.17292368994844E-310)
            long r25 = r20 & r22
            int r7 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r7 == 0) goto L_0x0397
            goto L_0x0252
        L_0x01fe:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0206
            goto L_0x0397
        L_0x0206:
            if (r4 <= r15) goto L_0x0215
            goto L_0x0213
        L_0x0209:
            char r2 = r0.f672n
            r7 = 46
            if (r2 == r7) goto L_0x0211
            goto L_0x0397
        L_0x0211:
            if (r4 <= r15) goto L_0x0215
        L_0x0213:
            r4 = 64
        L_0x0215:
            r2 = 31
            r7 = 33
            goto L_0x036d
        L_0x021b:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 37
            r7 = 38
            goto L_0x034b
        L_0x0227:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 6
            r7 = 0
        L_0x022f:
            r0.m692d(r7, r2)
            goto L_0x0397
        L_0x0234:
            r22 = 287948969894477824(0x3ff001000000000, double:1.9881506706942136E-289)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0241
            goto L_0x0397
        L_0x0241:
            if (r4 <= r8) goto L_0x0250
            goto L_0x024e
        L_0x0244:
            char r2 = r0.f672n
            r7 = 36
            if (r2 == r7) goto L_0x024c
            goto L_0x0397
        L_0x024c:
            if (r4 <= r8) goto L_0x0250
        L_0x024e:
            r4 = 69
        L_0x0250:
            r2 = 35
        L_0x0252:
            r0.m674a(r2)
            goto L_0x0397
        L_0x0257:
            r22 = 71776119061217280(0xff000000000000, double:7.06327445644526E-304)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 31
            goto L_0x0252
        L_0x0262:
            r22 = 4222124650659840(0xf000000000000, double:2.0860067423505013E-308)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            int[] r2 = r0.f680v
            int r7 = r0.f675q
            int r10 = r7 + 1
            r0.f675q = r10
            r10 = 33
            r2[r7] = r10
            goto L_0x0397
        L_0x0278:
            r22 = 71776119061217280(0xff000000000000, double:7.06327445644526E-304)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            goto L_0x02aa
        L_0x0281:
            r22 = 71776119061217280(0xff000000000000, double:7.06327445644526E-304)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 27
            r7 = 30
            goto L_0x036d
        L_0x028f:
            char r2 = r0.f672n
            r7 = 34
            if (r2 != r7) goto L_0x0397
            r2 = 67
            if (r4 <= r2) goto L_0x0397
            r2 = 67
            r4 = 67
            goto L_0x0397
        L_0x029f:
            r22 = 566935683072(0x8400000000, double:2.801034444074E-312)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
        L_0x02aa:
            r2 = 12
            goto L_0x02c3
        L_0x02ad:
            r2 = 12
            r22 = -17179878401(0xfffffffbffffdbff, double:NaN)
            long r25 = r20 & r22
            int r7 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r7 == 0) goto L_0x0397
            goto L_0x02c3
        L_0x02bb:
            r2 = 12
            char r7 = r0.f672n
            r10 = 34
            if (r7 != r10) goto L_0x0397
        L_0x02c3:
            r0.m692d(r9, r2)
            goto L_0x0397
        L_0x02c8:
            r22 = 71776119061217280(0xff000000000000, double:7.06327445644526E-304)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 22
            goto L_0x0252
        L_0x02d4:
            r22 = 4222124650659840(0xf000000000000, double:2.0860067423505013E-308)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            int[] r2 = r0.f680v
            int r7 = r0.f675q
            int r10 = r7 + 1
            r0.f675q = r10
            r10 = 24
            r2[r7] = r10
            goto L_0x0397
        L_0x02ea:
            r22 = 71776119061217280(0xff000000000000, double:7.06327445644526E-304)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            goto L_0x0329
        L_0x02f3:
            r22 = 71776119061217280(0xff000000000000, double:7.06327445644526E-304)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 22
            r0.m687c(r2, r12)
            goto L_0x0397
        L_0x0302:
            r22 = 566935683072(0x8400000000, double:2.801034444074E-312)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            goto L_0x0329
        L_0x030e:
            char r2 = r0.f672n
            r7 = 39
            if (r2 != r7) goto L_0x0397
            r2 = 66
            if (r4 <= r2) goto L_0x0397
            r2 = 66
            r4 = 66
            goto L_0x0397
        L_0x031e:
            r22 = -549755823105(0xffffff7fffffdbff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
        L_0x0329:
            r0.m674a(r12)
            goto L_0x0397
        L_0x032e:
            char r2 = r0.f672n
            r7 = 39
            if (r2 != r7) goto L_0x0397
            r2 = 13
            r7 = 14
            r0.m681b(r2, r7)
            goto L_0x0397
        L_0x033c:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0343
            goto L_0x0397
        L_0x0343:
            if (r4 <= r15) goto L_0x0347
            r4 = 64
        L_0x0347:
            r2 = 14
        L_0x0349:
            r7 = 15
        L_0x034b:
            r0.m687c(r2, r7)
            goto L_0x0397
        L_0x034f:
            r22 = 43980465111040(0x280000000000, double:2.17292368994844E-310)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0397
            r2 = 14
            goto L_0x0252
        L_0x035e:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0365
            goto L_0x0397
        L_0x0365:
            if (r4 <= r15) goto L_0x0369
            r4 = 64
        L_0x0369:
            r2 = 24
            r7 = 26
        L_0x036d:
            r0.m692d(r2, r7)
            goto L_0x0397
        L_0x0371:
            char r2 = r0.f672n
            r7 = 46
            if (r2 != r7) goto L_0x0397
            r2 = 11
            goto L_0x0252
        L_0x037b:
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0382
            goto L_0x0397
        L_0x0382:
            if (r4 <= r1) goto L_0x0392
            goto L_0x0390
        L_0x0385:
            r22 = 287667426198290432(0x3fe000000000000, double:1.9240016256086139E-289)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x038e
            goto L_0x0397
        L_0x038e:
            if (r4 <= r1) goto L_0x0392
        L_0x0390:
            r4 = 60
        L_0x0392:
            r2 = 8
        L_0x0394:
            r0.m687c(r2, r11)
        L_0x0397:
            r10 = 1
            goto L_0x048a
        L_0x039a:
            r25 = 8589934591(0x1ffffffff, double:4.2439915814E-314)
            long r27 = r20 & r25
            int r2 = (r27 > r18 ? 1 : (r27 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x03af
            r2 = 6
            if (r4 <= r2) goto L_0x03a9
            r4 = 6
        L_0x03a9:
            r7 = 0
            r0.m674a(r7)
        L_0x03ad:
            r10 = 1
            goto L_0x0409
        L_0x03af:
            r2 = 6
            r7 = 0
            long r24 = r20 & r22
            int r10 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r10 == 0) goto L_0x03bb
            r0.m692d(r7, r2)
            goto L_0x03ad
        L_0x03bb:
            char r2 = r0.f672n
            r7 = 47
            if (r2 != r7) goto L_0x03c5
            r0.m681b(r14, r11)
            goto L_0x03ad
        L_0x03c5:
            char r2 = r0.f672n
            r7 = 36
            if (r2 != r7) goto L_0x03d5
            if (r4 <= r8) goto L_0x03cf
            r4 = 69
        L_0x03cf:
            r2 = 35
        L_0x03d1:
            r0.m674a(r2)
            goto L_0x03ad
        L_0x03d5:
            char r2 = r0.f672n
            r7 = 34
            if (r2 != r7) goto L_0x03e1
            r2 = 12
            r0.m692d(r9, r2)
            goto L_0x03ad
        L_0x03e1:
            char r2 = r0.f672n
            r7 = 39
            if (r2 != r7) goto L_0x03ef
            r2 = 13
            r7 = 14
            r0.m681b(r2, r7)
            goto L_0x03ad
        L_0x03ef:
            char r2 = r0.f672n
            r7 = 46
            if (r2 != r7) goto L_0x03f8
            r2 = 11
            goto L_0x03d1
        L_0x03f8:
            char r2 = r0.f672n
            r7 = 35
            if (r2 != r7) goto L_0x03ad
            int[] r2 = r0.f680v
            int r7 = r0.f675q
            int r10 = r7 + 1
            r0.f675q = r10
            r10 = 1
            r2[r7] = r10
        L_0x0409:
            r22 = 287667426198290432(0x3fe000000000000, double:1.9240016256086139E-289)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x041c
            if (r4 <= r1) goto L_0x0415
            r4 = 60
        L_0x0415:
            r2 = 8
            r0.m687c(r2, r11)
            goto L_0x048a
        L_0x041c:
            char r2 = r0.f672n
            r7 = 48
            if (r2 != r7) goto L_0x048a
            if (r4 <= r1) goto L_0x0426
            r4 = 60
        L_0x0426:
            r2 = 15
            r7 = 17
        L_0x042a:
            r0.m692d(r2, r7)
            goto L_0x048a
        L_0x042e:
            r10 = 1
            char r2 = r0.f672n
            r7 = 13
            if (r2 != r7) goto L_0x048a
            int[] r2 = r0.f680v
            int r7 = r0.f675q
            int r13 = r7 + 1
            r0.f675q = r13
            r13 = 4
            r2[r7] = r13
            goto L_0x048a
        L_0x0441:
            r10 = 1
            char r2 = r0.f672n
            if (r2 != r9) goto L_0x048a
            r2 = 8
            if (r4 <= r2) goto L_0x048a
            goto L_0x0458
        L_0x044b:
            r10 = 1
            r22 = 9216(0x2400, double:4.5533E-320)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x048a
            r2 = 8
            if (r4 <= r2) goto L_0x048a
        L_0x0458:
            r2 = 8
            r4 = 8
            goto L_0x048a
        L_0x045d:
            r10 = 1
            r22 = -9217(0xffffffffffffdbff, double:NaN)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x048a
            goto L_0x046e
        L_0x0467:
            r10 = 1
            char r2 = r0.f672n
            r7 = 33
            if (r2 != r7) goto L_0x048a
        L_0x046e:
            r2 = 21
            r7 = 23
            goto L_0x042a
        L_0x0473:
            r10 = 1
            r22 = 8589934591(0x1ffffffff, double:4.2439915814E-314)
            long r25 = r20 & r22
            int r2 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0480
            goto L_0x048a
        L_0x0480:
            r2 = 6
            if (r4 <= r2) goto L_0x0486
            r2 = 0
            r4 = 6
            goto L_0x0487
        L_0x0486:
            r2 = 0
        L_0x0487:
            r0.m674a(r2)
        L_0x048a:
            if (r3 != r6) goto L_0x048f
        L_0x048c:
            r9 = 0
            goto L_0x072d
        L_0x048f:
            r2 = 0
            r10 = 63
            goto L_0x003e
        L_0x0494:
            r10 = 1
            char r2 = r0.f672n
            r7 = 128(0x80, float:1.794E-43)
            if (r2 >= r7) goto L_0x05c8
            r20 = 1
            char r2 = r0.f672n
            r7 = 63
            r2 = r2 & r7
            long r20 = r20 << r2
        L_0x04a4:
            int[] r2 = r0.f680v
            int r3 = r3 + -1
            r2 = r2[r3]
            switch(r2) {
                case 2: goto L_0x05bd;
                case 6: goto L_0x05a7;
                case 9: goto L_0x0597;
                case 12: goto L_0x0587;
                case 15: goto L_0x0577;
                case 17: goto L_0x056a;
                case 19: goto L_0x055f;
                case 20: goto L_0x0553;
                case 26: goto L_0x0543;
                case 27: goto L_0x0537;
                case 28: goto L_0x052b;
                case 35: goto L_0x05a7;
                case 40: goto L_0x051a;
                case 44: goto L_0x0509;
                case 48: goto L_0x04f8;
                case 52: goto L_0x04e9;
                case 53: goto L_0x04d1;
                case 57: goto L_0x04c7;
                case 62: goto L_0x04be;
                case 64: goto L_0x04b9;
                case 65: goto L_0x04b9;
                case 68: goto L_0x04b2;
                case 70: goto L_0x04af;
                case 71: goto L_0x04af;
                default: goto L_0x04ad;
            }
        L_0x04ad:
            goto L_0x05c4
        L_0x04af:
            r2 = 71
            goto L_0x04b4
        L_0x04b2:
            r2 = 68
        L_0x04b4:
            r0.m687c(r2, r8)
            goto L_0x05c4
        L_0x04b9:
            r2 = 65
            r7 = 63
            goto L_0x04c2
        L_0x04be:
            r7 = 63
            r2 = 62
        L_0x04c2:
            r0.m687c(r2, r7)
            goto L_0x05c4
        L_0x04c7:
            if (r4 <= r14) goto L_0x04ca
            r4 = 7
        L_0x04ca:
            r2 = 20
            r0.m681b(r12, r2)
            goto L_0x05c4
        L_0x04d1:
            r22 = 541165879422(0x7e0000007e, double:2.67371469724E-312)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x04de
            goto L_0x05c4
        L_0x04de:
            if (r4 <= r1) goto L_0x04e2
            r4 = 60
        L_0x04e2:
            r2 = 53
            r0.m687c(r2, r11)
            goto L_0x05c4
        L_0x04e9:
            r22 = 72057594054705152(0x100000001000000, double:7.291122046717944E-304)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            r2 = 53
            goto L_0x05b9
        L_0x04f8:
            r22 = 137438953504(0x2000000020, double:6.79038653267E-313)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            r2 = 55
            r7 = 56
            goto L_0x05c1
        L_0x0509:
            r22 = 137438953504(0x2000000020, double:6.79038653267E-313)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            r2 = 53
            r7 = 54
            goto L_0x05c1
        L_0x051a:
            r22 = 137438953504(0x2000000020, double:6.79038653267E-313)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            r2 = 51
            r7 = 52
            goto L_0x05c1
        L_0x052b:
            r22 = 5700160604602368(0x14404410000000, double:2.8162535305116993E-308)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            goto L_0x054c
        L_0x0537:
            char r2 = r0.f672n
            r7 = 92
            if (r2 != r7) goto L_0x05c4
            r2 = 48
            r7 = 50
            goto L_0x05c1
        L_0x0543:
            r22 = -268435457(0xffffffffefffffff, double:NaN)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
        L_0x054c:
            r2 = 12
            r0.m692d(r9, r2)
            goto L_0x05c4
        L_0x0553:
            r22 = 5700160604602368(0x14404410000000, double:2.8162535305116993E-308)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            goto L_0x0573
        L_0x055f:
            char r2 = r0.f672n
            r7 = 92
            if (r2 != r7) goto L_0x05c4
            r2 = 45
            r7 = 47
            goto L_0x05c1
        L_0x056a:
            r22 = -268435457(0xffffffffefffffff, double:NaN)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
        L_0x0573:
            r0.m674a(r12)
            goto L_0x05c4
        L_0x0577:
            r22 = 343597383760(0x5000000050, double:1.697596633167E-312)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            if (r4 <= r15) goto L_0x05c4
            r4 = 64
            goto L_0x05c4
        L_0x0587:
            r22 = 137438953504(0x2000000020, double:6.79038653267E-313)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            r2 = 43
            r7 = 44
            goto L_0x05c1
        L_0x0597:
            r22 = 17592186048512(0x100000001000, double:8.6916947618174E-311)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x05c4
            if (r4 <= r1) goto L_0x05c4
            r4 = 60
            goto L_0x05c4
        L_0x05a7:
            r22 = 576460745995190270(0x7fffffe87fffffe, double:3.7857643443544387E-270)
            long r24 = r20 & r22
            int r2 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x05b3
            goto L_0x05c4
        L_0x05b3:
            if (r4 <= r8) goto L_0x05b7
            r4 = 69
        L_0x05b7:
            r2 = 35
        L_0x05b9:
            r0.m674a(r2)
            goto L_0x05c4
        L_0x05bd:
            r2 = 21
            r7 = 23
        L_0x05c1:
            r0.m681b(r2, r7)
        L_0x05c4:
            if (r3 != r6) goto L_0x04a4
            goto L_0x048c
        L_0x05c8:
            char r1 = r0.f672n
            int r1 = r1 >> 8
            int r2 = r1 >> 6
            r15 = 1
            r7 = r1 & 63
            long r15 = r15 << r7
            char r7 = r0.f672n
            r7 = r7 & 255(0xff, float:3.57E-43)
            r11 = 6
            int r7 = r7 >> r11
            r18 = 1
            char r11 = r0.f672n
            r13 = 63
            r11 = r11 & r13
            long r18 = r18 << r11
            r13 = r4
        L_0x05e3:
            int[] r4 = r0.f680v
            int r3 = r3 + -1
            r4 = r4[r3]
            switch(r4) {
                case 0: goto L_0x070d;
                case 2: goto L_0x06f3;
                case 6: goto L_0x06c1;
                case 17: goto L_0x06a2;
                case 26: goto L_0x068a;
                case 34: goto L_0x066b;
                case 35: goto L_0x066b;
                case 57: goto L_0x064d;
                case 62: goto L_0x0634;
                case 64: goto L_0x061b;
                case 65: goto L_0x061b;
                case 68: goto L_0x0605;
                case 70: goto L_0x05f2;
                case 71: goto L_0x05f2;
                default: goto L_0x05ec;
            }
        L_0x05ec:
            r4 = 6
            r9 = 0
            r11 = 63
            goto L_0x072a
        L_0x05f2:
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m682b(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x05ec
            r4 = 71
            goto L_0x0617
        L_0x0605:
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m682b(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x05ec
            r4 = 68
        L_0x0617:
            r0.m687c(r4, r8)
            goto L_0x05ec
        L_0x061b:
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m682b(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x0630
            r4 = 65
            r11 = 63
            goto L_0x0648
        L_0x0630:
            r11 = 63
            goto L_0x06f0
        L_0x0634:
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m682b(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x06f0
            r4 = 62
        L_0x0648:
            r0.m687c(r4, r11)
            goto L_0x06f0
        L_0x064d:
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m682b(r27, r28, r29, r30, r32)
            if (r4 != 0) goto L_0x0661
            goto L_0x06f0
        L_0x0661:
            if (r13 <= r14) goto L_0x0664
            r13 = 7
        L_0x0664:
            r4 = 20
            r0.m681b(r12, r4)
            goto L_0x06f0
        L_0x066b:
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m688c(r27, r28, r29, r30, r32)
            if (r4 != 0) goto L_0x067f
            goto L_0x06f0
        L_0x067f:
            if (r13 <= r8) goto L_0x0683
        L_0x0681:
            r13 = 69
        L_0x0683:
            r4 = 35
            r0.m674a(r4)
            goto L_0x06f0
        L_0x068a:
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m682b(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x06f0
            r4 = 12
            r0.m681b(r9, r4)
            goto L_0x06f0
        L_0x06a2:
            r4 = 12
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r17 = m682b(r27, r28, r29, r30, r32)
            if (r17 == 0) goto L_0x06f0
            int[] r4 = r0.f680v
            int r9 = r0.f675q
            int r10 = r9 + 1
            r0.f675q = r10
            r4[r9] = r12
            goto L_0x06f0
        L_0x06c1:
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m675a(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x06dd
            r4 = 6
            if (r13 <= r4) goto L_0x06d9
            r4 = 0
            r13 = 6
            goto L_0x06da
        L_0x06d9:
            r4 = 0
        L_0x06da:
            r0.m674a(r4)
        L_0x06dd:
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m688c(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x06f0
            if (r13 <= r8) goto L_0x0683
            goto L_0x0681
        L_0x06f0:
            r4 = 6
            r9 = 0
            goto L_0x072a
        L_0x06f3:
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m682b(r27, r28, r29, r30, r32)
            if (r4 == 0) goto L_0x06f0
            r4 = 21
            r9 = 23
            r0.m681b(r4, r9)
            goto L_0x06f0
        L_0x070d:
            r11 = 63
            r27 = r1
            r28 = r2
            r29 = r7
            r30 = r15
            r32 = r18
            boolean r4 = m675a(r27, r28, r29, r30, r32)
            if (r4 != 0) goto L_0x0720
            goto L_0x06f0
        L_0x0720:
            r4 = 6
            if (r13 <= r4) goto L_0x0726
            r9 = 0
            r13 = 6
            goto L_0x0727
        L_0x0726:
            r9 = 0
        L_0x0727:
            r0.m674a(r9)
        L_0x072a:
            if (r3 != r6) goto L_0x0754
            r4 = r13
        L_0x072d:
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r1) goto L_0x073c
            r0.f678t = r4
            r0.f677s = r5
            r1 = 2147483647(0x7fffffff, float:NaN)
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x073c:
            int r5 = r5 + 1
            int r3 = r0.f675q
            r0.f675q = r6
            int r6 = 74 - r6
            if (r3 != r6) goto L_0x0747
            return r5
        L_0x0747:
            bsh.JavaCharStream r1 = r0.f671m     // Catch:{ IOException -> 0x0753 }
            char r1 = r1.readChar()     // Catch:{ IOException -> 0x0753 }
            r0.f672n = r1     // Catch:{ IOException -> 0x0753 }
            r1 = 1
            r2 = 0
            goto L_0x0016
        L_0x0753:
            return r5
        L_0x0754:
            r9 = 10
            r10 = 1
            goto L_0x05e3
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.ParserTokenManager.m693e(int, int):int");
    }

    /* renamed from: e */
    private final int m694e(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return m677b(24, 0, 0, j);
        }
        try {
            this.f672n = this.f671m.readChar();
            return this.f672n != 'g' ? m677b(25, 0, 0, j3) : m697f(j3, 32);
        } catch (IOException unused) {
            m669a(25, 0, 0, j3);
            return 26;
        }
    }

    /* renamed from: e */
    private final int m695e(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(15, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            if (c != 'n') {
                switch (c) {
                    case 'g':
                        return m698f(j5, 0, j6, 8);
                    case 'h':
                        return m698f(j5, 9007199254740992L, j6, 32);
                }
            } else if ((j6 & 2) != 0) {
                return m667a(17, 129);
            }
            return m677b(16, 0, j5, j6);
        } catch (IOException unused) {
            m669a(16, 0, j5, j6);
            return 17;
        }
    }

    /* renamed from: e */
    private final int m696e(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(4, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            switch (this.f672n) {
                case '_':
                    return m699f(j7, 0, j8, 11258999068426240L, j9, 40);
                case 'a':
                    return m699f(j7, 137438953472L, j8, 0, j9, 0);
                case 'c':
                    return m699f(j7, 34359739392L, j8, 0, j9, 0);
                case 'e':
                    return (j7 & 4398046511104L) != 0 ? m668a(6, 42, 35) : (j7 & 8796093022208L) != 0 ? m668a(6, 43, 35) : m699f(j7, 4503608217305088L, j8, 0, j9, 0);
                case 'f':
                    return m699f(j7, 562949953421312L, j8, 0, j9, 0);
                case 'l':
                    return m699f(j7, 288230376151711744L, j8, 0, j9, 0);
                case 'n':
                    if ((j7 & 2048) != 0) {
                        return m668a(6, 11, 35);
                    }
                    break;
                case 'o':
                    return m699f(j7, 2251799813685248L, j8, 0, j9, 0);
                case 's':
                    return (j7 & 33554432) != 0 ? m668a(6, 25, 35) : m699f(j7, 0, j8, 2882910691935649792L, j9, 2);
                case 't':
                    return (j7 & 1048576) != 0 ? m668a(6, 20, 35) : m699f(j7, 17592186044416L, j8, 0, j9, 0);
                case 'u':
                    return m699f(j7, 524288, j8, 0, j9, 0);
                case 'y':
                    if ((j7 & 268435456) != 0) {
                        return m668a(6, 28, 35);
                    }
                    break;
            }
            return m677b(5, j7, j8, j9);
        } catch (IOException unused) {
            m669a(5, j7, j8, j9);
            return 6;
        }
    }

    /* renamed from: f */
    private final int m697f(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return m677b(25, 0, 0, j);
        }
        try {
            this.f672n = this.f671m.readChar();
            return (this.f672n == 'n' && (j3 & 32) != 0) ? m667a(27, 133) : m677b(26, 0, 0, j3);
        } catch (IOException unused) {
            m669a(26, 0, 0, j3);
            return 27;
        }
    }

    /* renamed from: f */
    private final int m698f(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(16, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            return c != 'i' ? (c == 'n' && (j6 & 8) != 0) ? m667a(18, 131) : m677b(17, 0, j5, j6) : m700g(j5, 9007199254740992L, j6, 32);
        } catch (IOException unused) {
            m669a(17, 0, j5, j6);
            return 18;
        }
    }

    /* renamed from: f */
    private final int m699f(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(5, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            if (c == 'c') {
                return m701g(j7, 137438953472L, j8, 0, j9, 0);
            }
            if (c == 'e') {
                return (j7 & 524288) != 0 ? m668a(7, 19, 35) : (j7 & 288230376151711744L) != 0 ? m668a(7, 58, 35) : m701g(j7, 17626545782784L, j8, 43980465111040L, j9, 0);
            }
            if (c == 'n') {
                return m701g(j7, 6755408030990336L, j8, 0, j9, 0);
            }
            if (c != 'p') {
                switch (c) {
                    case 'h':
                        return m701g(j7, 0, j8, 562949953421312L, j9, 2);
                    case 'i':
                        return m701g(j7, 0, j8, 2305843009213693952L, j9, 0);
                    default:
                        switch (c) {
                            case 's':
                                return m701g(j7, 0, j8, 578712552117108736L, j9, 8);
                            case 't':
                                if ((j7 & 1024) != 0) {
                                    return m668a(7, 10, 35);
                                }
                                break;
                            case 'u':
                                return m701g(j7, 0, j8, 9007199254740992L, j9, 32);
                        }
                }
            } else if ((j7 & 562949953421312L) != 0) {
                return m668a(7, 49, 35);
            }
            return m677b(6, j7, j8, j9);
        } catch (IOException unused) {
            m669a(6, j7, j8, j9);
            return 7;
        }
    }

    /* renamed from: g */
    private final int m700g(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(17, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            return this.f672n != 'f' ? m677b(18, 0, j5, j6) : m702h(j5, 9007199254740992L, j6, 32);
        } catch (IOException unused) {
            m669a(18, 0, j5, j6);
            return 19;
        }
    }

    /* renamed from: g */
    private final int m701g(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(6, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            switch (this.f672n) {
                case '_':
                    return m703h(j7, 0, j8, 43980465111040L, j9, 0);
                case 'd':
                    if ((j7 & 17592186044416L) != 0) {
                        return m668a(8, 44, 35);
                    }
                    break;
                case 'e':
                    if ((j7 & 137438953472L) != 0) {
                        return m668a(8, 37, 35);
                    }
                    break;
                case 'g':
                    return m703h(j7, 0, j8, 2305843009213693952L, j9, 0);
                case 'h':
                    return m703h(j7, 0, j8, 2251799813685248L, j9, 8);
                case 'i':
                    return m703h(j7, 2251799813685248L, j8, 577023702256844800L, j9, 2);
                case 'n':
                    return m703h(j7, 0, j8, 9007199254740992L, j9, 32);
                case 'o':
                    return m703h(j7, 34359738368L, j8, 0, j9, 0);
                case 't':
                    return (j7 & 4503599627370496L) != 0 ? m668a(8, 52, 35) : m703h(j7, 8589934592L, j8, 0, j9, 0);
            }
            return m677b(7, j7, j8, j9);
        } catch (IOException unused) {
            m669a(7, j7, j8, j9);
            return 8;
        }
    }

    /* renamed from: h */
    private final int m702h(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return m677b(18, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            if (this.f672n != 't') {
                return m677b(19, 0, j5, j6);
            }
            if ((j5 & 9007199254740992L) != 0) {
                this.f678t = 117;
                this.f677s = 20;
            }
            return m704i(j5, 0, j6, 32);
        } catch (IOException unused) {
            m669a(19, 0, j5, j6);
            return 20;
        }
    }

    /* renamed from: h */
    private final int m703h(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(7, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            switch (this.f672n) {
                case 'a':
                    return m705i(j7, 0, j8, 8796093022208L, j9, 0);
                case 'f':
                    return (j7 & 34359738368L) != 0 ? m668a(9, 35, 35) : m705i(j7, 0, j8, 562949953421312L, j9, 2);
                case 'g':
                    return m705i(j7, 0, j8, 576460752303423488L, j9, 0);
                case 'i':
                    return m705i(j7, 0, j8, 2251799813685248L, j9, 8);
                case 'n':
                    if ((j8 & 2305843009213693952L) != 0) {
                        return m667a(9, 125);
                    }
                    break;
                case 'o':
                    return m705i(j7, 0, j8, 35184372088832L, j9, 0);
                case 's':
                    return (j7 & 8589934592L) != 0 ? m668a(9, 33, 35) : m705i(j7, 0, j8, 9007199254740992L, j9, 32);
                case 'z':
                    return m705i(j7, 2251799813685248L, j8, 0, j9, 0);
            }
            return m677b(8, j7, j8, j9);
        } catch (IOException unused) {
            m669a(8, j7, j8, j9);
            return 9;
        }
    }

    /* renamed from: i */
    private final int m704i(long j, long j2, long j3, long j4) {
        long j5 = j4 & j3;
        if (((j2 & j) | j5) == 0) {
            return m677b(19, 0, j, j3);
        }
        try {
            this.f672n = this.f671m.readChar();
            return this.f672n != '_' ? m677b(20, 0, 0, j5) : m670a(j5, 32);
        } catch (IOException unused) {
            m669a(20, 0, 0, j5);
            return 21;
        }
    }

    /* renamed from: i */
    private final int m705i(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(8, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            if (c == 'i') {
                return m706j(j7, 0, j8, 9007199254740992L, j9, 32);
            }
            if (c == 'n') {
                return (j8 & 576460752303423488L) != 0 ? m667a(10, 123) : m706j(j7, 0, j8, 8796093022208L, j9, 0);
            }
            if (c != 'r') {
                if (c != 't') {
                    switch (c) {
                        case 'e':
                            return m706j(j7, 2251799813685248L, j8, 0, j9, 0);
                        case 'f':
                            return m706j(j7, 0, j8, 2251799813685248L, j9, 8);
                    }
                } else {
                    if ((j8 & 562949953421312L) != 0) {
                        this.f678t = 113;
                        this.f677s = 10;
                    }
                    return m706j(j7, 0, j8, 0, j9, 2);
                }
            } else if ((j8 & 35184372088832L) != 0) {
                return m667a(10, 109);
            }
            return m677b(9, j7, j8, j9);
        } catch (IOException unused) {
            m669a(9, j7, j8, j9);
            return 10;
        }
    }

    /* renamed from: j */
    private final int m706j(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return m677b(9, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            if (c == '_') {
                return m707k(j7, 0, j8, 0, j9, 2);
            }
            if (c != 'd') {
                if (c == 'g') {
                    return m707k(j7, 0, j8, 9007199254740992L, j9, 32);
                }
                if (c == 't') {
                    if ((j8 & 2251799813685248L) != 0) {
                        this.f678t = 115;
                        this.f677s = 11;
                    }
                    return m707k(j7, 0, j8, 0, j9, 8);
                }
            } else if ((j7 & 2251799813685248L) != 0) {
                return m668a(11, 51, 35);
            } else {
                if ((j8 & 8796093022208L) != 0) {
                    return m667a(11, 107);
                }
            }
            return m677b(10, j7, j8, j9);
        } catch (IOException unused) {
            m669a(10, j7, j8, j9);
            return 11;
        }
    }

    /* renamed from: k */
    private final int m707k(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j4 & j3;
        long j8 = j6 & j5;
        if (((j2 & j) | j7 | j8) == 0) {
            return m677b(10, j, j3, j5);
        }
        try {
            this.f672n = this.f671m.readChar();
            char c = this.f672n;
            return c != '_' ? c != 'a' ? c != 'n' ? m677b(11, 0, j7, j8) : m672a(j7, 9007199254740992L, j8, 32) : m672a(j7, 0, j8, 2) : m672a(j7, 0, j8, 8);
        } catch (IOException unused) {
            m669a(11, 0, j7, j8);
            return 12;
        }
    }

    public void ReInit(JavaCharStream javaCharStream) {
        this.f675q = 0;
        this.f677s = 0;
        this.f673o = this.f674p;
        this.f671m = javaCharStream;
        m686c();
    }

    public void ReInit(JavaCharStream javaCharStream, int i) {
        ReInit(javaCharStream);
        SwitchTo(i);
    }

    public void SwitchTo(int i) {
        if (i >= 1 || i < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error: Ignoring invalid lexical state : ");
            stringBuffer.append(i);
            stringBuffer.append(". State unchanged.");
            throw new TokenMgrError(stringBuffer.toString(), 2);
        }
        this.f673o = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Token mo995a() {
        Token newToken = Token.newToken(this.f678t);
        newToken.kind = this.f678t;
        String str = jjstrLiteralImages[this.f678t];
        if (str == null) {
            str = this.f671m.GetImage();
        }
        newToken.image = str;
        newToken.beginLine = this.f671m.getBeginLine();
        newToken.beginColumn = this.f671m.getBeginColumn();
        newToken.endLine = this.f671m.getEndLine();
        newToken.endColumn = this.f671m.getEndColumn();
        return newToken;
    }

    public Token getNextToken() {
        int i;
        int i2;
        boolean z;
        int i3;
        String str = null;
        Token token = null;
        while (true) {
            try {
                this.f672n = this.f671m.BeginToken();
                this.f678t = Integer.MAX_VALUE;
                this.f677s = 0;
                int b = m676b();
                if (this.f678t != Integer.MAX_VALUE) {
                    if (this.f677s + 1 < b) {
                        this.f671m.backup((b - this.f677s) - 1);
                    }
                    if ((f668j[this.f678t >> 6] & (1 << (this.f678t & 63))) != 0) {
                        break;
                    } else if ((f670l[this.f678t >> 6] & (1 << (this.f678t & 63))) != 0) {
                        Token a = mo995a();
                        if (token != null) {
                            a.specialToken = token;
                            token.next = a;
                        }
                        token = a;
                    }
                } else {
                    int endLine = this.f671m.getEndLine();
                    int endColumn = this.f671m.getEndColumn();
                    try {
                        this.f671m.readChar();
                        this.f671m.backup(1);
                        i2 = endLine;
                        i = endColumn;
                        z = false;
                    } catch (IOException unused) {
                        str = b <= 1 ? BuildConfig.FLAVOR : this.f671m.GetImage();
                        if (this.f672n == 10 || this.f672n == 13) {
                            endLine++;
                            i3 = 0;
                        } else {
                            i3 = endColumn + 1;
                        }
                        i2 = endLine;
                        i = i3;
                        z = true;
                    }
                    if (!z) {
                        this.f671m.backup(1);
                        str = b <= 1 ? BuildConfig.FLAVOR : this.f671m.GetImage();
                    }
                    TokenMgrError tokenMgrError = new TokenMgrError(z, this.f673o, i2, i, str, this.f672n, 0);
                    throw tokenMgrError;
                }
            } catch (IOException unused2) {
                this.f678t = 0;
            }
        }
        Token a2 = mo995a();
        a2.specialToken = token;
        return a2;
    }

    public void setDebugStream(PrintStream printStream) {
        this.debugStream = printStream;
    }
}
