package bsh;

class BlockNameSpace extends NameSpace {
    public BlockNameSpace(NameSpace nameSpace) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(nameSpace.getName());
        stringBuffer.append("/BlockNameSpace");
        super(nameSpace, stringBuffer.toString());
    }

    /* renamed from: d */
    private NameSpace m293d() {
        NameSpace parent = super.getParent();
        return parent instanceof BlockNameSpace ? ((BlockNameSpace) parent).m293d() : parent;
    }

    /* renamed from: d */
    private boolean m294d(String str) {
        try {
            return super.mo755a(str, false) != null;
        } catch (UtilEvalError unused) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public This mo645a(Interpreter interpreter) {
        return m293d().mo645a(interpreter);
    }

    public This getSuper(Interpreter interpreter) {
        return m293d().getSuper(interpreter);
    }

    public void importClass(String str) {
        getParent().importClass(str);
    }

    public void importPackage(String str) {
        getParent().importPackage(str);
    }

    public void setBlockVariable(String str, Object obj) {
        super.setVariable(str, obj, false, false);
    }

    public void setMethod(String str, BshMethod bshMethod) {
        getParent().setMethod(str, bshMethod);
    }

    public void setVariable(String str, Object obj, boolean z, boolean z2) {
        if (m294d(str)) {
            super.setVariable(str, obj, z, false);
        } else {
            getParent().setVariable(str, obj, z, z2);
        }
    }
}
