import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static int[] toArray(String path) throws IOException {
        Path p = Paths.get(path);
        List<String> file = Files.readAllLines(p, StandardCharsets.UTF_8);
        String inputHolder = "";
        if(file.size() > 0 || file.size() < 2) {
            inputHolder = file.get(0);
        }
        String[] strArr = inputHolder.split(",");
        if (strArr.length == 0) {
            return new int[0];
        }
        int size = strArr.length;
        strArr[0] = strArr[0].substring(1);
        strArr[size - 1] = strArr[size - 1].substring(0, strArr[size -1].length() - 1);
        int[] output = new int[size];
        for (int index = 0; index < size; index++) {
            output[index] = Integer.parseInt(strArr[index]);
        }
        return output;
    }
}
