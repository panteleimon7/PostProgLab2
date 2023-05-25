import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReferenceValueTypeTests {

    void IncrementVal(int x) {
        x++;
    }

    void IncrementObj(Foo obj) {
        obj.Increment();
        // зміниться локальна  зміна obj, але не зовнішня змінна, значення якої ми передали у функцію
        obj = null;
    }

    @Test
    void intValueTypeTest() {
        int a = 10;
        IncrementVal(10);
        assertEquals(a, 10);
    }
    @Test
    void intReferenceTypeTest() {
        fail("Passing int by Reference isn't possible because of java architecture");
    }

    @Test
    void objectValueTypeTest() {
        fail("Passing int by Reference isn't possible because of java architecture");
    }
    @Test
    void objectReferenceTypeTest() {
        // Але все ж тут вказівник на об'єкт передається за значенням
        Foo obj = new Foo(10);
        IncrementObj(obj);
        // Тут порівнюються значення. Все зводиться до виклику наступного метода:
        // static boolean objectsAreEqual(Object obj1, Object obj2) {
        //    if (obj1 == null) {
        //        return (obj2 == null);
        //    }
        //    return obj1.equals(obj2);
        //}
        assertNotEquals(obj, new Foo(10));
    }
}
