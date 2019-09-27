package com.androlua;

import android.os.Handler;
import android.os.Message;

public class Ticker {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Handler f2733a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnTickListener f2734b;

    /* renamed from: c */
    private Thread f2735c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f2736d = 1000;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f2737e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f2738f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f2739g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f2740h;

    public interface OnTickListener {
        void onTick();
    }

    public Ticker() {
        m2324a();
    }

    /* renamed from: a */
    private void m2324a() {
        this.f2733a = new Handler() {
            public void handleMessage(Message message) {
                if (Ticker.this.f2734b != null) {
                    Ticker.this.f2734b.onTick();
                }
            }
        };
        this.f2735c = new Thread() {
            public void run() {
                Ticker.this.f2738f = true;
                while (Ticker.this.f2738f) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!Ticker.this.f2737e) {
                        Ticker.this.f2739g = currentTimeMillis - Ticker.this.f2740h;
                    }
                    if (currentTimeMillis - Ticker.this.f2739g >= Ticker.this.f2736d) {
                        Ticker.this.f2739g = currentTimeMillis;
                        Ticker.this.f2733a.sendEmptyMessage(0);
                    }
                    try {
                        sleep(1);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        };
    }

    public boolean getEnabled() {
        return this.f2737e;
    }

    public long getInterval() {
        return this.f2736d;
    }

    public long getPeriod() {
        return this.f2736d;
    }

    public boolean isRun() {
        return this.f2738f;
    }

    public void setEnabled(boolean z) {
        this.f2737e = z;
        if (!z) {
            this.f2740h = System.currentTimeMillis() - this.f2739g;
        }
    }

    public void setInterval(long j) {
        this.f2739g = System.currentTimeMillis();
        this.f2736d = j;
    }

    public void setOnTickListener(OnTickListener onTickListener) {
        this.f2734b = onTickListener;
    }

    public void setPeriod(long j) {
        this.f2739g = System.currentTimeMillis();
        this.f2736d = j;
    }

    public void start() {
        this.f2735c.start();
    }

    public void stop() {
        this.f2738f = false;
    }
}
