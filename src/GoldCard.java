public class GoldCard extends Card {

    public GoldCard(double turnover) {
        super(turnover, 0.02);
    }

    @Override
    public double calculateCurrentDiscountRate() {
        if (this.turnover < 100) {
            return this.initialDiscount;
        } else if (this.turnover >= 100 && this.turnover < 900) {
            return this.initialDiscount + ((this.turnover / 100) / 100.0);
        } else {
            return 0.1;
        }
    }
}
