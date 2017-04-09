import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by zhaobo on 4/9/17.
 */
public class CourseScheduleIITest {

    private CourseScheduleII obj;

    public CourseScheduleIITest() {
        this.obj = new CourseScheduleII();
    }

    @Test
    public void courseScheduleIITestCaseOne() {
        int n = 2;
        int[][] pre = {{1, 0}};
        int[] expected = {0, 1};
        int[] actual = obj.findOrder(n, pre);
        Assert.assertArrayEquals("case one", expected, actual);
    }
}
