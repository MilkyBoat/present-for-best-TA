package com.androlua;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class LuaBitmap {

    /* renamed from: a */
    static WeakHashMap<String, WeakReference<Bitmap>> f2407a = new WeakHashMap<>();

    /* renamed from: b */
    private static long f2408b = 604800000;

    /* renamed from: a */
    private static int m2187a(Options options, int i, int i2) {
        int b = m2188b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    /* renamed from: b */
    private static int m2188b(Options options, int i, int i2) {
        int i3;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        if (i == -1) {
            i3 = 128;
        } else {
            double d3 = (double) i;
            i3 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i3 < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : i3;
    }

    public static boolean checkCache(LuaContext luaContext, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(luaContext.getLuaExtDir("cache"));
        sb.append("/");
        sb.append(str.hashCode());
        File file = new File(sb.toString());
        return file.exists() && f2408b != -1 && System.currentTimeMillis() - file.lastModified() < f2408b;
    }

    public static Bitmap decodeScale(int i, File file) {
        Options options = new Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        if (options.outHeight > i * 4 || options.outWidth > i) {
            i2 = (int) Math.pow(2.0d, (double) ((int) Math.round(Math.log(((double) i) / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
        }
        Options options2 = new Options();
        options2.inSampleSize = i2;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
    }

    public static Bitmap getAssetBitmap(Context context, String str) {
        InputStream open = context.getAssets().open(str);
        Bitmap decodeStream = BitmapFactory.decodeStream(open);
        open.close();
        return decodeStream;
    }

    public static Bitmap getBitmap(LuaContext luaContext, String str) {
        Bitmap bitmap;
        WeakReference weakReference = (WeakReference) f2407a.get(str);
        if (weakReference != null) {
            Bitmap bitmap2 = (Bitmap) weakReference.get();
            if (bitmap2 != null) {
                return bitmap2;
            }
        }
        if (str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://")) {
            bitmap = getHttpBitmap(luaContext, str);
        } else if (str.charAt(0) != '/') {
            StringBuilder sb = new StringBuilder();
            sb.append(luaContext.getLuaDir());
            sb.append("/");
            sb.append(str);
            bitmap = getLocalBitmap(luaContext, sb.toString());
        } else {
            bitmap = getLocalBitmap(luaContext, str);
        }
        f2407a.put(str, new WeakReference(bitmap));
        return bitmap;
    }

    public static Bitmap getBitmapFromFile(File file, int i, int i2) {
        Options options;
        if (file != null && file.exists()) {
            if (i <= 0 || i2 <= 0) {
                options = null;
            } else {
                options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                options.inSampleSize = m2187a(options, Math.min(i, i2), i * i2);
                options.inJustDecodeBounds = false;
                options.inInputShareable = true;
                options.inPurgeable = true;
            }
            try {
                return BitmapFactory.decodeFile(file.getPath(), options);
            } catch (OutOfMemoryError e) {
                C0029a.m806a(e);
            }
        }
        return null;
    }

    public static long getCacheTime() {
        return f2408b;
    }

    public static Bitmap getHttpBitmap(LuaContext luaContext, String str) {
        int width;
        File file;
        StringBuilder sb = new StringBuilder();
        sb.append(luaContext.getLuaExtDir("cache"));
        sb.append("/");
        sb.append(str.hashCode());
        String sb2 = sb.toString();
        File file2 = new File(sb2);
        if (!file2.exists() || f2408b == -1 || System.currentTimeMillis() - file2.lastModified() >= f2408b) {
            new File(sb2).delete();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(120000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(sb2);
            if (!LuaUtil.copyFile(inputStream, (OutputStream) fileOutputStream)) {
                fileOutputStream.close();
                inputStream.close();
                new File(sb2).delete();
                throw new RuntimeException("LoadHttpBitmap Error.");
            }
            fileOutputStream.close();
            inputStream.close();
            width = luaContext.getWidth();
            file = new File(sb2);
        } else {
            width = luaContext.getWidth();
            file = new File(sb2);
        }
        return decodeScale(width, file);
    }

    public static Bitmap getHttpBitmap(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        inputStream.close();
        return decodeStream;
    }

    public static Bitmap getImageFromPath(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = m2187a(options, -1, 62500);
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap getLocalBitmap(LuaContext luaContext, String str) {
        return decodeScale(luaContext.getWidth(), new File(str));
    }

    public static Bitmap getLocalBitmap(String str) {
        FileInputStream fileInputStream = new FileInputStream(str);
        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
        fileInputStream.close();
        return decodeStream;
    }

    public static void removeBitmap(Bitmap bitmap) {
        for (Entry entry : f2407a.entrySet()) {
            if (bitmap.equals(((WeakReference) entry.getValue()).get())) {
                f2407a.remove(entry.getKey());
                return;
            }
        }
    }

    public static void setCacheTime(long j) {
        f2408b = j;
    }
}
