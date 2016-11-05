using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/**
 *
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 * This matrix has the following properties:

 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * [
 *   [1, 3, 5, 7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 *
 */

namespace LeetCodeCSharp
{
    public class Search2DMatrix
    {
        //Binary serach twice
        public static bool Search2DMatrix_a(int[][] matrix, int target)
        {
            if (matrix == null || matrix.Length == 0)
                return false;
            if (matrix[0] == null || matrix[0].Length == 0)
                return false;

            int start = 0;
            int end = matrix.Length - 1;
            
            while(start + 1 < end)
            {
                int mid = start + (end - start) / 2;

                if (matrix[mid][0] == target)
                    return true;
                else if (matrix[mid][0] < target)
                    start = mid;
                else
                    end = mid;
            }

            if (matrix[start][0] == target || matrix[end][0] == target)
                return true;

            int targetRow = 0;

            if (matrix[end][0] <= target)
                targetRow = end;
            else if (matrix[start][0] <= target)
                targetRow = start;
            else 
                return false;

            start = 0;
            end = matrix[targetRow].Length - 1;

            while (start + 1 < end)
            {
                int mid = start + (end - start) / 2;
                if (matrix[targetRow][mid] == target)
                    return true;
                else if (matrix[targetRow][mid] < target)
                    mid = start;
                else 
                    mid = end;
            }

            if (matrix[targetRow][start] == target)
                return true;
            if (matrix[targetRow][end] == target)
                return true;

            return false;
        }
        
        //one Search: treat as 1 d array
        public static bool Search2DMatrix_b(int[][] matrix, int target)
        {
            if (matrix == null || matrix.Length == 0)
                return false;

            if (matrix[0] == null || matrix[0].Length == 0)
                return false;

            int start = 0;
            int end = matrix.Length * matrix[0].Length - 1;
            int colLength = matrix[0].Length;

            while (start + 1 < end)
            {
                int mid = start + (end - start) / 2;
                int current = matrix[mid / colLength][ mid % colLength];

                if (current == target)
                    return true;
                else if (current < target)
                    start = mid;
                else
                    end = mid; 
            }

            if (matrix[start / colLength][start % colLength] == target)
                return true;
            if (matrix[end / colLength][end % colLength] == target)
                return true;
            return false;  
        }
    }
}
