package kupchinskii.ruslan.screenup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends Activity {

    CheckBox cbStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbStart = (CheckBox)findViewById(R.id.cbStart);
        PreferencesHelper.init(this);
        init();

        cbStart.setChecked(PreferencesHelper.GetAutoStart());
    }

    public void onClick(View w){
        PreferencesHelper.SetAutoStart(!PreferencesHelper.GetAutoStart());

        init();
    }

    public void onClickBack(View w){
        finish();
    }

    private void init() {
        if (PreferencesHelper.GetAutoStart() && !MainService.isMyServiceRunning(this, MainService.class))
            startService(new Intent(this, MainService.class));

        if(!PreferencesHelper.GetAutoStart() && MainService.isMyServiceRunning(this, MainService.class))
            stopService(new Intent(this, MainService.class));
    }

}
