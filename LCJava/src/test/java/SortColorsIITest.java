import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 5/1/17.
 */
public class SortColorsIITest {
    private SortColorsII obj = new SortColorsII();
    @Test
    public void sortColors2RainbowSort() throws Exception {
        int[] inputArr = {3, 2, 2, 1, 4};
        int k = 4;
        obj.sortColors2RainbowSort(inputArr, k);
        System.out.println("end");
    }

    @Test
    public void sortColors2RainbowSortTwo() throws Exception {
        int[] inputArr = {3,2,3,3,4,3,3,2,4,4,1,2,1,1,1,3,4,3,4,2};
        //[1,1,1,1,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4]
        int k = 4;
        obj.sortColors2RainbowSort(inputArr, k);
        System.out.println("end");
    }
}