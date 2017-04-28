/**
 * Created by zhaobo on 4/28/17.
 * Given an integer array, find a subarray with sum closest to zero.
 * Return the indexes of the first number and last number
 *
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 */
public class SubarraySumClosest {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int farSum = Integer.MAX_VALUE;
        int minSum = 0;
        int sum = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, Math.abs(sum - minSum));
        }
    }
}
