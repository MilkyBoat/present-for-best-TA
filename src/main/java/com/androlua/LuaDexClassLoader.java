package com.androlua;

import dalvik.system.DexClassLoader;
import java.util.HashMap;

public class LuaDexClassLoader extends DexClassLoader {

    /* renamed from: a */
    private HashMap<String, Class<?>> f2446a = new HashMap<>();

    /* renamed from: b */
    private String f2447b;

    public LuaDexClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        this.f2447b = str;
    }

    /* access modifiers changed from: protected */
    public Class<?> findClass(String str) {
        Class<?> cls = (Class) this.f2446a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> findClass = super.findClass(str);
        this.f2446a.put(str, findClass);
        return findClass;
    }

    public String getDexPath() {
        return this.f2447b;
    }
}
