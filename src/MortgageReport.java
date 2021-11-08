import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("---------");
        for(double loanBalance: calculator.getRemainingBalances())
            System.out.println(currency.format(loanBalance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }
}
