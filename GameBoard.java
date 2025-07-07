package game;

import model.GameButton;
import logic.GameLogic;

import javax.swing.*;
import java.awt.*;

public class GameBoard {
    JFrame frame = new JFrame("Tic Tac Toe");
    JPanel panel = new JPanel(new GridLayout(3, 3));
    GameButton[] buttons = new GameButton[9];
    GameLogic logic;

    String playerOneName;
    String playerTwoName;

    public GameBoard(String p1, String p2) {
        this.playerOneName = p1;
        this.playerTwoName = p2;
        this.logic = new GameLogic(p1, p2);
    }

    public void drawGrid() {
        panel.setBackground(new Color(173, 216, 230));

        for (int i = 0; i < 9; i++) {
            final int pos = i + 1;
            buttons[i] = new GameButton(pos);
            buttons[i].setFont(new Font("Calibri", Font.BOLD, 36));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusPainted(false);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            buttons[i].addActionListener(e -> logic.handleMove((GameButton) e.getSource()));
            panel.add(buttons[i]);
        }

        logic.setButtons(buttons);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
