package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.az */
public class C0460az {

    /* renamed from: a */
    private static C0460az f3107a;

    /* renamed from: b */
    private Context f3108b;

    /* renamed from: c */
    private JSONObject f3109c = new JSONObject();

    /* renamed from: d */
    private long f3110d = 24;

    /* renamed from: e */
    private long f3111e = 0;

    /* renamed from: f */
    private long f3112f = 0;

    /* renamed from: g */
    private long f3113g = 0;

    /* renamed from: h */
    private long f3114h = 5;

    /* renamed from: i */
    private long f3115i = 24;

    /* renamed from: j */
    private long f3116j = 15;

    /* renamed from: k */
    private long f3117k = 15;

    /* renamed from: l */
    private long f3118l = 30;

    /* renamed from: m */
    private long f3119m = 12;

    /* renamed from: n */
    private long f3120n = 1;

    /* renamed from: o */
    private long f3121o = 24;

    /* renamed from: p */
    private String f3122p = BuildConfig.FLAVOR;

    /* renamed from: q */
    private String f3123q = BuildConfig.FLAVOR;

    private C0460az(Context context) {
        this.f3108b = context;
        m2871m();
        mo3237j();
        mo3238k();
    }

    /* renamed from: a */
    public static C0460az m2869a(Context context) {
        if (f3107a == null) {
            synchronized (C0460az.class) {
                if (f3107a == null) {
                    f3107a = new C0460az(context);
                }
            }
        }
        return f3107a;
    }

    /* renamed from: b */
    private long m2870b(long j) {
        if (j - System.currentTimeMillis() > 0) {
            return 0;
        }
        return j;
    }

    /* renamed from: m */
    private void m2871m() {
        String b = C0507cs.m3087b("backups/system/.timestamp");
        try {
            if (!TextUtils.isEmpty(b)) {
                this.f3109c = new JSONObject(b);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public long mo3222a(C0537u uVar) {
        long j = uVar.f3363j;
        try {
            String uVar2 = uVar.toString();
            if (this.f3109c.has(uVar2)) {
                j = this.f3109c.getLong(uVar2);
            }
        } catch (Exception e) {
            C0465bd.m2910a((Throwable) e);
        }
        return m2870b(j);
    }

    /* renamed from: a */
    public void mo3223a(C0537u uVar, long j) {
        uVar.f3363j = j;
        try {
            this.f3109c.put(uVar.toString(), j);
        } catch (Exception e) {
            C0465bd.m2910a((Throwable) e);
        }
        try {
            C0507cs.m3085a("backups/system/.timestamp", this.f3109c.toString(), false);
        } catch (Exception e2) {
            C0465bd.m2910a((Throwable) e2);
        }
    }

    /* renamed from: a */
    public void mo3224a(String str) {
        C0507cs.m3084a(this.f3108b, ".config2", str, false);
        mo3237j();
    }

    /* renamed from: a */
    public boolean mo3225a() {
        return this.f3111e != 0;
    }

    /* renamed from: a */
    public boolean mo3226a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }

    /* renamed from: b */
    public void mo3227b(String str) {
        C0507cs.m3084a(this.f3108b, ".sign", str, false);
        mo3238k();
    }

    /* renamed from: b */
    public boolean mo3228b() {
        return this.f3112f != 0;
    }

    /* renamed from: c */
    public long mo3229c() {
        return this.f3110d * 60 * 60 * 1000;
    }

    /* renamed from: c */
    public String mo3230c(String str) {
        return (TextUtils.isEmpty(this.f3122p) || !this.f3122p.equals(str) || TextUtils.isEmpty(this.f3123q)) ? BuildConfig.FLAVOR : this.f3123q;
    }

    /* renamed from: d */
    public long mo3231d() {
        return this.f3121o * 60 * 60 * 1000;
    }

    /* renamed from: e */
    public long mo3232e() {
        return this.f3114h * 60 * 1000;
    }

    /* renamed from: f */
    public long mo3233f() {
        return this.f3115i * 60 * 60 * 1000;
    }

    /* renamed from: g */
    public long mo3234g() {
        return this.f3116j * 24 * 60 * 60 * 1000;
    }

    /* renamed from: h */
    public long mo3235h() {
        return this.f3117k * 24 * 60 * 60 * 1000;
    }

    /* renamed from: i */
    public long mo3236i() {
        return this.f3119m * 60 * 60 * 1000;
    }

    /* renamed from: j */
    public void mo3237j() {
        try {
            String str = new String(C0516da.m3125b(false, C0509cu.m3097a(), C0508ct.m3094a(C0507cs.m3082a(this.f3108b, ".config2").getBytes())));
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.f3111e = jSONObject.getLong("c");
                } catch (JSONException e) {
                    C0465bd.m2913b((Throwable) e);
                }
                try {
                    this.f3114h = jSONObject.getLong("d");
                } catch (JSONException e2) {
                    C0465bd.m2913b((Throwable) e2);
                }
                try {
                    this.f3115i = jSONObject.getLong(Config.SESSTION_END_TIME);
                } catch (JSONException e3) {
                    C0465bd.m2913b((Throwable) e3);
                }
                try {
                    this.f3116j = jSONObject.getLong("i");
                } catch (JSONException e4) {
                    C0465bd.m2913b((Throwable) e4);
                }
                try {
                    this.f3110d = jSONObject.getLong("f");
                } catch (JSONException e5) {
                    C0465bd.m2913b((Throwable) e5);
                }
                try {
                    this.f3121o = jSONObject.getLong("s");
                } catch (JSONException e6) {
                    C0465bd.m2913b((Throwable) e6);
                }
                try {
                    this.f3117k = jSONObject.getLong("pk");
                } catch (JSONException e7) {
                    C0465bd.m2913b((Throwable) e7);
                }
                try {
                    this.f3118l = jSONObject.getLong("at");
                } catch (JSONException e8) {
                    C0465bd.m2913b((Throwable) e8);
                }
                try {
                    this.f3119m = jSONObject.getLong("as");
                } catch (JSONException e9) {
                    C0465bd.m2913b((Throwable) e9);
                }
                try {
                    this.f3120n = jSONObject.getLong("ac");
                } catch (JSONException e10) {
                    C0465bd.m2913b((Throwable) e10);
                }
                try {
                    this.f3112f = jSONObject.getLong(Config.DEVICE_MAC_ID);
                } catch (JSONException e11) {
                    C0465bd.m2913b((Throwable) e11);
                }
                try {
                    this.f3113g = jSONObject.getLong("lsc");
                } catch (JSONException e12) {
                    C0465bd.m2913b((Throwable) e12);
                }
            }
        } catch (Exception e13) {
            C0465bd.m2913b((Throwable) e13);
        }
    }

    /* renamed from: k */
    public void mo3238k() {
        try {
            String str = new String(C0516da.m3125b(false, C0509cu.m3097a(), C0508ct.m3094a(C0507cs.m3082a(this.f3108b, ".sign").getBytes())));
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.f3123q = jSONObject.getString(Config.SIGN);
                } catch (Exception e) {
                    C0465bd.m2913b((Throwable) e);
                }
                try {
                    this.f3122p = jSONObject.getString("ver");
                } catch (Exception e2) {
                    C0465bd.m2913b((Throwable) e2);
                }
            }
        } catch (Exception e3) {
            C0465bd.m2913b((Throwable) e3);
        }
    }

    /* renamed from: l */
    public boolean mo3239l() {
        long currentTimeMillis = System.currentTimeMillis();
        long a = mo3222a(C0537u.LAST_SEND);
        long d = mo3231d();
        StringBuilder sb = new StringBuilder();
        sb.append("canSend now=");
        sb.append(currentTimeMillis);
        sb.append(";lastSendTime=");
        sb.append(a);
        sb.append(";sendLogTimeInterval=");
        sb.append(d);
        C0465bd.m2909a(sb.toString());
        return currentTimeMillis - a > d || !mo3226a(a);
    }
}
