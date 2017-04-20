import ingrediant.TreeNode;

/**
 * Created by zhaobo on 4/16/17.
 */
public class BinaryTreeMaximumPathSumII {
    /**
     *
     * @param root - root of binary tree
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        return Math.max(0, Math.max(left, right)) + root.val;
    }
}

