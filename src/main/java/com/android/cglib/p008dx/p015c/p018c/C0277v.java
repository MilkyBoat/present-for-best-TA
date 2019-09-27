package com.android.cglib.p008dx.p015c.p018c;

import bsh.org.objectweb.asm.Constants;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p020d.C0288c;
import com.androlua.BuildConfig;

/* renamed from: com.android.cglib.dx.c.c.v */
public final class C0277v extends C0279x {

    /* renamed from: a */
    public static final C0277v f2039a = new C0277v(BuildConfig.FLAVOR);

    /* renamed from: b */
    private final String f2040b;

    /* renamed from: c */
    private final C0288c f2041c;

    public C0277v(String str) {
        if (str == null) {
            throw new NullPointerException("string == null");
        }
        this.f2040b = str.intern();
        this.f2041c = new C0288c(m1924a(str));
    }

    /* renamed from: a */
    public static byte[] m1924a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length * 3)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt != 0 && charAt < 128) {
                bArr[i] = (byte) charAt;
                i++;
            } else if (charAt < 2048) {
                bArr[i] = (byte) (((charAt >> 6) & 31) | Constants.CHECKCAST);
                bArr[i + 1] = (byte) ((charAt & '?') | 128);
                i += 2;
            } else {
                bArr[i] = (byte) (((charAt >> 12) & 15) | 224);
                bArr[i + 1] = (byte) (((charAt >> 6) & 63) | 128);
                bArr[i + 2] = (byte) ((charAt & '?') | 128);
                i += 3;
            }
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    /* renamed from: a */
    public String mo1696a(int i) {
        String str;
        String a_ = mo1218a_();
        if (a_.length() <= i - 2) {
            str = BuildConfig.FLAVOR;
        } else {
            a_ = a_.substring(0, i - 5);
            str = "...";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(a_);
        sb.append(str);
        sb.append('\"');
        return sb.toString();
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        String str;
        int length = this.f2040b.length();
        StringBuilder sb = new StringBuilder((length * 3) / 2);
        int i = 0;
        while (i < length) {
            char charAt = this.f2040b.charAt(i);
            if (charAt < ' ' || charAt >= 127) {
                if (charAt <= 127) {
                    if (charAt != 13) {
                        switch (charAt) {
                            case 9:
                                str = "\\t";
                                break;
                            case 10:
                                str = "\\n";
                                break;
                            default:
                                char charAt2 = i < length + -1 ? this.f2040b.charAt(i + 1) : 0;
                                boolean z = charAt2 >= '0' && charAt2 <= '7';
                                sb.append('\\');
                                for (int i2 = 6; i2 >= 0; i2 -= 3) {
                                    char c = (char) (((charAt >> i2) & 7) + 48);
                                    if (c != '0' || z) {
                                        sb.append(c);
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    sb.append('0');
                                    break;
                                } else {
                                    continue;
                                }
                                break;
                        }
                    } else {
                        str = "\\r";
                    }
                    sb.append(str);
                    i++;
                } else {
                    sb.append("\\u");
                    sb.append(Character.forDigit(charAt >> 12, 16));
                    sb.append(Character.forDigit((charAt >> 8) & 15, 16));
                    sb.append(Character.forDigit((charAt >> 4) & 15, 16));
                    charAt = Character.forDigit(charAt & 15, 16);
                }
            } else if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                sb.append('\\');
            }
            sb.append(charAt);
            i++;
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1647b(C0255a aVar) {
        return this.f2040b.compareTo(((C0277v) aVar).f2040b);
    }

    /* renamed from: b */
    public C0283c mo1589b() {
        return C0283c.f2131q;
    }

    /* renamed from: e */
    public String mo1649e() {
        return "utf8";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0277v)) {
            return false;
        }
        return this.f2040b.equals(((C0277v) obj).f2040b);
    }

    /* renamed from: f */
    public String mo1698f() {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(mo1218a_());
        sb.append('\"');
        return sb.toString();
    }

    /* renamed from: g */
    public String mo1699g() {
        return this.f2040b;
    }

    /* renamed from: h */
    public C0288c mo1700h() {
        return this.f2041c;
    }

    public int hashCode() {
        return this.f2040b.hashCode();
    }

    /* renamed from: i */
    public int mo1702i() {
        return this.f2041c.mo1745a();
    }

    /* renamed from: j */
    public int mo1703j() {
        return this.f2040b.length();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("string{\"");
        sb.append(mo1218a_());
        sb.append("\"}");
        return sb.toString();
    }
}
