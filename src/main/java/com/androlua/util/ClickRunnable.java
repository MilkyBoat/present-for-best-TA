package com.androlua.util;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.androlua.LuaAccessibilityService;
import com.luajava.LuaTable;

public class ClickRunnable implements Runnable {

    /* renamed from: a */
    private final LuaAccessibilityService f2777a;

    /* renamed from: b */
    private LuaTable f2778b;

    /* renamed from: c */
    private int f2779c = 1;

    /* renamed from: d */
    private int f2780d = -1;

    /* renamed from: e */
    private int f2781e = -1;

    /* renamed from: f */
    private ClickCallback f2782f;

    /* renamed from: g */
    private boolean f2783g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ClickRunnable f2784h;

    public interface ClickCallback {
        void onDone(boolean z, LuaTable luaTable, String str, int i);
    }

    public ClickRunnable(LuaAccessibilityService luaAccessibilityService, LuaTable luaTable) {
        this.f2777a = luaAccessibilityService;
        this.f2778b = luaTable;
    }

    /* renamed from: a */
    private boolean m2363a(String str) {
        if (str == null) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("$");
        long j = 1000;
        if (lastIndexOf > 0) {
            try {
                j = Long.valueOf(str.substring(lastIndexOf + 1)).longValue();
            } catch (Exception unused) {
            }
            str = str.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf(">");
        if (lastIndexOf2 > 0) {
            if (this.f2780d < 0) {
                try {
                    this.f2780d = Integer.valueOf(str.substring(lastIndexOf2 + 1)).intValue();
                } catch (Exception unused2) {
                    this.f2780d = -1;
                }
            }
            str = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf("<");
        if (lastIndexOf3 > 0) {
            if (this.f2781e < 0) {
                try {
                    this.f2781e = Integer.valueOf(str.substring(lastIndexOf3 + 1)).intValue();
                } catch (Exception unused3) {
                    this.f2781e = -1;
                }
            }
            str = str.substring(0, lastIndexOf3);
        }
        this.f2781e--;
        this.f2780d--;
        AccessibilityNodeInfo findAccessibilityNodeInfo = this.f2777a.findAccessibilityNodeInfo(str);
        StringBuilder sb = new StringBuilder();
        sb.append("findAccessibilityNodeInfo ");
        sb.append(str);
        sb.append(",");
        sb.append(this.f2780d);
        sb.append(",");
        sb.append(this.f2781e);
        sb.append(",");
        sb.append(findAccessibilityNodeInfo);
        Log.i("lua", sb.toString());
        if (findAccessibilityNodeInfo != null) {
            this.f2780d = -1;
            this.f2777a.toClick2(findAccessibilityNodeInfo);
        } else if (this.f2780d <= 0 && this.f2781e <= 0) {
            if (this.f2782f != null) {
                this.f2782f.onDone(true, this.f2778b, str, this.f2779c);
            }
            return false;
        }
        this.f2777a.getHandler().postDelayed(this, j);
        return true;
    }

    public boolean canClick() {
        if (this.f2778b.length() == 0) {
            return false;
        }
        int length = this.f2778b.length();
        int i = 0;
        while (i < length) {
            if (this.f2783g) {
                if (this.f2782f != null) {
                    this.f2782f.onDone(false, this.f2778b, null, -1);
                }
                return false;
            }
            int i2 = i + 1;
            Object obj = this.f2778b.get(Integer.valueOf(i2));
            if (obj instanceof LuaTable) {
                LuaTable luaTable = (LuaTable) obj;
                if (luaTable.length() == 0) {
                    continue;
                } else {
                    String str = (String) luaTable.get(Integer.valueOf(1));
                    if (str != null && m2363a(str)) {
                        this.f2778b = luaTable;
                        return true;
                    }
                }
            } else if (obj instanceof String) {
                String str2 = (String) obj;
                AccessibilityNodeInfo findAccessibilityNodeInfo = this.f2777a.findAccessibilityNodeInfo(str2);
                if (findAccessibilityNodeInfo != null) {
                    this.f2777a.toClick2(findAccessibilityNodeInfo);
                    if (this.f2782f != null) {
                        this.f2782f.onDone(true, this.f2778b, str2, i);
                    }
                    return true;
                }
            } else {
                continue;
            }
            i = i2;
        }
        if (this.f2782f != null) {
            this.f2782f.onDone(false, this.f2778b, null, -1);
        }
        return false;
    }

    public boolean canClick(ClickCallback clickCallback) {
        this.f2782f = clickCallback;
        return canClick();
    }

    public void cancel() {
        this.f2783g = true;
        if (this.f2784h != null) {
            this.f2784h.cancel();
        }
    }

    public void run() {
        boolean z = false;
        if (this.f2783g) {
            if (this.f2782f != null) {
                this.f2782f.onDone(false, this.f2778b, null, -1);
            }
            return;
        }
        if (this.f2780d < 0 && this.f2781e < 0) {
            this.f2779c++;
        }
        Object obj = this.f2778b.get(Integer.valueOf(this.f2779c));
        if (obj == null) {
            if (this.f2782f != null) {
                ClickCallback clickCallback = this.f2782f;
                if (this.f2779c == this.f2778b.length()) {
                    z = true;
                }
                clickCallback.onDone(z, this.f2778b, null, this.f2779c);
            }
        } else if (obj instanceof LuaTable) {
            LuaTable luaTable = (LuaTable) obj;
            if (luaTable.length() != 0) {
                this.f2784h = new ClickRunnable(this.f2777a, luaTable);
                this.f2784h.canClick(new ClickCallback() {
                    public void onDone(boolean z, LuaTable luaTable, String str, int i) {
                        ClickRunnable.this.f2784h = null;
                        ClickRunnable.this.run();
                    }
                });
            }
        } else {
            if (obj instanceof String) {
                m2363a((String) obj);
            }
        }
    }
}
