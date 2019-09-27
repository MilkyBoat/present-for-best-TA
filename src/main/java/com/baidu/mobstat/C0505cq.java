package com.baidu.mobstat;

import android.annotation.SuppressLint;
import com.androlua.BuildConfig;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.baidu.mobstat.cq */
public class C0505cq {
    /* renamed from: a */
    public static String m3071a(byte[] bArr) {
        try {
            return m3074b(m3072a(), m3075b(), bArr);
        } catch (Exception e) {
            C0514cz.m3116b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: a */
    public static byte[] m3072a() {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128, new SecureRandom());
        return instance.generateKey().getEncoded();
    }

    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    public static byte[] m3073a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    /* renamed from: b */
    public static String m3074b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            byte[] a = m3073a(bArr, bArr2, C0510cv.m3098a(bArr3));
            StringBuilder sb = new StringBuilder();
            sb.append(C0508ct.m3096b(a));
            sb.append("|");
            sb.append(C0516da.m3121a(bArr));
            sb.append("|");
            sb.append(C0516da.m3121a(bArr2));
            return sb.toString();
        } catch (Exception e) {
            C0514cz.m3116b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: b */
    public static byte[] m3075b() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
