package montecarlo;

import java.util.Random;

/**
 * Base class for Portfolio
 */
public abstract class BasePortfolio {
    protected Random randomGenerator = new Random();

    protected abstract double getFutureReturnRate();
}
