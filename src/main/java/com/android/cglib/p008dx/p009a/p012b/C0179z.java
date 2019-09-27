package com.android.cglib.p008dx.p009a.p012b;

import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import java.util.ArrayList;

/* renamed from: com.android.cglib.dx.a.b.z */
public final class C0179z extends C0136ag {

    /* renamed from: a */
    private final C0178y f1402a;

    /* renamed from: b */
    private final C0140ak f1403b;

    /* renamed from: c */
    private final C0177x f1404c;

    /* renamed from: d */
    private final C0177x f1405d;

    /* renamed from: e */
    private final int f1406e;

    private C0179z(C0140ak akVar) {
        super(4, 12);
        if (akVar == null) {
            throw new NullPointerException("section == null");
        }
        this.f1402a = C0178y.TYPE_MAP_LIST;
        this.f1403b = akVar;
        this.f1404c = null;
        this.f1405d = null;
        this.f1406e = 1;
    }

    private C0179z(C0178y yVar, C0140ak akVar, C0177x xVar, C0177x xVar2, int i) {
        super(4, 12);
        if (yVar == null) {
            throw new NullPointerException("type == null");
        } else if (akVar == null) {
            throw new NullPointerException("section == null");
        } else if (xVar == null) {
            throw new NullPointerException("firstItem == null");
        } else if (xVar2 == null) {
            throw new NullPointerException("lastItem == null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("itemCount <= 0");
        } else {
            this.f1402a = yVar;
            this.f1403b = akVar;
            this.f1404c = xVar;
            this.f1405d = xVar2;
            this.f1406e = i;
        }
    }

    /* renamed from: a */
    public static void m1636a(C0140ak[] akVarArr, C0132af afVar) {
        C0179z zVar;
        C0140ak[] akVarArr2 = akVarArr;
        C0132af afVar2 = afVar;
        if (akVarArr2 == null) {
            throw new NullPointerException("sections == null");
        } else if (afVar.mo1362a().size() != 0) {
            throw new IllegalArgumentException("mapSection.items().size() != 0");
        } else {
            ArrayList arrayList = new ArrayList(50);
            for (C0140ak akVar : akVarArr2) {
                C0178y yVar = null;
                C0177x xVar = null;
                C0177x xVar2 = null;
                int i = 0;
                for (C0177x xVar3 : akVar.mo1362a()) {
                    C0178y a = xVar3.mo1338a();
                    if (a != yVar) {
                        if (i != 0) {
                            C0179z zVar2 = r6;
                            C0179z zVar3 = new C0179z(yVar, akVar, xVar, xVar2, i);
                            arrayList.add(zVar2);
                        }
                        xVar = xVar3;
                        yVar = a;
                        i = 0;
                    }
                    i++;
                    xVar2 = xVar3;
                }
                if (i != 0) {
                    zVar = new C0179z(yVar, akVar, xVar, xVar2, i);
                } else if (akVar == afVar2) {
                    zVar = new C0179z(afVar2);
                }
                arrayList.add(zVar);
            }
            afVar2.mo1366a((C0136ag) new C0150at(C0178y.TYPE_MAP_LIST, arrayList));
        }
    }

    /* renamed from: a */
    public C0178y mo1338a() {
        return C0178y.TYPE_MAP_ITEM;
    }

    /* renamed from: a */
    public void mo1340a(C0165l lVar) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public void mo1342a_(C0165l lVar, C0286a aVar) {
        int b = this.f1402a.mo1516b();
        int g = this.f1404c == null ? this.f1403b.mo1398g() : this.f1403b.mo1365a(this.f1404c);
        if (aVar.mo1741a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(mo1382g());
            sb.append(' ');
            sb.append(this.f1402a.mo1517c());
            sb.append(" map");
            aVar.mo1739a(0, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  type:   ");
            sb2.append(C0295i.m2048c(b));
            sb2.append(" // ");
            sb2.append(this.f1402a.toString());
            aVar.mo1739a(2, sb2.toString());
            aVar.mo1739a(2, "  unused: 0");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  size:   ");
            sb3.append(C0295i.m2044a(this.f1406e));
            aVar.mo1739a(4, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  offset: ");
            sb4.append(C0295i.m2044a(g));
            aVar.mo1739a(4, sb4.toString());
        }
        aVar.mo1754c(b);
        aVar.mo1754c(0);
        aVar.mo1755d(this.f1406e);
        aVar.mo1755d(g);
    }

    /* renamed from: b */
    public final String mo1343b() {
        return toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.f1403b.toString());
        stringBuffer.append(' ');
        stringBuffer.append(this.f1402a.mo1218a_());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
