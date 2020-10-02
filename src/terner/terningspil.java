package terner;


import java.util.Scanner;

class Main {
    private static Plays p1;
    private static Plays p2;
    private static Plays currentPlayer;
    static Scanner sc = new Scanner(System.in);



    private static void inputPlayerNames() {
        System.out.println("rules for DiceGame: \n" +
                "1. When you hit 40 points, you have to roll a pair to win the game\n" +
                "2. If you roll a pair, you get an extra turn \n" +
                "3. If you roll a pair of ones you lose your points \n" +
                "4. if you roll double 6 twice in a row, you win the game");

        System.out.println("Player 1, type in your name: ");
        p1 = new Plays(sc.next()); // Spiller 1's navn vælges og gemmes i p1
        System.out.println("Welcome " + p1.getNavn());

        System.out.println("Player 2, type in your name: ");
        p2 = new Plays(sc.next()); // Spiller 2's navn vælges og gemmes i p2
        System.out.println("Welcome " + p2.getNavn());


        System.out.println("Are you ready to start the game? '(y/n)'");
        sc.next(); // spørges om de er klar til at starte spil, ved tast startes det.
        }

        private static void doTurn()
        {
            do {

                // spørges om de er klar til at slå, ved k kaster de
                System.out.println(currentPlayer.getNavn() + " Press 'K' if you're ready to throw");
                sc.next();

                currentPlayer.roll(); // spilleren kaster terningerne

                //Navn, terning 1 og 2's værdi og den akkumulerede printes ud.
                System.out.println(currentPlayer.getNavn() + " rolls: (" + currentPlayer.getFaceValue1() +
                        "," + currentPlayer.getFaceValue2() + ") ->" + currentPlayer.getAccum());

                currentPlayer.clearPointsIfOnes(); // hvis spilleren slår par 1, bliver den akkumulerede sat til 0.

                // løkken køres så længe spilleren har et ekstra slag og spillet ikke er færdigt
            } while (currentPlayer.extraTurn() &&! currentPlayer.isGameDone());
        }

        private static void playGame()
        {
            int round = 1;

            //loop indtil hverken spiller 1 eller 2 har opnået spillet er færdigt
            while ((!p1.isGameDone()) &&! (p2.isGameDone()))
            {

                System.out.println("Round: " + round);
                round++; // printer runde nummer ud og plusser med en for hver runde.

                currentPlayer = p1;
                doTurn(); // kører do loop på player 1
                currentPlayer = p2;
                doTurn(); // kører do loop på player 2

                // printer current score ud for player 1 og player 2
                System.out.println("Current score is: " +  p1.getNavn() + ": " + p1.getAccum()
                        + " and " +  p2.getNavn() + ": " + p2.getAccum());
                System.out.println();
            }

            if (p1.isGameDone()) // Denne kode køres hvis spiller 1 er færdig
            {
                // Spiller 1's navn, værdien på han sidste kast og han samlede score printes
                System.out.println(p1.getNavn() + " won with: "
                        + p1.getFaceValue1() + ", " + p1.getFaceValue2()  + " = " + p1.getAccum());

                p1.incGamesWon(); // Player1 gameswon +1
                System.out.println("Games won : " + p1.getGamesWon());

            }

            if (p2.isGameDone()) // Denne kode køres hvis spiller 2 er færdig
            {
                // Spiller 2's navn, værdien på han sidste kast og han samlede score printes
                System.out.println(p2.getNavn() + " won with dice roll: "
                        + p2.getFaceValue1() + ", " + p2.getFaceValue2() + " = " + p2.getAccum());

                p2.incGamesWon(); // Player2 gameswon +1
                System.out.println("Games won : " + p2.getGamesWon());
            }
        }

        // Spillet er færdig og der spørges om de vil spille igen
    private static void newGame() {
        inputPlayerNames();
        String another = "y";

        while (another.equalsIgnoreCase("y"))
        {
            playGame(); //Kalder playGame hvis de vil spille igen
            System.out.println();
            System.out.print("would you like to play again? (y/n)");
            another = sc.next();


            p1.newGame(); // spiller 1 reset for nyt spil
            p2.newGame(); // spiller 2 reset for nyt spil
        }
    }

    public static void main(String[] args) {
            newGame(); //kalder new game, så accum og lastThrow sættes 0.
    }
}