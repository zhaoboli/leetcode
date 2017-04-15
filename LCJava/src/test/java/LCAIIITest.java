import ingrediant.TreeNode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhaobo on 3/31/17.
 */
public class LCAIIITest {
    @Test
    public void LCAIIITestCaseOne() {
        LowestCommonAncestorIII lca3 = new LowestCommonAncestorIII();
        TreeNode root = new TreeNode(1, null, null);
        TreeNode A = new TreeNode(1, null, null);
        TreeNode B = new TreeNode(1, null, null);
        TreeNode result = lca3.lowestCommonAncestor3(root, A, B);
        assertEquals("case {1}",root.val,result.val);
    }

    @Test
    public void LCAIIITestCaseTwo() {
        LowestCommonAncestorIII lca3 = new LowestCommonAncestorIII();
        TreeNode leaf = new TreeNode(-1, null, null);
        TreeNode root = new TreeNode(2, leaf, null);
        TreeNode a = new TreeNode(-1, null, null);
        TreeNode b = new TreeNode(2, null, null);
        TreeNode result = lca3.lowestCommonAncestor3(root, a, b);
        assertEquals("case {2, -1}", b.val, result.val );
    }
}
