package CoffeeMachine;

import java.util.Scanner;

class Cup {
    private static final int waterPerCup = 200;
    private static final int milkPerCup = 50;
    private static final int beansPerCup = 15;

    public static int calculateIngredients(int water, int milk, int beans) {
        int Watercups = water / waterPerCup;
        int Milkcups = milk / milkPerCup;
        int Beanscups = beans / beansPerCup;
        return Math.min(Watercups, Math.min(Milkcups, Beanscups));
    }
}
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = input.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = input.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = input.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int Cupsneeded = input.nextInt();

        int possibleCups = Cup.calculateIngredients(water, milk, beans);
        if (possibleCups == Cupsneeded) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCups > Cupsneeded) {
            int extra = possibleCups - Cupsneeded;
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }

    }
}

