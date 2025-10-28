package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public  static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cells: ");
        String cells = input.nextLine();

        if (cells.length() != 9){
            System.out.println("Invalid input");
            return;
        }
        for (int i = 0; i < cells.length(); i++) {
            char c = cells.charAt(i);
            if (c != 'X' && c != 'O' && c != '_') {
                System.out.println("Error:");
                return;
            }
        }

        System.out.println("---------");
        System.out.println("| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |");
        System.out.println("| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |");
        System.out.println("| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |");
        System.out.println("---------");
    }
}
