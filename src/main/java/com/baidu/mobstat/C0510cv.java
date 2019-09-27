package com.baidu.mobstat;

import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.baidu.mobstat.cv */
public class C0510cv {
    /* renamed from: a */
    public static byte[] m3098a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e) {
            C0029a.m806a(e);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
