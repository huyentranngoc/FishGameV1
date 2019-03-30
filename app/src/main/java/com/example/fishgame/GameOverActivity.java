package com.example.fishgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameOverActivity extends Activity {

    private Button StartGameAgain;
    private Button MainMenu;
    private TextView DisplayScore;
    private String score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        score = getIntent().getExtras().get("score").toString();

        //Initialize textview
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        //intitialize the buttons
        StartGameAgain = (Button) findViewById(R.id.play_again_btn);
        MainMenu = (Button) findViewById(R.id.main_menu_btn);

        //on click listener for the startgameagain button
        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GameOverActivity.this, MainActivity.class );
                startActivity(mainIntent);
            }
        });

        //On click listener for the Main Menu button to take user back to the main menu
        MainMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent MainMenuIntent = new Intent(GameOverActivity.this, SplashActivity.class);
                startActivity(MainMenuIntent);
            }
        });

        DisplayScore.setText("Your Score is "+score);
    }

    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(GameOverActivity.this);
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
