import java.util.ArrayList;

/**
 * Created by zhaobo on 4/28/17.
 */
public class MaximumSubarrayII {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums.get(nums.size() - 1);
        }

        int max = Integer.MIN_VALUE;
        for(int partition = 1; partition < nums.size(); partition++ ) {
            int leftMax = maxSubArrayHelper(nums, 0 , partition);
            int rightMax = maxSubArrayHelper(nums, partition, nums.size());
            max = Math.max(max, leftMax + rightMax);
        }
        return max;
    }

    private int maxSubArrayHelper(ArrayList<Integer> nums, int start, int end) {
        int minSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = start; i < end ; i++) {
            sum += nums.get(i);
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return maxSum;
    }
}
