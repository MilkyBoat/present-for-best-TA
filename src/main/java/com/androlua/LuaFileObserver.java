package com.androlua;

import android.os.FileObserver;

public class LuaFileObserver extends FileObserver {

    /* renamed from: a */
    private OnEventListener f2511a;

    public interface OnEventListener {
        void onEvent(int i, String str);
    }

    public LuaFileObserver(String str) {
        super(str);
    }

    public LuaFileObserver(String str, int i) {
        super(str, i);
    }

    public void onEvent(int i, String str) {
        if (this.f2511a != null) {
            this.f2511a.onEvent(i, str);
        }
    }

    public void setOnEventListener(OnEventListener onEventListener) {
        this.f2511a = onEventListener;
    }
}
