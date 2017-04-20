import ingrediant.TreeNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhaobo on 4/16/17.
 */
public class BinaryTreeMaximumPathSumTest {
    private BinaryTreeSerialization btSerializer;
    private BinaryTreeMaximumPathSum btMaxPathSum;

    public BinaryTreeMaximumPathSumTest() {
        this.btMaxPathSum = new BinaryTreeMaximumPathSum();
        this.btSerializer = new BinaryTreeSerialization();
    }

    @Test
    public void binaryTreeMaximumPathSumTestOne() {
        TreeNode tree = btSerializer.deserialize("{1,2,3}");
        int actual = btMaxPathSum.maxPathSum(tree);
        assertEquals("binary tree max path sum test", 6, actual);
    }
    @Test
    public void binaryTreeMaximumPathSumTestTwo() {
        TreeNode tree = btSerializer.deserialize("{-1,-2,-3}");
        int actual = btMaxPathSum.maxPathSum(tree);
        assertEquals("binary tree max path sum test", -1, actual);
    }
}
