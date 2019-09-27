package com.luajava;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LuaTable<K, V> extends LuaObject implements Map<K, V> {

    public class LuaEntry<K, V> implements Entry<K, V> {

        /* renamed from: b */
        private K f3407b;

        /* renamed from: c */
        private V f3408c;

        public LuaEntry(K k, V v) {
            this.f3407b = k;
            this.f3408c = v;
        }

        public K getKey() {
            return this.f3407b;
        }

        public V getValue() {
            return this.f3408c;
        }

        public V setValue(V v) {
            V v2 = this.f3408c;
            this.f3408c = v;
            return v2;
        }
    }

    public LuaTable(LuaState luaState) {
        super(luaState);
        luaState.newTable();
        mo3442a(-1);
    }

    protected LuaTable(LuaState luaState, int i) {
        super(luaState, i);
    }

    public void clear() {
        push();
        this.f3393b.pushNil();
        while (this.f3393b.next(-2) != 0) {
            this.f3393b.pop(1);
            this.f3393b.pushValue(-1);
            this.f3393b.pushNil();
            this.f3393b.setTable(-4);
        }
        this.f3393b.pop(1);
    }

    public boolean containsKey(Object obj) {
        push();
        try {
            this.f3393b.pushObjectValue(obj);
            boolean z = this.f3393b.getTable(-2) != 0;
            this.f3393b.pop(1);
            this.f3393b.pop(1);
            return z;
        } catch (LuaException unused) {
            return false;
        }
    }

    public boolean containsValue(Object obj) {
        return false;
    }

    public Set<Entry<K, V>> entrySet() {
        HashSet hashSet = new HashSet();
        push();
        this.f3393b.pushNil();
        while (this.f3393b.next(-2) != 0) {
            try {
                hashSet.add(new LuaEntry(this.f3393b.toJavaObject(-2), this.f3393b.toJavaObject(-1)));
            } catch (LuaException unused) {
            }
            this.f3393b.pop(1);
        }
        this.f3393b.pop(1);
        return hashSet;
    }

    public V get(Object obj) {
        V v;
        push();
        try {
            this.f3393b.pushObjectValue(obj);
            this.f3393b.getTable(-2);
            v = this.f3393b.toJavaObject(-1);
            try {
                this.f3393b.pop(1);
            } catch (LuaException unused) {
            }
        } catch (LuaException unused2) {
            v = null;
        }
        this.f3393b.pop(1);
        return v;
    }

    public boolean isEmpty() {
        push();
        this.f3393b.pushNil();
        boolean z = this.f3393b.next(-2) == 0;
        if (z) {
            this.f3393b.pop(1);
            return z;
        }
        this.f3393b.pop(3);
        return z;
    }

    public boolean isList() {
        push();
        if (this.f3393b.rawLen(-1) != 0) {
            pop();
            return true;
        }
        this.f3393b.pushNil();
        boolean z = this.f3393b.next(-2) == 0;
        if (z) {
            this.f3393b.pop(1);
            return z;
        }
        this.f3393b.pop(3);
        return z;
    }

    public Set<K> keySet() {
        HashSet hashSet = new HashSet();
        push();
        this.f3393b.pushNil();
        while (this.f3393b.next(-2) != 0) {
            try {
                hashSet.add(this.f3393b.toJavaObject(-2));
            } catch (LuaException unused) {
            }
            this.f3393b.pop(1);
        }
        this.f3393b.pop(1);
        return hashSet;
    }

    public int length() {
        push();
        int rawLen = this.f3393b.rawLen(-1);
        pop();
        return rawLen;
    }

    public V put(K k, V v) {
        push();
        try {
            this.f3393b.pushObjectValue(k);
            this.f3393b.pushObjectValue(v);
            this.f3393b.setTable(-3);
        } catch (LuaException unused) {
        }
        this.f3393b.pop(1);
        return null;
    }

    public void putAll(Map map) {
    }

    public V remove(Object obj) {
        push();
        try {
            this.f3393b.pushObjectValue(obj);
            this.f3393b.setTable(-2);
        } catch (LuaException unused) {
        }
        this.f3393b.pop(1);
        return null;
    }

    public int size() {
        push();
        this.f3393b.pushNil();
        int i = 0;
        while (this.f3393b.next(-2) != 0) {
            i++;
            this.f3393b.pop(1);
        }
        this.f3393b.pop(1);
        return i;
    }

    public Collection values() {
        return null;
    }
}
