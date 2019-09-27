package com.androlua.util;

import android.util.Log;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.IOException;

public class RootUtil {

    /* renamed from: a */
    private static boolean f2795a;

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d A[SYNTHETIC, Splitter:B:38:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[SYNTHETIC, Splitter:B:43:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f A[SYNTHETIC, Splitter:B:49:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9 A[SYNTHETIC, Splitter:B:54:0x00a9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String execRootCmd(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            java.lang.String r3 = "su"
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            java.io.OutputStream r4 = r2.getOutputStream()     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            r4.<init>(r5)     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            java.lang.String r1 = "linin.root"
            android.util.Log.i(r1, r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r1.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r1.append(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r6 = "\n"
            r1.append(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r3.writeBytes(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r3.flush()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r6 = "exit\n"
            r3.writeBytes(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r3.flush()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
        L_0x0043:
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r6 == 0) goto L_0x005f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r1.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r1.append(r0)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r1.append(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r6 = "\n"
            r1.append(r6)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r0 = r6
            goto L_0x0043
        L_0x005f:
            r2.waitFor()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            if (r3 == 0) goto L_0x006c
            r3.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r6 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r6)
        L_0x006c:
            if (r4 == 0) goto L_0x009a
            r4.close()     // Catch:{ IOException -> 0x0072 }
            return r0
        L_0x0072:
            r6 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r6)
            return r0
        L_0x0077:
            r6 = move-exception
            goto L_0x009d
        L_0x0079:
            r6 = move-exception
            goto L_0x0080
        L_0x007b:
            r6 = move-exception
            r4 = r1
            goto L_0x009d
        L_0x007e:
            r6 = move-exception
            r4 = r1
        L_0x0080:
            r1 = r3
            goto L_0x0088
        L_0x0082:
            r6 = move-exception
            r3 = r1
            r4 = r3
            goto L_0x009d
        L_0x0086:
            r6 = move-exception
            r4 = r1
        L_0x0088:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r6)     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x0095
        L_0x0091:
            r6 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r6)
        L_0x0095:
            if (r4 == 0) goto L_0x009a
            r4.close()     // Catch:{ IOException -> 0x0072 }
        L_0x009a:
            return r0
        L_0x009b:
            r6 = move-exception
            r3 = r1
        L_0x009d:
            if (r3 == 0) goto L_0x00a7
            r3.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r0 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r0)
        L_0x00a7:
            if (r4 == 0) goto L_0x00b1
            r4.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r0 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r0)
        L_0x00b1:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.RootUtil.execRootCmd(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[SYNTHETIC, Splitter:B:22:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[SYNTHETIC, Splitter:B:29:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int execRootCmdSilent(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "su"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ Exception -> 0x0052 }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0052 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x0052 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r0 = "linin.root"
            android.util.Log.i(r0, r4)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r0.<init>()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r0.append(r4)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            java.lang.String r4 = "\n"
            r0.append(r4)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r2.writeBytes(r4)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r2.flush()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            java.lang.String r4 = "exit\n"
            r2.writeBytes(r4)     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r2.flush()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            r1.waitFor()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            int r4 = r1.exitValue()     // Catch:{ Exception -> 0x004c, all -> 0x004a }
            if (r2 == 0) goto L_0x0061
            r2.close()     // Catch:{ IOException -> 0x0045 }
            return r4
        L_0x0045:
            r0 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r0)
            return r4
        L_0x004a:
            r4 = move-exception
            goto L_0x0062
        L_0x004c:
            r4 = move-exception
            r0 = r2
            goto L_0x0053
        L_0x004f:
            r4 = move-exception
            r2 = r0
            goto L_0x0062
        L_0x0052:
            r4 = move-exception
        L_0x0053:
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)     // Catch:{ all -> 0x004f }
            if (r0 == 0) goto L_0x0060
            r0.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r4 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r4)
        L_0x0060:
            r4 = -1
        L_0x0061:
            return r4
        L_0x0062:
            if (r2 == 0) goto L_0x006c
            r2.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r0 = move-exception
            com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.m806a(r0)
        L_0x006c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.util.RootUtil.execRootCmdSilent(java.lang.String):int");
    }

    public static boolean haveRoot() {
        String str;
        String str2;
        if (f2795a) {
            str2 = "linin.root";
            str = "mHaveRoot = true, have root!";
        } else if (execRootCmdSilent("echo test") != -1) {
            Log.i("linin.root", "have root!");
            f2795a = true;
            return f2795a;
        } else {
            str2 = "linin.root";
            str = "not root!";
        }
        Log.i(str2, str);
        return f2795a;
    }

    public static boolean root() {
        try {
            Runtime.getRuntime().exec(new String[]{"/system/bin/su", "-c", "chmod 777 /dev/graphics/fb0"});
            Log.i("linin.root", "root success!");
            return true;
        } catch (IOException e) {
            C0029a.m806a(e);
            Log.i("linin.root", "root fail!");
            return false;
        }
    }
}
