import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindTheMissingNumberIITest {
    FindTheMissingNumberII obj;
    @Before
    public void setUp() throws Exception {
        obj = new FindTheMissingNumberII();
    }

    @Test
    public void findMissing2_tc1() throws Exception {

        int actul = obj.findMissing2(20, "19201234567891011121314151618");
        int expected = 17;
        assertEquals(expected, actul);
    }

    @Test
    public void findMissing2_tc2() throws Exception {
        int actual = obj.findMissing2(1,"");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void findMissing2_tc3() throws Exception {
        int actual = obj.findMissing2(2,"1");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void findMissing2_tc4() throws Exception {
        //can traverse to the end, but missing more than one number, for example: 7
        int actual = obj.findMissing2(30, "1110986543271213130292826252423222120191817161514");
        int expected = 27;
        assertEquals(expected, actual);
    }
}
