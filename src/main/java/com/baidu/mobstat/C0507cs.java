package com.baidu.mobstat;

import android.content.Context;
import android.os.Environment;
import com.androlua.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: com.baidu.mobstat.cs */
public final class C0507cs {

    /* renamed from: a */
    private static final Proxy f3317a = new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.172", 80));

    /* renamed from: b */
    private static final Proxy f3318b = new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80));

    /* renamed from: a */
    public static File m3080a(String str) {
        File file;
        if (!"mounted".equals(m3081a())) {
            return null;
        }
        try {
            file = Environment.getExternalStorageDirectory();
        } catch (Exception unused) {
            file = null;
        }
        if (file == null) {
            return null;
        }
        return new File(file, str);
    }

    /* renamed from: a */
    public static String m3081a() {
        try {
            return Environment.getExternalStorageState();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m3082a(Context context, String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = context.openFileInput(str);
            try {
                byte[] a = m3086a((InputStream) fileInputStream);
                if (a != null) {
                    String str2 = new String(a, "utf-8");
                    C0513cy.m3106a(fileInputStream);
                    return str2;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                C0513cy.m3106a(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            C0513cy.m3106a(fileInputStream);
            throw th;
        }
        C0513cy.m3106a(fileInputStream);
        return BuildConfig.FLAVOR;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    @android.annotation.SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.HttpURLConnection m3083a(android.content.Context r2, java.lang.String r3, int r4, int r5) {
        /*
            java.net.URL r0 = new java.net.URL
            r0.<init>(r3)
            java.lang.String r3 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            r3 = 0
            android.net.NetworkInfo r3 = r2.getNetworkInfo(r3)
            r1 = 1
            android.net.NetworkInfo r2 = r2.getNetworkInfo(r1)
            if (r2 == 0) goto L_0x002b
            boolean r2 = r2.isAvailable()
            if (r2 == 0) goto L_0x002b
            java.lang.String r2 = "WIFI is available"
            com.baidu.mobstat.C0514cz.m3110a(r2)
            java.net.URLConnection r2 = r0.openConnection()
        L_0x0028:
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
            goto L_0x006f
        L_0x002b:
            if (r3 == 0) goto L_0x006e
            boolean r2 = r3.isAvailable()
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = r3.getExtraInfo()
            if (r2 == 0) goto L_0x003e
            java.lang.String r2 = r2.toLowerCase()
            goto L_0x0040
        L_0x003e:
            java.lang.String r2 = ""
        L_0x0040:
            com.baidu.mobstat.C0514cz.m3110a(r2)
            java.lang.String r3 = "cmwap"
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x0067
            java.lang.String r3 = "uniwap"
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x0067
            java.lang.String r3 = "3gwap"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0067
        L_0x005c:
            java.lang.String r3 = "ctwap"
            boolean r2 = r2.startsWith(r3)
            if (r2 == 0) goto L_0x006e
            java.net.Proxy r2 = f3318b
            goto L_0x0069
        L_0x0067:
            java.net.Proxy r2 = f3317a
        L_0x0069:
            java.net.URLConnection r2 = r0.openConnection(r2)
            goto L_0x0028
        L_0x006e:
            r2 = 0
        L_0x006f:
            if (r2 != 0) goto L_0x0077
            java.net.URLConnection r2 = r0.openConnection()
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
        L_0x0077:
            r2.setConnectTimeout(r4)
            r2.setReadTimeout(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0507cs.m3083a(android.content.Context, java.lang.String, int, int):java.net.HttpURLConnection");
    }

    /* renamed from: a */
    public static void m3084a(Context context, String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        if (context != null) {
            try {
                fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
                try {
                    C0513cy.m3107a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    C0513cy.m3106a(fileOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                C0513cy.m3106a(fileOutputStream);
                throw th;
            }
            C0513cy.m3106a(fileOutputStream);
        }
    }

    /* renamed from: a */
    public static void m3085a(String str, String str2, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            File a = m3080a(str);
            if (a != null) {
                if (!a.exists()) {
                    File parentFile = a.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a, z);
                try {
                    C0513cy.m3107a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream2);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    C0513cy.m3106a(fileOutputStream);
                    throw th;
                }
                fileOutputStream = fileOutputStream2;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
            C0513cy.m3106a(fileOutputStream);
            throw th;
        }
        C0513cy.m3106a(fileOutputStream);
    }

    /* renamed from: a */
    private static byte[] m3086a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (C0513cy.m3107a(inputStream, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    /* renamed from: b */
    public static String m3087b(String str) {
        FileInputStream fileInputStream;
        File a = m3080a(str);
        if (a != null && a.exists()) {
            try {
                fileInputStream = new FileInputStream(a);
                try {
                    byte[] a2 = m3086a((InputStream) fileInputStream);
                    if (a2 != null) {
                        String str2 = new String(a2, "utf-8");
                        C0513cy.m3106a(fileInputStream);
                        return str2;
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    C0513cy.m3106a(fileInputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                C0513cy.m3106a(fileInputStream);
                throw th;
            }
            C0513cy.m3106a(fileInputStream);
        }
        return BuildConfig.FLAVOR;
    }

    /* renamed from: b */
    public static boolean m3088b(Context context, String str) {
        return context.deleteFile(str);
    }

    /* renamed from: c */
    public static boolean m3089c(Context context, String str) {
        return context.getFileStreamPath(str).exists();
    }

    /* renamed from: c */
    public static boolean m3090c(String str) {
        File a = m3080a(str);
        if (a == null || !a.isFile()) {
            return false;
        }
        return a.delete();
    }

    /* renamed from: d */
    public static HttpURLConnection m3091d(Context context, String str) {
        return m3083a(context, str, 50000, 50000);
    }

    /* renamed from: e */
    public static boolean m3092e(Context context, String str) {
        boolean z = false;
        try {
            if (context.checkCallingOrSelfPermission(str) != -1) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            C0514cz.m3114b("Check permission failed.");
            return false;
        }
    }
}
