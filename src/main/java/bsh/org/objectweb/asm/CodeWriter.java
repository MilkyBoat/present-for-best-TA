package bsh.org.objectweb.asm;

public class CodeWriter implements CodeVisitor {

    /* renamed from: w */
    private static final int[] f744w;

    /* renamed from: z */
    private static Edge f745z;

    /* renamed from: a */
    CodeWriter f746a;

    /* renamed from: b */
    private ClassWriter f747b;

    /* renamed from: c */
    private Item f748c;

    /* renamed from: d */
    private Item f749d;

    /* renamed from: e */
    private int f750e;

    /* renamed from: f */
    private int f751f;

    /* renamed from: g */
    private int f752g;

    /* renamed from: h */
    private ByteVector f753h = new ByteVector();

    /* renamed from: i */
    private int f754i;

    /* renamed from: j */
    private ByteVector f755j;

    /* renamed from: k */
    private int f756k;

    /* renamed from: l */
    private int[] f757l;

    /* renamed from: m */
    private int f758m;

    /* renamed from: n */
    private ByteVector f759n;

    /* renamed from: o */
    private int f760o;

    /* renamed from: p */
    private ByteVector f761p;

    /* renamed from: q */
    private boolean f762q;

    /* renamed from: r */
    private final boolean f763r;

    /* renamed from: s */
    private int f764s;

    /* renamed from: t */
    private int f765t;

    /* renamed from: u */
    private Label f766u;

    /* renamed from: v */
    private Label f767v;

    /* renamed from: x */
    private Edge f768x;

    /* renamed from: y */
    private Edge f769y;

    static {
        int[] iArr = new int[202];
        String str = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE";
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = str.charAt(i) - 'E';
        }
        f744w = iArr;
    }

    protected CodeWriter(ClassWriter classWriter, boolean z) {
        if (classWriter.f724a == null) {
            classWriter.f724a = this;
        } else {
            classWriter.f725b.f746a = this;
        }
        classWriter.f725b = this;
        this.f747b = classWriter;
        this.f763r = z;
        if (z) {
            this.f766u = new Label();
            this.f766u.f791g = true;
            this.f767v = this.f766u;
        }
    }

    /* renamed from: a */
    private static int m783a(String str) {
        int i;
        char charAt;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 == ')') {
                break;
            } else if (charAt2 == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else if (charAt2 == '[') {
                i3 = i;
                while (true) {
                    charAt = str.charAt(i3);
                    if (charAt != '[') {
                        break;
                    }
                    i3++;
                }
                if (charAt == 'D' || charAt == 'J') {
                    i4--;
                }
            } else {
                i4 = (charAt2 == 'D' || charAt2 == 'J') ? i4 + 2 : i4 + 1;
                i3 = i;
            }
        }
        char charAt3 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt3 == 'V') {
            i2 = 0;
        } else if (charAt3 == 'D' || charAt3 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
    }

    /* renamed from: a */
    static int m784a(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* renamed from: a */
    static int m785a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = i2 - i;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i < iArr[i4] && iArr[i4] <= i2) {
                i3 += iArr2[i4];
            } else if (i2 < iArr[i4] && iArr[i4] <= i) {
                i3 -= iArr2[i4];
            }
        }
        return i3;
    }

    /* renamed from: a */
    private void m786a(int i, Label label) {
        Edge edge;
        synchronized (f744w) {
            if (f745z == null) {
                edge = new Edge();
            } else {
                edge = f745z;
                f745z = f745z.f773d;
            }
        }
        if (this.f769y == null) {
            this.f769y = edge;
        }
        edge.f773d = this.f768x;
        this.f768x = edge;
        edge.f770a = i;
        edge.f771b = label;
        edge.f772c = this.f766u.f789e;
        this.f766u.f789e = edge;
    }

    /* renamed from: a */
    static void m787a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >>> 8);
        bArr[i + 1] = (byte) i2;
    }

    /* renamed from: b */
    static short m788b(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* renamed from: c */
    static int m789c(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo1082a() {
        int i;
        if (this.f762q) {
            mo1085a(new int[0], new int[0], 0);
        }
        if (this.f753h.f722b > 0) {
            this.f747b.mo1059a("Code");
            i = this.f753h.f722b + 18 + (this.f754i * 8) + 8;
            if (this.f759n != null) {
                i += this.f759n.f722b + 8;
            }
            if (this.f761p != null) {
                i += this.f761p.f722b + 8;
            }
        } else {
            i = 8;
        }
        if (this.f756k > 0) {
            this.f747b.mo1059a("Exceptions");
            i += (this.f756k * 2) + 8;
        }
        if ((this.f750e & Constants.ACC_SYNTHETIC) != 0) {
            this.f747b.mo1059a("Synthetic");
            i += 6;
        }
        if ((this.f750e & Constants.ACC_DEPRECATED) == 0) {
            return i;
        }
        this.f747b.mo1059a("Deprecated");
        return i + 6;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1083a(int i, String str, String str2, String[] strArr) {
        this.f750e = i;
        this.f748c = this.f747b.mo1059a(str);
        this.f749d = this.f747b.mo1059a(str2);
        if (strArr != null && strArr.length > 0) {
            this.f756k = strArr.length;
            this.f757l = new int[this.f756k];
            for (int i2 = 0; i2 < this.f756k; i2++) {
                this.f757l[i2] = this.f747b.mo1061b(strArr[i2]).f774a;
            }
        }
        if (this.f763r) {
            int a = m783a(str2) >> 2;
            if ((i & 8) != 0) {
                a--;
            }
            if (a > this.f752g) {
                this.f752g = a;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo1084a(ByteVector byteVector) {
        byteVector.put2(this.f750e).put2(this.f748c.f774a).put2(this.f749d.f774a);
        int i = 1;
        int i2 = this.f753h.f722b > 0 ? 1 : 0;
        if (this.f756k > 0) {
            i2++;
        }
        if ((this.f750e & Constants.ACC_SYNTHETIC) != 0) {
            i2++;
        }
        if ((this.f750e & Constants.ACC_DEPRECATED) != 0) {
            i2++;
        }
        byteVector.put2(i2);
        if (this.f753h.f722b > 0) {
            int i3 = this.f753h.f722b + 12 + (this.f754i * 8);
            if (this.f759n != null) {
                i3 += this.f759n.f722b + 8;
            }
            if (this.f761p != null) {
                i3 += this.f761p.f722b + 8;
            }
            byteVector.put2(this.f747b.mo1059a("Code").f774a).put4(i3);
            byteVector.put2(this.f751f).put2(this.f752g);
            byteVector.put4(this.f753h.f722b).putByteArray(this.f753h.f721a, 0, this.f753h.f722b);
            byteVector.put2(this.f754i);
            if (this.f754i > 0) {
                byteVector.putByteArray(this.f755j.f721a, 0, this.f755j.f722b);
            }
            if (this.f759n == null) {
                i = 0;
            }
            if (this.f761p != null) {
                i++;
            }
            byteVector.put2(i);
            if (this.f759n != null) {
                byteVector.put2(this.f747b.mo1059a("LocalVariableTable").f774a);
                byteVector.put4(this.f759n.f722b + 2).put2(this.f758m);
                byteVector.putByteArray(this.f759n.f721a, 0, this.f759n.f722b);
            }
            if (this.f761p != null) {
                byteVector.put2(this.f747b.mo1059a("LineNumberTable").f774a);
                byteVector.put4(this.f761p.f722b + 2).put2(this.f760o);
                byteVector.putByteArray(this.f761p.f721a, 0, this.f761p.f722b);
            }
        }
        if (this.f756k > 0) {
            byteVector.put2(this.f747b.mo1059a("Exceptions").f774a).put4((this.f756k * 2) + 2);
            byteVector.put2(this.f756k);
            for (int i4 = 0; i4 < this.f756k; i4++) {
                byteVector.put2(this.f757l[i4]);
            }
        }
        if ((this.f750e & Constants.ACC_SYNTHETIC) != 0) {
            byteVector.put2(this.f747b.mo1059a("Synthetic").f774a).put4(0);
        }
        if ((this.f750e & Constants.ACC_DEPRECATED) != 0) {
            byteVector.put2(this.f747b.mo1059a("Deprecated").f774a).put4(0);
        }
    }

    /* JADX WARNING: type inference failed for: r5v21, types: [int] */
    /* JADX WARNING: type inference failed for: r5v30 */
    /* JADX WARNING: type inference failed for: r5v31, types: [int] */
    /* JADX WARNING: type inference failed for: r5v32, types: [int] */
    /* JADX WARNING: type inference failed for: r13v19 */
    /* JADX WARNING: type inference failed for: r13v20 */
    /* JADX WARNING: type inference failed for: r13v21, types: [int] */
    /* JADX WARNING: type inference failed for: r13v22, types: [int] */
    /* JADX WARNING: type inference failed for: r5v83 */
    /* JADX WARNING: type inference failed for: r5v84 */
    /* JADX WARNING: type inference failed for: r5v85 */
    /* JADX WARNING: type inference failed for: r13v33 */
    /* JADX WARNING: type inference failed for: r13v34 */
    /* JADX WARNING: type inference failed for: r13v35 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e2, code lost:
        r15 = 132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0211, code lost:
        r13 = r13 + 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0219, code lost:
        r13 = r13 + 3;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v30
  assigns: []
  uses: []
  mth insns count: 336
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] mo1085a(int[] r20, int[] r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            bsh.org.objectweb.asm.ByteVector r4 = r0.f753h
            byte[] r4 = r4.f721a
            int[] r5 = new int[r3]
            int[] r6 = new int[r3]
            r7 = 0
            java.lang.System.arraycopy(r1, r7, r5, r7, r3)
            java.lang.System.arraycopy(r2, r7, r6, r7, r3)
            bsh.org.objectweb.asm.ByteVector r8 = r0.f753h
            int r8 = r8.f722b
            boolean[] r8 = new boolean[r8]
            r9 = 3
            r10 = r6
            r6 = r5
            r5 = 3
        L_0x0021:
            if (r5 != r9) goto L_0x0024
            r5 = 2
        L_0x0024:
            r12 = r10
            r10 = r6
            r6 = r5
            r5 = 0
        L_0x0028:
            int r13 = r4.length
            r15 = 132(0x84, float:1.85E-43)
            r14 = 1
            r11 = 4
            if (r5 < r13) goto L_0x0256
            if (r6 >= r9) goto L_0x0033
            int r6 = r6 + -1
        L_0x0033:
            r5 = r6
            if (r5 != 0) goto L_0x0252
            bsh.org.objectweb.asm.ByteVector r6 = new bsh.org.objectweb.asm.ByteVector
            bsh.org.objectweb.asm.ByteVector r5 = r0.f753h
            int r5 = r5.f722b
            r6.<init>(r5)
            r13 = 0
        L_0x0040:
            bsh.org.objectweb.asm.ByteVector r5 = r0.f753h
            int r5 = r5.f722b
            if (r13 < r5) goto L_0x00cc
            bsh.org.objectweb.asm.ByteVector r2 = r0.f755j
            if (r2 == 0) goto L_0x007e
            bsh.org.objectweb.asm.ByteVector r2 = r0.f755j
            byte[] r2 = r2.f721a
            r3 = 0
        L_0x004f:
            bsh.org.objectweb.asm.ByteVector r4 = r0.f755j
            int r4 = r4.f722b
            if (r3 < r4) goto L_0x0056
            goto L_0x007e
        L_0x0056:
            int r4 = m784a(r2, r3)
            int r4 = m785a(r10, r12, r7, r4)
            m787a(r2, r3, r4)
            int r4 = r3 + 2
            int r5 = m784a(r2, r4)
            int r5 = m785a(r10, r12, r7, r5)
            m787a(r2, r4, r5)
            int r4 = r3 + 4
            int r5 = m784a(r2, r4)
            int r5 = m785a(r10, r12, r7, r5)
            m787a(r2, r4, r5)
            int r3 = r3 + 8
            goto L_0x004f
        L_0x007e:
            bsh.org.objectweb.asm.ByteVector r2 = r0.f759n
            if (r2 == 0) goto L_0x00ab
            bsh.org.objectweb.asm.ByteVector r2 = r0.f759n
            byte[] r2 = r2.f721a
            r3 = 0
        L_0x0087:
            bsh.org.objectweb.asm.ByteVector r4 = r0.f759n
            int r4 = r4.f722b
            if (r3 < r4) goto L_0x008e
            goto L_0x00ab
        L_0x008e:
            int r4 = m784a(r2, r3)
            int r5 = m785a(r10, r12, r7, r4)
            m787a(r2, r3, r5)
            int r8 = r3 + 2
            int r8 = m784a(r2, r8)
            int r4 = r4 + r8
            int r4 = m785a(r10, r12, r7, r4)
            int r4 = r4 - r5
            m787a(r2, r3, r4)
            int r3 = r3 + 10
            goto L_0x0087
        L_0x00ab:
            bsh.org.objectweb.asm.ByteVector r2 = r0.f761p
            if (r2 == 0) goto L_0x00c9
            bsh.org.objectweb.asm.ByteVector r2 = r0.f761p
            byte[] r2 = r2.f721a
            r3 = 0
        L_0x00b4:
            bsh.org.objectweb.asm.ByteVector r4 = r0.f761p
            int r4 = r4.f722b
            if (r3 < r4) goto L_0x00bb
            goto L_0x00c9
        L_0x00bb:
            int r4 = m784a(r2, r3)
            int r4 = m785a(r10, r12, r7, r4)
            m787a(r2, r3, r4)
            int r3 = r3 + 4
            goto L_0x00b4
        L_0x00c9:
            r0.f753h = r6
            return r1
        L_0x00cc:
            int r5 = r10.length
            int r5 = r5 - r14
        L_0x00ce:
            if (r5 >= 0) goto L_0x022f
            byte r5 = r4[r13]
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte[] r8 = bsh.org.objectweb.asm.ClassWriter.f723f
            byte r8 = r8[r5]
            switch(r8) {
                case 0: goto L_0x0226;
                case 1: goto L_0x021d;
                case 2: goto L_0x0215;
                case 3: goto L_0x021d;
                case 4: goto L_0x0226;
                case 5: goto L_0x0215;
                case 6: goto L_0x0215;
                case 7: goto L_0x020d;
                case 8: goto L_0x01ac;
                case 9: goto L_0x019a;
                case 10: goto L_0x021d;
                case 11: goto L_0x0215;
                case 12: goto L_0x0215;
                case 13: goto L_0x0149;
                case 14: goto L_0x00fd;
                case 15: goto L_0x00db;
                case 16: goto L_0x00e6;
                default: goto L_0x00db;
            }
        L_0x00db:
            r8 = 2
            r15 = 5
            r6.putByteArray(r4, r13, r11)
            int r13 = r13 + 4
        L_0x00e2:
            r15 = 132(0x84, float:1.85E-43)
            goto L_0x0040
        L_0x00e6:
            int r5 = r13 + 1
            byte r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r5 != r15) goto L_0x00f6
            r5 = 6
            r6.putByteArray(r4, r13, r5)
            int r13 = r13 + 6
            goto L_0x0040
        L_0x00f6:
            r6.putByteArray(r4, r13, r11)
            int r13 = r13 + 4
            goto L_0x0040
        L_0x00fd:
            int r5 = r13 + 4
            r8 = r13 & 3
            int r5 = r5 - r8
            int r8 = r6.f722b
            r8 = 171(0xab, float:2.4E-43)
            r6.put1(r8)
        L_0x0109:
            int r8 = r6.f722b
            int r8 = r8 % r11
            if (r8 != 0) goto L_0x0143
            int r8 = m789c(r4, r5)
            int r8 = r8 + r13
            int r5 = r5 + r11
            int r8 = m785a(r10, r12, r13, r8)
            r6.put4(r8)
            int r8 = m789c(r4, r5)
            int r5 = r5 + r11
            r6.put4(r8)
        L_0x0123:
            if (r8 > 0) goto L_0x0128
            r13 = r5
            goto L_0x0040
        L_0x0128:
            int r15 = m789c(r4, r5)
            r6.put4(r15)
            int r5 = r5 + 4
            int r15 = m789c(r4, r5)
            int r15 = r15 + r13
            int r5 = r5 + r11
            int r15 = m785a(r10, r12, r13, r15)
            r6.put4(r15)
            int r8 = r8 + -1
            r15 = 132(0x84, float:1.85E-43)
            goto L_0x0123
        L_0x0143:
            r6.put1(r7)
            r15 = 132(0x84, float:1.85E-43)
            goto L_0x0109
        L_0x0149:
            int r5 = r13 + 4
            r8 = r13 & 3
            int r8 = r5 - r8
            int r5 = r6.f722b
            r5 = 170(0xaa, float:2.38E-43)
            r6.put1(r5)
        L_0x0156:
            int r5 = r6.f722b
            int r5 = r5 % r11
            if (r5 != 0) goto L_0x0196
            int r5 = m789c(r4, r8)
            int r5 = r5 + r13
            int r8 = r8 + r11
            int r5 = m785a(r10, r12, r13, r5)
            r6.put4(r5)
            int r5 = m789c(r4, r8)
            int r8 = r8 + r11
            r6.put4(r5)
            int r15 = m789c(r4, r8)
            int r15 = r15 - r5
            int r15 = r15 + r14
            int r8 = r8 + r11
            int r5 = r8 + -4
            int r5 = m789c(r4, r5)
            r6.put4(r5)
        L_0x0180:
            if (r15 > 0) goto L_0x0185
            r13 = r8
            goto L_0x00e2
        L_0x0185:
            int r5 = m789c(r4, r8)
            int r5 = r5 + r13
            int r8 = r8 + 4
            int r5 = m785a(r10, r12, r13, r5)
            r6.put4(r5)
            int r15 = r15 + -1
            goto L_0x0180
        L_0x0196:
            r6.put1(r7)
            goto L_0x0156
        L_0x019a:
            int r8 = r13 + 1
            int r8 = m789c(r4, r8)
            int r8 = r8 + r13
            int r8 = m785a(r10, r12, r13, r8)
            r6.put1(r5)
            r6.put4(r8)
            goto L_0x0211
        L_0x01ac:
            r8 = 201(0xc9, float:2.82E-43)
            if (r5 <= r8) goto L_0x01c0
            r8 = 218(0xda, float:3.05E-43)
            if (r5 >= r8) goto L_0x01b7
            int r5 = r5 + -49
            goto L_0x01b9
        L_0x01b7:
            int r5 = r5 + -20
        L_0x01b9:
            int r8 = r13 + 1
            int r8 = m784a(r4, r8)
            goto L_0x01c6
        L_0x01c0:
            int r8 = r13 + 1
            short r8 = m788b(r4, r8)
        L_0x01c6:
            int r8 = r8 + r13
            int r8 = m785a(r10, r12, r13, r8)
            r15 = -32768(0xffffffffffff8000, float:NaN)
            if (r8 < r15) goto L_0x01db
            r15 = 32767(0x7fff, float:4.5916E-41)
            if (r8 <= r15) goto L_0x01d4
            goto L_0x01db
        L_0x01d4:
            r6.put1(r5)
            r6.put2(r8)
            goto L_0x0219
        L_0x01db:
            r15 = 167(0xa7, float:2.34E-43)
            if (r5 != r15) goto L_0x01e5
            r5 = 200(0xc8, float:2.8E-43)
            r6.put1(r5)
            goto L_0x0209
        L_0x01e5:
            r15 = 168(0xa8, float:2.35E-43)
            if (r5 != r15) goto L_0x01ef
            r15 = 201(0xc9, float:2.82E-43)
            r6.put1(r15)
            goto L_0x0209
        L_0x01ef:
            r15 = 166(0xa6, float:2.33E-43)
            if (r5 > r15) goto L_0x01f8
            int r5 = r5 + 1
            r5 = r5 ^ r14
            int r5 = r5 - r14
            goto L_0x01fa
        L_0x01f8:
            r5 = r5 ^ 1
        L_0x01fa:
            r6.put1(r5)
            r5 = 8
            r6.put2(r5)
            r5 = 200(0xc8, float:2.8E-43)
            r6.put1(r5)
            int r8 = r8 + -3
        L_0x0209:
            r6.put4(r8)
            goto L_0x0219
        L_0x020d:
            r15 = 5
            r6.putByteArray(r4, r13, r15)
        L_0x0211:
            int r13 = r13 + 5
            goto L_0x00e2
        L_0x0215:
            r15 = 5
            r6.putByteArray(r4, r13, r9)
        L_0x0219:
            int r13 = r13 + 3
            goto L_0x00e2
        L_0x021d:
            r8 = 2
            r15 = 5
            r6.putByteArray(r4, r13, r8)
            int r13 = r13 + 2
            goto L_0x00e2
        L_0x0226:
            r8 = 2
            r15 = 5
            r6.put1(r5)
            int r13 = r13 + 1
            goto L_0x00e2
        L_0x022f:
            r15 = 5
            r8 = r10[r5]
            if (r8 != r13) goto L_0x024c
            if (r5 >= r3) goto L_0x024c
            r8 = r2[r5]
            if (r8 <= 0) goto L_0x0241
            r8 = 0
            r15 = r2[r5]
            r6.putByteArray(r8, r7, r15)
            goto L_0x0248
        L_0x0241:
            int r8 = r6.f722b
            r15 = r2[r5]
            int r8 = r8 + r15
            r6.f722b = r8
        L_0x0248:
            int r8 = r6.f722b
            r1[r5] = r8
        L_0x024c:
            int r5 = r5 + -1
            r15 = 132(0x84, float:1.85E-43)
            goto L_0x00ce
        L_0x0252:
            r6 = r10
            r10 = r12
            goto L_0x0021
        L_0x0256:
            r15 = 2
            byte r13 = r4[r5]
            r13 = r13 & 255(0xff, float:3.57E-43)
            byte[] r16 = bsh.org.objectweb.asm.ClassWriter.f723f
            byte r16 = r16[r13]
            switch(r16) {
                case 0: goto L_0x031c;
                case 1: goto L_0x0318;
                case 2: goto L_0x0314;
                case 3: goto L_0x0318;
                case 4: goto L_0x031c;
                case 5: goto L_0x0314;
                case 6: goto L_0x0314;
                case 7: goto L_0x0310;
                case 8: goto L_0x02cd;
                case 9: goto L_0x0310;
                case 10: goto L_0x0318;
                case 11: goto L_0x0314;
                case 12: goto L_0x0314;
                case 13: goto L_0x029c;
                case 14: goto L_0x0274;
                case 15: goto L_0x0262;
                case 16: goto L_0x0267;
                default: goto L_0x0262;
            }
        L_0x0262:
            int r5 = r5 + 4
        L_0x0264:
            r11 = 0
            goto L_0x0320
        L_0x0267:
            int r11 = r5 + 1
            byte r11 = r4[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r13 = 132(0x84, float:1.85E-43)
            if (r11 != r13) goto L_0x0262
            int r5 = r5 + 6
            goto L_0x0264
        L_0x0274:
            if (r6 != r14) goto L_0x027d
            int r11 = m785a(r10, r12, r7, r5)
            r11 = r11 & r9
            int r11 = -r11
            goto L_0x0287
        L_0x027d:
            boolean r11 = r8[r5]
            if (r11 != 0) goto L_0x0286
            r11 = r5 & 3
            r8[r5] = r14
            goto L_0x0287
        L_0x0286:
            r11 = 0
        L_0x0287:
            int r13 = r5 + 4
            r5 = r5 & 3
            int r13 = r13 - r5
            int r5 = r13 + 4
            int r5 = m789c(r4, r5)
            r16 = 8
            int r5 = r5 * 8
            int r5 = r5 + 8
            int r13 = r13 + r5
            r5 = r13
            goto L_0x0320
        L_0x029c:
            if (r6 != r14) goto L_0x02a5
            int r13 = m785a(r10, r12, r7, r5)
            r13 = r13 & r9
            int r13 = -r13
            goto L_0x02af
        L_0x02a5:
            boolean r13 = r8[r5]
            if (r13 != 0) goto L_0x02ae
            r13 = r5 & 3
            r8[r5] = r14
            goto L_0x02af
        L_0x02ae:
            r13 = 0
        L_0x02af:
            int r16 = r5 + 4
            r5 = r5 & 3
            int r16 = r16 - r5
            int r5 = r16 + 8
            int r5 = m789c(r4, r5)
            int r9 = r16 + 4
            int r9 = m789c(r4, r9)
            int r5 = r5 - r9
            int r5 = r5 + r14
            int r5 = r5 * 4
            int r5 = r5 + 12
            int r16 = r16 + r5
            r11 = r13
            r5 = r16
            goto L_0x0320
        L_0x02cd:
            r9 = 201(0xc9, float:2.82E-43)
            if (r13 <= r9) goto L_0x02e1
            r9 = 218(0xda, float:3.05E-43)
            if (r13 >= r9) goto L_0x02d8
            int r13 = r13 + -49
            goto L_0x02da
        L_0x02d8:
            int r13 = r13 + -20
        L_0x02da:
            int r9 = r5 + 1
            int r9 = m784a(r4, r9)
            goto L_0x02e7
        L_0x02e1:
            int r9 = r5 + 1
            short r9 = m788b(r4, r9)
        L_0x02e7:
            int r9 = r9 + r5
            int r9 = m785a(r10, r12, r5, r9)
            r11 = -32768(0xffffffffffff8000, float:NaN)
            if (r9 < r11) goto L_0x02f4
            r11 = 32767(0x7fff, float:4.5916E-41)
            if (r9 <= r11) goto L_0x0309
        L_0x02f4:
            boolean r9 = r8[r5]
            if (r9 != 0) goto L_0x0309
            r9 = 167(0xa7, float:2.34E-43)
            if (r13 == r9) goto L_0x0304
            r9 = 168(0xa8, float:2.35E-43)
            if (r13 != r9) goto L_0x0301
            goto L_0x0304
        L_0x0301:
            r17 = 5
            goto L_0x0306
        L_0x0304:
            r17 = 2
        L_0x0306:
            r8[r5] = r14
            goto L_0x030b
        L_0x0309:
            r17 = 0
        L_0x030b:
            int r5 = r5 + 3
            r11 = r17
            goto L_0x0320
        L_0x0310:
            int r5 = r5 + 5
            goto L_0x0264
        L_0x0314:
            int r5 = r5 + 3
            goto L_0x0264
        L_0x0318:
            int r5 = r5 + 2
            goto L_0x0264
        L_0x031c:
            int r5 = r5 + 1
            goto L_0x0264
        L_0x0320:
            if (r11 == 0) goto L_0x0340
            int r9 = r10.length
            int r9 = r9 + r14
            int[] r9 = new int[r9]
            int r13 = r12.length
            int r13 = r13 + r14
            int[] r13 = new int[r13]
            int r14 = r10.length
            java.lang.System.arraycopy(r10, r7, r9, r7, r14)
            int r14 = r12.length
            java.lang.System.arraycopy(r12, r7, r13, r7, r14)
            int r10 = r10.length
            r9[r10] = r5
            int r10 = r12.length
            r13[r10] = r11
            if (r11 <= 0) goto L_0x033e
            r10 = r9
            r12 = r13
            r6 = 3
            goto L_0x0340
        L_0x033e:
            r10 = r9
            r12 = r13
        L_0x0340:
            r9 = 3
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.org.objectweb.asm.CodeWriter.mo1085a(int[], int[], int):int[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r2 = r2 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        if (r2 <= r6.f765t) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        r6.f765t = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        r6.f764s = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitFieldInsn(int r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            r6 = this;
            boolean r0 = r6.f763r
            if (r0 == 0) goto L_0x003f
            r0 = 0
            char r1 = r10.charAt(r0)
            r2 = -2
            r3 = 1
            r4 = 74
            r5 = 68
            switch(r7) {
                case 178: goto L_0x002b;
                case 179: goto L_0x0022;
                case 180: goto L_0x0019;
                default: goto L_0x0012;
            }
        L_0x0012:
            int r0 = r6.f764s
            if (r1 == r5) goto L_0x0035
            if (r1 != r4) goto L_0x0036
            goto L_0x0035
        L_0x0019:
            int r2 = r6.f764s
            if (r1 == r5) goto L_0x001f
            if (r1 != r4) goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            int r2 = r2 + r0
            goto L_0x0037
        L_0x0022:
            int r0 = r6.f764s
            if (r1 == r5) goto L_0x0036
            if (r1 != r4) goto L_0x0029
            goto L_0x0036
        L_0x0029:
            r2 = -1
            goto L_0x0036
        L_0x002b:
            int r0 = r6.f764s
            if (r1 == r5) goto L_0x0031
            if (r1 != r4) goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            int r2 = r0 + r3
            goto L_0x0037
        L_0x0035:
            r2 = -3
        L_0x0036:
            int r2 = r2 + r0
        L_0x0037:
            int r0 = r6.f765t
            if (r2 <= r0) goto L_0x003d
            r6.f765t = r2
        L_0x003d:
            r6.f764s = r2
        L_0x003f:
            bsh.org.objectweb.asm.ByteVector r0 = r6.f753h
            bsh.org.objectweb.asm.ClassWriter r1 = r6.f747b
            bsh.org.objectweb.asm.Item r8 = r1.mo1060a(r8, r9, r10)
            short r8 = r8.f774a
            r0.put12(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.org.objectweb.asm.CodeWriter.visitFieldInsn(int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void visitIincInsn(int i, int i2) {
        if (this.f763r) {
            int i3 = i + 1;
            if (i3 > this.f752g) {
                this.f752g = i3;
            }
        }
        if (i > 255 || i2 > 127 || i2 < -128) {
            this.f753h.put1(196).put12(132, i).put2(i2);
        } else {
            this.f753h.put1(132).put11(i, i2);
        }
    }

    public void visitInsn(int i) {
        if (this.f763r) {
            int i2 = this.f764s + f744w[i];
            if (i2 > this.f765t) {
                this.f765t = i2;
            }
            this.f764s = i2;
            if (((i >= 172 && i <= 177) || i == 191) && this.f766u != null) {
                this.f766u.f788d = this.f765t;
                this.f766u = null;
            }
        }
        this.f753h.put1(i);
    }

    public void visitIntInsn(int i, int i2) {
        if (this.f763r && i != 188) {
            int i3 = this.f764s + 1;
            if (i3 > this.f765t) {
                this.f765t = i3;
            }
            this.f764s = i3;
        }
        if (i == 17) {
            this.f753h.put12(i, i2);
        } else {
            this.f753h.put11(i, i2);
        }
    }

    public void visitJumpInsn(int i, Label label) {
        ByteVector byteVector;
        int i2;
        if (this.f763r) {
            if (i != 167) {
                if (i != 168) {
                    this.f764s += f744w[i];
                    if (this.f766u != null) {
                        i2 = this.f764s;
                    }
                } else if (this.f766u != null) {
                    i2 = this.f764s + 1;
                }
                m786a(i2, label);
            } else if (this.f766u != null) {
                this.f766u.f788d = this.f765t;
                m786a(this.f764s, label);
                this.f766u = null;
            }
        }
        if (!label.f785a || label.f786b - this.f753h.f722b >= -32768) {
            this.f753h.put1(i);
            label.mo1092a(this, this.f753h, this.f753h.f722b - 1, false);
            return;
        }
        int i3 = 200;
        if (i != 167) {
            if (i == 168) {
                byteVector = this.f753h;
                i3 = 201;
                byteVector.put1(i3);
                label.mo1092a(this, this.f753h, this.f753h.f722b - 1, true);
            }
            this.f753h.put1(i <= 166 ? ((i + 1) ^ 1) - 1 : i ^ 1);
            this.f753h.put2(8);
        }
        byteVector = this.f753h;
        byteVector.put1(i3);
        label.mo1092a(this, this.f753h, this.f753h.f722b - 1, true);
    }

    public void visitLabel(Label label) {
        if (this.f763r) {
            if (this.f766u != null) {
                this.f766u.f788d = this.f765t;
                m786a(this.f764s, label);
            }
            this.f766u = label;
            this.f764s = 0;
            this.f765t = 0;
        }
        this.f762q = label.mo1093a(this, this.f753h.f722b, this.f753h.f721a) | this.f762q;
    }

    public void visitLdcInsn(Object obj) {
        ByteVector byteVector;
        int i;
        Item a = this.f747b.mo1058a(obj);
        if (this.f763r) {
            int i2 = (a.f775b == 5 || a.f775b == 6) ? this.f764s + 2 : this.f764s + 1;
            if (i2 > this.f765t) {
                this.f765t = i2;
            }
            this.f764s = i2;
        }
        short s = a.f774a;
        if (a.f775b == 5 || a.f775b == 6) {
            byteVector = this.f753h;
            i = 20;
        } else if (s >= 256) {
            byteVector = this.f753h;
            i = 19;
        } else {
            this.f753h.put11(18, s);
            return;
        }
        byteVector.put12(i, s);
    }

    public void visitLineNumber(int i, Label label) {
        if (this.f761p == null) {
            this.f747b.mo1059a("LineNumberTable");
            this.f761p = new ByteVector();
        }
        this.f760o++;
        this.f761p.put2(label.f786b);
        this.f761p.put2(i);
    }

    public void visitLocalVariable(String str, String str2, Label label, Label label2, int i) {
        if (this.f759n == null) {
            this.f747b.mo1059a("LocalVariableTable");
            this.f759n = new ByteVector();
        }
        this.f758m++;
        this.f759n.put2(label.f786b);
        this.f759n.put2(label2.f786b - label.f786b);
        this.f759n.put2(this.f747b.mo1059a(str).f774a);
        this.f759n.put2(this.f747b.mo1059a(str2).f774a);
        this.f759n.put2(i);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        if (this.f763r) {
            this.f764s--;
            if (this.f766u != null) {
                this.f766u.f788d = this.f765t;
                m786a(this.f764s, label);
                for (Label a : labelArr) {
                    m786a(this.f764s, a);
                }
                this.f766u = null;
            }
        }
        int i = this.f753h.f722b;
        this.f753h.put1(Constants.LOOKUPSWITCH);
        while (this.f753h.f722b % 4 != 0) {
            this.f753h.put1(0);
        }
        label.mo1092a(this, this.f753h, i, true);
        this.f753h.put4(labelArr.length);
        for (int i2 = 0; i2 < labelArr.length; i2++) {
            this.f753h.put4(iArr[i2]);
            labelArr[i2].mo1092a(this, this.f753h, i, true);
        }
    }

    public void visitMaxs(int i, int i2) {
        if (this.f763r) {
            int i3 = 0;
            Label label = this.f767v;
            while (label != null) {
                Label label2 = label.f790f;
                int i4 = label.f787c;
                int i5 = label.f788d + i4;
                if (i5 <= i3) {
                    i5 = i3;
                }
                label = label2;
                for (Edge edge = label.f789e; edge != null; edge = edge.f772c) {
                    Label label3 = edge.f771b;
                    if (!label3.f791g) {
                        label3.f787c = edge.f770a + i4;
                        label3.f791g = true;
                        label3.f790f = label;
                        label = label3;
                    }
                }
                i3 = i5;
            }
            this.f751f = i3;
            synchronized (f744w) {
                if (this.f769y != null) {
                    this.f769y.f773d = f745z;
                    f745z = this.f768x;
                }
            }
            return;
        }
        this.f751f = i;
        this.f752g = i2;
    }

    public void visitMethodInsn(int i, String str, String str2, String str3) {
        Item c = i == 185 ? this.f747b.mo1063c(str, str2, str3) : this.f747b.mo1062b(str, str2, str3);
        int i2 = c.f776c;
        if (this.f763r) {
            if (i2 == 0) {
                i2 = m783a(str3);
                c.f776c = i2;
            }
            int i3 = i == 184 ? (this.f764s - (i2 >> 2)) + (i2 & 3) + 1 : (this.f764s - (i2 >> 2)) + (i2 & 3);
            if (i3 > this.f765t) {
                this.f765t = i3;
            }
            this.f764s = i3;
        }
        if (i == 185) {
            if (!this.f763r && i2 == 0) {
                i2 = m783a(str3);
                c.f776c = i2;
            }
            this.f753h.put12(Constants.INVOKEINTERFACE, c.f774a).put11(i2 >> 2, 0);
            return;
        }
        this.f753h.put12(i, c.f774a);
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        if (this.f763r) {
            this.f764s += 1 - i;
        }
        this.f753h.put12(Constants.MULTIANEWARRAY, this.f747b.mo1061b(str).f774a).put1(i);
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label[] labelArr) {
        if (this.f763r) {
            this.f764s--;
            if (this.f766u != null) {
                this.f766u.f788d = this.f765t;
                m786a(this.f764s, label);
                for (Label a : labelArr) {
                    m786a(this.f764s, a);
                }
                this.f766u = null;
            }
        }
        int i3 = this.f753h.f722b;
        this.f753h.put1(Constants.TABLESWITCH);
        while (this.f753h.f722b % 4 != 0) {
            this.f753h.put1(0);
        }
        label.mo1092a(this, this.f753h, i3, true);
        this.f753h.put4(i).put4(i2);
        for (Label a2 : labelArr) {
            a2.mo1092a(this, this.f753h, i3, true);
        }
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        if (this.f763r && !label3.f791g) {
            label3.f787c = 1;
            label3.f791g = true;
            label3.f790f = this.f767v;
            this.f767v = label3;
        }
        this.f754i++;
        if (this.f755j == null) {
            this.f755j = new ByteVector();
        }
        this.f755j.put2(label.f786b);
        this.f755j.put2(label2.f786b);
        this.f755j.put2(label3.f786b);
        this.f755j.put2(str != null ? this.f747b.mo1061b(str).f774a : 0);
    }

    public void visitTypeInsn(int i, String str) {
        if (this.f763r && i == 187) {
            int i2 = this.f764s + 1;
            if (i2 > this.f765t) {
                this.f765t = i2;
            }
            this.f764s = i2;
        }
        this.f753h.put12(i, this.f747b.mo1061b(str).f774a);
    }

    public void visitVarInsn(int i, int i2) {
        if (this.f763r) {
            if (i != 169) {
                int i3 = this.f764s + f744w[i];
                if (i3 > this.f765t) {
                    this.f765t = i3;
                }
                this.f764s = i3;
            } else if (this.f766u != null) {
                this.f766u.f788d = this.f765t;
                this.f766u = null;
            }
            int i4 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i4 > this.f752g) {
                this.f752g = i4;
            }
        }
        if (i2 < 4 && i != 169) {
            this.f753h.put1((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            this.f753h.put1(196).put12(i, i2);
        } else {
            this.f753h.put11(i, i2);
        }
    }
}
