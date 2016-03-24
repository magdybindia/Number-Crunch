package com.magdybindia.numbercrunch;

import java.util.Arrays;


/*
 *Class for creating questions of different difficulties for the App.
 * If an int value is given, a question of corresponding difficulty will be produced,
 * If no value is given, a local random number is generated and used as a parameter.
 *
 * It returns a string that holds the question, and an int value that holds the correct answer
 */

/**
 *
 * @author magdy
 */
public class Question {
    public static String numb;
    public static String question;
    public int answer;
    
    public Question(){
       int level = (int)((Math.random()*5)+1); 
       int[] num = generateNumber(level);
       question = generateSign(num, level);
       numb = Arrays.toString(num);
       
}
    public Question(int lvl){
       int[] num = generateNumber(lvl);
       question = generateSign(num, lvl);
    }
    
    private static int[] generateNumber(int level){
        int n1, n2, n3;
        switch(level){
            case 1:
            case 2:
                do{
                n1 = (int)((Math.random()+1)*20)+1;
                n2 = (int)((Math.random()+1)*20)+1;
                }
                while (n2>n1);
                n3 = 0;
                break; 
            case 3:
                n1 = (int)((Math.random()+1)*20)+1;
                n2 = (int)((Math.random()+1)*10)+1;
                n3 = (int)((Math.random()+1)*6)*5;
                break;
            case 4: 
                do {
                n1 = (int)((Math.random())*150)+1;
                n2 = (int)((Math.random())*20)+1;
                }
                while (n1%n2 != 0);
                n3 = 0;
                break; 
            case 5: 
                n1 = (int)((Math.random())*10)+1;
                n2 = (int)((Math.random())*7)+1;
                n3 = (int)((Math.random())*10)+1;
                break; 
            default:
                n1 = 0;
                n2 = 0;
                n3 = 0;
                break; 
        }
        
        int[] num ={n1, n2, n3};
        return num;
    }
    
    private String generateSign (int[] n, int lvl){
        int num1 = n[0];
        int num2 = n[1];
        int num3 = n[2];
        switch(lvl){
            case 1:
                question = num1 + "+" + num2;
                answer = num1 + num2;
            break;
            case 2:
                question = num1 + "-"+ num2;
                answer = num1 - num2;
            break;
            case 3:
                question = num1+ "*" + num2; 
                answer = num1*num2;
            break;
            case 4:
                question = num1+ "/" + num2 ;
                answer = num1/num2;
            break;
            case 5:
                question = num1 + "*"+num2 + "*" + num3;
                answer = num1*num3*num2;
            break;         
        }
        return question;
                
    }
    
    public String getNumber(){
        return numb;
    }
    public String getQuestion(){
        return question;
    }
    public int getAnswer(){
        return answer;
    }
}
   