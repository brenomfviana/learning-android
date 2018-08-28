package br.ufrn.edu.brenov.homework4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ex1Activity extends Activity {

    private int count = 10;
    private CounterHandler ch;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
        textView = findViewById(R.id.txt_status);
        button = findViewById(R.id.start);
        ch = new CounterHandler(textView, button);
    }

    public void start(View view) {
        button.setEnabled(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > -1) {
                    SystemClock.sleep(1000);
                    Message msg = Message.obtain();
                    msg.what = count--;
                    ch.sendMessage(msg);
                }
            }
        }).start();
    }
}