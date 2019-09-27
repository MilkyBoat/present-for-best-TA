package com.luajava;

public class LuaString implements CharSequence {

    /* renamed from: a */
    private byte[] f3405a = new byte[0];

    public LuaString(String str) {
        this.f3405a = str.getBytes();
    }

    public LuaString(byte[] bArr) {
        this.f3405a = bArr;
    }

    public char charAt(int i) {
        return (char) this.f3405a[i];
    }

    public int length() {
        return this.f3405a.length;
    }

    public CharSequence subSequence(int i, int i2) {
        return new String(this.f3405a, i, i2);
    }

    public byte[] toByteArray() {
        return this.f3405a;
    }

    public String toString() {
        return new String(this.f3405a);
    }
}
