package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p019d.C0282b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.android.cglib.dx.TypeList */
final class TypeList {

    /* renamed from: a */
    final TypeId<?>[] f860a;

    /* renamed from: b */
    final C0282b f861b;

    TypeList(TypeId<?>[] typeIdArr) {
        this.f860a = (TypeId[]) typeIdArr.clone();
        this.f861b = new C0282b(typeIdArr.length);
        for (int i = 0; i < typeIdArr.length; i++) {
            this.f861b.mo1720a(i, typeIdArr[i].f858b);
        }
    }

    public List<TypeId<?>> asList() {
        return Collections.unmodifiableList(Arrays.asList(this.f860a));
    }

    public boolean equals(Object obj) {
        return (obj instanceof TypeList) && Arrays.equals(((TypeList) obj).f860a, this.f860a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f860a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f860a.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.f860a[i]);
        }
        return sb.toString();
    }
}
