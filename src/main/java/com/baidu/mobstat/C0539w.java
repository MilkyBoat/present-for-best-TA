package com.baidu.mobstat;

import com.androlua.BuildConfig;

/* renamed from: com.baidu.mobstat.w */
public class C0539w {

    /* renamed from: a */
    private long f3364a = -1;

    /* renamed from: b */
    private String f3365b;

    /* renamed from: c */
    private String f3366c;

    public C0539w(long j, String str, String str2) {
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        this.f3364a = j;
        this.f3365b = str;
        this.f3366c = str2;
    }

    /* renamed from: a */
    public long mo3397a() {
        return this.f3364a;
    }

    /* renamed from: b */
    public String mo3398b() {
        return this.f3366c;
    }
}
