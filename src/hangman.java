import javax.crypto.SecretKey;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        // Stage 4
        System.out.println("HANGMAN");
        String[] w = {"python", "java", "javascript", "kotlin"};
        int index = rand.nextInt(w.length);
        String secret2 = w[index];
        String stage4 = secret2.substring(0,2);
        for (int i = 2; i < secret2.length(); i++){
            stage4 = stage4 + "-";
        }
        System.out.print("Guess the word " + stage4 + ": > ");
        String stage3 = input.nextLine();
        if (stage3.equals(secret2)){
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
