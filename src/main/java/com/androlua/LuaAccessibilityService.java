package com.androlua;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.hardware.display.VirtualDisplay.Callback;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.androlua.util.ClickRunnable;
import com.androlua.util.ClickRunnable.ClickCallback;
import com.androlua.util.GlobalActionAutomator;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.luajava.LuaTable;
import com.nirenr.Point;
import com.nirenr.screencapture.ScreenCaptureListener;
import com.nirenr.screencapture.ScreenShot;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class LuaAccessibilityService extends AccessibilityService {

    /* renamed from: a */
    private static AccessibilityServiceCallbacks f2268a;

    /* renamed from: d */
    private static LuaAccessibilityService f2269d;
    public static LuaFunction onAccessibilityEvent;

    /* renamed from: b */
    private LuaApplication f2270b;

    /* renamed from: c */
    private Map f2271c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HashMap<String, ComponentName> f2272e = new HashMap<>();

    /* renamed from: f */
    private boolean f2273f;

    /* renamed from: g */
    private Handler f2274g;

    /* renamed from: h */
    private GlobalActionAutomator f2275h;

    /* renamed from: i */
    private ScreenShot f2276i;

    /* renamed from: j */
    private int f2277j;

    /* renamed from: k */
    private int f2278k;

    /* renamed from: l */
    private int f2279l;

    public interface AccessibilityServiceCallbacks {
        void onAccessibilityEvent(LuaAccessibilityService luaAccessibilityService, AccessibilityEvent accessibilityEvent);

        void onConfigurationChanged(LuaAccessibilityService luaAccessibilityService, Configuration configuration);

        void onCreate(LuaAccessibilityService luaAccessibilityService);

        void onDestroy(LuaAccessibilityService luaAccessibilityService);

        void onInterrupt(LuaAccessibilityService luaAccessibilityService);

        boolean onKeyEvent(LuaAccessibilityService luaAccessibilityService, KeyEvent keyEvent);

        void onServiceConnected(LuaAccessibilityService luaAccessibilityService);
    }

    /* renamed from: a */
    private AccessibilityNodeInfo m2134a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (isListView2(accessibilityNodeInfo)) {
            return accessibilityNodeInfo;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo a = m2134a(accessibilityNodeInfo.getChild(i));
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m2136a() {
        WindowManager windowManager = (WindowManager) getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            this.f2277j = displayMetrics.densityDpi;
            this.f2278k = displayMetrics.widthPixels;
            this.f2279l = displayMetrics.heightPixels;
        }
    }

    /* renamed from: a */
    private void m2137a(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList<String> arrayList) {
        if (accessibilityNodeInfo != null) {
            getNodeInfoText(accessibilityNodeInfo);
            int childCount = accessibilityNodeInfo.getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    m2137a(accessibilityNodeInfo.getChild(i), arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    private void m2138a(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList<String> arrayList, AccessibilityNodeInfo accessibilityNodeInfo2) {
        if (accessibilityNodeInfo != null) {
            if (!this.f2273f) {
                this.f2273f = accessibilityNodeInfo.equals(accessibilityNodeInfo2);
            }
            String nodeInfoText = getNodeInfoText(accessibilityNodeInfo);
            if (this.f2273f && nodeInfoText != null) {
                arrayList.add(nodeInfoText.toString());
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                    if (child != null) {
                        if (!this.f2273f) {
                            this.f2273f = child.equals(accessibilityNodeInfo2);
                        }
                        m2138a(child, arrayList, accessibilityNodeInfo2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2140a(String str, LuaException luaException) {
    }

    /* renamed from: a */
    private void m2141a(List<AccessibilityNodeInfo> list, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        String[] split;
        if (accessibilityNodeInfo != null) {
            CharSequence[] charSequenceArr = {accessibilityNodeInfo.getContentDescription(), accessibilityNodeInfo.getText()};
            for (String str2 : str.split("\\|")) {
                boolean z = !str2.startsWith("*");
                boolean z2 = !str2.endsWith("*");
                if (!z) {
                    str2 = str2.substring(1);
                }
                if (!z2) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
                int length = charSequenceArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    CharSequence charSequence = charSequenceArr[i];
                    if (charSequence != null) {
                        String trim = charSequence.toString().trim();
                        if (!z || !z2) {
                            if (z) {
                                if (trim.startsWith(str2)) {
                                    break;
                                }
                            } else if (z2) {
                                if (trim.endsWith(str2)) {
                                    break;
                                }
                            } else if (trim.contains(str2)) {
                                break;
                            }
                        } else if (str2.equals(trim)) {
                            break;
                        }
                    }
                    i++;
                }
                list.add(accessibilityNodeInfo);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                m2141a(list, accessibilityNodeInfo.getChild(i2), str);
            }
        }
    }

    /* renamed from: b */
    private AccessibilityNodeInfo m2142b(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
        while (accessibilityNodeInfo2 != null) {
            try {
                if (isClickable(accessibilityNodeInfo2)) {
                    return accessibilityNodeInfo2;
                }
                accessibilityNodeInfo2 = accessibilityNodeInfo2.getParent();
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        }
        return accessibilityNodeInfo;
    }

    /* renamed from: b */
    private void m2143b() {
        new AsyncTask<String, String, HashMap<String, ComponentName>>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public HashMap<String, ComponentName> doInBackground(String... strArr) {
                HashMap<String, ComponentName> hashMap = new HashMap<>();
                PackageManager packageManager = LuaAccessibilityService.this.getPackageManager();
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.DEFAULT");
                List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                Collections.sort(queryIntentActivities, new DisplayNameComparator(packageManager));
                int size = queryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                    CharSequence loadLabel = resolveInfo.loadLabel(packageManager);
                    hashMap.put(loadLabel.toString().toLowerCase(), new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
                }
                Intent intent2 = new Intent("android.intent.action.MAIN", null);
                intent2.addCategory("android.intent.category.LAUNCHER");
                List queryIntentActivities2 = packageManager.queryIntentActivities(intent2, 0);
                Collections.sort(queryIntentActivities2, new DisplayNameComparator(packageManager));
                int size2 = queryIntentActivities2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ResolveInfo resolveInfo2 = (ResolveInfo) queryIntentActivities2.get(i2);
                    CharSequence loadLabel2 = resolveInfo2.loadLabel(packageManager);
                    hashMap.put(loadLabel2.toString().toLowerCase(), new ComponentName(resolveInfo2.activityInfo.applicationInfo.packageName, resolveInfo2.activityInfo.name));
                }
                return hashMap;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(HashMap<String, ComponentName> hashMap) {
                super.onPostExecute(hashMap);
                if (hashMap != null && !hashMap.isEmpty()) {
                    LuaAccessibilityService.this.f2272e = hashMap;
                }
            }
        }.execute(new String[]{BuildConfig.FLAVOR});
    }

    /* renamed from: c */
    private void m2144c() {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(queryIntentActivities, new DisplayNameComparator(packageManager));
        if (queryIntentActivities != null) {
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                CharSequence loadLabel = resolveInfo.loadLabel(packageManager);
                this.f2272e.put(loadLabel.toString().toLowerCase(), new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            }
        }
    }

    public static LuaAccessibilityService getInstance() {
        return f2269d;
    }

    public static void setCallback(AccessibilityServiceCallbacks accessibilityServiceCallbacks) {
        f2268a = accessibilityServiceCallbacks;
    }

    public boolean appendCopy() {
        return appendCopy(getText(getFocusView()));
    }

    public boolean appendCopy(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        CharSequence text = clipboardManager.getText();
        String str = BuildConfig.FLAVOR;
        if (text != null) {
            str = text.toString();
        }
        if (str.length() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("\n");
            str = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(charSequence);
        clipboardManager.setPrimaryClip(ClipData.newPlainText("label", sb2.toString()));
        return true;
    }

    public boolean click(int i, int i2) {
        if (this.f2275h != null) {
            return this.f2275h.click(i, i2);
        }
        return false;
    }

    public boolean click(LuaTable luaTable) {
        return new ClickRunnable(this, luaTable).canClick();
    }

    public boolean click(LuaTable luaTable, final LuaFunction luaFunction) {
        return new ClickRunnable(this, luaTable).canClick(new ClickCallback() {
            public void onDone(boolean z, LuaTable luaTable, String str, int i) {
                try {
                    luaFunction.call(Boolean.valueOf(z), luaTable, str, Integer.valueOf(i));
                } catch (LuaException e) {
                    C0029a.m806a(e);
                    LuaAccessibilityService.this.m2140a("click", e);
                }
            }
        });
    }

    public boolean click(Point point) {
        return click(point.f3417x, point.f3418y);
    }

    public boolean click(String str, String str2, int[] iArr) {
        if (str == null || str2 == null || !str.equals(getAppName(getFocusView()))) {
            return false;
        }
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        if (rootInActiveWindow == null || rootInActiveWindow.findAccessibilityNodeInfosByText(str2).isEmpty()) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = rootInActiveWindow;
        for (int i : iArr) {
            if (accessibilityNodeInfo.getChildCount() <= i) {
                return false;
            }
            accessibilityNodeInfo = accessibilityNodeInfo.getChild(i);
            if (accessibilityNodeInfo == null) {
                return false;
            }
        }
        return toClick(accessibilityNodeInfo);
    }

    public boolean copy() {
        return copy(getText(getFocusView()));
    }

    public boolean copy(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", charSequence.toString()));
        return true;
    }

    public boolean deleteApp(String str) {
        this.f2272e.clear();
        m2144c();
        ComponentName componentName = (ComponentName) this.f2272e.get(str.toLowerCase());
        if (componentName == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(componentName.getPackageName());
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse(sb.toString()));
        intent.setFlags(270532608);
        startActivity(intent);
        return true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean execute(java.lang.String r4, android.view.accessibility.AccessibilityNodeInfo r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1762910153: goto L_0x00a2;
                case 727753: goto L_0x0098;
                case 904469: goto L_0x008e;
                case 915554: goto L_0x0083;
                case 1024924: goto L_0x0079;
                case 1163658: goto L_0x006e;
                case 1211754: goto L_0x0063;
                case 20002657: goto L_0x0058;
                case 36429412: goto L_0x004d;
                case 647728589: goto L_0x0043;
                case 661385651: goto L_0x0038;
                case 661386612: goto L_0x002d;
                case 697331565: goto L_0x0022;
                case 821558167: goto L_0x0017;
                case 1119180876: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00ad
        L_0x000b:
            java.lang.String r0 = "追加复制"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 8
            goto L_0x00ae
        L_0x0017:
            java.lang.String r0 = "最近任务"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 5
            goto L_0x00ae
        L_0x0022:
            java.lang.String r0 = "增加进度"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 3
            goto L_0x00ae
        L_0x002d:
            java.lang.String r0 = "向下翻页"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 1
            goto L_0x00ae
        L_0x0038:
            java.lang.String r0 = "向上翻页"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 0
            goto L_0x00ae
        L_0x0043:
            java.lang.String r0 = "减少进度"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 2
            goto L_0x00ae
        L_0x004d:
            java.lang.String r0 = "通知栏"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 13
            goto L_0x00ae
        L_0x0058:
            java.lang.String r0 = "主屏幕"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 9
            goto L_0x00ae
        L_0x0063:
            java.lang.String r0 = "长按"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 12
            goto L_0x00ae
        L_0x006e:
            java.lang.String r0 = "返回"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 10
            goto L_0x00ae
        L_0x0079:
            java.lang.String r0 = "粘贴"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 4
            goto L_0x00ae
        L_0x0083:
            java.lang.String r0 = "点击"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 11
            goto L_0x00ae
        L_0x008e:
            java.lang.String r0 = "清空"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 6
            goto L_0x00ae
        L_0x0098:
            java.lang.String r0 = "复制"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 7
            goto L_0x00ae
        L_0x00a2:
            java.lang.String r0 = "打开通知栏"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ad
            r4 = 14
            goto L_0x00ae
        L_0x00ad:
            r4 = -1
        L_0x00ae:
            switch(r4) {
                case 0: goto L_0x0106;
                case 1: goto L_0x00f6;
                case 2: goto L_0x00f1;
                case 3: goto L_0x00ec;
                case 4: goto L_0x00e8;
                case 5: goto L_0x00e4;
                case 6: goto L_0x00d6;
                case 7: goto L_0x00ce;
                case 8: goto L_0x00c6;
                case 9: goto L_0x00c2;
                case 10: goto L_0x00be;
                case 11: goto L_0x00ba;
                case 12: goto L_0x00b6;
                case 13: goto L_0x00b2;
                case 14: goto L_0x00b2;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            return r2
        L_0x00b2:
            r3.toNotifications()
            return r1
        L_0x00b6:
            r3.toLongClick(r5)
            return r1
        L_0x00ba:
            r3.toClick(r5)
            return r1
        L_0x00be:
            r3.toBack()
            return r1
        L_0x00c2:
            r3.toHome()
            return r1
        L_0x00c6:
            java.lang.String r4 = r3.getText(r5)
            r3.appendCopy(r4)
            return r1
        L_0x00ce:
            java.lang.String r4 = r3.getText(r5)
            r3.copy(r4)
            return r1
        L_0x00d6:
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r4 < r0) goto L_0x00e3
            r4 = 2097152(0x200000, float:2.938736E-39)
            boolean r4 = r5.performAction(r4)
            return r4
        L_0x00e3:
            return r2
        L_0x00e4:
            r3.toRecents()
            return r1
        L_0x00e8:
            r3.paste(r5)
            return r1
        L_0x00ec:
            boolean r4 = r3.scrollForward(r5)
            return r4
        L_0x00f1:
            boolean r4 = r3.scrollBackward(r5)
            return r4
        L_0x00f6:
            android.view.accessibility.AccessibilityNodeInfo r4 = r3.getRootInActiveWindow()
            android.view.accessibility.AccessibilityNodeInfo r4 = r3.m2134a(r4)
            if (r4 != 0) goto L_0x0101
            return r2
        L_0x0101:
            boolean r4 = r3.scrollForward(r4)
            return r4
        L_0x0106:
            android.view.accessibility.AccessibilityNodeInfo r4 = r3.getRootInActiveWindow()
            android.view.accessibility.AccessibilityNodeInfo r4 = r3.m2134a(r4)
            if (r4 != 0) goto L_0x0111
            return r2
        L_0x0111:
            boolean r4 = r3.scrollBackward(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androlua.LuaAccessibilityService.execute(java.lang.String, android.view.accessibility.AccessibilityNodeInfo):boolean");
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfo(String str) {
        int lastIndexOf = str.lastIndexOf("@");
        if (lastIndexOf > 0) {
            if (!str.substring(lastIndexOf + 1).equals(getAppName(getFocusView()))) {
                return null;
            }
            str = str.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf("#");
        int i = -1;
        if (lastIndexOf2 > 0) {
            try {
                i = Integer.valueOf(str.substring(lastIndexOf2 + 1)).intValue();
            } catch (Exception unused) {
            }
            str = str.substring(0, lastIndexOf2);
        }
        char charAt = str.charAt(0);
        if (charAt != '>') {
            if (charAt == '@') {
                return findAccessibilityNodeInfoById(str.substring(1), i);
            }
            switch (charAt) {
                case '$':
                    return findAccessibilityNodeInfoByIndex(str.substring(1));
                case '%':
                    if (execute(str.substring(1), getFocusView())) {
                        return AccessibilityNodeInfo.obtain();
                    }
                    return null;
                default:
                    return findAccessibilityNodeInfoByText(str, i);
            }
        } else if (startApp(str.substring(1))) {
            return AccessibilityNodeInfo.obtain();
        } else {
            return null;
        }
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoById(String str, int i) {
        List findAccessibilityNodeInfoById = findAccessibilityNodeInfoById(str);
        if (findAccessibilityNodeInfoById.isEmpty()) {
            return null;
        }
        int size = findAccessibilityNodeInfoById.size();
        if (i + 1 > size || 0 - i > size) {
            return null;
        }
        return (AccessibilityNodeInfo) (i < 0 ? findAccessibilityNodeInfoById.get(findAccessibilityNodeInfoById.size() + i) : findAccessibilityNodeInfoById.get(i));
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfoById(String str) {
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        return rootInActiveWindow == null ? new ArrayList() : rootInActiveWindow.findAccessibilityNodeInfosByText(str);
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByIndex(String str) {
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        String[] split = str.split("-");
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int intValue = Integer.valueOf(split[i]).intValue();
                if (rootInActiveWindow.getChildCount() <= intValue) {
                    return null;
                }
                rootInActiveWindow = rootInActiveWindow.getChild(intValue);
                if (rootInActiveWindow == null) {
                    return null;
                }
                i++;
            } catch (Exception e) {
                C0029a.m806a(e);
                return null;
            }
        }
        return rootInActiveWindow;
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByText(String str, int i) {
        List findAccessibilityNodeInfoByText = findAccessibilityNodeInfoByText(str);
        if (findAccessibilityNodeInfoByText.isEmpty()) {
            return null;
        }
        int size = findAccessibilityNodeInfoByText.size();
        if (i + 1 > size || 0 - i > size) {
            return null;
        }
        return (AccessibilityNodeInfo) (i < 0 ? findAccessibilityNodeInfoByText.get(findAccessibilityNodeInfoByText.size() + i) : findAccessibilityNodeInfoByText.get(i));
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfoByText(String str) {
        String[] split;
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        ArrayList arrayList = new ArrayList();
        if (rootInActiveWindow == null) {
            return arrayList;
        }
        for (String str2 : str.split("\\|")) {
            if (!str2.isEmpty()) {
                if (str2.charAt(0) != '%') {
                    int lastIndexOf = str2.lastIndexOf(38);
                    if (lastIndexOf > 0) {
                        if (findAccessibilityNodeInfo(str2.substring(lastIndexOf + 1)) != null) {
                            str2 = str2.substring(0, lastIndexOf);
                        }
                    }
                    boolean z = !str2.startsWith("*");
                    boolean z2 = !str2.endsWith("*");
                    if (!z) {
                        str2 = str2.substring(1);
                    }
                    if (!z2) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    for (AccessibilityNodeInfo accessibilityNodeInfo : rootInActiveWindow.findAccessibilityNodeInfosByText(str2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(accessibilityNodeInfo.getText());
                        sb.append(BuildConfig.FLAVOR);
                        String trim = sb.toString().trim();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(accessibilityNodeInfo.getContentDescription());
                        sb2.append(BuildConfig.FLAVOR);
                        String trim2 = sb2.toString().trim();
                        if (!z || !z2) {
                            if (z) {
                                if (!trim.startsWith(str2) && !trim2.startsWith(str2)) {
                                }
                            } else if (z2) {
                                if (!trim.endsWith(str2) && !trim2.endsWith(str2)) {
                                }
                            } else if (!trim.contains(str2) && !trim2.contains(str2)) {
                            }
                        } else if (!str2.equals(trim) && !str2.equals(trim2)) {
                        }
                        arrayList.add(accessibilityNodeInfo);
                    }
                } else {
                    execute(str2.substring(1), getFocusView());
                    return arrayList;
                }
            }
        }
        if (arrayList.isEmpty()) {
            m2141a((List<AccessibilityNodeInfo>) arrayList, rootInActiveWindow, str);
        }
        return arrayList;
    }

    public boolean findClick(String[] strArr) {
        for (String findAccessibilityNodeInfoByText : strArr) {
            AccessibilityNodeInfo findAccessibilityNodeInfoByText2 = findAccessibilityNodeInfoByText(findAccessibilityNodeInfoByText, 0);
            if (findAccessibilityNodeInfoByText2 != null && m2142b(findAccessibilityNodeInfoByText2).performAction(16)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<AccessibilityNodeInfo> getAllEditTextList() {
        ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<>();
        getEditText(getRootInActiveWindow(), arrayList);
        return arrayList;
    }

    public String getAllText(int i) {
        ArrayList allTextList = getAllTextList();
        StringBuilder sb = new StringBuilder();
        Iterator it = allTextList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.length() > i) {
                sb.append(str);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public ArrayList<String> getAllTextList() {
        ArrayList<String> arrayList = new ArrayList<>();
        m2137a(getRootInActiveWindow(), arrayList);
        return arrayList;
    }

    public ArrayList<String> getAllTextList(AccessibilityNodeInfo accessibilityNodeInfo) {
        ArrayList<String> arrayList = new ArrayList<>();
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        this.f2273f = !accessibilityNodeInfo.isVisibleToUser();
        m2138a(rootInActiveWindow, arrayList, accessibilityNodeInfo);
        return arrayList;
    }

    public String getAppName(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return BuildConfig.FLAVOR;
        }
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        if (packageName == null) {
            return BuildConfig.FLAVOR;
        }
        String charSequence = packageName.toString();
        PackageManager packageManager = getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(charSequence, 0)).toString();
        } catch (NameNotFoundException e) {
            C0029a.m806a(e);
            return BuildConfig.FLAVOR;
        }
    }

    public int getDensity() {
        if (this.f2277j == 0) {
            m2136a();
        }
        return this.f2277j;
    }

    public AccessibilityNodeInfo getEditText() {
        ArrayList allEditTextList = getAllEditTextList();
        if (allEditTextList.isEmpty()) {
            return null;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) allEditTextList.get(0);
        if (accessibilityNodeInfo != null) {
            accessibilityNodeInfo.performAction(64);
        }
        return accessibilityNodeInfo;
    }

    public void getEditText(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList<AccessibilityNodeInfo> arrayList) {
        if (accessibilityNodeInfo != null) {
            if (accessibilityNodeInfo.isEditable()) {
                arrayList.add(accessibilityNodeInfo);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    getEditText(accessibilityNodeInfo.getChild(i), arrayList);
                }
            }
        }
    }

    public AccessibilityNodeInfo getFocusView() {
        return getRootInActiveWindow();
    }

    public Handler getHandler() {
        return this.f2274g;
    }

    public int getHeight() {
        if (this.f2279l == 0) {
            m2136a();
        }
        return this.f2279l;
    }

    public String getNodeInfoText(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        CharSequence text = accessibilityNodeInfo.getText();
        String charSequence = contentDescription != null ? contentDescription.toString() : null;
        if (charSequence != null && charSequence.trim().length() > 0 && (!accessibilityNodeInfo.isEditable() || text == null)) {
            return charSequence;
        }
        if (text == null || text.length() <= 0) {
            return null;
        }
        return text.toString();
    }

    public Bitmap getScreenshot() {
        if (this.f2276i != null) {
            return this.f2276i.getScreenShot();
        }
        return null;
    }

    public void getScreenshot(final LuaFunction luaFunction) {
        ScreenShot.getScreenCaptureBitmap(this, new ScreenCaptureListener() {
            public void onScreenCaptureDone(Bitmap bitmap) {
                try {
                    luaFunction.call(bitmap);
                } catch (LuaException e) {
                    C0029a.m806a(e);
                }
            }

            public void onScreenCaptureError(String str) {
                try {
                    luaFunction.call(null, str);
                } catch (LuaException e) {
                    C0029a.m806a(e);
                }
            }
        });
    }

    public String getText(AccessibilityNodeInfo accessibilityNodeInfo) {
        return getNodeInfoText(accessibilityNodeInfo);
    }

    public int getWidth() {
        if (this.f2278k == 0) {
            m2136a();
        }
        return this.f2278k;
    }

    public boolean insert(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        if (!(accessibilityNodeInfo == null || charSequence == null || !accessibilityNodeInfo.isEditable())) {
            if (!accessibilityNodeInfo.isFocused()) {
                accessibilityNodeInfo.performAction(1);
            }
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
            clipboardManager.setPrimaryClip(ClipData.newPlainText("label", charSequence));
            clipboardManager.setText(charSequence);
            if (accessibilityNodeInfo.performAction(32768)) {
                return true;
            }
        }
        return false;
    }

    public boolean installApp(String str) {
        if (str == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("market://search?q=");
        sb.append(str);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.setFlags(270532608);
        try {
            startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isClickable(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isCheckable()) {
            return true;
        }
        if (VERSION.SDK_INT >= 21) {
            if (accessibilityNodeInfo.getActionList().contains(AccessibilityAction.ACTION_CLICK)) {
                return true;
            }
        } else if ((accessibilityNodeInfo.getActions() & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isListView2(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        CharSequence className = accessibilityNodeInfo.getClassName();
        if (className != null) {
            String charSequence = className.toString();
            char c = 65535;
            switch (charSequence.hashCode()) {
                case -1433025002:
                    if (charSequence.equals("android.widget.GridView")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1154346071:
                    if (charSequence.equals("android.widget.AdapterView")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1102376577:
                    if (charSequence.equals("com.tencent.widget.GridView")) {
                        c = 9;
                        break;
                    }
                    break;
                case -703660929:
                    if (charSequence.equals("android.support.v7.widget.RecyclerView")) {
                        c = 5;
                        break;
                    }
                    break;
                case -438596061:
                    if (charSequence.equals("flyme.support.v7.widget.RecyclerView")) {
                        c = 6;
                        break;
                    }
                    break;
                case -405438610:
                    if (charSequence.equals("android.widget.ListView")) {
                        c = 1;
                        break;
                    }
                    break;
                case 841510749:
                    if (charSequence.equals("android.widget.ScrollView")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1799238850:
                    if (charSequence.equals("android.widget.ExpandableListView")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1928354017:
                    if (charSequence.equals("android.widget.HorizontalScrollView")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1977625610:
                    if (charSequence.equals("android.widget.AbsListView")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    return charSequence.endsWith("ScrollView") || charSequence.endsWith("GridView") || charSequence.endsWith("RecyclerView") || charSequence.endsWith("ListView");
            }
        }
    }

    public boolean longClick(int i, int i2) {
        if (this.f2275h != null) {
            return this.f2275h.longClick(i, i2);
        }
        return false;
    }

    public boolean longClick(Point point) {
        return longClick(point.f3417x, point.f3418y);
    }

    public ClickRunnable loopClick(final LuaTable luaTable) {
        ClickRunnable clickRunnable = new ClickRunnable(this, luaTable);
        clickRunnable.canClick(new ClickCallback() {
            public void onDone(boolean z, LuaTable luaTable, String str, int i) {
                LuaAccessibilityService.this.loopClick(luaTable);
            }
        });
        return clickRunnable;
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (f2268a != null) {
            f2268a.onAccessibilityEvent(this, accessibilityEvent);
        }
        if (onAccessibilityEvent != null) {
            try {
                onAccessibilityEvent.call(accessibilityEvent);
            } catch (LuaException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("onAccessibilityEvent: ");
                sb.append(e.toString());
                Log.i("lua", sb.toString());
            }
        } else if (this.f2271c.containsKey("LuaAccessibilityService")) {
            LuaTable luaTable = (LuaTable) this.f2271c.get("LuaAccessibilityService");
            if (luaTable != null) {
                try {
                    ((LuaFunction) luaTable.get("onAccessibilityEvent")).call(accessibilityEvent);
                } catch (LuaException e2) {
                    LuaFunction luaFunction = (LuaFunction) luaTable.get("onError");
                    if (luaFunction == null) {
                        Log.i("onAccessibilityEvent", e2.getMessage());
                        return;
                    }
                    try {
                        luaFunction.call(e2);
                    } catch (LuaException unused) {
                        Log.i("onAccessibilityEvent", e2.getMessage());
                    }
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (f2268a != null) {
            f2268a.onConfigurationChanged(this, configuration);
        }
    }

    public void onCreate() {
        Log.i("lua", "onCreate");
        super.onCreate();
        this.f2274g = new Handler();
        f2269d = this;
        if (VERSION.SDK_INT >= 24) {
            this.f2275h = new GlobalActionAutomator(this, new Handler());
            this.f2275h.setService(this);
        }
        if (f2268a != null) {
            f2268a.onCreate(this);
        }
        m2143b();
        this.f2270b = (LuaApplication) getApplication();
        this.f2271c = this.f2270b.getGlobalData();
        if (this.f2271c.containsKey("LuaAccessibilityService")) {
            LuaTable luaTable = (LuaTable) this.f2271c.get("LuaAccessibilityService");
            if (luaTable != null) {
                try {
                    ((LuaFunction) luaTable.get("onCreate")).call(this);
                } catch (LuaException e) {
                    LuaFunction luaFunction = (LuaFunction) luaTable.get("onError");
                    if (luaFunction == null) {
                        Log.i("onCreate", e.getMessage());
                        return;
                    }
                    try {
                        luaFunction.call(e);
                    } catch (LuaException unused) {
                        Log.i("onCreate", e.getMessage());
                    }
                }
            }
        }
    }

    public void onDestroy() {
        if (f2268a != null) {
            f2268a.onDestroy(this);
        }
        stopScreenshot();
        super.onDestroy();
    }

    public void onInterrupt() {
        if (f2268a != null) {
            f2268a.onInterrupt(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onKeyEvent(KeyEvent keyEvent) {
        if (f2268a == null || !f2268a.onKeyEvent(this, keyEvent)) {
            return super.onKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onServiceConnected() {
        Log.i("lua", "onServiceConnected");
        super.onServiceConnected();
        if (f2268a != null) {
            f2268a.onServiceConnected(this);
        }
        if (this.f2271c.containsKey("LuaAccessibilityService")) {
            LuaTable luaTable = (LuaTable) this.f2271c.get("LuaAccessibilityService");
            if (luaTable != null) {
                try {
                    ((LuaFunction) luaTable.get("onServiceConnected")).call(this);
                } catch (LuaException e) {
                    LuaFunction luaFunction = (LuaFunction) luaTable.get("onError");
                    if (luaFunction == null) {
                        Log.i("onServiceConnected", e.getMessage());
                        return;
                    }
                    try {
                        luaFunction.call(e);
                    } catch (LuaException unused) {
                        Log.i("onServiceConnected", e.getMessage());
                    }
                }
            }
        }
    }

    public boolean paste() {
        return paste(getFocusView(), ((ClipboardManager) getSystemService("clipboard")).getText());
    }

    public boolean paste(AccessibilityNodeInfo accessibilityNodeInfo) {
        return paste(accessibilityNodeInfo, ((ClipboardManager) getSystemService("clipboard")).getText());
    }

    public boolean paste(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        if (accessibilityNodeInfo == null || charSequence == null) {
            return false;
        }
        if (accessibilityNodeInfo.isEditable()) {
            if (!accessibilityNodeInfo.isFocused()) {
                accessibilityNodeInfo.performAction(1);
            }
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
            clipboardManager.setPrimaryClip(ClipData.newPlainText("label", charSequence));
            clipboardManager.setText(charSequence);
            if (accessibilityNodeInfo.performAction(32768)) {
                return true;
            }
        }
        return paste(charSequence);
    }

    public boolean paste(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        AccessibilityNodeInfo editText = getEditText();
        if (editText == null) {
            return false;
        }
        if (getFocusView().isEditable() && getFocusView().getText() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getFocusView().getText().toString());
            sb.append(charSequence);
            charSequence = sb.toString();
        }
        if (VERSION.SDK_INT < 21) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", charSequence);
        return editText.performAction(2097152, bundle);
    }

    public void postClick(long j, final LuaTable luaTable) {
        this.f2274g.postDelayed(new Runnable() {
            public void run() {
                LuaAccessibilityService.this.click(luaTable);
            }
        }, j);
    }

    public void postClick(long j, final LuaTable luaTable, final LuaFunction luaFunction) {
        this.f2274g.postDelayed(new Runnable() {
            public void run() {
                LuaAccessibilityService.this.click(luaTable, luaFunction);
            }
        }, j);
    }

    public void postExecute(long j, final String str, final AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2274g.postDelayed(new Runnable() {
            public void run() {
                LuaAccessibilityService.this.execute(str, accessibilityNodeInfo);
            }
        }, j);
    }

    public void postExecute(long j, final String str, final AccessibilityNodeInfo accessibilityNodeInfo, final LuaFunction luaFunction) {
        this.f2274g.postDelayed(new Runnable() {
            public void run() {
                try {
                    luaFunction.call(Boolean.valueOf(LuaAccessibilityService.this.execute(str, accessibilityNodeInfo)), str, accessibilityNodeInfo);
                } catch (LuaException e) {
                    C0029a.m806a(e);
                    LuaAccessibilityService.this.m2140a("postExecute", e);
                }
            }
        }, j);
    }

    public boolean press(int i, int i2, int i3) {
        if (this.f2275h != null) {
            return this.f2275h.press(i, i2, i3);
        }
        return false;
    }

    public boolean press(Point point, int i) {
        return press(point.f3417x, point.f3418y, i);
    }

    public boolean scrollBackward(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (VERSION.SDK_INT < 21) {
            if ((accessibilityNodeInfo.getActions() & 8192) == 0) {
                return false;
            }
        } else if (!accessibilityNodeInfo.getActionList().contains(AccessibilityAction.ACTION_SCROLL_BACKWARD)) {
            return false;
        }
        return accessibilityNodeInfo.performAction(8192);
    }

    public boolean scrollForward(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (VERSION.SDK_INT < 21) {
            if ((accessibilityNodeInfo.getActions() & 4096) == 0) {
                return false;
            }
        } else if (!accessibilityNodeInfo.getActionList().contains(AccessibilityAction.ACTION_SCROLL_FORWARD)) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    public boolean setText(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isEditable()) {
            return false;
        }
        if (VERSION.SDK_INT < 21) {
            return paste(accessibilityNodeInfo, str);
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str);
        return accessibilityNodeInfo.performAction(2097152, bundle);
    }

    public boolean setText(String str) {
        return setText(getEditText(), str);
    }

    public boolean startApp(String str) {
        m2143b();
        ComponentName componentName = (ComponentName) this.f2272e.get(str.toLowerCase());
        if (componentName == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setComponent(componentName);
        intent.setFlags(270532608);
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            C0029a.m806a(e);
            return false;
        }
    }

    public void startScreenshot() {
        this.f2276i = new ScreenShot(this, null);
    }

    public void startScreenshot(Callback callback) {
        this.f2276i = new ScreenShot(this, callback);
    }

    public void stopScreenshot() {
        if (this.f2276i != null) {
            this.f2276i.release();
        }
        this.f2276i = null;
    }

    public boolean swipe(int i, int i2, int i3, int i4, int i5) {
        if (this.f2275h != null) {
            return this.f2275h.swipe(i, i2, i3, i4, i5);
        }
        return false;
    }

    public boolean swipe(Path path, int i) {
        if (this.f2275h != null) {
            return this.f2275h.gesture(0, (long) i, path);
        }
        return false;
    }

    public boolean swipe(Point point, Point point2, int i) {
        return swipe(point.f3417x, point.f3418y, point2.f3417x, point2.f3418y, i);
    }

    public void toBack() {
        performGlobalAction(1);
    }

    public boolean toClick(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            try {
                return accessibilityNodeInfo.performAction(16);
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        }
        return false;
    }

    public void toClick2(AccessibilityNodeInfo accessibilityNodeInfo) {
        toClick(m2142b(accessibilityNodeInfo));
    }

    public void toHome() {
        performGlobalAction(2);
    }

    public boolean toLongClick(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            try {
                return accessibilityNodeInfo.performAction(32);
            } catch (Exception e) {
                C0029a.m806a(e);
            }
        }
        return false;
    }

    public void toNotifications() {
        performGlobalAction(4);
    }

    public void toRecents() {
        performGlobalAction(3);
    }
}
