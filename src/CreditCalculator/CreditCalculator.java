package CreditCalculator;

import java.lang.Math;

public class CreditCalculator {
    public static void main(String[] args) {

        String type = System.getProperty("type");
        String principalStr = System.getProperty("principal");
        String paymentStr = System.getProperty("payment");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");

        CalculatorLogic logic = new CalculatorLogic();

        if (type == null || interestStr == null) {
            System.out.println("Incorrect parameters");
            return;
        }

        double principal = principalStr != null ? Double.parseDouble(principalStr) : 0;
        double payment = paymentStr != null ? Double.parseDouble(paymentStr) : 0;
        int periods = periodsStr != null ? Integer.parseInt(periodsStr) : 0;
        double interest = Double.parseDouble(interestStr);

        if (principal < 0 || payment < 0 || periods < 0 || interest < 0) {
            System.out.println("Incorrect parameters");
            return;
        }

        switch (type) {
            case "diff":
                if (paymentStr != null) {
                    System.out.println("Incorrect parameters");
                    return;
                }
                logic.calculateDifferentiated(principal, periods, interest);
                break;

            case "annuity":
                int known = 0;
                if (principalStr != null) known++;
                if (paymentStr != null) known++;
                if (periodsStr != null) known++;
                if (known < 2) {
                    System.out.println("Incorrect parameters");
                    return;
                }

                if (principalStr == null) {
                    logic.calculatePrincipal(payment, periods, interest);
                } else if (paymentStr == null) {
                    logic.calculateAnnuity(principal, periods, interest);
                } else if (periodsStr == null) {
                    logic.calculatePeriods(principal, payment, interest);
                } else {
                    System.out.println("Incorrect parameters");
                }
                break;

            default:
                System.out.println("Incorrect parameters");
        }
    }
}

class CalculatorLogic {

    public void calculateAnnuity(double principal, int periods, double interest) {
        double i = interest / (12 * 100);
        double payment = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
        System.out.println("Your annuity payment = " + Math.round(payment) + "!");
        int overpayment = (int) Math.round(payment * periods - principal);
        System.out.println("Overpayment = " + overpayment);
    }

    public void calculatePrincipal(double payment, int periods, double interest) {
        double i = interest / (12 * 100);
        double principal = payment / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));
        System.out.println("Your loan principal = " + Math.round(principal) + "!");
        int overpayment = (int) Math.round(payment * periods - principal);
        System.out.println("Overpayment = " + overpayment);
    }

    public void calculatePeriods(double principal, double payment, double interest) {
        double i = interest / (12 * 100);
        double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
        int months = (int) Math.ceil(n);
        int years = months / 12;
        int m = months % 12;

        if (years > 0 && m > 0)
            System.out.println("It will take " + years + " years and " + m + " months to repay this loan!");
        else if (years > 0)
            System.out.println("It will take " + years + " years to repay this loan!");
        else
            System.out.println("It will take " + months + " months to repay this loan!");

        int overpayment = (int) Math.round(payment * months - principal);
        System.out.println("Overpayment = " + overpayment);
    }

    public void calculateDifferentiated(double principal, int periods, double interest) {
        double i = interest / (12 * 100);
        int total = 0;

        for (int m = 1; m <= periods; m++) {
            double payment = (principal / periods) + i * (principal - (principal * (m - 1) / periods));
            int rounded = (int) Math.ceil(payment);
            total += rounded;
            System.out.println("Month " + m + ": payment is " + rounded);
        }

        int overpayment = (int) Math.round(total - principal);
        System.out.println("Overpayment = " + overpayment);
    }
}
