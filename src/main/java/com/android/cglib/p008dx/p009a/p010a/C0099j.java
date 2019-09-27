package com.android.cglib.p008dx.p009a.p010a;

import bsh.ParserConstants;
import com.android.cglib.p008dx.p013b.C0222b;
import com.android.cglib.p008dx.p013b.C0224c;

/* renamed from: com.android.cglib.dx.a.a.j */
public final class C0099j {

    /* renamed from: a */
    private final int f915a;

    /* renamed from: b */
    private final int f916b;

    /* renamed from: c */
    private final int f917c;

    /* renamed from: d */
    private final C0103n f918d;

    /* renamed from: e */
    private final boolean f919e;

    public C0099j(int i, int i2, int i3, C0103n nVar, boolean z) {
        if (!C0224c.m1646a(i)) {
            throw new IllegalArgumentException("bogus opcode");
        } else if (!C0224c.m1646a(i2)) {
            throw new IllegalArgumentException("bogus family");
        } else if (!C0224c.m1646a(i3)) {
            throw new IllegalArgumentException("bogus nextOpcode");
        } else if (nVar == null) {
            throw new NullPointerException("format == null");
        } else {
            this.f915a = i;
            this.f916b = i2;
            this.f917c = i3;
            this.f918d = nVar;
            this.f919e = z;
        }
    }

    /* renamed from: a */
    public int mo1277a() {
        return this.f915a;
    }

    /* renamed from: b */
    public int mo1278b() {
        return this.f916b;
    }

    /* renamed from: c */
    public C0103n mo1279c() {
        return this.f918d;
    }

    /* renamed from: d */
    public boolean mo1280d() {
        return this.f919e;
    }

    /* renamed from: e */
    public String mo1281e() {
        return C0222b.m1643b(this.f915a);
    }

    /* renamed from: f */
    public int mo1282f() {
        return this.f917c;
    }

    /* renamed from: g */
    public C0099j mo1283g() {
        switch (this.f915a) {
            case 50:
                return C0100k.f973aa;
            case 51:
                return C0100k.f945Z;
            case 52:
                return C0100k.f975ac;
            case 53:
                return C0100k.f974ab;
            case 54:
                return C0100k.f977ae;
            case 55:
                return C0100k.f976ad;
            case 56:
                return C0100k.f979ag;
            case 57:
                return C0100k.f978af;
            case 58:
                return C0100k.f981ai;
            case ParserConstants.WHILE /*59*/:
                return C0100k.f980ah;
            case ParserConstants.INTEGER_LITERAL /*60*/:
                return C0100k.f983ak;
            case ParserConstants.DECIMAL_LITERAL /*61*/:
                return C0100k.f982aj;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("bogus opcode: ");
                sb.append(this);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    public String toString() {
        return mo1281e();
    }
}
