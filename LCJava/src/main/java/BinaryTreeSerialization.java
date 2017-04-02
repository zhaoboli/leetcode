import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaobo on 3/28/17.
 *
 *Design an algorithm and write code to serialize and deserialize a binary tree.
 *Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 *
 * Notice: There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize,
 * it won't check the result of serialize.
 * Example:
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
 *  3
 / \
9  20
  /  \
 15   7
 * */
public class BinaryTreeSerialization {

    public String serialize(TreeNode root) {
       if (root == null) {
          return "{}";//TODO
       }

       ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
       queue.add(root);
       for (int i = 0; i < queue.size(); i++) {
           TreeNode node = queue.get(i);
           if (node != null)  {
           queue.add(node.left);
           queue.add(node.right);
           }
       }

       while (queue.get(queue.size() - 1) == null) {
          queue.remove(queue.size() - 1);
       }

       StringBuilder sb = new StringBuilder();
       sb.append("{");
       for (int j = 0; j < queue.size(); j++) {
           if(queue.get(j) == null) {
               sb.append("#");
           }
           else {
               sb.append(queue.get(j).val);
           }
           if (j != queue.size() -1) {
               sb.append(",");
           }
       }
       sb.append("}");
       return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "{}") {
            return  null;
        }
        String trimedData = data.substring(1, data.length() - 1);
        String[] source = trimedData.split(",");

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root  = new TreeNode(Integer.parseInt(source[0]));
        queue.offer(root);
        boolean isLeftChild = true;
        TreeNode head = queue.poll();

        for(int i = 1; i < source.length; i++) {
            if (!source[i].equals("#")) {
               TreeNode node = new TreeNode(Integer.parseInt(source[i]));
                if(isLeftChild) {
                    head.left = node;
                } else {
                    head.right = node;
                }
                queue.offer(node);
            }
            isLeftChild = !isLeftChild;
            if (isLeftChild == true) {
                head = queue.poll();
            }
        }
        return root;
    }
}
