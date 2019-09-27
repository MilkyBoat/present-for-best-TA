package com.android.cglib.p008dx.p015c.p018c;

import com.android.cglib.p008dx.p020d.C0304r;

/* renamed from: com.android.cglib.dx.c.c.a */
public abstract class C0255a implements C0304r, Comparable<C0255a> {
    /* renamed from: a */
    public final int compareTo(C0255a aVar) {
        Class cls = getClass();
        Class cls2 = aVar.getClass();
        return cls != cls2 ? cls.getName().compareTo(cls2.getName()) : mo1647b(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo1647b(C0255a aVar);

    /* renamed from: e */
    public abstract String mo1649e();
}
