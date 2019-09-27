package bsh.org.objectweb.asm;

public class ClassWriter implements ClassVisitor {

    /* renamed from: f */
    static byte[] f723f;

    /* renamed from: a */
    CodeWriter f724a;

    /* renamed from: b */
    CodeWriter f725b;

    /* renamed from: c */
    Item f726c = new Item();

    /* renamed from: d */
    Item f727d = new Item();

    /* renamed from: e */
    Item f728e = new Item();

    /* renamed from: g */
    private short f729g = 1;

    /* renamed from: h */
    private ByteVector f730h = new ByteVector();

    /* renamed from: i */
    private Item[] f731i = new Item[64];

    /* renamed from: j */
    private int f732j = ((int) (((double) this.f731i.length) * 0.75d));

    /* renamed from: k */
    private int f733k;

    /* renamed from: l */
    private int f734l;

    /* renamed from: m */
    private int f735m;

    /* renamed from: n */
    private int f736n;

    /* renamed from: o */
    private int[] f737o;

    /* renamed from: p */
    private Item f738p;

    /* renamed from: q */
    private int f739q;

    /* renamed from: r */
    private ByteVector f740r;

    /* renamed from: s */
    private boolean f741s;

    /* renamed from: t */
    private int f742t;

    /* renamed from: u */
    private ByteVector f743u;

    static {
        byte[] bArr = new byte[220];
        String str = "AAAAAAAAAAAAAAAABCKLLDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIDNOAAAAAAGGGGGGGHAFBFAAFFAAQPIIJJIIIIIIIIIIIIIIIIII";
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (str.charAt(i) - 'A');
        }
        f723f = bArr;
    }

    public ClassWriter(boolean z) {
        this.f741s = z;
    }

    /* renamed from: a */
    private Item m768a(double d) {
        this.f726c.mo1086a(d);
        Item a = m772a(this.f726c);
        if (a != null) {
            return a;
        }
        this.f730h.put1(6).put8(Double.doubleToLongBits(d));
        Item item = new Item(this.f729g, this.f726c);
        m775b(item);
        this.f729g = (short) (this.f729g + 2);
        return item;
    }

    /* renamed from: a */
    private Item m769a(float f) {
        this.f726c.mo1087a(f);
        Item a = m772a(this.f726c);
        if (a != null) {
            return a;
        }
        this.f730h.put1(4).put4(Float.floatToIntBits(f));
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f726c);
        m775b(item);
        return item;
    }

    /* renamed from: a */
    private Item m770a(int i) {
        this.f726c.mo1088a(i);
        Item a = m772a(this.f726c);
        if (a != null) {
            return a;
        }
        this.f730h.put1(3).put4(i);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f726c);
        m775b(item);
        return item;
    }

    /* renamed from: a */
    private Item m771a(long j) {
        this.f726c.mo1090a(j);
        Item a = m772a(this.f726c);
        if (a != null) {
            return a;
        }
        this.f730h.put1(5).put8(j);
        Item item = new Item(this.f729g, this.f726c);
        m775b(item);
        this.f729g = (short) (this.f729g + 2);
        return item;
    }

    /* renamed from: a */
    private Item m772a(Item item) {
        Item[] itemArr = this.f731i;
        int i = item.f783j;
        for (Item item2 = itemArr[(Integer.MAX_VALUE & i) % itemArr.length]; item2 != null; item2 = item2.f784k) {
            if (item2.f783j == i && item.mo1091a(item2)) {
                return item2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private Item m773a(String str, String str2) {
        this.f727d.mo1089a(12, str, str2, null);
        Item a = m772a(this.f727d);
        if (a != null) {
            return a;
        }
        m774a(12, (int) mo1059a(str).f774a, (int) mo1059a(str2).f774a);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f727d);
        m775b(item);
        return item;
    }

    /* renamed from: a */
    private void m774a(int i, int i2, int i3) {
        this.f730h.put12(i, i2).put2(i3);
    }

    /* renamed from: b */
    private void m775b(Item item) {
        if (this.f729g > this.f732j) {
            int length = this.f731i.length;
            Item[] itemArr = this.f731i;
            int i = (length * 2) + 1;
            Item[] itemArr2 = new Item[i];
            this.f732j = (int) (((double) i) * 0.75d);
            this.f731i = itemArr2;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    break;
                }
                Item item2 = itemArr[i2];
                while (item2 != null) {
                    Item item3 = item2.f784k;
                    int i3 = (item2.f783j & Integer.MAX_VALUE) % i;
                    item2.f784k = itemArr2[i3];
                    itemArr2[i3] = item2;
                    item2 = item3;
                }
                length = i2;
            }
        }
        int length2 = (item.f783j & Integer.MAX_VALUE) % this.f731i.length;
        item.f784k = this.f731i[length2];
        this.f731i[length2] = item;
    }

    /* renamed from: c */
    private Item m776c(String str) {
        this.f727d.mo1089a(8, str, null, null);
        Item a = m772a(this.f727d);
        if (a != null) {
            return a;
        }
        this.f730h.put12(8, mo1059a(str).f774a);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f727d);
        m775b(item);
        return item;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo1058a(Object obj) {
        if (obj instanceof Integer) {
            return m770a(((Integer) obj).intValue());
        }
        if (obj instanceof Float) {
            return m769a(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return m771a(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return m768a(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return m776c((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("value ");
        stringBuffer.append(obj);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo1059a(String str) {
        this.f726c.mo1089a(1, str, null, null);
        Item a = m772a(this.f726c);
        if (a != null) {
            return a;
        }
        this.f730h.put1(1).putUTF(str);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f726c);
        m775b(item);
        return item;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo1060a(String str, String str2, String str3) {
        this.f728e.mo1089a(9, str, str2, str3);
        Item a = m772a(this.f728e);
        if (a != null) {
            return a;
        }
        m774a(9, (int) mo1061b(str).f774a, (int) m773a(str2, str3).f774a);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f728e);
        m775b(item);
        return item;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Item mo1061b(String str) {
        this.f727d.mo1089a(7, str, null, null);
        Item a = m772a(this.f727d);
        if (a != null) {
            return a;
        }
        this.f730h.put12(7, mo1059a(str).f774a);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f727d);
        m775b(item);
        return item;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Item mo1062b(String str, String str2, String str3) {
        this.f728e.mo1089a(10, str, str2, str3);
        Item a = m772a(this.f728e);
        if (a != null) {
            return a;
        }
        m774a(10, (int) mo1061b(str).f774a, (int) m773a(str2, str3).f774a);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f728e);
        m775b(item);
        return item;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Item mo1063c(String str, String str2, String str3) {
        this.f728e.mo1089a(11, str, str2, str3);
        Item a = m772a(this.f728e);
        if (a != null) {
            return a;
        }
        m774a(11, (int) mo1061b(str).f774a, (int) m773a(str2, str3).f774a);
        short s = this.f729g;
        this.f729g = (short) (s + 1);
        Item item = new Item(s, this.f728e);
        m775b(item);
        return item;
    }

    public byte[] toByteArray() {
        int i;
        int i2 = (this.f736n * 2) + 24;
        if (this.f740r != null) {
            i2 += this.f740r.f722b;
        }
        int i3 = 0;
        for (CodeWriter codeWriter = this.f724a; codeWriter != null; codeWriter = codeWriter.f746a) {
            i3++;
            i2 += codeWriter.mo1082a();
        }
        int i4 = i2 + this.f730h.f722b;
        if (this.f738p != null) {
            i4 += 8;
            i = 1;
        } else {
            i = 0;
        }
        if ((this.f733k & Constants.ACC_DEPRECATED) != 0) {
            i++;
            i4 += 6;
        }
        if (this.f743u != null) {
            i++;
            i4 += this.f743u.f722b + 8;
        }
        int i5 = i;
        ByteVector byteVector = new ByteVector(i4);
        byteVector.put4(-889275714).put2(3).put2(45);
        byteVector.put2(this.f729g).putByteArray(this.f730h.f721a, 0, this.f730h.f722b);
        byteVector.put2(this.f733k).put2(this.f734l).put2(this.f735m);
        byteVector.put2(this.f736n);
        for (int i6 = 0; i6 < this.f736n; i6++) {
            byteVector.put2(this.f737o[i6]);
        }
        byteVector.put2(this.f739q);
        if (this.f740r != null) {
            byteVector.putByteArray(this.f740r.f721a, 0, this.f740r.f722b);
        }
        byteVector.put2(i3);
        for (CodeWriter codeWriter2 = this.f724a; codeWriter2 != null; codeWriter2 = codeWriter2.f746a) {
            codeWriter2.mo1084a(byteVector);
        }
        byteVector.put2(i5);
        if (this.f738p != null) {
            byteVector.put2(mo1059a("SourceFile").f774a).put4(2).put2(this.f738p.f774a);
        }
        if ((this.f733k & Constants.ACC_DEPRECATED) != 0) {
            byteVector.put2(mo1059a("Deprecated").f774a).put4(0);
        }
        if (this.f743u != null) {
            byteVector.put2(mo1059a("InnerClasses").f774a);
            byteVector.put4(this.f743u.f722b + 2).put2(this.f742t);
            byteVector.putByteArray(this.f743u.f721a, 0, this.f743u.f722b);
        }
        return byteVector.f721a;
    }

    public void visit(int i, String str, String str2, String[] strArr, String str3) {
        this.f733k = i;
        this.f734l = mo1061b(str).f774a;
        this.f735m = str2 == null ? 0 : mo1061b(str2).f774a;
        if (strArr != null && strArr.length > 0) {
            this.f736n = strArr.length;
            this.f737o = new int[this.f736n];
            for (int i2 = 0; i2 < this.f736n; i2++) {
                this.f737o[i2] = mo1061b(strArr[i2]).f774a;
            }
        }
        if (str3 != null) {
            mo1059a("SourceFile");
            this.f738p = mo1059a(str3);
        }
        if ((i & Constants.ACC_DEPRECATED) != 0) {
            mo1059a("Deprecated");
        }
    }

    public void visitEnd() {
    }

    public void visitField(int i, String str, String str2, Object obj) {
        int i2 = 1;
        this.f739q++;
        if (this.f740r == null) {
            this.f740r = new ByteVector();
        }
        this.f740r.put2(i).put2(mo1059a(str).f774a).put2(mo1059a(str2).f774a);
        if (obj == null) {
            i2 = 0;
        }
        int i3 = 65536 & i;
        if (i3 != 0) {
            i2++;
        }
        int i4 = i & Constants.ACC_DEPRECATED;
        if (i4 != 0) {
            i2++;
        }
        this.f740r.put2(i2);
        if (obj != null) {
            this.f740r.put2(mo1059a("ConstantValue").f774a);
            this.f740r.put4(2).put2(mo1058a(obj).f774a);
        }
        if (i3 != 0) {
            this.f740r.put2(mo1059a("Synthetic").f774a).put4(0);
        }
        if (i4 != 0) {
            this.f740r.put2(mo1059a("Deprecated").f774a).put4(0);
        }
    }

    public void visitInnerClass(String str, String str2, String str3, int i) {
        if (this.f743u == null) {
            mo1059a("InnerClasses");
            this.f743u = new ByteVector();
        }
        this.f742t++;
        short s = 0;
        this.f743u.put2(str == null ? 0 : mo1061b(str).f774a);
        this.f743u.put2(str2 == null ? 0 : mo1061b(str2).f774a);
        ByteVector byteVector = this.f743u;
        if (str3 != null) {
            s = mo1059a(str3).f774a;
        }
        byteVector.put2(s);
        this.f743u.put2(i);
    }

    public CodeVisitor visitMethod(int i, String str, String str2, String[] strArr) {
        CodeWriter codeWriter = new CodeWriter(this, this.f741s);
        codeWriter.mo1083a(i, str, str2, strArr);
        return codeWriter;
    }
}
