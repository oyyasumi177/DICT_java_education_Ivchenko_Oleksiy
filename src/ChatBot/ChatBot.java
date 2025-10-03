package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Stage 1
        System.out.println("Hello! My name is SlimBot");
        System.out.println("I was created in 2025");
        //Stage 2
        System.out.println("Please, remind me your name");
        String Mynameis = input.nextLine();
        System.out.println("What a great name you have, " + Mynameis + "!");
        //Stage 3
        System.out.println("Let me guess your age");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int r1 = input.nextInt();
        int r2 = input.nextInt();
        int r3 = input.nextInt();
        int age = (r1 * 70 + r2 * 21 + r3 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }
}
