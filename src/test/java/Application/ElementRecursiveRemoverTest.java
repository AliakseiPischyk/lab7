package Application;


import org.junit.Before;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ElementRecursiveRemoverTest {
    private List<Integer> list1 = new ArrayList<>();
    private ElementRecursiveRemover elementRecursiveRemover = new ElementRecursiveRemover();

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

    @org.junit.Test
    public void excludeRepeatingElements() {

        List<Integer> list2 = new ArrayList<Integer>() {{
            addAll(elementRecursiveRemover.excludeRepeatingElements(list1));
        }};

        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(55);
        expected.add(555);


        assertArrayEquals(list2.toArray(), expected.toArray());

    }
}