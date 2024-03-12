import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTBoard implements ActionListener {

    private static final int ROW = 3;
    private static final int COL = 3;
    public static String[][] board = new String[ROW][COL];
    public static JFrame frame;
    private JPanel mainPanel;
    private JPanel bottomPnl;
    public static JButton[] buttons = new JButton[9];
    private boolean xTurn = true;
    private int moveCount = 0;
    private TTTGame game;

    public TTTBoard() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this::actionPerformed); // Adding action listener to handle button clicks
            mainPanel.add(buttons[i]);
        }

        JButton againBtn = new JButton("Play Again?");
        againBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearBoardGUI();
            }
        });
        bottomPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton quitBtn = new JButton("Quit");
        bottomPnl.add(quitBtn);
        quitBtn.addActionListener(new QuitListener());
        bottomPnl.add(againBtn);
        frame.add(bottomPnl, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setSize(400, 400);
        frame.setVisible(true);

      //  game = new TTTGame();
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

        TTTGame.checkForWinner();
        moveCount++;

        if (moveCount >= 9 && !TTTGame.winnerFound) {
            TTTGame.checkTie();
        }
    }
    private void clearBoardGUI() {
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(true);
        }
    }
}
