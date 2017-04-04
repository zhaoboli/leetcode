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
}
