package com.example.demo.recursive.eightqueen;


public class Queen {

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x;

    public int y;

    boolean isCorrect(Queen[] queens) {

        boolean result = true;

        for (int i = 0; i < y; i++) {
            if (queens[i] != null) {
                if (!this.isCorrect(queens[i])) {
                    return false;
                }
            }
        }
        return result;
    }

    boolean isCorrect(Queen queen) {
        if (this.x == queen.x
                || this.y == queen.y
                || this.x + this.y == queen.x + queen.y
                || this.y - this.x == queen.y - queen.x) {
            return false;
        }
        return true;

    }
}
