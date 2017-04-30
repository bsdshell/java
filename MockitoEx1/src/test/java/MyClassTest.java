import classfile.Print;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cat on 4/29/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {
    MyClass myclass;

    @Mock
    List<String> mockedList;

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Captor
    ArgumentCaptor argumentCaptor;

    @Before
    public void setUp() throws Exception {
        myclass = new MyClass();
        MockitoAnnotations.initMocks(this);
    }

    //@InjectMocks
    MyDictionary myDict = new MyDictionary();

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
        Mockito.when(mockList.size()).thenReturn(100);
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
        Mockito.when(myDict.getMeaning("dogkey")).thenReturn("dogvalue");
        assertEquals("dogvalue", myDict.getMeaning("dogkey"));
    }
}