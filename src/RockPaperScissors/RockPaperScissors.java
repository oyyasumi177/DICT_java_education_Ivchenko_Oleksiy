package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();

        String[] options = {"rock", "paper", "scissors"};

        Random random = new Random();
        String comp = options[random.nextInt(3)];

        if (user.equals(comp)) {
            System.out.println("There is a draw (" + comp + ")");
        } else if (
                (user.equals("rock") && comp.equals("scissors")) ||
                        (user.equals("scissors") && comp.equals("paper")) ||
                        (user.equals("paper") && comp.equals("rock"))
        ) {
            System.out.println("Well done. The computer chose " + comp + " and failed");
        } else {
            System.out.println("Sorry, but the computer chose " + comp);
        }
    }
}
