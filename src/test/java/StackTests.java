import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StackTests {

    static long maxStackFrameAllocation = 0;

    long factorial(int n) {
        if (n == 1) return 1;
        if  (maxStackFrameAllocation < Thread.currentThread().getStackTrace().length) {
            maxStackFrameAllocation = Thread.currentThread().getStackTrace().length;
        }
        return factorial(n - 1) * n;
    }

    @Test
    void stackFrameAllocationTest() {
        factorial(10);
        assertTrue(maxStackFrameAllocation > Thread.currentThread().getStackTrace().length);
    }

}
