import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by zhaobo on 4/2/17.
 */
public class BinaryTreeSerializationTest {

    private BinaryTreeSerialization btsObj = new BinaryTreeSerialization();
    @Test
    public void BinaryTreeSerializationTestOne() {
        TreeNode result = btsObj.deserialize("{1,2,3,#,#,4,5}");
        String output = btsObj.serialize(result);
        assertEquals("{1,2,3,#,#,4,5}", output);
    }

    @Test
    public void BinaryTreeSerializationTestTwo() {
        TreeNode input = btsObj.deserialize("{}");
        String output = btsObj.serialize(input);
        assertEquals("{}", output);
    }

}
