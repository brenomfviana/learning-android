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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemListFragment extends ListFragment implements ActionMode.Callback {

    private ListView listView;
    private ActionMode actionMode;
    private int selected = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.listView = view.findViewById(android.R.id.list);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        return view;
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.actions, menu);
        this.actionMode = actionMode;
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (this.selected < 0) {
            return false;
        }
        Toast.makeText(getActivity(), "Selected " + selected, Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId()) {
            case R.id.edit_item:
                final int sel = selected;
                EditDialog.show(getActivity().getSupportFragmentManager(),
                        new EditDialog.OnTextListener() {
                            @Override
                            public void onSetText(String text) {
                                ((ItemListAdapter) getListAdapter()).editItem(sel, text);
                            }
                        });
                // Update color
                this.listView.getChildAt(this.selected).setBackgroundColor(Color.TRANSPARENT);
                break;
            case R.id.delete_item:
                // Update color
                this.listView.getChildAt(this.selected).setBackgroundColor(Color.TRANSPARENT);
                // Remove item
                ((ItemListAdapter) getListAdapter()).removeItem(this.selected);
                break;
            default:
                return false;
        }
        actionMode.finish();
        ((ItemListAdapter) getListAdapter()).notifyDataSetChanged();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        int count = this.listView.getChildCount();
        for(int i = 0; i <count;i++){
            View view = this.listView.getChildAt(i);
            view.setBackgroundColor(Color.TRANSPARENT);
        }
        this.selected = -1;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int i, long l) {
        if (this.selected == -1) {
            // Update color
            view.setBackgroundColor(Color.CYAN);
            // Select item
            this.selected = i;
            getActivity().startActionMode(this);
        } else if (this.selected == i) {
            // Update color
            view.setBackgroundColor(Color.TRANSPARENT);
            // Deselect item
            this.selected = -1;
            this.actionMode.finish();
        }
    }
}
