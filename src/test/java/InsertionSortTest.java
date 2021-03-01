import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InsertionSortTest {

    private InsertionSort sort;

    @BeforeAll
    public void init(){
        sort = new InsertionSort();
    }

    @Test
    public void testSortedDataInAscendingOrderData(){
        int[] num = {1, 4, 65, 66, 78, 85};
        sort.sort(num);
        int[] expectedOrder = {1, 4, 65, 66, 78, 85};
        Assertions.assertArrayEquals(expectedOrder, num);

        List<java.lang.String> expectedHistory =
                Arrays.asList("New element", "New element", "New element", "New element", "New element");
        Assertions.assertArrayEquals(expectedHistory.toArray(new String[0]), sort.getHistory().toArray(new String[0]));
        sort.clean();
    }

    @Test
    public void testSortedDataInDescendingOrder(){
        int[] num = {123, 65, 48, 45, 21, 11};
        sort.sort(num);
        int[] expectedOrder = {11, 21, 45, 48, 65, 123 };
        Assertions.assertArrayEquals(expectedOrder, num);

        List<String> expectedHistory =
                Arrays.asList("New element", "Swap", "Left end", "New element", "Swap", "Swap", "Left end",
                        "New element", "Swap", "Swap", "Swap", "Left end", "New element", "Swap", "Swap", "Swap", "Swap", "Left end",
                        "New element", "Swap", "Swap", "Swap", "Swap", "Swap", "Left end");
        Assertions.assertArrayEquals(expectedHistory.toArray(new String[0]), sort.getHistory().toArray(new String[0]));
        sort.clean();
    }

    @Test
    public void testSortOnlyPositive(){
        int[] num = {15, 64, 52, 29, 76};
        sort.sort(num);
        int[] expectedOrder = {15, 29, 52, 64, 76};
        Assertions.assertArrayEquals(expectedOrder, num);

        List<String> expectedHistory =
                Arrays.asList("New element", "New element", "Swap", "New element", "Swap", "Swap", "New element");
        Assertions.assertArrayEquals(expectedHistory.toArray(new String[0]), sort.getHistory().toArray(new String[0]));
        sort.clean();
    }

    @Test
    public void testSortOnlyNegative(){
        int[] num = {-72, -78, -30, -33, -71};
        sort.sort(num);
        int[] expectedOrder = {-78, -72, -71, -33, -30};
        Assertions.assertArrayEquals(expectedOrder, num);

        List<String> expectedHistory =
                Arrays.asList("New element", "Swap", "Left end", "New element", "New element", "Swap", "New element", "Swap", "Swap");
        Assertions.assertArrayEquals(expectedHistory.toArray(new String[0]), sort.getHistory().toArray(new java.lang.String[0]));
        sort.clean();
    }

    @Test
    public void testSort() {
        int[] num = {-2, -45, 66, 56, 74};
        sort.sort(num);
        int[] expectedOrder = {-45, -2, 56, 66, 74};
        Assertions.assertArrayEquals(expectedOrder, num);

        List<String> expectedHistory =
                Arrays.asList("New element", "Swap", "Left end", "New element", "New element", "Swap", "New element");
        Assertions.assertArrayEquals(expectedHistory.toArray(new String[0]), sort.getHistory().toArray(new String[0]));
        sort.clean();
    }

    @Test
    public void testEmpty(){
        int[] num = {};
        sort.sort(num);
        int[] expectedOrder = {};
        Assertions.assertArrayEquals(expectedOrder, num);

        List<String> expectedHistory = new ArrayList<>();
        Assertions.assertArrayEquals(expectedHistory.toArray(new String[0]), sort.getHistory().toArray(new String[0]));
        sort.clean();
    }

    @Test
    public void testDuplicate() {
        int[] num = {34, 86, 62, 62, 86, 34};
        sort.sort(num);
        int[] expectedOrder = {34, 34, 62, 62, 86, 86};
        Assertions.assertArrayEquals(expectedOrder, num);

        List<String> expectedHistory =
                Arrays.asList("New element", "New element", "Swap", "New element", "Swap", "New element", "New element",
                        "Swap", "Swap", "Swap", "Swap");
        Assertions.assertArrayEquals(expectedHistory.toArray(new String[0]), sort.getHistory().toArray(new String[0]));
        sort.clean();
    }
}
