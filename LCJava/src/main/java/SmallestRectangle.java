/**
 * Created by zhaobo on 3/29/17.
 */
public class SmallestRectangle {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, image[0].length - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, image.length -1);

        return (right - left + 1) * (bottom - top + 1);

    }

    private int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!isEmptyColumn(image, start)) {
            return start;
        }
        return end;
    }

    private int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!isEmptyColumn(image, end)) {
            return end;
        }
        return start;
    }

    private int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!isEmptyRow(image, start)) {
            return start;
        }
        return end;
    }

    private int findBottom(char[][] image, int start, int end) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!isEmptyRow(image, end)) {
            return end;
        }
        return start;
    }

    private boolean isEmptyColumn(char[][] image, int col) {
        for (int j = 0; j < image.length; j++) {
            if (image[j][col] == '1') {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyRow(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                return false;
            }
        }
        return true;
    }
}
