import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zhaobo on 4/22/17.
 * Example
 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 */
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> resultRaw = new HashMap<Integer, List<String>>();
        if (dict == null) {
            return result;
        }
        ArrayList<String> ladder = new ArrayList<String>();
        ladder.add(start);

        Boolean[] isVisited = new Boolean[dict.size()];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        String[] dictArr = dict.toArray(new String[dict.size()]);

        findLaddersHelper(dictArr, isVisited, end, ladder, result);
        return result;
    }

    private void findLaddersHelper(String[] dict, Boolean[] isVisited, String end, ArrayList<String> ladder, List<List<String>> result) {
        if (isDiffByOne(ladder.get(ladder.size() - 1), end)) {
            if (!result.isEmpty() && result.get(result.size() - 1).size() > ladder.size() + 1) {
                //Use clear instead of last item, as there could be two lists with same number of steps
                result.clear();
            }
            if (!result.isEmpty() && result.get(result.size() - 1).size() < ladder.size() + 1) {
                return;
            }
            ladder.add(end);
            result.add(new ArrayList<String>(ladder));
            ladder.remove(ladder.size() - 1);
            return;
        }

        for (int i = 0; i < dict.length; i++)
            if (isDiffByOne(ladder.get(ladder.size() - 1), dict[i]) && !isVisited[i] ) {
                ladder.add(dict[i]);
                isVisited[i] = true;
                findLaddersHelper(dict, isVisited, end, ladder, result);
                isVisited[i] = false;
                ladder.remove(ladder.size() - 1);
            }
    }
    private boolean isDiffByOne(String s1, String s2) {
        if (s1.length() == 1 && !s1.equals(s2)) {
            return true;
        }
        int noEqualCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                noEqualCount++;
            }
        }
        return noEqualCount == 1;
    }
}
