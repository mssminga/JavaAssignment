public class SilverCard extends Card {

    public SilverCard(double turnover) {
        super(turnover, 0.02);
    }

    @Override
    double calculateCurrentDiscountRate() {
        if (this.turnover <= 300) {
            return this.initialDiscount;
        } else {
            return 0.035;
        }

    }
}
