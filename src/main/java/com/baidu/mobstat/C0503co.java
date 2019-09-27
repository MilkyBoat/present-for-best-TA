package com.baidu.mobstat;

import android.content.Context;
import android.support.p000a.p001a.C0001a;
import java.lang.ref.WeakReference;

/* renamed from: com.baidu.mobstat.co */
class C0503co implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0496ch f3308a;

    /* renamed from: b */
    private long f3309b;

    /* renamed from: c */
    private long f3310c;

    /* renamed from: d */
    private WeakReference<Context> f3311d;

    /* renamed from: e */
    private WeakReference<C0001a> f3312e;

    /* renamed from: f */
    private WeakReference<Object> f3313f;

    /* renamed from: g */
    private long f3314g;

    /* renamed from: h */
    private int f3315h;

    /* renamed from: i */
    private int f3316i = 1;

    public C0503co(C0496ch chVar, long j, long j2, long j3, Context context, C0001a aVar, Object obj, int i, int i2) {
        this.f3308a = chVar;
        this.f3309b = j;
        this.f3310c = j2;
        this.f3311d = new WeakReference<>(context);
        this.f3312e = new WeakReference<>(aVar);
        this.f3313f = new WeakReference<>(obj);
        this.f3314g = j3;
        this.f3315h = i;
        this.f3316i = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            long r0 = r7.f3310c
            long r2 = r7.f3309b
            long r4 = r0 - r2
            com.baidu.mobstat.ch r0 = r7.f3308a
            int r0 = r0.mo3370c()
            long r0 = (long) r0
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            r0 = 1
            if (r2 < 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r2 = 0
            if (r1 == 0) goto L_0x00ba
            long r4 = r7.f3309b
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ba
            java.lang.ref.WeakReference<android.content.Context> r1 = r7.f3311d
            java.lang.Object r1 = r1.get()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.ref.WeakReference<android.support.a.a.a> r2 = r7.f3312e
            java.lang.Object r2 = r2.get()
            android.support.a.a.a r2 = (android.support.p000a.p001a.C0001a) r2
            java.lang.ref.WeakReference<java.lang.Object> r3 = r7.f3313f
            java.lang.Object r3 = r3.get()
            if (r1 != 0) goto L_0x003b
            if (r2 != 0) goto L_0x003b
            if (r3 == 0) goto L_0x00c9
        L_0x003b:
            com.baidu.mobstat.ch r4 = r7.f3308a
            com.baidu.mobstat.cf r4 = r4.f3275i
            long r5 = r7.f3309b
            r4.mo3346d(r5)
            com.baidu.mobstat.ch r4 = r7.f3308a
            com.baidu.mobstat.cf r4 = r4.f3275i
            org.json.JSONObject r4 = r4.mo3343c()
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "new session:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.baidu.mobstat.C0514cz.m3110a(r5)
            com.baidu.mobstat.DataCore r5 = com.baidu.mobstat.DataCore.instance()
            r5.putSession(r4)
            r4 = 0
            int r5 = r7.f3316i
            if (r5 != r0) goto L_0x007c
        L_0x0074:
            com.baidu.mobstat.DataCore r0 = com.baidu.mobstat.DataCore.instance()
            r0.flush(r1)
            goto L_0x0091
        L_0x007c:
            int r0 = r7.f3316i
            r1 = 2
            if (r0 != r1) goto L_0x0086
            android.support.v4.app.FragmentActivity r1 = r2.getActivity()
            goto L_0x0074
        L_0x0086:
            int r0 = r7.f3316i
            r1 = 3
            if (r0 != r1) goto L_0x0090
            android.content.Context r1 = com.baidu.mobstat.C0496ch.m3037a(r3)
            goto L_0x0074
        L_0x0090:
            r1 = r4
        L_0x0091:
            com.baidu.mobstat.ch r0 = r7.f3308a
            r0.mo3373e()
            com.baidu.mobstat.ch r0 = r7.f3308a
            long r2 = r7.f3314g
            r0.mo3355a(r2)
            com.baidu.mobstat.ch r0 = r7.f3308a
            int r2 = r7.f3315h
            r0.mo3371c(r2)
            if (r1 == 0) goto L_0x00c9
            com.baidu.mobstat.ch r0 = r7.f3308a
            r0.mo3357a(r1)
            com.baidu.mobstat.DataCore r0 = com.baidu.mobstat.DataCore.instance()
            r0.saveLogDataToSend(r1)
            com.baidu.mobstat.by r0 = com.baidu.mobstat.C0486by.m2993a()
            r0.mo3325a(r1)
            return
        L_0x00ba:
            if (r1 == 0) goto L_0x00c9
            long r0 = r7.f3309b
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00c9
            com.baidu.mobstat.ch r0 = r7.f3308a
            int r1 = r7.f3315h
            r0.mo3371c(r1)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0503co.run():void");
    }
}
