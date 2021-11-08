public class MortgageCalculator {
    private final static byte MONTHS_IN_A_YEAR = 12;
    private final static byte PERCENTAGE = 100;
    private int principalAmount;
    private float annualInterest;
    private short payments;
    private float monthlyInterest;
    private byte years;

    public MortgageCalculator(int principalAmount, float annualInterest, byte years) {
        this.principalAmount = principalAmount;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short paymentsMade) {
        payments = getPayments();
        monthlyInterest = getMonthlyInterest();
        return principalAmount
                * (Math.pow(1 + monthlyInterest,payments) - Math.pow(1+monthlyInterest, paymentsMade))
                / (Math.pow(1+monthlyInterest,payments) - 1);
    }

    public double calculateMortgage(){
        payments = getPayments();
        monthlyInterest = getMonthlyInterest();
        return principalAmount * (monthlyInterest * Math.pow(1 + monthlyInterest, payments)) / (Math.pow(1 + monthlyInterest, payments) - 1);

    }

    public double[] getRemainingBalances(){
        double[] balances = new double[getPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month-1] = calculateBalance(month);
        return balances;
    }

    private short getPayments() {
        return (short) (years * MONTHS_IN_A_YEAR);
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENTAGE / MONTHS_IN_A_YEAR;
    }
}
