package android.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayExpandableListAdapter extends BaseExpandableListAdapter {

    /* renamed from: a */
    private Context f34a;

    /* renamed from: b */
    private List<List<String>> f35b;

    /* renamed from: c */
    private List<String> f36c;

    /* renamed from: d */
    private int f37d;

    /* renamed from: e */
    private int f38e;

    /* renamed from: f */
    private LayoutInflater f39f;

    /* renamed from: g */
    private boolean f40g;

    public ArrayExpandableListAdapter(Context context) {
        this(context, new ArrayList(), 17367046, new ArrayList(), 17367046);
    }

    public ArrayExpandableListAdapter(Context context, List<String> list, int i, List<List<String>> list2, int i2) {
        this.f40g = true;
        this.f34a = context;
        this.f36c = list;
        this.f37d = i;
        this.f35b = list2;
        this.f38e = i2;
        this.f39f = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ArrayExpandableListAdapter(Context context, List<String> list, List<List<String>> list2) {
        this(context, list, 17367046, list2, 17367046);
    }

    public void add(String str, List<String> list) {
        this.f36c.add(str);
        this.f35b.add(list);
        if (this.f40g) {
            notifyDataSetChanged();
        }
    }

    public void add(String str, String[] strArr) {
        this.f36c.add(str);
        this.f35b.add(Arrays.asList(strArr));
        if (this.f40g) {
            notifyDataSetChanged();
        }
    }

    public Object getChild(int i, int i2) {
        return ((List) this.f35b.get(i)).get(i2);
    }

    public long getChildId(int i, int i2) {
        return 0;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f39f.inflate(this.f38e, viewGroup, false);
        }
        ((TextView) view).setText((CharSequence) ((List) this.f35b.get(i)).get(i2));
        return view;
    }

    public int getChildrenCount(int i) {
        return ((List) this.f35b.get(i)).size();
    }

    public Object getGroup(int i) {
        return this.f36c.get(i);
    }

    public int getGroupCount() {
        return this.f36c.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f39f.inflate(this.f37d, viewGroup, false);
        }
        ((TextView) view).setText((CharSequence) this.f36c.get(i));
        return view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public void setNotifyOnChange(boolean z) {
        this.f40g = z;
    }
}
