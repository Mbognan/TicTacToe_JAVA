import java.util.Scanner;

public class App {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private char currentPlayer = PLAYER_X;

    private Scanner scanner = new Scanner(System.in);

    public App() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = EMPTY_CELL;
            }
        }
    }

    public void playGame() {
        while (true) {
            displayBoard();

            System.out.println("Player " + currentPlayer + ", enter row and column (e.g., 0 1): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;

                if (hasPlayerWon(currentPlayer)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY_CELL;
    }

    private boolean hasPlayerWon(char player) {
        // Implement your logic to check for a win
        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    private void displayBoard() {
        System.out.println("Current board:");
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < BOARD_SIZE - 1) {
                System.out.println("---------");
            }
        }
    }

    public static void main(String[] args) {
        App game = new App();
        game.playGame();
    }
}
