package br.ufrn.edu.brenov.homework4;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class CounterHandler extends Handler {

    private TextView textView;
    private Button button;

    public CounterHandler(TextView textView, Button button) {
        this.textView = textView;
        this.button = button;
    }

    @Override
    public void handleMessage(Message msg) {
            textView.setText(String.valueOf(msg.what));
            button.setEnabled(true);
    }
}