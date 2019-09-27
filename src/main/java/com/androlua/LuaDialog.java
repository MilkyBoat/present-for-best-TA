package com.androlua;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayListAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuaDialog extends AlertDialog implements android.content.DialogInterface.OnClickListener {

    /* renamed from: a */
    private Context f2457a;

    /* renamed from: b */
    private ListView f2458b = new ListView(this.f2457a);

    /* renamed from: c */
    private String f2459c;

    /* renamed from: d */
    private String f2460d;

    /* renamed from: e */
    private View f2461e;

    /* renamed from: f */
    private OnClickListener f2462f;

    public interface OnClickListener {
        void onClick(LuaDialog luaDialog, Button button);
    }

    public LuaDialog(Context context) {
        super(context);
        this.f2457a = context;
    }

    public LuaDialog(Context context, int i) {
        super(context, i);
        this.f2457a = context;
    }

    public ListView getListView() {
        return this.f2458b;
    }

    public String getMessage() {
        return this.f2459c;
    }

    public String getTitle() {
        return this.f2460d;
    }

    public View getView() {
        return this.f2461e;
    }

    public void hide() {
        super.hide();
    }

    public boolean isShowing() {
        return super.isShowing();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2462f != null) {
            this.f2462f.onClick(this, getButton(i));
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (!this.f2458b.equals(this.f2461e)) {
            setView(this.f2458b);
        }
        this.f2458b.setAdapter(listAdapter);
    }

    public void setButton(CharSequence charSequence) {
        setOkButton(charSequence);
    }

    public void setButton1(CharSequence charSequence) {
        setButton(-1, charSequence, this);
    }

    public void setButton2(CharSequence charSequence) {
        setButton(-2, charSequence, this);
    }

    public void setButton3(CharSequence charSequence) {
        setButton(-3, charSequence, this);
    }

    public void setCancelButton(CharSequence charSequence) {
        setButton(-2, charSequence, this);
    }

    public void setIcon(Drawable drawable) {
        super.setIcon(drawable);
    }

    public void setItems(String[] strArr) {
        setAdapter(new ArrayListAdapter(this.f2457a, 17367043, (List<T>) new ArrayList<T>(Arrays.asList(strArr))));
        this.f2458b.setChoiceMode(0);
    }

    public void setMessage(CharSequence charSequence) {
        this.f2459c = charSequence.toString();
        super.setMessage(charSequence);
    }

    public void setMultiChoiceItems(CharSequence[] charSequenceArr) {
        setMultiChoiceItems(charSequenceArr, new int[0]);
    }

    public void setMultiChoiceItems(CharSequence[] charSequenceArr, int[] iArr) {
        setAdapter(new ArrayListAdapter(this.f2457a, 17367056, (List<T>) new ArrayList<T>(Arrays.asList(charSequenceArr))));
        this.f2458b.setChoiceMode(2);
        for (int itemChecked : iArr) {
            this.f2458b.setItemChecked(itemChecked, true);
        }
    }

    public void setNegButton(CharSequence charSequence) {
        setButton(-2, charSequence, this);
    }

    public void setNegativeButton(CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        setButton(-2, charSequence, onClickListener);
    }

    public void setNeuButton(CharSequence charSequence) {
        setButton(-3, charSequence, this);
    }

    public void setNeutralButton(CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        setButton(-3, charSequence, onClickListener);
    }

    public void setOkButton(CharSequence charSequence) {
        setButton(-1, charSequence, this);
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f2462f = onClickListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f2458b.setOnItemClickListener(onItemClickListener);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.f2458b.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f2458b.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setPosButton(CharSequence charSequence) {
        setButton(-1, charSequence, this);
    }

    public void setPositiveButton(CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        setButton(-1, charSequence, onClickListener);
    }

    public void setSingleChoiceItems(CharSequence[] charSequenceArr) {
        setSingleChoiceItems(charSequenceArr, 0);
    }

    public void setSingleChoiceItems(CharSequence[] charSequenceArr, int i) {
        setAdapter(new ArrayListAdapter(this.f2457a, 17367055, (List<T>) new ArrayList<T>(Arrays.asList(charSequenceArr))));
        this.f2458b.setChoiceMode(1);
        this.f2458b.setItemChecked(i, true);
    }

    public void setTitle(CharSequence charSequence) {
        this.f2460d = charSequence.toString();
        super.setTitle(charSequence);
    }

    public void setView(View view) {
        this.f2461e = view;
        super.setView(view);
    }

    public void show() {
        super.show();
    }
}
