package com.androlua;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.widget.EditText;
import java.io.File;
import java.util.HashMap;

public class Download {

    /* renamed from: a */
    private final LuaContext f2193a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f2194b;

    /* renamed from: c */
    private String f2195c;

    /* renamed from: d */
    private DownloadBroadcastReceiver f2196d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HashMap<Long, String[]> f2197e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnDownloadCompleteListener f2198f;

    /* renamed from: g */
    private String f2199g;

    /* renamed from: h */
    private String f2200h;

    /* renamed from: i */
    private String f2201i;

    /* renamed from: j */
    private String f2202j;

    /* renamed from: k */
    private long f2203k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f2204l;

    private class DownloadBroadcastReceiver extends BroadcastReceiver {
        private DownloadBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", 0);
            intent.getExtras();
            if (Download.this.f2197e.containsKey(Long.valueOf(longExtra)) && Download.this.f2198f != null) {
                String[] strArr = (String[]) Download.this.f2197e.get(Long.valueOf(longExtra));
                Download.this.f2198f.onDownloadComplete(strArr[0], strArr[1]);
            }
        }
    }

    public interface OnDownloadCompleteListener {
        void onDownloadComplete(String str, String str2);
    }

    public Download(LuaContext luaContext) {
        this.f2193a = luaContext;
    }

    public long getContentLength() {
        return this.f2203k;
    }

    public String getDestinationDir() {
        return this.f2200h;
    }

    public String getFilePath() {
        return this.f2204l;
    }

    public String getMimeType() {
        return this.f2202j;
    }

    public String getUrl() {
        return this.f2195c;
    }

    public String getUserAgent() {
        return this.f2201i;
    }

    public void setContentLength(long j) {
        this.f2203k = j;
    }

    public void setDestinationDir(String str) {
        this.f2200h = str;
    }

    public void setFilePath(String str) {
        this.f2204l = str;
    }

    public void setMessage(String str) {
        this.f2199g = str;
    }

    public void setMimeType(String str) {
        this.f2202j = str;
    }

    public void setOnDownloadCompleteListener(OnDownloadCompleteListener onDownloadCompleteListener) {
        this.f2198f = onDownloadCompleteListener;
    }

    public void setUrl(String str) {
        this.f2195c = str;
    }

    public void setUserAgent(String str) {
        this.f2201i = str;
    }

    public long start(boolean z) {
        if (this.f2196d == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
            this.f2196d = new DownloadBroadcastReceiver();
            this.f2193a.getContext().registerReceiver(this.f2196d, intentFilter);
        }
        DownloadManager downloadManager = (DownloadManager) this.f2193a.getContext().getSystemService("download");
        Uri parse = Uri.parse(this.f2195c);
        parse.getLastPathSegment();
        Request request = new Request(parse);
        if (this.f2200h == null) {
            this.f2200h = "Download";
        }
        request.setDestinationInExternalPublicDir(this.f2200h, this.f2204l);
        request.setTitle(this.f2204l);
        request.setDescription(this.f2195c);
        if (z) {
            request.setAllowedNetworkTypes(2);
        }
        if (this.f2202j == null) {
            this.f2202j = "*/*";
        }
        request.setMimeType(this.f2202j);
        long enqueue = downloadManager.enqueue(request);
        this.f2197e.put(Long.valueOf(enqueue), new String[]{new File(this.f2200h, this.f2204l).getAbsolutePath(), this.f2202j});
        return enqueue;
    }

    public void start() {
    }

    public void start(String str, String str2, String str3, String str4) {
        this.f2195c = str;
        this.f2199g = str4;
        Uri parse = Uri.parse(this.f2195c);
        this.f2204l = str3;
        if (str3 == null) {
            this.f2204l = parse.getLastPathSegment();
        }
        if (str2 == null) {
            this.f2200h = "Download";
        }
        this.f2194b = new EditText(this.f2193a.getContext());
        this.f2194b.setText(this.f2204l);
        if (this.f2199g == null) {
            this.f2199g = str;
        }
        new Builder(this.f2193a.getContext()).setTitle("Download").setMessage(this.f2199g).setView(this.f2194b).setPositiveButton("Download", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Download.this.f2204l = Download.this.f2194b.getText().toString();
                Download.this.start(false);
            }
        }).setNegativeButton("Cancel", null).setNeutralButton("Only Wifi", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Download.this.f2204l = Download.this.f2194b.getText().toString();
                Download.this.start(true);
            }
        }).create().show();
    }
}
