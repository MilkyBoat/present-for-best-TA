package com.androlua;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.luajava.LuaMetaTable;
import java.io.InputStream;
import java.util.HashMap;

@SuppressLint({"UseSparseArrays"})
public class LuaResources extends Resources implements LuaMetaTable {

    /* renamed from: a */
    private static int f2567a = 2131034112;

    /* renamed from: b */
    private final HashMap<Integer, String> f2568b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<Integer, Drawable> f2569c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<Integer, Integer> f2570d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<Integer, String[]> f2571e = new HashMap<>();

    /* renamed from: f */
    private final HashMap<Integer, int[]> f2572f = new HashMap<>();

    /* renamed from: g */
    private final HashMap<Integer, Typeface> f2573g = new HashMap<>();

    /* renamed from: h */
    private final HashMap<Integer, Integer> f2574h = new HashMap<>();

    /* renamed from: i */
    private final HashMap<Integer, Float> f2575i = new HashMap<>();

    /* renamed from: j */
    private final HashMap<Integer, Boolean> f2576j = new HashMap<>();

    /* renamed from: k */
    private final HashMap<String, Integer> f2577k = new HashMap<>();

    /* renamed from: l */
    private Resources f2578l;

    public LuaResources(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
    }

    public Object __call(Object... objArr) {
        return null;
    }

    public Object __index(String str) {
        return get(str);
    }

    public void __newIndex(String str, Object obj) {
        put(str, obj);
    }

    public Object get(String str) {
        return this.f2577k.get(str);
    }

    public XmlResourceParser getAnimation(int i) {
        return this.f2578l.getAnimation(i);
    }

    public boolean getBoolean(int i) {
        Boolean bool = (Boolean) this.f2576j.get(Integer.valueOf(i));
        return bool != null ? bool.booleanValue() : this.f2578l.getBoolean(i);
    }

    public int getColor(int i) {
        Integer num = (Integer) this.f2570d.get(Integer.valueOf(i));
        return num != null ? num.intValue() : this.f2578l.getColor(i);
    }

    @TargetApi(23)
    public int getColor(int i, Theme theme) {
        Integer num = (Integer) this.f2570d.get(Integer.valueOf(i));
        return num != null ? num.intValue() : this.f2578l.getColor(i, theme);
    }

    public ColorStateList getColorStateList(int i) {
        return this.f2578l.getColorStateList(i);
    }

    @TargetApi(23)
    public ColorStateList getColorStateList(int i, Theme theme) {
        return this.f2578l.getColorStateList(i, theme);
    }

    public Configuration getConfiguration() {
        return this.f2578l.getConfiguration();
    }

    public float getDimension(int i) {
        return this.f2578l.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) {
        return this.f2578l.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) {
        return this.f2578l.getDimensionPixelSize(i);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f2578l.getDisplayMetrics();
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = (Drawable) this.f2569c.get(Integer.valueOf(i));
        return drawable != null ? drawable : this.f2578l.getDrawable(i);
    }

    @TargetApi(21)
    public Drawable getDrawable(int i, Theme theme) {
        Drawable drawable = (Drawable) this.f2569c.get(Integer.valueOf(i));
        return drawable != null ? drawable : this.f2578l.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) {
        return this.f2578l.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return this.f2578l.getDrawableForDensity(i, i2, theme);
    }

    @TargetApi(26)
    public Typeface getFont(int i) {
        Typeface typeface = (Typeface) this.f2573g.get(Integer.valueOf(i));
        return typeface != null ? typeface : this.f2578l.getFont(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f2578l.getFraction(i, i2, i3);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f2578l.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i) {
        int[] iArr = (int[]) this.f2572f.get(Integer.valueOf(i));
        return iArr != null ? iArr : this.f2578l.getIntArray(i);
    }

    public int getInteger(int i) {
        Integer num = (Integer) this.f2574h.get(Integer.valueOf(i));
        return num != null ? num.intValue() : this.f2578l.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) {
        return this.f2578l.getLayout(i);
    }

    public Movie getMovie(int i) {
        return this.f2578l.getMovie(i);
    }

    public String getQuantityString(int i, int i2) {
        return this.f2578l.getQuantityString(i, i2);
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.f2578l.getQuantityString(i, i2, objArr);
    }

    public CharSequence getQuantityText(int i, int i2) {
        return this.f2578l.getQuantityText(i, i2);
    }

    public String getResourceEntryName(int i) {
        return this.f2578l.getResourceEntryName(i);
    }

    public String getResourceName(int i) {
        return this.f2578l.getResourceName(i);
    }

    public String getResourcePackageName(int i) {
        return this.f2578l.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) {
        return this.f2578l.getResourceTypeName(i);
    }

    public String getString(int i) {
        return getText(i).toString();
    }

    public String getString(int i, Object... objArr) {
        return String.format(getString(i), objArr);
    }

    public String[] getStringArray(int i) {
        String[] strArr = (String[]) this.f2571e.get(Integer.valueOf(i));
        return strArr != null ? strArr : this.f2578l.getStringArray(i);
    }

    public CharSequence getText(int i) {
        String str = (String) this.f2568b.get(Integer.valueOf(i));
        return str != null ? str : this.f2578l.getText(i);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        String str = (String) this.f2568b.get(Integer.valueOf(i));
        return str != null ? str : this.f2578l.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) {
        String[] strArr = (String[]) this.f2571e.get(Integer.valueOf(i));
        return strArr != null ? strArr : this.f2578l.getTextArray(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.f2578l.getValue(i, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.f2578l.getValue(str, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        this.f2578l.getValueForDensity(i, i2, typedValue, z);
    }

    public XmlResourceParser getXml(int i) {
        return this.f2578l.getXml(i);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2578l.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i) {
        return this.f2578l.obtainTypedArray(i);
    }

    public InputStream openRawResource(int i) {
        return this.f2578l.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.f2578l.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.f2578l.openRawResourceFd(i);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f2578l.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f2578l.parseBundleExtras(xmlResourceParser, bundle);
    }

    public int put(String str, Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        int i = f2567a;
        f2567a = i + 1;
        if (obj instanceof Drawable) {
            setDrawable(i, (Drawable) obj);
        } else if (obj instanceof String) {
            setText(i, (String) obj);
        } else if (obj instanceof String[]) {
            setTextArray(i, (String[]) obj);
        } else if (obj instanceof Number) {
            setColor(i, ((Number) obj).intValue());
        } else if (obj instanceof int[]) {
            setIntArray(i, (int[]) obj);
        } else {
            throw new IllegalArgumentException();
        }
        this.f2577k.put(str, Integer.valueOf(i));
        return i;
    }

    public void setBoolean(int i, Boolean bool) {
        this.f2576j.put(Integer.valueOf(i), bool);
    }

    public void setColor(int i, int i2) {
        this.f2570d.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void setDrawable(int i, Drawable drawable) {
        this.f2569c.put(Integer.valueOf(i), drawable);
    }

    public void setFont(int i, Typeface typeface) {
        this.f2573g.put(Integer.valueOf(i), typeface);
    }

    public void setIntArray(int i, int[] iArr) {
        this.f2572f.put(Integer.valueOf(i), iArr);
    }

    public void setString(int i, String str) {
        this.f2568b.put(Integer.valueOf(i), str);
    }

    public void setStringArray(int i, String[] strArr) {
        this.f2571e.put(Integer.valueOf(i), strArr);
    }

    public void setSuperResources(Resources resources) {
        this.f2578l = resources;
    }

    public void setText(int i, String str) {
        this.f2568b.put(Integer.valueOf(i), str);
    }

    public void setTextArray(int i, String[] strArr) {
        this.f2571e.put(Integer.valueOf(i), strArr);
    }
}
