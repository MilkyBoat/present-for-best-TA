package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Timer;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.baidu.mobstat.by */
class C0486by {

    /* renamed from: a */
    private static C0486by f3235a = new C0486by();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f3236b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f3237c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f3238d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SendStrategyEnum f3239e = SendStrategyEnum.APP_START;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Timer f3240f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f3241g;

    private C0486by() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.f3241g = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static C0486by m2993a() {
        return f3235a;
    }

    /* renamed from: a */
    private String m2994a(Context context, String str, String str2) {
        return !str.startsWith("https:") ? m3004c(context, str, str2) : m3001b(context, str, str2);
    }

    /* renamed from: b */
    private String m3001b(Context context, String str, String str2) {
        HttpURLConnection d = C0507cs.m3091d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        d.connect();
        C0514cz.m3110a("AdUtil.httpPost connected");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(d.getOutputStream())));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() == 200) {
                if (contentLength == 0) {
                    return sb.toString();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http code = ");
            sb2.append(d.getResponseCode());
            sb2.append("; contentResponse = ");
            sb2.append(sb);
            throw new IOException(sb2.toString());
        } finally {
            d.disconnect();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m3002b(Context context, String str) {
        boolean z = false;
        if (this.f3236b && !C0518dc.m3156n(context)) {
            return false;
        }
        try {
            m2994a(context, Config.LOG_SEND_URL, str);
            z = true;
        } catch (Exception e) {
            C0514cz.m3118c((Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("send log data over. result = ");
        sb.append(z);
        sb.append("; data=");
        sb.append(str);
        C0514cz.m3110a(sb.toString());
        return z;
    }

    /* renamed from: c */
    private String m3004c(Context context, String str, String str2) {
        C0514cz.m3110a("httpPostEncrypt");
        HttpURLConnection d = C0507cs.m3091d(context, str);
        d.setDoOutput(true);
        d.setInstanceFollowRedirects(false);
        d.setUseCaches(false);
        d.setRequestProperty("Content-Type", "gzip");
        byte[] a = C0505cq.m3072a();
        byte[] b = C0505cq.m3075b();
        d.setRequestProperty("key", C0516da.m3121a(a));
        d.setRequestProperty("iv", C0516da.m3121a(b));
        byte[] a2 = C0505cq.m3073a(a, b, str2.getBytes("utf-8"));
        d.connect();
        C0514cz.m3110a("AdUtil.httpPost connected");
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(d.getOutputStream());
            gZIPOutputStream.write(a2);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d.getContentLength();
            if (d.getResponseCode() == 200) {
                if (contentLength == 0) {
                    return sb.toString();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http code = ");
            sb2.append(d.getResponseCode());
            sb2.append("; contentResponse = ");
            sb2.append(sb);
            throw new IOException(sb2.toString());
        } finally {
            d.disconnect();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m3005c(Context context) {
        if (!this.f3236b || C0518dc.m3156n(context)) {
            this.f3241g.post(new C0491cc(this, context));
        }
    }

    /* renamed from: a */
    public void mo3324a(int i) {
        if (i >= 0 && i <= 30) {
            this.f3237c = i;
        }
    }

    /* renamed from: a */
    public void mo3325a(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context != null) {
            this.f3241g.post(new C0487bz(this, context));
        }
    }

    /* renamed from: a */
    public void mo3326a(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (!sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.f3239e = sendStrategyEnum;
            C0471bj.m2935a().mo3272a(context, this.f3239e.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                C0471bj.m2935a().mo3276b(context, 24);
            }
        } else if (i <= 0 || i > 24) {
            C0514cz.m3117c("timeInterval is invalid, new strategy does not work");
        } else {
            this.f3238d = i;
            this.f3239e = SendStrategyEnum.SET_TIME_INTERVAL;
            C0471bj.m2935a().mo3272a(context, this.f3239e.ordinal());
            C0471bj.m2935a().mo3276b(context, this.f3238d);
        }
        this.f3236b = z;
        C0471bj.m2935a().mo3274a(context, this.f3236b);
        StringBuilder sb = new StringBuilder();
        sb.append("sstype is:");
        sb.append(this.f3239e.name());
        sb.append(" And timeInterval is:");
        sb.append(this.f3238d);
        sb.append(" And mOnlyWifi:");
        sb.append(this.f3236b);
        C0514cz.m3110a(sb.toString());
    }

    /* renamed from: a */
    public void mo3327a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Config.PREFIX_SEND_DATA);
        sb.append(System.currentTimeMillis());
        C0507cs.m3084a(context, sb.toString(), str, false);
    }

    /* renamed from: b */
    public void mo3328b(Context context) {
        Context applicationContext = context.getApplicationContext();
        long j = (long) (this.f3238d * 3600000);
        this.f3240f = new Timer();
        this.f3240f.schedule(new C0490cb(this, applicationContext), j, j);
    }
}
