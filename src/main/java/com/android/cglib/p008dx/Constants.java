package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p018c.C0260e;
import com.android.cglib.p008dx.p015c.p018c.C0261f;
import com.android.cglib.p008dx.p015c.p018c.C0262g;
import com.android.cglib.p008dx.p015c.p018c.C0263h;
import com.android.cglib.p008dx.p015c.p018c.C0266k;
import com.android.cglib.p008dx.p015c.p018c.C0267l;
import com.android.cglib.p008dx.p015c.p018c.C0268m;
import com.android.cglib.p008dx.p015c.p018c.C0272q;
import com.android.cglib.p008dx.p015c.p018c.C0276u;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p018c.C0279x;

/* renamed from: com.android.cglib.dx.Constants */
final class Constants {
    private Constants() {
    }

    /* renamed from: a */
    static C0279x m836a(Object obj) {
        if (obj == null) {
            return C0268m.f2028a;
        }
        if (obj instanceof Boolean) {
            return C0260e.m1855a(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Byte) {
            return C0261f.m1860a(((Byte) obj).byteValue());
        }
        if (obj instanceof Character) {
            return C0262g.m1864a(((Character) obj).charValue());
        }
        if (obj instanceof Double) {
            return C0263h.m1868a(Double.doubleToLongBits(((Double) obj).doubleValue()));
        }
        if (obj instanceof Float) {
            return C0266k.m1878a(Float.floatToIntBits(((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return C0267l.m1882a(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return C0272q.m1905a(((Long) obj).longValue());
        }
        if (obj instanceof Short) {
            return C0276u.m1920a(((Short) obj).shortValue());
        }
        if (obj instanceof String) {
            return new C0277v((String) obj);
        }
        if (obj instanceof Class) {
            return new C0278w(TypeId.get((Class) obj).f858b);
        }
        if (obj instanceof TypeId) {
            return new C0278w(((TypeId) obj).f858b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Not a constant: ");
        sb.append(obj);
        throw new UnsupportedOperationException(sb.toString());
    }
}
