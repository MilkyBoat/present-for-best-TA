package com.nirenr;

public class Point {

    /* renamed from: t */
    public int f3416t;

    /* renamed from: x */
    public int f3417x;

    /* renamed from: y */
    public int f3418y;

    public Point(int i, int i2) {
        this.f3417x = i;
        this.f3418y = i2;
    }

    public Point(int i, int i2, int i3) {
        this.f3417x = i;
        this.f3418y = i2;
        this.f3416t = i3;
    }

    public Point(Point point) {
        this.f3417x = point.f3417x;
        this.f3418y = point.f3418y;
    }

    public final boolean equals(int i, int i2) {
        return this.f3417x == i && this.f3418y == i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return this.f3417x == point.f3417x && this.f3418y == point.f3418y;
    }

    public int hashCode() {
        return (this.f3417x * 31) + this.f3418y;
    }

    public final void negate() {
        this.f3417x = -this.f3417x;
        this.f3418y = -this.f3418y;
    }

    public final void offset(int i, int i2) {
        this.f3417x += i;
        this.f3418y += i2;
    }

    public void set(int i, int i2) {
        this.f3417x = i;
        this.f3418y = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point(");
        sb.append(this.f3417x);
        sb.append(", ");
        sb.append(this.f3418y);
        sb.append(": ");
        sb.append(this.f3416t);
        sb.append(")");
        return sb.toString();
    }
}
