package bsh;

import com.androlua.BuildConfig;

public class ParseException extends EvalError {
    public Token currentToken;

    /* renamed from: d */
    String f639d;

    /* renamed from: e */
    protected boolean f640e;
    public int[][] expectedTokenSequences;

    /* renamed from: f */
    protected String f641f;
    public String[] tokenImage;

    public ParseException() {
        this(BuildConfig.FLAVOR);
        this.f640e = false;
    }

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        this();
        this.f640e = true;
        this.currentToken = token;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
    }

    public ParseException(String str) {
        super(str, null, null);
        this.f639d = "<unknown>";
        this.f641f = System.getProperty("line.separator", "\n");
        this.f640e = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo899b(String str) {
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

    public int getErrorLineNumber() {
        return this.currentToken.next.beginLine;
    }

    public String getErrorSourceFile() {
        return this.f639d;
    }

    public String getErrorText() {
        int i = 0;
        for (int i2 = 0; i2 < this.expectedTokenSequences.length; i2++) {
            if (i < this.expectedTokenSequences[i2].length) {
                i = this.expectedTokenSequences[i2].length;
            }
        }
        String str = BuildConfig.FLAVOR;
        Token token = this.currentToken.next;
        String str2 = str;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str2);
                stringBuffer.append(" ");
                str2 = stringBuffer.toString();
            }
            if (token.kind == 0) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(str2);
                stringBuffer2.append(this.tokenImage[0]);
                return stringBuffer2.toString();
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(str2);
            stringBuffer3.append(mo899b(token.image));
            str2 = stringBuffer3.toString();
            token = token.next;
        }
        return str2;
    }

    public String getMessage() {
        return getMessage(false);
    }

    public String getMessage(boolean z) {
        StringBuffer stringBuffer;
        String str;
        if (!this.f640e) {
            return super.getMessage();
        }
        String str2 = BuildConfig.FLAVOR;
        int i = 0;
        for (int i2 = 0; i2 < this.expectedTokenSequences.length; i2++) {
            if (i < this.expectedTokenSequences[i2].length) {
                i = this.expectedTokenSequences[i2].length;
            }
            String str3 = str2;
            for (int i3 : this.expectedTokenSequences[i2]) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(str3);
                stringBuffer2.append(this.tokenImage[i3]);
                stringBuffer2.append(" ");
                str3 = stringBuffer2.toString();
            }
            if (this.expectedTokenSequences[i2][this.expectedTokenSequences[i2].length - 1] != 0) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(str3);
                stringBuffer3.append("...");
                str3 = stringBuffer3.toString();
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(str3);
            stringBuffer4.append(this.f641f);
            stringBuffer4.append("    ");
            str2 = stringBuffer4.toString();
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("In file: ");
        stringBuffer5.append(this.f639d);
        stringBuffer5.append(" Encountered \"");
        String stringBuffer6 = stringBuffer5.toString();
        Token token = this.currentToken.next;
        String str4 = stringBuffer6;
        int i4 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            if (i4 != 0) {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append(str4);
                stringBuffer7.append(" ");
                str4 = stringBuffer7.toString();
            }
            if (token.kind == 0) {
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append(str4);
                stringBuffer8.append(this.tokenImage[0]);
                str4 = stringBuffer8.toString();
                break;
            }
            StringBuffer stringBuffer9 = new StringBuffer();
            stringBuffer9.append(str4);
            stringBuffer9.append(mo899b(token.image));
            str4 = stringBuffer9.toString();
            token = token.next;
            i4++;
        }
        StringBuffer stringBuffer10 = new StringBuffer();
        stringBuffer10.append(str4);
        stringBuffer10.append("\" at line ");
        stringBuffer10.append(this.currentToken.next.beginLine);
        stringBuffer10.append(", column ");
        stringBuffer10.append(this.currentToken.next.beginColumn);
        stringBuffer10.append(".");
        stringBuffer10.append(this.f641f);
        String stringBuffer11 = stringBuffer10.toString();
        if (z) {
            if (this.expectedTokenSequences.length == 1) {
                stringBuffer = new StringBuffer();
                stringBuffer.append(stringBuffer11);
                str = "Was expecting:";
            } else {
                stringBuffer = new StringBuffer();
                stringBuffer.append(stringBuffer11);
                str = "Was expecting one of:";
            }
            stringBuffer.append(str);
            stringBuffer.append(this.f641f);
            stringBuffer.append("    ");
            String stringBuffer12 = stringBuffer.toString();
            StringBuffer stringBuffer13 = new StringBuffer();
            stringBuffer13.append(stringBuffer12);
            stringBuffer13.append(str2);
            stringBuffer11 = stringBuffer13.toString();
        }
        return stringBuffer11;
    }

    public void setErrorSourceFile(String str) {
        this.f639d = str;
    }

    public String toString() {
        return getMessage();
    }
}
