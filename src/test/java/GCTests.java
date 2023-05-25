import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
public class GCTests {

    @Test
    void VerifyThatUnreferencedObjectsAreCollected() {
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < 1 << 20; i++) {
            list.add(new Character('a'));
        }

        long allocatedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        list.clear();
        Runtime.getRuntime().gc();

        long allocatedMemoryDiff = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) - allocatedMemory;

        assertTrue(allocatedMemoryDiff < 0);
    }

}
