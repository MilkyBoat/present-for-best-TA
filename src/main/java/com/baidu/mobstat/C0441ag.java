package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;

/* renamed from: com.baidu.mobstat.ag */
class C0441ag extends C0540x {
    public C0441ag() {
        super("ap_list3", "Create table if not exists ap_list3(_id Integer primary key AUTOINCREMENT,time VARCHAR(50),content TEXT);");
    }

    /* renamed from: a */
    private ArrayList<C0539w> m2804a(Cursor cursor) {
        ArrayList<C0539w> arrayList = new ArrayList<>();
        if (cursor == null || cursor.getCount() == 0) {
            return arrayList;
        }
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("time");
        int columnIndex3 = cursor.getColumnIndex("content");
        while (cursor.moveToNext()) {
            arrayList.add(new C0539w(cursor.getLong(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public long mo3205a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", str);
        contentValues.put("content", str2);
        return mo3399a(contentValues);
    }

    /* renamed from: a */
    public ArrayList<C0539w> mo3206a(int i, int i2) {
        Cursor a = mo3400a("time", i, i2);
        ArrayList<C0539w> a2 = m2804a(a);
        if (a != null) {
            a.close();
        }
        return a2;
    }

    /* renamed from: b */
    public boolean mo3207b(long j) {
        return mo3403a(j);
    }
}
