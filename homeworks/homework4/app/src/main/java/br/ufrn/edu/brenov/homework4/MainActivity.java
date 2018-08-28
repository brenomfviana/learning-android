package br.ufrn.edu.brenov.homework4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

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
