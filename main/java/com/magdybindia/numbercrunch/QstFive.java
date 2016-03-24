package com.magdybindia.numbercrunch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class QstFive extends Activity {
    public int[] result = new int[5];
    public int[] cAnswer = new int [5];
    public final static String EXTRA_RESULT = "com.magdybindia.numbercrunch.RESULT";
    public final static String EXTRA_CRESULT5 = "com.magdybindia.numbercrunch.CRESULT5";
    int[] level = new int[5];
    public static final int QUESTNUMB = 5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_qst_five);

        TextView txtName = (TextView) findViewById(R.id.Level5Text);
        Button btnClose = (Button) findViewById(R.id.btnClose5);

        Intent previousScreen = getIntent();
        level = previousScreen.getIntArrayExtra(QstFour.EXTRA_LEVEL);
        Question q5 = new Question(level[QUESTNUMB-1]);
        cAnswer = previousScreen.getIntArrayExtra(QstFour.EXTRA_CRESULT);
        cAnswer[QUESTNUMB-1] = q5.getAnswer();
        txtName.setText("");
        txtName.setText(q5.getQuestion());
        result = previousScreen.getIntArrayExtra(QstFour.EXTRA_RESULT);
        // Listening to Close button
        btnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                Intent back = new Intent(getApplicationContext(),MainscreenActivity.class);
                startActivity(back);
                finish();
            }
        });

    }

    // Next Button
    public void OnScoreButton(View view){
        EditText editText = (EditText) findViewById(R.id.Level5UserAnswer);
        String UserAnswer = editText.getText().toString();
        //Convert from String to Int
        try {
            // the String to int conversion happens here
            result[QUESTNUMB-1] = Integer.parseInt(UserAnswer);

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        //Starting a new Intent
        Intent nextScreen = new Intent(getApplicationContext(), ScoreBoard.class);
        nextScreen.putExtra(EXTRA_RESULT, result);
        nextScreen.putExtra(EXTRA_CRESULT5, cAnswer);
        startActivity(nextScreen);
        finish();
    }

}
