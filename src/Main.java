public class Main {

    public static void main(String[] args) {

        int principalAmount = (int) Console.readNumber("Principal Amount ($1K - $1M)", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest (Years)",0,30);
        byte years = (byte) Console.readNumber("Period (Years)", 0, 30);


        var calculator = new MortgageCalculator(principalAmount,annualInterest,years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();


    }


}

