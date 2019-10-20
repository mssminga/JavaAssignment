public class PayDesk {

    /**
     * Calculate card discount rate
     *
     * @param card
     * @return discountRate
     */
    static double discountRate(Card card) {
        return card.calculateCurrentDiscountRate() * 100;
    }

    /**
     * Calculate card discount value for purchase
     *
     * @param card
     * @param purchaseValue
     * @return discount
     */
    static double calculateDiscount(Card card, double purchaseValue) {
        return purchaseValue * card.calculateCurrentDiscountRate();
    }

    /**
     * Calculate purchase total value
     *
     * @param card
     * @param purchaseValue
     * @return total
     */
    static double calculateTotalValue(Card card, double purchaseValue) {
        return purchaseValue - calculateDiscount(card, purchaseValue);
    }
}
