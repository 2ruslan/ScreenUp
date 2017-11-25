package kupchinskii.ruslan.screenup;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesHelper {

    public static final String APP_PREFERENCES = "preference";
    public static final String AUTO_START = "auto_start";


    private static SharedPreferences mSettings;

    public static void init(Context context) {
        mSettings = context.getSharedPreferences(PreferencesHelper.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    //region AUTO_START

    public static void SetAutoStart(boolean val) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putBoolean(AUTO_START, val);
        editor.apply();
    }

    public static boolean GetAutoStart() {
        return mSettings.getBoolean(AUTO_START, false);

    }
    // endregion AUTO_START
}
