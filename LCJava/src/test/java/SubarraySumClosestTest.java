import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/28/17.
 */
public class SubarraySumClosestTest {
    private SubarraySumClosest obj;
    @Before
    public void setUp() throws Exception {
        this.obj = new SubarraySumClosest();
    }

    @Test
    public void subarraySumClosest() throws Exception {
        int[] inputArr = {-3, 1, 1, -3, 5};
        int[] expected = {0, 4};
        assertArrayEquals(expected, obj.subarraySumClosest(inputArr));
    }

    @Test
    public void subarraySumClosestCaseOne() throws Exception {
        int[] inputArr = {-3, 1, 1, -3, 5};
        int[] expected = {0, 2};
        assertArrayEquals(expected, obj.subarraySumClosest(inputArr));
    }
}