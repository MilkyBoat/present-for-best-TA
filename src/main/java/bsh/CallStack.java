package bsh;

import java.util.Vector;

public class CallStack {

    /* renamed from: a */
    private Vector f521a = new Vector(2);

    public CallStack() {
    }

    public CallStack(NameSpace nameSpace) {
        push(nameSpace);
    }

    public void clear() {
        this.f521a.removeAllElements();
    }

    public CallStack copy() {
        CallStack callStack = new CallStack();
        callStack.f521a = (Vector) this.f521a.clone();
        return callStack;
    }

    public int depth() {
        return this.f521a.size();
    }

    public NameSpace get(int i) {
        return i >= depth() ? NameSpace.JAVACODE : (NameSpace) this.f521a.elementAt(i);
    }

    public NameSpace pop() {
        if (depth() < 1) {
            throw new InterpreterError("pop on empty CallStack");
        }
        NameSpace pVar = top();
        this.f521a.removeElementAt(0);
        return pVar;
    }

    public void push(NameSpace nameSpace) {
        this.f521a.insertElementAt(nameSpace, 0);
    }

    public void set(int i, NameSpace nameSpace) {
        this.f521a.setElementAt(nameSpace, i);
    }

    public NameSpace swap(NameSpace nameSpace) {
        NameSpace nameSpace2 = (NameSpace) this.f521a.elementAt(0);
        this.f521a.setElementAt(nameSpace, 0);
        return nameSpace2;
    }

    public NameSpace[] toArray() {
        NameSpace[] nameSpaceArr = new NameSpace[depth()];
        this.f521a.copyInto(nameSpaceArr);
        return nameSpaceArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallStack:\n");
        NameSpace[] array = toArray();
        for (NameSpace append : array) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("\t");
            stringBuffer2.append(append);
            stringBuffer2.append("\n");
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }

    public NameSpace top() {
        return get(0);
    }
}
