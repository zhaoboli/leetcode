using ProbSolution;
using Xunit;
using System.Collections.Generic;

namespace Test
{
    public class PreOrderTest
    {
       private readonly PreOrderTraversalProb preOrder;

       public PreOrderTest(){
           preOrder = new PreOrderTraversalProb();
       }

       [Fact]
       public void TestCaseOne()
       {
       //Given
            TreeNode leftChild = new TreeNode { val = 2, left = null, right = null};
            TreeNode rightChild = new TreeNode { val = 3, left =null, right = null};
            TreeNode root = new TreeNode { val = 1, left = leftChild, right = rightChild};
            List<int> actul = preOrder.PreOrder(root);
            List<int> expected = new List<int>{1, 2, 3};
            Assert.Equal(expected, actul);
       //When
       
       //Then
       }
    }
}