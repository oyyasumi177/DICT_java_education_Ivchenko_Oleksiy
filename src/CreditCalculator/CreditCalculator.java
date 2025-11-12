package CreditCalculator;

import java.util.Scanner;
import java.lang.Math;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorLogic logic = new CalculatorLogic();

        System.out.println("Enter the loan principal:");
        int principal = scanner.nextInt();

        System.out.println("What do you want to calculate?");
        System.out.println("type \"m\" – for number of monthly payments,");
        System.out.println("type \"p\" – for the monthly payment:");
        String choice = scanner.next();

        if (choice.equals("m")) {
            System.out.println("Enter the monthly payment:");
            int payment = scanner.nextInt();
            logic.calculateMonths(principal, payment);

        } else if (choice.equals("p")) {
            System.out.println("Enter the number of months:");
            int months = scanner.nextInt();
            logic.calculatePayment(principal, months);

        } else {
            System.out.println("Invalid option!");
        }
    }
}

class CalculatorLogic {

    public void calculateMonths(int principal, int payment) {
        int months = (int) Math.ceil((double) principal / payment);

        if (months == 1) {
            System.out.println("It will take 1 month to repay the loan");
        } else {
            System.out.println("It will take " + months + " months to repay the loan");
        }
    }

    public void calculatePayment(int principal, int months) {
        double paymentExact = (double) principal / months;
        int payment = (int) Math.ceil(paymentExact);
        int lastPayment = principal - (months - 1) * payment;

        if (lastPayment != payment) {
            System.out.println("Your monthly payment = " + payment +
                    " and the last payment = " + lastPayment + ".");
        } else {
            System.out.println("Your monthly payment = " + payment);
        }
    }
}
