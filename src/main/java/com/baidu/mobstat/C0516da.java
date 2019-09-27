package com.baidu.mobstat;

import com.androlua.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.baidu.mobstat.da */
public class C0516da {
    /* renamed from: a */
    public static String m3121a(byte[] bArr) {
        try {
            return C0508ct.m3096b(m3124a(false, C0509cu.m3097a(), bArr));
        } catch (Exception e) {
            C0514cz.m3116b((Throwable) e);
            return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: a */
    private static RSAKey m3122a(boolean z, byte[] bArr) {
        KeyFactory instance = KeyFactory.getInstance("RSA");
        return z ? (RSAPrivateKey) instance.generatePrivate(new PKCS8EncodedKeySpec(bArr)) : (RSAPublicKey) instance.generatePublic(new X509EncodedKeySpec(bArr));
    }

    /* renamed from: a */
    private static byte[] m3123a(int i, Key key, int i2, byte[] bArr) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(i, key);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        while (i3 < bArr.length) {
            int length = bArr.length - i3;
            if (length > i2) {
                length = i2;
            }
            byteArrayOutputStream.write(instance.doFinal(bArr, i3, length));
            i3 += i2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static byte[] m3124a(boolean z, byte[] bArr, byte[] bArr2) {
        RSAKey a = m3122a(z, bArr);
        return m3123a(1, (Key) a, ((a.getModulus().bitLength() + 1) / 8) - 11, bArr2);
    }

    /* renamed from: b */
    public static byte[] m3125b(boolean z, byte[] bArr, byte[] bArr2) {
        RSAKey a = m3122a(z, bArr);
        return m3123a(2, (Key) a, (a.getModulus().bitLength() + 1) / 8, bArr2);
    }
}
