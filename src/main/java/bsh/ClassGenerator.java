package bsh;

import bsh.Capabilities.Unavailable;

public abstract class ClassGenerator {

    /* renamed from: a */
    private static ClassGenerator f525a;

    public static ClassGenerator getClassGenerator() {
        if (f525a == null) {
            try {
                f525a = (ClassGenerator) Class.forName("bsh.ClassGeneratorImpl").newInstance();
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("ClassGenerator unavailable: ");
                stringBuffer.append(e);
                throw new Unavailable(stringBuffer.toString());
            }
        }
        return f525a;
    }

    public abstract Class generateClass(String str, Modifiers modifiers, Class[] clsArr, Class cls, BSHBlock bSHBlock, boolean z, CallStack callStack, Interpreter interpreter);

    public abstract Object invokeSuperclassMethod(BshClassManager bshClassManager, Object obj, String str, Object[] objArr);

    public abstract void setInstanceNameSpaceParent(Object obj, String str, NameSpace nameSpace);
}
