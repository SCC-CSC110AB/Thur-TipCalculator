package thur.tipcalculator;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class ThurTipCalculator {
    public static final String SERVER_NAME_QUESTION 
            = "What was your servers name?";
    public static final String BILL_AMOUNT_QUESTION
            = "What was your bill?";
    public static final String SERVICE_QUALITY_QUESTION
            = "How was your service?";
    
    public static final double SALES_TAX = 0.075;
    
    // Guillermo is heartless :(
    public static final double BAD_SERVICE_TIP_PERCENT = 0;
    public static final double GOOD_SERVICE_TIP_PERCENT = 0.2;
    public static final double GREAT_SERVICE_TIP_PERCENT = 0.25;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double billAmount;
        String serverName;
        String serviceQuality;
        double tipAmount;
        double taxAmount;
        
        System.out.print(SERVER_NAME_QUESTION);
        serverName = input.nextLine();
        
        System.out.print(BILL_AMOUNT_QUESTION);
        billAmount = input.nextDouble();
        // input.nextDouble does not clear out the new line char so we have to
        // do it manually before getting more user input.
        input.nextLine();
        
        System.out.print(SERVICE_QUALITY_QUESTION);
        serviceQuality = input.nextLine();
        
        taxAmount = billAmount * SALES_TAX;
        
        if (serviceQuality.equalsIgnoreCase("bad")) {
            tipAmount = (billAmount + taxAmount) * BAD_SERVICE_TIP_PERCENT;
        } else if (serviceQuality.equalsIgnoreCase("good")) {
            tipAmount = (billAmount + taxAmount) * GOOD_SERVICE_TIP_PERCENT;
        } else {
            tipAmount = (billAmount + taxAmount) * GREAT_SERVICE_TIP_PERCENT;
        }
        
//        System.out.println(
//                "Your server "
//                + serverName
//                + " gave "
//                + serviceQuality
//                + " service and will receive a tip of "
//                + tipAmount
//                + " and your final bill will be "
//                + (billAmount + taxAmount + tipAmount)
//        );

        System.out.printf(
                "Your server %s gave %s service and will receive a tip of $%.2f"
                + " and your final bill will be $%.2f\n",
                serverName,
                serviceQuality,
                tipAmount,
                billAmount + taxAmount + tipAmount
        );
    }
}
