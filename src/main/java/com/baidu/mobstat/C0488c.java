package com.baidu.mobstat;

import com.androlua.BuildConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.baidu.mobstat.c */
public final class C0488c {
    /* renamed from: a */
    public static String m3012a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m3013a(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return m3012a(instance.digest(), BuildConfig.FLAVOR, z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
