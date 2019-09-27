package com.baidu.mobstat;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.cf */
class C0494cf {

    /* renamed from: a */
    private volatile long f3251a = 0;

    /* renamed from: b */
    private volatile long f3252b = 0;

    /* renamed from: c */
    private volatile long f3253c = 0;

    /* renamed from: d */
    private volatile long f3254d = 0;

    /* renamed from: e */
    private volatile long f3255e = 0;

    /* renamed from: f */
    private volatile int f3256f = 0;

    /* renamed from: g */
    private volatile int f3257g = 0;

    /* renamed from: h */
    private List<C0495cg> f3258h = new ArrayList();

    public C0494cf() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f3251a = currentTimeMillis;
        this.f3255e = currentTimeMillis;
    }

    /* renamed from: a */
    public static JSONObject m3015a(C0495cg cgVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", cgVar.mo3347a());
            jSONObject.put("d", cgVar.mo3350c());
            long d = cgVar.mo3351d() - j;
            String str = Config.SESSTION_ACTIVITY_START;
            long j2 = 0;
            if (d >= 0) {
                j2 = d;
            }
            jSONObject.put(str, j2);
            jSONObject.put("t", cgVar.mo3349b());
            jSONObject.put("at", cgVar.mo3353f() ? 1 : 0);
            JSONObject e = cgVar.mo3352e();
            if (!(e == null || e.length() == 0)) {
                jSONObject.put("ext", e);
                return jSONObject;
            }
        } catch (JSONException e2) {
            C0514cz.m3116b((Throwable) e2);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m3016a(List<C0495cg> list, C0495cg cgVar) {
        if (list != null && cgVar != null) {
            int size = list.size();
            if (size == 0) {
                list.add(cgVar);
                return;
            }
            C0495cg cgVar2 = (C0495cg) list.get(size - 1);
            if (TextUtils.isEmpty(cgVar2.f3259a) || TextUtils.isEmpty(cgVar.f3259a)) {
                list.add(cgVar);
            } else if (!cgVar2.f3259a.equals(cgVar.f3259a) || cgVar2.f3264f == cgVar.f3264f) {
                list.add(cgVar);
            } else {
                if (cgVar2.f3264f) {
                    cgVar2.mo3348a(cgVar);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3336a() {
        long currentTimeMillis = System.currentTimeMillis();
        mo3344c(currentTimeMillis);
        this.f3252b = 0;
        this.f3253c = 0;
        this.f3254d = 0;
        this.f3255e = currentTimeMillis;
        this.f3256f = 0;
        this.f3257g = 0;
        this.f3257g = 0;
        this.f3258h.clear();
    }

    /* renamed from: a */
    public void mo3337a(int i) {
        this.f3257g = i;
    }

    /* renamed from: a */
    public void mo3338a(long j) {
        this.f3253c = j;
    }

    /* renamed from: a */
    public void mo3339a(C0495cg cgVar) {
        m3016a(this.f3258h, cgVar);
    }

    /* renamed from: b */
    public long mo3340b() {
        return this.f3251a;
    }

    /* renamed from: b */
    public void mo3341b(int i) {
        this.f3256f = i;
    }

    /* renamed from: b */
    public void mo3342b(long j) {
        this.f3254d = j;
    }

    /* renamed from: c */
    public JSONObject mo3343c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", this.f3251a);
            jSONObject.put(Config.SESSTION_END_TIME, this.f3252b);
            jSONObject.put("i", this.f3255e);
            jSONObject.put("c", this.f3256f);
            jSONObject.put(Config.SESSTION_TRACK_START_TIME, this.f3253c);
            jSONObject.put(Config.SESSTION_TRACK_END_TIME, this.f3254d);
            jSONObject.put(Config.SESSTION_TRIGGER_CATEGORY, this.f3257g);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f3258h.size(); i++) {
                jSONArray.put(m3015a((C0495cg) this.f3258h.get(i), this.f3251a));
            }
            jSONObject.put("p", jSONArray);
            return jSONObject;
        } catch (JSONException unused) {
            C0514cz.m3110a("StatSession.constructJSONObject() failed");
            return jSONObject;
        }
    }

    /* renamed from: c */
    public void mo3344c(long j) {
        this.f3251a = j;
    }

    /* renamed from: d */
    public int mo3345d() {
        return this.f3256f;
    }

    /* renamed from: d */
    public void mo3346d(long j) {
        this.f3252b = j;
    }
}
