import dinnerware.Plate;

import java.util.Map;
import java.util.Set;

/**
 * Created by zhaobo on 4/4/17.
 */
public class Program {

    public static void main (String[] args) {
        GraphValidTree graph = new GraphValidTree();
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        //int[][] edges =  [[0, 1], [0, 2], [0, 3], [1, 4]];
        Map<Integer, Set<Integer>> result = graph.initializeGraph(5, edges);
        System.out.println("this is the end");

        Plate myplate = new Plate("home");
        myplate.Print();
    }
}
