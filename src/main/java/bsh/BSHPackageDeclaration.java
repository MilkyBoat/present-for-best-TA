package bsh;

public class BSHPackageDeclaration extends SimpleNode {
    public BSHPackageDeclaration(int i) {
        super(i);
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) jjtGetChild(0);
        NameSpace pVar = callStack.top();
        pVar.mo863c(bSHAmbiguousName.text);
        pVar.importPackage(bSHAmbiguousName.text);
        return Primitive.VOID;
    }
}
