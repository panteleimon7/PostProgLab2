import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryLeakTests {
    @Test
    void MemoryLeakTest() {
        long allocatedMemory1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        new Bar().growthList();

        long allocatedMemory2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        Runtime.getRuntime().gc();

        assertTrue(allocatedMemory2 > allocatedMemory1);


    }
}
