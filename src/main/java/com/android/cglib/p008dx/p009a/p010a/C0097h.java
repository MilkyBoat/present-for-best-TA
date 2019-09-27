package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0252s;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import com.android.cglib.p008dx.p020d.C0305s;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.h */
public abstract class C0097h {

    /* renamed from: a */
    private int f910a;

    /* renamed from: b */
    private final C0099j f911b;

    /* renamed from: c */
    private final C0252s f912c;

    /* renamed from: d */
    private final C0247n f913d;

    public C0097h(C0099j jVar, C0252s sVar, C0247n nVar) {
        if (jVar == null) {
            throw new NullPointerException("opcode == null");
        } else if (sVar == null) {
            throw new NullPointerException("position == null");
        } else if (nVar == null) {
            throw new NullPointerException("registers == null");
        } else {
            this.f910a = -1;
            this.f911b = jVar;
            this.f912c = sVar;
            this.f913d = nVar;
        }
    }

    /* renamed from: a */
    public static C0120x m1099a(C0252s sVar, C0244m mVar, C0244m mVar2) {
        boolean z = true;
        if (mVar.mo1602i() != 1) {
            z = false;
        }
        boolean j = mVar.mo1589b().mo1733j();
        int e = mVar.mo1596e();
        C0099j jVar = (mVar2.mo1596e() | e) < 16 ? j ? C0100k.f1161i : z ? C0100k.f1052c : C0100k.f1158f : e < 256 ? j ? C0100k.f1162j : z ? C0100k.f1105d : C0100k.f1159g : j ? C0100k.f1163k : z ? C0100k.f1157e : C0100k.f1160h;
        return new C0120x(jVar, sVar, C0247n.m1754a(mVar, mVar2));
    }

    /* renamed from: a */
    public final int mo1256a(BitSet bitSet) {
        int j = mo1267j();
        int a = this.f913d.mo1772a();
        int i = 0;
        int i2 = (j == 0 || bitSet.get(0)) ? 0 : this.f913d.mo1614b(0).mo1602i();
        while (j < a) {
            if (!bitSet.get(j)) {
                i += this.f913d.mo1614b(j).mo1602i();
            }
            j++;
        }
        return Math.max(i, i2);
    }

    /* renamed from: a */
    public abstract C0097h mo1207a(C0099j jVar);

    /* renamed from: a */
    public abstract C0097h mo1237a(C0247n nVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo1238a();

    /* renamed from: a */
    public final String mo1257a(String str, int i, boolean z) {
        String a = mo1239a(z);
        if (a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(mo1269l());
        sb.append(": ");
        String sb2 = sb.toString();
        int length = sb2.length();
        return C0305s.m2090a(sb2, length, BuildConfig.FLAVOR, a, i == 0 ? a.length() : i - length);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo1239a(boolean z);

    /* renamed from: a */
    public abstract void mo1209a(C0286a aVar);

    /* renamed from: b */
    public C0097h mo1258b(BitSet bitSet) {
        C0247n nVar = this.f913d;
        boolean z = bitSet.get(0);
        if (mo1267j()) {
            bitSet.set(0);
        }
        C0247n a = nVar.mo1611a(bitSet);
        if (mo1267j()) {
            bitSet.set(0, z);
        }
        if (a.mo1772a() == 0) {
            return null;
        }
        return new C0102m(this.f912c, a);
    }

    /* renamed from: c */
    public C0097h mo1259c(BitSet bitSet) {
        if (!mo1267j() || bitSet.get(0)) {
            return null;
        }
        C0244m b = this.f913d.mo1614b(0);
        return m1099a(this.f912c, b, b.mo1588b(0));
    }

    /* renamed from: c */
    public final void mo1260c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        }
        this.f910a = i;
    }

    /* renamed from: d */
    public abstract C0097h mo1208d(int i);

    /* renamed from: d */
    public C0097h mo1261d(BitSet bitSet) {
        return mo1237a(this.f913d.mo1610a(0, mo1267j(), bitSet));
    }

    /* renamed from: e */
    public final boolean mo1262e() {
        return this.f910a >= 0;
    }

    /* renamed from: f */
    public final int mo1263f() {
        if (this.f910a >= 0) {
            return this.f910a;
        }
        throw new RuntimeException("address not yet known");
    }

    /* renamed from: g */
    public final C0099j mo1264g() {
        return this.f911b;
    }

    /* renamed from: h */
    public final C0252s mo1265h() {
        return this.f912c;
    }

    /* renamed from: i */
    public final C0247n mo1266i() {
        return this.f913d;
    }

    /* renamed from: j */
    public final boolean mo1267j() {
        return this.f911b.mo1280d();
    }

    /* renamed from: k */
    public C0097h mo1268k() {
        return mo1237a(this.f913d.mo1610a(0, mo1267j(), (BitSet) null));
    }

    /* renamed from: l */
    public final String mo1269l() {
        if (this.f910a == -1) {
            return C0295i.m2044a(System.identityHashCode(this));
        }
        return String.format("%04x", new Object[]{Integer.valueOf(this.f910a)});
    }

    /* renamed from: m */
    public final int mo1270m() {
        return mo1263f() + mo1210n();
    }

    /* renamed from: n */
    public abstract int mo1210n();

    public final String toString() {
        boolean z;
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(mo1269l());
        stringBuffer.append(' ');
        stringBuffer.append(this.f912c);
        stringBuffer.append(": ");
        stringBuffer.append(this.f911b.mo1281e());
        if (this.f913d.mo1772a() != 0) {
            stringBuffer.append(this.f913d.mo1775b(" ", ", ", null));
            z = true;
        } else {
            z = false;
        }
        String a = mo1238a();
        if (a != null) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append(' ');
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
}
