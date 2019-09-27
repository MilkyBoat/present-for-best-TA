package com.nirenr.screencapture;

import android.graphics.Bitmap;

public interface ScreenCaptureListener {
    void onScreenCaptureDone(Bitmap bitmap);

    void onScreenCaptureError(String str);
}
