
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cat on 3/13/17.
 */
public class MyClassTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void myClass() throws Exception {

    }

    @Test
    public void print() throws Exception {
        MyClass c = new MyClass();
        assertTrue(c.print() == 1);
    }

}