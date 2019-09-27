package com.baidu.mobstat;

import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.cg */
class C0495cg {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f3259a;

    /* renamed from: b */
    private String f3260b;

    /* renamed from: c */
    private String f3261c;

    /* renamed from: d */
    private long f3262d;

    /* renamed from: e */
    private long f3263e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f3264f;

    /* renamed from: g */
    private JSONObject f3265g;

    public C0495cg(String str, String str2, String str3, long j, long j2, boolean z, ExtraInfo extraInfo) {
        this.f3260b = str;
        this.f3261c = str2;
        this.f3259a = str3;
        this.f3262d = j;
        this.f3263e = j2;
        this.f3264f = z;
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.f3265g = jSONObject;
    }

    /* renamed from: a */
    public String mo3347a() {
        return this.f3260b;
    }

    /* renamed from: a */
    public void mo3348a(C0495cg cgVar) {
        this.f3259a = cgVar.f3259a;
        this.f3260b = cgVar.f3260b;
        this.f3261c = cgVar.f3261c;
        this.f3262d = cgVar.f3262d;
        this.f3263e = cgVar.f3263e;
        this.f3264f = cgVar.f3264f;
        this.f3265g = cgVar.f3265g;
    }

    /* renamed from: b */
    public String mo3349b() {
        return this.f3261c;
    }

    /* renamed from: c */
    public long mo3350c() {
        return this.f3262d;
    }

    /* renamed from: d */
    public long mo3351d() {
        return this.f3263e;
    }

    /* renamed from: e */
    public JSONObject mo3352e() {
        return this.f3265g;
    }

    /* renamed from: f */
    public boolean mo3353f() {
        return this.f3264f;
    }
}
