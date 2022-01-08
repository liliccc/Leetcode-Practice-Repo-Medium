package algorithms.level14DataStructuresReview;

public class LinkedListCycleII {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
     // using two pointers to find the cycle without extra space
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        // step 1: make fast meet slow
        fast = slow = head;
        while (fast != null && fast.next != null) {
            // slow move 1 step, fast move two steps each time
            slow = slow.next;
            fast = fast.next.next;
            // fast met slow
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // step 2: find the node where the cycle begins
        // make slow back to head, fast stays at meet point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

