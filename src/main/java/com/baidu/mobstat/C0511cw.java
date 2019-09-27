package com.baidu.mobstat;

import java.security.MessageDigest;

/* renamed from: com.baidu.mobstat.cw */
public final class C0511cw {
    /* renamed from: a */
    private static String m3101a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >> 4) & 15;
            byte b = bArr[i] & 15;
            sb.append((char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48));
            sb.append((char) (b >= 10 ? (b + 97) - 10 : b + 48));
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0043 A[SYNTHETIC, Splitter:B:33:0x0043] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3102b(java.security.MessageDigest r3, java.io.File r4) {
        /*
            boolean r0 = r4.isFile()
            if (r0 == 0) goto L_0x004c
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002a }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002a }
            r4 = 4048(0xfd0, float:5.672E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
        L_0x0010:
            int r0 = r1.read(r4)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r2 = -1
            if (r0 != r2) goto L_0x001d
            if (r1 == 0) goto L_0x0038
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x001d:
            r2 = 0
            r3.update(r4, r2, r0)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            goto L_0x0010
        L_0x0022:
            r3 = move-exception
            r0 = r1
            goto L_0x0041
        L_0x0025:
            r4 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x0028:
            r3 = move-exception
            goto L_0x0041
        L_0x002a:
            r4 = move-exception
        L_0x002b:
            com.baidu.mobstat.C0514cz.m3116b(r4)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r4 = move-exception
            com.baidu.mobstat.C0514cz.m3116b(r4)
        L_0x0038:
            byte[] r3 = r3.digest()
            java.lang.String r3 = m3101a(r3)
            return r3
        L_0x0041:
            if (r0 == 0) goto L_0x004b
            r0.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r4 = move-exception
            com.baidu.mobstat.C0514cz.m3116b(r4)
        L_0x004b:
            throw r3
        L_0x004c:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0511cw.m3102b(java.security.MessageDigest, java.io.File):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m3103b(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return m3101a(messageDigest.digest());
    }
}
