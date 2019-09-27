package com.androlua;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.p021b.p022a.p023a.C0383c;
import com.p021b.p022a.p023a.C0403h;
import com.p021b.p022a.p023a.C0404i;
import com.p021b.p022a.p024b.C0408b.C0409a;
import com.p021b.p022a.p024b.C0410c;
import com.p021b.p022a.p024b.C0411d;
import com.p021b.p022a.p024b.C0412e;
import com.p021b.p022a.p024b.C0414f;
import com.p021b.p022a.p024b.C0416h;
import com.p021b.p022a.p024b.C0417i;
import com.p021b.p022a.p024b.C0419k;
import com.p021b.p022a.p024b.C0423l;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class LuaEditor extends C0383c {

    /* renamed from: A */
    private C0423l f2467A;

    /* renamed from: B */
    private int f2468B;

    /* renamed from: C */
    private String f2469C;

    /* renamed from: u */
    private boolean f2470u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Context f2471v;

    /* renamed from: w */
    private String f2472w;

    /* renamed from: x */
    private String f2473x = LuaApplication.getInstance().getLuaExtDir("fonts");

    /* renamed from: y */
    private String f2474y = LuaApplication.getInstance().getLuaExtPath("android.jar");

    /* renamed from: z */
    private int f2475z;

    @SuppressLint({"StaticFieldLeak"})
    public LuaEditor(Context context) {
        super(context);
        this.f2471v = context;
        setTypeface(Typeface.MONOSPACE);
        File file = new File(this.f2473x, "default.ttf");
        if (file.exists()) {
            setTypeface(Typeface.createFromFile(file));
        }
        File file2 = new File(this.f2473x, "bold.ttf");
        if (file2.exists()) {
            setBoldTypeface(Typeface.createFromFile(file2));
        }
        File file3 = new File(this.f2473x, "italic.ttf");
        if (file3.exists()) {
            setItalicTypeface(Typeface.createFromFile(file3));
        }
        setTextSize((int) TypedValue.applyDimension(2, (float) f2851d, context.getResources().getDisplayMetrics()));
        setShowLineNumbers(true);
        setHighlightCurrentRow(true);
        setWordWrap(false);
        setAutoIndentWidth(2);
        C0419k.m2666a(C0417i.m2650g());
        setNavigationMethod(isAccessibilityEnabled() ? new C0403h(this) : new C0404i(this));
        TypedArray obtainStyledAttributes = this.f2471v.getTheme().obtainStyledAttributes(new int[]{16842801, 16842806, 16842905});
        obtainStyledAttributes.getColor(0, 16711935);
        int color = obtainStyledAttributes.getColor(1, 16711935);
        int color2 = obtainStyledAttributes.getColor(2, 16711935);
        obtainStyledAttributes.recycle();
        setTextColor(color);
        setTextHighlightColor(color2);
    }

    public void addNames(String[] strArr) {
        C0417i iVar = (C0417i) C0419k.m2664a();
        String[] c = iVar.mo3021c();
        String[] strArr2 = new String[(c.length + strArr.length)];
        System.arraycopy(c, 0, strArr2, 0, c.length);
        System.arraycopy(strArr, 0, strArr2, c.length, strArr.length);
        iVar.mo3014b(strArr2);
        C0419k.m2666a((C0416h) iVar);
        respan();
        invalidate();
    }

    public void addPackage(String str, String[] strArr) {
        C0417i iVar = (C0417i) C0419k.m2664a();
        iVar.mo3006a(str, strArr);
        C0419k.m2666a((C0416h) iVar);
        respan();
        invalidate();
    }

    public boolean findNext(String str) {
        if (!str.equals(this.f2469C)) {
            this.f2469C = str;
            this.f2468B = 0;
        }
        this.f2467A = new C0423l();
        String str2 = this.f2469C;
        if (str2.isEmpty()) {
            selectText(false);
            return false;
        }
        this.f2468B = this.f2467A.mo3044a(getText(), str2, this.f2468B, getText().length(), false, false);
        if (this.f2468B == -1) {
            selectText(false);
            Toast.makeText(this.f2471v, "未找到", 0).show();
            this.f2468B = 0;
            return false;
        }
        setSelection(this.f2468B, this.f2469C.length());
        this.f2468B += this.f2469C.length();
        moveCaret(this.f2468B);
        return true;
    }

    public String getFilePath() {
        return this.f2472w;
    }

    public String getSelectedText() {
        return this.f2885h.subSequence(getSelectionStart(), getSelectionEnd() - getSelectionStart()).toString();
    }

    public C0414f getText() {
        return createDocumentProvider();
    }

    public void gotoLine() {
        startGotoMode();
    }

    public void gotoLine(int i) {
        if (i > this.f2885h.mo2989f()) {
            i = this.f2885h.mo2989f();
        }
        setSelection(getText().mo2987e(i - 1));
    }

    public void insert(int i, String str) {
        selectText(false);
        moveCaret(i);
        paste(str);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState() & -28673)) {
            if (i == 29) {
                selectAll();
                return true;
            } else if (i == 31) {
                copy();
                return true;
            } else if (i == 35) {
                gotoLine();
                return true;
            } else if (i == 40) {
                format();
                return true;
            } else if (i == 47) {
                search();
                return true;
            } else if (i == 50) {
                paste();
                return true;
            } else if (i == 52) {
                cut();
                return true;
            }
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2475z != 0 && i3 > 0) {
            moveCaret(this.f2475z);
            this.f2475z = 0;
        }
    }

    public void open(String str) {
        this.f2472w = str;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
            sb.append("\n");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        setText(sb);
    }

    public void redo() {
        int m = createDocumentProvider().mo2999m();
        if (m >= 0) {
            setEdited(true);
            respan();
            selectText(false);
            moveCaret(m);
            invalidate();
        }
    }

    public void removePackage(String str) {
        C0417i iVar = (C0417i) C0419k.m2664a();
        iVar.mo3013b(str);
        C0419k.m2666a((C0416h) iVar);
        respan();
        invalidate();
    }

    public boolean save() {
        return save(this.f2472w);
    }

    public boolean save(String str) {
        if (str == null) {
            return true;
        }
        File file = new File(str);
        if (file.exists() && !file.canWrite()) {
            return false;
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
        bufferedWriter.write(getText().toString());
        bufferedWriter.close();
        return true;
    }

    public void search() {
        startFindMode();
    }

    public void setBackgoudColor(int i) {
        getColorScheme().mo2958a(C0409a.BACKGROUND, i);
    }

    public void setBasewordColor(int i) {
        getColorScheme().mo2958a(C0409a.NAME, i);
    }

    public void setCommentColor(int i) {
        getColorScheme().mo2958a(C0409a.COMMENT, i);
    }

    public void setDark(boolean z) {
        setColorScheme(z ? new C0410c() : new C0411d());
    }

    public void setKeywordColor(int i) {
        getColorScheme().mo2958a(C0409a.KEYWORD, i);
    }

    public void setPanelBackgroundColor(int i) {
        this.f2896s.mo2733b(i);
    }

    public void setPanelTextColor(int i) {
        this.f2896s.mo2729a(i);
    }

    public void setSelection(int i) {
        selectText(false);
        if (!hasLayout()) {
            moveCaret(i);
        } else {
            this.f2475z = i;
        }
    }

    public void setStringColor(int i) {
        getColorScheme().mo2958a(C0409a.STRING, i);
    }

    public void setText(CharSequence charSequence) {
        C0412e eVar = new C0412e(this);
        eVar.mo2962a(this.f2470u);
        eVar.mo2961a(charSequence);
        setDocumentProvider(new C0414f(eVar));
    }

    public void setText(CharSequence charSequence, boolean z) {
        replaceText(0, getLength() - 1, charSequence.toString());
    }

    public void setTextColor(int i) {
        getColorScheme().mo2958a(C0409a.FOREGROUND, i);
    }

    public void setTextHighlightColor(int i) {
        getColorScheme().mo2958a(C0409a.SELECTION_BACKGROUND, i);
    }

    public void setUserwordColor(int i) {
        getColorScheme().mo2958a(C0409a.LITERAL, i);
    }

    public void setWordWrap(boolean z) {
        this.f2470u = z;
        super.setWordWrap(z);
    }

    public void startFindMode() {
        startActionMode(new Callback() {

            /* renamed from: b */
            private C0423l f2482b;
            /* access modifiers changed from: private */

            /* renamed from: c */
            public int f2483c;

            /* renamed from: d */
            private EditText f2484d;

            /* access modifiers changed from: private */
            /* renamed from: a */
            public void m2215a() {
                this.f2482b = new C0423l();
                String obj = this.f2484d.getText().toString();
                if (obj.isEmpty()) {
                    LuaEditor.this.selectText(false);
                    return;
                }
                this.f2483c = this.f2482b.mo3044a(LuaEditor.this.getText(), obj, this.f2483c, LuaEditor.this.getText().length(), false, false);
                if (this.f2483c == -1) {
                    LuaEditor.this.selectText(false);
                    Toast.makeText(LuaEditor.this.f2471v, "未找到", 0).show();
                    this.f2483c = 0;
                    return;
                }
                LuaEditor.this.setSelection(this.f2483c, this.f2484d.getText().length());
                this.f2483c += this.f2484d.getText().length();
                LuaEditor.this.moveCaret(this.f2483c);
            }

            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case 2:
                        m2215a();
                        break;
                }
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                actionMode.setTitle("搜索");
                actionMode.setSubtitle(null);
                this.f2484d = new EditText(LuaEditor.this.f2471v) {
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        if (charSequence.length() > 0) {
                            C03332.this.f2483c = 0;
                            C03332.this.m2215a();
                        }
                    }
                };
                this.f2484d.setSingleLine(true);
                this.f2484d.setImeOptions(3);
                this.f2484d.setOnEditorActionListener(new OnEditorActionListener() {
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        C03332.this.m2215a();
                        return true;
                    }
                });
                this.f2484d.setLayoutParams(new LayoutParams(LuaEditor.this.getWidth() / 3, -1));
                menu.add(0, 1, 0, BuildConfig.FLAVOR).setActionView(this.f2484d);
                menu.add(0, 2, 0, LuaEditor.this.f2471v.getString(17039372));
                this.f2484d.requestFocus();
                return true;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
    }

    public void startGotoMode() {
        startActionMode(new Callback() {
            /* access modifiers changed from: private */

            /* renamed from: b */
            public int f2477b;

            /* renamed from: c */
            private EditText f2478c;

            /* access modifiers changed from: private */
            /* renamed from: a */
            public void m2212a() {
                String obj = this.f2478c.getText().toString();
                if (!obj.isEmpty()) {
                    int intValue = Integer.valueOf(obj).intValue();
                    if (intValue > LuaEditor.this.f2885h.mo2989f()) {
                        intValue = LuaEditor.this.f2885h.mo2989f();
                    }
                    LuaEditor.this.gotoLine(intValue);
                }
            }

            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case 2:
                        m2212a();
                        break;
                }
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                actionMode.setTitle("转到");
                actionMode.setSubtitle(null);
                this.f2478c = new EditText(LuaEditor.this.f2471v) {
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        if (charSequence.length() > 0) {
                            C03301.this.f2477b = 0;
                            C03301.this.m2212a();
                        }
                    }
                };
                this.f2478c.setSingleLine(true);
                this.f2478c.setInputType(2);
                this.f2478c.setImeOptions(2);
                this.f2478c.setOnEditorActionListener(new OnEditorActionListener() {
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        C03301.this.m2212a();
                        return true;
                    }
                });
                this.f2478c.setLayoutParams(new LayoutParams(LuaEditor.this.getWidth() / 3, -1));
                menu.add(0, 1, 0, BuildConfig.FLAVOR).setActionView(this.f2478c);
                menu.add(0, 2, 0, LuaEditor.this.f2471v.getString(17039370));
                this.f2478c.requestFocus();
                return true;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
    }

    public void undo() {
        int l = createDocumentProvider().mo2997l();
        if (l >= 0) {
            setEdited(true);
            respan();
            selectText(false);
            moveCaret(l);
            invalidate();
        }
    }
}
