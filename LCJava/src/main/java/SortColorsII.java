/**
 * Created by zhaobo on 4/30/17.
 */
public class SortColorsII {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length < 2) {
            return;
        }

        int lColorPtr = 0;
        int rColorPtr = colors.length - 1;
        int lColor = 1;
        int rColor = k;
        while( lColor < rColor ) {
            int i = lColorPtr;
            while (i <= rColorPtr) {
                if (colors[i] == lColor) {
                    swap(colors, i, lColorPtr);
                    lColorPtr++;
                    i++;
                } else if (colors[i] == rColor) {
                    swap(colors, i, rColorPtr);
                    rColorPtr--;
                } else {
                    i++;
                }
            }
            lColor++;
            rColor--;
        }
    }

    private void swap(int[] colors, int from, int to) {
        int temp = colors[from];
        colors[from] = colors[to];
        colors[to] = temp;
    }
}

