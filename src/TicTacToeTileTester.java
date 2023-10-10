import javax.swing.*;
import java.awt.*;

// Definition of TicTacToeTileTester class, extending JFrame to use GUI functionalities.
public class TicTacToeTileTester extends JFrame {
    // 3x3 matrix to represent the TicTacToe board visually with buttons.
    private TicTacToeTile[][] board;
    // Game logic handling object.
    private TicTacToe game;
    // String to keep track of whose turn it is to play.
    private String currentPlayer = "X";
    // Variables to keep track of wins by X and O, and ties.
    private int xWins = 0;
    private int oWins = 0;
    private int ties = 0;

    // Constructor of the TicTacToeTileTester class, where GUI is set up.
    public TicTacToeTileTester() {
        // Set the title of the GUI window.
        super("Tic Tac Toe");
        // Set layout of the GUI to be a 3x3 grid.
        setLayout(new GridLayout(3, 3));
        // Set size of the GUI window.
        setSize(400, 400);
        // Set default close operation.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Initialize the board array and game object.
        board = new TicTacToeTile[3][3];
        game = new TicTacToe();

        // Nested for loop to initialize each button in the 3x3 grid.
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                // Create new button, provide its position as arguments and assign it to board[i][j].
                board[i][j] = new TicTacToeTile(i, j);
                // Add ActionListener to button to listen for clicks and trigger makeMove method.
                board[i][j].addActionListener(e -> makeMove((TicTacToeTile) e.getSource()));
                // Add button to the GUI.
                add(board[i][j]);
            }
        }
    }

    // Method to handle button clicks/moves.
    private void makeMove(TicTacToeTile tile) {
        // Retrieve the row and column of the clicked button.
        int row = tile.getRow();
        int col = tile.getCol();
        // Make a move using game logic. If move is valid...
        if(game.makeMove(row, col, currentPlayer)) {
            // Update text of clicked button to the current player's symbol.
            tile.setText(currentPlayer);
            // Check if the move resulted in a win.
            if(game.checkWin(currentPlayer)) {
                // Update score board accordingly.
                updateScore(currentPlayer.equals("X") ? "X" : "O");
                // Display winning message.
                JOptionPane.showMessageDialog(this, currentPlayer + " Wins!\nX: " + xWins + " wins\nO: " + oWins + " wins\nTies: " + ties);
                // Reset the game board.
                resetGame();
                // Prompt the user to play again.
                promptPlayAgain();
                // Check if the board is full without a winner.
            } else if(game.isBoardFull()) {
                // Update score board for a tie.
                updateScore("Tie");
                // Display tie message.
                JOptionPane.showMessageDialog(this, "It's a tie!\nX: " + xWins + " wins\nO: " + oWins + " wins\nTies: " + ties);
                // Reset the game board.
                resetGame();
                // Prompt the user to play again.
                promptPlayAgain();
                // If no win and board is not full, switch player.
            } else {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }
            // If move is not valid...
        } else {
            // Display error message.
            JOptionPane.showMessageDialog(this, "Invalid Move!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to update the score variables based on the outcome of a game.
    private void updateScore(String result) {
        // If X wins, increment xWins; if O wins, increment oWins; if tie, increment ties.
        switch(result) {
            case "X": xWins++; break;
            case "O": oWins++; break;
            case "Tie": ties++; break;
        }
    }

    // Method to ask the user if they want to play again after a game concludes.
    private void promptPlayAgain() {
        // Show a dialog box with 'yes' and 'no' options.
        int input = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        // If the user chooses 'no'...
        if(input != JOptionPane.YES_OPTION){
            // Terminate the application.
            System.exit(0);
        }
    }

    // Method to reset the game to its initial state.
    private void resetGame() {
        // Clear logical game board.
        game.resetBoard();
        // Clear visual GUI board.
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j].setText("");
        // Set the starting player to be X.
        currentPlayer = "X";
    }

    // Main method to launch the GUI application.
    public static void main(String[] args) {
        // Ensure GUI updates are made on the Event Dispatch Thread.
        SwingUtilities.invokeLater(() -> {
            // Create TicTacToeTileTester object and make it visible.
            new TicTacToeTileTester().setVisible(true);
        });
    }
}
