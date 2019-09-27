package com.androlua;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.ClientCertRequest;
import android.webkit.DownloadListener;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LuaWebView extends WebView implements LuaGcable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DownloadBroadcastReceiver f2664a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HashMap<Long, String[]> f2665b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnDownloadCompleteListener f2666c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LuaActivity f2667d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ProgressBar f2668e;

    /* renamed from: f */
    private DisplayMetrics f2669f;

    /* renamed from: g */
    private Dialog f2670g;

    /* renamed from: h */
    private ListView f2671h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ValueCallback<Uri> f2672i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f2673j = "/";
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LuaFunction<Boolean> f2674k;

    /* renamed from: l */
    private boolean f2675l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public OnReceivedTitleListener f2676m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public OnReceivedIconListener f2677n;

    private class Download implements DownloadListener {

        /* renamed from: a */
        EditText f2686a;

        /* renamed from: c */
        private String f2688c;

        /* renamed from: d */
        private String f2689d;

        /* renamed from: e */
        private String f2690e;

        /* renamed from: f */
        private String f2691f;

        /* renamed from: g */
        private long f2692g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public String f2693h;

        private Download() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public long m2317a(boolean z) {
            if (LuaWebView.this.f2664a == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
                LuaWebView.this.f2664a = new DownloadBroadcastReceiver();
                LuaWebView.this.f2667d.registerReceiver(LuaWebView.this.f2664a, intentFilter);
            }
            DownloadManager downloadManager = (DownloadManager) LuaWebView.this.f2667d.getSystemService("download");
            Uri parse = Uri.parse(this.f2688c);
            parse.getLastPathSegment();
            Request request = new Request(parse);
            String luaExtDir = LuaWebView.this.f2667d.getLuaExtDir("Download");
            StringBuilder sb = new StringBuilder();
            sb.append(new File(LuaWebView.this.f2667d.getLuaExtDir()).getName());
            sb.append("/");
            sb.append("Download");
            request.setDestinationInExternalPublicDir(sb.toString(), this.f2693h);
            request.setTitle(this.f2693h);
            request.setDescription(this.f2688c);
            if (z) {
                request.setAllowedNetworkTypes(2);
            }
            File file = new File(luaExtDir, this.f2693h);
            if (file.exists()) {
                file.delete();
            }
            request.setMimeType(this.f2691f);
            long enqueue = downloadManager.enqueue(request);
            LuaWebView.this.f2665b.put(Long.valueOf(enqueue), new String[]{new File(luaExtDir, this.f2693h).getAbsolutePath(), this.f2691f});
            return enqueue;
        }

        @SuppressLint({"DefaultLocale"})
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            String str5;
            Object[] objArr;
            this.f2688c = str;
            this.f2689d = str2;
            this.f2690e = str3;
            this.f2691f = str4;
            this.f2692g = j;
            this.f2693h = Uri.parse(this.f2688c).getLastPathSegment();
            if (str3 != null) {
                String str6 = "filename=\"";
                int indexOf = str3.indexOf(str6);
                if (indexOf != -1) {
                    int length = indexOf + str6.length();
                    int indexOf2 = str3.indexOf(34, length);
                    if (indexOf2 > length) {
                        this.f2693h = str3.substring(length, indexOf2);
                    }
                }
            }
            this.f2686a = new EditText(LuaWebView.this.f2667d);
            this.f2686a.setText(this.f2693h);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(j));
            sb.append("B");
            String sb2 = sb.toString();
            if (j > 1048576) {
                str5 = "%.2f MB";
                objArr = new Object[]{Double.valueOf(Long.valueOf(j).doubleValue() / 1048576.0d)};
            } else {
                if (j > 1024) {
                    str5 = "%.2f KB";
                    objArr = new Object[]{Double.valueOf(Long.valueOf(j).doubleValue() / 1024.0d)};
                }
                Builder title = new Builder(LuaWebView.this.f2667d).setTitle("Download");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Type: ");
                sb3.append(str4);
                sb3.append("\nSize: ");
                sb3.append(sb2);
                title.setMessage(sb3.toString()).setView(this.f2686a).setPositiveButton("Download", new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Download.this.f2693h = Download.this.f2686a.getText().toString();
                        Download.this.m2317a(false);
                    }
                }).setNegativeButton(17039360, null).setNeutralButton("Only Wifi", new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Download.this.f2693h = Download.this.f2686a.getText().toString();
                        Download.this.m2317a(true);
                    }
                }).create().show();
            }
            sb2 = String.format(str5, objArr);
            Builder title2 = new Builder(LuaWebView.this.f2667d).setTitle("Download");
            StringBuilder sb32 = new StringBuilder();
            sb32.append("Type: ");
            sb32.append(str4);
            sb32.append("\nSize: ");
            sb32.append(sb2);
            title2.setMessage(sb32.toString()).setView(this.f2686a).setPositiveButton("Download", new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Download.this.f2693h = Download.this.f2686a.getText().toString();
                    Download.this.m2317a(false);
                }
            }).setNegativeButton(17039360, null).setNeutralButton("Only Wifi", new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Download.this.f2693h = Download.this.f2686a.getText().toString();
                    Download.this.m2317a(true);
                }
            }).create().show();
        }
    }

    private class DownloadBroadcastReceiver extends BroadcastReceiver {
        private DownloadBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", 0);
            intent.getExtras();
            if (LuaWebView.this.f2665b.containsKey(Long.valueOf(longExtra)) && LuaWebView.this.f2666c != null) {
                String[] strArr = (String[]) LuaWebView.this.f2665b.get(Long.valueOf(longExtra));
                LuaWebView.this.f2666c.onDownloadComplete(strArr[0], strArr[1]);
            }
        }
    }

    public interface JsInterface {
        @JavascriptInterface
        String execute(String str);
    }

    class JsObject {

        /* renamed from: b */
        private JsInterface f2698b;

        public JsObject(JsInterface jsInterface) {
            this.f2698b = jsInterface;
        }

        @JavascriptInterface
        public String execute(String str) {
            return this.f2698b.execute(str);
        }
    }

    private class LuaJavaScriptInterface {

        /* renamed from: b */
        private LuaActivity f2700b;

        public LuaJavaScriptInterface(LuaActivity luaActivity) {
            this.f2700b = luaActivity;
        }

        @JavascriptInterface
        public Object callLuaFunction(String str) {
            return this.f2700b.runFunc(str, new Object[0]);
        }

        @JavascriptInterface
        public Object callLuaFunction(String str, String str2) {
            return this.f2700b.runFunc(str, str2);
        }

        @JavascriptInterface
        public Object doLuaString(String str) {
            return this.f2700b.doString(str, new Object[0]);
        }
    }

    class LuaWebChromeClient extends WebChromeClient {

        /* renamed from: a */
        EditText f2701a = new EditText(LuaWebView.this.f2667d);

        LuaWebChromeClient() {
        }

        public Bitmap getDefaultVideoPoster() {
            return BitmapFactory.decodeResource(LuaWebView.this.f2667d.getResources(), C0364R.drawable.icon);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new Builder(LuaWebView.this.f2667d).setTitle(str).setMessage(str2).setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setCancelable(false).create().show();
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            Builder builder = new Builder(LuaWebView.this.f2667d);
            builder.setTitle(str);
            builder.setMessage(str2);
            builder.setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.setNegativeButton(17039360, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
            builder.setCancelable(false);
            builder.create();
            builder.show();
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
            this.f2701a.setText(str3);
            Builder builder = new Builder(LuaWebView.this.f2667d);
            builder.setTitle(str);
            builder.setMessage(str2);
            builder.setView(this.f2701a);
            builder.setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.confirm(LuaWebChromeClient.this.f2701a.getText().toString());
                }
            });
            builder.setNegativeButton(17039360, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.cancel();
                }
            });
            builder.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    jsPromptResult.cancel();
                }
            });
            builder.show();
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                LuaWebView.this.f2668e.setVisibility(8);
            } else {
                LuaWebView.this.f2668e.setVisibility(0);
                LuaWebView.this.f2668e.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            super.onReceivedIcon(webView, bitmap);
            if (LuaWebView.this.f2677n != null) {
                LuaWebView.this.f2677n.onReceivedIcon(bitmap);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (LuaWebView.this.f2676m != null) {
                LuaWebView.this.f2676m.onReceivedTitle(str);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            openFileChooser(valueCallback, BuildConfig.FLAVOR);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            if (LuaWebView.this.f2672i == null) {
                LuaWebView.this.f2672i = valueCallback;
                LuaWebView.this.openFile(LuaWebView.this.f2673j);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            openFileChooser(valueCallback, str);
        }
    }

    public interface LuaWebViewClient {
        public static final int ERROR_AUTHENTICATION = -4;
        public static final int ERROR_BAD_URL = -12;
        public static final int ERROR_CONNECT = -6;
        public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
        public static final int ERROR_FILE = -13;
        public static final int ERROR_FILE_NOT_FOUND = -14;
        public static final int ERROR_HOST_LOOKUP = -2;
        public static final int ERROR_IO = -7;
        public static final int ERROR_PROXY_AUTHENTICATION = -5;
        public static final int ERROR_REDIRECT_LOOP = -9;
        public static final int ERROR_TIMEOUT = -8;
        public static final int ERROR_TOO_MANY_REQUESTS = -15;
        public static final int ERROR_UNKNOWN = -1;
        public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
        public static final int ERROR_UNSUPPORTED_SCHEME = -10;

        void doUpdateVisitedHistory(WebView webView, String str, boolean z);

        void onFormResubmission(WebView webView, Message message, Message message2);

        void onLoadResource(WebView webView, String str);

        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void onProceededAfterSslError(WebView webView, SslError sslError);

        void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest, String str);

        void onReceivedError(WebView webView, int i, String str, String str2);

        void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2);

        void onReceivedLoginRequest(WebView webView, String str, String str2, String str3);

        void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

        void onScaleChanged(WebView webView, float f, float f2);

        @Deprecated
        void onTooManyRedirects(WebView webView, Message message, Message message2);

        void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent);

        WebResourceResponse shouldInterceptRequest(WebView webView, String str);

        boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent);

        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public interface OnDownloadCompleteListener {
        void onDownloadComplete(String str, String str2);
    }

    public interface OnDownloadStartListener {
        void onDownloadStart(String str, String str2, String str3, String str4, long j);
    }

    public interface OnReceivedIconListener {
        void onReceivedIcon(Bitmap bitmap);
    }

    public interface OnReceivedTitleListener {
        void onReceivedTitle(String str);
    }

    private class SimpleLuaWebViewClient extends WebViewClient {

        /* renamed from: b */
        private LuaWebViewClient f2716b;

        public SimpleLuaWebViewClient(LuaWebViewClient luaWebViewClient) {
            this.f2716b = luaWebViewClient;
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            this.f2716b.doUpdateVisitedHistory(webView, str, z);
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            message.sendToTarget();
        }

        public void onLoadResource(WebView webView, String str) {
            this.f2716b.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            this.f2716b.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f2716b.onPageStarted(webView, str, bitmap);
        }

        public void onProceededAfterSslError(WebView webView, SslError sslError) {
            this.f2716b.onProceededAfterSslError(webView, sslError);
        }

        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest, String str) {
            this.f2716b.onReceivedClientCertRequest(webView, clientCertRequest, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f2716b.onReceivedError(webView, i, str, str2);
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.f2716b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            this.f2716b.onReceivedLoginRequest(webView, str, str2, str3);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.f2716b.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public void onScaleChanged(WebView webView, float f, float f2) {
            this.f2716b.onScaleChanged(webView, f, f2);
        }

        @Deprecated
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            message.sendToTarget();
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            this.f2716b.onUnhandledKeyEvent(webView, keyEvent);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (LuaWebView.this.f2674k != null) {
                try {
                    if (((Boolean) LuaWebView.this.f2674k.call(str)).booleanValue()) {
                        return new WebResourceResponse(null, null, null);
                    }
                } catch (LuaException e) {
                    C0029a.m806a(e);
                }
            }
            return this.f2716b.shouldInterceptRequest(webView, str);
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return this.f2716b.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return this.f2716b.shouldOverrideUrlLoading(webView, str);
        }
    }

    @SuppressLint({"AddJavascriptInterface", "SetJavaScriptEnabled"})
    public LuaWebView(LuaActivity luaActivity) {
        super(luaActivity);
        luaActivity.regGc(this);
        this.f2667d = luaActivity;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setDisplayZoomControls(true);
        getSettings().setSupportZoom(true);
        getSettings().setDomStorageEnabled(true);
        if (VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        addJavascriptInterface(new LuaJavaScriptInterface(luaActivity), "androlua");
        setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
                Builder builder = new Builder(LuaWebView.this.f2667d);
                builder.setTitle("SslError");
                builder.setMessage(sslError.toString());
                builder.setPositiveButton(17039370, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.proceed();
                    }
                });
                builder.setNegativeButton(17039360, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.cancel();
                    }
                });
                builder.setCancelable(false);
                builder.create();
                builder.show();
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (LuaWebView.this.f2674k != null) {
                    try {
                        Boolean bool = (Boolean) LuaWebView.this.f2674k.call(str);
                        if (bool != null && bool.booleanValue()) {
                            return new WebResourceResponse(null, null, null);
                        }
                    } catch (LuaException e) {
                        C0029a.m806a(e);
                    }
                }
                return null;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (LuaWebView.this.f2674k != null) {
                    try {
                        Boolean bool = (Boolean) LuaWebView.this.f2674k.call(str);
                        if (bool != null && bool.booleanValue()) {
                            return true;
                        }
                    } catch (LuaException e) {
                        C0029a.m806a(e);
                    }
                }
                if (str.startsWith("http") || str.startsWith("file")) {
                    webView.loadUrl(str);
                    return true;
                }
                try {
                    LuaWebView.this.f2667d.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0);
                    return true;
                } catch (Exception e2) {
                    LuaWebView.this.f2667d.sendError("LuaWebView", e2);
                    return true;
                }
            }
        });
        this.f2669f = luaActivity.getResources().getDisplayMetrics();
        int applyDimension = (int) TypedValue.applyDimension(1, 2.0f, this.f2669f);
        this.f2668e = new ProgressBar(luaActivity, null, 16842872);
        this.f2668e.setLayoutParams(new LayoutParams(-1, applyDimension, 0, 0));
        addView(this.f2668e);
        setWebChromeClient(new LuaWebChromeClient());
        setDownloadListener(new Download());
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void addJSInterface(JsInterface jsInterface, String str) {
        super.addJavascriptInterface(new JsObject(jsInterface), str);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void addJsInterface(JsInterface jsInterface, String str) {
        super.addJavascriptInterface(new JsObject(jsInterface), str);
    }

    public void destroy() {
        if (this.f2664a != null) {
            this.f2667d.unregisterReceiver(this.f2664a);
        }
        super.destroy();
    }

    /* renamed from: gc */
    public void mo2151gc() {
        destroy();
        this.f2675l = true;
    }

    public boolean isGc() {
        return this.f2675l;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) this.f2668e.getLayoutParams();
        layoutParams.x = i;
        layoutParams.y = i2;
        this.f2668e.setLayoutParams(layoutParams);
        super.onScrollChanged(i, i2, i3, i4);
    }

    public void openFile(String str) {
        if (this.f2670g == null) {
            this.f2670g = new Dialog(getContext());
            this.f2671h = new ListView(getContext());
            this.f2671h.setFastScrollEnabled(true);
            this.f2671h.setFastScrollAlwaysVisible(true);
            this.f2670g.setContentView(this.f2671h);
            this.f2671h.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (charSequence.equals("../")) {
                        LuaWebView luaWebView = LuaWebView.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(new File(LuaWebView.this.f2673j).getParent());
                        sb.append("/");
                        luaWebView.f2673j = sb.toString();
                        LuaWebView.this.openFile(LuaWebView.this.f2673j);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(LuaWebView.this.f2673j);
                    sb2.append(charSequence);
                    String sb3 = sb2.toString();
                    if (new File(sb3).isDirectory()) {
                        LuaWebView.this.f2673j = sb3;
                        LuaWebView.this.openFile(LuaWebView.this.f2673j);
                        return;
                    }
                    LuaWebView.this.f2672i.onReceiveValue(Uri.parse(sb3));
                }
            });
        }
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add("../");
        String[] list = file.list();
        if (list != null) {
            Arrays.sort(list);
            for (String str2 : list) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f2673j);
                sb.append(str2);
                if (new File(sb.toString()).isDirectory()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append("/");
                    arrayList.add(sb2.toString());
                }
            }
            for (String str3 : list) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.f2673j);
                sb3.append(str3);
                if (new File(sb3.toString()).isFile()) {
                    arrayList.add(str3);
                }
            }
        }
        this.f2671h.setAdapter(new ArrayAdapter(getContext(), 17367043, arrayList));
        this.f2670g.setTitle(this.f2673j);
        this.f2670g.show();
    }

    public void setAdsFilter(LuaFunction<Boolean> luaFunction) {
        this.f2674k = luaFunction;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        super.setDownloadListener(downloadListener);
    }

    public void setOnDownloadCompleteListener(OnDownloadCompleteListener onDownloadCompleteListener) {
        this.f2666c = onDownloadCompleteListener;
    }

    public void setOnDownloadStartListener(final OnDownloadStartListener onDownloadStartListener) {
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                onDownloadStartListener.onDownloadStart(str, str2, str3, str4, j);
            }
        });
    }

    public void setOnKeyListener(OnKeyListener onKeyListener) {
        super.setOnKeyListener(onKeyListener);
    }

    public void setOnReceivedIconListener(OnReceivedIconListener onReceivedIconListener) {
        this.f2677n = onReceivedIconListener;
    }

    public void setOnReceivedTitleListener(OnReceivedTitleListener onReceivedTitleListener) {
        this.f2676m = onReceivedTitleListener;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.f2668e = progressBar;
    }

    public void setProgressBarEnabled(boolean z) {
        ProgressBar progressBar;
        int i;
        if (z) {
            progressBar = this.f2668e;
            i = 0;
        } else {
            progressBar = this.f2668e;
            i = 8;
        }
        progressBar.setVisibility(i);
    }

    public void setWebViewClient(LuaWebViewClient luaWebViewClient) {
        super.setWebViewClient(new SimpleLuaWebViewClient(luaWebViewClient));
    }
}
