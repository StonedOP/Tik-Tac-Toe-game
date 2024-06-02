import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    //creating an empty board by using 2d Arrays technique
    //we take input as the coordinates of a 2d array to place the x or o
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        //we need a function for win condition
        char player = 'X';//initially let the player is X and then we switch it
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameover) {
            printBoard(board);
            System.out.print("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
//we add after checking if the box is empty
//
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameover = haveWon(board, player);
                if ( gameover){
                    System.out.println("Player " + player + "has won ");
                }else {
                    player = player == 'X' ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid input , plz try again");
            }
        }
        printBoard(board);
    }
//we check all the condition where the player win
    private static boolean haveWon(char[][] board, char player) {
        //check for row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // check for col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        //check for diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }


    private static void printBoard ( char[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}