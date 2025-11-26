package CreditCalculator;

public class CreditCalculator {
    public static void main(String[] args) {

        String type = System.getProperty("type");
        String principalStr = System.getProperty("principal");
        String paymentStr = System.getProperty("payment");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");

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

        CalculatorLogic logic = new CalculatorLogic();

        if (type.equals("diff")) {

            if (paymentStr != null || principalStr == null || periodsStr == null) {
                System.out.println("Incorrect parameters");
                return;
            }

            logic.calculateDifferentiated(principal, periods, interest);
            return;
        }

        if (type.equals("annuity")) {

            int params = 0;
            if (principalStr != null) params++;
            if (paymentStr != null) params++;
            if (periodsStr != null) params++;

            if (params < 2) {
                System.out.println("Incorrect parameters");
                return;
            }

            if (principalStr == null) {
                logic.calculatePrincipal(payment, periods, interest);
                return;
            }
            if (paymentStr == null) {
                logic.calculateAnnuity(principal, periods, interest);
                return;
            }
            if (periodsStr == null) {
                logic.calculatePeriods(principal, payment, interest);
                return;
            }

            System.out.println("Incorrect parameters");
            return;
        }

        System.out.println("Incorrect parameters");
    }
}

class CalculatorLogic {

    private double monthlyRate(double interest) {
        return interest / (12 * 100.0);
    }

    public void calculateAnnuity(double principal, int periods, double interest) {
        double i = monthlyRate(interest);
        double payment = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);

        long p = Math.round(payment);
        System.out.println("Your annuity payment = " + p + "!");
        System.out.println("Overpayment = " + (p * periods - (long) principal));
    }

    public void calculatePrincipal(double payment, int periods, double interest) {
        double i = monthlyRate(interest);
        double principal = payment / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));

        long pr = Math.round(principal);
        System.out.println("Your loan principal = " + pr + "!");
        System.out.println("Overpayment = " + ((long)(payment * periods) - pr));
    }

    public void calculatePeriods(double principal, double payment, double interest) {
        double i = monthlyRate(interest);
        double n = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);

        int months = (int)Math.ceil(n);
        int years = months / 12;
        int rem = months % 12;

        if (years > 0 && rem > 0)
            System.out.println("It will take " + years + " years and " + rem + " months to repay this loan!");
        else if (years > 0)
            System.out.println("It will take " + years + " years to repay this loan!");
        else
            System.out.println("It will take " + months + " months to repay this loan!");

        System.out.println("Overpayment = " + ((long)(payment * months - principal)));
    }

    public void calculateDifferentiated(double principal, int periods, double interest) {
        double i = monthlyRate(interest);
        long total = 0;

        for (int m = 1; m <= periods; m++) {
            double diff = principal / periods + i * (principal - (principal * (m - 1) / periods));
            long rounded = (long)Math.ceil(diff);

            System.out.println("Month " + m + ": payment is " + rounded);
            total += rounded;
        }

        System.out.println("Overpayment = " + (total - (long)principal));
    }
}
