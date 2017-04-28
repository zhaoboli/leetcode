import org.junit.Before;
import org.junit.Test;
import sun.reflect.annotation.ExceptionProxy;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/28/17.
 */
public class MaximumSubarrayTest {
    private MaximumSubarray obj;

    @Before
    public void setUp() throws Exception {
        this.obj = new MaximumSubarray();
    }

    @Test
    public void maxSubArray() throws Exception {
        int[] arr = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        //expected sub Array {4, -1, 2, 1}, expected sum = 6
        int expected = 6;
        assertEquals(6, obj.maxSubArray(arr));
    }

    @Test
    public void maxSubArrayEmpty() throws Exception {
        int[] arr = {};
        assertEquals(0, obj.maxSubArray(arr));
    }

    @Test
    public void maxSubArrayNull() throws Exception {
        int[] arr = null;
        assertEquals(0, obj.maxSubArray(arr));
    }

}