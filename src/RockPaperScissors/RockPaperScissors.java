package RockPaperScissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        int rating = 0;

        try {
            File file = new File("rating.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                String userName = fileScanner.next();
                int userScore = fileScanner.nextInt();

                if (userName.equals(name)) {
                    rating = userScore;
                    break;
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
        }

        String[] options = {"rock", "paper", "scissors"};

        while (true) {

            String user = scanner.nextLine();

            if (user.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }

            if (user.equals("!rating")) {
                System.out.println("Your rating: " + rating);
                continue;
            }

            if (!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")) {
                System.out.println("Invalid input");
                continue;
            }

            String comp = options[random.nextInt(3)];

            if (user.equals(comp)) {
                System.out.println("There is a draw (" + comp + ")");
                rating += 50;
            }
            else if (
                    (user.equals("rock") && comp.equals("scissors")) ||
                            (user.equals("scissors") && comp.equals("paper")) ||
                            (user.equals("paper") && comp.equals("rock"))
            ) {
                System.out.println("Well done. The computer chose " + comp + " and failed");
                rating += 100;
            }
            else {
                System.out.println("Sorry, but the computer chose " + comp);
            }
        }
    }
}
