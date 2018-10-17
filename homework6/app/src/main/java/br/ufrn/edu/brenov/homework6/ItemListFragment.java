package br.ufrn.edu.brenov.homework6;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ItemListFragment extends ListFragment implements AbsListView.MultiChoiceModeListener {

    private ListView listView;
    private List<Integer> selected = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.listView = view.findViewById(android.R.id.list);
        this.listView.setMultiChoiceModeListener(this);
        this.listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        return view;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
        View view = this.listView.getChildAt(i);
        if (b) {
            // Update color
            view.setBackgroundColor(Color.CYAN);
            // Select item
            this.selected.add(i);
        } else {
            // Update color
            view.setBackgroundColor(Color.TRANSPARENT);
            // Deselect item
            this.selected.remove(new Integer(i));
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.edit_item:
                for (final int i : this.selected) {
                    EditDialog.show(getActivity().getSupportFragmentManager(),
                            new EditDialog.OnTextListener() {
                        @Override
                        public void onSetText(String text) {
                            ((ItemListAdapter) getListAdapter()).editItem(i, text);
                        }
                    });
                    // Update color
                    this.listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                break;
            case R.id.delete_item:
                for (int i : this.selected) {
                    // Update color
                    this.listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    // Remove item
                    ((ItemListAdapter) getListAdapter()).removeItem(i);
                }
                break;
            default:
                return false;
        }
        this.selected.clear();
        actionMode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        int count = this.listView.getChildCount();
        for(int i = 0; i <count;i++){
            View view = this.listView.getChildAt(i);
            view.setBackgroundColor(Color.TRANSPARENT);
        }
        this.selected.clear();
    }
}
