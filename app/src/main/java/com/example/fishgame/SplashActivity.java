package com.example.fishgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

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

                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);

            case R.id.mediumButton:

                Toast.makeText(this, "medium button clicked", Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);

            case R.id.hardButton:

                Toast.makeText(this, "hard button clicked", Toast.LENGTH_SHORT).show();

                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
