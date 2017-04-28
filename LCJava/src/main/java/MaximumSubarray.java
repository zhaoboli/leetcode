/**
 * Created by zhaobo on 4/25/17.
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 *  Notice

 * The subarray should contain at least one number.
 * Example
 * Given the array [−2,2,−3,4,−1,2,1,−5,3],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int minPrefix = 0;
        int maxSubArray = Integer.MIN_VALUE;
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            maxSubArray = Math.max(maxSubArray, sum - minPrefix);
            /**
            prefix[j->i] = Sum(i) - Sum(j - 1); if i = 0; sum(0) - Sum(-1),
            so it's obvious minPrefixSum should start with 0, also consider
            if nums is a asending positive integer array, count j to i,
            prefix(i) should consider all elements minus 0
             */
            minPrefix = Math.min(minPrefix, sum);
        }
        return maxSubArray;
    }
}
