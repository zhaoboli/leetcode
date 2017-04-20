import ingrediant.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhaobo on 4/16/17.
 */
public class BinaryTreePathSumIITest {
    private BinaryTreePathSumII binaryTeePathSumIIObj;
    private BinaryTreeSerialization btSerializer;

    public BinaryTreePathSumIITest() {
        this.binaryTeePathSumIIObj = new BinaryTreePathSumII();
        this.btSerializer = new BinaryTreeSerialization();
    }


    @Test
    public void BinaryTreePathSumIITestOne() {
        TreeNode tree = btSerializer.deserialize("{1,2,3,4,#,2}");
        List<List<Integer>> actual = binaryTeePathSumIIObj.binaryTreePathSum2(tree, 6);
        List<Integer> one = Arrays.asList(2, 4);
        List<Integer> two = Arrays.asList(1, 3, 2);
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(one);
        expectedResult.add(two);
        assertEquals("Case one", expectedResult, actual);
    }

}
