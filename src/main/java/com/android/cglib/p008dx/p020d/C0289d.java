package com.android.cglib.p008dx.p020d;

import com.androlua.BuildConfig;
import java.io.Writer;
import java.util.ArrayList;

/* renamed from: com.android.cglib.dx.d.d */
public final class C0289d implements C0286a, C0291e {

    /* renamed from: a */
    private final boolean f2151a;

    /* renamed from: b */
    private byte[] f2152b;

    /* renamed from: c */
    private int f2153c;

    /* renamed from: d */
    private boolean f2154d;

    /* renamed from: e */
    private ArrayList<C0290a> f2155e;

    /* renamed from: f */
    private int f2156f;

    /* renamed from: g */
    private int f2157g;

    /* renamed from: com.android.cglib.dx.d.d$a */
    private static class C0290a {

        /* renamed from: a */
        private final int f2158a;

        /* renamed from: b */
        private int f2159b;

        /* renamed from: c */
        private final String f2160c;

        public C0290a(int i, int i2, String str) {
            this.f2158a = i;
            this.f2159b = i2;
            this.f2160c = str;
        }

        public C0290a(int i, String str) {
            this(i, Integer.MAX_VALUE, str);
        }

        /* renamed from: a */
        public int mo1764a() {
            return this.f2158a;
        }

        /* renamed from: a */
        public void mo1765a(int i) {
            if (this.f2159b == Integer.MAX_VALUE) {
                this.f2159b = i;
            }
        }

        /* renamed from: b */
        public int mo1766b() {
            return this.f2159b;
        }

        /* renamed from: b */
        public void mo1767b(int i) {
            this.f2159b = i;
        }

        /* renamed from: c */
        public String mo1768c() {
            return this.f2160c;
        }
    }

    public C0289d() {
        this(1000);
    }

    public C0289d(int i) {
        this(new byte[i], true);
    }

    public C0289d(byte[] bArr) {
        this(bArr, false);
    }

    private C0289d(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        this.f2151a = z;
        this.f2152b = bArr;
        this.f2153c = 0;
        this.f2154d = false;
        this.f2155e = null;
        this.f2156f = 0;
        this.f2157g = 0;
    }

    /* renamed from: i */
    private static void m2002i() {
        throw new IndexOutOfBoundsException("attempt to write past the end");
    }

    /* renamed from: i */
    private void m2003i(int i) {
        if (this.f2152b.length < i) {
            byte[] bArr = new byte[((i * 2) + 1000)];
            System.arraycopy(this.f2152b, 0, bArr, 0, this.f2153c);
            this.f2152b = bArr;
        }
    }

    /* renamed from: a */
    public void mo1747a(int i) {
        if (this.f2153c != i) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected cursor ");
            sb.append(i);
            sb.append("; actual value: ");
            sb.append(this.f2153c);
            throw new C0293g(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo1739a(int i, String str) {
        if (this.f2155e != null) {
            mo1743c();
            int size = this.f2155e.size();
            int b = size == 0 ? 0 : ((C0290a) this.f2155e.get(size - 1)).mo1766b();
            if (b <= this.f2153c) {
                b = this.f2153c;
            }
            this.f2155e.add(new C0290a(b, i + b, str));
        }
    }

    /* renamed from: a */
    public void mo1748a(int i, boolean z) {
        if (this.f2155e != null || this.f2153c != 0) {
            throw new RuntimeException("cannot enable annotations");
        } else if (i < 40) {
            throw new IllegalArgumentException("annotationWidth < 40");
        } else {
            int i2 = (((i - 7) / 15) + 1) & -2;
            if (i2 < 6) {
                i2 = 6;
            } else if (i2 > 10) {
                i2 = 10;
            }
            this.f2155e = new ArrayList<>(1000);
            this.f2156f = i;
            this.f2157g = i2;
            this.f2154d = z;
        }
    }

    /* renamed from: a */
    public void mo1749a(C0288c cVar) {
        int a = cVar.mo1745a();
        int i = this.f2153c;
        int i2 = a + i;
        if (this.f2151a) {
            m2003i(i2);
        } else if (i2 > this.f2152b.length) {
            m2002i();
            return;
        }
        cVar.mo1746a(this.f2152b, i);
        this.f2153c = i2;
    }

    /* renamed from: a */
    public void mo1750a(Writer writer) {
        int i;
        String str;
        int d = mo1744d();
        C0305s sVar = new C0305s(writer, (this.f2156f - d) - 1, d, "|");
        Writer a = sVar.mo1804a();
        Writer b = sVar.mo1805b();
        int size = this.f2155e.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.f2153c && i2 < size) {
            C0290a aVar = (C0290a) this.f2155e.get(i2);
            int a2 = aVar.mo1764a();
            if (i3 < a2) {
                str = BuildConfig.FLAVOR;
                i = i3;
            } else {
                int b2 = aVar.mo1766b();
                str = aVar.mo1768c();
                i2++;
                i = a2;
                a2 = b2;
            }
            a.write(C0295i.m2046a(this.f2152b, i, a2 - i, i, this.f2157g, 6));
            b.write(str);
            sVar.mo1806c();
            i3 = a2;
        }
        if (i3 < this.f2153c) {
            a.write(C0295i.m2046a(this.f2152b, i3, this.f2153c - i3, i3, this.f2157g, 6));
        }
        while (i2 < size) {
            b.write(((C0290a) this.f2155e.get(i2)).mo1768c());
            i2++;
        }
        sVar.mo1806c();
    }

    /* renamed from: a */
    public void mo1740a(String str) {
        if (this.f2155e != null) {
            mo1743c();
            this.f2155e.add(new C0290a(this.f2153c, str));
        }
    }

    /* renamed from: a */
    public void mo1751a(byte[] bArr) {
        mo1752a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo1752a(byte[] bArr, int i, int i2) {
        int i3 = this.f2153c;
        int i4 = i3 + i2;
        int i5 = i + i2;
        if ((i | i2 | i4) < 0 || i5 > bArr.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes.length ");
            sb.append(bArr.length);
            sb.append("; ");
            sb.append(i);
            sb.append("..!");
            sb.append(i4);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (this.f2151a) {
            m2003i(i4);
        } else if (i4 > this.f2152b.length) {
            m2002i();
            return;
        }
        System.arraycopy(bArr, i, this.f2152b, i3, i2);
        this.f2153c = i4;
    }

    /* renamed from: a */
    public boolean mo1741a() {
        return this.f2155e != null;
    }

    /* renamed from: b */
    public void mo1753b(int i) {
        int i2 = this.f2153c;
        int i3 = i2 + 1;
        if (this.f2151a) {
            m2003i(i3);
        } else if (i3 > this.f2152b.length) {
            m2002i();
            return;
        }
        this.f2152b[i2] = (byte) i;
        this.f2153c = i3;
    }

    /* renamed from: b */
    public boolean mo1742b() {
        return this.f2154d;
    }

    /* renamed from: c */
    public void mo1743c() {
        if (this.f2155e != null) {
            int size = this.f2155e.size();
            if (size != 0) {
                ((C0290a) this.f2155e.get(size - 1)).mo1765a(this.f2153c);
            }
        }
    }

    /* renamed from: c */
    public void mo1754c(int i) {
        int i2 = this.f2153c;
        int i3 = i2 + 2;
        if (this.f2151a) {
            m2003i(i3);
        } else if (i3 > this.f2152b.length) {
            m2002i();
            return;
        }
        this.f2152b[i2] = (byte) i;
        this.f2152b[i2 + 1] = (byte) (i >> 8);
        this.f2153c = i3;
    }

    /* renamed from: d */
    public int mo1744d() {
        return this.f2156f - (((this.f2157g * 2) + 8) + (this.f2157g / 2));
    }

    /* renamed from: d */
    public void mo1755d(int i) {
        int i2 = this.f2153c;
        int i3 = i2 + 4;
        if (this.f2151a) {
            m2003i(i3);
        } else if (i3 > this.f2152b.length) {
            m2002i();
            return;
        }
        this.f2152b[i2] = (byte) i;
        this.f2152b[i2 + 1] = (byte) (i >> 8);
        this.f2152b[i2 + 2] = (byte) (i >> 16);
        this.f2152b[i2 + 3] = (byte) (i >> 24);
        this.f2153c = i3;
    }

    /* renamed from: e */
    public int mo1756e(int i) {
        if (this.f2151a) {
            m2003i(this.f2153c + 5);
        }
        int i2 = this.f2153c;
        C0300n.m2072a(this, i);
        return this.f2153c - i2;
    }

    /* renamed from: e */
    public byte[] mo1757e() {
        return this.f2152b;
    }

    /* renamed from: f */
    public int mo1758f(int i) {
        if (this.f2151a) {
            m2003i(this.f2153c + 5);
        }
        int i2 = this.f2153c;
        C0300n.m2073b(this, i);
        return this.f2153c - i2;
    }

    /* renamed from: f */
    public byte[] mo1759f() {
        byte[] bArr = new byte[this.f2153c];
        System.arraycopy(this.f2152b, 0, bArr, 0, this.f2153c);
        return bArr;
    }

    /* renamed from: g */
    public int mo1760g() {
        return this.f2153c;
    }

    /* renamed from: g */
    public void mo1761g(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        int i2 = this.f2153c + i;
        if (this.f2151a) {
            m2003i(i2);
        } else if (i2 > this.f2152b.length) {
            m2002i();
            return;
        }
        this.f2153c = i2;
    }

    /* renamed from: h */
    public void mo1762h() {
        mo1743c();
        if (this.f2155e != null) {
            int size = this.f2155e.size();
            while (size > 0) {
                int i = size - 1;
                C0290a aVar = (C0290a) this.f2155e.get(i);
                if (aVar.mo1764a() > this.f2153c) {
                    this.f2155e.remove(i);
                    size--;
                } else if (aVar.mo1766b() > this.f2153c) {
                    aVar.mo1767b(this.f2153c);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: h */
    public void mo1763h(int i) {
        int i2 = i - 1;
        if (i < 0 || (i & i2) != 0) {
            throw new IllegalArgumentException("bogus alignment");
        }
        int i3 = (this.f2153c + i2) & (i2 ^ -1);
        if (this.f2151a) {
            m2003i(i3);
        } else if (i3 > this.f2152b.length) {
            m2002i();
            return;
        }
        this.f2153c = i3;
    }
}
