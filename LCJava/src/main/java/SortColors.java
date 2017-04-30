/**
 * Created by zhaobo on 4/30/17.
 */
public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     * [1, 0, 1, 2]
     */
    public void sortColors(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;

        int red = 0;
        int blue = nums.length - 1;

        while (left <= right) {
            while (left <= right) {
                if (nums[left] == 0) {
                    swap(nums, left, red);
                    red++;
                    left++;
                } else if(nums[left] == 1) {
                    left++;
                } else {
                    break;
                }
            }
            while (left <= right) {
                if (nums[right] == 2) {
                    swap(nums, right, blue);
                    right--;
                    blue--;
                } else if (nums[right] == 1) {
                    right--;
                } else {
                    break;
                }
            }
            if (left <= right) {
                swap(nums, left, right);
            }
        }
        return;
    }
    private void swap(int[] nums, int from, int to) {
        if (from == to) {
            return;
        }
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
        return;
    }

    public void sortColorsQuick(int[] nums) {

        int lred = 0;
        int rblue = nums.length - 1;
        int i = 0;
        while (i <= rblue) {
            if (nums[i] == 0) {
                swap(nums, lred, i);
                i++;
                lred++;
            } else if(nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, rblue, i);
                rblue--;
            }
        }
    }
}

