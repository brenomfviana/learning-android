package br.ufrn.edu.brenov.homework8.ex1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;

import br.ufrn.edu.brenov.homework8.NotificationUtils;

public class PICalculatorService extends Service {

    private PICalculator calculator;

    @Override
    public void onCreate() {
        super.onCreate();
        this.calculator = new PICalculator();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Start to calculate PI value
        Thread pi = new Thread(this.calculator);
        pi.start();
        // Wait for PI value
        while (this.calculator.get() == 0);
        // Notify user
        Notification.Builder builder = new Notification.Builder(this, NotificationUtils.getChannelId(this));
        builder.setContentTitle("PI Calculator");
        builder.setContentText("π calculation was finalized!");
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        // Create intent to show result
        Intent it = new Intent(this, ResultActivity.class);
        it.putExtra("pivalue", calculator.get());
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 , it, 0);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        // Show notification
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(50, notification);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
