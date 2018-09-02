package br.ufrn.edu.brenov.homework1;

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

    public void nextEx1(View view) {
        Intent intent = new Intent(this, Ex1Activity.class);
        startActivity(intent);
    }

    public void nextEx2(View view) {
        Intent intent = new Intent(this, Ex21Activity.class);
        startActivity(intent);
    }

    public void nextEx3(View view) {
        Intent intent = new Intent(this, Ex31Activity.class);
        startActivity(intent);
    }
}
