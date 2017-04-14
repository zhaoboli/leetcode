import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaobo on 4/10/17.
 * Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
 * Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall.
 * How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
 *
 * Given a matrix:

 0 1 2 0 0
 1 0 0 2 1
 0 1 0 0 0

 return 2
 */
public class ZombieInMatrix {

    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */

    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int humansCount = 0;
        Queue<Coordinate> zombies = new LinkedList<Coordinate>();

        // count the humans and enque zombies
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    humansCount++;
                }
                if (grid[i][j] == 1) {
                    zombies.offer(new Coordinate(i, j));
                }
            }
        }

        int[][] directions = { {0, 1, 0, -1}, {1, 0, -1, 0} };

        int size = zombies.size();
        int dayCount = 1;

        while (!zombies.isEmpty()) {
            if (size > 0) {
                size--;
            } else {
                dayCount++;
                size = zombies.size();
            }
            Coordinate head = zombies.poll();
            for (int direct = 0; direct < directions[0].length; direct++) {
                int row = head.row + directions[0][direct];
                int col = head.col + directions[1][direct];
                if (isInBound(grid, row, col) && grid[row][col] == 0) {
                    zombies.offer(new Coordinate(row, col));
                    grid[row][col] = 1;
                    humansCount--;
                }
            }
        }
        if (humansCount == 0) {
            return  dayCount;
        }
        return -1;
    }

    private boolean isInBound(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    private class Coordinate {
        int row;
        int col;
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
