import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameEnded = false;

        System.out.println("Tic Tac Toe Game Started!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter row and column (0, 1, or 2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (isValid(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isDraw()) {
                    System.out.println("Game is a draw.");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        sc.close();
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == ' ';
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer) return true;

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer) return true;
        }

        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer) return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer) return true;

        return false;
    }

    static boolean isDraw() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }

    static void printBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}