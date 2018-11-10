package br.ufrn.edu.brenov.homework8.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import br.ufrn.edu.brenov.homework8.R;

public class Ex1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
    }

    public void calculate(View view) {
        Intent it = new Intent(getApplicationContext(), PICalculatorService.class);
        startService(it);
    }
}
