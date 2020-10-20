package montecarlo;

import java.util.List;

/**
 * Run simulations for 2 portfolios, aggressive and conservative, an compare their median, best and worst case performance.
 */
public class Main {
    public static void main(String[] args) {

        int simulations = 10000, initialAmount = 100000, periods = 20;
        double inflationRate = 0.035;

        //Simulator
        Simulator simulator = new Simulator(simulations, initialAmount, periods, inflationRate);

        //Aggressive portfolio and its performance
        Portfolio aggressivePortfolio = new Portfolio(0.094324, 0.15675);
        List<Double> aggressiveReturns = simulator.runSimulation(aggressivePortfolio);
        System.out.println("Aggressive Median " + ((aggressiveReturns.get(5000) + aggressiveReturns.get(5001)) / 2));
        System.out.println("Aggressive 10% Best case " + (aggressiveReturns.get(9000)));
        System.out.println("Aggressive 10% Worst case " + (aggressiveReturns.get(1000)));

        //conservative portfolio and its performance
        Portfolio conservativePortfolio = new Portfolio(0.06189, 0.063438);
        List<Double> conservativeReturns = simulator.runSimulation(conservativePortfolio);
        System.out.println("Conservative Median " + ((conservativeReturns.get(5000) + conservativeReturns.get(5001)) / 2));
        System.out.println("Conservative 10% Best case " + (conservativeReturns.get(9000)));
        System.out.println("Conservative 10% Worst case " + (conservativeReturns.get(1000)));
    }
}
