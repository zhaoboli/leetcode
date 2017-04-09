package ingrediant;

import java.util.ArrayList;

/**
 * Created by zhaobo on 4/8/17.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
}
