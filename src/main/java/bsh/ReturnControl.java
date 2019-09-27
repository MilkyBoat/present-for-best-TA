package bsh;

class ReturnControl implements ParserConstants {
    public int kind;
    public SimpleNode returnPoint;
    public Object value;

    public ReturnControl(int i, Object obj, SimpleNode simpleNode) {
        this.kind = i;
        this.value = obj;
        this.returnPoint = simpleNode;
    }
}
