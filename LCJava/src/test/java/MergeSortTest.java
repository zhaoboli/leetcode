import org.junit.Test;
import static  org.junit.Assert.assertEquals;

/**
 * Created by zhaobo on 3/19/17.
 */
public class MergeSortTest {
    @Test
    public void MergeSortCaseOneTest() {
        MergeSort ms= new MergeSort();
        int[] A = {2, 3, 1, 4, 5};
        ms.sortIntegers(A);
        StringBuilder actual = new StringBuilder();
        for (int a: A
             ) {
            actual.append(a);
        }
        String expected = "12345";
        assertEquals("normal case", expected, actual.toString());

    }
}
