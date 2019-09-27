package android.widget;

import android.view.View;

public class PageAdapter extends BasePageAdapter {

    /* renamed from: a */
    private final Adapter f182a;

    /* renamed from: b */
    private View[] f183b;

    public PageAdapter(Adapter adapter) {
        this.f182a = adapter;
        this.f183b = new View[adapter.getViewTypeCount()];
    }

    public void destroyItem(View view, int i, Object obj) {
        View view2 = (View) obj;
        ((PageView) view).removeView(view2);
        this.f183b[this.f182a.getItemViewType(i)] = view2;
    }

    public int getCount() {
        return this.f182a.getCount();
    }

    public Object instantiateItem(View view, int i) {
        int itemViewType = this.f182a.getItemViewType(i);
        if (this.f183b[itemViewType] != null) {
            ((PageView) view).removeView(this.f183b[itemViewType]);
        }
        PageView pageView = (PageView) view;
        View view2 = this.f182a.getView(i, this.f183b[itemViewType], pageView);
        pageView.addView(view2, 0);
        this.f183b[itemViewType] = null;
        return view2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
