package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game("_________");

        game.printBoard();

        char Player = 'X';

        while (true) {
            game.makeMove(input, Player);
            game.printBoard();

            String state = game.WorL();
            if (!state.equals("Game not finished")) {
                System.out.println(state);
                break;
            }

            Player = (Player == 'X') ? 'O' : 'X';
        }
    }
}

class Game {
    private String cells;

    public Game(String cells) {
        this.cells = cells;
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                char c = cells.charAt(i * 3 + j);
                if (c == '_') c = ' ';
                System.out.print(c + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void makeMove(Scanner input, char player) {
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Enter the coordinates: ");
            String line = input.nextLine();
            String[] parts = line.split(" ");

            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row, col;

            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            int index = (row - 1) * 3 + (col - 1);
            if (cells.charAt(index) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            cells = cells.substring(0, index) + player + cells.substring(index + 1);
            validMove = true;
        }
    }

    public String WorL() {
        boolean xWins = checkWin('X');
        boolean oWins = checkWin('O');

        if (xWins) return "X wins";
        if (oWins) return "O wins";
        if (cells.contains("_")) return "Game not finished";
        return "Draw";
    }

    private boolean checkWin(char p) {
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
