package br.ufrn.edu.brenov.homework3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChangeValueActivity extends Activity {

    private int type = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_value);
        TextView item = findViewById(R.id.item);
        // Get type of content
        Bundle params = getIntent().getExtras();
        if (params.getString("type").equals("weight")) {
            item.setText("Alterar peso:");
            this.type = 1;
        } else if (params.getString("type").equals("height")) {
            item.setText("Alterar altura:");
            this.type = 2;
        }
    }

    public void confirm(View view) {
        // Get new value
        TextView value = findViewById(R.id.new_value);
        Intent intent = new Intent(this, MainActivity.class);
        Bundle params = new Bundle();
        // Check type
        if (this.type == 1) {
            params.putString("weight", String.valueOf(value.getText()));
            intent.putExtras(params);
            setResult(3, intent);
        } else if (this.type == 2) {
            params.putString("height", String.valueOf(value.getText()));
            intent.putExtras(params);
            setResult(4, intent);
        }
        finish();
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        // Send counter
        setResult(0, intent);
        finish();
    }
}
