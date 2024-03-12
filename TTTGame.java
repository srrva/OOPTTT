import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TTTGame extends TTTBoard implements ActionListener {

  //  static JFrame frame = new JFrame();
   private static final int ROW = 3;
    private static final int COL = 3;
    public static String[][] board = new String[ROW][COL];
    public static boolean winnerFound = false;
    public static int moveCount = 0;
    public static boolean xTurn = true;

    public static void checkForWinner() {
        // this for loops checks rows for a winner
        for (int i = 0; i < 9; i += 3) {
            if (TTTBoard.buttons[i].getText().equals(TTTBoard.buttons[i + 1].getText()) && TTTBoard.buttons[i].getText().equals(TTTBoard.buttons[i + 2].getText()) && !TTTBoard.buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, TTTBoard.buttons[i].getText() + " Wins!!");
                return;
            }
        }
        // checks columns for a winner
        for (int i = 0; i < 3; i++) {
            if (TTTBoard.buttons[i].getText().equals(TTTBoard.buttons[i + 3].getText()) && TTTBoard.buttons[i].getText().equals(TTTBoard.buttons[i + 6].getText()) && !TTTBoard.buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, TTTBoard.buttons[i].getText() + " Wins!!");
            }
        }
        if (TTTBoard.buttons[0].getText().equals(TTTBoard.buttons[4].getText()) && TTTBoard.buttons[0].getText().equals(TTTBoard.buttons[8].getText()) && !TTTBoard.buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, TTTBoard.buttons[0].getText() + " Wins!!");
            return;
        }
        if (TTTBoard.buttons[2].getText().equals(TTTBoard.buttons[4].getText()) && TTTBoard.buttons[2].getText().equals(TTTBoard.buttons[6].getText()) && !TTTBoard.buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, TTTBoard.buttons[2].getText() + " Wins!!");
        }
    }
    public static boolean checkTie() {
        boolean boardFull = true;
        for (int i = 0; i < 3; i++) {
            for (int z = 0; z < 3; z++) {
                if (board[i][z] == null || "".equals(board[i][z]) || " ".equals(board[i][z])) {
                    boardFull = false;
                    break;
                }
            }
        }
        if (!boardFull) {
            JOptionPane.showMessageDialog(null, "Full Board Tie!");
        }
        return true;
    }
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        if (xTurn){
            button.setText("X");
        }
        else {
            button.setText("O");
        }
        button.setEnabled(false);
        xTurn = !xTurn;

        checkForWinner();
        moveCount++;

        if (moveCount >= 9 && !winnerFound) {

            checkTie();
        }
    }
    /*public static void main(String[] args) {
        new TTTBoard();
        frame.setVisible(true);
        frame.setSize(400, 400);
    }*/
}