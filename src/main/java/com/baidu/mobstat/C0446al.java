package com.baidu.mobstat;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.androlua.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.baidu.mobstat.al */
public class C0446al {

    /* renamed from: a */
    private static String f3081a = (VERSION.SDK_INT < 9 ? "http://openrcv.baidu.com/1010/bplus.gif" : "https://openrcv.baidu.com/1010/bplus.gif");

    /* renamed from: b */
    private static C0446al f3082b;

    /* renamed from: c */
    private Handler f3083c;

    private C0446al() {
        HandlerThread handlerThread = new HandlerThread("LogSender");
        handlerThread.start();
        this.f3083c = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static C0446al m2824a() {
        if (f3082b == null) {
            synchronized (C0446al.class) {
                if (f3082b == null) {
                    f3082b = new C0446al();
                }
            }
        }
        return f3082b;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private String m2825a(Context context, String str, String str2) {
        byte[] bArr;
        boolean z = !str.startsWith("https:");
        HttpURLConnection d = C0507cs.m3091d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Encoding", "gzip");
        d.connect();
        try {
            OutputStream outputStream = d.getOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            gZIPOutputStream.write(new byte[]{72, 77, 48, 49});
            gZIPOutputStream.write(new byte[]{0, 0, 0, 1});
            gZIPOutputStream.write(new byte[]{0, 0, 3, -14});
            gZIPOutputStream.write(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
            gZIPOutputStream.write(new byte[]{0, 2});
            gZIPOutputStream.write(z ? new byte[]{0, 1} : new byte[]{0, 0});
            gZIPOutputStream.write(new byte[]{72, 77, 48, 49});
            if (z) {
                byte[] a = C0505cq.m3072a();
                byte[] a2 = C0516da.m3124a(false, C0509cu.m3097a(), a);
                gZIPOutputStream.write(m2830a((long) a2.length, 4));
                gZIPOutputStream.write(a2);
                bArr = C0505cq.m3073a(a, new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, str2.getBytes("utf-8"));
                gZIPOutputStream.write(m2830a((long) bArr.length, 2));
            } else {
                bArr = str2.getBytes("utf-8");
            }
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            outputStream.close();
            int responseCode = d.getResponseCode();
            int contentLength = d.getContentLength();
            StringBuilder sb = new StringBuilder();
            sb.append("code: ");
            sb.append(responseCode);
            sb.append("; len: ");
            sb.append(contentLength);
            C0465bd.m2914c(sb.toString());
            if (responseCode == 200) {
                if (contentLength == 0) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            String sb3 = sb2.toString();
                            d.disconnect();
                            return sb3;
                        }
                        sb2.append(readLine);
                    }
                }
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Response code = ");
            sb4.append(d.getResponseCode());
            throw new IOException(sb4.toString());
        } catch (Exception e) {
            C0465bd.m2913b((Throwable) e);
            d.disconnect();
            return BuildConfig.FLAVOR;
        } catch (Throwable th) {
            d.disconnect();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2826a(Context context) {
        if ("mounted".equals(C0507cs.m3081a())) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/system");
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    try {
                        Arrays.sort(listFiles, new C0448an(this));
                    } catch (Exception e) {
                        C0465bd.m2913b((Throwable) e);
                    }
                    int i = 0;
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            String name = file2.getName();
                            if (!TextUtils.isEmpty(name) && name.startsWith("__send_log_data_")) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("backups/system");
                                sb.append(File.separator);
                                sb.append(name);
                                String sb2 = sb.toString();
                                if (m2831b(context, C0507cs.m3087b(sb2))) {
                                    C0507cs.m3090c(sb2);
                                    i = 0;
                                } else {
                                    i++;
                                    if (i >= 5) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2829a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("backups/system");
        sb.append(File.separator);
        sb.append("__send_log_data_");
        sb.append(System.currentTimeMillis());
        C0507cs.m3085a(sb.toString(), str, false);
    }

    /* renamed from: a */
    private static byte[] m2830a(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[(i - i2) - 1] = (byte) ((int) (j & 255));
            j >>= 8;
        }
        return bArr;
    }

    /* renamed from: b */
    private boolean m2831b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            m2825a(context, f3081a, str);
            return true;
        } catch (Exception e) {
            C0465bd.m2915c((Throwable) e);
            return false;
        }
    }

    /* renamed from: a */
    public void mo3208a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("data = ");
        sb.append(str);
        C0465bd.m2909a(sb.toString());
        if (str != null && !BuildConfig.FLAVOR.equals(str)) {
            this.f3083c.post(new C0447am(this, str, context));
        }
    }
}
