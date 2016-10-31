using LeetCodeCSharp;
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LeetCodeCSharp.Tests
{
    [TestClass()]
    public class BinarySearchTest
    {
        [TestMethod()]
        public void SearchOneTest()
        {
            int[] source = { 1, 2, 3 };
            int target = 5;
            Assert.IsTrue(BinarySearch.SearchOne(source, target) == -1);
        }

        [TestMethod]
        public void SearchOneTestNullInput()
        {
            int[] source = { };
            int target = 5;
            Assert.IsTrue(BinarySearch.SearchOne(source, target) == -1);
        }

        [TestMethod]
        [ExpectedException(typeof(NotImplementedException))]
        public void SearchOneTestOverflow()
        {
            throw new NotImplementedException ("Not yet implemented due to C# Array size" ); //TODO
        }

        [TestMethod]
        public void SearchLastPostion()
        {
            int[] source = { 2, 2 };
            int target = 2;
            Assert.IsTrue(BinarySearch.SearchLastPosition(source, target) == 1);
        }

        [TestMethod]
        public void SearchLastPositionNormalCase()
        {
            int[] source = { 1, 2, 3, 3, 3, 3, 3, 3 };
            int target = 3;
            Assert.IsTrue(BinarySearch.SearchLastPosition(source, target) == 7);
        }
    }
}

