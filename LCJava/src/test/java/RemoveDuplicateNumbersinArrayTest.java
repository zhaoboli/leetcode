import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by zhaobo on 4/30/17.
 */
public class RemoveDuplicateNumbersinArrayTest {
    RemoveDuplicateNumbersinArray obj;
    @Before
    public void setUp() throws Exception {
        this.obj = new RemoveDuplicateNumbersinArray();
    }

    @Test
    public void deduplication() throws Exception {
        int[] input = {1, 3, 1, 4, 4, 2};
        int expected = 4;
        assertEquals(4, obj.deduplication(input));
    }
    @Test
    public void deduplicationTwo() throws Exception {
        int[] input = {7,1,4,12,2,2,13,1,6,11,2,12,9,9,6,11,1,1,4,7,3,11};
        int expected = 10;
        assertEquals(10, obj.deduplication(input));
    }
    @Test
    public void deduplicationThree() throws Exception {
        String path ="/home/zhaobo/Downloads/14.in";
        int[] input = Util.toArray(path);
        int expected = 500;
        assertEquals(expected, obj.deduplication(input));
    }

    @Test
    public void deduplicationFour() throws Exception {
        String path ="/home/zhaobo/Downloads/14.in";
        int[] input = Util.toArray(path);
        int expected = 500;
        assertEquals(expected, obj.deduplicationHash(input));
    }
}