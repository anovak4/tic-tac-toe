package tictactoe;

public class Board {

    private String[][] board;
    private final String comp = "C";
    private final String user = "U";
    private int cats;
    private int userWins;
    private int compWins;

    public Board() {
        board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[j][i] = "" + ((j * 3) + (i + 1));
            }
        }
        cats = 0;
        userWins = 0;
        compWins = 0;
    }

    public void compTurn() {
        String winner;
        int row = 0, col = 0, countC = 0, countU = 0;
        boolean done = false;
        System.out.println("COMPUTER'S TURN");
        //check rows
        for (int i = 0; i < board.length; i++) {
            if (!done) {
                countC = 0;
                countU = 0;
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals(user)) {
                        countU++;
                    }
                    if (board[i][j].equals(comp)) {
                        countC++;
                    }
                }
                if (countC == 2 || countU == 2) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (!board[i][j].equals(user) && !board[i][j].equals(comp)) {
                            board[i][j] = comp;
                            done = true;
                        }
                    }
                }
            }
        }
        //check columns
        if (!done) {
            for (int i = 0; i < board[0].length; i++) {
                if (!done) {
                    countC = 0;
                    countU = 0;
                    for (int j = 0; j < board.length; j++) {
                        if (board[j][i].equals(user)) {
                            countU++;
                        }
                        if (board[j][i].equals(comp)) {
                            countC++;
                        }
                    }
                    if (countC == 2 || countU == 2) {
                        for (int j = 0; j < board.length; j++) {
                            if (!board[j][i].equals(user) && !board[j][i].equals(comp)) {
                                board[j][i] = comp;
                                done = true;
                            }
                        }
                    }
                }
            }
        }
        //check left to right diag
        if (!done) {
            countC = 0;
            countU = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i].equals(user)) {
                    countU++;
                }
                if (board[i][i].equals(comp)) {
                    countC++;
                }
            }
            if (countC == 2 || countU == 2) {
                for (int i = 0; i < board.length; i++) {
                    if (!board[i][i].equals(user) && !board[i][i].equals(comp)) {
                        board[i][i] = comp;
                        done = true;
                    }
                }
            }
        }
        //check right to left diag
        if (!done) {
            countC = 0;
            countU = 0;
            int i = 0, j = 2;
            while (i <= 2 && j >= 0) {
                if (board[i][j].equals(user)) {
                    countU++;
                }
                if (board[i][j].equals(comp)) {
                    countC++;
                }
                i++;
                j--;
            }
            if (countC == 2 || countU == 2) {
                i = 0;
                j = 2;
                while (i <= 2 && j >= 0) {
                    if (!board[i][j].equals(user) && !board[i][j].equals(comp)) {
                        row = i;
                        col = j;
                    }
                    i++;
                    j--;
                }
                board[row][col] = comp;
                done = true;
            }
        }
        //check for only one C, no U in rows
        if (!done) {
            for (int i = 0; i < board.length; i++) {
                if (!done) {
                    countC = 0;
                    countU = 0;
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j].equals(user)) {
                            countU++;
                        }
                        if (board[i][j].equals(comp)) {
                            countC++;
                        }
                    }
                    if (countC == 1 && countU == 0) {
                        for (int j = 0; j < board[i].length; j++) {
                            if (!board[i][j].equals(user) && !board[i][j].equals(comp)) {
                                board[i][j] = comp;
                                done = true;

                            }
                        }
                    }
                }
            }
        }
        //check 1 C no U in columns
        if (!done) {
            for (int i = 0; i < board[0].length; i++) {
                if (!done) {
                    countC = 0;
                    countU = 0;
                    for (int j = 0; j < board.length; j++) {
                        if (board[j][i].equals(user)) {
                            countU++;
                        }
                        if (board[j][i].equals(comp)) {
                            countC++;
                        }
                    }
                    if (countC == 1 && countU == 0) {
                        for (int j = 0; j < board.length; j++) {
                            if (!board[j][i].equals(user) && !board[j][i].equals(comp)) {
                                board[j][i] = comp;
                                done = true;
                            }
                        }
                    }
                }
            }
        }
        //check 1 C no U in left to right diag
        if (!done) {
            countC = 0;
            countU = 0;
            int i = 0, j = 2;
            while (i <= 2 && j >= 0) {
                if (board[i][j].equals(user)) {
                    countU++;
                }
                if (board[i][j].equals(comp)) {
                    countC++;
                }
                i++;
                j--;
            }
            if (countC == 1 && countU == 0) {
                i = 0;
                j = 2;
                while (i <= 2 && j >= 0) {
                    if (!board[i][j].equals(user) && !board[i][j].equals(comp)) {
                        board[i][j] = comp;
                        done = true;
                    }
                    i++;
                    j--;
                }
            }
        }
        //check 1 C no U in right to left diag
        if (!done) {
            countC = 0;
            countU = 0;
            int i = 0, j = 2;
            while (i <= 2 && j >= 0) {
                if (board[i][j].equals(user)) {
                    countU++;
                }
                if (board[i][j].equals(comp)) {
                    countC++;
                }
                i++;
                j--;
            }
            if (countC == 1 || countU == 0) {
                i = 0;
                j = 2;
                while (i <= 2 && j >= 0) {
                    if (!board[i][j].equals(user) && !board[i][j].equals(comp)) {
                        row = i;
                        col = j;
                    }
                    i++;
                    j--;
                }
                board[row][col] = comp;
                done = true;
            }
        }
        //pick random spot
        if (!done) {
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
            //check spot
            while (board[row][col].equals(user) || board[row][col].equals(comp)) {
                row = (int) (Math.random() * 3);
                col = (int) (Math.random() * 3);
            }
            board[row][col] = comp;
            done = true;
        }
        //print board
        System.out.println(this);
        //check if cat's game
        if (catsGame()) {
            cats++;
            System.out.println("It's a cat's game! Would you like to play again?");
            playAgain();
        } else {
            //check winner, go to user's turn
            winner = determineWinner();
            if (winner.equals("nobody won :(")) {
                userTurn();
            } else {
                System.out.println(winner);
                playAgain();
            }
        }
    }

    public void userTurn() {
        String winner;
        System.out.println("YOUR TURN");
        String ans;
        boolean found = false;
        //ask spot
        System.out.print("What spot are you picking? ");
        ans = Keyboard.readString();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(ans)) {
                    found = true;
                }
            }
        }
        //check validity
        while (found = false) {
            System.out.print("Please pick a spot shown on the board: ");
            ans = Keyboard.readString();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals(ans)) {
                        found = true;
                    }
                }
            }
        }
        //fill spot
        if (ans.equals("1")) {
            board[0][0] = user;
        } else if (ans.equals("2")) {
            board[0][1] = user;
        } else if (ans.equals("3")) {
            board[0][2] = user;
        } else if (ans.equals("4")) {
            board[1][0] = user;
        } else if (ans.equals("5")) {
            board[1][1] = user;
        } else if (ans.equals("6")) {
            board[1][2] = user;
        } else if (ans.equals("7")) {
            board[2][0] = user;
        } else if (ans.equals("8")) {
            board[2][1] = user;
        } else {
            board[2][2] = user;
        }
        System.out.println(this);
        //check if cat's game
        if (catsGame()) {
            cats++;
            System.out.println("It's a cat's game! Would you like to play again?");
            playAgain();
        } else {
            winner = determineWinner();
            //check winner, go to comp turn
            if (winner.equals("nobody won :(")) {
                compTurn();
            } else {
                System.out.println(winner);
                playAgain();
            }
        }
    }

    public void playAgain() {
        int ran = (int) (Math.random() * 2);
        String ans = Keyboard.readString();
        if (ans.equalsIgnoreCase("yes")) {
            if (ran == 0) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        board[j][i] = "" + ((j * 3) + (i + 1));
                    }
                }
                System.out.println("\nBoard:\n" + this);
                userTurn();
            } else {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        board[j][i] = "" + ((j * 3) + (i + 1));
                    }
                }
                System.out.println("\nBoard:\n" + this);
                compTurn();
            }
        } else {
            stats();
        }
    }

    public String determineWinner() {
        //USER
        if (board[0][0].equals(user) && board[0][1].equals(user) && board[0][2].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        } else if (board[1][0].equals(user) && board[1][1].equals(user) && board[1][2].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        } else if (board[2][0].equals(user) && board[2][1].equals(user) && board[2][2].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        } else if (board[0][0].equals(user) && board[1][0].equals(user) && board[2][0].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        } else if (board[0][1].equals(user) && board[1][1].equals(user) && board[2][1].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        } else if (board[0][2].equals(user) && board[1][2].equals(user) && board[2][2].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        } else if (board[0][0].equals(user) && board[1][1].equals(user) && board[2][2].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        } else if (board[0][2].equals(user) && board[1][1].equals(user) && board[2][0].equals(user)) {
            userWins++;
            return "YOU WON! Would you like to play again?";
        }
        //COMPUTER
        if (board[0][0].equals(comp) && board[0][1].equals(comp) && board[0][2].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        } else if (board[1][0].equals(comp) && board[1][1].equals(comp) && board[1][2].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        } else if (board[2][0].equals(comp) && board[2][1].equals(comp) && board[2][2].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        } else if (board[0][0].equals(comp) && board[1][0].equals(comp) && board[2][0].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        } else if (board[0][1].equals(comp) && board[1][1].equals(comp) && board[2][1].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        } else if (board[0][2].equals(comp) && board[1][2].equals(comp) && board[2][2].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        } else if (board[0][0].equals(comp) && board[1][1].equals(comp) && board[2][2].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        } else if (board[0][2].equals(comp) && board[1][1].equals(comp) && board[2][0].equals(comp)) {
            compWins++;
            return "The computer won. Would you like to play again?";
        }
        return "nobody won :(";
    }

    public boolean catsGame() {
        boolean cat = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!(board[i][j].equals(user) || board[i][j].equals(comp))) {
                    cat = false;
                }
            }
        }
        return cat;
    }

    public void stats() {
        System.out.println("Stats for all games played:\n"
                + "You won " + userWins + " times, which was " + (((double) userWins / (userWins + compWins + cats)) * 100) + "% of the total games played.\n"
                + "The computer won " + compWins + " times, which was " + (((double) compWins / (userWins + compWins + cats)) * 100) + "% of the total games played.\n"
                + "There were " + cats + " cat's games, which was " + (((double) cats / (userWins + compWins + cats)) * 100) + "% of the total games played.\n"
                + "Thank you for playing!");
    }

    @Override
    public String toString() {
        String print = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                print += board[i][j] + " ";
            }
            print += "\n";
        }
        return print;
    }
}
