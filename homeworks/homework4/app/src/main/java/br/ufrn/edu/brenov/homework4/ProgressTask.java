package br.ufrn.edu.brenov.homework4;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressTask extends AsyncTask<Integer, Integer, Void> {

    private ProgressBar progress;
    private Button button;

    public ProgressTask(ProgressBar progress, Button button) {
        this.progress = progress;
        this.button = button;
    }

    @Override
    protected Void doInBackground(Integer... params) {
        int max = params[0];
        for (int i = 0; i <= max; i++) {
            SystemClock.sleep(50);
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        this.button.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        this.button.setEnabled(true);
        SystemClock.sleep(1000);
        this.progress.setProgress(0);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int c = values[0];
        this.progress.setProgress(c);
    }
}
