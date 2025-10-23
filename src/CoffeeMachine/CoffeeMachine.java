package CoffeeMachine;

import java.util.Scanner;

class Cup {
    public static final int espressowater = 250;
    public static final int espressobeans = 16;
    public static final int espressocost = 4;

    public static final int lattewater = 350;
    public static final int lattemilk = 75;
    public static final int lattebeans = 20;
    public static final int lattecost = 7;

    public static final int cappuccinowater = 200;
    public static final int cappuccinomilk = 100;
    public static final int cappuccinobeans = 12;
    public static final int cappuccinocost = 6;
}
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        System.out.println("The coffee machine has:");
        printStatus(water, milk, beans, cups, money); //!

        System.out.println("Write action (buy, fill, take):");
        String action = input.next();

        switch (action) { //!
            case "buy": //!
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int choice = input.nextInt();
                if (choice == 1) {
                    if (water >= Cup.espressowater && beans >= Cup.espressobeans && cups > 0) { //  !
                        water -= Cup.espressowater;
                        beans -= Cup.espressobeans;
                        cups--;
                        money += Cup.espressocost;
                    } else {
                        System.out.println("Not enough ingredients!");
                    }
                } else if (choice == 2) {
                    if (water >= Cup.lattewater && milk >= Cup.lattemilk && beans >= Cup.lattebeans && cups > 0) {
                        water -= Cup.lattewater;
                        milk -= Cup.lattemilk;
                        beans -= Cup.lattebeans;
                        cups--;
                        money += Cup.lattecost;
                    } else {
                        System.out.println("Not enough ingredients!");
                    }
                } else if (choice == 3) { // cappuccino
                    if (water >= Cup.cappuccinowater && milk >= Cup.cappuccinomilk && beans >= Cup.cappuccinobeans && cups > 0) {
                        water -= Cup.cappuccinowater;
                        milk -= Cup.cappuccinomilk;
                        beans -= Cup.cappuccinobeans;
                        cups--;
                        money += Cup.cappuccinocost;
                    } else {
                        System.out.println("Not enough ingredients!");
                    }
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                water += input.nextInt();

                System.out.println("Write how many ml of milk you want to add:");
                milk += input.nextInt();

                System.out.println("Write how many grams of coffee beans you want to add:");
                beans += input.nextInt();

                System.out.println("Write how many disposable coffee cups you want to add:");
                cups += input.nextInt();
                break;
            case "take":
                System.out.println("I gave you " + money);
                money = 0;
                break;
            default: //!
                System.out.println("Unknown action");

        }
        System.out.println("The coffee machine has:");
        printStatus(water, milk, beans, cups, money);
    }
    private static void printStatus(int water, int milk, int beans, int cups, int money) { //!
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
