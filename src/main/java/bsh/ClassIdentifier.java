package bsh;

public class ClassIdentifier {

    /* renamed from: a */
    Class f547a;

    public ClassIdentifier(Class cls) {
        this.f547a = cls;
    }

    public Class getTargetClass() {
        return this.f547a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Class Identifier: ");
        stringBuffer.append(this.f547a.getName());
        return stringBuffer.toString();
    }
}
