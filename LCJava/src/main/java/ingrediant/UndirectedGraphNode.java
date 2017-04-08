package ingrediant;

import java.util.ArrayList;

/**
 * Created by zhaobo on 4/8/17.
 */
public class UndirectedGraphNode {
     // Definition for graph node.
     public int label;
     public ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
     }
}
