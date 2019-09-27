package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p015c.p016a.C0225a;
import com.android.cglib.p008dx.p015c.p016a.C0228d;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0256b;
import com.android.cglib.p008dx.p015c.p018c.C0257c;
import com.android.cglib.p008dx.p015c.p018c.C0257c.C0258a;
import com.android.cglib.p008dx.p015c.p018c.C0260e;
import com.android.cglib.p008dx.p015c.p018c.C0261f;
import com.android.cglib.p008dx.p015c.p018c.C0262g;
import com.android.cglib.p008dx.p015c.p018c.C0263h;
import com.android.cglib.p008dx.p015c.p018c.C0264i;
import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p015c.p018c.C0266k;
import com.android.cglib.p008dx.p015c.p018c.C0267l;
import com.android.cglib.p008dx.p015c.p018c.C0268m;
import com.android.cglib.p008dx.p015c.p018c.C0272q;
import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p018c.C0276u;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.Collection;

/* renamed from: com.android.cglib.dx.a.b.au */
public final class C0151au {

    /* renamed from: a */
    private final C0165l f1286a;

    /* renamed from: b */
    private final C0286a f1287b;

    public C0151au(C0165l lVar, C0286a aVar) {
        if (lVar == null) {
            throw new NullPointerException("file == null");
        } else if (aVar == null) {
            throw new NullPointerException("out == null");
        } else {
            this.f1286a = lVar;
            this.f1287b = aVar;
        }
    }

    /* renamed from: a */
    private void m1451a(int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros(j ^ (j >> 63))) + 7) >> 3;
        this.f1287b.mo1753b(i | ((numberOfLeadingZeros - 1) << 5));
        while (numberOfLeadingZeros > 0) {
            this.f1287b.mo1753b((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    /* renamed from: a */
    public static void m1452a(C0165l lVar, C0225a aVar) {
        C0147aq j = lVar.mo1476j();
        C0145ao g = lVar.mo1473g();
        j.mo1417a(aVar.mo1522b());
        for (C0228d dVar : aVar.mo1525d()) {
            g.mo1413a(dVar.mo1535a());
            m1453a(lVar, dVar.mo1536b());
        }
    }

    /* renamed from: a */
    public static void m1453a(C0165l lVar, C0255a aVar) {
        if (aVar instanceof C0256b) {
            m1452a(lVar, ((C0256b) aVar).mo1650b());
            return;
        }
        if (aVar instanceof C0257c) {
            C0258a b = ((C0257c) aVar).mo1654b();
            int a = b.mo1772a();
            for (int i = 0; i < a; i++) {
                m1453a(lVar, b.mo1215a(i));
            }
        } else {
            lVar.mo1465a(aVar);
        }
    }

    /* renamed from: b */
    public static String m1454b(C0255a aVar) {
        if (m1456c(aVar) == 30) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.mo1649e());
        sb.append(' ');
        sb.append(aVar.mo1218a_());
        return sb.toString();
    }

    /* renamed from: b */
    private void m1455b(int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        int i2 = (numberOfLeadingZeros + 7) >> 3;
        this.f1287b.mo1753b(i | ((i2 - 1) << 5));
        while (i2 > 0) {
            this.f1287b.mo1753b((byte) ((int) j));
            j >>= 8;
            i2--;
        }
    }

    /* renamed from: c */
    private static int m1456c(C0255a aVar) {
        if (aVar instanceof C0261f) {
            return 0;
        }
        if (aVar instanceof C0276u) {
            return 2;
        }
        if (aVar instanceof C0262g) {
            return 3;
        }
        if (aVar instanceof C0267l) {
            return 4;
        }
        if (aVar instanceof C0272q) {
            return 6;
        }
        if (aVar instanceof C0266k) {
            return 16;
        }
        if (aVar instanceof C0263h) {
            return 17;
        }
        if (aVar instanceof C0277v) {
            return 23;
        }
        if (aVar instanceof C0278w) {
            return 24;
        }
        if (aVar instanceof C0265j) {
            return 25;
        }
        if (aVar instanceof C0274s) {
            return 26;
        }
        if (aVar instanceof C0264i) {
            return 27;
        }
        if (aVar instanceof C0257c) {
            return 28;
        }
        if (aVar instanceof C0256b) {
            return 29;
        }
        if (aVar instanceof C0268m) {
            return 30;
        }
        if (aVar instanceof C0260e) {
            return 31;
        }
        throw new RuntimeException("Shouldn't happen");
    }

    /* renamed from: c */
    private void m1457c(int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        int i2 = (numberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (i2 * 8));
        this.f1287b.mo1753b(i | ((i2 - 1) << 5));
        while (i2 > 0) {
            this.f1287b.mo1753b((byte) ((int) j2));
            j2 >>= 8;
            i2--;
        }
    }

    /* renamed from: a */
    public void mo1427a(C0225a aVar, boolean z) {
        boolean z2 = z && this.f1287b.mo1741a();
        C0145ao g = this.f1286a.mo1473g();
        C0147aq j = this.f1286a.mo1476j();
        C0278w b = aVar.mo1522b();
        int b2 = j.mo1420b(b);
        if (z2) {
            C0286a aVar2 = this.f1287b;
            StringBuilder sb = new StringBuilder();
            sb.append("  type_idx: ");
            sb.append(C0295i.m2044a(b2));
            sb.append(" // ");
            sb.append(b.mo1218a_());
            aVar2.mo1740a(sb.toString());
        }
        this.f1287b.mo1756e(j.mo1420b(aVar.mo1522b()));
        Collection<C0228d> d = aVar.mo1525d();
        int size = d.size();
        if (z2) {
            C0286a aVar3 = this.f1287b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  size: ");
            sb2.append(C0295i.m2044a(size));
            aVar3.mo1740a(sb2.toString());
        }
        this.f1287b.mo1756e(size);
        int i = 0;
        for (C0228d dVar : d) {
            C0277v a = dVar.mo1535a();
            int b3 = g.mo1415b(a);
            C0255a b4 = dVar.mo1536b();
            if (z2) {
                C0286a aVar4 = this.f1287b;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  elements[");
                sb3.append(i);
                sb3.append("]:");
                aVar4.mo1739a(0, sb3.toString());
                i++;
                C0286a aVar5 = this.f1287b;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("    name_idx: ");
                sb4.append(C0295i.m2044a(b3));
                sb4.append(" // ");
                sb4.append(a.mo1218a_());
                aVar5.mo1740a(sb4.toString());
            }
            this.f1287b.mo1756e(b3);
            if (z2) {
                C0286a aVar6 = this.f1287b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("    value: ");
                sb5.append(m1454b(b4));
                aVar6.mo1740a(sb5.toString());
            }
            mo1428a(b4);
        }
        if (z2) {
            this.f1287b.mo1743c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        r4 = r1.mo1509b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        r1 = (long) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        m1457c(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        m1455b(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a9, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1428a(com.android.cglib.p008dx.p015c.p018c.C0255a r4) {
        /*
            r3 = this;
            int r0 = m1456c(r4)
            if (r0 == 0) goto L_0x00aa
            r1 = 6
            if (r0 == r1) goto L_0x00aa
            switch(r0) {
                case 2: goto L_0x00aa;
                case 3: goto L_0x00a0;
                case 4: goto L_0x00aa;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r0) {
                case 16: goto L_0x0093;
                case 17: goto L_0x008c;
                default: goto L_0x000f;
            }
        L_0x000f:
            r1 = 0
            switch(r0) {
                case 23: goto L_0x007e;
                case 24: goto L_0x0071;
                case 25: goto L_0x0064;
                case 26: goto L_0x0057;
                case 27: goto L_0x004a;
                case 28: goto L_0x003f;
                case 29: goto L_0x0030;
                case 30: goto L_0x002a;
                case 31: goto L_0x001b;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r0 = "Shouldn't happen"
            r4.<init>(r0)
            throw r4
        L_0x001b:
            com.android.cglib.dx.c.c.e r4 = (com.android.cglib.p008dx.p015c.p018c.C0260e) r4
            int r4 = r4.mo1675g()
            com.android.cglib.dx.d.a r1 = r3.f1287b
            int r4 = r4 << 5
            r4 = r4 | r0
            r1.mo1753b(r4)
            return
        L_0x002a:
            com.android.cglib.dx.d.a r4 = r3.f1287b
            r4.mo1753b(r0)
            return
        L_0x0030:
            com.android.cglib.dx.d.a r2 = r3.f1287b
            r2.mo1753b(r0)
            com.android.cglib.dx.c.c.b r4 = (com.android.cglib.p008dx.p015c.p018c.C0256b) r4
            com.android.cglib.dx.c.a.a r4 = r4.mo1650b()
            r3.mo1427a(r4, r1)
            return
        L_0x003f:
            com.android.cglib.dx.d.a r2 = r3.f1287b
            r2.mo1753b(r0)
            com.android.cglib.dx.c.c.c r4 = (com.android.cglib.p008dx.p015c.p018c.C0257c) r4
            r3.mo1429a(r4, r1)
            return
        L_0x004a:
            com.android.cglib.dx.c.c.i r4 = (com.android.cglib.p008dx.p015c.p018c.C0264i) r4
            com.android.cglib.dx.c.c.j r4 = r4.mo1669f()
            com.android.cglib.dx.a.b.l r1 = r3.f1286a
            com.android.cglib.dx.a.b.s r1 = r1.mo1478l()
            goto L_0x006c
        L_0x0057:
            com.android.cglib.dx.a.b.l r1 = r3.f1286a
            com.android.cglib.dx.a.b.ae r1 = r1.mo1479m()
            com.android.cglib.dx.c.c.s r4 = (com.android.cglib.p008dx.p015c.p018c.C0274s) r4
            int r4 = r1.mo1364b(r4)
            goto L_0x008a
        L_0x0064:
            com.android.cglib.dx.a.b.l r1 = r3.f1286a
            com.android.cglib.dx.a.b.s r1 = r1.mo1478l()
            com.android.cglib.dx.c.c.j r4 = (com.android.cglib.p008dx.p015c.p018c.C0265j) r4
        L_0x006c:
            int r4 = r1.mo1509b(r4)
            goto L_0x008a
        L_0x0071:
            com.android.cglib.dx.a.b.l r1 = r3.f1286a
            com.android.cglib.dx.a.b.aq r1 = r1.mo1476j()
            com.android.cglib.dx.c.c.w r4 = (com.android.cglib.p008dx.p015c.p018c.C0278w) r4
            int r4 = r1.mo1420b(r4)
            goto L_0x008a
        L_0x007e:
            com.android.cglib.dx.a.b.l r1 = r3.f1286a
            com.android.cglib.dx.a.b.ao r1 = r1.mo1473g()
            com.android.cglib.dx.c.c.v r4 = (com.android.cglib.p008dx.p015c.p018c.C0277v) r4
            int r4 = r1.mo1415b(r4)
        L_0x008a:
            long r1 = (long) r4
            goto L_0x00a6
        L_0x008c:
            com.android.cglib.dx.c.c.h r4 = (com.android.cglib.p008dx.p015c.p018c.C0263h) r4
            long r1 = r4.mo1676h()
            goto L_0x009c
        L_0x0093:
            com.android.cglib.dx.c.c.k r4 = (com.android.cglib.p008dx.p015c.p018c.C0266k) r4
            long r1 = r4.mo1676h()
            r4 = 32
            long r1 = r1 << r4
        L_0x009c:
            r3.m1457c(r0, r1)
            return
        L_0x00a0:
            com.android.cglib.dx.c.c.p r4 = (com.android.cglib.p008dx.p015c.p018c.C0271p) r4
            long r1 = r4.mo1676h()
        L_0x00a6:
            r3.m1455b(r0, r1)
            return
        L_0x00aa:
            com.android.cglib.dx.c.c.p r4 = (com.android.cglib.p008dx.p015c.p018c.C0271p) r4
            long r1 = r4.mo1676h()
            r3.m1451a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.cglib.p008dx.p009a.p012b.C0151au.mo1428a(com.android.cglib.dx.c.c.a):void");
    }

    /* renamed from: a */
    public void mo1429a(C0257c cVar, boolean z) {
        boolean z2 = z && this.f1287b.mo1741a();
        C0258a b = cVar.mo1654b();
        int a = b.mo1772a();
        if (z2) {
            C0286a aVar = this.f1287b;
            StringBuilder sb = new StringBuilder();
            sb.append("  size: ");
            sb.append(C0295i.m2044a(a));
            aVar.mo1740a(sb.toString());
        }
        this.f1287b.mo1756e(a);
        for (int i = 0; i < a; i++) {
            C0255a a2 = b.mo1215a(i);
            if (z2) {
                C0286a aVar2 = this.f1287b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  [");
                sb2.append(Integer.toHexString(i));
                sb2.append("] ");
                sb2.append(m1454b(a2));
                aVar2.mo1740a(sb2.toString());
            }
            mo1428a(a2);
        }
        if (z2) {
            this.f1287b.mo1743c();
        }
    }
}
