package br.ufrn.edu.brenov.homework5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.ufrn.edu.brenov.homework5.exercise1.Exercise1Activity;
import br.ufrn.edu.brenov.homework5.exercise2.Exercise2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exercise1(View view) {
        Intent intent = new Intent(this, Exercise1Activity.class);
        startActivity(intent);
    }

    public void exercise2(View view) {
        Intent intent = new Intent(this, Exercise2Activity.class);
        startActivity(intent);
    }
}
