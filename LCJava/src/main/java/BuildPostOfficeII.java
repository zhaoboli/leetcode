import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nate_Li on 4/12/2017.
 * Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two),
 * find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.

 Return the smallest sum of distance. Return -1 if it is not possible.

 Notice

 You cannot pass through wall and house, but can pass through empty.
 You only build post office on an empty.

 Example
 Given a grid:

 0 1 0 0 0
 1 0 0 2 1
 0 1 0 0 0

 return 8, You can build at (1,1).

 (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)
 */
public class BuildPostOfficeII {
    /**
     * @param grid a 2D grid
     * @return an integer
     */

    private class Point {
        int x;
        int y;
        public Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public int shortestDistance(int[][] grid) {
        // Write your code here

        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        //the count holder for all houses
        int houseCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    houseCount++;
                }
            }
        }

        int shortestDistance = Integer.MAX_VALUE;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == 0) {
                    int[][] clone = this.deepCopyGrid(grid);
                    Point poi = new Point(m, n);
                    int distance = this.pointDistance(clone, poi, houseCount);
                    shortestDistance = Math.min(shortestDistance, distance);
                }
            }
        }

        if (shortestDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return shortestDistance;
    }

    private int[][] deepCopyGrid (int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];

        for (int u = 0; u < row; u++) {
            for (int v = 0; v < col; v++) {
                result[u][v] = grid[u][v];
            }
        }

        return result;
    }

    //BFS to find the sum of distance of a given point
    private int pointDistance (int[][] grid, Point point, int houses) {
        int[][] matrix = {{0, 1, 0, -1}, {1, 0, -1, 0}};
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        int levelDistance = 0;
        int sumOfDistance = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            levelDistance++;

            for (int start = 0; start < levelSize; start++) {
                Point head = queue.poll();
                for (int index = 0; index < matrix[0].length; index++) {
                    int row = head.x + matrix[0][index];
                    int col = head.y + matrix[1][index];
                    Point p = new Point(row, col);
                    if (isInBound(grid, p)) {
                        if (grid[p.x][p.y] == 1) {
                            houses--;
                            sumOfDistance += levelDistance;
                            grid[p.x][p.y] = 2;
                        }
                        if (grid[p.x][p.y] == 0) {
                            queue.offer(p);
                            grid[p.x][p.y] = 2;
                        }
                    }
                }

            }
        }

        if (houses == 0) {
            return sumOfDistance;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private boolean isInBound(int[][] grid, Point point) {
        return point.x >= 0 && point.x < grid.length && point.y >= 0 && point.y < grid[0].length;
    }
}
