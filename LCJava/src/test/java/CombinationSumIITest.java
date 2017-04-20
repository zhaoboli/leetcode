import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/20/17.
 */
public class CombinationSumIITest {
    CombinationSumII combSumIIObj;
    @Before
    public void setUp() throws Exception {
        this.combSumIIObj = new CombinationSumII();
    }

    @Test
    public void combinationSum2() throws Exception {
        int[] input = {7, 1, 2, 5, 1, 6, 10};
        int[][] expected = {{1, 1, 6}, {1, 2, 5},{1, 7}, {2, 6}};
        assertEquals(Util.toListofList(expected), this.combSumIIObj.combinationSum2(input, 8));
    }

}