package com.androlua;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;

public class LuaContentObserver extends ContentObserver implements LuaGcable {

    /* renamed from: a */
    private OnChangeListener f2444a;

    /* renamed from: b */
    private boolean f2445b;

    public interface OnChangeListener {
        void onChange(boolean z, Uri uri, Cursor cursor);
    }

    private LuaContentObserver(Handler handler) {
        super(handler);
    }

    public LuaContentObserver(LuaContext luaContext, Uri uri) {
        this(new Handler(LuaApplication.getInstance().getMainLooper()));
        luaContext.regGc(this);
        LuaApplication.getInstance().getContentResolver().registerContentObserver(uri, true, this);
    }

    public LuaContentObserver(LuaContext luaContext, String str) {
        this(new Handler(LuaApplication.getInstance().getMainLooper()));
        Uri parse = Uri.parse(str);
        luaContext.regGc(this);
        LuaApplication.getInstance().getContentResolver().registerContentObserver(parse, true, this);
    }

    /* renamed from: gc */
    public void mo2151gc() {
        LuaApplication.getInstance().getContentResolver().unregisterContentObserver(this);
        this.f2445b = true;
    }

    public boolean isGc() {
        return this.f2445b;
    }

    public void onChange(boolean z, Uri uri) {
        super.onChange(z, uri);
        if (this.f2444a != null) {
            Cursor query = LuaApplication.getInstance().getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                query.moveToFirst();
            }
            this.f2444a.onChange(z, uri, query);
            if (query != null) {
                query.close();
            }
        }
    }

    public void setOnChangeListener(OnChangeListener onChangeListener) {
        this.f2444a = onChangeListener;
    }
}
