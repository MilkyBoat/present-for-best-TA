package com.p021b.p022a.p024b;

import java.util.ArrayList;

/* renamed from: com.b.a.b.e */
public class C0412e extends C0426o {

    /* renamed from: f */
    private boolean f2987f = false;

    /* renamed from: g */
    private C0413a f2988g;

    /* renamed from: h */
    private ArrayList<Integer> f2989h;

    /* renamed from: com.b.a.b.e$a */
    public interface C0413a {
        int getAdvance(char c);

        int getRowWidth();
    }

    public C0412e(C0413a aVar) {
        this.f2988g = aVar;
        m2574m();
    }

    /* renamed from: a */
    private void m2570a(int i, int i2) {
        while (i < this.f2989h.size() && ((Integer) this.f2989h.get(i)).intValue() <= i2) {
            this.f2989h.remove(i);
        }
    }

    /* renamed from: a */
    private void m2571a(int i, int i2, int i3) {
        if (i > 0) {
            i--;
        }
        int intValue = ((Integer) this.f2989h.get(i)).intValue();
        int i4 = i + 1;
        m2570a(i4, i2 - i3);
        m2572b(i4, i3);
        m2573b(i4, intValue, i2);
    }

    /* renamed from: b */
    private void m2572b(int i, int i2) {
        while (i < this.f2989h.size()) {
            this.f2989h.set(i, Integer.valueOf(((Integer) this.f2989h.get(i)).intValue() + i2));
            i++;
        }
    }

    /* renamed from: b */
    private void m2573b(int i, int i2, int i3) {
        if (!this.f2987f) {
            int p = mo3072p(i2);
            int p2 = mo3072p(i3);
            ArrayList arrayList = new ArrayList();
            while (p < p2) {
                if (p == this.f3026b) {
                    p = this.f3027c;
                }
                if (this.f3025a[p] == 10) {
                    arrayList.add(Integer.valueOf(mo3073q(p) + 1));
                }
                p++;
            }
            this.f2989h.addAll(i, arrayList);
        } else if (!m2575n()) {
            C0428q.m2726a("Not enough space to do word wrap");
        } else {
            ArrayList arrayList2 = new ArrayList();
            int p3 = mo3072p(i2);
            int p4 = mo3072p(i3);
            int rowWidth = this.f2988g.getRowWidth();
            int i4 = i2;
            int i5 = rowWidth;
            int i6 = 0;
            while (p3 < p4) {
                if (p3 == this.f3026b) {
                    p3 = this.f3027c;
                }
                char c = this.f3025a[p3];
                i6 += this.f2988g.getAdvance(c);
                if (c == ' ' || c == 9 || c == 10 || c == 65535) {
                    if (i6 <= i5) {
                        i5 -= i6;
                    } else if (i6 > rowWidth) {
                        int p5 = mo3072p(i4);
                        if (i4 != i2 && (arrayList2.isEmpty() || i4 != ((Integer) arrayList2.get(arrayList2.size() - 1)).intValue())) {
                            arrayList2.add(Integer.valueOf(i4));
                        }
                        i5 = rowWidth;
                        while (p5 <= p3) {
                            if (p5 == this.f3026b) {
                                p5 = this.f3027c;
                            }
                            int advance = this.f2988g.getAdvance(this.f3025a[p5]);
                            if (advance > i5) {
                                arrayList2.add(Integer.valueOf(mo3073q(p5)));
                                i5 = rowWidth - advance;
                            } else {
                                i5 -= advance;
                            }
                            p5++;
                        }
                    } else {
                        arrayList2.add(Integer.valueOf(i4));
                        i5 = rowWidth - i6;
                    }
                    i4 = mo3073q(p3) + 1;
                    i6 = 0;
                }
                if (c == 10) {
                    arrayList2.add(Integer.valueOf(i4));
                    i5 = rowWidth;
                }
                p3++;
            }
            this.f2989h.addAll(i, arrayList2);
        }
    }

    /* renamed from: m */
    private void m2574m() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(0));
        this.f2989h = arrayList;
    }

    /* renamed from: n */
    private boolean m2575n() {
        return this.f2988g.getRowWidth() >= this.f2988g.getAdvance('M') * 2;
    }

    /* renamed from: s */
    private int m2576s(int i) {
        int p = mo3072p(i);
        while (p < this.f3025a.length) {
            if (p == this.f3026b) {
                p = this.f3027c;
            }
            if (this.f3025a[p] == 10 || this.f3025a[p] == 65535) {
                break;
            }
            p++;
        }
        return mo3073q(p) + 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo2959a(int i) {
        super.mo2959a(i);
        if (i != 0) {
            m2571a(mo2970e(i > 0 ? this.f3026b - i : this.f3026b), m2576s(this.f3026b), i);
        }
    }

    /* renamed from: a */
    public synchronized void mo2960a(int i, int i2, long j, boolean z) {
        super.mo2960a(i, i2, j, z);
        m2571a(mo2970e(i), m2576s(i), -i2);
    }

    /* renamed from: a */
    public void mo2961a(CharSequence charSequence) {
        int length = charSequence.length();
        char[] cArr = new char[C0426o.m2693g(length)];
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = charSequence.charAt(i2);
            if (charSequence.charAt(i2) == 10) {
                i++;
            }
        }
        mo3052a(cArr, length, i);
    }

    /* renamed from: a */
    public void mo2962a(boolean z) {
        boolean z2;
        if (z && !this.f2987f) {
            z2 = true;
        } else if (!z && this.f2987f) {
            z2 = false;
        } else {
            return;
        }
        this.f2987f = z2;
        mo2966b();
    }

    /* renamed from: a */
    public synchronized void mo2963a(char[] cArr, int i, long j, boolean z) {
        super.mo2963a(cArr, i, j, z);
        m2571a(mo2970e(i), m2576s(i + cArr.length), cArr.length);
    }

    /* renamed from: a */
    public boolean mo2964a() {
        return this.f2987f;
    }

    /* renamed from: b */
    public String mo2965b(int i) {
        int c = mo2968c(i);
        return c == 0 ? new String() : subSequence(((Integer) this.f2989h.get(i)).intValue(), c).toString();
    }

    /* renamed from: b */
    public void mo2966b() {
        m2574m();
        if (!this.f2987f || m2575n()) {
            m2573b(1, 0, mo3054d());
            return;
        }
        if (this.f2988g.getRowWidth() > 0) {
            C0428q.m2726a("Text field has non-zero width but still too small for word wrap");
        }
    }

    /* renamed from: c */
    public int mo2967c() {
        return this.f2989h.size();
    }

    /* renamed from: c */
    public int mo2968c(int i) {
        if (mo2971f(i)) {
            return 0;
        }
        return (i != this.f2989h.size() + -1 ? ((Integer) this.f2989h.get(i + 1)).intValue() : mo3054d()) - ((Integer) this.f2989h.get(i)).intValue();
    }

    /* renamed from: d */
    public int mo2969d(int i) {
        if (mo2971f(i)) {
            return -1;
        }
        return ((Integer) this.f2989h.get(i)).intValue();
    }

    /* renamed from: e */
    public int mo2970e(int i) {
        if (!mo3071o(i)) {
            return -1;
        }
        int size = this.f2989h.size() - 1;
        int i2 = 0;
        while (size >= i2) {
            int i3 = (i2 + size) / 2;
            int i4 = i3 + 1;
            int intValue = i4 < this.f2989h.size() ? ((Integer) this.f2989h.get(i4)).intValue() : mo3054d();
            if (i >= ((Integer) this.f2989h.get(i3)).intValue() && i < intValue) {
                return i3;
            }
            if (i >= intValue) {
                i2 = i4;
            } else {
                size = i3 - 1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo2971f(int i) {
        return i < 0 || i >= this.f2989h.size();
    }
}
