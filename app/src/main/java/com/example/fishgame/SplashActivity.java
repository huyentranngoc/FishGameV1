package com.example.fishgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashActivity extends Activity implements View.OnClickListener {

    //Initialize public static variables to hold speed values for the different balls
    public static int StaticGrnSpd, StaticYlwSpd, StaticRedSpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //button initialization
        Button easyButton = findViewById(R.id.easyButton);
        Button mediumButton = findViewById(R.id.mediumButton);
        Button hardButton = findViewById(R.id.hardButton);

        //on click listeners for the buttons
        easyButton.setOnClickListener(this);
        mediumButton.setOnClickListener(this);
        hardButton.setOnClickListener(this);



    }

    //overriding the on click method and using a switch statement to get the ID of the button clicked.
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.easyButton:

                Toast.makeText(this, "easy button clicked", Toast.LENGTH_SHORT).show();




                StaticGrnSpd = 20;   //setting the speeds of the individual balls
                StaticYlwSpd = 16;   //for the easy difficulty
                StaticRedSpd = 30;

                break;


            case R.id.mediumButton:

                Toast.makeText(this, "medium button clicked", Toast.LENGTH_SHORT).show();


                StaticGrnSpd = 35;  //setting the speeds of the individual balls
                StaticYlwSpd = 30;  //for the medium difficulty
                StaticRedSpd = 40;

                break;

            case R.id.hardButton:

                Toast.makeText(this, "hard button clicked", Toast.LENGTH_SHORT).show();


                StaticGrnSpd = 40;  //setting the speeds of the individual balls
                StaticYlwSpd = 35;  //for the medium difficulty
                StaticRedSpd = 60;

                break;
        }

        //initialize and start the intent
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
