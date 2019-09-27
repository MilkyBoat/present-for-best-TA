package com.p021b.p022a.p024b;

import com.androlua.LuaLexer;
import com.androlua.LuaTokenTypes;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.IOException;

/* renamed from: com.b.a.b.a */
public class C0406a {
    /* renamed from: a */
    private static int m2562a(LuaTokenTypes luaTokenTypes) {
        switch (luaTokenTypes) {
            case FOR:
            case WHILE:
            case FUNCTION:
            case IF:
            case REPEAT:
            case LCURLY:
            case SWITCH:
                return 1;
            case UNTIL:
            case END:
            case RCURLY:
                return -1;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static int m2563a(CharSequence charSequence) {
        LuaLexer luaLexer = new LuaLexer(charSequence);
        int i = 0;
        while (true) {
            try {
                LuaTokenTypes advance = luaLexer.advance();
                if (advance == null) {
                    return i;
                }
                i = luaLexer.yytext().equals("switch") ? i + 1 : i + m2562a(advance);
            } catch (IOException e) {
                C0029a.m806a(e);
                return i;
            }
        }
    }

    /* renamed from: a */
    public static CharSequence m2564a(CharSequence charSequence, int i) {
        String yytext;
        StringBuilder sb = new StringBuilder();
        LuaLexer luaLexer = new LuaLexer(charSequence);
        boolean z = true;
        int i2 = 0;
        while (true) {
            try {
                LuaTokenTypes advance = luaLexer.advance();
                if (advance == null) {
                    return sb;
                }
                if (advance == LuaTokenTypes.NEW_LINE) {
                    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append(10);
                    i2 = Math.max(0, i2);
                    z = true;
                } else if (z) {
                    switch (advance) {
                        case UNTIL:
                        case END:
                        case RCURLY:
                            i2--;
                            sb.append(m2565a(i2 * i));
                            yytext = luaLexer.yytext();
                            break;
                        case WHITE_SPACE:
                            break;
                        case ELSE:
                        case ELSEIF:
                        case CASE:
                        case DEFAULT:
                            sb.append(m2565a((i2 * i) - (i / 2)));
                            yytext = luaLexer.yytext();
                            break;
                        case DOUBLE_COLON:
                        case AT:
                            yytext = luaLexer.yytext();
                            break;
                        default:
                            sb.append(m2565a(i2 * i));
                            sb.append(luaLexer.yytext());
                            i2 += m2562a(advance);
                            break;
                    }
                    sb.append(yytext);
                    z = false;
                } else if (advance == LuaTokenTypes.WHITE_SPACE) {
                    sb.append(' ');
                } else {
                    sb.append(luaLexer.yytext());
                    i2 += m2562a(advance);
                }
            } catch (IOException e) {
                C0029a.m806a(e);
                return sb;
            }
        }
    }

    /* renamed from: a */
    private static char[] m2565a(int i) {
        if (i < 0) {
            return new char[0];
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = ' ';
        }
        return cArr;
    }
}
