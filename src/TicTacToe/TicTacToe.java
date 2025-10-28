package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = input.nextLine();
        Game game = new Game(cells);

        if (!game.validateInput()) {
            System.out.println("Error:");
            return;
        }

        game.printBoard();
        System.out.println(game.WorL());
    }
}

class Game {
    private String cells;

    public Game(String cells) {
        this.cells = cells;
    }

    public boolean validateInput() {
        for (int i = 0; i < cells.length(); i++) {
            char c = cells.charAt(i);
            if (c != 'X' && c != 'O' && c != '_') {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public String WorL() {
        int xCount = 0;
        int oCount = 0;
        for (char c : cells.toCharArray()) {
            if (c == 'X') xCount++;
            if (c == 'O') oCount++;
        }

        boolean xWins = checkWin('X');
        boolean oWins = checkWin('O');

        if (Math.abs(xCount - oCount) > 1 || (xWins && oWins)) {
            return "Impossible";
        } else if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else if (cells.contains("_")) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    private boolean checkWin(char player) {
        char p = player;

        if (cells.charAt(0) == p && cells.charAt(1) == p && cells.charAt(2) == p) return true;
        if (cells.charAt(3) == p && cells.charAt(4) == p && cells.charAt(5) == p) return true;
        if (cells.charAt(6) == p && cells.charAt(7) == p && cells.charAt(8) == p) return true;

        if (cells.charAt(0) == p && cells.charAt(3) == p && cells.charAt(6) == p) return true;
        if (cells.charAt(1) == p && cells.charAt(4) == p && cells.charAt(7) == p) return true;
        if (cells.charAt(2) == p && cells.charAt(5) == p && cells.charAt(8) == p) return true;
       
        if (cells.charAt(0) == p && cells.charAt(4) == p && cells.charAt(8) == p) return true;
        if (cells.charAt(2) == p && cells.charAt(4) == p && cells.charAt(6) == p) return true;
        return false;
    }
}