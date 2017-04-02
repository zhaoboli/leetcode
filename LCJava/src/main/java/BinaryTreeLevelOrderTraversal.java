import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaobo on 4/2/17.
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        int index = 0;
        while (index < queue.size()) {
            int end = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (index < end) {
                TreeNode node = queue.get(index);
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                index++;
            }
            result.add(level);
        }
        return result;
    }

    //using queue
    public ArrayList<ArrayList<Integer>> levelOrderI(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
           return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int queueSize = queue.size();
            int index = 0;
            while(index < queueSize) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                   queue.offer(node.left);
                }
                if (node.right != null) {
                   queue.offer(node.right);
                }
                index++;
           }
           result.add(level);
        }
        return result;
    }
}
