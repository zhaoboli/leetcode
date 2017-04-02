import java.util.ArrayList;

/**
 * Created by zhaobo on 4/2/17.
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        int index = 0;
        while (index < queue.size()) {
            int end = queue.size();
            ArrayList<Integer> row = new ArrayList<Integer>();
            while (index < end) {
                TreeNode node = queue.get(index);
                row.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                index++;
            }
            result.add(row);
        }
        return result;
    }
}
