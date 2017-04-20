import ingrediant.TreeNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhaobo on 4/16/17.
 */
public class BinaryTreeMaximumPathSumIITest {
    private BinaryTreeSerialization btSerializer;
    private BinaryTreeMaximumPathSumII btMaxPathSum2;

    public BinaryTreeMaximumPathSumIITest() {
        this.btMaxPathSum2 = new BinaryTreeMaximumPathSumII();
        this.btSerializer = new BinaryTreeSerialization();
    }

    @Test
    public void BinaryTreeMaximumPathSumIITestOne() {
        TreeNode tree = btSerializer.deserialize("{1,2,3}");
        int actual = btMaxPathSum2.maxPathSum2(tree);
        assertEquals("BinaryTreeMaximumPathSumIITestOne", 4, actual);
    }
}
