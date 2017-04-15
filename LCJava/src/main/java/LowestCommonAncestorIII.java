import ingrediant.TreeNode;

/**
 * Created by zhaobo on 3/31/17.
 */
public class LowestCommonAncestorIII {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    private class ResultType {
        public TreeNode node;
        public boolean isAExist;
        public boolean isBExist;
        public ResultType (TreeNode node, boolean isAExist, boolean isBExist) {
            this.node = node;
            this.isAExist = isAExist;
            this.isBExist = isBExist;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = helper(root, A, B);

        if (result.isAExist && result.isBExist) {
            return result.node;
        }
        return null;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(null, false, false);
        }

        boolean isAExist = false;
        boolean isBExist = false;

        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        if (root.val == A.val || left.isAExist || right.isAExist) {
            isAExist = true;
        }
        if (root.val == B.val || right.isBExist || left.isBExist) {
            isBExist = true;
        }

        //logic for decision logic

        if (root.val == A.val || root.val == B.val) {
            return new ResultType(root, isAExist, isBExist);
        }

        // this doesn't mean root is the one we are looking for
        if (left.node != null && right.node != null) {
            return new ResultType(root, isAExist, isBExist);
        }

        // only considers the postivie scenario, missed to consider the negative scenario
        //as when left is not null, left could be only having one node found

        if (left.node != null) {
            return new ResultType(left.node, isAExist, isBExist);
        }
        if (right.node != null) {
            return new ResultType(right.node, isAExist, isBExist);
        }
        return new ResultType(null, isAExist, isBExist);
    }
}
