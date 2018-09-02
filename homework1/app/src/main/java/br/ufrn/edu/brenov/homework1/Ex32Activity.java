package br.ufrn.edu.brenov.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Ex32Activity extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex32);
        setTitle("Exercise 3.2");
        // Get counter
        Bundle params = getIntent().getExtras();
        int sum = Integer.parseInt(params.getString("counter")) + 1;
        String count = Integer.toString(sum);
        // Update button
        button = findViewById(R.id.button);
        button.setText(count);
    }

    public void back(View view) {
        Intent intent = new Intent(this, Ex31Activity.class);
        // Send counter
        Bundle params = new Bundle();
        params.putString("counter", button.getText().toString());
        intent.putExtras(params);
        setResult(32, intent);
        finish();
    }
}
