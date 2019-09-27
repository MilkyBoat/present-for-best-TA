package com.p021b.p022a.p023a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import com.androlua.BuildConfig;
import com.p021b.p022a.p024b.C0415g;
import com.p021b.p022a.p024b.C0416h;
import com.p021b.p022a.p024b.C0418j;
import java.util.ArrayList;

/* renamed from: com.b.a.a.a */
public class C0377a {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static C0416h f2825c = C0418j.m2655g();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0383c f2826a;

    /* renamed from: b */
    private Context f2827b;

    /* renamed from: d */
    private ListPopupWindow f2828d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0379a f2829e;

    /* renamed from: f */
    private Filter f2830f;

    /* renamed from: g */
    private int f2831g;

    /* renamed from: h */
    private int f2832h;

    /* renamed from: i */
    private int f2833i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CharSequence f2834j;

    /* renamed from: k */
    private int f2835k;

    /* renamed from: l */
    private GradientDrawable f2836l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f2837m;

    /* renamed from: com.b.a.a.a$a */
    class C0379a extends ArrayAdapter<String> implements Filterable {

        /* renamed from: b */
        private int f2840b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C0415g f2841c = new C0415g();

        /* renamed from: d */
        private DisplayMetrics f2842d;

        public C0379a(Context context, int i) {
            super(context, i);
            setNotifyOnChange(false);
            this.f2842d = context.getResources().getDisplayMetrics();
        }

        /* renamed from: a */
        public void mo2736a() {
            this.f2841c.mo3002a();
        }

        /* renamed from: b */
        public void mo2737b() {
            this.f2841c.mo3003b();
        }

        /* renamed from: c */
        public int mo2738c() {
            if (this.f2840b != 0) {
                return this.f2840b;
            }
            TextView textView = (TextView) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(17367043, null);
            textView.measure(0, 0);
            this.f2840b = textView.getMeasuredHeight();
            return this.f2840b;
        }

        public Filter getFilter() {
            return new Filter() {
                /* access modifiers changed from: protected */
                public FilterResults performFiltering(CharSequence charSequence) {
                    String str;
                    String[] b;
                    String[] d;
                    ArrayList arrayList = new ArrayList();
                    String lowerCase = String.valueOf(charSequence).toLowerCase();
                    String[] split = lowerCase.split("\\.");
                    int i = 0;
                    if (split.length == 2) {
                        String str2 = split[0];
                        str = split[1];
                        if (C0377a.f2825c.mo3030f(str2)) {
                            String[] a = C0377a.f2825c.mo3012a(str2);
                            int length = a.length;
                            while (i < length) {
                                String str3 = a[i];
                                if (str3.toLowerCase().startsWith(str)) {
                                    arrayList.add(str3);
                                }
                                i++;
                            }
                        }
                    } else {
                        if (split.length == 1) {
                            if (lowerCase.charAt(lowerCase.length() - 1) == '.') {
                                String substring = lowerCase.substring(0, lowerCase.length() - 1);
                                str = BuildConfig.FLAVOR;
                                if (C0377a.f2825c.mo3030f(substring)) {
                                    String[] a2 = C0377a.f2825c.mo3012a(substring);
                                    int length2 = a2.length;
                                    while (i < length2) {
                                        arrayList.add(a2[i]);
                                        i++;
                                    }
                                }
                            } else {
                                for (String str4 : C0377a.f2825c.mo3017b()) {
                                    if (str4.toLowerCase().startsWith(lowerCase)) {
                                        arrayList.add(str4);
                                    }
                                }
                                for (String str5 : C0377a.f2825c.mo3024d()) {
                                    if (str5.indexOf(lowerCase) == 0) {
                                        arrayList.add(str5);
                                    }
                                }
                                String[] c = C0377a.f2825c.mo3021c();
                                int length3 = c.length;
                                while (i < length3) {
                                    String str6 = c[i];
                                    if (str6.toLowerCase().startsWith(lowerCase)) {
                                        arrayList.add(str6);
                                    }
                                    i++;
                                }
                            }
                        }
                        str = lowerCase;
                    }
                    C0377a.this.f2834j = str;
                    FilterResults filterResults = new FilterResults();
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                    return filterResults;
                }

                /* access modifiers changed from: protected */
                public void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    if (filterResults == null || filterResults.count <= 0 || C0379a.this.f2841c.mo3004c()) {
                        C0379a.this.notifyDataSetInvalidated();
                        return;
                    }
                    C0379a.this.clear();
                    C0379a.this.addAll((ArrayList) filterResults.values);
                    int caretY = (C0377a.this.f2826a.getCaretY() + (C0377a.this.f2826a.mo2751a() / 2)) - C0377a.this.f2826a.getScrollY();
                    C0377a.this.m2397d(C0379a.this.mo2738c() * Math.min(2, filterResults.count));
                    C0377a.this.m2398e(C0377a.this.f2826a.getCaretX() - C0377a.this.f2826a.getScrollX());
                    C0377a.this.m2399f(caretY - C0377a.this.f2826a.getHeight());
                    C0379a.this.notifyDataSetChanged();
                    C0377a.this.mo2728a();
                }
            };
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getView(i, view, viewGroup);
            textView.setTextColor(C0377a.this.f2837m);
            return textView;
        }
    }

    public C0377a(C0383c cVar) {
        this.f2826a = cVar;
        this.f2827b = cVar.getContext();
        m2396d();
    }

    /* renamed from: d */
    private void m2396d() {
        this.f2828d = new ListPopupWindow(this.f2827b);
        this.f2828d.setAnchorView(this.f2826a);
        this.f2829e = new C0379a(this.f2827b, 17367043);
        this.f2828d.setAdapter(this.f2829e);
        this.f2830f = this.f2829e.getFilter();
        m2397d(300);
        TypedArray obtainStyledAttributes = this.f2827b.getTheme().obtainStyledAttributes(new int[]{16842801, 16842806});
        int color = obtainStyledAttributes.getColor(0, 16711935);
        int color2 = obtainStyledAttributes.getColor(1, 16711935);
        obtainStyledAttributes.recycle();
        this.f2836l = new GradientDrawable();
        this.f2836l.setColor(color);
        this.f2836l.setCornerRadius(4.0f);
        this.f2836l.setStroke(1, color2);
        mo2729a(color2);
        this.f2828d.setBackgroundDrawable(this.f2836l);
        this.f2828d.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C0377a.this.f2826a.replaceText(C0377a.this.f2826a.getCaretPosition() - C0377a.this.f2834j.length(), C0377a.this.f2834j.length(), ((TextView) view).getText().toString());
                C0377a.this.f2829e.mo2736a();
                C0377a.this.mo2732b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2397d(int i) {
        if (this.f2832h != i) {
            this.f2832h = i;
            this.f2828d.setHeight(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2398e(int i) {
        int min = Math.min(i, this.f2826a.getWidth() / 2);
        if (this.f2833i != min) {
            this.f2833i = min;
            this.f2828d.setHorizontalOffset(min);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2399f(int i) {
        int height = 0 - this.f2828d.getHeight();
        if (i > height) {
            this.f2826a.scrollBy(0, i - height);
            i = height;
        }
        if (this.f2831g != i) {
            this.f2831g = i;
            this.f2828d.setVerticalOffset(i);
        }
    }

    /* renamed from: a */
    public void mo2728a() {
        if (!this.f2828d.isShowing()) {
            this.f2828d.show();
        }
        this.f2828d.getListView().setFadingEdgeLength(0);
    }

    /* renamed from: a */
    public void mo2729a(int i) {
        this.f2837m = i;
        this.f2836l.setStroke(1, i);
        this.f2828d.setBackgroundDrawable(this.f2836l);
    }

    /* renamed from: a */
    public synchronized void mo2730a(C0416h hVar) {
        f2825c = hVar;
    }

    /* renamed from: a */
    public void mo2731a(CharSequence charSequence) {
        this.f2829e.mo2737b();
        this.f2830f.filter(charSequence);
    }

    /* renamed from: b */
    public void mo2732b() {
        if (this.f2828d.isShowing()) {
            this.f2828d.dismiss();
        }
    }

    /* renamed from: b */
    public void mo2733b(int i) {
        this.f2835k = i;
        this.f2836l.setColor(i);
        this.f2828d.setBackgroundDrawable(this.f2836l);
    }

    /* renamed from: c */
    public void mo2734c(int i) {
        this.f2828d.setWidth(i);
    }
}
