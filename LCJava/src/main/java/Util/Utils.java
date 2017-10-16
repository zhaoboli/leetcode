package Util;

import java.util.List;
import java.util.ArrayList;
public class Utils {
    public static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }

        return list;
    }

    public static String toBitString (int num) {
        return String.format("%32s", Integer.toBinaryString(1)).replace(' ', '0');
    }
}
