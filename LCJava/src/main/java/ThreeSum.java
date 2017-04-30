import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhaobo on 4/30/17.
 */
public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if (numbers == null || numbers.length == 0 || numbers.length <= 2) {
            return result;
        }

        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length && i < numbers.length - 2; i++) {
            // notice here >= 1
            if(i >= 1 && numbers[i] == numbers[i-1]) {
                continue;
            } else {
                //if no less than 3 numbers left
                int target = -numbers[i];
                threeSumHelper(i + 1, numbers.length - 1, numbers, target, result);
            }
        }
        return result;
    }

    private void threeSumHelper(int start, int end,
                                int[] numbers, int target,
                                ArrayList<ArrayList<Integer>> result) {
        int left = start;
        int right = end;
        while(left < right) {
            if (numbers[left] + numbers[right] == target) {
                ArrayList<Integer> ans = new ArrayList<Integer>();
                ans.add(-target);
                ans.add(numbers[left]);
                ans.add(numbers[right]);
                result.add(ans);
                left++;
                right--;
                //sequence is important
                //remove duplicates after found match
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                //remove duplicates after found match
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
