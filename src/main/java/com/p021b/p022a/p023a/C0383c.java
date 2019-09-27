package com.p021b.p022a.p023a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.ClipboardManager;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.method.CharacterPickerDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import bsh.org.objectweb.asm.Constants;
import com.androlua.BuildConfig;
import com.baidu.mobstat.Config;
import com.p021b.p022a.p024b.C0406a;
import com.p021b.p022a.p024b.C0408b;
import com.p021b.p022a.p024b.C0408b.C0409a;
import com.p021b.p022a.p024b.C0411d;
import com.p021b.p022a.p024b.C0412e.C0413a;
import com.p021b.p022a.p024b.C0414f;
import com.p021b.p022a.p024b.C0416h;
import com.p021b.p022a.p024b.C0417i;
import com.p021b.p022a.p024b.C0419k;
import com.p021b.p022a.p024b.C0419k.C0421a;
import com.p021b.p022a.p024b.C0424m;
import com.p021b.p022a.p024b.C0425n;
import com.p021b.p022a.p024b.C0428q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.b.a.a.c */
public class C0383c extends View implements C0413a {
    public static final int SCROLL_DOWN = 1;
    public static final int SCROLL_LEFT = 2;
    public static final int SCROLL_RIGHT = 3;
    public static final int SCROLL_UP = 0;

    /* renamed from: a */
    protected static float f2848a = 0.75f;

    /* renamed from: b */
    protected static float f2849b = 0.5f;

    /* renamed from: c */
    protected static int f2850c = 4;

    /* renamed from: d */
    protected static int f2851d = 16;

    /* renamed from: e */
    protected static long f2852e = 250;

    /* renamed from: u */
    private static SparseArray<String> f2853u = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f2854A = 0;

    /* renamed from: B */
    private Paint f2855B;

    /* renamed from: C */
    private int f2856C = 0;

    /* renamed from: D */
    private int f2857D = 0;

    /* renamed from: E */
    private boolean f2858E = false;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C0381b f2859F;

    /* renamed from: G */
    private ClipboardManager f2860G;

    /* renamed from: H */
    private float f2861H = 1.0f;

    /* renamed from: I */
    private int f2862I;

    /* renamed from: J */
    private int f2863J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C0401f f2864K;

    /* renamed from: L */
    private int f2865L;

    /* renamed from: M */
    private Typeface f2866M = Typeface.DEFAULT;

    /* renamed from: N */
    private Typeface f2867N = Typeface.DEFAULT_BOLD;

    /* renamed from: O */
    private Typeface f2868O = Typeface.create(Typeface.DEFAULT, 2);

    /* renamed from: P */
    private char f2869P;

    /* renamed from: Q */
    private boolean f2870Q;

    /* renamed from: R */
    private Paint f2871R;

    /* renamed from: S */
    private int f2872S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public final Runnable f2873T = new Runnable() {
        public void run() {
            C0383c.this.f2899w.mo2895c();
            if (!C0383c.this.mo2771d()) {
                C0383c.this.postDelayed(C0383c.this.f2873T, C0383c.f2852e);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: U */
    public final Runnable f2874U = new Runnable() {
        public void run() {
            C0383c.this.f2899w.mo2898d();
            if (!C0383c.this.mo2760c()) {
                C0383c.this.postDelayed(C0383c.this.f2874U, C0383c.f2852e);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: V */
    public final Runnable f2875V = new Runnable() {
        public void run() {
            C0383c.this.f2899w.mo2892b(false);
            if (C0383c.this.f2886i > 0 && C0383c.this.f2854A == C0383c.this.f2885h.mo2981b(C0383c.this.f2886i - 1)) {
                C0383c.this.postDelayed(C0383c.this.f2875V, C0383c.f2852e);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: W */
    public final Runnable f2876W = new Runnable() {
        public void run() {
            C0383c.this.f2899w.mo2888a(false);
            if (!C0383c.this.mo2774e() && C0383c.this.f2854A == C0383c.this.f2885h.mo2981b(C0383c.this.f2886i + 1)) {
                C0383c.this.postDelayed(C0383c.this.f2876W, C0383c.f2852e);
            }
        }
    };

    /* renamed from: aa */
    private int f2877aa;

    /* renamed from: ab */
    private long f2878ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public boolean f2879ac = false;

    /* renamed from: ad */
    private MotionEvent f2880ad;

    /* renamed from: ae */
    private float f2881ae;

    /* renamed from: af */
    private float f2882af;

    /* renamed from: f */
    protected boolean f2883f = false;

    /* renamed from: g */
    protected C0402g f2884g = new C0402g(this);
    /* access modifiers changed from: protected */

    /* renamed from: h */
    public C0414f f2885h = new C0414f((C0413a) this);

    /* renamed from: i */
    protected int f2886i = 0;

    /* renamed from: j */
    protected int f2887j = -1;

    /* renamed from: k */
    protected int f2888k = -1;

    /* renamed from: l */
    protected int f2889l = f2850c;

    /* renamed from: m */
    protected C0408b f2890m = new C0411d();

    /* renamed from: n */
    protected boolean f2891n = false;

    /* renamed from: o */
    protected boolean f2892o = false;

    /* renamed from: p */
    protected boolean f2893p = true;

    /* renamed from: q */
    protected int f2894q = 4;

    /* renamed from: r */
    protected boolean f2895r = false;

    /* renamed from: s */
    protected C0377a f2896s;

    /* renamed from: t */
    protected boolean f2897t = true;

    /* renamed from: v */
    private final Scroller f2898v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C0394a f2899w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C0396b f2900x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C0425n f2901y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C0400e f2902z;

    /* renamed from: com.b.a.a.c$a */
    private class C0394a implements C0421a {

        /* renamed from: b */
        private final C0419k f2920b;

        /* renamed from: c */
        private boolean f2921c;

        /* renamed from: d */
        private boolean f2922d;

        private C0394a() {
            this.f2920b = new C0419k(this);
            this.f2921c = false;
        }

        /* renamed from: b */
        private void m2482b(int i, int i2) {
            if (C0383c.this.f2879ac && VERSION.SDK_INT >= 16) {
                AccessibilityRecord.obtain();
                AccessibilityEvent obtain = AccessibilityEvent.obtain(Constants.ACC_DEPRECATED);
                int i3 = i - i2;
                if (i3 * i3 == 1) {
                    obtain.setMovementGranularity(1);
                }
                obtain.setAction(i > i2 ? Constants.ACC_INTERFACE : Constants.ACC_NATIVE);
                obtain.setFromIndex(Math.min(i, i2));
                obtain.setToIndex(Math.max(i, i2));
                C0383c.this.sendAccessibilityEventUnchecked(obtain);
            }
            if (this.f2921c) {
                if (i < C0383c.this.f2888k) {
                    if (i2 > C0383c.this.f2888k) {
                        C0383c.this.f2887j = C0383c.this.f2888k;
                    }
                    C0383c.this.f2887j = i2;
                    return;
                } else if (i2 < C0383c.this.f2887j) {
                    C0383c.this.f2888k = C0383c.this.f2887j;
                    C0383c.this.f2887j = i2;
                    return;
                }
                C0383c.this.f2888k = i2;
            }
        }

        /* renamed from: j */
        private char[] m2483j() {
            int e = C0383c.this.f2885h.mo2987e(C0383c.this.f2885h.mo2982c(C0383c.this.f2886i));
            C0383c.this.f2885h.mo2990f(e);
            int i = 0;
            int i2 = 0;
            while (C0383c.this.f2885h.mo2979a()) {
                char b = C0383c.this.f2885h.mo2980b();
                if ((b != ' ' && b != 9) || e + i2 >= C0383c.this.f2886i) {
                    break;
                }
                i2++;
            }
            int a = i2 + (C0383c.this.f2894q * C0406a.m2563a(C0383c.this.f2885h.subSequence(e, C0383c.this.f2886i - e)));
            if (a < 0) {
                return new char[]{10};
            }
            char[] cArr = new char[(a + 1)];
            cArr[0] = 10;
            C0383c.this.f2885h.mo2990f(e);
            while (i < a) {
                i++;
                cArr[i] = ' ';
            }
            return cArr;
        }

        /* renamed from: k */
        private void m2484k() {
            int d = C0383c.this.f2854A;
            mo2900e();
            if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                C0383c.this.m2438d(d, d + 1);
                C0383c.this.m2449h();
            }
            mo2901f();
        }

        /* renamed from: a */
        public void mo2879a() {
            this.f2920b.mo3035a(C0383c.this.f2885h);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0063, code lost:
            if (r3 != r8.f2919a.f2885h.mo2985d(r2)) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0173, code lost:
            if (r3 != r8.f2919a.f2885h.mo2985d(r2)) goto L_0x0065;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo2880a(char r9) {
            /*
                r8 = this;
                boolean r0 = r8.f2921c
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r8.mo2904i()
                r0 = 1
                goto L_0x000b
            L_0x000a:
                r0 = 0
            L_0x000b:
                com.b.a.a.c r2 = com.p021b.p022a.p023a.C0383c.this
                int r2 = r2.f2854A
                com.b.a.a.c r3 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r3 = r3.f2885h
                int r3 = r3.mo2985d(r2)
                r4 = 8
                if (r9 == r4) goto L_0x00d8
                r0 = 10
                if (r9 == r0) goto L_0x006e
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r0 = r0.f2885h
                com.b.a.a.c r4 = com.p021b.p022a.p023a.C0383c.this
                int r4 = r4.f2886i
                long r5 = java.lang.System.nanoTime()
                r0.mo2973a(r9, r4, r5)
                r8.mo2888a(r1)
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.a.f r0 = r0.f2864K
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r9)
                java.lang.String r9 = ""
                r4.append(r9)
                java.lang.String r9 = r4.toString()
                com.b.a.a.c r4 = com.p021b.p022a.p023a.C0383c.this
                int r4 = r4.f2886i
                r0.mo2877b(r9, r4, r1)
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                boolean r9 = r9.mo2995j()
                if (r9 == 0) goto L_0x0177
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                int r9 = r9.mo2985d(r2)
                if (r3 == r9) goto L_0x0067
            L_0x0065:
                int r2 = r2 + -1
            L_0x0067:
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                r9.m2448g(r2)
                goto L_0x0177
            L_0x006e:
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                boolean r0 = r0.f2893p
                if (r0 == 0) goto L_0x0091
                char[] r0 = r8.m2483j()
                com.b.a.a.c r4 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r4 = r4.f2885h
                com.b.a.a.c r5 = com.p021b.p022a.p023a.C0383c.this
                int r5 = r5.f2886i
                long r6 = java.lang.System.nanoTime()
                r4.mo2978a(r0, r5, r6)
                com.b.a.a.c r4 = com.p021b.p022a.p023a.C0383c.this
                int r4 = r4.f2886i
                int r0 = r0.length
                int r4 = r4 + r0
                r8.mo2881a(r4)
                goto L_0x00a3
            L_0x0091:
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r0 = r0.f2885h
                com.b.a.a.c r4 = com.p021b.p022a.p023a.C0383c.this
                int r4 = r4.f2886i
                long r5 = java.lang.System.nanoTime()
                r0.mo2973a(r9, r4, r5)
                r8.mo2888a(r1)
            L_0x00a3:
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r0 = r0.f2885h
                boolean r0 = r0.mo2995j()
                if (r0 == 0) goto L_0x00b9
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r0 = r0.f2885h
                int r0 = r0.mo2985d(r2)
                if (r3 == r0) goto L_0x00b9
                int r2 = r2 + -1
            L_0x00b9:
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.a.f r0 = r0.f2864K
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r9)
                java.lang.String r9 = ""
                r3.append(r9)
                java.lang.String r9 = r3.toString()
                com.b.a.a.c r3 = com.p021b.p022a.p023a.C0383c.this
                int r3 = r3.f2886i
                r0.mo2876a(r9, r3, r1)
                goto L_0x0067
            L_0x00d8:
                if (r0 == 0) goto L_0x00dc
                goto L_0x0177
            L_0x00dc:
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                int r0 = r0.f2886i
                if (r0 <= 0) goto L_0x0177
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.a.f r0 = r0.f2864K
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r9)
                java.lang.String r9 = ""
                r4.append(r9)
                java.lang.String r9 = r4.toString()
                com.b.a.a.c r4 = com.p021b.p022a.p023a.C0383c.this
                int r4 = r4.f2886i
                r0.mo2875a(r9, r4, r1)
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                int r0 = r0.f2886i
                int r0 = r0 - r1
                long r4 = java.lang.System.nanoTime()
                r9.mo2975a(r0, r4)
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                int r0 = r0.f2886i
                int r0 = r0 + -2
                char r9 = r9.charAt(r0)
                r0 = 55357(0xd83d, float:7.7572E-41)
                if (r9 == r0) goto L_0x0136
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                int r0 = r0.f2886i
                int r0 = r0 + -2
                char r9 = r9.charAt(r0)
                r0 = 55356(0xd83c, float:7.757E-41)
                if (r9 != r0) goto L_0x014a
            L_0x0136:
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                int r0 = r0.f2886i
                int r0 = r0 + -2
                long r4 = java.lang.System.nanoTime()
                r9.mo2975a(r0, r4)
                r8.mo2892b(r1)
            L_0x014a:
                r8.mo2892b(r1)
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                int r9 = r9.f2854A
                if (r9 >= r2) goto L_0x0161
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.a.c r0 = com.p021b.p022a.p023a.C0383c.this
                int r0 = r0.f2854A
                r9.m2448g(r0)
                goto L_0x0177
            L_0x0161:
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                boolean r9 = r9.mo2995j()
                if (r9 == 0) goto L_0x0177
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                com.b.a.b.f r9 = r9.f2885h
                int r9 = r9.mo2985d(r2)
                if (r3 == r9) goto L_0x0067
                goto L_0x0065
            L_0x0177:
                com.b.a.a.c r9 = com.p021b.p022a.p023a.C0383c.this
                r9.setEdited(r1)
                r8.mo2879a()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p023a.C0383c.C0394a.mo2880a(char):void");
        }

        /* renamed from: a */
        public void mo2881a(int i) {
            if (i < 0 || i >= C0383c.this.f2885h.mo2991g()) {
                C0428q.m2726a("Invalid caret position");
                return;
            }
            m2482b(C0383c.this.f2886i, i);
            C0383c.this.f2886i = i;
            m2484k();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo2882a(int i, int i2) {
            int i3 = C0383c.this.f2886i - i;
            if (i3 < 0) {
                i3 = 0;
            }
            int i4 = C0383c.this.f2886i + i2;
            int g = C0383c.this.f2885h.mo2991g() - 1;
            if (i4 > g) {
                i4 = g;
            }
            mo2890b(i3, i4 - i3, BuildConfig.FLAVOR);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo2883a(int i, int i2, String str) {
            boolean z;
            boolean z2;
            int i3;
            int i4;
            boolean z3 = false;
            if (this.f2921c) {
                i4 = C0383c.this.f2885h.mo2981b(C0383c.this.f2887j);
                i3 = C0383c.this.f2885h.mo2985d(i4);
                int i5 = C0383c.this.f2888k - C0383c.this.f2887j;
                if (i5 > 0) {
                    C0383c.this.f2886i = C0383c.this.f2887j;
                    C0383c.this.f2885h.mo2974a(C0383c.this.f2887j, i5, System.nanoTime());
                    z = i4 == C0383c.this.f2854A;
                    z2 = true;
                } else {
                    z2 = false;
                    z = true;
                }
                mo2896c(false);
            } else {
                i4 = C0383c.this.f2854A;
                i3 = C0383c.this.f2885h.mo2985d(C0383c.this.f2854A);
                z2 = false;
                z = true;
            }
            if (i2 > 0) {
                int b = C0383c.this.f2885h.mo2981b(i);
                if (b < i4) {
                    i3 = C0383c.this.f2885h.mo2985d(b);
                    i4 = b;
                }
                if (i4 != C0383c.this.f2854A) {
                    z = false;
                }
                C0383c.this.f2886i = i;
                C0383c.this.f2885h.mo2974a(i, i2, System.nanoTime());
                z2 = true;
            }
            if (str != null && str.length() > 0) {
                int b2 = C0383c.this.f2885h.mo2981b(i);
                if (b2 < i4) {
                    i4 = b2;
                    i3 = C0383c.this.f2885h.mo2985d(b2);
                }
                C0383c.this.f2885h.mo2978a(str.toCharArray(), C0383c.this.f2886i, System.nanoTime());
                C0383c.this.f2886i += str.length();
                z2 = true;
            }
            if (z2) {
                C0383c.this.setEdited(true);
                mo2879a();
            }
            int d = C0383c.this.f2854A;
            mo2900e();
            if (d == C0383c.this.f2854A) {
                z3 = z;
            }
            if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                if (C0383c.this.f2885h.mo2995j() && i3 != C0383c.this.f2885h.mo2985d(i4)) {
                    i4--;
                }
                if (!z3 || C0383c.this.f2885h.mo2995j()) {
                    C0383c.this.m2448g(i4);
                } else {
                    C0383c.this.m2438d(C0383c.this.f2854A, C0383c.this.f2854A + 1);
                }
            }
        }

        /* renamed from: a */
        public void mo2884a(int i, int i2, boolean z, boolean z2) {
            C0428q.m2727a(i >= 0 && i2 <= C0383c.this.f2885h.mo2991g() - 1 && i2 >= 0, "Invalid range to select");
            if (this.f2921c) {
                C0383c.this.m2454i();
            } else {
                C0383c.this.m2449h();
                if (z2) {
                    mo2896c(true);
                } else {
                    this.f2921c = true;
                }
            }
            C0383c.this.f2887j = i;
            C0383c.this.f2888k = C0383c.this.f2887j + i2;
            C0383c.this.f2886i = C0383c.this.f2888k;
            mo2901f();
            mo2900e();
            if (z2) {
                C0383c.this.f2902z.mo2874a(mo2902g(), C0383c.this.f2887j, C0383c.this.f2888k);
            }
            boolean b = C0383c.this.m2450h(C0383c.this.f2888k);
            if (z) {
                b = C0383c.this.m2450h(C0383c.this.f2887j);
            }
            if (!b) {
                C0383c.this.m2454i();
            }
        }

        /* renamed from: a */
        public void mo2885a(ClipboardManager clipboardManager) {
            mo2891b(clipboardManager);
            mo2904i();
        }

        /* renamed from: a */
        public void mo2886a(String str) {
            if (str != null) {
                C0383c.this.f2885h.mo2986d();
                mo2904i();
                int d = C0383c.this.f2854A;
                int d2 = C0383c.this.f2885h.mo2985d(d);
                C0383c.this.f2885h.mo2978a(str.toCharArray(), C0383c.this.f2886i, System.nanoTime());
                C0383c.this.f2885h.mo2988e();
                C0383c.this.f2886i += str.length();
                mo2900e();
                C0383c.this.setEdited(true);
                mo2879a();
                mo2901f();
                if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                    int i = (!C0383c.this.f2885h.mo2995j() || d2 == C0383c.this.f2885h.mo2985d(d)) ? d : d - 1;
                    if (d != C0383c.this.f2854A || C0383c.this.f2885h.mo2995j()) {
                        C0383c.this.m2448g(i);
                    } else {
                        C0383c.this.m2438d(i, i + 1);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo2887a(final List<C0424m> list) {
            C0383c.this.post(new Runnable() {
                public void run() {
                    C0383c.this.f2885h.mo2976a(list);
                    C0383c.this.invalidate();
                }
            });
        }

        /* renamed from: a */
        public void mo2888a(boolean z) {
            if (!C0383c.this.mo2774e()) {
                int d = C0383c.this.f2854A;
                C0383c.this.f2886i++;
                mo2900e();
                m2482b(C0383c.this.f2886i - 1, C0383c.this.f2886i);
                if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                    C0383c.this.m2438d(d, C0383c.this.f2854A + 1);
                }
                if (!z) {
                    mo2901f();
                }
            }
        }

        /* renamed from: b */
        public void mo2889b() {
            this.f2920b.mo3037b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo2890b(int i, int i2, String str) {
            boolean z;
            boolean z2;
            int i3;
            int i4;
            boolean z3 = false;
            if (this.f2921c) {
                i4 = C0383c.this.f2885h.mo2981b(C0383c.this.f2887j);
                i3 = C0383c.this.f2885h.mo2985d(i4);
                int i5 = C0383c.this.f2888k - C0383c.this.f2887j;
                if (i5 > 0) {
                    C0383c.this.f2886i = C0383c.this.f2887j;
                    C0383c.this.f2885h.mo2974a(C0383c.this.f2887j, i5, System.nanoTime());
                    z = i4 == C0383c.this.f2854A;
                    z2 = true;
                } else {
                    z2 = false;
                    z = true;
                }
                mo2896c(false);
            } else {
                i4 = C0383c.this.f2854A;
                i3 = C0383c.this.f2885h.mo2985d(C0383c.this.f2854A);
                z2 = false;
                z = true;
            }
            if (i2 > 0) {
                int b = C0383c.this.f2885h.mo2981b(i);
                if (b < i4) {
                    i3 = C0383c.this.f2885h.mo2985d(b);
                    i4 = b;
                }
                if (i4 != C0383c.this.f2854A) {
                    z = false;
                }
                C0383c.this.f2886i = i;
                C0383c.this.f2885h.mo2974a(i, i2, System.nanoTime());
                z2 = true;
            }
            if (str != null && str.length() > 0) {
                int b2 = C0383c.this.f2885h.mo2981b(i);
                if (b2 < i4) {
                    i3 = C0383c.this.f2885h.mo2985d(b2);
                    i4 = b2;
                }
                C0383c.this.f2885h.mo2978a(str.toCharArray(), C0383c.this.f2886i, System.nanoTime());
                C0383c.this.f2886i += str.length();
                z2 = true;
            }
            C0383c.this.f2864K.mo2877b(str, C0383c.this.f2886i, str.length() - i2);
            if (z2) {
                C0383c.this.setEdited(true);
                mo2879a();
            }
            int d = C0383c.this.f2854A;
            mo2900e();
            if (d == C0383c.this.f2854A) {
                z3 = z;
            }
            if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                if (C0383c.this.f2885h.mo2995j() && i3 != C0383c.this.f2885h.mo2985d(i4)) {
                    i4--;
                }
                if (!z3 || C0383c.this.f2885h.mo2995j()) {
                    C0383c.this.m2448g(i4);
                } else {
                    C0383c.this.m2438d(C0383c.this.f2854A, C0383c.this.f2854A + 1);
                }
            }
        }

        /* renamed from: b */
        public void mo2891b(ClipboardManager clipboardManager) {
            if (this.f2921c && C0383c.this.f2887j < C0383c.this.f2888k) {
                clipboardManager.setText(C0383c.this.f2885h.subSequence(C0383c.this.f2887j, C0383c.this.f2888k - C0383c.this.f2887j));
            }
        }

        /* renamed from: b */
        public void mo2892b(boolean z) {
            if (C0383c.this.f2886i > 0) {
                int d = C0383c.this.f2854A;
                C0383c.this.f2886i--;
                mo2900e();
                m2482b(C0383c.this.f2886i + 1, C0383c.this.f2886i);
                if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                    C0383c.this.m2438d(C0383c.this.f2854A, d + 1);
                }
                if (!z) {
                    mo2901f();
                }
            }
        }

        /* renamed from: b */
        public boolean mo2893b(int i) {
            boolean z = false;
            if (C0383c.this.f2887j < 0) {
                return false;
            }
            if (C0383c.this.f2887j <= i && i < C0383c.this.f2888k) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public String mo2894c(int i) {
            int g = C0383c.this.f2885h.mo2991g();
            return (C0383c.this.f2886i + i > g + -1 ? C0383c.this.f2885h.subSequence(C0383c.this.f2886i, (g - C0383c.this.f2886i) - 1) : C0383c.this.f2885h.subSequence(C0383c.this.f2886i, i)).toString();
        }

        /* renamed from: c */
        public void mo2895c() {
            if (!C0383c.this.mo2771d()) {
                int i = C0383c.this.f2886i;
                int d = C0383c.this.f2854A;
                int i2 = d + 1;
                int e = C0383c.this.mo2773e(i);
                int g = C0383c.this.f2885h.mo2992g(d);
                int g2 = C0383c.this.f2885h.mo2992g(i2);
                if (e < g2) {
                    C0383c.this.f2886i += g;
                } else {
                    C0383c.this.f2886i += ((g - e) + g2) - 1;
                }
                C0383c.m2456j(C0383c.this);
                m2482b(i, C0383c.this.f2886i);
                if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                    C0383c.this.m2438d(d, i2 + 1);
                }
                C0383c.this.f2901y.mo2873a(i2);
                mo2901f();
            }
        }

        /* renamed from: c */
        public void mo2896c(boolean z) {
            int i;
            C0383c cVar;
            if (this.f2921c ^ z) {
                if (z) {
                    C0383c.this.f2887j = C0383c.this.f2886i;
                    cVar = C0383c.this;
                    i = C0383c.this.f2886i;
                } else {
                    i = -1;
                    C0383c.this.f2887j = -1;
                    cVar = C0383c.this;
                }
                cVar.f2888k = i;
                this.f2921c = z;
                this.f2922d = z;
                C0383c.this.f2902z.mo2874a(z, C0383c.this.getSelectionStart(), C0383c.this.getSelectionEnd());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public String mo2897d(int i) {
            int i2 = C0383c.this.f2886i - i;
            if (i2 < 0) {
                i2 = 0;
            }
            return C0383c.this.f2885h.subSequence(i2, C0383c.this.f2886i - i2).toString();
        }

        /* renamed from: d */
        public void mo2898d() {
            if (!C0383c.this.mo2760c()) {
                int i = C0383c.this.f2886i;
                int d = C0383c.this.f2854A;
                int i2 = d - 1;
                int e = C0383c.this.mo2773e(i);
                int g = C0383c.this.f2885h.mo2992g(i2);
                if (e < g) {
                    C0383c.this.f2886i -= g;
                } else {
                    C0383c.this.f2886i -= e + 1;
                }
                C0383c.m2458l(C0383c.this);
                m2482b(i, C0383c.this.f2886i);
                if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                    C0383c.this.m2438d(i2, d + 1);
                }
                C0383c.this.f2901y.mo2873a(i2);
                mo2901f();
            }
        }

        /* renamed from: d */
        public void mo2899d(boolean z) {
            C0383c cVar;
            int i;
            if (this.f2921c) {
                if (z && C0383c.this.f2886i != C0383c.this.f2887j) {
                    cVar = C0383c.this;
                    i = C0383c.this.f2887j;
                } else if (!z && C0383c.this.f2886i != C0383c.this.f2888k) {
                    cVar = C0383c.this;
                    i = C0383c.this.f2888k;
                }
                cVar.f2886i = i;
                m2484k();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo2900e() {
            int b = C0383c.this.f2885h.mo2981b(C0383c.this.f2886i);
            if (C0383c.this.f2854A != b) {
                C0383c.this.f2854A = b;
                C0383c.this.f2901y.mo2873a(b);
            }
        }

        /* renamed from: f */
        public void mo2901f() {
            ((InputMethodManager) C0383c.this.getContext().getSystemService("input_method")).restartInput(C0383c.this);
            if (C0383c.this.f2900x != null && C0383c.this.f2900x.mo2907b()) {
                C0383c.this.f2900x.mo2906a();
            }
        }

        /* renamed from: g */
        public final boolean mo2902g() {
            return this.f2921c;
        }

        /* renamed from: h */
        public final boolean mo2903h() {
            return this.f2922d;
        }

        /* renamed from: i */
        public void mo2904i() {
            if (this.f2921c) {
                int i = C0383c.this.f2888k - C0383c.this.f2887j;
                if (i > 0) {
                    int b = C0383c.this.f2885h.mo2981b(C0383c.this.f2887j);
                    int d = C0383c.this.f2885h.mo2985d(b);
                    boolean z = C0383c.this.f2885h.mo2981b(C0383c.this.f2888k) == b;
                    C0383c.this.f2864K.mo2875a((CharSequence) BuildConfig.FLAVOR, C0383c.this.f2886i, i);
                    C0383c.this.f2885h.mo2974a(C0383c.this.f2887j, i, System.nanoTime());
                    C0383c.this.f2886i = C0383c.this.f2887j;
                    mo2900e();
                    C0383c.this.setEdited(true);
                    mo2879a();
                    mo2896c(false);
                    mo2901f();
                    if (!C0383c.this.m2450h(C0383c.this.f2886i)) {
                        if (C0383c.this.f2885h.mo2995j() && d != C0383c.this.f2885h.mo2985d(b)) {
                            b--;
                        }
                        if (!z || C0383c.this.f2885h.mo2995j()) {
                            C0383c.this.m2448g(b);
                        } else {
                            C0383c.this.m2438d(b, b + 1);
                        }
                    }
                } else {
                    mo2896c(false);
                    C0383c.this.m2449h();
                }
            }
        }
    }

    /* renamed from: com.b.a.a.c$b */
    private class C0396b extends BaseInputConnection {

        /* renamed from: b */
        private boolean f2926b = false;

        /* renamed from: c */
        private int f2927c = 0;

        public C0396b(C0383c cVar) {
            super(cVar, true);
        }

        /* renamed from: a */
        public void mo2906a() {
            this.f2927c = 0;
            this.f2926b = false;
            C0383c.this.f2885h.mo2988e();
        }

        /* renamed from: b */
        public boolean mo2907b() {
            return this.f2926b;
        }

        public boolean commitText(CharSequence charSequence, int i) {
            C0383c.this.f2899w.mo2890b(C0383c.this.getCaretPosition() - this.f2927c, this.f2927c, charSequence.toString());
            this.f2927c = 0;
            C0383c.this.f2885h.mo2988e();
            if (i > 1) {
                C0383c.this.f2899w.mo2881a((C0383c.this.f2886i + i) - 1);
            } else if (i <= 0) {
                C0383c.this.f2899w.mo2881a((C0383c.this.f2886i - charSequence.length()) - i);
            }
            this.f2926b = false;
            return true;
        }

        public boolean deleteSurroundingText(int i, int i2) {
            if (this.f2927c != 0) {
                Log.i("lua", "Warning: Implmentation of InputConnection.deleteSurroundingText will not skip composing text");
            }
            C0383c.this.f2899w.mo2882a(i, i2);
            return true;
        }

        public boolean finishComposingText() {
            mo2906a();
            return true;
        }

        public int getCursorCapsMode(int i) {
            boolean z = true;
            if ((i & 8192) == 8192) {
                int i2 = C0383c.this.f2886i - 1;
                if (i2 < 0 || C0419k.m2664a().mo3015b(C0383c.this.f2885h.charAt(i2))) {
                    return (i & 16384) == 16384 ? 24576 : 8192;
                }
            } else {
                C0416h a = C0419k.m2664a();
                int i3 = C0383c.this.f2886i - 1;
                int i4 = 0;
                while (true) {
                    if (i3 < 0) {
                        break;
                    }
                    char charAt = C0383c.this.f2885h.charAt(i3);
                    if (charAt == 10) {
                        break;
                    } else if (a.mo3015b(charAt)) {
                        i4++;
                        i3--;
                    } else if (i4 == 0 || !a.mo3019c(charAt)) {
                        z = false;
                    }
                }
                if (z) {
                    return 16384;
                }
            }
            return 0;
        }

        public CharSequence getTextAfterCursor(int i, int i2) {
            return C0383c.this.f2899w.mo2894c(i);
        }

        public CharSequence getTextBeforeCursor(int i, int i2) {
            return C0383c.this.f2899w.mo2897d(i);
        }

        public boolean performContextMenuAction(int i) {
            switch (i) {
                case 16908319:
                    C0383c.this.selectAll();
                    break;
                case 16908320:
                    C0383c.this.cut();
                    break;
                case 16908321:
                    C0383c.this.copy();
                    break;
                case 16908322:
                    C0383c.this.paste();
                    break;
                default:
                    switch (i) {
                        case 16908328:
                        case 16908329:
                            break;
                    }
                    C0383c.this.selectAll();
                    break;
            }
            return false;
        }

        public boolean reportFullscreenMode(boolean z) {
            return false;
        }

        public boolean sendKeyEvent(KeyEvent keyEvent) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 59) {
                switch (keyCode) {
                    case 19:
                        C0383c.this.moveCaretUp();
                        return true;
                    case 20:
                        C0383c.this.moveCaretDown();
                        return true;
                    case 21:
                        C0383c.this.moveCaretLeft();
                        return true;
                    case 22:
                        C0383c.this.moveCaretRight();
                        return true;
                    default:
                        switch (keyCode) {
                            case 122:
                                C0383c.this.moveCaret(0);
                                return true;
                            case 123:
                                C0383c.this.moveCaret(C0383c.this.f2885h.length());
                                return true;
                            default:
                                return super.sendKeyEvent(keyEvent);
                        }
                }
            } else if (C0383c.this.isSelectText()) {
                C0383c.this.selectText(false);
                return true;
            } else {
                C0383c.this.selectText(true);
                return true;
            }
        }

        public boolean setComposingText(CharSequence charSequence, int i) {
            this.f2926b = true;
            if (!C0383c.this.f2885h.mo2983c()) {
                C0383c.this.f2885h.mo2986d();
            }
            C0383c.this.f2899w.mo2890b(C0383c.this.getCaretPosition() - this.f2927c, this.f2927c, charSequence.toString());
            this.f2927c = charSequence.length();
            if (i > 1) {
                C0383c.this.f2899w.mo2881a((C0383c.this.f2886i + i) - 1);
                return true;
            }
            if (i <= 0) {
                C0383c.this.f2899w.mo2881a((C0383c.this.f2886i - charSequence.length()) - i);
            }
            return true;
        }

        public boolean setSelection(int i, int i2) {
            if (i == i2) {
                C0383c.this.f2899w.mo2881a(i);
                return true;
            }
            C0383c.this.f2899w.mo2884a(i, i2 - i, false, true);
            return true;
        }
    }

    /* renamed from: com.b.a.a.c$c */
    public static class C0397c implements Parcelable {
        public static final Creator<C0397c> CREATOR = new Creator<C0397c>() {
            /* renamed from: a */
            public C0397c createFromParcel(Parcel parcel) {
                return new C0397c(parcel);
            }

            /* renamed from: a */
            public C0397c[] newArray(int i) {
                return new C0397c[i];
            }
        };

        /* renamed from: a */
        final int f2928a;

        /* renamed from: b */
        final int f2929b;

        /* renamed from: c */
        final int f2930c;

        /* renamed from: d */
        final boolean f2931d;

        /* renamed from: e */
        final int f2932e;

        /* renamed from: f */
        final int f2933f;

        private C0397c(Parcel parcel) {
            this.f2928a = parcel.readInt();
            this.f2929b = parcel.readInt();
            this.f2930c = parcel.readInt();
            this.f2931d = parcel.readInt() != 0;
            this.f2932e = parcel.readInt();
            this.f2933f = parcel.readInt();
        }

        public C0397c(C0383c cVar) {
            this.f2928a = cVar.getCaretPosition();
            this.f2929b = cVar.getScrollX();
            this.f2930c = cVar.getScrollY();
            this.f2931d = cVar.isSelectText();
            this.f2932e = cVar.getSelectionStart();
            this.f2933f = cVar.getSelectionEnd();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2928a);
            parcel.writeInt(this.f2929b);
            parcel.writeInt(this.f2930c);
            parcel.writeInt(this.f2931d ? 1 : 0);
            parcel.writeInt(this.f2932e);
            parcel.writeInt(this.f2933f);
        }
    }

    static {
        f2853u.put(65, "ÀÁÂÄÆÃÅĄĀ");
        f2853u.put(67, "ÇĆČ");
        f2853u.put(68, "Ď");
        f2853u.put(69, "ÈÉÊËĘĚĒ");
        f2853u.put(71, "Ğ");
        f2853u.put(76, "Ł");
        f2853u.put(73, "ÌÍÎÏĪİ");
        f2853u.put(78, "ÑŃŇ");
        f2853u.put(79, "ØŒÕÒÓÔÖŌ");
        f2853u.put(82, "Ř");
        f2853u.put(83, "ŚŠŞ");
        f2853u.put(84, "Ť");
        f2853u.put(85, "ÙÚÛÜŮŪ");
        f2853u.put(89, "ÝŸ");
        f2853u.put(90, "ŹŻŽ");
        f2853u.put(97, "àáâäæãåąā");
        f2853u.put(99, "çćč");
        f2853u.put(100, "ď");
        f2853u.put(101, "èéêëęěē");
        f2853u.put(103, "ğ");
        f2853u.put(105, "ìíîïīı");
        f2853u.put(108, "ł");
        f2853u.put(110, "ñńň");
        f2853u.put(111, "øœõòóôöō");
        f2853u.put(114, "ř");
        f2853u.put(115, "§ßśšş");
        f2853u.put(116, "ť");
        f2853u.put(117, "ùúûüůū");
        f2853u.put(121, "ýÿ");
        f2853u.put(122, "źżž");
        f2853u.put(61185, "…¥•®©±[]{}\\|");
        f2853u.put(47, "\\");
        f2853u.put(49, "¹½⅓¼⅛");
        f2853u.put(50, "²⅔");
        f2853u.put(51, "³¾⅜");
        f2853u.put(52, "⁴");
        f2853u.put(53, "⅝");
        f2853u.put(55, "⅞");
        f2853u.put(48, "ⁿ∅");
        f2853u.put(36, "¢£€¥₣₤₱");
        f2853u.put(37, "‰");
        f2853u.put(42, "†‡");
        f2853u.put(45, "–—");
        f2853u.put(43, "±");
        f2853u.put(40, "[{<");
        f2853u.put(41, "]}>");
        f2853u.put(33, "¡");
        f2853u.put(34, "“”«»˝");
        f2853u.put(63, "¿");
        f2853u.put(44, "‚„");
        f2853u.put(61, "≠≈∞");
        f2853u.put(60, "≤«‹");
        f2853u.put(62, "≥»›");
    }

    public C0383c(Context context) {
        super(context);
        this.f2898v = new Scroller(context);
        m2445f();
    }

    public C0383c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2898v = new Scroller(context);
        m2445f();
    }

    public C0383c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2898v = new Scroller(context);
        m2445f();
    }

    /* renamed from: a */
    private int m2417a(Canvas canvas) {
        return canvas.getClipBounds().top / mo2751a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008f, code lost:
        r23.drawText(r8, 0, 1, (float) r2, (float) r3, r0.f2855B);
        r0.f2855B.setColor(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009f, code lost:
        return r5;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m2418a(android.graphics.Canvas r23, char r24, int r25, int r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r2 = r25
            r3 = r26
            android.graphics.Paint r4 = r0.f2855B
            int r4 = r4.getColor()
            int r5 = r0.getAdvance(r1, r2)
            int r6 = r22.getScrollX()
            if (r2 > r6) goto L_0x0023
            int r6 = r22.getScrollX()
            int r7 = r22.getContentWidth()
            int r6 = r6 + r7
            if (r2 >= r6) goto L_0x00b9
        L_0x0023:
            switch(r1) {
                case 9: goto L_0x007c;
                case 10: goto L_0x0068;
                case 32: goto L_0x0046;
                case 55356: goto L_0x0043;
                case 55357: goto L_0x0043;
                case 65535: goto L_0x0068;
                default: goto L_0x0026;
            }
        L_0x0026:
            char r4 = r0.f2869P
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x00a0
            r4 = 2
            char[] r9 = new char[r4]
            char r4 = r0.f2869P
            r9[r7] = r4
            r9[r6] = r1
            r10 = 0
            r11 = 2
            float r12 = (float) r2
            float r13 = (float) r3
            android.graphics.Paint r14 = r0.f2855B
            r8 = r23
            r8.drawText(r9, r10, r11, r12, r13, r14)
            r0.f2869P = r7
            return r5
        L_0x0043:
            r0.f2869P = r1
            return r5
        L_0x0046:
            boolean r1 = r0.f2892o
            if (r1 == 0) goto L_0x005a
            android.graphics.Paint r1 = r0.f2855B
            com.b.a.b.b r6 = r0.f2890m
            com.b.a.b.b$a r7 = com.p021b.p022a.p024b.C0408b.C0409a.NON_PRINTING_GLYPH
            int r6 = r6.mo2957a(r7)
            r1.setColor(r6)
            java.lang.String r8 = "·"
            goto L_0x008f
        L_0x005a:
            java.lang.String r7 = " "
            r8 = 0
            r9 = 1
            float r10 = (float) r2
            float r11 = (float) r3
            android.graphics.Paint r12 = r0.f2855B
            r6 = r23
            r6.drawText(r7, r8, r9, r10, r11, r12)
            return r5
        L_0x0068:
            boolean r1 = r0.f2892o
            if (r1 == 0) goto L_0x00b9
            android.graphics.Paint r1 = r0.f2855B
            com.b.a.b.b r6 = r0.f2890m
            com.b.a.b.b$a r7 = com.p021b.p022a.p024b.C0408b.C0409a.NON_PRINTING_GLYPH
            int r6 = r6.mo2957a(r7)
            r1.setColor(r6)
            java.lang.String r8 = "↵"
            goto L_0x008f
        L_0x007c:
            boolean r1 = r0.f2892o
            if (r1 == 0) goto L_0x00b9
            android.graphics.Paint r1 = r0.f2855B
            com.b.a.b.b r6 = r0.f2890m
            com.b.a.b.b$a r7 = com.p021b.p022a.p024b.C0408b.C0409a.NON_PRINTING_GLYPH
            int r6 = r6.mo2957a(r7)
            r1.setColor(r6)
            java.lang.String r8 = "»"
        L_0x008f:
            r9 = 0
            r10 = 1
            float r11 = (float) r2
            float r12 = (float) r3
            android.graphics.Paint r13 = r0.f2855B
            r7 = r23
            r7.drawText(r8, r9, r10, r11, r12, r13)
            android.graphics.Paint r1 = r0.f2855B
            r1.setColor(r4)
            return r5
        L_0x00a0:
            char[] r4 = new char[r6]
            r4[r7] = r1
            r17 = 0
            r18 = 1
            float r1 = (float) r2
            float r2 = (float) r3
            android.graphics.Paint r3 = r0.f2855B
            r15 = r23
            r16 = r4
            r19 = r1
            r20 = r2
            r21 = r3
            r15.drawText(r16, r17, r18, r19, r20, r21)
        L_0x00b9:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p023a.C0383c.m2418a(android.graphics.Canvas, char, int, int):int");
    }

    /* renamed from: a */
    private int m2419a(Canvas canvas, String str, int i, int i2) {
        canvas.drawText(str, (float) i, (float) i2, this.f2871R);
        return 0;
    }

    /* renamed from: a */
    private void m2421a(char c) {
        C0394a aVar;
        if (!Character.isLowerCase(c) || c != this.f2885h.charAt(this.f2886i - 1)) {
            aVar = this.f2899w;
        } else {
            this.f2899w.mo2880a(8);
            aVar = this.f2899w;
            c = Character.toUpperCase(c);
        }
        aVar.mo2880a(c);
    }

    /* renamed from: a */
    private void m2422a(float f, float f2) {
        int scrollX = ((int) f) + getScrollX();
        int scrollY = ((int) f2) + getScrollY();
        int max = Math.max(getMaxScrollX(), getScrollX());
        if (scrollX > max) {
            scrollX = max;
        } else if (scrollX < 0) {
            scrollX = 0;
        }
        int max2 = Math.max(getMaxScrollY(), getScrollY());
        if (scrollY > max2) {
            scrollY = max2;
        } else if (scrollY < 0) {
            scrollY = 0;
        }
        smoothScrollTo(scrollX, scrollY);
    }

    /* renamed from: a */
    private void m2423a(int i, KeyEvent keyEvent) {
        if (keyEvent.isShiftPressed() && !isSelectText()) {
            m2449h();
            this.f2899w.mo2896c(true);
        } else if (!keyEvent.isShiftPressed() && isSelectText()) {
            m2454i();
            this.f2899w.mo2896c(false);
        }
        switch (i) {
            case 19:
                this.f2899w.mo2898d();
                return;
            case 20:
                this.f2899w.mo2895c();
                return;
            case 21:
                this.f2899w.mo2892b(false);
                return;
            case 22:
                this.f2899w.mo2888a(false);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m2424a(Canvas canvas, int i, int i2) {
        int color = this.f2855B.getColor();
        this.f2862I = i;
        this.f2863J = i2;
        this.f2855B.setColor(this.f2890m.mo2957a(C0409a.CARET_DISABLED));
        m2425a(canvas, i - 1, i2, 2);
        this.f2855B.setColor(color);
    }

    /* renamed from: a */
    private void m2425a(Canvas canvas, int i, int i2, int i3) {
        FontMetricsInt fontMetricsInt = this.f2855B.getFontMetricsInt();
        canvas.drawRect((float) i, (float) (fontMetricsInt.ascent + i2), (float) (i + i3), (float) (i2 + fontMetricsInt.descent), this.f2855B);
    }

    /* renamed from: a */
    private void m2428a(String str, final boolean z) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Selection.setSelection(spannableStringBuilder, 0);
        CharacterPickerDialog characterPickerDialog = new CharacterPickerDialog(getContext(), this, spannableStringBuilder, str, true);
        characterPickerDialog.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (spannableStringBuilder.length() > 0) {
                    if (z) {
                        C0383c.this.f2899w.mo2880a(8);
                    }
                    C0383c.this.f2899w.mo2880a(spannableStringBuilder.charAt(0));
                }
            }
        });
        characterPickerDialog.show();
    }

    /* renamed from: b */
    private int m2429b(Canvas canvas) {
        return (canvas.getClipBounds().bottom - 1) / mo2751a();
    }

    /* renamed from: b */
    private int m2430b(Canvas canvas, char c, int i, int i2) {
        int color = this.f2855B.getColor();
        int advance = getAdvance(c);
        this.f2855B.setColor(this.f2890m.mo2957a(C0409a.SELECTION_BACKGROUND));
        m2425a(canvas, i, i2, advance);
        this.f2855B.setColor(this.f2890m.mo2957a(C0409a.SELECTION_FOREGROUND));
        m2418a(canvas, c, i, i2);
        this.f2855B.setColor(color);
        return advance;
    }

    /* renamed from: b */
    private void m2432b(char c) {
        String str = (String) f2853u.get(Character.isUpperCase(this.f2885h.charAt(this.f2886i - 1)) ? Character.toUpperCase(c) : c);
        if (str != null) {
            this.f2899w.mo2901f();
            m2428a(str, true);
            return;
        }
        this.f2899w.mo2880a(c);
    }

    /* renamed from: c */
    private void m2436c(Canvas canvas) {
        int a;
        int i;
        C0424m mVar;
        Paint paint;
        Typeface typeface;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Typeface typeface2;
        int i9;
        int i10;
        C0424m mVar2;
        int i11;
        Canvas canvas2 = canvas;
        int a2 = m2417a(canvas);
        int d = this.f2885h.mo2985d(a2);
        if (d >= 0) {
            this.f2885h.length();
            int c = isWordWrap() ? this.f2885h.mo2982c(d) + 1 : a2 + 1;
            if (this.f2858E) {
                Paint paint2 = this.f2871R;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f2885h.mo2989f());
                sb.append(" ");
                this.f2857D = (int) paint2.measureText(sb.toString());
            }
            int b = m2429b(canvas);
            int paintBaseline = getPaintBaseline(a2);
            List i12 = this.f2885h.mo2994i();
            C0428q.m2727a(!i12.isEmpty(), "No spans to paint in TextWarrior.paint()");
            if (i12.isEmpty()) {
                i12.add(new C0424m(0, 0));
            }
            C0424m mVar3 = (C0424m) i12.get(0);
            int size = i12.size();
            int i13 = 0;
            int i14 = 1;
            while (true) {
                a = i13 + mVar3.mo3047a();
                if (i14 < size) {
                    i = i14 + 1;
                    mVar = (C0424m) i12.get(i14);
                } else {
                    i = i14;
                    mVar = null;
                }
                if (mVar == null || a > d) {
                    int b2 = mVar3.mo3049b();
                    int b3 = mVar3.mo3049b();
                } else {
                    i13 = a;
                    mVar3 = mVar;
                    i14 = i;
                }
            }
            int b22 = mVar3.mo3049b();
            int b32 = mVar3.mo3049b();
            if (b32 == 1) {
                paint = this.f2855B;
                typeface = this.f2867N;
            } else if (b32 != 30) {
                paint = this.f2855B;
                typeface = this.f2866M;
            } else {
                paint = this.f2855B;
                typeface = this.f2868O;
            }
            paint.setTypeface(typeface);
            this.f2855B.setColor(this.f2890m.mo2956a(mVar3.mo3049b()));
            int f = this.f2885h.mo2989f();
            if (this.f2858E) {
                this.f2871R.setColor(this.f2890m.mo2957a(C0409a.NON_PRINTING_GLYPH));
                i4 = a2;
                i3 = d;
                i7 = 30;
                i8 = f;
                i5 = b22;
                i6 = a;
                i2 = size;
                canvas2.drawLine((float) (this.f2857D - (this.f2877aa / 2)), (float) getScrollY(), (float) (this.f2857D - (this.f2877aa / 2)), (float) (getScrollY() + getHeight()), this.f2871R);
            } else {
                i5 = b22;
                i6 = a;
                i2 = size;
                i4 = a2;
                i3 = d;
                i7 = 30;
                i8 = f;
            }
            Typeface typeface3 = i5 != 1 ? i5 != i7 ? this.f2866M : this.f2868O : this.f2867N;
            this.f2855B.setTypeface(typeface3);
            Typeface typeface4 = typeface3;
            int i15 = i4;
            int i16 = 0;
            while (i15 <= b) {
                int g = this.f2885h.mo2992g(i15);
                if (i15 >= i8) {
                    break;
                }
                if (this.f2858E && c != i16) {
                    m2419a(canvas2, String.valueOf(c), 0, paintBaseline);
                    i16 = c;
                }
                int i17 = i16;
                Typeface typeface5 = typeface4;
                int i18 = this.f2857D;
                int i19 = i8;
                int i20 = i5;
                C0424m mVar4 = mVar;
                int i21 = i;
                int i22 = 0;
                int i23 = i6;
                int i24 = i3;
                while (i22 < g) {
                    if (mVar4 == null || i24 < i23) {
                        int i25 = i20;
                        i10 = i2;
                        typeface2 = typeface5;
                        int i26 = i21;
                        mVar2 = mVar4;
                        i11 = i25;
                        i9 = i26;
                    } else {
                        i23 += mVar4.mo3047a();
                        i11 = mVar4.mo3049b();
                        if (i20 != i11) {
                            Typeface typeface6 = i11 != 1 ? i11 != 30 ? this.f2866M : this.f2868O : this.f2867N;
                            if (typeface5 != typeface6) {
                                this.f2855B.setTypeface(typeface6);
                                typeface5 = typeface6;
                            }
                            Typeface typeface7 = typeface5;
                            this.f2855B.setColor(this.f2890m.mo2956a(i11));
                            i10 = i2;
                            typeface5 = typeface7;
                        } else {
                            i10 = i2;
                        }
                        if (i21 < i10) {
                            i9 = i21 + 1;
                            mVar2 = (C0424m) i12.get(i21);
                            typeface2 = typeface5;
                        } else {
                            typeface2 = typeface5;
                            i9 = i21;
                            mVar2 = null;
                        }
                    }
                    if (i24 == this.f2886i) {
                        m2424a(canvas2, i18, paintBaseline);
                    }
                    char charAt = this.f2885h.charAt(i24);
                    i18 += this.f2899w.mo2893b(i24) ? m2430b(canvas2, charAt, i18, paintBaseline) : m2418a(canvas2, charAt, i18, paintBaseline);
                    i24++;
                    i22++;
                    i2 = i10;
                    typeface5 = typeface2;
                    g = g;
                    i20 = i11;
                    mVar4 = mVar2;
                    i21 = i9;
                }
                int i27 = i20;
                int i28 = i2;
                if (this.f2885h.charAt(i24 - 1) == 10) {
                    c++;
                }
                paintBaseline += mo2751a();
                if (i18 > this.f2856C) {
                    this.f2856C = i18;
                }
                i15++;
                typeface4 = typeface5;
                i = i21;
                i2 = i28;
                i3 = i24;
                i6 = i23;
                i5 = i27;
                i16 = i17;
                i8 = i19;
                mVar = mVar4;
            }
            m2441e(canvas);
            if (!isWordWrap()) {
                m2439d(canvas);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2438d(int i, int i2) {
        C0428q.m2727a(i <= i2 && i >= 0, "Invalid startRow and/or endRow");
        Rect a = this.f2884g.mo2926a();
        super.invalidate(0, Math.max(0, ((i * mo2751a()) + getPaddingTop()) - Math.max(a.top, this.f2855B.getFontMetricsInt().descent)), getScrollX() + getWidth(), (i2 * mo2751a()) + getPaddingTop() + a.bottom);
    }

    /* renamed from: d */
    private void m2439d(Canvas canvas) {
        ArrayList d = C0419k.m2667d();
        if (d != null && !d.isEmpty()) {
            Rect clipBounds = canvas.getClipBounds();
            int i = clipBounds.top;
            int i2 = clipBounds.bottom;
            Iterator it = d.iterator();
            while (it.hasNext()) {
                Rect rect = (Rect) it.next();
                int a = (rect.top + 1) * mo2751a();
                int a2 = rect.bottom * mo2751a();
                if (a2 >= i && a <= i2) {
                    float min = (float) Math.min(mo2756b(rect.left).mo3047a(), mo2756b(rect.right).mo3047a());
                    canvas.drawLine(min, (float) a, min, (float) a2, this.f2871R);
                }
            }
        }
    }

    /* renamed from: e */
    private void m2441e(Canvas canvas) {
        if (this.f2891n) {
            int paintBaseline = getPaintBaseline(this.f2854A);
            int color = this.f2855B.getColor();
            this.f2855B.setColor(this.f2890m.mo2957a(C0409a.LINE_HIGHLIGHT));
            m2425a(canvas, 0, paintBaseline, Math.max(this.f2856C, getContentWidth()));
            this.f2855B.setColor(color);
        }
    }

    /* renamed from: e */
    private final boolean m2442e(int i, int i2) {
        return i >= 0 && i < getWidth() && i2 >= 0 && i2 < getHeight();
    }

    /* renamed from: f */
    private int m2443f(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            return size;
        }
        C0428q.m2726a("MeasureSpec cannot be UNSPECIFIED. Setting dimensions to max.");
        return Integer.MAX_VALUE;
    }

    /* renamed from: f */
    private void m2445f() {
        this.f2879ac = ((AccessibilityManager) getContext().getSystemService("accessibility")).isTouchExplorationEnabled();
        this.f2899w = new C0394a();
        this.f2860G = (ClipboardManager) getContext().getSystemService("clipboard");
        this.f2855B = new Paint();
        this.f2855B.setAntiAlias(true);
        this.f2855B.setTextSize((float) f2851d);
        this.f2871R = new Paint();
        this.f2871R.setAntiAlias(true);
        this.f2871R.setTextSize((float) f2851d);
        setLongClickable(true);
        setFocusableInTouchMode(true);
        setHapticFeedbackEnabled(true);
        this.f2901y = new C0425n() {
            /* renamed from: a */
            public void mo2873a(int i) {
            }
        };
        this.f2902z = new C0400e() {
            /* renamed from: a */
            public void mo2874a(boolean z, int i, int i2) {
                if (z) {
                    C0383c.this.f2859F.mo2743a();
                } else {
                    C0383c.this.f2859F.mo2744b();
                }
            }
        };
        this.f2864K = new C0401f() {
            /* renamed from: a */
            public void mo2875a(CharSequence charSequence, int i, int i2) {
                if (C0383c.this.f2879ac) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain(16);
                    obtain.setFromIndex(i - i2);
                    obtain.setRemovedCount(i2);
                    obtain.setBeforeText(C0383c.this.f2885h);
                    C0383c.this.sendAccessibilityEventUnchecked(obtain);
                }
                C0383c.this.f2896s.mo2732b();
            }

            /* renamed from: a */
            public void mo2876a(String str, int i, int i2) {
                if (C0383c.this.f2879ac) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain(16);
                    obtain.setFromIndex(i - 1);
                    obtain.setAddedCount(1);
                    C0383c.this.sendAccessibilityEventUnchecked(obtain);
                }
                C0383c.this.f2896s.mo2732b();
            }

            /* renamed from: b */
            public void mo2877b(CharSequence charSequence, int i, int i2) {
                if (C0383c.this.f2879ac) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain(16);
                    obtain.setFromIndex(i - i2);
                    obtain.setAddedCount(i2);
                    C0383c.this.sendAccessibilityEventUnchecked(obtain);
                }
                if (C0383c.this.f2897t) {
                    int i3 = C0383c.this.f2886i;
                    while (i3 >= 0) {
                        char charAt = C0383c.this.f2885h.charAt(i3 - 1);
                        if (!Character.isLetterOrDigit(charAt) && charAt != '_' && charAt != '.') {
                            break;
                        }
                        i3--;
                    }
                    if (C0383c.this.f2886i - i3 > 0) {
                        C0383c.this.f2896s.mo2731a(C0383c.this.f2885h.subSequence(i3, C0383c.this.f2886i - i3));
                    } else {
                        C0383c.this.f2896s.mo2732b();
                    }
                }
            }
        };
        m2447g();
        this.f2859F = new C0381b(this);
        this.f2896s = new C0377a(this);
        this.f2896s.mo2730a(C0417i.m2650g());
        invalidate();
    }

    /* renamed from: g */
    private void m2447g() {
        this.f2886i = 0;
        this.f2854A = 0;
        this.f2856C = 0;
        this.f2899w.mo2896c(false);
        this.f2899w.mo2901f();
        this.f2885h.mo2993h();
        if (getContentWidth() > 0 || !this.f2885h.mo2995j()) {
            this.f2885h.mo2996k();
        }
        this.f2901y.mo2873a(0);
        scrollTo(0, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m2448g(int i) {
        C0428q.m2727a(i >= 0, "Invalid startRow");
        super.invalidate(0, Math.max(0, ((i * mo2751a()) + getPaddingTop()) - Math.max(this.f2884g.mo2926a().top, this.f2855B.getFontMetricsInt().descent)), getScrollX() + getWidth(), getScrollY() + getHeight());
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m2449h() {
        m2438d(this.f2854A, this.f2854A + 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m2450h(int i) {
        C0428q.m2727a(i >= 0 && i < this.f2885h.mo2991g(), "Invalid charOffset given");
        int i2 = m2452i(i);
        int j = m2455j(i);
        if (i2 == 0 && j == 0) {
            return false;
        }
        scrollBy(j, i2);
        return true;
    }

    /* renamed from: i */
    private int m2452i(int i) {
        int b = this.f2885h.mo2981b(i) * mo2751a();
        int a = mo2751a() + b;
        if (b < getScrollY()) {
            return b - getScrollY();
        }
        if (a > getScrollY() + getContentHeight()) {
            return (a - getScrollY()) - getContentHeight();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m2454i() {
        m2438d(this.f2885h.mo2981b(this.f2887j), this.f2885h.mo2981b(this.f2888k) + 1);
    }

    /* renamed from: j */
    private int m2455j(int i) {
        C0424m b = mo2756b(i);
        int a = b.mo3047a();
        int b2 = b.mo3049b();
        return a < getScrollX() + this.f2872S ? (a - getScrollX()) - this.f2872S : b2 > getScrollX() + getContentWidth() ? (b2 - getScrollX()) - getContentWidth() : 0;
    }

    /* renamed from: j */
    static /* synthetic */ int m2456j(C0383c cVar) {
        int i = cVar.f2854A + 1;
        cVar.f2854A = i;
        return i;
    }

    /* renamed from: l */
    static /* synthetic */ int m2458l(C0383c cVar) {
        int i = cVar.f2854A - 1;
        cVar.f2854A = i;
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2751a() {
        FontMetricsInt fontMetricsInt = this.f2855B.getFontMetricsInt();
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2752a(int i) {
        if (this.f2892o) {
            return this.f2889l * ((int) this.f2855B.measureText("·", 0, "·".length()));
        }
        return (this.f2889l - (((i - this.f2857D) / this.f2877aa) % this.f2889l)) * this.f2877aa;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        r6 = r6 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        if (r6 < r10) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        r2 = r2 + 1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo2753a(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.mo2751a()
            int r11 = r11 / r0
            com.b.a.b.f r0 = r9.f2885h
            int r0 = r0.mo2989f()
            r1 = 1
            if (r11 <= r0) goto L_0x0016
            com.b.a.b.f r10 = r9.f2885h
            int r10 = r10.mo2991g()
            int r10 = r10 - r1
            return r10
        L_0x0016:
            com.b.a.b.f r0 = r9.f2885h
            int r0 = r0.mo2985d(r11)
            if (r0 >= 0) goto L_0x0020
            r10 = -1
            return r10
        L_0x0020:
            if (r10 >= 0) goto L_0x0023
            return r0
        L_0x0023:
            com.b.a.b.f r2 = r9.f2885h
            java.lang.String r11 = r2.mo2972a(r11)
            int r2 = r9.f2857D
            int r3 = r11.length()
            r4 = 0
            r6 = r2
            r2 = 0
            r5 = 0
        L_0x0033:
            if (r2 >= r3) goto L_0x0072
            char r7 = r11.charAt(r2)
            switch(r7) {
                case 9: goto L_0x0061;
                case 10: goto L_0x005c;
                case 32: goto L_0x0057;
                case 55356: goto L_0x0040;
                case 55357: goto L_0x0040;
                case 65535: goto L_0x005c;
                default: goto L_0x003c;
            }
        L_0x003c:
            if (r5 == 0) goto L_0x0067
            r5 = 0
            goto L_0x006c
        L_0x0040:
            r5 = 2
            char[] r8 = new char[r5]
            r8[r4] = r7
            int r7 = r2 + 1
            char r7 = r11.charAt(r7)
            r8[r1] = r7
            android.graphics.Paint r7 = r9.f2855B
            float r5 = r7.measureText(r8, r4, r5)
            int r5 = (int) r5
            int r6 = r6 + r5
            r5 = 1
            goto L_0x006c
        L_0x0057:
            int r7 = r9.getSpaceAdvance()
            goto L_0x0065
        L_0x005c:
            int r7 = r9.getEOLAdvance()
            goto L_0x0065
        L_0x0061:
            int r7 = r9.mo2752a(r6)
        L_0x0065:
            int r6 = r6 + r7
            goto L_0x006c
        L_0x0067:
            int r7 = r9.getCharAdvance(r7)
            goto L_0x0065
        L_0x006c:
            if (r6 < r10) goto L_0x006f
            goto L_0x0072
        L_0x006f:
            int r2 = r2 + 1
            goto L_0x0033
        L_0x0072:
            int r10 = r11.length()
            if (r2 >= r10) goto L_0x007a
            int r0 = r0 + r2
            return r0
        L_0x007a:
            int r0 = r0 + r2
            int r0 = r0 - r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p023a.C0383c.mo2753a(int, int):int");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2754a(boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(this, 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
        r6 = r6 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if (r6 < r11) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        r4 = r4 + 1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo2755b(int r11, int r12) {
        /*
            r10 = this;
            int r0 = r10.mo2751a()
            int r12 = r12 / r0
            com.b.a.b.f r0 = r10.f2885h
            int r0 = r0.mo2985d(r12)
            r1 = -1
            if (r0 < 0) goto L_0x0067
            if (r11 >= 0) goto L_0x0011
            return r1
        L_0x0011:
            com.b.a.b.f r2 = r10.f2885h
            java.lang.String r12 = r2.mo2972a(r12)
            int r2 = r12.length()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x001f:
            if (r4 >= r2) goto L_0x005f
            char r7 = r12.charAt(r4)
            r8 = 1
            switch(r7) {
                case 9: goto L_0x004e;
                case 10: goto L_0x0049;
                case 32: goto L_0x0044;
                case 55356: goto L_0x002d;
                case 55357: goto L_0x002d;
                case 65535: goto L_0x0049;
                default: goto L_0x0029;
            }
        L_0x0029:
            if (r5 == 0) goto L_0x0054
            r5 = 0
            goto L_0x0059
        L_0x002d:
            r5 = 2
            char[] r9 = new char[r5]
            r9[r3] = r7
            int r7 = r4 + 1
            char r7 = r12.charAt(r7)
            r9[r8] = r7
            android.graphics.Paint r7 = r10.f2855B
            float r5 = r7.measureText(r9, r3, r5)
            int r5 = (int) r5
            int r6 = r6 + r5
            r5 = 1
            goto L_0x0059
        L_0x0044:
            int r7 = r10.getSpaceAdvance()
            goto L_0x0052
        L_0x0049:
            int r7 = r10.getEOLAdvance()
            goto L_0x0052
        L_0x004e:
            int r7 = r10.mo2752a(r6)
        L_0x0052:
            int r6 = r6 + r7
            goto L_0x0059
        L_0x0054:
            int r7 = r10.getCharAdvance(r7)
            goto L_0x0052
        L_0x0059:
            if (r6 < r11) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            int r4 = r4 + 1
            goto L_0x001f
        L_0x005f:
            int r11 = r12.length()
            if (r4 >= r11) goto L_0x0067
            int r0 = r0 + r4
            return r0
        L_0x0067:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p023a.C0383c.mo2755b(int, int):int");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0424m mo2756b(int i) {
        int i2;
        int i3;
        int b = this.f2885h.mo2981b(i);
        int d = this.f2885h.mo2985d(b);
        int i4 = this.f2857D;
        int i5 = this.f2857D;
        String a = this.f2885h.mo2972a(b);
        int length = a.length();
        int i6 = i5;
        boolean z = false;
        int i7 = i4;
        int i8 = 0;
        while (d + i8 <= i && i8 < length) {
            char charAt = a.charAt(i8);
            switch (charAt) {
                case 9:
                    i3 = mo2752a(i6);
                    break;
                case 10:
                case 65535:
                    i3 = getEOLAdvance();
                    break;
                case ' ':
                    i3 = getSpaceAdvance();
                    break;
                case 55356:
                case 55357:
                    i2 = ((int) this.f2855B.measureText(new char[]{charAt, a.charAt(i8 + 1)}, 0, 2)) + i6;
                    z = true;
                    continue;
                default:
                    if (!z) {
                        i3 = getCharAdvance(charAt);
                        break;
                    } else {
                        i2 = i6;
                        z = false;
                        continue;
                    }
            }
            i2 = i3 + i6;
            i8++;
            int i9 = i6;
            i6 = i2;
            i7 = i9;
        }
        return new C0424m(i7, i6);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo2757b() {
        removeCallbacks(this.f2873T);
        removeCallbacks(this.f2874U);
        removeCallbacks(this.f2875V);
        removeCallbacks(this.f2876W);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Rect mo2758c(int i) {
        if (i < 0 || i >= this.f2885h.mo2991g()) {
            return new Rect(-1, -1, -1, -1);
        }
        int b = this.f2885h.mo2981b(i) * mo2751a();
        int a = mo2751a() + b;
        C0424m b2 = mo2756b(i);
        return new Rect(b2.mo3047a(), b, b2.mo3049b(), a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo2759c(int i, int i2) {
        this.f2898v.fling(getScrollX(), getScrollY(), i, i2, 0, getMaxScrollX(), 0, getMaxScrollY());
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo2760c() {
        return this.f2854A == 0;
    }

    public void cancelSpanning() {
        this.f2899w.mo2889b();
    }

    public void computeScroll() {
        if (this.f2898v.computeScrollOffset()) {
            scrollTo(this.f2898v.getCurrX(), this.f2898v.getCurrY());
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollOffset() {
        return getScrollY();
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        return (this.f2885h.mo2989f() * mo2751a()) + getPaddingTop() + getPaddingBottom();
    }

    public void copy() {
        if (this.f2887j != this.f2888k) {
            this.f2899w.mo2891b(this.f2860G);
        }
        selectText(false);
    }

    public void copy(ClipboardManager clipboardManager) {
        this.f2899w.mo2891b(clipboardManager);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        AccessibilityNodeInfo createAccessibilityNodeInfo = super.createAccessibilityNodeInfo();
        if (VERSION.SDK_INT > 20) {
            createAccessibilityNodeInfo.addAction(AccessibilityAction.ACTION_SCROLL_FORWARD);
            createAccessibilityNodeInfo.addAction(AccessibilityAction.ACTION_SCROLL_BACKWARD);
            createAccessibilityNodeInfo.addAction(AccessibilityAction.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            createAccessibilityNodeInfo.addAction(AccessibilityAction.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY);
        } else if (VERSION.SDK_INT > 15) {
            createAccessibilityNodeInfo.addAction(4096);
            createAccessibilityNodeInfo.addAction(8192);
            createAccessibilityNodeInfo.addAction(Constants.ACC_NATIVE);
            createAccessibilityNodeInfo.addAction(Constants.ACC_INTERFACE);
        }
        if (VERSION.SDK_INT >= 18) {
            createAccessibilityNodeInfo.setTextSelection(getSelectionStart(), getSelectionEnd());
        }
        createAccessibilityNodeInfo.setFocusable(true);
        if (VERSION.SDK_INT >= 18) {
            createAccessibilityNodeInfo.setEditable(true);
        }
        if (VERSION.SDK_INT >= 19) {
            createAccessibilityNodeInfo.setMultiLine(true);
        }
        return createAccessibilityNodeInfo;
    }

    public C0414f createDocumentProvider() {
        return new C0414f(this.f2885h);
    }

    public void cut() {
        if (this.f2887j != this.f2888k) {
            this.f2899w.mo2885a(this.f2860G);
        }
    }

    public void cut(ClipboardManager clipboardManager) {
        this.f2899w.mo2885a(clipboardManager);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo2771d() {
        return this.f2854A == this.f2885h.mo2989f() - 1;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        post(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        return false;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo2772d(int r4) {
        /*
            r3 = this;
            r0 = 1
            switch(r4) {
                case 0: goto L_0x004c;
                case 1: goto L_0x003e;
                case 2: goto L_0x0025;
                case 3: goto L_0x000a;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.String r4 = "Invalid scroll direction"
            com.p021b.p022a.p024b.C0428q.m2726a(r4)
            goto L_0x005d
        L_0x000a:
            java.lang.Runnable r4 = r3.f2876W
            r3.removeCallbacks(r4)
            boolean r4 = r3.mo2774e()
            if (r4 != 0) goto L_0x005d
            int r4 = r3.f2854A
            com.b.a.b.f r1 = r3.f2885h
            int r2 = r3.f2886i
            int r2 = r2 + r0
            int r1 = r1.mo2981b(r2)
            if (r4 != r1) goto L_0x005d
            java.lang.Runnable r4 = r3.f2876W
            goto L_0x0059
        L_0x0025:
            java.lang.Runnable r4 = r3.f2875V
            r3.removeCallbacks(r4)
            int r4 = r3.f2886i
            if (r4 <= 0) goto L_0x005d
            int r4 = r3.f2854A
            com.b.a.b.f r1 = r3.f2885h
            int r2 = r3.f2886i
            int r2 = r2 - r0
            int r1 = r1.mo2981b(r2)
            if (r4 != r1) goto L_0x005d
            java.lang.Runnable r4 = r3.f2875V
            goto L_0x0059
        L_0x003e:
            java.lang.Runnable r4 = r3.f2873T
            r3.removeCallbacks(r4)
            boolean r4 = r3.mo2771d()
            if (r4 != 0) goto L_0x005d
            java.lang.Runnable r4 = r3.f2873T
            goto L_0x0059
        L_0x004c:
            java.lang.Runnable r4 = r3.f2874U
            r3.removeCallbacks(r4)
            boolean r4 = r3.mo2760c()
            if (r4 != 0) goto L_0x005d
            java.lang.Runnable r4 = r3.f2874U
        L_0x0059:
            r3.post(r4)
            return r0
        L_0x005d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p023a.C0383c.mo2772d(int):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public int mo2773e(int i) {
        int b = this.f2885h.mo2981b(i);
        C0428q.m2727a(b >= 0, "Invalid char offset given to getColumn");
        return i - this.f2885h.mo2985d(b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo2774e() {
        return this.f2886i == this.f2885h.mo2991g() - 1;
    }

    public void focusCaret() {
        m2450h(this.f2886i);
    }

    public void focusSelectionEnd() {
        this.f2899w.mo2899d(false);
    }

    public void focusSelectionStart() {
        this.f2899w.mo2899d(true);
    }

    public void format() {
        selectText(false);
        CharSequence a = C0406a.m2564a(new C0414f(this.f2885h), this.f2894q);
        this.f2885h.mo2986d();
        this.f2885h.mo2974a(0, this.f2885h.mo2991g() - 1, System.nanoTime());
        this.f2885h.mo2978a(a.toString().toCharArray(), 0, System.nanoTime());
        this.f2885h.mo2988e();
        this.f2885h.mo2993h();
        respan();
        invalidate();
    }

    public int getAdvance(char c) {
        float measureText;
        switch (c) {
            case 9:
                return getTabAdvance();
            case 10:
            case 65535:
                return getEOLAdvance();
            case ' ':
                return getSpaceAdvance();
            case 55356:
            case 55357:
                return 0;
            default:
                if (this.f2869P != 0) {
                    measureText = this.f2855B.measureText(new char[]{this.f2869P, c}, 0, 2);
                } else {
                    measureText = this.f2855B.measureText(new char[]{c}, 0, 1);
                }
                return (int) measureText;
        }
    }

    public int getAdvance(char c, int i) {
        float measureText;
        switch (c) {
            case 9:
                return mo2752a(i);
            case 10:
            case 65535:
                return getEOLAdvance();
            case ' ':
                return getSpaceAdvance();
            case 55356:
            case 55357:
                return 0;
            default:
                if (this.f2869P != 0) {
                    measureText = this.f2855B.measureText(new char[]{this.f2869P, c}, 0, 2);
                } else {
                    measureText = this.f2855B.measureText(new char[]{c}, 0, 1);
                }
                return (int) measureText;
        }
    }

    public int getAutoIndentWidth() {
        return this.f2894q;
    }

    public int getCaretPosition() {
        return this.f2886i;
    }

    public int getCaretRow() {
        return this.f2854A;
    }

    public int getCaretX() {
        return this.f2862I;
    }

    public int getCaretY() {
        return this.f2863J;
    }

    public int getCharAdvance(char c) {
        return (int) this.f2855B.measureText(new char[]{c}, 0, 1);
    }

    public C0408b getColorScheme() {
        return this.f2890m;
    }

    /* access modifiers changed from: protected */
    public int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public int getEOLAdvance() {
        return (int) (this.f2892o ? this.f2855B.measureText("↵", 0, "↵".length()) : f2848a * this.f2855B.measureText(" ", 0, 1));
    }

    public int getLeftOffset() {
        return this.f2857D;
    }

    public int getLength() {
        return this.f2885h.mo2991g();
    }

    /* access modifiers changed from: 0000 */
    public int getMaxScrollX() {
        return isWordWrap() ? this.f2857D : Math.max(0, (this.f2856C - getContentWidth()) + this.f2884g.mo2926a().right + this.f2872S);
    }

    /* access modifiers changed from: 0000 */
    public int getMaxScrollY() {
        return Math.max(0, ((this.f2885h.mo2989f() * mo2751a()) - (getContentHeight() / 2)) + this.f2884g.mo2926a().bottom);
    }

    /* access modifiers changed from: protected */
    public int getNumVisibleRows() {
        return (int) Math.ceil(((double) getContentHeight()) / ((double) mo2751a()));
    }

    public int getPaintBaseline(int i) {
        return ((i + 1) * mo2751a()) - this.f2855B.getFontMetricsInt().descent;
    }

    public final int getRowWidth() {
        return getContentWidth() - this.f2857D;
    }

    public int getSelectionEnd() {
        return this.f2888k < 0 ? this.f2886i : this.f2888k;
    }

    public int getSelectionStart() {
        return this.f2887j < 0 ? this.f2886i : this.f2887j;
    }

    /* access modifiers changed from: protected */
    public int getSpaceAdvance() {
        return this.f2892o ? (int) this.f2855B.measureText("·", 0, "·".length()) : this.f2877aa;
    }

    /* access modifiers changed from: protected */
    public int getTabAdvance() {
        int i;
        int i2;
        if (this.f2892o) {
            i = this.f2889l;
            i2 = (int) this.f2855B.measureText("·", 0, "·".length());
        } else {
            i = this.f2889l;
            i2 = this.f2877aa;
        }
        return i * i2;
    }

    public float getTextSize() {
        return this.f2855B.getTextSize();
    }

    public int getTopOffset() {
        return this.f2865L;
    }

    public Parcelable getUiState() {
        return new C0397c(this);
    }

    public float getZoom() {
        return this.f2861H;
    }

    public boolean hasLayout() {
        return getWidth() == 0;
    }

    public boolean inSelectionRange(int i) {
        return this.f2899w.mo2893b(i);
    }

    public boolean isAccessibilityEnabled() {
        return this.f2879ac;
    }

    public boolean isEdited() {
        return this.f2883f;
    }

    public boolean isFlingScrolling() {
        return !this.f2898v.isFinished();
    }

    public boolean isSaveEnabled() {
        return true;
    }

    public final boolean isSelectText() {
        return this.f2899w.mo2902g();
    }

    public final boolean isSelectText2() {
        return this.f2899w.mo2903h();
    }

    public boolean isShowLineNumbers() {
        return this.f2858E;
    }

    public boolean isWordWrap() {
        return this.f2885h.mo2995j();
    }

    public void moveCaret(int i) {
        this.f2899w.mo2881a(i);
    }

    public void moveCaretDown() {
        this.f2899w.mo2895c();
    }

    public void moveCaretLeft() {
        this.f2899w.mo2892b(false);
    }

    public void moveCaretRight() {
        this.f2899w.mo2888a(false);
    }

    public void moveCaretUp() {
        this.f2899w.mo2898d();
    }

    public boolean onCheckIsTextEditor() {
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.inputType = 131073;
        editorInfo.imeOptions = 1342177286;
        if (this.f2900x == null) {
            this.f2900x = new C0396b(this);
        } else {
            this.f2900x.mo2906a();
        }
        return this.f2900x;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(getScrollX() + getPaddingLeft(), getScrollY() + getPaddingTop(), (getScrollX() + getWidth()) - getPaddingRight(), (getScrollY() + getHeight()) - getPaddingBottom());
        canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        m2436c(canvas);
        canvas.restore();
        this.f2884g.mo2927a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        m2449h();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() != 8) {
            return super.onGenericMotionEvent(motionEvent);
        }
        m2422a(0.0f, (-motionEvent.getAxisValue(9)) * ((float) mo2751a()));
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.f2879ac) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 7) {
                switch (action) {
                    case 9:
                        this.f2880ad = motionEvent;
                        break;
                    case 10:
                        this.f2884g.mo2932a(motionEvent);
                        break;
                }
            } else {
                this.f2884g.onScroll(this.f2880ad, motionEvent, this.f2881ae - x, this.f2882af - y);
            }
            this.f2881ae = x;
            this.f2882af = y;
        }
        return super.onHoverEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f2884g.mo2931a(i, keyEvent)) {
            return true;
        }
        if (C0399d.m2516b(keyEvent)) {
            m2423a(i, keyEvent);
            return true;
        } else if (i == 63 || i == 61185) {
            m2428a((String) f2853u.get(61185), false);
            return true;
        } else {
            char a = C0399d.m2515a(keyEvent);
            if (a == 0) {
                return super.onKeyDown(i, keyEvent);
            }
            int repeatCount = keyEvent.getRepeatCount();
            if (repeatCount != 1) {
                if (repeatCount == 0 || ((this.f2895r && !Character.isLowerCase(a)) || (!this.f2895r && f2853u.get(a) == null))) {
                    this.f2899w.mo2880a(a);
                }
                return true;
            } else if (this.f2895r) {
                m2421a(a);
                return true;
            } else {
                m2432b(a);
                return true;
            }
        }
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (this.f2895r && keyEvent.getRepeatCount() == 1 && keyEvent.getAction() == 0) {
            char a = C0399d.m2515a(keyEvent);
            if (Character.isLowerCase(a) && a == Character.toLowerCase(this.f2885h.charAt(this.f2886i - 1))) {
                this.f2899w.mo2880a(8);
                this.f2899w.mo2880a(Character.toUpperCase(a));
                return true;
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f2884g.mo2934b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.f2865L = (rect.top + rect.height()) - getHeight();
            if (!this.f2870Q) {
                respan();
            }
            this.f2870Q = i3 > 0;
            invalidate();
            this.f2896s.mo2734c(getWidth() / 2);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m2443f(i), m2443f(i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f2885h.mo2995j() && i3 != i) {
            this.f2885h.mo2996k();
        }
        this.f2899w.mo2900e();
        if (i2 < i4) {
            m2450h(this.f2886i);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isFocused()) {
            this.f2884g.mo2935b(motionEvent);
            return true;
        }
        if ((motionEvent.getAction() & 255) == 1 && m2442e((int) motionEvent.getX(), (int) motionEvent.getY())) {
            requestFocus();
        }
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        int round = Math.round(motionEvent.getX());
        int round2 = Math.round(motionEvent.getY());
        while (round > 0) {
            this.f2899w.mo2888a(false);
            round--;
        }
        while (round < 0) {
            this.f2899w.mo2892b(false);
            round++;
        }
        while (round2 > 0) {
            this.f2899w.mo2895c();
            round2--;
        }
        while (round2 < 0) {
            this.f2899w.mo2898d();
            round2++;
        }
        return true;
    }

    public void paste() {
        CharSequence text = this.f2860G.getText();
        if (text != null) {
            this.f2899w.mo2886a(text.toString());
        }
    }

    public void paste(String str) {
        this.f2899w.mo2886a(str);
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (VERSION.SDK_INT < 16) {
            return super.performAccessibilityAction(i, bundle);
        }
        if (i == 256) {
            int i2 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
            if (i2 == 1) {
                moveCaretRight();
                return true;
            } else if (i2 != 4) {
                return true;
            } else {
                moveCaretDown();
                return true;
            }
        } else if (i != 512) {
            return super.performAccessibilityAction(i, bundle);
        } else {
            int i3 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
            if (i3 == 1) {
                moveCaretLeft();
                return true;
            } else if (i3 != 4) {
                return true;
            } else {
                moveCaretUp();
                return true;
            }
        }
    }

    public void replaceText(int i, int i2, String str) {
        this.f2885h.mo2986d();
        this.f2899w.mo2883a(i, i2, str);
        this.f2899w.mo2901f();
        this.f2885h.mo2988e();
    }

    public void respan() {
        this.f2899w.mo2879a();
    }

    public void restoreUiState(Parcelable parcelable) {
        C0397c cVar = (C0397c) parcelable;
        final int i = cVar.f2928a;
        if (cVar.f2931d) {
            final int i2 = cVar.f2932e;
            final int i3 = cVar.f2933f;
            post(new Runnable() {
                public void run() {
                    C0383c.this.setSelectionRange(i2, i3 - i2);
                    if (i < i3) {
                        C0383c.this.focusSelectionStart();
                    }
                }
            });
            return;
        }
        post(new Runnable() {
            public void run() {
                C0383c.this.moveCaret(i);
            }
        });
    }

    public void selectAll() {
        this.f2899w.mo2884a(0, this.f2885h.mo2991g() - 1, false, true);
    }

    public void selectText(boolean z) {
        C0394a aVar;
        boolean z2;
        if (this.f2899w.mo2902g() && !z) {
            m2454i();
            aVar = this.f2899w;
            z2 = false;
        } else if (!this.f2899w.mo2902g() && z) {
            m2449h();
            aVar = this.f2899w;
            z2 = true;
        } else {
            return;
        }
        aVar.mo2896c(z2);
    }

    public void setAutoComplete(boolean z) {
        this.f2897t = z;
    }

    public void setAutoIndent(boolean z) {
        this.f2893p = z;
    }

    public void setAutoIndentWidth(int i) {
        this.f2894q = i;
    }

    public void setBoldTypeface(Typeface typeface) {
        this.f2867N = typeface;
    }

    public void setChirality(boolean z) {
        this.f2884g.mo2929a(z);
    }

    public void setColorScheme(C0408b bVar) {
        this.f2890m = bVar;
        this.f2884g.mo2928a(bVar);
        setBackgroundColor(bVar.mo2957a(C0409a.BACKGROUND));
    }

    public void setDocumentProvider(C0414f fVar) {
        this.f2885h = fVar;
        m2447g();
        this.f2899w.mo2889b();
        this.f2899w.mo2879a();
        invalidate();
        if (this.f2879ac) {
            setContentDescription(this.f2885h);
        }
    }

    public void setEdited(boolean z) {
        this.f2883f = z;
    }

    public void setHighlightCurrentRow(boolean z) {
        this.f2891n = z;
        m2449h();
    }

    public void setItalicTypeface(Typeface typeface) {
        this.f2868O = typeface;
    }

    public void setLongPressCaps(boolean z) {
        this.f2895r = z;
    }

    public void setNavigationMethod(C0402g gVar) {
        this.f2884g = gVar;
    }

    public void setNonPrintingCharVisibility(boolean z) {
        if (this.f2892o ^ z) {
            this.f2892o = z;
            if (this.f2885h.mo2995j()) {
                this.f2885h.mo2996k();
            }
            this.f2899w.mo2900e();
            if (!m2450h(this.f2886i)) {
                invalidate();
            }
        }
    }

    public void setOnSelectionChangedListener(C0400e eVar) {
        this.f2902z = eVar;
    }

    public void setRowListener(C0425n nVar) {
        this.f2901y = nVar;
    }

    public void setSelection(int i, int i2) {
        this.f2899w.mo2884a(i, i2, true, false);
    }

    public void setSelectionRange(int i, int i2) {
        this.f2899w.mo2884a(i, i2, true, true);
    }

    public void setShowLineNumbers(boolean z) {
        this.f2858E = z;
    }

    public void setTabSpaces(int i) {
        if (i >= 0) {
            this.f2889l = i;
            if (this.f2885h.mo2995j()) {
                this.f2885h.mo2996k();
            }
            this.f2899w.mo2900e();
            if (!m2450h(this.f2886i)) {
                invalidate();
            }
        }
    }

    public void setTextSize(int i) {
        if (i > 8 && i < 80) {
            float f = (float) i;
            if (f != this.f2855B.getTextSize()) {
                double a = (double) mo2751a();
                double advance = (double) getAdvance('a');
                this.f2861H = (float) (i / f2851d);
                this.f2855B.setTextSize(f);
                this.f2871R.setTextSize(f);
                if (this.f2885h.mo2995j()) {
                    this.f2885h.mo2996k();
                }
                this.f2899w.mo2900e();
                scrollTo((int) (((double) getScrollX()) * (((double) getAdvance('a')) / advance)), (int) (((double) getScrollY()) * (((double) mo2751a()) / a)));
                this.f2872S = (int) this.f2855B.measureText(Config.APP_VERSION_CODE);
                this.f2877aa = (int) this.f2855B.measureText(" ");
                invalidate();
            }
        }
    }

    public void setTypeface(Typeface typeface) {
        this.f2866M = typeface;
        this.f2867N = Typeface.create(typeface, 1);
        this.f2868O = Typeface.create(typeface, 2);
        this.f2855B.setTypeface(typeface);
        this.f2871R.setTypeface(typeface);
        if (this.f2885h.mo2995j()) {
            this.f2885h.mo2996k();
        }
        this.f2899w.mo2900e();
        if (!m2450h(this.f2886i)) {
            invalidate();
        }
    }

    public void setWordWrap(boolean z) {
        this.f2885h.mo2977a(z);
        if (z) {
            this.f2856C = 0;
            scrollTo(0, 0);
        }
        this.f2899w.mo2900e();
        if (!m2450h(this.f2886i)) {
            invalidate();
        }
    }

    public void setZoom(float f) {
        if (((double) f) > 0.5d && f < 5.0f && f != this.f2861H) {
            this.f2861H = f;
            float f2 = (float) ((int) (f * ((float) f2851d)));
            this.f2855B.setTextSize(f2);
            this.f2871R.setTextSize(f2);
            if (this.f2885h.mo2995j()) {
                this.f2885h.mo2996k();
            }
            this.f2899w.mo2900e();
            this.f2872S = (int) this.f2855B.measureText(Config.APP_VERSION_CODE);
            invalidate();
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        if (getHeight() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2878ab > 250) {
                int scrollY = getScrollY();
                this.f2898v.startScroll(getScrollX(), scrollY, i, i2);
                postInvalidate();
            } else {
                if (!this.f2898v.isFinished()) {
                    this.f2898v.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.f2878ab = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    public void stopFlingScrolling() {
        this.f2898v.forceFinished(true);
    }
}
