package com.p021b.p022a.p024b;

import com.p021b.p022a.p024b.C0412e.C0413a;
import java.util.List;

/* renamed from: com.b.a.b.f */
public class C0414f implements CharSequence {

    /* renamed from: a */
    private int f2990a = 0;

    /* renamed from: b */
    private final C0412e f2991b;

    public C0414f(C0413a aVar) {
        this.f2991b = new C0412e(aVar);
    }

    public C0414f(C0412e eVar) {
        this.f2991b = eVar;
    }

    public C0414f(C0414f fVar) {
        this.f2991b = fVar.f2991b;
    }

    /* renamed from: a */
    public String mo2972a(int i) {
        return this.f2991b.mo2965b(i);
    }

    /* renamed from: a */
    public void mo2973a(char c, int i, long j) {
        if (this.f2991b.mo3071o(i)) {
            this.f2991b.mo2963a(new char[]{c}, i, j, true);
        }
    }

    /* renamed from: a */
    public void mo2974a(int i, int i2, long j) {
        if (this.f2991b.mo3071o(i) && i2 > 0) {
            this.f2991b.mo2960a(i, Math.min(i2, this.f2991b.mo3054d() - i), j, true);
        }
    }

    /* renamed from: a */
    public void mo2975a(int i, long j) {
        if (this.f2991b.mo3071o(i)) {
            this.f2991b.mo2960a(i, 1, j, true);
        }
    }

    /* renamed from: a */
    public void mo2976a(List<C0424m> list) {
        this.f2991b.mo3051a(list);
    }

    /* renamed from: a */
    public void mo2977a(boolean z) {
        this.f2991b.mo2962a(z);
    }

    /* renamed from: a */
    public void mo2978a(char[] cArr, int i, long j) {
        if (this.f2991b.mo3071o(i) && cArr.length != 0) {
            this.f2991b.mo2963a(cArr, i, j, true);
        }
    }

    /* renamed from: a */
    public boolean mo2979a() {
        return this.f2990a >= 0 && this.f2990a < this.f2991b.mo3054d();
    }

    /* renamed from: b */
    public char mo2980b() {
        char charAt = this.f2991b.charAt(this.f2990a);
        this.f2990a++;
        return charAt;
    }

    /* renamed from: b */
    public int mo2981b(int i) {
        return this.f2991b.mo2970e(i);
    }

    /* renamed from: c */
    public int mo2982c(int i) {
        return this.f2991b.mo3060i(i);
    }

    /* renamed from: c */
    public boolean mo2983c() {
        return this.f2991b.mo3059h();
    }

    public char charAt(int i) {
        if (this.f2991b.mo3071o(i)) {
            return this.f2991b.charAt(i);
        }
        return 0;
    }

    /* renamed from: d */
    public int mo2985d(int i) {
        return this.f2991b.mo2969d(i);
    }

    /* renamed from: d */
    public void mo2986d() {
        this.f2991b.mo3061i();
    }

    /* renamed from: e */
    public int mo2987e(int i) {
        return this.f2991b.mo3058h(i);
    }

    /* renamed from: e */
    public void mo2988e() {
        this.f2991b.mo3062j();
    }

    /* renamed from: f */
    public int mo2989f() {
        return this.f2991b.mo2967c();
    }

    /* renamed from: f */
    public int mo2990f(int i) {
        if (!this.f2991b.mo3071o(i)) {
            i = -1;
        }
        this.f2990a = i;
        return this.f2990a;
    }

    /* renamed from: g */
    public int mo2991g() {
        return this.f2991b.mo3054d();
    }

    /* renamed from: g */
    public int mo2992g(int i) {
        return this.f2991b.mo2968c(i);
    }

    /* renamed from: h */
    public void mo2993h() {
        this.f2991b.mo3056f();
    }

    /* renamed from: i */
    public List<C0424m> mo2994i() {
        return this.f2991b.mo3057g();
    }

    /* renamed from: j */
    public boolean mo2995j() {
        return this.f2991b.mo2964a();
    }

    /* renamed from: k */
    public void mo2996k() {
        this.f2991b.mo2966b();
    }

    /* renamed from: l */
    public int mo2997l() {
        return this.f2991b.mo3064k();
    }

    public int length() {
        return this.f2991b.length();
    }

    /* renamed from: m */
    public int mo2999m() {
        return this.f2991b.mo3066l();
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f2991b.subSequence(i, i2);
    }

    public String toString() {
        return this.f2991b.toString();
    }
}
