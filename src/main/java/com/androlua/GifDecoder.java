package com.androlua;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import bsh.org.objectweb.asm.Constants;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class GifDecoder extends Thread {
    public static final int STATUS_FINISH = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARSING = 0;

    /* renamed from: A */
    private boolean f2208A = false;

    /* renamed from: B */
    private byte[] f2209B = new byte[Constants.ACC_NATIVE];

    /* renamed from: C */
    private int f2210C = 0;

    /* renamed from: D */
    private int f2211D = 0;

    /* renamed from: E */
    private int f2212E = 0;

    /* renamed from: F */
    private boolean f2213F = false;

    /* renamed from: G */
    private int f2214G = 0;

    /* renamed from: H */
    private int f2215H;

    /* renamed from: I */
    private short[] f2216I;

    /* renamed from: J */
    private byte[] f2217J;

    /* renamed from: K */
    private byte[] f2218K;

    /* renamed from: L */
    private byte[] f2219L;

    /* renamed from: M */
    private GifFrame f2220M;

    /* renamed from: N */
    private int f2221N;

    /* renamed from: O */
    private GifAction f2222O = null;

    /* renamed from: P */
    private byte[] f2223P = null;

    /* renamed from: a */
    private InputStream f2224a;

    /* renamed from: b */
    private int f2225b;

    /* renamed from: c */
    private boolean f2226c;

    /* renamed from: d */
    private int f2227d;

    /* renamed from: e */
    private int f2228e = 1;

    /* renamed from: f */
    private int[] f2229f;

    /* renamed from: g */
    private int[] f2230g;

    /* renamed from: h */
    private int[] f2231h;
    public int height;

    /* renamed from: i */
    private int f2232i;

    /* renamed from: j */
    private int f2233j;

    /* renamed from: k */
    private int f2234k;

    /* renamed from: l */
    private int f2235l;

    /* renamed from: m */
    private boolean f2236m;

    /* renamed from: n */
    private boolean f2237n;

    /* renamed from: o */
    private int f2238o;

    /* renamed from: p */
    private int f2239p;

    /* renamed from: q */
    private int f2240q;

    /* renamed from: r */
    private int f2241r;

    /* renamed from: s */
    private int f2242s;

    /* renamed from: t */
    private int f2243t;

    /* renamed from: u */
    private int f2244u;

    /* renamed from: v */
    private int f2245v;

    /* renamed from: w */
    private int f2246w;
    public int width;

    /* renamed from: x */
    private Bitmap f2247x;

    /* renamed from: y */
    private Bitmap f2248y;

    /* renamed from: z */
    private GifFrame f2249z = null;

    public interface GifAction {
        void parseOk(boolean z, int i);
    }

    public static class GifFrame {
        public int delay;
        public Bitmap image;
        public GifFrame nextFrame = null;

        public GifFrame(Bitmap bitmap, int i) {
            this.image = bitmap;
            this.delay = i;
        }
    }

    public GifDecoder(InputStream inputStream, GifAction gifAction) {
        this.f2224a = inputStream;
        this.f2222O = gifAction;
    }

    public GifDecoder(String str, GifAction gifAction) {
        this.f2224a = new FileInputStream(str);
        this.f2222O = gifAction;
    }

    public GifDecoder(byte[] bArr, GifAction gifAction) {
        this.f2223P = bArr;
        this.f2222O = gifAction;
    }

    /* renamed from: a */
    private void m2108a() {
        int i;
        int[] iArr = new int[(this.width * this.height)];
        int i2 = 0;
        if (this.f2212E > 0) {
            if (this.f2212E == 3) {
                int i3 = this.f2221N - 2;
                this.f2248y = i3 > 0 ? getFrameImage(i3 - 1) : null;
            }
            if (this.f2248y != null) {
                this.f2248y.getPixels(iArr, 0, this.width, 0, 0, this.width, this.height);
                if (this.f2212E == 2) {
                    int i4 = !this.f2213F ? this.f2234k : 0;
                    for (int i5 = 0; i5 < this.f2246w; i5++) {
                        int i6 = ((this.f2244u + i5) * this.width) + this.f2243t;
                        int i7 = this.f2245v + i6;
                        while (i6 < i7) {
                            iArr[i6] = i4;
                            i6++;
                        }
                    }
                }
            }
        }
        int i8 = 0;
        int i9 = 1;
        int i10 = 8;
        while (i2 < this.f2242s) {
            if (this.f2237n) {
                if (i8 >= this.f2242s) {
                    i9++;
                    switch (i9) {
                        case 2:
                            i8 = 4;
                            break;
                        case 3:
                            i8 = 2;
                            i10 = 4;
                            break;
                        case 4:
                            i8 = 1;
                            i10 = 2;
                            break;
                    }
                }
                i = i8 + i10;
            } else {
                i = i8;
                i8 = i2;
            }
            int i11 = i8 + this.f2240q;
            if (i11 < this.height) {
                int i12 = i11 * this.width;
                int i13 = this.f2239p + i12;
                int i14 = this.f2241r + i13;
                if (this.width + i12 < i14) {
                    i14 = this.width + i12;
                }
                int i15 = this.f2241r * i2;
                while (i13 < i14) {
                    int i16 = i15 + 1;
                    int i17 = this.f2231h[this.f2219L[i15] & 255];
                    if (i17 != 0) {
                        iArr[i13] = i17;
                    }
                    i13++;
                    i15 = i16;
                }
            }
            i2++;
            i8 = i;
        }
        this.f2247x = Bitmap.createBitmap(iArr, this.width, this.height, Config.ARGB_4444);
    }

    /* renamed from: a */
    private int[] m2109a(int i) {
        int i2;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        try {
            i2 = this.f2224a.read(bArr);
        } catch (Exception e) {
            C0029a.m806a(e);
            i2 = 0;
        }
        if (i2 < i3) {
            this.f2225b = 1;
            return null;
        }
        int[] iArr = new int[Constants.ACC_NATIVE];
        int i5 = 0;
        while (i4 < i) {
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i4 + 1;
            iArr[i4] = ((bArr[i5] & 255) << 16) | -16777216 | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            i5 = i8;
            i4 = i9;
        }
        return iArr;
    }

    /* renamed from: b */
    private int m2110b() {
        this.f2224a = new ByteArrayInputStream(this.f2223P);
        this.f2223P = null;
        return m2111c();
    }

    /* renamed from: c */
    private int m2111c() {
        m2114f();
        if (this.f2224a != null) {
            m2119k();
            if (!m2113e()) {
                m2117i();
                if (this.f2221N < 0) {
                    this.f2225b = 1;
                } else {
                    this.f2225b = -1;
                    this.f2222O.parseOk(true, -1);
                    this.f2224a.close();
                }
            }
            this.f2222O.parseOk(false, -1);
            try {
                this.f2224a.close();
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        } else {
            this.f2225b = 2;
            this.f2222O.parseOk(false, -1);
        }
        return this.f2225b;
    }

    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v4
  assigns: []
  uses: []
  mth insns count: 154
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2112d() {
        /*
            r25 = this;
            r0 = r25
            int r1 = r0.f2241r
            int r2 = r0.f2242s
            int r1 = r1 * r2
            byte[] r2 = r0.f2219L
            if (r2 == 0) goto L_0x0011
            byte[] r2 = r0.f2219L
            int r2 = r2.length
            if (r2 >= r1) goto L_0x0015
        L_0x0011:
            byte[] r2 = new byte[r1]
            r0.f2219L = r2
        L_0x0015:
            short[] r2 = r0.f2216I
            r3 = 4096(0x1000, float:5.74E-42)
            if (r2 != 0) goto L_0x001f
            short[] r2 = new short[r3]
            r0.f2216I = r2
        L_0x001f:
            byte[] r2 = r0.f2217J
            if (r2 != 0) goto L_0x0027
            byte[] r2 = new byte[r3]
            r0.f2217J = r2
        L_0x0027:
            byte[] r2 = r0.f2218K
            if (r2 != 0) goto L_0x0031
            r2 = 4097(0x1001, float:5.741E-42)
            byte[] r2 = new byte[r2]
            r0.f2218K = r2
        L_0x0031:
            int r2 = r25.m2115g()
            r4 = 1
            int r5 = r4 << r2
            int r6 = r5 + 1
            int r7 = r5 + 2
            int r2 = r2 + r4
            int r8 = r4 << r2
            int r8 = r8 - r4
            r9 = 0
            r10 = 0
        L_0x0042:
            if (r10 >= r5) goto L_0x0050
            short[] r11 = r0.f2216I
            r11[r10] = r9
            byte[] r11 = r0.f2217J
            byte r12 = (byte) r10
            r11[r10] = r12
            int r10 = r10 + 1
            goto L_0x0042
        L_0x0050:
            r14 = r2
            r9 = r7
            r17 = r8
            r3 = -1
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x0061:
            if (r11 >= r1) goto L_0x012c
            if (r12 != 0) goto L_0x010d
            if (r13 >= r14) goto L_0x0083
            if (r15 != 0) goto L_0x0073
            int r15 = r25.m2116h()
            if (r15 > 0) goto L_0x0071
            goto L_0x012c
        L_0x0071:
            r18 = 0
        L_0x0073:
            byte[] r10 = r0.f2209B
            byte r10 = r10[r18]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << r13
            int r16 = r16 + r10
            int r13 = r13 + 8
            int r18 = r18 + 1
            r10 = -1
            int r15 = r15 + r10
            goto L_0x0061
        L_0x0083:
            r10 = -1
            r4 = r16 & r17
            int r16 = r16 >> r14
            int r13 = r13 - r14
            if (r4 > r9) goto L_0x012c
            if (r4 != r6) goto L_0x008f
            goto L_0x012c
        L_0x008f:
            if (r4 != r5) goto L_0x0098
            r14 = r2
            r9 = r7
            r17 = r8
            r3 = -1
            goto L_0x0129
        L_0x0098:
            if (r3 != r10) goto L_0x00ae
            byte[] r3 = r0.f2218K
            int r10 = r12 + 1
            r21 = r2
            byte[] r2 = r0.f2217J
            byte r2 = r2[r4]
            r3[r12] = r2
            r3 = r4
            r19 = r3
            r12 = r10
            r2 = r21
            goto L_0x0129
        L_0x00ae:
            r21 = r2
            if (r4 != r9) goto L_0x00bf
            byte[] r2 = r0.f2218K
            int r10 = r12 + 1
            r22 = r4
            r4 = r19
            byte r4 = (byte) r4
            r2[r12] = r4
            r2 = r3
            goto L_0x00c4
        L_0x00bf:
            r22 = r4
            r10 = r12
            r2 = r22
        L_0x00c4:
            if (r2 <= r5) goto L_0x00da
            byte[] r4 = r0.f2218K
            int r12 = r10 + 1
            r23 = r5
            byte[] r5 = r0.f2217J
            byte r5 = r5[r2]
            r4[r10] = r5
            short[] r4 = r0.f2216I
            short r2 = r4[r2]
            r10 = r12
            r5 = r23
            goto L_0x00c4
        L_0x00da:
            r23 = r5
            byte[] r4 = r0.f2217J
            byte r2 = r4[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 < r4) goto L_0x00e7
            goto L_0x012c
        L_0x00e7:
            byte[] r4 = r0.f2218K
            int r12 = r10 + 1
            byte r5 = (byte) r2
            r4[r10] = r5
            short[] r4 = r0.f2216I
            short r3 = (short) r3
            r4[r9] = r3
            byte[] r3 = r0.f2217J
            r3[r9] = r5
            int r9 = r9 + 1
            r3 = r9 & r17
            if (r3 != 0) goto L_0x0106
            r5 = 4096(0x1000, float:5.74E-42)
            if (r9 >= r5) goto L_0x0108
            int r14 = r14 + 1
            int r17 = r17 + r9
            goto L_0x0108
        L_0x0106:
            r5 = 4096(0x1000, float:5.74E-42)
        L_0x0108:
            r19 = r2
            r3 = r22
            goto L_0x0115
        L_0x010d:
            r21 = r2
            r23 = r5
            r4 = r19
            r5 = 4096(0x1000, float:5.74E-42)
        L_0x0115:
            r2 = -1
            int r12 = r12 + r2
            byte[] r4 = r0.f2219L
            int r10 = r20 + 1
            byte[] r2 = r0.f2218K
            byte r2 = r2[r12]
            r4[r20] = r2
            int r11 = r11 + 1
            r20 = r10
            r2 = r21
            r5 = r23
        L_0x0129:
            r4 = 1
            goto L_0x0061
        L_0x012c:
            r2 = r20
        L_0x012e:
            if (r2 >= r1) goto L_0x0138
            byte[] r3 = r0.f2219L
            r4 = 0
            r3[r2] = r4
            int r2 = r2 + 1
            goto L_0x012e
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.GifDecoder.m2112d():void");
    }

    /* renamed from: e */
    private boolean m2113e() {
        return this.f2225b != 0;
    }

    /* renamed from: f */
    private void m2114f() {
        this.f2225b = 0;
        this.f2221N = 0;
        this.f2220M = null;
        this.f2229f = null;
        this.f2230g = null;
    }

    /* renamed from: g */
    private int m2115g() {
        try {
            return this.f2224a.read();
        } catch (Exception unused) {
            this.f2225b = 1;
            return 0;
        }
    }

    /* renamed from: h */
    private int m2116h() {
        this.f2210C = m2115g();
        int i = 0;
        if (this.f2210C > 0) {
            while (i < this.f2210C) {
                try {
                    int read = this.f2224a.read(this.f2209B, i, this.f2210C - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    C0029a.m806a(e);
                }
            }
            if (i < this.f2210C) {
                this.f2225b = 1;
            }
        }
        return i;
    }

    /* renamed from: i */
    private void m2117i() {
        boolean z = false;
        while (!z && !m2113e()) {
            int g = m2115g();
            if (g != 0) {
                if (g == 33) {
                    int g2 = m2115g();
                    if (g2 != 249) {
                        if (g2 == 255) {
                            m2116h();
                            String str = BuildConfig.FLAVOR;
                            for (int i = 0; i < 11; i++) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                sb.append((char) this.f2209B[i]);
                                str = sb.toString();
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                m2122n();
                            }
                        }
                        m2125q();
                    } else {
                        m2118j();
                    }
                } else if (g == 44) {
                    m2120l();
                } else if (g != 59) {
                    this.f2225b = 1;
                } else {
                    z = true;
                }
            }
        }
    }

    /* renamed from: j */
    private void m2118j() {
        m2115g();
        int g = m2115g();
        this.f2211D = (g & 28) >> 2;
        boolean z = true;
        if (this.f2211D == 0) {
            this.f2211D = 1;
        }
        if ((g & 1) == 0) {
            z = false;
        }
        this.f2213F = z;
        this.f2214G = m2123o() * 10;
        this.f2215H = m2115g();
        m2115g();
    }

    /* renamed from: k */
    private void m2119k() {
        String str = BuildConfig.FLAVOR;
        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append((char) m2115g());
            str = sb.toString();
        }
        if (!str.startsWith("GIF")) {
            this.f2225b = 1;
            return;
        }
        m2121m();
        if (this.f2226c && !m2113e()) {
            this.f2229f = m2109a(this.f2227d);
            this.f2233j = this.f2229f[this.f2232i];
        }
    }

    /* renamed from: l */
    private void m2120l() {
        int i;
        this.f2239p = m2123o();
        this.f2240q = m2123o();
        this.f2241r = m2123o();
        this.f2242s = m2123o();
        int g = m2115g();
        this.f2236m = (g & 128) != 0;
        this.f2237n = (g & 64) != 0;
        this.f2238o = 2 << (g & 7);
        if (this.f2236m) {
            this.f2230g = m2109a(this.f2238o);
            this.f2231h = this.f2230g;
        } else {
            this.f2231h = this.f2229f;
            if (this.f2232i == this.f2215H) {
                this.f2233j = 0;
            }
        }
        if (this.f2213F) {
            i = this.f2231h[this.f2215H];
            this.f2231h[this.f2215H] = 0;
        } else {
            i = 0;
        }
        if (this.f2231h == null) {
            this.f2225b = 1;
        }
        if (!m2113e()) {
            m2112d();
            m2125q();
            if (!m2113e()) {
                this.f2221N++;
                this.f2247x = Bitmap.createBitmap(this.width, this.height, Config.ARGB_4444);
                m2108a();
                if (this.f2220M == null) {
                    this.f2220M = new GifFrame(this.f2247x, this.f2214G);
                    this.f2249z = this.f2220M;
                } else {
                    GifFrame gifFrame = this.f2220M;
                    while (gifFrame.nextFrame != null) {
                        gifFrame = gifFrame.nextFrame;
                    }
                    gifFrame.nextFrame = new GifFrame(this.f2247x, this.f2214G);
                }
                if (this.f2213F) {
                    this.f2231h[this.f2215H] = i;
                }
                m2124p();
                this.f2222O.parseOk(true, this.f2221N);
            }
        }
    }

    /* renamed from: m */
    private void m2121m() {
        this.width = m2123o();
        this.height = m2123o();
        int g = m2115g();
        this.f2226c = (g & 128) != 0;
        this.f2227d = 2 << (g & 7);
        this.f2232i = m2115g();
        this.f2235l = m2115g();
    }

    /* renamed from: n */
    private void m2122n() {
        do {
            m2116h();
            if (this.f2209B[0] == 1) {
                this.f2228e = (this.f2209B[1] & 255) | ((this.f2209B[2] & 255) << 8);
            }
            if (this.f2210C <= 0) {
                return;
            }
        } while (!m2113e());
    }

    /* renamed from: o */
    private int m2123o() {
        return m2115g() | (m2115g() << 8);
    }

    /* renamed from: p */
    private void m2124p() {
        this.f2212E = this.f2211D;
        this.f2243t = this.f2239p;
        this.f2244u = this.f2240q;
        this.f2245v = this.f2241r;
        this.f2246w = this.f2242s;
        this.f2248y = this.f2247x;
        this.f2234k = this.f2233j;
        this.f2211D = 0;
        this.f2213F = false;
        this.f2214G = 0;
        this.f2230g = null;
    }

    /* renamed from: q */
    private void m2125q() {
        do {
            m2116h();
            if (this.f2210C <= 0) {
                return;
            }
        } while (!m2113e());
    }

    public void free() {
        while (true) {
            GifFrame gifFrame = this.f2220M;
            if (gifFrame == null) {
                break;
            }
            gifFrame.image = null;
            this.f2220M = this.f2220M.nextFrame;
        }
        if (this.f2224a != null) {
            try {
                this.f2224a.close();
            } catch (Exception unused) {
            }
            this.f2224a = null;
        }
        this.f2223P = null;
    }

    public GifFrame getCurrentFrame() {
        return this.f2249z;
    }

    public int getDelay(int i) {
        this.f2214G = -1;
        if (i >= 0 && i < this.f2221N) {
            GifFrame frame = getFrame(i);
            if (frame != null) {
                this.f2214G = frame.delay;
            }
        }
        return this.f2214G;
    }

    public int[] getDelays() {
        GifFrame gifFrame = this.f2220M;
        int[] iArr = new int[this.f2221N];
        int i = 0;
        while (gifFrame != null && i < this.f2221N) {
            iArr[i] = gifFrame.delay;
            gifFrame = gifFrame.nextFrame;
            i++;
        }
        return iArr;
    }

    public GifFrame getFrame(int i) {
        GifFrame gifFrame = this.f2220M;
        int i2 = 0;
        while (gifFrame != null) {
            if (i2 == i) {
                return gifFrame;
            }
            gifFrame = gifFrame.nextFrame;
            i2++;
        }
        return null;
    }

    public int getFrameCount() {
        return this.f2221N;
    }

    public Bitmap getFrameImage(int i) {
        GifFrame frame = getFrame(i);
        if (frame == null) {
            return null;
        }
        return frame.image;
    }

    public Bitmap getImage() {
        return getFrameImage(0);
    }

    public int getLoopCount() {
        return this.f2228e;
    }

    public int getStatus() {
        return this.f2225b;
    }

    public GifFrame next() {
        GifFrame gifFrame;
        if (!this.f2208A) {
            this.f2208A = true;
            return this.f2220M;
        }
        if (this.f2225b == 0) {
            if (this.f2249z.nextFrame != null) {
                gifFrame = this.f2249z.nextFrame;
            }
            return this.f2249z;
        }
        this.f2249z = this.f2249z.nextFrame;
        if (this.f2249z == null) {
            gifFrame = this.f2220M;
        }
        return this.f2249z;
        this.f2249z = gifFrame;
        return this.f2249z;
    }

    public boolean parseOk() {
        return this.f2225b == -1;
    }

    public void reset() {
        this.f2249z = this.f2220M;
    }

    public void run() {
        if (this.f2224a != null) {
            m2111c();
            return;
        }
        if (this.f2223P != null) {
            m2110b();
        }
    }
}
