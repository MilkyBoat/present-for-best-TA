package com.p021b.p022a.p024b;

/* renamed from: com.b.a.b.l */
public class C0423l {

    /* renamed from: a */
    private int f3022a = 0;

    /* renamed from: a */
    public int mo3044a(C0414f fVar, String str, int i, int i2, boolean z, boolean z2) {
        if (str.length() == 0) {
            return -1;
        }
        if (i < 0) {
            C0428q.m2726a("TextBuffer.find: Invalid start position");
            i = 0;
        }
        if (i2 > fVar.mo2991g()) {
            C0428q.m2726a("TextBuffer.find: Invalid end position");
            i2 = fVar.mo2991g();
        }
        int min = Math.min(i2, (fVar.mo2991g() - str.length()) + 1);
        while (i < min && (!mo3046a(fVar, str, i, z) || (z2 && !mo3045a(fVar, i, str.length())))) {
            i++;
            this.f3022a++;
        }
        if (i < min) {
            return i;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo3045a(C0414f fVar, int i, int i2) {
        C0416h a = C0419k.m2664a();
        boolean b = i == 0 ? true : a.mo3015b(fVar.charAt(i - 1));
        int i3 = i + i2;
        return b && (i3 == fVar.mo2991g() ? true : a.mo3015b(fVar.charAt(i3)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo3046a(C0414f fVar, String str, int i, boolean z) {
        if (fVar.mo2991g() - i < str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (z && str.charAt(i2) != fVar.charAt(i2 + i)) {
                return false;
            }
            if (!z && Character.toLowerCase(str.charAt(i2)) != Character.toLowerCase(fVar.charAt(i2 + i))) {
                return false;
            }
        }
        return true;
    }
}
