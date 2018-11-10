package br.ufrn.edu.brenov.homework7;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    private Notification.Builder builder;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        // Get builder
        this.builder = new Notification.Builder(context, NotificationUtils.getChannelId(context));
        this.builder.setContentTitle("Power");
        this.builder.setContentText("A change in power connection occurred.");
        this.builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        // Check the power connection
        if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            // Create intent
            Intent it = new Intent(context, PowerDisconnectedActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, it, 0);
            this.builder.setContentIntent(pendingIntent);
            builder.setAutoCancel(true);
            // Show notification
            Notification notification = this.builder.build();
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(50, notification);
        } else if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            // Create intent
            Intent it = new Intent(context, PowerConnectedActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, it, 0);
            this.builder.setContentIntent(pendingIntent);
            builder.setAutoCancel(true);
            // Show notification
            Notification notification = this.builder.build();
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(50, notification);
        } else {
            // Create intent
            Intent it = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, it, 0);
            this.builder.setContentIntent(pendingIntent);
            builder.setAutoCancel(true);
            // Show notification
            Notification notification = this.builder.build();
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(50, notification);
            Toast.makeText(context, "An error has occurred in power connection checker.", Toast.LENGTH_SHORT).show();
        }
    }
}
