package model;

import javax.swing.*;

public class GameButton extends JButton {
    public final int position;

    public GameButton(int position) {
        super();
        this.position = position;
    }
}
public class Player {
    private final ArrayList<Integer> moves = new ArrayList<>();

    public void addMove(int position) {
        moves.add(position);
    }

    public ArrayList<Integer> getMoves() {
        return moves;
    }

    public boolean hasWon(int[] combo) {
        for (int pos : combo) {
            if (!moves.contains(pos)) return false;
        }
        return true;
    }
}

