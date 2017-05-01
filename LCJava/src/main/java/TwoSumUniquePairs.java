import java.util.Arrays;

/**
 * Created by zhaobo on 5/1/17.
 */
public class TwoSumUniquePairs {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        int counter = 0;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                counter++;
                left++;
                right--;
                while(nums[left] == nums[left - 1] && left < right) {
                    left++;
                }
                while(nums[right] == nums[right + 1] && left < right) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }

        }
        return counter;
    }
}
