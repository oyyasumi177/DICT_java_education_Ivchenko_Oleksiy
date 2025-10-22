package CoffeeMachine;

import java.util.Scanner;

class Cup {
    private static final int water = 200;
    private static final int milk = 50;
    private static final int beans = 15;

    public static void calculateIngredients(int cups) {
        int waterTotal = water * cups;
        int milkTotal = milk * cups;
        int beansTotal = beans * cups;

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(waterTotal + " ml of water");
        System.out.println(milkTotal + " ml of milk");
        System.out.println(beansTotal + " g of coffee beans");
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = input.nextInt();

        Cup.calculateIngredients(cups);
        
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}

