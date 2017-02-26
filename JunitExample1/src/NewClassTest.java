import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cat on 2/25/17.
 */
public class NewClassTest {
    NewClass c = new NewClass();
    @Before
    public void setUp() throws Exception {

   }
   @Test
   public void printTest(){
        assertEquals(c.print(), 1);
   }

    @After
    public void tearDown() throws Exception {

    }
}