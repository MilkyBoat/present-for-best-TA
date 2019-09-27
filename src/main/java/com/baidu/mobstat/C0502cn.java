package com.baidu.mobstat;

import android.content.Context;
import android.support.p000a.p001a.C0001a;
import java.lang.ref.WeakReference;

/* renamed from: com.baidu.mobstat.cn */
class C0502cn implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0496ch f3293a;

    /* renamed from: b */
    private long f3294b;

    /* renamed from: c */
    private WeakReference<Context> f3295c;

    /* renamed from: d */
    private WeakReference<C0001a> f3296d;

    /* renamed from: e */
    private WeakReference<Object> f3297e;

    /* renamed from: f */
    private long f3298f;

    /* renamed from: g */
    private WeakReference<Context> f3299g;

    /* renamed from: h */
    private WeakReference<C0001a> f3300h;

    /* renamed from: i */
    private WeakReference<Object> f3301i;

    /* renamed from: j */
    private int f3302j;

    /* renamed from: k */
    private String f3303k;

    /* renamed from: l */
    private String f3304l;

    /* renamed from: m */
    private boolean f3305m;

    /* renamed from: n */
    private ExtraInfo f3306n;

    /* renamed from: o */
    private C0500cl f3307o;

    public C0502cn(C0496ch chVar, long j, Context context, C0001a aVar, long j2, Context context2, C0001a aVar2, int i, String str, Object obj, Object obj2, String str2, boolean z, ExtraInfo extraInfo, C0500cl clVar) {
        this.f3293a = chVar;
        this.f3294b = j;
        this.f3298f = j2;
        this.f3295c = new WeakReference<>(context);
        this.f3299g = new WeakReference<>(context2);
        this.f3296d = new WeakReference<>(aVar);
        this.f3300h = new WeakReference<>(aVar2);
        this.f3301i = new WeakReference<>(obj);
        this.f3297e = new WeakReference<>(obj2);
        this.f3302j = i;
        this.f3303k = str;
        this.f3304l = str2;
        this.f3305m = z;
        this.f3306n = extraInfo;
        this.f3307o = clVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r19 = this;
            r0 = r19
            int r1 = r0.f3302j
            r2 = 1
            if (r1 != r2) goto L_0x0124
            java.lang.ref.WeakReference<android.content.Context> r1 = r0.f3295c
            java.lang.Object r1 = r1.get()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.ref.WeakReference<android.content.Context> r2 = r0.f3299g
            java.lang.Object r2 = r2.get()
            android.content.Context r2 = (android.content.Context) r2
            if (r1 == 0) goto L_0x0120
            if (r2 != 0) goto L_0x001d
            goto L_0x0120
        L_0x001d:
            if (r1 == r2) goto L_0x002d
            java.lang.String r1 = r0.f3303k
            if (r1 == 0) goto L_0x0029
            java.lang.String r1 = "onPageStart() or onPageEnd() install error."
        L_0x0025:
            com.baidu.mobstat.C0514cz.m3114b(r1)
            return
        L_0x0029:
            java.lang.String r1 = "onPause() or onResume() install error."
            goto L_0x0025
            return
        L_0x002d:
            java.lang.String r2 = ""
            long r3 = r0.f3294b
            long r5 = r0.f3298f
            long r7 = r3 - r5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.f3303k
            if (r4 == 0) goto L_0x007f
            java.lang.String r4 = r0.f3303k
            r3.append(r4)
            com.baidu.mobstat.cl r4 = r0.f3307o
            if (r4 == 0) goto L_0x00a0
            com.baidu.mobstat.cl r4 = r0.f3307o
            long r4 = r4.f3289d
            com.baidu.mobstat.cl r6 = r0.f3307o
            long r6 = r6.f3288c
            long r8 = r4 - r6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "page time = "
            r4.append(r5)
            com.baidu.mobstat.cl r5 = r0.f3307o
            java.lang.String r5 = r5.f3286a
            r4.append(r5)
            java.lang.String r5 = "; time = "
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.baidu.mobstat.C0514cz.m3117c(r4)
            r4 = 20
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x007d
            java.lang.String r1 = "page time little than 20 mills."
        L_0x0079:
            com.baidu.mobstat.C0514cz.m3117c(r1)
            return
        L_0x007d:
            r13 = r8
            goto L_0x00a1
        L_0x007f:
            boolean r4 = r1 instanceof android.app.Activity
            if (r4 != 0) goto L_0x0086
            java.lang.String r1 = "onPause, pause is not a Activity"
            goto L_0x0079
        L_0x0086:
            r4 = r1
            android.app.Activity r4 = (android.app.Activity) r4
            android.content.ComponentName r4 = r4.getComponentName()
            java.lang.String r4 = r4.getShortClassName()
            r3.append(r4)
            r4 = 0
            char r5 = r3.charAt(r4)
            r6 = 46
            if (r5 != r6) goto L_0x00a0
            r3.deleteCharAt(r4)
        L_0x00a0:
            r13 = r7
        L_0x00a1:
            boolean r4 = r1 instanceof android.app.Activity
            if (r4 == 0) goto L_0x00b2
            r4 = r1
            android.app.Activity r4 = (android.app.Activity) r4
            java.lang.CharSequence r4 = r4.getTitle()
            if (r4 == 0) goto L_0x00b2
            java.lang.String r2 = r4.toString()
        L_0x00b2:
            r11 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "new page view, page name = "
            r2.append(r4)
            java.lang.String r4 = r3.toString()
            r2.append(r4)
            java.lang.String r4 = ", stay time = "
            r2.append(r4)
            r2.append(r13)
            java.lang.String r4 = "(ms)"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.baidu.mobstat.C0514cz.m3110a(r2)
            java.lang.String r10 = r3.toString()
            java.lang.String r2 = r0.f3303k
            if (r2 != 0) goto L_0x00e2
            r0.f3304l = r10
        L_0x00e2:
            com.baidu.mobstat.cg r2 = new com.baidu.mobstat.cg
            java.lang.String r12 = r0.f3304l
            long r3 = r0.f3298f
            boolean r5 = r0.f3305m
            com.baidu.mobstat.ExtraInfo r6 = r0.f3306n
            r9 = r2
            r15 = r3
            r17 = r5
            r18 = r6
            r9.<init>(r10, r11, r12, r13, r15, r17, r18)
            com.baidu.mobstat.ch r3 = r0.f3293a
            com.baidu.mobstat.cf r3 = r3.f3275i
            r3.mo3339a(r2)
            java.lang.String r2 = r0.f3303k
            if (r2 == 0) goto L_0x0111
            com.baidu.mobstat.cl r2 = r0.f3307o
            if (r2 == 0) goto L_0x0262
            com.baidu.mobstat.ch r2 = r0.f3293a
            com.baidu.mobstat.cf r2 = r2.f3275i
            com.baidu.mobstat.cl r3 = r0.f3307o
            long r3 = r3.f3289d
            goto L_0x0119
        L_0x0111:
            com.baidu.mobstat.ch r2 = r0.f3293a
            com.baidu.mobstat.cf r2 = r2.f3275i
            long r3 = r0.f3294b
        L_0x0119:
            r2.mo3346d(r3)
            com.baidu.mobstat.ch r2 = r0.f3293a
            goto L_0x01bd
        L_0x0120:
            java.lang.String r1 = "onPause, WeakReference is already been released"
            goto L_0x0079
        L_0x0124:
            int r1 = r0.f3302j
            r3 = 2
            if (r1 != r3) goto L_0x01c1
            java.lang.ref.WeakReference<android.support.a.a.a> r1 = r0.f3296d
            java.lang.Object r1 = r1.get()
            android.support.a.a.a r1 = (android.support.p000a.p001a.C0001a) r1
            java.lang.ref.WeakReference<android.support.a.a.a> r3 = r0.f3300h
            java.lang.Object r3 = r3.get()
            android.support.a.a.a r3 = (android.support.p000a.p001a.C0001a) r3
            if (r1 == 0) goto L_0x0120
            if (r3 != 0) goto L_0x013e
            goto L_0x0120
        L_0x013e:
            if (r1 == r3) goto L_0x0144
        L_0x0140:
            java.lang.String r1 = "onPause() or onResume() install error."
            goto L_0x0079
        L_0x0144:
            java.lang.String r3 = ""
            android.support.v4.app.FragmentActivity r4 = r1.getActivity()
            if (r4 == 0) goto L_0x0154
            java.lang.CharSequence r3 = r4.getTitle()
            java.lang.String r3 = r3.toString()
        L_0x0154:
            r6 = r3
            long r3 = r0.f3294b
            long r7 = r0.f3298f
            long r9 = r3 - r7
            java.lang.Class r3 = r1.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = "."
            int r4 = r3.lastIndexOf(r4)
            int r4 = r4 + r2
            java.lang.String r7 = r3.substring(r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Fragment new page view, page name = "
            r2.append(r4)
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.String r3 = ", stay time = "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r3 = "(ms)"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.baidu.mobstat.C0514cz.m3110a(r2)
            com.baidu.mobstat.cg r2 = new com.baidu.mobstat.cg
            long r11 = r0.f3298f
            boolean r3 = r0.f3305m
            com.baidu.mobstat.ExtraInfo r13 = r0.f3306n
            r4 = r2
            r5 = r7
            r8 = r9
            r10 = r11
            r12 = r3
            r4.<init>(r5, r6, r7, r8, r10, r12, r13)
            com.baidu.mobstat.ch r3 = r0.f3293a
            com.baidu.mobstat.cf r3 = r3.f3275i
            r3.mo3339a(r2)
            com.baidu.mobstat.ch r2 = r0.f3293a
            com.baidu.mobstat.cf r2 = r2.f3275i
            long r3 = r0.f3294b
            r2.mo3346d(r3)
            com.baidu.mobstat.ch r2 = r0.f3293a
            android.support.v4.app.FragmentActivity r1 = r1.getActivity()
        L_0x01bd:
            r2.m3044b(r1)
            return
        L_0x01c1:
            int r1 = r0.f3302j
            r3 = 3
            if (r1 != r3) goto L_0x0262
            java.lang.ref.WeakReference<java.lang.Object> r1 = r0.f3297e
            java.lang.Object r1 = r1.get()
            android.app.Fragment r1 = (android.app.Fragment) r1
            java.lang.ref.WeakReference<java.lang.Object> r3 = r0.f3301i
            java.lang.Object r3 = r3.get()
            android.app.Fragment r3 = (android.app.Fragment) r3
            if (r1 == 0) goto L_0x0120
            if (r3 != 0) goto L_0x01dc
            goto L_0x0120
        L_0x01dc:
            if (r1 == r3) goto L_0x01e0
            goto L_0x0140
        L_0x01e0:
            java.lang.String r3 = ""
            android.app.Activity r4 = r1.getActivity()
            if (r4 == 0) goto L_0x01f0
            java.lang.CharSequence r3 = r4.getTitle()
            java.lang.String r3 = r3.toString()
        L_0x01f0:
            r6 = r3
            long r3 = r0.f3294b
            long r7 = r0.f3298f
            long r9 = r3 - r7
            android.content.Context r3 = com.baidu.mobstat.C0496ch.m3037a(r1)
            if (r3 != 0) goto L_0x0201
            java.lang.String r1 = "getContxtFromReverse faild."
            goto L_0x0079
        L_0x0201:
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r4 = "."
            int r4 = r1.lastIndexOf(r4)
            int r4 = r4 + r2
            java.lang.String r7 = r1.substring(r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "android.app.Fragment new page view, page name = "
            r2.append(r4)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = "; stay time = "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r1 = "(ms)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.baidu.mobstat.C0514cz.m3110a(r1)
            com.baidu.mobstat.cg r1 = new com.baidu.mobstat.cg
            long r11 = r0.f3298f
            boolean r2 = r0.f3305m
            com.baidu.mobstat.ExtraInfo r13 = r0.f3306n
            r4 = r1
            r5 = r7
            r8 = r9
            r10 = r11
            r12 = r2
            r4.<init>(r5, r6, r7, r8, r10, r12, r13)
            com.baidu.mobstat.ch r2 = r0.f3293a
            com.baidu.mobstat.cf r2 = r2.f3275i
            r2.mo3339a(r1)
            com.baidu.mobstat.ch r1 = r0.f3293a
            com.baidu.mobstat.cf r1 = r1.f3275i
            long r4 = r0.f3294b
            r1.mo3346d(r4)
            com.baidu.mobstat.ch r1 = r0.f3293a
            r1.m3044b(r3)
        L_0x0262:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0502cn.run():void");
    }
}
