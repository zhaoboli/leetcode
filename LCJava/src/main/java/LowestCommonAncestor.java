/**
 * Created by zhaobo on 4/1/17.
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

 The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 Notice

 Assume two nodes are exist in tree.
   4
  / \
 3   7
     / \
    5   6
 LCA(3, 5) = 4

 LCA(5, 6) = 7

 LCA(6, 7) = 7


 */
public class LowestCommonAncestor {

    //however, this implementation is not very straight forward
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        // if hit one of the node, as here the assumption is that two nodes are exist in tree
        if (root.val == A.val || root.val == B.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }
        //not found
        return null;
    }
}
