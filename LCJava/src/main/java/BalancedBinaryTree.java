import ingrediant.TreeNode;

import javax.xml.transform.Result;

/**
 * Created by zhaobo on 4/15/17.
 */
public class BalancedBinaryTree {
    /**
     * @param root: the root of the binary tree
     * @return: True if this Binary tree is balanced, else folse
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return helper(root).isBalanced;

    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType leftChild = helper(root.left);
        ResultType rightChild = helper(root.right);

        if (!leftChild.isBalanced || !rightChild.isBalanced) {
            return new ResultType(false, -1);
        }

        if (Math.abs(leftChild.maxDepth - rightChild.maxDepth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(leftChild.maxDepth, rightChild.maxDepth) + 1);
    }
    private class ResultType {
        public boolean isBalanced;
        public int maxDepth;
        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }
}
