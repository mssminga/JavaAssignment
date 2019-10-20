import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter how many purchases you want to make: ");
        int howMany = readSafelyNumberOfPurchasesInput();

        for (int i = 0; i < howMany; i++) {
            String cardType = readCardTypeFromInput();
            double turnoverMonth = readTurnoverMonthFromInput();
            double purchaseValue = readPurchaseValueFromInput();

//            System.out.println("Entered values: \n - card type: " + cardType
//                    + "\n - turnover: " + turnoverMonth
//                    + "\n - purchase value: " + purchaseValue + "\n");

            Card card = createCardByInput(cardType, turnoverMonth);
            printOutput(card, purchaseValue);
        }
    }

    /**
     * Read cardType from input and check if it is a valid cardType
     *
     * @return cardType - "b", "s", "g"
     */
    private static String readCardTypeFromInput() {
        while (true) {
            System.out.println("Enter the type of the card (b-bronze, s-silver, g-gold): ");
            String cardType = scan.next();

            if (cardType.equals("b") || cardType.equals("s") || cardType.equals("g")) {
                return cardType;
            }
        }
    }

    /**
     * Read turnoverMonth from input and check if it is a valid turnoverMonth
     *
     * @return turnoverMonth
     */
    private static double readTurnoverMonthFromInput() {
        System.out.println("Enter turnover from previous month (cannot be negative): ");
        double turnoverMonth = readSafelyDoubleInput();

        if (turnoverMonth >= 0) {
            return turnoverMonth;
        } else {
            return readTurnoverMonthFromInput();
        }
    }

    /**
     * Read purchaseValue from input and check if it is a valid purchaseValue
     *
     * @return purchaseValue
     */
    private static double readPurchaseValueFromInput() {
        System.out.println("Enter purchase value (cannot be negative): ");
        double purchaseValue = readSafelyDoubleInput();

        if (purchaseValue > 0) {
            return purchaseValue;
        } else {
            return readPurchaseValueFromInput();
        }
    }

    /**
     * Recursively read input until a valid double
     *
     * @return read double number
     */
    private static double readSafelyDoubleInput() {
        try {
            return scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scan.nextLine();
            return readSafelyDoubleInput();
        }
    }

    /**
     * Continuously read input until a valid int
     *
     * @return read int number
     */
    private static int readSafelyNumberOfPurchasesInput() {
        while (true) {
            try {
                int numberOfPurchases = scan.nextInt();
                if (numberOfPurchases > 0) {
                    return numberOfPurchases;
                } else System.out.println("Invalid input. Please enter a positive integer number.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a integer number.");
                scan.nextLine();
            }
        }
    }

    /**
     * Initialize new Card instance based on cardType parameter. Throws exception if card type not valid.
     *
     * @param cardType      - "b", "s", "g"
     * @param turnoverMonth
     * @return card
     */
    private static Card createCardByInput(String cardType, double turnoverMonth) {
        switch (cardType) {
            case "b":
                return new BronzeCard(turnoverMonth);
            case "s":
                return new SilverCard(turnoverMonth);
            case "g":
                return new GoldCard(turnoverMonth);
            default:
                throw new IllegalStateException("Unexpected value: " + cardType);
        }
    }

    /**
     * Print purchase info based on card
     *
     * @param card
     * @param purchaseValue
     */
    private static void printOutput(Card card, double purchaseValue) {
        System.out.printf("\nPurchase value: $%.2f%n", purchaseValue);
        System.out.printf("Discount rate: %.1f%%%n", PayDesk.discountRate(card));
        System.out.printf("Discount: $%.2f%n", PayDesk.calculateDiscount(card, purchaseValue));
        System.out.printf("Total: $%.2f%n", PayDesk.calculateTotalValue(card, purchaseValue));
        System.out.println();
    }

}
