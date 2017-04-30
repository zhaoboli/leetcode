import java.util.HashSet;

/**
 * Created by zhaobo on 4/30/17.
 * [1,3,1,4,4,2]
 */
public class RemoveDuplicateNumbersinArray {

    public int deduplication(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        HashSet<Integer> hash = new HashSet<Integer>();

        while (head <= tail) {
            while (head <= tail && !hash.contains(nums[head])) {
                hash.add(nums[head]);
                head++;
            }
            while (head <= tail) {
                if (hash.contains(nums[tail])) {
                    tail--;
                } else {
                    nums[head] = nums[tail];
                    tail--;
                    break;
                }
            }
        }
        return hash.size();
    }

    public int deduplicationHash(int[] nums) {
        int head = 0;
        HashSet<Integer> hash = new HashSet<>();

        for (int index = 0; index < nums.length; index++) {
            if(!hash.contains(nums[index])) {
                hash.add(nums[index]);
            } else {
                continue;
            }
        }

        return hash.size();
    }
}
