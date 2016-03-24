package com.magdybindia.numbercrunch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class LevelOneQstOne extends Activity {
    public int[] result = new int[5];
    public int[] cAnswer = new int [5];
    //cAnswer is an array into which the correct answers to all questions are written
    //as the user goes along the quiz
    public final static String EXTRA_RESULT = "com.magdybindia.numbercrunch.RESULT";
    public final static String EXTRA_CRESULT = "com.magdybindia.numbercrunch.CRESULT";
    public final static String EXTRA_LEVEL = "com.magdybindia.numbercrunch.LEVEL";
    int[] level = new int[5];
    public static final int QUESTNUMB = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leveloneqst_one);

        TextView txtName = (TextView) findViewById(R.id.Level1Text);
        Button btnClose = (Button) findViewById(R.id.btnClose);
        Intent previousScreen = getIntent();
        level = previousScreen.getIntArrayExtra(LevelScreenActivity.EXTRA_LEVEL);
        //Here this activity receives the values for the difficulty of question
        // from the previous activity
        Question q1 = new Question(level[QUESTNUMB-1]);
        //By reading out the corresponding element of the array a question of the desired
        //difficulty is created
        cAnswer[QUESTNUMB-1] = q1.getAnswer();
        txtName.setText("");
        txtName.setText(q1.getQuestion());
        // Listening to Close button
        btnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent back = new Intent(getApplicationContext(),MainscreenActivity.class);
                startActivity(back);
                finish();
            }
        });

    }

// Next Button
    public void buttonNext1(View view){
        EditText editText = (EditText) findViewById(R.id.Level1UserAnswer);
        //This reads the user input from the screen
        String UserAnswer = editText.getText().toString();
        //Convert from String to Int
        try {
            // the String to int conversion happens here
            result[QUESTNUMB-1] = Integer.parseInt(UserAnswer);

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        Intent nextQuestion = new Intent(getApplicationContext(),QstTwo.class);
        /*These commands send forward to the next activity the level array for determining question
        difficulty, the cAnswer array where the correct answers are stored and the result array where
        the user answers are stored
         */
        nextQuestion.putExtra(EXTRA_LEVEL,level);
        nextQuestion.putExtra(EXTRA_CRESULT,cAnswer);
        nextQuestion.putExtra(EXTRA_RESULT,result);
        startActivity(nextQuestion);
        finish();
    }
}
