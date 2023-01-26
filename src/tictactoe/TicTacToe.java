package tictactoe;

public class TicTacToe {

    public static void main(String[] args) {
        /*
        if comp goes first and i pick 1 it takes the next 2 turns to finish off the row
        it also picked spot 7 both times
        */
        Board game = new Board();
        System.out.println("Directions:\nEach spot on the board is numbered.\n" + 
                "When it is your turn, pick a number visible on the board.\n" + 
                "That number will be replaced with a U.\n" + 
                "The computer's choice will be marked with a C.\n" + 
                "If you pick a number not visible on the board you will be asked to pick again.\n" + 
                "Please do not enter a number not between 1 and 9.\n" +
                "Have fun!\n");
        System.out.println("Board:\n" + game);
        game.userTurn();
    }
    
}
