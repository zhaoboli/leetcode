import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhaobo on 4/30/17.
 */
public class TwoSumLessThanEqualToTarget {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        int head = 0;
        int tail = nums.length - 1;
        int counter = 0;
        Arrays.sort(nums);
        while (head < tail) {
            while (head < tail && nums[head] + nums[tail] <= target) {
                counter++;
                head++;
            }
            while (head < tail && nums[head] + nums[tail] > target) {
                tail--;
                head = 0;
                break;
            }
        }
        return counter;
    }
    public int twoSum5Quick(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int head = 0;
        int tail = nums.length - 1;
        int count = 0;
        while (head < tail) {
            if (nums[head] + nums[tail] > target) {
                tail--;
            } else {
                count += tail - head;
                head++;
            }
        }
        return count;
    }
}
