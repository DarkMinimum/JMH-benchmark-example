package dark;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ExecutionPlan {

    @Param({ "2", "34"})
    int x;
    @Param({ "3", "10"})
    int n;
    @Param({ "5", "123"})
    int m;
}
