package kupchinskii.ruslan.screenup;


import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class MainService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    PowerManager.WakeLock wl;

    @Override
    public void onCreate() {
        startForeground(R.drawable.ic_notify_proc, "screen up", 1100);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "screen_up");
        wl.acquire();
    }


    @Override
    public void onDestroy() {
        wl.release();
    }



    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
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
                    , PendingIntent.FLAG_UPDATE_CURRENT);

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
                    , PendingIntent.FLAG_UPDATE_CURRENT);


            startForeground(notifyId, notification);
        }
    }
}
