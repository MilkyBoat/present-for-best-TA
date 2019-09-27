package com.baidu.mobstat;

import android.text.TextUtils;
import com.androlua.BuildConfig;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.baidu.mobstat.cr */
public class C0506cr {
    /* renamed from: a */
    public static byte[] m3076a(int i, byte[] bArr) {
        int i2 = i - 1;
        if (i2 < 0 || C0509cu.f3320a.length <= i2) {
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(C0509cu.f3320a[i2].getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    public static byte[] m3077b(int i, byte[] bArr) {
        int i2 = i - 1;
        if (i2 < 0 || C0509cu.f3320a.length <= i2) {
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(C0509cu.f3320a[i2].getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr);
    }

    /* renamed from: c */
    public static String m3078c(int i, byte[] bArr) {
        try {
            return C0508ct.m3096b(m3076a(i, bArr));
        } catch (Exception e) {
            C0514cz.m3112a((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: d */
    public static String m3079d(int i, byte[] bArr) {
        String c = m3078c(i, bArr);
        if (TextUtils.isEmpty(c)) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append("|");
        sb.append(i);
        return sb.toString();
    }
}
