package kupchinskii.ruslan.screenup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        PreferencesHelper.init(context);
        if(PreferencesHelper.GetAutoStart() ) {
            context.startService(new Intent(context, MainService.class));
        }
    }
}