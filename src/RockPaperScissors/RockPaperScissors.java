package RockPaperScissors;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();   
        String comp = "";

        switch (user) {
            case "rock":
                comp = "paper";
                break;
            case "paper":
                comp = "scissors";
                break;
            case "scissors":
                comp = "rock";
                break;
        }

        System.out.println("Sorry, but the computer chose " + comp);
    }
}

