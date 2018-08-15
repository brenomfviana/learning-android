package br.ufrn.edu.brenov.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ex31Activity extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex31);
        setTitle("Exercise 3.1");
        // Get button
        button = findViewById(R.id.button31);
        button.setText("1");
    }

    public void next(View view) {
        Intent intent = new Intent(this, Ex32Activity.class);
        // Send counter
        Bundle params = new Bundle();
        params.putString("counter", button.getText().toString());
        intent.putExtras(params);
        startActivityForResult(intent, 31);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check code
        if (resultCode == 32){
            // Get counter
            Bundle params = data.getExtras();
            int sum = Integer.parseInt(params.getString("counter")) + 1;
            String count = Integer.toString(sum);
            button.setText(count);
        }
    }
}
