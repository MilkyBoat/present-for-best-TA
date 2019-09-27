package com.nirenr.screencapture;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;

@TargetApi(21)
public class ScreenCaptureActivity extends Activity {
    public static final int REQUEST_MEDIA_PROJECTION = 18;

    /* renamed from: a */
    private TextView f3432a;

    public void finish() {
        if (VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 18) {
            ScreenShot.setResultData(null);
        } else if (i2 == -1 && intent != null) {
            ScreenShot.setResultData(intent);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3432a = new TextView(this);
        this.f3432a.setText("请授予权限");
        setContentView(this.f3432a);
        requesturePermission();
    }

    public void requesturePermission() {
        if (VERSION.SDK_INT < 21) {
            Toast.makeText(this, "仅支持安卓5以上系统", 0).show();
            return;
        }
        try {
            startActivityForResult(((MediaProjectionManager) getSystemService("media_projection")).createScreenCaptureIntent(), 18);
        } catch (Exception e) {
            C0029a.m806a(e);
            ScreenShot.setResultData(null);
        }
    }
}
