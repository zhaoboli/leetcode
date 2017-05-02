import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.prefs.NodeChangeEvent;

/**
 * Created by zhaobo on 5/2/17.
 * Given k = 4 and a matrix:

 [
 [1 ,5 ,7],
 [3 ,7 ,8],
 [4 ,8 ,9],
 ]
 return 5
 */
public class KthSmallestNumberinSortedMatrix {
    private class Node {
        public int row;
        public int col;
        public int val;
        public Node(int row, int col, int val) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        Queue<Node> heap = new PriorityQueue<Node>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });


        int index = 0;
        heap.add(new Node(0, 0, matrix[0][0]));
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] hash = new boolean[row][col];

        while (!heap.isEmpty()) {
            Node head = heap.poll();
            index++;
            if (index == k) {
                return head.val;
            }

            int x = head.row;
            int y = head.col;
            if (y + 1 < col) {
                if (!hash[x][y + 1]) {
                    Node right = new Node(x, y + 1, matrix[x][y + 1]);
                    heap.offer(right);
                    hash[x][y + 1] = true;
                }
            }
            if (x + 1 < row) {
                if (!hash[x + 1][y]) {
                    Node down = new Node(x + 1, y, matrix[x + 1][y]);
                    heap.offer(down);
                    hash[x + 1][y] = true;
                }
            }
        }
        return 0;
    }
}

