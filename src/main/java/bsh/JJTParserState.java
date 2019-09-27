package bsh;

import java.util.Stack;

class JJTParserState {

    /* renamed from: a */
    private Stack f582a = new Stack();

    /* renamed from: b */
    private Stack f583b = new Stack();

    /* renamed from: c */
    private int f584c = 0;

    /* renamed from: d */
    private int f585d = 0;

    /* renamed from: e */
    private boolean f586e;

    JJTParserState() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo801a() {
        this.f582a.removeAllElements();
        this.f583b.removeAllElements();
        this.f584c = 0;
        this.f585d = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo802a(Node node) {
        this.f582a.push(node);
        this.f584c++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo803a(Node node, int i) {
        this.f585d = ((Integer) this.f583b.pop()).intValue();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                node.jjtClose();
                mo802a(node);
                this.f586e = true;
                return;
            }
            Node c = mo807c();
            c.jjtSetParent(node);
            node.jjtAddChild(c, i2);
            i = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo804a(Node node, boolean z) {
        boolean z2;
        if (z) {
            int d = mo809d();
            this.f585d = ((Integer) this.f583b.pop()).intValue();
            while (true) {
                int i = d - 1;
                if (d <= 0) {
                    break;
                }
                Node c = mo807c();
                c.jjtSetParent(node);
                node.jjtAddChild(c, i);
                d = i;
            }
            node.jjtClose();
            mo802a(node);
            z2 = true;
        } else {
            this.f585d = ((Integer) this.f583b.pop()).intValue();
            z2 = false;
        }
        this.f586e = z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Node mo805b() {
        return (Node) this.f582a.elementAt(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo806b(Node node) {
        while (this.f584c > this.f585d) {
            mo807c();
        }
        this.f585d = ((Integer) this.f583b.pop()).intValue();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Node mo807c() {
        int i = this.f584c - 1;
        this.f584c = i;
        if (i < this.f585d) {
            this.f585d = ((Integer) this.f583b.pop()).intValue();
        }
        return (Node) this.f582a.pop();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo808c(Node node) {
        this.f583b.push(new Integer(this.f585d));
        this.f585d = this.f584c;
        node.jjtOpen();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo809d() {
        return this.f584c - this.f585d;
    }
}
