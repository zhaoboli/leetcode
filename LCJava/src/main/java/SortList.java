import ingrediant.ListNode;
/**
 * Created by zhaobo on 4/29/17.
 * Sort a linked list in O(n log n) time
 * using constant space complexity.
 *
 * Given 1->3->2->null, sort it to 1->2->3->null.
 */
public class SortList {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMidlle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left, right);
    }

    private ListNode findMidlle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
                head = head.next;
            } else {
                head.next = right;
                right = right.next;
                head = head.next;
            }
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return dummy.next;
    }
}
