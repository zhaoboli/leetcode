import dinnerware.Plate;

import java.util.*;

/**
 * Created by zhaobo on 4/4/17.
 */
public class Program {

    public static void main (String[] args) {
        String crt = "hit";
        Set<String> temp = new LinkedHashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        //List<String> result = expand("hit", temp);
        System.out.println(crt.substring(3));
    }

    private static List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
}
