package com.nirenr;

public class Color {
    public int blue;
    public int green;
    public int red;

    public Color(int i) {
        this.red = (i << 8) >>> 24;
        this.green = (i << 16) >>> 24;
        this.blue = (i << 24) >>> 24;
    }

    public Color(int i, int i2, int i3) {
        this.red = i;
        this.green = i2;
        this.blue = i3;
    }

    public int getInt() {
        return (this.red << 16) | -16777216 | (this.green << 8) | this.blue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Color(");
        sb.append(this.red);
        sb.append(", ");
        sb.append(this.green);
        sb.append(", ");
        sb.append(this.blue);
        sb.append(")");
        return sb.toString();
    }
}
