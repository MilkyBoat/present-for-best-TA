package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p009a.p010a.C0089c;
import com.android.cglib.p008dx.p009a.p010a.C0089c.C0090a;
import com.android.cglib.p008dx.p009a.p010a.C0091d;
import com.android.cglib.p008dx.p009a.p010a.C0091d.C0092a;
import com.android.cglib.p008dx.p009a.p010a.C0095g;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0289d;
import com.android.cglib.p008dx.p020d.C0295i;
import com.androlua.BuildConfig;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.android.cglib.dx.a.b.e */
public final class C0155e {

    /* renamed from: a */
    private final C0095g f1295a;

    /* renamed from: b */
    private C0091d f1296b = null;

    /* renamed from: c */
    private byte[] f1297c = null;

    /* renamed from: d */
    private int f1298d = 0;

    /* renamed from: e */
    private TreeMap<C0089c, Integer> f1299e = null;

    public C0155e(C0095g gVar) {
        this.f1295a = gVar;
    }

    /* renamed from: a */
    private static void m1480a(C0089c cVar, int i, int i2, String str, PrintWriter printWriter, C0286a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(C0295i.m2048c(i));
        sb.append(": ");
        String a = cVar.mo1216a(str, sb.toString());
        if (printWriter != null) {
            printWriter.println(a);
        }
        aVar.mo1739a(i2, a);
    }

    /* renamed from: a */
    private void m1481a(String str, PrintWriter printWriter, C0286a aVar) {
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        C0286a aVar2 = aVar;
        m1482c();
        int i = 0;
        boolean z = aVar2 != null;
        int i2 = z ? 6 : 0;
        int i3 = z ? 2 : 0;
        int a = this.f1296b.mo1772a();
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("  ");
        String sb2 = sb.toString();
        if (z) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append("tries:");
            aVar2.mo1739a(0, sb3.toString());
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append("tries:");
            printWriter2.println(sb4.toString());
        }
        for (int i4 = 0; i4 < a; i4++) {
            C0092a a2 = this.f1296b.mo1215a(i4);
            C0089c c = a2.mo1233c();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append("try ");
            sb5.append(C0295i.m2049d(a2.mo1230a()));
            sb5.append("..");
            sb5.append(C0295i.m2049d(a2.mo1232b()));
            String sb6 = sb5.toString();
            String a3 = c.mo1216a(sb2, BuildConfig.FLAVOR);
            if (z) {
                aVar2.mo1739a(i2, sb6);
                aVar2.mo1739a(i3, a3);
            } else {
                printWriter2.println(sb6);
                printWriter2.println(a3);
            }
        }
        if (z) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str2);
            sb7.append("handlers:");
            aVar2.mo1739a(0, sb7.toString());
            int i5 = this.f1298d;
            StringBuilder sb8 = new StringBuilder();
            sb8.append(sb2);
            sb8.append("size: ");
            sb8.append(C0295i.m2048c(this.f1299e.size()));
            aVar2.mo1739a(i5, sb8.toString());
            C0089c cVar = null;
            for (Entry entry : this.f1299e.entrySet()) {
                C0089c cVar2 = (C0089c) entry.getKey();
                int intValue = ((Integer) entry.getValue()).intValue();
                if (cVar != null) {
                    m1480a(cVar, i, intValue - i, sb2, printWriter2, aVar2);
                }
                cVar = cVar2;
                i = intValue;
            }
            m1480a(cVar, i, this.f1297c.length - i, sb2, printWriter2, aVar2);
        }
    }

    /* renamed from: c */
    private void m1482c() {
        if (this.f1296b == null) {
            this.f1296b = this.f1295a.mo1252g();
        }
    }

    /* renamed from: a */
    public int mo1434a() {
        m1482c();
        return this.f1296b.mo1772a();
    }

    /* renamed from: a */
    public void mo1435a(C0165l lVar) {
        m1482c();
        C0147aq j = lVar.mo1476j();
        int a = this.f1296b.mo1772a();
        this.f1299e = new TreeMap<>();
        for (int i = 0; i < a; i++) {
            this.f1299e.put(this.f1296b.mo1215a(i).mo1233c(), null);
        }
        if (this.f1299e.size() > 65535) {
            throw new UnsupportedOperationException("too many catch handlers");
        }
        C0289d dVar = new C0289d();
        this.f1298d = dVar.mo1756e(this.f1299e.size());
        for (Entry entry : this.f1299e.entrySet()) {
            C0089c cVar = (C0089c) entry.getKey();
            int a2 = cVar.mo1772a();
            boolean b = cVar.mo1219b();
            entry.setValue(Integer.valueOf(dVar.mo1760g()));
            if (b) {
                dVar.mo1758f(-(a2 - 1));
                a2--;
            } else {
                dVar.mo1758f(a2);
            }
            for (int i2 = 0; i2 < a2; i2++) {
                C0090a a3 = cVar.mo1215a(i2);
                dVar.mo1756e(j.mo1420b(a3.mo1222a()));
                dVar.mo1756e(a3.mo1223b());
            }
            if (b) {
                dVar.mo1756e(cVar.mo1215a(a2).mo1223b());
            }
        }
        this.f1297c = dVar.mo1759f();
    }

    /* renamed from: a */
    public void mo1436a(C0165l lVar, C0286a aVar) {
        m1482c();
        if (aVar.mo1741a()) {
            m1481a("  ", null, aVar);
        }
        int a = this.f1296b.mo1772a();
        for (int i = 0; i < a; i++) {
            C0092a a2 = this.f1296b.mo1215a(i);
            int a3 = a2.mo1230a();
            int b = a2.mo1232b();
            int i2 = b - a3;
            if (i2 >= 65536) {
                StringBuilder sb = new StringBuilder();
                sb.append("bogus exception range: ");
                sb.append(C0295i.m2044a(a3));
                sb.append("..");
                sb.append(C0295i.m2044a(b));
                throw new UnsupportedOperationException(sb.toString());
            }
            aVar.mo1755d(a3);
            aVar.mo1754c(i2);
            aVar.mo1754c(((Integer) this.f1299e.get(a2.mo1233c())).intValue());
        }
        aVar.mo1751a(this.f1297c);
    }

    /* renamed from: b */
    public int mo1437b() {
        return (mo1434a() * 8) + this.f1297c.length;
    }
}
