package br.ufrn.edu.brenov.homework8.ex2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class RandomizerService extends Service {

    private Randomizer randomizer;
    private RandomizerServiceBinder binder = new RandomizerServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        this.randomizer = new Randomizer();
        Log.i("Ex2", "The service was created.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(this.randomizer).start();
        Log.i("Ex2", "Random generation has started.");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Ex2", "Bind");
        return this.binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        this.randomizer.stop();
        Log.i("Ex2", "Unbind");
        return super.onUnbind(intent);
    }

    public double getNumber() {
        return this.randomizer.getNumber();
    }

    public class RandomizerServiceBinder extends Binder {
        public RandomizerService getService() {
            return RandomizerService.this;
        }
    }
}
