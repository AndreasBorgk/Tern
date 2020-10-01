package terner;

import java.util.Scanner;

public class Plays {
    private String navn;
    private Ternings d1;
    private Ternings d2;
    private int accum = 0;
    private int gamesWon = 0;
    private int LastThrow = 0;

    void saveLastThrow()
    {
        LastThrow = getFaceValue1() + getFaceValue2();

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

    void playForTwoEquals()
    {
        if (getFaceValue1() == getFaceValue2()) {
            System.out.println("you rolled two equals, while being above 40 points.");

        }

    }

    void newTurnIfSame() {
        Scanner sc = new Scanner(System.in);
        if (getFaceValue1() == getFaceValue2()) {
            System.out.println("you rolled a pair, new turn!");
            System.out.println(getNavn() + " Press 'K' if you're ready to throw");
            String K = sc.next();
            K = K.toLowerCase();
            roll();
            System.out.println(getFaceValue1() + " + " + getFaceValue2() + " = " + getAccum());
            saveLastThrow();
        }
    }




    void getSaveLastThrow() {
        if (LastThrow == 12 && (getFaceValue1() + getFaceValue2()) == 12) {
            System.out.println(getNavn() + " have rolled pair 6 two times in a row, you've won the game");
        }
    }



    void reset()
    {
        newGame();
        gamesWon = 0;
    }
}
