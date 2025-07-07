package ui;

import game.GameBoard;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame {
    JTextField playerOneField;
    JTextField playerTwoField;

    public WelcomeScreen() {
        setTitle("Welcome to Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(5, 1, 10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        content.setBackground(new Color(200, 240, 230));

        JLabel label1 = new JLabel("Enter Player 1 Name (X):", SwingConstants.CENTER);
        label1.setFont(new Font("Calibri", Font.BOLD, 18));
        label1.setForeground(new Color(30, 30, 90));

        playerOneField = new JTextField();
        playerOneField.setFont(new Font("Calibri", Font.PLAIN, 18));
        playerOneField.setBackground(Color.WHITE);

        JLabel label2 = new JLabel("Enter Player 2 Name (O):", SwingConstants.CENTER);
        label2.setFont(new Font("Calibri", Font.BOLD, 18));
        label2.setForeground(new Color(30, 30, 90));

        playerTwoField = new JTextField();
        playerTwoField.setFont(new Font("Calibri", Font.PLAIN, 18));
        playerTwoField.setBackground(Color.WHITE);

        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        startButton.setBackground(new Color(30, 30, 90));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMaximumSize(new Dimension(30, 30));

        startButton.addActionListener(e -> {
            String p1 = playerOneField.getText().trim();
            String p2 = playerTwoField.getText().trim();
            if (p1.isEmpty() || p2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both player names.");
                return;
            }

            dispose();
            new GameBoard(p1, p2).drawGrid();
        });

        add(label1);
        add(playerOneField);
        add(label2);
        add(playerTwoField);
        add(startButton);

        setVisible(true);
    }
}

