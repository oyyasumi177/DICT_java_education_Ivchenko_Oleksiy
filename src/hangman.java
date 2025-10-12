import javax.crypto.SecretKey;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        // Stage 1
        System.out.println("HANGMAN");
        System.out.println("The game will be able soon");
        // Stage 2
        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        String stage2 = input.nextLine();
        String secret = "java";
        if (stage2.equals("java")){
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
        // Stage 3
        System.out.println("HANGMAN");
        String[] w = {"python", "java", "javascript", "kotlin"};

        int index = rand.nextInt(w.length);
        String secret2 = w[index];
        System.out.print("Guess the word: > ");
        String stage3 = input.nextLine();
        if (stage2.equals(secret2)){
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
