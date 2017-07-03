package com.a7av.news24h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Openning view for user interacting.
 */
@EActivity(R.layout.activity_starting_screen)
public class StartingScreen extends AppCompatActivity {

    @ViewById(R.id.activity_starting_screen_iv_news)
    ImageView ivNews;

    @ViewById(R.id.activity_starting_screen_iv_exit)
    ImageView ivExit;

    @ViewById(R.id.activity_starting_screen_iv_fav)
    ImageView ivFav;

    @ViewById(R.id.activity_starting_screen_iv_about)
    ImageView ivAbout;

    private AlertDialog.Builder a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                                              .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                                              .setFontAttrId(R.attr.fontPath)
                                              .build()
                                     );

        checkForUpdates();
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }

    @Click(R.id.activity_starting_screen_iv_news)
    void setIvNews() {
        Intent intent = new Intent(StartingScreen.this, MainActivity.class);
        startActivity(intent);
    }

    @Click(R.id.activity_starting_screen_iv_exit)
    void setIvExit() {
        a = new AlertDialog.Builder(StartingScreen.this);
        a.setTitle("Exit");
        a.setMessage("Do you want to exit ?").setPositiveButton("Yes", new react1())
                 .setNegativeButton("No", new react2());
        a.show();
    }

    @Click(R.id.activity_starting_screen_iv_fav)
    void setIvFav() {
            a = new AlertDialog.Builder(StartingScreen.this);
            a.setTitle("Sorry...");
            a.setMessage("This function is not available yet.");
            a.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            a.show();
    }

    @Click(R.id.activity_starting_screen_iv_about)
    void setIvAbout() {
            a = new AlertDialog.Builder(StartingScreen.this);
            a.setTitle("About me");
            a.setMessage("I'm a newbie whom learning android");
            a.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            a.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        // ... your own onResume implementation
        checkForCrashes();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterManagers();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterManagers();
    }

    private void checkForCrashes() {
        CrashManager.register(this);
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this);
    }

    private void unregisterManagers() {
        UpdateManager.unregister();
    }

    private class react1 implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            StartingScreen.this.finish();
        }
    }

    private class react2 implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }
}
