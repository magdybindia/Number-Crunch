package com.magdybindia.numbercrunch;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
//import android.widget.EditText;

public class ScoreBoard extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard);

        Button btnRepeatLevel = (Button) findViewById(R.id.RepeatLevel);
        Button btnMainMenu = (Button) findViewById(R.id.MainMenu);
        Intent nextScreen = this.getIntent();
        int [] result = nextScreen.getIntArrayExtra(QstFive.EXTRA_RESULT);
        int [] cAnswer = nextScreen.getIntArrayExtra(QstFive.EXTRA_CRESULT5);
        Performance myPerformance = new Performance(result,cAnswer);
        TextView resultDisplay = (TextView) findViewById(R.id.textView9);
        resultDisplay.setText(getString(R.string.Score_text) + myPerformance.getPercent()+"\nYour answers:\n" + Arrays.toString(result)+"\nCorrect answers:\n" + Arrays.toString(cAnswer));

        btnRepeatLevel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), LevelScreenActivity.class);
                startActivity(nextScreen);
                finish();
                //finish();

            }
        });

        btnMainMenu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), MainscreenActivity.class);
                startActivity(nextScreen);
                finish();
                //finish();

            }
        });
    }



    }