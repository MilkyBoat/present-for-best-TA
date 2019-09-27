package com.androlua;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.luajava.LuaObject;
import com.luajava.LuaTable;

public class LuaFragment extends Fragment {

    /* renamed from: a */
    private LuaTable f2512a = null;

    /* renamed from: b */
    private LuaObject f2513b = null;

    /* renamed from: c */
    private View f2514c;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            if (this.f2514c != null) {
                return this.f2514c;
            }
            if (this.f2512a == null) {
                return new TextView(getActivity());
            }
            return (View) ((LuaObject) this.f2512a.getLuaState().getLuaObject("require").call("loadlayout")).call(this.f2512a);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void setLayout(View view) {
        this.f2514c = view;
        this.f2512a = null;
    }

    public void setLayout(LuaTable luaTable) {
        this.f2512a = luaTable;
        this.f2514c = null;
    }
}
