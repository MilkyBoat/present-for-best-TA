package android.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPageAdapter extends BasePageAdapter {
    public ArrayList<View> mListViews;

    public ArrayPageAdapter() {
        this.mListViews = new ArrayList<>();
    }

    public ArrayPageAdapter(ArrayList<View> arrayList) {
        this.mListViews = arrayList;
    }

    public ArrayPageAdapter(View[] viewArr) {
        this.mListViews = new ArrayList<>(Arrays.asList(viewArr));
    }

    public void add(View view) {
        this.mListViews.add(view);
    }

    public void destroyItem(View view, int i, Object obj) {
        ((PageView) view).removeView((View) this.mListViews.get(i));
    }

    public int getCount() {
        return this.mListViews.size();
    }

    public ArrayList<View> getData() {
        return this.mListViews;
    }

    public View getItem(int i) {
        return (View) this.mListViews.get(i);
    }

    public void insert(int i, View view) {
        this.mListViews.add(i, view);
    }

    public Object instantiateItem(View view, int i) {
        ((PageView) view).addView((View) this.mListViews.get(i), 0);
        return this.mListViews.get(i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public View remove(int i) {
        return (View) this.mListViews.remove(i);
    }

    public boolean remove(View view) {
        return this.mListViews.remove(view);
    }
}
