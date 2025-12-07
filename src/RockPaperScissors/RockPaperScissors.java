package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"rock", "paper", "scissors"};

        while (true) {

            String user = scanner.nextLine();

            if (user.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }

            if (!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")) {
                System.out.println("Invalid input");
                continue;
            }

            String comp = options[random.nextInt(3)];

            if (user.equals(comp)) {
                System.out.println("There is a draw (" + comp + ")");
            }
            else if (
                    (user.equals("rock") && comp.equals("scissors")) ||
                            (user.equals("scissors") && comp.equals("paper")) ||
                            (user.equals("paper") && comp.equals("rock"))
            ) {
                System.out.println("Well done. The computer chose " + comp + " and failed");
            }
            else {
                System.out.println("Sorry, but the computer chose " + comp);
            }
        }
    }
}
