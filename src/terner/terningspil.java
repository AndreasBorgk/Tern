package terner;

import java.util.Scanner;

class Main {
    private static Plays p1;
    private static Plays p2;
    private static Plays currentPlayer;
    static Scanner sc = new Scanner(System.in);

    private static void inputPlayerNames() {
        System.out.println("Player 1, type in your name: ");
        String Spiller1 = sc.next();
        System.out.println("Welcome " + Spiller1);
        System.out.println("Player 2, type in your name: ");
        p1 = new Plays(Spiller1);
        String Spiller2 = sc.next();
        System.out.println("Welcome " + Spiller2);
        p2 = new Plays(Spiller2);
        System.out.println("Are you ready to start the game? '(y/n)'");
        sc.next();
        }

        private static void doTurn()
        {
            do {
                System.out.println(currentPlayer.getNavn() + " Press 'K' if you're ready to throw");
                sc.next();
                currentPlayer.roll();
                System.out.println(currentPlayer.getNavn() + " rolls: (" + currentPlayer.getFaceValue1() + "," + currentPlayer.getFaceValue2() + ") ->" + currentPlayer.getAccum());
                currentPlayer.clearPointsIfOnes();
            } while (currentPlayer.extraTurn() &&! currentPlayer.isGameDone());
        }

        private static void playGame()
        {
            int round = 1;
            while ((!p1.isGameDone()) &&! (p2.isGameDone())){
                System.out.println("Round: " + round);
                round++;
                currentPlayer = p1;
                doTurn();
                currentPlayer = p2;
                doTurn();
                System.out.println("Current score is: " +  p1.getNavn() + ": " + p1.getAccum()  + " and " +  p2.getNavn() + ": " + p2.getAccum());
                System.out.println();
            }

            if (p1.isGameDone()) {
                System.out.println(p1.getNavn() + " won with: " + p1.getFaceValue1() + ", " + p1.getFaceValue2()  + " = " + p2.getAccum());
                p1.incGamesWon();
                System.out.println("Games won : " + p1.getGamesWon());

            } if (p2.isGameDone()) {
            System.out.println(p2.getNavn() + " won with dice roll: " + p2.getFaceValue1() + ", " + p2.getFaceValue2() + " = " + p2.getAccum());
            p2.incGamesWon();
            System.out.println("Games won : " + p2.getGamesWon());
            }
        }

    private static void newGame() {
        inputPlayerNames();
        String another = "y";

        while (another.equalsIgnoreCase("y"))
        {
            playGame();
            System.out.println();
            System.out.print("would you like to play again? (y/n)");
            another = sc.next();
            p1.newGame();
            p2.newGame();
        }
    }

    public static void main(String[] args) {
            newGame();
    }
}