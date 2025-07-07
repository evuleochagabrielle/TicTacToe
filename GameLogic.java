package logic;

import model.GameButton;
import model.Player;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameLogic {
    private final Player playerOne = new Player();
    private final Player playerTwo = new Player();
    private final String p1Name;
    private final String p2Name;
    private GameButton[] buttons;
    private int flag = 0;

    public GameLogic(String p1, String p2) {
        this.p1Name = p1;
        this.p2Name = p2;
    }

    public void setButtons(GameButton[] buttons) {
        this.buttons = buttons;
    }

    public void handleMove(GameButton btn) {
        if (flag == 0) {
            playerOne.addMove(btn.position);
            btn.setText("X");
            btn.setForeground(Color.RED);
            flag = 1;
        } else {
            playerTwo.addMove(btn.position);
            btn.setText("O");
            btn.setForeground(new Color(0, 128, 0));
            flag = 0;
        }
        btn.setEnabled(false);
        checkWin();
    }

    private void checkWin() {
        int[][] winConditions = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
                {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
                {1, 5, 9}, {3, 5, 7}
        };

        for (int[] win : winConditions) {
            if (playerOne.hasWon(win)) {
                announceWinner(p1Name);
                return;
            } else if (playerTwo.hasWon(win)) {
                announceWinner(p2Name);
                return;
            }
        }

        if (playerOne.getMoves().size() + playerTwo.getMoves().size() == 9) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            playSound("victory.wav");
        }
    }

    private void announceWinner(String winner) {
        playSound("victory.wav");
        JOptionPane.showMessageDialog(null, "🎉 " + winner + " wins!");
        disableAll();
    }

    private void disableAll() {
        for (GameButton btn : buttons) {
            btn.setEnabled(false);
        }
    }

    private void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }
}
