package br.ufrn.edu.brenov.homework6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ItemListAdapter adapter;
    private ItemListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.adapter = new ItemListAdapter(getApplicationContext());
        for (int i = 0; i < 10; i++) {
            this.adapter.addItem("Example" + i);
        }
        this.fragment = (ItemListFragment) getSupportFragmentManager().findFragmentById(R.id.frag_list);
        this.fragment.setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                EditDialog.show(getSupportFragmentManager(), new EditDialog.OnTextListener() {
                    @Override
                    public void onSetText(String text) {
                        adapter.addItem(text);
                        adapter.notifyDataSetChanged();
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
