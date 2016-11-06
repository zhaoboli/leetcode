using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LeetCodeCSharp.Models;

namespace LeetCodeCSharp
{
    public class BinaryTreeTraversal
    {
        public static List<int> PreOrderTraversal(TreeNode root)
        {
            List<int> result = new List<int>();
            TraversePreOrder(root, result);
            return result;
             
        }

        private static void TraversePreOrder(TreeNode node, List<int> result)
        {
            if (node == null)
                return;
            result.Add(node.Value);
            TraversePreOrder(node.Left, result);
            TraversePreOrder(node.Right, result);

        }
        
    }
}
