package CreditCalculator;

import java.util.Scanner;
import java.lang.Math;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorLogic logic = new CalculatorLogic();

        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        String choice = scanner.next();

        switch (choice) {
            case "n":
                System.out.println("Enter the loan principal:");
                double principalN = scanner.nextDouble();

                System.out.println("Enter the monthly payment:");
                double paymentN = scanner.nextDouble();

                System.out.println("Enter the loan interest:");
                double interestN = scanner.nextDouble();

                logic.calculatePeriods(principalN, paymentN, interestN);
                break;

            case "a":
                System.out.println("Enter the loan principal:");
                double principalA = scanner.nextDouble();

                System.out.println("Enter the number of periods:");
                int periodsA = scanner.nextInt();

                System.out.println("Enter the loan interest:");
                double interestA = scanner.nextDouble();

                logic.calculateAnnuity(principalA, periodsA, interestA);
                break;

            case "p":
                System.out.println("Enter the annuity payment:");
                double paymentP = scanner.nextDouble();

                System.out.println("Enter the number of periods:");
                int periodsP = scanner.nextInt();

                System.out.println("Enter the loan interest:");
                double interestP = scanner.nextDouble();

                logic.calculatePrincipal(paymentP, periodsP, interestP);
                break;

            default:
                System.out.println("Invalid option!");
                break;
        }
    }
}

class CalculatorLogic {

    public void calculatePeriods(double principal, double payment, double interest) {
        double i = interest / 12 / 100;
        double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
        int months = (int) Math.ceil(n);

        int years = months / 12;
        int remainingMonths = months % 12;

        if (years > 0 && remainingMonths > 0) {
            System.out.println("It will take " + years + " years and " + remainingMonths + " months to repay this loan!");
        } else if (years > 0) {
            System.out.println("It will take " + years + " years to repay this loan!");
        } else {
            System.out.println("It will take " + months + " months to repay this loan!");
        }
    }

    public void calculateAnnuity(double principal, int periods, double interest) {
        double i = interest / 12 / 100;
        double payment = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
        System.out.println("Your annuity payment = " + Math.round(payment) + "!");
    }

    public void calculatePrincipal(double payment, int periods, double interest) {
        double i = interest / 12 / 100;
        double principal = payment / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));
        System.out.println("Your loan principal = " + Math.round(principal) + "!");
    }
}
