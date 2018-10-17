package br.ufrn.edu.brenov.homework6;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class ItemListAdapter extends BaseAdapter {

    Context context;
    private ArrayAdapter<String> adapter;

    public ItemListAdapter(Context context) {
        this.context = context;
        this.adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1);
    }

    public void addItem(String name) {
        this.adapter.add(name);
    }

    public void editItem(int index, String name) {
        this.removeItem(index);
        this.adapter.insert(name, index);
    }

    public void removeItem(int index) {
        this.adapter.remove(this.adapter.getItem(index));
    }

    @Override
    public int getCount() {
        return this.adapter.getCount();
    }

    @Override
    public Object getItem(int i) {
        return this.adapter.getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return this.adapter.getItemId(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.adapter.getView(i, view, viewGroup);
    }
}
