package terner;

public class Plays {
    private Ternings d1;
    private Ternings d2;
    private int accum = 0;
    private int gamesWon = 0;

    Plays()
    {
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

    void reset()
    {
        newGame();
        gamesWon = 0;
    }
}
