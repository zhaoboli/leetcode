import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaobo on 4/20/17.
 */
public class CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        List<Integer>  startPath = new ArrayList<>();
        combinationSumHelper(num, startPath, 0, 0, target, result);
        return result;
    }

    private void combinationSumHelper(int[] num, List<Integer> path, int position, int currentSum, int target, List<List<Integer>> result) {
        List<Integer> currPath = new ArrayList<Integer>(path);
        if (currentSum == target) {
            result.add(currPath);
            return;
        }
        if (currentSum > target) {
            return;
        }
        for (int index = position; index < num.length; index++) {
            //if a number is encouterred at the same recursion level, only counted it once
            if (index - position > 0 && num[index] == num[index - 1]) {
                continue;
            }
            currentSum += num[index];
            currPath.add(num[index]);
            combinationSumHelper(num, currPath, index + 1, currentSum, target, result);
            currentSum -= num[index];
            currPath.remove(currPath.size() - 1);
        }
    }
}
