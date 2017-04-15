import ingrediant.TreeNode;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by zhaobo on 4/15/17.
 */
public class BalancedBinaryTreeTest {
    private BalancedBinaryTree bst;
    private BinaryTreeSerialization btSerializer;
    public BalancedBinaryTreeTest() {
        this.bst = new BalancedBinaryTree();
        this.btSerializer = new BinaryTreeSerialization();
    }

    @Test
    public void BalancedBinaryTreeTestOne () {
        TreeNode tree = this.btSerializer.deserialize("{3,9,20,#,#,15,7}");
        boolean actul = bst.isBalanced(tree);
        assertEquals(true, actul);
    }

    @Test
    public void BalancedBinaryTreeTestTwo () {
        TreeNode tree = this.btSerializer.deserialize("{3,#,20,15,7}");
        boolean actual = bst.isBalanced(tree);
        assertEquals("not a BST", false, actual);
    }
}
