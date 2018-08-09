package br.ufrn.edu.la.learningandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button day1btn = findViewById(R.id.day1);
        View.OnClickListener button_click = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Day 1", Toast.LENGTH_SHORT).show();
            }
        };
        day1btn.setOnClickListener(button_click);
    }
}
