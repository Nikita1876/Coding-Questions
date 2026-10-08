class Solution {
    public ListNode removeNodes(ListNode head) {

        // 1. Reverse the linked list
        head = reverse(head);

        // 2. Find maximum and remove smaller nodes
        int max = head.val;
        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.next.val < max) {
                // delete curr.next
                curr.next = curr.next.next;
            } else {
                // curr.next is >= max
                curr = curr.next;
                max = curr.val;
            }
        }

        // 3. Reverse again
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}