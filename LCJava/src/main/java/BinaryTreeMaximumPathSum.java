import com.sun.org.apache.regexp.internal.RE;
import ingrediant.TreeNode;

import javax.xml.transform.Result;

/**
 * Created by zhaobo on 4/16/17.
 */
public class BinaryTreeMaximumPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        return helper(root).any2any;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int root2Any = Math.max(Math.max(left.root2any, right.root2any), 0) + root.val;
        int any2Any = Math.max(left.any2any, right.any2any);

        any2Any = Math.max(any2Any, Math.max(0, left.root2any) + root.val + Math.max(0, right.root2any));

        return new ResultType(root2Any, any2Any);
    }

    private class ResultType {
        public int root2any;
        public int any2any;
        public ResultType(int root2any, int any2any) {
            this.root2any = root2any;
            this.any2any = any2any;
        }
    }
}
