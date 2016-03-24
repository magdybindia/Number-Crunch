package com.magdybindia.numbercrunch;

/**
 * Created by Bindia Venugopal on 19/03/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.magdybindia.numbercrunch.R;

public class LevelScreenActivity extends Activity {
    public final static String EXTRA_LEVEL = "com.magdybindia.numbercrunch.LEVEL";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelscreen_activity);
        //Defining the Buttons on the screen
        Button btnNextSrnOne = (Button) findViewById(R.id.btnOne);
        Button btnNextSrnTwo = (Button) findViewById(R.id.btnTwo);
        Button btnNextSrnThree = (Button) findViewById(R.id.btnThree);
        Button btnNextSrnFour = (Button) findViewById(R.id.btnFour);
        Button btnNextSrnMixitup = (Button) findViewById(R.id.btnmixitup);
        Button btnNextSrnClose = (Button) findViewById(R.id.btnClose);

        btnNextSrnOne.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                //the array level is sent through the 5 questions and each array value
                //corresponds to the difficulty of the question
                int [] level = {1,2,1,2,1};
                Intent nextScreen = new Intent(getApplicationContext(), LevelOneQstOne.class);
                //putExtra is used to send data between different activities
                nextScreen.putExtra(EXTRA_LEVEL, level);
                startActivity(nextScreen);
                finish();
            }
        });

        btnNextSrnTwo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                int [] level = {1,2,3,3,3};
                Intent nextScreen = new Intent(getApplicationContext(), LevelOneQstOne.class);
                nextScreen.putExtra(EXTRA_LEVEL, level);
                startActivity(nextScreen);
                finish();
            }
        });

        btnNextSrnThree.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                int [] level = {1,3,3,4,4};
                Intent nextScreen = new Intent(getApplicationContext(), LevelOneQstOne.class);
                nextScreen.putExtra(EXTRA_LEVEL, level);
                startActivity(nextScreen);
                finish();
            }
        });


        btnNextSrnFour.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                int[] level = {3, 4, 5, 5, 5};
                Intent nextScreen = new Intent(getApplicationContext(), LevelOneQstOne.class);
                nextScreen.putExtra(EXTRA_LEVEL, level);
                startActivity(nextScreen);
                finish();
            }
        });

        btnNextSrnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), MainscreenActivity.class);
                startActivity(nextScreen);
                finish();
            }
        });

    }
    public void onClickMix(View view){
        /*
        This method is used when the Button "Mix It Up" is clicked.
        It generates 5 different random numbers between 1 and 5 and populates the 5x1 array with them
        Then the array is sorted in ascending order so that the lower level questions appear first
         get harder as you go along.
         */
        int [] level = new int[5];
        for (int i1 = 0; i1 < level.length; i1++){
            level[i1] = (int)(Math.random()*5)+1;
        }
        int [] level1 = BubbleSort(level);
        Intent nextScreen = new Intent(getApplicationContext(), LevelOneQstOne.class);
        nextScreen.putExtra(EXTRA_LEVEL, level1);
        startActivity(nextScreen);
        finish();
    }


    public static int [] BubbleSort(int [] num)
    {
        /*
        This bubble sort code was taken from http://mathbits.com/MathBits/Java/arrays/Bubble.htm
        And was changed to sort the array in ascending order.
         */
        int j;
        boolean flag = true;
        int temp;
        while (flag) {
            flag= false;
            for( j=0;  j < num.length -1;  j++ ){
                if ( num[j] > num[j+1] ){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    flag = true;
                }
            }
        }
        return num;
    }

}
