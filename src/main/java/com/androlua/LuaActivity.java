package com.androlua;

import android.R.style;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.FileProvider;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.ArrayListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.androlua.LuaBroadcastReceiver.OnReceiveListener;
import com.androlua.LuaService.LuaBinder;
import com.androlua.Ticker.OnTickListener;
import com.baidu.mobstat.StatService;
import com.luajava.JavaFunction;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LuaActivity extends Activity implements OnReceiveListener, LuaContext {

    /* renamed from: J */
    private static String f2299J;

    /* renamed from: K */
    private static final HashMap<String, LuaActivity> f2300K = new HashMap<>();

    /* renamed from: a */
    private static ArrayList<String> f2301a = new ArrayList<>();

    /* renamed from: A */
    private String f2302A;

    /* renamed from: B */
    private LuaBroadcastReceiver f2303B;

    /* renamed from: C */
    private String f2304C;

    /* renamed from: D */
    private String f2305D;

    /* renamed from: E */
    private boolean f2306E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f2307F = true;

    /* renamed from: G */
    private LuaResources f2308G;

    /* renamed from: H */
    private ArrayList<LuaGcable> f2309H = new ArrayList<>();

    /* renamed from: I */
    private String f2310I = "main";

    /* renamed from: L */
    private LuaObject f2311L;

    /* renamed from: b */
    private String f2312b;

    /* renamed from: c */
    private Handler f2313c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f2314d;

    /* renamed from: e */
    private String f2315e;

    /* renamed from: f */
    private LuaDexLoader f2316f;

    /* renamed from: g */
    private int f2317g;

    /* renamed from: h */
    private int f2318h;

    /* renamed from: i */
    private ListView f2319i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayListAdapter<String> f2320j;

    /* renamed from: k */
    private LuaState f2321k;

    /* renamed from: l */
    private String f2322l;

    /* renamed from: m */
    private StringBuilder f2323m = new StringBuilder();

    /* renamed from: n */
    private Boolean f2324n = Boolean.valueOf(false);

    /* renamed from: o */
    private Toast f2325o;

    /* renamed from: p */
    private LinearLayout f2326p;

    /* renamed from: q */
    private boolean f2327q;

    /* renamed from: r */
    private long f2328r;

    /* renamed from: s */
    private Menu f2329s;

    /* renamed from: t */
    private LuaObject f2330t;

    /* renamed from: u */
    private LuaObject f2331u;

    /* renamed from: v */
    private LuaObject f2332v;

    /* renamed from: w */
    private LuaObject f2333w;

    /* renamed from: x */
    private String f2334x;

    /* renamed from: y */
    private String f2335y;

    /* renamed from: z */
    private String f2336z;

    public class MainHandler extends Handler {
        public MainHandler() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    String string = message.getData().getString("data");
                    if (LuaActivity.this.f2307F) {
                        LuaActivity.this.showToast(string);
                    }
                    TextView b = LuaActivity.this.f2314d;
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append("\n");
                    b.append(sb.toString());
                    LuaActivity.this.f2320j.add(string);
                    return;
                case 1:
                    Bundle data = message.getData();
                    LuaActivity.this.m2152a(data.getString("data"), ((Object[]) data.getSerializable("args"))[0]);
                    return;
                case 2:
                    LuaActivity.this.runFunc(message.getData().getString("data"), new Object[0]);
                    return;
                case 3:
                    LuaActivity.this.runFunc(message.getData().getString("data"), (Object[]) message.getData().getSerializable("args"));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private String m2147a(int i) {
        switch (i) {
            case 1:
                return "Yield error";
            case 2:
                return "Runtime error";
            case 3:
                return "Syntax error";
            case 4:
                return "Out of memory";
            case 5:
                return "GC error";
            case 6:
                return "error error";
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown error ");
                sb.append(i);
                return sb.toString();
        }
    }

    /* renamed from: a */
    private String m2148a(File file) {
        int lastIndexOf = file.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(file.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    /* renamed from: a */
    private void m2149a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge").getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.valueOf(true));
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m2151a(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            ((HashMap) declaredField.get(obj)).clear();
            LuaDialog luaDialog = new LuaDialog(this);
            luaDialog.setTitle("提示3");
            luaDialog.setMessage("你的手机运行环境不安全");
            luaDialog.setPosButton("确定");
            luaDialog.show();
        } catch (Exception e) {
            C0029a.m806a(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2152a(String str, Object obj) {
        synchronized (this.f2321k) {
            try {
                this.f2321k.pushObjectValue(obj);
                this.f2321k.setGlobal(str);
            } catch (LuaException e) {
                sendError("setField", e);
            }
        }
    }

    /* renamed from: a */
    private static byte[] m2154a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* renamed from: b */
    private void m2156b() {
        try {
            Object newInstance = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedHelpers").newInstance();
            if (newInstance != null) {
                m2151a(newInstance, "fieldCache");
                m2151a(newInstance, "methodCache");
                m2151a(newInstance, "constructorCache");
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m2158c() {
        this.f2321k = LuaStateFactory.newLuaState();
        this.f2321k.openLibs();
        this.f2321k.pushJavaObject(this);
        this.f2321k.setGlobal("activity");
        this.f2321k.getGlobal("activity");
        this.f2321k.setGlobal("this");
        this.f2321k.pushContext(this);
        this.f2321k.getGlobal("luajava");
        this.f2321k.pushString(this.f2302A);
        this.f2321k.setField(-2, "luaextdir");
        this.f2321k.pushString(this.f2312b);
        this.f2321k.setField(-2, "luadir");
        this.f2321k.pushString(this.f2322l);
        this.f2321k.setField(-2, "luapath");
        this.f2321k.pop(1);
        m2159d();
        new LuaPrint(this, this.f2321k).register("print");
        this.f2321k.getGlobal("package");
        this.f2321k.pushString(this.f2304C);
        this.f2321k.setField(-2, "path");
        this.f2321k.pushString(this.f2315e);
        this.f2321k.setField(-2, "cpath");
        this.f2321k.pop(1);
        new JavaFunction(this.f2321k) {
            public int execute() {
                ((LuaThread) this.f3375b.toJavaObject(2)).set(this.f3375b.toString(3), this.f3375b.toJavaObject(4));
                return 0;
            }
        }.register("set");
        new JavaFunction(this.f2321k) {
            public int execute() {
                LuaThread luaThread = (LuaThread) this.f3375b.toJavaObject(2);
                int top = this.f3375b.getTop();
                if (top > 3) {
                    Object[] objArr = new Object[(top - 3)];
                    for (int i = 4; i <= top; i++) {
                        objArr[i - 4] = this.f3375b.toJavaObject(i);
                    }
                    luaThread.call(this.f3375b.toString(3), objArr);
                } else if (top == 3) {
                    luaThread.call(this.f3375b.toString(3));
                }
                return 0;
            }
        }.register("call");
    }

    /* renamed from: d */
    private void m2159d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2312b);
        sb.append("/init.lua");
        if (new File(sb.toString()).exists()) {
            try {
                LuaState luaState = this.f2321k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f2312b);
                sb2.append("/init.lua");
                int LloadFile = luaState.LloadFile(sb2.toString());
                if (LloadFile == 0) {
                    this.f2321k.newTable();
                    LuaObject luaObject = this.f2321k.getLuaObject(-1);
                    this.f2321k.setUpValue(-2, 1);
                    int pcall = this.f2321k.pcall(0, 0, 0);
                    if (pcall == 0) {
                        if (f2299J == null) {
                            LuaObject field = luaObject.getField("app_key");
                            if (field.isString()) {
                                f2299J = field.toString();
                                StatService.setAppKey(field.toString());
                            }
                            LuaObject field2 = luaObject.getField("app_channel");
                            if (field2.isString()) {
                                StatService.setAppChannel(this, field2.toString(), true);
                            }
                            StatService.setOn(this, 1);
                        }
                        LuaObject field3 = luaObject.getField("appname");
                        if (field3.isString()) {
                            setTitle(field3.getString());
                        }
                        LuaObject field4 = luaObject.getField("app_name");
                        if (field4.isString()) {
                            setTitle(field4.getString());
                        }
                        LuaObject field5 = luaObject.getField("debugmode");
                        if (field5.isBoolean()) {
                            this.f2307F = field5.getBoolean();
                        }
                        LuaObject field6 = luaObject.getField("debug_mode");
                        if (field6.isBoolean()) {
                            this.f2307F = field6.getBoolean();
                        }
                        LuaObject field7 = luaObject.getField("theme");
                        if (field7.isNumber()) {
                            setTheme((int) field7.getInteger());
                            return;
                        }
                        if (field7.isString()) {
                            setTheme(style.class.getField(field7.getString()).getInt(null));
                        }
                        return;
                    }
                    LloadFile = pcall;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(m2147a(LloadFile));
                sb3.append(": ");
                sb3.append(this.f2321k.toString(-1));
                throw new LuaException(sb3.toString());
            } catch (Exception e) {
                sendMsg(e.getMessage());
            }
        }
    }

    public static LuaActivity getActivity(String str) {
        return (LuaActivity) f2300K.get(str);
    }

    public void assetsToSD(String str, String str2) {
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        InputStream open = getAssets().open(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    public boolean bindService(int i) {
        return bindService(new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LuaActivity.this.runFunc("onServiceConnected", componentName, ((LuaBinder) iBinder).getService());
            }

            public void onServiceDisconnected(ComponentName componentName) {
                LuaActivity.this.runFunc("onServiceDisconnected", componentName);
            }
        }, i);
    }

    public boolean bindService(ServiceConnection serviceConnection, int i) {
        Intent intent = new Intent(this, LuaService.class);
        intent.putExtra("luaDir", this.f2312b);
        intent.putExtra("luaPath", this.f2322l);
        return super.bindService(intent, serviceConnection, i);
    }

    public void call(String str) {
        push(2, str);
    }

    public void call(String str, Object[] objArr) {
        if (objArr.length == 0) {
            push(2, str);
        } else {
            push(3, str, objArr);
        }
    }

    public void createShortcut(String str, String str2) {
        String str3;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(getPackageName(), LuaActivity.class.getName());
        intent.setData(Uri.parse(str));
        if (VERSION.SDK_INT >= 22) {
            intent.addFlags(524288);
            intent.addFlags(134217728);
        }
        if (VERSION.SDK_INT >= 26) {
            try {
                ((ShortcutManager) getSystemService("shortcut")).requestPinShortcut(new Builder(this, str).setIcon(Icon.createWithResource(this, C0364R.drawable.icon)).setShortLabel(str2).setIntent(intent).build(), null);
            } catch (Exception e) {
                C0029a.m806a(e);
                str3 = "添加快捷方式出错";
            }
        } else {
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            ShortcutIconResource fromContext = ShortcutIconResource.fromContext(this, C0364R.drawable.icon);
            intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent2.putExtra("duplicate", 0);
            intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", fromContext);
            sendBroadcast(intent2);
            str3 = "已添加快捷方式";
            Toast.makeText(this, str3, 0).show();
        }
    }

    public void createShortcut(String str, String str2, String str3) {
        String str4;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClassName(getPackageName(), LuaActivity.class.getName());
        intent.setData(Uri.parse(str));
        if (VERSION.SDK_INT >= 22) {
            intent.addFlags(524288);
            intent.addFlags(134217728);
        }
        if (VERSION.SDK_INT >= 26) {
            try {
                ((ShortcutManager) getSystemService("shortcut")).requestPinShortcut(new Builder(this, str).setIcon(Icon.createWithFilePath(str3)).setShortLabel(str2).setIntent(intent).build(), null);
            } catch (Exception e) {
                C0029a.m806a(e);
                str4 = "添加快捷方式出错";
            }
        } else {
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent2.putExtra("duplicate", 0);
            intent2.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeFile(str3));
            sendBroadcast(intent2);
            str4 = "已添加快捷方式";
            Toast.makeText(this, str4, 0).show();
        }
    }

    public Object doAsset(String str, Object... objArr) {
        int i = 0;
        try {
            byte[] readAsset = readAsset(str);
            this.f2321k.setTop(0);
            int LloadBuffer = this.f2321k.LloadBuffer(readAsset, str);
            if (LloadBuffer == 0) {
                try {
                    this.f2321k.getGlobal("debug");
                    this.f2321k.getField(-1, "traceback");
                    this.f2321k.remove(-2);
                    this.f2321k.insert(-2);
                    for (Object pushObjectValue : objArr) {
                        this.f2321k.pushObjectValue(pushObjectValue);
                    }
                    i = this.f2321k.pcall(r2, 0, -2 - r2);
                    if (i == 0) {
                        return this.f2321k.toJavaObject(-1);
                    }
                } catch (Exception e) {
                    e = e;
                    i = LloadBuffer;
                    setTitle(m2147a(i));
                    setContentView(this.f2326p);
                    sendMsg(e.getMessage());
                    return null;
                }
            } else {
                i = LloadBuffer;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2147a(i));
            sb.append(": ");
            sb.append(this.f2321k.toString(-1));
            throw new LuaException(sb.toString());
        } catch (Exception e2) {
            e = e2;
            setTitle(m2147a(i));
            setContentView(this.f2326p);
            sendMsg(e.getMessage());
            return null;
        }
    }

    public Object doFile(String str) {
        return doFile(str, new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doFile(java.lang.String r10, java.lang.Object[] r11) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            char r3 = r10.charAt(r1)     // Catch:{ LuaException -> 0x00a5 }
            r4 = 47
            if (r3 == r4) goto L_0x0021
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ LuaException -> 0x00a5 }
            r3.<init>()     // Catch:{ LuaException -> 0x00a5 }
            java.lang.String r4 = r9.f2312b     // Catch:{ LuaException -> 0x00a5 }
            r3.append(r4)     // Catch:{ LuaException -> 0x00a5 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ LuaException -> 0x00a5 }
            r3.append(r10)     // Catch:{ LuaException -> 0x00a5 }
            java.lang.String r10 = r3.toString()     // Catch:{ LuaException -> 0x00a5 }
        L_0x0021:
            com.luajava.LuaState r3 = r9.f2321k     // Catch:{ LuaException -> 0x00a5 }
            r3.setTop(r1)     // Catch:{ LuaException -> 0x00a5 }
            com.luajava.LuaState r3 = r9.f2321k     // Catch:{ LuaException -> 0x00a5 }
            int r10 = r3.LloadFile(r10)     // Catch:{ LuaException -> 0x00a5 }
            if (r10 != 0) goto L_0x006e
            com.luajava.LuaState r3 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            java.lang.String r4 = "debug"
            r3.getGlobal(r4)     // Catch:{ LuaException -> 0x006c }
            com.luajava.LuaState r3 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            java.lang.String r4 = "traceback"
            r3.getField(r2, r4)     // Catch:{ LuaException -> 0x006c }
            com.luajava.LuaState r3 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            r4 = -2
            r3.remove(r4)     // Catch:{ LuaException -> 0x006c }
            com.luajava.LuaState r3 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            r3.insert(r4)     // Catch:{ LuaException -> 0x006c }
            int r3 = r11.length     // Catch:{ LuaException -> 0x006c }
            r5 = 0
        L_0x0049:
            if (r5 >= r3) goto L_0x0055
            com.luajava.LuaState r6 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            r7 = r11[r5]     // Catch:{ LuaException -> 0x006c }
            r6.pushObjectValue(r7)     // Catch:{ LuaException -> 0x006c }
            int r5 = r5 + 1
            goto L_0x0049
        L_0x0055:
            com.luajava.LuaState r11 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            int r4 = r4 - r3
            int r11 = r11.pcall(r3, r0, r4)     // Catch:{ LuaException -> 0x006c }
            if (r11 != 0) goto L_0x006a
            com.luajava.LuaState r10 = r9.f2321k     // Catch:{ LuaException -> 0x0065 }
            java.lang.Object r10 = r10.toJavaObject(r2)     // Catch:{ LuaException -> 0x0065 }
            return r10
        L_0x0065:
            r10 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x00a8
        L_0x006a:
            r10 = r11
            goto L_0x006e
        L_0x006c:
            r11 = move-exception
            goto L_0x00a8
        L_0x006e:
            android.content.Intent r11 = new android.content.Intent     // Catch:{ LuaException -> 0x006c }
            r11.<init>()     // Catch:{ LuaException -> 0x006c }
            java.lang.String r3 = "data"
            com.luajava.LuaState r4 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            java.lang.String r4 = r4.toString(r2)     // Catch:{ LuaException -> 0x006c }
            r11.putExtra(r3, r4)     // Catch:{ LuaException -> 0x006c }
            r9.setResult(r10, r11)     // Catch:{ LuaException -> 0x006c }
            com.luajava.LuaException r11 = new com.luajava.LuaException     // Catch:{ LuaException -> 0x006c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ LuaException -> 0x006c }
            r3.<init>()     // Catch:{ LuaException -> 0x006c }
            java.lang.String r4 = r9.m2147a(r10)     // Catch:{ LuaException -> 0x006c }
            r3.append(r4)     // Catch:{ LuaException -> 0x006c }
            java.lang.String r4 = ": "
            r3.append(r4)     // Catch:{ LuaException -> 0x006c }
            com.luajava.LuaState r4 = r9.f2321k     // Catch:{ LuaException -> 0x006c }
            java.lang.String r4 = r4.toString(r2)     // Catch:{ LuaException -> 0x006c }
            r3.append(r4)     // Catch:{ LuaException -> 0x006c }
            java.lang.String r3 = r3.toString()     // Catch:{ LuaException -> 0x006c }
            r11.<init>(r3)     // Catch:{ LuaException -> 0x006c }
            throw r11     // Catch:{ LuaException -> 0x006c }
        L_0x00a5:
            r10 = move-exception
            r11 = r10
            r10 = 0
        L_0x00a8:
            java.lang.String r10 = r9.m2147a(r10)
            r9.setTitle(r10)
            android.widget.LinearLayout r10 = r9.f2326p
            r9.setContentView(r10)
            java.lang.String r10 = r11.getMessage()
            r9.sendMsg(r10)
            java.lang.String r10 = r11.getMessage()
            java.lang.String r11 = "android.permission."
            int r3 = r10.indexOf(r11)
            r4 = 0
            if (r3 <= 0) goto L_0x0134
            int r11 = r11.length()
            int r3 = r3 + r11
            java.lang.String r11 = "."
            int r11 = r10.indexOf(r11, r3)
            if (r11 <= r3) goto L_0x0134
            java.lang.String r10 = r10.substring(r3, r11)
            com.luajava.LuaState r11 = r9.f2321k
            java.lang.String r3 = "require"
            r11.getGlobal(r3)
            com.luajava.LuaState r11 = r9.f2321k
            java.lang.String r3 = "permission"
            r11.pushString(r3)
            com.luajava.LuaState r11 = r9.f2321k
            r11.pcall(r0, r1, r1)
            com.luajava.LuaState r11 = r9.f2321k
            java.lang.String r0 = "permission_info"
            r11.getGlobal(r0)
            com.luajava.LuaState r11 = r9.f2321k
            r11.getField(r2, r10)
            com.luajava.LuaState r11 = r9.f2321k
            boolean r11 = r11.isString(r2)
            if (r11 == 0) goto L_0x011f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            java.lang.String r10 = " ("
            r11.append(r10)
            com.luajava.LuaState r10 = r9.f2321k
            java.lang.String r10 = r10.toString(r2)
            r11.append(r10)
            java.lang.String r10 = ")"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
        L_0x011f:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "权限错误: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.sendMsg(r10)
            return r4
        L_0x0134:
            boolean r10 = r9.f2306E
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.doFile(java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    public Object doString(String str, Object... objArr) {
        try {
            this.f2321k.setTop(0);
            int LloadString = this.f2321k.LloadString(str);
            if (LloadString == 0) {
                this.f2321k.getGlobal("debug");
                this.f2321k.getField(-1, "traceback");
                this.f2321k.remove(-2);
                this.f2321k.insert(-2);
                for (Object pushObjectValue : objArr) {
                    this.f2321k.pushObjectValue(pushObjectValue);
                }
                LloadString = this.f2321k.pcall(r6, 1, -2 - r6);
                if (LloadString == 0) {
                    return this.f2321k.toJavaObject(-1);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2147a(LloadString));
            sb.append(": ");
            sb.append(this.f2321k.toString(-1));
            throw new LuaException(sb.toString());
        } catch (LuaException e) {
            sendMsg(e.getMessage());
            return null;
        }
    }

    public void finish(boolean z) {
        if (!z) {
            super.finish();
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            Intent intent = getIntent();
            if (!(intent == null || (intent.getFlags() & 524288) == 0)) {
                finishAndRemoveTask();
                return;
            }
        }
        super.finish();
    }

    public Object get(String str) {
        Object javaObject;
        synchronized (this.f2321k) {
            this.f2321k.getGlobal(str);
            javaObject = this.f2321k.toJavaObject(-1);
        }
        return javaObject;
    }

    public Object getArg(int i) {
        Object[] objArr = (Object[]) getIntent().getSerializableExtra("arg");
        if (objArr == null || objArr.length >= i) {
            return null;
        }
        return objArr[i];
    }

    public AssetManager getAssets() {
        return (this.f2316f == null || this.f2316f.getAssets() == null) ? super.getAssets() : this.f2316f.getAssets();
    }

    public ArrayList<ClassLoader> getClassLoaders() {
        return this.f2316f.getClassLoaders();
    }

    public Context getContext() {
        return this;
    }

    public View getDecorView() {
        return getWindow().getDecorView();
    }

    public Map getGlobalData() {
        return ((LuaApplication) getApplication()).getGlobalData();
    }

    public int getHeight() {
        return this.f2318h;
    }

    public HashMap<String, String> getLibrarys() {
        return this.f2316f.getLibrarys();
    }

    public String getLocalDir() {
        return this.f2334x;
    }

    public String getLuaCpath() {
        return this.f2315e;
    }

    public String getLuaDir() {
        return this.f2312b;
    }

    public String getLuaDir(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2312b);
        sb.append("/");
        sb.append(str);
        File file = new File(sb.toString());
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public String getLuaExtDir() {
        return this.f2302A;
    }

    public String getLuaExtDir(String str) {
        File file = new File(getLuaExtDir(), str);
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public String getLuaExtPath(String str) {
        return new File(getLuaExtDir(), str).getAbsolutePath();
    }

    public String getLuaExtPath(String str, String str2) {
        return new File(getLuaExtDir(str), str2).getAbsolutePath();
    }

    public String getLuaLpath() {
        return this.f2304C;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0065, code lost:
        if (f2301a.contains(r4.f2312b) == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a2, code lost:
        if (f2301a.contains(r4.f2312b) == false) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getLuaPath() {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            android.net.Uri r0 = r0.getData()
            if (r0 != 0) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            java.lang.String r0 = r0.getPath()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x002e
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r4.getLuaPath(r0)
            r1.<init>(r2)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x002e
            java.lang.String r0 = r4.getLuaPath(r0)
        L_0x002e:
            r4.f2322l = r0
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r4.f2322l
            r2.<init>(r3)
            java.lang.String r2 = r2.getParent()
            r4.f2312b = r2
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "main.lua"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006f
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r4.f2312b
            java.lang.String r3 = "init.lua"
            r1.<init>(r2, r3)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x006f
            java.util.ArrayList<java.lang.String> r1 = f2301a
            java.lang.String r2 = r4.f2312b
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x00af
        L_0x0067:
            java.util.ArrayList<java.lang.String> r1 = f2301a
            java.lang.String r2 = r4.f2312b
            r1.add(r2)
            return r0
        L_0x006f:
            java.lang.String r1 = r4.f2312b
        L_0x0071:
            if (r1 == 0) goto L_0x00af
            java.util.ArrayList<java.lang.String> r2 = f2301a
            boolean r2 = r2.contains(r1)
            if (r2 == 0) goto L_0x007e
            r4.f2312b = r1
            return r0
        L_0x007e:
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "main.lua"
            r2.<init>(r1, r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00a5
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "init.lua"
            r2.<init>(r1, r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00a5
            r4.f2312b = r1
            java.util.ArrayList<java.lang.String> r1 = f2301a
            java.lang.String r2 = r4.f2312b
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x00af
            goto L_0x0067
        L_0x00a5:
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            java.lang.String r1 = r2.getParent()
            goto L_0x0071
        L_0x00af:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.getLuaPath():java.lang.String");
    }

    public String getLuaPath(String str) {
        return new File(getLuaDir(), str).getAbsolutePath();
    }

    public String getLuaPath(String str, String str2) {
        return new File(getLuaDir(str), str2).getAbsolutePath();
    }

    public LuaResources getLuaResources() {
        Resources resources = super.getResources();
        if (!(this.f2316f == null || this.f2316f.getResources() == null)) {
            resources = this.f2316f.getResources();
        }
        this.f2308G = new LuaResources(getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2308G.setSuperResources(resources);
        return this.f2308G;
    }

    public LuaState getLuaState() {
        return this.f2321k;
    }

    public Menu getOptionsMenu() {
        return this.f2329s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r1.equals("file") != false) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPathFromUri(android.net.Uri r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0060
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            java.lang.String r1 = "_data"
            r2 = 0
            r3[r2] = r1
            java.lang.String r1 = r8.getScheme()
            r4 = -1
            int r5 = r1.hashCode()
            r6 = 3143036(0x2ff57c, float:4.404332E-39)
            if (r5 == r6) goto L_0x0028
            r0 = 951530617(0x38b73479, float:8.735894E-5)
            if (r5 == r0) goto L_0x001e
            goto L_0x0031
        L_0x001e:
            java.lang.String r0 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0031
            r0 = 0
            goto L_0x0032
        L_0x0028:
            java.lang.String r2 = "file"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r0 = -1
        L_0x0032:
            switch(r0) {
                case 0: goto L_0x003b;
                case 1: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x0060
        L_0x0036:
            java.lang.String r8 = r8.getPath()
            return r8
        L_0x003b:
            android.content.ContentResolver r1 = r7.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x0060
            java.lang.String r0 = r7.getPackageName()
            int r0 = r8.getColumnIndexOrThrow(r0)
            if (r0 >= 0) goto L_0x0054
            goto L_0x0060
        L_0x0054:
            java.lang.String r0 = r8.getString(r0)
            r8.moveToFirst()
            r8.close()
            r8 = r0
            return r8
        L_0x0060:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.getPathFromUri(android.net.Uri):java.lang.String");
    }

    public String getQuery(String str) {
        Uri data = getIntent().getData();
        if (data == null) {
            return null;
        }
        return data.getQueryParameter(str);
    }

    public Resources getResources() {
        return (this.f2316f == null || this.f2316f.getResources() == null) ? this.f2308G != null ? this.f2308G : super.getResources() : this.f2316f.getResources();
    }

    public Object getSharedData(String str) {
        return LuaApplication.getInstance().getSharedData(str);
    }

    public Object getSharedData(String str, Object obj) {
        return LuaApplication.getInstance().getSharedData(str, obj);
    }

    public Resources getSuperResources() {
        return super.getResources();
    }

    public Uri getUriForFile(File file) {
        return FileProvider.getUriForFile(this, getPackageName(), file);
    }

    public Uri getUriForPath(String str) {
        return FileProvider.getUriForFile(this, getPackageName(), new File(str));
    }

    public int getWidth() {
        return this.f2317g;
    }

    public void initMain() {
        f2301a.add(getLocalDir());
    }

    public void installApk(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        File file = new File(str);
        intent.setFlags(1);
        intent.setDataAndType(getUriForFile(file), m2148a(file));
        intent.addFlags(268435456);
        startActivity(Intent.createChooser(intent, file.getName()));
    }

    public DexClassLoader loadApp(String str) {
        return this.f2316f.loadApp(str);
    }

    public Bitmap loadBitmap(String str) {
        return LuaBitmap.getBitmap(this, str);
    }

    public DexClassLoader loadDex(String str) {
        return this.f2316f.loadDex(str);
    }

    public Object loadLib(String str) {
        int indexOf = str.indexOf(".");
        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2336z);
        sb.append("/lib");
        sb.append(substring);
        sb.append(".so");
        if (!new File(sb.toString()).exists()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f2312b);
            sb2.append("/lib");
            sb2.append(substring);
            sb2.append(".so");
            if (!new File(sb2.toString()).exists()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("can not find lib ");
                sb3.append(str);
                throw new LuaException(sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.f2312b);
            sb4.append("/lib");
            sb4.append(substring);
            sb4.append(".so");
            String sb5 = sb4.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.f2336z);
            sb6.append("/lib");
            sb6.append(substring);
            sb6.append(".so");
            LuaUtil.copyFile(sb5, sb6.toString());
        }
        return this.f2321k.getLuaObject("require").call(str);
    }

    public void loadResources(String str) {
        this.f2316f.loadResources(str);
    }

    public void newActivity(int i, String str) {
        newActivity(i, str, (Object[]) null);
    }

    public void newActivity(int i, String str, int i2, int i3) {
        newActivity(i, str, i2, i3, (Object[]) null);
    }

    public void newActivity(int i, String str, int i2, int i3, boolean z) {
        newActivity(i, str, i2, i3, null, z);
    }

    public void newActivity(int i, String str, int i2, int i3, Object[] objArr) {
        newActivity(i, str, i2, i3, objArr, false);
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object[], code=null, for r10v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void newActivity(int r6, java.lang.String r7, int r8, int r9, java.lang.Object[] r10, boolean r11) {
        /*
            r5 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.androlua.LuaActivity> r1 = com.androlua.LuaActivity.class
            r0.<init>(r5, r1)
            if (r11 == 0) goto L_0x0010
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.androlua.LuaActivityX> r1 = com.androlua.LuaActivityX.class
            r0.<init>(r5, r1)
        L_0x0010:
            java.lang.String r1 = "name"
            r0.putExtra(r1, r7)
            r1 = 0
            char r1 = r7.charAt(r1)
            r2 = 47
            if (r1 == r2) goto L_0x0034
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.f2312b
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L_0x0034:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r2 = r1.isDirectory()
            if (r2 == 0) goto L_0x006d
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r4 = "/main.lua"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x006d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = "/main.lua"
        L_0x0065:
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            goto L_0x008c
        L_0x006d:
            boolean r2 = r1.isDirectory()
            if (r2 != 0) goto L_0x0079
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x008c
        L_0x0079:
            java.lang.String r1 = ".lua"
            boolean r1 = r7.endsWith(r1)
            if (r1 != 0) goto L_0x008c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = ".lua"
            goto L_0x0065
        L_0x008c:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x009d
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException
            r6.<init>(r7)
            throw r6
        L_0x009d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "file://"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r0.setData(r7)
            if (r11 == 0) goto L_0x00c7
            int r7 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r7 < r1) goto L_0x00c7
            r7 = 524288(0x80000, float:7.34684E-40)
            r0.addFlags(r7)
            r7 = 134217728(0x8000000, float:3.85186E-34)
            r0.addFlags(r7)
        L_0x00c7:
            if (r10 == 0) goto L_0x00ce
            java.lang.String r7 = "arg"
            r0.putExtra(r7, r10)
        L_0x00ce:
            if (r11 == 0) goto L_0x00d4
            r5.startActivity(r0)
            goto L_0x00d7
        L_0x00d4:
            r5.startActivityForResult(r0, r6)
        L_0x00d7:
            r5.overridePendingTransition(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.newActivity(int, java.lang.String, int, int, java.lang.Object[], boolean):void");
    }

    public void newActivity(int i, String str, boolean z) {
        newActivity(i, str, (Object[]) null, z);
    }

    public void newActivity(int i, String str, Object[] objArr) {
        newActivity(i, str, objArr, false);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object[], code=null, for r8v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009d A[ADDED_TO_REGION] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void newActivity(int r6, java.lang.String r7, java.lang.Object[] r8, boolean r9) {
        /*
            r5 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.androlua.LuaActivity> r1 = com.androlua.LuaActivity.class
            r0.<init>(r5, r1)
            if (r9 == 0) goto L_0x0010
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.androlua.LuaActivityX> r1 = com.androlua.LuaActivityX.class
            r0.<init>(r5, r1)
        L_0x0010:
            java.lang.String r1 = "name"
            r0.putExtra(r1, r7)
            r1 = 0
            char r1 = r7.charAt(r1)
            r2 = 47
            if (r1 == r2) goto L_0x0034
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.f2312b
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L_0x0034:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r2 = r1.isDirectory()
            if (r2 == 0) goto L_0x006d
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r4 = "/main.lua"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x006d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = "/main.lua"
        L_0x0065:
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            goto L_0x008c
        L_0x006d:
            boolean r2 = r1.isDirectory()
            if (r2 != 0) goto L_0x0079
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x008c
        L_0x0079:
            java.lang.String r1 = ".lua"
            boolean r1 = r7.endsWith(r1)
            if (r1 != 0) goto L_0x008c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = ".lua"
            goto L_0x0065
        L_0x008c:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x009d
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException
            r6.<init>(r7)
            throw r6
        L_0x009d:
            if (r9 == 0) goto L_0x00af
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x00af
            r1 = 524288(0x80000, float:7.34684E-40)
            r0.addFlags(r1)
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0.addFlags(r1)
        L_0x00af:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "file://"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r0.setData(r7)
            if (r8 == 0) goto L_0x00ce
            java.lang.String r7 = "arg"
            r0.putExtra(r7, r8)
        L_0x00ce:
            if (r9 == 0) goto L_0x00d4
            r5.startActivity(r0)
            return
        L_0x00d4:
            r5.startActivityForResult(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.newActivity(int, java.lang.String, java.lang.Object[], boolean):void");
    }

    public void newActivity(String str) {
        newActivity(1, str, (Object[]) null);
    }

    public void newActivity(String str, int i, int i2) {
        newActivity(1, str, i, i2, (Object[]) null);
    }

    public void newActivity(String str, int i, int i2, boolean z) {
        newActivity(1, str, i, i2, null, z);
    }

    public void newActivity(String str, int i, int i2, Object[] objArr) {
        newActivity(1, str, i, i2, objArr);
    }

    public void newActivity(String str, int i, int i2, Object[] objArr, boolean z) {
        newActivity(1, str, i, i2, objArr, z);
    }

    public void newActivity(String str, boolean z) {
        newActivity(1, str, (Object[]) null, z);
    }

    public void newActivity(String str, Object[] objArr) {
        newActivity(1, str, objArr);
    }

    public void newActivity(String str, Object[] objArr, boolean z) {
        newActivity(1, str, objArr, z);
    }

    public LuaAsyncTask newTask(LuaObject luaObject) {
        return newTask(luaObject, null, null);
    }

    public LuaAsyncTask newTask(LuaObject luaObject, LuaObject luaObject2) {
        return newTask(luaObject, null, luaObject2);
    }

    public LuaAsyncTask newTask(LuaObject luaObject, LuaObject luaObject2, LuaObject luaObject3) {
        return new LuaAsyncTask(this, luaObject, luaObject2, luaObject3);
    }

    public LuaThread newThread(LuaObject luaObject) {
        return newThread(luaObject, null);
    }

    public LuaThread newThread(LuaObject luaObject, Object[] objArr) {
        return new LuaThread((LuaContext) this, luaObject, true, objArr);
    }

    public LuaTimer newTimer(LuaObject luaObject) {
        return newTimer(luaObject, null);
    }

    public LuaTimer newTimer(LuaObject luaObject, Object[] objArr) {
        return new LuaTimer((LuaContext) this, luaObject, objArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("name");
            if (stringExtra != null) {
                Object[] objArr = (Object[]) intent.getSerializableExtra("data");
                if (objArr == null) {
                    runFunc("onResult", stringExtra);
                } else {
                    Object[] objArr2 = new Object[(objArr.length + 1)];
                    objArr2[0] = stringExtra;
                    int i3 = 0;
                    while (i3 < objArr.length) {
                        int i4 = i3 + 1;
                        objArr2[i4] = objArr[i3];
                        i3 = i4;
                    }
                    Object runFunc = runFunc("onResult", objArr2);
                    if (runFunc != null && runFunc.getClass() == Boolean.class && ((Boolean) runFunc).booleanValue()) {
                        return;
                    }
                }
            }
        }
        runFunc("onActivityResult", Integer.valueOf(i), Integer.valueOf(i2), intent);
        super.onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f2317g = displayMetrics.widthPixels;
        this.f2318h = displayMetrics.heightPixels;
        runFunc("onConfigurationChanged", configuration);
    }

    public void onContentChanged() {
        super.onContentChanged();
        this.f2327q = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        runFunc("onContextItemSelected", menuItem);
        return super.onContextItemSelected(menuItem);
    }

    public void onCreate(Bundle bundle) {
        setTheme(16974064);
        StrictMode.setThreadPolicy(new ThreadPolicy.Builder().permitAll().build());
        super.onCreate(null);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f2317g = displayMetrics.widthPixels;
        this.f2318h = displayMetrics.heightPixels;
        this.f2326p = new LinearLayout(this);
        ScrollView scrollView = new ScrollView(this);
        int i = 1;
        scrollView.setFillViewport(true);
        this.f2314d = new TextView(this);
        this.f2314d.setTextColor(-16777216);
        scrollView.addView(this.f2314d, new LayoutParams(-1, -2));
        this.f2314d.setText(BuildConfig.FLAVOR);
        this.f2314d.setTextIsSelectable(true);
        this.f2319i = new ListView(this);
        this.f2319i.setFastScrollEnabled(true);
        this.f2320j = new ArrayListAdapter<String>(this, 17367043) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) super.getView(i, view, viewGroup);
                if (view == null) {
                    textView.setTextIsSelectable(true);
                }
                return textView;
            }
        };
        this.f2319i.setAdapter(this.f2320j);
        this.f2326p.addView(this.f2319i, new LayoutParams(-1, -2));
        LuaApplication luaApplication = (LuaApplication) getApplication();
        if (luaApplication.getClass() != LuaApplication.class) {
            do {
            } while (luaApplication.getClass() != LuaApplication.class);
        }
        this.f2334x = luaApplication.getLocalDir();
        this.f2335y = luaApplication.getOdexDir();
        this.f2336z = luaApplication.getLibDir();
        this.f2305D = luaApplication.getMdDir();
        this.f2315e = luaApplication.getLuaCpath();
        this.f2312b = this.f2334x;
        this.f2304C = luaApplication.getLuaLpath();
        this.f2302A = luaApplication.getLuaExtDir();
        this.f2313c = new MainHandler();
        try {
            this.f2314d.setText(BuildConfig.FLAVOR);
            this.f2320j.clear();
            Object[] objArr = (Object[]) getIntent().getSerializableExtra("arg");
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.f2322l = getLuaPath();
            this.f2310I = new File(this.f2322l).getName();
            int lastIndexOf = this.f2310I.lastIndexOf(".");
            if (lastIndexOf > 0) {
                this.f2310I = this.f2310I.substring(0, lastIndexOf);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f2312b);
            sb.append("/?.lua;");
            sb.append(this.f2312b);
            sb.append("/lua/?.lua;");
            sb.append(this.f2312b);
            sb.append("/?/init.lua;");
            sb.append(this.f2304C);
            this.f2304C = sb.toString();
            m2158c();
            this.f2316f = new LuaDexLoader(this);
            this.f2316f.loadLibs();
            f2300K.put(this.f2310I, this);
            doFile(this.f2322l, objArr);
            this.f2324n = Boolean.valueOf(true);
            if (!this.f2310I.equals("main")) {
                runFunc("main", objArr);
            }
            runFunc(this.f2310I, objArr);
            runFunc("onCreate", bundle);
            if (!this.f2327q) {
                TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(new int[]{16842801, 16842806, 16843599});
                int color = obtainStyledAttributes.getColor(0, 16711935);
                int color2 = obtainStyledAttributes.getColor(1, 16711935);
                obtainStyledAttributes.recycle();
                this.f2314d.setTextColor(color2);
                this.f2326p.setBackgroundColor(color);
                setContentView(this.f2326p);
            }
            this.f2311L = this.f2321k.getLuaObject("onKeyShortcut");
            if (this.f2311L.isNil()) {
                this.f2311L = null;
            }
            this.f2330t = this.f2321k.getLuaObject("onKeyDown");
            if (this.f2330t.isNil()) {
                this.f2330t = null;
            }
            this.f2331u = this.f2321k.getLuaObject("onKeyUp");
            if (this.f2331u.isNil()) {
                this.f2331u = null;
            }
            this.f2332v = this.f2321k.getLuaObject("onKeyLongPress");
            if (this.f2332v.isNil()) {
                this.f2332v = null;
            }
            this.f2333w = this.f2321k.getLuaObject("onTouchEvent");
            if (this.f2333w.isNil()) {
                this.f2333w = null;
            }
            LuaObject luaObject = this.f2321k.getLuaObject("onAccessibilityEvent");
            if (luaObject.isFunction()) {
                LuaAccessibilityService.onAccessibilityEvent = luaObject.getFunction();
            }
            m2149a();
            m2156b();
            try {
                throw new RuntimeException(BuildConfig.FLAVOR);
            } catch (Exception e) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                C0029a.m807a((Throwable) e, new PrintStream(byteArrayOutputStream));
                String[] split = byteArrayOutputStream.toString().split("\n");
                while (i < split.length) {
                    String str = split[i];
                    if (str.contains(BuildConfig.APPLICATION_ID) || str.contains("com.nirenr.talkman") || str.contains("android.app") || str.contains("android.os") || str.contains("java.lang") || str.contains("com.android")) {
                        i++;
                    } else {
                        runFunc("onHook", new Object[0]);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            sendMsg(e2.getMessage());
            setContentView(this.f2326p);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        runFunc("onCreateContextMenu", contextMenu, view, contextMenuInfo);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.f2329s = menu;
        runFunc("onCreateOptionsMenu", menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.f2303B != null) {
            unregisterReceiver(this.f2303B);
        }
        Iterator it = this.f2309H.iterator();
        while (it.hasNext()) {
            ((LuaGcable) it.next()).mo2151gc();
        }
        f2300K.remove(this.f2310I);
        runFunc("onDestroy", new Object[0]);
        super.onDestroy();
        System.gc();
        this.f2321k.mo3510gc(2, 1);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f2330t != null) {
            try {
                Object call = this.f2330t.call(Integer.valueOf(i), keyEvent);
                if (call != null && call.getClass() == Boolean.class && ((Boolean) call).booleanValue()) {
                    return true;
                }
            } catch (LuaException e) {
                sendError("onKeyDown", e);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (this.f2332v != null) {
            try {
                Object call = this.f2332v.call(Integer.valueOf(i), keyEvent);
                if (call != null && call.getClass() == Boolean.class && ((Boolean) call).booleanValue()) {
                    return true;
                }
            } catch (LuaException e) {
                sendError("onKeyLongPress", e);
            }
        }
        return super.onKeyLongPress(i, keyEvent);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (this.f2311L != null) {
            try {
                Object call = this.f2311L.call(Integer.valueOf(i), keyEvent);
                if (call != null && call.getClass() == Boolean.class && ((Boolean) call).booleanValue()) {
                    return true;
                }
            } catch (LuaException e) {
                sendError("onKeyShortcut", e);
            }
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f2331u != null) {
            try {
                Object call = this.f2331u.call(Integer.valueOf(i), keyEvent);
                if (call != null && call.getClass() == Boolean.class && ((Boolean) call).booleanValue()) {
                    return true;
                }
            } catch (LuaException e) {
                sendError("onKeyUp", e);
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (!menuItem.hasSubMenu()) {
            runFunc("onMenuItemSelected", Integer.valueOf(i), menuItem);
        }
        return super.onMenuItemSelected(i, menuItem);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Object obj;
        if (!menuItem.hasSubMenu()) {
            obj = runFunc("onOptionsItemSelected", menuItem);
        } else {
            obj = null;
        }
        if (obj == null || obj.getClass() != Boolean.class || !((Boolean) obj).booleanValue()) {
            return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        runFunc("onPause", new Object[0]);
    }

    public void onReceive(Context context, Intent intent) {
        runFunc("onReceive", context, intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        runFunc("onResume", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        runFunc("onStart", new Object[0]);
        StatService.onPageStart(this, this.f2310I);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        runFunc("onStop", new Object[0]);
        StatService.onPageEnd(this, this.f2310I);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2333w != null) {
            try {
                Object call = this.f2333w.call(motionEvent);
                if (call != null && call.getClass() == Boolean.class && ((Boolean) call).booleanValue()) {
                    return true;
                }
            } catch (LuaException e) {
                sendError("onTouchEvent", e);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void push(int i, String str) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", str);
        message.setData(bundle);
        message.what = i;
        this.f2313c.sendMessage(message);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object[], code=null, for r6v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void push(int r4, java.lang.String r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            android.os.Message r0 = new android.os.Message
            r0.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "data"
            r1.putString(r2, r5)
            java.lang.String r5 = "args"
            r1.putSerializable(r5, r6)
            r0.setData(r1)
            r0.what = r4
            android.os.Handler r4 = r3.f2313c
            r4.sendMessage(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.push(int, java.lang.String, java.lang.Object[]):void");
    }

    public byte[] readAsset(String str) {
        InputStream open = getAssets().open(str);
        byte[] a = m2154a(open);
        open.close();
        return a;
    }

    public void regGc(LuaGcable luaGcable) {
        this.f2309H.add(luaGcable);
    }

    public Intent registerReceiver(IntentFilter intentFilter) {
        if (this.f2303B != null) {
            unregisterReceiver(this.f2303B);
        }
        this.f2303B = new LuaBroadcastReceiver(this);
        return super.registerReceiver(this.f2303B, intentFilter);
    }

    public Intent registerReceiver(OnReceiveListener onReceiveListener, IntentFilter intentFilter) {
        return super.registerReceiver(new LuaBroadcastReceiver(onReceiveListener), intentFilter);
    }

    public Intent registerReceiver(LuaBroadcastReceiver luaBroadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(luaBroadcastReceiver, intentFilter);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object[], code=null, for r5v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void result(java.lang.Object[] r5) {
        /*
            r4 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "name"
            android.content.Intent r2 = r4.getIntent()
            java.lang.String r3 = "name"
            java.lang.String r2 = r2.getStringExtra(r3)
            r0.putExtra(r1, r2)
            java.lang.String r1 = "data"
            r0.putExtra(r1, r5)
            r5 = 0
            r4.setResult(r5, r0)
            r4.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.result(java.lang.Object[]):void");
    }

    public Object runFunc(String str, Object... objArr) {
        if (this.f2321k != null) {
            synchronized (this.f2321k) {
                try {
                    this.f2321k.setTop(0);
                    this.f2321k.pushGlobalTable();
                    this.f2321k.pushString(str);
                    this.f2321k.rawGet(-2);
                    if (this.f2321k.isFunction(-1)) {
                        this.f2321k.getGlobal("debug");
                        this.f2321k.getField(-1, "traceback");
                        this.f2321k.remove(-2);
                        this.f2321k.insert(-2);
                        for (Object pushObjectValue : objArr) {
                            this.f2321k.pushObjectValue(pushObjectValue);
                        }
                        int pcall = this.f2321k.pcall(r1, 1, -2 - r1);
                        if (pcall == 0) {
                            Object javaObject = this.f2321k.toJavaObject(-1);
                            return javaObject;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(m2147a(pcall));
                        sb.append(": ");
                        sb.append(this.f2321k.toString(-1));
                        throw new LuaException(sb.toString());
                    }
                } catch (LuaException e) {
                    sendError(str, e);
                    return null;
                }
            }
        }
        return null;
    }

    public void sendError(String str, Exception exc) {
        Object runFunc = runFunc("onError", str, exc);
        if (runFunc == null || runFunc.getClass() != Boolean.class || !((Boolean) runFunc).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": ");
            sb.append(exc.getMessage());
            sendMsg(sb.toString());
        }
    }

    public void sendMsg(String str) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", str);
        message.setData(bundle);
        message.what = 0;
        this.f2313c.sendMessage(message);
        Log.i("lua", str);
    }

    public void set(String str, Object obj) {
        push(1, str, new Object[]{obj});
    }

    public void setContentView(LuaObject luaObject) {
        setContentView(luaObject, (LuaObject) null);
    }

    public void setContentView(LuaObject luaObject, LuaObject luaObject2) {
        Object[] objArr;
        LuaObject luaObject3 = this.f2321k.getLuaObject("loadlayout");
        if (luaObject.isString()) {
            objArr = new Object[]{luaObject.getString(), luaObject2};
        } else if (luaObject.isTable()) {
            objArr = new Object[]{luaObject, luaObject2};
        } else {
            throw new LuaException("layout may be table or string.");
        }
        super.setContentView((View) luaObject3.call(objArr));
    }

    public void setContentView(String str) {
        setContentView(str, (LuaObject) null);
    }

    public void setContentView(String str, LuaObject luaObject) {
        super.setContentView((View) this.f2321k.getLuaObject("loadlayout").call(str, luaObject));
    }

    public void setDebug(boolean z) {
        this.f2307F = z;
    }

    public void setFragment(Fragment fragment) {
        this.f2327q = true;
        getFragmentManager().beginTransaction().replace(16908290, fragment).commit();
    }

    public void setLuaDir(String str) {
        this.f2312b = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLuaExtDir(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0020
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r0 = r0.getAbsolutePath()
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r8)
            java.lang.String r8 = r1.getAbsolutePath()
        L_0x001d:
            r7.f2302A = r8
            goto L_0x0058
        L_0x0020:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/storage"
            r0.<init>(r1)
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x002e:
            if (r3 >= r1) goto L_0x004b
            r4 = r0[r3]
            java.lang.String[] r5 = r4.list()
            if (r5 != 0) goto L_0x0039
            goto L_0x0048
        L_0x0039:
            int r5 = r5.length
            r6 = 5
            if (r5 <= r6) goto L_0x0048
            java.io.File r5 = new java.io.File
            r5.<init>(r4, r8)
            java.lang.String r4 = r5.getAbsolutePath()
            r7.f2302A = r4
        L_0x0048:
            int r3 = r3 + 1
            goto L_0x002e
        L_0x004b:
            java.lang.String r0 = r7.f2302A
            if (r0 != 0) goto L_0x0058
            java.io.File r8 = r7.getDir(r8, r2)
            java.lang.String r8 = r8.getAbsolutePath()
            goto L_0x001d
        L_0x0058:
            java.io.File r8 = new java.io.File
            java.lang.String r0 = r7.f2302A
            r8.<init>(r0)
            boolean r0 = r8.exists()
            if (r0 != 0) goto L_0x0068
            r8.mkdirs()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.setLuaExtDir(java.lang.String):void");
    }

    public boolean setSharedData(String str, Object obj) {
        return LuaApplication.getInstance().setSharedData(str, obj);
    }

    public void setTitle(CharSequence charSequence) {
        TaskDescription taskDescription;
        super.setTitle(charSequence);
        if (VERSION.SDK_INT >= 21) {
            try {
                taskDescription = new TaskDescription(charSequence.toString(), loadBitmap(getLuaPath("icon.png")));
            } catch (IOException e) {
                C0029a.m806a(e);
                taskDescription = new TaskDescription(charSequence.toString());
            }
            setTaskDescription(taskDescription);
        }
    }

    public void shareFile(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        File file = new File(str);
        intent.setType(m2148a(file));
        intent.setFlags(1);
        intent.putExtra("android.intent.extra.STREAM", getUriForFile(file));
        startActivity(Intent.createChooser(intent, file.getName()));
    }

    @SuppressLint({"ShowToast"})
    public void showToast(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f2325o == null || currentTimeMillis - this.f2328r > 1000) {
            this.f2323m.setLength(0);
            this.f2325o = Toast.makeText(this, str, 1);
            this.f2323m.append(str);
            this.f2325o.show();
        } else {
            this.f2323m.append("\n");
            this.f2323m.append(str);
            this.f2325o.setText(this.f2323m.toString());
            this.f2325o.setDuration(1);
        }
        this.f2328r = currentTimeMillis;
    }

    public ComponentName startService() {
        return startService(null, null);
    }

    public ComponentName startService(String str) {
        return startService(str, null);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object[], code=null, for r5v0, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.ComponentName startService(java.lang.String r4, java.lang.Object[] r5) {
        /*
            r3 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.androlua.LuaService> r1 = com.androlua.LuaService.class
            r0.<init>(r3, r1)
            java.lang.String r1 = "luaDir"
            java.lang.String r2 = r3.f2312b
            r0.putExtra(r1, r2)
            java.lang.String r1 = "luaPath"
            java.lang.String r2 = r3.f2322l
            r0.putExtra(r1, r2)
            if (r4 == 0) goto L_0x0053
            r1 = 0
            char r1 = r4.charAt(r1)
            r2 = 47
            if (r1 == r2) goto L_0x0048
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "file://"
            r1.append(r2)
            java.lang.String r2 = r3.f2312b
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = ".lua"
        L_0x0039:
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            android.net.Uri r4 = android.net.Uri.parse(r4)
            r0.setData(r4)
            goto L_0x0053
        L_0x0048:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "file://"
            r1.append(r2)
            goto L_0x0039
        L_0x0053:
            if (r5 == 0) goto L_0x005a
            java.lang.String r4 = "arg"
            r0.putExtra(r4, r5)
        L_0x005a:
            android.content.ComponentName r4 = super.startService(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaActivity.startService(java.lang.String, java.lang.Object[]):android.content.ComponentName");
    }

    public ComponentName startService(Object[] objArr) {
        return startService(null, objArr);
    }

    public boolean stopService() {
        return stopService(new Intent(this, LuaService.class));
    }

    public LuaAsyncTask task(long j, LuaObject luaObject) {
        return task(j, (Object[]) null, (LuaObject) null);
    }

    public LuaAsyncTask task(long j, Object[] objArr, LuaObject luaObject) {
        LuaAsyncTask luaAsyncTask = new LuaAsyncTask((LuaContext) this, j, luaObject);
        luaAsyncTask.execute((Params[]) objArr);
        return luaAsyncTask;
    }

    public LuaAsyncTask task(LuaObject luaObject) {
        return task(luaObject, null, null, null);
    }

    public LuaAsyncTask task(LuaObject luaObject, LuaObject luaObject2, LuaObject luaObject3) {
        return task(luaObject, null, luaObject2, luaObject3);
    }

    public LuaAsyncTask task(LuaObject luaObject, Object[] objArr) {
        return task(luaObject, objArr, null, null);
    }

    public LuaAsyncTask task(LuaObject luaObject, Object[] objArr, LuaObject luaObject2) {
        return task(luaObject, null, null, luaObject2);
    }

    public LuaAsyncTask task(LuaObject luaObject, Object[] objArr, LuaObject luaObject2, LuaObject luaObject3) {
        LuaAsyncTask luaAsyncTask = new LuaAsyncTask(this, luaObject, luaObject2, luaObject3);
        luaAsyncTask.execute((Params[]) objArr);
        return luaAsyncTask;
    }

    public long test(String str, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i2 = 0; i2 < i; i2++) {
            this.f2321k.LdoString(str);
        }
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public LuaThread thread(LuaObject luaObject) {
        LuaThread newThread = newThread(luaObject, null);
        newThread.start();
        return newThread;
    }

    public LuaThread thread(LuaObject luaObject, Object[] objArr) {
        LuaThread luaThread = new LuaThread((LuaContext) this, luaObject, true, objArr);
        luaThread.start();
        return luaThread;
    }

    public Ticker ticker(final LuaObject luaObject, long j) {
        Ticker ticker = new Ticker();
        ticker.setOnTickListener(new OnTickListener() {
            public void onTick() {
                try {
                    luaObject.call(new Object[0]);
                } catch (LuaException e) {
                    C0029a.m806a(e);
                    LuaActivity.this.sendError("onTick", e);
                }
            }
        });
        ticker.start();
        ticker.setPeriod(j);
        return ticker;
    }

    public LuaTimer timer(LuaObject luaObject, long j) {
        return timer(luaObject, 0, j, null);
    }

    public LuaTimer timer(LuaObject luaObject, long j, long j2) {
        return timer(luaObject, j, j2, null);
    }

    public LuaTimer timer(LuaObject luaObject, long j, long j2, Object[] objArr) {
        LuaTimer luaTimer = new LuaTimer((LuaContext) this, luaObject, objArr);
        luaTimer.start(j, j2);
        return luaTimer;
    }

    public LuaTimer timer(LuaObject luaObject, long j, Object[] objArr) {
        return timer(luaObject, 0, j, objArr);
    }

    public void unZipAssets(String str, String str2) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(getAssets().open(str));
            byte[] bArr = new byte[4096];
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                if (nextEntry.isDirectory()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(File.separator);
                    sb.append(nextEntry.getName());
                    new File(sb.toString()).mkdir();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(File.separator);
                    sb2.append(nextEntry.getName());
                    File file2 = new File(sb2.toString());
                    file2.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                }
            }
            zipInputStream.close();
        } catch (IOException unused) {
        }
    }
}
