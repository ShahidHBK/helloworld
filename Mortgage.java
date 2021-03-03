import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {

    public static void main(String[] args) {
        /*String percent = NumberFormat.getPercentInstance().format(0.56);
        System.out.println(percent); */


        //Declaring Constants
        final int percentageDenominator = 100;
        final int yearsMultiplier = 12;


        //Taking in the values and assigning them to variables
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Principle amount: ");
        int principle = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Annual Rate of interest: ");
        float rateOfInterest = scanner.nextFloat();
        System.out.print("Enter Time period in years: ");
        int timePeriod = scanner.nextByte();

        //Conversion of inputs
        rateOfInterest = rateOfInterest/yearsMultiplier/percentageDenominator;
        timePeriod = timePeriod*yearsMultiplier;


        //Mortgage calculation
        double mortgage = Math.pow(1+rateOfInterest,timePeriod); //Calculate exponent part of numerator

        mortgage = mortgage*rateOfInterest; //complete the numerator by multiplying the interest rate

        double denominator = (Math.pow(1+rateOfInterest,timePeriod))-1; //Calculate denominator

        mortgage = mortgage/denominator; //Divide the numerator with denominator

        mortgage = mortgage*principle; //Finally multiply the principle to complete the formula

        System.out.println("Mortgage: " +NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
