package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0259d;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0293g;
import com.android.cglib.p008dx.p020d.C0294h;
import com.androlua.BuildConfig;
import java.util.ArrayList;

/* renamed from: com.android.cglib.dx.a.a.i */
public final class C0098i extends C0294h {

    /* renamed from: a */
    private final int f914a;

    public C0098i(int i, int i2) {
        super(i);
        this.f914a = i2;
    }

    /* renamed from: a */
    public static C0098i m1122a(ArrayList<C0097h> arrayList, int i) {
        int size = arrayList.size();
        C0098i iVar = new C0098i(size, i);
        for (int i2 = 0; i2 < size; i2++) {
            iVar.mo1272a(i2, (C0097h) arrayList.get(i2));
        }
        iVar.mo1799e();
        return iVar;
    }

    /* renamed from: a */
    public C0097h mo1215a(int i) {
        return (C0097h) mo1776d(i);
    }

    /* renamed from: a */
    public void mo1272a(int i, C0097h hVar) {
        mo1774a(i, hVar);
    }

    /* renamed from: a */
    public void mo1273a(C0286a aVar) {
        int g = aVar.mo1760g();
        int a = mo1772a();
        int i = 0;
        if (aVar.mo1741a()) {
            boolean b = aVar.mo1742b();
            for (int i2 = 0; i2 < a; i2++) {
                C0097h hVar = (C0097h) mo1776d(i2);
                int n = hVar.mo1210n() * 2;
                String a2 = (n != 0 || b) ? hVar.mo1257a("  ", aVar.mo1744d(), true) : null;
                if (a2 == null) {
                    if (n != 0) {
                        a2 = BuildConfig.FLAVOR;
                    }
                }
                aVar.mo1739a(n, a2);
            }
        }
        while (i < a) {
            C0097h hVar2 = (C0097h) mo1776d(i);
            try {
                hVar2.mo1209a(aVar);
                i++;
            } catch (RuntimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("...while writing ");
                sb.append(hVar2);
                throw C0293g.m2033a(e, sb.toString());
            }
        }
        int g2 = (aVar.mo1760g() - g) / 2;
        if (g2 != mo1274b()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("write length mismatch; expected ");
            sb2.append(mo1274b());
            sb2.append(" but actually wrote ");
            sb2.append(g2);
            throw new RuntimeException(sb2.toString());
        }
    }

    /* renamed from: b */
    public int mo1274b() {
        int a = mo1772a();
        if (a == 0) {
            return 0;
        }
        return mo1215a(a - 1).mo1270m();
    }

    /* renamed from: c */
    public int mo1275c() {
        return this.f914a;
    }

    /* renamed from: d */
    public int mo1276d() {
        int a = mo1772a();
        int i = 0;
        for (int i2 = 0; i2 < a; i2++) {
            C0097h hVar = (C0097h) mo1776d(i2);
            if (hVar instanceof C0094f) {
                C0255a b = ((C0094f) hVar).mo1241b();
                if (b instanceof C0259d) {
                    int b2 = ((C0259d) b).mo1662b(hVar.mo1264g().mo1278b() == 113);
                    if (b2 > i) {
                        i = b2;
                    }
                }
            }
        }
        return i;
    }
}
