import ingrediant.TreeNode;

/**
 * Created by zhaobo on 3/26/17.
 */
public class ValidateBinarySearchTree {
    public ResultType isValidBST(TreeNode root) {
       if (root == null) {
           return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
       }
       ResultType left = isValidBST(root.left);
       ResultType right = isValidBST(root.right);

       if (!left.is_bst || !right.is_bst) {
           return new ResultType(false, 0, 0);
       }
       if (root.left != null && left.max >= root.val ||
               root.right != null && right.min <= root.val) {
           return new ResultType(false, 0, 0);
       }
       return new ResultType(true, Math.max(root.val, right.max), Math.min(root.val, left.min));

    }

    public boolean isBST (TreeNode root) {
        ResultType result = isValidBST(root);
        return result.is_bst;
    }
    private class ResultType {
        public int max;
        public int min;
        public boolean is_bst;

        public ResultType(boolean is_bst, int max, int min) {
            this.is_bst = is_bst;
            this.max = max;
            this.min = min;
        }
    }
}
