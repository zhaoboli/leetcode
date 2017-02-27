using LeetCodeCSharp.Models;

namespace LeetCodeCSharpTest
{
    class BinaryTreeHelper
    {
        /*
         *    1
         *   / \
         *  2   3
         * / \
         * 4  5
         * 
         **/
        public static TreeNode GetBinaryTree()
        {
            TreeNode root = new TreeNode();
            root.Value = 1;

            TreeNode leftChild = new TreeNode();
            leftChild.Value = 2;
            TreeNode rightChild = new TreeNode();
            rightChild.Value = 3;

            root.Left = leftChild;
            root.Right = rightChild;

            TreeNode leftGrandLeftChild = new TreeNode();
            leftGrandLeftChild.Value = 4;
            TreeNode rightGrandRightChild = new TreeNode();
            rightGrandRightChild.Value = 5;

            leftChild.Left = leftGrandLeftChild;
            leftChild.Right = rightGrandRightChild;

            return root;               
        }
    }
}
