package bsh;

import java.io.Serializable;

public class Variable implements Serializable {

    /* renamed from: a */
    String f711a;

    /* renamed from: b */
    Class f712b;

    /* renamed from: c */
    String f713c;

    /* renamed from: d */
    Object f714d;

    /* renamed from: e */
    Modifiers f715e;

    /* renamed from: f */
    LHS f716f;

    Variable(String str, Class cls, LHS lhs) {
        this.f712b = null;
        this.f711a = str;
        this.f716f = lhs;
        this.f712b = cls;
    }

    Variable(String str, Class cls, Object obj, Modifiers modifiers) {
        this.f712b = null;
        this.f711a = str;
        this.f712b = cls;
        this.f715e = modifiers;
        setValue(obj, 0);
    }

    Variable(String str, Object obj, Modifiers modifiers) {
        this(str, (Class) null, obj, modifiers);
    }

    Variable(String str, String str2, Object obj, Modifiers modifiers) {
        this(str, (Class) null, obj, modifiers);
        this.f713c = str2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo1035a() {
        return this.f716f != null ? this.f716f.getValue() : this.f714d;
    }

    public Modifiers getModifiers() {
        return this.f715e;
    }

    public String getName() {
        return this.f711a;
    }

    public Class getType() {
        return this.f712b;
    }

    public String getTypeDescriptor() {
        return this.f713c;
    }

    public boolean hasModifier(String str) {
        return this.f715e != null && this.f715e.hasModifier(str);
    }

    public void setValue(Object obj, int i) {
        if (!hasModifier("final") || this.f714d == null) {
            if (obj == null) {
                obj = Primitive.getDefaultValue(this.f712b);
            }
            int i2 = 0;
            if (this.f716f != null) {
                this.f716f.assign(obj, false);
                return;
            }
            if (this.f712b != null) {
                Class cls = this.f712b;
                if (i != 0) {
                    i2 = 1;
                }
                obj = Types.castObject(obj, cls, i2);
            }
            this.f714d = obj;
            return;
        }
        throw new UtilEvalError("Final variable, can't re-assign.");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Variable: ");
        stringBuffer.append(super.toString());
        stringBuffer.append(" ");
        stringBuffer.append(this.f711a);
        stringBuffer.append(", type:");
        stringBuffer.append(this.f712b);
        stringBuffer.append(", value:");
        stringBuffer.append(this.f714d);
        stringBuffer.append(", lhs = ");
        stringBuffer.append(this.f716f);
        return stringBuffer.toString();
    }
}
