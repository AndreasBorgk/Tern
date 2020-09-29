package terner;

import java.util.Scanner;

class Main {
    private static Plays p1;
    private static Plays p2;





        private static void inputPlayerNames()
        {
            System.out.println("Player 1, type in your name: ");
            Scanner sc = new Scanner(System.in);
            String Spiller1 = sc.next();
            System.out.println("Welcome " + Spiller1);
            System.out.println("Player 2, type in your name: ");
            p1 = new Plays(Spiller1);
            String Spiller2 = sc.next();
            System.out.println("Welcome " + Spiller2);
            p2 = new Plays(Spiller2);
            System.out.println("Type 'start' to start game");
            String start = sc.next();
            start = start.toLowerCase();
        }

        private static void playGame()
        {
            int round = 1;
            Scanner sc = new Scanner(System.in);
            while ((p1.getAccum() < 40) && (p2.getAccum() < 40)) {
                System.out.println(p1.getNavn() + " Press 'K' if you're ready to throw");
                String k = sc.next();
                k = k.toLowerCase();
                p1.roll();
                System.out.println(p1.getNavn() + " rolls: (" + p1.getFaceValue1() + "," + p1.getFaceValue2() + ") ->" + p1.getAccum());
                System.out.println(p2.getNavn() + " Press 'K' if you're ready to throw");
                String K = sc.next();
                K = K.toLowerCase();
                p2.roll();
                System.out.println(p2.getNavn() + " rolls: (" + p2.getFaceValue1() + "," + p2.getFaceValue2() + ") ->" + p2.getAccum());
                System.out.println();
                System.out.println("Round: " + round);
                round++;
                System.out.println("Current score is: " +  p1.getNavn() + ": " + p1.getAccum()  + " and " +  p2.getNavn() + ": " + p2.getAccum());

                System.out.println();
            }

            if (p1.getAccum() > p2.getAccum()) {
                System.out.println(p1.getNavn() + " won with: " + p1.getAccum());
                p1.incGamesWon();


            } else {
                System.out.println(p2.getNavn() + " won with: " + p2.getAccum());
                p2.incGamesWon();

            }


        }

    private static void newGame() {
        inputPlayerNames();
        String another = "y";
        Scanner sc = new Scanner(System.in);

        while (another.equalsIgnoreCase("y"))
        {
            playGame();
            System.out.println();
            System.out.print("vil du spille igen (y/n)");
            another = sc.next();
            p1.newGame();
            p2.newGame();
        }

    }


    public static void main(String[] args) {
            newGame();

        //while ((p1.getGamesWon() < 3) && (p2.getGamesWon() < 3)) {
        //    System.out.println("Game round #: " + games);
         //   games++;
         //   newGame();
         //   p1.newGame();
        //    p2.newGame();
       // }


       // if (p1.getGamesWon() > p2.getGamesWon()) {
       //     System.out.println(" won with: " + p1.getGamesWon() + " - " + p2.getGamesWon());
      //  } else {
       //     System.out.println("Player 2 won with: " + p2.getGamesWon() + " - " + p1.getGamesWon());
       // }
    }
}
