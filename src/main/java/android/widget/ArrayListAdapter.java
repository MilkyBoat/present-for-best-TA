package android.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter.FilterResults;
import com.luajava.LuaException;
import com.luajava.LuaFunction;
import com.p002a.p003a.p004a.p005a.p006a.p007a.C0029a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListAdapter<T> extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArrayList<T> f41a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f42b = new Object();

    /* renamed from: c */
    private int f43c;

    /* renamed from: d */
    private int f44d;

    /* renamed from: e */
    private int f45e = 0;

    /* renamed from: f */
    private boolean f46f = true;

    /* renamed from: g */
    private Context f47g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<T> f48h;

    /* renamed from: i */
    private ArrayFilter f49i;

    /* renamed from: j */
    private LayoutInflater f50j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LuaFunction f51k;

    private class ArrayFilter extends Filter {
        private ArrayFilter() {
        }

        /* access modifiers changed from: protected */
        public FilterResults performFiltering(CharSequence charSequence) {
            int i;
            ArrayList arrayList;
            ArrayList arrayList2;
            FilterResults filterResults = new FilterResults();
            if (ArrayListAdapter.this.f48h == null) {
                synchronized (ArrayListAdapter.this.f42b) {
                    ArrayListAdapter.this.f48h = new ArrayList(ArrayListAdapter.this.f41a);
                }
            } else if (TextUtils.isEmpty(charSequence)) {
                filterResults.values = new ArrayList(ArrayListAdapter.this.f48h);
                filterResults.count = ArrayListAdapter.this.f48h.size();
                ArrayListAdapter.this.f48h = null;
                return filterResults;
            }
            if (ArrayListAdapter.this.f51k != null) {
                ArrayList arrayList3 = new ArrayList();
                try {
                    ArrayListAdapter.this.f51k.call(new ArrayList(ArrayListAdapter.this.f48h), arrayList3, charSequence);
                } catch (LuaException e) {
                    C0029a.m806a(e);
                }
                filterResults.values = arrayList3;
                filterResults.count = arrayList3.size();
                return filterResults;
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (ArrayListAdapter.this.f42b) {
                    arrayList = new ArrayList(ArrayListAdapter.this.f48h);
                }
                filterResults.values = arrayList;
                i = arrayList.size();
            } else {
                String lowerCase = charSequence.toString().toLowerCase();
                synchronized (ArrayListAdapter.this.f42b) {
                    arrayList2 = new ArrayList(ArrayListAdapter.this.f48h);
                }
                int size = arrayList2.size();
                ArrayList arrayList4 = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj = arrayList2.get(i2);
                    if (obj.toString().toLowerCase().contains(lowerCase)) {
                        arrayList4.add(obj);
                    }
                }
                filterResults.values = arrayList4;
                i = arrayList4.size();
            }
            filterResults.count = i;
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, FilterResults filterResults) {
            ArrayListAdapter.this.f41a = (ArrayList) filterResults.values;
            if (filterResults.count > 0) {
                ArrayListAdapter.this.notifyDataSetChanged();
            } else {
                ArrayListAdapter.this.notifyDataSetInvalidated();
            }
        }
    }

    public ArrayListAdapter(Context context) {
        m16a(context, 17367043, 0, (List<T>) new ArrayList<T>());
    }

    public ArrayListAdapter(Context context, int i) {
        m16a(context, i, 0, (List<T>) new ArrayList<T>());
    }

    public ArrayListAdapter(Context context, int i, int i2) {
        m16a(context, i, i2, (List<T>) new ArrayList<T>());
    }

    public ArrayListAdapter(Context context, int i, int i2, List<T> list) {
        m16a(context, i, i2, list);
    }

    public ArrayListAdapter(Context context, int i, int i2, T[] tArr) {
        m16a(context, i, i2, Arrays.asList(tArr));
    }

    public ArrayListAdapter(Context context, int i, List<T> list) {
        m16a(context, i, 0, list);
    }

    public ArrayListAdapter(Context context, int i, T[] tArr) {
        m16a(context, i, 0, Arrays.asList(tArr));
    }

    public ArrayListAdapter(Context context, List<T> list) {
        m16a(context, 17367043, 0, list);
    }

    public ArrayListAdapter(Context context, T[] tArr) {
        m16a(context, 17367043, 0, Arrays.asList(tArr));
    }

    /* renamed from: a */
    private View m13a(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.f50j.inflate(i2, viewGroup, false);
        }
        try {
            TextView textView = this.f45e == 0 ? (TextView) view : (TextView) view.findViewById(this.f45e);
            Object item = getItem(i);
            textView.setText(item instanceof CharSequence ? (CharSequence) item : item.toString());
            return view;
        } catch (ClassCastException e) {
            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", e);
        }
    }

    /* renamed from: a */
    private void m16a(Context context, int i, int i2, List<T> list) {
        this.f47g = context;
        this.f50j = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f44d = i;
        this.f43c = i;
        this.f41a = new ArrayList<>(list);
        this.f45e = i2;
    }

    public static ArrayListAdapter<CharSequence> createFromResource(Context context, int i, int i2) {
        return new ArrayListAdapter<>(context, i2, (T[]) context.getResources().getTextArray(i));
    }

    public void add(T t) {
        synchronized (this.f42b) {
            (this.f48h != null ? this.f48h : this.f41a).add(t);
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }

    public void addAll(Collection<? extends T> collection) {
        synchronized (this.f42b) {
            (this.f48h != null ? this.f48h : this.f41a).addAll(collection);
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }

    public void addAll(T... tArr) {
        synchronized (this.f42b) {
            Collections.addAll(this.f48h != null ? this.f48h : this.f41a, tArr);
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        synchronized (this.f42b) {
            (this.f48h != null ? this.f48h : this.f41a).clear();
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }

    public void filter(CharSequence charSequence) {
        getFilter().filter(charSequence);
    }

    public Context getContext() {
        return this.f47g;
    }

    public int getCount() {
        return this.f41a.size();
    }

    public Object getData() {
        return this.f41a;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return m13a(i, view, viewGroup, this.f44d);
    }

    public Filter getFilter() {
        if (this.f49i == null) {
            this.f49i = new ArrayFilter<>();
        }
        return this.f49i;
    }

    public T getItem(int i) {
        return this.f41a.get(i);
    }

    public long getItemId(int i) {
        return (long) (i + 1);
    }

    public int getPosition(T t) {
        return this.f41a.indexOf(t);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m13a(i, view, viewGroup, this.f43c);
    }

    public void insert(int i, T t) {
        synchronized (this.f42b) {
            (this.f48h != null ? this.f48h : this.f41a).add(i, t);
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f46f = true;
    }

    public void remove(int i) {
        synchronized (this.f42b) {
            (this.f48h != null ? this.f48h : this.f41a).remove(i);
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }

    public void remove(T t) {
        synchronized (this.f42b) {
            (this.f48h != null ? this.f48h : this.f41a).remove(t);
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }

    public void setDropDownViewResource(int i) {
        this.f44d = i;
    }

    public void setFilter(LuaFunction luaFunction) {
        this.f51k = luaFunction;
    }

    public void setNotifyOnChange(boolean z) {
        this.f46f = z;
    }

    public void sort(Comparator<? super T> comparator) {
        synchronized (this.f42b) {
            Collections.sort(this.f48h != null ? this.f48h : this.f41a, comparator);
        }
        if (this.f46f) {
            notifyDataSetChanged();
        }
    }
}
