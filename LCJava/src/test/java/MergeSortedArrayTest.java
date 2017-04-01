import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhaobo on 3/19/17.
 */
public class MergeSortedArrayTest {

    @Test
    public void MergeSortedArrayCaseoneTest() {
        MergeSortedArray ms= new MergeSortedArray();
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {1};
        int[] result = new int[6];
        result = ms.mergeSortedArray(A, B);
        StringBuilder actual = new StringBuilder();
        for (int a: result
             ) {
            actual.append(a);
        }
        String expected = "112345";
        assertEquals("normal case", expected, actual.toString());

    }
}
