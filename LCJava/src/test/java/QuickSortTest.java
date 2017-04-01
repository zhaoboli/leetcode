/**
 * Created by zhaobo on 3/18/17.
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void quickSortCaseOneTest() {
        QuickSort qs = new QuickSort();
        int[] A = {2, 3, 1, 4, 5};
        qs.SortInts(A);
        StringBuilder actual = new StringBuilder();
        for (int a: A
             ) {
            actual.append(a);
        }
        String expected = "12345";
        assertEquals("normal case", expected, actual.toString());
    }
}
