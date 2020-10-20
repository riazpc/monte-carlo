package montecarlo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulator {
    private int simulations = 10000, initialAmount = 100000, periods = 20;
    private double inflationAdjustedRate = 1 - 0.035;

    public Simulator(int simulations, int initialAmount, int periods, double inflationRate) {
        this.simulations = simulations;
        this.initialAmount = initialAmount;
        this.inflationAdjustedRate = 1 - inflationRate;
    }

    /**
     * Returns simulations for portfolio's 20 years of future return value.
     *
     */
    public List<Double> runSimulation(Portfolio p) {
        List<Double> result = new ArrayList<>();

        for(int simulation = 1; simulation <= simulations; simulation++) {
            double futurePortfolioReturnAmount = initialAmount;
            for (int period = 1; period <= periods; period++) {
                //adjust portfolio return based on random return rate
                futurePortfolioReturnAmount *= (1 + p.getFutureReturnRate());

                //adjust based on inflation
                futurePortfolioReturnAmount *= inflationAdjustedRate;
            }

            //collect results for each 20 year simulation
            result.add(futurePortfolioReturnAmount);
        }

        //sort to calculate the median and percentiles later.
        Collections.sort(result);
        return result;
    }
}
