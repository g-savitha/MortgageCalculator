import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);

    public static void readNumber(String prompt){
        System.out.print(prompt + ": ");
    }

    public static double readNumber(String prompt, double min, double max) {
        System.out.print(prompt + ": ");
        double value;
        while (true) {
            value = input.nextDouble();
            if (value > min && value <= max)
                break;
            System.out.print("Enter a value between " + (int) min + " and " + (int) max);
        }
        return value;

    }
}
