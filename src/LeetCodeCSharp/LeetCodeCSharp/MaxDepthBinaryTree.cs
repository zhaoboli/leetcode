using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LeetCodeCSharp.Models;

namespace LeetCodeCSharp
{
    public class MaxDepthBinaryTree
    {
        public int MaxDepthDc(TreeNode root)
        {
            if (root == null)
                return 0;
            int depth = 1 + Math.Max(MaxDepthDc(root.Left), MaxDepthDc(root.Right));
            return depth;            
        }


        private int _depth;

        //Traverse with a Global memo
        public int MaxDepthTraverse(TreeNode root)
        {
            if (root == null)
                return 0;

            TraverseHelper(root, _depth + 1);

            return _depth;
        }

        private void TraverseHelper(TreeNode root, int curDepth)
        {
            if (root == null)
                return;
            if (curDepth > _depth)
                _depth = curDepth;

            TraverseHelper(root.Left, curDepth + 1);
            TraverseHelper(root.Right, curDepth + 1);
        }
    }
}
