package com.baidu.mobstat;

import android.text.TextUtils;
import com.androlua.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtraInfo {

    /* renamed from: a */
    String f3063a = BuildConfig.FLAVOR;

    /* renamed from: b */
    String f3064b = BuildConfig.FLAVOR;

    /* renamed from: c */
    String f3065c = BuildConfig.FLAVOR;

    /* renamed from: d */
    String f3066d = BuildConfig.FLAVOR;

    /* renamed from: e */
    String f3067e = BuildConfig.FLAVOR;

    /* renamed from: f */
    String f3068f = BuildConfig.FLAVOR;

    /* renamed from: g */
    String f3069g = BuildConfig.FLAVOR;

    /* renamed from: h */
    String f3070h = BuildConfig.FLAVOR;

    /* renamed from: i */
    String f3071i = BuildConfig.FLAVOR;

    /* renamed from: j */
    String f3072j = BuildConfig.FLAVOR;

    /* renamed from: a */
    private static String m2779a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.FLAVOR;
        }
        return m2780a(str, 1024) ? BuildConfig.FLAVOR : str;
    }

    /* renamed from: a */
    private static boolean m2780a(String str, int i) {
        int i2;
        boolean z = false;
        if (str == null) {
            return false;
        }
        try {
            i2 = str.getBytes().length;
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 > i) {
            z = true;
        }
        return z;
    }

    public JSONObject dumpToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f3063a)) {
                jSONObject.put("v1", this.f3063a);
            }
            if (!TextUtils.isEmpty(this.f3064b)) {
                jSONObject.put("v2", this.f3064b);
            }
            if (!TextUtils.isEmpty(this.f3065c)) {
                jSONObject.put("v3", this.f3065c);
            }
            if (!TextUtils.isEmpty(this.f3066d)) {
                jSONObject.put("v4", this.f3066d);
            }
            if (!TextUtils.isEmpty(this.f3067e)) {
                jSONObject.put("v5", this.f3067e);
            }
            if (!TextUtils.isEmpty(this.f3068f)) {
                jSONObject.put("v6", this.f3068f);
            }
            if (!TextUtils.isEmpty(this.f3069g)) {
                jSONObject.put("v7", this.f3069g);
            }
            if (!TextUtils.isEmpty(this.f3070h)) {
                jSONObject.put("v8", this.f3070h);
            }
            if (!TextUtils.isEmpty(this.f3071i)) {
                jSONObject.put("v9", this.f3071i);
            }
            if (!TextUtils.isEmpty(this.f3072j)) {
                jSONObject.put("v10", this.f3072j);
                return jSONObject;
            }
        } catch (JSONException e) {
            C0514cz.m3118c((Throwable) e);
        }
        return jSONObject;
    }

    public String getV1() {
        return this.f3063a;
    }

    public String getV10() {
        return this.f3072j;
    }

    public String getV2() {
        return this.f3064b;
    }

    public String getV3() {
        return this.f3065c;
    }

    public String getV4() {
        return this.f3066d;
    }

    public String getV5() {
        return this.f3067e;
    }

    public String getV6() {
        return this.f3068f;
    }

    public String getV7() {
        return this.f3069g;
    }

    public String getV8() {
        return this.f3070h;
    }

    public String getV9() {
        return this.f3071i;
    }

    public void setV1(String str) {
        this.f3063a = m2779a(str);
    }

    public void setV10(String str) {
        this.f3072j = m2779a(str);
    }

    public void setV2(String str) {
        this.f3064b = m2779a(str);
    }

    public void setV3(String str) {
        this.f3065c = m2779a(str);
    }

    public void setV4(String str) {
        this.f3066d = m2779a(str);
    }

    public void setV5(String str) {
        this.f3067e = m2779a(str);
    }

    public void setV6(String str) {
        this.f3068f = m2779a(str);
    }

    public void setV7(String str) {
        this.f3069g = m2779a(str);
    }

    public void setV8(String str) {
        this.f3070h = m2779a(str);
    }

    public void setV9(String str) {
        this.f3071i = m2779a(str);
    }
}
