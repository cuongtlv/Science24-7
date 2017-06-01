package com.a7av.news24h;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartingScreen extends AppCompatActivity {

    private static ImageView img_news, img_exit, img_fav, img_about;
    private AlertDialog.Builder a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        click_News();
        click_Exit();
        click_Fav();
        click_About();
    }

    public void click_News(){
        img_news = (ImageView)findViewById(R.id.img_news);
        img_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void click_Exit(){
        img_exit = (ImageView) findViewById(R.id.img_exit);
        img_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = new AlertDialog.Builder(StartingScreen.this);
                a.setTitle("Exit");
                a.setMessage("Do you want to exit ?").setPositiveButton("Yes", new react1()).setNegativeButton("No", new react2());
                a.show();
            }
        });
    }
    public void click_Fav(){
        img_fav = (ImageView)findViewById(R.id.img_favorites);
        img_fav.setOnClickListener(new View.OnClickListener() {
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
    public void click_About(){
        img_about = (ImageView)findViewById(R.id.img_about);
        img_about.setOnClickListener(new View.OnClickListener() {
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
}
