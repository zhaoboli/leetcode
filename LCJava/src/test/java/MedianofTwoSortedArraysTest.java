import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhaobo on 4/9/17.
 */
public class MedianofTwoSortedArraysTest {

    private  MedianofTwoSortedArrays medianObj;

    public MedianofTwoSortedArraysTest() {
       medianObj = new MedianofTwoSortedArrays();
    }

    @Test
    public void medianOfTwoSortedArraysCaseOne() {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {2, 3, 4, 5};
        double resultCaseOne = this.medianObj.findMedianSortedArrays(a, b);
        double expectedCaseOne = 3.5;
        assertEquals(expectedCaseOne, resultCaseOne,0.1);
    }

    @Test
    public void medianOfTwoSortedArrayCaseTwo() {
        int[] a = {};
        int[] b = {1};
        double resultCaseTwo = this.medianObj.findMedianSortedArrays(a, b);
        double expectedCaseTwo = 1.0;
        assertEquals(expectedCaseTwo, resultCaseTwo, 0.1);
    }
    /*
    [], [1] expected 1.0
    * */
}
