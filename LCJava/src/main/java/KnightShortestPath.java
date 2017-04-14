import ingrediant.Point;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Created by zhaobo on 4/14/17.
 */
public class KnightShortestPath {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        //if either of the two points are not on Matrix
        if (!isInBound(grid, source) || !isInBound(grid, destination)) {
            return -1;
        }

        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};


        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);

        int level = 0;
        int startIndex = 0;

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for (startIndex = 0; startIndex < currentLevelSize; startIndex++) {
                Point head = queue.poll();
                for (int index = 0; index < deltaX.length; index++) {

                    int row = head.x + deltaX[index];
                    int col = head.y + deltaY[index];

                    if (row == destination.x && col == destination.y) {
                        return level + 1;
                    }

                    Point p = new Point(row, col);
                    if (isInBound(grid, p) && !grid[p.x][p.y]) {
                        queue.offer(p);
                        grid[p.x][p.y] = true;
                    }
                }

            }
            level++;
        }

        return -1;
    }

    private boolean isInBound(boolean[][] grid, Point point) {
        return point.x < grid.length && point.x >= 0 && point.y < grid[0].length && point.y >= 0;
    }
}
