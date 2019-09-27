package com.luajava;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LuaList extends LuaObject implements List {
    public LuaList(LuaState luaState) {
        super(luaState);
        luaState.newTable();
        mo3442a(-1);
    }

    public void add(int i, Object obj) {
    }

    public boolean add(Object obj) {
        push();
        int rawLen = this.f3393b.rawLen(-1);
        try {
            this.f3393b.pushObjectValue(obj);
            this.f3393b.setI(-2, (long) (rawLen + 1));
            pop();
            return true;
        } catch (LuaException unused) {
            pop();
            return false;
        }
    }

    public boolean addAll(int i, Collection collection) {
        return false;
    }

    public boolean addAll(Collection collection) {
        return false;
    }

    public void clear() {
    }

    public boolean contains(Object obj) {
        return false;
    }

    public boolean containsAll(Collection collection) {
        return false;
    }

    public Object get(int i) {
        return null;
    }

    public int indexOf(Object obj) {
        return 0;
    }

    public boolean isEmpty() {
        push();
        int rawLen = this.f3393b.rawLen(-1);
        this.f3393b.pop(1);
        return rawLen == 0;
    }

    public Iterator iterator() {
        return null;
    }

    public int lastIndexOf(Object obj) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int i) {
        return null;
    }

    public Object remove(int i) {
        return null;
    }

    public boolean remove(Object obj) {
        return false;
    }

    public boolean removeAll(Collection collection) {
        return false;
    }

    public boolean retainAll(Collection collection) {
        return false;
    }

    public Object set(int i, Object obj) {
        return null;
    }

    public int size() {
        push();
        int rawLen = this.f3393b.rawLen(-1);
        this.f3393b.pop(1);
        return rawLen;
    }

    public List subList(int i, int i2) {
        return null;
    }

    public Object[] toArray() {
        return null;
    }

    public Object[] toArray(Object[] objArr) {
        return null;
    }
}
