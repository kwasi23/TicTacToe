import javax.swing.JButton;  // Import JButton class to use GUI button functionalities.

// Define the TicTacToeTile class, which extends JButton, meaning it inherits all of JButton’s functionalities.
public class TicTacToeTile extends JButton {

    // Define two private integer variables to store the row and column information of a TicTacToeTile instance.
    private int row;
    private int col;

    // Constructor of TicTacToeTile class, which gets row and column as parameters.
    public TicTacToeTile(int row, int col) {
        super();  // Calls the constructor of the superclass (JButton). This is used to initialize the component’s state.
        this.row = row;  // Assigns the value of the parameter row to the class variable row.
        this.col = col;  // Assigns the value of the parameter col to the class variable col.
    }

    // Method to get the value of row. This is a ‘getter’ method which allows retrieval of the private variable row.
    public int getRow() {
        return row;  // Return the value of the variable row.
    }

    // Method to get the value of col. This is a ‘getter’ method which allows retrieval of the private variable col.
    public int getCol() {
        return col;  // Return the value of the variable col.
    }
}
