package org.example;

import org.example.exception.IllegalRollException;

public class Frame {

    private BowlingBall ball;
    private static int score = 0;

    public Frame(BowlingBall ball){
        this.ball = ball;
    }

    public int play(int serie){
        int firstRoll = ball.rollTheBall();
        int newScore = score;

        if(serie < 10){
            if(firstRoll == 10){
                newScore += 10;
                return newScore;
            }
            int secondRoll = ball.rollTheBall();
            newScore += firstRoll;
            newScore += secondRoll;
            return newScore;
        }
        int secondRoll = ball.rollTheBall();
        newScore += firstRoll;
        newScore += secondRoll;

        if(firstRoll == 10 || secondRoll == 10 || firstRoll + secondRoll == 10){
            newScore += ball.rollTheBall();
            return newScore;
        }
       return newScore;
    }

    public static int getScore() {
        return score;
    }
}
