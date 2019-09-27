package com.p021b.p022a.p024b;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.b.a.b.h */
public abstract class C0416h {

    /* renamed from: f */
    private static final char[] f2993f = {'(', ')', '{', '}', '.', ',', ';', '=', '+', '-', '/', '*', '&', '!', '|', ':', '[', ']', '<', '>', '?', '~', '%', '^'};

    /* renamed from: a */
    protected HashMap<String, Integer> f2994a = new HashMap<>(0);

    /* renamed from: b */
    protected HashMap<String, Integer> f2995b = new HashMap<>(0);

    /* renamed from: c */
    protected HashMap<String, String[]> f2996c = new HashMap<>(0);

    /* renamed from: d */
    protected HashMap<String, Integer> f2997d = new HashMap<>(0);

    /* renamed from: e */
    protected HashMap<Character, Integer> f2998e = m2619b(f2993f);

    /* renamed from: g */
    private ArrayList<String> f2999g = new ArrayList<>();

    /* renamed from: h */
    private String[] f3000h = new String[0];

    /* renamed from: i */
    private String[] f3001i;

    /* renamed from: j */
    private String[] f3002j;

    /* renamed from: b */
    private HashMap<Character, Integer> m2619b(char[] cArr) {
        HashMap<Character, Integer> hashMap = new HashMap<>(cArr.length);
        for (char valueOf : cArr) {
            hashMap.put(Character.valueOf(valueOf), Integer.valueOf(2));
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo3005a() {
        this.f3000h = (String[]) this.f2999g.toArray(new String[this.f2999g.size()]);
    }

    /* renamed from: a */
    public void mo3006a(String str, String[] strArr) {
        this.f2996c.put(str, strArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3007a(char[] cArr) {
        this.f2998e = m2619b(cArr);
    }

    /* renamed from: a */
    public void mo3008a(String[] strArr) {
        this.f3001i = strArr;
        this.f2994a = new HashMap<>(strArr.length);
        for (String put : strArr) {
            this.f2994a.put(put, Integer.valueOf(1));
        }
    }

    /* renamed from: a */
    public final boolean mo3009a(char c) {
        return this.f2998e.containsKey(Character.valueOf(c));
    }

    /* renamed from: a */
    public boolean mo3010a(char c, char c2) {
        return c == '/' && c2 == '/';
    }

    /* renamed from: a */
    public final boolean mo3011a(String str, String str2) {
        for (String equals : (String[]) this.f2996c.get(str)) {
            if (equals.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public String[] mo3012a(String str) {
        return (String[]) this.f2996c.get(str);
    }

    /* renamed from: b */
    public void mo3013b(String str) {
        this.f2996c.remove(str);
    }

    /* renamed from: b */
    public void mo3014b(String[] strArr) {
        this.f3002j = strArr;
        ArrayList arrayList = new ArrayList();
        this.f2995b = new HashMap<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            if (!arrayList.contains(strArr[i])) {
                arrayList.add(strArr[i]);
            }
            this.f2995b.put(strArr[i], Integer.valueOf(3));
        }
        this.f3002j = new String[arrayList.size()];
        arrayList.toArray(this.f3002j);
    }

    /* renamed from: b */
    public boolean mo3015b(char c) {
        return c == ' ' || c == 10 || c == 9 || c == 13 || c == 12 || c == 65535;
    }

    /* renamed from: b */
    public boolean mo3016b(char c, char c2) {
        return c == '/' && c2 == '*';
    }

    /* renamed from: b */
    public String[] mo3017b() {
        return this.f3000h;
    }

    /* renamed from: c */
    public void mo3018c(String str) {
        if (!this.f2999g.contains(str) && !this.f2995b.containsKey(str)) {
            this.f2999g.add(str);
        }
        this.f2997d.put(str, Integer.valueOf(3));
    }

    /* renamed from: c */
    public boolean mo3019c(char c) {
        return c == '.';
    }

    /* renamed from: c */
    public boolean mo3020c(char c, char c2) {
        return c == '*' && c2 == '/';
    }

    /* renamed from: c */
    public String[] mo3021c() {
        return this.f3002j;
    }

    /* renamed from: d */
    public boolean mo3022d(char c) {
        return c == '\\';
    }

    /* renamed from: d */
    public final boolean mo3023d(String str) {
        return this.f2994a.containsKey(str);
    }

    /* renamed from: d */
    public String[] mo3024d() {
        return this.f3001i;
    }

    /* renamed from: e */
    public void mo3025e() {
        this.f2999g.clear();
        this.f2997d.clear();
    }

    /* renamed from: e */
    public boolean mo3026e(char c) {
        return false;
    }

    /* renamed from: e */
    public final boolean mo3027e(String str) {
        return this.f2995b.containsKey(str);
    }

    /* renamed from: f */
    public boolean mo3028f() {
        return true;
    }

    /* renamed from: f */
    public boolean mo3029f(char c) {
        return c == '\"';
    }

    /* renamed from: f */
    public final boolean mo3030f(String str) {
        return this.f2996c.containsKey(str);
    }

    /* renamed from: g */
    public boolean mo3031g(char c) {
        return c == '\'';
    }

    /* renamed from: g */
    public final boolean mo3032g(String str) {
        return this.f2997d.containsKey(str);
    }

    /* renamed from: h */
    public boolean mo3033h(char c) {
        return c == '#';
    }

    /* renamed from: i */
    public boolean mo3034i(char c) {
        return false;
    }
}
