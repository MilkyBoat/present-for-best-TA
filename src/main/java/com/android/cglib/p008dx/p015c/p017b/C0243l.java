package com.android.cglib.p008dx.p015c.p017b;

import bsh.ParserConstants;
import com.android.cglib.p008dx.p020d.C0295i;

/* renamed from: com.android.cglib.dx.c.b.l */
public final class C0243l {
    /* renamed from: a */
    public static String m1721a(int i) {
        switch (i) {
            case 1:
                return "nop";
            case 2:
                return "move";
            case 3:
                return "move-param";
            case 4:
                return "move-exception";
            case 5:
                return "const";
            case 6:
                return "goto";
            case 7:
                return "if-eq";
            case 8:
                return "if-ne";
            case 9:
                return "if-lt";
            case 10:
                return "if-ge";
            case 11:
                return "if-le";
            case 12:
                return "if-gt";
            case 13:
                return "switch";
            case 14:
                return "add";
            case 15:
                return "sub";
            case 16:
                return "mul";
            case 17:
                return "div";
            case 18:
                return "rem";
            case 19:
                return "neg";
            case 20:
                return "and";
            case 21:
                return "or";
            case 22:
                return "xor";
            case 23:
                return "shl";
            case 24:
                return "shr";
            case 25:
                return "ushr";
            case 26:
                return "not";
            case 27:
                return "cmpl";
            case 28:
                return "cmpg";
            case 29:
                return "conv";
            case 30:
                return "to-byte";
            case 31:
                return "to-char";
            case 32:
                return "to-short";
            case 33:
                return "return";
            case 34:
                return "array-length";
            case 35:
                return "throw";
            case 36:
                return "monitor-enter";
            case 37:
                return "monitor-exit";
            case ParserConstants.LONG /*38*/:
                return "aget";
            case ParserConstants.NATIVE /*39*/:
                return "aput";
            case ParserConstants.NEW /*40*/:
                return "new-instance";
            case ParserConstants.NULL /*41*/:
                return "new-array";
            case ParserConstants.PACKAGE /*42*/:
                return "filled-new-array";
            case ParserConstants.PRIVATE /*43*/:
                return "check-cast";
            case ParserConstants.PROTECTED /*44*/:
                return "instance-of";
            case ParserConstants.PUBLIC /*45*/:
                return "get-field";
            case 46:
                return "get-static";
            case 47:
                return "put-field";
            case 48:
                return "put-static";
            case 49:
                return "invoke-static";
            case 50:
                return "invoke-virtual";
            case 51:
                return "invoke-super";
            case 52:
                return "invoke-direct";
            case 53:
                return "invoke-interface";
            case 55:
                return "move-result";
            case 56:
                return "move-result-pseudo";
            case 57:
                return "fill-array-data";
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("unknown-");
                sb.append(C0295i.m2050e(i));
                return sb.toString();
        }
    }
}
