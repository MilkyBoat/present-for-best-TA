package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.j */
class C0526j {

    /* renamed from: a */
    public String f3337a;

    /* renamed from: b */
    public String f3338b;

    /* renamed from: c */
    public int f3339c;

    private C0526j() {
        this.f3339c = 2;
    }

    /* synthetic */ C0526j(C0524h hVar) {
        this();
    }

    /* renamed from: a */
    public static C0526j m3197a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("deviceid");
            String string2 = jSONObject.getString("imei");
            int i = jSONObject.getInt("ver");
            if (!TextUtils.isEmpty(string) && string2 != null) {
                C0526j jVar = new C0526j();
                jVar.f3337a = string;
                jVar.f3338b = string2;
                jVar.f3339c = i;
                return jVar;
            }
        } catch (JSONException e) {
            C0523g.m3184b((Throwable) e);
        }
        return null;
    }

    /* renamed from: a */
    public String mo3387a() {
        try {
            return new JSONObject().put("deviceid", this.f3337a).put("imei", this.f3338b).put("ver", this.f3339c).toString();
        } catch (JSONException e) {
            C0523g.m3184b((Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    public String mo3388b() {
        String str = this.f3338b;
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        String stringBuffer = new StringBuffer(str).reverse().toString();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3337a);
        sb.append("|");
        sb.append(stringBuffer);
        return sb.toString();
    }
}
