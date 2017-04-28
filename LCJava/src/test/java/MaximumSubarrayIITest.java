import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/28/17.
 */
public class MaximumSubarrayIITest {
    private MaximumSubarrayII obj;

    @Before
    public void setUp() throws Exception {
        this.obj = new MaximumSubarrayII();
    }

    @Test
    public void maxTwoSubArrays() throws Exception {
        /**
         * [1, 3] and [2, -2, 2]; [1, 3, -1, 2] and [2]
         * */
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 3, -1, 2, -1, 2));
        int actual = obj.maxTwoSubArrays(arr);
        assertEquals(7, actual);
    }

    @Test
    public void maxTwoSubArraysCaseTwo() throws Exception {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(-1, -2, -3, -100, -1, -50));
        int actual = obj.maxTwoSubArrays(arr);
        assertEquals(-2, actual);
    }

}