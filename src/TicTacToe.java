// Definition of the TicTacToe class.
public class TicTacToe {
    // A 3x3 matrix representing the game board, initialized as an empty board.
    // Each string can be "", "X", or "O".
    private String[][] board = new String[3][3];

    // The constructor of the TicTacToe class, which is called when an instance of the class is created.
    public TicTacToe() {
        resetBoard();  // Calls the resetBoard method to initialize the board when a TicTacToe object is created.
    }

    // Method to reset the game board, setting every position to an empty string.
    public void resetBoard() {
        for(int i = 0; i < 3; i++)  // Loop through each row.
            for(int j = 0; j < 3; j++)  // Loop through each column in the current row.
                board[i][j] = "";  // Set the current tile to be empty.
    }

    // Method to make a move on the board.
    // Takes the row and column to move to, and the player ("X" or "O") as parameters.
    public boolean makeMove(int row, int col, String player) {
        if("".equals(board[row][col])) {  // Check if the targeted position on the board is empty.
            board[row][col] = player;  // If it is, set the board position to the current player’s string.
            return true;  // Move was successful, return true.
        }
        return false;  // Move was not successful (target was not empty), return false.
    }

    // Method to check if the specified player has won. Takes the player string ("X" or "O") as a parameter.
    public boolean checkWin(String player) {
        for (int i = 0; i < 3; i++) {  // Loop through each row.
            // Check for a win in the current row or column.
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player))
                return true;  // Player won horizontally.
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))
                return true;  // Player won vertically.
        }
        // Check for a win in the two diagonals.
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
            return true;  // Player won on the descending diagonal.
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
            return true;  // Player won on the ascending diagonal.

        return false;  // No win found, return false.
    }

    // Method to check if the board is full, returning a boolean.
    public boolean isBoardFull() {
        for(int i = 0; i < 3; i++)  // Loop through each row.
            for(int j = 0; j < 3; j++)  // Loop through each column in the current row.
                if("".equals(board[i][j]))  // If any position is empty,
                    return false;  // The board is not full, return false.
        return true;  // All positions were checked and none were empty, so the board is full, return true.
    }
}
