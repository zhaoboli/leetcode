using Xunit;
using ProbSolution;

namespace Test
{
    public class CopyBooksTest
    {
        private readonly CopyBooksProb copyBooksProb;

        public CopyBooksTest() {
            copyBooksProb = new CopyBooksProb();
        }

        [Fact]
        public void TestCaseOne() 
        {
            int[] inputPages = {3, 2, 4};
            int inputK = 2;
            int actualValue = copyBooksProb.CopyBooks(inputPages, inputK);
            Assert.Equal(5, actualValue);
        }
        [Fact]
        public void TestCaseTwo()
        {
            int[] inputPage = {13, 999, 1, 2, 3, 9, 11};
            int inputK = 2;
            int actualValue = copyBooksProb.CopyBooks(inputPage, inputK);
            Assert.Equal(1012, actualValue);
        }
    }
}
