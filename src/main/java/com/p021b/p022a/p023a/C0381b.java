package com.p021b.p022a.p023a;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: com.b.a.a.b */
public class C0381b {

    /* renamed from: a */
    protected C0383c f2844a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f2845b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ActionMode f2846c;

    public C0381b(C0383c cVar) {
        this.f2844a = cVar;
        this.f2845b = cVar.getContext();
    }

    /* renamed from: a */
    public void mo2743a() {
        mo2745c();
    }

    /* renamed from: b */
    public void mo2744b() {
        mo2746d();
    }

    /* renamed from: c */
    public void mo2745c() {
        if (this.f2846c == null) {
            this.f2844a.startActionMode(new Callback() {
                public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            C0381b.this.f2844a.selectAll();
                            break;
                        case 1:
                            C0381b.this.f2844a.cut();
                            break;
                        case 2:
                            C0381b.this.f2844a.copy();
                            break;
                        case 3:
                            C0381b.this.f2844a.paste();
                            break;
                    }
                    actionMode.finish();
                    return false;
                }

                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    C0381b.this.f2846c = actionMode;
                    actionMode.setTitle(17039382);
                    TypedArray obtainStyledAttributes = C0381b.this.f2845b.getTheme().obtainStyledAttributes(new int[]{16843646, 16843537, 16843538, 16843539});
                    menu.add(0, 0, 0, C0381b.this.f2845b.getString(17039373)).setShowAsActionFlags(2).setAlphabeticShortcut('a').setIcon(obtainStyledAttributes.getDrawable(0));
                    menu.add(0, 1, 0, C0381b.this.f2845b.getString(17039363)).setShowAsActionFlags(2).setAlphabeticShortcut('x').setIcon(obtainStyledAttributes.getDrawable(1));
                    menu.add(0, 2, 0, C0381b.this.f2845b.getString(17039361)).setShowAsActionFlags(2).setAlphabeticShortcut('c').setIcon(obtainStyledAttributes.getDrawable(2));
                    menu.add(0, 3, 0, C0381b.this.f2845b.getString(17039371)).setShowAsActionFlags(2).setAlphabeticShortcut('v').setIcon(obtainStyledAttributes.getDrawable(3));
                    obtainStyledAttributes.recycle();
                    return true;
                }

                public void onDestroyActionMode(ActionMode actionMode) {
                    C0381b.this.f2844a.selectText(false);
                    C0381b.this.f2846c = null;
                }

                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }
            });
        }
    }

    /* renamed from: d */
    public void mo2746d() {
        if (this.f2846c != null) {
            this.f2846c.finish();
            this.f2846c = null;
        }
    }
}
