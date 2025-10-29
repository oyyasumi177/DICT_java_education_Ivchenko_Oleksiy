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
class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private String state;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        this.state = "action";
    }

    public void processInput(String input) {
        switch (state) {
            case "action":
                switch (input) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        state = "buy";
                        break;
                    case "fill":
                        System.out.println("Write how many ml of water you want to add:");
                        state = "fillWater";
                        break;
                    case "take":
                        System.out.println("I gave you " + money);
                        money = 0;
                        break;
                    case "remaining":
                        printStatus();
                        break;
                    case "exit":
                        state = "exit";
                        break;
                    default:
                        System.out.println("Unknown action");
                }
                break;
            case "buy":
                switch (input) {
                    case "1":
                        makeCoffee(Cup.espressowater, 0, Cup.espressobeans, Cup.espressocost);
                        break;
                    case "2":
                        makeCoffee(Cup.lattewater, Cup.lattemilk, Cup.lattebeans, Cup.lattecost);
                        break;
                    case "3":
                        makeCoffee(Cup.cappuccinowater, Cup.cappuccinomilk, Cup.cappuccinobeans, Cup.cappuccinocost);
                        break;
                    case "back":
                        break;
                    default:
                        System.out.println("Unknown coffee choice!");
                        break;
                }
                state = "action";
                break;
            case "fillWater":
                water += Integer.parseInt(input);
                System.out.println("Write how many ml of milk you want to add:");
                state = "fillMilk";
                break;
            case "fillMilk":
                milk += Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans you want to add:");
                state = "fillBeans";
                break;
            case "fillBeans":
                beans += Integer.parseInt(input);
                System.out.println("Write how many disposable cups of coffee you want to add:");
                state = "fillCups";
                break;
            case "fillCups":
                cups += Integer.parseInt(input);
                state = "action";
                break;
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded && cups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            cups--;
            money += cost;
        } else {
            if (water < waterNeeded) System.out.println("Sorry, not enough water!");
            else if (milk < milkNeeded) System.out.println("Sorry, not enough milk!");
            else if (beans < beansNeeded) System.out.println("Sorry, not enough coffee beans!");
            else System.out.println("Sorry, not enough disposable cups!");
        }
    }

    private void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public boolean isExit() {
        return "exit".equals(state);
    }
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        while (!machine.isExit()) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String input = scanner.nextLine();
            machine.processInput(input);
        }
    }
}