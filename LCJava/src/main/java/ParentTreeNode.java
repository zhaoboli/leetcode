/**
 * Created by zhaobo on 4/1/17.
 */
public class ParentTreeNode {
    public int val;

    public ParentTreeNode left;

    public ParentTreeNode right;

    public ParentTreeNode parent;

    public ParentTreeNode (int val, ParentTreeNode parent, ParentTreeNode left, ParentTreeNode right) {
        this.val = val;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
