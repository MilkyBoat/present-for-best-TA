package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.bi */
class C0470bi extends WebViewClient {

    /* renamed from: a */
    private WeakReference<Context> f3148a;

    /* renamed from: b */
    private WebViewClient f3149b;

    public C0470bi(Context context, WebViewClient webViewClient) {
        this.f3148a = new WeakReference<>(context);
        this.f3149b = webViewClient;
    }

    /* renamed from: a */
    private void m2934a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("action");
        JSONObject jSONObject2 = jSONObject.getJSONObject("obj");
        Context context = (Context) this.f3148a.get();
        if (context != null) {
            if ("onPageStart".equals(string)) {
                StatService.onPageStart(context, jSONObject2.getString("page"));
            } else if ("onPageEnd".equals(string)) {
                StatService.onPageEnd(context, jSONObject2.getString("page"));
            } else if ("onEvent".equals(string)) {
                StatService.onEvent(context, jSONObject2.getString("event_id"), jSONObject2.getString("label"), jSONObject2.getInt("acc"));
            } else if ("onEventStart".equals(string)) {
                StatService.onEventStart(context, jSONObject2.getString("event_id"), jSONObject2.getString("label"));
            } else if ("onEventEnd".equals(string)) {
                StatService.onEventEnd(context, jSONObject2.getString("event_id"), jSONObject2.getString("label"));
            } else {
                if ("onEventDuration".equals(string)) {
                    StatService.onEventDuration(context, jSONObject2.getString("event_id"), jSONObject2.getString("label"), jSONObject2.getLong("duration"));
                }
            }
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.f3149b != null) {
            this.f3149b.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        if (this.f3149b != null) {
            this.f3149b.onFormResubmission(webView, message, message2);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        if (this.f3149b != null) {
            this.f3149b.onLoadResource(webView, str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.f3149b != null) {
            this.f3149b.onPageFinished(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f3149b != null) {
            this.f3149b.onPageStarted(webView, str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.f3149b != null) {
            this.f3149b.onReceivedError(webView, i, str, str2);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.f3149b != null) {
            this.f3149b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (this.f3149b != null) {
            this.f3149b.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f3149b != null) {
            this.f3149b.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        if (this.f3149b != null) {
            this.f3149b.onScaleChanged(webView, f, f2);
        }
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        if (this.f3149b != null) {
            this.f3149b.onTooManyRedirects(webView, message, message2);
        }
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.f3149b != null) {
            this.f3149b.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.f3149b != null) {
            return this.f3149b.shouldInterceptRequest(webView, str);
        }
        return null;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.f3149b != null) {
            return this.f3149b.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "BaiduStatJSInterface"
            java.lang.String r1 = "shouldOverrideUrlLoading"
            android.util.Log.d(r0, r1)
            java.lang.String r0 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r5, r0)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0027 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0025 }
            if (r5 != 0) goto L_0x002e
            java.lang.String r5 = "bmtj:"
            boolean r5 = r0.startsWith(r5)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0025 }
            if (r5 == 0) goto L_0x002e
            r5 = 5
            java.lang.String r5 = r0.substring(r5)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0025 }
            r3.m2934a(r5)     // Catch:{ UnsupportedEncodingException | JSONException -> 0x0025 }
            r4 = 1
            return r4
        L_0x0025:
            r5 = move-exception
            goto L_0x002b
        L_0x0027:
            r0 = move-exception
            r2 = r0
            r0 = r5
            r5 = r2
        L_0x002b:
            com.baidu.mobstat.C0514cz.m3116b(r5)
        L_0x002e:
            android.webkit.WebViewClient r5 = r3.f3149b
            if (r5 == 0) goto L_0x0039
            android.webkit.WebViewClient r5 = r3.f3149b
            boolean r4 = r5.shouldOverrideUrlLoading(r4, r0)
            return r4
        L_0x0039:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0470bi.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }
}
