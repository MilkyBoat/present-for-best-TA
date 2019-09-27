package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p018c.C0278w;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.android.cglib.dx.TypeId */
public final class TypeId<T> {
    public static final TypeId<Boolean> BOOLEAN = new TypeId<>(C0283c.f2115a);
    public static final TypeId<Byte> BYTE = new TypeId<>(C0283c.f2116b);
    public static final TypeId<Character> CHAR = new TypeId<>(C0283c.f2117c);
    public static final TypeId<Double> DOUBLE = new TypeId<>(C0283c.f2118d);
    public static final TypeId<Float> FLOAT = new TypeId<>(C0283c.f2119e);
    public static final TypeId<Integer> INT = new TypeId<>(C0283c.f2120f);
    public static final TypeId<Long> LONG = new TypeId<>(C0283c.f2121g);
    public static final TypeId<Object> OBJECT = new TypeId<>(C0283c.f2129o);
    public static final TypeId<Short> SHORT = new TypeId<>(C0283c.f2122h);
    public static final TypeId<String> STRING = new TypeId<>(C0283c.f2131q);
    public static final TypeId<Void> VOID = new TypeId<>(C0283c.f2123i);

    /* renamed from: d */
    private static final Map<Class<?>, TypeId<?>> f856d = new HashMap();

    /* renamed from: a */
    final String f857a;

    /* renamed from: b */
    final C0283c f858b;

    /* renamed from: c */
    final C0278w f859c;

    static {
        f856d.put(Boolean.TYPE, BOOLEAN);
        f856d.put(Byte.TYPE, BYTE);
        f856d.put(Character.TYPE, CHAR);
        f856d.put(Double.TYPE, DOUBLE);
        f856d.put(Float.TYPE, FLOAT);
        f856d.put(Integer.TYPE, INT);
        f856d.put(Long.TYPE, LONG);
        f856d.put(Short.TYPE, SHORT);
        f856d.put(Void.TYPE, VOID);
    }

    TypeId(C0283c cVar) {
        this(cVar.mo1726e(), cVar);
    }

    TypeId(String str, C0283c cVar) {
        if (str == null || cVar == null) {
            throw new NullPointerException();
        }
        this.f857a = str;
        this.f858b = cVar;
        this.f859c = C0278w.m1935a(cVar);
    }

    public static <T> TypeId<T> get(Class<T> cls) {
        if (cls.isPrimitive()) {
            return (TypeId) f856d.get(cls);
        }
        String replace = cls.getName().replace('.', '/');
        if (!cls.isArray()) {
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            sb.append(replace);
            sb.append(';');
            replace = sb.toString();
        }
        return get(replace);
    }

    public static <T> TypeId<T> get(String str) {
        return new TypeId<>(str, C0283c.m1968b(str));
    }

    public boolean equals(Object obj) {
        return (obj instanceof TypeId) && ((TypeId) obj).f857a.equals(this.f857a);
    }

    public MethodId<T, Void> getConstructor(TypeId<?>... typeIdArr) {
        return new MethodId<>(this, VOID, "<init>", new TypeList(typeIdArr));
    }

    public <V> FieldId<T, V> getField(TypeId<V> typeId, String str) {
        return new FieldId<>(this, typeId, str);
    }

    public <R> MethodId<T, R> getMethod(TypeId<R> typeId, String str, TypeId<?>... typeIdArr) {
        return new MethodId<>(this, typeId, str, new TypeList(typeIdArr));
    }

    public String getName() {
        return this.f857a;
    }

    public int hashCode() {
        return this.f857a.hashCode();
    }

    public String toString() {
        return this.f857a;
    }
}
