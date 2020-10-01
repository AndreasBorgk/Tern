package terner;

import java.util.Scanner;

public class Plays {
    private String navn;
    private Ternings d1;
    private Ternings d2;
    private int accum = 0;
    private int gamesWon = 0;
    private int lastThrow = 0;

    void saveLastThrow()
    {
        lastThrow = getFaceValue1() + getFaceValue2();
    }
    Plays(String navn)
    {
        this.navn = navn;
        d1 = new Ternings();
        d2 = new Ternings();
    }

    void roll()
    {
        d1.roll();
        accum += d1.getFaceValue();

        d2.roll();
        accum += d2.getFaceValue();
    }

    String getNavn()
    {
        return navn;
    }

    int getFaceValue1()
    {
        return d1.getFaceValue();
    }

    int getFaceValue2(){
        return d2.getFaceValue();
    }
    int getAccum()
    {
        return accum;
    }

    void newGame()
    {
        accum = 0;
        lastThrow = 0;
    }

    void incGamesWon()
    {
        gamesWon++;
    }

    int getGamesWon()
    {
        return gamesWon;
    }

    void clearPointsIfOnes() {
        if (getFaceValue1() == 1 && getFaceValue2() == 1) {
            System.out.println("You rolled ones, your score has been reset");
            accum = 0;


        }

    }

    void checkIfDiceEqualAndReset()
    {
        if (getFaceValue1() == getFaceValue2()) {
            System.out.println("you rolled two equals, while being above 40 points.");
            newGame();

        }

    }

    boolean extraTurn() {
        return getFaceValue1() == getFaceValue2();
        }





    boolean isCurrentAndLastThrowSixes() {
            return lastThrow == 12 && (getFaceValue1() + getFaceValue2()) == 12;


    }

    boolean isGameDone() {
        boolean isFinalStage = (getAccum() - (getFaceValue1() +getFaceValue2())) >= 40;
        return isFinalStage && getFaceValue1() == getFaceValue2();

    }



    void reset()
    {
        newGame();
        gamesWon = 0;
    }
}
