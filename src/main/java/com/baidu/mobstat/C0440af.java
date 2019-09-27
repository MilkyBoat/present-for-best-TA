package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.baidu.mobstat.af */
class C0440af extends SQLiteOpenHelper {

    /* renamed from: a */
    private String f3079a;

    /* renamed from: b */
    private SQLiteDatabase f3080b;

    public C0440af(Context context, String str) {
        super(context, ".confd", null, 1);
        this.f3079a = str;
    }

    /* renamed from: a */
    public int mo3193a(String str, String[] strArr) {
        return this.f3080b.delete(this.f3079a, str, strArr);
    }

    /* renamed from: a */
    public long mo3194a(String str, ContentValues contentValues) {
        return this.f3080b.insert(this.f3079a, str, contentValues);
    }

    /* renamed from: a */
    public Cursor mo3195a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.f3080b.query(this.f3079a, strArr, str, strArr2, str2, str3, str4, str5);
    }

    /* renamed from: a */
    public void mo3196a(String str) {
        getWritableDatabase().execSQL(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo3197a() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.database.sqlite.SQLiteDatabase r0 = r3.f3080b     // Catch:{ all -> 0x0034 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = 1
            goto L_0x0013
        L_0x0009:
            android.database.sqlite.SQLiteDatabase r0 = r3.f3080b     // Catch:{ all -> 0x0034 }
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0007
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 == 0) goto L_0x0024
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ NullPointerException -> 0x001c }
            r3.f3080b = r0     // Catch:{ NullPointerException -> 0x001c }
            goto L_0x0024
        L_0x001c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "db path is null"
            r0.<init>(r1)     // Catch:{ all -> 0x0034 }
            throw r0     // Catch:{ all -> 0x0034 }
        L_0x0024:
            android.database.sqlite.SQLiteDatabase r0 = r3.f3080b     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            android.database.sqlite.SQLiteDatabase r0 = r3.f3080b     // Catch:{ all -> 0x0034 }
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r1 = 1
        L_0x0032:
            monitor-exit(r3)
            return r1
        L_0x0034:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0440af.mo3197a():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo3198b() {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f3080b     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r2.<init>()     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "SELECT COUNT(*) FROM "
            r2.append(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r5.f3079a     // Catch:{ all -> 0x0038 }
            r2.append(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0038 }
            android.database.Cursor r1 = r1.rawQuery(r2, r0)     // Catch:{ all -> 0x0038 }
            r0 = 0
            if (r1 == 0) goto L_0x0032
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0032
            int r0 = r1.getInt(r0)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            return r0
        L_0x002d:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0039
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r1.close()
        L_0x0037:
            return r0
        L_0x0038:
            r1 = move-exception
        L_0x0039:
            if (r0 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.C0440af.mo3198b():int");
    }

    public synchronized void close() {
        super.close();
        if (this.f3080b != null) {
            this.f3080b.close();
            this.f3080b = null;
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f3080b = sQLiteDatabase;
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
