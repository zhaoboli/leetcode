/**
 * use BFS to serialize and de-serialize for better readability
 * for example: Binary tree {3,9,20,#,#,15,7}
 *     3
 *   /  \
 *  9  20
 *     / \
 *    15  7
 *
 */
package Util;
import com.sun.javafx.image.IntPixelGetter;
import ingrediant.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeSerializer {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode head = queue.get(i);
            if (head == null) {
                continue;
            }
            queue.add(head.left);
            queue.add(head.right);
        }
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append('#');
            } else {
                sb.append(queue.get(i).val);
            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == "{}") {
            return null;
        }
        String trimedData= data.substring(1, data.length() - 1);
        String[] source = trimedData.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(source[0]));
        TreeNode head = root;
        boolean isLeftChild = true;

        for (int curr = 1; curr < source.length; curr++) {
            String s = source[curr];
            TreeNode node = null;
            if (!s.equals("#")) {
                node = new TreeNode(Integer.parseInt(s));
                queue.offer(node);
            }
            if (isLeftChild) {
                head.left = node;
            } else {
                head.right = node;
            }
            isLeftChild = !isLeftChild;
            if (isLeftChild) {
                head = queue.poll();
            }
        }
        return root;
    }
}
