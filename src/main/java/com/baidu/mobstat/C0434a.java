package com.baidu.mobstat;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.baidu.mobstat.a */
public final class C0434a {
    /* renamed from: a */
    public static byte[] m2792a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }

    /* renamed from: b */
    public static byte[] m2793b(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }
}
