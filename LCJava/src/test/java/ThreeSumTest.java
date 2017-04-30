import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/30/17.
 */
public class ThreeSumTest {
    private ThreeSum obj = new ThreeSum();

    @Test
    public void threeSum() throws Exception {

        int[] input = {-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> result = obj.threeSum(input);
        System.out.println("the end");
    }

    @Test
    public void threeSumOne() throws Exception {

        int[] input = {1,0,-1,-1,-1,-1,0,1,1,1};
        ArrayList<ArrayList<Integer>> result = obj.threeSum(input);
        System.out.println("the end");
    }

}