package hello;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecursiveElementFinderTest {
    private List<Integer> list1 = new ArrayList<>();
    private RecursiveElementFinder recursiveElementFinder = new RecursiveElementFinder();

    @Before
    public void setList1() {
        list1.add(5);
        list1.add(55);
        list1.add(555);
        list1.add(55);
        list1.add(5);
        list1.add(5);
        list1.add(5);
    }

    @Test
    public void find() {
        int elem5 = recursiveElementFinder.find(list1, 5);
        assertEquals(elem5, 5);
    }

}