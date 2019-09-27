package com.p002a.p003a.p004a.p005a.p006a.p007a;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.a.a.a.a.a.a.a */
public final class C0029a {

    /* renamed from: a */
    static final C0030a f798a;

    /* renamed from: b */
    static final int f799b;

    /* renamed from: com.a.a.a.a.a.a.a$a */
    static abstract class C0030a {

        /* renamed from: a */
        protected static final Throwable[] f800a = new Throwable[0];

        C0030a() {
        }

        /* renamed from: a */
        public abstract void mo1102a(Throwable th);

        /* renamed from: a */
        public abstract void mo1103a(Throwable th, PrintStream printStream);

        /* renamed from: a */
        public abstract void mo1104a(Throwable th, PrintWriter printWriter);
    }

    /* renamed from: com.a.a.a.a.a.a.a$b */
    static final class C0031b extends C0030a {
        C0031b() {
        }

        /* renamed from: a */
        public void mo1102a(Throwable th) {
            th.printStackTrace();
        }

        /* renamed from: a */
        public void mo1103a(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        /* renamed from: a */
        public void mo1104a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* renamed from: com.a.a.a.a.a.a.a$c */
    static final class C0032c extends C0030a {
        C0032c() {
        }

        /* renamed from: a */
        public void mo1102a(Throwable th) {
            th.printStackTrace();
        }

        /* renamed from: a */
        public void mo1103a(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        /* renamed from: a */
        public void mo1104a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    static {
        /*
            java.lang.Integer r0 = m810b()     // Catch:{ Throwable -> 0x0028 }
            if (r0 == 0) goto L_0x0016
            int r1 = r0.intValue()     // Catch:{ Throwable -> 0x0014 }
            r2 = 19
            if (r1 < r2) goto L_0x0016
            com.a.a.a.a.a.a.a$c r1 = new com.a.a.a.a.a.a.a$c     // Catch:{ Throwable -> 0x0014 }
            r1.<init>()     // Catch:{ Throwable -> 0x0014 }
            goto L_0x0055
        L_0x0014:
            r1 = move-exception
            goto L_0x002a
        L_0x0016:
            boolean r1 = m809a()     // Catch:{ Throwable -> 0x0014 }
            if (r1 == 0) goto L_0x0022
            com.a.a.a.a.a.a.a$b r1 = new com.a.a.a.a.a.a.a$b     // Catch:{ Throwable -> 0x0014 }
            r1.<init>()     // Catch:{ Throwable -> 0x0014 }
            goto L_0x0055
        L_0x0022:
            com.a.a.a.a.a.a.a$b r1 = new com.a.a.a.a.a.a.a$b     // Catch:{ Throwable -> 0x0014 }
            r1.<init>()     // Catch:{ Throwable -> 0x0014 }
            goto L_0x0055
        L_0x0028:
            r1 = move-exception
            r0 = 0
        L_0x002a:
            java.io.PrintStream r2 = java.lang.System.err
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy "
            r3.append(r4)
            java.lang.Class<com.a.a.a.a.a.a.a$b> r4 = com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.C0031b.class
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            java.io.PrintStream r2 = java.lang.System.err
            r1.printStackTrace(r2)
            com.a.a.a.a.a.a.a$b r1 = new com.a.a.a.a.a.a.a$b
            r1.<init>()
        L_0x0055:
            f798a = r1
            if (r0 != 0) goto L_0x005b
            r0 = 1
            goto L_0x005f
        L_0x005b:
            int r0 = r0.intValue()
        L_0x005f:
            f799b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a.<clinit>():void");
    }

    /* renamed from: a */
    public static void m806a(Throwable th) {
        f798a.mo1102a(th);
    }

    /* renamed from: a */
    public static void m807a(Throwable th, PrintStream printStream) {
        f798a.mo1103a(th, printStream);
    }

    /* renamed from: a */
    public static void m808a(Throwable th, PrintWriter printWriter) {
        f798a.mo1104a(th, printWriter);
    }

    /* renamed from: a */
    private static boolean m809a() {
        return !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic");
    }

    /* renamed from: b */
    private static Integer m810b() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
