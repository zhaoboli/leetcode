import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 5/1/17.
 */
public class TwoSumUniquePairsTest {
    private TwoSumUniquePairs obj = new TwoSumUniquePairs();

    @Test
    public void twoSum6() throws Exception {
        int[] input = {1,1,2,45,46,46};
        int target = 47;
        int expectd = 2;
        assertEquals(expectd, obj.twoSum6(input, target));
    }

}