package com.androlua;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.androlua.LuaBroadcastReceiver.OnReceiveListener;
import com.androlua.Ticker.OnTickListener;
import com.luajava.JavaFunction;
import com.luajava.LuaException;
import com.luajava.LuaObject;
import com.luajava.LuaState;
import com.luajava.LuaStateFactory;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LuaService extends Service implements OnReceiveListener, LuaContext {

    /* renamed from: b */
    private static LuaService f2600b;

    /* renamed from: a */
    LuaBinder f2601a = new LuaBinder();

    /* renamed from: c */
    private LuaDexLoader f2602c;

    /* renamed from: d */
    private ArrayList<LuaGcable> f2603d = new ArrayList<>();

    /* renamed from: e */
    private String f2604e;

    /* renamed from: f */
    private MainHandler f2605f;

    /* renamed from: g */
    private String f2606g;

    /* renamed from: h */
    private LuaState f2607h;

    /* renamed from: i */
    private String f2608i;

    /* renamed from: j */
    private String f2609j;

    /* renamed from: k */
    private String f2610k;

    /* renamed from: l */
    private String f2611l;
    public String luaCpath;
    public String luaDir;

    /* renamed from: m */
    private String f2612m;

    /* renamed from: n */
    private BroadcastReceiver f2613n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public StringBuilder f2614o = new StringBuilder();

    /* renamed from: p */
    private Toast f2615p;

    /* renamed from: q */
    private StringBuilder f2616q = new StringBuilder();

    /* renamed from: r */
    private long f2617r;

    /* renamed from: s */
    private LuaResources f2618s;

    public class LuaBinder extends Binder {
        public LuaBinder() {
        }

        public LuaService getService() {
            return LuaService.this;
        }
    }

    public class MainHandler extends Handler {
        public MainHandler() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    LuaService.this.showToast(message.getData().getString("data"));
                    return;
                case 1:
                    Bundle data = message.getData();
                    LuaService.this.m2274a(data.getString("data"), ((Object[]) data.getSerializable("args"))[0]);
                    return;
                case 2:
                    LuaService.this.runFunc(message.getData().getString("data"), new Object[0]);
                    return;
                case 3:
                    LuaService.this.runFunc(message.getData().getString("data"), (Object[]) message.getData().getSerializable("args"));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private String m2270a(int i) {
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
    private void m2272a() {
        this.f2607h = LuaStateFactory.newLuaState();
        this.f2607h.openLibs();
        this.f2607h.pushJavaObject(this);
        this.f2607h.setGlobal("service");
        this.f2607h.getGlobal("service");
        this.f2607h.setGlobal("this");
        this.f2607h.pushContext(this);
        this.f2607h.getGlobal("luajava");
        this.f2607h.pushString(this.f2612m);
        this.f2607h.setField(-2, "luaextdir");
        this.f2607h.pushString(this.luaDir);
        this.f2607h.setField(-2, "luadir");
        this.f2607h.pushString(this.f2608i);
        this.f2607h.setField(-2, "luapath");
        this.f2607h.pop(1);
        new LuaAssetLoader(this, this.f2607h);
        this.f2607h.getGlobal("package");
        this.f2607h.pushString(this.f2604e);
        this.f2607h.setField(-2, "path");
        this.f2607h.pushString(this.luaCpath);
        this.f2607h.setField(-2, "cpath");
        this.f2607h.pop(1);
        new JavaFunction(this.f2607h) {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
                if (r0.equals("boolean") == false) goto L_0x004b;
             */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int execute() {
                /*
                    r8 = this;
                    com.luajava.LuaState r0 = r8.f3375b
                    int r0 = r0.getTop()
                    r1 = 2
                    r2 = 0
                    if (r0 >= r1) goto L_0x0012
                    com.androlua.LuaService r0 = com.androlua.LuaService.this
                    java.lang.String r1 = ""
                    r0.sendMsg(r1)
                    return r2
                L_0x0012:
                    com.luajava.LuaState r0 = r8.f3375b
                    int r0 = r0.getTop()
                    r3 = 1
                    if (r1 > r0) goto L_0x0098
                    com.luajava.LuaState r0 = r8.f3375b
                    int r0 = r0.type(r1)
                    r4 = 0
                    com.luajava.LuaState r5 = r8.f3375b
                    java.lang.String r0 = r5.typeName(r0)
                    r5 = -1
                    int r6 = r0.hashCode()
                    r7 = -266011147(0xfffffffff024fdf5, float:-2.0425023E29)
                    if (r6 == r7) goto L_0x0041
                    r7 = 64711720(0x3db6c28, float:1.2896495E-36)
                    if (r6 == r7) goto L_0x0038
                    goto L_0x004b
                L_0x0038:
                    java.lang.String r6 = "boolean"
                    boolean r6 = r0.equals(r6)
                    if (r6 == 0) goto L_0x004b
                    goto L_0x004c
                L_0x0041:
                    java.lang.String r3 = "userdata"
                    boolean r3 = r0.equals(r3)
                    if (r3 == 0) goto L_0x004b
                    r3 = 0
                    goto L_0x004c
                L_0x004b:
                    r3 = -1
                L_0x004c:
                    switch(r3) {
                        case 0: goto L_0x0065;
                        case 1: goto L_0x0056;
                        default: goto L_0x004f;
                    }
                L_0x004f:
                    com.luajava.LuaState r3 = r8.f3375b
                    java.lang.String r4 = r3.toString(r1)
                    goto L_0x0071
                L_0x0056:
                    com.luajava.LuaState r3 = r8.f3375b
                    boolean r3 = r3.toBoolean(r1)
                    if (r3 == 0) goto L_0x0062
                    java.lang.String r3 = "true"
                L_0x0060:
                    r4 = r3
                    goto L_0x0071
                L_0x0062:
                    java.lang.String r3 = "false"
                    goto L_0x0060
                L_0x0065:
                    com.luajava.LuaState r3 = r8.f3375b
                    java.lang.Object r3 = r3.toJavaObject(r1)
                    if (r3 == 0) goto L_0x0071
                    java.lang.String r4 = r3.toString()
                L_0x0071:
                    if (r4 != 0) goto L_0x0074
                    goto L_0x0075
                L_0x0074:
                    r0 = r4
                L_0x0075:
                    com.androlua.LuaService r3 = com.androlua.LuaService.this
                    java.lang.StringBuilder r3 = r3.f2614o
                    java.lang.String r4 = "\t"
                    r3.append(r4)
                    com.androlua.LuaService r3 = com.androlua.LuaService.this
                    java.lang.StringBuilder r3 = r3.f2614o
                    r3.append(r0)
                    com.androlua.LuaService r0 = com.androlua.LuaService.this
                    java.lang.StringBuilder r0 = r0.f2614o
                    java.lang.String r3 = "\t"
                    r0.append(r3)
                    int r1 = r1 + 1
                    goto L_0x0012
                L_0x0098:
                    com.androlua.LuaService r0 = com.androlua.LuaService.this
                    com.androlua.LuaService r1 = com.androlua.LuaService.this
                    java.lang.StringBuilder r1 = r1.f2614o
                    java.lang.String r1 = r1.toString()
                    com.androlua.LuaService r4 = com.androlua.LuaService.this
                    java.lang.StringBuilder r4 = r4.f2614o
                    int r4 = r4.length()
                    int r4 = r4 - r3
                    java.lang.String r1 = r1.substring(r3, r4)
                    r0.sendMsg(r1)
                    com.androlua.LuaService r0 = com.androlua.LuaService.this
                    java.lang.StringBuilder r0 = r0.f2614o
                    r0.setLength(r2)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaService.C03432.execute():int");
            }
        }.register("print");
        new JavaFunction(this.f2607h) {
            public int execute() {
                ((LuaThread) this.f3375b.toJavaObject(2)).set(this.f3375b.toString(3), this.f3375b.toJavaObject(4));
                return 0;
            }
        }.register("set");
        new JavaFunction(this.f2607h) {
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

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2274a(String str, Object obj) {
        try {
            this.f2607h.pushObjectValue(obj);
            this.f2607h.setGlobal(str);
        } catch (LuaException e) {
            sendMsg(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m2275a(String str, String str2) {
        try {
            if (new File(str).exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                byte[] bArr = new byte[4096];
                int i = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        i += read;
                        System.out.println(i);
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("复制文件操作出错");
            C0029a.m806a(e);
        }
    }

    /* renamed from: a */
    private static byte[] m2276a(InputStream inputStream) {
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

    public static LuaService getService() {
        return f2600b;
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

    public Object doAsset(String str, Object... objArr) {
        try {
            byte[] readAsset = readAsset(str);
            this.f2607h.setTop(0);
            int LloadBuffer = this.f2607h.LloadBuffer(readAsset, str);
            if (LloadBuffer == 0) {
                this.f2607h.getGlobal("debug");
                this.f2607h.getField(-1, "traceback");
                this.f2607h.remove(-2);
                this.f2607h.insert(-2);
                int length = objArr != null ? objArr.length : 0;
                for (int i = 0; i < length; i++) {
                    this.f2607h.pushObjectValue(objArr[i]);
                }
                LloadBuffer = this.f2607h.pcall(length, 0, -2 - length);
                if (LloadBuffer == 0) {
                    return this.f2607h.toJavaObject(-1);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2270a(LloadBuffer));
            sb.append(": ");
            sb.append(this.f2607h.toString(-1));
            throw new LuaException(sb.toString());
        } catch (Exception e) {
            sendMsg(e.getMessage());
            return null;
        }
    }

    public Object doFile(String str) {
        return doFile(str, new Object[0]);
    }

    public Object doFile(String str, Object[] objArr) {
        try {
            if (str.charAt(0) != '/') {
                StringBuilder sb = new StringBuilder();
                sb.append(this.luaDir);
                sb.append("/");
                sb.append(str);
                str = sb.toString();
            }
            this.f2607h.setTop(0);
            int LloadFile = this.f2607h.LloadFile(str);
            if (LloadFile == 0) {
                this.f2607h.getGlobal("debug");
                this.f2607h.getField(-1, "traceback");
                this.f2607h.remove(-2);
                this.f2607h.insert(-2);
                int length = objArr != null ? objArr.length : 0;
                for (int i = 0; i < length; i++) {
                    this.f2607h.pushObjectValue(objArr[i]);
                }
                LloadFile = this.f2607h.pcall(length, 1, -2 - length);
                if (LloadFile == 0) {
                    return this.f2607h.toJavaObject(-1);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2270a(LloadFile));
            sb2.append(": ");
            sb2.append(this.f2607h.toString(-1));
            throw new LuaException(sb2.toString());
        } catch (LuaException e) {
            sendMsg(e.getMessage());
            return null;
        }
    }

    public Object doString(String str, Object... objArr) {
        try {
            this.f2607h.setTop(0);
            int LloadString = this.f2607h.LloadString(str);
            if (LloadString == 0) {
                this.f2607h.getGlobal("debug");
                this.f2607h.getField(-1, "traceback");
                this.f2607h.remove(-2);
                this.f2607h.insert(-2);
                int length = objArr != null ? objArr.length : 0;
                for (int i = 0; i < length; i++) {
                    this.f2607h.pushObjectValue(objArr[i]);
                }
                LloadString = this.f2607h.pcall(length, 1, -2 - length);
                if (LloadString == 0) {
                    return this.f2607h.toJavaObject(-1);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2270a(LloadString));
            sb.append(": ");
            sb.append(this.f2607h.toString(-1));
            throw new LuaException(sb.toString());
        } catch (LuaException e) {
            sendMsg(e.getMessage());
            return null;
        }
    }

    public Object get(String str) {
        this.f2607h.getGlobal(str);
        return this.f2607h.toJavaObject(-1);
    }

    public AssetManager getAssets() {
        return (this.f2602c == null || this.f2602c.getAssets() == null) ? super.getAssets() : this.f2602c.getAssets();
    }

    public LuaBinder getBinder() {
        return this.f2601a;
    }

    public ArrayList<ClassLoader> getClassLoaders() {
        return this.f2602c.getClassLoaders();
    }

    public Context getContext() {
        return this;
    }

    public Map getGlobalData() {
        return LuaApplication.getInstance().getGlobalData();
    }

    public int getHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public HashMap<String, String> getLibrarys() {
        return this.f2602c.getLibrarys();
    }

    public String getLuaCpath() {
        return this.luaCpath;
    }

    public String getLuaDir() {
        return this.luaDir;
    }

    public String getLuaDir(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.luaDir);
        sb.append("/");
        sb.append(str);
        File file = new File(sb.toString());
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public String getLuaExtDir() {
        return this.f2612m;
    }

    public String getLuaExtDir(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2612m);
        sb.append("/");
        sb.append(str);
        File file = new File(sb.toString());
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
        return this.f2604e;
    }

    public String getLuaPath() {
        return this.f2608i;
    }

    public String getLuaPath(String str) {
        return new File(getLuaDir(), str).getAbsolutePath();
    }

    public String getLuaPath(String str, String str2) {
        return new File(getLuaDir(str), str2).getAbsolutePath();
    }

    public LuaResources getLuaResources() {
        Resources resources = super.getResources();
        if (!(this.f2602c == null || this.f2602c.getResources() == null)) {
            resources = this.f2602c.getResources();
        }
        this.f2618s = new LuaResources(getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2618s.setSuperResources(resources);
        return this.f2618s;
    }

    public LuaState getLuaState() {
        return this.f2607h;
    }

    public Resources getResources() {
        return (this.f2602c == null || this.f2602c.getResources() == null) ? this.f2618s != null ? this.f2618s : super.getResources() : this.f2602c.getResources();
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

    public int getWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public DexClassLoader loadDex(String str) {
        return this.f2602c.loadDex(str);
    }

    public Object loadLib(String str) {
        int indexOf = str.indexOf(".");
        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2611l);
        sb.append("/lib");
        sb.append(substring);
        sb.append(".so");
        if (!new File(sb.toString()).exists()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.luaDir);
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
            sb4.append(this.luaDir);
            sb4.append("/lib");
            sb4.append(substring);
            sb4.append(".so");
            String sb5 = sb4.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.f2611l);
            sb6.append("/lib");
            sb6.append(substring);
            sb6.append(".so");
            m2275a(sb5, sb6.toString());
        }
        return this.f2607h.getLuaObject("require").call(str);
    }

    public void loadResources(String str) {
        this.f2602c.loadResources(str);
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

    public IBinder onBind(Intent intent) {
        startForeground(1, new Notification());
        return new LuaBinder();
    }

    public void onCreate() {
        super.onCreate();
        f2600b = this;
        LuaApplication luaApplication = (LuaApplication) getApplication();
        this.f2609j = luaApplication.getLocalDir();
        this.f2610k = luaApplication.getOdexDir();
        this.f2611l = luaApplication.getLibDir();
        this.f2606g = luaApplication.getMdDir();
        this.luaCpath = luaApplication.getLuaCpath();
        this.luaDir = this.f2609j;
        this.f2604e = luaApplication.getLuaLpath();
        this.f2612m = luaApplication.getLuaExtDir();
        this.f2605f = new MainHandler();
    }

    public void onDestroy() {
        runFunc("onDestroy", new Object[0]);
        if (this.f2613n != null) {
            unregisterReceiver(this.f2613n);
        }
        super.onDestroy();
    }

    public void onReceive(Context context, Intent intent) {
        runFunc("onReceive", context, intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        f2600b = this;
        if (this.f2607h == null) {
            startForeground(1, new Notification());
            this.f2608i = intent.getStringExtra("luaPath");
            this.luaDir = intent.getStringExtra("luaDir");
            StringBuilder sb = new StringBuilder();
            sb.append(this.luaDir);
            sb.append("/?.lua;");
            sb.append(this.luaDir);
            sb.append("/lua/?.lua;");
            sb.append(this.luaDir);
            sb.append("/?/init.lua;");
            sb.append(this.f2604e);
            this.f2604e = sb.toString();
            Uri data = intent.getData();
            try {
                m2272a();
                this.f2602c = new LuaDexLoader(this);
                this.f2602c.loadLibs();
                doFile(data != null ? data.getPath() : "service.lua");
            } catch (Exception e) {
                sendMsg(e.getMessage());
            }
        }
        runFunc("onStartCommand", intent, Integer.valueOf(i), Integer.valueOf(i2));
        runFunc("onStart", (Object[]) intent.getSerializableExtra("arg"));
        return super.onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void push(int i, String str) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", str);
        message.setData(bundle);
        message.what = i;
        this.f2605f.sendMessage(message);
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
            com.androlua.LuaService$MainHandler r4 = r3.f2605f
            r4.sendMessage(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaService.push(int, java.lang.String, java.lang.Object[]):void");
    }

    public byte[] readAsset(String str) {
        InputStream open = getAssets().open(str);
        byte[] a = m2276a(open);
        open.close();
        return a;
    }

    public void regGc(LuaGcable luaGcable) {
        this.f2603d.add(luaGcable);
    }

    public Intent registerReceiver(IntentFilter intentFilter) {
        if (this.f2613n != null) {
            unregisterReceiver(this.f2613n);
        }
        this.f2613n = new LuaBroadcastReceiver(this);
        return super.registerReceiver(this.f2613n, intentFilter);
    }

    public Intent registerReceiver(OnReceiveListener onReceiveListener, IntentFilter intentFilter) {
        return super.registerReceiver(new LuaBroadcastReceiver(onReceiveListener), intentFilter);
    }

    public Intent registerReceiver(LuaBroadcastReceiver luaBroadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(luaBroadcastReceiver, intentFilter);
    }

    public Object runFunc(String str, Object... objArr) {
        if (this.f2607h != null) {
            try {
                this.f2607h.setTop(0);
                this.f2607h.getGlobal(str);
                if (this.f2607h.isFunction(-1)) {
                    this.f2607h.getGlobal("debug");
                    this.f2607h.getField(-1, "traceback");
                    this.f2607h.remove(-2);
                    this.f2607h.insert(-2);
                    int length = objArr != null ? objArr.length : 0;
                    for (int i = 0; i < length; i++) {
                        this.f2607h.pushObjectValue(objArr[i]);
                    }
                    int pcall = this.f2607h.pcall(length, 1, -2 - length);
                    if (pcall == 0) {
                        return this.f2607h.toJavaObject(-1);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2270a(pcall));
                    sb.append(": ");
                    sb.append(this.f2607h.toString(-1));
                    throw new LuaException(sb.toString());
                }
            } catch (LuaException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" ");
                sb2.append(e.getMessage());
                sendMsg(sb2.toString());
            }
        }
        return null;
    }

    public void sendError(String str, Exception exc) {
        runFunc("onError", str, exc);
    }

    public void sendMsg(String str) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", str);
        message.setData(bundle);
        message.what = 0;
        this.f2605f.sendMessage(message);
        Log.i("lua", str);
    }

    public void set(String str, Object obj) {
        push(1, str, new Object[]{obj});
    }

    public void setBinder(LuaBinder luaBinder) {
        this.f2601a = luaBinder;
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
            r7.f2612m = r8
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
            r7.f2612m = r4
        L_0x0048:
            int r3 = r3 + 1
            goto L_0x002e
        L_0x004b:
            java.lang.String r0 = r7.f2612m
            if (r0 != 0) goto L_0x0058
            java.io.File r8 = r7.getDir(r8, r2)
            java.lang.String r8 = r8.getAbsolutePath()
            goto L_0x001d
        L_0x0058:
            java.io.File r8 = new java.io.File
            java.lang.String r0 = r7.f2612m
            r8.<init>(r0)
            boolean r0 = r8.exists()
            if (r0 != 0) goto L_0x0068
            r8.mkdirs()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaService.setLuaExtDir(java.lang.String):void");
    }

    public boolean setSharedData(String str, Object obj) {
        return LuaApplication.getInstance().setSharedData(str, obj);
    }

    @SuppressLint({"ShowToast"})
    public void showToast(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f2615p != null) {
                if (currentTimeMillis - this.f2617r <= 1000) {
                    this.f2616q.append("\n");
                    this.f2616q.append(str);
                    this.f2615p.setText(this.f2616q.toString());
                    this.f2615p.setDuration(1);
                    this.f2617r = currentTimeMillis;
                    this.f2615p.show();
                }
            }
            this.f2616q.setLength(0);
            this.f2615p = Toast.makeText(this, str, 1);
            this.f2616q.append(str);
            this.f2617r = currentTimeMillis;
            this.f2615p.show();
        } catch (Exception e) {
            C0029a.m806a(e);
        }
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
                    LuaService.this.sendError("onTick", e);
                }
            }
        });
        ticker.setPeriod(j);
        ticker.start();
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
}
