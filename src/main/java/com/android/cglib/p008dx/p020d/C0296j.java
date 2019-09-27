package com.android.cglib.p008dx.p020d;

import com.androlua.BuildConfig;
import java.io.FilterWriter;
import java.io.Writer;

/* renamed from: com.android.cglib.dx.d.j */
public final class C0296j extends FilterWriter {

    /* renamed from: a */
    private final String f2163a;

    /* renamed from: b */
    private final int f2164b;

    /* renamed from: c */
    private final int f2165c;

    /* renamed from: d */
    private int f2166d;

    /* renamed from: e */
    private boolean f2167e;

    /* renamed from: f */
    private int f2168f;

    public C0296j(Writer writer, int i) {
        this(writer, i, BuildConfig.FLAVOR);
    }

    public C0296j(Writer writer, int i, String str) {
        super(writer);
        if (writer == null) {
            throw new NullPointerException("out == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("width < 0");
        } else if (str == null) {
            throw new NullPointerException("prefix == null");
        } else {
            this.f2164b = i != 0 ? i : Integer.MAX_VALUE;
            this.f2165c = i >> 1;
            if (str.length() == 0) {
                str = null;
            }
            this.f2163a = str;
            m2054a();
        }
    }

    /* renamed from: a */
    private void m2054a() {
        this.f2166d = 0;
        this.f2167e = this.f2165c != 0;
        this.f2168f = 0;
    }

    public void write(int i) {
        synchronized (this.lock) {
            if (this.f2167e) {
                if (i == 32) {
                    this.f2168f++;
                    if (this.f2168f >= this.f2165c) {
                        this.f2168f = this.f2165c;
                    }
                }
                this.f2167e = false;
            }
            if (this.f2166d == this.f2164b && i != 10) {
                this.out.write(10);
                this.f2166d = 0;
            }
            if (this.f2166d == 0) {
                if (this.f2163a != null) {
                    this.out.write(this.f2163a);
                }
                if (!this.f2167e) {
                    for (int i2 = 0; i2 < this.f2168f; i2++) {
                        this.out.write(32);
                    }
                    this.f2166d = this.f2168f;
                }
            }
            this.out.write(i);
            if (i == 10) {
                m2054a();
            } else {
                this.f2166d++;
            }
        }
    }

    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                try {
                    write(str.charAt(i));
                    i++;
                    i2--;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                try {
                    write(cArr[i]);
                    i++;
                    i2--;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
