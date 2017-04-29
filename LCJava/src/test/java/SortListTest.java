import ingrediant.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 4/29/17.
 */
public class SortListTest {
    private SortList obj = new SortList();
    @Test
    public void sortList() throws Exception {
        ListNode tail = new ListNode(-1);
        //ListNode mid = new ListNode(3, tail);
        ListNode head = new ListNode(1, tail);
        ListNode expected = obj.sortList(head);
    }

}