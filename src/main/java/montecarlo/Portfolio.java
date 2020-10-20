package montecarlo;

public class Portfolio extends BasePortfolio {
    private double mean;
    private double standardDeviation;

    public Portfolio(double mean, double standardDeviation) {
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }

    public double getMean() {
        return mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    /**
     * Returns random return rate for this portfolio
     */
    public double getFutureReturnRate() {
        return mean + (standardDeviation * randomGenerator.nextGaussian());
    }
}
