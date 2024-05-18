import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            playGame();
            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing Tic-Tac-Toe!");
    }

    private static void playGame() {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameWon = false;
        int moves = 0;

        while (!gameWon && moves < 9) {
            displayBoard(board);
            int[] move = getPlayerMove(currentPlayer);
            int row = move[0];
            int col = move[1];

            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer);
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                moves++;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        displayBoard(board);
        printResult(gameWon, moves);
    }

    private static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int[] getPlayerMove(char player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + player + ", enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static void printResult(boolean gameWon, int moves) {
        if (gameWon) {
            System.out.println("Congratulations! Player wins!");
        } else if (moves == 9) {
            System.out.println("It's a draw!");
        }
    }
}
