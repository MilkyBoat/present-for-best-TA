package com.p021b.p022a.p024b;

import android.graphics.Rect;
import com.androlua.LuaTokenTypes;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.b.a.b.k */
public class C0419k {

    /* renamed from: b */
    private static C0416h f3010b = C0418j.m2655g();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static ArrayList<Rect> f3011e = new ArrayList<>();

    /* renamed from: a */
    C0421a f3012a = null;

    /* renamed from: c */
    private C0414f f3013c;

    /* renamed from: d */
    private C0422b f3014d = null;

    /* renamed from: com.b.a.b.k$1 */
    static /* synthetic */ class C04201 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3015a = new int[LuaTokenTypes.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(88:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(90:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|90) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00da */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fe */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x010a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0116 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x013a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0146 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0152 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x015e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x016a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0176 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0182 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x018e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x019a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x01a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x01b2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x01be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x01ca */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x01d6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x01e2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x01ee */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x01fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0206 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.androlua.LuaTokenTypes[] r0 = com.androlua.LuaTokenTypes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3015a = r0
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.TRUE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.FALSE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.DO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.FUNCTION     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.NOT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.AND     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.OR     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.IF     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.THEN     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x007a }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.ELSEIF     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.ELSE     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.WHILE     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x009e }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.FOR     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.IN     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.RETURN     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.BREAK     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.LOCAL     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00da }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.REPEAT     // Catch:{ NoSuchFieldError -> 0x00da }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00da }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00da }
            L_0x00da:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00e6 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.UNTIL     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00f2 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.END     // Catch:{ NoSuchFieldError -> 0x00f2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f2 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f2 }
            L_0x00f2:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x00fe }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.NIL     // Catch:{ NoSuchFieldError -> 0x00fe }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fe }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fe }
            L_0x00fe:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x010a }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.SWITCH     // Catch:{ NoSuchFieldError -> 0x010a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010a }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010a }
            L_0x010a:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0116 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.CASE     // Catch:{ NoSuchFieldError -> 0x0116 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0116 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0116 }
            L_0x0116:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0122 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x012e }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.CONTINUE     // Catch:{ NoSuchFieldError -> 0x012e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012e }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012e }
            L_0x012e:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x013a }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.GOTO     // Catch:{ NoSuchFieldError -> 0x013a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x013a }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x013a }
            L_0x013a:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0146 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.LAMBDA     // Catch:{ NoSuchFieldError -> 0x0146 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0146 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0146 }
            L_0x0146:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0152 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.DEFER     // Catch:{ NoSuchFieldError -> 0x0152 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0152 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0152 }
            L_0x0152:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x015e }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.WHEN     // Catch:{ NoSuchFieldError -> 0x015e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015e }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015e }
            L_0x015e:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x016a }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.LCURLY     // Catch:{ NoSuchFieldError -> 0x016a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x016a }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x016a }
            L_0x016a:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0176 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.RCURLY     // Catch:{ NoSuchFieldError -> 0x0176 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0176 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0176 }
            L_0x0176:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0182 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.LPAREN     // Catch:{ NoSuchFieldError -> 0x0182 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0182 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0182 }
            L_0x0182:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x018e }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.RPAREN     // Catch:{ NoSuchFieldError -> 0x018e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018e }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x018e }
            L_0x018e:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x019a }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.LBRACK     // Catch:{ NoSuchFieldError -> 0x019a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x019a }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x019a }
            L_0x019a:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01a6 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.RBRACK     // Catch:{ NoSuchFieldError -> 0x01a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a6 }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01a6 }
            L_0x01a6:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01b2 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.COMMA     // Catch:{ NoSuchFieldError -> 0x01b2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b2 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01b2 }
            L_0x01b2:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01be }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.DOT     // Catch:{ NoSuchFieldError -> 0x01be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01be }
                r2 = 37
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01be }
            L_0x01be:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01ca }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.STRING     // Catch:{ NoSuchFieldError -> 0x01ca }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ca }
                r2 = 38
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01ca }
            L_0x01ca:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01d6 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.LONG_STRING     // Catch:{ NoSuchFieldError -> 0x01d6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d6 }
                r2 = 39
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01d6 }
            L_0x01d6:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01e2 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.NAME     // Catch:{ NoSuchFieldError -> 0x01e2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e2 }
                r2 = 40
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01e2 }
            L_0x01e2:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01ee }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.SHORT_COMMENT     // Catch:{ NoSuchFieldError -> 0x01ee }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ee }
                r2 = 41
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01ee }
            L_0x01ee:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x01fa }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.BLOCK_COMMENT     // Catch:{ NoSuchFieldError -> 0x01fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01fa }
                r2 = 42
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01fa }
            L_0x01fa:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0206 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.DOC_COMMENT     // Catch:{ NoSuchFieldError -> 0x0206 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0206 }
                r2 = 43
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0206 }
            L_0x0206:
                int[] r0 = f3015a     // Catch:{ NoSuchFieldError -> 0x0212 }
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.NUMBER     // Catch:{ NoSuchFieldError -> 0x0212 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0212 }
                r2 = 44
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0212 }
            L_0x0212:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0419k.C04201.<clinit>():void");
        }
    }

    /* renamed from: com.b.a.b.k$a */
    public interface C0421a {
        /* renamed from: a */
        void mo2887a(List<C0424m> list);
    }

    /* renamed from: com.b.a.b.k$b */
    private class C0422b extends Thread {

        /* renamed from: b */
        private final C0419k f3017b;

        /* renamed from: c */
        private final C0415g f3018c;

        /* renamed from: d */
        private boolean f3019d = false;

        /* renamed from: e */
        private int f3020e = 16;

        /* renamed from: f */
        private ArrayList<C0424m> f3021f;

        public C0422b(C0419k kVar) {
            this.f3017b = kVar;
            this.f3018c = new C0415g();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:102:0x029e, code lost:
            r4.add(r1);
            r10 = r20;
            r16 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x02b5, code lost:
            r10 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x02c3, code lost:
            if (r9 == com.androlua.LuaTokenTypes.WHITE_SPACE) goto L_0x02c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x02c5, code lost:
            r11 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x02c7, code lost:
            r11 = r22;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x009d, code lost:
            r4.add(r1);
            r21 = r3;
            r22 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a5, code lost:
            r4.add(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a8, code lost:
            r21 = r3;
            r22 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ac, code lost:
            r10 = r20;
         */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m2674d() {
            /*
                r23 = this;
                r1 = r23
                com.b.a.b.k r2 = com.p021b.p022a.p024b.C0419k.this
                com.b.a.b.f r2 = r2.mo3039c()
                int r3 = r2.mo2989f()
                java.util.ArrayList r4 = new java.util.ArrayList
                r5 = 8196(0x2004, float:1.1485E-41)
                r4.<init>(r5)
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>(r5)
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>(r5)
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>(r5)
                com.androlua.LuaLexer r5 = new com.androlua.LuaLexer
                r5.<init>(r2)
                com.b.a.b.h r2 = com.p021b.p022a.p024b.C0419k.m2664a()
                r2.mo3025e()
                java.lang.String r10 = ""
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d2 }
                r11.<init>()     // Catch:{ Exception -> 0x02d2 }
                r12 = -1
                r13 = r10
                r12 = r11
                r10 = 0
                r11 = 0
                r15 = 0
                r16 = 1
                r17 = 0
                r18 = -1
            L_0x0041:
                com.b.a.b.g r9 = r1.f3018c     // Catch:{ Exception -> 0x02d2 }
                boolean r9 = r9.mo3004c()     // Catch:{ Exception -> 0x02d2 }
                if (r9 != 0) goto L_0x02de
                com.androlua.LuaTokenTypes r9 = r5.advance()     // Catch:{ Exception -> 0x02d2 }
                if (r9 != 0) goto L_0x0051
                goto L_0x02de
            L_0x0051:
                int r14 = r5.yylength()     // Catch:{ Exception -> 0x02d2 }
                if (r10 == 0) goto L_0x007e
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.STRING     // Catch:{ Exception -> 0x02d2 }
                if (r11 != r1) goto L_0x007e
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.STRING     // Catch:{ Exception -> 0x02d2 }
                if (r9 == r1) goto L_0x007e
                java.lang.String r1 = r12.toString()     // Catch:{ Exception -> 0x02d2 }
                int r10 = r12.length()     // Catch:{ Exception -> 0x02d2 }
                r12 = 2
                if (r10 <= r12) goto L_0x0077
                int r10 = r1.length()     // Catch:{ Exception -> 0x02d2 }
                r12 = 1
                int r10 = r10 - r12
                java.lang.String r1 = r1.substring(r12, r10)     // Catch:{ Exception -> 0x02d2 }
                r2.mo3018c(r1)     // Catch:{ Exception -> 0x02d2 }
            L_0x0077:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02d2 }
                r1.<init>()     // Catch:{ Exception -> 0x02d2 }
                r12 = r1
                r10 = 0
            L_0x007e:
                int[] r1 = com.p021b.p022a.p024b.C0419k.C04201.f3015a     // Catch:{ Exception -> 0x02d2 }
                int r19 = r9.ordinal()     // Catch:{ Exception -> 0x02d2 }
                r1 = r1[r19]     // Catch:{ Exception -> 0x02d2 }
                r20 = r10
                r10 = 9999(0x270f, float:1.4012E-41)
                switch(r1) {
                    case 1: goto L_0x02a8;
                    case 2: goto L_0x02a8;
                    case 3: goto L_0x027d;
                    case 4: goto L_0x0259;
                    case 5: goto L_0x02a8;
                    case 6: goto L_0x02a8;
                    case 7: goto L_0x02a8;
                    case 8: goto L_0x0259;
                    case 9: goto L_0x02a8;
                    case 10: goto L_0x02a8;
                    case 11: goto L_0x02a8;
                    case 12: goto L_0x0230;
                    case 13: goto L_0x0230;
                    case 14: goto L_0x02a8;
                    case 15: goto L_0x02a8;
                    case 16: goto L_0x02a8;
                    case 17: goto L_0x02a8;
                    case 18: goto L_0x02a8;
                    case 19: goto L_0x02a8;
                    case 20: goto L_0x0200;
                    case 21: goto L_0x02a8;
                    case 22: goto L_0x0259;
                    case 23: goto L_0x02a8;
                    case 24: goto L_0x02a8;
                    case 25: goto L_0x02a8;
                    case 26: goto L_0x02a8;
                    case 27: goto L_0x02a8;
                    case 28: goto L_0x02a8;
                    case 29: goto L_0x02a8;
                    case 30: goto L_0x01dd;
                    case 31: goto L_0x01b1;
                    case 32: goto L_0x019f;
                    case 33: goto L_0x019f;
                    case 34: goto L_0x019f;
                    case 35: goto L_0x019f;
                    case 36: goto L_0x019f;
                    case 37: goto L_0x019f;
                    case 38: goto L_0x017e;
                    case 39: goto L_0x017e;
                    case 40: goto L_0x00b0;
                    case 41: goto L_0x00a7;
                    case 42: goto L_0x00a7;
                    case 43: goto L_0x00a7;
                    case 44: goto L_0x0097;
                    default: goto L_0x008d;
                }     // Catch:{ Exception -> 0x02d2 }
            L_0x008d:
                r21 = r3
                r22 = r11
                r3 = 1
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10 = 0
                goto L_0x02b9
            L_0x0097:
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10 = 4
                r1.<init>(r14, r10)     // Catch:{ Exception -> 0x02d2 }
            L_0x009d:
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
                r21 = r3
                r22 = r11
            L_0x00a4:
                r3 = 1
                goto L_0x02b5
            L_0x00a7:
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10 = 30
                r1.<init>(r14, r10)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x01a5
            L_0x00b0:
                if (r3 <= r10) goto L_0x00b9
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10 = 0
                r1.<init>(r14, r10)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x009d
            L_0x00b9:
                com.androlua.LuaTokenTypes r1 = com.androlua.LuaTokenTypes.NUMBER     // Catch:{ Exception -> 0x02d2 }
                if (r15 != r1) goto L_0x00d5
                int r1 = r4.size()     // Catch:{ Exception -> 0x02d2 }
                r10 = 1
                int r1 = r1 - r10
                java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x02d2 }
                com.b.a.b.m r1 = (com.p021b.p022a.p024b.C0424m) r1     // Catch:{ Exception -> 0x02d2 }
                r10 = 0
                r1.mo3050b(r10)     // Catch:{ Exception -> 0x02d2 }
                int r10 = r1.mo3047a()     // Catch:{ Exception -> 0x02d2 }
                int r10 = r10 + r14
                r1.mo3048a(r10)     // Catch:{ Exception -> 0x02d2 }
            L_0x00d5:
                java.lang.String r1 = r5.yytext()     // Catch:{ Exception -> 0x02d2 }
                com.androlua.LuaTokenTypes r10 = com.androlua.LuaTokenTypes.FUNCTION     // Catch:{ Exception -> 0x02d2 }
                if (r11 != r10) goto L_0x00eb
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r15 = 4
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                r4.add(r10)     // Catch:{ Exception -> 0x02d2 }
                r2.mo3018c(r1)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x0152
            L_0x00eb:
                boolean r10 = r2.mo3032g(r1)     // Catch:{ Exception -> 0x02d2 }
                if (r10 == 0) goto L_0x00fb
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r15 = 4
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
            L_0x00f7:
                r4.add(r10)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x0152
            L_0x00fb:
                com.androlua.LuaTokenTypes r10 = com.androlua.LuaTokenTypes.GOTO     // Catch:{ Exception -> 0x02d2 }
                if (r11 == r10) goto L_0x014b
                com.androlua.LuaTokenTypes r10 = com.androlua.LuaTokenTypes.AT     // Catch:{ Exception -> 0x02d2 }
                if (r11 != r10) goto L_0x0104
                goto L_0x014b
            L_0x0104:
                com.androlua.LuaTokenTypes r10 = com.androlua.LuaTokenTypes.MULT     // Catch:{ Exception -> 0x02d2 }
                if (r11 != r10) goto L_0x0115
                com.androlua.LuaTokenTypes r10 = com.androlua.LuaTokenTypes.LOCAL     // Catch:{ Exception -> 0x02d2 }
                r15 = r17
                if (r15 != r10) goto L_0x0115
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r15 = 2
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x00f7
            L_0x0115:
                boolean r10 = r2.mo3030f(r1)     // Catch:{ Exception -> 0x02d2 }
                r15 = 3
                if (r10 == 0) goto L_0x0122
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x00f7
            L_0x0122:
                com.androlua.LuaTokenTypes r10 = com.androlua.LuaTokenTypes.DOT     // Catch:{ Exception -> 0x02d2 }
                if (r11 != r10) goto L_0x0138
                boolean r10 = r2.mo3030f(r13)     // Catch:{ Exception -> 0x02d2 }
                if (r10 == 0) goto L_0x0138
                boolean r10 = r2.mo3011a(r13, r1)     // Catch:{ Exception -> 0x02d2 }
                if (r10 == 0) goto L_0x0138
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x00f7
            L_0x0138:
                boolean r10 = r2.mo3027e(r1)     // Catch:{ Exception -> 0x02d2 }
                if (r10 == 0) goto L_0x0144
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x00f7
            L_0x0144:
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r15 = 0
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x00f7
            L_0x014b:
                com.b.a.b.m r10 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r15 = 4
                r10.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x00f7
            L_0x0152:
                com.androlua.LuaTokenTypes r10 = com.androlua.LuaTokenTypes.ASSIGN     // Catch:{ Exception -> 0x02d2 }
                if (r11 != r10) goto L_0x016f
                java.lang.String r10 = "require"
                boolean r10 = r1.equals(r10)     // Catch:{ Exception -> 0x02d2 }
                if (r10 == 0) goto L_0x016f
                r2.mo3018c(r13)     // Catch:{ Exception -> 0x02d2 }
                if (r18 < 0) goto L_0x016f
                int r10 = r18 + -1
                java.lang.Object r10 = r4.get(r10)     // Catch:{ Exception -> 0x02d2 }
                com.b.a.b.m r10 = (com.p021b.p022a.p024b.C0424m) r10     // Catch:{ Exception -> 0x02d2 }
                r13 = 4
                r10.mo3050b(r13)     // Catch:{ Exception -> 0x02d2 }
            L_0x016f:
                int r10 = r4.size()     // Catch:{ Exception -> 0x02d2 }
                r13 = r1
                r21 = r3
                r18 = r10
                r22 = r11
                r10 = r20
                r1 = 0
                goto L_0x01ae
            L_0x017e:
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r15 = 50
                r1.<init>(r14, r15)     // Catch:{ Exception -> 0x02d2 }
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
                if (r3 <= r10) goto L_0x018b
                goto L_0x01a8
            L_0x018b:
                java.lang.String r10 = "require"
                boolean r10 = r13.equals(r10)     // Catch:{ Exception -> 0x02d2 }
                if (r10 == 0) goto L_0x0195
                r20 = 1
            L_0x0195:
                if (r20 == 0) goto L_0x01a8
                java.lang.String r10 = r5.yytext()     // Catch:{ Exception -> 0x02d2 }
                r12.append(r10)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x01a8
            L_0x019f:
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10 = 2
                r1.<init>(r14, r10)     // Catch:{ Exception -> 0x02d2 }
            L_0x01a5:
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
            L_0x01a8:
                r21 = r3
                r22 = r11
            L_0x01ac:
                r10 = r20
            L_0x01ae:
                r3 = 1
                goto L_0x02c1
            L_0x01b1:
                int r1 = r8.size()     // Catch:{ Exception -> 0x02d2 }
                if (r1 <= 0) goto L_0x01d6
                int r1 = r1 + -1
                java.lang.Object r1 = r8.remove(r1)     // Catch:{ Exception -> 0x02d2 }
                android.graphics.Rect r1 = (android.graphics.Rect) r1     // Catch:{ Exception -> 0x02d2 }
                int r10 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                r1.bottom = r10     // Catch:{ Exception -> 0x02d2 }
                int r10 = r5.yychar()     // Catch:{ Exception -> 0x02d2 }
                r1.right = r10     // Catch:{ Exception -> 0x02d2 }
                int r10 = r1.bottom     // Catch:{ Exception -> 0x02d2 }
                int r15 = r1.top     // Catch:{ Exception -> 0x02d2 }
                int r10 = r10 - r15
                r15 = 1
                if (r10 <= r15) goto L_0x01d6
                r6.add(r1)     // Catch:{ Exception -> 0x02d2 }
            L_0x01d6:
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r10 = 2
                r1.<init>(r14, r10)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x01a5
            L_0x01dd:
                android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ Exception -> 0x02d2 }
                int r10 = r5.yychar()     // Catch:{ Exception -> 0x02d2 }
                int r15 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                r21 = r3
                int r3 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                r22 = r11
                r11 = 0
                r1.<init>(r10, r15, r11, r3)     // Catch:{ Exception -> 0x02d2 }
                r8.add(r1)     // Catch:{ Exception -> 0x02d2 }
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r3 = 2
                r1.<init>(r14, r3)     // Catch:{ Exception -> 0x02d2 }
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x01ac
            L_0x0200:
                r21 = r3
                r22 = r11
                int r1 = r7.size()     // Catch:{ Exception -> 0x02d2 }
                if (r1 <= 0) goto L_0x0229
                int r1 = r1 + -1
                java.lang.Object r1 = r7.remove(r1)     // Catch:{ Exception -> 0x02d2 }
                android.graphics.Rect r1 = (android.graphics.Rect) r1     // Catch:{ Exception -> 0x02d2 }
                int r3 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                r1.bottom = r3     // Catch:{ Exception -> 0x02d2 }
                int r3 = r5.yychar()     // Catch:{ Exception -> 0x02d2 }
                r1.right = r3     // Catch:{ Exception -> 0x02d2 }
                int r3 = r1.bottom     // Catch:{ Exception -> 0x02d2 }
                int r10 = r1.top     // Catch:{ Exception -> 0x02d2 }
                int r3 = r3 - r10
                r10 = 1
                if (r3 <= r10) goto L_0x0229
                r6.add(r1)     // Catch:{ Exception -> 0x02d2 }
            L_0x0229:
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r3 = 1
                r1.<init>(r14, r3)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x029e
            L_0x0230:
                r21 = r3
                r22 = r11
                android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ Exception -> 0x02d2 }
                int r3 = r5.yychar()     // Catch:{ Exception -> 0x02d2 }
                int r10 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                int r11 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                r15 = 0
                r1.<init>(r3, r10, r15, r11)     // Catch:{ Exception -> 0x02d2 }
                r7.add(r1)     // Catch:{ Exception -> 0x02d2 }
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r3 = 1
                r1.<init>(r14, r3)     // Catch:{ Exception -> 0x02d2 }
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
                r10 = r20
                r1 = 0
                r3 = 1
                r16 = 0
                goto L_0x02c1
            L_0x0259:
                r21 = r3
                r22 = r11
                android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ Exception -> 0x02d2 }
                int r3 = r5.yychar()     // Catch:{ Exception -> 0x02d2 }
                int r10 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                int r11 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                r15 = 0
                r1.<init>(r3, r10, r15, r11)     // Catch:{ Exception -> 0x02d2 }
                r7.add(r1)     // Catch:{ Exception -> 0x02d2 }
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r3 = 1
                r1.<init>(r14, r3)     // Catch:{ Exception -> 0x02d2 }
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
                goto L_0x00a4
            L_0x027d:
                r21 = r3
                r22 = r11
                if (r16 == 0) goto L_0x0298
                android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ Exception -> 0x02d2 }
                int r3 = r5.yychar()     // Catch:{ Exception -> 0x02d2 }
                int r10 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                int r11 = r5.yyline()     // Catch:{ Exception -> 0x02d2 }
                r15 = 0
                r1.<init>(r3, r10, r15, r11)     // Catch:{ Exception -> 0x02d2 }
                r7.add(r1)     // Catch:{ Exception -> 0x02d2 }
            L_0x0298:
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r3 = 1
                r1.<init>(r14, r3)     // Catch:{ Exception -> 0x02d2 }
            L_0x029e:
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
                r10 = r20
                r1 = 0
                r3 = 1
                r16 = 1
                goto L_0x02c1
            L_0x02a8:
                r21 = r3
                r22 = r11
                com.b.a.b.m r1 = new com.b.a.b.m     // Catch:{ Exception -> 0x02d2 }
                r3 = 1
                r1.<init>(r14, r3)     // Catch:{ Exception -> 0x02d2 }
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
            L_0x02b5:
                r10 = r20
                r1 = 0
                goto L_0x02c1
            L_0x02b9:
                r1.<init>(r14, r10)     // Catch:{ Exception -> 0x02d2 }
                r4.add(r1)     // Catch:{ Exception -> 0x02d2 }
                r10 = r20
            L_0x02c1:
                com.androlua.LuaTokenTypes r11 = com.androlua.LuaTokenTypes.WHITE_SPACE     // Catch:{ Exception -> 0x02d2 }
                if (r9 == r11) goto L_0x02c7
                r11 = r9
                goto L_0x02c9
            L_0x02c7:
                r11 = r22
            L_0x02c9:
                r15 = r9
                r3 = r21
                r17 = r22
                r1 = r23
                goto L_0x0041
            L_0x02d2:
                r0 = move-exception
                r1 = r0
                com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r1)
                java.lang.String r1 = r1.getMessage()
                com.p021b.p022a.p024b.C0428q.m2726a(r1)
            L_0x02de:
                boolean r1 = r4.isEmpty()
                if (r1 == 0) goto L_0x02ed
                com.b.a.b.m r1 = new com.b.a.b.m
                r3 = 0
                r1.<init>(r3, r3)
                r4.add(r1)
            L_0x02ed:
                r2.mo3005a()
                com.p021b.p022a.p024b.C0419k.f3011e = r6
                r1 = r23
                r1.f3021f = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0419k.C0422b.m2674d():void");
        }

        /* renamed from: a */
        public void mo3040a() {
            this.f3019d = true;
            this.f3018c.mo3002a();
        }

        /* renamed from: b */
        public void mo3041b() {
            this.f3018c.mo3002a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
            if (r2.mo3022d(r9) != false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
            if (r2.mo3022d(r9) != false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
            r9 = ' ';
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
            if (r2.mo3020c(r9, r12) != false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
            r9 = r12;
            r8 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
            if (r12 == 10) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a8, code lost:
            r11 = r11 + 1;
         */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo3042c() {
            /*
                r17 = this;
                r0 = r17
                com.b.a.b.k r1 = com.p021b.p022a.p024b.C0419k.this
                com.b.a.b.f r1 = r1.mo3039c()
                com.b.a.b.h r2 = com.p021b.p022a.p024b.C0419k.m2664a()
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                boolean r4 = r2.mo3028f()
                r5 = 0
                if (r4 != 0) goto L_0x0023
                com.b.a.b.m r1 = new com.b.a.b.m
                r1.<init>(r5, r5)
                r3.add(r1)
                r0.f3021f = r3
                return
            L_0x0023:
                r4 = 127(0x7f, float:1.78E-43)
                char[] r6 = new char[r4]
                r1.mo2990f(r5)
                r8 = -1
                r9 = 0
                r10 = 0
                r11 = 0
            L_0x002e:
                boolean r12 = r1.mo2979a()
                if (r12 == 0) goto L_0x01ac
                com.b.a.b.g r12 = r0.f3018c
                boolean r12 = r12.mo3004c()
                if (r12 != 0) goto L_0x01ac
                char r12 = r1.mo2980b()
                r13 = 32
                r14 = 40
                r15 = 10
                switch(r8) {
                    case -1: goto L_0x00a3;
                    case 0: goto L_0x00a3;
                    case 1: goto L_0x00a3;
                    case 3: goto L_0x00a3;
                    case 10: goto L_0x00a3;
                    case 20: goto L_0x0095;
                    case 21: goto L_0x0095;
                    case 30: goto L_0x0095;
                    case 40: goto L_0x008b;
                    case 50: goto L_0x006c;
                    case 51: goto L_0x0050;
                    default: goto L_0x0049;
                }
            L_0x0049:
                java.lang.String r7 = "Invalid state in TokenScanner"
                com.p021b.p022a.p024b.C0428q.m2726a(r7)
                goto L_0x01a7
            L_0x0050:
                boolean r14 = r2.mo3031g(r12)
                if (r14 != 0) goto L_0x0058
                if (r12 != r15) goto L_0x005f
            L_0x0058:
                boolean r14 = r2.mo3022d(r9)
                if (r14 != 0) goto L_0x005f
                goto L_0x0091
            L_0x005f:
                boolean r14 = r2.mo3022d(r12)
                if (r14 == 0) goto L_0x01a7
                boolean r9 = r2.mo3022d(r9)
                if (r9 == 0) goto L_0x01a7
                goto L_0x0087
            L_0x006c:
                boolean r14 = r2.mo3029f(r12)
                if (r14 != 0) goto L_0x0074
                if (r12 != r15) goto L_0x007b
            L_0x0074:
                boolean r14 = r2.mo3022d(r9)
                if (r14 != 0) goto L_0x007b
                goto L_0x0091
            L_0x007b:
                boolean r14 = r2.mo3022d(r12)
                if (r14 == 0) goto L_0x01a7
                boolean r9 = r2.mo3022d(r9)
                if (r9 == 0) goto L_0x01a7
            L_0x0087:
                r9 = 32
                goto L_0x01a8
            L_0x008b:
                boolean r9 = r2.mo3020c(r9, r12)
                if (r9 == 0) goto L_0x01a7
            L_0x0091:
                r9 = r12
                r8 = -1
                goto L_0x01a8
            L_0x0095:
                boolean r9 = r2.mo3016b(r9, r12)
                if (r9 == 0) goto L_0x00a0
                r9 = r12
                r8 = 40
                goto L_0x01a8
            L_0x00a0:
                if (r12 != r15) goto L_0x01a7
                goto L_0x0091
            L_0x00a3:
                boolean r13 = r2.mo3010a(r9, r12)
                r7 = 30
                r15 = 1
                if (r13 == 0) goto L_0x00b0
                r9 = 1
                r13 = 30
                goto L_0x00ec
            L_0x00b0:
                boolean r9 = r2.mo3016b(r9, r12)
                if (r9 == 0) goto L_0x00ba
                r9 = 1
                r13 = 40
                goto L_0x00ec
            L_0x00ba:
                boolean r9 = r2.mo3029f(r12)
                if (r9 == 0) goto L_0x00c6
                r9 = 50
                r9 = 1
                r13 = 50
                goto L_0x00ec
            L_0x00c6:
                boolean r9 = r2.mo3031g(r12)
                if (r9 == 0) goto L_0x00d2
                r9 = 51
                r9 = 1
                r13 = 51
                goto L_0x00ec
            L_0x00d2:
                boolean r9 = r2.mo3033h(r12)
                if (r9 == 0) goto L_0x00de
                r9 = 20
                r9 = 1
                r13 = 20
                goto L_0x00ec
            L_0x00de:
                boolean r9 = r2.mo3034i(r12)
                if (r9 == 0) goto L_0x00ea
                r9 = 21
                r9 = 1
                r13 = 21
                goto L_0x00ec
            L_0x00ea:
                r13 = r8
                r9 = 0
            L_0x00ec:
                if (r9 == 0) goto L_0x012b
                if (r13 == r7) goto L_0x00f5
                if (r13 != r14) goto L_0x00f3
                goto L_0x00f5
            L_0x00f3:
                r7 = r11
                goto L_0x0110
            L_0x00f5:
                int r7 = r11 + -1
                int r9 = r3.size()
                int r9 = r9 - r15
                java.lang.Object r9 = r3.get(r9)
                com.b.a.b.m r9 = (com.p021b.p022a.p024b.C0424m) r9
                int r9 = r9.mo3047a()
                if (r9 != r7) goto L_0x0110
                int r9 = r3.size()
                int r9 = r9 - r15
                r3.remove(r9)
            L_0x0110:
                if (r10 <= 0) goto L_0x011e
                if (r8 == 0) goto L_0x011e
                com.b.a.b.m r8 = new com.b.a.b.m
                int r9 = r11 - r10
                r8.<init>(r9, r5)
                r3.add(r8)
            L_0x011e:
                com.b.a.b.m r8 = new com.b.a.b.m
                r8.<init>(r7, r13)
                r3.add(r8)
                r9 = r12
                r8 = r13
                r10 = 0
                goto L_0x01a8
            L_0x012b:
                boolean r7 = r2.mo3015b(r12)
                if (r7 != 0) goto L_0x013f
                boolean r7 = r2.mo3009a(r12)
                if (r7 == 0) goto L_0x0138
                goto L_0x013f
            L_0x0138:
                if (r10 >= r4) goto L_0x01a7
                r6[r10] = r12
                int r10 = r10 + 1
                goto L_0x01a7
            L_0x013f:
                if (r10 <= 0) goto L_0x0194
                char r7 = r6[r5]
                boolean r7 = r2.mo3026e(r7)
                if (r7 == 0) goto L_0x0158
                int r7 = r11 - r10
                com.b.a.b.m r8 = new com.b.a.b.m
                r9 = 10
                r8.<init>(r7, r9)
                r3.add(r8)
                r8 = 10
                goto L_0x0193
            L_0x0158:
                java.lang.String r7 = new java.lang.String
                r7.<init>(r6, r5, r10)
                boolean r7 = r2.mo3023d(r7)
                if (r7 == 0) goto L_0x016f
                int r7 = r11 - r10
                com.b.a.b.m r8 = new com.b.a.b.m
                r8.<init>(r7, r15)
                r3.add(r8)
                r8 = 1
                goto L_0x0193
            L_0x016f:
                java.lang.String r7 = new java.lang.String
                r7.<init>(r6, r5, r10)
                boolean r7 = r2.mo3027e(r7)
                if (r7 == 0) goto L_0x0186
                int r7 = r11 - r10
                r8 = 3
                com.b.a.b.m r9 = new com.b.a.b.m
                r9.<init>(r7, r8)
                r3.add(r9)
                goto L_0x0193
            L_0x0186:
                if (r8 == 0) goto L_0x0193
                int r7 = r11 - r10
                com.b.a.b.m r8 = new com.b.a.b.m
                r8.<init>(r7, r5)
                r3.add(r8)
                r8 = 0
            L_0x0193:
                r10 = 0
            L_0x0194:
                if (r8 == 0) goto L_0x01a7
                boolean r7 = r2.mo3009a(r12)
                if (r7 == 0) goto L_0x01a7
                com.b.a.b.m r7 = new com.b.a.b.m
                r7.<init>(r11, r5)
                r3.add(r7)
                r9 = r12
                r8 = 0
                goto L_0x01a8
            L_0x01a7:
                r9 = r12
            L_0x01a8:
                int r11 = r11 + 1
                goto L_0x002e
            L_0x01ac:
                boolean r1 = r3.isEmpty()
                if (r1 == 0) goto L_0x01ba
                com.b.a.b.m r1 = new com.b.a.b.m
                r1.<init>(r5, r5)
                r3.add(r1)
            L_0x01ba:
                r0.f3021f = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0419k.C0422b.mo3042c():void");
        }

        public void run() {
            do {
                this.f3019d = false;
                this.f3018c.mo3003b();
                if (C0419k.m2664a() instanceof C0417i) {
                    m2674d();
                } else {
                    mo3042c();
                }
            } while (this.f3019d);
            if (!this.f3018c.mo3004c()) {
                this.f3017b.mo3036a((List<C0424m>) this.f3021f);
            }
        }
    }

    public C0419k(C0421a aVar) {
        this.f3012a = aVar;
    }

    /* renamed from: a */
    public static synchronized C0416h m2664a() {
        C0416h hVar;
        synchronized (C0419k.class) {
            hVar = f3010b;
        }
        return hVar;
    }

    /* renamed from: a */
    public static synchronized void m2666a(C0416h hVar) {
        synchronized (C0419k.class) {
            f3010b = hVar;
        }
    }

    /* renamed from: d */
    public static ArrayList<Rect> m2667d() {
        return f3011e;
    }

    /* renamed from: a */
    public void mo3035a(C0414f fVar) {
        if (m2664a().mo3028f()) {
            mo3038b(new C0414f(fVar));
            if (this.f3014d == null) {
                this.f3014d = new C0422b(this);
                this.f3014d.start();
                return;
            }
            this.f3014d.mo3040a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3036a(List<C0424m> list) {
        if (this.f3012a != null) {
            this.f3012a.mo2887a(list);
        }
        this.f3014d = null;
    }

    /* renamed from: b */
    public void mo3037b() {
        if (this.f3014d != null) {
            this.f3014d.mo3041b();
            this.f3014d = null;
        }
    }

    /* renamed from: b */
    public synchronized void mo3038b(C0414f fVar) {
        this.f3013c = fVar;
    }

    /* renamed from: c */
    public synchronized C0414f mo3039c() {
        return this.f3013c;
    }
}
