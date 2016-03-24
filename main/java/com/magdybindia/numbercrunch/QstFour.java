package com.magdybindia.numbercrunch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class QstFour extends Activity {
    public int[] result = new int[5];
    public int[] cAnswer = new int [5];
    public final static String EXTRA_RESULT = "com.magdybindia.numbercrunch.RESULT";
    public final static String EXTRA_CRESULT = "com.magdybindia.numbercrunch.CRESULT";
    public final static String EXTRA_LEVEL = "com.magdybindia.numbercrunch.LEVEL";
    int[] level = new int[5];
    public static final int QUESTNUMB = 4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_qst_four);

        TextView txtName = (TextView) findViewById(R.id.Level4Text);
        Button btnClose = (Button) findViewById(R.id.btnClose4);

        Intent previousScreen = getIntent();
        level = previousScreen.getIntArrayExtra(QstThree.EXTRA_LEVEL);
        Question q4 = new Question(level[QUESTNUMB-1]);
        cAnswer = previousScreen.getIntArrayExtra(QstFour.EXTRA_CRESULT);
        cAnswer[QUESTNUMB-1] = q4.getAnswer();
        txtName.setText("");
        txtName.setText(q4.getQuestion());
        result = previousScreen.getIntArrayExtra(QstThree.EXTRA_RESULT);
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
    public void buttonNext4(View view){
        EditText editText = (EditText) findViewById(R.id.Level4UserAnswer);
        String UserAnswer = editText.getText().toString();
        //Convert from String to Int
        try {
            // the String to int conversion happens here
            result[QUESTNUMB-1] = Integer.parseInt(UserAnswer);

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        Intent nextQuestion = new Intent(getApplicationContext(),QstFive.class);
        nextQuestion.putExtra(EXTRA_LEVEL, level);
        nextQuestion.putExtra(EXTRA_CRESULT, cAnswer);
        nextQuestion.putExtra(EXTRA_RESULT, result);
        startActivity(nextQuestion);
        finish();
    }
}
