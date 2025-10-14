import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Stage 6
        System.out.println("HANGMAN");
        String[] w = {"python", "java", "javascript", "kotlin"};
        int index = rand.nextInt(w.length);
        String secret2 = w[index];

        char[] stage4 = new char[secret2.length()];
        for (int i = 0; i < stage4.length; i++) {
            stage4[i] = '-';
        }

        int attempts = 8;
        String stage6 = "";

        while (attempts > 0) {
            System.out.println(new String(stage4));
            System.out.print("Input your a letter: ");
            String stage3 = input.nextLine();
            if (stage3.length() != 1) {
                System.out.println("Please, a single letter.");
                continue;
            }

            char stage5 = stage3.charAt(0);
            if (stage6.indexOf(stage5) != -1) {
                System.out.println("No improvements");
                attempts--;
                continue;
            }
            stage6 += stage5;
            boolean found = false;

            for (int i = 0; i < secret2.length(); i++) {
                if (secret2.charAt(i) == stage5) {
                    stage4[i] = stage5;
                    found = true;
                }
            }

            if (!found) {
                System.out.println("That letter doesn't appear in the word.");
                attempts--;
            } else if (new String(stage4).equals(secret2)) {
                System.out.println(secret2);
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                return;
            }
        }

        System.out.println("You lost!");

    }
}
