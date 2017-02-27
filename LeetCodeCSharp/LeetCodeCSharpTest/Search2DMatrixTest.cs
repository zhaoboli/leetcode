using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeCSharp;

namespace LeetCodeCSharpTest
{
    [TestClass]
    public class Search2DMatrixTest
    {

        [TestMethod]
        public void Search2DMetrix_a_Test()
        {
            int[][] targetMatrix =new int[][] { new int[] { 1, 3, 5, 7 },
                                     new int[]{ 10, 11, 16, 20 },
                                     new int[] { 23, 30, 34, 50 } };
            Assert.IsTrue(Search2DMatrix.Search2DMatrix_a(targetMatrix, 3));
        }

        [TestMethod]
        public void Search2DMetrix_a_TestNull()
        {
            int[][] targetMatrix = new int[][] { new int[] { } };
            Assert.IsFalse(Search2DMatrix.Search2DMatrix_a(targetMatrix, 2));
        }

        [TestMethod]
        public void Search2DMetrix_b_TestNull()
        {
            int[][] sourceMetrix = new int[][] { new int[] { } };
            Assert.IsFalse(Search2DMatrix.Search2DMatrix_b(sourceMetrix, 2));
        }

        [TestMethod]
        public void Search2DMetrix_b_Test()
        {
            //int[][] sourceMetrix = new int[][] { }
            int[][] sourceMatrix =new int[][] {
                new int[] { 1, 2 },
                new int[] { 3, 4 } };
            Assert.IsTrue(Search2DMatrix.Search2DMatrix_b(sourceMatrix, 3));
        }
    }
}
