import ingrediant.ListNode;
/**
 * Created by zhaobo on 4/14/17.
 */
public class ReverseLinkedListII {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curr = head;
        dummy.next = head;

        ListNode hook = dummy;
        ListNode tail = dummy;

        int i = 1;
        boolean startReversing = false;

        while (curr != null) {
            if (i == m) {
                hook = pre;
                tail = curr;
                startReversing = true;
            }
            if (startReversing) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
            if (i == n) {
                break;
            }
            i++;
        }

        tail.next = curr;
        hook.next = pre;

        return dummy.next;
    }
}
