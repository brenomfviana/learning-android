package br.ufrn.edu.brenov.homework8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.ufrn.edu.brenov.homework8.ex1.Ex1Activity;
import br.ufrn.edu.brenov.homework8.ex2.Ex2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ex1(View view) {
        Intent intent = new Intent(this, Ex1Activity.class);
        startActivity(intent);
    }

    public void ex2(View view) {
        Intent intent = new Intent(this, Ex2Activity.class);
        startActivity(intent);
    }
}
