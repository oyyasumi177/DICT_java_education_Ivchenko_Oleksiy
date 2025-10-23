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

        while (true) {
            System.out.println("Write action (buy, fill, take,remaining,exit):");
            String action = input.next();
            if (action.equals("exit")) {
                break;
            }
            switch (action) { //!
                case "buy": //!
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String choice = input.next();
                    if  (choice.equals("back")) {
                        break;
                    }
                    switch (choice) {
                        case "1":
                            if (water >= Cup.espressowater && beans >= Cup.espressobeans && cups > 0) {
                                System.out.println("I have enough resources, making you a coffee!");//  !
                                water -= Cup.espressowater;
                                beans -= Cup.espressobeans;
                                cups--;
                                money += Cup.espressocost;
                            } else {
                                if (water < Cup.espressowater) System.out.println("Sorry, not enough water!");
                                else if (beans < Cup.espressobeans) System.out.println("Sorry, not enough coffee beans!");
                                else System.out.println("Sorry, not enough disposable cups!");
                            }
                            break;
                        case "2":
                            if (water >= Cup.lattewater && milk >= Cup.lattemilk && beans >= Cup.lattebeans && cups > 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= Cup.lattewater;
                                milk -= Cup.lattemilk;
                                beans -= Cup.lattebeans;
                                cups--;
                                money += Cup.lattecost;
                            } else {
                                if (water < Cup.lattewater) System.out.println("Sorry, not enough water!");
                                else if (milk < Cup.lattemilk) System.out.println("Sorry, not enough milk!");
                                else if (beans < Cup.lattebeans) System.out.println("Sorry, not enough coffee beans!");
                                else System.out.println("Sorry, not enough disposable cups!");
                            }
                            break;
                        case "3":
                            if (water >= Cup.cappuccinowater && milk >= Cup.cappuccinomilk && beans >= Cup.cappuccinobeans && cups > 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= Cup.cappuccinowater;
                                milk -= Cup.cappuccinomilk;
                                beans -= Cup.cappuccinobeans;
                                cups--;
                                money += Cup.cappuccinocost;
                            } else {
                                if (water < Cup.cappuccinowater) System.out.println("Sorry, not enough water!");
                                else if (milk < Cup.cappuccinomilk) System.out.println("Sorry, not enough milk!");
                                else if (beans < Cup.cappuccinobeans) System.out.println("Sorry, not enough coffee beans!");
                                else System.out.println("Sorry, not enough disposable cups!");
                            }
                            break;
                        default:
                            System.out.println("Unknown coffee choice!");
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
                case "remaining":
                    System.out.println("The coffee machine has:");
                    printStatus(water, milk, beans, cups, money);
                    break;
                default: //!
                    System.out.println("Unknown action");
            }
        }
    }
    private static void printStatus(int water, int milk, int beans, int cups, int money) { //!
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
