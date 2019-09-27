package bsh.org.objectweb.asm;

final class Item {

    /* renamed from: a */
    short f774a;

    /* renamed from: b */
    int f775b;

    /* renamed from: c */
    int f776c;

    /* renamed from: d */
    long f777d;

    /* renamed from: e */
    float f778e;

    /* renamed from: f */
    double f779f;

    /* renamed from: g */
    String f780g;

    /* renamed from: h */
    String f781h;

    /* renamed from: i */
    String f782i;

    /* renamed from: j */
    int f783j;

    /* renamed from: k */
    Item f784k;

    Item() {
    }

    Item(short s, Item item) {
        this.f774a = s;
        this.f775b = item.f775b;
        this.f776c = item.f776c;
        this.f777d = item.f777d;
        this.f778e = item.f778e;
        this.f779f = item.f779f;
        this.f780g = item.f780g;
        this.f781h = item.f781h;
        this.f782i = item.f782i;
        this.f783j = item.f783j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1086a(double d) {
        this.f775b = 6;
        this.f779f = d;
        this.f783j = this.f775b + ((int) d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1087a(float f) {
        this.f775b = 4;
        this.f778e = f;
        this.f783j = this.f775b + ((int) f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1088a(int i) {
        this.f775b = 3;
        this.f776c = i;
        this.f783j = this.f775b + i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1089a(int i, String str, String str2, String str3) {
        int hashCode;
        int hashCode2;
        int hashCode3;
        this.f775b = i;
        this.f780g = str;
        this.f781h = str2;
        this.f782i = str3;
        if (i != 1) {
            if (i != 12) {
                switch (i) {
                    case 7:
                    case 8:
                        break;
                    default:
                        hashCode2 = str.hashCode() * str2.hashCode();
                        hashCode3 = str3.hashCode();
                        break;
                }
            } else {
                hashCode2 = str.hashCode();
                hashCode3 = str2.hashCode();
            }
            hashCode = hashCode2 * hashCode3;
            this.f783j = i + hashCode;
        }
        hashCode = str.hashCode();
        this.f783j = i + hashCode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1090a(long j) {
        this.f775b = 5;
        this.f777d = j;
        this.f783j = this.f775b + ((int) j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1091a(Item item) {
        if (item.f775b != this.f775b) {
            return false;
        }
        int i = this.f775b;
        if (i != 1) {
            if (i == 12) {
                return item.f780g.equals(this.f780g) && item.f781h.equals(this.f781h);
            }
            switch (i) {
                case 3:
                    return item.f776c == this.f776c;
                case 4:
                    return item.f778e == this.f778e;
                case 5:
                    return item.f777d == this.f777d;
                case 6:
                    return item.f779f == this.f779f;
                case 7:
                case 8:
                    break;
                default:
                    return item.f780g.equals(this.f780g) && item.f781h.equals(this.f781h) && item.f782i.equals(this.f782i);
            }
        }
        return item.f780g.equals(this.f780g);
    }
}
