import ingrediant.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobo on 4/14/17.
 */
public class BinaryTreePathSum {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */

    private List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        if (root == null) {
            return result;
        }
        ArrayList<Integer> startPath = new ArrayList<Integer>();
        helper(root, 0, startPath, target);
        return result;
    }

    private void helper(TreeNode root, int sum, ArrayList<Integer> path, int target) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(path);
        temp.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == target) {
            result.add(temp);
            return;
        }
        helper(root.left, sum, temp, target);
        helper(root.right, sum, temp, target);
    }
}
