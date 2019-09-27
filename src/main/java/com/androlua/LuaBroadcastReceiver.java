package com.androlua;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LuaBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private OnReceiveListener f2433a;

    public interface OnReceiveListener {
        void onReceive(Context context, Intent intent);
    }

    public LuaBroadcastReceiver(OnReceiveListener onReceiveListener) {
        this.f2433a = onReceiveListener;
    }

    public void onReceive(Context context, Intent intent) {
        this.f2433a.onReceive(context, intent);
    }
}
