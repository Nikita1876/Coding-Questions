
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list
        ListNode secondhalf = slow.next;
        slow.next = null;

        // Step 3: Reverse the second half
        ListNode prev = null;
        ListNode temp = secondhalf;

        while (temp != null) {
            ListNode fwd = temp.next;
            temp.next = prev;
            prev = temp;
            temp = fwd;
        }

        // Step 4: Merge alternatively
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
