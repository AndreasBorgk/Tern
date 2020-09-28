package terner;

class Main {
    private static Plays p1 = new Plays();
    private static Plays p2 = new Plays();


    private static void newGame() {
        int round = 1;
        while ((p1.getAccum() < 40) && (p2.getAccum() < 40)) {
            p1.roll();
            p2.roll();
            System.out.println("Round: " + round);
            round++;
            System.out.println("p1 rolls: (" + p1.getFaceValue1() + "," + p1.getFaceValue2() + ") ->" + p1.getAccum());
            System.out.println("p2 rolls: (" + p2.getFaceValue1() + "," + p2.getFaceValue2() + ") ->" + p2.getAccum());
            System.out.println("P1: " + p1.getAccum());
            System.out.println("P2: " + p2.getAccum());
        }

        if (p1.getAccum() > p2.getAccum()) {
            System.out.println("Player 1 won with: " + p1.getAccum());
            p1.incGamesWon();
        } else {
            System.out.println("Player 2 won with: " + p2.getAccum());
            p2.incGamesWon();
        }
    }


    public static void main(String[] args) {

        int games = 0;

        while ((p1.getGamesWon() < 3) && (p2.getGamesWon() < 3)) {
            System.out.println("Game round #: " + games);
            games++;
            newGame();
            p1.newGame();
            p2.newGame();
        }


        if (p1.getGamesWon() > p2.getGamesWon()) {
            System.out.println("Player 1 won with: " + p1.getGamesWon() + " - " + p2.getGamesWon());
        } else {
            System.out.println("Player 2 won with: " + p2.getGamesWon() + " - " + p1.getGamesWon());
        }
    }
}
