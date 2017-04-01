import sun.reflect.generics.tree.Tree;

/**
 * Created by zhaobo on 3/19/17.
 */
public class MaximumDepthofBinaryTree {
    /**
     * @param root: the root of binary tree
     * @return: An integer
     */
    public int maxDepthDC(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthDC(root.left);
        int rightDepth = maxDepthDC(root.right);
        int maxDepth = Math.max(leftDepth, rightDepth) + 1;

        return maxDepth;
    }

    private int maxDepath;
    public int maxDepthTraverse(TreeNode root) {

        maxDepath = 0;
        helper(root, 1);
        return maxDepath;
    }

    public void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }

        if (currentDepth > maxDepath) {
            maxDepath = currentDepth;
        }
        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }
}
