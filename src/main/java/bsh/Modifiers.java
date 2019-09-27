package bsh;

import java.io.Serializable;
import java.util.Hashtable;

public class Modifiers implements Serializable {
    public static final int CLASS = 0;
    public static final int FIELD = 2;
    public static final int METHOD = 1;

    /* renamed from: a */
    Hashtable f610a;

    /* renamed from: a */
    private void m366a() {
        m367a("volatile", "Method");
        m367a("transient", "Method");
    }

    /* renamed from: a */
    private void m367a(String str, String str2) {
        if (hasModifier(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(" cannot be declared '");
            stringBuffer.append(str);
            stringBuffer.append("'");
            throw new IllegalStateException(stringBuffer.toString());
        }
    }

    /* renamed from: b */
    private void m368b() {
        m367a("synchronized", "Variable");
        m367a("native", "Variable");
        m367a("abstract", "Variable");
    }

    /* renamed from: c */
    private void m369c() {
        m366a();
        m367a("native", "Class");
        m367a("synchronized", "Class");
    }

    public void addModifier(int i, String str) {
        if (this.f610a == null) {
            this.f610a = new Hashtable();
        }
        if (this.f610a.put(str, Void.TYPE) != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Duplicate modifier: ");
            stringBuffer.append(str);
            throw new IllegalStateException(stringBuffer.toString());
        }
        int i2 = 0;
        if (hasModifier("private")) {
            i2 = 1;
        }
        if (hasModifier("protected")) {
            i2++;
        }
        if (hasModifier("public")) {
            i2++;
        }
        if (i2 > 1) {
            throw new IllegalStateException("public/private/protected cannot be used in combination.");
        }
        switch (i) {
            case 0:
                m369c();
                return;
            case 1:
                m366a();
                return;
            case 2:
                m368b();
                return;
            default:
                return;
        }
    }

    public boolean hasModifier(String str) {
        if (this.f610a == null) {
            this.f610a = new Hashtable();
        }
        return this.f610a.get(str) != null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Modifiers: ");
        stringBuffer.append(this.f610a);
        return stringBuffer.toString();
    }
}
