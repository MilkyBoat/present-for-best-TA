package bsh;

public class TokenMgrError extends Error {

    /* renamed from: a */
    int f703a;

    public TokenMgrError() {
    }

    public TokenMgrError(String str, int i) {
        super(str);
        this.f703a = i;
    }

    public TokenMgrError(boolean z, int i, int i2, int i3, String str, char c, int i4) {
        this(m754a(z, i, i2, i3, str, c), i4);
    }

    /* renamed from: a */
    protected static final String m753a(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != 0) {
                if (charAt == '\"') {
                    str2 = "\\\"";
                } else if (charAt == '\'') {
                    str2 = "\\'";
                } else if (charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            str2 = "\\b";
                            break;
                        case 9:
                            str2 = "\\t";
                            break;
                        case 10:
                            str2 = "\\n";
                            break;
                        default:
                            switch (charAt) {
                                case 12:
                                    str2 = "\\f";
                                    break;
                                case 13:
                                    str2 = "\\r";
                                    break;
                                default:
                                    char charAt2 = str.charAt(i);
                                    if (charAt2 < ' ' || charAt2 > '~') {
                                        StringBuffer stringBuffer2 = new StringBuffer();
                                        stringBuffer2.append("0000");
                                        stringBuffer2.append(Integer.toString(charAt2, 16));
                                        String stringBuffer3 = stringBuffer2.toString();
                                        StringBuffer stringBuffer4 = new StringBuffer();
                                        stringBuffer4.append("\\u");
                                        stringBuffer4.append(stringBuffer3.substring(stringBuffer3.length() - 4, stringBuffer3.length()));
                                        str2 = stringBuffer4.toString();
                                        break;
                                    } else {
                                        stringBuffer.append(charAt2);
                                        continue;
                                        continue;
                                    }
                            }
                    }
                } else {
                    str2 = "\\\\";
                }
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected static String m754a(boolean z, int i, int i2, int i3, String str, char c) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Lexical error at line ");
        stringBuffer.append(i2);
        stringBuffer.append(", column ");
        stringBuffer.append(i3);
        stringBuffer.append(".  Encountered: ");
        if (z) {
            str2 = "<EOF> ";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("\"");
            stringBuffer2.append(m753a(String.valueOf(c)));
            stringBuffer2.append("\"");
            stringBuffer2.append(" (");
            stringBuffer2.append(c);
            stringBuffer2.append("), ");
            str2 = stringBuffer2.toString();
        }
        stringBuffer.append(str2);
        stringBuffer.append("after : \"");
        stringBuffer.append(m753a(str));
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public String getMessage() {
        return super.getMessage();
    }
}
