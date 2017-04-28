import java.util.ArrayList;

/**
 * Created by zhaobo on 4/24/17.
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 Notice
 There is at least one subarray that it's sum equals to zero.

 Example
 Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 */

public class SubarraySum {

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        int sum = nums[0];
        ArrayList<Integer> result = new ArrayList<Integer>();
        //subArrayHelper(nums, 0, 0, 0, result);
        return result;
    }

    private void subArrayHelper(int[] nums, int start, int sum, ArrayList<Integer> result) {
        /*
        if (sum == 0) {
            return new ArrayList<Integer>(start, end);
        }
        for (int index = start; index < nums.length; index++) {
            result.add(nums[index]);
            sum += nums[index];
            subArrayHelper(nums, index + 1, sum);
            sum -= nums[index];
        }
        */
    }
}
