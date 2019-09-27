package bsh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class ExternalNameSpace extends NameSpace {

    /* renamed from: h */
    private Map f564h;

    public ExternalNameSpace() {
        this(null, "External Map Namespace", null);
    }

    public ExternalNameSpace(NameSpace nameSpace, String str, Map map) {
        super(nameSpace, str);
        if (map == null) {
            map = new HashMap();
        }
        this.f564h = map;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Variable mo755a(String str, boolean z) {
        Object obj = this.f564h.get(str);
        if (obj == null) {
            super.unsetVariable(str);
            return super.mo755a(str, z);
        }
        Variable a = super.mo755a(str, false);
        if (a == null) {
            a = new Variable(str, (Class) null, obj, (Modifiers) null);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo756a(String str, Object obj) {
        if (obj instanceof Variable) {
            try {
                obj = mo853a((Variable) obj);
            } catch (UtilEvalError unused) {
                throw new InterpreterError("unexpected UtilEvalError");
            }
        }
        if (obj instanceof Primitive) {
            obj = Primitive.unwrap((Object) (Primitive) obj);
        }
        this.f564h.put(str, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo757a(Vector vector) {
        super.mo757a(vector);
    }

    public void clear() {
        super.clear();
        this.f564h.clear();
    }

    public Variable[] getDeclaredVariables() {
        return super.getDeclaredVariables();
    }

    public Map getMap() {
        return this.f564h;
    }

    public BshMethod getMethod(String str, Class[] clsArr, boolean z) {
        return super.getMethod(str, clsArr, z);
    }

    public String[] getVariableNames() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(super.getVariableNames()));
        hashSet.addAll(this.f564h.keySet());
        return (String[]) hashSet.toArray(new String[0]);
    }

    public void setMap(Map map) {
        this.f564h = null;
        clear();
        this.f564h = map;
    }

    public void setMethod(String str, BshMethod bshMethod) {
        super.setMethod(str, bshMethod);
    }

    public void setTypedVariable(String str, Class cls, Object obj, Modifiers modifiers) {
        super.setTypedVariable(str, cls, obj, modifiers);
        mo756a(str, obj);
    }

    /* access modifiers changed from: 0000 */
    public void setVariable(String str, Object obj, boolean z, boolean z2) {
        super.setVariable(str, obj, z, z2);
        mo756a(str, obj);
    }

    public void unsetVariable(String str) {
        super.unsetVariable(str);
        this.f564h.remove(str);
    }
}
