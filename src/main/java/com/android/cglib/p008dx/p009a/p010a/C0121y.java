package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p009a.p010a.C0091d.C0092a;
import com.android.cglib.p008dx.p015c.p017b.C0230b;
import com.android.cglib.p008dx.p015c.p017b.C0231c;
import com.android.cglib.p008dx.p015c.p017b.C0250q;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0285e;
import com.android.cglib.p008dx.p020d.C0297k;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.android.cglib.dx.a.a.y */
public final class C0121y implements C0088b {

    /* renamed from: a */
    private final C0250q f1233a;

    /* renamed from: b */
    private final int[] f1234b;

    /* renamed from: c */
    private final C0057a f1235c;

    public C0121y(C0250q qVar, int[] iArr, C0057a aVar) {
        if (qVar == null) {
            throw new NullPointerException("method == null");
        } else if (iArr == null) {
            throw new NullPointerException("order == null");
        } else if (aVar == null) {
            throw new NullPointerException("addresses == null");
        } else {
            this.f1233a = qVar;
            this.f1234b = iArr;
            this.f1235c = aVar;
        }
    }

    /* renamed from: a */
    private static C0089c m1292a(C0230b bVar, C0057a aVar) {
        C0297k c = bVar.mo1543c();
        int a = c.mo1784a();
        int d = bVar.mo1544d();
        C0285e i = bVar.mo1547f().mo1570i();
        int a2 = i.mo1738a();
        if (a2 == 0) {
            return C0089c.f893a;
        }
        if ((d != -1 || a == a2) && (d == -1 || (a == a2 + 1 && d == c.mo1785a(a2)))) {
            int i2 = 0;
            while (true) {
                if (i2 >= a2) {
                    break;
                } else if (i.mo1215a(i2).equals(C0283c.f2129o)) {
                    a2 = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            C0089c cVar = new C0089c(a2);
            for (int i3 = 0; i3 < a2; i3++) {
                cVar.mo1217a(i3, new C0278w(i.mo1215a(i3)), aVar.mo1196a(c.mo1785a(i3)).mo1263f());
            }
            cVar.mo1799e();
            return cVar;
        }
        throw new RuntimeException("shouldn't happen: weird successors list");
    }

    /* renamed from: a */
    private static C0092a m1293a(C0230b bVar, C0230b bVar2, C0089c cVar, C0057a aVar) {
        return new C0092a(aVar.mo1198b(bVar).mo1263f(), aVar.mo1199c(bVar2).mo1263f(), cVar);
    }

    /* renamed from: a */
    public static C0091d m1294a(C0250q qVar, int[] iArr, C0057a aVar) {
        C0231c a = qVar.mo1637a();
        ArrayList arrayList = new ArrayList(r0);
        C0230b bVar = null;
        C0230b bVar2 = null;
        C0089c cVar = C0089c.f893a;
        for (int b : iArr) {
            C0230b b2 = a.mo1555b(b);
            if (b2.mo1548g()) {
                C0089c a2 = m1292a(b2, aVar);
                if (cVar.mo1772a() != 0) {
                    if (cVar.equals(a2) && m1295a(bVar, b2, aVar)) {
                        bVar2 = b2;
                    } else if (cVar.mo1772a() != 0) {
                        arrayList.add(m1293a(bVar, bVar2, cVar, aVar));
                    }
                }
                bVar = b2;
                bVar2 = bVar;
                cVar = a2;
            }
        }
        if (cVar.mo1772a() != 0) {
            arrayList.add(m1293a(bVar, bVar2, cVar, aVar));
        }
        int size = arrayList.size();
        if (size == 0) {
            return C0091d.f896a;
        }
        C0091d dVar = new C0091d(size);
        for (int i = 0; i < size; i++) {
            dVar.mo1228a(i, (C0092a) arrayList.get(i));
        }
        dVar.mo1799e();
        return dVar;
    }

    /* renamed from: a */
    private static boolean m1295a(C0230b bVar, C0230b bVar2, C0057a aVar) {
        if (bVar == null) {
            throw new NullPointerException("start == null");
        } else if (bVar2 == null) {
            throw new NullPointerException("end == null");
        } else {
            return aVar.mo1199c(bVar2).mo1263f() - aVar.mo1198b(bVar).mo1263f() <= 65535;
        }
    }

    /* renamed from: a */
    public C0091d mo1211a() {
        return m1294a(this.f1233a, this.f1234b, this.f1235c);
    }

    /* renamed from: b */
    public boolean mo1212b() {
        C0231c a = this.f1233a.mo1637a();
        int a2 = a.mo1772a();
        for (int i = 0; i < a2; i++) {
            if (a.mo1215a(i).mo1547f().mo1570i().mo1738a() != 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public HashSet<C0283c> mo1213c() {
        HashSet<C0283c> hashSet = new HashSet<>(20);
        C0231c a = this.f1233a.mo1637a();
        int a2 = a.mo1772a();
        for (int i = 0; i < a2; i++) {
            C0285e i2 = a.mo1215a(i).mo1547f().mo1570i();
            int a3 = i2.mo1738a();
            for (int i3 = 0; i3 < a3; i3++) {
                hashSet.add(i2.mo1215a(i3));
            }
        }
        return hashSet;
    }
}
