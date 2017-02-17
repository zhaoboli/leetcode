using System;

namespace ConsoleApplication
{
    public class LastPositionOfTarget
    {
        /*
        @param nums: An integer array sorted in asending order
        @param target: An integer
        @return integer: index of item
         */
         public int LastPosition(int[] nums, int target) {
             if (nums == null || nums.Length == 0) {
                 return -1;
             }

             int start = 0;
             int end = nums.Length - 1;

             while ( start + 1 < end ) {
                int mid = start + (end - start) / 2; 
                if (nums[mid] == target) {
                    start = mid;
                }
                else if (nums[mid] < target) {
                    start = mid;
                }
                else {
                    end = mid;
                }
             }

             if (nums[end] == target) {
                 return end;
             }
             
             if (nums[start] == target) {
                 return start;
             }

             return -1;
         }
    }
}
