package com.magdybindia.numbercrunch;


import java.text.DecimalFormat;


/*
 * This class takes the two arrays, the user responses and the correct answers, and then compares
 * both to determine the performance of the user and returns a percentage that reflects
 * the users performance
 */

/**
 *
 * @author magdy
 */
public class Performance {

    private String percent;
    private int[] score;
    private double PercentagePerformance;

    public Performance(int[] Answers, int[] cAnswers){
        int[] scores = checkPerformance(Answers, cAnswers);
        percent = Percentageformatted(scores);
        score = scores;
    }
    private int[] checkPerformance(int[] Answers, int[] cAnswers){
        int [] score = new int[Answers.length];
        for(int i = 0; i<cAnswers.length; i++){
            if (Answers[i] == cAnswers[i])
                score[i] = 1;
            else
                score[i] = 0;
        }
        return score;
    }

    private double Percentage(int[] scores){
        double sum1 = 0;
        for(int i = 0; i<scores.length; i++){
            sum1 += scores[i];
        }
        PercentagePerformance = (sum1)*100/scores.length;
        return PercentagePerformance;
    }

    private String Percentageformatted(int [] scores1){
        double p1 = Percentage(scores1);
        String pattern = "##.0";
        DecimalFormat percent = new DecimalFormat(pattern);
        String percentValue = percent.format(p1) + "%";
        return percentValue;
    }

    public String getPercent(){
        return percent;
    }
    public int[] getScore(){
        return score;
    }
}
