package kupchinskii.ruslan.screenup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ruslan on 25.11.17.
 */

public class BootReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      //  PreferencesHelper.init(context);
      //  if(PreferencesHelper.GetAutoStart() || PreferencesHelper.GetAutoStartRebooting()) {
      //      PreferencesHelper.SetAutoStartRebooting(false);
      //      Intent s = new Intent(context, StartActivity.class);
      //      s.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
      //      context.startActivity(s);
      //  }
    }
}