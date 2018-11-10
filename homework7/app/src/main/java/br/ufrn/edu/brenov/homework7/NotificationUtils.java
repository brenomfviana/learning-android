package br.ufrn.edu.brenov.homework7;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class NotificationUtils {

    private static final String CHANNEL_ID = "br.ufrn.imd.android.channel";
    private static final String CHANNEL_NAME = "Power Channel";

    public static String getChannelId(Context context) {
        // Check Android version
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return CHANNEL_ID;
        }
        // Get channel if exists
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = manager.getNotificationChannel(CHANNEL_ID);
        // If the channel is not created
        if(channel == null) {
            // Create notification channel
            channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        return CHANNEL_ID;
    }
}
