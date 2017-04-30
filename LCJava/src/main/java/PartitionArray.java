/**
 * Created by zhaobo on 5/1/17.
 */
public class PartitionArray {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     *
     *        *        */
    public int partitionArray(int[] nums, int k) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int less = 0;
        int greater = nums.length - 1;
        int i = 0;
        while (i <= greater) {
            if (nums[i] < k) {
                i++;
                less++;
            } else {
                swap(nums, i, greater);
                greater--;
            }
        }
        return less;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
