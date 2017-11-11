import java.util.*;
/**
 * Created by zhaobo on 4/3/17.
 */
public class GraphValidTree {
    public Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        return graph;
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges == null) {
            return false;
        }

        if (edges.length != n -1) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        HashSet<Integer> hash = new HashSet<Integer>();
        hash.add(0);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for(Integer j : graph.get(temp)) {
                if (hash.contains(j)) {
                    continue;
                }
                hash.add(j);
                queue.offer(j);
            }
        }
        return hash.size() == n;
    }

    public boolean validTreeIi(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        if ((n - 1) != edges.length) {
            return false;
        }
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < edges.length; i++) {
            uf.connect(edges[i][0], edges[i][1]);
        }
        int root = uf.find(0);
        for (int i = 0; i < n; i++) {
            if (uf.find(i) != root) {
                return false;
            }
        }
        return true;
    }

    private class UnionFind {
        int[] father = null;

        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i]  = i;
            }
        }

        private void connect(int left, int right) {
            int fatherLeft = find(left);
            int fatherRight = find(right);
            if (fatherLeft != fatherRight) {
                father[fatherLeft] = fatherRight;
            }
        }

        private int find(int child) {
            if (father[child] != child) {
                return father[child] = find(father[child]);
            }
            return child;
        }
    }
}
