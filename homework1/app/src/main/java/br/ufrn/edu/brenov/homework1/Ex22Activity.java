package br.ufrn.edu.brenov.homework1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Ex22Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex22);
        setTitle("Exercise 2.2");
        Log.i("Exercise2", "onCreate()/2.2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Exercise2", "onStart()/2.2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Exercise2", "onResume()/2.2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Exercise2", "onPause()/2.2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Exercise2", "onStop()/2.2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Exercise2", "onRestart()/2.2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Exercise2", "onDestroy()/2.2");
    }
}
