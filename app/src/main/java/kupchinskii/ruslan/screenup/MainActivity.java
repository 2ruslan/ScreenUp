package kupchinskii.ruslan.screenup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View w){
        PreferencesHelper.SetAutoStart(!PreferencesHelper.GetAutoStart());

        if (PreferencesHelper.GetAutoStart() && !MainService.isMyServiceRunning(this, MainService.class))
            startService(new Intent(this, MainService.class));

        if(!PreferencesHelper.GetAutoStart() && MainService.isMyServiceRunning(this, MainService.class))
            stopService(new Intent(this, MainService.class));
    }

}
