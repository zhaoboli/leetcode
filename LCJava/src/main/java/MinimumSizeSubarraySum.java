import java.util.Arrays;

/**
 * Created by zhaobo on 5/1/17.
 */
public class MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int mini = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                sum += nums[j];
                j++;
                if (sum >= s) {
                   mini = Math.min(mini, j - i + 1);
                   sum -= nums[i];
                   break;
                }
            }
        }
        return mini;
    }
}
