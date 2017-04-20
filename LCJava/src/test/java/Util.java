import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

/**
 * Created by zhaobo on 4/20/17.
 */
public class Util {
    public static List<List<Integer>> toListofList(int[][] input) {
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                row.add(input[i][j]);
            }
            output.add(row);
        }
        return output;
    }
}
