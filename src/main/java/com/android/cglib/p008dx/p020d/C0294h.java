package com.android.cglib.p008dx.p020d;

import java.util.Arrays;

/* renamed from: com.android.cglib.dx.d.h */
public class C0294h extends C0301o implements C0304r {

    /* renamed from: a */
    private Object[] f2162a;

    public C0294h(int i) {
        super(i != 0);
        try {
            this.f2162a = new Object[i];
        } catch (NegativeArraySizeException unused) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    /* renamed from: a */
    private Object mo1215a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("n < 0");
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    /* renamed from: a */
    private String m2036a(String str, String str2, String str3, boolean z) {
        int length = this.f2162a.length;
        StringBuffer stringBuffer = new StringBuffer((length * 10) + 10);
        if (str != null) {
            stringBuffer.append(str);
        }
        for (int i = 0; i < length; i++) {
            if (!(i == 0 || str2 == null)) {
                stringBuffer.append(str2);
            }
            if (z) {
                stringBuffer.append(((C0304r) this.f2162a[i]).mo1218a_());
            } else {
                stringBuffer.append(this.f2162a[i]);
            }
        }
        if (str3 != null) {
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public final int mo1772a() {
        return this.f2162a.length;
    }

    /* renamed from: a */
    public String mo1773a(String str, String str2, String str3) {
        return m2036a(str, str2, str3, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo1774a(int i, Object obj) {
        mo1802h();
        try {
            this.f2162a[i] = obj;
        } catch (ArrayIndexOutOfBoundsException unused) {
            mo1215a(i);
        }
    }

    /* renamed from: a_ */
    public String mo1218a_() {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append('{');
        return m2036a(sb.toString(), ", ", "}", true);
    }

    /* renamed from: b */
    public String mo1775b(String str, String str2, String str3) {
        return m2036a(str, str2, str3, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final Object mo1776d(int i) {
        try {
            Object obj = this.f2162a[i];
            if (obj != null) {
                return obj;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unset: ");
            sb.append(i);
            throw new NullPointerException(sb.toString());
        } catch (ArrayIndexOutOfBoundsException unused) {
            return mo1215a(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final Object mo1777e(int i) {
        return this.f2162a[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f2162a, ((C0294h) obj).f2162a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f2162a);
    }

    public String toString() {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append('{');
        return m2036a(sb.toString(), ", ", "}", false);
    }
}
