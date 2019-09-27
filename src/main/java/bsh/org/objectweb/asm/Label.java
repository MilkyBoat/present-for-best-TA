package bsh.org.objectweb.asm;

public class Label {

    /* renamed from: a */
    boolean f785a;

    /* renamed from: b */
    int f786b;

    /* renamed from: c */
    int f787c;

    /* renamed from: d */
    int f788d;

    /* renamed from: e */
    Edge f789e;

    /* renamed from: f */
    Label f790f;

    /* renamed from: g */
    boolean f791g;

    /* renamed from: h */
    private int f792h;

    /* renamed from: i */
    private int[] f793i;

    /* renamed from: a */
    private void m800a(int i, int i2) {
        if (this.f793i == null) {
            this.f793i = new int[6];
        }
        if (this.f792h >= this.f793i.length) {
            int[] iArr = new int[(this.f793i.length + 6)];
            System.arraycopy(this.f793i, 0, iArr, 0, this.f793i.length);
            this.f793i = iArr;
        }
        int[] iArr2 = this.f793i;
        int i3 = this.f792h;
        this.f792h = i3 + 1;
        iArr2[i3] = i;
        int[] iArr3 = this.f793i;
        int i4 = this.f792h;
        this.f792h = i4 + 1;
        iArr3[i4] = i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1092a(CodeWriter codeWriter, ByteVector byteVector, int i, boolean z) {
        int i2;
        if (!this.f785a) {
            i2 = -1;
            if (z) {
                m800a(-1 - i, byteVector.f722b);
            } else {
                m800a(i, byteVector.f722b);
                byteVector.put2(i2);
                return;
            }
        } else if (z) {
            i2 = this.f786b - i;
        } else {
            i2 = this.f786b - i;
            byteVector.put2(i2);
            return;
        }
        byteVector.put4(i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1093a(CodeWriter codeWriter, int i, byte[] bArr) {
        this.f785a = true;
        this.f786b = i;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.f792h) {
            int i3 = i2 + 1;
            int i4 = this.f793i[i2];
            int i5 = i3 + 1;
            int i6 = this.f793i[i3];
            if (i4 >= 0) {
                int i7 = i - i4;
                if (i7 < -32768 || i7 > 32767) {
                    int i8 = i6 - 1;
                    byte b = bArr[i8] & 255;
                    if (b <= 168) {
                        bArr[i8] = (byte) (b + 49);
                    } else {
                        bArr[i8] = (byte) (b + 20);
                    }
                    z = true;
                }
                int i9 = i6 + 1;
                bArr[i6] = (byte) (i7 >>> 8);
                bArr[i9] = (byte) i7;
            } else {
                int i10 = i4 + i + 1;
                int i11 = i6 + 1;
                bArr[i6] = (byte) (i10 >>> 24);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (i10 >>> 16);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (i10 >>> 8);
                bArr[i13] = (byte) i10;
            }
            i2 = i5;
        }
        return z;
    }
}
