package dark;

import org.openjdk.jmh.annotations.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Class that holds all implementations of function n!
 */
public class Functions {

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(MILLISECONDS)
    @Warmup(iterations = 2, time = 500, timeUnit = MILLISECONDS)
    @Measurement(iterations = 2, time = 500, timeUnit = MILLISECONDS)
    @BenchmarkMode(Mode.Throughput)
    public Double javaBasicImpl(final ExecutionPlan plan) {
        return Math.pow(plan.x, plan.n) % plan.m;
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(MILLISECONDS)
    @Warmup(iterations = 2, time = 500, timeUnit = MILLISECONDS)
    @Measurement(iterations = 2, time = 500, timeUnit = MILLISECONDS)
    @BenchmarkMode(Mode.Throughput)
    public Double ownStraightImpl(final ExecutionPlan plan) {
        return straightPower(plan.x, plan.n) % plan.m;
    }

    private Double straightPower(final double x, final double n) {
        double pow = 1;
        for (int i = 0; i < n; i++) {
            pow = pow * x;
        }
        return pow;
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @OutputTimeUnit(MILLISECONDS)
    @Warmup(iterations = 2, time = 500, timeUnit = MILLISECONDS)
    @Measurement(iterations = 2, time = 500, timeUnit = MILLISECONDS)
    @BenchmarkMode(Mode.Throughput)
    public long ownOptimalImpl(final ExecutionPlan plan) {
        return optimalPower((int)plan.x, (int)plan.n) % plan.m;
    }

    private long optimalPower(int x, int n) {
        long pow = 1L;

        while (n > 0) {
            if ((n & 1) == 1) {
                pow *= x;
            }

            n = n >> 1;
            x = x * x;
        }
        return pow;
    }


}
