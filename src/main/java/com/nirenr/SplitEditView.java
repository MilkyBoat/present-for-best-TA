package com.nirenr;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.androlua.BuildConfig;
import com.androlua.LuaEditor;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitEditView extends LinearLayout implements OnClickListener, OnItemClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f3419a;

    /* renamed from: b */
    private LinearLayout f3420b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public GridView f3421c;

    /* renamed from: d */
    private LuaEditor f3422d;

    /* renamed from: e */
    private int f3423e = 0;

    /* renamed from: f */
    private String f3424f = BuildConfig.FLAVOR;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String[] f3425g = {BuildConfig.FLAVOR};

    /* renamed from: h */
    private OnSaveListener f3426h;

    /* renamed from: i */
    private LinearLayout f3427i;

    private class EditDialog implements DialogInterface.OnClickListener {

        /* renamed from: b */
        private final int f3429b;

        /* renamed from: c */
        private final EditText f3430c;

        /* renamed from: d */
        private AlertDialog f3431d;

        public EditDialog(int i) {
            this.f3429b = i;
            this.f3430c = new EditText(SplitEditView.this.f3419a);
            this.f3430c.setText(SplitEditView.this.f3425g[i]);
            this.f3430c.setSelection(SplitEditView.this.f3425g[i].length());
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            SplitEditView.this.f3425g[this.f3429b] = this.f3430c.getText().toString();
            SplitEditView.this.m3295f();
            SplitEditView.this.f3421c.smoothScrollToPosition(this.f3429b);
        }

        public void show() {
            this.f3431d = new Builder(SplitEditView.this.f3419a).setTitle("输入内容").setView(this.f3430c).setNegativeButton(17039360, null).setPositiveButton(17039370, this).setCancelable(false).create();
            Window window = this.f3431d.getWindow();
            if (window != null) {
                window.setSoftInputMode(4);
                if (SplitEditView.this.f3419a instanceof Service) {
                    window.setType(VERSION.SDK_INT >= 22 ? 2032 : 2010);
                }
                this.f3431d.show();
            }
            this.f3430c.setFocusable(true);
            this.f3430c.requestFocus();
        }
    }

    public interface OnSaveListener {
        void onSave(String str);
    }

    public SplitEditView(Context context) {
        super(context);
        m3286a(context);
        this.f3419a = context;
    }

    /* renamed from: a */
    private void m3285a() {
        this.f3425g = new String[]{this.f3424f};
        switch (this.f3423e) {
            case 1:
                m3294e();
                return;
            case 2:
                m3290c();
                return;
            case 3:
                m3293d();
                return;
            case 4:
                m3288b();
                return;
            default:
                setShowEdit(true);
                return;
        }
    }

    /* renamed from: a */
    private void m3286a(Context context) {
        this.f3420b = this;
        this.f3420b.setOrientation(1);
        LayoutParams layoutParams = new LayoutParams(-1, -1, 1.0f);
        LayoutParams layoutParams2 = new LayoutParams(-1, -2, 1.0f);
        LayoutParams layoutParams3 = new LayoutParams(-1, -2);
        this.f3421c = new GridView(context);
        this.f3422d = new LuaEditor(context);
        this.f3421c.setOnItemClickListener(this);
        this.f3420b.addView(this.f3421c, layoutParams);
        this.f3420b.addView(this.f3422d, layoutParams);
        this.f3427i = new LinearLayout(context);
        String[] strArr = {"全文", "按段", "按行", "按句", "按字", "确定"};
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            Button button = new Button(context);
            button.setText(str);
            button.setId(i);
            button.setOnClickListener(this);
            this.f3427i.addView(button, layoutParams2);
        }
        this.f3420b.addView(this.f3427i, layoutParams3);
        this.f3421c.setVisibility(8);
        this.f3422d.setVisibility(0);
        setText(BuildConfig.FLAVOR);
        setOnSaveListener(null);
    }

    /* renamed from: a */
    private String[] m3287a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        int i = 0;
        while (matcher.find()) {
            int end = matcher.end();
            if (this.f3423e == 1) {
                end = matcher.start();
            }
            arrayList.add(str.substring(i, end));
            i = this.f3423e == 1 ? matcher.end() : end;
        }
        if (i != str.length()) {
            arrayList.add(str.substring(i));
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    /* renamed from: b */
    private void m3288b() {
        this.f3424f = getText();
        this.f3423e = 4;
        this.f3425g = new String[this.f3424f.length()];
        for (int i = 0; i < this.f3424f.length(); i++) {
            this.f3425g[i] = String.valueOf(this.f3424f.charAt(i));
        }
        if (this.f3425g.length == 0) {
            this.f3425g = new String[]{BuildConfig.FLAVOR};
        }
        this.f3421c.setNumColumns(8);
        this.f3421c.setAdapter(new ArrayListAdapter(this.f3419a, 17367043, (T[]) this.f3425g));
    }

    /* renamed from: c */
    private void m3290c() {
        this.f3424f = getText();
        this.f3423e = 2;
        this.f3425g = m3287a(this.f3424f, "\n");
        if (this.f3425g.length == 0) {
            this.f3425g = new String[]{BuildConfig.FLAVOR};
        }
        this.f3421c.setNumColumns(1);
        this.f3421c.setAdapter(new ArrayListAdapter(this.f3419a, 17367043, (T[]) this.f3425g));
    }

    /* renamed from: d */
    private void m3293d() {
        this.f3424f = getText();
        this.f3423e = 3;
        this.f3425g = m3287a(this.f3424f, "\\. |[。？！，\n “”,：；;\\?!]+");
        if (this.f3425g.length == 0) {
            this.f3425g = new String[]{BuildConfig.FLAVOR};
        }
        this.f3421c.setNumColumns(1);
        this.f3421c.setAdapter(new ArrayListAdapter(this.f3419a, 17367043, (T[]) this.f3425g));
    }

    /* renamed from: e */
    private void m3294e() {
        this.f3424f = getText();
        this.f3423e = 1;
        this.f3425g = m3287a(this.f3424f, "\\n{2,10}");
        if (this.f3425g.length == 0) {
            this.f3425g = new String[]{BuildConfig.FLAVOR};
        }
        this.f3421c.setNumColumns(1);
        this.f3421c.setAdapter(new ArrayListAdapter(this.f3419a, 17367043, (T[]) this.f3425g));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m3295f() {
        switch (this.f3423e) {
            case 1:
                m3294e();
                return;
            case 2:
                m3290c();
                return;
            case 3:
                m3293d();
                return;
            case 4:
                m3288b();
                return;
            default:
                return;
        }
    }

    private void setShowEdit(boolean z) {
        if (isShowEdit() != z) {
            if (!z) {
                this.f3421c.setVisibility(0);
                this.f3422d.setVisibility(8);
                this.f3424f = this.f3422d.getText().toString();
                this.f3425g = new String[]{this.f3424f};
                return;
            }
            this.f3422d.setText(getText());
            this.f3421c.setVisibility(8);
            this.f3422d.setVisibility(0);
        }
    }

    public String getText() {
        if (isShowEdit()) {
            return this.f3422d.getText().toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String append : this.f3425g) {
            sb.append(append);
            if (this.f3423e == 1) {
                sb.append("\n\n");
            }
        }
        if (this.f3423e == 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    public boolean isShowEdit() {
        return this.f3422d.getVisibility() == 0;
    }

    public void onClick(View view) {
        Button button = (Button) view;
        switch (view.getId()) {
            case 0:
                setShowEdit(true);
                this.f3423e = 0;
                break;
            case 1:
                setShowEdit(false);
                m3294e();
                return;
            case 2:
                setShowEdit(false);
                m3290c();
                return;
            case 3:
                setShowEdit(false);
                m3293d();
                return;
            case 4:
                setShowEdit(false);
                m3288b();
                return;
            case 5:
                if (this.f3426h != null) {
                    this.f3426h.onSave(getText());
                    return;
                }
                break;
            default:
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        new EditDialog(i).show();
    }

    public void setOnSaveListener(OnSaveListener onSaveListener) {
        View childAt;
        int i;
        this.f3426h = onSaveListener;
        if (onSaveListener == null) {
            childAt = this.f3427i.getChildAt(5);
            i = 8;
        } else {
            childAt = this.f3427i.getChildAt(5);
            i = 0;
        }
        childAt.setVisibility(i);
    }

    public void setText(String str) {
        this.f3424f = str;
        if (this.f3424f == null) {
            this.f3424f = BuildConfig.FLAVOR;
        }
        this.f3422d.setText(this.f3424f);
        m3285a();
    }
}
