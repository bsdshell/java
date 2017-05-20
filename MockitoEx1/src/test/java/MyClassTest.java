import classfile.Print;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by cat on 4/29/17.
 */
//@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {
    MyClass myclass;

    @Mock
    List<String> mockedList;

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Captor
    ArgumentCaptor argumentCaptor;

    @Mock MyClass c;
    @Mock MyClass2 c2;

    @Before
    public void setUp() throws Exception {
        myclass = new MyClass();
        MockitoAnnotations.initMocks(this);

        initSetup();
        MyMain main = new MyMain(c, c2);
        main.run();
    }

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary myDict = new MyDictionary();

    @Mock
    MyDictionary myNewDic;

    @Test
    public void print() throws Exception {
        assertEquals(myclass.print(), 1);
    }
    @Test
    public void test_me() throws Exception{
        List mockList = Mockito.mock(ArrayList.class);
        mockList.add("dog");
        mockList.add("cat");
        Mockito.verify(mockList).add("dog");
        assertEquals(0, mockList.size());
        Mockito.verify(mockList).add("cat");
        //Mockito.verify(mockList).add("cow");
        Print.pb(mockList.size());

        // mockito when and then return
        when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
        Print.pbl(mockList.size());
    }
    @Test
    public void testMockIsInjected() throws Exception{
        mockedList.add("one");
        mockedList.add("two");
        Mockito.verify(mockedList).add("one");
        Mockito.verify(mockedList).add("two");
        assertEquals(0, mockedList.size());
    }

    @Test
    public void spyTest() throws Exception{
        List<String> spyList = Mockito.spy(new ArrayList<String>());
        spyList.add("one");
        spyList.add("two");
        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");
        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    public void spyAnnotation_thenSpyIsInjected() throws Exception{
        spiedList.add("one");
        spiedList.add("two");
        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");
        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }

    @Test
    public void whenNotUseCaptorAnnotation_test() throws Exception{
        List mockList = Mockito.mock(ArrayList.class);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        mockList.add("one");
        Mockito.verify(mockList).add(argumentCaptor.capture());
        assertEquals("one", argumentCaptor.getValue());
    }

    @Test
    public void useCaptorAnnotation_test() throws Exception{
        mockedList.add("one");
        Mockito.verify(mockedList).add((String) argumentCaptor.capture());
        assertEquals("one", argumentCaptor.getValue());
    }

    @Test
    public void injectMockAnnotaiton_test() throws Exception{
        when(myDict.getMeaning("key")).thenReturn("value");
        assertEquals("value", myDict.getMeaning("key"));
    }
    @Test
    public void simpleInteractionWithMock() throws Exception{
        List<String> mymockedList = Mockito.mock(MyList.class);
        mymockedList.size();
        Mockito.verify(mymockedList).size();

        List<String> myMocketList2 = Mockito.mock(MyList.class);
        myMocketList2.get(0);
        Mockito.verify(myMocketList2).get(0);

        when(mymockedList.size()).thenReturn(100);
        assertEquals(100, mymockedList.size());

        assertEquals(null, mymockedList.get(0));

    }
    @Test
    public void testGenericObject() throws Exception{
        MyClass c = Mockito.mock(MyClass.class);
        when(c.print()).thenReturn(100);
        assertEquals(c.print(), 100);

        when(c.show(anyString())).thenReturn("output");
        assertEquals("output", c.show("input"));

        when(c.show(eq("animal"))).thenReturn("cat");

        assertEquals(c.show("animal"), "cat");

        assertEquals(c.show("human"), "cat");
    }

    public void initSetup() throws Exception{
        MyClass c = Mockito.mock(MyClass.class);
        MyClass2 c2 = new MyClass2();
        c2.setNum(100);
        when(c.display(any(MyClass2.class))).thenReturn(c2);
        when(c.show(c)).thenReturn(c);
    }

    @Test
    public void testMyMain() throws Exception{
        MyClass2 c2 = new MyClass2();
        MyClass c = new MyClass();
        MyClass cc = new MyClass();
        c2.setNum(10);
        assertEquals(c.display(c2), c2);
        assertEquals(c.show(c), c);
        assertEquals(c.show(cc), cc);
    }
}