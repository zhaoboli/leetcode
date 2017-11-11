import org.junit.Test;

import static org.junit.Assert.*;

public class GraphValidTreeTest {
    GraphValidTree graphValidTree = new GraphValidTree();
    @Test
    public void validTreeIi() throws Exception {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int ct = 5;
        graphValidTree.validTreeIi(ct, edges);
    }

}