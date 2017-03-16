using System.Collections.Generic;

namespace ProbSolution
{
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    //iterative
    public class PreOrderTraversalProb
    {
        public List<int> PreOrder(TreeNode root) {
            List<int> result = new List<int>();
            if (root == null) {
               return result; 
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.Push(root);

            while( stack.Count > 0) {
                TreeNode node = stack.Pop();
                result.Add(node.val);
                if (node.left != null) {
                    stack.Push(node.right);
                }
                if (node.right != null) {
                    stack.Push(node.left);
                }
            }

            return result;
        }
    }
}