import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 5/2/17.
 */
public class KthSmallestNumberinSortedMatrixTest {
    private KthSmallestNumberinSortedMatrix obj = new KthSmallestNumberinSortedMatrix();
    @Test
    public void kthSmallest() throws Exception {
        int[][] matrix = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}};
        int k = 19;
        int expected = 7;
        assertEquals(expected, obj.kthSmallest(matrix, 19));
    }

}