package RockPaperScissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class GameLogic {

    private List<String> options;

    GameLogic(List<String> options) {
        this.options = options;
    }

    String getResult(String user, String comp) {
        if (user.equals(comp)) {
            return "draw";
        }

        int index = options.indexOf(user);

        List<String> rotated = new ArrayList<>();
        rotated.addAll(options.subList(index + 1, options.size()));
        rotated.addAll(options.subList(0, index));

        int half = rotated.size() / 2;
        List<String> beatsUser = rotated.subList(0, half);

        return beatsUser.contains(comp) ? "lose" : "win";
    }
}

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        int rating = loadRating(name);

        String inputOptions = scanner.nextLine().trim();

        List<String> options = new ArrayList<>();

        if (inputOptions.isEmpty()) {
            options = Arrays.asList("rock", "paper", "scissors");
        } else {
            for (String s : inputOptions.split(",")) {
                options.add(s.trim());
            }
        }

        GameLogic logic = new GameLogic(options);

        System.out.println("Okay, let's start");

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

            if (!options.contains(user)) {
                System.out.println("Invalid input");
                continue;
            }

            String comp = options.get(random.nextInt(options.size()));
            String result = logic.getResult(user, comp);

            switch (result) {
                case "draw":
                    System.out.println("There is a draw (" + comp + ")");
                    rating += 50;
                    break;

                case "win":
                    System.out.println("Well done. The computer chose " + comp + " and failed");
                    rating += 100;
                    break;

                case "lose":
                    System.out.println("Sorry, but the computer chose " + comp);
                    break;
            }
        }
    }

    private static int loadRating(String name) {
        int rating = 0;

        try {
            File file = new File("rating.txt");
            Scanner f = new Scanner(file);

            while (f.hasNext()) {
                String user = f.next();
                int score = f.nextInt();
                if (user.equals(name)) {
                    rating = score;
                }
            }

            f.close();
        } catch (FileNotFoundException ignored) {}

        return rating;
    }
}

