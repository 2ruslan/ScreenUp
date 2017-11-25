package kupchinskii.ruslan.screenup;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class MainService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected  void startForeground(int ico, String title, int notifyId) {
        if (Build.VERSION.SDK_INT < 11) {
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(ico)
                            .setContentTitle(title)
                            .setContentText("")
                            .setOnlyAlertOnce(true)
                            //    .setContentIntent(contentIntent)
                            .setOngoing(true);

            ;

            Notification notification = mBuilder.getNotification();
            notification.contentIntent = PendingIntent.getActivity(this,
                    0, new Intent(getApplicationContext(), MainActivity.class)
                    , 0);

            startForeground(notifyId, notification);
        } else {
            Notification.Builder builder = new Notification.Builder(this)
                    .setSmallIcon(ico)
                    .setContentTitle(title)
                    .setContentText("")
                    .setOnlyAlertOnce(true)
                    //         .setContentIntent(contentIntent)
                    .setOngoing(true);
            Notification notification;
            if (Build.VERSION.SDK_INT < 16) {
                notification = builder.getNotification();
            } else
                notification = builder.build();

            notification.contentIntent = PendingIntent.getActivity(this,
                    0, new Intent(getApplicationContext(), MainActivity.class)
                    , 0);


            startForeground(notifyId, notification);
        }
    }
}
