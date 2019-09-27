package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.aw */
class C0457aw implements C0528l {

    /* renamed from: a */
    private C0462ba f3100a = C0462ba.f3125a;

    /* renamed from: b */
    private Object f3101b;

    /* renamed from: c */
    private Class<?> f3102c;

    public C0457aw(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("proxy is null.");
        } else if (!"com.baidu.bottom.remote.BPStretegyController2".equals(obj.getClass().getName())) {
            throw new IllegalArgumentException("class isn't com.baidu.bottom.remote.BPStretegyController2");
        } else {
            this.f3101b = obj;
            this.f3102c = obj.getClass();
        }
    }

    /* renamed from: a */
    private <T> T m2849a(Object[] objArr, String str, Class<?>[] clsArr) {
        return this.f3102c.getMethod(str, clsArr).invoke(this.f3101b, objArr);
    }

    /* renamed from: a */
    public void mo3215a(Context context, long j) {
        try {
            m2849a(new Object[]{context, Long.valueOf(j)}, "setLastUpdateTime", new Class[]{Context.class, Long.TYPE});
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            this.f3100a.mo3240a(context, j);
        }
    }

    /* renamed from: a */
    public void mo3216a(Context context, String str) {
        try {
            m2849a(new Object[]{context, str}, "saveRemoteConfig2", new Class[]{Context.class, String.class});
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            this.f3100a.mo3241a(context, str);
        }
    }

    /* renamed from: a */
    public void mo3217a(Context context, JSONObject jSONObject) {
        try {
            m2849a(new Object[]{context, jSONObject}, "startDataAnynalyze", new Class[]{Context.class, JSONObject.class});
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            this.f3100a.mo3242a(context, jSONObject);
        }
    }

    /* renamed from: a */
    public boolean mo3218a(Context context) {
        try {
            return ((Boolean) m2849a(new Object[]{context}, "needUpdate", new Class[]{Context.class})).booleanValue();
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            return this.f3100a.mo3243a(context);
        }
    }

    /* renamed from: b */
    public void mo3219b(Context context, String str) {
        try {
            m2849a(new Object[]{context, str}, "saveRemoteSign", new Class[]{Context.class, String.class});
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            this.f3100a.mo3244b(context, str);
        }
    }

    /* renamed from: b */
    public boolean mo3220b(Context context) {
        try {
            return ((Boolean) m2849a(new Object[]{context}, "canStartService", new Class[]{Context.class})).booleanValue();
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            return this.f3100a.mo3245b(context);
        }
    }
}
