
public class FindTheMissingNumberII {
    /*
 * @param n: An integer
 * @param str: a string with number from 1-n in random order and miss one number
 * @return: An integer
 */
    public int findMissing2(int n, String str) {
        if (str == null) {
            return -1;
        }
        boolean[] flag = new boolean[n + 1];
        helper(str, n, 0, flag);
        return missingNum;
    }
    private int missingNum = -1;
    private void helper(String str, int n, int startIndex, boolean[] flag) {
        if (startIndex == str.length()) {
            int missingCt = 0;
            int missing = -1;
            for (int index = 1; index < flag.length; index++) {
                if (!flag[index]) {
                    missingCt++;
                    missing = index;
                }
            }
            //missed point, if it can traverse to the end, but with more than one missing number
            if (missingCt == 1) {
                missingNum = missing;
            }
            //missed point, dfs need to return in the end
            return;
        }
        //this was missed first
        if (str.charAt(startIndex) == '0') {
            return;
        }
        for (int i = 1; i <= 2; i++) {
            //missed point
            if (startIndex + i > str.length()) {
                break;
            }
            int curr = Integer.valueOf(str.substring(startIndex, startIndex + i));
            // curr > n was missed
            if (curr > n || flag[curr]) {
                continue;
            }
            flag[curr] = true;
            helper(str, n, startIndex + i, flag);
            flag[curr] = false;
        }
    }
}
