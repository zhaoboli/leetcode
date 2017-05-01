import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaobo on 5/1/17.
 */
public class TwoSum {
    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;

    public TwoSum() {
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Integer>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }

    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for(int i = 0; i< list.size(); i++) {
            int number1 = list.get(i);
            int number2 = value - number1;
            if ((number1 == number2 && map.get(number1) > 1)
                    || number1 != number2 && map.containsKey(number2)) {
                return true;
            }
        }
        return false;
    }
}
