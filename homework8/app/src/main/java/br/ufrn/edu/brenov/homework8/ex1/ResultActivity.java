package br.ufrn.edu.brenov.homework8.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.ufrn.edu.brenov.homework8.R;

public class ResultActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // Get text view
        this.textView = findViewById(R.id.txt_result);
        // Get and show PI value
        Intent it = getIntent();
        Double result = it.getExtras().getDouble("pivalue");
        this.textView.setText("π = " + String.valueOf(result));
    }
}
