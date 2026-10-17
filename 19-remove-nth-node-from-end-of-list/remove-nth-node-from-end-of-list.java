class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        // Fast ko n steps aage le jao
        for (int i = 1; i <= n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        // Head delete karna ho
        if (fast == null) {
            return head.next;
        }

        // Slow ko deletion se ek node pehle rokna
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete the target node
        slow.next = slow.next.next;

        return head;
    }
}