package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p018c.C0265j;
import com.android.cglib.p008dx.p015c.p018c.C0275t;
import com.android.cglib.p008dx.p015c.p018c.C0277v;

/* renamed from: com.android.cglib.dx.FieldId */
public final class FieldId<D, V> {

    /* renamed from: a */
    final TypeId<D> f834a;

    /* renamed from: b */
    final TypeId<V> f835b;

    /* renamed from: c */
    final String f836c;

    /* renamed from: d */
    final C0275t f837d;

    /* renamed from: e */
    final C0265j f838e;

    FieldId(TypeId<D> typeId, TypeId<V> typeId2, String str) {
        if (typeId == null || typeId2 == null || str == null) {
            throw new NullPointerException();
        }
        this.f834a = typeId;
        this.f835b = typeId2;
        this.f836c = str;
        this.f837d = new C0275t(new C0277v(str), new C0277v(typeId2.f857a));
        this.f838e = new C0265j(typeId.f859c, this.f837d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FieldId) {
            FieldId fieldId = (FieldId) obj;
            if (fieldId.f834a.equals(this.f834a) && fieldId.f836c.equals(this.f836c)) {
                return true;
            }
        }
        return false;
    }

    public TypeId<D> getDeclaringType() {
        return this.f834a;
    }

    public String getName() {
        return this.f836c;
    }

    public TypeId<V> getType() {
        return this.f835b;
    }

    public int hashCode() {
        return this.f834a.hashCode() + (this.f836c.hashCode() * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f834a);
        sb.append(".");
        sb.append(this.f836c);
        return sb.toString();
    }
}
