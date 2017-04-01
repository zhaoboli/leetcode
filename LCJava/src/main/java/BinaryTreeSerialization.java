import java.util.ArrayList;

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
       for (int i = 0; i < (queue.size() - 1); i++) {
           TreeNode node = queue.get(i);
           if (node != null)  {
           queue.add(root.left);
           queue.add(root.right);
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
        String trimedData = data.substring(1, data.length() - 2);
        String[] source = trimedData.split(",");

        for(int i = 0; i < source.length; i++) {
            //TODO
        }
        return new TreeNode(0, null, null);
    }
}
