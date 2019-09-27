package com.android.cglib.p008dx.p009a.p010a;

import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0268m;
import com.android.cglib.p008dx.p015c.p018c.C0270o;
import com.android.cglib.p008dx.p015c.p018c.C0271p;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p020d.C0286a;
import com.android.cglib.p008dx.p020d.C0295i;
import com.androlua.BuildConfig;
import java.util.BitSet;

/* renamed from: com.android.cglib.dx.a.a.n */
public abstract class C0103n {

    /* renamed from: a */
    public static boolean f1180a = true;

    /* renamed from: a */
    protected static String m1150a(C0247n nVar) {
        int a = nVar.mo1772a();
        StringBuffer stringBuffer = new StringBuffer((a * 5) + 2);
        stringBuffer.append('{');
        for (int i = 0; i < a; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(nVar.mo1614b(i).mo1604k());
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected static String m1151a(C0271p pVar) {
        String a_;
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('#');
        if (pVar instanceof C0268m) {
            a_ = "null";
        } else {
            stringBuffer.append(pVar.mo1649e());
            stringBuffer.append(' ');
            a_ = pVar.mo1218a_();
        }
        stringBuffer.append(a_);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected static String m1152a(C0271p pVar, int i) {
        String str;
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("#");
        long h = pVar instanceof C0270o ? ((C0270o) pVar).mo1676h() : (long) pVar.mo1675g();
        if (i == 4) {
            str = C0295i.m2051f((int) h);
        } else if (i == 8) {
            str = C0295i.m2050e((int) h);
        } else if (i == 16) {
            str = C0295i.m2048c((int) h);
        } else if (i == 32) {
            str = C0295i.m2044a((int) h);
        } else if (i != 64) {
            throw new RuntimeException("shouldn't happen");
        } else {
            str = C0295i.m2045a(h);
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected static short m1153a(int i, int i2) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("low out of range 0..255");
        } else if ((i2 & 255) == i2) {
            return (short) (i | (i2 << 8));
        } else {
            throw new IllegalArgumentException("high out of range 0..255");
        }
    }

    /* renamed from: a */
    protected static short m1154a(int i, int i2, int i3, int i4) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("n0 out of range 0..15");
        } else if ((i2 & 15) != i2) {
            throw new IllegalArgumentException("n1 out of range 0..15");
        } else if ((i3 & 15) != i3) {
            throw new IllegalArgumentException("n2 out of range 0..15");
        } else if ((i4 & 15) == i4) {
            return (short) (i | (i2 << 4) | (i3 << 8) | (i4 << 12));
        } else {
            throw new IllegalArgumentException("n3 out of range 0..15");
        }
    }

    /* renamed from: a */
    protected static short m1155a(C0097h hVar, int i) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("arg out of range 0..255");
        }
        int a = hVar.mo1264g().mo1277a();
        if ((a & 255) == a) {
            return (short) (a | (i << 8));
        }
        throw new IllegalArgumentException("opcode out of range 0..255");
    }

    /* renamed from: a */
    protected static void m1156a(C0286a aVar, short s) {
        aVar.mo1754c(s);
    }

    /* renamed from: a */
    protected static void m1157a(C0286a aVar, short s, int i) {
        m1162a(aVar, s, (short) i, (short) (i >> 16));
    }

    /* renamed from: a */
    protected static void m1158a(C0286a aVar, short s, int i, short s2) {
        m1163a(aVar, s, (short) i, (short) (i >> 16), s2);
    }

    /* renamed from: a */
    protected static void m1159a(C0286a aVar, short s, int i, short s2, short s3) {
        m1164a(aVar, s, (short) i, (short) (i >> 16), s2, s3);
    }

    /* renamed from: a */
    protected static void m1160a(C0286a aVar, short s, long j) {
        m1164a(aVar, s, (short) ((int) j), (short) ((int) (j >> 16)), (short) ((int) (j >> 32)), (short) ((int) (j >> 48)));
    }

    /* renamed from: a */
    protected static void m1161a(C0286a aVar, short s, short s2) {
        aVar.mo1754c(s);
        aVar.mo1754c(s2);
    }

    /* renamed from: a */
    protected static void m1162a(C0286a aVar, short s, short s2, short s3) {
        aVar.mo1754c(s);
        aVar.mo1754c(s2);
        aVar.mo1754c(s3);
    }

    /* renamed from: a */
    protected static void m1163a(C0286a aVar, short s, short s2, short s3, short s4) {
        aVar.mo1754c(s);
        aVar.mo1754c(s2);
        aVar.mo1754c(s3);
        aVar.mo1754c(s4);
    }

    /* renamed from: a */
    protected static void m1164a(C0286a aVar, short s, short s2, short s3, short s4, short s5) {
        aVar.mo1754c(s);
        aVar.mo1754c(s2);
        aVar.mo1754c(s3);
        aVar.mo1754c(s4);
        aVar.mo1754c(s5);
    }

    /* renamed from: a */
    protected static boolean m1165a(int i) {
        return i >= -8 && i <= 7;
    }

    /* renamed from: b */
    protected static int m1166b(int i, int i2) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("low out of range 0..15");
        } else if ((i2 & 15) == i2) {
            return i | (i2 << 4);
        } else {
            throw new IllegalArgumentException("high out of range 0..15");
        }
    }

    /* renamed from: b */
    protected static String m1167b(C0247n nVar) {
        String str;
        int a = nVar.mo1772a();
        StringBuilder sb = new StringBuilder(30);
        sb.append("{");
        switch (a) {
            case 0:
                sb.append("}");
                return sb.toString();
            case 1:
                str = nVar.mo1614b(0).mo1604k();
                break;
            default:
                C0244m b = nVar.mo1614b(a - 1);
                if (b.mo1602i() == 2) {
                    b = b.mo1593c(1);
                }
                sb.append(nVar.mo1614b(0).mo1604k());
                sb.append("..");
                str = b.mo1604k();
                break;
        }
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: b */
    protected static boolean m1168b(int i) {
        return i == (i & 15);
    }

    /* renamed from: c */
    protected static boolean m1169c(int i) {
        return ((byte) i) == i;
    }

    /* renamed from: c */
    protected static boolean m1170c(C0247n nVar) {
        int a = nVar.mo1772a();
        if (a < 2) {
            return true;
        }
        int e = nVar.mo1614b(0).mo1596e();
        for (int i = 0; i < a; i++) {
            C0244m b = nVar.mo1614b(i);
            if (b.mo1596e() != e) {
                return false;
            }
            e += b.mo1602i();
        }
        return true;
    }

    /* renamed from: d */
    protected static String m1171d(C0097h hVar) {
        int c = ((C0122z) hVar).mo1332c();
        return c == ((char) c) ? C0295i.m2048c(c) : C0295i.m2044a(c);
    }

    /* renamed from: d */
    protected static boolean m1172d(int i) {
        return i == (i & 255);
    }

    /* renamed from: e */
    protected static String m1173e(C0097h hVar) {
        int d = ((C0122z) hVar).mo1333d();
        return d == ((short) d) ? C0295i.m2053h(d) : C0295i.m2052g(d);
    }

    /* renamed from: e */
    protected static boolean m1174e(int i) {
        return ((short) i) == i;
    }

    /* renamed from: f */
    protected static String m1175f(C0097h hVar) {
        C0255a b = ((C0094f) hVar).mo1241b();
        return b instanceof C0277v ? ((C0277v) b).mo1698f() : b.mo1218a_();
    }

    /* renamed from: f */
    protected static boolean m1176f(int i) {
        return i == (65535 & i);
    }

    /* renamed from: g */
    protected static String m1177g(C0097h hVar) {
        C0094f fVar = (C0094f) hVar;
        if (!fVar.mo1244d()) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder(20);
        int c = fVar.mo1243c();
        sb.append(fVar.mo1241b().mo1649e());
        sb.append('@');
        sb.append(c < 65536 ? C0295i.m2048c(c) : C0295i.m2044a(c));
        return sb.toString();
    }

    /* renamed from: h */
    protected static short m1178h(C0097h hVar) {
        int a = hVar.mo1264g().mo1277a();
        if (a >= 255 && a <= 65535) {
            return (short) a;
        }
        throw new IllegalArgumentException("extended opcode out of range 255..65535");
    }

    /* renamed from: a */
    public abstract int mo1200a();

    /* renamed from: a */
    public abstract String mo1201a(C0097h hVar);

    /* renamed from: a */
    public final String mo1285a(C0097h hVar, boolean z) {
        String e = hVar.mo1264g().mo1281e();
        String a = mo1201a(hVar);
        String b = mo1204b(hVar, z);
        StringBuilder sb = new StringBuilder(100);
        sb.append(e);
        if (a.length() != 0) {
            sb.append(' ');
            sb.append(a);
        }
        if (b.length() != 0) {
            sb.append(" // ");
            sb.append(b);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public abstract void mo1202a(C0286a aVar, C0097h hVar);

    /* renamed from: a */
    public boolean mo1203a(C0122z zVar) {
        return false;
    }

    /* renamed from: b */
    public abstract String mo1204b(C0097h hVar, boolean z);

    /* renamed from: b */
    public abstract boolean mo1205b(C0097h hVar);

    /* renamed from: c */
    public BitSet mo1206c(C0097h hVar) {
        return new BitSet();
    }
}
