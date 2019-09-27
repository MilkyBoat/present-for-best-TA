package com.androlua;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import bsh.org.objectweb.asm.Constants;
import java.io.IOException;

class LuaCameraView extends SurfaceView {

    /* renamed from: a */
    private SurfaceHolder f2434a;

    public LuaCameraView(Context context) {
        super(context);
        this.f2434a = null;
        this.f2434a = getHolder();
        this.f2434a.addCallback(new Callback() {

            /* renamed from: b */
            private Camera f2436b;

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Parameters parameters = this.f2436b.getParameters();
                parameters.setPictureFormat(Constants.ACC_NATIVE);
                parameters.setPreviewSize(854, 480);
                parameters.setFocusMode("auto");
                parameters.setPictureSize(2592, 1456);
                this.f2436b.startPreview();
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                this.f2436b = Camera.open();
                try {
                    this.f2436b.setPreviewDisplay(surfaceHolder);
                } catch (IOException unused) {
                    this.f2436b = null;
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                this.f2436b.stopPreview();
                this.f2436b.release();
                this.f2436b = null;
            }
        });
        this.f2434a.setType(3);
    }
}
