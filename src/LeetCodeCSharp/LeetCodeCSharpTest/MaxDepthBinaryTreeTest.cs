using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeCSharp.Models;
using LeetCodeCSharp;

namespace LeetCodeCSharpTest
{
    [TestClass]
    public class MaxDepthBinaryTreeTest
    {

        private MaxDepthBinaryTree _maxDepthBinaryTreeObj;

        private MaxDepthBinaryTree SearchTree
        {
            get
            {
                if (_maxDepthBinaryTreeObj == null)
                {
                    _maxDepthBinaryTreeObj = new MaxDepthBinaryTree();
                }
                return _maxDepthBinaryTreeObj;
            }                
         }

        [TestMethod]
        public void MaxDepthDcTest()
        {
            TreeNode root = BinaryTreeHelper.GetBinaryTree();
            Assert.AreEqual(3, SearchTree.MaxDepthDc(root));
        }

        [TestMethod]
        public void MaxDepthTraverseTest()
        {
            TreeNode root = BinaryTreeHelper.GetBinaryTree();
            Assert.AreEqual(3, SearchTree.MaxDepthTraverse(root));
        }
    }
}
