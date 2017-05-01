import java.util.Arrays;

/**
 * Created by zhaobo on 5/1/17.
 */
public class TwoSumClosestToTarget {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        int minDiff = Integer.MAX_VALUE;
        if (nums == null || nums.length <= 1) {
            return minDiff;
        }
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            int actualDiff = target - sum;
            if (actualDiff < 0) {
                minDiff = Math.min(Math.abs(actualDiff), Math.abs(minDiff));
                right--;
            } else if (actualDiff > 0) {
                minDiff = Math.min(Math.abs(actualDiff), Math.abs(minDiff));
                left++;
            } else {
                minDiff = 0;
                break;
            }
        }
        return minDiff;
    }
}
