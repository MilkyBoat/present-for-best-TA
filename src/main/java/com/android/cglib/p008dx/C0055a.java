package com.android.cglib.p008dx;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* renamed from: com.android.cglib.dx.a */
class C0055a {
    C0055a() {
    }

    /* renamed from: a */
    private String m866a(ClassLoader classLoader, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("path");
            declaredField.setAccessible(true);
            return (String) declaredField.get(classLoader);
        } catch (ClassCastException | IllegalAccessException | NoSuchFieldException unused) {
            return m867a(classLoader.toString());
        }
    }

    /* renamed from: a */
    static String m867a(String str) {
        return str.contains("DexPathList") ? m871e(str) : m870d(str);
    }

    /* renamed from: b */
    private ClassLoader m868b() {
        return C0055a.class.getClassLoader();
    }

    /* renamed from: c */
    static String[] m869c(String str) {
        if (str.startsWith("dexPath=")) {
            int length = "dexPath=".length();
            int indexOf = str.indexOf(44);
            str = indexOf == -1 ? str.substring(length) : str.substring(length, indexOf);
        }
        return str.split(":");
    }

    /* renamed from: d */
    private static String m870d(String str) {
        int lastIndexOf = str.lastIndexOf(91);
        if (lastIndexOf != -1) {
            str = str.substring(lastIndexOf + 1);
        }
        int indexOf = str.indexOf(93);
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }

    /* renamed from: e */
    private static String m871e(String str) {
        int indexOf = str.indexOf("DexPathList") + "DexPathList".length();
        if (str.length() <= indexOf + 4) {
            return str;
        }
        String substring = str.substring(indexOf);
        int indexOf2 = substring.indexOf(93);
        if (substring.charAt(0) != '[' || substring.charAt(1) != '[' || indexOf2 < 0) {
            return str;
        }
        String[] split = substring.substring(2, indexOf2).split(",");
        for (int i = 0; i < split.length; i++) {
            int indexOf3 = split[i].indexOf(34);
            int lastIndexOf = split[i].lastIndexOf(34);
            if (indexOf3 > 0 && indexOf3 < lastIndexOf) {
                split[i] = split[i].substring(indexOf3 + 1, lastIndexOf);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (sb.length() > 0) {
                sb.append(':');
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public File mo1192a() {
        try {
            ClassLoader b = m868b();
            Class cls = Class.forName("dalvik.system.PathClassLoader");
            cls.cast(b);
            File[] b2 = mo1195b(m866a(b, cls));
            if (b2.length > 0) {
                return b2[0];
            }
        } catch (ClassCastException | ClassNotFoundException unused) {
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1193a(File file) {
        return file.exists();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo1194b(File file) {
        return file.isDirectory() && file.canWrite();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public File[] mo1195b(String str) {
        String[] c;
        ArrayList arrayList = new ArrayList();
        for (String str2 : m869c(str)) {
            if (str2.startsWith("/data/app/")) {
                int length = "/data/app/".length();
                int lastIndexOf = str2.lastIndexOf(".apk");
                if (lastIndexOf == str2.length() - 4) {
                    int indexOf = str2.indexOf("-");
                    if (indexOf != -1) {
                        lastIndexOf = indexOf;
                    }
                    String substring = str2.substring(length, lastIndexOf);
                    StringBuilder sb = new StringBuilder();
                    sb.append("/data/data/");
                    sb.append(substring);
                    File file = new File(sb.toString());
                    if (mo1194b(file)) {
                        File file2 = new File(file, "cache");
                        if ((mo1193a(file2) || file2.mkdir()) && mo1194b(file2)) {
                            arrayList.add(file2);
                        }
                    }
                }
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }
}
