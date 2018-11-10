package br.ufrn.edu.brenov.homework7;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private PowerReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize broadcast receiver
        this.receiver = new PowerReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        // Add receiver
        registerReceiver(this.receiver, filter);
    }

    @Override
    protected void onDestroy() {
        if(this.receiver != null) {
            unregisterReceiver(this.receiver);
        }
        super.onDestroy();
    }
}
