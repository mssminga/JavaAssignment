public class BronzeCard extends Card {

    public BronzeCard(double turnover) {
        super(turnover, 0);
    }

    @Override
    public double calculateCurrentDiscountRate() {
        if (this.turnover < 100) {
            return this.initialDiscount;
        } else if (this.turnover >= 100 && this.turnover <= 300) {
            return 0.01;
        } else {
            return 0.025;
        }
    }
}
