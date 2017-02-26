import org.junit.Test;
import static org.junit.Assert.*;


public class MyClassTest {
    @Test
    public void testPrint() {
        MyClass c = new MyClass();
        assertEquals(1, c.print());
    }
}