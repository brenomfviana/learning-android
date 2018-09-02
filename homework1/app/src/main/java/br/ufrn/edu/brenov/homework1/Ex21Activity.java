package br.ufrn.edu.brenov.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Ex21Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex21);
        setTitle("Exercise 2");
        Log.i("Exercise2", "onCreate()/2.1");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Exercise2", "onStart()/2.1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Exercise2", "onResume()/2.1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Exercise2", "onPause()/2.1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Exercise2", "onStop()/2.1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Exercise2", "onRestart()/2.1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Exercise2", "onDestroy()/2.1");
    }

    public void next(View view) {
        Intent intent = new Intent(this, Ex22Activity.class);
        startActivity(intent);
    }
}
