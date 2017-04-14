import ingrediant.ListNode;
import java.util.HashSet;

/**
 * Created by zhaobo on 4/14/17.
 */
public class LinkedListCycle {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return false;
        }

        HashSet<ListNode> hash = new HashSet<ListNode>();

        while (head != null) {
            if (!hash.contains(head)) {
                hash.add(head);
            } else {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycleTwoPointer(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                return true;
            }
        }

        return false;

    }
}
