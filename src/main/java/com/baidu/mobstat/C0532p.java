package com.baidu.mobstat;

import com.androlua.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.p */
class C0532p {

    /* renamed from: a */
    private String f3342a;

    /* renamed from: b */
    private String f3343b;

    /* renamed from: c */
    private String f3344c;

    /* renamed from: d */
    private String f3345d;

    public C0532p(String str, String str2, String str3, String str4) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        if (str4 == null) {
            str4 = BuildConfig.FLAVOR;
        }
        this.f3342a = str;
        this.f3343b = str2;
        this.f3344c = str3;
        this.f3345d = str4;
    }

    /* renamed from: a */
    public JSONObject mo3391a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", this.f3342a);
            jSONObject.put("v", this.f3343b);
            jSONObject.put("c", this.f3344c);
            jSONObject.put(Config.APP_VERSION_CODE, this.f3345d);
            return jSONObject;
        } catch (JSONException e) {
            C0465bd.m2913b((Throwable) e);
            return null;
        }
    }
}
