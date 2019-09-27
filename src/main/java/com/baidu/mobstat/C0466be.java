package com.baidu.mobstat;

import com.androlua.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.be */
public class C0466be {

    /* renamed from: a */
    public boolean f3135a = false;

    /* renamed from: b */
    public String f3136b = BuildConfig.FLAVOR;

    /* renamed from: c */
    public boolean f3137c = false;

    public C0466be() {
    }

    public C0466be(JSONObject jSONObject) {
        try {
            this.f3135a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
        }
        try {
            this.f3136b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Exception e2) {
            C0465bd.m2913b((Throwable) e2);
        }
        try {
            this.f3137c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Exception e3) {
            C0465bd.m2913b((Throwable) e3);
        }
    }

    /* renamed from: a */
    public JSONObject mo3246a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SDK_BPLUS_SERVICE", this.f3135a);
        } catch (JSONException e) {
            C0465bd.m2913b((Throwable) e);
        }
        try {
            jSONObject.put("SDK_PRODUCT_LY", this.f3136b);
        } catch (JSONException e2) {
            C0465bd.m2913b((Throwable) e2);
        }
        try {
            jSONObject.put("SDK_LOCAL_SERVER", this.f3137c);
            return jSONObject;
        } catch (JSONException e3) {
            C0465bd.m2913b((Throwable) e3);
            return jSONObject;
        }
    }
}
