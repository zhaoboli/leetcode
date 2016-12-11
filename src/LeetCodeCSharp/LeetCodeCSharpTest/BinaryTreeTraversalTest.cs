using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeCSharp.Models;
using LeetCodeCSharp;
using System.Linq;
using System.Text;

namespace LeetCodeCSharpTest
{
    [TestClass]
    public class BinaryTreeTraversalTest
    { 
        /*
         *    1
         *   / \
         *  2   3
         * / \
         * 4  5
         **/
        private TreeNode GetBinaryTree()
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

        [TestMethod]
        public void PreOrderTraversalTest()
        {
            StringBuilder resultStr = new StringBuilder();
            BinaryTreeTraversal.PreOrderTraversal(GetBinaryTree()).Select(x => resultStr.Append(x));

            String.Equals(new StringBuilder("12453"), resultStr);
            
        }

        [TestMethod]
        public void PreOrderTraversalDCTest()
        {
            StringBuilder resultStr = new StringBuilder();
            BinaryTreeTraversal.PreOrderTraversalDC(GetBinaryTree()).Select(x => resultStr.Append(x));

            String.Equals(new StringBuilder("12453"), resultStr);
            
        }

        [TestMethod]
        public void PreOrderTraversalDCTest_Null()
        {
            StringBuilder resultStr = new StringBuilder();
            BinaryTreeTraversal.PreOrderTraversalDC(null).Select(x => resultStr.Append(x));

            String.Equals(new StringBuilder(""), resultStr); 
        }
    }
}
