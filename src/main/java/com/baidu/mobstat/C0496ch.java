package com.baidu.mobstat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.p000a.p001a.C0001a;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.ch */
class C0496ch {

    /* renamed from: a */
    private static final C0496ch f3266a = new C0496ch();

    /* renamed from: n */
    private static HashMap<String, C0500cl> f3267n = new HashMap<>();

    /* renamed from: b */
    private C0501cm f3268b = new C0501cm();

    /* renamed from: c */
    private C0501cm f3269c = new C0501cm();

    /* renamed from: d */
    private C0501cm f3270d = new C0501cm();

    /* renamed from: e */
    private C0501cm f3271e = new C0501cm();

    /* renamed from: f */
    private long f3272f = 0;

    /* renamed from: g */
    private boolean f3273g = true;

    /* renamed from: h */
    private boolean f3274h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0494cf f3275i = new C0494cf();

    /* renamed from: j */
    private int f3276j = -1;

    /* renamed from: k */
    private volatile int f3277k;

    /* renamed from: l */
    private volatile long f3278l;

    /* renamed from: m */
    private Handler f3279m;

    private C0496ch() {
        HandlerThread handlerThread = new HandlerThread("SessionAnalysisThread");
        handlerThread.start();
        handlerThread.setPriority(10);
        this.f3279m = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    static Context m3037a(Object obj) {
        try {
            return (Context) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable th) {
            C0514cz.m3110a(th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static C0496ch m3039a() {
        return f3266a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3041a(java.lang.String r4) {
        /*
            r3 = this;
            java.util.HashMap<java.lang.String, com.baidu.mobstat.cl> r0 = f3267n
            monitor-enter(r0)
            if (r4 != 0) goto L_0x000e
            java.lang.String r4 = "page Object is null"
            com.baidu.mobstat.C0514cz.m3117c(r4)     // Catch:{ all -> 0x000c }
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r4 = move-exception
            goto L_0x0022
        L_0x000e:
            com.baidu.mobstat.cl r1 = new com.baidu.mobstat.cl     // Catch:{ all -> 0x000c }
            r1.<init>(r4)     // Catch:{ all -> 0x000c }
            java.util.HashMap<java.lang.String, com.baidu.mobstat.cl> r2 = f3267n     // Catch:{ all -> 0x000c }
            boolean r2 = r2.containsKey(r4)     // Catch:{ all -> 0x000c }
            if (r2 != 0) goto L_0x0020
            java.util.HashMap<java.lang.String, com.baidu.mobstat.cl> r2 = f3267n     // Catch:{ all -> 0x000c }
            r2.put(r4, r1)     // Catch:{ all -> 0x000c }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0496ch.m3041a(java.lang.String):void");
    }

    /* renamed from: a */
    private void m3042a(boolean z) {
        this.f3273g = z;
    }

    /* renamed from: b */
    private C0500cl m3043b(String str) {
        C0500cl clVar;
        synchronized (f3267n) {
            if (!f3267n.containsKey(str)) {
                m3041a(str);
            }
            clVar = (C0500cl) f3267n.get(str);
        }
        return clVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3044b(Context context) {
        String jSONObject = this.f3275i.mo3343c().toString();
        this.f3277k = jSONObject.getBytes().length;
        StringBuilder sb = new StringBuilder();
        sb.append("cacheString = ");
        sb.append(jSONObject);
        C0514cz.m3110a(sb.toString());
        String q = C0518dc.m3159q(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(q);
        sb2.append(Config.LAST_SESSION_FILE_NAME);
        C0507cs.m3084a(context, sb2.toString(), jSONObject, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3045c(java.lang.String r3) {
        /*
            r2 = this;
            java.util.HashMap<java.lang.String, com.baidu.mobstat.cl> r0 = f3267n
            monitor-enter(r0)
            if (r3 != 0) goto L_0x000e
            java.lang.String r3 = "pageName is null"
            com.baidu.mobstat.C0514cz.m3117c(r3)     // Catch:{ all -> 0x000c }
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r3 = move-exception
            goto L_0x001d
        L_0x000e:
            java.util.HashMap<java.lang.String, com.baidu.mobstat.cl> r1 = f3267n     // Catch:{ all -> 0x000c }
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x001b
            java.util.HashMap<java.lang.String, com.baidu.mobstat.cl> r1 = f3267n     // Catch:{ all -> 0x000c }
            r1.remove(r3)     // Catch:{ all -> 0x000c }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0496ch.m3045c(java.lang.String):void");
    }

    /* renamed from: h */
    private boolean m3046h() {
        return this.f3273g;
    }

    /* renamed from: i */
    private int m3047i() {
        Class cls;
        Class cls2;
        Class cls3;
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("android.support.a.a.a");
        } catch (ClassNotFoundException unused2) {
            cls2 = null;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            String methodName = stackTrace[i].getMethodName();
            if (!TextUtils.isEmpty(className) && !TextUtils.isEmpty(methodName) && methodName.equals("onResume")) {
                try {
                    cls3 = Class.forName(className);
                } catch (Throwable unused3) {
                    cls3 = null;
                }
                if (cls3 == null) {
                    continue;
                } else if (Activity.class.isAssignableFrom(cls3)) {
                    return 1;
                } else {
                    if (cls != null && cls.isAssignableFrom(cls3)) {
                        return 2;
                    }
                    if (cls2 != null && cls2.isAssignableFrom(cls3)) {
                        return 2;
                    }
                }
            }
        }
        return 3;
    }

    /* renamed from: j */
    private void m3048j() {
        boolean h = m3046h();
        StringBuilder sb = new StringBuilder();
        sb.append("isFirstResume:");
        sb.append(h);
        C0514cz.m3110a(sb.toString());
        if (h) {
            m3042a(false);
            this.f3279m.post(new C0499ck(this));
        }
    }

    /* renamed from: a */
    public void mo3354a(int i) {
        this.f3276j = i * 1000;
    }

    /* renamed from: a */
    public void mo3355a(long j) {
        this.f3275i.mo3338a(j);
    }

    @TargetApi(11)
    /* renamed from: a */
    public void mo3356a(Fragment fragment, long j) {
        C0514cz.m3110a("post resume job");
        if (this.f3270d.f3292c) {
            C0514cz.m3117c("遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.f3270d.f3292c = true;
        m3048j();
        C0503co coVar = new C0503co(this, this.f3272f, j, this.f3278l, null, null, fragment, 2, 3);
        this.f3279m.post(coVar);
        this.f3270d.f3291b = new WeakReference<>(fragment);
        this.f3270d.f3290a = j;
    }

    /* renamed from: a */
    public void mo3357a(Context context) {
        if (context == null) {
            C0514cz.m3110a("clearLastSession context is null, invalid");
            return;
        }
        String jSONObject = new JSONObject().toString();
        String q = C0518dc.m3159q(context);
        StringBuilder sb = new StringBuilder();
        sb.append(q);
        sb.append(Config.LAST_SESSION_FILE_NAME);
        C0507cs.m3084a(context, sb.toString(), jSONObject, false);
    }

    /* renamed from: a */
    public void mo3358a(Context context, long j) {
        if (this.f3278l == 0) {
            this.f3279m.post(new C0497ci(this, j));
        }
        this.f3278l = j;
    }

    /* renamed from: a */
    public void mo3359a(Context context, long j, String str) {
        long j2 = j;
        C0514cz.m3110a("AnalysisPageStart");
        if (TextUtils.isEmpty(str)) {
            C0514cz.m3117c("自定义页面 pageName 为 null");
            return;
        }
        C0500cl b = m3043b(str);
        if (b == null) {
            C0514cz.m3117c("get page info, PageInfo null");
            return;
        }
        if (b.f3287b) {
            C0514cz.m3117c("遗漏StatService.onPageEnd() || missing StatService.onPageEnd()");
        }
        b.f3287b = true;
        b.f3288c = j2;
        m3048j();
        if (!this.f3274h) {
            C0503co coVar = r0;
            C0503co coVar2 = new C0503co(this, this.f3272f, j2, this.f3278l, context, null, null, m3047i(), 1);
            this.f3279m.post(coVar);
            this.f3274h = true;
        }
        this.f3268b.f3291b = new WeakReference<>(context);
        this.f3268b.f3290a = j;
    }

    /* renamed from: a */
    public void mo3360a(Context context, long j, String str, String str2, ExtraInfo extraInfo) {
        long j2 = j;
        String str3 = str2;
        C0514cz.m3110a("post pause job");
        this.f3274h = false;
        if (TextUtils.isEmpty(str2)) {
            C0514cz.m3117c("自定义页面 pageName 无效值");
            return;
        }
        C0500cl b = m3043b(str3);
        if (b == null) {
            C0514cz.m3117c("get page info, PageInfo null");
        } else if (!b.f3287b) {
            C0514cz.m3117c("Please check (1)遗漏StatService.onPageStart() || missing StatService.onPageStart()");
        } else {
            b.f3287b = false;
            b.f3289d = j2;
            C0502cn cnVar = r0;
            C0502cn cnVar2 = new C0502cn(this, j2, context, null, b.f3288c, (Context) this.f3268b.f3291b.get(), null, 1, str3, null, null, str, false, extraInfo, b);
            this.f3279m.post(cnVar);
            m3045c(str2);
            this.f3272f = j;
        }
    }

    /* renamed from: a */
    public void mo3361a(Context context, long j, boolean z) {
        Context context2 = context;
        long j2 = j;
        if (z) {
            this.f3271e.f3292c = true;
            this.f3271e.f3291b = new WeakReference<>(context2);
            this.f3271e.f3290a = j2;
        }
        C0514cz.m3110a("AnalysisResume job");
        if (!z && this.f3268b.f3292c) {
            C0514cz.m3117c("遗漏StatService.onPause() || missing StatService.onPause()");
        }
        if (!z) {
            this.f3268b.f3292c = true;
        }
        m3048j();
        if (!this.f3274h) {
            C0503co coVar = r0;
            C0503co coVar2 = new C0503co(this, this.f3272f, j2, this.f3278l, context2, null, null, 1, 1);
            this.f3279m.post(coVar);
            this.f3274h = true;
        }
        this.f3268b.f3291b = new WeakReference<>(context2);
        this.f3268b.f3290a = j;
    }

    /* renamed from: a */
    public void mo3362a(Context context, long j, boolean z, ExtraInfo extraInfo) {
        long j2 = j;
        C0514cz.m3110a("post pause job");
        this.f3274h = false;
        if (z) {
            this.f3271e.f3292c = false;
            C0502cn cnVar = r0;
            C0502cn cnVar2 = new C0502cn(this, j2, context, null, this.f3271e.f3290a, (Context) this.f3271e.f3291b.get(), null, 1, null, null, null, null, z, extraInfo, null);
            this.f3279m.post(cnVar);
            this.f3272f = j;
        } else if (!this.f3268b.f3292c) {
            C0514cz.m3117c("遗漏StatService.onResume() || missing StatService.onResume()");
        } else {
            this.f3268b.f3292c = false;
            C0502cn cnVar3 = r0;
            C0502cn cnVar4 = new C0502cn(this, j2, context, null, this.f3268b.f3290a, (Context) this.f3268b.f3291b.get(), null, 1, null, null, null, null, z, extraInfo, null);
            this.f3279m.post(cnVar3);
            this.f3272f = j;
        }
    }

    /* renamed from: a */
    public void mo3363a(C0001a aVar, long j) {
        C0514cz.m3110a("post resume job");
        if (this.f3269c.f3292c) {
            C0514cz.m3117c("遗漏StatService.onPause() || missing StatService.onPause()");
        }
        this.f3269c.f3292c = true;
        m3048j();
        C0503co coVar = new C0503co(this, this.f3272f, j, this.f3278l, null, aVar, null, 2, 2);
        this.f3279m.post(coVar);
        this.f3269c.f3291b = new WeakReference<>(aVar);
        this.f3269c.f3290a = j;
    }

    /* renamed from: b */
    public int mo3364b() {
        return this.f3277k;
    }

    /* renamed from: b */
    public void mo3365b(int i) {
        this.f3275i.mo3341b(i);
    }

    /* renamed from: b */
    public void mo3366b(long j) {
        this.f3275i.mo3342b(j);
    }

    @TargetApi(11)
    /* renamed from: b */
    public void mo3367b(Fragment fragment, long j) {
        C0514cz.m3110a("post pause job");
        if (!this.f3270d.f3292c) {
            C0514cz.m3117c("遗漏android.app.Fragment StatService.onResume() || android.app.Fragment missing StatService.onResume()");
            return;
        }
        this.f3270d.f3292c = false;
        C0502cn cnVar = r0;
        C0502cn cnVar2 = new C0502cn(this, j, null, null, this.f3270d.f3290a, null, null, 3, null, this.f3270d.f3291b.get(), fragment, null, false, null, null);
        this.f3279m.post(cnVar);
        this.f3272f = j;
    }

    /* renamed from: b */
    public void mo3368b(Context context, long j) {
        this.f3279m.post(new C0498cj(this, j, context));
    }

    /* renamed from: b */
    public void mo3369b(C0001a aVar, long j) {
        C0514cz.m3110a("post pause job");
        if (!this.f3269c.f3292c) {
            C0514cz.m3117c("遗漏android.support.v4.app.Fragment StatService.onResume() || android.support.v4.app.Fragment missing StatService.onResume()");
            return;
        }
        this.f3269c.f3292c = false;
        C0502cn cnVar = r0;
        C0502cn cnVar2 = new C0502cn(this, j, null, aVar, this.f3269c.f3290a, null, (C0001a) this.f3269c.f3291b.get(), 2, null, null, null, null, false, null, null);
        this.f3279m.post(cnVar);
        this.f3272f = j;
    }

    /* renamed from: c */
    public int mo3370c() {
        if (this.f3276j == -1) {
            this.f3276j = Config.SESSION_PERIOD;
        }
        return this.f3276j;
    }

    /* renamed from: c */
    public void mo3371c(int i) {
        this.f3275i.mo3337a(i);
    }

    /* renamed from: d */
    public void mo3372d() {
        mo3365b(mo3374f() + 1);
    }

    /* renamed from: e */
    public void mo3373e() {
        this.f3275i.mo3336a();
    }

    /* renamed from: f */
    public int mo3374f() {
        return this.f3275i.mo3345d();
    }

    /* renamed from: g */
    public long mo3375g() {
        return this.f3275i.mo3340b();
    }
}
