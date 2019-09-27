package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p018c.C0274s;
import com.android.cglib.p008dx.p015c.p018c.C0275t;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p019d.C0281a;
import java.util.List;

/* renamed from: com.android.cglib.dx.MethodId */
public final class MethodId<D, R> {

    /* renamed from: a */
    final TypeId<D> f850a;

    /* renamed from: b */
    final TypeId<R> f851b;

    /* renamed from: c */
    final String f852c;

    /* renamed from: d */
    final TypeList f853d;

    /* renamed from: e */
    final C0275t f854e;

    /* renamed from: f */
    final C0274s f855f;

    MethodId(TypeId<D> typeId, TypeId<R> typeId2, String str, TypeList typeList) {
        if (typeId == null || typeId2 == null || str == null || typeList == null) {
            throw new NullPointerException();
        }
        this.f850a = typeId;
        this.f851b = typeId2;
        this.f852c = str;
        this.f853d = typeList;
        this.f854e = new C0275t(new C0277v(str), new C0277v(mo1170a(false)));
        this.f855f = new C0274s(typeId.f859c, this.f854e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo1170a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        if (z) {
            sb.append(this.f850a.f857a);
        }
        for (TypeId<?> typeId : this.f853d.f860a) {
            sb.append(typeId.f857a);
        }
        sb.append(")");
        sb.append(this.f851b.f857a);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0281a mo1171b(boolean z) {
        return C0281a.m1945a(mo1170a(z));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MethodId) {
            MethodId methodId = (MethodId) obj;
            if (methodId.f850a.equals(this.f850a) && methodId.f852c.equals(this.f852c) && methodId.f853d.equals(this.f853d) && methodId.f851b.equals(this.f851b)) {
                return true;
            }
        }
        return false;
    }

    public TypeId<D> getDeclaringType() {
        return this.f850a;
    }

    public String getName() {
        return this.f852c;
    }

    public List<TypeId<?>> getParameters() {
        return this.f853d.asList();
    }

    public TypeId<R> getReturnType() {
        return this.f851b;
    }

    public int hashCode() {
        return ((((((527 + this.f850a.hashCode()) * 31) + this.f852c.hashCode()) * 31) + this.f853d.hashCode()) * 31) + this.f851b.hashCode();
    }

    public boolean isConstructor() {
        return this.f852c.equals("<init>");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f850a);
        sb.append(".");
        sb.append(this.f852c);
        sb.append("(");
        sb.append(this.f853d);
        sb.append(")");
        return sb.toString();
    }
}
