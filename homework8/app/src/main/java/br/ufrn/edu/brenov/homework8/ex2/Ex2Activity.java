package br.ufrn.edu.brenov.homework8.ex2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.ufrn.edu.brenov.homework8.R;

public class Ex2Activity extends AppCompatActivity {

    private Intent intent;
    private TextView textView;
    private RandomizerService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        // Get view
        this.textView = findViewById(R.id.txt_value);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Start service
        this.intent = new Intent(getApplicationContext(), RandomizerService.class);
        startService(this.intent);
        RandimizerServiceConnection connection = new RandimizerServiceConnection();
        bindService(this.intent, connection, 0);
    }

    @Override
    protected void onDestroy() {
        this.service.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.service.onUnbind(this.intent);
    }

    public void getValue(View view) {
        this.textView.setText(String.valueOf(this.service.getNumber()));
    }

    public class RandimizerServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            RandomizerService.RandomizerServiceBinder binder = (RandomizerService.RandomizerServiceBinder) iBinder;
            Ex2Activity.this.service = binder.getService();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // empty
        }
    }
}
