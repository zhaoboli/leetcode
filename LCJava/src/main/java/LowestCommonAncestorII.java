import java.util.ArrayList;

/**
 * Created by zhaobo on 4/1/17.
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

 The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

 The node has an extra attribute parent which point to the father of itself. The root's parent is null.

 For the following binary tree:

   4
  / \
 3   7
    / \
    5   6

 LCA(3, 5) = 4

 LCA(5, 6) = 7

 LCA(6, 7) = 7
 */
public class LowestCommonAncestorII {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if (root == null) {
            return null;
        }

        ArrayList<ParentTreeNode> aPath = PathToRoot(A);
        ArrayList<ParentTreeNode> bPath = PathToRoot(B);

        int aIndex = aPath.size() - 1;
        int bIndex = bPath.size() - 1;
        int lcaIndex = aIndex;
        while (aIndex >= 0 && bIndex >= 0) {
            if (aPath.get(aIndex) != bPath.get(bIndex)) {
               break;
            }
            lcaIndex = aIndex;
            aIndex--;
            bIndex--;
        }
        return aPath.get(lcaIndex);
    }

    private ArrayList<ParentTreeNode> PathToRoot(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        path.add(node);
        while(node.parent != null) {
            node = node.parent;
            path.add(node);
        }
        return path;
    }
}
