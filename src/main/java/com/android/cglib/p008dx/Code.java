package com.android.cglib.p008dx;

import com.android.cglib.p008dx.p015c.p017b.C0231c;
import com.android.cglib.p008dx.p015c.p017b.C0235f;
import com.android.cglib.p008dx.p015c.p017b.C0241j;
import com.android.cglib.p008dx.p015c.p017b.C0242k;
import com.android.cglib.p008dx.p015c.p017b.C0244m;
import com.android.cglib.p008dx.p015c.p017b.C0247n;
import com.android.cglib.p008dx.p015c.p017b.C0249p;
import com.android.cglib.p008dx.p015c.p017b.C0251r;
import com.android.cglib.p008dx.p015c.p017b.C0252s;
import com.android.cglib.p008dx.p015c.p017b.C0253t;
import com.android.cglib.p008dx.p015c.p017b.C0254u;
import com.android.cglib.p008dx.p015c.p018c.C0267l;
import com.android.cglib.p008dx.p015c.p019d.C0282b;
import com.android.cglib.p008dx.p015c.p019d.C0283c;
import com.android.cglib.p008dx.p015c.p019d.C0284d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.android.cglib.dx.Code */
public final class Code {

    /* renamed from: a */
    private final MethodId<?, ?> f802a;

    /* renamed from: b */
    private final List<Label> f803b = new ArrayList();

    /* renamed from: c */
    private Label f804c;

    /* renamed from: d */
    private boolean f805d;

    /* renamed from: e */
    private final Local<?> f806e;

    /* renamed from: f */
    private final List<Local<?>> f807f = new ArrayList();

    /* renamed from: g */
    private final List<Local<?>> f808g = new ArrayList();

    /* renamed from: h */
    private C0252s f809h = C0252s.f2000a;

    /* renamed from: i */
    private final List<TypeId<?>> f810i = new ArrayList();

    /* renamed from: j */
    private final List<Label> f811j = new ArrayList();

    /* renamed from: k */
    private C0282b f812k = C0282b.f2078a;

    Code(C0051b bVar) {
        this.f802a = bVar.f823a;
        if (bVar.mo1153a()) {
            this.f806e = null;
        } else {
            this.f806e = Local.m860a(this, this.f802a.f850a);
            this.f807f.add(this.f806e);
        }
        for (TypeId<?> a : this.f802a.f853d.f860a) {
            this.f807f.add(Local.m860a(this, a));
        }
        this.f804c = new Label();
        m824a(this.f804c);
        this.f804c.f841c = true;
    }

    /* renamed from: a */
    private <T> Local<T> m820a(Local<?> local, TypeId<T> typeId) {
        if (local.f846a.equals(typeId)) {
            return local;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("requested ");
        sb.append(typeId);
        sb.append(" but was ");
        sb.append(local.f846a);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private static C0247n m821a(Local<?> local, Local<?>[] localArr) {
        int i = local != null ? 1 : 0;
        C0247n nVar = new C0247n(localArr.length + i);
        if (local != null) {
            nVar.mo1612a(0, local.mo1167b());
        }
        for (int i2 = 0; i2 < localArr.length; i2++) {
            nVar.mo1612a(i2 + i, localArr[i2].mo1167b());
        }
        return nVar;
    }

    /* renamed from: a */
    private C0249p m822a(C0283c cVar, C0283c cVar2) {
        if (cVar.mo1591c() == 6) {
            int c = cVar2.mo1591c();
            if (c == 8) {
                return C0251r.f1920bv;
            }
            switch (c) {
                case 2:
                    return C0251r.f1918bt;
                case 3:
                    return C0251r.f1919bu;
            }
        }
        return C0251r.m1784a(cVar2, cVar);
    }

    /* renamed from: a */
    private C0282b m823a(List<TypeId<?>> list) {
        C0282b bVar = new C0282b(list.size());
        for (int i = 0; i < list.size(); i++) {
            bVar.mo1720a(i, ((TypeId) list.get(i)).f858b);
        }
        return bVar;
    }

    /* renamed from: a */
    private void m824a(Label label) {
        if (label.f840b != this) {
            if (label.f840b != null) {
                throw new IllegalArgumentException("Cannot adopt label; it belongs to another Code");
            }
            label.f840b = this;
            this.f803b.add(label);
        }
    }

    /* renamed from: a */
    private void m825a(Label label, List<Label> list) {
        Label label2 = new Label();
        m824a(label2);
        this.f804c.f843e = label2;
        this.f804c.f844f = label;
        this.f804c.f842d = list;
        this.f804c = label2;
        this.f804c.f841c = true;
    }

    /* renamed from: a */
    private void m826a(Local<?> local, boolean z) {
        m827a((C0235f) new C0242k(z ? C0251r.m1795d((C0284d) local.f846a.f858b) : C0251r.m1792c((C0284d) local.f846a.f858b), this.f809h, local.mo1167b(), C0247n.f1778a));
    }

    /* renamed from: a */
    private void m827a(C0235f fVar) {
        m828a(fVar, (Label) null);
    }

    /* renamed from: a */
    private void m828a(C0235f fVar, Label label) {
        if (this.f804c == null || !this.f804c.f841c) {
            throw new IllegalStateException("no current label");
        }
        this.f804c.f839a.add(fVar);
        int b = fVar.mo1563d().mo1629b();
        if (b != 6) {
            switch (b) {
                case 1:
                    if (label != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unexpected branch: ");
                        sb.append(label);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    return;
                case 2:
                    if (label != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("unexpected branch: ");
                        sb2.append(label);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    break;
                case 3:
                    if (label != null) {
                        this.f804c.f843e = label;
                        break;
                    } else {
                        throw new IllegalArgumentException("branch == null");
                    }
                case 4:
                    if (label == null) {
                        throw new IllegalArgumentException("branch == null");
                    }
                    m825a(label, Collections.emptyList());
                    return;
                default:
                    throw new IllegalArgumentException();
            }
            this.f804c = null;
        } else if (label != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("unexpected branch: ");
            sb3.append(label);
            throw new IllegalArgumentException(sb3.toString());
        } else {
            m825a((Label) null, (List<Label>) new ArrayList<Label>(this.f811j));
        }
    }

    /* renamed from: a */
    private <D, R> void m829a(C0249p pVar, MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        C0253t tVar = new C0253t(pVar, this.f809h, m821a(local2, localArr), this.f812k, methodId.f855f);
        m827a((C0235f) tVar);
        if (local != null) {
            m826a(local, false);
        }
    }

    /* renamed from: d */
    private void m830d() {
        Iterator it = this.f803b.iterator();
        int i = 0;
        while (it.hasNext()) {
            Label label = (Label) it.next();
            if (label.mo1162a()) {
                it.remove();
            } else {
                label.mo1163b();
                int i2 = i + 1;
                label.f845g = i;
                i = i2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1106a() {
        if (this.f805d) {
            throw new AssertionError();
        }
        this.f805d = true;
        int i = 0;
        for (Local a : this.f808g) {
            i += a.mo1166a(i);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i;
        for (Local local : this.f807f) {
            C0267l a2 = C0267l.m1882a(i2 - i);
            i2 += local.mo1166a(i2);
            C0241j jVar = new C0241j(C0251r.m1789b((C0284d) local.f846a.f858b), this.f809h, local.mo1167b(), C0247n.f1778a, a2);
            arrayList.add(jVar);
        }
        ((Label) this.f803b.get(0)).f839a.addAll(0, arrayList);
    }

    public void addCatchClause(TypeId<? extends Throwable> typeId, Label label) {
        if (this.f810i.contains(typeId)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Already caught: ");
            sb.append(typeId);
            throw new IllegalArgumentException(sb.toString());
        }
        m824a(label);
        this.f810i.add(typeId);
        this.f812k = m823a(this.f810i);
        this.f811j.add(label);
    }

    public void aget(Local<?> local, Local<?> local2, Local<Integer> local3) {
        m827a((C0235f) new C0254u(C0251r.m1810k((C0284d) local.f846a.f858b), this.f809h, C0247n.m1754a(local2.mo1167b(), local3.mo1167b()), this.f812k));
        m826a(local, true);
    }

    public void aput(Local<?> local, Local<Integer> local2, Local<?> local3) {
        m827a((C0235f) new C0254u(C0251r.m1812l((C0284d) local3.f846a.f858b), this.f809h, C0247n.m1755a(local3.mo1167b(), local.mo1167b(), local2.mo1167b()), this.f812k));
    }

    public <T> void arrayLength(Local<Integer> local, Local<T> local2) {
        m827a((C0235f) new C0254u(C0251r.f1875bC, this.f809h, C0247n.m1753a(local2.mo1167b()), this.f812k));
        m826a(local, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo1111b() {
        int i = 0;
        for (Local a : this.f807f) {
            i += a.mo1165a();
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0231c mo1112c() {
        if (!this.f805d) {
            mo1106a();
        }
        m830d();
        C0231c cVar = new C0231c(this.f803b.size());
        for (int i = 0; i < this.f803b.size(); i++) {
            cVar.mo1552a(i, ((Label) this.f803b.get(i)).mo1164c());
        }
        return cVar;
    }

    public void cast(Local<?> local, Local<?> local2) {
        if (local2.getType().f858b.mo1733j()) {
            C0253t tVar = new C0253t(C0251r.f1958ch, this.f809h, C0247n.m1753a(local2.mo1167b()), this.f812k, local.f846a.f859c);
            m827a((C0235f) tVar);
            m826a(local, true);
            return;
        }
        m827a((C0235f) new C0242k(m822a(local2.f846a.f858b, local.f846a.f858b), this.f809h, local.mo1167b(), local2.mo1167b()));
    }

    public <T> void compare(Comparison comparison, Label label, Local<T> local, Local<T> local2) {
        m824a(label);
        m828a((C0235f) new C0242k(comparison.rop(C0282b.m1956a(local.f846a.f858b, local2.f846a.f858b)), this.f809h, (C0244m) null, C0247n.m1754a(local.mo1167b(), local2.mo1167b())), label);
    }

    public <T extends Number> void compareFloatingPoint(Local<Integer> local, Local<T> local2, Local<T> local3, int i) {
        C0249p pVar;
        if (i == 1) {
            pVar = C0251r.m1806i((C0284d) local2.f846a.f858b);
        } else if (i == -1) {
            pVar = C0251r.m1804h((C0284d) local2.f846a.f858b);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("expected 1 or -1 but was ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        m827a((C0235f) new C0242k(pVar, this.f809h, local.mo1167b(), C0247n.m1754a(local2.mo1167b(), local3.mo1167b())));
    }

    public void compareLongs(Local<Integer> local, Local<Long> local2, Local<Long> local3) {
        m827a((C0235f) new C0242k(C0251r.f1901bc, this.f809h, local.mo1167b(), C0247n.m1754a(local2.mo1167b(), local3.mo1167b())));
    }

    public <T> Local<T> getParameter(int i, TypeId<T> typeId) {
        if (this.f806e != null) {
            i++;
        }
        return m820a((Local) this.f807f.get(i), typeId);
    }

    public <T> Local<T> getThis(TypeId<T> typeId) {
        if (this.f806e != null) {
            return m820a(this.f806e, typeId);
        }
        throw new IllegalStateException("static methods cannot access 'this'");
    }

    public <D, V> void iget(FieldId<D, V> fieldId, Local<V> local, Local<D> local2) {
        C0253t tVar = new C0253t(C0251r.m1816n((C0284d) local.f846a.f858b), this.f809h, C0247n.m1753a(local2.mo1167b()), this.f812k, fieldId.f838e);
        m827a((C0235f) tVar);
        m826a(local, true);
    }

    public void instanceOfType(Local<?> local, Local<?> local2, TypeId<?> typeId) {
        C0253t tVar = new C0253t(C0251r.f1959ci, this.f809h, C0247n.m1753a(local2.mo1167b()), this.f812k, typeId.f859c);
        m827a((C0235f) tVar);
        m826a(local, true);
    }

    public <D, R> void invokeDirect(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        m829a(C0251r.m1794d(methodId.mo1171b(true)), methodId, local, local2, localArr);
    }

    public <D, R> void invokeInterface(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        m829a(C0251r.m1797e(methodId.mo1171b(true)), methodId, local, local2, localArr);
    }

    public <R> void invokeStatic(MethodId<?, R> methodId, Local<? super R> local, Local<?>... localArr) {
        m829a(C0251r.m1782a(methodId.mo1171b(true)), methodId, local, null, localArr);
    }

    public <D, R> void invokeSuper(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        m829a(C0251r.m1791c(methodId.mo1171b(true)), methodId, local, local2, localArr);
    }

    public <D, R> void invokeVirtual(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        m829a(C0251r.m1788b(methodId.mo1171b(true)), methodId, local, local2, localArr);
    }

    public <D, V> void iput(FieldId<D, V> fieldId, Local<D> local, Local<V> local2) {
        C0253t tVar = new C0253t(C0251r.m1818o((C0284d) local2.f846a.f858b), this.f809h, C0247n.m1754a(local2.mo1167b(), local.mo1167b()), this.f812k, fieldId.f838e);
        m827a((C0235f) tVar);
    }

    public void jump(Label label) {
        m824a(label);
        m828a((C0235f) new C0242k(C0251r.f1992s, this.f809h, (C0244m) null, C0247n.f1778a), label);
    }

    public <T> void loadConstant(Local<T> local, T t) {
        C0249p e = t == null ? C0251r.f1991r : C0251r.m1798e((C0284d) local.f846a.f858b);
        if (e.mo1629b() == 1) {
            C0241j jVar = new C0241j(e, this.f809h, local.mo1167b(), C0247n.f1778a, Constants.m836a(t));
            m827a((C0235f) jVar);
            return;
        }
        C0253t tVar = new C0253t(e, this.f809h, C0247n.f1778a, this.f812k, Constants.m836a(t));
        m827a((C0235f) tVar);
        m826a(local, true);
    }

    public void mark(Label label) {
        m824a(label);
        if (label.f841c) {
            throw new IllegalStateException("already marked");
        }
        label.f841c = true;
        if (this.f804c != null) {
            jump(label);
        }
        this.f804c = label;
    }

    public void monitorEnter(Local<?> local) {
        m827a((C0235f) new C0254u(C0251r.f1877bE, this.f809h, C0247n.m1753a(local.mo1167b()), this.f812k));
    }

    public void monitorExit(Local<?> local) {
        m827a((C0235f) new C0254u(C0251r.f1877bE, this.f809h, C0247n.m1753a(local.mo1167b()), this.f812k));
    }

    public <T> void move(Local<T> local, Local<T> local2) {
        m827a((C0235f) new C0242k(C0251r.m1783a((C0284d) local2.f846a.f858b), this.f809h, local.mo1167b(), local2.mo1167b()));
    }

    public <T> void newArray(Local<T> local, Local<Integer> local2) {
        C0253t tVar = new C0253t(C0251r.m1814m((C0284d) local.f846a.f858b), this.f809h, C0247n.m1753a(local2.mo1167b()), this.f812k, local.f846a.f859c);
        m827a((C0235f) tVar);
        m826a(local, true);
    }

    public <T> void newInstance(Local<T> local, MethodId<T, Void> methodId, Local<?>... localArr) {
        if (local == null) {
            throw new IllegalArgumentException();
        }
        C0253t tVar = new C0253t(C0251r.f1897bY, this.f809h, C0247n.f1778a, this.f812k, methodId.f850a.f859c);
        m827a((C0235f) tVar);
        m826a(local, true);
        invokeDirect(methodId, null, local, localArr);
    }

    public <T> Local<T> newLocal(TypeId<T> typeId) {
        if (this.f805d) {
            throw new IllegalStateException("Cannot allocate locals after adding instructions");
        }
        Local<T> a = Local.m860a(this, typeId);
        this.f808g.add(a);
        return a;
    }

    /* renamed from: op */
    public <T1, T2> void mo1136op(BinaryOp binaryOp, Local<T1> local, Local<T1> local2, Local<T2> local3) {
        C0249p rop = binaryOp.rop(C0282b.m1956a(local2.f846a.f858b, local3.f846a.f858b));
        C0247n a = C0247n.m1754a(local2.mo1167b(), local3.mo1167b());
        if (rop.mo1629b() == 1) {
            m827a((C0235f) new C0242k(rop, this.f809h, local.mo1167b(), a));
            return;
        }
        m827a((C0235f) new C0254u(rop, this.f809h, a, this.f812k));
        m826a(local, true);
    }

    /* renamed from: op */
    public <T> void mo1137op(UnaryOp unaryOp, Local<T> local, Local<T> local2) {
        m827a((C0235f) new C0242k(unaryOp.rop(local2.f846a), this.f809h, local.mo1167b(), local2.mo1167b()));
    }

    public Label removeCatchClause(TypeId<? extends Throwable> typeId) {
        int indexOf = this.f810i.indexOf(typeId);
        if (indexOf == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("No catch clause: ");
            sb.append(typeId);
            throw new IllegalArgumentException(sb.toString());
        }
        this.f810i.remove(indexOf);
        this.f812k = m823a(this.f810i);
        return (Label) this.f811j.remove(indexOf);
    }

    public void returnValue(Local<?> local) {
        if (!local.f846a.equals(this.f802a.f851b)) {
            StringBuilder sb = new StringBuilder();
            sb.append("declared ");
            sb.append(this.f802a.f851b);
            sb.append(" but returned ");
            sb.append(local.f846a);
            throw new IllegalArgumentException(sb.toString());
        }
        m827a((C0235f) new C0242k(C0251r.m1808j((C0284d) local.f846a.f858b), this.f809h, (C0244m) null, C0247n.m1753a(local.mo1167b())));
    }

    public void returnVoid() {
        if (!this.f802a.f851b.equals(TypeId.VOID)) {
            StringBuilder sb = new StringBuilder();
            sb.append("declared ");
            sb.append(this.f802a.f851b);
            sb.append(" but returned void");
            throw new IllegalArgumentException(sb.toString());
        }
        m827a((C0235f) new C0242k(C0251r.f1921bw, this.f809h, (C0244m) null, C0247n.f1778a));
    }

    public <V> void sget(FieldId<?, V> fieldId, Local<V> local) {
        C0253t tVar = new C0253t(C0251r.m1820p((C0284d) local.f846a.f858b), this.f809h, C0247n.f1778a, this.f812k, fieldId.f838e);
        m827a((C0235f) tVar);
        m826a(local, true);
    }

    public <V> void sput(FieldId<?, V> fieldId, Local<V> local) {
        C0253t tVar = new C0253t(C0251r.m1822q((C0284d) local.f846a.f858b), this.f809h, C0247n.m1753a(local.mo1167b()), this.f812k, fieldId.f838e);
        m827a((C0235f) tVar);
    }

    public void throwValue(Local<? extends Throwable> local) {
        m827a((C0235f) new C0254u(C0251r.f1876bD, this.f809h, C0247n.m1753a(local.mo1167b()), this.f812k));
    }
}
