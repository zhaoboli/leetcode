import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaobo on 4/4/17.
 */
public class IntersectionofTwoArrays {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    // use hash table, time O(m) + O(n), space, m or n
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> numSet1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (numSet1.contains(nums1[i])) {
                continue;
            }
            numSet1.add(nums1[i]);
        }
        Set<Integer> result = new HashSet<Integer>();
        for (int j =0; j < nums2.length; j++) {
            if (!numSet1.contains(nums2[j])) {
                continue;
            }
            if (result.contains(nums2[j])) {
                continue;
            }
            result.add(nums2[j]);
        }

        int size = result.size();
        int[] resultArr = new int[size];
        int index = 0;
        for (Integer num : result) {
            resultArr[index++] = num;
        }
        return resultArr;
        
    }
}
