using System;

namespace ConsoleApplication
{
    public class Search2DMatrix 
    {
        public Boolean SearchMatrix (int[][] matrix, int target) {

            if (matrix == null || matrix.Length == 0) {
                return false;
            }

            int startRow = 0;
            int endRow = matrix.Length - 1;
            int targetRow = 0;

            while (startRow + 1 < endRow) {
                int midRow = startRow + (endRow - startRow) /2 ;
                if (matrix[midRow][0] <= target) {
                    startRow = midRow;
                    //can be optimized
                }
                else {
                    endRow = midRow;
                }
            }
            if (matrix[endRow][0] <= target) {
                targetRow = endRow;
            }
            else if (matrix[startRow][0] <= target) {
                targetRow = startRow;
            }
            else {
                return false;
            }

            int start = 0;
            int end = matrix[targetRow].Length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) /2;
                if (matrix[targetRow][mid] == target) {
                    return true;
                }
                else if (matrix[targetRow][mid] < target) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
            if (matrix[targetRow][start] == target) {
                return true;
            }
            if (matrix[targetRow][end] == target) {
                return true;
            }
            return false;
        }
    }
}