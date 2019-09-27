package bsh;

class BSHPrimitiveType extends SimpleNode {
    public Class type;

    BSHPrimitiveType(int i) {
        super(i);
    }

    public Class getType() {
        return this.type;
    }
}
