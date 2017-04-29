import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhaobo on 4/28/17.
 * Given an integer array, find a subarray with sum closest to zero.
 * Return the indexes of the first number and last number
 *
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 */
public class SubarraySumClosest {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[] {0, 0};
        }
        Pair[] result = new Pair[nums.length + 1];

        int sum = 0;
        result[0] = new Pair(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            result[i] = new Pair(i, sum);
        }

        Arrays.sort(result);

        int minDiff = Integer.MAX_VALUE;
        int[] resultPair = new int[2];
        for (int index = 1; index < result.length; index++) {
            if (result[index].sum - result[index - 1].sum < minDiff) {
                minDiff = result[index].sum - result[index - 1].sum;
                resultPair[0] = result[index].index - 1;
                resultPair[1] = result[index - 1].index - 1;
                Arrays.sort(resultPair);
            }
        }
        resultPair[0] = resultPair[0] + 1;
        resultPair[1] = resultPair[1];

        return resultPair;
    }
    private class Pair implements Comparable<Pair> {
        public int index;
        public int sum;
        public Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.sum < pair.sum) {
                return -1;
            } else if (this.sum > pair.sum) {
                return 1;
            }

            return 0;
        }
    }
}
