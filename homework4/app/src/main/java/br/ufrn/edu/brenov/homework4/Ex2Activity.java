package br.ufrn.edu.brenov.homework4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Ex2Activity extends Activity {

    private ProgressBar progress;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        progress = findViewById(R.id.progress);
        button = findViewById(R.id.start);
    }

    public void start(View view) {
        ProgressTask task = new ProgressTask(progress, button);
        task.execute(100);
    }
}
