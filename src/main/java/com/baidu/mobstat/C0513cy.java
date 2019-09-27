package com.baidu.mobstat;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.baidu.mobstat.cy */
public final class C0513cy {
    /* renamed from: a */
    public static void m3106a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                C0514cz.m3116b(th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m3107a(InputStream inputStream, OutputStream outputStream) {
        if (!(inputStream == null || outputStream == null)) {
            byte[] bArr = new byte[4048];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return true;
                    }
                    outputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    C0514cz.m3116b((Throwable) e);
                }
            }
        }
        return false;
    }
}
