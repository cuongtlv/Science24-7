package com.a7av.news24h;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

public class StartingScreen extends AppCompatActivity {

    private static ImageView iv_news, iv_fav, iv_exit, iv_about;
    private AlertDialog.Builder a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);
        btn_news();
        btn_exit();
        btn_fav();
        btn_about();
        checkForUpdates();
    }

    public void btn_news(){
        iv_news = (ImageView)findViewById(R.id.activity_starting_screen_iv_news);
        iv_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void btn_exit(){
        iv_exit = (ImageView) findViewById(R.id.activity_starting_screen_iv_exit);
        iv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = new AlertDialog.Builder(StartingScreen.this);
                a.setTitle("Exit");
                a.setMessage("Do you want to exit ?").setPositiveButton("Yes", new react1()).setNegativeButton("No", new react2());
                a.show();
            }
        });
    }
    public void btn_fav(){
        iv_fav = (ImageView)findViewById(R.id.activity_starting_screen_iv_fav);
        iv_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }
    public void btn_about(){
        iv_about = (ImageView)findViewById(R.id.activity_starting_screen_iv_about);
        iv_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
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
}
