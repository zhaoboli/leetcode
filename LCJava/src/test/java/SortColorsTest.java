import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/30/17.
 */
public class SortColorsTest {
    private SortColors obj = new SortColors();
    @Test
    public void sortColors() throws Exception {
        int[] input = {2,0,0,1,2,0,2};
        int[] expected = {0,0,0,1,2,2,2};
        obj.sortColors(input);
        assertArrayEquals(expected, input);
    }

}