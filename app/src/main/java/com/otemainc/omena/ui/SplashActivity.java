package com.otemainc.omena.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.otemainc.omena.R;
import com.otemainc.omena.ui.auth.SignInActivity;
import com.otemainc.omena.utilities.SharedPreference;

public class SplashActivity extends AppCompatActivity {
    ProgressBar myProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slpash);
        myProgress = findViewById(R.id.progressBar);
        myProgress.setIndeterminate(true);
        splash();
    }
    private void splash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Check if the user has been authenticated
                if (SharedPreference.getInstance().getString("is_logged_in").equalsIgnoreCase("")) {

                    //User is not yet logged in
                    // show the login activity
                    Intent login = new Intent(SplashActivity.this, SignInActivity.class);
                    startActivity(login);
                }else {
                    //User has logged in
                    //Show the HomeActivity
                    Intent home = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(home);
                }
                finish();
            }
        },5000);

    }
}
