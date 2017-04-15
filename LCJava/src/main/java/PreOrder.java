import ingrediant.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhaobo on 3/19/17.
 */
public class PreOrder {
    public ArrayList<Integer> preOrderTraverse(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        preOrderTravel(root, result);
        return result;
    }

    private void preOrderTravel(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrderTravel(root.left, result);
        preOrderTravel(root.right, result);
    }

    public ArrayList<Integer> preOrderTraverseDivideConq(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null) {
            return result;
        }

        ArrayList<Integer> leftChild = preOrderTraverseDivideConq(root.left);
        ArrayList<Integer> rightChild = preOrderTraverseDivideConq(root.right);

        result.add(root.val);
        result.addAll(leftChild);
        result.addAll(rightChild);

        return result;
    }
    public ArrayList<Integer> preOrderTraverseIterate(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return null;
        }
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
