/**
 * Created by zhaobo on 5/3/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int j = 0;
        int[] map = new int[256];
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                int index = s.charAt(j);
                if (map[index] == 1) {
                    break;
                } else {
                    map[index] = 1;
                    j++;
                }
            }
            max = Math.max(max, j - i);
            int toRemoveIndex = s.charAt(i);
            map[toRemoveIndex] = 0;
        }
        return max;
    }
}
