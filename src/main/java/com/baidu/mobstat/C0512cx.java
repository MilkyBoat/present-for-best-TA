package com.baidu.mobstat;

import com.androlua.BuildConfig;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.baidu.mobstat.cx */
public class C0512cx {
    /* renamed from: a */
    public static String m3104a(File file) {
        try {
            return C0511cw.m3102b(MessageDigest.getInstance("SHA-256"), file);
        } catch (NoSuchAlgorithmException e) {
            C0514cz.m3116b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: a */
    public static String m3105a(byte[] bArr) {
        try {
            return C0511cw.m3103b(MessageDigest.getInstance("SHA-256"), bArr);
        } catch (Exception e) {
            C0514cz.m3116b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }
}
