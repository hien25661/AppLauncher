package app.hiennv.applauncher.apps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import app.hiennv.applauncher.BaseActivity;
import app.hiennv.applauncher.R;
import app.hiennv.applauncher.apps.MainActivity;
import app.hiennv.applauncher.widgets.location.LocationView;

public class HomeActivity extends BaseActivity {
    LocationView locationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        locationView = (LocationView) getSupportFragmentManager().findFragmentById(R.id.fragment_location);
    }

    public void openListApp(View v){
        startActivity(new Intent(this,MainActivity.class));
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case LocationView.REQUEST_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission granted successfully
                    locationView.init(this);
                } else {
                    //permission denied
                }
                break;
        }
    }
}
