package com.androlua.util;

public abstract class TimerTaskX implements Runnable {

    /* renamed from: a */
    private long f2803a;

    /* renamed from: b */
    final Object f2804b = new Object();

    /* renamed from: c */
    boolean f2805c;

    /* renamed from: d */
    long f2806d;

    /* renamed from: e */
    long f2807e;

    /* renamed from: f */
    boolean f2808f;

    /* renamed from: g */
    private boolean f2809g;

    protected TimerTaskX() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo2694a() {
        boolean z;
        synchronized (this.f2804b) {
            if (this.f2806d <= 0) {
                if (this.f2803a <= 0) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean cancel() {
        boolean z;
        synchronized (this.f2804b) {
            z = !this.f2805c && this.f2806d > 0;
            this.f2805c = true;
        }
        return z;
    }

    public long getPeriod() {
        return this.f2807e;
    }

    public boolean isEnabled() {
        return this.f2809g;
    }

    public abstract void run();

    public long scheduledExecutionTime() {
        long j;
        synchronized (this.f2804b) {
            j = this.f2803a;
        }
        return j;
    }

    public void setEnabled(boolean z) {
        this.f2809g = z;
    }

    public void setPeriod(long j) {
        this.f2807e = j;
    }

    public void setScheduledTime(long j) {
        synchronized (this.f2804b) {
            this.f2803a = j;
        }
    }
}
