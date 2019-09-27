package bsh.org.objectweb.asm;

public interface ClassVisitor {
    void visit(int i, String str, String str2, String[] strArr, String str3);

    void visitEnd();

    void visitField(int i, String str, String str2, Object obj);

    void visitInnerClass(String str, String str2, String str3, int i);

    CodeVisitor visitMethod(int i, String str, String str2, String[] strArr);
}
