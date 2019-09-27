package com.p021b.p022a.p024b;

import java.util.HashMap;

/* renamed from: com.b.a.b.b */
public abstract class C0408b {

    /* renamed from: a */
    protected HashMap<C0409a, Integer> f2970a = m2566a();

    /* renamed from: com.b.a.b.b$a */
    public enum C0409a {
        FOREGROUND,
        BACKGROUND,
        SELECTION_FOREGROUND,
        SELECTION_BACKGROUND,
        CARET_FOREGROUND,
        CARET_BACKGROUND,
        CARET_DISABLED,
        LINE_HIGHLIGHT,
        NON_PRINTING_GLYPH,
        COMMENT,
        KEYWORD,
        NAME,
        LITERAL,
        STRING,
        SECONDARY
    }

    /* renamed from: a */
    private HashMap<C0409a, Integer> m2566a() {
        HashMap<C0409a, Integer> hashMap = new HashMap<>(C0409a.values().length);
        hashMap.put(C0409a.FOREGROUND, Integer.valueOf(-16777216));
        hashMap.put(C0409a.BACKGROUND, Integer.valueOf(-32));
        hashMap.put(C0409a.SELECTION_FOREGROUND, Integer.valueOf(-32));
        hashMap.put(C0409a.SELECTION_BACKGROUND, Integer.valueOf(-6832092));
        hashMap.put(C0409a.CARET_FOREGROUND, Integer.valueOf(-32));
        hashMap.put(C0409a.CARET_BACKGROUND, Integer.valueOf(-12537601));
        hashMap.put(C0409a.CARET_DISABLED, Integer.valueOf(-8355712));
        hashMap.put(C0409a.LINE_HIGHLIGHT, Integer.valueOf(545818760));
        hashMap.put(C0409a.NON_PRINTING_GLYPH, Integer.valueOf(-5592406));
        hashMap.put(C0409a.COMMENT, Integer.valueOf(-12615841));
        hashMap.put(C0409a.KEYWORD, Integer.valueOf(-3129123));
        hashMap.put(C0409a.NAME, Integer.valueOf(-14008065));
        hashMap.put(C0409a.LITERAL, Integer.valueOf(-10452737));
        hashMap.put(C0409a.STRING, Integer.valueOf(-2276216));
        hashMap.put(C0409a.SECONDARY, Integer.valueOf(-8355712));
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r2 = com.p021b.p022a.p024b.C0408b.C0409a.f2971a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo2956a(int r2) {
        /*
            r1 = this;
            r0 = 10
            if (r2 == r0) goto L_0x002c
            r0 = 30
            if (r2 == r0) goto L_0x0029
            r0 = 40
            if (r2 == r0) goto L_0x0029
            switch(r2) {
                case 0: goto L_0x001a;
                case 1: goto L_0x0026;
                case 2: goto L_0x002c;
                case 3: goto L_0x0023;
                case 4: goto L_0x0020;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r2) {
                case 20: goto L_0x002c;
                case 21: goto L_0x0029;
                default: goto L_0x0012;
            }
        L_0x0012:
            switch(r2) {
                case 50: goto L_0x001d;
                case 51: goto L_0x001d;
                default: goto L_0x0015;
            }
        L_0x0015:
            java.lang.String r2 = "Invalid token type"
            com.p021b.p022a.p024b.C0428q.m2726a(r2)
        L_0x001a:
            com.b.a.b.b$a r2 = com.p021b.p022a.p024b.C0408b.C0409a.FOREGROUND
            goto L_0x002e
        L_0x001d:
            com.b.a.b.b$a r2 = com.p021b.p022a.p024b.C0408b.C0409a.STRING
            goto L_0x002e
        L_0x0020:
            com.b.a.b.b$a r2 = com.p021b.p022a.p024b.C0408b.C0409a.LITERAL
            goto L_0x002e
        L_0x0023:
            com.b.a.b.b$a r2 = com.p021b.p022a.p024b.C0408b.C0409a.NAME
            goto L_0x002e
        L_0x0026:
            com.b.a.b.b$a r2 = com.p021b.p022a.p024b.C0408b.C0409a.KEYWORD
            goto L_0x002e
        L_0x0029:
            com.b.a.b.b$a r2 = com.p021b.p022a.p024b.C0408b.C0409a.COMMENT
            goto L_0x002e
        L_0x002c:
            com.b.a.b.b$a r2 = com.p021b.p022a.p024b.C0408b.C0409a.SECONDARY
        L_0x002e:
            int r2 = r1.mo2957a(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p021b.p022a.p024b.C0408b.mo2956a(int):int");
    }

    /* renamed from: a */
    public int mo2957a(C0409a aVar) {
        Integer num = (Integer) this.f2970a.get(aVar);
        if (num != null) {
            return num.intValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Color not specified for ");
        sb.append(aVar);
        C0428q.m2726a(sb.toString());
        return 0;
    }

    /* renamed from: a */
    public void mo2958a(C0409a aVar, int i) {
        this.f2970a.put(aVar, Integer.valueOf(i));
    }
}
