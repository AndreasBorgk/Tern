package terner;

public class Plays {
    private String navn;
    private Ternings d1;
    private Ternings d2;
    private int accum = 0; // Holder styr på summen af terninge øjne.
    private int gamesWon = 0; // Holder styr på antal vundne spil
    private int lastThrow = 0; // Holder styr på værdien af sidste slag

   private void saveLastThrow()
    {
        lastThrow = getFaceValue1() + getFaceValue2(); // Gemmer nuværende slag i lastThrow.
    }

    Plays(String navn)
    {
        this.navn = navn;
        d1 = new Ternings();
        d2 = new Ternings();
    }

    void roll()
    {
        saveLastThrow();

        d1.roll();
        accum += d1.getFaceValue(); // holder styr på sum

        d2.roll();
        accum += d2.getFaceValue(); // holder styr på sum
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
        accum = 0; // sætter sum = 0 ved nyt spil
        lastThrow = 0; // sætter lastThrow = 0 ved nyt spil
    }

    void incGamesWon()
    {
        gamesWon++; // tæller op med en når Spiller vinder
    }

    int getGamesWon()
    {
        return gamesWon;
    }

    void clearPointsIfOnes() {
        if (getFaceValue1() == 1 && getFaceValue2() == 1) { // Tjekker om der er slået par 1
            System.out.println("You rolled ones, your score has been reset");
            accum = 0; // hvis der er slået par 1, accum = 0 for reset.
        }
    }
    boolean extraTurn() {
        return getFaceValue1() == getFaceValue2(); //tjekker om der er slået par, for at få ekstra slag.
        }

    boolean isCurrentAndLastThrowSixes() {
            return lastThrow == 12 && (getFaceValue1() + getFaceValue2()) == 12; //holder styr på om der er slået 2x6 to gange i streg
    }

    boolean isGameDone() {
        boolean isFinalStage = (getAccum() - (getFaceValue1() +getFaceValue2())) >= 40; // tjekker om spilleren er kommet over 40 point
        return (isFinalStage && getFaceValue1() == getFaceValue2()) // tjekker spiller har over 40 point ved par, for at vinde spil
                || isCurrentAndLastThrowSixes(); // Tjekker om der er slået 2x6 for at vinde spil
    }

    void reset()
    {
        newGame();
        gamesWon = 0;
    }
}
