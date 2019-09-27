package bsh;

class BSHLiteral extends SimpleNode {
    public Object value;

    BSHLiteral(int i) {
        super(i);
    }

    /* renamed from: a */
    private char m271a(char c) {
        if (c == 'b') {
            return 8;
        }
        if (c == 'f') {
            return 12;
        }
        if (c == 'n') {
            return 10;
        }
        if (c == 'r') {
            return 13;
        }
        if (c != 't') {
            return c;
        }
        return 9;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo621a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i++;
                char charAt2 = str.charAt(i);
                if (Character.isDigit(charAt2)) {
                    int i2 = i;
                    while (i2 < i + 2) {
                        int i3 = i2 + 1;
                        if (!Character.isDigit(str.charAt(i3))) {
                            break;
                        }
                        i2 = i3;
                    }
                    int i4 = i2;
                    charAt = (char) Integer.parseInt(str.substring(i, i2 + 1), 8);
                    i = i4;
                } else {
                    charAt = m271a(charAt2);
                }
            }
            stringBuffer.append(charAt);
            i++;
        }
        this.value = stringBuffer.toString().intern();
    }

    public void charSetup(String str) {
        char charAt = str.charAt(0);
        if (charAt == '\\') {
            char charAt2 = str.charAt(1);
            charAt = Character.isDigit(charAt2) ? (char) Integer.parseInt(str.substring(1), 8) : m271a(charAt2);
        }
        this.value = new Primitive(new Character(charAt).charValue());
    }

    public Object eval(CallStack callStack, Interpreter interpreter) {
        if (this.value != null) {
            return this.value;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Null in bsh literal: ");
        stringBuffer.append(this.value);
        throw new InterpreterError(stringBuffer.toString());
    }
}
