package com.android.cglib.p008dx.p020d;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: com.android.cglib.dx.d.s */
public final class C0305s {

    /* renamed from: a */
    private final Writer f2175a;

    /* renamed from: b */
    private final int f2176b;

    /* renamed from: c */
    private final StringBuffer f2177c;

    /* renamed from: d */
    private final StringBuffer f2178d;

    /* renamed from: e */
    private final C0296j f2179e;

    /* renamed from: f */
    private final C0296j f2180f;

    public C0305s(Writer writer, int i, int i2, String str) {
        if (writer == null) {
            throw new NullPointerException("out == null");
        } else if (i < 1) {
            throw new IllegalArgumentException("leftWidth < 1");
        } else if (i2 < 1) {
            throw new IllegalArgumentException("rightWidth < 1");
        } else if (str == null) {
            throw new NullPointerException("spacer == null");
        } else {
            StringWriter stringWriter = new StringWriter(1000);
            StringWriter stringWriter2 = new StringWriter(1000);
            this.f2175a = writer;
            this.f2176b = i;
            this.f2177c = stringWriter.getBuffer();
            this.f2178d = stringWriter2.getBuffer();
            this.f2179e = new C0296j(stringWriter, i);
            this.f2180f = new C0296j(stringWriter2, i2, str);
        }
    }

    /* renamed from: a */
    public static String m2090a(String str, int i, String str2, String str3, int i2) {
        StringWriter stringWriter = new StringWriter((str.length() + str3.length()) * 3);
        C0305s sVar = new C0305s(stringWriter, i, i2, str2);
        try {
            sVar.mo1804a().write(str);
            sVar.mo1805b().write(str3);
            sVar.mo1806c();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException("shouldn't happen", e);
        }
    }

    /* renamed from: a */
    private static void m2091a(Writer writer, int i) {
        while (i > 0) {
            writer.write(32);
            i--;
        }
    }

    /* renamed from: a */
    private static void m2092a(StringBuffer stringBuffer, Writer writer) {
        int length = stringBuffer.length();
        if (length != 0 && stringBuffer.charAt(length - 1) != 10) {
            writer.write(10);
        }
    }

    /* renamed from: d */
    private void m2093d() {
        while (true) {
            int indexOf = this.f2177c.indexOf("\n");
            if (indexOf >= 0) {
                int indexOf2 = this.f2178d.indexOf("\n");
                if (indexOf2 >= 0) {
                    if (indexOf != 0) {
                        this.f2175a.write(this.f2177c.substring(0, indexOf));
                    }
                    if (indexOf2 != 0) {
                        m2091a(this.f2175a, this.f2176b - indexOf);
                        this.f2175a.write(this.f2178d.substring(0, indexOf2));
                    }
                    this.f2175a.write(10);
                    this.f2177c.delete(0, indexOf + 1);
                    this.f2178d.delete(0, indexOf2 + 1);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    private void m2094e() {
        m2092a(this.f2177c, (Writer) this.f2179e);
        while (this.f2177c.length() != 0) {
            this.f2180f.write(10);
            m2093d();
        }
    }

    /* renamed from: f */
    private void m2095f() {
        m2092a(this.f2178d, (Writer) this.f2180f);
        while (this.f2178d.length() != 0) {
            this.f2179e.write(10);
            m2093d();
        }
    }

    /* renamed from: a */
    public Writer mo1804a() {
        return this.f2179e;
    }

    /* renamed from: b */
    public Writer mo1805b() {
        return this.f2180f;
    }

    /* renamed from: c */
    public void mo1806c() {
        try {
            m2092a(this.f2177c, (Writer) this.f2179e);
            m2092a(this.f2178d, (Writer) this.f2180f);
            m2093d();
            m2094e();
            m2095f();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
