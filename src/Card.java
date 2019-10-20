public abstract class Card {
    String owner;
    double turnover;
    double initialDiscount;

    Card() {

    }

    Card(double turnover, double initialDiscount) {
        if (turnover < 0)
            throw new IllegalArgumentException("Turnover cannot be a negative number!");
        this.turnover = turnover;
        this.initialDiscount = initialDiscount;

    }

    public String getOwner() {
        return owner;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getInitialDiscount() {
        return initialDiscount;
    }

    /**
     * Calculate current discount rate depending on card type
     *
     * @return
     */
    abstract double calculateCurrentDiscountRate();

}
