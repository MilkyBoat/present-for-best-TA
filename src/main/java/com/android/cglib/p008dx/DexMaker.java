package com.android.cglib.p008dx;

import bsh.org.objectweb.asm.Constants;
import com.android.cglib.p008dx.p009a.C0123b;
import com.android.cglib.p008dx.p009a.p010a.C0116w;
import com.android.cglib.p008dx.p009a.p012b.C0157g;
import com.android.cglib.p008dx.p009a.p012b.C0165l;
import com.android.cglib.p008dx.p009a.p012b.C0167n;
import com.android.cglib.p008dx.p009a.p012b.C0169p;
import com.android.cglib.p008dx.p015c.p017b.C0250q;
import com.android.cglib.p008dx.p015c.p018c.C0255a;
import com.android.cglib.p008dx.p015c.p018c.C0277v;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/* renamed from: com.android.cglib.dx.DexMaker */
public final class DexMaker {

    /* renamed from: a */
    private final Map<TypeId<?>, C0052c> f819a = new LinkedHashMap();

    /* renamed from: com.android.cglib.dx.DexMaker$a */
    static class C0050a {

        /* renamed from: a */
        final FieldId<?, ?> f820a;

        /* renamed from: b */
        private final int f821b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Object f822c;

        C0050a(FieldId<?, ?> fieldId, int i, Object obj) {
            if ((i & 8) != 0 || obj == null) {
                this.f820a = fieldId;
                this.f821b = i;
                this.f822c = obj;
                return;
            }
            throw new IllegalArgumentException("instance fields may not have a value");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0167n mo1150a() {
            return new C0167n(this.f820a.f838e, this.f821b);
        }

        /* renamed from: b */
        public boolean mo1151b() {
            return (this.f821b & 8) != 0;
        }
    }

    /* renamed from: com.android.cglib.dx.DexMaker$b */
    static class C0051b {

        /* renamed from: a */
        final MethodId<?, ?> f823a;

        /* renamed from: b */
        private final int f824b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Code f825c = new Code(this);

        public C0051b(MethodId<?, ?> methodId, int i) {
            this.f823a = methodId;
            this.f824b = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0169p mo1152a(C0123b bVar) {
            return new C0169p(this.f823a.f855f, this.f824b, C0116w.m1263a(new C0250q(this.f825c.mo1112c(), 0), 1, null, this.f825c.mo1111b(), bVar), C0282b.f2078a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo1153a() {
            return (this.f824b & 8) != 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo1154b() {
            return (this.f824b & 65546) != 0;
        }
    }

    /* renamed from: com.android.cglib.dx.DexMaker$c */
    private static class C0052c {

        /* renamed from: a */
        private final TypeId<?> f826a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f827b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f828c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public TypeId<?> f829d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f830e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public TypeList f831f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final Map<FieldId, C0050a> f832g = new LinkedHashMap();
        /* access modifiers changed from: private */

        /* renamed from: h */
        public final Map<MethodId, C0051b> f833h = new LinkedHashMap();

        C0052c(TypeId<?> typeId) {
            this.f826a = typeId;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0157g mo1155a() {
            if (!this.f827b) {
                StringBuilder sb = new StringBuilder();
                sb.append("Undeclared type ");
                sb.append(this.f826a);
                sb.append(" declares members: ");
                sb.append(this.f832g.keySet());
                sb.append(" ");
                sb.append(this.f833h.keySet());
                throw new IllegalStateException(sb.toString());
            }
            C0123b bVar = new C0123b();
            bVar.f1237a = 13;
            C0157g gVar = new C0157g(this.f826a.f859c, this.f828c, this.f829d.f859c, this.f831f.f861b, new C0277v(this.f830e));
            for (C0051b bVar2 : this.f833h.values()) {
                C0169p a = bVar2.mo1152a(bVar);
                if (bVar2.mo1154b()) {
                    gVar.mo1446a(a);
                } else {
                    gVar.mo1447b(a);
                }
            }
            for (C0050a aVar : this.f832g.values()) {
                C0167n a2 = aVar.mo1150a();
                if (aVar.mo1151b()) {
                    gVar.mo1445a(a2, (C0255a) Constants.m836a(aVar.f822c));
                } else {
                    gVar.mo1444a(a2);
                }
            }
            return gVar;
        }
    }

    /* renamed from: a */
    private C0052c m837a(TypeId<?> typeId) {
        C0052c cVar = (C0052c) this.f819a.get(typeId);
        if (cVar != null) {
            return cVar;
        }
        C0052c cVar2 = new C0052c(typeId);
        this.f819a.put(typeId, cVar2);
        return cVar2;
    }

    /* renamed from: a */
    private ClassLoader m838a(File file, File file2, ClassLoader classLoader) {
        try {
            return (ClassLoader) Class.forName("dalvik.system.DexClassLoader").getConstructor(new Class[]{String.class, String.class, String.class, ClassLoader.class}).newInstance(new Object[]{file.getPath(), file2.getAbsolutePath(), null, classLoader});
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("load() requires a Dalvik VM", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getCause());
        } catch (InstantiationException unused) {
            throw new AssertionError();
        } catch (NoSuchMethodException unused2) {
            throw new AssertionError();
        } catch (IllegalAccessException unused3) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private String m839a() {
        Set<TypeId> keySet = this.f819a.keySet();
        int[] iArr = new int[keySet.size()];
        int i = 0;
        for (TypeId a : keySet) {
            C0052c a2 = m837a(a);
            Set keySet2 = a2.f833h.keySet();
            if (a2.f829d != null) {
                int i2 = i + 1;
                iArr[i] = (a2.f829d.hashCode() * 31) + keySet2.hashCode();
                i = i2;
            }
        }
        Arrays.sort(iArr);
        int i3 = 1;
        for (int i4 : iArr) {
            i3 = (i3 * 31) + i4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Generated_");
        sb.append(i3);
        sb.append(".jar");
        return sb.toString();
    }

    public Code declare(MethodId<?, ?> methodId, int i) {
        C0052c a = m837a(methodId.f850a);
        if (a.f833h.containsKey(methodId)) {
            StringBuilder sb = new StringBuilder();
            sb.append("already declared: ");
            sb.append(methodId);
            throw new IllegalStateException(sb.toString());
        } else if ((i & -64) != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected flag: ");
            sb2.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb2.toString());
        } else {
            if ((i & 32) != 0) {
                i = (i & -33) | Constants.ACC_DEPRECATED;
            }
            if (methodId.isConstructor()) {
                i |= Constants.ACC_SYNTHETIC;
            }
            C0051b bVar = new C0051b(methodId, i);
            a.f833h.put(methodId, bVar);
            return bVar.f825c;
        }
    }

    public void declare(FieldId<?, ?> fieldId, int i, Object obj) {
        C0052c a = m837a(fieldId.f834a);
        if (a.f832g.containsKey(fieldId)) {
            StringBuilder sb = new StringBuilder();
            sb.append("already declared: ");
            sb.append(fieldId);
            throw new IllegalStateException(sb.toString());
        } else if ((i & -224) != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected flag: ");
            sb2.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb2.toString());
        } else if ((i & 8) != 0 || obj == null) {
            a.f832g.put(fieldId, new C0050a(fieldId, i, obj));
        } else {
            throw new IllegalArgumentException("staticValue is non-null, but field is not static");
        }
    }

    public void declare(TypeId<?> typeId, String str, int i, TypeId<?> typeId2, TypeId<?>... typeIdArr) {
        C0052c a = m837a(typeId);
        if ((i & -1042) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected flag: ");
            sb.append(Integer.toHexString(i));
            throw new IllegalArgumentException(sb.toString());
        } else if (a.f827b) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("already declared: ");
            sb2.append(typeId);
            throw new IllegalStateException(sb2.toString());
        } else {
            a.f827b = true;
            a.f828c = i;
            a.f829d = typeId2;
            a.f830e = str;
            a.f831f = new TypeList(typeIdArr);
        }
    }

    public byte[] generate() {
        C0123b bVar = new C0123b();
        bVar.f1237a = 13;
        C0165l lVar = new C0165l(bVar);
        for (C0052c a : this.f819a.values()) {
            lVar.mo1464a(a.mo1155a());
        }
        try {
            return lVar.mo1466a((Writer) null, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassLoader generateAndLoad(ClassLoader classLoader, File file) {
        if (file == null) {
            String property = System.getProperty("dexmaker.dexcache");
            if (property != null) {
                file = new File(property);
            } else {
                file = new C0055a().mo1192a();
                if (file == null) {
                    throw new IllegalArgumentException("dexcache == null (and no default could be found; consider setting the 'dexmaker.dexcache' system property)");
                }
            }
        }
        File file2 = new File(file, m839a());
        if (file2.exists()) {
            return m838a(file2, file, classLoader);
        }
        byte[] generate = generate();
        file2.createNewFile();
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(file2));
        JarEntry jarEntry = new JarEntry("classes.dex");
        jarEntry.setSize((long) generate.length);
        jarOutputStream.putNextEntry(jarEntry);
        jarOutputStream.write(generate);
        jarOutputStream.closeEntry();
        jarOutputStream.close();
        return m838a(file2, file, classLoader);
    }
}
