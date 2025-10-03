package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! My name is IvchenkoBot");
        System.out.println("I was created in 2025");
        System.out.println("Please, remind me your name");
        String Mynameis = input.nextLine();
        System.out.println("What a great name you have," + Mynameis + "!");
    }
}
